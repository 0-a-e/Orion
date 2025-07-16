package jp.co.sony.reon.android.ble.service;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jp.co.sony.reon.android.ble.util.BluetoothUtil;
import jp.co.sony.reon.android.ble.util.DebugLogUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J$\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0017J$\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J$\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0017J$\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0015"}, d2 = {"jp/co/sony/reon/android/ble/service/BleService$mGattCallback$1", "Landroid/bluetooth/BluetoothGattCallback;", "onCharacteristicChanged", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicRead", "status", "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWrite", "onMtuChanged", "mtu", "onServicesDiscovered", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleService.kt */
public final class BleService$mGattCallback$1 extends BluetoothGattCallback {
    final /* synthetic */ BleService this$0;

    BleService$mGattCallback$1(BleService bleService) {
        this.this$0 = bleService;
    }

    @Deprecated(message = "Deprecated in Java")
    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattService service;
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        byte[] bArr = null;
        UUID uuid = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null;
        String convertResultStateToString = BluetoothUtil.INSTANCE.convertResultStateToString(i);
        debugLogUtil.v("BleService", "Uuid:" + uuid + ", status:" + convertResultStateToString);
        if (bluetoothGattCharacteristic != null) {
            BleService bleService = this.this$0;
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            String access$parseData = bleService.parseData(bluetoothGattCharacteristic.getValue());
            debugLogUtil2.v("BleService", "Value:" + access$parseData);
        }
        Bundle bundle = new Bundle();
        bundle.putString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID, String.valueOf(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null));
        bundle.putString(BleService.KEY_ARGUMENT_SERVICE_UUID, String.valueOf((bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null) ? null : service.getUuid()));
        bundle.putInt(BleService.KEY_ARGUMENT_RESPONSE_CODE, i);
        if (i == 0) {
            if (bluetoothGattCharacteristic != null) {
                bArr = bluetoothGattCharacteristic.getValue();
            }
            bundle.putByteArray(BleService.KEY_ARGUMENT_NOTIFY_DATA, bArr);
            this.this$0.sendClientMessage(5, 0, bundle);
        } else {
            this.this$0.sendClientMessage(5, 1, bundle);
        }
        this.this$0.dequeueCommand();
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattService service;
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        UUID uuid = null;
        UUID uuid2 = bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null;
        String convertResultStateToString = BluetoothUtil.INSTANCE.convertResultStateToString(i);
        debugLogUtil.v("BleService", "Uuid:" + uuid2 + ", status:" + convertResultStateToString);
        if (bluetoothGattCharacteristic != null) {
            BleService bleService = this.this$0;
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            String access$parseData = bleService.parseData(bluetoothGattCharacteristic.getValue());
            debugLogUtil2.v("BleService", "Value:" + access$parseData);
        }
        Bundle bundle = new Bundle();
        bundle.putString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID, String.valueOf(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null));
        if (!(bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null)) {
            uuid = service.getUuid();
        }
        bundle.putString(BleService.KEY_ARGUMENT_SERVICE_UUID, String.valueOf(uuid));
        bundle.putInt(BleService.KEY_ARGUMENT_RESPONSE_CODE, i);
        if (i == 0) {
            this.this$0.sendClientMessage(6, 0, bundle);
        } else {
            this.this$0.sendClientMessage(6, 1, bundle);
        }
        this.this$0.dequeueCommand();
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        BluetoothDevice device;
        BluetoothDevice device2;
        super.onServicesDiscovered(bluetoothGatt, i);
        this.this$0.mServiceDiscoveryRequested = false;
        if (i != 0) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.v("BleService", "Failed with status: " + i);
            this.this$0.sendFailedMsg(2);
            boolean unused = this.this$0.disconnect();
            return;
        }
        DebugLogUtil.INSTANCE.v("BleService", "Services discovered");
        this.this$0.mServicesDiscovered = true;
        String str = null;
        List<BluetoothGattService> services = bluetoothGatt != null ? bluetoothGatt.getServices() : null;
        if (services != null) {
            BleService bleService = this.this$0;
            bleService.aServiceUuidList = new ArrayList();
            for (BluetoothGattService next : services) {
                if (next != null) {
                    ArrayList access$getAServiceUuidList$p = bleService.aServiceUuidList;
                    Intrinsics.checkNotNull(access$getAServiceUuidList$p);
                    access$getAServiceUuidList$p.add(next.getUuid().toString());
                }
            }
        }
        this.this$0.mAddress = (bluetoothGatt == null || (device2 = bluetoothGatt.getDevice()) == null) ? null : device2.getAddress();
        BleService bleService2 = this.this$0;
        if (!(bluetoothGatt == null || (device = bluetoothGatt.getDevice()) == null)) {
            str = device.getName();
        }
        bleService2.mDeviceName = str;
        Bundle bundle = new Bundle();
        bundle.putString(BleService.KEY_ARGUMENT_ADDRESS, this.this$0.mAddress);
        bundle.putString(BleService.KEY_ARGUMENT_DEVICE_NAME, this.this$0.mDeviceName);
        bundle.putStringArrayList(BleService.KEY_ARGUMENT_SERVICE_UUID_LIST, this.this$0.aServiceUuidList);
        this.this$0.sendClientMessage(2, 0, bundle);
    }

    public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
        super.onMtuChanged(bluetoothGatt, i, i2);
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.v("BleService", "Mtu changed to: " + i + " Status: " + i2);
        if (i2 == 0) {
            this.this$0.sendSuccessMsg(7);
        } else {
            this.this$0.sendFailedMsg(7);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0045, code lost:
        r1 = r6.getCharacteristic();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDescriptorWrite(android.bluetooth.BluetoothGatt r5, android.bluetooth.BluetoothGattDescriptor r6, int r7) {
        /*
            r4 = this;
            super.onDescriptorWrite(r5, r6, r7)
            jp.co.sony.reon.android.ble.util.DebugLogUtil r5 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            jp.co.sony.reon.android.ble.util.BluetoothUtil r0 = jp.co.sony.reon.android.ble.util.BluetoothUtil.INSTANCE
            java.lang.String r0 = r0.convertResultStateToString(r7)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "onDescriptorWrite status:"
            r1.<init>(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "BleService"
            r5.v(r1, r0)
            if (r6 == 0) goto L_0x003d
            jp.co.sony.reon.android.ble.service.BleService r5 = r4.this$0
            jp.co.sony.reon.android.ble.util.DebugLogUtil r0 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            byte[] r2 = r6.getValue()
            java.lang.String r5 = r5.parseData(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Value:"
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r0.v(r1, r5)
        L_0x003d:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r0 = 0
            if (r6 == 0) goto L_0x0050
            android.bluetooth.BluetoothGattCharacteristic r1 = r6.getCharacteristic()
            if (r1 == 0) goto L_0x0050
            java.util.UUID r1 = r1.getUuid()
            goto L_0x0051
        L_0x0050:
            r1 = r0
        L_0x0051:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "key_argument_characteristic_uuid"
            r5.putString(r2, r1)
            if (r6 == 0) goto L_0x006c
            android.bluetooth.BluetoothGattCharacteristic r6 = r6.getCharacteristic()
            if (r6 == 0) goto L_0x006c
            android.bluetooth.BluetoothGattService r6 = r6.getService()
            if (r6 == 0) goto L_0x006c
            java.util.UUID r0 = r6.getUuid()
        L_0x006c:
            java.lang.String r6 = java.lang.String.valueOf(r0)
            java.lang.String r0 = "key_argument_service_uuid"
            r5.putString(r0, r6)
            java.lang.String r6 = "key_argument_response_code"
            r5.putInt(r6, r7)
            r6 = 4
            if (r7 != 0) goto L_0x0084
            jp.co.sony.reon.android.ble.service.BleService r7 = r4.this$0
            r0 = 0
            r7.sendClientMessage(r6, r0, r5)
            goto L_0x008a
        L_0x0084:
            jp.co.sony.reon.android.ble.service.BleService r7 = r4.this$0
            r0 = 1
            r7.sendClientMessage(r6, r0, r5)
        L_0x008a:
            jp.co.sony.reon.android.ble.service.BleService r5 = r4.this$0
            r5.dequeueCommand()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.service.BleService$mGattCallback$1.onDescriptorWrite(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattDescriptor, int):void");
    }

    @Deprecated(message = "Deprecated in Java")
    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        if (!this.this$0.isReceivedNotifyDataFromWear) {
            this.this$0.isReceivedNotifyDataFromWear = true;
        }
        if (bluetoothGattCharacteristic != null) {
            BleService bleService = this.this$0;
            if (bleService.isSendDataToClient) {
                Bundle bundle = new Bundle();
                bundle.putInt(BleService.KEY_ARGUMENT_RESPONSE_CODE, 0);
                bundle.putString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID, bluetoothGattCharacteristic.getUuid().toString());
                bundle.putString(BleService.KEY_ARGUMENT_SERVICE_UUID, bluetoothGattCharacteristic.getService().getUuid().toString());
                bundle.putByteArray(BleService.KEY_ARGUMENT_NOTIFY_DATA, bluetoothGattCharacteristic.getValue());
                bleService.sendClientMessage(4, 0, bundle);
            }
        }
    }

    @Deprecated(message = "Deprecated in Java")
    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
        DebugLogUtil.INSTANCE.v("BleService", "onDescriptorRead");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x015b, code lost:
        r1 = r10.getDevice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConnectionStateChange(android.bluetooth.BluetoothGatt r10, int r11, int r12) {
        /*
            r9 = this;
            super.onConnectionStateChange(r10, r11, r12)
            jp.co.sony.reon.android.ble.util.DebugLogUtil r0 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            jp.co.sony.reon.android.ble.util.BluetoothUtil r1 = jp.co.sony.reon.android.ble.util.BluetoothUtil.INSTANCE
            java.lang.String r1 = r1.convertResultStateToString(r11)
            jp.co.sony.reon.android.ble.util.BluetoothUtil r2 = jp.co.sony.reon.android.ble.util.BluetoothUtil.INSTANCE
            java.lang.String r2 = r2.convertConnectStateToString(r12)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Connection state changed with status:"
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " and new state: "
            r3.append(r1)
            r3.append(r12)
            java.lang.String r1 = "("
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = ")"
            r3.append(r1)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "BleService"
            r0.v(r3, r2)
            r0 = 1
            r2 = 2
            r4 = 0
            if (r11 != 0) goto L_0x00c5
            if (r12 != r2) goto L_0x00c5
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            android.bluetooth.BluetoothDevice r11 = r11.mDevice
            if (r11 != 0) goto L_0x005c
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r12 = "Device received notification after disconnection."
            r11.e(r3, r12)
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r12 = "gatt.close()"
            r11.e(r3, r12)
            if (r10 == 0) goto L_0x005b
            r10.close()     // Catch:{ all -> 0x005b }
        L_0x005b:
            return
        L_0x005c:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            if (r10 == 0) goto L_0x006a
            android.bluetooth.BluetoothDevice r12 = r10.getDevice()
            if (r12 == 0) goto L_0x006a
            java.lang.String r4 = r12.getAddress()
        L_0x006a:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r2 = "Connected to "
            r12.<init>(r2)
            r12.append(r4)
            java.lang.String r12 = r12.toString()
            r11.v(r3, r12)
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            r11.mIsConnected = r0
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            boolean r11 = r11.mServiceDiscoveryRequested
            if (r11 != 0) goto L_0x0244
            r11 = 500(0x1f4, float:7.0E-43)
            if (r10 == 0) goto L_0x009a
            android.bluetooth.BluetoothDevice r12 = r10.getDevice()
            int r12 = r12.getBondState()
            r0 = 12
            if (r12 != r0) goto L_0x009a
            r11 = 1500(0x5dc, float:2.102E-42)
        L_0x009a:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r12 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "wait("
            r0.<init>(r2)
            r0.append(r11)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r12.v(r3, r0)
            jp.co.sony.reon.android.ble.service.BleService r12 = r9.this$0
            android.os.Handler r12 = r12.mHandler
            if (r12 == 0) goto L_0x0244
            jp.co.sony.reon.android.ble.service.BleService r0 = r9.this$0
            jp.co.sony.reon.android.ble.service.BleService$mGattCallback$1$$ExternalSyntheticLambda0 r1 = new jp.co.sony.reon.android.ble.service.BleService$mGattCallback$1$$ExternalSyntheticLambda0
            r1.<init>(r10, r0)
            long r10 = (long) r11
            r12.postDelayed(r1, r10)
            goto L_0x0244
        L_0x00c5:
            if (r12 != 0) goto L_0x0244
            java.lang.String r12 = "getDevice(...)"
            r5 = 3
            r6 = 0
            if (r11 == 0) goto L_0x01ba
            r7 = 8
            if (r11 == r7) goto L_0x01b2
            r7 = 19
            if (r11 == r7) goto L_0x01aa
            r7 = 22
            java.lang.String r8 = "getAddress(...)"
            if (r11 == r7) goto L_0x0180
            r7 = 133(0x85, float:1.86E-43)
            if (r11 == r7) goto L_0x00f7
            jp.co.sony.reon.android.ble.util.DebugLogUtil r0 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "gatt unknown error code("
            r4.<init>(r7)
            r4.append(r11)
            r4.append(r1)
            java.lang.String r11 = r4.toString()
            r0.e(r3, r11)
            goto L_0x01c1
        L_0x00f7:
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            int r11 = r11.mConnectRetryCount
            if (r11 >= r5) goto L_0x0138
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            int r1 = r11.mConnectRetryCount
            int r1 = r1 + r0
            r11.mConnectRetryCount = r1
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            jp.co.sony.reon.android.ble.service.BleService r0 = r9.this$0
            int r0 = r0.mConnectRetryCount
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "gatt error, retry "
            r1.<init>(r4)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.d((java.lang.String) r3, (java.lang.String) r0)
            if (r10 == 0) goto L_0x01c1
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            r11.mIsConnected = r6
            android.bluetooth.BluetoothDevice r10 = r10.getDevice()
            java.lang.String r10 = r10.getAddress()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r8)
            r11.connect(r10)
            return
        L_0x0138:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            jp.co.sony.reon.android.ble.service.BleService r0 = r9.this$0
            int r0 = r0.mConnectRetryCount
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r7 = "gatt error, retry count "
            r1.<init>(r7)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.e(r3, r0)
            jp.co.sony.reon.android.ble.util.CrashlyticsUtil r11 = jp.co.sony.reon.android.ble.util.CrashlyticsUtil.INSTANCE
            jp.co.sony.reon.android.ble.service.BleService r0 = r9.this$0
            java.lang.String r0 = r0.mOwnerId
            if (r10 == 0) goto L_0x0166
            android.bluetooth.BluetoothDevice r1 = r10.getDevice()
            if (r1 == 0) goto L_0x0166
            java.lang.String r1 = r1.getName()
            goto L_0x0167
        L_0x0166:
            r1 = r4
        L_0x0167:
            java.lang.String r7 = "null"
            if (r1 != 0) goto L_0x016c
            r1 = r7
        L_0x016c:
            if (r10 == 0) goto L_0x0178
            android.bluetooth.BluetoothDevice r8 = r10.getDevice()
            if (r8 == 0) goto L_0x0178
            java.lang.String r4 = r8.getAddress()
        L_0x0178:
            if (r4 != 0) goto L_0x017b
            goto L_0x017c
        L_0x017b:
            r7 = r4
        L_0x017c:
            r11.sendGattStatus133Exception(r0, r1, r7)
            goto L_0x01c1
        L_0x0180:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "gatt conn terminate local host"
            r11.e(r3, r0)
            if (r10 == 0) goto L_0x01c1
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            android.bluetooth.BluetoothDevice r0 = r10.getDevice()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)
            boolean r0 = r11.removeBond(r0)
            if (r0 == 0) goto L_0x01c1
            r11.mIsConnected = r6
            android.bluetooth.BluetoothDevice r10 = r10.getDevice()
            java.lang.String r10 = r10.getAddress()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r8)
            r11.connect(r10)
            return
        L_0x01aa:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "gatt conn terminate peer user"
            r11.e(r3, r0)
            goto L_0x01c1
        L_0x01b2:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "gatt conn timeout"
            r11.e(r3, r0)
            goto L_0x01c1
        L_0x01ba:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "gatt disconnected"
            r11.d((java.lang.String) r3, (java.lang.String) r0)
        L_0x01c1:
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            r11.mServicesDiscovered = r6
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            r11.mServiceDiscoveryRequested = r6
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            boolean r11 = r11.mManualDisconnect
            if (r11 == 0) goto L_0x01ef
            jp.co.sony.reon.android.ble.util.DebugLogUtil r10 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r11 = "user manual disconnected"
            r10.v(r3, r11)
            jp.co.sony.reon.android.ble.service.BleService r10 = r9.this$0
            r10.mIsConnected = r6
            jp.co.sony.reon.android.ble.service.BleService r10 = r9.this$0
            r10.mManualDisconnect = r6
            jp.co.sony.reon.android.ble.service.BleService r10 = r9.this$0
            r10.sendSuccessMsg(r5)
            jp.co.sony.reon.android.ble.service.BleService r10 = r9.this$0
            r10.close()
            return
        L_0x01ef:
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            boolean r11 = r11.mIsConnected
            if (r11 == 0) goto L_0x0233
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            r11.mIsConnected = r6
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            boolean r11 = r11.mHasRequestDFU
            if (r11 == 0) goto L_0x021f
            jp.co.sony.reon.android.ble.util.DebugLogUtil r11 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r0 = "request dfu, disconnected"
            r11.e(r3, r0)
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            r11.mHasRequestDFU = r6
            if (r10 == 0) goto L_0x0226
            jp.co.sony.reon.android.ble.service.BleService r11 = r9.this$0
            android.bluetooth.BluetoothDevice r10 = r10.getDevice()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            boolean unused = r11.removeBond(r10)
            goto L_0x0226
        L_0x021f:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r10 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r11 = "has exception, disconnected"
            r10.e(r3, r11)
        L_0x0226:
            jp.co.sony.reon.android.ble.service.BleService r10 = r9.this$0
            r11 = 10
            r10.sendFailedMsg(r11)
            jp.co.sony.reon.android.ble.service.BleService r10 = r9.this$0
            r10.close()
            goto L_0x0244
        L_0x0233:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r10 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r11 = "connect failed"
            r10.e(r3, r11)
            jp.co.sony.reon.android.ble.service.BleService r10 = r9.this$0
            r10.sendFailedMsg(r2)
            jp.co.sony.reon.android.ble.service.BleService r10 = r9.this$0
            r10.close()
        L_0x0244:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.service.BleService$mGattCallback$1.onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void onConnectionStateChange$lambda$8(BluetoothGatt bluetoothGatt, BleService bleService) {
        Intrinsics.checkNotNullParameter(bleService, "this$0");
        if (bluetoothGatt != null && bleService.mIsConnected && bluetoothGatt.getDevice().getBondState() != 11) {
            bleService.mServiceDiscoveryRequested = true;
            DebugLogUtil.INSTANCE.v("BleService", "Discovering services...");
            DebugLogUtil.INSTANCE.v("BleService", "gatt.discoverServices()");
            bluetoothGatt.discoverServices();
        }
    }
}
