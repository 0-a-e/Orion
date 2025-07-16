package jp.co.sony.reon.android.ble.service;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.SystemClock;
import java.util.UUID;
import jp.co.sony.reon.android.ble.service.BleService;
import jp.co.sony.reon.android.ble.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"jp/co/sony/reon/android/ble/service/BleService$writeCharacteristicTag$command$1", "Ljp/co/sony/reon/android/ble/service/BleService$Command;", "Ljp/co/sony/reon/android/ble/service/BleService;", "execute", "", "aGatt", "Landroid/bluetooth/BluetoothGatt;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleService.kt */
public final class BleService$writeCharacteristicTag$command$1 extends BleService.Command {
    final /* synthetic */ BluetoothGattCharacteristic $gattCharacteristic;
    final /* synthetic */ BleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleService$writeCharacteristicTag$command$1(BleService bleService, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super();
        this.this$0 = bleService;
        this.$gattCharacteristic = bluetoothGattCharacteristic;
    }

    public void execute(BluetoothGatt bluetoothGatt) {
        Unit unit;
        super.execute(bluetoothGatt);
        boolean z = true;
        boolean z2 = false;
        if (bluetoothGatt != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$gattCharacteristic;
            if (!bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic)) {
                SystemClock.sleep(300);
                if (!bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic)) {
                    DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                    UUID uuid = bluetoothGattCharacteristic.getUuid();
                    debugLogUtil.e("BleService", "Write(" + uuid + ") is failed");
                    z2 = true;
                }
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.$gattCharacteristic;
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            UUID uuid2 = bluetoothGattCharacteristic2.getUuid();
            debugLogUtil2.e("BleService", "Write(" + uuid2 + ") is failed, gatt is null");
        } else {
            z = z2;
        }
        if (z) {
            this.this$0.dequeueCommand();
            BleService bleService = this.this$0;
            String uuid3 = this.$gattCharacteristic.getUuid().toString();
            Intrinsics.checkNotNullExpressionValue(uuid3, "toString(...)");
            String uuid4 = this.$gattCharacteristic.getService().getUuid().toString();
            Intrinsics.checkNotNullExpressionValue(uuid4, "toString(...)");
            bleService.sendFailedMsgWithUuid(14, uuid3, uuid4);
        }
    }
}
