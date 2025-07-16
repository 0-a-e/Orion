package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.BaseCustomDfuImpl;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
import no.nordicsemi.android.error.SecureDfuError;

class SecureDfuImpl extends BaseCustomDfuImpl {
    static final UUID DEFAULT_DFU_CONTROL_POINT_UUID;
    static final UUID DEFAULT_DFU_PACKET_UUID;
    static final UUID DEFAULT_DFU_SERVICE_UUID;
    static UUID DFU_CONTROL_POINT_UUID = null;
    static UUID DFU_PACKET_UUID = null;
    static UUID DFU_SERVICE_UUID = null;
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final int MAX_ATTEMPTS = 3;
    private static final int OBJECT_COMMAND = 1;
    private static final int OBJECT_DATA = 2;
    private static final byte[] OP_CODE_CALCULATE_CHECKSUM = {3};
    private static final int OP_CODE_CALCULATE_CHECKSUM_KEY = 3;
    private static final byte[] OP_CODE_CREATE_COMMAND = {1, 1, 0, 0, 0, 0};
    private static final byte[] OP_CODE_CREATE_DATA = {1, 2, 0, 0, 0, 0};
    private static final int OP_CODE_CREATE_KEY = 1;
    private static final byte[] OP_CODE_EXECUTE = {4};
    private static final int OP_CODE_EXECUTE_KEY = 4;
    private static final byte[] OP_CODE_PACKET_RECEIPT_NOTIF_REQ = {2, 0, 0};
    private static final int OP_CODE_PACKET_RECEIPT_NOTIF_REQ_KEY = 2;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 96;
    private static final byte[] OP_CODE_SELECT_OBJECT = {6, 0};
    private static final int OP_CODE_SELECT_OBJECT_KEY = 6;
    private final SecureBluetoothCallback mBluetoothCallback = new SecureBluetoothCallback();
    private BluetoothGattCharacteristic mControlPointCharacteristic;
    private BluetoothGattCharacteristic mPacketCharacteristic;
    private long prepareObjectDelay;

    static {
        UUID uuid = new UUID(279658205548544L, -9223371485494954757L);
        DEFAULT_DFU_SERVICE_UUID = uuid;
        UUID uuid2 = new UUID(-8157989241631715488L, -6937650605005804976L);
        DEFAULT_DFU_CONTROL_POINT_UUID = uuid2;
        UUID uuid3 = new UUID(-8157989237336748192L, -6937650605005804976L);
        DEFAULT_DFU_PACKET_UUID = uuid3;
        DFU_SERVICE_UUID = uuid;
        DFU_CONTROL_POINT_UUID = uuid2;
        DFU_PACKET_UUID = uuid3;
    }

    protected class SecureBluetoothCallback extends BaseCustomDfuImpl.BaseCustomBluetoothCallback {
        protected SecureBluetoothCallback() {
            super();
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            if (bArr.length < 3) {
                SecureDfuImpl secureDfuImpl = SecureDfuImpl.this;
                secureDfuImpl.loge("Empty response: " + parse(bArr));
                SecureDfuImpl.this.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
                SecureDfuImpl.this.notifyLock();
                return;
            }
            if ((bArr[0] & 255) != 96) {
                SecureDfuImpl secureDfuImpl2 = SecureDfuImpl.this;
                secureDfuImpl2.loge("Invalid response: " + parse(bArr));
                SecureDfuImpl.this.mError = DfuBaseService.ERROR_INVALID_RESPONSE;
            } else if ((bArr[1] & 255) == 3) {
                int intValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                if (((int) (((ArchiveInputStream) SecureDfuImpl.this.mFirmwareStream).getCrc32() & 4294967295L)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                    SecureDfuImpl.this.mProgressInfo.setBytesReceived(intValue);
                } else if (SecureDfuImpl.this.mFirmwareUploadInProgress) {
                    SecureDfuImpl.this.mFirmwareUploadInProgress = false;
                    SecureDfuImpl.this.notifyLock();
                    return;
                }
                handlePacketReceiptNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            } else if (!SecureDfuImpl.this.mRemoteErrorOccurred) {
                if ((bArr[2] & 255) != 1) {
                    SecureDfuImpl.this.mRemoteErrorOccurred = true;
                }
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
            }
            SecureDfuImpl.this.notifyLock();
        }
    }

    SecureDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
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

    public boolean initialize(Intent intent, BluetoothGatt bluetoothGatt, int i, InputStream inputStream, InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        if (inputStream2 != null) {
            return super.initialize(intent, bluetoothGatt, i, inputStream, inputStream2);
        }
        this.mService.sendLogBroadcast(20, "The Init packet is required by this version DFU Bootloader");
        this.mService.terminateConnection(bluetoothGatt, DfuBaseService.ERROR_INIT_PACKET_REQUIRED);
        return false;
    }

