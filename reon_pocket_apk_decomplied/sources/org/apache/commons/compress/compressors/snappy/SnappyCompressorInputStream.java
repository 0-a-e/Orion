package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.InputStream;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.apache.commons.compress.compressors.lz77support.AbstractLZ77CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;

public class SnappyCompressorInputStream extends AbstractLZ77CompressorInputStream {
    public static final int DEFAULT_BLOCK_SIZE = 32768;
    private static final int TAG_MASK = 3;
    private boolean endReached;
    private final int size;
    private State state;
    private int uncompressedBytesRemaining;

    private enum State {
        NO_BLOCK,
        IN_LITERAL,
        IN_BACK_REFERENCE
    }

    public SnappyCompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, 32768);
    }

    public SnappyCompressorInputStream(InputStream inputStream, int i) throws IOException {
        super(inputStream, i);
        this.state = State.NO_BLOCK;
        this.endReached = false;
        int readSize = (int) readSize();
        this.size = readSize;
        this.uncompressedBytesRemaining = readSize;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.endReached) {
            return -1;
        }
        int i3 = AnonymousClass1.$SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State[this.state.ordinal()];
        if (i3 == 1) {
            fill();
            return read(bArr, i, i2);
        } else if (i3 == 2) {
            int readLiteral = readLiteral(bArr, i, i2);
            if (!hasMoreDataInBlock()) {
                this.state = State.NO_BLOCK;
            }
            if (readLiteral > 0) {
                return readLiteral;
            }
            return read(bArr, i, i2);
        } else if (i3 == 3) {
            int readBackReference = readBackReference(bArr, i, i2);
            if (!hasMoreDataInBlock()) {
                this.state = State.NO_BLOCK;
            }
            return readBackReference > 0 ? readBackReference : read(bArr, i, i2);
        } else {
            throw new IOException("Unknown stream state " + this.state);
        }
    }

    /* renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$State[] r0 = org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State = r0
                org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$State r1 = org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.State.NO_BLOCK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$State r1 = org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.State.IN_LITERAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$compress$compressors$snappy$SnappyCompressorInputStream$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream$State r1 = org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.State.IN_BACK_REFERENCE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.snappy.SnappyCompressorInputStream.AnonymousClass1.<clinit>():void");
        }
    }

    private void fill() throws IOException {
        if (this.uncompressedBytesRemaining == 0) {
            this.endReached = true;
            return;
        }
        int readOneByte = readOneByte();
        if (readOneByte != -1) {
            int i = readOneByte & 3;
            if (i == 0) {
                int readLiteralLength = readLiteralLength(readOneByte);
                if (readLiteralLength >= 0) {
                    this.uncompressedBytesRemaining -= readLiteralLength;
                    startLiteral((long) readLiteralLength);
                    this.state = State.IN_LITERAL;
                    return;
                }
                throw new IOException("Illegal block with a negative literal size found");
            } else if (i == 1) {
                int i2 = ((readOneByte >> 2) & 7) + 4;
                if (i2 >= 0) {
                    this.uncompressedBytesRemaining -= i2;
                    int i3 = (readOneByte & 224) << 3;
                    int readOneByte2 = readOneByte();
                    if (readOneByte2 != -1) {
                        try {
                            startBackReference(i3 | readOneByte2, (long) i2);
                            this.state = State.IN_BACK_REFERENCE;
                        } catch (IllegalArgumentException e) {
                            throw new IOException("Illegal block with bad offset found", e);
                        }
                    } else {
                        throw new IOException("Premature end of stream reading back-reference length");
                    }
                } else {
                    throw new IOException("Illegal block with a negative match length found");
                }
            } else if (i == 2) {
                int i4 = (readOneByte >> 2) + 1;
                if (i4 >= 0) {
                    this.uncompressedBytesRemaining -= i4;
                    try {
                        startBackReference((int) ByteUtils.fromLittleEndian(this.supplier, 2), (long) i4);
                        this.state = State.IN_BACK_REFERENCE;
                    } catch (IllegalArgumentException e2) {
                        throw new IOException("Illegal block with bad offset found", e2);
                    }
                } else {
                    throw new IOException("Illegal block with a negative match length found");
                }
            } else if (i == 3) {
                int i5 = (readOneByte >> 2) + 1;
                if (i5 >= 0) {
                    this.uncompressedBytesRemaining -= i5;
                    try {
                        startBackReference(((int) ByteUtils.fromLittleEndian(this.supplier, 4)) & Integer.MAX_VALUE, (long) i5);
                        this.state = State.IN_BACK_REFERENCE;
                    } catch (IllegalArgumentException e3) {
                        throw new IOException("Illegal block with bad offset found", e3);
                    }
                } else {
                    throw new IOException("Illegal block with a negative match length found");
                }
            }
        } else {
            throw new IOException("Premature end of stream reading block start");
        }
    }

    private int readLiteralLength(int i) throws IOException {
        long j;
        int i2 = i >> 2;
        switch (i2) {
            case 60:
                i2 = readOneByte();
                if (i2 == -1) {
                    throw new IOException("Premature end of stream reading literal length");
                }
                break;
            case LockFreeTaskQueueCore.CLOSED_SHIFT:
                j = ByteUtils.fromLittleEndian(this.supplier, 2);
                break;
            case 62:
                j = ByteUtils.fromLittleEndian(this.supplier, 3);
                break;
            case 63:
                j = ByteUtils.fromLittleEndian(this.supplier, 4);
                break;
        }
        i2 = (int) j;
        return i2 + 1;
    }

    private long readSize() throws IOException {
        int i = 0;
        long j = 0;
        while (true) {
            int readOneByte = readOneByte();
            if (readOneByte != -1) {
                int i2 = i + 1;
                j |= (long) ((readOneByte & WorkQueueKt.MASK) << (i * 7));
                if ((readOneByte & 128) == 0) {
                    return j;
                }
                i = i2;
            } else {
                throw new IOException("Premature end of stream reading size");
            }
        }
    }

    public int getSize() {
        return this.size;
    }
}
