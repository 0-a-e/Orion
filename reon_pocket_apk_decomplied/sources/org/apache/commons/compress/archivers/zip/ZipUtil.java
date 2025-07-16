package org.apache.commons.compress.archivers.zip;

import androidx.core.view.InputDeviceCompat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException;

public abstract class ZipUtil {
    private static final byte[] DOS_TIME_MIN = ZipLong.getBytes(8448);

    public static long adjustToLong(int i) {
        return i < 0 ? ((long) i) + 4294967296L : (long) i;
    }

    public static int signedByteToUnsignedInt(byte b) {
        return b >= 0 ? b : b + 256;
    }

    public static ZipLong toDosTime(Date date) {
        return new ZipLong(toDosTime(date.getTime()));
    }

    public static byte[] toDosTime(long j) {
        byte[] bArr = new byte[4];
        toDosTime(j, bArr, 0);
        return bArr;
    }

    public static void toDosTime(long j, byte[] bArr, int i) {
        toDosTime(Calendar.getInstance(), j, bArr, i);
    }

    static void toDosTime(Calendar calendar, long j, byte[] bArr, int i) {
        calendar.setTimeInMillis(j);
        int i2 = calendar.get(1);
        if (i2 < 1980) {
            copy(DOS_TIME_MIN, bArr, i);
            return;
        }
        ZipLong.putLong((long) ((calendar.get(13) >> 1) | ((i2 - 1980) << 25) | ((calendar.get(2) + 1) << 21) | (calendar.get(5) << 16) | (calendar.get(11) << 11) | (calendar.get(12) << 5)), bArr, i);
    }

