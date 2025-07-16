package jp.co.sony.reonpocket.connection.log;

import android.bluetooth.BluetoothGatt;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceCommManager$mGattCallback$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ BluetoothGatt f$0;

    public /* synthetic */ DeviceCommManager$mGattCallback$1$$ExternalSyntheticLambda0(BluetoothGatt bluetoothGatt) {
        this.f$0 = bluetoothGatt;
    }

    public final void run() {
        DeviceCommManager$mGattCallback$1.onConnectionStateChange$lambda$6(this.f$0);
    }
}
