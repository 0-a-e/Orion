package jp.co.sony.reonpocket.modules.locationSetting.presenter;

import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import jp.co.sony.reonpocket.modules.base.presenter.BasePresenter;
import jp.co.sony.reonpocket.modules.locationSetting.router.LocationSettingRouter;
import jp.co.sony.reonpocket.modules.locationSetting.view.LocationSettingActivity;
import jp.co.sony.reonpocket.modules.locationSetting.view.LocationSettingViewInput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/modules/locationSetting/presenter/LocationSettingPresenter;", "Ljp/co/sony/reonpocket/modules/base/presenter/BasePresenter;", "Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingActivity$LocationSettingViewOutput;", "aContext", "Landroid/content/Context;", "aView", "Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingViewInput;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/modules/locationSetting/view/LocationSettingViewInput;)V", "mRouter", "Ljp/co/sony/reonpocket/modules/locationSetting/router/LocationSettingRouter;", "checkBackgroundPermission", "", "onResume", "", "transitToSetting", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationSettingPresenter.kt */
public final class LocationSettingPresenter extends BasePresenter implements LocationSettingActivity.LocationSettingViewOutput {
    public static final int $stable = 8;
    private final Context aContext;
    private final LocationSettingViewInput aView;
    private final LocationSettingRouter mRouter;

    public LocationSettingPresenter(Context context, LocationSettingViewInput locationSettingViewInput) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        this.aView = locationSettingViewInput;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type jp.co.sony.reonpocket.modules.locationSetting.view.LocationSettingActivity");
        this.mRouter = new LocationSettingRouter((LocationSettingActivity) context);
    }

    public void onResume() {
        LocationSettingViewInput locationSettingViewInput;
        super.onResume();
        if (Build.VERSION.SDK_INT >= 29 && (locationSettingViewInput = this.aView) != null) {
            locationSettingViewInput.updatePermissionView(checkBackgroundPermission());
        }
    }

    public boolean checkBackgroundPermission() {
        if (Build.VERSION.SDK_INT < 29 || ActivityCompat.checkSelfPermission(this.aContext, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
            return false;
        }
        return true;
    }

    public void transitToSetting() {
        this.mRouter.goToSetting();
    }
}
