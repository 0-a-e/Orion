package jp.co.sony.reon.android.ble.service;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import jp.co.sony.reon.android.ble.util.BluetoothUtil;
import jp.co.sony.reon.android.ble.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"jp/co/sony/reon/android/ble/service/BleService$mBondingBroadcastReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleService.kt */
public final class BleService$mBondingBroadcastReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ BleService this$0;

    BleService$mBondingBroadcastReceiver$1(BleService bleService) {
        this.this$0 = bleService;
    }

    public void onReceive(Context context, Intent intent) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
        int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", -1);
        BluetoothDevice access$getMDevice$p = this.this$0.mDevice;
        if (access$getMDevice$p == null) {
            unit = null;
        } else if (bluetoothDevice != null && Intrinsics.areEqual((Object) bluetoothDevice.getAddress(), (Object) access$getMDevice$p.getAddress())) {
            unit = Unit.INSTANCE;
        } else {
            return;
        }
        if (unit != null) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String convertBondStateToString = BluetoothUtil.INSTANCE.convertBondStateToString(intExtra);
            debugLogUtil.v("BleService", "Bond state changed to: " + convertBondStateToString + "(" + intExtra + ")");
            switch (intExtra) {
                case 10:
                    if (intExtra2 == 11) {
                        DebugLogUtil.INSTANCE.e("BleService", "Bonding failed");
                        return;
                    } else if (intExtra2 == 12) {
                        DebugLogUtil.INSTANCE.e("BleService", "Bond information removed");
                        return;
                    } else {
                        return;
                    }
                case 11:
                    DebugLogUtil.INSTANCE.v("BleService", "Device bonding");
                    return;
                case 12:
                    DebugLogUtil.INSTANCE.v("BleService", "Device bonded");
                    if (!this.this$0.mServicesDiscovered && !this.this$0.mServiceDiscoveryRequested) {
                        this.this$0.mServiceDiscoveryRequested = true;
                        Handler access$getMHandler$p = this.this$0.mHandler;
                        if (access$getMHandler$p != null) {
                            access$getMHandler$p.post(new BleService$mBondingBroadcastReceiver$1$$ExternalSyntheticLambda0(this.this$0));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onReceive$lambda$2(BleService bleService) {
        Intrinsics.checkNotNullParameter(bleService, "this$0");
        DebugLogUtil.INSTANCE.v("BleService", "Discovering services...");
        DebugLogUtil.INSTANCE.v("BleService", "gatt.discoverServices()");
        BluetoothGatt access$getMBleGatt$p = bleService.mBleGatt;
        if (access$getMBleGatt$p != null) {
            access$getMBleGatt$p.discoverServices();
        }
    }
}
