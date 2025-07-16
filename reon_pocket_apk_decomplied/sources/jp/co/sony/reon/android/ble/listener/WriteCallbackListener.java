package jp.co.sony.reon.android.ble.listener;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Ljp/co/sony/reon/android/ble/listener/WriteCallbackListener;", "", "onWrite", "", "aResponseCode", "", "aCharacteristicUuid", "", "aServiceUuid", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: WriteCallbackListener.kt */
public interface WriteCallbackListener {
    void onWrite(int i, String str, String str2);
}
