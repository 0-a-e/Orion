package jp.co.sony.reonpocket.modules.pairing.router;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.router.BaseRouter;
import jp.co.sony.reonpocket.modules.main.router.MainRouterKt;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import jp.co.sony.reonpocket.modules.pairing.view.PairingActivity;
import jp.co.sony.reonpocket.modules.tagInfo.view.TagInfoActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J,\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/router/PairingRouter;", "Ljp/co/sony/reonpocket/modules/base/router/BaseRouter;", "Ljp/co/sony/reonpocket/modules/pairing/router/PairingWireFrame;", "aActivity", "Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity;", "(Ljp/co/sony/reonpocket/modules/pairing/view/PairingActivity;)V", "goToChangeUserInfo", "", "goToLegal", "goToMain", "aBundle", "Landroid/os/Bundle;", "goToOss", "goToPairingComplete", "aModelName", "", "goToTagInfo", "isTagInfoReceiving", "", "isTagNoAmbientTemp", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "tagDataEntity", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingRouter.kt */
public final class PairingRouter extends BaseRouter implements PairingWireFrame {
    public static final int $stable = 8;
    private final PairingActivity aActivity;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PairingRouter(PairingActivity pairingActivity) {
        super(pairingActivity);
        Intrinsics.checkNotNullParameter(pairingActivity, "aActivity");
        this.aActivity = pairingActivity;
    }

    public void goToPairingComplete(String str) {
        Intrinsics.checkNotNullParameter(str, "aModelName");
        this.aActivity.transitToCompleteFragment(str);
    }

    public void goToMain(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "aBundle");
        transitToActivity(MainActivity.class, bundle);
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
        intent.putExtra(MainRouterKt.MAIN_VIEW_TAG_INFO_RECEIVING, z);
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
