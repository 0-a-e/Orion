package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

class InflaterInputStreamWithStatistics extends InflaterInputStream implements InputStreamStatistics {
    private long compressedCount = 0;
    private long uncompressedCount = 0;

    public InflaterInputStreamWithStatistics(InputStream inputStream) {
        super(inputStream);
    }

    public InflaterInputStreamWithStatistics(InputStream inputStream, Inflater inflater) {
        super(inputStream, inflater);
    }

    public InflaterInputStreamWithStatistics(InputStream inputStream, Inflater inflater, int i) {
        super(inputStream, inflater, i);
    }

    /* access modifiers changed from: protected */
    public void fill() throws IOException {
        super.fill();
        this.compressedCount += (long) this.inf.getRemaining();
    }

    public int read() throws IOException {
        int read = super.read();
        if (read > -1) {
            this.uncompressedCount++;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read > -1) {
            this.uncompressedCount += (long) read;
        }
        return read;
    }

    public long getCompressedCount() {
        return this.compressedCount;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }
}
