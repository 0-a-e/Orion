package org.apache.commons.compress.compressors.deflate64;

import com.amazonaws.services.s3.internal.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.utils.BitInputStream;

class HuffmanDecoder implements Closeable {
    private static final int[] CODE_LENGTHS_ORDER = {16, 17, 18, 0, 8, 7, 9, 6, 10, 5, 11, 4, 12, 3, 13, 2, 14, 1, 15};
    /* access modifiers changed from: private */
    public static final int[] DISTANCE_TABLE = {16, 32, 48, 64, 81, 113, 146, 210, 275, Constants.BUCKET_ACCESS_FORBIDDEN_STATUS_CODE, 532, 788, 1045, 1557, 2070, 3094, 4119, 6167, 8216, 12312, 16409, 24601, 32794, 49178, 65563, 98331, 131100, 196636, 262173, 393245, 524318, 786462};
    private static final int[] FIXED_DISTANCE;
    private static final int[] FIXED_LITERALS;
    /* access modifiers changed from: private */
    public static final short[] RUN_LENGTH_TABLE = {96, 128, 160, 192, 224, 256, 288, 320, 353, 417, 481, 545, 610, 738, 866, 994, 1123, 1379, 1635, 1891, 2148, 2660, 3172, 3684, 4197, 5221, 6245, 7269, 112};
    private boolean finalBlock = false;
    /* access modifiers changed from: private */
    public final InputStream in;
    /* access modifiers changed from: private */
    public final DecodingMemory memory = new DecodingMemory();
    /* access modifiers changed from: private */
    public BitInputStream reader;
    private DecoderState state;

    static {
        int[] iArr = new int[288];
        FIXED_LITERALS = iArr;
        Arrays.fill(iArr, 0, 144, 8);
        Arrays.fill(iArr, 144, 256, 9);
        Arrays.fill(iArr, 256, 280, 7);
        Arrays.fill(iArr, 280, 288, 8);
        int[] iArr2 = new int[32];
        FIXED_DISTANCE = iArr2;
        Arrays.fill(iArr2, 5);
    }

    HuffmanDecoder(InputStream inputStream) {
        this.reader = new BitInputStream(inputStream, ByteOrder.LITTLE_ENDIAN);
        this.in = inputStream;
        this.state = new InitialState();
    }

    public void close() {
        this.state = new InitialState();
        this.reader = null;
    }

    public int decode(byte[] bArr) throws IOException {
        return decode(bArr, 0, bArr.length);
    }

