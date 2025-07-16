package jp.co.sony.reonpocket.modules.locationSetting.router;

import android.content.Intent;
import android.net.Uri;
import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import jp.co.sony.reonpocket.modules.locationSetting.view.LocationSettingActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ljp/co/sony/reonpocket/modules/locationSetting/router/LocationSettingRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "Ljp/co/sony/reonpocket/modules/locationSetting/router/LocationSettingWireFrame;", "aActivity", "Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingActivity;", "(Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingActivity;)V", "goToSetting", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationSettingRouter.kt */
public final class LocationSettingRouter extends BaseRouter implements LocationSettingWireFrame {
    public static final int $stable = 8;
    private final LocationSettingActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationSettingRouter(LocationSettingActivity locationSettingActivity) {
        super(locationSettingActivity);
        Intrinsics.checkNotNullParameter(locationSettingActivity, "aActivity");
        this.aActivity = locationSettingActivity;
    }

    public void goToSetting() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.aActivity.getPackageName(), (String) null));
        this.aActivity.startActivity(intent);
    }
}
