package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuCallback;
import no.nordicsemi.android.dfu.internal.scanner.BootloaderScannerFactory;

abstract class BaseDfuImpl implements DfuService {
    static final UUID CLIENT_CHARACTERISTIC_CONFIG = new UUID(45088566677504L, -9223371485494954757L);
    static final UUID GENERIC_ATTRIBUTE_SERVICE_UUID = new UUID(26392574038016L, -9223371485494954757L);
    /* access modifiers changed from: private */
    public static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    static final int INDICATIONS = 2;
    private static final int MAX_PACKET_SIZE_DEFAULT = 20;
    static final int NOTIFICATIONS = 1;
    static final UUID SERVICE_CHANGED_UUID = new UUID(46200963207168L, -9223371485494954757L);
    private static final String TAG = "DfuImpl";
    boolean mAborted;
    byte[] mBuffer = new byte[20];
    boolean mConnected;
    /* access modifiers changed from: private */
    public int mCurrentMtu;
    int mError;
    int mFileType;
    InputStream mFirmwareStream;
    BluetoothGatt mGatt;
    int mImageSizeInBytes;
    int mInitPacketSizeInBytes;
    InputStream mInitPacketStream;
    final Object mLock = new Object();
    boolean mPaused;
    DfuProgressInfo mProgressInfo;
    byte[] mReceivedData = null;
    boolean mRequestCompleted;
    boolean mResetRequestSent;
    DfuBaseService mService;

    protected class BaseBluetoothGattCallback extends DfuCallback.DfuGattCallback {
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        }

        protected BaseBluetoothGattCallback() {
        }

        public void onDisconnected() {
            BaseDfuImpl.this.mConnected = false;
            BaseDfuImpl.this.notifyLock();
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i) {
            if (i == 0) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "Read Response received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + parse(bArr));
                BaseDfuImpl.this.mReceivedData = bArr;
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.loge("Characteristic read error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i, byte[] bArr) {
            if (i == 0) {
                UUID uuid = bluetoothGattDescriptor.getUuid();
                UUID uuid2 = bluetoothGattDescriptor.getCharacteristic().getUuid();
                BaseDfuImpl.this.mReceivedData = bArr;
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(uuid)) {
                    DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                    dfuBaseService.sendLogBroadcast(5, "Read Response received from descr." + uuid2 + ", value (0x): " + parse(bArr));
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(uuid2)) {
                        BaseDfuImpl.this.mRequestCompleted = true;
                    } else {
                        BaseDfuImpl.this.loge("Unknown descriptor read");
                    }
                }
            } else {
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.loge("Descriptor read error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            if (i == 0) {
                UUID uuid = bluetoothGattDescriptor.getUuid();
                UUID uuid2 = bluetoothGattDescriptor.getCharacteristic().getUuid();
                if (BaseDfuImpl.CLIENT_CHARACTERISTIC_CONFIG.equals(uuid)) {
                    DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                    dfuBaseService.sendLogBroadcast(5, "Data written to descr." + uuid2);
                    if (BaseDfuImpl.SERVICE_CHANGED_UUID.equals(uuid2)) {
                        DfuBaseService dfuBaseService2 = BaseDfuImpl.this.mService;
                        dfuBaseService2.sendLogBroadcast(1, "Indications enabled for " + uuid2);
                    } else {
                        DfuBaseService dfuBaseService3 = BaseDfuImpl.this.mService;
                        dfuBaseService3.sendLogBroadcast(1, "Notifications enabled for " + uuid2);
                    }
                }
                BaseDfuImpl.this.mRequestCompleted = true;
            } else {
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.loge("Descriptor write error: " + i);
                BaseDfuImpl.this.mError = i | 16384;
            }
            BaseDfuImpl.this.notifyLock();
        }

