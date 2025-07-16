package jp.co.sony.reon.android.ble.listener;

import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Ljp/co/sony/reon/android/ble/listener/TagScanCallbackListener;", "", "onScanFailed", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "onScanSuccess", "bdAddress", "", "deviceName", "aTagData", "", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TagScanCallbackListener.kt */
public interface TagScanCallbackListener {
    void onScanFailed(ReasonCodeConstant reasonCodeConstant);

    void onScanSuccess(String str, String str2, byte[] bArr);
}
