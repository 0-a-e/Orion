package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import no.nordicsemi.android.dfu.BaseDfuImpl;

abstract class BaseButtonlessDfuImpl extends BaseDfuImpl {
    private final ButtonlessBluetoothCallback mBluetoothCallback = new ButtonlessBluetoothCallback();

    protected class ButtonlessBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        protected ButtonlessBluetoothCallback() {
            super();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            DfuBaseService dfuBaseService = BaseButtonlessDfuImpl.this.mService;
            dfuBaseService.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
            BaseButtonlessDfuImpl.this.mReceivedData = bluetoothGattCharacteristic.getValue();
            BaseButtonlessDfuImpl.this.notifyLock();
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            BaseButtonlessDfuImpl.this.mRequestCompleted = true;
            BaseButtonlessDfuImpl.this.notifyLock();
        }
    }

    BaseButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    /* access modifiers changed from: package-private */
    public void finalize(Intent intent, boolean z, boolean z2) {
        boolean z3 = false;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        DfuBaseService dfuBaseService = this.mService;
        BluetoothGatt bluetoothGatt = this.mGatt;
        if (z || !booleanExtra) {
            z3 = true;
        }
        dfuBaseService.refreshDeviceCache(bluetoothGatt, z3);
        this.mService.close(this.mGatt);
        logi("Restarting to bootloader mode");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, z2);
    }
}