    public BaseDfuImpl.BaseBluetoothGattCallback getGattCallback() {
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

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x015c, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x015d, code lost:
        loge(r9.getMessage());
        r8.mService.sendLogBroadcast(20, r9.getMessage());
        r8.mService.terminateConnection(r1, no.nordicsemi.android.dfu.DfuBaseService.ERROR_INVALID_RESPONSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0175, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0176, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f A[Catch:{ RemoteDfuException -> 0x0068, UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x015c A[ExcHandler: UnknownResponseException (r9v2 'e' no.nordicsemi.android.dfu.internal.exception.UnknownResponseException A[CUSTOM_DECLARE]), Splitter:B:4:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0175 A[ExcHandler: UploadAbortedException (r9v1 'e' no.nordicsemi.android.dfu.internal.exception.UploadAbortedException A[CUSTOM_DECLARE]), Splitter:B:4:0x003f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performDfu(android.content.Intent r9) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r8 = this;
            java.lang.String r0 = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME"
            java.lang.String r1 = "Secure DFU bootloader found"
            r8.logw(r1)
            no.nordicsemi.android.dfu.DfuProgressInfo r1 = r8.mProgressInfo
            r2 = -2
            r1.setProgress(r2)
            android.bluetooth.BluetoothGatt r1 = r8.mGatt
            java.lang.String r2 = "no.nordicsemi.android.dfu.extra.EXTRA_MTU"
            boolean r3 = r9.hasExtra(r2)
            if (r3 == 0) goto L_0x0031
            r3 = 517(0x205, float:7.24E-43)
            int r2 = r9.getIntExtra(r2, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Requesting MTU = "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r8.logi(r3)
            r8.requestMtu(r2)
        L_0x0031:
            java.lang.String r2 = "no.nordicsemi.android.dfu.extra.EXTRA_DATA_OBJECT_DELAY"
            r3 = 0
            long r2 = r9.getLongExtra(r2, r3)
            r8.prepareObjectDelay = r2
            r2 = 20
            r3 = 1
            r4 = 0
            android.bluetooth.BluetoothGattCharacteristic r5 = r8.mControlPointCharacteristic     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r8.enableCCCD(r5, r3)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            no.nordicsemi.android.dfu.DfuBaseService r5 = r8.mService     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            java.lang.String r6 = "Notifications enabled"
            r7 = 10
            r5.sendLogBroadcast(r7, r6)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            boolean r5 = r9.hasExtra(r0)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            if (r5 == 0) goto L_0x005c
            boolean r0 = r9.getBooleanExtra(r0, r4)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            if (r0 != 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r0 = r4
            goto L_0x005d
        L_0x005c:
            r0 = r3
        L_0x005d:
            if (r0 != 0) goto L_0x0064
            java.lang.String r5 = "Resume feature disabled. Performing fresh DFU"
            r8.logi(r5)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
        L_0x0064:
            r8.sendInitPacket(r1, r0)     // Catch:{ RemoteDfuException -> 0x0068, UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c }
            goto L_0x00ac
        L_0x0068:
            r0 = move-exception
            no.nordicsemi.android.dfu.DfuProgressInfo r5 = r8.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            boolean r5 = r5.isLastPart()     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            if (r5 != 0) goto L_0x00c7
            r8.mRemoteErrorOccurred = r4     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            java.lang.String r0 = "Sending SD+BL failed. Trying to send App only"
            r8.logw(r0)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r8.mService     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            java.lang.String r5 = "Invalid system components. Trying to send application"
            r6 = 15
            r0.sendLogBroadcast(r6, r5)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r0 = 4
            r8.mFileType = r0     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            java.io.InputStream r0 = r8.mFirmwareStream     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r0 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r0     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            int r5 = r8.mFileType     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r0.setContentType(r5)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            byte[] r5 = r0.getApplicationInit()     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r6.<init>(r5)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r8.mInitPacketStream = r6     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            int r5 = r5.length     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r8.mInitPacketSizeInBytes = r5     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            int r0 = r0.applicationImageSize()     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r8.mImageSizeInBytes = r0     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r8.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            int r5 = r8.mImageSizeInBytes     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r6 = 2
            r0.init(r5, r6, r6)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r8.sendInitPacket(r1, r4)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
        L_0x00ac:
            r8.sendFirmware(r1)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r8.mProgressInfo     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r5 = -5
            r0.setProgress(r5)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r8.mService     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r0.waitUntilDisconnected()     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r8.mService     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            java.lang.String r5 = "Disconnected by the remote device"
            r6 = 5
            r0.sendLogBroadcast(r6, r5)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            r8.finalize(r9, r4)     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
            goto L_0x0174
        L_0x00c7:
            throw r0     // Catch:{ UploadAbortedException -> 0x0175, UnknownResponseException -> 0x015c, RemoteDfuException -> 0x00c8 }
        L_0x00c8:
            r9 = move-exception
            int r0 = r9.getErrorNumber()
            r5 = r0 | 512(0x200, float:7.175E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = r9.getMessage()
            r6.append(r7)
            java.lang.String r7 = ": "
            r6.append(r7)
            java.lang.String r7 = no.nordicsemi.android.error.SecureDfuError.parse(r5)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r8.loge(r6)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r8.mService
            java.util.Locale r7 = java.util.Locale.US
            java.lang.String r5 = no.nordicsemi.android.error.SecureDfuError.parse(r5)
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r5
            java.lang.String r4 = "Remote DFU error: %s"
            java.lang.String r3 = java.lang.String.format(r7, r4, r3)
            r6.sendLogBroadcast(r2, r3)
            boolean r3 = r9 instanceof no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException
            if (r3 == 0) goto L_0x0154
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException r9 = (no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException) r9
            int r0 = r9.getExtendedErrorNumber()
            r3 = r0 | 1024(0x400, float:1.435E-42)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Extended Error details: "
            r4.<init>(r5)
            java.lang.String r5 = no.nordicsemi.android.error.SecureDfuError.parseExtendedError(r3)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r8.loge(r4)
            no.nordicsemi.android.dfu.DfuBaseService r4 = r8.mService
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Details: "
            r5.<init>(r6)
            java.lang.String r3 = no.nordicsemi.android.error.SecureDfuError.parseExtendedError(r3)
            r5.append(r3)
            java.lang.String r3 = " (Code = "
            r5.append(r3)
            int r9 = r9.getExtendedErrorNumber()
            r5.append(r9)
            java.lang.String r9 = ")"
            r5.append(r9)
            java.lang.String r9 = r5.toString()
            r4.sendLogBroadcast(r2, r9)
            no.nordicsemi.android.dfu.DfuBaseService r9 = r8.mService
            r0 = r0 | 9216(0x2400, float:1.2914E-41)
            r9.terminateConnection(r1, r0)
            goto L_0x0174
        L_0x0154:
            no.nordicsemi.android.dfu.DfuBaseService r9 = r8.mService
            r0 = r0 | 8704(0x2200, float:1.2197E-41)
            r9.terminateConnection(r1, r0)
            goto L_0x0174
        L_0x015c:
            r9 = move-exception
            java.lang.String r0 = r9.getMessage()
            r8.loge(r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r8.mService
            java.lang.String r9 = r9.getMessage()
            r0.sendLogBroadcast(r2, r9)
            no.nordicsemi.android.dfu.DfuBaseService r9 = r8.mService
            r0 = 4104(0x1008, float:5.751E-42)
            r9.terminateConnection(r1, r0)
        L_0x0174:
            return
        L_0x0175:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.performDfu(android.content.Intent):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendInitPacket(android.bluetooth.BluetoothGatt r18, boolean r19) throws no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.UnknownResponseException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            java.lang.String r0 = "-> "
            java.util.zip.CRC32 r3 = new java.util.zip.CRC32
            r3.<init>()
            java.lang.String r4 = "Setting object to Command (Op Code = 6, Type = 1)"
            r1.logi(r4)
            r4 = 1
            no.nordicsemi.android.dfu.SecureDfuImpl$ObjectInfo r5 = r1.selectObject(r4)
            java.util.Locale r6 = java.util.Locale.US
            int r7 = r5.maxSize
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r8 = r5.offset
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            int r9 = r5.CRC32
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r10 = 3
            java.lang.Object[] r11 = new java.lang.Object[r10]
            r12 = 0
            r11[r12] = r7
            r11[r4] = r8
            r7 = 2
            r11[r7] = r9
            java.lang.String r8 = "Command object info received (Max size = %d, Offset = %d, CRC = %08X)"
            java.lang.String r6 = java.lang.String.format(r6, r8, r11)
            r1.logi(r6)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r1.mService
            java.util.Locale r9 = java.util.Locale.US
            int r11 = r5.maxSize
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r13 = r5.offset
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            int r14 = r5.CRC32
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.Object[] r15 = new java.lang.Object[r10]
            r15[r12] = r11
            r15[r4] = r13
            r15[r7] = r14
            java.lang.String r8 = java.lang.String.format(r9, r8, r15)
            r9 = 10
            r6.sendLogBroadcast(r9, r8)
            int r6 = r1.mInitPacketSizeInBytes
            int r6 = r5.maxSize
            r13 = 4294967295(0xffffffff, double:2.1219957905E-314)
            r6 = 4100(0x1004, float:5.745E-42)
            java.lang.String r8 = "Error while resetting the init packet stream"
            if (r19 == 0) goto L_0x0115
            int r11 = r5.offset
            if (r11 <= 0) goto L_0x0115
            int r11 = r5.offset
            int r15 = r1.mInitPacketSizeInBytes
            if (r11 > r15) goto L_0x0115
            int r11 = r5.offset     // Catch:{ IOException -> 0x00e4 }
            byte[] r11 = new byte[r11]     // Catch:{ IOException -> 0x00e4 }
            java.io.InputStream r15 = r1.mInitPacketStream     // Catch:{ IOException -> 0x00e4 }
            r15.read(r11)     // Catch:{ IOException -> 0x00e4 }
            r3.update(r11)     // Catch:{ IOException -> 0x00e4 }
            long r15 = r3.getValue()     // Catch:{ IOException -> 0x00e4 }
            long r10 = r15 & r13
            int r10 = (int) r10     // Catch:{ IOException -> 0x00e4 }
            int r11 = r5.CRC32     // Catch:{ IOException -> 0x00e4 }
            if (r11 != r10) goto L_0x00d9
            java.lang.String r10 = "Init packet CRC is the same"
            r1.logi(r10)     // Catch:{ IOException -> 0x00e4 }
            int r10 = r5.offset     // Catch:{ IOException -> 0x00e4 }
            int r11 = r1.mInitPacketSizeInBytes     // Catch:{ IOException -> 0x00e4 }
            if (r10 != r11) goto L_0x00b4
            java.lang.String r0 = "-> Whole Init packet was sent before"
            r1.logi(r0)     // Catch:{ IOException -> 0x00e4 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService     // Catch:{ IOException -> 0x00af }
            java.lang.String r10 = "Received CRC match Init packet"
            r0.sendLogBroadcast(r9, r10)     // Catch:{ IOException -> 0x00af }
            r0 = r4
            r10 = r12
            goto L_0x0117
        L_0x00af:
            r0 = move-exception
            r11 = r0
            r0 = r4
            r10 = r12
            goto L_0x00e8
        L_0x00b4:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e4 }
            r10.<init>(r0)     // Catch:{ IOException -> 0x00e4 }
            int r0 = r5.offset     // Catch:{ IOException -> 0x00e4 }
            r10.append(r0)     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r0 = " bytes of Init packet were sent before"
            r10.append(r0)     // Catch:{ IOException -> 0x00e4 }
            java.lang.String r0 = r10.toString()     // Catch:{ IOException -> 0x00e4 }
            r1.logi(r0)     // Catch:{ IOException -> 0x00e4 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService     // Catch:{ IOException -> 0x00d4 }
            java.lang.String r10 = "Resuming sending Init packet..."
            r0.sendLogBroadcast(r9, r10)     // Catch:{ IOException -> 0x00d4 }
            r10 = r4
            r0 = r12
            goto L_0x0117
        L_0x00d4:
            r0 = move-exception
            r11 = r0
            r10 = r4
            r0 = r12
            goto L_0x00e8
        L_0x00d9:
            java.io.InputStream r0 = r1.mInitPacketStream     // Catch:{ IOException -> 0x00e4 }
            r0.reset()     // Catch:{ IOException -> 0x00e4 }
            r3.reset()     // Catch:{ IOException -> 0x00e4 }
            r5.offset = r12     // Catch:{ IOException -> 0x00e4 }
            goto L_0x0115
        L_0x00e4:
            r0 = move-exception
            r11 = r0
            r0 = r12
            r10 = r0
        L_0x00e8:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r7 = "Error while reading "
            r15.<init>(r7)
            int r7 = r5.offset
            r15.append(r7)
            java.lang.String r7 = " bytes from the init packet stream"
            r15.append(r7)
            java.lang.String r7 = r15.toString()
            r1.loge(r7, r11)
            java.io.InputStream r7 = r1.mInitPacketStream     // Catch:{ IOException -> 0x010b }
            r7.reset()     // Catch:{ IOException -> 0x010b }
            r3.reset()     // Catch:{ IOException -> 0x010b }
            r5.offset = r12     // Catch:{ IOException -> 0x010b }
            goto L_0x0117
        L_0x010b:
            r0 = move-exception
            r1.loge(r8, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r0.terminateConnection(r2, r6)
            return
        L_0x0115:
            r0 = r12
            r10 = r0
        L_0x0117:
            if (r0 != 0) goto L_0x0246
            r1.setPacketReceiptNotifications(r12)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            java.lang.String r7 = "Packet Receipt Notif disabled (Op Code = 2, Value = 0)"
            r0.sendLogBroadcast(r9, r7)
            r0 = r4
            r7 = 3
        L_0x0125:
            if (r0 > r7) goto L_0x0246
            if (r10 != 0) goto L_0x014d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r10 = "Creating Init packet object (Op Code = 1, Type = 1, Size = "
            r7.<init>(r10)
            int r10 = r1.mInitPacketSizeInBytes
            r7.append(r10)
            java.lang.String r10 = ")"
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r1.logi(r7)
            int r7 = r1.mInitPacketSizeInBytes
            r1.writeCreateRequest(r4, r7)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r1.mService
            java.lang.String r10 = "Command object created"
            r7.sendLogBroadcast(r9, r10)
        L_0x014d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ DeviceDisconnectedException -> 0x023f }
            r7.<init>()     // Catch:{ DeviceDisconnectedException -> 0x023f }
            java.lang.String r10 = "Sending "
            r7.append(r10)     // Catch:{ DeviceDisconnectedException -> 0x023f }
            int r10 = r1.mInitPacketSizeInBytes     // Catch:{ DeviceDisconnectedException -> 0x023f }
            int r11 = r5.offset     // Catch:{ DeviceDisconnectedException -> 0x023f }
            int r10 = r10 - r11
            r7.append(r10)     // Catch:{ DeviceDisconnectedException -> 0x023f }
            java.lang.String r10 = " bytes of init packet..."
            r7.append(r10)     // Catch:{ DeviceDisconnectedException -> 0x023f }
            java.lang.String r7 = r7.toString()     // Catch:{ DeviceDisconnectedException -> 0x023f }
            r1.logi(r7)     // Catch:{ DeviceDisconnectedException -> 0x023f }
            android.bluetooth.BluetoothGattCharacteristic r7 = r1.mPacketCharacteristic     // Catch:{ DeviceDisconnectedException -> 0x023f }
            r1.writeInitData(r7, r3)     // Catch:{ DeviceDisconnectedException -> 0x023f }
            long r10 = r3.getValue()
            long r10 = r10 & r13
            int r7 = (int) r10
            no.nordicsemi.android.dfu.DfuBaseService r10 = r1.mService
            java.util.Locale r11 = java.util.Locale.US
            java.lang.Integer r15 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r13 = new java.lang.Object[r4]
            r13[r12] = r15
            java.lang.String r14 = "Command object sent (CRC = %08X)"
            java.lang.String r11 = java.lang.String.format(r11, r14, r13)
            r10.sendLogBroadcast(r9, r11)
            java.lang.String r10 = "Sending Calculate Checksum command (Op Code = 3)"
            r1.logi(r10)
            no.nordicsemi.android.dfu.SecureDfuImpl$ObjectChecksum r10 = r17.readChecksum()
            no.nordicsemi.android.dfu.DfuBaseService r11 = r1.mService
            java.util.Locale r13 = java.util.Locale.US
            int r14 = r10.offset
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            int r15 = r10.CRC32
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r6 = 2
            java.lang.Object[] r9 = new java.lang.Object[r6]
            r9[r12] = r14
            r9[r4] = r15
            java.lang.String r14 = "Checksum received (Offset = %d, CRC = %08X)"
            java.lang.String r9 = java.lang.String.format(r13, r14, r9)
            r13 = 10
            r11.sendLogBroadcast(r13, r9)
            java.util.Locale r9 = java.util.Locale.US
            int r11 = r10.offset
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r13 = r10.CRC32
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.Object[] r15 = new java.lang.Object[r6]
            r15[r12] = r11
            r15[r4] = r13
            java.lang.String r9 = java.lang.String.format(r9, r14, r15)
            r1.logi(r9)
            int r9 = r10.CRC32
            if (r7 != r9) goto L_0x01d6
            goto L_0x0246
        L_0x01d6:
            r7 = 3
            if (r0 >= r7) goto L_0x022b
            int r0 = r0 + 1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "CRC does not match! Retrying...("
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r11 = "/3)"
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            r1.logi(r9)
            no.nordicsemi.android.dfu.DfuBaseService r9 = r1.mService
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r10)
            r13.append(r0)
            r13.append(r11)
            java.lang.String r10 = r13.toString()
            r11 = 15
            r9.sendLogBroadcast(r11, r10)
            r5.offset = r12     // Catch:{ IOException -> 0x021f }
            r5.CRC32 = r12     // Catch:{ IOException -> 0x021f }
            java.io.InputStream r9 = r1.mInitPacketStream     // Catch:{ IOException -> 0x021f }
            r9.reset()     // Catch:{ IOException -> 0x021f }
            r3.reset()     // Catch:{ IOException -> 0x021f }
            r10 = r12
            r6 = 4100(0x1004, float:5.745E-42)
            r9 = 10
            r13 = 4294967295(0xffffffff, double:2.1219957905E-314)
            goto L_0x0125
        L_0x021f:
            r0 = move-exception
            r1.loge(r8, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r3 = 4100(0x1004, float:5.745E-42)
            r0.terminateConnection(r2, r3)
            return
        L_0x022b:
            java.lang.String r0 = "CRC does not match!"
            r1.loge(r0)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService
            r4 = 20
            r3.sendLogBroadcast(r4, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r3 = 4109(0x100d, float:5.758E-42)
            r0.terminateConnection(r2, r3)
            return
        L_0x023f:
            r0 = move-exception
            java.lang.String r2 = "Disconnected while sending init packet"
            r1.loge(r2)
            throw r0
        L_0x0246:
            java.lang.String r0 = "Executing init packet (Op Code = 4)"
            r1.logi(r0)
            r17.writeExecute()
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            java.lang.String r2 = "Command object executed"
            r3 = 10
            r0.sendLogBroadcast(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.sendInitPacket(android.bluetooth.BluetoothGatt, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x031d, code lost:
        if (r1.mPacketsBeforeNotification > 1) goto L_0x0321;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendFirmware(android.bluetooth.BluetoothGatt r25) throws no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException, no.nordicsemi.android.dfu.internal.exception.UnknownResponseException {
        /*
            r24 = this;
            r1 = r24
            r2 = r25
            java.lang.String r0 = "..."
            java.lang.String r3 = " bytes of data sent before, CRC match"
            java.lang.String r4 = " bytes sent before, CRC does not match"
            java.lang.String r5 = "Resuming from byte "
            int r6 = r1.mPacketsBeforeNotification
            java.lang.String r7 = ")"
            r8 = 10
            if (r6 <= 0) goto L_0x002d
            r1.setPacketReceiptNotifications(r6)
            no.nordicsemi.android.dfu.DfuBaseService r9 = r1.mService
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Packet Receipt Notif Req (Op Code = 2) sent (Value = "
            r10.<init>(r11)
            r10.append(r6)
            r10.append(r7)
            java.lang.String r6 = r10.toString()
            r9.sendLogBroadcast(r8, r6)
        L_0x002d:
            java.lang.String r6 = "Setting object to Data (Op Code = 6, Type = 2)"
            r1.logi(r6)
            r6 = 2
            no.nordicsemi.android.dfu.SecureDfuImpl$ObjectInfo r9 = r1.selectObject(r6)
            java.util.Locale r10 = java.util.Locale.US
            int r11 = r9.maxSize
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r12 = r9.offset
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            int r13 = r9.CRC32
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r14 = 3
            java.lang.Object[] r15 = new java.lang.Object[r14]
            r8 = 0
            r15[r8] = r11
            r11 = 1
            r15[r11] = r12
            r15[r6] = r13
            java.lang.String r12 = "Data object info received (Max size = %d, Offset = %d, CRC = %08X)"
            java.lang.String r10 = java.lang.String.format(r10, r12, r15)
            r1.logi(r10)
            no.nordicsemi.android.dfu.DfuBaseService r10 = r1.mService
            java.util.Locale r13 = java.util.Locale.US
            int r15 = r9.maxSize
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            int r6 = r9.offset
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r11 = r9.CRC32
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r16 = r7
            java.lang.Object[] r7 = new java.lang.Object[r14]
            r7[r8] = r15
            r15 = 1
            r7[r15] = r6
            r6 = 2
            r7[r6] = r11
            java.lang.String r6 = java.lang.String.format(r13, r12, r7)
            r7 = 10
            r10.sendLogBroadcast(r7, r6)
            no.nordicsemi.android.dfu.DfuProgressInfo r6 = r1.mProgressInfo
            int r7 = r9.maxSize
            r6.setMaxObjectSizeInBytes(r7)
            int r6 = r1.mImageSizeInBytes
            int r7 = r9.maxSize
            int r6 = r6 + r7
            int r6 = r6 - r15
            int r7 = r9.maxSize
            int r6 = r6 / r7
            int r7 = r9.offset
            java.lang.String r12 = "Error while reading firmware stream"
            java.lang.String r14 = "Data object executed"
            java.lang.String r15 = "Executing data object (Op Code = 4)"
            if (r7 <= 0) goto L_0x01cb
            int r7 = r9.offset     // Catch:{ IOException -> 0x01bf }
            int r13 = r9.maxSize     // Catch:{ IOException -> 0x01bf }
            int r7 = r7 / r13
            int r13 = r9.maxSize     // Catch:{ IOException -> 0x01bf }
            int r13 = r13 * r7
            int r8 = r9.offset     // Catch:{ IOException -> 0x01bf }
            int r8 = r8 - r13
            if (r8 != 0) goto L_0x00b6
            int r8 = r9.maxSize     // Catch:{ IOException -> 0x01bf }
            int r13 = r13 - r8
            int r8 = r9.maxSize     // Catch:{ IOException -> 0x01bf }
        L_0x00b6:
            if (r13 <= 0) goto L_0x00c6
            java.io.InputStream r10 = r1.mFirmwareStream     // Catch:{ IOException -> 0x01bf }
            byte[] r11 = new byte[r13]     // Catch:{ IOException -> 0x01bf }
            r10.read(r11)     // Catch:{ IOException -> 0x01bf }
            java.io.InputStream r10 = r1.mFirmwareStream     // Catch:{ IOException -> 0x01bf }
            int r11 = r9.maxSize     // Catch:{ IOException -> 0x01bf }
            r10.mark(r11)     // Catch:{ IOException -> 0x01bf }
        L_0x00c6:
            java.io.InputStream r10 = r1.mFirmwareStream     // Catch:{ IOException -> 0x01bf }
            byte[] r11 = new byte[r8]     // Catch:{ IOException -> 0x01bf }
            r10.read(r11)     // Catch:{ IOException -> 0x01bf }
            java.io.InputStream r10 = r1.mFirmwareStream     // Catch:{ IOException -> 0x01bf }
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r10 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r10     // Catch:{ IOException -> 0x01bf }
            long r10 = r10.getCrc32()     // Catch:{ IOException -> 0x01bf }
            r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r10 = r10 & r17
            int r10 = (int) r10     // Catch:{ IOException -> 0x01bf }
            int r11 = r9.CRC32     // Catch:{ IOException -> 0x01bf }
            if (r10 != r11) goto L_0x014e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01bf }
            r0.<init>()     // Catch:{ IOException -> 0x01bf }
            int r4 = r9.offset     // Catch:{ IOException -> 0x01bf }
            r0.append(r4)     // Catch:{ IOException -> 0x01bf }
            r0.append(r3)     // Catch:{ IOException -> 0x01bf }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x01bf }
            r1.logi(r0)     // Catch:{ IOException -> 0x01bf }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService     // Catch:{ IOException -> 0x01bf }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01bf }
            r4.<init>()     // Catch:{ IOException -> 0x01bf }
            int r5 = r9.offset     // Catch:{ IOException -> 0x01bf }
            r4.append(r5)     // Catch:{ IOException -> 0x01bf }
            r4.append(r3)     // Catch:{ IOException -> 0x01bf }
            java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x01bf }
            r4 = 10
            r0.sendLogBroadcast(r4, r3)     // Catch:{ IOException -> 0x01bf }
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r1.mProgressInfo     // Catch:{ IOException -> 0x01bf }
            int r3 = r9.offset     // Catch:{ IOException -> 0x01bf }
            r0.setBytesSent(r3)     // Catch:{ IOException -> 0x01bf }
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r1.mProgressInfo     // Catch:{ IOException -> 0x01bf }
            int r3 = r9.offset     // Catch:{ IOException -> 0x01bf }
            r0.setBytesReceived(r3)     // Catch:{ IOException -> 0x01bf }
            int r0 = r9.maxSize     // Catch:{ IOException -> 0x01bf }
            if (r8 != r0) goto L_0x014b
            int r0 = r9.offset     // Catch:{ IOException -> 0x01bf }
            int r3 = r1.mImageSizeInBytes     // Catch:{ IOException -> 0x01bf }
            if (r0 >= r3) goto L_0x014b
            r1.logi(r15)     // Catch:{ IOException -> 0x01bf }
            r24.writeExecute()     // Catch:{ RemoteDfuException -> 0x0134 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService     // Catch:{ RemoteDfuException -> 0x0134 }
            r3 = 10
            r0.sendLogBroadcast(r3, r14)     // Catch:{ RemoteDfuException -> 0x0134 }
            goto L_0x01bd
        L_0x0134:
            r0 = move-exception
            int r3 = r0.getErrorNumber()     // Catch:{ IOException -> 0x01bf }
            r4 = 8
            if (r3 != r4) goto L_0x014a
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService     // Catch:{ IOException -> 0x01bf }
            java.lang.String r3 = "Data object already executed"
            r4 = 10
            r0.sendLogBroadcast(r4, r3)     // Catch:{ IOException -> 0x01bf }
            r3 = 0
            r1.mRemoteErrorOccurred = r3     // Catch:{ IOException -> 0x01bf }
            goto L_0x01bd
        L_0x014a:
            throw r0     // Catch:{ IOException -> 0x01bf }
        L_0x014b:
            r0 = 1
            goto L_0x01d3
        L_0x014e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01bf }
            r3.<init>()     // Catch:{ IOException -> 0x01bf }
            int r10 = r9.offset     // Catch:{ IOException -> 0x01bf }
            r3.append(r10)     // Catch:{ IOException -> 0x01bf }
            r3.append(r4)     // Catch:{ IOException -> 0x01bf }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x01bf }
            r1.logi(r3)     // Catch:{ IOException -> 0x01bf }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ IOException -> 0x01bf }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01bf }
            r10.<init>()     // Catch:{ IOException -> 0x01bf }
            int r11 = r9.offset     // Catch:{ IOException -> 0x01bf }
            r10.append(r11)     // Catch:{ IOException -> 0x01bf }
            r10.append(r4)     // Catch:{ IOException -> 0x01bf }
            java.lang.String r4 = r10.toString()     // Catch:{ IOException -> 0x01bf }
            r10 = 15
            r3.sendLogBroadcast(r10, r4)     // Catch:{ IOException -> 0x01bf }
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r1.mProgressInfo     // Catch:{ IOException -> 0x01bf }
            r3.setBytesSent(r13)     // Catch:{ IOException -> 0x01bf }
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r1.mProgressInfo     // Catch:{ IOException -> 0x01bf }
            r3.setBytesReceived(r13)     // Catch:{ IOException -> 0x01bf }
            int r3 = r9.offset     // Catch:{ IOException -> 0x01bf }
            int r3 = r3 - r8
            r9.offset = r3     // Catch:{ IOException -> 0x01bf }
            r3 = 0
            r9.CRC32 = r3     // Catch:{ IOException -> 0x01bf }
            java.io.InputStream r3 = r1.mFirmwareStream     // Catch:{ IOException -> 0x01bf }
            r3.reset()     // Catch:{ IOException -> 0x01bf }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01bf }
            r3.<init>(r5)     // Catch:{ IOException -> 0x01bf }
            int r4 = r9.offset     // Catch:{ IOException -> 0x01bf }
            r3.append(r4)     // Catch:{ IOException -> 0x01bf }
            r3.append(r0)     // Catch:{ IOException -> 0x01bf }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x01bf }
            r1.logi(r3)     // Catch:{ IOException -> 0x01bf }
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService     // Catch:{ IOException -> 0x01bf }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01bf }
            r4.<init>(r5)     // Catch:{ IOException -> 0x01bf }
            int r5 = r9.offset     // Catch:{ IOException -> 0x01bf }
            r4.append(r5)     // Catch:{ IOException -> 0x01bf }
            r4.append(r0)     // Catch:{ IOException -> 0x01bf }
            java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x01bf }
            r4 = 10
            r3.sendLogBroadcast(r4, r0)     // Catch:{ IOException -> 0x01bf }
        L_0x01bd:
            r0 = 0
            goto L_0x01d3
        L_0x01bf:
            r0 = move-exception
            r1.loge(r12, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r3 = 4100(0x1004, float:5.745E-42)
            r0.terminateConnection(r2, r3)
            return
        L_0x01cb:
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r1.mProgressInfo
            r3 = 0
            r0.setBytesSent(r3)
            r0 = 0
            r7 = 0
        L_0x01d3:
            long r3 = android.os.SystemClock.elapsedRealtime()
            int r5 = r9.offset
            int r8 = r1.mImageSizeInBytes
            if (r5 >= r8) goto L_0x0436
            r5 = 1
        L_0x01de:
            no.nordicsemi.android.dfu.DfuProgressInfo r8 = r1.mProgressInfo
            int r8 = r8.getAvailableObjectSizeIsBytes()
            if (r8 <= 0) goto L_0x0433
            java.lang.String r8 = "Uploading firmware..."
            if (r0 != 0) goto L_0x0262
            no.nordicsemi.android.dfu.DfuProgressInfo r10 = r1.mProgressInfo
            int r10 = r10.getAvailableObjectSizeIsBytes()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r13 = "Creating Data object (Op Code = 1, Type = 2, Size = "
            r11.<init>(r13)
            r11.append(r10)
            java.lang.String r13 = ") ("
            r11.append(r13)
            int r13 = r7 + 1
            r11.append(r13)
            r19 = r0
            java.lang.String r0 = "/"
            r11.append(r0)
            r11.append(r6)
            r20 = r3
            r3 = r16
            r11.append(r3)
            java.lang.String r4 = r11.toString()
            r1.logi(r4)
            r4 = 2
            r1.writeCreateRequest(r4, r10)
            no.nordicsemi.android.dfu.DfuBaseService r4 = r1.mService
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Data object ("
            r10.<init>(r11)
            r10.append(r13)
            r10.append(r0)
            r10.append(r6)
            java.lang.String r0 = ") created"
            r10.append(r0)
            java.lang.String r0 = r10.toString()
            r10 = 10
            r4.sendLogBroadcast(r10, r0)
            long r10 = r1.prepareObjectDelay
            r22 = 0
            int r0 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r0 > 0) goto L_0x024a
            if (r6 != 0) goto L_0x0258
        L_0x024a:
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            long r10 = r1.prepareObjectDelay
            int r4 = (r10 > r22 ? 1 : (r10 == r22 ? 0 : -1))
            if (r4 <= 0) goto L_0x0253
            goto L_0x0255
        L_0x0253:
            r10 = 400(0x190, double:1.976E-321)
        L_0x0255:
            r0.waitFor(r10)
        L_0x0258:
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r4 = 10
            r0.sendLogBroadcast(r4, r8)
            r0 = r19
            goto L_0x0270
        L_0x0262:
            r20 = r3
            r3 = r16
            r4 = 10
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            java.lang.String r10 = "Resuming uploading firmware..."
            r0.sendLogBroadcast(r4, r10)
            r0 = 0
        L_0x0270:
            r1.logi(r8)     // Catch:{ DeviceDisconnectedException -> 0x042c }
            android.bluetooth.BluetoothGattCharacteristic r4 = r1.mPacketCharacteristic     // Catch:{ DeviceDisconnectedException -> 0x042c }
            r1.uploadFirmwareImage(r4)     // Catch:{ DeviceDisconnectedException -> 0x042c }
            java.lang.String r4 = "Sending Calculate Checksum command (Op Code = 3)"
            r1.logi(r4)
            no.nordicsemi.android.dfu.SecureDfuImpl$ObjectChecksum r4 = r24.readChecksum()
            java.util.Locale r8 = java.util.Locale.US
            int r10 = r4.offset
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            int r11 = r4.CRC32
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r16 = r0
            r13 = 2
            java.lang.Object[] r0 = new java.lang.Object[r13]
            r13 = 0
            r0[r13] = r10
            r10 = 1
            r0[r10] = r11
            java.lang.String r10 = "Checksum received (Offset = %d, CRC = %08X)"
            java.lang.String r0 = java.lang.String.format(r8, r10, r0)
            r1.logi(r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            java.util.Locale r8 = java.util.Locale.US
            int r11 = r4.offset
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r13 = r4.CRC32
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r19 = r3
            r22 = r6
            r3 = 2
            java.lang.Object[] r6 = new java.lang.Object[r3]
            r3 = 0
            r6[r3] = r11
            r3 = 1
            r6[r3] = r13
            java.lang.String r3 = java.lang.String.format(r8, r10, r6)
            r6 = 10
            r0.sendLogBroadcast(r6, r3)
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r1.mProgressInfo
            int r0 = r0.getBytesSent()
            int r3 = r4.offset
            int r0 = r0 - r3
            if (r0 <= 0) goto L_0x035c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r6 = " bytes were lost!"
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r1.logw(r3)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r0)
            java.lang.String r8 = " bytes were lost"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r8 = 15
            r3.sendLogBroadcast(r8, r6)
            java.io.InputStream r3 = r1.mFirmwareStream     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            r3.reset()     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            java.io.InputStream r3 = r1.mFirmwareStream     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            int r6 = r9.maxSize     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            int r6 = r6 - r0
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            r3.read(r6)     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r1.mProgressInfo     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            int r6 = r4.offset     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            r3.setBytesSent(r6)     // Catch:{ IOException -> 0x0350, all -> 0x0330 }
            int r3 = r1.mPacketsBeforeNotification
            if (r3 == 0) goto L_0x0320
            int r3 = r1.mPacketsBeforeNotification
            r6 = 1
            if (r3 <= r6) goto L_0x035c
            goto L_0x0321
        L_0x0320:
            r6 = 1
        L_0x0321:
            r1.mPacketsBeforeNotification = r6
            r1.setPacketReceiptNotifications(r6)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService
            java.lang.String r6 = "Packet Receipt Notif Req (Op Code = 2) sent (Value = 1)"
            r8 = 10
            r3.sendLogBroadcast(r8, r6)
            goto L_0x035c
        L_0x0330:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Progress lost. Bytes sent: "
            r3.<init>(r4)
            no.nordicsemi.android.dfu.DfuProgressInfo r4 = r1.mProgressInfo
            int r4 = r4.getBytesSent()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.loge(r3, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r3 = 4111(0x100f, float:5.761E-42)
            r0.terminateConnection(r2, r3)
            return
        L_0x0350:
            r0 = move-exception
            r1.loge(r12, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r3 = 4100(0x1004, float:5.745E-42)
            r0.terminateConnection(r2, r3)
            return
        L_0x035c:
            java.io.InputStream r3 = r1.mFirmwareStream
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r3 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r3
            long r10 = r3.getCrc32()
            r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r10 = r10 & r17
            int r3 = (int) r10
            int r6 = r4.CRC32
            if (r3 != r6) goto L_0x039d
            if (r0 <= 0) goto L_0x037b
            r16 = r19
            r3 = r20
            r6 = r22
            r0 = 1
            goto L_0x01de
        L_0x037b:
            r1.logi(r15)
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r1.mProgressInfo
            boolean r0 = r0.isComplete()
            r1.writeExecute(r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r3 = 10
            r0.sendLogBroadcast(r3, r14)
            int r7 = r7 + 1
            java.io.InputStream r0 = r1.mFirmwareStream
            r6 = 0
            r0.mark(r6)
            r13 = r6
            r3 = 3
            r5 = 1
            r6 = 15
            r10 = 2
            goto L_0x0402
        L_0x039d:
            r6 = 0
            java.util.Locale r0 = java.util.Locale.US
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r4 = r4.CRC32
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8 = 2
            java.lang.Object[] r10 = new java.lang.Object[r8]
            r10[r6] = r3
            r3 = 1
            r10[r3] = r4
            java.lang.String r3 = "CRC does not match! Expected %08X but found %08X."
            java.lang.String r0 = java.lang.String.format(r0, r3, r10)
            r3 = 3
            if (r5 >= r3) goto L_0x041a
            int r4 = r5 + 1
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.util.Locale r0 = java.util.Locale.US
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r10 = 2
            java.lang.Object[] r11 = new java.lang.Object[r10]
            r13 = 0
            r11[r13] = r6
            r6 = 1
            r11[r6] = r8
            java.lang.String r6 = " Retrying...(%d/%d)"
            java.lang.String r0 = java.lang.String.format(r0, r6, r11)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            r1.logi(r0)
            no.nordicsemi.android.dfu.DfuBaseService r5 = r1.mService
            r6 = 15
            r5.sendLogBroadcast(r6, r0)
            java.io.InputStream r0 = r1.mFirmwareStream     // Catch:{ IOException -> 0x040c }
            r0.reset()     // Catch:{ IOException -> 0x040c }
            no.nordicsemi.android.dfu.DfuProgressInfo r0 = r1.mProgressInfo     // Catch:{ IOException -> 0x040c }
            java.io.InputStream r5 = r1.mFirmwareStream     // Catch:{ IOException -> 0x040c }
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r5 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r5     // Catch:{ IOException -> 0x040c }
            int r5 = r5.getBytesRead()     // Catch:{ IOException -> 0x040c }
            r0.setBytesSent(r5)     // Catch:{ IOException -> 0x040c }
            r5 = r4
        L_0x0402:
            r0 = r16
            r16 = r19
            r3 = r20
            r6 = r22
            goto L_0x01de
        L_0x040c:
            r0 = move-exception
            java.lang.String r3 = "Error while resetting the firmware stream"
            r1.loge(r3, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r3 = 4100(0x1004, float:5.745E-42)
            r0.terminateConnection(r2, r3)
            return
        L_0x041a:
            r1.loge(r0)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r1.mService
            r4 = 20
            r3.sendLogBroadcast(r4, r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r3 = 4109(0x100d, float:5.758E-42)
            r0.terminateConnection(r2, r3)
            return
        L_0x042c:
            r0 = move-exception
            java.lang.String r2 = "Disconnected while sending data"
            r1.loge(r2)
            throw r0
        L_0x0433:
            r20 = r3
            goto L_0x0446
        L_0x0436:
            r20 = r3
            r1.logi(r15)
            r2 = 1
            r1.writeExecute(r2)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            r2 = 10
            r0.sendLogBroadcast(r2, r14)
        L_0x0446:
            long r2 = android.os.SystemClock.elapsedRealtime()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "Transfer of "
            r0.<init>(r4)
            no.nordicsemi.android.dfu.DfuProgressInfo r4 = r1.mProgressInfo
            int r4 = r4.getBytesSent()
            int r5 = r9.offset
            int r4 = r4 - r5
            r0.append(r4)
            java.lang.String r4 = " bytes has taken "
            r0.append(r4)
            long r2 = r2 - r20
            r0.append(r2)
            java.lang.String r4 = " ms"
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            r1.logi(r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r1.mService
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Upload completed in "
            r5.<init>(r6)
            r5.append(r2)
            r5.append(r4)
            java.lang.String r2 = r5.toString()
            r3 = 10
            r0.sendLogBroadcast(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.SecureDfuImpl.sendFirmware(android.bluetooth.BluetoothGatt):void");
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == i && ((b = bArr[2]) == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 7 || b == 8 || b == 10 || b == 11)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, i);
    }

    private void setNumberOfPackets(byte[] bArr, int i) {
        bArr[1] = (byte) (i & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
    }

    private void setObjectSize(byte[] bArr, int i) {
        bArr[2] = (byte) (i & 255);
        bArr[3] = (byte) ((i >> 8) & 255);
        bArr[4] = (byte) ((i >> 16) & 255);
        bArr[5] = (byte) ((i >> 24) & 255);
    }

    private void setPacketReceiptNotifications(int i) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            logi("Sending the number of packets before notifications (Op Code = 2, Value = " + i + ")");
            byte[] bArr = OP_CODE_PACKET_RECEIPT_NOTIF_REQ;
            setNumberOfPackets(bArr, i);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 2);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Sending the number of packets failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private void writeOpCode(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        writeOpCode(bluetoothGattCharacteristic, bArr, false);
    }

    private void writeCreateRequest(int i, int i2) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            byte[] bArr = i == 1 ? OP_CODE_CREATE_COMMAND : OP_CODE_CREATE_DATA;
            setObjectSize(bArr, i2);
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 1);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Creating Command object failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Creating Command object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to create object: device disconnected");
        }
    }

    private ObjectInfo selectObject(int i) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            byte[] bArr = OP_CODE_SELECT_OBJECT;
            bArr[1] = (byte) i;
            writeOpCode(this.mControlPointCharacteristic, bArr);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 6);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Selecting object failed", readNotificationResponse[3]);
            } else if (statusCode == 1) {
                ObjectInfo objectInfo = new ObjectInfo();
                objectInfo.maxSize = unsignedBytesToInt(readNotificationResponse, 3);
                objectInfo.offset = unsignedBytesToInt(readNotificationResponse, 7);
                objectInfo.CRC32 = unsignedBytesToInt(readNotificationResponse, 11);
                return objectInfo;
            } else {
                throw new RemoteDfuException("Selecting object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
        }
    }

    private ObjectChecksum readChecksum() throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_CALCULATE_CHECKSUM);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 3);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", readNotificationResponse[3]);
            } else if (statusCode == 1) {
                ObjectChecksum objectChecksum = new ObjectChecksum();
                objectChecksum.offset = unsignedBytesToInt(readNotificationResponse, 3);
                objectChecksum.CRC32 = unsignedBytesToInt(readNotificationResponse, 7);
                return objectChecksum;
            } else {
                throw new RemoteDfuException("Receiving Checksum failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private int unsignedBytesToInt(byte[] bArr, int i) {
        return (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8) + ((bArr[i + 2] & 255) << 16) + ((bArr[i + 3] & 255) << 24);
    }

    private void writeExecute() throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.mConnected) {
            writeOpCode(this.mControlPointCharacteristic, OP_CODE_EXECUTE);
            byte[] readNotificationResponse = readNotificationResponse();
            int statusCode = getStatusCode(readNotificationResponse, 4);
            if (statusCode == 11) {
                throw new RemoteDfuExtendedErrorException("Executing object failed", readNotificationResponse[3]);
            } else if (statusCode != 1) {
                throw new RemoteDfuException("Executing object failed", statusCode);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private void writeExecute(boolean z) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        try {
            writeExecute();
        } catch (RemoteDfuException e) {
            if (!z || e.getErrorNumber() != 5) {
                throw e;
            }
            logw(e.getMessage() + ": " + SecureDfuError.parse(517));
            if (this.mFileType == 1) {
                logw("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
            }
            this.mService.sendLogBroadcast(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", new Object[]{SecureDfuError.parse(517)}));
            logi("SD busy? Retrying...");
            logi("Executing data object (Op Code = 4)");
            writeExecute();
        }
    }

    private static class ObjectInfo extends ObjectChecksum {
        int maxSize;

        private ObjectInfo() {
            super();
        }
    }

    private static class ObjectChecksum {
        int CRC32;
        int offset;

        private ObjectChecksum() {
        }
    }
}
