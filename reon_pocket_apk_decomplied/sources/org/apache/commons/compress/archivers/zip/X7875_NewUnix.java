package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.zip.ZipException;

public class X7875_NewUnix implements ZipExtraField, Cloneable, Serializable {
    private static final ZipShort HEADER_ID = new ZipShort(30837);
    private static final BigInteger ONE_THOUSAND = BigInteger.valueOf(1000);
    private static final ZipShort ZERO = new ZipShort(0);
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version = 1;

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws ZipException {
    }

    public X7875_NewUnix() {
        reset();
    }

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public long getUID() {
        return ZipUtil.bigToLong(this.uid);
    }

    public long getGID() {
        return ZipUtil.bigToLong(this.gid);
    }

    public void setUID(long j) {
        this.uid = ZipUtil.longToBig(j);
    }

    public void setGID(long j) {
        this.gid = ZipUtil.longToBig(j);
    }

    public ZipShort getLocalFileDataLength() {
        int i;
        byte[] trimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(this.uid.toByteArray());
        int i2 = 0;
        if (trimLeadingZeroesForceMinLength == null) {
            i = 0;
        } else {
            i = trimLeadingZeroesForceMinLength.length;
        }
        byte[] trimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(this.gid.toByteArray());
        if (trimLeadingZeroesForceMinLength2 != null) {
            i2 = trimLeadingZeroesForceMinLength2.length;
        }
        return new ZipShort(i + 3 + i2);
    }

    public ZipShort getCentralDirectoryLength() {
        return ZERO;
    }

    public byte[] getLocalFileDataData() {
        byte[] byteArray = this.uid.toByteArray();
        byte[] byteArray2 = this.gid.toByteArray();
        byte[] trimLeadingZeroesForceMinLength = trimLeadingZeroesForceMinLength(byteArray);
        int length = trimLeadingZeroesForceMinLength != null ? trimLeadingZeroesForceMinLength.length : 0;
        byte[] trimLeadingZeroesForceMinLength2 = trimLeadingZeroesForceMinLength(byteArray2);
        int length2 = trimLeadingZeroesForceMinLength2 != null ? trimLeadingZeroesForceMinLength2.length : 0;
        byte[] bArr = new byte[(length + 3 + length2)];
        if (trimLeadingZeroesForceMinLength != null) {
            ZipUtil.reverse(trimLeadingZeroesForceMinLength);
        }
        if (trimLeadingZeroesForceMinLength2 != null) {
            ZipUtil.reverse(trimLeadingZeroesForceMinLength2);
        }
        bArr[0] = ZipUtil.unsignedIntToSignedByte(this.version);
        bArr[1] = ZipUtil.unsignedIntToSignedByte(length);
        if (trimLeadingZeroesForceMinLength != null) {
            System.arraycopy(trimLeadingZeroesForceMinLength, 0, bArr, 2, length);
        }
        int i = 2 + length;
        int i2 = length + 3;
        bArr[i] = ZipUtil.unsignedIntToSignedByte(length2);
        if (trimLeadingZeroesForceMinLength2 != null) {
            System.arraycopy(trimLeadingZeroesForceMinLength2, 0, bArr, i2, length2);
        }
        return bArr;
    }

    public byte[] getCentralDirectoryData() {
        return new byte[0];
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        reset();
        if (i2 >= 3) {
            int i3 = i + 1;
            this.version = ZipUtil.signedByteToUnsignedInt(bArr[i]);
            int i4 = i + 2;
            int signedByteToUnsignedInt = ZipUtil.signedByteToUnsignedInt(bArr[i3]);
            int i5 = signedByteToUnsignedInt + 3;
            if (i5 <= i2) {
                int i6 = signedByteToUnsignedInt + i4;
                this.uid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(bArr, i4, i6)));
                int i7 = i6 + 1;
                int signedByteToUnsignedInt2 = ZipUtil.signedByteToUnsignedInt(bArr[i6]);
                if (i5 + signedByteToUnsignedInt2 <= i2) {
                    this.gid = new BigInteger(1, ZipUtil.reverse(Arrays.copyOfRange(bArr, i7, signedByteToUnsignedInt2 + i7)));
                    return;
                }
                throw new ZipException("X7875_NewUnix invalid: gidSize " + signedByteToUnsignedInt2 + " doesn't fit into " + i2 + " bytes");
            }
            throw new ZipException("X7875_NewUnix invalid: uidSize " + signedByteToUnsignedInt + " doesn't fit into " + i2 + " bytes");
        }
        throw new ZipException("X7875_NewUnix length is too short, only " + i2 + " bytes");
    }

    private void reset() {
        BigInteger bigInteger = ONE_THOUSAND;
        this.uid = bigInteger;
        this.gid = bigInteger;
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof X7875_NewUnix)) {
            return false;
        }
        X7875_NewUnix x7875_NewUnix = (X7875_NewUnix) obj;
        if (this.version != x7875_NewUnix.version || !this.uid.equals(x7875_NewUnix.uid) || !this.gid.equals(x7875_NewUnix.gid)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Integer.rotateLeft(this.uid.hashCode(), 16) ^ (this.version * -1234567)) ^ this.gid.hashCode();
    }

    static byte[] trimLeadingZeroesForceMinLength(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length && bArr[i] == 0) {
            i2++;
            i++;
        }
        int max = Math.max(1, bArr.length - i2);
        byte[] bArr2 = new byte[max];
        int length2 = max - (bArr.length - i2);
        System.arraycopy(bArr, i2, bArr2, length2, max - length2);
        return bArr2;
    }
}
