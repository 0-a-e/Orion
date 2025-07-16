package jp.co.sony.reonpocket.modules.connect.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.data.entity.NotifyTagSensorDataEntity;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u001c\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J0\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\b\u0010\u001d\u001a\u00020\u0003H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\rH&J\b\u0010 \u001a\u00020\u0003H&J>\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\t2\b\u0010'\u001a\u0004\u0018\u00010(H&J\b\u0010)\u001a\u00020\u0003H&J\b\u0010*\u001a\u00020\u0003H&J\b\u0010+\u001a\u00020\u0003H&J\b\u0010,\u001a\u00020\u0003H&J\b\u0010-\u001a\u00020\u0003H&J&\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\t2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000303H&J\b\u00104\u001a\u00020\u0003H&J\b\u00105\u001a\u00020\u0003H&J \u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\t2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\tH&J\b\u00107\u001a\u00020\u0003H&J\b\u00108\u001a\u00020\u0003H&J\b\u00109\u001a\u00020\u0003H&J\b\u0010:\u001a\u00020\u0003H&J\b\u0010;\u001a\u00020\u0003H&J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\rH&J\u0010\u0010>\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\rH&J\u001a\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH&J\u001a\u0010D\u001a\u00020\u00032\u0006\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u000100H&¨\u0006E"}, d2 = {"Ljp/co/sony/reonpocket/modules/connect/view/ConnectionViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "doDfu", "", "hiddenProgress", "hiddenSettingMenuDialog", "hiddenTagDfuProgress", "onFail", "aErrorMessage", "", "onFinishSend", "onNextPage", "aPageId", "", "aBundle", "Landroid/os/Bundle;", "onUserInfoInit", "aGender", "aAge", "aHeight", "aWeight", "aState", "requestForAppUpdate", "requestPermissionDialog", "permissionCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "showDfuComplete", "showDfuDisconnect", "showDfuFail", "showDfuStarting", "showErrorMessage", "aStringResId", "showNoMessageProgress", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showProgress", "showTagDfuComplete", "showTagDfuDisconnect", "showTagDfuFail", "showTagDfuStarting", "showTagFoundDialog", "aTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "aTagModelName", "positiveCompletion", "Lkotlin/Function0;", "showTagNotFoundPopup", "showTagRegisterDialog", "bdAddress", "showTagRegistrationFailedDialog", "showTagUnRegisterDialog", "showTagUpdateMessage", "tryConnectDfu", "unRegisterTagStatus", "updateDfuProgress", "aProgress", "updateTagDfuProgress", "updateTagMiniInfoView", "isActive", "", "entity", "Ljp/co/sony/reonpocket/data/entity/NotifyTagSensorDataEntity;", "updateTagMiniInfoViewNoReceiving", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionViewInput.kt */
public interface ConnectionViewInput extends BaseViewInput {
    void doDfu();

    void hiddenProgress();

    void hiddenSettingMenuDialog();

    void hiddenTagDfuProgress();

    void onFail(String str);

    void onFinishSend();

    void onNextPage(int i, Bundle bundle);

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
    /* compiled from: ConnectionViewInput.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onNextPage$default(ConnectionViewInput connectionViewInput, int i, Bundle bundle, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    bundle = null;
                }
                connectionViewInput.onNextPage(i, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onNextPage");
        }
    }
}
