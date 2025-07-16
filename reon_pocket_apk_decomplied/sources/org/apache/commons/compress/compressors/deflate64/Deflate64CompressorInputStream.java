package org.apache.commons.compress.compressors.deflate64;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class Deflate64CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private long compressedBytesRead;
    private HuffmanDecoder decoder;
    private final byte[] oneByte;
    private InputStream originalStream;

    public Deflate64CompressorInputStream(InputStream inputStream) {
        this(new HuffmanDecoder(inputStream));
        this.originalStream = inputStream;
    }

    Deflate64CompressorInputStream(HuffmanDecoder huffmanDecoder) {
        this.oneByte = new byte[1];
        this.decoder = huffmanDecoder;
    }

    public int read() throws IOException {
        int read;
        do {
            read = read(this.oneByte);
            if (read == -1) {
                return -1;
            }
        } while (read == 0);
        if (read == 1) {
            return this.oneByte[0] & 255;
        }
        throw new IllegalStateException("Invalid return value from read: " + read);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        HuffmanDecoder huffmanDecoder = this.decoder;
        if (huffmanDecoder == null) {
            return -1;
        }
        int decode = huffmanDecoder.decode(bArr, i, i2);
        this.compressedBytesRead = this.decoder.getBytesRead();
        count(decode);
        if (decode == -1) {
            closeDecoder();
        }
        return decode;
    }

    public int available() throws IOException {
        HuffmanDecoder huffmanDecoder = this.decoder;
        if (huffmanDecoder != null) {
            return huffmanDecoder.available();
        }
        return 0;
    }

    public void close() throws IOException {
        try {
            closeDecoder();
            InputStream inputStream = this.originalStream;
            if (inputStream != null) {
                inputStream.close();
                this.originalStream = null;
            }
        } catch (Throwable th) {
            if (this.originalStream != null) {
                this.originalStream.close();
                this.originalStream = null;
            }
            throw th;
        }
    }

    public long getCompressedCount() {
        return this.compressedBytesRead;
    }

    private void closeDecoder() {
        IOUtils.closeQuietly(this.decoder);
        this.decoder = null;
    }
}
