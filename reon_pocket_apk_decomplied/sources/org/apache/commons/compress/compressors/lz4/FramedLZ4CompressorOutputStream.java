package org.apache.commons.compress.compressors.lz4;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.utils.ByteUtils;

public class FramedLZ4CompressorOutputStream extends CompressorOutputStream {
    private static final byte[] END_MARK = new byte[4];
    private final byte[] blockData;
    private byte[] blockDependencyBuffer;
    private final XXHash32 blockHash;
    private int collectedBlockDependencyBytes;
    private final XXHash32 contentHash;
    private int currentIndex;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream out;
    private final Parameters params;

    public enum BlockSize {
        K64(65536, 4),
        K256(262144, 5),
        M1(1048576, 6),
        M4(4194304, 7);
        
        private final int index;
        private final int size;

        private BlockSize(int i, int i2) {
            this.size = i;
            this.index = i2;
        }

        /* access modifiers changed from: package-private */
        public int getSize() {
            return this.size;
        }

        /* access modifiers changed from: package-private */
        public int getIndex() {
            return this.index;
        }
    }

    public static class Parameters {
        public static final Parameters DEFAULT = new Parameters(BlockSize.M4, true, false, false);
        /* access modifiers changed from: private */
        public final BlockSize blockSize;
        /* access modifiers changed from: private */
        public final org.apache.commons.compress.compressors.lz77support.Parameters lz77params;
        /* access modifiers changed from: private */
        public final boolean withBlockChecksum;
        /* access modifiers changed from: private */
        public final boolean withBlockDependency;
        /* access modifiers changed from: private */
        public final boolean withContentChecksum;

        public Parameters(BlockSize blockSize2) {
            this(blockSize2, true, false, false);
        }

        public Parameters(BlockSize blockSize2, org.apache.commons.compress.compressors.lz77support.Parameters parameters) {
            this(blockSize2, true, false, false, parameters);
        }

        public Parameters(BlockSize blockSize2, boolean z, boolean z2, boolean z3) {
            this(blockSize2, z, z2, z3, BlockLZ4CompressorOutputStream.createParameterBuilder().build());
        }

        public Parameters(BlockSize blockSize2, boolean z, boolean z2, boolean z3, org.apache.commons.compress.compressors.lz77support.Parameters parameters) {
            this.blockSize = blockSize2;
            this.withContentChecksum = z;
            this.withBlockChecksum = z2;
            this.withBlockDependency = z3;
            this.lz77params = parameters;
        }

        public String toString() {
            return "LZ4 Parameters with BlockSize " + this.blockSize + ", withContentChecksum " + this.withContentChecksum + ", withBlockChecksum " + this.withBlockChecksum + ", withBlockDependency " + this.withBlockDependency;
        }
    }

