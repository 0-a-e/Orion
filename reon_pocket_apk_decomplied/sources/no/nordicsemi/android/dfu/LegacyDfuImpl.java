package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

class LegacyDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static final UUID DEFAULT_DFU_VERSION_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    static UUID DFU_VERSION_UUID = null;
    private static final byte[] OP_CODE_ACTIVATE_AND_RESET = {5};
    private static final int OP_CODE_ACTIVATE_AND_RESET_KEY = 5;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS = {2};
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_COMPLETE = {2, 1};
    private static final int OP_CODE_INIT_DFU_PARAMS_KEY = 2;
    private static final byte[] OP_CODE_INIT_DFU_PARAMS_START = {2, 0};
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_KEY = 17;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ = {8, 0, 0};
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 8;
    private static final byte[] OP_CODE_RECEIVE_FIRMWARE_IMAGE = {3};
    private static final int OP_CODE_RECEIVE_FIRMWARE_IMAGE_KEY = 3;
    private static final byte[] OP_CODE_RESET = {6};
    private static final int OP_CODE_RESET_KEY = 6;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 16;
    private static final byte[] OP_CODE_START_DFU = {1, 0};
    private static final int OP_CODE_START_DFU_KEY = 1;
    private static final byte[] OP_CODE_START_DFU_V1 = {1};
    private static final byte[] OP_CODE_VALIDATE = {4};
    private static final int OP_CODE_VALIDATE_KEY = 4;
    private final LegacyBluetoothCallback mBluetoothCallback = new LegacyBluetoothCallback();
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    /* access modifiers changed from: private */
    public boolean mImageSizeInProgress;
    private BluetoothGattCharacteristic mPacketCharacteristic;

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        DEFAULT_DFU_VERSION_UUID = uuid4;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
        DFU_VERSION_UUID = uuid4;
    }

    protected class LegacyBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected LegacyBluetoothCallback() {
            super();
        }

        /* access modifiers changed from: protected */
        public void onPacketCharacteristicWrite() {
            if (LegacyDfuImpl.this.mImageSizeInProgress) {
                LegacyDfuImpl.this.mImageSizeInProgress = false;
            }
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            if ((bArr[0] & 255) == 17) {
                LegacyDfuImpl.this.mProgressInfo.setBytesReceived(getInt(bArr, 1));
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            } else if (!LegacyDfuImpl.this.mRemoteErrorOccurred) {
                if ((bArr[2] & 255) != 1) {
                    LegacyDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            }
            LegacyDfuImpl.this.notifyLock();
        }
    }

    LegacyDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    public boolean isClientCompatible(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(DFU_SERVICE_UUID);
        if (service == null || (characteristic = service.getCharacteristic(DFU_CONTROL_POINT_UUID)) == null || characteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG) == null) {
            return false;
        }
        this.mControlPointCharacteristic = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(DFU_PACKET_UUID);
        this.mPacketCharacteristic = characteristic2;
        if (characteristic2 != null) {
            return true;
        }
        return false;
    }

    public BaseCustomDfuImpl.BaseCustomBluetoothCallback getGattCallback() {
        return this.mBluetoothCallback;
    }

    /* access modifiers changed from: protected */
    public UUID getControlPointCharacteristicUUID() {
        return DFU_CONTROL_POINT_UUID;
    }

    /* access modifiers changed from: protected */
    public UUID getPacketCharacteristicUUID() {
        return DFU_PACKET_UUID;
    }

    /* access modifiers changed from: protected */
    public UUID getDfuServiceUUID() {
        return DFU_SERVICE_UUID;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x031d, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0323, code lost:
        if (r3.getErrorNumber() != 3) goto L_0x063f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0326, code lost:
        if (r5 == 4) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0328, code lost:
        r1.mRemoteErrorOccurred = false;
        r3 = r21;
        logw(r3);
        r1.mService.sendLogBroadcast(15, r3);
        r1.mService.sendLogBroadcast(1, "Switching to DFU v.1");
        logi("Resending Start DFU command (Op Code = 1)");
        writeOpCode(r1.mControlPointCharacteristic, OP_CODE_START_DFU_V1);
        r1.mService.sendLogBroadcast(10, "DFU Start sent (Op Code = 1)");
        logi(r22 + r1.mImageSizeInBytes + " bytes");
        writeImageSize(r1.mPacketCharacteristic, r1.mImageSizeInBytes);
        r3 = r1.mService;
        r3.sendLogBroadcast(10, r27 + r1.mImageSizeInBytes + " bytes)");
        r3 = readNotificationResponse();
        r6 = getStatusCode(r3, 1);
        r7 = r1.mService;
        r8 = new java.lang.StringBuilder("Response received (Op Code = ");
        r8.append(r3[1]);
        r3 = r20;
        r8.append(r3);
        r8.append(r6);
        r8.append(")");
        r7.sendLogBroadcast(10, r8.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x03b9, code lost:
        if (r6 == 2) goto L_0x03bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x03bb, code lost:
        resetAndRestart(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03be, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x03c0, code lost:
        if (r6 == 1) goto L_0x03c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03c2, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x063d, code lost:
        throw new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException(r12, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x063e, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x063f, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x065a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x065b, code lost:
        r32 = "Reset request sent";
        r33 = "Sending Reset command (Op Code = 6)";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x06bb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x06bc, code lost:
        r5 = "Reset request sent";
        r2 = "Sending Reset command (Op Code = 6)";
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x06ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x06eb, code lost:
        r5 = "Reset request sent";
        r2 = "Sending Reset command (Op Code = 6)";
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0204, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0205, code lost:
        r3 = r0;
        r12 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0218, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x021a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x021b, code lost:
        r2 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x021e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0221, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0224, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0225, code lost:
        r12 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0227, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x022d, code lost:
        if (r3.getErrorNumber() != 3) goto L_0x0315;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x022f, code lost:
        if (r31 <= 0) goto L_0x0312;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0235, code lost:
        r1.mRemoteErrorOccurred = false;
        r3 = r27;
        logw(r3);
        r1.mService.sendLogBroadcast(15, r3);
        r5 = r5 & -5;
        r1.mFileType = r5;
        r3 = OP_CODE_START_DFU;
        r3[1] = (byte) r5;
        r1.mProgressInfo.setTotalPart(2);
        ((no.nordicsemi.android.dfu.internal.ArchiveInputStream) r1.mFirmwareStream).setContentType(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x025f, code lost:
        r27 = "Firmware image size sent (";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        r1.mService.sendLogBroadcast(1, "Sending only SD/BL");
        logi(r26 + r5 + ")");
        writeOpCode(r1.mControlPointCharacteristic, r3);
        r3 = r1.mService;
        r3.sendLogBroadcast(10, "DFU Start sent (Op Code = 1, Upload Mode = " + r5 + ")");
        r3 = new java.lang.StringBuilder(r25);
        r3.append(r13);
        r3.append("b, ");
        r3.append(r6);
        r7 = r24;
        r3.append(r7);
        logi(r3.toString());
        writeImageSize(r1.mPacketCharacteristic, r13, r6, 0);
        r3 = r1.mService;
        r3.sendLogBroadcast(10, r23 + r13 + "b, " + r6 + r7);
        r3 = readNotificationResponse();
        r7 = getStatusCode(r3, 1);
        r8 = r1.mService;
        r8.sendLogBroadcast(10, "Response received (Op Code = " + r3[1] + " Status = " + r7 + ")");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02fe, code lost:
        if (r7 == 2) goto L_0x0300;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0300, code lost:
        resetAndRestart(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0303, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0305, code lost:
        if (r7 != 1) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0311, code lost:
        throw new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException(r12, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0312, code lost:
        r27 = "Firmware image size sent (";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0314, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0315, code lost:
        r27 = "Firmware image size sent (";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0317, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0318, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x031a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x031b, code lost:
        r27 = "Firmware image size sent (";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0325 A[Catch:{ DeviceDisconnectedException -> 0x0630, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03c7 A[Catch:{ DeviceDisconnectedException -> 0x0630, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0470 A[Catch:{ DeviceDisconnectedException -> 0x0630, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0482 A[Catch:{ DeviceDisconnectedException -> 0x0630, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0544 A[Catch:{ DeviceDisconnectedException -> 0x0630, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0628 A[Catch:{ DeviceDisconnectedException -> 0x0630, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x063f A[Catch:{ DeviceDisconnectedException -> 0x0630, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x065a A[ExcHandler: RemoteDfuException (e no.nordicsemi.android.dfu.internal.exception.RemoteDfuException), Splitter:B:11:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x021e A[ExcHandler: UnknownResponseException (e no.nordicsemi.android.dfu.internal.exception.UnknownResponseException), Splitter:B:46:0x0155] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0221 A[ExcHandler: UploadAbortedException (e no.nordicsemi.android.dfu.internal.exception.UploadAbortedException), Splitter:B:46:0x0155] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x022f A[Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0315 A[Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performDfu(android.content.Intent r37) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r36 = this;
            r1 = r36
            r2 = r37
            java.lang.String r3 = "DFU target does not support DFU v.2"
            java.lang.String r4 = "DFU target does not support (SD/BL)+App update"
            java.lang.String r5 = "Starting DFU failed"
            java.lang.String r6 = "Reset request sent"
            java.lang.String r7 = "Sending Reset command (Op Code = 6)"
            java.lang.String r8 = ", Status = "
            java.lang.String r9 = "b, "
            java.lang.String r10 = ")"
            java.lang.String r11 = "Response received (Op Code = "
            java.lang.String r12 = "Upload completed in "
            java.lang.String r13 = "Transfer of "
            java.lang.String r14 = "Packet Receipt Notif Req (Op Code = 8) sent (Value = "
            java.lang.String r15 = "Sending the number of packets before notifications (Op Code = 8, Value = "
            r16 = r12
            java.lang.String r12 = "b, 0b]"
            r17 = r13
            java.lang.String r13 = "Firmware image size sent ["
            r18 = r14
            java.lang.String r14 = "Sending image size array to DFU Packet: ["
            r19 = r15
            java.lang.String r15 = "Firmware image size sent ("
            r20 = r8
            java.lang.String r8 = "DFU Start sent (Op Code = 1, Upload Mode = "
            r21 = r3
            java.lang.String r3 = "Sending application image size to DFU Packet: "
            r22 = r3
            java.lang.String r3 = "Sending image size array to DFU Packet ("
            r23 = r13
            java.lang.String r13 = "Resending Start DFU command (Op Code = 1, Upload Mode = "
            r24 = r12
            java.lang.String r12 = "Sending Start DFU command (Op Code = 1, Upload Mode = "
            r25 = r14
            java.lang.String r14 = "Legacy DFU bootloader found"
            r1.logw(r14)
            no.nordicsemi.android.dfu.DfuProgressInfo r14 = r1.mProgressInfo
            r26 = r13
            r13 = -2
            r14.setProgress(r13)
            java.lang.String r13 = "no.nordicsemi.android.dfu.extra.EXTRA_MTU"
            boolean r14 = r2.hasExtra(r13)
            if (r14 == 0) goto L_0x0076
            r14 = 517(0x205, float:7.24E-43)
            int r13 = r2.getIntExtra(r13, r14)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r27 = r4
            java.lang.String r4 = "Requesting MTU = "
            r14.<init>(r4)
            r14.append(r13)
            java.lang.String r4 = r14.toString()
            r1.logi(r4)
            r1.requestMtu(r13)
            goto L_0x0078
        L_0x0076:
            r27 = r4
        L_0x0078:
            android.bluetooth.BluetoothGatt r4 = r1.mGatt
            java.util.UUID r13 = DFU_SERVICE_UUID
            android.bluetooth.BluetoothGattService r13 = r4.getService(r13)
            java.util.UUID r14 = DFU_VERSION_UUID
            android.bluetooth.BluetoothGattCharacteristic r13 = r13.getCharacteristic(r14)
            int r13 = r1.readVersion(r13)
            r14 = 5
            r28 = r5
            r5 = 20
            if (r13 < r14) goto L_0x00b5
            java.io.InputStream r14 = r1.mInitPacketStream
            if (r14 != 0) goto L_0x00b5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Init packet not set for the DFU Bootloader version "
            r2.<init>(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r1.logw(r2)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            java.lang.String r3 = "The Init packet is required by this version DFU Bootloader"
            r2.sendLogBroadcast(r5, r3)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            r3 = 4107(0x100b, float:5.755E-42)
            r2.terminateConnection(r4, r3)
            return
        L_0x00b5:
            r14 = 1
            android.bluetooth.BluetoothGattCharacteristic r5 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x06ea, UnknownResponseException -> 0x06bb, RemoteDfuException -> 0x065a }
            r1.enableCCCD(r5, r14)     // Catch:{ UploadAbortedException -> 0x064e, UnknownResponseException -> 0x0642, RemoteDfuException -> 0x065a }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ UploadAbortedException -> 0x064e, UnknownResponseException -> 0x0642, RemoteDfuException -> 0x065a }
            java.lang.String r14 = "Notifications enabled"
            r30 = r13
            r13 = 10
            r5.sendLogBroadcast(r13, r14)     // Catch:{ UploadAbortedException -> 0x064e, UnknownResponseException -> 0x0642, RemoteDfuException -> 0x065a }
            int r5 = r1.mFileType     // Catch:{ UploadAbortedException -> 0x064e, UnknownResponseException -> 0x0642, RemoteDfuException -> 0x065a }
            r13 = r5 & 1
            if (r13 <= 0) goto L_0x00e3
            int r13 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            goto L_0x00e4
        L_0x00cf:
            r0 = move-exception
            r2 = r0
            r32 = r6
            r33 = r7
            goto L_0x0660
        L_0x00d7:
            r0 = move-exception
            r3 = r0
            r5 = r6
            r2 = r7
            goto L_0x06bf
        L_0x00dd:
            r0 = move-exception
            r3 = r0
            r5 = r6
            r2 = r7
            goto L_0x06ee
        L_0x00e3:
            r13 = 0
        L_0x00e4:
            r14 = r5 & 2
            if (r14 <= 0) goto L_0x00eb
            int r14 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            goto L_0x00ec
        L_0x00eb:
            r14 = 0
        L_0x00ec:
            r31 = r5 & 4
            if (r31 <= 0) goto L_0x00f7
            r32 = r13
            int r13 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            r33 = r13
            goto L_0x00fb
        L_0x00f7:
            r32 = r13
            r33 = 0
        L_0x00fb:
            java.io.InputStream r13 = r1.mFirmwareStream     // Catch:{ UploadAbortedException -> 0x064e, UnknownResponseException -> 0x0642, RemoteDfuException -> 0x065a }
            boolean r13 = r13 instanceof no.nordicsemi.android.dfu.internal.ArchiveInputStream     // Catch:{ UploadAbortedException -> 0x064e, UnknownResponseException -> 0x0642, RemoteDfuException -> 0x065a }
            if (r13 == 0) goto L_0x014c
            java.io.InputStream r13 = r1.mFirmwareStream     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r13 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r13     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            boolean r14 = r13.isSecureDfuRequired()     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            if (r14 == 0) goto L_0x0132
            java.lang.String r2 = "Secure DFU is required to upload selected firmware"
            r1.loge(r2)     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            java.lang.String r3 = "The device does not support given firmware."
            r5 = 20
            r2.sendLogBroadcast(r5, r3)     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            r1.logi(r7)     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            byte[] r3 = OP_CODE_RESET     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            r1.writeOpCode(r2, r3)     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            r3 = 10
            r2.sendLogBroadcast(r3, r6)     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            r3 = 4099(0x1003, float:5.744E-42)
            r2.terminateConnection(r4, r3)     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            return
        L_0x0132:
            int r14 = r13.softDeviceImageSize()     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            int r32 = r13.bootloaderImageSize()     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            int r13 = r13.applicationImageSize()     // Catch:{ UploadAbortedException -> 0x00dd, UnknownResponseException -> 0x00d7, RemoteDfuException -> 0x00cf }
            r33 = r7
            r34 = r32
            r32 = r6
            r6 = r34
            r35 = r14
            r14 = r13
            r13 = r35
            goto L_0x0155
        L_0x014c:
            r13 = r32
            r32 = r6
            r6 = r14
            r14 = r33
            r33 = r7
        L_0x0155:
            byte[] r7 = OP_CODE_START_DFU     // Catch:{ RemoteDfuException -> 0x0224, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            byte r2 = (byte) r5
            r29 = 1
            r7[r29] = r2     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.<init>(r12)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.append(r5)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.append(r10)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r2 = r2.toString()     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r1.logi(r2)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r1.writeOpCode(r2, r7)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.<init>(r8)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.append(r5)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.append(r10)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r7 = r7.toString()     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r12 = 10
            r2.sendLogBroadcast(r12, r7)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.<init>(r3)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.append(r13)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.append(r9)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.append(r6)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.append(r9)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2.append(r14)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r3 = "b)"
            r2.append(r3)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r2 = r2.toString()     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r1.logi(r2)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mPacketCharacteristic     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r1.writeImageSize(r2, r13, r6, r14)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.<init>(r15)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.append(r13)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.append(r9)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.append(r6)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.append(r9)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.append(r14)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r7 = "b)"
            r3.append(r7)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r3 = r3.toString()     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7 = 10
            r2.sendLogBroadcast(r7, r3)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            byte[] r2 = r36.readNotificationResponse()     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3 = 1
            int r7 = r1.getStatusCode(r2, r3)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuBaseService r12 = r1.mService     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14.<init>(r11)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            byte r2 = r2[r3]     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14.append(r2)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r2 = " Status = "
            r14.append(r2)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14.append(r7)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14.append(r10)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r2 = r14.toString()     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3 = 10
            r12.sendLogBroadcast(r3, r2)     // Catch:{ RemoteDfuException -> 0x021a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r2 = 2
            if (r7 != r2) goto L_0x0209
            r2 = r37
            r1.resetAndRestart(r4, r2)     // Catch:{ RemoteDfuException -> 0x0204, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            return
        L_0x0204:
            r0 = move-exception
            r3 = r0
            r12 = r28
            goto L_0x0228
        L_0x0209:
            r2 = r37
            r3 = 1
            if (r7 != r3) goto L_0x0210
            goto L_0x0307
        L_0x0210:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r3 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ RemoteDfuException -> 0x0224, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r12 = r28
            r3.<init>(r12, r7)     // Catch:{ RemoteDfuException -> 0x0218, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            throw r3     // Catch:{ RemoteDfuException -> 0x0218, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
        L_0x0218:
            r0 = move-exception
            goto L_0x0227
        L_0x021a:
            r0 = move-exception
            r2 = r37
            goto L_0x0225
        L_0x021e:
            r0 = move-exception
            goto L_0x0647
        L_0x0221:
            r0 = move-exception
            goto L_0x0653
        L_0x0224:
            r0 = move-exception
        L_0x0225:
            r12 = r28
        L_0x0227:
            r3 = r0
        L_0x0228:
            int r7 = r3.getErrorNumber()     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14 = 3
            if (r7 != r14) goto L_0x0315
            if (r31 <= 0) goto L_0x0312
            r7 = r5 & 3
            if (r7 <= 0) goto L_0x0312
            r7 = 0
            r1.mRemoteErrorOccurred = r7     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3 = r27
            r1.logw(r3)     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuBaseService r7 = r1.mService     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14 = 15
            r7.sendLogBroadcast(r14, r3)     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r5 = r5 & -5
            r1.mFileType = r5     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            byte[] r3 = OP_CODE_START_DFU     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            byte r7 = (byte) r5     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14 = 1
            r3[r14] = r7     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuProgressInfo r7 = r1.mProgressInfo     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14 = 2
            r7.setTotalPart(r14)     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.io.InputStream r7 = r1.mFirmwareStream     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r7 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r7     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.setContentType(r5)     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuBaseService r7 = r1.mService     // Catch:{ RemoteDfuException -> 0x031a, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r14 = "Sending only SD/BL"
            r27 = r15
            r15 = 1
            r7.sendLogBroadcast(r15, r14)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14 = r26
            r7.<init>(r14)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.append(r5)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.append(r10)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r7 = r7.toString()     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r1.logi(r7)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            android.bluetooth.BluetoothGattCharacteristic r7 = r1.mControlPointCharacteristic     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r1.writeOpCode(r7, r3)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.<init>(r8)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.append(r5)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7.append(r10)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r7 = r7.toString()     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r8 = 10
            r3.sendLogBroadcast(r8, r7)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7 = r25
            r3.<init>(r7)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.append(r13)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.append(r9)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.append(r6)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7 = r24
            r3.append(r7)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r3 = r3.toString()     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r1.logi(r3)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            android.bluetooth.BluetoothGattCharacteristic r3 = r1.mPacketCharacteristic     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r8 = 0
            r1.writeImageSize(r3, r13, r6, r8)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r14 = r23
            r8.<init>(r14)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r8.append(r13)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r8.append(r9)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r8.append(r6)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r8.append(r7)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r6 = r8.toString()     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r7 = 10
            r3.sendLogBroadcast(r7, r6)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            byte[] r3 = r36.readNotificationResponse()     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r6 = 1
            int r7 = r1.getStatusCode(r3, r6)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            no.nordicsemi.android.dfu.DfuBaseService r8 = r1.mService     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r9.<init>(r11)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            byte r3 = r3[r6]     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r9.append(r3)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r3 = " Status = "
            r9.append(r3)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r9.append(r7)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r9.append(r10)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            java.lang.String r3 = r9.toString()     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r6 = 10
            r8.sendLogBroadcast(r6, r3)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3 = 2
            if (r7 != r3) goto L_0x0304
            r1.resetAndRestart(r4, r2)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            return
        L_0x0304:
            r3 = 1
            if (r7 != r3) goto L_0x030c
        L_0x0307:
            r3 = r20
            r5 = 1
            goto L_0x03c3
        L_0x030c:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r3 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            r3.<init>(r12, r7)     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
            throw r3     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
        L_0x0312:
            r27 = r15
            throw r3     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
        L_0x0315:
            r27 = r15
            throw r3     // Catch:{ RemoteDfuException -> 0x0318, UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e }
        L_0x0318:
            r0 = move-exception
            goto L_0x031d
        L_0x031a:
            r0 = move-exception
            r27 = r15
        L_0x031d:
            r3 = r0
            int r6 = r3.getErrorNumber()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7 = 3
            if (r6 != r7) goto L_0x063f
            r6 = 4
            if (r5 != r6) goto L_0x063e
            r5 = 0
            r1.mRemoteErrorOccurred = r5     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r3 = r21
            r1.logw(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6 = 15
            r5.sendLogBroadcast(r6, r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = "Switching to DFU v.1"
            r6 = 1
            r3.sendLogBroadcast(r6, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r3 = "Resending Start DFU command (Op Code = 1)"
            r1.logi(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r3 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r5 = OP_CODE_START_DFU_V1     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeOpCode(r3, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = "DFU Start sent (Op Code = 1)"
            r6 = 10
            r3.sendLogBroadcast(r6, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r5 = r22
            r3.<init>(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            int r5 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r3.append(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = " bytes"
            r3.append(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r3 = r3.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.logi(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r3 = r1.mPacketCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            int r5 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeImageSize(r3, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6 = r27
            r5.<init>(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            int r6 = r1.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r5.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = " bytes)"
            r5.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = r5.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6 = 10
            r3.sendLogBroadcast(r6, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r3 = r36.readNotificationResponse()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r5 = 1
            int r6 = r1.getStatusCode(r3, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r7 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.<init>(r11)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte r3 = r3[r5]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.append(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r3 = r20
            r8.append(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.append(r10)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = r8.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8 = 10
            r7.sendLogBroadcast(r8, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r5 = 2
            if (r6 != r5) goto L_0x03bf
            r1.resetAndRestart(r4, r2)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            return
        L_0x03bf:
            r5 = 1
            if (r6 != r5) goto L_0x0638
            r5 = 0
        L_0x03c3:
            java.io.InputStream r6 = r1.mInitPacketStream     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            if (r6 == 0) goto L_0x046e
            no.nordicsemi.android.dfu.DfuBaseService r6 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r7 = "Writing Initialize DFU Parameters..."
            r8 = 10
            r6.sendLogBroadcast(r8, r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = "Sending "
            if (r5 == 0) goto L_0x0412
            java.lang.String r7 = "Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)"
            r1.logi(r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r7 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r8 = OP_CODE_INIT_DFU_PARAMS_START     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeOpCode(r7, r8)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.<init>(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            int r6 = r1.mInitPacketSizeInBytes     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = " bytes of init packet"
            r7.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = r7.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.logi(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r6 = r1.mPacketCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7 = 0
            r1.writeInitData(r6, r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = "Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)"
            r1.logi(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r6 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r7 = OP_CODE_INIT_DFU_PARAMS_COMPLETE     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeOpCode(r6, r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r6 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r7 = "Initialize DFU Parameters completed"
            r8 = 10
            r6.sendLogBroadcast(r8, r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            goto L_0x043a
        L_0x0412:
            java.lang.String r7 = "Sending the Initialize DFU Parameters (Op Code = 2)"
            r1.logi(r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r7 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r8 = OP_CODE_INIT_DFU_PARAMS     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeOpCode(r7, r8)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.<init>(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            int r6 = r1.mInitPacketSizeInBytes     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = " bytes of init packet"
            r7.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = r7.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.logi(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r6 = r1.mPacketCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7 = 0
            r1.writeInitData(r6, r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x043a:
            byte[] r6 = r36.readNotificationResponse()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7 = 2
            int r8 = r1.getStatusCode(r6, r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r7 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9.<init>(r11)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r12 = 1
            byte r6 = r6[r12]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9.append(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9.append(r8)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9.append(r10)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = r9.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9 = 10
            r7.sendLogBroadcast(r9, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6 = 1
            if (r8 != r6) goto L_0x0466
            goto L_0x046e
        L_0x0466:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r2 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r3 = "Device returned error after sending init packet"
            r2.<init>(r3, r8)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            throw r2     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x046e:
            if (r5 != 0) goto L_0x047e
            int r5 = r1.mPacketsBeforeNotification     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            if (r5 <= 0) goto L_0x047b
            int r5 = r1.mPacketsBeforeNotification     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6 = 10
            if (r5 > r6) goto L_0x047b
            goto L_0x047e
        L_0x047b:
            r5 = 10
            goto L_0x0480
        L_0x047e:
            int r5 = r1.mPacketsBeforeNotification     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x0480:
            if (r5 <= 0) goto L_0x04ba
            r1.mPacketsBeforeNotification = r5     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7 = r19
            r6.<init>(r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6.append(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6.append(r10)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = r6.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.logi(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r6 = OP_CODE_PACKET_RECEIPT_NOTIF_REQ     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.setNumberOfPackets(r6, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r7 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeOpCode(r7, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r6 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8 = r18
            r7.<init>(r8)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r10)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = r7.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7 = 10
            r6.sendLogBroadcast(r7, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x04ba:
            java.lang.String r5 = "Sending Receive Firmware Image request (Op Code = 3)"
            r1.logi(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r5 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r6 = OP_CODE_RECEIVE_FIRMWARE_IMAGE     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeOpCode(r5, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = "Receive Firmware Image request sent"
            r7 = 10
            r5.sendLogBroadcast(r7, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuProgressInfo r7 = r1.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8 = 0
            r7.setBytesSent(r8)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r7 = "Uploading firmware..."
            r1.logi(r7)     // Catch:{ DeviceDisconnectedException -> 0x0630 }
            no.nordicsemi.android.dfu.DfuBaseService r7 = r1.mService     // Catch:{ DeviceDisconnectedException -> 0x0630 }
            java.lang.String r8 = "Uploading firmware..."
            r9 = 10
            r7.sendLogBroadcast(r9, r8)     // Catch:{ DeviceDisconnectedException -> 0x0630 }
            android.bluetooth.BluetoothGattCharacteristic r7 = r1.mPacketCharacteristic     // Catch:{ DeviceDisconnectedException -> 0x0630 }
            r1.uploadFirmwareImage(r7)     // Catch:{ DeviceDisconnectedException -> 0x0630 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r9 = r36.readNotificationResponse()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r12 = 3
            int r12 = r1.getStatusCode(r9, r12)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r13.<init>(r11)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14 = 0
            byte r15 = r9[r14]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r13.append(r15)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r14 = ", Req Op Code = "
            r13.append(r14)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14 = 1
            byte r15 = r9[r14]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r13.append(r15)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r13.append(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14 = 2
            byte r15 = r9[r14]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r13.append(r15)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r13.append(r10)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r13 = r13.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.logi(r13)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r13 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14.<init>(r11)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r15 = 1
            byte r9 = r9[r15]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14.append(r9)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14.append(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14.append(r12)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14.append(r10)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r9 = r14.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r14 = 10
            r13.sendLogBroadcast(r14, r9)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9 = 1
            if (r12 != r9) goto L_0x0628
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r12 = r17
            r9.<init>(r12)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuProgressInfo r12 = r1.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            int r12 = r12.getBytesSent()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9.append(r12)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r12 = " bytes has taken "
            r9.append(r12)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            long r7 = r7 - r5
            r9.append(r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = " ms"
            r9.append(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = r9.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.logi(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9 = r16
            r6.<init>(r9)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6.append(r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r7 = " ms"
            r6.append(r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = r6.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7 = 10
            r5.sendLogBroadcast(r7, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = "Sending Validate request (Op Code = 4)"
            r1.logi(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r5 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r6 = OP_CODE_VALIDATE     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeOpCode(r5, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r6 = "Validate request sent"
            r7 = 10
            r5.sendLogBroadcast(r7, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r5 = r36.readNotificationResponse()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r6 = 4
            int r6 = r1.getStatusCode(r5, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.<init>(r11)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8 = 0
            byte r9 = r5[r8]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r9)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r8 = ", Req Op Code = "
            r7.append(r8)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8 = 1
            byte r9 = r5[r8]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r9)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8 = 2
            byte r8 = r5[r8]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r8)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r7.append(r10)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r7 = r7.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.logi(r7)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r7 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.<init>(r11)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r9 = 1
            byte r5 = r5[r9]     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.append(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.append(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.append(r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r8.append(r10)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r3 = r8.toString()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r5 = 10
            r7.sendLogBroadcast(r5, r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r3 = 1
            if (r6 != r3) goto L_0x0620
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r1.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r5 = -5
            r3.setProgress(r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r3 = "Sending Activate and Reset request (Op Code = 5)"
            r1.logi(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            android.bluetooth.BluetoothGattCharacteristic r3 = r1.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            byte[] r5 = OP_CODE_ACTIVATE_AND_RESET     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r1.writeOpCode(r3, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = "Activate and Reset request sent"
            r6 = 10
            r3.sendLogBroadcast(r6, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r3.waitUntilDisconnected()     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r5 = "Disconnected by the remote device"
            r6 = 5
            r3.sendLogBroadcast(r6, r5)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r3 = r30
            if (r3 != r6) goto L_0x061a
            r3 = 1
            goto L_0x061b
        L_0x061a:
            r3 = 0
        L_0x061b:
            r1.finalize(r2, r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            goto L_0x06e9
        L_0x0620:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r2 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r3 = "Device returned validation error"
            r2.<init>(r3, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            throw r2     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x0628:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r2 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            java.lang.String r3 = "Device returned error after sending file"
            r2.<init>(r3, r12)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            throw r2     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x0630:
            r0 = move-exception
            r2 = r0
            java.lang.String r3 = "Disconnected while sending data"
            r1.loge(r3)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            throw r2     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x0638:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r2 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            r2.<init>(r12, r6)     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
            throw r2     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x063e:
            throw r3     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x063f:
            throw r3     // Catch:{ UploadAbortedException -> 0x0221, UnknownResponseException -> 0x021e, RemoteDfuException -> 0x0640 }
        L_0x0640:
            r0 = move-exception
            goto L_0x065f
        L_0x0642:
            r0 = move-exception
            r32 = r6
            r33 = r7
        L_0x0647:
            r3 = r0
            r5 = r32
            r2 = r33
            goto L_0x06bf
        L_0x064e:
            r0 = move-exception
            r32 = r6
            r33 = r7
        L_0x0653:
            r3 = r0
            r5 = r32
            r2 = r33
            goto L_0x06ee
        L_0x065a:
            r0 = move-exception
            r32 = r6
            r33 = r7
        L_0x065f:
            r2 = r0
        L_0x0660:
            int r3 = r2.getErrorNumber()
            r5 = r3 | 256(0x100, float:3.59E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = r2.getMessage()
            r6.append(r2)
            java.lang.String r2 = ": "
            r6.append(r2)
            java.lang.String r2 = no.nordicsemi.android.error.LegacyDfuError.parse(r5)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r1.loge(r2)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            java.util.Locale r6 = java.util.Locale.US
            java.lang.String r5 = no.nordicsemi.android.error.LegacyDfuError.parse(r5)
            r7 = 1
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r8 = 0
            r7[r8] = r5
            java.lang.String r5 = "Remote DFU error: %s"
            java.lang.String r5 = java.lang.String.format(r6, r5, r7)
            r6 = 20
            r2.sendLogBroadcast(r6, r5)
            r2 = r33
            r1.logi(r2)
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic
            byte[] r5 = OP_CODE_RESET
            r1.writeOpCode(r2, r5)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            r5 = r32
            r6 = 10
            r2.sendLogBroadcast(r6, r5)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            r3 = r3 | 8448(0x2100, float:1.1838E-41)
            r2.terminateConnection(r4, r3)
            goto L_0x06e9
        L_0x06bb:
            r0 = move-exception
            r5 = r6
            r2 = r7
            r3 = r0
        L_0x06bf:
            java.lang.String r6 = r3.getMessage()
            r1.loge(r6)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r1.mService
            java.lang.String r3 = r3.getMessage()
            r7 = 20
            r6.sendLogBroadcast(r7, r3)
            r1.logi(r2)
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic
            byte[] r3 = OP_CODE_RESET
            r1.writeOpCode(r2, r3)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            r3 = 10
            r2.sendLogBroadcast(r3, r5)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            r3 = 4104(0x1008, float:5.751E-42)
            r2.terminateConnection(r4, r3)
        L_0x06e9:
            return
        L_0x06ea:
            r0 = move-exception
            r5 = r6
            r2 = r7
            r3 = r0
        L_0x06ee:
            r1.logi(r2)
            r2 = 0
            r1.mAborted = r2
            android.bluetooth.BluetoothGattCharacteristic r2 = r1.mControlPointCharacteristic
            byte[] r4 = OP_CODE_RESET
            r1.writeOpCode(r2, r4)
            no.nordicsemi.android.dfu.DfuBaseService r2 = r1.mService
            r4 = 10
            r2.sendLogBroadcast(r4, r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.performDfu(android.content.Intent):void");
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void setImageSize(byte[] bArr, int i, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length == 3 && bArr[0] == 16 && bArr[1] == i && (b = bArr[2]) >= 1 && b <= 6) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 16, i);
    }

    private int readVersion(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        boolean z = false;
        byte b = bArr[0];
        if (b == 6 || b == 5) {
            z = true;
        }
        writeOpCode(bluetoothGattCharacteristic, bArr, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeImageSize(android.bluetooth.BluetoothGattCharacteristic r6, int r7) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r5 = this;
            r0 = 0
            r5.mReceivedData = r0
            r0 = 0
            r5.mError = r0
            r1 = 1
            r5.mImageSizeInProgress = r1
            r2 = 4
            byte[] r2 = new byte[r2]
            r5.setImageSize(r2, r7, r0)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r5.mService
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Writing to characteristic "
            r3.<init>(r4)
            java.util.UUID r4 = r6.getUuid()
            r3.append(r4)
            java.lang.String r4 = ", value (0x): "
            r3.append(r4)
            java.lang.String r4 = r5.parse(r2)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.sendLogBroadcast(r1, r3)
            int r7 = android.os.Build.VERSION.SDK_INT
            r3 = 33
            if (r7 < r3) goto L_0x0066
            no.nordicsemi.android.dfu.DfuBaseService r7 = r5.mService
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "gatt.writeCharacteristic("
            r3.<init>(r4)
            java.util.UUID r4 = r6.getUuid()
            r3.append(r4)
            java.lang.String r4 = ", value="
            r3.append(r4)
            java.lang.String r4 = r5.parse(r2)
            r3.append(r4)
            java.lang.String r4 = ", WRITE_TYPE_NO_RESPONSE)"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r7.sendLogBroadcast(r0, r3)
            android.bluetooth.BluetoothGatt r7 = r5.mGatt
            int unused = r7.writeCharacteristic(r6, r2, r1)
            goto L_0x008d
        L_0x0066:
            r6.setWriteType(r1)
            r6.setValue(r2)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r5.mService
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "gatt.writeCharacteristic("
            r1.<init>(r2)
            java.util.UUID r2 = r6.getUuid()
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r7.sendLogBroadcast(r0, r1)
            android.bluetooth.BluetoothGatt r7 = r5.mGatt
            r7.writeCharacteristic(r6)
        L_0x008d:
            java.lang.Object r6 = r5.mLock     // Catch:{ InterruptedException -> 0x00af }
            monitor-enter(r6)     // Catch:{ InterruptedException -> 0x00af }
        L_0x0090:
            boolean r7 = r5.mImageSizeInProgress     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x00a0
            boolean r7 = r5.mConnected     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x00a0
            int r7 = r5.mError     // Catch:{ all -> 0x00ac }
            if (r7 != 0) goto L_0x00a0
            boolean r7 = r5.mAborted     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x00a4
        L_0x00a0:
            boolean r7 = r5.mPaused     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x00aa
        L_0x00a4:
            java.lang.Object r7 = r5.mLock     // Catch:{ all -> 0x00ac }
            r7.wait()     // Catch:{ all -> 0x00ac }
            goto L_0x0090
        L_0x00aa:
            monitor-exit(r6)     // Catch:{ all -> 0x00ac }
            goto L_0x00b5
        L_0x00ac:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x00ac }
            throw r7     // Catch:{ InterruptedException -> 0x00af }
        L_0x00af:
            r6 = move-exception
            java.lang.String r7 = "Sleeping interrupted"
            r5.loge(r7, r6)
        L_0x00b5:
            boolean r6 = r5.mAborted
            if (r6 != 0) goto L_0x00d4
            boolean r6 = r5.mConnected
            if (r6 == 0) goto L_0x00cc
            int r6 = r5.mError
            if (r6 != 0) goto L_0x00c2
            return
        L_0x00c2:
            no.nordicsemi.android.dfu.internal.exception.DfuException r6 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r7 = "Unable to write Image Size"
            int r0 = r5.mError
            r6.<init>(r7, r0)
            throw r6
        L_0x00cc:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r6 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r7 = "Unable to write Image Size: device disconnected"
            r6.<init>(r7)
            throw r6
        L_0x00d4:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r6 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.writeImageSize(android.bluetooth.BluetoothGattCharacteristic, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeImageSize(android.bluetooth.BluetoothGattCharacteristic r4, int r5, int r6, int r7) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r3 = this;
            r0 = 0
            r3.mReceivedData = r0
            r0 = 0
            r3.mError = r0
            r1 = 1
            r3.mImageSizeInProgress = r1
            r2 = 12
            byte[] r2 = new byte[r2]
            r3.setImageSize(r2, r5, r0)
            r5 = 4
            r3.setImageSize(r2, r6, r5)
            r5 = 8
            r3.setImageSize(r2, r7, r5)
            no.nordicsemi.android.dfu.DfuBaseService r5 = r3.mService
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Writing to characteristic "
            r6.<init>(r7)
            java.util.UUID r7 = r4.getUuid()
            r6.append(r7)
            java.lang.String r7 = ", value (0x): "
            r6.append(r7)
            java.lang.String r7 = r3.parse(r2)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.sendLogBroadcast(r1, r6)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 33
            if (r5 < r6) goto L_0x0070
            no.nordicsemi.android.dfu.DfuBaseService r5 = r3.mService
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "gatt.writeCharacteristic("
            r6.<init>(r7)
            java.util.UUID r7 = r4.getUuid()
            r6.append(r7)
            java.lang.String r7 = ", value="
            r6.append(r7)
            java.lang.String r7 = r3.parse(r2)
            r6.append(r7)
            java.lang.String r7 = ", WRITE_TYPE_NO_RESPONSE)"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.sendLogBroadcast(r0, r6)
            android.bluetooth.BluetoothGatt r5 = r3.mGatt
            int unused = r5.writeCharacteristic(r4, r2, r1)
            goto L_0x0097
        L_0x0070:
            r4.setWriteType(r1)
            r4.setValue(r2)
            no.nordicsemi.android.dfu.DfuBaseService r5 = r3.mService
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "gatt.writeCharacteristic("
            r6.<init>(r7)
            java.util.UUID r7 = r4.getUuid()
            r6.append(r7)
            java.lang.String r7 = ")"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.sendLogBroadcast(r0, r6)
            android.bluetooth.BluetoothGatt r5 = r3.mGatt
            r5.writeCharacteristic(r4)
        L_0x0097:
            java.lang.Object r4 = r3.mLock     // Catch:{ InterruptedException -> 0x00b9 }
            monitor-enter(r4)     // Catch:{ InterruptedException -> 0x00b9 }
        L_0x009a:
            boolean r5 = r3.mImageSizeInProgress     // Catch:{ all -> 0x00b6 }
            if (r5 == 0) goto L_0x00aa
            boolean r5 = r3.mConnected     // Catch:{ all -> 0x00b6 }
            if (r5 == 0) goto L_0x00aa
            int r5 = r3.mError     // Catch:{ all -> 0x00b6 }
            if (r5 != 0) goto L_0x00aa
            boolean r5 = r3.mAborted     // Catch:{ all -> 0x00b6 }
            if (r5 == 0) goto L_0x00ae
        L_0x00aa:
            boolean r5 = r3.mPaused     // Catch:{ all -> 0x00b6 }
            if (r5 == 0) goto L_0x00b4
        L_0x00ae:
            java.lang.Object r5 = r3.mLock     // Catch:{ all -> 0x00b6 }
            r5.wait()     // Catch:{ all -> 0x00b6 }
            goto L_0x009a
        L_0x00b4:
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            goto L_0x00bf
        L_0x00b6:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b6 }
            throw r5     // Catch:{ InterruptedException -> 0x00b9 }
        L_0x00b9:
            r4 = move-exception
            java.lang.String r5 = "Sleeping interrupted"
            r3.loge(r5, r4)
        L_0x00bf:
            boolean r4 = r3.mAborted
            if (r4 != 0) goto L_0x00de
            boolean r4 = r3.mConnected
            if (r4 == 0) goto L_0x00d6
            int r4 = r3.mError
            if (r4 != 0) goto L_0x00cc
            return
        L_0x00cc:
            no.nordicsemi.android.dfu.internal.exception.DfuException r4 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r5 = "Unable to write Image Sizes"
            int r6 = r3.mError
            r4.<init>(r5, r6)
            throw r4
        L_0x00d6:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r4 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r5 = "Unable to write Image Sizes: device disconnected"
            r4.<init>(r5)
            throw r4
        L_0x00de:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r4 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.LegacyDfuImpl.writeImageSize(android.bluetooth.BluetoothGattCharacteristic, int, int, int):void");
    }

    private void resetAndRestart(BluetoothGatt bluetoothGatt, Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        this.mService.sendLogBroadcast(15, "Last upload interrupted. Restarting device...");
        this.mProgressInfo.setProgress(-5);
        logi("Sending Reset command (Op Code = 6)");
        writeOpCode(this.mControlPointCharacteristic, OP_CODE_RESET);
        this.mService.sendLogBroadcast(10, "Reset request sent");
        this.mService.waitUntilDisconnected();
        this.mService.sendLogBroadcast(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(GENERIC_ATTRIBUTE_SERVICE_UUID);
        this.mService.refreshDeviceCache(bluetoothGatt, !((service == null || service.getCharacteristic(SERVICE_CHANGED_UUID) == null) ? false : true));
        this.mService.close(bluetoothGatt);
        logi("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        restartService(intent2, false);
    }
}
