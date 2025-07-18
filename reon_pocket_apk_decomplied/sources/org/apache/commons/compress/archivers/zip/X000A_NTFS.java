package org.apache.commons.compress.archivers.zip;

import java.util.Date;
import java.util.zip.ZipException;

public class X000A_NTFS implements ZipExtraField {
    private static final long EPOCH_OFFSET = -116444736000000000L;
    private static final ZipShort HEADER_ID = new ZipShort(10);
    private static final ZipShort TIME_ATTR_SIZE = new ZipShort(24);
    private static final ZipShort TIME_ATTR_TAG = new ZipShort(1);
    private ZipEightByteInteger accessTime = ZipEightByteInteger.ZERO;
    private ZipEightByteInteger createTime = ZipEightByteInteger.ZERO;
    private ZipEightByteInteger modifyTime = ZipEightByteInteger.ZERO;

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public ZipShort getLocalFileDataLength() {
        return new ZipShort(32);
    }

    public ZipShort getCentralDirectoryLength() {
        return getLocalFileDataLength();
    }

    public byte[] getLocalFileDataData() {
        byte[] bArr = new byte[getLocalFileDataLength().getValue()];
        System.arraycopy(TIME_ATTR_TAG.getBytes(), 0, bArr, 4, 2);
        System.arraycopy(TIME_ATTR_SIZE.getBytes(), 0, bArr, 6, 2);
        System.arraycopy(this.modifyTime.getBytes(), 0, bArr, 8, 8);
        System.arraycopy(this.accessTime.getBytes(), 0, bArr, 16, 8);
        System.arraycopy(this.createTime.getBytes(), 0, bArr, 24, 8);
        return bArr;
    }

    public byte[] getCentralDirectoryData() {
        return getLocalFileDataData();
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        int i3 = i2 + i;
        int i4 = i + 4;
        while (i4 + 4 <= i3) {
            ZipShort zipShort = new ZipShort(bArr, i4);
            int i5 = i4 + 2;
            if (zipShort.equals(TIME_ATTR_TAG)) {
                readTimeAttr(bArr, i5, i3 - i5);
                return;
            }
            i4 = i5 + new ZipShort(bArr, i5).getValue() + 2;
        }
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws ZipException {
        reset();
        parseFromLocalFileData(bArr, i, i2);
    }

    public ZipEightByteInteger getModifyTime() {
        return this.modifyTime;
    }

    public ZipEightByteInteger getAccessTime() {
        return this.accessTime;
    }

    public ZipEightByteInteger getCreateTime() {
        return this.createTime;
    }

    public Date getModifyJavaTime() {
        return zipToDate(this.modifyTime);
    }

    public Date getAccessJavaTime() {
        return zipToDate(this.accessTime);
    }

    public Date getCreateJavaTime() {
        return zipToDate(this.createTime);
    }

    public void setModifyTime(ZipEightByteInteger zipEightByteInteger) {
        if (zipEightByteInteger == null) {
            zipEightByteInteger = ZipEightByteInteger.ZERO;
        }
        this.modifyTime = zipEightByteInteger;
    }

    public void setAccessTime(ZipEightByteInteger zipEightByteInteger) {
        if (zipEightByteInteger == null) {
            zipEightByteInteger = ZipEightByteInteger.ZERO;
        }
        this.accessTime = zipEightByteInteger;
    }

    public void setCreateTime(ZipEightByteInteger zipEightByteInteger) {
        if (zipEightByteInteger == null) {
            zipEightByteInteger = ZipEightByteInteger.ZERO;
        }
        this.createTime = zipEightByteInteger;
    }

    public void setModifyJavaTime(Date date) {
        setModifyTime(dateToZip(date));
    }

    public void setAccessJavaTime(Date date) {
        setAccessTime(dateToZip(date));
    }

    public void setCreateJavaTime(Date date) {
        setCreateTime(dateToZip(date));
    }

    public String toString() {
        return "0x000A Zip Extra Field: Modify:[" + getModifyJavaTime() + "]  Access:[" + getAccessJavaTime() + "]  Create:[" + getCreateJavaTime() + "] ";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof X000A_NTFS)) {
            return false;
        }
        X000A_NTFS x000a_ntfs = (X000A_NTFS) obj;
        ZipEightByteInteger zipEightByteInteger = this.modifyTime;
        ZipEightByteInteger zipEightByteInteger2 = x000a_ntfs.modifyTime;
        if (zipEightByteInteger != zipEightByteInteger2 && (zipEightByteInteger == null || !zipEightByteInteger.equals(zipEightByteInteger2))) {
            return false;
        }
        ZipEightByteInteger zipEightByteInteger3 = this.accessTime;
        ZipEightByteInteger zipEightByteInteger4 = x000a_ntfs.accessTime;
        if (zipEightByteInteger3 != zipEightByteInteger4 && (zipEightByteInteger3 == null || !zipEightByteInteger3.equals(zipEightByteInteger4))) {
            return false;
        }
        ZipEightByteInteger zipEightByteInteger5 = this.createTime;
        ZipEightByteInteger zipEightByteInteger6 = x000a_ntfs.createTime;
        if (zipEightByteInteger5 == zipEightByteInteger6 || (zipEightByteInteger5 != null && zipEightByteInteger5.equals(zipEightByteInteger6))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        ZipEightByteInteger zipEightByteInteger = this.modifyTime;
        int i = -123;
        if (zipEightByteInteger != null) {
            i = -123 ^ zipEightByteInteger.hashCode();
        }
        ZipEightByteInteger zipEightByteInteger2 = this.accessTime;
        if (zipEightByteInteger2 != null) {
            i ^= Integer.rotateLeft(zipEightByteInteger2.hashCode(), 11);
        }
        ZipEightByteInteger zipEightByteInteger3 = this.createTime;
        return zipEightByteInteger3 != null ? i ^ Integer.rotateLeft(zipEightByteInteger3.hashCode(), 22) : i;
    }

    private void reset() {
        this.modifyTime = ZipEightByteInteger.ZERO;
        this.accessTime = ZipEightByteInteger.ZERO;
        this.createTime = ZipEightByteInteger.ZERO;
    }

    private void readTimeAttr(byte[] bArr, int i, int i2) {
        if (i2 >= 26) {
            if (TIME_ATTR_SIZE.equals(new ZipShort(bArr, i))) {
                this.modifyTime = new ZipEightByteInteger(bArr, i + 2);
                this.accessTime = new ZipEightByteInteger(bArr, i + 10);
                this.createTime = new ZipEightByteInteger(bArr, i + 18);
            }
        }
    }

    private static ZipEightByteInteger dateToZip(Date date) {
        if (date == null) {
            return null;
        }
        return new ZipEightByteInteger((date.getTime() * 10000) - EPOCH_OFFSET);
    }

    private static Date zipToDate(ZipEightByteInteger zipEightByteInteger) {
        if (zipEightByteInteger == null || ZipEightByteInteger.ZERO.equals(zipEightByteInteger)) {
            return null;
        }
        return new Date((zipEightByteInteger.getLongValue() + EPOCH_OFFSET) / 10000);
    }
}
