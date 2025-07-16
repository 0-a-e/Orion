package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

class LegacyButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    static UUID DFU_CONTROL_POINT_UUID = LegacyDfuImpl.DEFAULT_DFU_CONTROL_POINT_UUID;
    static UUID DFU_SERVICE_UUID = LegacyDfuImpl.DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_VERSION_UUID = LegacyDfuImpl.DEFAULT_DFU_VERSION_UUID;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1, 4};
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private int mVersion;

    LegacyButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        int i;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        this.mProgressInfo.setProgress(-2);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_VERSION_UUID);
        if (characteristic2 != null) {
            i = readVersion(bluetoothGatt, characteristic2);
            this.mVersion = i;
            int i2 = i & 15;
            int i3 = i >> 8;
            logi("Version number read: " + i3 + InstructionFileId.DOT + i2 + " -> " + getVersionFeatures(i));
            DfuBaseService dfuBaseService = this.mService;
            StringBuilder sb = new StringBuilder("Version number read: ");
            sb.append(i3);
            sb.append(InstructionFileId.DOT);
            sb.append(i2);
            dfuBaseService.sendLogBroadcast(10, sb.toString());
        } else {
            logi("No DFU Version characteristic found -> " + getVersionFeatures(0));
            this.mService.sendLogBroadcast(10, "DFU Version characteristic not found");
            i = 0;
        }
        boolean z = PreferenceManager.getDefaultSharedPreferences(this.mService).getBoolean(DfuSettingsConstants.SETTINGS_ASSUME_DFU_NODE, false);
        if (intent.hasExtra(DfuBaseService.EXTRA_FORCE_DFU)) {
            z = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_DFU, false);
        }
        boolean z2 = bluetoothGatt.getServices().size() > 3;
        if (i == 0 && z2) {
            logi("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        if (i == 1 || (!z && i == 0 && z2)) {
            return true;
        }
        return false;
    }

    public void performDfu(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        logw("Application with legacy buttonless update found");
        this.mService.sendLogBroadcast(15, "Application with buttonless update found");
        boolean z = true;
        this.mService.sendLogBroadcast(1, "Jumping to the DFU Bootloader...");
        if (intent.hasExtra(DfuBaseService.EXTRA_MTU)) {
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_MTU, 517);
            logi("Requesting MTU = " + intExtra);
            requestMtu(intExtra);
        }
        enableCCCD(this.mControlPointCharacteristic, 1);
        this.mService.sendLogBroadcast(10, "Notifications enabled");
        this.mProgressInfo.setProgress(-3);
        logi("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_ENTER_BOOTLOADER, true);
        this.mService.sendLogBroadcast(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        BluetoothGatt bluetoothGatt = this.mGatt;
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_FORCE_SCANNING_FOR_BOOTLOADER_IN_LEGACY_DFU, false);
        if (booleanExtra || this.mVersion == 0) {
            this.mService.disconnect(bluetoothGatt);
        } else {
            this.mService.waitUntilDisconnected();
            this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        }
        logi("Device disconnected");
        if (!booleanExtra && this.mVersion != 0) {
            z = false;
        }
        finalize(intent, false, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int readVersion(android.bluetooth.BluetoothGatt r5, android.bluetooth.BluetoothGattCharacteristic r6) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r4 = this;
            boolean r0 = r4.mConnected
            if (r0 == 0) goto L_0x009a
            boolean r0 = r4.mAborted
            if (r0 != 0) goto L_0x0094
            r0 = 0
            if (r6 != 0) goto L_0x000c
            return r0
        L_0x000c:
            r1 = 0
            r4.mReceivedData = r1
            r4.mError = r0
            java.lang.String r1 = "Reading DFU version number..."
            r4.logi(r1)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r4.mService
            r2 = 1
            java.lang.String r3 = "Reading DFU version number..."
            r1.sendLogBroadcast(r2, r3)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "gatt.readCharacteristic("
            r2.<init>(r3)
            java.util.UUID r3 = r6.getUuid()
            r2.append(r3)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.sendLogBroadcast(r0, r2)
            r5.readCharacteristic(r6)
            java.lang.Object r5 = r4.mLock     // Catch:{ InterruptedException -> 0x0065 }
            monitor-enter(r5)     // Catch:{ InterruptedException -> 0x0065 }
        L_0x0040:
            boolean r6 = r4.mRequestCompleted     // Catch:{ all -> 0x0062 }
            if (r6 == 0) goto L_0x0048
            byte[] r6 = r4.mReceivedData     // Catch:{ all -> 0x0062 }
            if (r6 != 0) goto L_0x0054
        L_0x0048:
            boolean r6 = r4.mConnected     // Catch:{ all -> 0x0062 }
            if (r6 == 0) goto L_0x0054
            int r6 = r4.mError     // Catch:{ all -> 0x0062 }
            if (r6 != 0) goto L_0x0054
            boolean r6 = r4.mAborted     // Catch:{ all -> 0x0062 }
            if (r6 == 0) goto L_0x0058
        L_0x0054:
            boolean r6 = r4.mPaused     // Catch:{ all -> 0x0062 }
            if (r6 == 0) goto L_0x0060
        L_0x0058:
            r4.mRequestCompleted = r0     // Catch:{ all -> 0x0062 }
            java.lang.Object r6 = r4.mLock     // Catch:{ all -> 0x0062 }
            r6.wait()     // Catch:{ all -> 0x0062 }
            goto L_0x0040
        L_0x0060:
            monitor-exit(r5)     // Catch:{ all -> 0x0062 }
            goto L_0x006b
        L_0x0062:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0062 }
            throw r6     // Catch:{ InterruptedException -> 0x0065 }
        L_0x0065:
            r5 = move-exception
            java.lang.String r6 = "Sleeping interrupted"
            r4.loge(r6, r5)
        L_0x006b:
            boolean r5 = r4.mConnected
            if (r5 == 0) goto L_0x008c
            int r5 = r4.mError
            if (r5 != 0) goto L_0x0082
            byte[] r5 = r4.mReceivedData
            if (r5 == 0) goto L_0x0081
            int r6 = r5.length
            r1 = 2
            if (r6 >= r1) goto L_0x007c
            goto L_0x0081
        L_0x007c:
            int r5 = r4.getShort(r5, r0)
            return r5
        L_0x0081:
            return r0
        L_0x0082:
            no.nordicsemi.android.dfu.internal.exception.DfuException r5 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r6 = "Unable to read version number"
            int r0 = r4.mError
            r5.<init>(r6, r0)
            throw r5
        L_0x008c:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r6 = "Unable to read version number: device disconnected"
            r5.<init>(r6)
            throw r5
        L_0x0094:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        L_0x009a:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r6 = "Unable to read version number: device disconnected"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyButtonlessDfuImpl.readVersion(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic):int");
    }

    /* access modifiers changed from: protected */
    public int getShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
    }

    private String getVersionFeatures(int i) {
        if (i == 0) {
            return "Bootloader from SDK 6.1 or older";
        }
        if (i == 1) {
            return "Application with Legacy buttonless update from SDK 7.0 or newer";
        }
        if (i == 5) {
            return "Bootloader from SDK 7.0 or newer. No bond sharing";
        }
        if (i == 6) {
            return "Bootloader from SDK 8.0 or newer. Bond sharing supported";
        }
        if (i == 7) {
            return "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet";
        }
        if (i != 8) {
            return "Unknown version";
        }
        return "Bootloader from SDK 9.0 or newer. Signature supported";
    }
}
