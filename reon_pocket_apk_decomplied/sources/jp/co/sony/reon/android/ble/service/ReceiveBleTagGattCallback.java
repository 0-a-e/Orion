package jp.co.sony.reon.android.ble.service;

import android.os.Bundle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Ljp/co/sony/reon/android/ble/service/ReceiveBleTagGattCallback;", "", "onSend", "", "action", "", "result", "aBundle", "Landroid/os/Bundle;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleTagGattCallback.kt */
public interface ReceiveBleTagGattCallback {
    void onSend(int i, int i2, Bundle bundle);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleTagGattCallback.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onSend$default(ReceiveBleTagGattCallback receiveBleTagGattCallback, int i, int i2, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    bundle = null;
                }
                receiveBleTagGattCallback.onSend(i, i2, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSend");
        }
    }
}
