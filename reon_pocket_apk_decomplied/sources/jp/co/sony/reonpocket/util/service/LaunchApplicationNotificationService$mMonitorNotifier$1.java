package jp.co.sony.reonpocket.util.service;

import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.Region;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"jp/co/sony/reonpocket/util/service/LaunchApplicationNotificationService$mMonitorNotifier$1", "Lorg/altbeacon/beacon/MonitorNotifier;", "didDetermineStateForRegion", "", "i", "", "region", "Lorg/altbeacon/beacon/Region;", "didEnterRegion", "didExitRegion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LaunchApplicationNotificationService.kt */
public final class LaunchApplicationNotificationService$mMonitorNotifier$1 implements MonitorNotifier {
    final /* synthetic */ LaunchApplicationNotificationService this$0;

    LaunchApplicationNotificationService$mMonitorNotifier$1(LaunchApplicationNotificationService launchApplicationNotificationService) {
        this.this$0 = launchApplicationNotificationService;
    }

    public void didEnterRegion(Region region) {
        Intrinsics.checkNotNullParameter(region, "region");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("TEST_IBEACON", "#### iBeacon検出 : " + region);
        BeaconManager access$getMBeaconManager$p = this.this$0.mBeaconManager;
        if (access$getMBeaconManager$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            access$getMBeaconManager$p = null;
        }
        access$getMBeaconManager$p.startRangingBeaconsInRegion(region);
    }

    public void didExitRegion(Region region) {
        Intrinsics.checkNotNullParameter(region, "region");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("TEST_IBEACON", "#### iBeacon消失 : " + region);
        BeaconManager access$getMBeaconManager$p = this.this$0.mBeaconManager;
        if (access$getMBeaconManager$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBeaconManager");
            access$getMBeaconManager$p = null;
        }
        access$getMBeaconManager$p.stopRangingBeaconsInRegion(region);
    }

    public void didDetermineStateForRegion(int i, Region region) {
        Intrinsics.checkNotNullParameter(region, "region");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e("TEST_IBEACON", "#### iBeaconステータス変化 : " + i + " : " + region);
    }
}
