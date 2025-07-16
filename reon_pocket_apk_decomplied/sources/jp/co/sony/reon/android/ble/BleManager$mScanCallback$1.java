package jp.co.sony.reon.android.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.util.SparseArray;
import java.util.List;
import jp.co.sony.reon.android.ble.BleManager;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reon.android.ble.listener.TagScanCallbackListener;
import jp.co.sony.reon.android.ble.listener.TagScanNoReceivingCallbackListener;
import jp.co.sony.reon.android.ble.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0017¨\u0006\r"}, d2 = {"jp/co/sony/reon/android/ble/BleManager$mScanCallback$1", "Landroid/bluetooth/le/ScanCallback;", "onBatchScanResults", "", "results", "", "Landroid/bluetooth/le/ScanResult;", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "result", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleManager.kt */
public final class BleManager$mScanCallback$1 extends ScanCallback {
    final /* synthetic */ BleManager this$0;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BleManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                jp.co.sony.reon.android.ble.BleManager$Action[] r0 = jp.co.sony.reon.android.ble.BleManager.Action.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reon.android.ble.BleManager$Action r1 = jp.co.sony.reon.android.ble.BleManager.Action.NONE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                jp.co.sony.reon.android.ble.BleManager$Action r1 = jp.co.sony.reon.android.ble.BleManager.Action.RSSI_SCAN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                jp.co.sony.reon.android.ble.BleManager$Action r1 = jp.co.sony.reon.android.ble.BleManager.Action.SCAN_CONNECT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                jp.co.sony.reon.android.ble.BleManager$Action r1 = jp.co.sony.reon.android.ble.BleManager.Action.SCAN_TAG     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                jp.co.sony.reon.android.ble.BleManager$Action r1 = jp.co.sony.reon.android.ble.BleManager.Action.SCAN_TAG_NO_RECEIVING     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                jp.co.sony.reon.android.ble.BleManager$Action r1 = jp.co.sony.reon.android.ble.BleManager.Action.SCAN_CONNECT_TAG     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.BleManager$mScanCallback$1.WhenMappings.<clinit>():void");
        }
    }

    BleManager$mScanCallback$1(BleManager bleManager) {
        this.this$0 = bleManager;
    }

    public void onScanFailed(int i) {
        super.onScanFailed(i);
        this.this$0.isCalledScanCallback = true;
        this.this$0.stopScan(ReasonCodeConstant.DEVICE_NOT_FOUND);
    }

    public void onScanResult(int i, ScanResult scanResult) {
        Unit unit;
        SparseArray<byte[]> manufacturerSpecificData;
        List access$asArrayList;
        byte[] bArr;
        TagScanCallbackListener access$getMTagScanCallbackListener$cp;
        SparseArray<byte[]> manufacturerSpecificData2;
        List access$asArrayList2;
        byte[] bArr2;
        TagScanNoReceivingCallbackListener access$getMTagScanNoReceivingCallbackListener$cp;
        super.onScanResult(i, scanResult);
        this.this$0.isCalledScanCallback = true;
        if (this.this$0.mScanning || this.this$0.mTagNoReceivingScanning) {
            Unit unit2 = null;
            BluetoothDevice device = scanResult != null ? scanResult.getDevice() : null;
            if (device != null) {
                ScanRecord scanRecord = scanResult.getScanRecord();
                if (scanRecord != null) {
                    BleManager bleManager = this.this$0;
                    byte[] bytes = scanRecord.getBytes();
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    if (bleManager.isBeaconDevice(bytes) && bleManager.mCurrentAction != BleManager.Action.SCAN_TAG) {
                        DebugLogUtil.INSTANCE.e("BleManager", "scanned beacon device:" + device.getAddress());
                        return;
                    }
                }
                switch (WhenMappings.$EnumSwitchMapping$0[this.this$0.mCurrentAction.ordinal()]) {
                    case 1:
                        this.this$0.handleActionNone(device);
                        return;
                    case 2:
                        this.this$0.handleActionRssiScan(scanResult);
                        return;
                    case 3:
                        if (this.this$0.mWantConnectedDeviceAddress != null) {
                            this.this$0.handleActionScanConnectWithAddress(device);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BleManager bleManager2 = this.this$0;
                            if (bleManager2.mScanDfuDeviceNameFilterArray != null) {
                                bleManager2.handleActionScanConnectDfu(device);
                                unit2 = Unit.INSTANCE;
                            }
                            if (unit2 == null) {
                                bleManager2.handleActionScanConnect(device);
                                return;
                            }
                            return;
                        }
                        return;
                    case 4:
                        this.this$0.stopScan(ReasonCodeConstant.NONE);
                        if (scanRecord != null && (manufacturerSpecificData = scanRecord.getManufacturerSpecificData()) != null && (access$asArrayList = BleManagerKt.asArrayList(manufacturerSpecificData)) != null && (bArr = (byte[]) access$asArrayList.get(0)) != null && (access$getMTagScanCallbackListener$cp = BleManager.mTagScanCallbackListener) != null) {
                            String address = device.getAddress();
                            Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                            String name = device.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            access$getMTagScanCallbackListener$cp.onScanSuccess(address, name, bArr);
                            return;
                        }
                        return;
                    case 5:
                        if (!this.this$0.mScanning) {
                            this.this$0.stopScan(ReasonCodeConstant.NONE);
                            if (scanRecord != null && (manufacturerSpecificData2 = scanRecord.getManufacturerSpecificData()) != null && (access$asArrayList2 = BleManagerKt.asArrayList(manufacturerSpecificData2)) != null && (bArr2 = (byte[]) access$asArrayList2.get(0)) != null && (access$getMTagScanNoReceivingCallbackListener$cp = BleManager.mTagScanNoReceivingCallbackListener) != null) {
                                access$getMTagScanNoReceivingCallbackListener$cp.onScanSuccess(bArr2);
                                return;
                            }
                            return;
                        }
                        return;
                    case 6:
                        if (this.this$0.mScanning) {
                            if (this.this$0.mScanDfuTagNameFilterArray != null) {
                                BleManager bleManager3 = this.this$0;
                                DebugLogUtil.INSTANCE.e("Ble Interactor: onScanResult");
                                bleManager3.handleActionScanConnectDfuTag(device);
                                unit2 = Unit.INSTANCE;
                            }
                            if (unit2 == null) {
                                BleManager bleManager4 = this.this$0;
                                bleManager4.stopScan(ReasonCodeConstant.NONE);
                                DebugLogUtil.INSTANCE.e("Ble Interactor: onScanResult");
                                String address2 = device.getAddress();
                                Intrinsics.checkNotNull(address2);
                                bleManager4.executeConnectTag(address2);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void onBatchScanResults(List<ScanResult> list) {
        super.onBatchScanResults(list);
    }
}
