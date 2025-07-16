package org.apache.commons.compress.archivers.cpio;

class CpioUtil {
    static long fileType(long j) {
        return j & 61440;
    }

    CpioUtil() {
    }

    static long byteArray2long(byte[] bArr, boolean z) {
        if (bArr.length % 2 == 0) {
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            if (!z) {
                for (int i = 0; i < length; i += 2) {
                    byte b = bArr2[i];
                    int i2 = i + 1;
                    bArr2[i] = bArr2[i2];
                    bArr2[i2] = b;
                }
            }
            long j = (long) (bArr2[0] & 255);
            for (int i3 = 1; i3 < length; i3++) {
                j = (j << 8) | ((long) (bArr2[i3] & 255));
            }
            return j;
        }
        throw new UnsupportedOperationException();
    }

    static byte[] long2byteArray(long j, int i, boolean z) {
        byte[] bArr = new byte[i];
        if (i % 2 != 0 || i < 2) {
            throw new UnsupportedOperationException();
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        if (!z) {
            for (int i3 = 0; i3 < i; i3 += 2) {
                byte b = bArr[i3];
                int i4 = i3 + 1;
                bArr[i3] = bArr[i4];
                bArr[i4] = b;
            }
        }
        return bArr;
    }
}
