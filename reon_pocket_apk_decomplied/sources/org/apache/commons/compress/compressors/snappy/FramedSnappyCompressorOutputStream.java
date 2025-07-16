package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

public class FramedSnappyCompressorOutputStream extends CompressorOutputStream {
    private static final int MAX_COMPRESSED_BUFFER_SIZE = 65536;
    private final byte[] buffer;
    private final PureJavaCrc32C checksum;
    private final ByteUtils.ByteConsumer consumer;
    private int currentIndex;
    private final byte[] oneByte;
    private final OutputStream out;
    private final Parameters params;

    static long mask(long j) {
        return (((j << 17) | (j >> 15)) + 2726488792L) & 4294967295L;
    }

    public FramedSnappyCompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, SnappyCompressorOutputStream.createParameterBuilder(32768).build());
    }

    public FramedSnappyCompressorOutputStream(OutputStream outputStream, Parameters parameters) throws IOException {
        this.checksum = new PureJavaCrc32C();
        this.oneByte = new byte[1];
        this.buffer = new byte[65536];
        this.currentIndex = 0;
        this.out = outputStream;
        this.params = parameters;
        this.consumer = new ByteUtils.OutputStreamByteConsumer(outputStream);
        outputStream.write(FramedSnappyCompressorInputStream.SZ_SIGNATURE);
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i & 255);
        write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.currentIndex + i2 > 65536) {
            flushBuffer();
            while (i2 > 65536) {
                System.arraycopy(bArr, i, this.buffer, 0, 65536);
                i += 65536;
                i2 -= 65536;
                this.currentIndex = 65536;
                flushBuffer();
            }
        }
        System.arraycopy(bArr, i, this.buffer, this.currentIndex, i2);
        this.currentIndex += i2;
    }

    public void close() throws IOException {
        try {
            finish();
        } finally {
            this.out.close();
        }
    }

    public void finish() throws IOException {
        if (this.currentIndex > 0) {
            flushBuffer();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r0.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void flushBuffer() throws java.io.IOException {
        /*
            r6 = this;
            java.io.OutputStream r0 = r6.out
            r1 = 0
            r0.write(r1)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream r2 = new org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream
            int r3 = r6.currentIndex
            long r3 = (long) r3
            org.apache.commons.compress.compressors.lz77support.Parameters r5 = r6.params
            r2.<init>((java.io.OutputStream) r0, (long) r3, (org.apache.commons.compress.compressors.lz77support.Parameters) r5)
            byte[] r3 = r6.buffer     // Catch:{ all -> 0x0037 }
            int r4 = r6.currentIndex     // Catch:{ all -> 0x0037 }
            r2.write(r3, r1, r4)     // Catch:{ all -> 0x0037 }
            r2.close()
            byte[] r0 = r0.toByteArray()
            int r2 = r0.length
            long r2 = (long) r2
            r4 = 4
            long r2 = r2 + r4
            r4 = 3
            r6.writeLittleEndian(r4, r2)
            r6.writeCrc()
            java.io.OutputStream r2 = r6.out
            r2.write(r0)
            r6.currentIndex = r1
            return
        L_0x0037:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r2 = move-exception
            r0.addSuppressed(r2)
        L_0x0042:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.snappy.FramedSnappyCompressorOutputStream.flushBuffer():void");
    }

    private void writeLittleEndian(int i, long j) throws IOException {
        ByteUtils.toLittleEndian(this.consumer, j, i);
    }

    private void writeCrc() throws IOException {
        this.checksum.update(this.buffer, 0, this.currentIndex);
        writeLittleEndian(4, mask(this.checksum.getValue()));
        this.checksum.reset();
    }
}
