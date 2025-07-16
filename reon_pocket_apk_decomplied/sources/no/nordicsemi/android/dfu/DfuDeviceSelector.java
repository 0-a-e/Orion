package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;

public interface DfuDeviceSelector {
    boolean matches(BluetoothDevice bluetoothDevice, int i, byte[] bArr, String str, String str2);
}
