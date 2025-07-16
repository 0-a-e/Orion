package org.apache.commons.compress.compressors.xz;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SingleXZInputStream;
import org.tukaani.xz.XZ;
import org.tukaani.xz.XZInputStream;

public class XZCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final InputStream in;

    public static boolean matches(byte[] bArr, int i) {
        if (i < XZ.HEADER_MAGIC.length) {
            return false;
        }
        for (int i2 = 0; i2 < XZ.HEADER_MAGIC.length; i2++) {
            if (bArr[i2] != XZ.HEADER_MAGIC[i2]) {
                return false;
            }
        }
        return true;
    }

    public XZCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z) throws IOException {
        this(inputStream, z, -1);
    }

    public XZCompressorInputStream(InputStream inputStream, boolean z, int i) throws IOException {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        if (z) {
            this.in = new XZInputStream(countingInputStream, i);
        } else {
            this.in = new SingleXZInputStream(countingInputStream, i);
        }
    }

    public int read() throws IOException {
        try {
            int read = this.in.read();
            int i = -1;
            if (read != -1) {
                i = 1;
            }
            count(i);
            return read;
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.in.read(bArr, i, i2);
            count(read);
            return read;
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    public long skip(long j) throws IOException {
        try {
            return IOUtils.skip(this.in, j);
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public void close() throws IOException {
        this.in.close();
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }
}
