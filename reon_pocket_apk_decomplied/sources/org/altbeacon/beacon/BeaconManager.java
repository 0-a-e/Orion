package org.altbeacon.beacon;

import android.app.Notification;
import android.bluetooth.BluetoothManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.logging.Loggers;
import org.altbeacon.beacon.powersave.BackgroundPowerSaverInternal;
import org.altbeacon.beacon.service.BeaconService;
import org.altbeacon.beacon.service.Callback;
import org.altbeacon.beacon.service.IntentScanStrategyCoordinator;
import org.altbeacon.beacon.service.MonitoringStatus;
import org.altbeacon.beacon.service.RangeState;
import org.altbeacon.beacon.service.RangedBeacon;
import org.altbeacon.beacon.service.RegionMonitoringState;
import org.altbeacon.beacon.service.RunningAverageRssiFilter;
import org.altbeacon.beacon.service.ScanJobScheduler;
import org.altbeacon.beacon.service.SettingsData;
import org.altbeacon.beacon.service.StartRMData;
import org.altbeacon.beacon.service.scanner.NonBeaconLeScanCallback;
import org.altbeacon.beacon.simulator.BeaconSimulator;
import org.altbeacon.beacon.utils.ProcessUtils;

public class BeaconManager {
    public static final long DEFAULT_BACKGROUND_BETWEEN_SCAN_PERIOD = 300000;
    public static final long DEFAULT_BACKGROUND_SCAN_PERIOD = 10000;
    public static final long DEFAULT_EXIT_PERIOD = 10000;
    public static final long DEFAULT_FOREGROUND_BETWEEN_SCAN_PERIOD = 0;
    public static final long DEFAULT_FOREGROUND_SCAN_PERIOD = 1100;
    private static final Object SINGLETON_LOCK = new Object();
    private static final String TAG = "BeaconManager";
    protected static BeaconSimulator beaconSimulator = null;
    protected static String distanceModelUpdateUrl = "https://s3.amazonaws.com/android-beacon-library/android-distance.json";
    protected static Class rssiFilterImplClass = RunningAverageRssiFilter.class;
    private static boolean sAndroidLScanningDisabled = false;
    private static long sExitRegionPeriod = 10000;
    protected static volatile BeaconManager sInstance = null;
    private static boolean sManifestCheckingDisabled = false;
    private BeaconConsumer autoBindConsumer;
    /* access modifiers changed from: private */
    public final Set<Region> autoBindMonitoredRegions = new HashSet();
    /* access modifiers changed from: private */
    public final Set<Region> autoBindRangedRegions = new HashSet();
    private long backgroundBetweenScanPeriod;
    private long backgroundScanPeriod;
    private final List<BeaconParser> beaconParsers;
    /* access modifiers changed from: private */
    public final ConcurrentMap<InternalBeaconConsumer, ConsumerInfo> consumers = new ConcurrentHashMap();
    protected RangeNotifier dataRequestNotifier = null;
    private long foregroundBetweenScanPeriod;
    private long foregroundScanPeriod;
    private boolean mBackgroundMode;
    private boolean mBackgroundModeUninitialized;
    /* access modifiers changed from: private */
    public final Context mContext;
    private Notification mForegroundServiceNotification;
    private int mForegroundServiceNotificationId;
    private IntentScanStrategyCoordinator mIntentScanStrategyCoordinator;
    BackgroundPowerSaverInternal mInternalBackgroundPowerSaver;
    private boolean mMainProcess;
    private NonBeaconLeScanCallback mNonBeaconLeScanCallback;
    private boolean mRegionStatePersistenceEnabled;
    private HashMap<Region, RegionViewModel> mRegionViewModels;
    /* access modifiers changed from: private */
    public Boolean mScannerInSameProcess;
    private boolean mScheduledScanJobsEnabled;
    protected final Set<MonitorNotifier> monitorNotifiers = new CopyOnWriteArraySet();
    protected final Set<RangeNotifier> rangeNotifiers = new CopyOnWriteArraySet();
    private final Set<Region> rangedRegions = new CopyOnWriteArraySet();
    /* access modifiers changed from: private */
    public Messenger serviceMessenger = null;

    public static void setDebug(boolean z) {
        if (z) {
            LogManager.setLogger(Loggers.verboseLogger());
            LogManager.setVerboseLoggingEnabled(true);
            return;
        }
        LogManager.setLogger(Loggers.empty());
        LogManager.setVerboseLoggingEnabled(false);
    }

    public RegionViewModel getRegionViewModel(Region region) {
        RegionViewModel regionViewModel = this.mRegionViewModels.get(region);
        if (regionViewModel != null) {
            return regionViewModel;
        }
        RegionViewModel regionViewModel2 = new RegionViewModel();
        this.mRegionViewModels.put(region, regionViewModel2);
        return regionViewModel2;
    }

    public boolean isRegionViewModelInitialized(Region region) {
        return this.mRegionViewModels.get(region) != null;
    }

    public void setForegroundScanPeriod(long j) {
        LogManager.d(TAG, "API setForegroundScanPeriod " + j, new Object[0]);
        this.foregroundScanPeriod = j;
    }

    public void setForegroundBetweenScanPeriod(long j) {
        LogManager.d(TAG, "API setForegroundBetweenScanPeriod " + j, new Object[0]);
        this.foregroundBetweenScanPeriod = j;
    }

    public void setBackgroundScanPeriod(long j) {
        LogManager.d(TAG, "API setBackgroundScanPeriod " + j, new Object[0]);
        this.backgroundScanPeriod = j;
    }

