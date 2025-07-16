package jp.co.sony.reonpocket.modules.pairing.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\fH&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u0003H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0010H&J\b\u0010$\u001a\u00020\u0003H&J>\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\f2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010,H&J\b\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u00020\u0003H&J\b\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u00020\u0003H&J&\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000307H&J\b\u00108\u001a\u00020\u0003H&J\b\u00109\u001a\u00020\u0003H&J \u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\fH&J\b\u0010;\u001a\u00020\u0003H&J\b\u0010<\u001a\u00020\u0003H&J\b\u0010=\u001a\u00020\u0003H&J\b\u0010>\u001a\u00020\u0003H&J\b\u0010?\u001a\u00020\u0003H&J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u0010H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u0010H&J\u001a\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u00010FH&J\u001a\u0010G\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00052\b\u0010E\u001a\u0004\u0018\u000104H&¨\u0006H"}, d2 = {"Ljp/co/sony/reonpocket/modules/pairing/view/PairingViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "changeOkBtnState", "", "aIsActive", "", "doDfu", "hiddenProgress", "hiddenSettingMenuDialog", "hiddenTagDfuProgress", "onFail", "aErrorMessage", "", "onFinishSend", "onNextPage", "aPageId", "", "aModelName", "aBundle", "Landroid/os/Bundle;", "onUserInfoInit", "aGender", "aAge", "aHeight", "aWeight", "aState", "requestForAppUpdate", "requestPermissionDialog", "permissionCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "showDfuComplete", "showDfuDisconnect", "showDfuFail", "showDfuStarting", "showErrorMessage", "aStringResId", "showNoMessageProgress", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showProgress", "showTagDfuComplete", "showTagDfuDisconnect", "showTagDfuFail", "showTagDfuStarting", "showTagFoundDialog", "aTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "aTagModelName", "positiveCompletion", "Lkotlin/Function0;", "showTagNotFoundPopup", "showTagRegisterDialog", "bdAddress", "showTagRegistrationFailedDialog", "showTagUnRegisterDialog", "showTagUpdateMessage", "tryConnectDfu", "unRegisterTagStatus", "updateDfuProgress", "aProgress", "updateTagDfuProgress", "updateTagMiniInfoView", "isActive", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "updateTagMiniInfoViewNoReceiving", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairingViewInput.kt */
public interface PairingViewInput extends BaseViewInput {
    void changeOkBtnState(boolean z);

    void doDfu();

    void hiddenProgress();

    void hiddenSettingMenuDialog();

    void hiddenTagDfuProgress();

    void onFail(String str);

    void onFinishSend();

    void onNextPage(int i, String str, Bundle bundle);

    void onUserInfoInit(String str, String str2, String str3, String str4, String str5);

    void requestForAppUpdate();

    void requestPermissionDialog(BleConnStatusCode bleConnStatusCode);

    void showDfuComplete();

    void showDfuDisconnect();

    void showDfuFail();

    void showDfuStarting();

    void showErrorMessage(int i);

    void showNoMessageProgress();

    void showNotification(String str, String str2, String str3, String str4, String str5, Bitmap bitmap);

    void showProgress();

    void showTagDfuComplete();

    void showTagDfuDisconnect();

    void showTagDfuFail();

    void showTagDfuStarting();

    void showTagFoundDialog(TagDataEntity tagDataEntity, String str, Function0<Unit> function0);

    void showTagNotFoundPopup();

    void showTagRegisterDialog();

    void showTagRegisterDialog(String str, TagDataEntity tagDataEntity, String str2);

    void showTagRegistrationFailedDialog();

    void showTagUnRegisterDialog();

    void showTagUpdateMessage();

    void tryConnectDfu();

    void unRegisterTagStatus();

    void updateDfuProgress(int i);

    void updateTagDfuProgress(int i);

    void updateTagMiniInfoView(boolean z, NotifyTagSensorDataEntity notifyTagSensorDataEntity);

    void updateTagMiniInfoViewNoReceiving(boolean z, TagDataEntity tagDataEntity);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PairingViewInput.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onNextPage$default(PairingViewInput pairingViewInput, int i, String str, Bundle bundle, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    str = null;
                }
                if ((i2 & 4) != 0) {
                    bundle = null;
                }
                pairingViewInput.onNextPage(i, str, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNextPage");
        }
    }
}
