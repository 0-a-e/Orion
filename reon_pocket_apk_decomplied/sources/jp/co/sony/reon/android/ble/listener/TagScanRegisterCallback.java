package jp.co.sony.reon.android.ble.listener;

import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reon/android/ble/listener/TagScanRegisterCallback;", "", "failure", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "success", "deviceName", "", "aTagData", "", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagScanCallbackListener.kt */
public interface TagScanRegisterCallback {
    void failure(ReasonCodeConstant reasonCodeConstant);

    void success(String str, byte[] bArr);
}
