package jp.co.sony.reonpocket.modules.settings.router;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import jp.co.sony.reonpocket.modules.autoStart.view.AutoStartActivity;
import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import jp.co.sony.reonpocket.modules.base.view.BaseActivity;
import jp.co.sony.reonpocket.modules.locationSetting.view.LocationSettingActivity;
import jp.co.sony.reonpocket.modules.quickMode.view.QuickLaunchActivity;
import jp.co.sony.reonpocket.modules.settings.view.SettingActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/router/SettingRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "Ljp/co/sony/reonpocket/modules/settings/router/SettingWireframe;", "aActivity", "Ljp/co/sony/reonpocket/modules/settings/view/SettingActivity;", "(Ljp/co/sony/reonpocket/modules/settings/view/SettingActivity;)V", "goToAutoStart", "", "goToBatteryNotification", "goToChangeUserInfo", "goToLegal", "goToOss", "goToQuickLaunch", "goToTwitter", "aUrl", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingRouter.kt */
public final class SettingRouter extends BaseRouter implements SettingWireframe {
    public static final int $stable = 8;
    private final SettingActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SettingRouter(SettingActivity settingActivity) {
        super(settingActivity);
        Intrinsics.checkNotNullParameter(settingActivity, "aActivity");
        this.aActivity = settingActivity;
    }

    public void goToOss() {
        this.aActivity.transitToOssContentFragment();
    }

    public void goToLegal() {
        this.aActivity.transitToLegalFragment();
    }

    public void goToQuickLaunch() {
        BaseRouter.transitToActivity$default(this, QuickLaunchActivity.class, (Bundle) null, 2, (Object) null);
    }

    public void goToAutoStart() {
        BaseRouter.transitToActivity$default(this, AutoStartActivity.class, (Bundle) null, 2, (Object) null);
    }

    public void goToChangeUserInfo() {
        this.aActivity.transitToChangeUserInfo();
    }

    public void goToTwitter(String str) {
        Intrinsics.checkNotNullParameter(str, "aUrl");
        this.aActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void goToBatteryNotification() {
        BaseActivity.transitToActivity$default(this.aActivity, LocationSettingActivity.class, (Bundle) null, 2, (Object) null);
    }
}
