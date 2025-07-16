package jp.co.sony.reonpocket.modules.connect.router;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionActivity;
import jp.co.sony.reonpocket.modules.main.router.MainRouterKt;
import jp.co.sony.reonpocket.modules.splash.view.SplashActivity;
import jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016J,\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/router/ConnectionRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "Ljp/co/sony/reonpocket/modules/connect/router/ConnectionWireFrame;", "aActivity", "Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity;", "(Ljp/co/sony/reonpocket/modules/connect/view/ConnectionActivity;)V", "goToChangeUserInfo", "", "goToLegal", "goToMain", "aBundle", "Landroid/os/Bundle;", "goToOss", "goToSplash", "goToTagInfo", "isTagInfoReceiving", "", "isTagNoAmbientTemp", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "tagDataEntity", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionRouter.kt */
public final class ConnectionRouter extends BaseRouter implements ConnectionWireFrame {
    public static final int $stable = 8;
    private final ConnectionActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionRouter(ConnectionActivity connectionActivity) {
        super(connectionActivity);
        Intrinsics.checkNotNullParameter(connectionActivity, "aActivity");
        this.aActivity = connectionActivity;
    }

    public void goToMain(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "aBundle");
        this.aActivity.transitToMain(bundle);
    }

    public void goToSplash() {
        BaseRouter.transitToActivity$default(this, SplashActivity.class, (Bundle) null, 2, (Object) null);
        finish();
    }

    public void goToLegal() {
        this.aActivity.transitToLegalFragment();
    }

    public void goToChangeUserInfo() {
        this.aActivity.transitToChangeUserInfo();
    }

    public void goToOss() {
        this.aActivity.transitToOssContentFragment();
    }

    public void goToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity, TagDataEntity tagDataEntity) {
        Intent intent = new Intent(this.aActivity, TagInfoActivity.class);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(this.aActivity, new Pair[0]).toBundle();
        intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_NO_AMBIENT_TEMP, z2);
        intent.putExtra(MainRouterKt.MAIN_VIEW_IS_USE_DEVICE_READ_SENSOR, false);
        if (notifyTagSensorDataEntity != null) {
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_RECEIVING, true);
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_TEMP, notifyTagSensorDataEntity.getTagTemp());
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_HUMI, notifyTagSensorDataEntity.getTagHumi());
            intent.putExtra(MainRouterKt.MAIN_VIEW_BATTERY_REMAINING, notifyTagSensorDataEntity.getBatteryLevel());
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_GET_VALUE, true);
        } else if (tagDataEntity != null) {
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_RECEIVING, false);
            Float temperature = tagDataEntity.getTemperature();
            float f = 0.0f;
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_TEMP, (temperature != null ? temperature.floatValue() : 0.0f) / 100.0f);
            Float humidity = tagDataEntity.getHumidity();
            if (humidity != null) {
                f = humidity.floatValue();
            }
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_HUMI, f / 100.0f);
            intent.putExtra(MainRouterKt.MAIN_VIEW_BATTERY_REMAINING, tagDataEntity.getBatteryLevel());
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_GET_VALUE, true);
        } else {
            intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_GET_VALUE, false);
        }
        this.aActivity.startActivity(intent, bundle);
    }
}