        public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
            if (i2 == 0) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "MTU changed to: " + i);
                int i3 = i + -3;
                if (i3 > BaseDfuImpl.this.mBuffer.length) {
                    BaseDfuImpl.this.mBuffer = new byte[i3];
                }
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.logi("MTU changed to: " + i);
            } else {
                BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
                baseDfuImpl2.logw("Changing MTU failed: " + i2 + " (mtu: " + i + ")");
                if (i2 == 4 && BaseDfuImpl.this.mCurrentMtu > 23 && BaseDfuImpl.this.mCurrentMtu - 3 > BaseDfuImpl.this.mBuffer.length) {
                    BaseDfuImpl baseDfuImpl3 = BaseDfuImpl.this;
                    baseDfuImpl3.mBuffer = new byte[(baseDfuImpl3.mCurrentMtu - 3)];
                    BaseDfuImpl baseDfuImpl4 = BaseDfuImpl.this;
                    baseDfuImpl4.logi("MTU restored to: " + BaseDfuImpl.this.mCurrentMtu);
                }
            }
            BaseDfuImpl.this.mRequestCompleted = true;
            BaseDfuImpl.this.notifyLock();
        }

        public void onPhyUpdate(BluetoothGatt bluetoothGatt, int i, int i2, int i3) {
            if (i3 == 0) {
                DfuBaseService dfuBaseService = BaseDfuImpl.this.mService;
                dfuBaseService.sendLogBroadcast(5, "PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
                BaseDfuImpl baseDfuImpl = BaseDfuImpl.this;
                baseDfuImpl.logi("PHY updated (TX: " + phyToString(i) + ", RX: " + phyToString(i2) + ")");
                return;
            }
            BaseDfuImpl baseDfuImpl2 = BaseDfuImpl.this;
            baseDfuImpl2.logw("Updating PHY failed: " + i3 + " (txPhy: " + i + ", rxPhy: " + i2 + ")");
        }

        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue());
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, bluetoothGattCharacteristic.getValue(), i);
        }

        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i, bluetoothGattDescriptor.getValue());
        }

        /* access modifiers changed from: protected */
        public int getInt(byte[] bArr, int i) {
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
        }

        /* access modifiers changed from: protected */
        public String parse(byte[] bArr) {
            int length;
            if (bArr == null || (length = bArr.length) == 0) {
                return "";
            }
            char[] cArr = new char[((length * 3) - 1)];
            for (int i = 0; i < length; i++) {
                byte b = bArr[i];
                int i2 = i * 3;
                cArr[i2] = BaseDfuImpl.HEX_ARRAY[(b & 255) >>> 4];
                cArr[i2 + 1] = BaseDfuImpl.HEX_ARRAY[b & 15];
                if (i != length - 1) {
                    cArr[i2 + 2] = '-';
                }
            }
            return new String(cArr);
        }

        private String phyToString(int i) {
            if (i == 1) {
                return "LE 1M";
            }
            if (i == 2) {
                return "LE 2M";
            }
            if (i == 3) {
                return "LE Coded";
            }
            return "UNKNOWN (" + i + ")";
        }
    }

    BaseDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        this.mService = dfuBaseService;
        this.mProgressInfo = dfuBaseService.mProgressInfo;
        this.mConnected = true;
    }

    public void release() {
        this.mService = null;
    }

    public void pause() {
        this.mPaused = true;
    }

    public void resume() {
        this.mPaused = false;
        notifyLock();
    }

    public void abort() {
        this.mPaused = false;
        this.mAborted = true;
        notifyLock();
    }

    public void onBondStateChanged(int i) {
        this.mRequestCompleted = true;
        notifyLock();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062 A[Catch:{ Exception -> 0x0074 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initialize(android.content.Intent r6, android.bluetooth.BluetoothGatt r7, int r8, java.io.InputStream r9, java.io.InputStream r10) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r5 = this;
            r5.mGatt = r7
            r5.mFileType = r8
            r5.mFirmwareStream = r9
            r5.mInitPacketStream = r10
            java.lang.String r0 = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT"
            r1 = 1
            int r0 = r6.getIntExtra(r0, r1)
            java.lang.String r2 = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL"
            int r2 = r6.getIntExtra(r2, r1)
            java.lang.String r3 = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU"
            r4 = 23
            int r6 = r6.getIntExtra(r3, r4)
            r5.mCurrentMtu = r6
            r6 = 4
            r3 = 15
            r4 = 2
            if (r8 <= r6) goto L_0x003f
            java.lang.String r6 = "DFU target does not support (SD/BL)+App update, splitting into 2 parts"
            r5.logw(r6)
            no.nordicsemi.android.dfu.DfuBaseService r6 = r5.mService
            java.lang.String r8 = "Sending system components"
            r6.sendLogBroadcast(r3, r8)
            int r6 = r5.mFileType
            r6 = r6 & -5
            r5.mFileType = r6
            java.io.InputStream r8 = r5.mFirmwareStream
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r8 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r8
            r8.setContentType(r6)
            r2 = r4
        L_0x003f:
            if (r0 != r4) goto L_0x0048
            no.nordicsemi.android.dfu.DfuBaseService r6 = r5.mService
            java.lang.String r8 = "Sending application"
            r6.sendLogBroadcast(r3, r8)
        L_0x0048:
            r6 = 0
            if (r10 == 0) goto L_0x0059
            boolean r8 = r10.markSupported()     // Catch:{ Exception -> 0x0059 }
            if (r8 == 0) goto L_0x0054
            r10.reset()     // Catch:{ Exception -> 0x0059 }
        L_0x0054:
            int r8 = r10.available()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005a
        L_0x0059:
            r8 = r6
        L_0x005a:
            r5.mInitPacketSizeInBytes = r8
            boolean r8 = r9.markSupported()     // Catch:{ Exception -> 0x0074 }
            if (r8 == 0) goto L_0x0070
            boolean r8 = r9 instanceof no.nordicsemi.android.dfu.internal.ArchiveInputStream     // Catch:{ Exception -> 0x0074 }
            if (r8 == 0) goto L_0x006d
            r8 = r9
            no.nordicsemi.android.dfu.internal.ArchiveInputStream r8 = (no.nordicsemi.android.dfu.internal.ArchiveInputStream) r8     // Catch:{ Exception -> 0x0074 }
            r8.fullReset()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0070
        L_0x006d:
            r9.reset()     // Catch:{ Exception -> 0x0074 }
        L_0x0070:
            int r6 = r9.available()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r5.mImageSizeInBytes = r6
            no.nordicsemi.android.dfu.DfuProgressInfo r8 = r5.mProgressInfo
            r8.init(r6, r0, r2)
            android.bluetooth.BluetoothDevice r6 = r7.getDevice()
            int r6 = r6.getBondState()
            r8 = 12
            if (r6 != r8) goto L_0x00ac
            java.util.UUID r6 = GENERIC_ATTRIBUTE_SERVICE_UUID
            android.bluetooth.BluetoothGattService r6 = r7.getService(r6)
            if (r6 == 0) goto L_0x00ac
            java.util.UUID r7 = SERVICE_CHANGED_UUID
            android.bluetooth.BluetoothGattCharacteristic r6 = r6.getCharacteristic(r7)
            if (r6 == 0) goto L_0x00ac
            boolean r7 = r5.isServiceChangedCCCDEnabled()
            if (r7 != 0) goto L_0x00a0
            r5.enableCCCD(r6, r4)
        L_0x00a0:
            java.lang.String r6 = "Service Changed indications enabled"
            r5.logi(r6)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r5.mService
            r8 = 10
            r7.sendLogBroadcast(r8, r6)
        L_0x00ac:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.initialize(android.content.Intent, android.bluetooth.BluetoothGatt, int, java.io.InputStream, java.io.InputStream):boolean");
    }

    /* access modifiers changed from: package-private */
    public void notifyLock() {
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    public void waitIfPaused() {
        try {
            synchronized (this.mLock) {
                while (this.mPaused) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enableCCCD(android.bluetooth.BluetoothGattCharacteristic r9, int r10) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r8 = this;
            android.bluetooth.BluetoothGatt r0 = r8.mGatt
            r1 = 1
            if (r10 != r1) goto L_0x0008
            java.lang.String r2 = "notifications"
            goto L_0x000a
        L_0x0008:
            java.lang.String r2 = "indications"
        L_0x000a:
            boolean r3 = r8.mConnected
            if (r3 == 0) goto L_0x011a
            boolean r3 = r8.mAborted
            if (r3 != 0) goto L_0x0114
            r3 = 0
            r8.mRequestCompleted = r3
            r4 = 0
            r8.mReceivedData = r4
            r8.mError = r3
            java.util.UUID r4 = CLIENT_CHARACTERISTIC_CONFIG
            android.bluetooth.BluetoothGattDescriptor r4 = r9.getDescriptor(r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Enabling "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r6 = "..."
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r8.logi(r5)
            no.nordicsemi.android.dfu.DfuBaseService r5 = r8.mService
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Enabling "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " for "
            r6.append(r7)
            java.util.UUID r7 = r9.getUuid()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.sendLogBroadcast(r1, r6)
            no.nordicsemi.android.dfu.DfuBaseService r5 = r8.mService
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "gatt.setCharacteristicNotification("
            r6.<init>(r7)
            java.util.UUID r7 = r9.getUuid()
            r6.append(r7)
            java.lang.String r7 = ", true)"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.sendLogBroadcast(r3, r6)
            r0.setCharacteristicNotification(r9, r1)
            no.nordicsemi.android.dfu.DfuBaseService r9 = r8.mService
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "gatt.writeDescriptor("
            r5.<init>(r6)
            java.util.UUID r6 = r4.getUuid()
            r5.append(r6)
            if (r10 != r1) goto L_0x0089
            java.lang.String r6 = ", value=0x01-00)"
            goto L_0x008b
        L_0x0089:
            java.lang.String r6 = ", value=0x02-00)"
        L_0x008b:
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r9.sendLogBroadcast(r3, r5)
            int r9 = android.os.Build.VERSION.SDK_INT
            r3 = 33
            if (r9 < r3) goto L_0x00a6
            if (r10 != r1) goto L_0x00a0
            byte[] r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            goto L_0x00a2
        L_0x00a0:
            byte[] r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
        L_0x00a2:
            int unused = r0.writeDescriptor(r4, r9)
            goto L_0x00b3
        L_0x00a6:
            if (r10 != r1) goto L_0x00ab
            byte[] r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
            goto L_0x00ad
        L_0x00ab:
            byte[] r9 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
        L_0x00ad:
            r4.setValue(r9)
            r0.writeDescriptor(r4)
        L_0x00b3:
            java.lang.Object r9 = r8.mLock     // Catch:{ InterruptedException -> 0x00d1 }
            monitor-enter(r9)     // Catch:{ InterruptedException -> 0x00d1 }
        L_0x00b6:
            boolean r10 = r8.mRequestCompleted     // Catch:{ all -> 0x00ce }
            if (r10 != 0) goto L_0x00c2
            boolean r10 = r8.mConnected     // Catch:{ all -> 0x00ce }
            if (r10 == 0) goto L_0x00c2
            int r10 = r8.mError     // Catch:{ all -> 0x00ce }
            if (r10 == 0) goto L_0x00c6
        L_0x00c2:
            boolean r10 = r8.mPaused     // Catch:{ all -> 0x00ce }
            if (r10 == 0) goto L_0x00cc
        L_0x00c6:
            java.lang.Object r10 = r8.mLock     // Catch:{ all -> 0x00ce }
            r10.wait()     // Catch:{ all -> 0x00ce }
            goto L_0x00b6
        L_0x00cc:
            monitor-exit(r9)     // Catch:{ all -> 0x00ce }
            goto L_0x00d7
        L_0x00ce:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00ce }
            throw r10     // Catch:{ InterruptedException -> 0x00d1 }
        L_0x00d1:
            r9 = move-exception
            java.lang.String r10 = "Sleeping interrupted"
            r8.loge(r10, r9)
        L_0x00d7:
            boolean r9 = r8.mConnected
            if (r9 == 0) goto L_0x00fb
            int r9 = r8.mError
            if (r9 != 0) goto L_0x00e0
            return
        L_0x00e0:
            no.nordicsemi.android.dfu.internal.exception.DfuException r9 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to set "
            r10.<init>(r0)
            r10.append(r2)
            java.lang.String r0 = " state"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            int r0 = r8.mError
            r9.<init>(r10, r0)
            throw r9
        L_0x00fb:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r9 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to set "
            r10.<init>(r0)
            r10.append(r2)
            java.lang.String r0 = " state: device disconnected"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0114:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r9 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r9.<init>()
            throw r9
        L_0x011a:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r9 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to set "
            r10.<init>(r0)
            r10.append(r2)
            java.lang.String r0 = " state: device disconnected"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.enableCCCD(android.bluetooth.BluetoothGattCharacteristic, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isServiceChangedCCCDEnabled() throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r7 = this;
            boolean r0 = r7.mConnected
            if (r0 == 0) goto L_0x00b7
            boolean r0 = r7.mAborted
            if (r0 != 0) goto L_0x00b1
            android.bluetooth.BluetoothGatt r0 = r7.mGatt
            java.util.UUID r1 = GENERIC_ATTRIBUTE_SERVICE_UUID
            android.bluetooth.BluetoothGattService r1 = r0.getService(r1)
            r2 = 0
            if (r1 != 0) goto L_0x0014
            return r2
        L_0x0014:
            java.util.UUID r3 = SERVICE_CHANGED_UUID
            android.bluetooth.BluetoothGattCharacteristic r1 = r1.getCharacteristic(r3)
            if (r1 != 0) goto L_0x001d
            return r2
        L_0x001d:
            java.util.UUID r3 = CLIENT_CHARACTERISTIC_CONFIG
            android.bluetooth.BluetoothGattDescriptor r1 = r1.getDescriptor(r3)
            if (r1 != 0) goto L_0x0026
            return r2
        L_0x0026:
            r7.mRequestCompleted = r2
            r3 = 0
            r7.mReceivedData = r3
            r7.mError = r2
            java.lang.String r3 = "Reading Service Changed CCCD value..."
            r7.logi(r3)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r7.mService
            java.lang.String r4 = "Reading Service Changed CCCD value..."
            r5 = 1
            r3.sendLogBroadcast(r5, r4)
            no.nordicsemi.android.dfu.DfuBaseService r3 = r7.mService
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "gatt.readDescriptor("
            r4.<init>(r6)
            java.util.UUID r6 = r1.getUuid()
            r4.append(r6)
            java.lang.String r6 = ")"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            r3.sendLogBroadcast(r2, r4)
            r0.readDescriptor(r1)
            java.lang.Object r0 = r7.mLock     // Catch:{ InterruptedException -> 0x0077 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0077 }
        L_0x005c:
            boolean r1 = r7.mRequestCompleted     // Catch:{ all -> 0x0074 }
            if (r1 != 0) goto L_0x0068
            boolean r1 = r7.mConnected     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0068
            int r1 = r7.mError     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x006c
        L_0x0068:
            boolean r1 = r7.mPaused     // Catch:{ all -> 0x0074 }
            if (r1 == 0) goto L_0x0072
        L_0x006c:
            java.lang.Object r1 = r7.mLock     // Catch:{ all -> 0x0074 }
            r1.wait()     // Catch:{ all -> 0x0074 }
            goto L_0x005c
        L_0x0072:
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            goto L_0x007d
        L_0x0074:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0074 }
            throw r1     // Catch:{ InterruptedException -> 0x0077 }
        L_0x0077:
            r0 = move-exception
            java.lang.String r1 = "Sleeping interrupted"
            r7.loge(r1, r0)
        L_0x007d:
            boolean r0 = r7.mConnected
            if (r0 == 0) goto L_0x00a9
            int r0 = r7.mError
            if (r0 != 0) goto L_0x009f
            byte[] r0 = r7.mReceivedData
            if (r0 == 0) goto L_0x009e
            int r1 = r0.length
            r3 = 2
            if (r1 != r3) goto L_0x009e
            byte r1 = r0[r2]
            byte[] r3 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
            byte r3 = r3[r2]
            if (r1 != r3) goto L_0x009e
            byte r0 = r0[r5]
            byte[] r1 = android.bluetooth.BluetoothGattDescriptor.ENABLE_INDICATION_VALUE
            byte r1 = r1[r5]
            if (r0 != r1) goto L_0x009e
            r2 = r5
        L_0x009e:
            return r2
        L_0x009f:
            no.nordicsemi.android.dfu.internal.exception.DfuException r0 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r1 = "Unable to read Service Changed CCCD"
            int r2 = r7.mError
            r0.<init>(r1, r2)
            throw r0
        L_0x00a9:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r0 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r1 = "Unable to read Service Changed CCCD: device disconnected"
            r0.<init>(r1)
            throw r0
        L_0x00b1:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r0 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r0.<init>()
            throw r0
        L_0x00b7:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r0 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r1 = "Unable to read Service Changed CCCD: device disconnected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.isServiceChangedCCCDEnabled():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeOpCode(android.bluetooth.BluetoothGattCharacteristic r5, byte[] r6, boolean r7) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r4 = this;
            boolean r0 = r4.mAborted
            if (r0 != 0) goto L_0x00f6
            r0 = 0
            r4.mReceivedData = r0
            r0 = 0
            r4.mError = r0
            r4.mRequestCompleted = r0
            r4.mResetRequestSent = r7
            no.nordicsemi.android.dfu.DfuBaseService r7 = r4.mService
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Writing to characteristic "
            r1.<init>(r2)
            java.util.UUID r2 = r5.getUuid()
            r1.append(r2)
            java.lang.String r2 = ", value (0x): "
            r1.append(r2)
            java.lang.String r2 = r4.parse(r6)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 1
            r7.sendLogBroadcast(r2, r1)
            int r7 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 2
            if (r7 < r1) goto L_0x0067
            no.nordicsemi.android.dfu.DfuBaseService r7 = r4.mService
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "gatt.writeCharacteristic("
            r1.<init>(r3)
            java.util.UUID r3 = r5.getUuid()
            r1.append(r3)
            java.lang.String r3 = ", value=0x"
            r1.append(r3)
            java.lang.String r3 = r4.parse(r6)
            r1.append(r3)
            java.lang.String r3 = ", WRITE_TYPE_DEFAULT)"
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r7.sendLogBroadcast(r0, r1)
            android.bluetooth.BluetoothGatt r7 = r4.mGatt
            int unused = r7.writeCharacteristic(r5, r6, r2)
            goto L_0x008e
        L_0x0067:
            r5.setWriteType(r2)
            r5.setValue(r6)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r4.mService
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "gatt.writeCharacteristic("
            r1.<init>(r2)
            java.util.UUID r2 = r5.getUuid()
            r1.append(r2)
            java.lang.String r2 = ")"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r7.sendLogBroadcast(r0, r1)
            android.bluetooth.BluetoothGatt r7 = r4.mGatt
            r7.writeCharacteristic(r5)
        L_0x008e:
            java.lang.Object r5 = r4.mLock     // Catch:{ InterruptedException -> 0x00ac }
            monitor-enter(r5)     // Catch:{ InterruptedException -> 0x00ac }
        L_0x0091:
            boolean r7 = r4.mRequestCompleted     // Catch:{ all -> 0x00a9 }
            if (r7 != 0) goto L_0x009d
            boolean r7 = r4.mConnected     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x009d
            int r7 = r4.mError     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x00a1
        L_0x009d:
            boolean r7 = r4.mPaused     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x00a7
        L_0x00a1:
            java.lang.Object r7 = r4.mLock     // Catch:{ all -> 0x00a9 }
            r7.wait()     // Catch:{ all -> 0x00a9 }
            goto L_0x0091
        L_0x00a7:
            monitor-exit(r5)     // Catch:{ all -> 0x00a9 }
            goto L_0x00b2
        L_0x00a9:
            r7 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00a9 }
            throw r7     // Catch:{ InterruptedException -> 0x00ac }
        L_0x00ac:
            r5 = move-exception
            java.lang.String r7 = "Sleeping interrupted"
            r4.loge(r7, r5)
        L_0x00b2:
            boolean r5 = r4.mResetRequestSent
            if (r5 != 0) goto L_0x00d6
            boolean r7 = r4.mConnected
            if (r7 == 0) goto L_0x00bb
            goto L_0x00d6
        L_0x00bb:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to write Op Code "
            r7.<init>(r1)
            byte r6 = r6[r0]
            r7.append(r6)
            java.lang.String r6 = ": device disconnected"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L_0x00d6:
            if (r5 != 0) goto L_0x00f5
            int r5 = r4.mError
            if (r5 != 0) goto L_0x00dd
            goto L_0x00f5
        L_0x00dd:
            no.nordicsemi.android.dfu.internal.exception.DfuException r5 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to write Op Code "
            r7.<init>(r1)
            byte r6 = r6[r0]
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            int r7 = r4.mError
            r5.<init>(r6, r7)
            throw r5
        L_0x00f5:
            return
        L_0x00f6:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.writeOpCode(android.bluetooth.BluetoothGattCharacteristic, byte[], boolean):void");
    }

    /* access modifiers changed from: package-private */
    public boolean createBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        this.mRequestCompleted = false;
        this.mService.sendLogBroadcast(1, "Starting pairing...");
        this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond()");
        boolean createBond = device.createBond();
        try {
            synchronized (this.mLock) {
                while (createBond) {
                    if (this.mRequestCompleted || this.mAborted) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e) {
            loge("Sleeping interrupted", e);
        }
        return createBond;
    }

    private boolean createBondApi18(BluetoothDevice bluetoothDevice) {
        try {
            Method method = bluetoothDevice.getClass().getMethod("createBond", (Class[]) null);
            this.mService.sendLogBroadcast(0, "gatt.getDevice().createBond() (hidden)");
            return ((Boolean) method.invoke(bluetoothDevice, (Object[]) null)).booleanValue();
        } catch (Exception e) {
            Log.w(TAG, "An exception occurred while creating bond", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean removeBond() {
        BluetoothDevice device = this.mGatt.getDevice();
        if (device.getBondState() == 10) {
            return true;
        }
        this.mService.sendLogBroadcast(1, "Removing bond information...");
        boolean z = false;
        try {
            Method method = device.getClass().getMethod("removeBond", (Class[]) null);
            this.mRequestCompleted = false;
            this.mService.sendLogBroadcast(0, "gatt.getDevice().removeBond() (hidden)");
            z = ((Boolean) method.invoke(device, (Object[]) null)).booleanValue();
            try {
                synchronized (this.mLock) {
                    while (!this.mRequestCompleted && !this.mAborted) {
                        this.mLock.wait();
                    }
                }
            } catch (InterruptedException e) {
                loge("Sleeping interrupted", e);
            }
        } catch (Exception e2) {
            Log.w(TAG, "An exception occurred while removing bond information", e2);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean isBonded() {
        return this.mGatt.getDevice().getBondState() == 12;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void requestMtu(int r5) throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r4 = this;
            java.lang.String r0 = android.os.Build.HARDWARE
            java.lang.String r1 = "ums512_25c10"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x001a
            r0 = 516(0x204, float:7.23E-43)
            if (r5 != r0) goto L_0x0014
            java.lang.String r0 = "MTU request forced"
            r4.logw(r0)
            goto L_0x001a
        L_0x0014:
            java.lang.String r5 = "MTU request disabled for this device. See https://github.com/NordicSemiconductor/Android-DFU-Library/issues/339"
            r4.logw(r5)
            return
        L_0x001a:
            boolean r0 = r4.mAborted
            if (r0 != 0) goto L_0x007b
            r0 = 0
            r4.mRequestCompleted = r0
            no.nordicsemi.android.dfu.DfuBaseService r1 = r4.mService
            r2 = 1
            java.lang.String r3 = "Requesting new MTU..."
            r1.sendLogBroadcast(r2, r3)
            no.nordicsemi.android.dfu.DfuBaseService r1 = r4.mService
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "gatt.requestMtu("
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r3 = ")"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.sendLogBroadcast(r0, r2)
            android.bluetooth.BluetoothGatt r0 = r4.mGatt
            boolean r5 = r0.requestMtu(r5)
            if (r5 != 0) goto L_0x004a
            return
        L_0x004a:
            java.lang.Object r5 = r4.mLock     // Catch:{ InterruptedException -> 0x0068 }
            monitor-enter(r5)     // Catch:{ InterruptedException -> 0x0068 }
        L_0x004d:
            boolean r0 = r4.mRequestCompleted     // Catch:{ all -> 0x0065 }
            if (r0 != 0) goto L_0x0059
            boolean r0 = r4.mConnected     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x0059
            int r0 = r4.mError     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x005d
        L_0x0059:
            boolean r0 = r4.mPaused     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x0063
        L_0x005d:
            java.lang.Object r0 = r4.mLock     // Catch:{ all -> 0x0065 }
            r0.wait()     // Catch:{ all -> 0x0065 }
            goto L_0x004d
        L_0x0063:
            monitor-exit(r5)     // Catch:{ all -> 0x0065 }
            goto L_0x006e
        L_0x0065:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0065 }
            throw r0     // Catch:{ InterruptedException -> 0x0068 }
        L_0x0068:
            r5 = move-exception
            java.lang.String r0 = "Sleeping interrupted"
            r4.loge(r0, r5)
        L_0x006e:
            boolean r5 = r4.mConnected
            if (r5 == 0) goto L_0x0073
            return
        L_0x0073:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r5 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r0 = "Unable to read Service Changed CCCD: device disconnected"
            r5.<init>(r0)
            throw r5
        L_0x007b:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r5 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.requestMtu(int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] readNotificationResponse() throws no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock     // Catch:{ InterruptedException -> 0x0022 }
            monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0022 }
        L_0x0003:
            byte[] r1 = r3.mReceivedData     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r3.mConnected     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0013
            int r1 = r3.mError     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r3.mAborted     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0017
        L_0x0013:
            boolean r1 = r3.mPaused     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x001d
        L_0x0017:
            java.lang.Object r1 = r3.mLock     // Catch:{ all -> 0x001f }
            r1.wait()     // Catch:{ all -> 0x001f }
            goto L_0x0003
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            goto L_0x0028
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r1     // Catch:{ InterruptedException -> 0x0022 }
        L_0x0022:
            r0 = move-exception
            java.lang.String r1 = "Sleeping interrupted"
            r3.loge(r1, r0)
        L_0x0028:
            boolean r0 = r3.mAborted
            if (r0 != 0) goto L_0x0049
            boolean r0 = r3.mConnected
            if (r0 == 0) goto L_0x0041
            int r0 = r3.mError
            if (r0 != 0) goto L_0x0037
            byte[] r0 = r3.mReceivedData
            return r0
        L_0x0037:
            no.nordicsemi.android.dfu.internal.exception.DfuException r0 = new no.nordicsemi.android.dfu.internal.exception.DfuException
            java.lang.String r1 = "Unable to write Op Code"
            int r2 = r3.mError
            r0.<init>(r1, r2)
            throw r0
        L_0x0041:
            no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException r0 = new no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException
            java.lang.String r1 = "Unable to write Op Code: device disconnected"
            r0.<init>(r1)
            throw r0
        L_0x0049:
            no.nordicsemi.android.dfu.internal.exception.UploadAbortedException r0 = new no.nordicsemi.android.dfu.internal.exception.UploadAbortedException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.BaseDfuImpl.readNotificationResponse():byte[]");
    }

    /* access modifiers changed from: package-private */
    public void restartService(Intent intent, boolean z) {
        String str;
        if (z) {
            long longExtra = intent.getLongExtra(DfuBaseService.EXTRA_SCAN_DELAY, 0);
            long longExtra2 = intent.getLongExtra(DfuBaseService.EXTRA_SCAN_TIMEOUT, 5000);
            DfuBaseService dfuBaseService = this.mService;
            dfuBaseService.sendLogBroadcast(1, "Scanning for the DFU Bootloader... (timeout " + longExtra2 + " ms)");
            if (longExtra > 0) {
                this.mService.waitFor(longExtra);
            }
            str = BootloaderScannerFactory.getScanner(this.mGatt.getDevice().getAddress()).searchUsing(this.mService.getDeviceSelector(), longExtra2);
            logi("Scanning for new address finished with: " + str);
            if (str != null) {
                DfuBaseService dfuBaseService2 = this.mService;
                dfuBaseService2.sendLogBroadcast(5, "DFU Bootloader found with address " + str);
            } else {
                this.mService.sendLogBroadcast(5, "DFU Bootloader not found. Trying the same address...");
            }
        } else {
            str = null;
        }
        if (str != null) {
            intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, str);
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT", 0);
        if (!intent.getBooleanExtra(DfuBaseService.EXTRA_FOREGROUND_SERVICE, true) || Build.VERSION.SDK_INT < 26) {
            this.mService.startService(intent);
        } else {
            ComponentName unused = this.mService.startForegroundService(intent);
        }
    }

    /* access modifiers changed from: protected */
    public String parse(byte[] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return "";
        }
        char[] cArr = new char[((length * 3) - 1)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = i * 3;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
            if (i != length - 1) {
                cArr[i2 + 2] = '-';
            }
        }
        return new String(cArr);
    }

    /* access modifiers changed from: package-private */
    public void loge(String str) {
        Log.e(TAG, str);
    }

    /* access modifiers changed from: package-private */
    public void loge(String str, Throwable th) {
        Log.e(TAG, str, th);
    }

    /* access modifiers changed from: package-private */
    public void logw(String str) {
        if (DfuBaseService.DEBUG) {
            Log.w(TAG, str);
        }
    }

    /* access modifiers changed from: package-private */
    public void logi(String str) {
        if (DfuBaseService.DEBUG) {
            Log.i(TAG, str);
        }
    }
}
