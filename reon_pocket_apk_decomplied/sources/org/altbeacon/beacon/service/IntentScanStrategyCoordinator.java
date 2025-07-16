package org.altbeacon.beacon.service;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.distance.ModelSpecificDistanceCalculator;
import org.altbeacon.beacon.logging.LogManager;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0012\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020(H\u0002J\u000e\u0010*\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003J\u0018\u0010+\u001a\u00020%2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0-H\u0007J\u0006\u0010/\u001a\u00020%J\b\u00100\u001a\u00020%H\u0007J\u0010\u00101\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u00102\u001a\u00020%H\u0007J\b\u00103\u001a\u00020%H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001a¨\u00065"}, d2 = {"Lorg/altbeacon/beacon/service/IntentScanStrategyCoordinator;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "disableOnFailure", "", "getDisableOnFailure", "()Z", "setDisableOnFailure", "(Z)V", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "initialized", "lastCycleEnd", "", "lastStrategyFailureDetectionCount", "", "getLastStrategyFailureDetectionCount", "()I", "setLastStrategyFailureDetectionCount", "(I)V", "longScanForcingEnabled", "scanHelper", "Lorg/altbeacon/beacon/service/ScanHelper;", "scanState", "Lorg/altbeacon/beacon/service/ScanState;", "started", "strategyFailureDetectionCount", "getStrategyFailureDetectionCount", "setStrategyFailureDetectionCount", "applySettings", "", "ensureInitialized", "getManifestMetadataValue", "", "key", "performPeriodicProcessing", "processScanResults", "scanResults", "Ljava/util/ArrayList;", "Landroid/bluetooth/le/ScanResult;", "reinitialize", "restartBackgroundScan", "runBackupScan", "start", "stop", "Companion", "android-beacon-library_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: IntentScanStrategyCoordinator.kt */
public final class IntentScanStrategyCoordinator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = "IntentScanCoord";
    private final Context context;
    private boolean disableOnFailure;
    private final ExecutorService executor = Executors.newFixedThreadPool(1);
    private boolean initialized;
    private long lastCycleEnd;
    private int lastStrategyFailureDetectionCount;
    private boolean longScanForcingEnabled;
    /* access modifiers changed from: private */
    public ScanHelper scanHelper;
    private ScanState scanState;
    private boolean started;
    private int strategyFailureDetectionCount;

    public IntentScanStrategyCoordinator(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public static final /* synthetic */ ScanHelper access$getScanHelper$p(IntentScanStrategyCoordinator intentScanStrategyCoordinator) {
        ScanHelper scanHelper2 = intentScanStrategyCoordinator.scanHelper;
        if (scanHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        return scanHelper2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getStrategyFailureDetectionCount() {
        return this.strategyFailureDetectionCount;
    }

    public final void setStrategyFailureDetectionCount(int i) {
        this.strategyFailureDetectionCount = i;
    }

    public final int getLastStrategyFailureDetectionCount() {
        return this.lastStrategyFailureDetectionCount;
    }

    public final void setLastStrategyFailureDetectionCount(int i) {
        this.lastStrategyFailureDetectionCount = i;
    }

    public final boolean getDisableOnFailure() {
        return this.disableOnFailure;
    }

    public final void setDisableOnFailure(boolean z) {
        this.disableOnFailure = z;
    }

    public final ExecutorService getExecutor() {
        return this.executor;
    }

    public final void ensureInitialized() {
        if (!this.initialized) {
            this.initialized = true;
            this.scanHelper = new ScanHelper(this.context);
            if (Beacon.getDistanceCalculator() == null) {
                Beacon.setDistanceCalculator(new ModelSpecificDistanceCalculator(this.context, BeaconManager.getDistanceModelUpdateUrl()));
            }
            reinitialize();
        }
    }

    public final void reinitialize() {
        if (!this.initialized) {
            ensureInitialized();
            return;
        }
        ScanState restore = ScanState.restore(this.context);
        if (restore == null) {
            restore = new ScanState(this.context);
        }
        this.scanState = restore;
        if (restore == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanState");
        }
        restore.setLastScanStartTimeMillis(System.currentTimeMillis());
        ScanHelper scanHelper2 = this.scanHelper;
        if (scanHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        ScanState scanState2 = this.scanState;
        if (scanState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanState");
        }
        scanHelper2.setMonitoringStatus(scanState2.getMonitoringStatus());
        ScanHelper scanHelper3 = this.scanHelper;
        if (scanHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        ScanState scanState3 = this.scanState;
        if (scanState3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanState");
        }
        scanHelper3.setRangedRegionState(scanState3.getRangedRegionState());
        ScanHelper scanHelper4 = this.scanHelper;
        if (scanHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        ScanState scanState4 = this.scanState;
        if (scanState4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanState");
        }
        scanHelper4.setBeaconParsers(scanState4.getBeaconParsers());
        ScanHelper scanHelper5 = this.scanHelper;
        if (scanHelper5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        ScanState scanState5 = this.scanState;
        if (scanState5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanState");
        }
        scanHelper5.setExtraDataBeaconTracker(scanState5.getExtraBeaconDataTracker());
    }

    public final void applySettings() {
        ScanState scanState2 = this.scanState;
        if (scanState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanState");
        }
        scanState2.applyChanges(BeaconManager.getInstanceForApplication(this.context));
        reinitialize();
        if (Build.VERSION.SDK_INT >= 26) {
            restartBackgroundScan();
        }
    }

    public final void start() {
        this.started = true;
        ensureInitialized();
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(this.context);
        Intrinsics.checkNotNullExpressionValue(instanceForApplication, "BeaconManager.getInstanceForApplication(context)");
        ScanHelper scanHelper2 = this.scanHelper;
        if (scanHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        scanHelper2.setExtraDataBeaconTracker(new ExtraDataBeaconTracker());
        instanceForApplication.setScannerInSameProcess(true);
        String manifestMetadataValue = getManifestMetadataValue("longScanForcingEnabled");
        if (manifestMetadataValue != null && Intrinsics.areEqual((Object) manifestMetadataValue, (Object) "true")) {
            LogManager.i(BeaconService.TAG, "longScanForcingEnabled to keep scans going on Android N for > 30 minutes", new Object[0]);
            this.longScanForcingEnabled = true;
        }
        ScanHelper scanHelper3 = this.scanHelper;
        if (scanHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        scanHelper3.reloadParsers();
        LogManager.d(TAG, "starting background scan", new Object[0]);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Region next : instanceForApplication.getRangedRegions()) {
            Intrinsics.checkNotNullExpressionValue(next, "region");
            if (next.getIdentifiers().size() == 0) {
                hashSet2.add(next);
            } else {
                hashSet.add(next);
            }
        }
        for (Region next2 : instanceForApplication.getMonitoredRegions()) {
            Intrinsics.checkNotNullExpressionValue(next2, "region");
            if (next2.getIdentifiers().size() == 0) {
                hashSet2.add(next2);
            } else {
                hashSet.add(next2);
            }
        }
        if (hashSet2.size() > 0) {
            if (hashSet.size() > 0) {
                LogManager.w(TAG, "Wildcard regions are being used for beacon ranging or monitoring.  The wildcard regions are ignored with intent scan strategy active.", new Object[0]);
            } else {
                hashSet = hashSet2;
            }
        }
        ScanHelper scanHelper4 = this.scanHelper;
        if (scanHelper4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        ScanState scanState2 = this.scanState;
        if (scanState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanState");
        }
        scanHelper4.startAndroidOBackgroundScan(scanState2.getBeaconParsers(), new ArrayList(hashSet));
        this.lastCycleEnd = System.currentTimeMillis();
        ScanJobScheduler.getInstance().scheduleForIntentScanStrategy(this.context);
    }

    private final String getManifestMetadataValue(String str) {
        String str2 = null;
        try {
            ServiceInfo serviceInfo = this.context.getPackageManager().getServiceInfo(new ComponentName(this.context, BeaconService.class), 128);
            Intrinsics.checkNotNullExpressionValue(serviceInfo, "context.getPackageManage…T_META_DATA\n            )");
            PackageItemInfo packageItemInfo = serviceInfo;
            if (!(packageItemInfo == null || packageItemInfo.metaData == null)) {
                return String.valueOf(packageItemInfo.metaData.get(str));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public final void stop() {
        ensureInitialized();
        LogManager.d(TAG, "stopping background scan", new Object[0]);
        ScanHelper scanHelper2 = this.scanHelper;
        if (scanHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        scanHelper2.stopAndroidOBackgroundScan();
        ScanJobScheduler.getInstance().cancelSchedule(this.context);
        this.started = false;
    }

    public final void restartBackgroundScan() {
        ensureInitialized();
        LogManager.d(TAG, "restarting background scan", new Object[0]);
        ScanHelper scanHelper2 = this.scanHelper;
        if (scanHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        scanHelper2.stopAndroidOBackgroundScan();
        ScanHelper scanHelper3 = this.scanHelper;
        if (scanHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        ScanState scanState2 = this.scanState;
        if (scanState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanState");
        }
        scanHelper3.startAndroidOBackgroundScan(scanState2.getBeaconParsers());
    }

    public final void processScanResults(ArrayList<ScanResult> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "scanResults");
        ensureInitialized();
        Iterator<ScanResult> it = arrayList.iterator();
        while (it.hasNext()) {
            ScanResult next = it.next();
            if (next != null) {
                ScanHelper scanHelper2 = this.scanHelper;
                if (scanHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
                }
                BluetoothDevice device = next.getDevice();
                int rssi = next.getRssi();
                ScanRecord scanRecord = next.getScanRecord();
                scanHelper2.processScanResult(device, rssi, scanRecord != null ? scanRecord.getBytes() : null, next.getTimestampNanos() / ((long) 1000));
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        BeaconManager instanceForApplication = BeaconManager.getInstanceForApplication(this.context);
        Intrinsics.checkNotNullExpressionValue(instanceForApplication, "BeaconManager.getInstanceForApplication(context)");
        long foregroundScanPeriod = instanceForApplication.getForegroundScanPeriod();
        if (instanceForApplication.getBackgroundMode()) {
            foregroundScanPeriod = instanceForApplication.getBackgroundScanPeriod();
        }
        if (currentTimeMillis - this.lastCycleEnd > foregroundScanPeriod) {
            LogManager.d(TAG, "End of scan cycle", new Object[0]);
            this.lastCycleEnd = currentTimeMillis;
            ScanHelper scanHelper3 = this.scanHelper;
            if (scanHelper3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
            }
            scanHelper3.getCycledLeScanCallback().onCycleEnd();
        }
    }

    public final void performPeriodicProcessing(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        if (Build.VERSION.SDK_INT >= 26) {
            processScanResults(new ArrayList());
            runBackupScan(context2);
        }
    }

    public final void runBackupScan(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        if (!this.started) {
            LogManager.i(TAG, "Not doing backup scan because we are not started", new Object[0]);
            return;
        }
        ScanHelper scanHelper2 = this.scanHelper;
        if (scanHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanHelper");
        }
        if (scanHelper2.anyBeaconsDetectedThisCycle()) {
            LogManager.d(TAG, "We have detected beacons with the intent scan.  No need to do a backup scan.", new Object[0]);
            this.strategyFailureDetectionCount = 0;
            this.lastStrategyFailureDetectionCount = 0;
            return;
        }
        LogManager.i(TAG, "Starting backup scan on background thread", new Object[0]);
        this.executor.execute(new IntentScanStrategyCoordinator$runBackupScan$1(this, context2));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lorg/altbeacon/beacon/service/IntentScanStrategyCoordinator$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "android-beacon-library_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IntentScanStrategyCoordinator.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return IntentScanStrategyCoordinator.TAG;
        }
    }
}