    public void setBackgroundBetweenScanPeriod(long j) {
        LogManager.d(TAG, "API setBackgroundBetweenScanPeriod " + j, new Object[0]);
        this.backgroundBetweenScanPeriod = j;
        if (Build.VERSION.SDK_INT >= 26 && this.backgroundBetweenScanPeriod < 900000) {
            LogManager.w(TAG, "Setting a short backgroundBetweenScanPeriod has no effect on Android 8+, which is limited to scanning every ~15 minutes", new Object[0]);
        }
    }

    public static void setRegionExitPeriod(long j) {
        LogManager.d(TAG, "API setRegionExitPeriod " + j, new Object[0]);
        sExitRegionPeriod = j;
        BeaconManager beaconManager = sInstance;
        if (beaconManager != null) {
            beaconManager.applySettings();
        }
    }

    public static long getRegionExitPeriod() {
        return sExitRegionPeriod;
    }

    public static BeaconManager getInstanceForApplication(Context context) {
        BeaconManager beaconManager = sInstance;
        if (beaconManager == null) {
            synchronized (SINGLETON_LOCK) {
                beaconManager = sInstance;
                if (beaconManager == null) {
                    beaconManager = new BeaconManager(context);
                    sInstance = beaconManager;
                    LogManager.d(TAG, "API BeaconManager constructed ", new Object[0]);
                }
            }
        }
        return beaconManager;
    }

