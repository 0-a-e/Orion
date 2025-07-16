package jp.co.sony.reonpocket.modules.settings.view;

import android.graphics.Bitmap;
import java.util.ArrayList;
import jp.co.sony.reonpocket.constant.BleConnStatusCode;
import jp.co.sony.reonpocket.data.entity.tag.TagDataEntity;
import jp.co.sony.reonpocket.modules.base.view.BaseViewInput;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J,\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0003H&J0\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J>\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 H&J&\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030&H&J\b\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\u0003H&J\b\u0010)\u001a\u00020\u0003H&J\b\u0010*\u001a\u00020\u0003H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\tH&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\tH&¨\u0006/"}, d2 = {"Ljp/co/sony/reonpocket/modules/settings/view/SettingViewInput;", "Ljp/co/sony/reonpocket/modules/base/view/BaseViewInput;", "hideProgress", "", "onConnectionStatus", "aConnStatusCode", "Ljp/co/sony/reonpocket/constant/BleConnStatusCode;", "aServiceUuidList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "onFail", "aErrorMessage", "onFinishSend", "onSuccess", "onUnregisteredTag", "onUserInfoInit", "aGender", "aAge", "aHeight", "aWeight", "aState", "showErrorMessage", "aStringResId", "", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showTagFoundDialog", "aTagInfo", "Ljp/co/sony/reonpocket/data/entity/tag/TagDataEntity;", "aTagModelName", "positiveCompletion", "Lkotlin/Function0;", "showTagNotFoundPopup", "showTagRegistrationFailedDialog", "tagRegisteredFailed", "tagRegisteredSuccess", "updateFirmwareReversion", "aFirmwareReversion", "updateModelName", "aModelName", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingViewInput.kt */
public interface SettingViewInput extends BaseViewInput {
    void hideProgress();

    void onConnectionStatus(BleConnStatusCode bleConnStatusCode, ArrayList<String> arrayList);

    void onFail(String str);

    void onFinishSend();

    void onSuccess();

    void onUnregisteredTag();

    void onUserInfoInit(String str, String str2, String str3, String str4, String str5);

    void showErrorMessage(int i);

    void showNotification(String str, String str2, String str3, String str4, String str5, Bitmap bitmap);

    void showTagFoundDialog(TagDataEntity tagDataEntity, String str, Function0<Unit> function0);

    void showTagNotFoundPopup();

    void showTagRegistrationFailedDialog();

    void tagRegisteredFailed();

    void tagRegisteredSuccess();

    void updateFirmwareReversion(String str);

    void updateModelName(String str);
}
