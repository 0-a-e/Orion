package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

public class UnrecognizedExtraField implements ZipExtraField {
    private byte[] centralData;
    private ZipShort headerId;
    private byte[] localData;

    public void setHeaderId(ZipShort zipShort) {
        this.headerId = zipShort;
    }

    public ZipShort getHeaderId() {
        return this.headerId;
    }

    public void setLocalFileDataData(byte[] bArr) {
        this.localData = ZipUtil.copy(bArr);
    }

    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.localData;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localData);
    }

    public void setCentralDirectoryData(byte[] bArr) {
        this.centralData = ZipUtil.copy(bArr);
    }

    public ZipShort getCentralDirectoryLength() {
        if (this.centralData != null) {
            return new ZipShort(this.centralData.length);
        }
        return getLocalFileDataLength();
    }

    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralData;
        if (bArr != null) {
            return ZipUtil.copy(bArr);
        }
        return getLocalFileDataData();
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        setLocalFileDataData(Arrays.copyOfRange(bArr, i, i2 + i));
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2 + i);
        setCentralDirectoryData(copyOfRange);
        if (this.localData == null) {
            setLocalFileDataData(copyOfRange);
        }
    }
}
