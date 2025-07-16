package org.apache.commons.compress.archivers;

import java.io.IOException;
import java.io.InputStream;

public abstract class ArchiveInputStream extends InputStream {
    private static final int BYTE_MASK = 255;
    private long bytesRead = 0;
    private final byte[] single = new byte[1];

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return true;
    }

    public abstract ArchiveEntry getNextEntry() throws IOException;

    public int read() throws IOException {
        if (read(this.single, 0, 1) == -1) {
            return -1;
        }
        return this.single[0] & 255;
    }

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
}
