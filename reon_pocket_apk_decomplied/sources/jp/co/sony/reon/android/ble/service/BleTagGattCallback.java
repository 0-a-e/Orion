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
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\"\u0010\u0012\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0017J$\u0010\u0014\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0017\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ljp/co/sony/reon/android/ble/service/BleTagGattCallback;", "Landroid/bluetooth/BluetoothGattCallback;", "bleServiceCallback", "Ljp/co/sony/reon/android/ble/service/ReceiveBleTagGattCallback;", "(Ljp/co/sony/reon/android/ble/service/ReceiveBleTagGattCallback;)V", "mServiceDiscoveryRequested", "", "mServicesDiscovered", "onCharacteristicChanged", "", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "onCharacteristicRead", "status", "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onDescriptorRead", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onDescriptorWrite", "onServicesDiscovered", "reon-ble_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BleTagGattCallback.kt */
public final class BleTagGattCallback extends BluetoothGattCallback {
    private final ReceiveBleTagGattCallback bleServiceCallback;
    private boolean mServiceDiscoveryRequested;
    private boolean mServicesDiscovered;

    public BleTagGattCallback(ReceiveBleTagGattCallback receiveBleTagGattCallback) {
        Intrinsics.checkNotNullParameter(receiveBleTagGattCallback, "bleServiceCallback");
        this.bleServiceCallback = receiveBleTagGattCallback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0040, code lost:
        r9 = r7.getDevice();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConnectionStateChange(android.bluetooth.BluetoothGatt r7, int r8, int r9) {
        /*
            r6 = this;
            super.onConnectionStateChange(r7, r8, r9)
            jp.co.sony.reon.android.ble.util.DebugLogUtil r0 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            jp.co.sony.reon.android.ble.util.BluetoothUtil r1 = jp.co.sony.reon.android.ble.util.BluetoothUtil.INSTANCE
            java.lang.String r1 = r1.convertResultStateToString(r8)
            jp.co.sony.reon.android.ble.util.BluetoothUtil r2 = jp.co.sony.reon.android.ble.util.BluetoothUtil.INSTANCE
            java.lang.String r2 = r2.convertConnectStateToString(r9)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Connection state changed with status:"
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = " and new state: "
            r3.append(r1)
            r3.append(r9)
            java.lang.String r1 = "("
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = ")"
            r3.append(r1)
            java.lang.String r2 = r3.toString()
            r0.v(r2)
            if (r8 != 0) goto L_0x0070
            r0 = 2
            if (r9 != r0) goto L_0x0070
            jp.co.sony.reon.android.ble.util.DebugLogUtil r8 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            if (r7 == 0) goto L_0x004b
            android.bluetooth.BluetoothDevice r9 = r7.getDevice()
            if (r9 == 0) goto L_0x004b
            java.lang.String r9 = r9.getAddress()
            goto L_0x004c
        L_0x004b:
            r9 = 0
        L_0x004c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Connected to "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r8.v(r9)
            if (r7 == 0) goto L_0x00e8
            android.bluetooth.BluetoothDevice r8 = r7.getDevice()
            int r8 = r8.getBondState()
            r9 = 11
            if (r8 == r9) goto L_0x00e8
            r7.discoverServices()
            goto L_0x00e8
        L_0x0070:
            if (r9 != 0) goto L_0x00e8
            if (r8 == 0) goto L_0x00d1
            r7 = 8
            if (r8 == r7) goto L_0x00c9
            r7 = 19
            if (r8 == r7) goto L_0x00c1
            r7 = 22
            if (r8 == r7) goto L_0x00ae
            r7 = 133(0x85, float:1.86E-43)
            if (r8 == r7) goto L_0x009b
            jp.co.sony.reon.android.ble.util.DebugLogUtil r7 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "gatt unknown error code("
            r9.<init>(r0)
            r9.append(r8)
            r9.append(r1)
            java.lang.String r8 = r9.toString()
            r7.e(r8)
            goto L_0x00d8
        L_0x009b:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r7 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r8 = "gatt error"
            r7.e(r8)
            jp.co.sony.reon.android.ble.service.ReceiveBleTagGattCallback r0 = r6.bleServiceCallback
            r4 = 4
            r5 = 0
            r1 = 17
            r2 = 0
            r3 = 0
            jp.co.sony.reon.android.ble.service.ReceiveBleTagGattCallback.DefaultImpls.onSend$default(r0, r1, r2, r3, r4, r5)
            return
        L_0x00ae:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r7 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r8 = "gatt conn terminate local host"
            r7.e(r8)
            jp.co.sony.reon.android.ble.service.ReceiveBleTagGattCallback r0 = r6.bleServiceCallback
            r4 = 4
            r5 = 0
            r1 = 16
            r2 = 0
            r3 = 0
            jp.co.sony.reon.android.ble.service.ReceiveBleTagGattCallback.DefaultImpls.onSend$default(r0, r1, r2, r3, r4, r5)
            return
        L_0x00c1:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r7 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r8 = "gatt conn terminate peer user"
            r7.e(r8)
            goto L_0x00d8
        L_0x00c9:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r7 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r8 = "gatt conn timeout"
            r7.e(r8)
            goto L_0x00d8
        L_0x00d1:
            jp.co.sony.reon.android.ble.util.DebugLogUtil r7 = jp.co.sony.reon.android.ble.util.DebugLogUtil.INSTANCE
            java.lang.String r8 = "gatt disconnected"
            r7.d(r8)
        L_0x00d8:
            r7 = 0
            r6.mServicesDiscovered = r7
            r6.mServiceDiscoveryRequested = r7
            jp.co.sony.reon.android.ble.service.ReceiveBleTagGattCallback r0 = r6.bleServiceCallback
            r4 = 4
            r5 = 0
            r1 = 15
            r2 = 1
            r3 = 0
            jp.co.sony.reon.android.ble.service.ReceiveBleTagGattCallback.DefaultImpls.onSend$default(r0, r1, r2, r3, r4, r5)
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reon.android.ble.service.BleTagGattCallback.onConnectionStateChange(android.bluetooth.BluetoothGatt, int, int):void");
    }

    public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
        BluetoothDevice device;
        BluetoothDevice device2;
        super.onServicesDiscovered(bluetoothGatt, i);
        this.mServiceDiscoveryRequested = false;
        this.mServicesDiscovered = true;
        ArrayList arrayList = new ArrayList();
        String str = null;
        List<BluetoothGattService> services = bluetoothGatt != null ? bluetoothGatt.getServices() : null;
        if (services != null) {
            for (BluetoothGattService next : services) {
                if (next != null) {
                    arrayList.add(next.getUuid().toString());
                }
            }
        }
        String address = (bluetoothGatt == null || (device2 = bluetoothGatt.getDevice()) == null) ? null : device2.getAddress();
        if (!(bluetoothGatt == null || (device = bluetoothGatt.getDevice()) == null)) {
            str = device.getName();
        }
        Bundle bundle = new Bundle();
        bundle.putString(BleService.KEY_ARGUMENT_ADDRESS, address);
        bundle.putString(BleService.KEY_ARGUMENT_DEVICE_NAME, str);
        bundle.putStringArrayList(BleService.KEY_ARGUMENT_SERVICE_UUID_LIST, arrayList);
        this.bleServiceCallback.onSend(13, 0, bundle);
    }

    public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        super.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, i);
    }

    public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
        BluetoothGattService service;
        super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
        Bundle bundle = new Bundle();
        UUID uuid = null;
        bundle.putString(BleService.KEY_ARGUMENT_CHARACTERISTIC_UUID, String.valueOf(bluetoothGattCharacteristic != null ? bluetoothGattCharacteristic.getUuid() : null));
        if (!(bluetoothGattCharacteristic == null || (service = bluetoothGattCharacteristic.getService()) == null)) {
            uuid = service.getUuid();
        }
        bundle.putString(BleService.KEY_ARGUMENT_SERVICE_UUID, String.valueOf(uuid));
        bundle.putInt(BleService.KEY_ARGUMENT_RESPONSE_CODE, i);
        if (i == 0) {
            this.bleServiceCallback.onSend(14, 0, bundle);
        } else {
            this.bleServiceCallback.onSend(14, 1, bundle);
        }
    }

    public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
    }

    public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
    }

    public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
        super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i);
    }
}