    protected BeaconManager(Context context) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.beaconParsers = copyOnWriteArrayList;
        this.mRegionStatePersistenceEnabled = true;
        this.mBackgroundMode = false;
        this.mBackgroundModeUninitialized = true;
        this.mMainProcess = false;
        this.mScannerInSameProcess = null;
        this.mScheduledScanJobsEnabled = false;
        this.mIntentScanStrategyCoordinator = null;
        this.mForegroundServiceNotification = null;
        this.mForegroundServiceNotificationId = -1;
        this.foregroundScanPeriod = DEFAULT_FOREGROUND_SCAN_PERIOD;
        this.foregroundBetweenScanPeriod = 0;
        this.backgroundScanPeriod = 10000;
        this.backgroundBetweenScanPeriod = DEFAULT_BACKGROUND_BETWEEN_SCAN_PERIOD;
        this.mRegionViewModels = new HashMap<>();
        this.autoBindConsumer = null;
        this.mInternalBackgroundPowerSaver = null;
        this.mContext = context.getApplicationContext();
        checkIfMainProcess();
        if (!sManifestCheckingDisabled) {
            verifyServiceDeclaration();
        }
        copyOnWriteArrayList.add(new AltBeaconParser());
        setScheduledScanJobsEnabledDefault();
    }

    public boolean isMainProcess() {
        return this.mMainProcess;
    }

    public boolean isScannerInDifferentProcess() {
        Boolean bool = this.mScannerInSameProcess;
        return bool != null && !bool.booleanValue();
    }

    public void setScannerInSameProcess(boolean z) {
        LogManager.d(TAG, "API setScannerInSameProcess " + z, new Object[0]);
        this.mScannerInSameProcess = Boolean.valueOf(z);
    }

    /* access modifiers changed from: protected */
    public void checkIfMainProcess() {
        ProcessUtils processUtils = new ProcessUtils(this.mContext);
        String processName = processUtils.getProcessName();
        String packageName = processUtils.getPackageName();
        int pid = processUtils.getPid();
        this.mMainProcess = processUtils.isMainProcess();
        LogManager.i(TAG, "BeaconManager started up on pid " + pid + " named '" + processName + "' for application package '" + packageName + "'.  isMainProcess=" + this.mMainProcess, new Object[0]);
    }

    public List<BeaconParser> getBeaconParsers() {
        LogManager.d(TAG, "API getBeaconParsers, current count " + this.beaconParsers.size(), new Object[0]);
        return this.beaconParsers;
    }

    public boolean checkAvailability() throws BleNotAvailableException {
        if (isBleAvailableOrSimulated()) {
            return ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter().isEnabled();
        }
        throw new BleNotAvailableException("Bluetooth LE not supported by this device");
    }

    @Deprecated
    public void bind(BeaconConsumer beaconConsumer) {
        LogManager.d(TAG, "API bind", new Object[0]);
        bindInternal(beaconConsumer);
    }

    public void bindInternal(InternalBeaconConsumer internalBeaconConsumer) {
        if (!isBleAvailableOrSimulated()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
            return;
        }
        synchronized (this.consumers) {
            ConsumerInfo consumerInfo = new ConsumerInfo();
            if (this.consumers.putIfAbsent(internalBeaconConsumer, consumerInfo) != null) {
                LogManager.d(TAG, "This consumer is already bound", new Object[0]);
            } else {
                LogManager.d(TAG, "This consumer is not bound.  Binding now: %s", internalBeaconConsumer);
                IntentScanStrategyCoordinator intentScanStrategyCoordinator = this.mIntentScanStrategyCoordinator;
                if (intentScanStrategyCoordinator != null) {
                    intentScanStrategyCoordinator.start();
                    internalBeaconConsumer.onBeaconServiceConnect();
                } else if (this.mScheduledScanJobsEnabled) {
                    LogManager.d(TAG, "Not starting beacon scanning service. Using scheduled jobs", new Object[0]);
                    internalBeaconConsumer.onBeaconServiceConnect();
                } else {
                    LogManager.d(TAG, "Binding to service", new Object[0]);
                    Intent intent = new Intent(internalBeaconConsumer.getApplicationContext(), BeaconService.class);
                    if (Build.VERSION.SDK_INT >= 26 && getForegroundServiceNotification() != null) {
                        if (isAnyConsumerBound()) {
                            LogManager.i(TAG, "Not starting foreground beacon scanning service.  A consumer is already bound, so it should be started", new Object[0]);
                        } else {
                            LogManager.i(TAG, "Starting foreground beacon scanning service.", new Object[0]);
                            ComponentName unused = this.mContext.startForegroundService(intent);
                        }
                    }
                    internalBeaconConsumer.bindService(intent, consumerInfo.beaconServiceConnection, 1);
                }
                LogManager.d(TAG, "consumer count is now: %s", Integer.valueOf(this.consumers.size()));
            }
        }
    }

    public void handleStategyFailover() {
        IntentScanStrategyCoordinator intentScanStrategyCoordinator = this.mIntentScanStrategyCoordinator;
        if (intentScanStrategyCoordinator != null && intentScanStrategyCoordinator.getDisableOnFailure() && this.mIntentScanStrategyCoordinator.getLastStrategyFailureDetectionCount() > 0) {
            this.mIntentScanStrategyCoordinator = null;
            LogManager.d(TAG, "unbinding all consumers for failover from intent strategy", new Object[0]);
            ArrayList<InternalBeaconConsumer> arrayList = new ArrayList<>(this.consumers.keySet());
            for (InternalBeaconConsumer unbindInternal : arrayList) {
                unbindInternal(unbindInternal);
            }
            LogManager.d(TAG, "binding all consumers for failover from intent strategy", new Object[0]);
            for (InternalBeaconConsumer bindInternal : arrayList) {
                bindInternal(bindInternal);
            }
            LogManager.d(TAG, "Done with failover", new Object[0]);
        }
    }

    @Deprecated
    public void unbind(BeaconConsumer beaconConsumer) {
        LogManager.d(TAG, "API unbind", new Object[0]);
        unbindInternal(beaconConsumer);
    }

    public void unbindInternal(InternalBeaconConsumer internalBeaconConsumer) {
        if (!isBleAvailableOrSimulated()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
            return;
        }
        synchronized (this.consumers) {
            if (this.consumers.containsKey(internalBeaconConsumer)) {
                LogManager.d(TAG, "Unbinding", new Object[0]);
                if (this.mIntentScanStrategyCoordinator != null) {
                    LogManager.d(TAG, "Not unbinding as we are using intent scanning strategy", new Object[0]);
                } else if (this.mScheduledScanJobsEnabled) {
                    LogManager.d(TAG, "Not unbinding from scanning service as we are using scan jobs.", new Object[0]);
                } else {
                    internalBeaconConsumer.unbindService(((ConsumerInfo) this.consumers.get(internalBeaconConsumer)).beaconServiceConnection);
                }
                LogManager.d(TAG, "Before unbind, consumer count is " + this.consumers.size(), new Object[0]);
                this.consumers.remove(internalBeaconConsumer);
                LogManager.d(TAG, "After unbind, consumer count is " + this.consumers.size(), new Object[0]);
                if (this.consumers.size() == 0) {
                    this.serviceMessenger = null;
                    if (this.mScheduledScanJobsEnabled || this.mIntentScanStrategyCoordinator != null) {
                        LogManager.i(TAG, "Cancelling scheduled jobs after unbind of last consumer.", new Object[0]);
                        ScanJobScheduler.getInstance().cancelSchedule(this.mContext);
                    }
                }
            } else {
                LogManager.d(TAG, "This consumer is not bound to: %s", internalBeaconConsumer);
                LogManager.d(TAG, "Bound consumers: ", new Object[0]);
                for (Map.Entry value : this.consumers.entrySet()) {
                    LogManager.d(TAG, String.valueOf(value.getValue()), new Object[0]);
                }
            }
        }
    }

    @Deprecated
    public boolean isBound(BeaconConsumer beaconConsumer) {
        boolean z;
        synchronized (this.consumers) {
            if (beaconConsumer != null) {
                try {
                    if (this.consumers.get(beaconConsumer) != null && (this.mScheduledScanJobsEnabled || this.serviceMessenger != null)) {
                        z = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            z = false;
        }
        return z;
    }

    public boolean isAnyConsumerBound() {
        boolean z;
        synchronized (this.consumers) {
            z = !this.consumers.isEmpty() && !(this.mIntentScanStrategyCoordinator == null && !this.mScheduledScanJobsEnabled && this.serviceMessenger == null);
        }
        return z;
    }

    @Deprecated
    public void setBackgroundMode(boolean z) {
        LogManager.d(TAG, "API setBackgroundMode " + z, new Object[0]);
        setBackgroundModeInternal(z);
    }

    public void setBackgroundModeInternal(boolean z) {
        LogManager.d(TAG, "API setBackgroundModeIternal " + z, new Object[0]);
        if (!isBleAvailableOrSimulated()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
            return;
        }
        this.mBackgroundModeUninitialized = false;
        if (z != this.mBackgroundMode) {
            if (!z && getIntentScanStrategyCoordinator() != null) {
                getIntentScanStrategyCoordinator().performPeriodicProcessing(this.mContext);
            }
            this.mBackgroundMode = z;
            try {
                updateScanPeriods();
            } catch (RemoteException unused) {
                LogManager.e(TAG, "Cannot contact service to set scan periods", new Object[0]);
            }
        }
    }

    public void setEnableScheduledScanJobs(boolean z) {
        LogManager.d(TAG, "API setEnableScheduledScanJobs " + z, new Object[0]);
        if (!isAnyConsumerBound()) {
            if (!z && Build.VERSION.SDK_INT >= 26) {
                LogManager.w(TAG, "Disabling ScanJobs on Android 8+ may disable delivery of beacon callbacks in the background unless a foreground service is active.", new Object[0]);
            }
            if (!z) {
                ScanJobScheduler.getInstance().cancelSchedule(this.mContext);
            }
            this.mScheduledScanJobsEnabled = z;
            return;
        }
        LogManager.e(TAG, "ScanJob may not be configured because a consumer is already bound.", new Object[0]);
        throw new IllegalStateException("Method must be called before starting ranging or monitoring");
    }

    public void setIntentScanningStrategyEnabled(boolean z) {
        LogManager.d(TAG, "API setIntentScanningStrategyEnabled " + z, new Object[0]);
        if (isAnyConsumerBound()) {
            LogManager.e(TAG, "IntentScanningStrategy may not be configured because a consumer is already bound.", new Object[0]);
            throw new IllegalStateException("Method must be called before starting ranging or monitoring");
        } else if (z && Build.VERSION.SDK_INT < 26) {
            LogManager.e(TAG, "IntentScanningStrategy may not be configured because Intent Scanning is not availble prior to Android 8.0", new Object[0]);
        } else if (!z || Build.VERSION.SDK_INT < 26) {
            this.mIntentScanStrategyCoordinator = null;
        } else {
            ScanJobScheduler.getInstance().cancelSchedule(this.mContext);
            this.mIntentScanStrategyCoordinator = new IntentScanStrategyCoordinator(this.mContext);
        }
    }

    public IntentScanStrategyCoordinator getIntentScanStrategyCoordinator() {
        return this.mIntentScanStrategyCoordinator;
    }

    public boolean getScheduledScanJobsEnabled() {
        return this.mScheduledScanJobsEnabled;
    }

    public boolean getBackgroundMode() {
        return this.mBackgroundMode;
    }

    public long getBackgroundScanPeriod() {
        return this.backgroundScanPeriod;
    }

    public long getBackgroundBetweenScanPeriod() {
        return this.backgroundBetweenScanPeriod;
    }

    public long getForegroundScanPeriod() {
        return this.foregroundScanPeriod;
    }

    public long getForegroundBetweenScanPeriod() {
        return this.foregroundBetweenScanPeriod;
    }

    public boolean isBackgroundModeUninitialized() {
        return this.mBackgroundModeUninitialized;
    }

    @Deprecated
    public void setRangeNotifier(RangeNotifier rangeNotifier) {
        LogManager.d(TAG, "API setRangeNotifier " + rangeNotifier, new Object[0]);
        this.rangeNotifiers.clear();
        if (rangeNotifier != null) {
            addRangeNotifier(rangeNotifier);
        }
    }

    public void addRangeNotifier(RangeNotifier rangeNotifier) {
        LogManager.d(TAG, "API addRangeNotifier " + rangeNotifier, new Object[0]);
        if (rangeNotifier != null) {
            this.rangeNotifiers.add(rangeNotifier);
        }
    }

    public boolean removeRangeNotifier(RangeNotifier rangeNotifier) {
        LogManager.d(TAG, "API removeRangeNotifier " + rangeNotifier, new Object[0]);
        return this.rangeNotifiers.remove(rangeNotifier);
    }

    public void removeAllRangeNotifiers() {
        LogManager.d(TAG, "API removeAllRangeNotifiers", new Object[0]);
        this.rangeNotifiers.clear();
    }

    @Deprecated
    public void setMonitorNotifier(MonitorNotifier monitorNotifier) {
        LogManager.d(TAG, "API setMonitorNotifier " + monitorNotifier, new Object[0]);
        if (!determineIfCalledFromSeparateScannerProcess()) {
            this.monitorNotifiers.clear();
            if (monitorNotifier != null) {
                addMonitorNotifier(monitorNotifier);
            }
        }
    }

    public void addMonitorNotifier(MonitorNotifier monitorNotifier) {
        LogManager.d(TAG, "API addMonitorNotifier " + monitorNotifier, new Object[0]);
        if (!determineIfCalledFromSeparateScannerProcess() && monitorNotifier != null) {
            this.monitorNotifiers.add(monitorNotifier);
        }
    }

    @Deprecated
    public boolean removeMonitoreNotifier(MonitorNotifier monitorNotifier) {
        return removeMonitorNotifier(monitorNotifier);
    }

    public boolean removeMonitorNotifier(MonitorNotifier monitorNotifier) {
        LogManager.d(TAG, "API removeMonitorNotifier " + monitorNotifier, new Object[0]);
        if (determineIfCalledFromSeparateScannerProcess()) {
            return false;
        }
        return this.monitorNotifiers.remove(monitorNotifier);
    }

    public void removeAllMonitorNotifiers() {
        LogManager.d(TAG, "API removeAllMonitorNotifiers", new Object[0]);
        if (!determineIfCalledFromSeparateScannerProcess()) {
            this.monitorNotifiers.clear();
        }
    }

    @Deprecated
    public void setRegionStatePeristenceEnabled(boolean z) {
        setRegionStatePersistenceEnabled(z);
    }

    public void setRegionStatePersistenceEnabled(boolean z) {
        LogManager.d(TAG, "API setRegionStatePerisistenceEnabled " + z, new Object[0]);
        this.mRegionStatePersistenceEnabled = z;
        if (!isScannerInDifferentProcess()) {
            if (z) {
                MonitoringStatus.getInstanceForApplication(this.mContext).startStatusPreservation();
            } else {
                MonitoringStatus.getInstanceForApplication(this.mContext).stopStatusPreservation();
            }
        }
        applySettings();
    }

    public boolean isRegionStatePersistenceEnabled() {
        return this.mRegionStatePersistenceEnabled;
    }

    public void requestStateForRegion(Region region) {
        if (!determineIfCalledFromSeparateScannerProcess()) {
            RegionMonitoringState stateOf = MonitoringStatus.getInstanceForApplication(this.mContext).stateOf(region);
            int i = (stateOf == null || !stateOf.getInside()) ? 0 : 1;
            for (MonitorNotifier didDetermineStateForRegion : this.monitorNotifiers) {
                didDetermineStateForRegion.didDetermineStateForRegion(i, region);
            }
        }
    }

    @Deprecated
    public void startRangingBeaconsInRegion(Region region) throws RemoteException {
        LogManager.d(TAG, "API startRangingBeaconsInRegion " + region, new Object[0]);
        LogManager.d(TAG, "startRangingBeaconsInRegion", new Object[0]);
        if (!isBleAvailableOrSimulated()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (!determineIfCalledFromSeparateScannerProcess()) {
            this.rangedRegions.remove(region);
            this.rangedRegions.add(region);
            applyChangesToServices(2, region);
        }
    }

    public void startRangingBeacons(Region region) {
        LogManager.d(TAG, "API startRangingBeacons " + region, new Object[0]);
        LogManager.d(TAG, "startRanging", new Object[0]);
        ensureBackgroundPowerSaver();
        if (isAnyConsumerBound()) {
            try {
                startRangingBeaconsInRegion(region);
            } catch (RemoteException e) {
                LogManager.e(TAG, "Failed to start ranging", e);
            }
        } else {
            synchronized (this.autoBindRangedRegions) {
                this.autoBindRangedRegions.remove(region);
                this.autoBindRangedRegions.add(region);
            }
            autoBind();
        }
    }

    @Deprecated
    public void stopRangingBeaconsInRegion(Region region) throws RemoteException {
        LogManager.d(TAG, "API stopRangingBeacons " + region, new Object[0]);
        LogManager.d(TAG, "stopRangingBeaconsInRegion", new Object[0]);
        if (!isBleAvailableOrSimulated()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (!determineIfCalledFromSeparateScannerProcess()) {
            this.rangedRegions.remove(region);
            applyChangesToServices(3, region);
        }
    }

    public void stopRangingBeacons(Region region) {
        LogManager.d(TAG, "API stopRangingBeacons " + region, new Object[0]);
        LogManager.d(TAG, "stopRangingBeacons", new Object[0]);
        ensureBackgroundPowerSaver();
        if (isAnyConsumerBound()) {
            try {
                stopRangingBeaconsInRegion(region);
            } catch (RemoteException e) {
                LogManager.e(TAG, "Cannot stop ranging", e);
            }
        } else {
            synchronized (this.autoBindMonitoredRegions) {
                this.autoBindRangedRegions.remove(region);
            }
        }
        autoUnbindIfNeeded();
    }

    public void applySettings() {
        LogManager.d(TAG, "API applySettings", new Object[0]);
        if (!determineIfCalledFromSeparateScannerProcess()) {
            if (!isAnyConsumerBound()) {
                LogManager.d(TAG, "Not synchronizing settings to service, as it has not started up yet", new Object[0]);
            } else if (isScannerInDifferentProcess()) {
                LogManager.d(TAG, "Synchronizing settings to service", new Object[0]);
                syncSettingsToService();
            } else {
                LogManager.d(TAG, "Not synchronizing settings to service, as it is in the same process", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void syncSettingsToService() {
        IntentScanStrategyCoordinator intentScanStrategyCoordinator = this.mIntentScanStrategyCoordinator;
        if (intentScanStrategyCoordinator != null) {
            intentScanStrategyCoordinator.applySettings();
        } else if (this.mScheduledScanJobsEnabled) {
            ScanJobScheduler.getInstance().applySettingsToScheduledJob(this.mContext, this);
        } else {
            try {
                applyChangesToServices(7, (Region) null);
            } catch (RemoteException e) {
                LogManager.e(TAG, "Failed to sync settings to service", e);
            }
        }
    }

    @Deprecated
    public void startMonitoringBeaconsInRegion(Region region) throws RemoteException {
        LogManager.d(TAG, "API startMonitoringBeaconsInRegion " + region, new Object[0]);
        if (!isBleAvailableOrSimulated()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (!determineIfCalledFromSeparateScannerProcess()) {
            if (!isScannerInDifferentProcess()) {
                MonitoringStatus.getInstanceForApplication(this.mContext).addRegion(region, new Callback(callbackPackageName()));
            }
            applyChangesToServices(4, region);
            if (isScannerInDifferentProcess()) {
                MonitoringStatus.getInstanceForApplication(this.mContext).addLocalRegion(region);
            }
            requestStateForRegion(region);
        }
    }

    public void startMonitoring(Region region) {
        LogManager.d(TAG, "API startMonitoring " + region, new Object[0]);
        ensureBackgroundPowerSaver();
        if (isAnyConsumerBound()) {
            try {
                startMonitoringBeaconsInRegion(region);
            } catch (RemoteException e) {
                LogManager.e(TAG, "Failed to start monitoring", e);
            }
        } else {
            synchronized (this.autoBindMonitoredRegions) {
                this.autoBindMonitoredRegions.remove(region);
                this.autoBindMonitoredRegions.add(region);
            }
            autoBind();
        }
    }

    @Deprecated
    public void stopMonitoringBeaconsInRegion(Region region) throws RemoteException {
        LogManager.d(TAG, "API stopMonitoringBeaconsInRegion " + region, new Object[0]);
        if (!isBleAvailableOrSimulated()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (!determineIfCalledFromSeparateScannerProcess()) {
            if (!isScannerInDifferentProcess()) {
                MonitoringStatus.getInstanceForApplication(this.mContext).removeRegion(region);
            }
            applyChangesToServices(5, region);
            if (isScannerInDifferentProcess()) {
                MonitoringStatus.getInstanceForApplication(this.mContext).removeLocalRegion(region);
            }
            autoUnbindIfNeeded();
        }
    }

    private void autoUnbindIfNeeded() {
        BeaconConsumer beaconConsumer;
        if (getMonitoredRegions().size() == 0 && getRangedRegions().size() == 0 && (beaconConsumer = this.autoBindConsumer) != null) {
            unbindInternal(beaconConsumer);
            this.autoBindConsumer = null;
            this.autoBindRangedRegions.clear();
            this.autoBindMonitoredRegions.clear();
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stopMonitoring(org.altbeacon.beacon.Region r5) {
        /*
            r4 = this;
            java.lang.String r0 = "BeaconManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "API stopMonitoring "
            r1.<init>(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            org.altbeacon.beacon.logging.LogManager.d(r0, r1, r3)
            r4.ensureBackgroundPowerSaver()
            boolean r0 = r4.isAnyConsumerBound()
            if (r0 == 0) goto L_0x0031
            r4.stopMonitoringBeaconsInRegion(r5)     // Catch:{ RemoteException -> 0x0023 }
            goto L_0x0043
        L_0x0023:
            r5 = move-exception
            java.lang.String r0 = "BeaconManager"
            java.lang.String r1 = "Failed to stop monitoring"
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r5
            org.altbeacon.beacon.logging.LogManager.e(r0, r1, r3)
            goto L_0x0043
        L_0x0031:
            java.util.Set<org.altbeacon.beacon.Region> r0 = r4.autoBindMonitoredRegions
            monitor-enter(r0)
            java.util.Set<org.altbeacon.beacon.Region> r1 = r4.autoBindMonitoredRegions     // Catch:{ all -> 0x0044 }
            r1.remove(r5)     // Catch:{ all -> 0x0044 }
            android.content.Context r1 = r4.mContext     // Catch:{ all -> 0x0044 }
            org.altbeacon.beacon.service.MonitoringStatus r1 = org.altbeacon.beacon.service.MonitoringStatus.getInstanceForApplication(r1)     // Catch:{ all -> 0x0044 }
            r1.removeRegion(r5)     // Catch:{ all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
        L_0x0043:
            return
        L_0x0044:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.altbeacon.beacon.BeaconManager.stopMonitoring(org.altbeacon.beacon.Region):void");
    }

    public void updateScanPeriods() throws RemoteException {
        LogManager.d(TAG, "API updateScanPeriods", new Object[0]);
        if (!isBleAvailableOrSimulated()) {
            LogManager.w(TAG, "Method invocation will be ignored.", new Object[0]);
        } else if (!determineIfCalledFromSeparateScannerProcess()) {
            LogManager.d(TAG, "updating background flag to %s", Boolean.valueOf(this.mBackgroundMode));
            LogManager.d(TAG, "updating scan periods to %s, %s", Long.valueOf(getScanPeriod()), Long.valueOf(getBetweenScanPeriod()));
            if (isAnyConsumerBound()) {
                applyChangesToServices(6, (Region) null);
            }
        }
    }

    private void applyChangesToServices(int i, Region region) throws RemoteException {
        if (!isAnyConsumerBound()) {
            LogManager.w(TAG, "The BeaconManager is not bound to the service.  Call beaconManager.bind(BeaconConsumer consumer) and wait for a callback to onBeaconServiceConnect()", new Object[0]);
            return;
        }
        IntentScanStrategyCoordinator intentScanStrategyCoordinator = this.mIntentScanStrategyCoordinator;
        if (intentScanStrategyCoordinator != null) {
            intentScanStrategyCoordinator.applySettings();
        } else if (this.mScheduledScanJobsEnabled) {
            ScanJobScheduler.getInstance().applySettingsToScheduledJob(this.mContext, this);
        } else {
            Message obtain = Message.obtain((Handler) null, i, 0, 0);
            if (i == 6) {
                obtain.setData(new StartRMData(getScanPeriod(), getBetweenScanPeriod(), this.mBackgroundMode).toBundle());
            } else if (i == 7) {
                obtain.setData(new SettingsData().collect(this.mContext).toBundle());
            } else {
                obtain.setData(new StartRMData(region, callbackPackageName(), getScanPeriod(), getBetweenScanPeriod(), this.mBackgroundMode).toBundle());
            }
            this.serviceMessenger.send(obtain);
        }
    }

    private String callbackPackageName() {
        String packageName = this.mContext.getPackageName();
        LogManager.d(TAG, "callback packageName: %s", packageName);
        return packageName;
    }

    @Deprecated
    public MonitorNotifier getMonitoringNotifier() {
        Iterator<MonitorNotifier> it = this.monitorNotifiers.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public Set<MonitorNotifier> getMonitoringNotifiers() {
        return Collections.unmodifiableSet(this.monitorNotifiers);
    }

    @Deprecated
    public RangeNotifier getRangingNotifier() {
        Iterator<RangeNotifier> it = this.rangeNotifiers.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public Set<RangeNotifier> getRangingNotifiers() {
        return Collections.unmodifiableSet(this.rangeNotifiers);
    }

    public Collection<Region> getMonitoredRegions() {
        return MonitoringStatus.getInstanceForApplication(this.mContext).regions();
    }

    public Collection<Region> getRangedRegions() {
        return Collections.unmodifiableSet(this.rangedRegions);
    }

    @Deprecated
    public static void logDebug(String str, String str2) {
        LogManager.d(str, str2, new Object[0]);
    }

    @Deprecated
    public static void logDebug(String str, String str2, Throwable th) {
        LogManager.d(th, str, str2, new Object[0]);
    }

    public static String getDistanceModelUpdateUrl() {
        return distanceModelUpdateUrl;
    }

    public static void setDistanceModelUpdateUrl(String str) {
        warnIfScannerNotInSameProcess();
        distanceModelUpdateUrl = str;
    }

    public static void setRssiFilterImplClass(Class cls) {
        warnIfScannerNotInSameProcess();
        rssiFilterImplClass = cls;
    }

    public static Class getRssiFilterImplClass() {
        return rssiFilterImplClass;
    }

    public static void setUseTrackingCache(boolean z) {
        RangeState.setUseTrackingCache(z);
        if (sInstance != null) {
            sInstance.applySettings();
        }
    }

    public void setMaxTrackingAge(int i) {
        LogManager.d(TAG, "API setMaxTrackingAge " + i, new Object[0]);
        RangedBeacon.setMaxTrackinAge(i);
    }

    public static void setBeaconSimulator(BeaconSimulator beaconSimulator2) {
        LogManager.d(TAG, "API setBeaconSimulator " + beaconSimulator2, new Object[0]);
        warnIfScannerNotInSameProcess();
        beaconSimulator = beaconSimulator2;
    }

    public static BeaconSimulator getBeaconSimulator() {
        return beaconSimulator;
    }

    /* access modifiers changed from: protected */
    public void setDataRequestNotifier(RangeNotifier rangeNotifier) {
        LogManager.d(TAG, "API setDataRequestNotifier " + rangeNotifier, new Object[0]);
        this.dataRequestNotifier = rangeNotifier;
    }

    /* access modifiers changed from: protected */
    public RangeNotifier getDataRequestNotifier() {
        return this.dataRequestNotifier;
    }

    public NonBeaconLeScanCallback getNonBeaconLeScanCallback() {
        return this.mNonBeaconLeScanCallback;
    }

    public void setNonBeaconLeScanCallback(NonBeaconLeScanCallback nonBeaconLeScanCallback) {
        LogManager.d(TAG, "API setNonBeaconLeScanCallback " + nonBeaconLeScanCallback, new Object[0]);
        this.mNonBeaconLeScanCallback = nonBeaconLeScanCallback;
    }

    /* access modifiers changed from: private */
    public boolean isBleAvailableOrSimulated() {
        if (getBeaconSimulator() != null) {
            return true;
        }
        return isBleAvailable();
    }

    private boolean isBleAvailable() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return true;
        }
        LogManager.w(TAG, "This device does not support bluetooth LE.", new Object[0]);
        return false;
    }

    private long getScanPeriod() {
        if (this.mBackgroundMode) {
            return this.backgroundScanPeriod;
        }
        return this.foregroundScanPeriod;
    }

    private long getBetweenScanPeriod() {
        if (this.mBackgroundMode) {
            return this.backgroundBetweenScanPeriod;
        }
        return this.foregroundBetweenScanPeriod;
    }

    private void verifyServiceDeclaration() {
        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent(this.mContext, BeaconService.class), 65536);
        if (queryIntentServices != null && queryIntentServices.isEmpty()) {
            throw new ServiceNotDeclaredException();
        }
    }

    private class ConsumerInfo {
        public BeaconServiceConnection beaconServiceConnection;
        public boolean isConnected = false;

        public ConsumerInfo() {
            this.beaconServiceConnection = new BeaconServiceConnection();
        }
    }

    private class BeaconServiceConnection implements ServiceConnection {
        private BeaconServiceConnection() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogManager.d(BeaconManager.TAG, "we have a connection to the service now", new Object[0]);
            if (BeaconManager.this.mScannerInSameProcess == null) {
                Boolean unused = BeaconManager.this.mScannerInSameProcess = false;
            }
            Messenger unused2 = BeaconManager.this.serviceMessenger = new Messenger(iBinder);
            BeaconManager.this.applySettings();
            synchronized (BeaconManager.this.consumers) {
                for (Map.Entry entry : BeaconManager.this.consumers.entrySet()) {
                    if (!((ConsumerInfo) entry.getValue()).isConnected) {
                        ((InternalBeaconConsumer) entry.getKey()).onBeaconServiceConnect();
                        ((ConsumerInfo) entry.getValue()).isConnected = true;
                    }
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            LogManager.e(BeaconManager.TAG, "onServiceDisconnected", new Object[0]);
            Messenger unused = BeaconManager.this.serviceMessenger = null;
        }
    }

    public class ServiceNotDeclaredException extends RuntimeException {
        public ServiceNotDeclaredException() {
            super("The BeaconService is not properly declared in AndroidManifest.xml.  If using Eclipse, please verify that your project.properties has manifestmerger.enabled=true");
        }
    }

    public static boolean isAndroidLScanningDisabled() {
        return sAndroidLScanningDisabled;
    }

    public static void setAndroidLScanningDisabled(boolean z) {
        LogManager.d(TAG, "API setAndroidLScanningDisabled " + z, new Object[0]);
        sAndroidLScanningDisabled = z;
        BeaconManager beaconManager = sInstance;
        if (beaconManager != null) {
            beaconManager.applySettings();
        }
    }

    @Deprecated
    public static void setsManifestCheckingDisabled(boolean z) {
        sManifestCheckingDisabled = z;
    }

    public static void setManifestCheckingDisabled(boolean z) {
        LogManager.d(TAG, "API setManifestCheckingDisabled " + z, new Object[0]);
        sManifestCheckingDisabled = z;
    }

    public static boolean getManifestCheckingDisabled() {
        return sManifestCheckingDisabled;
    }

    public void enableForegroundServiceScanning(Notification notification, int i) throws IllegalStateException {
        LogManager.d(TAG, "API enableForegroundServiceScanning " + notification, new Object[0]);
        if (isAnyConsumerBound()) {
            throw new IllegalStateException("May not be called after consumers are already bound.");
        } else if (notification != null) {
            setEnableScheduledScanJobs(false);
            this.mForegroundServiceNotification = notification;
            this.mForegroundServiceNotificationId = i;
        } else {
            throw new NullPointerException("Notification cannot be null");
        }
    }

    public void disableForegroundServiceScanning() throws IllegalStateException {
        LogManager.d(TAG, "API disableForegroundServiceScanning", new Object[0]);
        if (!isAnyConsumerBound()) {
            this.mForegroundServiceNotification = null;
            setScheduledScanJobsEnabledDefault();
            return;
        }
        throw new IllegalStateException("May not be called after consumers are already bound");
    }

    public Notification getForegroundServiceNotification() {
        return this.mForegroundServiceNotification;
    }

    public int getForegroundServiceNotificationId() {
        return this.mForegroundServiceNotificationId;
    }

    private boolean determineIfCalledFromSeparateScannerProcess() {
        if (!isScannerInDifferentProcess() || isMainProcess()) {
            return false;
        }
        LogManager.w(TAG, "Ranging/Monitoring may not be controlled from a separate BeaconScanner process.  To remove this warning, please wrap this call in: if (beaconManager.isMainProcess())", new Object[0]);
        return true;
    }

    private static void warnIfScannerNotInSameProcess() {
        BeaconManager beaconManager = sInstance;
        if (beaconManager != null && beaconManager.isScannerInDifferentProcess()) {
            LogManager.w(TAG, "Unsupported configuration change made for BeaconScanner in separate process", new Object[0]);
        }
    }

    private void setScheduledScanJobsEnabledDefault() {
        this.mScheduledScanJobsEnabled = Build.VERSION.SDK_INT >= 26;
    }

    public boolean isAutoBindActive() {
        return this.autoBindConsumer != null;
    }

    public boolean shutdownIfIdle() {
        BeaconConsumer beaconConsumer;
        if (this.autoBindConsumer == null || this.rangedRegions.size() != 0 || getMonitoredRegions().size() != 0 || (beaconConsumer = this.autoBindConsumer) == null) {
            return false;
        }
        unbindInternal(beaconConsumer);
        this.autoBindConsumer = null;
        return true;
    }

    private void ensureBackgroundPowerSaver() {
        if (this.mInternalBackgroundPowerSaver == null) {
            BackgroundPowerSaverInternal backgroundPowerSaverInternal = new BackgroundPowerSaverInternal(this.mContext);
            this.mInternalBackgroundPowerSaver = backgroundPowerSaverInternal;
            backgroundPowerSaverInternal.enableDefaultBackgroundStateInference();
        }
    }

    private synchronized void autoBind() {
        if (this.autoBindConsumer == null) {
            this.autoBindConsumer = new BeaconConsumer() {
                public void onBeaconServiceConnect() {
                    if (!BeaconManager.this.isBleAvailableOrSimulated()) {
                        LogManager.w(BeaconManager.TAG, "Method invocation will be ignored -- no BLE.", new Object[0]);
                        return;
                    }
                    synchronized (BeaconManager.this.autoBindRangedRegions) {
                        for (Region startRangingBeaconsInRegion : BeaconManager.this.autoBindRangedRegions) {
                            try {
                                BeaconManager.this.startRangingBeaconsInRegion(startRangingBeaconsInRegion);
                            } catch (RemoteException e) {
                                LogManager.e(BeaconManager.TAG, "Failed to start ranging", e);
                            }
                        }
                        BeaconManager.this.autoBindRangedRegions.clear();
                    }
                    synchronized (BeaconManager.this.autoBindMonitoredRegions) {
                        for (Region startMonitoringBeaconsInRegion : BeaconManager.this.autoBindMonitoredRegions) {
                            try {
                                BeaconManager.this.startMonitoringBeaconsInRegion(startMonitoringBeaconsInRegion);
                            } catch (RemoteException e2) {
                                LogManager.e(BeaconManager.TAG, "Failed to start monitoring", e2);
                            }
                        }
                        BeaconManager.this.autoBindMonitoredRegions.clear();
                    }
                }

                public Context getApplicationContext() {
                    return BeaconManager.this.mContext;
                }

                public void unbindService(ServiceConnection serviceConnection) {
                    BeaconManager.this.mContext.unbindService(serviceConnection);
                }

                public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
                    return BeaconManager.this.mContext.bindService(intent, serviceConnection, i);
                }
            };
        }
        bindInternal(this.autoBindConsumer);
    }
}
