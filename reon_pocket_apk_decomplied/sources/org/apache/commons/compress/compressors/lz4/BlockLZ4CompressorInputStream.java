package org.apache.commons.compress.compressors.lz4;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

public class BlockLZ4CompressorInputStream extends AbstractLZ77CompressorInputStream {
    static final int BACK_REFERENCE_SIZE_MASK = 15;
    static final int LITERAL_SIZE_MASK = 240;
    static final int SIZE_BITS = 4;
    static final int WINDOW_SIZE = 65536;
    private int nextBackReferenceSize;
    private State state = State.NO_BLOCK;

    private enum State {
        NO_BLOCK,
        IN_LITERAL,
        LOOKING_FOR_BACK_REFERENCE,
        IN_BACK_REFERENCE,
        EOF
    }

    public BlockLZ4CompressorInputStream(InputStream inputStream) throws IOException {
        super(inputStream, 65536);
    }

    /* renamed from: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$State[] r0 = org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State = r0
                org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$State r1 = org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream.State.EOF     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$State r1 = org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream.State.NO_BLOCK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$State r1 = org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream.State.IN_LITERAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$State r1 = org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream.State.LOOKING_FOR_BACK_REFERENCE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State     // Catch:{ NoSuchFieldError -> 0x003e }
                org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream$State r1 = org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream.State.IN_BACK_REFERENCE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorInputStream.AnonymousClass1.<clinit>():void");
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$lz4$BlockLZ4CompressorInputStream$State[this.state.ordinal()];
        if (i3 == 1) {
            return -1;
        }
        if (i3 == 2) {
            readSizes();
        } else if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    throw new IOException("Unknown stream state " + this.state);
                }
            } else if (!initializeBackReference()) {
                this.state = State.EOF;
                return -1;
            }
            int readBackReference = readBackReference(bArr, i, i2);
            if (!hasMoreDataInBlock()) {
                this.state = State.NO_BLOCK;
            }
            if (readBackReference > 0) {
                return readBackReference;
            }
            return read(bArr, i, i2);
        }
        int readLiteral = readLiteral(bArr, i, i2);
        if (!hasMoreDataInBlock()) {
            this.state = State.LOOKING_FOR_BACK_REFERENCE;
        }
        return readLiteral > 0 ? readLiteral : read(bArr, i, i2);
    }

    private void readSizes() throws IOException {
        int readOneByte = readOneByte();
        if (readOneByte != -1) {
            this.nextBackReferenceSize = readOneByte & 15;
            long j = (long) ((readOneByte & LITERAL_SIZE_MASK) >> 4);
            if (j == 15) {
                j += readSizeBytes();
            }
            if (j >= 0) {
                startLiteral(j);
                this.state = State.IN_LITERAL;
                return;
            }
            throw new IOException("Illegal block with a negative literal size found");
        }
        throw new IOException("Premature end of stream while looking for next block");
    }

    private long readSizeBytes() throws IOException {
        int readOneByte;
        long j = 0;
        do {
            readOneByte = readOneByte();
            if (readOneByte != -1) {
                j += (long) readOneByte;
            } else {
                throw new IOException("Premature end of stream while parsing length");
            }
        } while (readOneByte == 255);
        return j;
    }

    private boolean initializeBackReference() throws IOException {
        try {
            int fromLittleEndian = (int) ByteUtils.fromLittleEndian(this.supplier, 2);
            int i = this.nextBackReferenceSize;
            long j = (long) i;
            if (i == 15) {
                j += readSizeBytes();
            }
            if (j >= 0) {
                try {
                    startBackReference(fromLittleEndian, j + 4);
                    this.state = State.IN_BACK_REFERENCE;
                    return true;
                } catch (IllegalArgumentException e) {
                    throw new IOException("Illegal block with bad offset found", e);
                }
            } else {
                throw new IOException("Illegal block with a negative match length found");
            }
        } catch (IOException e2) {
            if (this.nextBackReferenceSize == 0) {
                return false;
            }
            throw e2;
        }
    }
}
