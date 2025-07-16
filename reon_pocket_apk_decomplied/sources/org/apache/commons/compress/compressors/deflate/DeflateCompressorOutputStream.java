package org.apache.commons.compress.compressors.deflate;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class DeflateCompressorOutputStream extends CompressorOutputStream {
    private final Deflater deflater;
    private final DeflaterOutputStream out;

    public DeflateCompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, new DeflateParameters());
    }

    public DeflateCompressorOutputStream(OutputStream outputStream, DeflateParameters deflateParameters) throws IOException {
        Deflater deflater2 = new Deflater(deflateParameters.getCompressionLevel(), !deflateParameters.withZlibHeader());
        this.deflater = deflater2;
        this.out = new DeflaterOutputStream(outputStream, deflater2);
    }

    public void write(int i) throws IOException {
        this.out.write(i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void finish() throws IOException {
        this.out.finish();
    }

    public void close() throws IOException {
        try {
            this.out.close();
        } finally {
            this.deflater.end();
        }
    }
}
