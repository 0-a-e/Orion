package org.apache.commons.compress.compressors.lz77support;

import java.io.IOException;
import java.util.Arrays;

public class LZ77Compressor {
    private static final int HASH_MASK = 32767;
    private static final int HASH_SIZE = 32768;
    private static final int H_SHIFT = 5;
    private static final int NO_MATCH = -1;
    static final int NUMBER_OF_BYTES_IN_HASH = 3;
    private static final Block THE_EOD = new EOD();
    private int blockStart = 0;
    private final Callback callback;
    private int currentPosition;
    private final int[] head;
    private boolean initialized = false;
    private int insertHash = 0;
    private int lookahead = 0;
    private int matchStart = -1;
    private int missedInserts = 0;
    private final Parameters params;
    private final int[] prev;
    private final int wMask;
    private final byte[] window;

    public static abstract class Block {

        public enum BlockType {
            LITERAL,
            BACK_REFERENCE,
            EOD
        }

        public abstract BlockType getType();
    }

    public interface Callback {
        void accept(Block block) throws IOException;
    }

    private int nextHash(int i, byte b) {
        return ((i << 5) ^ (b & 255)) & 32767;
    }

    public static final class LiteralBlock extends Block {
        private final byte[] data;
        private final int length;
        private final int offset;

        public LiteralBlock(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.offset = i;
            this.length = i2;
        }

        public byte[] getData() {
            return this.data;
        }

        public int getOffset() {
            return this.offset;
        }

        public int getLength() {
            return this.length;
        }

        public Block.BlockType getType() {
            return Block.BlockType.LITERAL;
        }

        public String toString() {
            return "LiteralBlock starting at " + this.offset + " with length " + this.length;
        }
    }

    public static final class BackReference extends Block {
        private final int length;
        private final int offset;

        public BackReference(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        public int getOffset() {
            return this.offset;
        }

        public int getLength() {
            return this.length;
        }

        public Block.BlockType getType() {
            return Block.BlockType.BACK_REFERENCE;
        }

        public String toString() {
            return "BackReference with offset " + this.offset + " and length " + this.length;
        }
    }

    public static final class EOD extends Block {
        public Block.BlockType getType() {
            return Block.BlockType.EOD;
        }
    }

    public LZ77Compressor(Parameters parameters, Callback callback2) {
        if (parameters == null) {
            throw new NullPointerException("params must not be null");
        } else if (callback2 != null) {
            this.params = parameters;
            this.callback = callback2;
            int windowSize = parameters.getWindowSize();
            this.window = new byte[(windowSize * 2)];
            this.wMask = windowSize - 1;
            int[] iArr = new int[32768];
            this.head = iArr;
            Arrays.fill(iArr, -1);
            this.prev = new int[windowSize];
        } else {
            throw new NullPointerException("callback must not be null");
        }
    }

    public void compress(byte[] bArr) throws IOException {
        compress(bArr, 0, bArr.length);
    }

    public void compress(byte[] bArr, int i, int i2) throws IOException {
        int windowSize = this.params.getWindowSize();
        while (i2 > windowSize) {
            doCompress(bArr, i, windowSize);
            i += windowSize;
            i2 -= windowSize;
        }
        if (i2 > 0) {
            doCompress(bArr, i, i2);
        }
    }

    public void finish() throws IOException {
        int i = this.blockStart;
        int i2 = this.currentPosition;
        if (i != i2 || this.lookahead > 0) {
            this.currentPosition = i2 + this.lookahead;
            flushLiteralBlock();
        }
        this.callback.accept(THE_EOD);
    }

    public void prefill(byte[] bArr) {
        if (this.currentPosition == 0 && this.lookahead == 0) {
            int min = Math.min(this.params.getWindowSize(), bArr.length);
            System.arraycopy(bArr, bArr.length - min, this.window, 0, min);
            if (min >= 3) {
                initialize();
                int i = min - 2;
                for (int i2 = 0; i2 < i; i2++) {
                    insertString(i2);
                }
                this.missedInserts = 2;
            } else {
                this.missedInserts = min;
            }
            this.currentPosition = min;
            this.blockStart = min;
            return;
        }
        throw new IllegalStateException("The compressor has already started to accept data, can't prefill anymore");
    }

    private void doCompress(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > (this.window.length - this.currentPosition) - this.lookahead) {
            slide();
        }
        System.arraycopy(bArr, i, this.window, this.currentPosition + this.lookahead, i2);
        int i3 = this.lookahead + i2;
        this.lookahead = i3;
        if (!this.initialized && i3 >= this.params.getMinBackReferenceLength()) {
            initialize();
        }
        if (this.initialized) {
            compress();
        }
    }

