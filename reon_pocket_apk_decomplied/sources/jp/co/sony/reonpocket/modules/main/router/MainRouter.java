package jp.co.sony.reonpocket.modules.main.router;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.constant.IntentExtraConstant;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity;
import jp.co.sony.reonpocket.modules.deviceInfo.view.DeviceInfoActivity;
import jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment;
import jp.co.sony.reonpocket.modules.initialize.view.InitializeActivity;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.modules.settings.view.SettingActivity;
import jp.co.sony.reonpocket.modules.splash.view.SplashActivity;
import jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016Jg\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\"\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ljp/co/sony/reonpocket/modules/main/router/MainRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "Ljp/co/sony/reonpocket/modules/main/router/MainWireFrame;", "aActivity", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity;", "(Ljp/co/sony/reonpocket/modules/main/view/MainActivity;)V", "goToConnectionAndClear", "", "aBundle", "Landroid/os/Bundle;", "goToDeviceInfo", "aErrorCode", "", "aTemp", "", "aFinTemp", "aCoolHeatTypeCode", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "aIsSmartMixTypeCool", "", "aMyCoolHeatStep", "Lkotlin/Pair;", "aIsSmartActive", "aCurrentPage", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$Companion$Page;", "aDeviceMode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "(Ljava/lang/Integer;FFLjp/co/sony/reonpocket/constant/CoolHeatTypeCode;ZLkotlin/Pair;ZLjp/co/sony/reonpocket/modules/main/view/MainActivity$Companion$Page;Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;)V", "goToInitialize", "aEula", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "aPrivacyPolicy", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "goToSetting", "goToSplash", "goToTagInfo", "isTagInfoReceiving", "isTagNoAmbientTemp", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainRouter.kt */
public final class MainRouter extends BaseRouter implements MainWireFrame {
    public static final int $stable = 8;
    private final MainActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainRouter(MainActivity mainActivity) {
        super(mainActivity);
        Intrinsics.checkNotNullParameter(mainActivity, "aActivity");
        this.aActivity = mainActivity;
    }

    public void goToInitialize(InitWelcomeFragment.Eula eula) {
        Intrinsics.checkNotNullParameter(eula, "aEula");
        transitToActivity(InitializeActivity.Companion.createIntent((Context) this.aActivity, eula));
    }

    public void goToInitialize(InitWelcomeFragment.PrivacyPolicy privacyPolicy) {
        Intrinsics.checkNotNullParameter(privacyPolicy, "aPrivacyPolicy");
        transitToActivity(InitializeActivity.Companion.createIntent((Context) this.aActivity, privacyPolicy));
    }

    public void goToInitialize(InitWelcomeFragment.Eula eula, InitWelcomeFragment.PrivacyPolicy privacyPolicy) {
        Intrinsics.checkNotNullParameter(eula, "aEula");
        Intrinsics.checkNotNullParameter(privacyPolicy, "aPrivacyPolicy");
        transitToActivity(InitializeActivity.Companion.createIntent(this.aActivity, eula, privacyPolicy));
    }

    public void goToSetting() {
        BaseRouter.transitToActivity$default(this, SettingActivity.class, (Bundle) null, 2, (Object) null);
    }

    public void goToConnectionAndClear(Bundle bundle) {
        if (bundle != null) {
            bundle.putBoolean(IntentExtraConstant.FromSplash.IS_CONNECT_WHEN_ON_CREATE.getKey(), true);
        }
        transitAndClear(ConnectionActivity.class, bundle);
        finish();
    }

    public void goToDeviceInfo(Integer num, float f, float f2, CoolHeatTypeCode coolHeatTypeCode, boolean z, Pair<Integer, Integer> pair, boolean z2, MainActivity.Companion.Page page, DeviceModeActionCode deviceModeActionCode) {
        Intrinsics.checkNotNullParameter(coolHeatTypeCode, "aCoolHeatTypeCode");
        Intrinsics.checkNotNullParameter(pair, "aMyCoolHeatStep");
        Intrinsics.checkNotNullParameter(page, "aCurrentPage");
        Intrinsics.checkNotNullParameter(deviceModeActionCode, "aDeviceMode");
        Intent intent = new Intent(this.aActivity, DeviceInfoActivity.class);
        intent.setFlags(335544320);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this.aActivity, new android.util.Pair[0]).toBundle();
        if (num == null || intent.putExtra(MainRouterKt.MAIN_VIEW_INFO_CODE, num.intValue()) == null) {
            intent.putExtra(MainRouterKt.MAIN_VIEW_INFO_CODE, -1);
        }
        intent.putExtra(MainRouterKt.MAIN_VIEW_TEMPERATURE, f);
        intent.putExtra(MainRouterKt.MAIN_VIEW_FAN_TEMPERATURE, f2);
        intent.putExtra(MainRouterKt.MAIN_VIEW_COOL_HEAT_TYPE, coolHeatTypeCode.getCode());
        intent.putExtra(MainRouterKt.MAIN_VIEW_SMART_MIX_MODE_TYPE, z);
        Integer first = pair.getFirst();
        int i = 255;
        intent.putExtra(MainRouterKt.MAIN_VIEW_MY_COOL_STEP, first != null ? first.intValue() : 255);
        Integer second = pair.getSecond();
        if (second != null) {
            i = second.intValue();
        }
        intent.putExtra(MainRouterKt.MAIN_VIEW_MY_HEAT_STEP, i);
        intent.putExtra(MainRouterKt.MAIN_VIEW_IS_SMART_ACTIVE, z2);
        intent.putExtra(MainRouterKt.MAIN_VIEW_CURRENT_PAGE, page.getStandard());
        intent.putExtra(MainRouterKt.MAIN_VIEW_DEVICE_MODE, deviceModeActionCode.getCode());
        this.aActivity.startActivity(intent, bundle);
    }

    public void goToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity) {
        Intent intent = new Intent(this.aActivity, TagInfoActivity.class);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this.aActivity, new android.util.Pair[0]).toBundle();
        intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_RECEIVING, z);
        intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_NO_AMBIENT_TEMP, z2);
        intent.putExtra(MainRouterKt.MAIN_VIEW_IS_USE_DEVICE_READ_SENSOR, true);
        if (notifyTagSensorDataEntity != null) {
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_TEMP, notifyTagSensorDataEntity.getTagTemp());
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_HUMI, notifyTagSensorDataEntity.getTagHumi());
            intent.putExtra(MainRouterKt.MAIN_VIEW_BATTERY_REMAINING, notifyTagSensorDataEntity.getBatteryLevel());
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_GET_VALUE, true);
        } else {
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_GET_VALUE, false);
        }
        this.aActivity.startActivity(intent, bundle);
    }

    public void goToSplash() {
        BaseRouter.transitAndClear$default(this, SplashActivity.class, (Bundle) null, 2, (Object) null);
        finish();
    }
}
