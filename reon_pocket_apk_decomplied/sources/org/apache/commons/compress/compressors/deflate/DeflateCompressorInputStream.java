package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class DeflateCompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private static final int MAGIC_1 = 120;
    private static final int MAGIC_2a = 1;
    private static final int MAGIC_2b = 94;
    private static final int MAGIC_2c = 156;
    private static final int MAGIC_2d = 218;
    private final CountingInputStream countingStream;
    private final InputStream in;
    private final Inflater inflater;

    public DeflateCompressorInputStream(InputStream inputStream) {
        this(inputStream, new DeflateParameters());
    }

    public DeflateCompressorInputStream(InputStream inputStream, DeflateParameters deflateParameters) {
        Inflater inflater2 = new Inflater(!deflateParameters.withZlibHeader());
        this.inflater = inflater2;
        CountingInputStream countingInputStream = new CountingInputStream(inputStream);
        this.countingStream = countingInputStream;
        this.in = new InflaterInputStream(countingInputStream, inflater2);
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
        try {
            this.in.close();
        } finally {
            this.inflater.end();
        }
    }

    public long getCompressedCount() {
        return this.countingStream.getBytesRead();
    }

    public static boolean matches(byte[] bArr, int i) {
        if (i <= 3 || bArr[0] != 120) {
            return false;
        }
        byte b = bArr[1];
        return b == 1 || b == MAGIC_2b || b == -100 || b == -38;
    }
}