    private void slide() throws IOException {
        int windowSize = this.params.getWindowSize();
        int i = this.blockStart;
        if (i != this.currentPosition && i < windowSize) {
            flushLiteralBlock();
            this.blockStart = this.currentPosition;
        }
        byte[] bArr = this.window;
        System.arraycopy(bArr, windowSize, bArr, 0, windowSize);
        this.currentPosition -= windowSize;
        this.matchStart -= windowSize;
        this.blockStart -= windowSize;
        int i2 = 0;
        while (true) {
            int i3 = -1;
            if (i2 >= 32768) {
                break;
            }
            int[] iArr = this.head;
            int i4 = iArr[i2];
            if (i4 >= windowSize) {
                i3 = i4 - windowSize;
            }
            iArr[i2] = i3;
            i2++;
        }
        for (int i5 = 0; i5 < windowSize; i5++) {
            int[] iArr2 = this.prev;
            int i6 = iArr2[i5];
            iArr2[i5] = i6 >= windowSize ? i6 - windowSize : -1;
        }
    }

    private void initialize() {
        for (int i = 0; i < 2; i++) {
            this.insertHash = nextHash(this.insertHash, this.window[i]);
        }
        this.initialized = true;
    }

    private void compress() throws IOException {
        int i;
        int minBackReferenceLength = this.params.getMinBackReferenceLength();
        boolean lazyMatching = this.params.getLazyMatching();
        int lazyMatchingThreshold = this.params.getLazyMatchingThreshold();
        while (this.lookahead >= minBackReferenceLength) {
            catchUpMissedInserts();
            int insertString = insertString(this.currentPosition);
            if (insertString == -1 || insertString - this.currentPosition > this.params.getMaxOffset()) {
                i = 0;
            } else {
                i = longestMatch(insertString);
                if (lazyMatching && i <= lazyMatchingThreshold && this.lookahead > minBackReferenceLength) {
                    i = longestMatchForNextPosition(i);
                }
            }
            if (i >= minBackReferenceLength) {
                if (this.blockStart != this.currentPosition) {
                    flushLiteralBlock();
                    this.blockStart = -1;
                }
                flushBackReference(i);
                insertStringsInMatch(i);
                this.lookahead -= i;
                int i2 = this.currentPosition + i;
                this.currentPosition = i2;
                this.blockStart = i2;
            } else {
                this.lookahead--;
                int i3 = this.currentPosition + 1;
                this.currentPosition = i3;
                if (i3 - this.blockStart >= this.params.getMaxLiteralLength()) {
                    flushLiteralBlock();
                    this.blockStart = this.currentPosition;
                }
            }
        }
    }

    private int insertString(int i) {
        int nextHash = nextHash(this.insertHash, this.window[i + 2]);
        this.insertHash = nextHash;
        int[] iArr = this.head;
        int i2 = iArr[nextHash];
        this.prev[this.wMask & i] = i2;
        iArr[nextHash] = i;
        return i2;
    }

    private int longestMatchForNextPosition(int i) {
        int i2 = this.matchStart;
        int i3 = this.insertHash;
        this.lookahead--;
        int i4 = this.currentPosition + 1;
        this.currentPosition = i4;
        int insertString = insertString(i4);
        int i5 = this.prev[this.currentPosition & this.wMask];
        int longestMatch = longestMatch(insertString);
        if (longestMatch > i) {
            return longestMatch;
        }
        this.matchStart = i2;
        this.head[this.insertHash] = i5;
        this.insertHash = i3;
        this.currentPosition--;
        this.lookahead++;
        return i;
    }

    private void insertStringsInMatch(int i) {
        int min = Math.min(i - 1, this.lookahead - 3);
        for (int i2 = 1; i2 <= min; i2++) {
            insertString(this.currentPosition + i2);
        }
        this.missedInserts = (i - min) - 1;
    }

    private void catchUpMissedInserts() {
        while (true) {
            int i = this.missedInserts;
            if (i > 0) {
                int i2 = this.currentPosition;
                this.missedInserts = i - 1;
                insertString(i2 - i);
            } else {
                return;
            }
        }
    }

    private void flushBackReference(int i) throws IOException {
        this.callback.accept(new BackReference(this.currentPosition - this.matchStart, i));
    }

    private void flushLiteralBlock() throws IOException {
        Callback callback2 = this.callback;
        byte[] bArr = this.window;
        int i = this.blockStart;
        callback2.accept(new LiteralBlock(bArr, i, this.currentPosition - i));
    }

    private int longestMatch(int i) {
        int minBackReferenceLength = this.params.getMinBackReferenceLength() - 1;
        int min = Math.min(this.params.getMaxBackReferenceLength(), this.lookahead);
        int max = Math.max(0, this.currentPosition - this.params.getMaxOffset());
        int min2 = Math.min(min, this.params.getNiceBackReferenceLength());
        int maxCandidates = this.params.getMaxCandidates();
        for (int i2 = 0; i2 < maxCandidates && i >= max; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < min; i4++) {
                byte[] bArr = this.window;
                if (bArr[i + i4] != bArr[this.currentPosition + i4]) {
                    break;
                }
                i3++;
            }
            if (i3 > minBackReferenceLength) {
                this.matchStart = i;
                minBackReferenceLength = i3;
                if (i3 >= min2) {
                    break;
                }
            }
            i = this.prev[i & this.wMask];
        }
        return minBackReferenceLength;
    }
}
