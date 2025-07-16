package no.nordicsemi.android.dfu.internal.scanner;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuDeviceSelector;

class BootloaderScannerLollipop extends ScanCallback implements BootloaderScanner {
    private String mBootloaderAddress;
    private final String mDeviceAddress;
    private final String mDeviceAddressIncremented;
    private boolean mFound;
    private final Object mLock = new Object();
    private DfuDeviceSelector mSelector;

    BootloaderScannerLollipop(String str, String str2) {
        this.mDeviceAddress = str;
        this.mDeviceAddressIncremented = str2;
    }

    public String searchUsing(DfuDeviceSelector dfuDeviceSelector, long j) {
        BluetoothLeScanner bluetoothLeScanner;
        this.mSelector = dfuDeviceSelector;
        this.mBootloaderAddress = null;
        this.mFound = false;
        new Thread(new BootloaderScannerLollipop$$ExternalSyntheticLambda0(this, j), "Scanner timer").start();
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || defaultAdapter.getState() != 12 || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return null;
        }
        ScanSettings build = new ScanSettings.Builder().setScanMode(2).build();
        if (!defaultAdapter.isOffloadedFilteringSupported() || Build.VERSION.SDK_INT < 27) {
            bluetoothLeScanner.startScan((List) null, build, this);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new ScanFilter.Builder().build());
            bluetoothLeScanner.startScan(arrayList, build, this);
        }
        try {
            synchronized (this.mLock) {
                while (!this.mFound) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException unused) {
        }
        bluetoothLeScanner.stopScan(this);
        return this.mBootloaderAddress;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$searchUsing$0$no-nordicsemi-android-dfu-internal-scanner-BootloaderScannerLollipop  reason: not valid java name */
    public /* synthetic */ void m8655lambda$searchUsing$0$nonordicsemiandroiddfuinternalscannerBootloaderScannerLollipop(long j) {
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

    public void onScanResult(int i, ScanResult scanResult) {
        String address = scanResult.getDevice().getAddress();
        if (!this.mFound && this.mSelector.matches(scanResult.getDevice(), scanResult.getRssi(), scanResult.getScanRecord().getBytes(), this.mDeviceAddress, this.mDeviceAddressIncremented)) {
            this.mBootloaderAddress = address;
            this.mFound = true;
            synchronized (this.mLock) {
                this.mLock.notifyAll();
            }
        }
    }
}
