package jp.co.sony.reon.android.ble.service;

import android.bluetooth.BluetoothGatt;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleService$mGattCallback$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ BluetoothGatt f$0;
    public final /* synthetic */ BleService f$1;

    public /* synthetic */ BleService$mGattCallback$1$$ExternalSyntheticLambda0(BluetoothGatt bluetoothGatt, BleService bleService) {
        this.f$0 = bluetoothGatt;
        this.f$1 = bleService;
    }

    public final void run() {
        BleService$mGattCallback$1.onConnectionStateChange$lambda$8(this.f$0, this.f$1);
    }
}
