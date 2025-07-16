package jp.co.sony.reon.android.ble.service;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import jp.co.sony.reon.android.ble.service.ReceiveBleTagGattCallback;
import jp.co.sony.reon.android.ble.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"jp/co/sony/reon/android/ble/service/BleService$tagConnect$1", "Ljp/co/sony/reon/android/ble/service/ReceiveBleTagGattCallback;", "onSend", "", "action", "", "result", "aBundle", "Landroid/os/Bundle;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleService.kt */
public final class BleService$tagConnect$1 implements ReceiveBleTagGattCallback {
    final /* synthetic */ BleService this$0;

    BleService$tagConnect$1(BleService bleService) {
        this.this$0 = bleService;
    }

    public void onSend(int i, int i2, Bundle bundle) {
        boolean z = false;
        switch (i) {
            case 13:
                BleService bleService = this.this$0;
                if (i2 != 1) {
                    z = true;
                }
                bleService.mIsTagConnected = z;
                if (i2 == 1) {
                    this.this$0.tagClose();
                }
                this.this$0.sendClientMessage(i, i2, bundle);
                return;
            case 14:
                this.this$0.sendClientMessage(i, i2, bundle);
                this.this$0.dequeueCommand();
                return;
            case 15:
                if (this.this$0.mIsTagConnected) {
                    this.this$0.mIsTagConnected = false;
                    DebugLogUtil.INSTANCE.e("has exception, disconnected");
                    this.this$0.sendClientMessage(18, 1, bundle);
                } else {
                    DebugLogUtil.INSTANCE.e("connect failed");
                    this.this$0.sendClientMessage(13, 1, bundle);
                }
                this.this$0.tagClose();
                return;
            case 16:
                BluetoothGatt access$getMTagBleGatt$p = this.this$0.mTagBleGatt;
                if (access$getMTagBleGatt$p != null) {
                    BleService bleService2 = this.this$0;
                    BluetoothDevice device = access$getMTagBleGatt$p.getDevice();
                    Intrinsics.checkNotNullExpressionValue(device, "getDevice(...)");
                    if (bleService2.removeBond(device)) {
                        bleService2.mIsTagConnected = false;
                        String address = access$getMTagBleGatt$p.getDevice().getAddress();
                        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                        bleService2.tagConnect(address);
                        return;
                    }
                    return;
                }
                return;
            case 17:
                if (this.this$0.mTagConnectRetryCount < 3) {
                    BleService bleService3 = this.this$0;
                    bleService3.mTagConnectRetryCount = bleService3.mTagConnectRetryCount + 1;
                    DebugLogUtil.INSTANCE.d("gatt error, retry " + this.this$0.mTagConnectRetryCount);
                    BluetoothGatt access$getMTagBleGatt$p2 = this.this$0.mTagBleGatt;
                    if (access$getMTagBleGatt$p2 != null) {
                        BleService bleService4 = this.this$0;
                        bleService4.mIsTagConnected = false;
                        String address2 = access$getMTagBleGatt$p2.getDevice().getAddress();
                        Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
                        bleService4.tagConnect(address2);
                        return;
                    }
                } else {
                    DebugLogUtil.INSTANCE.e("gatt error, retry count " + this.this$0.mTagConnectRetryCount);
                }
                ReceiveBleTagGattCallback.DefaultImpls.onSend$default(this, 15, 1, (Bundle) null, 4, (Object) null);
                return;
            default:
                return;
        }
    }
}
