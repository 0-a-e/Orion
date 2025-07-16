package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.BaseDfuImpl;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;

abstract class BaseCustomDfuImpl extends BaseDfuImpl {
    boolean mFirmwareUploadInProgress;
    /* access modifiers changed from: private */
    public boolean mInitPacketInProgress;
    int mPacketsBeforeNotification;
    /* access modifiers changed from: private */
    public int mPacketsSentSinceNotification;
    boolean mRemoteErrorOccurred;

    /* access modifiers changed from: protected */
    public abstract UUID getControlPointCharacteristicUUID();

    /* access modifiers changed from: protected */
    public abstract UUID getDfuServiceUUID();

    /* access modifiers changed from: protected */
    public abstract UUID getPacketCharacteristicUUID();

    class BaseCustomBluetoothCallback extends BaseDfuImpl.BaseBluetoothGattCallback {
        /* access modifiers changed from: protected */
        public void onPacketCharacteristicWrite() {
        }

        BaseCustomBluetoothCallback() {
            super();
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            boolean z = true;
            if (i == 0) {
                UUID uuid = bluetoothGattCharacteristic.getUuid();
                if (!uuid.equals(BaseCustomDfuImpl.this.getPacketCharacteristicUUID())) {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + uuid);
                    BaseCustomDfuImpl.this.mRequestCompleted = true;
                } else if (BaseCustomDfuImpl.this.mInitPacketInProgress) {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + uuid);
                    BaseCustomDfuImpl.this.mInitPacketInProgress = false;
                } else if (BaseCustomDfuImpl.this.mFirmwareUploadInProgress) {
                    BaseCustomDfuImpl baseCustomDfuImpl = BaseCustomDfuImpl.this;
                    baseCustomDfuImpl.mPacketsSentSinceNotification = baseCustomDfuImpl.mPacketsSentSinceNotification + 1;
                    if (BaseCustomDfuImpl.this.mPacketsBeforeNotification <= 0 || BaseCustomDfuImpl.this.mPacketsSentSinceNotification < BaseCustomDfuImpl.this.mPacketsBeforeNotification) {
                        z = false;
                    }
                    boolean isComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                    boolean isObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                    if (!z) {
                        if (isComplete || isObjectComplete) {
                            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                            BaseCustomDfuImpl.this.notifyLock();
                            return;
                        }
                        try {
                            BaseCustomDfuImpl.this.waitIfPaused();
                            if (!BaseCustomDfuImpl.this.mAborted && BaseCustomDfuImpl.this.mError == 0 && !BaseCustomDfuImpl.this.mRemoteErrorOccurred) {
                                if (!BaseCustomDfuImpl.this.mResetRequestSent) {
                                    int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                                    byte[] bArr = BaseCustomDfuImpl.this.mBuffer;
                                    if (availableObjectSizeIsBytes < bArr.length) {
                                        bArr = new byte[availableObjectSizeIsBytes];
                                    }
                                    BaseCustomDfuImpl.this.writePacket(bluetoothGatt, bluetoothGattCharacteristic, bArr, BaseCustomDfuImpl.this.mFirmwareStream.read(bArr));
                                    return;
                                }
                            }
                            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                            BaseCustomDfuImpl.this.mService.sendLogBroadcast(15, "Upload terminated");
                            BaseCustomDfuImpl.this.notifyLock();
                            return;
                        } catch (HexFileValidationException unused) {
                            BaseCustomDfuImpl.this.loge("Invalid HEX file");
                            BaseCustomDfuImpl.this.mError = 4099;
                        } catch (IOException e) {
                            BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                            BaseCustomDfuImpl.this.mError = 4100;
                        }
                    } else {
                        return;
                    }
                } else {
                    BaseCustomDfuImpl.this.mService.sendLogBroadcast(5, "Data written to " + uuid);
                    onPacketCharacteristicWrite();
                }
            } else if (BaseCustomDfuImpl.this.mResetRequestSent) {
                BaseCustomDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseCustomDfuImpl.this.loge("Characteristic write error: " + i);
                BaseCustomDfuImpl.this.mError = i | 16384;
            }
            BaseCustomDfuImpl.this.notifyLock();
        }

        /* access modifiers changed from: package-private */
        public void handlePacketReceiptNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            if (!BaseCustomDfuImpl.this.mFirmwareUploadInProgress) {
                handleNotification(bluetoothGatt, bluetoothGattCharacteristic, bArr);
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(BaseCustomDfuImpl.this.getDfuServiceUUID()).getCharacteristic(BaseCustomDfuImpl.this.getPacketCharacteristicUUID());
            try {
                BaseCustomDfuImpl.this.mPacketsSentSinceNotification = 0;
                BaseCustomDfuImpl.this.waitIfPaused();
                if (!BaseCustomDfuImpl.this.mAborted && BaseCustomDfuImpl.this.mError == 0 && !BaseCustomDfuImpl.this.mRemoteErrorOccurred) {
                    if (!BaseCustomDfuImpl.this.mResetRequestSent) {
                        boolean isComplete = BaseCustomDfuImpl.this.mProgressInfo.isComplete();
                        boolean isObjectComplete = BaseCustomDfuImpl.this.mProgressInfo.isObjectComplete();
                        if (!isComplete) {
                            if (!isObjectComplete) {
                                int availableObjectSizeIsBytes = BaseCustomDfuImpl.this.mProgressInfo.getAvailableObjectSizeIsBytes();
                                byte[] bArr2 = BaseCustomDfuImpl.this.mBuffer;
                                if (availableObjectSizeIsBytes < bArr2.length) {
                                    bArr2 = new byte[availableObjectSizeIsBytes];
                                }
                                BaseCustomDfuImpl.this.writePacket(bluetoothGatt, characteristic, bArr2, BaseCustomDfuImpl.this.mFirmwareStream.read(bArr2));
                                return;
                            }
                        }
                        BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                        BaseCustomDfuImpl.this.notifyLock();
                        return;
                    }
                }
                BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
                BaseCustomDfuImpl.this.mService.sendLogBroadcast(15, "Upload terminated");
            } catch (HexFileValidationException unused) {
                BaseCustomDfuImpl.this.loge("Invalid HEX file");
                BaseCustomDfuImpl.this.mError = 4099;
            } catch (IOException e) {
                BaseCustomDfuImpl.this.loge("Error while reading the input stream", e);
                BaseCustomDfuImpl.this.mError = 4100;
            }
        }

        /* access modifiers changed from: package-private */
        public void handleNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
            DfuBaseService dfuBaseService = BaseCustomDfuImpl.this.mService;
            dfuBaseService.sendLogBroadcast(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
            BaseCustomDfuImpl.this.mReceivedData = bArr;
            BaseCustomDfuImpl.this.mFirmwareUploadInProgress = false;
        }
    }

    BaseCustomDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
        int i = 0;
        int i2 = 12;
        if (intent.hasExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED)) {
            boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, false);
            int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, 12);
            if (intExtra >= 0 && intExtra <= 65535) {
                i2 = intExtra;
            }
            this.mPacketsBeforeNotification = booleanExtra ? i2 : i;
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(dfuBaseService);
        boolean z = defaultSharedPreferences.getBoolean(DfuSettingsConstants.SETTINGS_PACKET_RECEIPT_NOTIFICATION_ENABLED, false);
        try {
            int parseInt = Integer.parseInt(defaultSharedPreferences.getString(DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS, String.valueOf(12)));
            if (parseInt >= 0 && parseInt <= 65535) {
                i2 = parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        this.mPacketsBeforeNotification = z ? i2 : i;
    }

    /* access modifiers changed from: package-private */
    public void writeInitData(BluetoothGattCharacteristic bluetoothGattCharacteristic, CRC32 crc32) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        try {
            byte[] bArr = this.mBuffer;
            while (true) {
                int read = this.mInitPacketStream.read(bArr, 0, bArr.length);
                if (read != -1) {
                    writeInitPacket(bluetoothGattCharacteristic, bArr, read);
                    if (crc32 != null) {
                        crc32.update(bArr, 0, read);
                    }
                } else {
                    return;
                }
            }
        } catch (IOException e) {
            loge("Error while reading Init packet file", e);
            throw new DfuException("Error while reading Init packet file", 4098);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeInitPacket(android.bluetooth.BluetoothGattCharacteristic r5, byte[] r6, int r7) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r4 = this;
            boolean r0 = r4.mAborted
            if (r0 != 0) goto L_0x00f6
            int r0 = r6.length
            r1 = 0
            if (r0 == r7) goto L_0x000e
            byte[] r0 = new byte[r7]
            java.lang.System.arraycopy(r6, r1, r0, r1, r7)
            r6 = r0
        L_0x000e:
            r7 = 0
            r4.mReceivedData = r7
            r4.mError = r1
            r7 = 1
            r4.mInitPacketInProgress = r7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Sending init packet (size: "
            r0.<init>(r2)
            int r2 = r6.length
            r0.append(r2)
            java.lang.String r2 = ", value: 0x"
            r0.append(r2)
            java.lang.String r2 = r4.parse(r6)
            r0.append(r2)
            java.lang.String r2 = ")"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r4.logi(r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Writing to characteristic "
            r2.<init>(r3)
            java.util.UUID r3 = r5.getUuid()
            r2.append(r3)
            java.lang.String r3 = " value (0x): "
            r2.append(r3)
            java.lang.String r3 = r4.parse(r6)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.sendLogBroadcast(r7, r2)
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r0 < r2) goto L_0x0090
            no.nordicsemi.android.dfu.DfuBaseService r0 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "gatt.writeCharacteristic("
            r2.<init>(r3)
            java.util.UUID r3 = r5.getUuid()
            r2.append(r3)
            java.lang.String r3 = ", value=0x"
            r2.append(r3)
            java.lang.String r3 = r4.parse(r6)
            r2.append(r3)
            java.lang.String r3 = ", WRITE_TYPE_NO_RESPONSE)"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.sendLogBroadcast(r1, r2)
            android.bluetooth.BluetoothGatt r0 = r4.mGatt
            int unused = r0.writeCharacteristic(r5, r6, r7)
            goto L_0x00b7
        L_0x0090:
            r5.setWriteType(r7)
            r5.setValue(r6)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r4.mService
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "gatt.writeCharacteristic("
            r7.<init>(r0)
            java.util.UUID r0 = r5.getUuid()
            r7.append(r0)
            java.lang.String r0 = ")"
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.sendLogBroadcast(r1, r7)
            android.bluetooth.BluetoothGatt r6 = r4.mGatt
            r6.writeCharacteristic(r5)
        L_0x00b7:
            java.lang.Object r5 = r4.mLock     // Catch:{ InterruptedException -> 0x00d5 }
            monitor-enter(r5)     // Catch:{ InterruptedException -> 0x00d5 }
        L_0x00ba:
            boolean r6 = r4.mInitPacketInProgress     // Catch:{ all -> 0x00d2 }
            if (r6 == 0) goto L_0x00c6
            boolean r6 = r4.mConnected     // Catch:{ all -> 0x00d2 }
            if (r6 == 0) goto L_0x00c6
            int r6 = r4.mError     // Catch:{ all -> 0x00d2 }
            if (r6 == 0) goto L_0x00ca
        L_0x00c6:
            boolean r6 = r4.mPaused     // Catch:{ all -> 0x00d2 }
            if (r6 == 0) goto L_0x00d0
        L_0x00ca:
            java.lang.Object r6 = r4.mLock     // Catch:{ all -> 0x00d2 }
            r6.wait()     // Catch:{ all -> 0x00d2 }
            goto L_0x00ba
        L_0x00d0:
            monitor-exit(r5)     // Catch:{ all -> 0x00d2 }
            goto L_0x00db
        L_0x00d2:
            r6 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00d2 }
            throw r6     // Catch:{ InterruptedException -> 0x00d5 }
        L_0x00d5:
            r5 = move-exception
            java.lang.String r6 = "Sleeping interrupted"
            r4.loge(r6, r5)
        L_0x00db:
            boolean r5 = r4.mConnected
            if (r5 == 0) goto L_0x00ee
            int r5 = r4.mError
            if (r5 != 0) goto L_0x00e4
            return
        L_0x00e4:
            no.nordicsemi.android.dfu.internal.exception.DfuException r5 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r6 = "Unable to write Init DFU Parameters"
            int r7 = r4.mError
            r5.<init>(r6, r7)
            throw r5
        L_0x00ee:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r6 = "Unable to write Init DFU Parameters: device disconnected"
            r5.<init>(r6)
            throw r5
        L_0x00f6:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseCustomDfuImpl.writeInitPacket(android.bluetooth.BluetoothGattCharacteristic, byte[], int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadFirmwareImage(android.bluetooth.BluetoothGattCharacteristic r7) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r6 = this;
            java.lang.String r0 = "Sending firmware to characteristic "
            boolean r1 = r6.mAborted
            if (r1 != 0) goto L_0x009a
            r1 = 0
            r6.mReceivedData = r1
            r1 = 0
            r6.mError = r1
            r2 = 1
            r6.mFirmwareUploadInProgress = r2
            r6.mPacketsSentSinceNotification = r1
            no.nordicsemi.android.dfu.DfuProgressInfo r1 = r6.mProgressInfo     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            int r1 = r1.getAvailableObjectSizeIsBytes()     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            byte[] r3 = r6.mBuffer     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            int r4 = r3.length     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            if (r1 >= r4) goto L_0x001e
            byte[] r3 = new byte[r1]     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
        L_0x001e:
            java.io.InputStream r1 = r6.mFirmwareStream     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            int r1 = r1.read(r3)     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            no.nordicsemi.android.dfu.DfuBaseService r4 = r6.mService     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            r5.<init>(r0)     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            java.util.UUID r0 = r7.getUuid()     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            r5.append(r0)     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            java.lang.String r0 = "..."
            r5.append(r0)     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            java.lang.String r0 = r5.toString()     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            r4.sendLogBroadcast(r2, r0)     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            android.bluetooth.BluetoothGatt r0 = r6.mGatt     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            r6.writePacket(r0, r7, r3, r1)     // Catch:{ HexFileValidationException -> 0x0090, IOException -> 0x0086 }
            java.lang.Object r7 = r6.mLock     // Catch:{ InterruptedException -> 0x0065 }
            monitor-enter(r7)     // Catch:{ InterruptedException -> 0x0065 }
        L_0x0046:
            boolean r0 = r6.mFirmwareUploadInProgress     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0056
            byte[] r0 = r6.mReceivedData     // Catch:{ all -> 0x0062 }
            if (r0 != 0) goto L_0x0056
            boolean r0 = r6.mConnected     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0056
            int r0 = r6.mError     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x005a
        L_0x0056:
            boolean r0 = r6.mPaused     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0060
        L_0x005a:
            java.lang.Object r0 = r6.mLock     // Catch:{ all -> 0x0062 }
            r0.wait()     // Catch:{ all -> 0x0062 }
            goto L_0x0046
        L_0x0060:
            monitor-exit(r7)     // Catch:{ all -> 0x0062 }
            goto L_0x006b
        L_0x0062:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0062 }
            throw r0     // Catch:{ InterruptedException -> 0x0065 }
        L_0x0065:
            r7 = move-exception
            java.lang.String r0 = "Sleeping interrupted"
            r6.loge(r0, r7)
        L_0x006b:
            boolean r7 = r6.mConnected
            if (r7 == 0) goto L_0x007e
            int r7 = r6.mError
            if (r7 != 0) goto L_0x0074
            return
        L_0x0074:
            no.nordicsemi.android.dfu.internal.exception.DfuException r7 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r0 = "Uploading Firmware Image failed"
            int r1 = r6.mError
            r7.<init>(r0, r1)
            throw r7
        L_0x007e:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r7 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r0 = "Uploading Firmware Image failed: device disconnected"
            r7.<init>(r0)
            throw r7
        L_0x0086:
            no.nordicsemi.android.dfu.internal.exception.DfuException r7 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r0 = "Error while reading file"
            r1 = 4100(0x1004, float:5.745E-42)
            r7.<init>(r0, r1)
            throw r7
        L_0x0090:
            no.nordicsemi.android.dfu.internal.exception.DfuException r7 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r0 = "HEX file not valid"
            r1 = 4099(0x1003, float:5.744E-42)
            r7.<init>(r0, r1)
            throw r7
        L_0x009a:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r7 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseCustomDfuImpl.uploadFirmwareImage(android.bluetooth.BluetoothGattCharacteristic):void");
    }

    /* access modifiers changed from: private */
    public void writePacket(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
        if (i > 0) {
            if (bArr.length != i) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                bArr = bArr2;
            }
            this.mProgressInfo.addBytesSent(i);
            if (Build.VERSION.SDK_INT >= 33) {
                int unused = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic, bArr, 1);
                return;
            }
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
    }

    /* access modifiers changed from: package-private */
    public void finalize(Intent intent, boolean z) {
        boolean booleanExtra = intent.getBooleanExtra(DfuBaseService.EXTRA_KEEP_BOND, false);
        this.mService.refreshDeviceCache(this.mGatt, z || !booleanExtra);
        this.mService.close(this.mGatt);
        if (this.mGatt.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra(DfuBaseService.EXTRA_RESTORE_BOND, false);
            if (booleanExtra2 || !booleanExtra) {
                removeBond();
                this.mService.waitFor(2000);
            }
            if (booleanExtra2 && (this.mFileType & 4) > 0 && !createBond()) {
                logw("Creating bond failed");
            }
        }
        if (this.mProgressInfo.isLastPart()) {
            this.mProgressInfo.setProgress(-6);
            return;
        }
        logi("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, DfuBaseService.MIME_TYPE_ZIP);
        intent2.putExtra(DfuBaseService.EXTRA_FILE_TYPE, 4);
        intent2.putExtra(DfuBaseService.EXTRA_PART_CURRENT, this.mProgressInfo.getCurrentPart() + 1);
        intent2.putExtra(DfuBaseService.EXTRA_PARTS_TOTAL, this.mProgressInfo.getTotalParts());
        restartService(intent2, true);
    }
}
