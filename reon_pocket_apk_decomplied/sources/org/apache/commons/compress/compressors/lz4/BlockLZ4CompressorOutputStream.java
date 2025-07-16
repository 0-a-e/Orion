package org.apache.commons.compress.compressors.lz4;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.apache.commons.compress.compressors.lz77support.Parameters;
import org.apache.commons.compress.utils.ByteUtils;

public class BlockLZ4CompressorOutputStream extends CompressorOutputStream {
    private static final int MIN_BACK_REFERENCE_LENGTH = 4;
    private static final int MIN_OFFSET_OF_LAST_BACK_REFERENCE = 12;
    private final LZ77Compressor compressor;
    private Deque<byte[]> expandedBlocks;
    private boolean finished;
    private final byte[] oneByte;
    private final OutputStream os;
    private Deque<Pair> pairs;

    public BlockLZ4CompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, createParameterBuilder().build());
    }

    public BlockLZ4CompressorOutputStream(OutputStream outputStream, Parameters parameters) throws IOException {
        this.oneByte = new byte[1];
        this.finished = false;
        this.pairs = new LinkedList();
        this.expandedBlocks = new LinkedList();
        this.os = outputStream;
        this.compressor = new LZ77Compressor(parameters, new LZ77Compressor.Callback() {
            public void accept(LZ77Compressor.Block block) throws IOException {
                int i = AnonymousClass2.$SwitchMap$org$apache$commons$compress$compressors$lz77support$LZ77Compressor$Block$BlockType[block.getType().ordinal()];
                if (i == 1) {
                    BlockLZ4CompressorOutputStream.this.addLiteralBlock((LZ77Compressor.LiteralBlock) block);
                } else if (i == 2) {
                    BlockLZ4CompressorOutputStream.this.addBackReference((LZ77Compressor.BackReference) block);
                } else if (i == 3) {
                    BlockLZ4CompressorOutputStream.this.writeFinalLiteralBlock();
                }
            }
        });
    }

    /* renamed from: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream$2  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.lz4.BlockLZ4CompressorOutputStream.AnonymousClass2.<clinit>():void");
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

    public void prefill(byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i2 + i);
            this.compressor.prefill(copyOfRange);
            recordLiteral(copyOfRange);
        }
    }

    /* access modifiers changed from: private */
    public void addLiteralBlock(LZ77Compressor.LiteralBlock literalBlock) throws IOException {
        recordLiteral(writeBlocksAndReturnUnfinishedPair(literalBlock.getLength()).addLiteral(literalBlock));
        clearUnusedBlocksAndPairs();
    }

    /* access modifiers changed from: private */
    public void addBackReference(LZ77Compressor.BackReference backReference) throws IOException {
        writeBlocksAndReturnUnfinishedPair(backReference.getLength()).setBackReference(backReference);
        recordBackReference(backReference);
        clearUnusedBlocksAndPairs();
    }

    private Pair writeBlocksAndReturnUnfinishedPair(int i) throws IOException {
        writeWritablePairs(i);
        Pair peekLast = this.pairs.peekLast();
        if (peekLast != null && !peekLast.hasBackReference()) {
            return peekLast;
        }
        Pair pair = new Pair();
        this.pairs.addLast(pair);
        return pair;
    }

    private void recordLiteral(byte[] bArr) {
        this.expandedBlocks.addFirst(bArr);
    }

    private void clearUnusedBlocksAndPairs() {
        clearUnusedBlocks();
        clearUnusedPairs();
    }

    private void clearUnusedBlocks() {
        int i = 0;
        int i2 = 0;
        for (byte[] length : this.expandedBlocks) {
            i++;
            i2 += length.length;
            if (i2 >= 65536) {
                break;
            }
        }
        int size = this.expandedBlocks.size();
        while (i < size) {
            this.expandedBlocks.removeLast();
            i++;
        }
    }

    private void recordBackReference(LZ77Compressor.BackReference backReference) {
        this.expandedBlocks.addFirst(expand(backReference.getOffset(), backReference.getLength()));
    }

    private byte[] expand(int i, int i2) {
        byte[] bArr = new byte[i2];
        if (i == 1) {
            byte[] peekFirst = this.expandedBlocks.peekFirst();
            byte b = peekFirst[peekFirst.length - 1];
            if (b != 0) {
                Arrays.fill(bArr, b);
            }
        } else {
            expandFromList(bArr, i, i2);
        }
        return bArr;
    }

    private void expandFromList(byte[] bArr, int i, int i2) {
        byte[] bArr2;
        int i3;
        int i4;
        int i5 = i;
        int i6 = 0;
        while (i2 > 0) {
            if (i5 > 0) {
                Iterator<byte[]> it = this.expandedBlocks.iterator();
                int i7 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        bArr2 = null;
                        break;
                    }
                    bArr2 = it.next();
                    if (bArr2.length + i7 >= i5) {
                        break;
                    }
                    i7 += bArr2.length;
                }
                if (bArr2 != null) {
                    i3 = (i7 + bArr2.length) - i5;
                    i4 = Math.min(i2, bArr2.length - i3);
                } else {
                    throw new IllegalStateException("Failed to find a block containing offset " + i);
                }
            } else {
                i3 = -i5;
                i4 = Math.min(i2, i6 + i5);
                bArr2 = bArr;
            }
            System.arraycopy(bArr2, i3, bArr, i6, i4);
            i5 -= i4;
            i2 -= i4;
            i6 += i4;
        }
    }

    private void clearUnusedPairs() {
        Iterator<Pair> descendingIterator = this.pairs.descendingIterator();
        int i = 0;
        int i2 = 0;
        while (descendingIterator.hasNext()) {
            i++;
            i2 += descendingIterator.next().length();
            if (i2 >= 65536) {
                break;
            }
        }
        int size = this.pairs.size();
        while (i < size && this.pairs.peekFirst().hasBeenWritten()) {
            this.pairs.removeFirst();
            i++;
        }
    }

    /* access modifiers changed from: private */
    public void writeFinalLiteralBlock() throws IOException {
        rewriteLastPairs();
        for (Pair next : this.pairs) {
            if (!next.hasBeenWritten()) {
                next.writeTo(this.os);
            }
        }
        this.pairs.clear();
    }

    private void writeWritablePairs(int i) throws IOException {
        Iterator<Pair> descendingIterator = this.pairs.descendingIterator();
        while (descendingIterator.hasNext()) {
            Pair next = descendingIterator.next();
            if (next.hasBeenWritten()) {
                break;
            }
            i += next.length();
        }
        for (Pair next2 : this.pairs) {
            if (!next2.hasBeenWritten()) {
                i -= next2.length();
                if (next2.canBeWritten(i)) {
                    next2.writeTo(this.os);
                } else {
                    return;
                }
            }
        }
    }

    private void rewriteLastPairs() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Iterator<Pair> descendingIterator = this.pairs.descendingIterator();
        int i = 0;
        int i2 = 0;
        while (descendingIterator.hasNext()) {
            Pair next = descendingIterator.next();
            if (!next.hasBeenWritten()) {
                int length = next.length();
                linkedList2.addFirst(Integer.valueOf(length));
                linkedList.addFirst(next);
                i2 += length;
                if (i2 >= 12) {
                    break;
                }
            } else {
                break;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.pairs.remove((Pair) it.next());
        }
        int size = linkedList.size();
        int i3 = 0;
        for (int i4 = 1; i4 < size; i4++) {
            i3 += ((Integer) linkedList2.get(i4)).intValue();
        }
        Pair pair = new Pair();
        if (i3 > 0) {
            pair.prependLiteral(expand(i3, i3));
        }
        Pair pair2 = (Pair) linkedList.get(0);
        int i5 = 12 - i3;
        if (pair2.hasBackReference()) {
            i = pair2.backReferenceLength();
        }
        if (!pair2.hasBackReference() || i < 16 - i3) {
            if (pair2.hasBackReference()) {
                pair.prependLiteral(expand(i3 + i, i));
            }
            pair2.prependTo(pair);
        } else {
            pair.prependLiteral(expand(i3 + i5, i5));
            this.pairs.add(pair2.splitWithNewBackReferenceLengthOf(i - i5));
        }
        this.pairs.add(pair);
    }

    public static Parameters.Builder createParameterBuilder() {
        return Parameters.builder(65536).withMinBackReferenceLength(4).withMaxBackReferenceLength(65535).withMaxOffset(65535).withMaxLiteralLength(65535);
    }

    static final class Pair {
        private int brLength;
        private int brOffset;
        private final Deque<byte[]> literals = new LinkedList();
        private boolean written;

        private static int lengths(int i, int i2) {
            int i3 = 15;
            if (i >= 15) {
                i = 15;
            }
            if (i2 < 4) {
                i3 = 0;
            } else if (i2 < 19) {
                i3 = i2 - 4;
            }
            return (i << 4) | i3;
        }

        Pair() {
        }

        /* access modifiers changed from: private */
        public void prependLiteral(byte[] bArr) {
            this.literals.addFirst(bArr);
        }

        /* access modifiers changed from: package-private */
        public byte[] addLiteral(LZ77Compressor.LiteralBlock literalBlock) {
            byte[] copyOfRange = Arrays.copyOfRange(literalBlock.getData(), literalBlock.getOffset(), literalBlock.getOffset() + literalBlock.getLength());
            this.literals.add(copyOfRange);
            return copyOfRange;
        }

        /* access modifiers changed from: package-private */
        public void setBackReference(LZ77Compressor.BackReference backReference) {
            if (!hasBackReference()) {
                this.brOffset = backReference.getOffset();
                this.brLength = backReference.getLength();
                return;
            }
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public boolean hasBackReference() {
            return this.brOffset > 0;
        }

        /* access modifiers changed from: package-private */
        public boolean canBeWritten(int i) {
            return hasBackReference() && i >= 16;
        }

        /* access modifiers changed from: package-private */
        public int length() {
            return literalLength() + this.brLength;
        }

        /* access modifiers changed from: private */
        public boolean hasBeenWritten() {
            return this.written;
        }

        /* access modifiers changed from: package-private */
        public void writeTo(OutputStream outputStream) throws IOException {
            int literalLength = literalLength();
            outputStream.write(lengths(literalLength, this.brLength));
            if (literalLength >= 15) {
                writeLength(literalLength - 15, outputStream);
            }
            for (byte[] write : this.literals) {
                outputStream.write(write);
            }
            if (hasBackReference()) {
                ByteUtils.toLittleEndian(outputStream, (long) this.brOffset, 2);
                int i = this.brLength;
                if (i - 4 >= 15) {
                    writeLength(i - 19, outputStream);
                }
            }
            this.written = true;
        }

        private int literalLength() {
            int i = 0;
            for (byte[] length : this.literals) {
                i += length.length;
            }
            return i;
        }

        private static void writeLength(int i, OutputStream outputStream) throws IOException {
            while (i >= 255) {
                outputStream.write(255);
                i -= 255;
            }
            outputStream.write(i);
        }

        /* access modifiers changed from: private */
        public int backReferenceLength() {
            return this.brLength;
        }

        /* access modifiers changed from: private */
        public void prependTo(Pair pair) {
            Iterator<byte[]> descendingIterator = this.literals.descendingIterator();
            while (descendingIterator.hasNext()) {
                pair.prependLiteral(descendingIterator.next());
            }
        }

        /* access modifiers changed from: private */
        public Pair splitWithNewBackReferenceLengthOf(int i) {
            Pair pair = new Pair();
            pair.literals.addAll(this.literals);
            pair.brOffset = this.brOffset;
            pair.brLength = i;
            return pair;
        }
    }
}
