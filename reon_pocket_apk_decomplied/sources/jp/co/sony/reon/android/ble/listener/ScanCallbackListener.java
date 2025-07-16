package jp.co.sony.reon.android.ble.listener;

import android.bluetooth.BluetoothDevice;
import java.util.List;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, d2 = {"Ljp/co/sony/reon/android/ble/listener/ScanCallbackListener;", "", "onScanFailed", "", "aReason", "Ljp/co/sony/reon/android/ble/constant/ReasonCodeConstant;", "onScanSuccess", "aBleDeviceList", "", "Landroid/bluetooth/BluetoothDevice;", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ScanCallbackListener.kt */
public interface ScanCallbackListener {
    void onScanFailed(ReasonCodeConstant reasonCodeConstant);

    void onScanSuccess(List<BluetoothDevice> list);
}
