package jp.co.sony.reonpocket.modules.tagInfo.view;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J0\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J>\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&¨\u0006\u001a"}, d2 = {"Ljp/co/sony/reonpocket/modules/tagInfo/view/TagInfoViewInput;", "", "hiddenSettingMenuDialog", "", "onFinishSend", "onUserInfoInit", "aGender", "", "aAge", "aHeight", "aWeight", "aState", "showErrorMessage", "aStringResId", "", "showNoMessageProgress", "showNotification", "aButtonPreference", "aTitle", "aSubtitle", "aDescription", "aUrl", "aBitMap", "Landroid/graphics/Bitmap;", "showTagUnRegisterDialog", "unRegisterTagStatus", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagInfoViewInput.kt */
public interface TagInfoViewInput {
    void hiddenSettingMenuDialog();

    void onFinishSend();

    void onUserInfoInit(String str, String str2, String str3, String str4, String str5);

    void showErrorMessage(int i);

    void showNoMessageProgress();

    void showNotification(String str, String str2, String str3, String str4, String str5, Bitmap bitmap);

    void showTagUnRegisterDialog();

    void unRegisterTagStatus();
}
