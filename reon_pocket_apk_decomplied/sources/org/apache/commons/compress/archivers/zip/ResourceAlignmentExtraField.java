package org.apache.commons.compress.archivers.zip;

import java.util.zip.ZipException;
import kotlin.jvm.internal.ShortCompanionObject;

public class ResourceAlignmentExtraField implements ZipExtraField {
    private static final int ALLOW_METHOD_MESSAGE_CHANGE_FLAG = 32768;
    public static final int BASE_SIZE = 2;
    public static final ZipShort ID = new ZipShort(41246);
    private short alignment;
    private boolean allowMethodChange;
    private int padding;

    public ResourceAlignmentExtraField() {
        this.padding = 0;
    }

    public ResourceAlignmentExtraField(int i) {
        this(i, false);
    }

    public ResourceAlignmentExtraField(int i, boolean z) {
        this(i, z, 0);
    }

    public ResourceAlignmentExtraField(int i, boolean z, int i2) {
        this.padding = 0;
        if (i < 0 || i > 32767) {
            throw new IllegalArgumentException("Alignment must be between 0 and 0x7fff, was: " + i);
        } else if (i2 >= 0) {
            this.alignment = (short) i;
            this.allowMethodChange = z;
            this.padding = i2;
        } else {
            throw new IllegalArgumentException("Padding must not be negative, was: " + i2);
        }
    }

    public short getAlignment() {
        return this.alignment;
    }

    public boolean allowMethodChange() {
        return this.allowMethodChange;
    }

    public ZipShort getHeaderId() {
        return ID;
    }

    public ZipShort getLocalFileDataLength() {
        return new ZipShort(this.padding + 2);
    }

    public ZipShort getCentralDirectoryLength() {
        return new ZipShort(2);
    }

    public byte[] getLocalFileDataData() {
        byte[] bArr = new byte[(this.padding + 2)];
        ZipShort.putShort(this.alignment | (this.allowMethodChange ? ShortCompanionObject.MIN_VALUE : 0), bArr, 0);
        return bArr;
    }

    public byte[] getCentralDirectoryData() {
        return ZipShort.getBytes(this.alignment | (this.allowMethodChange ? ShortCompanionObject.MIN_VALUE : 0));
    }

    public void parseFromLocalFileData(byte[] bArr, int i, int i2) throws ZipException {
        parseFromCentralDirectoryData(bArr, i, i2);
        this.padding = i2 - 2;
    }

    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 >= 2) {
            int value = ZipShort.getValue(bArr, i);
            this.alignment = (short) (value & 32767);
            this.allowMethodChange = (value & 32768) != 0;
            return;
        }
        throw new ZipException("Too short content for ResourceAlignmentExtraField (0xa11e): " + i2);
    }
}
