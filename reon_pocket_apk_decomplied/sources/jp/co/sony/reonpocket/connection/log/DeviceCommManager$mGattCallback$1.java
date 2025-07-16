package jp.co.sony.reonpocket.connection.log;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jp.co.sony.reon.android.ble.constant.ReasonCodeConstant;
import jp.co.sony.reonpocket.constant.BleActionCode;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J$\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0013"}, d2 = {"jp/co/sony/reonpocket/connection/log/DeviceCommManager$mGattCallback$1", "Landroid/bluetooth/BluetoothGattCallback;", "onCharacteristicChanged", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicRead", "status", "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWrite", "onServicesDiscovered", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceCommManager.kt */
public final class DeviceCommManager$mGattCallback$1 extends BluetoothGattCallback {
    final /* synthetic */ DeviceCommManager this$0;

    DeviceCommManager$mGattCallback$1(DeviceCommManager deviceCommManager) {
        this.this$0 = deviceCommManager;
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattService service;
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        byte[] bArr = null;
        UUID uuid = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null;
        String access$convertResultStateToString = this.this$0.convertResultStateToString(i);
        debugLogUtil.d("AwsLog_DeviceCommManager", "Uuid:" + uuid + ", status:" + access$convertResultStateToString);
        if (bluetoothGattCharacteristic != null) {
            DeviceCommManager deviceCommManager = this.this$0;
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            String access$parseData = deviceCommManager.parseData(bluetoothGattCharacteristic.getValue());
            debugLogUtil2.d("AwsLog_DeviceCommManager", "Value:" + access$parseData);
        }
        DeviceCommManager deviceCommManager2 = this.this$0;
        BleActionCode bleActionCode = BleActionCode.READ;
        String valueOf = String.valueOf((bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null) ? null : service.getUuid());
        String valueOf2 = String.valueOf(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null);
        if (bluetoothGattCharacteristic != null) {
            bArr = bluetoothGattCharacteristic.getValue();
        }
        deviceCommManager2.handleCommandResult(bleActionCode, i, valueOf, valueOf2, bArr);
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattService service;
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        byte[] bArr = null;
        UUID uuid = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null;
        String access$convertResultStateToString = this.this$0.convertResultStateToString(i);
        debugLogUtil.d("AwsLog_DeviceCommManager", "Uuid:" + uuid + ", status:" + access$convertResultStateToString);
        if (bluetoothGattCharacteristic != null) {
            DeviceCommManager deviceCommManager = this.this$0;
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            String access$parseData = deviceCommManager.parseData(bluetoothGattCharacteristic.getValue());
            debugLogUtil2.d("AwsLog_DeviceCommManager", "Value:" + access$parseData);
        }
        DeviceCommManager deviceCommManager2 = this.this$0;
        BleActionCode bleActionCode = BleActionCode.WRITE;
        String valueOf = String.valueOf((bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null) ? null : service.getUuid());
        String valueOf2 = String.valueOf(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null);
        if (bluetoothGattCharacteristic != null) {
            bArr = bluetoothGattCharacteristic.getValue();
        }
        deviceCommManager2.handleCommandResult(bleActionCode, i, valueOf, valueOf2, bArr);
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        BluetoothDevice device;
        BluetoothDevice device2;
        super.onServicesDiscovered(bluetoothGatt, i);
        String str = null;
        if (i != 0) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.d("AwsLog_DeviceCommManager", "Failed with status: " + i);
            DeviceCommManager.handleConnectError$default(this.this$0, (ReasonCodeConstant) null, 1, (Object) null);
            DeviceCommManager.doDisconnect$default(this.this$0, false, 1, (Object) null);
            return;
        }
        DebugLogUtil.INSTANCE.d("AwsLog_DeviceCommManager", "Services discovered");
        this.this$0.aServiceUuidList = new ArrayList();
        List<BluetoothGattService> services = bluetoothGatt != null ? bluetoothGatt.getServices() : null;
        if (services != null) {
            DeviceCommManager deviceCommManager = this.this$0;
            for (BluetoothGattService next : services) {
                if (next != null) {
                    deviceCommManager.aServiceUuidList.add(next.getUuid().toString());
                }
            }
        }
        this.this$0.mAddress = (bluetoothGatt == null || (device2 = bluetoothGatt.getDevice()) == null) ? null : device2.getAddress();
        DeviceCommManager deviceCommManager2 = this.this$0;
        if (!(bluetoothGatt == null || (device = bluetoothGatt.getDevice()) == null)) {
            str = device.getName();
        }
        deviceCommManager2.mDeviceName = str;
        DeviceCommManager deviceCommManager3 = this.this$0;
        deviceCommManager3.handleConnectSuccess(deviceCommManager3.aServiceUuidList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004a, code lost:
        r0 = (r0 = r10.getCharacteristic()).getService();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDescriptorWrite(android.bluetooth.BluetoothGatt r9, android.bluetooth.BluetoothGattDescriptor r10, int r11) {
        /*
            r8 = this;
            super.onDescriptorWrite(r9, r10, r11)
            jp.co.sony.reonpocket.util.DebugLogUtil r9 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            jp.co.sony.reonpocket.connection.log.DeviceCommManager r0 = r8.this$0
            java.lang.String r0 = r0.convertResultStateToString(r11)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "onDescriptorWrite status:"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "AwsLog_DeviceCommManager"
            r9.d((java.lang.String) r1, (java.lang.String) r0)
            if (r10 == 0) goto L_0x003d
            jp.co.sony.reonpocket.connection.log.DeviceCommManager r9 = r8.this$0
            jp.co.sony.reonpocket.util.DebugLogUtil r0 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            byte[] r2 = r10.getValue()
            java.lang.String r9 = r9.parseData(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Value:"
            r2.<init>(r3)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            r0.d((java.lang.String) r1, (java.lang.String) r9)
        L_0x003d:
            jp.co.sony.reonpocket.connection.log.DeviceCommManager r2 = r8.this$0
            jp.co.sony.reonpocket.constant.BleActionCode r3 = jp.co.sony.reonpocket.constant.BleActionCode.NOTIFY
            r9 = 0
            if (r10 == 0) goto L_0x0055
            android.bluetooth.BluetoothGattCharacteristic r0 = r10.getCharacteristic()
            if (r0 == 0) goto L_0x0055
            android.bluetooth.BluetoothGattService r0 = r0.getService()
            if (r0 == 0) goto L_0x0055
            java.util.UUID r0 = r0.getUuid()
            goto L_0x0056
        L_0x0055:
            r0 = r9
        L_0x0056:
            java.lang.String r5 = java.lang.String.valueOf(r0)
            if (r10 == 0) goto L_0x0067
            android.bluetooth.BluetoothGattCharacteristic r0 = r10.getCharacteristic()
            if (r0 == 0) goto L_0x0067
            java.util.UUID r0 = r0.getUuid()
            goto L_0x0068
        L_0x0067:
            r0 = r9
        L_0x0068:
            java.lang.String r6 = java.lang.String.valueOf(r0)
            if (r10 == 0) goto L_0x0078
            android.bluetooth.BluetoothGattCharacteristic r10 = r10.getCharacteristic()
            if (r10 == 0) goto L_0x0078
            byte[] r9 = r10.getValue()
        L_0x0078:
            r7 = r9
            r4 = r11
            r2.handleCommandResult(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.DeviceCommManager$mGattCallback$1.onDescriptorWrite(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattDescriptor, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        r0 = r10.getService();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCharacteristicChanged(android.bluetooth.BluetoothGatt r9, android.bluetooth.BluetoothGattCharacteristic r10) {
        /*
            r8 = this;
            super.onCharacteristicChanged(r9, r10)
            if (r10 == 0) goto L_0x0024
            jp.co.sony.reonpocket.connection.log.DeviceCommManager r9 = r8.this$0
            jp.co.sony.reonpocket.util.DebugLogUtil r0 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE
            byte[] r1 = r10.getValue()
            java.lang.String r9 = r9.parseData(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Data Value:"
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            java.lang.String r1 = "AwsLog_DeviceCommManager"
            r0.d((java.lang.String) r1, (java.lang.String) r9)
        L_0x0024:
            jp.co.sony.reonpocket.connection.log.DeviceCommManager r2 = r8.this$0
            jp.co.sony.reonpocket.constant.BleActionCode r3 = jp.co.sony.reonpocket.constant.BleActionCode.NOTIFY
            r9 = 0
            if (r10 == 0) goto L_0x0036
            android.bluetooth.BluetoothGattService r0 = r10.getService()
            if (r0 == 0) goto L_0x0036
            java.util.UUID r0 = r0.getUuid()
            goto L_0x0037
        L_0x0036:
            r0 = r9
        L_0x0037:
            java.lang.String r5 = java.lang.String.valueOf(r0)
            if (r10 == 0) goto L_0x0042
            java.util.UUID r0 = r10.getUuid()
            goto L_0x0043
        L_0x0042:
            r0 = r9
        L_0x0043:
            java.lang.String r6 = java.lang.String.valueOf(r0)
            if (r10 == 0) goto L_0x004d
            byte[] r9 = r10.getValue()
        L_0x004d:
            r7 = r9
            r4 = 0
            r2.handleCommandResult(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.DeviceCommManager$mGattCallback$1.onCharacteristicChanged(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic):void");
    }

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        DebugLogUtil.INSTANCE.d("AwsLog_DeviceCommManager", "onDescriptorRead");
    }

    public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
        BluetoothDevice device;
        super.onConnectionStateChange(bluetoothGatt, i, i2);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String access$convertResultStateToString = this.this$0.convertResultStateToString(i);
        String access$convertConnectStateToString = this.this$0.convertConnectStateToString(i2);
        debugLogUtil.d("AwsLog_DeviceCommManager", "Connection state changed with status:" + access$convertResultStateToString + " and new state: " + i2 + "(" + access$convertConnectStateToString + ")");
        String str = null;
        if (i == 0 && i2 == 2) {
            if (this.this$0.mDevice == null) {
                DebugLogUtil.INSTANCE.e("AwsLog_DeviceCommManager", "Device received notification after disconnection.");
                DebugLogUtil.INSTANCE.e("AwsLog_DeviceCommManager", "gatt.close()");
                if (bluetoothGatt != null) {
                    try {
                        bluetoothGatt.close();
                    } catch (Throwable unused) {
                    }
                }
            } else {
                this.this$0.mIsConnected = true;
                DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
                if (!(bluetoothGatt == null || (device = bluetoothGatt.getDevice()) == null)) {
                    str = device.getAddress();
                }
                debugLogUtil2.d("AwsLog_DeviceCommManager", "Connected to " + str);
                DebugLogUtil.INSTANCE.d("AwsLog_DeviceCommManager", "wait(1500)");
                this.this$0.mHandler.postDelayed(new DeviceCommManager$mGattCallback$1$$ExternalSyntheticLambda0(bluetoothGatt), 1500);
            }
        } else if (i2 == 0) {
            if (i == 0) {
                DebugLogUtil.INSTANCE.d("AwsLog_DeviceCommManager", "gatt disconnected");
            } else if (i == 8) {
                DebugLogUtil.INSTANCE.e("AwsLog_DeviceCommManager", "gatt conn timeout");
            } else if (i != 133) {
                DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
                debugLogUtil3.e("AwsLog_DeviceCommManager", "gatt unknown error code(" + i + ")");
            } else {
                DebugLogUtil.INSTANCE.e("AwsLog_DeviceCommManager", "gatt error");
            }
            if (this.this$0.mManualDisconnect) {
                DebugLogUtil.INSTANCE.d("AwsLog_DeviceCommManager", "user manual disconnected");
                this.this$0.mIsConnected = false;
                this.this$0.mManualDisconnect = false;
                this.this$0.handleConnectError(ReasonCodeConstant.MANUAL_DISCONNECT);
                this.this$0.close();
            } else if (this.this$0.mIsConnected) {
                this.this$0.mIsConnected = false;
                DebugLogUtil.INSTANCE.e("AwsLog_DeviceCommManager", "has exception, disconnected");
                this.this$0.handleConnectError(ReasonCodeConstant.CONNECT_EXCEPTION);
                this.this$0.close();
            } else {
                DebugLogUtil.INSTANCE.e("AwsLog_DeviceCommManager", "connect failed");
                DeviceCommManager.handleConnectError$default(this.this$0, (ReasonCodeConstant) null, 1, (Object) null);
                this.this$0.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onConnectionStateChange$lambda$6(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            DebugLogUtil.INSTANCE.d("AwsLog_DeviceCommManager", "Discovering services...");
            DebugLogUtil.INSTANCE.d("AwsLog_DeviceCommManager", "gatt.discoverServices()");
            bluetoothGatt.discoverServices();
        }
    }
}
