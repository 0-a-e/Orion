package org.apache.commons.compress.compressors.lzma;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.LZMAOutputStream;

public class LZMACompressorOutputStream extends CompressorOutputStream {
    private final LZMAOutputStream out;

    public void flush() throws IOException {
    }

    public LZMACompressorOutputStream(OutputStream outputStream) throws IOException {
        this.out = new LZMAOutputStream(outputStream, new LZMA2Options(), -1);
    }

    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    public void finish() throws IOException {
        this.out.finish();
    }

    public void close() throws IOException {
        this.out.close();
    }
}