    public int decode(byte[] bArr, int i, int i2) throws IOException {
        while (true) {
            if (this.finalBlock && !this.state.hasData()) {
                return -1;
            }
            if (this.state.state() != HuffmanState.INITIAL) {
                return this.state.read(bArr, i, i2);
            }
            this.finalBlock = readBits(1) == 1;
            int readBits = (int) readBits(2);
            if (readBits == 0) {
                switchToUncompressedState();
            } else if (readBits == 1) {
                this.state = new HuffmanCodes(HuffmanState.FIXED_CODES, FIXED_LITERALS, FIXED_DISTANCE);
            } else if (readBits == 2) {
                int[][] readDynamicTables = readDynamicTables();
                this.state = new HuffmanCodes(HuffmanState.DYNAMIC_CODES, readDynamicTables[0], readDynamicTables[1]);
            } else {
                throw new IllegalStateException("Unsupported compression: " + readBits);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public long getBytesRead() {
        return this.reader.getBytesRead();
    }

    private void switchToUncompressedState() throws IOException {
        this.reader.alignWithByteBoundary();
        long readBits = readBits(16);
        if ((65535 & (readBits ^ 65535)) == readBits(16)) {
            this.state = new UncompressedState(readBits);
            return;
        }
        throw new IllegalStateException("Illegal LEN / NLEN values");
    }

    private int[][] readDynamicTables() throws IOException {
        int[][] iArr = {new int[((int) (readBits(5) + 257))], new int[((int) (readBits(5) + 1))]};
        populateDynamicTables(this.reader, iArr[0], iArr[1]);
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public int available() throws IOException {
        return this.state.available();
    }

    private static abstract class DecoderState {
        /* access modifiers changed from: package-private */
        public abstract int available() throws IOException;

        /* access modifiers changed from: package-private */
        public abstract boolean hasData();

        /* access modifiers changed from: package-private */
        public abstract int read(byte[] bArr, int i, int i2) throws IOException;

        /* access modifiers changed from: package-private */
        public abstract HuffmanState state();

        private DecoderState() {
        }
    }

    private class UncompressedState extends DecoderState {
        private final long blockLength;
        private long read;

        private UncompressedState(long j) {
            super();
            this.blockLength = j;
        }

        /* access modifiers changed from: package-private */
        public HuffmanState state() {
            return this.read < this.blockLength ? HuffmanState.STORED : HuffmanState.INITIAL;
        }

        /* access modifiers changed from: package-private */
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            int min = (int) Math.min(this.blockLength - this.read, (long) i2);
            int i4 = 0;
            while (i4 < min) {
                if (HuffmanDecoder.this.reader.bitsCached() > 0) {
                    bArr[i + i4] = HuffmanDecoder.this.memory.add((byte) ((int) HuffmanDecoder.this.readBits(8)));
                    i3 = 1;
                } else {
                    int i5 = i + i4;
                    i3 = HuffmanDecoder.this.in.read(bArr, i5, min - i4);
                    if (i3 != -1) {
                        HuffmanDecoder.this.memory.add(bArr, i5, i3);
                    } else {
                        throw new EOFException("Truncated Deflate64 Stream");
                    }
                }
                this.read += (long) i3;
                i4 += i3;
            }
            return min;
        }

        /* access modifiers changed from: package-private */
        public boolean hasData() {
            return this.read < this.blockLength;
        }

        /* access modifiers changed from: package-private */
        public int available() throws IOException {
            return (int) Math.min(this.blockLength - this.read, HuffmanDecoder.this.reader.bitsAvailable() / 8);
        }
    }

    private class InitialState extends DecoderState {
        /* access modifiers changed from: package-private */
        public int available() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean hasData() {
            return false;
        }

        private InitialState() {
            super();
        }

        /* access modifiers changed from: package-private */
        public HuffmanState state() {
            return HuffmanState.INITIAL;
        }

        /* access modifiers changed from: package-private */
        public int read(byte[] bArr, int i, int i2) throws IOException {
            throw new IllegalStateException("Cannot read in this state");
        }
    }

    private class HuffmanCodes extends DecoderState {
        private final BinaryTreeNode distanceTree;
        private boolean endOfBlock = false;
        private final BinaryTreeNode lengthTree;
        private byte[] runBuffer = new byte[0];
        private int runBufferLength = 0;
        private int runBufferPos = 0;
        private final HuffmanState state;

        HuffmanCodes(HuffmanState huffmanState, int[] iArr, int[] iArr2) {
            super();
            this.state = huffmanState;
            this.lengthTree = HuffmanDecoder.buildTree(iArr);
            this.distanceTree = HuffmanDecoder.buildTree(iArr2);
        }

        /* access modifiers changed from: package-private */
        public HuffmanState state() {
            return this.endOfBlock ? HuffmanState.INITIAL : this.state;
        }

        /* access modifiers changed from: package-private */
        public int read(byte[] bArr, int i, int i2) throws IOException {
            return decodeNext(bArr, i, i2);
        }

        private int decodeNext(byte[] bArr, int i, int i2) throws IOException {
            if (this.endOfBlock) {
                return -1;
            }
            int copyFromRunBuffer = copyFromRunBuffer(bArr, i, i2);
            while (true) {
                if (copyFromRunBuffer < i2) {
                    int access$900 = HuffmanDecoder.nextSymbol(HuffmanDecoder.this.reader, this.lengthTree);
                    if (access$900 >= 256) {
                        if (access$900 <= 256) {
                            this.endOfBlock = true;
                            break;
                        }
                        short s = HuffmanDecoder.RUN_LENGTH_TABLE[access$900 - 257];
                        int access$500 = (int) (((long) (s >>> 5)) + HuffmanDecoder.this.readBits(s & 31));
                        int i3 = HuffmanDecoder.DISTANCE_TABLE[HuffmanDecoder.nextSymbol(HuffmanDecoder.this.reader, this.distanceTree)];
                        int access$5002 = (int) (((long) (i3 >>> 4)) + HuffmanDecoder.this.readBits(i3 & 15));
                        if (this.runBuffer.length < access$500) {
                            this.runBuffer = new byte[access$500];
                        }
                        this.runBufferLength = access$500;
                        this.runBufferPos = 0;
                        HuffmanDecoder.this.memory.recordToBuffer(access$5002, access$500, this.runBuffer);
                        copyFromRunBuffer += copyFromRunBuffer(bArr, i + copyFromRunBuffer, i2 - copyFromRunBuffer);
                    } else {
                        bArr[copyFromRunBuffer + i] = HuffmanDecoder.this.memory.add((byte) access$900);
                        copyFromRunBuffer++;
                    }
                } else {
                    break;
                }
            }
            return copyFromRunBuffer;
        }

        private int copyFromRunBuffer(byte[] bArr, int i, int i2) {
            int i3 = this.runBufferLength - this.runBufferPos;
            if (i3 <= 0) {
                return 0;
            }
            int min = Math.min(i2, i3);
            System.arraycopy(this.runBuffer, this.runBufferPos, bArr, i, min);
            this.runBufferPos += min;
            return min;
        }

        /* access modifiers changed from: package-private */
        public boolean hasData() {
            return !this.endOfBlock;
        }

        /* access modifiers changed from: package-private */
        public int available() {
            return this.runBufferLength - this.runBufferPos;
        }
    }

    /* access modifiers changed from: private */
    public static int nextSymbol(BitInputStream bitInputStream, BinaryTreeNode binaryTreeNode) throws IOException {
        while (binaryTreeNode != null && binaryTreeNode.literal == -1) {
            binaryTreeNode = readBits(bitInputStream, 1) == 0 ? binaryTreeNode.leftNode : binaryTreeNode.rightNode;
        }
        if (binaryTreeNode != null) {
            return binaryTreeNode.literal;
        }
        return -1;
    }

    private static void populateDynamicTables(BitInputStream bitInputStream, int[] iArr, int[] iArr2) throws IOException {
        long readBits;
        int readBits2 = (int) (readBits(bitInputStream, 4) + 4);
        int[] iArr3 = new int[19];
        for (int i = 0; i < readBits2; i++) {
            iArr3[CODE_LENGTHS_ORDER[i]] = (int) readBits(bitInputStream, 3);
        }
        BinaryTreeNode buildTree = buildTree(iArr3);
        int length = iArr.length + iArr2.length;
        int[] iArr4 = new int[length];
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i4 > 0) {
                iArr4[i3] = i2;
                i4--;
                i3++;
            } else {
                int nextSymbol = nextSymbol(bitInputStream, buildTree);
                if (nextSymbol < 16) {
                    iArr4[i3] = nextSymbol;
                    i3++;
                    i2 = nextSymbol;
                } else if (nextSymbol == 16) {
                    i4 = (int) (readBits(bitInputStream, 2) + 3);
                } else {
                    if (nextSymbol == 17) {
                        readBits = readBits(bitInputStream, 3) + 3;
                    } else if (nextSymbol == 18) {
                        readBits = readBits(bitInputStream, 7) + 11;
                    }
                    i4 = (int) readBits;
                    i2 = 0;
                }
            }
        }
        System.arraycopy(iArr4, 0, iArr, 0, iArr.length);
        System.arraycopy(iArr4, iArr.length, iArr2, 0, iArr2.length);
    }

    private static class BinaryTreeNode {
        private final int bits;
        BinaryTreeNode leftNode;
        int literal;
        BinaryTreeNode rightNode;

        private BinaryTreeNode(int i) {
            this.literal = -1;
            this.bits = i;
        }

        /* access modifiers changed from: package-private */
        public void leaf(int i) {
            this.literal = i;
            this.leftNode = null;
            this.rightNode = null;
        }

        /* access modifiers changed from: package-private */
        public BinaryTreeNode left() {
            if (this.leftNode == null && this.literal == -1) {
                this.leftNode = new BinaryTreeNode(this.bits + 1);
            }
            return this.leftNode;
        }

        /* access modifiers changed from: package-private */
        public BinaryTreeNode right() {
            if (this.rightNode == null && this.literal == -1) {
                this.rightNode = new BinaryTreeNode(this.bits + 1);
            }
            return this.rightNode;
        }
    }

    /* access modifiers changed from: private */
    public static BinaryTreeNode buildTree(int[] iArr) {
        int[] codes = getCodes(iArr);
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(0);
        for (int i = 0; i < iArr.length; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                int i3 = i2 - 1;
                int i4 = codes[i3];
                BinaryTreeNode binaryTreeNode2 = binaryTreeNode;
                for (int i5 = i3; i5 >= 0; i5--) {
                    binaryTreeNode2 = ((1 << i5) & i4) == 0 ? binaryTreeNode2.left() : binaryTreeNode2.right();
                }
                binaryTreeNode2.leaf(i);
                codes[i3] = codes[i3] + 1;
            }
        }
        return binaryTreeNode;
    }

