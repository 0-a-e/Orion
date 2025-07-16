package jp.co.sony.reon.android.ble.service;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.SystemClock;
import java.util.UUID;
import jp.co.sony.reon.android.ble.service.BleService;
import jp.co.sony.reon.android.ble.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"jp/co/sony/reon/android/ble/service/BleService$setCharacteristicNotification$command$1", "Ljp/co/sony/reon/android/ble/service/BleService$Command;", "Ljp/co/sony/reon/android/ble/service/BleService;", "execute", "", "aGatt", "Landroid/bluetooth/BluetoothGatt;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleService.kt */
public final class BleService$setCharacteristicNotification$command$1 extends BleService.Command {
    final /* synthetic */ UUID $aCharacteristicUuid;
    final /* synthetic */ boolean $aEnabled;
    final /* synthetic */ UUID $aServiceUuid;
    final /* synthetic */ BluetoothGattCharacteristic $gattCharacteristic;
    final /* synthetic */ BleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleService$setCharacteristicNotification$command$1(BleService bleService, UUID uuid, UUID uuid2, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        super();
        this.this$0 = bleService;
        this.$aCharacteristicUuid = uuid;
        this.$aServiceUuid = uuid2;
        this.$gattCharacteristic = bluetoothGattCharacteristic;
        this.$aEnabled = z;
    }

    public void execute(BluetoothGatt bluetoothGatt) {
        Unit unit;
        super.execute(bluetoothGatt);
        boolean z = true;
        boolean z2 = false;
        if (bluetoothGatt != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.$gattCharacteristic;
            boolean z3 = this.$aEnabled;
            if (bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z3)) {
                BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(BleService.Companion.getCHARACTERISTIC_CONFIG_DESCRIPTOR());
                if (z3) {
                    descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                } else {
                    descriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                }
                if (!bluetoothGatt.writeDescriptor(descriptor)) {
                    SystemClock.sleep(300);
                    if (!bluetoothGatt.writeDescriptor(descriptor)) {
                        DebugLogUtil.INSTANCE.e("BleService", "Notification(" + bluetoothGattCharacteristic.getUuid() + ") enabled(" + z3 + ") writeDescriptor failed");
                    }
                }
                unit = Unit.INSTANCE;
            } else {
                DebugLogUtil.INSTANCE.e("BleService", "Notification(" + bluetoothGattCharacteristic.getUuid() + ") enabled(" + z3 + ") setCharacteristicNotification failed");
            }
            z2 = true;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic2 = this.$gattCharacteristic;
            boolean z4 = this.$aEnabled;
            DebugLogUtil.INSTANCE.e("BleService", "Notification(" + bluetoothGattCharacteristic2.getUuid() + ") enabled(" + z4 + ") is failed, gatt is null");
        } else {
            z = z2;
        }
        if (z) {
            this.this$0.dequeueCommand();
            BleService bleService = this.this$0;
            String uuid = this.$aCharacteristicUuid.toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
            String uuid2 = this.$aServiceUuid.toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "toString(...)");
            bleService.sendFailedMsgWithUuid(4, uuid, uuid2);
        }
    }
}
