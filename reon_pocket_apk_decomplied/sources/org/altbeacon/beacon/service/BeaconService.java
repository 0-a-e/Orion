package org.altbeacon.beacon.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import androidx.core.app.NotificationCompat;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconLocalBroadcastProcessor;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BuildConfig;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.scanner.CycledLeScanCallback;
import org.altbeacon.beacon.startup.StartupBroadcastReceiver;
import org.altbeacon.beacon.utils.ProcessUtils;
import org.altbeacon.bluetooth.BluetoothCrashResolver;

public class BeaconService extends Service {
    public static final int MSG_SET_SCAN_PERIODS = 6;
    public static final int MSG_START_MONITORING = 4;
    public static final int MSG_START_RANGING = 2;
    public static final int MSG_STOP_MONITORING = 5;
    public static final int MSG_STOP_RANGING = 3;
    public static final int MSG_SYNC_SETTINGS = 7;
    public static final String TAG = "BeaconService";
    private BluetoothCrashResolver bluetoothCrashResolver;
    private final Handler handler = new Handler();
    private BeaconLocalBroadcastProcessor mBeaconNotificationProcessor;
    final Messenger mMessenger = new Messenger(new IncomingHandler(this));
    private ScanHelper mScanHelper;

    public class BeaconBinder extends Binder {
        public BeaconBinder() {
        }

        public BeaconService getService() {
            LogManager.i(BeaconService.TAG, "getService of BeaconBinder called", new Object[0]);
            return BeaconService.this;
        }
    }

    static class IncomingHandler extends Handler {
        private final WeakReference<BeaconService> mService;

        IncomingHandler(BeaconService beaconService) {
            super(Looper.getMainLooper());
            this.mService = new WeakReference<>(beaconService);
        }

