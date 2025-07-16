package jp.co.sony.reonpocket.connection.log;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import java.util.List;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reonpocket.ReonPocketApplication;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"jp/co/sony/reonpocket/connection/log/DeviceCommManager$mScanCallback$1", "Landroid/bluetooth/le/ScanCallback;", "onBatchScanResults", "", "results", "", "Landroid/bluetooth/le/ScanResult;", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "result", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceCommManager.kt */
public final class DeviceCommManager$mScanCallback$1 extends ScanCallback {
    final /* synthetic */ DeviceCommManager this$0;

    DeviceCommManager$mScanCallback$1(DeviceCommManager deviceCommManager) {
        this.this$0 = deviceCommManager;
    }

    public void onScanFailed(int i) {
        super.onScanFailed(i);
        this.this$0.stopScan(ReonPocketApplication.Companion.getApplicationContext(), ReasonCodeConstant.DEVICE_NOT_FOUND);
    }

    public void onScanResult(int i, ScanResult scanResult) {
        super.onScanResult(i, scanResult);
        if (this.this$0.mScanning) {
            BluetoothDevice device = scanResult != null ? scanResult.getDevice() : null;
            if (device != null) {
                ScanRecord scanRecord = scanResult.getScanRecord();
                if (scanRecord != null) {
                    DeviceCommManager deviceCommManager = this.this$0;
                    byte[] bytes = scanRecord.getBytes();
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    if (deviceCommManager.isBeaconDevice(bytes)) {
                        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                        String address = device.getAddress();
                        debugLogUtil.e("AwsLog_DeviceCommManager", "scanned beacon device:" + address);
                        return;
                    }
                }
                this.this$0.handleActionScanConnect(ReonPocketApplication.Companion.getApplicationContext(), device);
            }
        }
    }

    public void onBatchScanResults(List<ScanResult> list) {
        super.onBatchScanResults(list);
    }
}
