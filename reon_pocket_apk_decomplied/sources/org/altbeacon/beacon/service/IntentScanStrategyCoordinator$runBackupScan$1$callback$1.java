package org.altbeacon.beacon.service;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.altbeacon.beacon.logging.LogManager;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"org/altbeacon/beacon/service/IntentScanStrategyCoordinator$runBackupScan$1$callback$1", "Landroid/bluetooth/le/ScanCallback;", "onBatchScanResults", "", "results", "", "Landroid/bluetooth/le/ScanResult;", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "result", "android-beacon-library_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: IntentScanStrategyCoordinator.kt */
public final class IntentScanStrategyCoordinator$runBackupScan$1$callback$1 extends ScanCallback {
    final /* synthetic */ BluetoothLeScanner $scanner;
    final /* synthetic */ IntentScanStrategyCoordinator$runBackupScan$1 this$0;

    IntentScanStrategyCoordinator$runBackupScan$1$callback$1(IntentScanStrategyCoordinator$runBackupScan$1 intentScanStrategyCoordinator$runBackupScan$1, BluetoothLeScanner bluetoothLeScanner) {
        this.this$0 = intentScanStrategyCoordinator$runBackupScan$1;
        this.$scanner = bluetoothLeScanner;
    }

    public void onScanResult(int i, ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "result");
        super.onScanResult(i, scanResult);
        ScanHelper access$getScanHelper$p = IntentScanStrategyCoordinator.access$getScanHelper$p(this.this$0.this$0);
        BluetoothDevice device = scanResult.getDevice();
        int rssi = scanResult.getRssi();
        ScanRecord scanRecord = scanResult.getScanRecord();
        access$getScanHelper$p.processScanResult(device, rssi, scanRecord != null ? scanRecord.getBytes() : null, scanResult.getTimestampNanos());
        try {
            this.$scanner.stopScan(this);
        } catch (IllegalStateException unused) {
        }
    }

    public void onBatchScanResults(List<ScanResult> list) {
        Intrinsics.checkNotNullParameter(list, "results");
        super.onBatchScanResults(list);
    }

    public void onScanFailed(int i) {
        super.onScanFailed(i);
        LogManager.d(IntentScanStrategyCoordinator.Companion.getTAG(), "Sending onScanFailed event", new Object[0]);
    }
}