    public FramedLZ4CompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, Parameters.DEFAULT);
    }

    public FramedLZ4CompressorOutputStream(OutputStream outputStream, Parameters parameters) throws IOException {
        this.oneByte = new byte[1];
        this.finished = false;
        this.currentIndex = 0;
        this.contentHash = new XXHash32();
        this.params = parameters;
        this.blockData = new byte[parameters.blockSize.getSize()];
        this.out = outputStream;
        byte[] bArr = null;
        this.blockHash = parameters.withBlockChecksum ? new XXHash32() : null;
        outputStream.write(FramedLZ4CompressorInputStream.LZ4_SIGNATURE);
        writeFrameDescriptor();
        this.blockDependencyBuffer = parameters.withBlockDependency ? new byte[65536] : bArr;
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i & 255);
        write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.params.withContentChecksum) {
            this.contentHash.update(bArr, i, i2);
        }
        if (this.currentIndex + i2 > this.blockData.length) {
            flushBlock();
            while (true) {
                byte[] bArr2 = this.blockData;
                if (i2 <= bArr2.length) {
                    break;
                }
                System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
                byte[] bArr3 = this.blockData;
                i += bArr3.length;
                i2 -= bArr3.length;
                this.currentIndex = bArr3.length;
                flushBlock();
            }
        }
        System.arraycopy(bArr, i, this.blockData, this.currentIndex, i2);
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
        if (!this.finished) {
            if (this.currentIndex > 0) {
                flushBlock();
            }
            writeTrailer();
            this.finished = true;
        }
    }

    private void writeFrameDescriptor() throws IOException {
        int i = !this.params.withBlockDependency ? 96 : 64;
        if (this.params.withContentChecksum) {
            i |= 4;
        }
        if (this.params.withBlockChecksum) {
            i |= 16;
        }
        this.out.write(i);
        this.contentHash.update(i);
        int index = (this.params.blockSize.getIndex() << 4) & 112;
        this.out.write(index);
        this.contentHash.update(index);
        this.out.write((int) ((this.contentHash.getValue() >> 8) & 255));
        this.contentHash.reset();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a0, code lost:
        r0.addSuppressed(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a3, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void flushBlock() throws java.io.IOException {
        /*
            r8 = this;
            org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream$Parameters r0 = r8.params
            boolean r0 = r0.withBlockDependency
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream r2 = new org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream
            org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream$Parameters r3 = r8.params
            org.apache.commons.compress.compressors.lz77support.Parameters r3 = r3.lz77params
            r2.<init>(r1, r3)
            if (r0 == 0) goto L_0x0021
            byte[] r3 = r8.blockDependencyBuffer     // Catch:{ all -> 0x0098 }
            int r4 = r3.length     // Catch:{ all -> 0x0098 }
            int r5 = r8.collectedBlockDependencyBytes     // Catch:{ all -> 0x0098 }
            int r4 = r4 - r5
            r2.prefill(r3, r4, r5)     // Catch:{ all -> 0x0098 }
        L_0x0021:
            byte[] r3 = r8.blockData     // Catch:{ all -> 0x0098 }
            int r4 = r8.currentIndex     // Catch:{ all -> 0x0098 }
            r5 = 0
            r2.write(r3, r5, r4)     // Catch:{ all -> 0x0098 }
            r2.close()
            if (r0 == 0) goto L_0x0035
            byte[] r0 = r8.blockData
            int r2 = r8.currentIndex
            r8.appendToBlockDependencyBuffer(r0, r5, r2)
        L_0x0035:
            byte[] r0 = r1.toByteArray()
            int r1 = r0.length
            int r2 = r8.currentIndex
            r3 = 4
            if (r1 <= r2) goto L_0x0063
            java.io.OutputStream r0 = r8.out
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 | r2
            long r1 = (long) r1
            org.apache.commons.compress.utils.ByteUtils.toLittleEndian((java.io.OutputStream) r0, (long) r1, (int) r3)
            java.io.OutputStream r0 = r8.out
            byte[] r1 = r8.blockData
            int r2 = r8.currentIndex
            r0.write(r1, r5, r2)
            org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream$Parameters r0 = r8.params
            boolean r0 = r0.withBlockChecksum
            if (r0 == 0) goto L_0x007d
            org.apache.commons.compress.compressors.lz4.XXHash32 r0 = r8.blockHash
            byte[] r1 = r8.blockData
            int r2 = r8.currentIndex
            r0.update(r1, r5, r2)
            goto L_0x007d
        L_0x0063:
            java.io.OutputStream r1 = r8.out
            int r2 = r0.length
            long r6 = (long) r2
            org.apache.commons.compress.utils.ByteUtils.toLittleEndian((java.io.OutputStream) r1, (long) r6, (int) r3)
            java.io.OutputStream r1 = r8.out
            r1.write(r0)
            org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream$Parameters r1 = r8.params
            boolean r1 = r1.withBlockChecksum
            if (r1 == 0) goto L_0x007d
            org.apache.commons.compress.compressors.lz4.XXHash32 r1 = r8.blockHash
            int r2 = r0.length
            r1.update(r0, r5, r2)
        L_0x007d:
            org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream$Parameters r0 = r8.params
            boolean r0 = r0.withBlockChecksum
            if (r0 == 0) goto L_0x0095
            java.io.OutputStream r0 = r8.out
            org.apache.commons.compress.compressors.lz4.XXHash32 r1 = r8.blockHash
            long r1 = r1.getValue()
            org.apache.commons.compress.utils.ByteUtils.toLittleEndian((java.io.OutputStream) r0, (long) r1, (int) r3)
            org.apache.commons.compress.compressors.lz4.XXHash32 r0 = r8.blockHash
            r0.reset()
        L_0x0095:
            r8.currentIndex = r5
            return
        L_0x0098:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x009a }
        L_0x009a:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x009f }
            goto L_0x00a3
        L_0x009f:
            r2 = move-exception
            r0.addSuppressed(r2)
        L_0x00a3:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.lz4.FramedLZ4CompressorOutputStream.flushBlock():void");
    }

    private void writeTrailer() throws IOException {
        this.out.write(END_MARK);
        if (this.params.withContentChecksum) {
            ByteUtils.toLittleEndian(this.out, this.contentHash.getValue(), 4);
        }
    }

    private void appendToBlockDependencyBuffer(byte[] bArr, int i, int i2) {
        int min = Math.min(i2, this.blockDependencyBuffer.length);
        if (min > 0) {
            byte[] bArr2 = this.blockDependencyBuffer;
            int length = bArr2.length - min;
            if (length > 0) {
                System.arraycopy(bArr2, min, bArr2, 0, length);
            }
            System.arraycopy(bArr, i, this.blockDependencyBuffer, length, min);
            this.collectedBlockDependencyBytes = Math.min(this.collectedBlockDependencyBytes + min, this.blockDependencyBuffer.length);
        }
    }
}
