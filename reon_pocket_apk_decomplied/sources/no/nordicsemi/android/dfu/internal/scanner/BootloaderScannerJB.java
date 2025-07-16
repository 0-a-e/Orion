package no.nordicsemi.android.dfu.internal.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import no.nordicsemi.android.dfu.DfuDeviceSelector;

public class BootloaderScannerJB implements BootloaderScanner, BluetoothAdapter.LeScanCallback {
    private String mBootloaderAddress;
    private final String mDeviceAddress;
    private final String mDeviceAddressIncremented;
    private boolean mFound;
    private final Object mLock = new Object();
    private DfuDeviceSelector mSelector;

    BootloaderScannerJB(String str, String str2) {
        this.mDeviceAddress = str;
        this.mDeviceAddressIncremented = str2;
    }

    public String searchUsing(DfuDeviceSelector dfuDeviceSelector, long j) {
        this.mSelector = dfuDeviceSelector;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new BootloaderScannerJB$$ExternalSyntheticLambda0(this, j), "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12) {
            return null;
        }
        defaultAdapter.startLeScan(this);
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        defaultAdapter.stopLeScan(this);
        return this.mBootloaderAddress;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$searchUsing$0$no-nordicsemi-android-dfu-internal-scanner-BootloaderScannerJB  reason: not valid java name */
    public /* synthetic */ void m8654lambda$searchUsing$0$nonordicsemiandroiddfuinternalscannerBootloaderScannerJB(long j) {
        try {
            Thread.sleep(j);
        } catch (InterruptedException unused) {
        }
        if (!this.mFound) {
            this.mBootloaderAddress = null;
            this.mFound = true;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }

    public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        String address = bluetoothDevice.getAddress();
        if (!this.mFound) {
            if (this.mSelector.matches(bluetoothDevice, i, bArr, this.mDeviceAddress, this.mDeviceAddressIncremented)) {
                this.mBootloaderAddress = address;
                this.mFound = true;
                synchronized (this.mLock) {
                    this.mLock.notifyAll();
                }
            }
        }
    }
}