        public void handleMessage(Message message) {
            BeaconService beaconService = (BeaconService) this.mService.get();
            if (beaconService != null) {
                StartRMData fromBundle = StartRMData.fromBundle(message.getData());
                if (fromBundle != null) {
                    int i = message.what;
                    if (i == 2) {
                        LogManager.i(BeaconService.TAG, "start ranging received", new Object[0]);
                        beaconService.startRangingBeaconsInRegion(fromBundle.getRegionData(), new Callback(fromBundle.getCallbackPackageName()));
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else if (i == 3) {
                        LogManager.i(BeaconService.TAG, "stop ranging received", new Object[0]);
                        beaconService.stopRangingBeaconsInRegion(fromBundle.getRegionData());
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else if (i == 4) {
                        LogManager.i(BeaconService.TAG, "start monitoring received", new Object[0]);
                        beaconService.startMonitoringBeaconsInRegion(fromBundle.getRegionData(), new Callback(fromBundle.getCallbackPackageName()));
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else if (i == 5) {
                        LogManager.i(BeaconService.TAG, "stop monitoring received", new Object[0]);
                        beaconService.stopMonitoringBeaconsInRegion(fromBundle.getRegionData());
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    } else if (i != 6) {
                        super.handleMessage(message);
                    } else {
                        LogManager.i(BeaconService.TAG, "set scan intervals received", new Object[0]);
                        beaconService.setScanPeriods(fromBundle.getScanPeriod(), fromBundle.getBetweenScanPeriod(), fromBundle.getBackgroundFlag());
                    }
                } else if (message.what == 7) {
                    LogManager.i(BeaconService.TAG, "Received settings update from other process", new Object[0]);
                    SettingsData fromBundle2 = SettingsData.fromBundle(message.getData());
                    if (fromBundle2 != null) {
                        fromBundle2.apply(beaconService);
                    } else {
                        LogManager.w(BeaconService.TAG, "Settings data missing", new Object[0]);
                    }
                } else {
                    LogManager.i(BeaconService.TAG, "Received unknown message from other process : " + message.what, new Object[0]);
                }
            }
        }
    }

    public void onCreate() {
        startForegroundIfConfigured();
        ScanHelper scanHelper = new ScanHelper(this);
        this.mScanHelper = scanHelper;
        if (scanHelper.getCycledScanner() == null) {
            this.mScanHelper.createCycledLeScanner(false, this.bluetoothCrashResolver);
        }
        this.mScanHelper.setMonitoringStatus(MonitoringStatus.getInstanceForApplication(this));
        this.mScanHelper.setRangedRegionState(new HashMap());
        this.mScanHelper.setBeaconParsers(new HashSet());
        this.mScanHelper.setExtraDataBeaconTracker(new ExtraDataBeaconTracker());
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(getApplicationContext());
        instanceForApplication.setScannerInSameProcess(true);
        if (instanceForApplication.isMainProcess()) {
            LogManager.i(TAG, "beaconService version %s is starting up on the main process", BuildConfig.VERSION_NAME);
            ensureNotificationProcessorSetup();
        } else {
            LogManager.i(TAG, "beaconService version %s is starting up on a separate process", BuildConfig.VERSION_NAME);
            ProcessUtils processUtils = new ProcessUtils(this);
            LogManager.i(TAG, "beaconService PID is " + processUtils.getPid() + " with process name " + processUtils.getProcessName(), new Object[0]);
        }
        String manifestMetadataValue = getManifestMetadataValue("longScanForcingEnabled");
        if (manifestMetadataValue != null && manifestMetadataValue.equals("true")) {
            LogManager.i(TAG, "longScanForcingEnabled to keep scans going on Android N for > 30 minutes", new Object[0]);
            if (this.mScanHelper.getCycledScanner() != null) {
                this.mScanHelper.getCycledScanner().setLongScanForcingEnabled(true);
            }
        }
        this.mScanHelper.reloadParsers();
        Beacon.setDistanceCalculator(new ModelSpecificDistanceCalculator(this, BeaconManager.getDistanceModelUpdateUrl()));
        try {
            this.mScanHelper.setSimulatedScanData((List) Class.forName("org.altbeacon.beacon.SimulatedScanData").getField("beacons").get((Object) null));
        } catch (ClassNotFoundException unused) {
            LogManager.d(TAG, "No org.altbeacon.beacon.SimulatedScanData class exists.", new Object[0]);
        } catch (Exception e) {
            LogManager.e(e, TAG, "Cannot get simulated Scan data.  Make sure your org.altbeacon.beacon.SimulatedScanData class defines a field with the signature 'public static List<Beacon> beacons'", new Object[0]);
        }
    }

    private void ensureNotificationProcessorSetup() {
        if (this.mBeaconNotificationProcessor == null) {
            BeaconLocalBroadcastProcessor instance = BeaconLocalBroadcastProcessor.getInstance(this);
            this.mBeaconNotificationProcessor = instance;
            instance.register();
        }
    }

    private void startForegroundIfConfigured() {
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(getApplicationContext());
        Notification foregroundServiceNotification = instanceForApplication.getForegroundServiceNotification();
        int foregroundServiceNotificationId = instanceForApplication.getForegroundServiceNotificationId();
        if (foregroundServiceNotification != null) {
            startForeground(foregroundServiceNotificationId, foregroundServiceNotification);
        }
    }

    private String getManifestMetadataValue(String str) {
        try {
            ServiceInfo serviceInfo = getPackageManager().getServiceInfo(new ComponentName(this, BeaconService.class), 128);
            if (serviceInfo == null || serviceInfo.metaData == null) {
                return null;
            }
            return serviceInfo.metaData.get(str).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        if (intent == null) {
            str = "starting with null intent";
        } else {
            str = "starting with intent " + intent.toString();
        }
        LogManager.i(TAG, str, new Object[0]);
        return super.onStartCommand(intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        LogManager.i(TAG, "binding", new Object[0]);
        return this.mMessenger.getBinder();
    }

    public boolean onUnbind(Intent intent) {
        LogManager.i(TAG, "unbinding so destroying self", new Object[0]);
        stopForeground(true);
        stopSelf();
        return false;
    }

    public void onDestroy() {
        LogManager.e(TAG, "onDestroy()", new Object[0]);
        BeaconLocalBroadcastProcessor beaconLocalBroadcastProcessor = this.mBeaconNotificationProcessor;
        if (beaconLocalBroadcastProcessor != null) {
            beaconLocalBroadcastProcessor.unregister();
        }
        BluetoothCrashResolver bluetoothCrashResolver2 = this.bluetoothCrashResolver;
        if (bluetoothCrashResolver2 != null) {
            bluetoothCrashResolver2.stop();
        }
        LogManager.i(TAG, "onDestroy called.  stopping scanning", new Object[0]);
        this.handler.removeCallbacksAndMessages((Object) null);
        if (this.mScanHelper.getCycledScanner() != null) {
            this.mScanHelper.getCycledScanner().stop();
            this.mScanHelper.getCycledScanner().destroy();
        }
        this.mScanHelper.getMonitoringStatus().stopStatusPreservation();
        this.mScanHelper.terminateThreads();
    }

    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        LogManager.d(TAG, "task removed", new Object[0]);
        if (Build.VERSION.RELEASE.contains("4.4.1") || Build.VERSION.RELEASE.contains("4.4.2") || Build.VERSION.RELEASE.contains("4.4.3")) {
            ((AlarmManager) getApplicationContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(0, System.currentTimeMillis() + 1000, getRestartIntent());
            LogManager.d(TAG, "Setting a wakeup alarm to go off due to Android 4.4.2 service restarting bug.", new Object[0]);
        }
    }

    private PendingIntent getRestartIntent() {
        return PendingIntent.getBroadcast(getApplicationContext(), 1, new Intent(getApplicationContext(), StartupBroadcastReceiver.class), 1140850688);
    }

    public void startRangingBeaconsInRegion(Region region, Callback callback) {
        synchronized (this.mScanHelper.getRangedRegionState()) {
            if (this.mScanHelper.getRangedRegionState().containsKey(region)) {
                LogManager.i(TAG, "Already ranging that region -- will replace existing region.", new Object[0]);
                this.mScanHelper.getRangedRegionState().remove(region);
            }
            this.mScanHelper.getRangedRegionState().put(region, new RangeState(callback));
            LogManager.d(TAG, "Currently ranging %s regions.", Integer.valueOf(this.mScanHelper.getRangedRegionState().size()));
        }
        if (this.mScanHelper.getCycledScanner() != null) {
            this.mScanHelper.getCycledScanner().start();
        }
    }

    public void stopRangingBeaconsInRegion(Region region) {
        int size;
        synchronized (this.mScanHelper.getRangedRegionState()) {
            this.mScanHelper.getRangedRegionState().remove(region);
            size = this.mScanHelper.getRangedRegionState().size();
            LogManager.d(TAG, "Currently ranging %s regions.", Integer.valueOf(this.mScanHelper.getRangedRegionState().size()));
        }
        if (size == 0 && this.mScanHelper.getMonitoringStatus().regionsCount() == 0 && this.mScanHelper.getCycledScanner() != null) {
            this.mScanHelper.getCycledScanner().stop();
        }
    }

    public void startMonitoringBeaconsInRegion(Region region, Callback callback) {
        LogManager.d(TAG, "startMonitoring called", new Object[0]);
        this.mScanHelper.getMonitoringStatus().addRegion(region, callback);
        LogManager.d(TAG, "Currently monitoring %s regions.", Integer.valueOf(this.mScanHelper.getMonitoringStatus().regionsCount()));
        if (this.mScanHelper.getCycledScanner() != null) {
            this.mScanHelper.getCycledScanner().start();
        }
    }

    public void stopMonitoringBeaconsInRegion(Region region) {
        LogManager.d(TAG, "stopMonitoring called", new Object[0]);
        this.mScanHelper.getMonitoringStatus().removeRegion(region);
        LogManager.d(TAG, "Currently monitoring %s regions.", Integer.valueOf(this.mScanHelper.getMonitoringStatus().regionsCount()));
        if (this.mScanHelper.getMonitoringStatus().regionsCount() == 0 && this.mScanHelper.getRangedRegionState().size() == 0 && this.mScanHelper.getCycledScanner() != null) {
            this.mScanHelper.getCycledScanner().stop();
        }
    }

    public void setScanPeriods(long j, long j2, boolean z) {
        if (this.mScanHelper.getCycledScanner() != null) {
            this.mScanHelper.getCycledScanner().setScanPeriods(j, j2, z);
        }
    }

    public void reloadParsers() {
        this.mScanHelper.reloadParsers();
    }

    /* access modifiers changed from: protected */
    public CycledLeScanCallback getCycledLeScanCallback() {
        return this.mScanHelper.getCycledLeScanCallback();
    }
}
