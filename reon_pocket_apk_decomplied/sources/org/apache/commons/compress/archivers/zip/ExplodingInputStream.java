package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

class ExplodingInputStream extends InputStream implements InputStreamStatistics {
    private BitStream bits;
    private final CircularBuffer buffer = new CircularBuffer(32768);
    private final int dictionarySize;
    private BinaryTree distanceTree;
    private final InputStream in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;
    private long treeSizes = 0;
    private long uncompressedCount = 0;

    public ExplodingInputStream(int i, int i2, InputStream inputStream) {
        if (i != 4096 && i != 8192) {
            throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
        } else if (i2 == 2 || i2 == 3) {
            this.dictionarySize = i;
            this.numberOfTrees = i2;
            this.minimumMatchLength = i2;
            this.in = inputStream;
        } else {
            throw new IllegalArgumentException("The number of trees must be 2 or 3");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0043, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0044, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0047, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init() throws java.io.IOException {
        /*
            r5 = this;
            org.apache.commons.compress.archivers.zip.BitStream r0 = r5.bits
            if (r0 != 0) goto L_0x0048
            org.apache.commons.compress.archivers.zip.ExplodingInputStream$1 r0 = new org.apache.commons.compress.archivers.zip.ExplodingInputStream$1
            java.io.InputStream r1 = r5.in
            r0.<init>(r1)
            int r1 = r5.numberOfTrees     // Catch:{ all -> 0x003c }
            r2 = 3
            if (r1 != r2) goto L_0x0018
            r1 = 256(0x100, float:3.59E-43)
            org.apache.commons.compress.archivers.zip.BinaryTree r1 = org.apache.commons.compress.archivers.zip.BinaryTree.decode(r0, r1)     // Catch:{ all -> 0x003c }
            r5.literalTree = r1     // Catch:{ all -> 0x003c }
        L_0x0018:
            r1 = 64
            org.apache.commons.compress.archivers.zip.BinaryTree r2 = org.apache.commons.compress.archivers.zip.BinaryTree.decode(r0, r1)     // Catch:{ all -> 0x003c }
            r5.lengthTree = r2     // Catch:{ all -> 0x003c }
            org.apache.commons.compress.archivers.zip.BinaryTree r1 = org.apache.commons.compress.archivers.zip.BinaryTree.decode(r0, r1)     // Catch:{ all -> 0x003c }
            r5.distanceTree = r1     // Catch:{ all -> 0x003c }
            long r1 = r5.treeSizes     // Catch:{ all -> 0x003c }
            long r3 = r0.getBytesRead()     // Catch:{ all -> 0x003c }
            long r1 = r1 + r3
            r5.treeSizes = r1     // Catch:{ all -> 0x003c }
            r0.close()
            org.apache.commons.compress.archivers.zip.BitStream r0 = new org.apache.commons.compress.archivers.zip.BitStream
            java.io.InputStream r1 = r5.in
            r0.<init>(r1)
            r5.bits = r0
            goto L_0x0048
        L_0x003c:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003e }
        L_0x003e:
            r2 = move-exception
            r0.close()     // Catch:{ all -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0047:
            throw r2
        L_0x0048:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.zip.ExplodingInputStream.init():void");
    }

    public int read() throws IOException {
        if (!this.buffer.available()) {
            fillBuffer();
        }
        int i = this.buffer.get();
        if (i > -1) {
            this.uncompressedCount++;
        }
        return i;
    }

    public long getCompressedCount() {
        return this.bits.getBytesRead() + this.treeSizes;
    }

    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    public void close() throws IOException {
        this.in.close();
    }

    private void fillBuffer() throws IOException {
        int i;
        init();
        int nextBit = this.bits.nextBit();
        if (nextBit != -1) {
            if (nextBit == 1) {
                BinaryTree binaryTree = this.literalTree;
                if (binaryTree != null) {
                    i = binaryTree.read(this.bits);
                } else {
                    i = this.bits.nextByte();
                }
                if (i != -1) {
                    this.buffer.put(i);
                    return;
                }
                return;
            }
            int i2 = this.dictionarySize == 4096 ? 6 : 7;
            int nextBits = (int) this.bits.nextBits(i2);
            int read = this.distanceTree.read(this.bits);
            if (read != -1 || nextBits > 0) {
                int i3 = (read << i2) | nextBits;
                int read2 = this.lengthTree.read(this.bits);
                if (read2 == 63) {
                    long nextBits2 = this.bits.nextBits(8);
                    if (nextBits2 != -1) {
                        read2 = (int) (((long) read2) + nextBits2);
                    } else {
                        return;
                    }
                }
                this.buffer.copy(i3 + 1, read2 + this.minimumMatchLength);
            }
        }
    }
}
