package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;

abstract class ButtonlessDfuImpl extends BaseButtonlessDfuImpl {
    private static final int DFU_STATUS_SUCCESS = 1;
    private static final byte[] OP_CODE_ENTER_BOOTLOADER = {1};
    private static final int OP_CODE_ENTER_BOOTLOADER_KEY = 1;
    private static final int OP_CODE_RESPONSE_CODE_KEY = 32;

    /* access modifiers changed from: protected */
    public abstract BluetoothGattCharacteristic getButtonlessDfuCharacteristic();

    /* access modifiers changed from: protected */
    public abstract int getResponseType();

    /* access modifiers changed from: protected */
    public abstract boolean shouldScanForBootloader();

    ButtonlessDfuImpl(Intent intent, DfuBaseService dfuBaseService) {
        super(intent, dfuBaseService);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4 = r12.mReceivedData;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0062 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performDfu(android.content.Intent r13) throws no.nordicsemi.android.dfu.internal.exception.DfuException, no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException, no.nordicsemi.android.dfu.internal.exception.UploadAbortedException {
        /*
            r12 = this;
            java.lang.String r0 = ")"
            java.lang.String r1 = ", Status = "
            java.lang.String r2 = "Response received (Op Code = "
            no.nordicsemi.android.dfu.DfuProgressInfo r3 = r12.mProgressInfo
            r4 = -2
            r3.setProgress(r4)
            android.bluetooth.BluetoothGatt r3 = r12.mGatt
            no.nordicsemi.android.dfu.DfuBaseService r4 = r12.mService
            r5 = 15
            java.lang.String r6 = "Application with buttonless update found"
            r4.sendLogBroadcast(r5, r6)
            no.nordicsemi.android.dfu.DfuBaseService r4 = r12.mService
            java.lang.String r5 = "Jumping to the DFU Bootloader..."
            r6 = 1
            r4.sendLogBroadcast(r6, r5)
            android.bluetooth.BluetoothGattCharacteristic r4 = r12.getButtonlessDfuCharacteristic()
            int r5 = r12.getResponseType()
            int r7 = r12.getResponseType()
            r12.enableCCCD(r4, r7)
            no.nordicsemi.android.dfu.DfuBaseService r7 = r12.mService
            r8 = 2
            if (r5 != r8) goto L_0x0036
            java.lang.String r5 = "Indications"
            goto L_0x0038
        L_0x0036:
            java.lang.String r5 = "Notifications"
        L_0x0038:
            java.lang.String r8 = " enabled"
            java.lang.String r5 = r5.concat(r8)
            r8 = 10
            r7.sendLogBroadcast(r8, r5)
            r5 = 0
            r7 = 20
            no.nordicsemi.android.dfu.DfuProgressInfo r9 = r12.mProgressInfo     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r10 = -3
            r9.setProgress(r10)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            java.lang.String r9 = "Sending Enter Bootloader (Op Code = 1)"
            r12.logi(r9)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            byte[] r9 = OP_CODE_ENTER_BOOTLOADER     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r12.writeOpCode(r4, r9, r6)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            no.nordicsemi.android.dfu.DfuBaseService r4 = r12.mService     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            java.lang.String r9 = "Enter bootloader sent (Op Code = 1)"
            r4.sendLogBroadcast(r8, r9)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            byte[] r4 = r12.readNotificationResponse()     // Catch:{ DeviceDisconnectedException -> 0x0062 }
            goto L_0x0064
        L_0x0062:
            byte[] r4 = r12.mReceivedData     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
        L_0x0064:
            if (r4 == 0) goto L_0x00c9
            int r9 = r12.getStatusCode(r4, r6)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r10.<init>(r2)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            byte r11 = r4[r6]     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r10.append(r11)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r10.append(r1)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r10.append(r9)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r10.append(r0)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            java.lang.String r10 = r10.toString()     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r12.logi(r10)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            no.nordicsemi.android.dfu.DfuBaseService r10 = r12.mService     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r11.<init>(r2)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            byte r2 = r4[r6]     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r11.append(r2)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r11.append(r1)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r11.append(r9)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r11.append(r0)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            java.lang.String r0 = r11.toString()     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r10.sendLogBroadcast(r8, r0)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            if (r9 != r6) goto L_0x00c1
            boolean r0 = r12.shouldScanForBootloader()     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            if (r0 == 0) goto L_0x00ae
            no.nordicsemi.android.dfu.DfuBaseService r0 = r12.mService     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r0.disconnect(r3)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            goto L_0x00bb
        L_0x00ae:
            no.nordicsemi.android.dfu.DfuBaseService r0 = r12.mService     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r0.waitUntilDisconnected()     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            no.nordicsemi.android.dfu.DfuBaseService r0 = r12.mService     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            java.lang.String r1 = "Disconnected by the remote device"
            r2 = 5
            r0.sendLogBroadcast(r2, r1)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
        L_0x00bb:
            java.lang.String r0 = "Device disconnected"
            r12.logi(r0)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            goto L_0x00ce
        L_0x00c1:
            no.nordicsemi.android.dfu.internal.exception.RemoteDfuException r13 = new no.nordicsemi.android.dfu.internal.exception.RemoteDfuException     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            java.lang.String r0 = "Device returned error after sending Enter Bootloader"
            r13.<init>(r0, r9)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            throw r13     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
        L_0x00c9:
            java.lang.String r0 = "Device disconnected before receiving notification"
            r12.logi(r0)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
        L_0x00ce:
            boolean r0 = r12.shouldScanForBootloader()     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            r12.finalize(r13, r5, r0)     // Catch:{ UnknownResponseException -> 0x0101, RemoteDfuException -> 0x00d6 }
            goto L_0x0119
        L_0x00d6:
            r13 = move-exception
            int r0 = r13.getErrorNumber()
            r1 = r0 | 2048(0x800, float:2.87E-42)
            java.lang.String r13 = r13.getMessage()
            r12.loge(r13)
            no.nordicsemi.android.dfu.DfuBaseService r13 = r12.mService
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r1 = no.nordicsemi.android.error.SecureDfuError.parseButtonlessError(r1)
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r5] = r1
            java.lang.String r1 = "Remote DFU error: %s"
            java.lang.String r1 = java.lang.String.format(r2, r1, r4)
            r13.sendLogBroadcast(r7, r1)
            no.nordicsemi.android.dfu.DfuBaseService r13 = r12.mService
            r0 = r0 | 10240(0x2800, float:1.4349E-41)
            r13.terminateConnection(r3, r0)
            goto L_0x0119
        L_0x0101:
            r13 = move-exception
            java.lang.String r0 = r13.getMessage()
            r12.loge(r0)
            no.nordicsemi.android.dfu.DfuBaseService r0 = r12.mService
            java.lang.String r13 = r13.getMessage()
            r0.sendLogBroadcast(r7, r13)
            no.nordicsemi.android.dfu.DfuBaseService r13 = r12.mService
            r0 = 4104(0x1008, float:5.751E-42)
            r13.terminateConnection(r3, r0)
        L_0x0119:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.ButtonlessDfuImpl.performDfu(android.content.Intent):void");
    }

    private int getStatusCode(byte[] bArr, int i) throws UnknownResponseException {
        byte b;
        if (bArr != null && bArr.length >= 3 && bArr[0] == 32 && bArr[1] == i && ((b = bArr[2]) == 1 || b == 2 || b == 4)) {
            return b;
        }
        throw new UnknownResponseException("Invalid response received", bArr, 32, i);
    }
}
