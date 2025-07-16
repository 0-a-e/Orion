package org.apache.commons.compress.compressors.deflate;

public class DeflateParameters {
    private int compressionLevel = -1;
    private boolean zlibHeader = true;

    public boolean withZlibHeader() {
        return this.zlibHeader;
    }

    public void setWithZlibHeader(boolean z) {
        this.zlibHeader = z;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        if (i < -1 || i > 9) {
            throw new IllegalArgumentException("Invalid Deflate compression level: " + i);
        }
        this.compressionLevel = i;
    }
}
