package org.apache.commons.compress.compressors;

import java.io.InputStream;

public abstract class CompressorInputStream extends InputStream {
    private long bytesRead = 0;

    /* access modifiers changed from: protected */
    public void count(int i) {
        count((long) i);
    }

    /* access modifiers changed from: protected */
    public void count(long j) {
        if (j != -1) {
            this.bytesRead += j;
        }
    }

    /* access modifiers changed from: protected */
    public void pushedBackBytes(long j) {
        this.bytesRead -= j;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public long getUncompressedCount() {
        return getBytesRead();
    }
}
