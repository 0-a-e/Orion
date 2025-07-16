package org.apache.commons.compress.archivers.zip;

import java.util.Arrays;

public final class UnparseableExtraFieldData implements ZipExtraField {
    private static final ZipShort HEADER_ID = new ZipShort(44225);
    private byte[] centralDirectoryData;
    private byte[] localFileData;

    public ZipShort getHeaderId() {
        return HEADER_ID;
    }

    public ZipShort getLocalFileDataLength() {
        byte[] bArr = this.localFileData;
        return new ZipShort(bArr == null ? 0 : bArr.length);
    }

    public ZipShort getCentralDirectoryLength() {
        return this.centralDirectoryData == null ? getLocalFileDataLength() : new ZipShort(this.centralDirectoryData.length);
    }

    public byte[] getLocalFileDataData() {
        return ZipUtil.copy(this.localFileData);
    }

    public byte[] getCentralDirectoryData() {
        byte[] bArr = this.centralDirectoryData;
        return bArr == null ? getLocalFileDataData() : ZipUtil.copy(bArr);
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        this.localFileData = Arrays.copyOfRange(bArr, i, i2 + i);
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        this.centralDirectoryData = Arrays.copyOfRange(bArr, i, i + i2);
        if (this.localFileData == null) {
            parseFromLocalFileData(bArr, i, i2);
        }
    }
}
