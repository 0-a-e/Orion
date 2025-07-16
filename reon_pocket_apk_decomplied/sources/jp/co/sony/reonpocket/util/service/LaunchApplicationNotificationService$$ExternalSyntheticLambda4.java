package jp.co.sony.reonpocket.util.service;

import java.util.Collection;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LaunchApplicationNotificationService$$ExternalSyntheticLambda4 implements RangeNotifier {
    public final /* synthetic */ LaunchApplicationNotificationService f$0;

    public /* synthetic */ LaunchApplicationNotificationService$$ExternalSyntheticLambda4(LaunchApplicationNotificationService launchApplicationNotificationService) {
        this.f$0 = launchApplicationNotificationService;
    }

    public final void didRangeBeaconsInRegion(Collection collection, Region region) {
        LaunchApplicationNotificationService.mRangeNotifier$lambda$4(this.f$0, collection, region);
    }
}