    public static byte[] reverse(byte[] bArr) {
        int length = bArr.length - 1;
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            int i2 = length - i;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }
        return bArr;
    }

    static long bigToLong(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return bigInteger.longValue();
        }
        throw new NumberFormatException("The BigInteger cannot fit inside a 64 bit java long: [" + bigInteger + "]");
    }

    static BigInteger longToBig(long j) {
        int i = (j > -2147483648L ? 1 : (j == -2147483648L ? 0 : -1));
        if (i >= 0) {
            if (j < 0 && i >= 0) {
                j = adjustToLong((int) j);
            }
            return BigInteger.valueOf(j);
        }
        throw new IllegalArgumentException("Negative longs < -2^31 not permitted: [" + j + "]");
    }

    public static byte unsignedIntToSignedByte(int i) {
        if (i <= 255 && i >= 0) {
            return i < 128 ? (byte) i : (byte) (i + InputDeviceCompat.SOURCE_ANY);
        }
        throw new IllegalArgumentException("Can only convert non-negative integers between [0,255] to byte: [" + i + "]");
    }

    public static Date fromDosTime(ZipLong zipLong) {
        return new Date(dosToJavaTime(zipLong.getValue()));
    }

    public static long dosToJavaTime(long j) {
        Calendar instance = Calendar.getInstance();
        instance.set(1, ((int) ((j >> 25) & 127)) + 1980);
        instance.set(2, ((int) ((j >> 21) & 15)) - 1);
        instance.set(5, ((int) (j >> 16)) & 31);
        instance.set(11, ((int) (j >> 11)) & 31);
        instance.set(12, ((int) (j >> 5)) & 63);
        instance.set(13, ((int) (j << 1)) & 62);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [org.apache.commons.compress.archivers.zip.ZipExtraField] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void setNameAndCommentFromExtraFields(org.apache.commons.compress.archivers.zip.ZipArchiveEntry r3, byte[] r4, byte[] r5) {
        /*
            org.apache.commons.compress.archivers.zip.ZipShort r0 = org.apache.commons.compress.archivers.zip.UnicodePathExtraField.UPATH_ID
            org.apache.commons.compress.archivers.zip.ZipExtraField r0 = r3.getExtraField(r0)
            boolean r1 = r0 instanceof org.apache.commons.compress.archivers.zip.UnicodePathExtraField
            r2 = 0
            if (r1 == 0) goto L_0x000e
            org.apache.commons.compress.archivers.zip.UnicodePathExtraField r0 = (org.apache.commons.compress.archivers.zip.UnicodePathExtraField) r0
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            java.lang.String r4 = getUnicodeStringIfOriginalMatches(r0, r4)
            if (r4 == 0) goto L_0x001d
            r3.setName(r4)
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry$NameSource r4 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.NameSource.UNICODE_EXTRA_FIELD
            r3.setNameSource(r4)
        L_0x001d:
            if (r5 == 0) goto L_0x003d
            int r4 = r5.length
            if (r4 <= 0) goto L_0x003d
            org.apache.commons.compress.archivers.zip.ZipShort r4 = org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField.UCOM_ID
            org.apache.commons.compress.archivers.zip.ZipExtraField r4 = r3.getExtraField(r4)
            boolean r0 = r4 instanceof org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField
            if (r0 == 0) goto L_0x002f
            r2 = r4
            org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField r2 = (org.apache.commons.compress.archivers.zip.UnicodeCommentExtraField) r2
        L_0x002f:
            java.lang.String r4 = getUnicodeStringIfOriginalMatches(r2, r5)
            if (r4 == 0) goto L_0x003d
            r3.setComment(r4)
            org.apache.commons.compress.archivers.zip.ZipArchiveEntry$CommentSource r4 = org.apache.commons.compress.archivers.zip.ZipArchiveEntry.CommentSource.UNICODE_EXTRA_FIELD
            r3.setCommentSource(r4)
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ZipUtil.setNameAndCommentFromExtraFields(org.apache.commons.compress.archivers.zip.ZipArchiveEntry, byte[], byte[]):void");
    }

    private static String getUnicodeStringIfOriginalMatches(AbstractUnicodeExtraField abstractUnicodeExtraField, byte[] bArr) {
        if (abstractUnicodeExtraField != null) {
            CRC32 crc32 = new CRC32();
            crc32.update(bArr);
            if (crc32.getValue() == abstractUnicodeExtraField.getNameCRC32()) {
                try {
                    return ZipEncodingHelper.UTF8_ZIP_ENCODING.decode(abstractUnicodeExtraField.getUnicodeName());
                } catch (IOException unused) {
                }
            }
        }
        return null;
    }

    static byte[] copy(byte[] bArr) {
        if (bArr != null) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        return null;
    }

    static void copy(byte[] bArr, byte[] bArr2, int i) {
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, i, bArr.length);
        }
    }

    static boolean canHandleEntryData(ZipArchiveEntry zipArchiveEntry) {
        return supportsEncryptionOf(zipArchiveEntry) && supportsMethodOf(zipArchiveEntry);
    }

    private static boolean supportsEncryptionOf(ZipArchiveEntry zipArchiveEntry) {
        return !zipArchiveEntry.getGeneralPurposeBit().usesEncryption();
    }

    private static boolean supportsMethodOf(ZipArchiveEntry zipArchiveEntry) {
        return zipArchiveEntry.getMethod() == 0 || zipArchiveEntry.getMethod() == ZipMethod.UNSHRINKING.getCode() || zipArchiveEntry.getMethod() == ZipMethod.IMPLODING.getCode() || zipArchiveEntry.getMethod() == 8 || zipArchiveEntry.getMethod() == ZipMethod.ENHANCED_DEFLATED.getCode() || zipArchiveEntry.getMethod() == ZipMethod.BZIP2.getCode();
    }

    static void checkRequestedFeatures(ZipArchiveEntry zipArchiveEntry) throws UnsupportedZipFeatureException {
        if (!supportsEncryptionOf(zipArchiveEntry)) {
            throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.ENCRYPTION, zipArchiveEntry);
        } else if (!supportsMethodOf(zipArchiveEntry)) {
            ZipMethod methodByCode = ZipMethod.getMethodByCode(zipArchiveEntry.getMethod());
            if (methodByCode == null) {
                throw new UnsupportedZipFeatureException(UnsupportedZipFeatureException.Feature.METHOD, zipArchiveEntry);
            }
            throw new UnsupportedZipFeatureException(methodByCode, zipArchiveEntry);
        }
    }
}
