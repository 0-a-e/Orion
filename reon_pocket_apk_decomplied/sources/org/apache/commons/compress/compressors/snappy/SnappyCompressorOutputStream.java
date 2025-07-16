package org.apache.commons.compress.compressors.snappy;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

public class SnappyCompressorOutputStream extends CompressorOutputStream {
    private static final int FOUR_BYTE_COPY_TAG = 3;
    private static final int FOUR_SIZE_BYTE_MARKER = 252;
    private static final int MAX_LITERAL_SIZE_WITHOUT_SIZE_BYTES = 60;
    private static final int MAX_LITERAL_SIZE_WITH_ONE_SIZE_BYTE = 256;
    private static final int MAX_LITERAL_SIZE_WITH_THREE_SIZE_BYTES = 16777216;
    private static final int MAX_LITERAL_SIZE_WITH_TWO_SIZE_BYTES = 65536;
    private static final int MAX_MATCH_LENGTH = 64;
    private static final int MAX_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 11;
    private static final int MAX_OFFSET_WITH_ONE_OFFSET_BYTE = 1024;
    private static final int MAX_OFFSET_WITH_TWO_OFFSET_BYTES = 32768;
    private static final int MIN_MATCH_LENGTH = 4;
    private static final int MIN_MATCH_LENGTH_WITH_ONE_OFFSET_BYTE = 4;
    private static final int ONE_BYTE_COPY_TAG = 1;
    private static final int ONE_SIZE_BYTE_MARKER = 240;
    private static final int THREE_SIZE_BYTE_MARKER = 248;
    private static final int TWO_BYTE_COPY_TAG = 2;
    private static final int TWO_SIZE_BYTE_MARKER = 244;
    private final LZ77Compressor compressor;
    private final ByteUtils.ByteConsumer consumer;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream os;

    public SnappyCompressorOutputStream(OutputStream outputStream, long j) throws IOException {
        this(outputStream, j, 32768);
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j, int i) throws IOException {
        this(outputStream, j, createParameterBuilder(i).build());
    }

    public SnappyCompressorOutputStream(OutputStream outputStream, long j, Parameters parameters) throws IOException {
        this.oneByte = new byte[1];
        this.finished = false;
        this.os = outputStream;
        this.consumer = new ByteUtils.OutputStreamByteConsumer(outputStream);
        this.compressor = new LZ77Compressor(parameters, new LZ77Compressor.Callback() {
            public void accept(LZ77Compressor.Block block) throws IOException {
                int i = AnonymousClass2.$SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[block.getType().ordinal()];
                if (i == 1) {
                    SnappyCompressorOutputStream.this.writeLiteralBlock((LZ77Compressor.LiteralBlock) block);
                } else if (i == 2) {
                    SnappyCompressorOutputStream.this.writeBackReference((LZ77Compressor.BackReference) block);
                }
            }
        });
        writeUncompressedSize(j);
    }

    /* renamed from: org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType[] r0 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType = r0
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.LITERAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.BACK_REFERENCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.apache.commons.compress.compressors.lz77support.LZ77Compressor$Block$BlockType r1 = org.apache.commons.compress.compressors.lz77support.LZ77Compressor.Block.BlockType.EOD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.snappy.SnappyCompressorOutputStream.AnonymousClass2.<clinit>():void");
        }
    }

    public void write(int i) throws IOException {
        byte[] bArr = this.oneByte;
        bArr[0] = (byte) (i & 255);
        write(bArr);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.compressor.compress(bArr, i, i2);
    }

    public void close() throws IOException {
        try {
            finish();
        } finally {
            this.os.close();
        }
    }

    public void finish() throws IOException {
        if (!this.finished) {
            this.compressor.finish();
            this.finished = true;
        }
    }

    private void writeUncompressedSize(long j) throws IOException {
        boolean z;
        do {
            int i = (int) (127 & j);
            z = j > ((long) i);
            if (z) {
                i |= 128;
            }
            this.os.write(i);
            j >>= 7;
        } while (z);
    }

    /* access modifiers changed from: private */
    public void writeLiteralBlock(LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        int length = literalBlock.getLength();
        if (length <= 60) {
            writeLiteralBlockNoSizeBytes(literalBlock, length);
        } else if (length <= 256) {
            writeLiteralBlockOneSizeByte(literalBlock, length);
        } else if (length <= 65536) {
            writeLiteralBlockTwoSizeBytes(literalBlock, length);
        } else if (length <= 16777216) {
            writeLiteralBlockThreeSizeBytes(literalBlock, length);
        } else {
            writeLiteralBlockFourSizeBytes(literalBlock, length);
        }
    }

    private void writeLiteralBlockNoSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize((i - 1) << 2, 0, i, literalBlock);
    }

    private void writeLiteralBlockOneSizeByte(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize(ONE_SIZE_BYTE_MARKER, 1, i, literalBlock);
    }

    private void writeLiteralBlockTwoSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize(TWO_SIZE_BYTE_MARKER, 2, i, literalBlock);
    }

    private void writeLiteralBlockThreeSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize(THREE_SIZE_BYTE_MARKER, 3, i, literalBlock);
    }

    private void writeLiteralBlockFourSizeBytes(LZ77Compressor.LiteralBlock literalBlock, int i) throws IOException {
        writeLiteralBlockWithSize(FOUR_SIZE_BYTE_MARKER, 4, i, literalBlock);
    }

    private void writeLiteralBlockWithSize(int i, int i2, int i3, LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        this.os.write(i);
        writeLittleEndian(i2, i3 - 1);
        this.os.write(literalBlock.getData(), literalBlock.getOffset(), i3);
    }

    private void writeLittleEndian(int i, int i2) throws IOException {
        ByteUtils.toLittleEndian(this.consumer, (long) i2, i);
    }

    /* access modifiers changed from: private */
    public void writeBackReference(LZ77Compressor.BackReference backReference) throws IOException {
        int length = backReference.getLength();
        int offset = backReference.getOffset();
        if (length >= 4 && length <= 11 && offset <= 1024) {
            writeBackReferenceWithOneOffsetByte(length, offset);
        } else if (offset < 32768) {
            writeBackReferenceWithTwoOffsetBytes(length, offset);
        } else {
            writeBackReferenceWithFourOffsetBytes(length, offset);
        }
    }

    private void writeBackReferenceWithOneOffsetByte(int i, int i2) throws IOException {
        this.os.write(((i - 4) << 2) | 1 | ((i2 & 1792) >> 3));
        this.os.write(i2 & 255);
    }

    private void writeBackReferenceWithTwoOffsetBytes(int i, int i2) throws IOException {
        writeBackReferenceWithLittleEndianOffset(2, 2, i, i2);
    }

    private void writeBackReferenceWithFourOffsetBytes(int i, int i2) throws IOException {
        writeBackReferenceWithLittleEndianOffset(3, 4, i, i2);
    }

    private void writeBackReferenceWithLittleEndianOffset(int i, int i2, int i3, int i4) throws IOException {
        this.os.write(i | ((i3 - 1) << 2));
        writeLittleEndian(i2, i4);
    }

    public static Parameters.Builder createParameterBuilder(int i) {
        return Parameters.builder(i).withMinBackReferenceLength(4).withMaxBackReferenceLength(64).withMaxOffset(i).withMaxLiteralLength(i);
    }
}
