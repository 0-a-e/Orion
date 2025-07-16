package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;

class DfuDefaultDeviceSelector implements DfuDeviceSelector {
    DfuDefaultDeviceSelector() {
    }

    public boolean matches(BluetoothDevice bluetoothDevice, int i, byte[] bArr, String str, String str2) {
        return str.equals(bluetoothDevice.getAddress()) || str2.equals(bluetoothDevice.getAddress());
    }
}