    private static int[] getCodes(int[] iArr) {
        int[] iArr2 = new int[65];
        int i = 0;
        for (int i2 : iArr) {
            i = Math.max(i, i2);
            iArr2[i2] = iArr2[i2] + 1;
        }
        int i3 = i + 1;
        int[] copyOf = Arrays.copyOf(iArr2, i3);
        int[] iArr3 = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 <= i; i5++) {
            i4 = (i4 + copyOf[i5]) << 1;
            iArr3[i5] = i4;
        }
        return iArr3;
    }

    private static class DecodingMemory {
        private final int mask;
        private final byte[] memory;
        private int wHead;
        private boolean wrappedAround;

        private DecodingMemory() {
            this(16);
        }

        private DecodingMemory(int i) {
            byte[] bArr = new byte[(1 << i)];
            this.memory = bArr;
            this.mask = bArr.length - 1;
        }

        /* access modifiers changed from: package-private */
        public byte add(byte b) {
            byte[] bArr = this.memory;
            int i = this.wHead;
            bArr[i] = b;
            this.wHead = incCounter(i);
            return b;
        }

        /* access modifiers changed from: package-private */
        public void add(byte[] bArr, int i, int i2) {
            for (int i3 = i; i3 < i + i2; i3++) {
                add(bArr[i3]);
            }
        }

        /* access modifiers changed from: package-private */
        public void recordToBuffer(int i, int i2, byte[] bArr) {
            if (i <= this.memory.length) {
                int i3 = this.wHead;
                int i4 = (i3 - i) & this.mask;
                if (this.wrappedAround || i4 < i3) {
                    int i5 = 0;
                    while (i5 < i2) {
                        bArr[i5] = add(this.memory[i4]);
                        i5++;
                        i4 = incCounter(i4);
                    }
                    return;
                }
                throw new IllegalStateException("Attempt to read beyond memory: dist=" + i);
            }
            throw new IllegalStateException("Illegal distance parameter: " + i);
        }

        private int incCounter(int i) {
            int i2 = (i + 1) & this.mask;
            if (!this.wrappedAround && i2 < i) {
                this.wrappedAround = true;
            }
            return i2;
        }
    }

    /* access modifiers changed from: private */
    public long readBits(int i) throws IOException {
        return readBits(this.reader, i);
    }

    private static long readBits(BitInputStream bitInputStream, int i) throws IOException {
        long readBits = bitInputStream.readBits(i);
        if (readBits != -1) {
            return readBits;
        }
        throw new EOFException("Truncated Deflate64 Stream");
    }
}
