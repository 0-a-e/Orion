package org.apache.commons.compress.compressors.lzma;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.tukaani.xz.LZMAInputStream;
import org.tukaani.xz.MemoryLimitException;

public class LZMACompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private final CountingInputStream countingStream;
    private final InputStream in;

    public LZMACompressorInputStream(InputStream inputStream) throws IOException {
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        this.in = new LZMAInputStream(countingInputStream, -1);
    }

    public LZMACompressorInputStream(InputStream inputStream, int i) throws IOException {
        try {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            this.countingStream = countingInputStream;
            this.in = new LZMAInputStream(countingInputStream, i);
        } catch (MemoryLimitException e) {
            throw new org.apache.commons.compress.MemoryLimitException((long) e.getMemoryNeeded(), e.getMemoryLimit(), e);
        }
    }

    public int read() throws IOException {
        int read = this.in.read();
        count(read == -1 ? 0 : 1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.in.read(bArr, i, i2);
        count(read);
        return read;
    }

    public long skip(long j) throws IOException {
        return IOUtils.skip(this.in, j);
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

    public static boolean matches(byte[] bArr, int i) {
        return bArr != null && i >= 3 && bArr[0] == 93 && bArr[1] == 0 && bArr[2] == 0;
    }
}
