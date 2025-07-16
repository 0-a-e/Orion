package jp.co.sony.reonpocket.modules.main.router;

import android.os.Bundle;
import jp.co.sony.reonpocket.constant.CoolHeatTypeCode;
import jp.co.sony.reonpocket.constant.DeviceModeActionCode;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.modules.initialize.view.InitWelcomeFragment;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&Jg\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0010\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00112\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u0003H&J\b\u0010\u001e\u001a\u00020\u0003H&J\"\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010#H&¨\u0006$"}, d2 = {"Ljp/co/sony/reonpocket/modules/main/router/MainWireFrame;", "", "goToConnectionAndClear", "", "aBundle", "Landroid/os/Bundle;", "goToDeviceInfo", "aErrorCode", "", "aTemp", "", "aFinTemp", "aCoolHeatTypeCode", "Ljp/co/sony/reonpocket/constant/CoolHeatTypeCode;", "aIsSmartMixTypeCool", "", "aMyCoolHeatStep", "Lkotlin/Pair;", "aIsSmartActive", "aCurrentPage", "Ljp/co/sony/reonpocket/modules/main/view/MainActivity$Companion$Page;", "aDeviceMode", "Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;", "(Ljava/lang/Integer;FFLjp/co/sony/reonpocket/constant/CoolHeatTypeCode;ZLkotlin/Pair;ZLjp/co/sony/reonpocket/modules/main/view/MainActivity$Companion$Page;Ljp/co/sony/reonpocket/constant/DeviceModeActionCode;)V", "goToInitialize", "aEula", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$Eula;", "aPrivacyPolicy", "Ljp/co/sony/reonpocket/modules/initialize/view/InitWelcomeFragment$PrivacyPolicy;", "goToSetting", "goToSplash", "goToTagInfo", "isTagInfoReceiving", "isTagNoAmbientTemp", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainRouter.kt */
public interface MainWireFrame {
    void goToConnectionAndClear(Bundle bundle);

    void goToDeviceInfo(Integer num, float f, float f2, CoolHeatTypeCode coolHeatTypeCode, boolean z, Pair<Integer, Integer> pair, boolean z2, MainActivity.Companion.Page page, DeviceModeActionCode deviceModeActionCode);

    void goToInitialize(InitWelcomeFragment.Eula eula);

    void goToInitialize(InitWelcomeFragment.Eula eula, InitWelcomeFragment.PrivacyPolicy privacyPolicy);

    void goToInitialize(InitWelcomeFragment.PrivacyPolicy privacyPolicy);

    void goToSetting();

    void goToSplash();

    void goToTagInfo(boolean z, boolean z2, NotifyTagSensorDataEntity notifyTagSensorDataEntity);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainRouter.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void goToConnectionAndClear$default(MainWireFrame mainWireFrame, Bundle bundle, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    bundle = null;
                }
                mainWireFrame.goToConnectionAndClear(bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goToConnectionAndClear");
        }
    }
}
