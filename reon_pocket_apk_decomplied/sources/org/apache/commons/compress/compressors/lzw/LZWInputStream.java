package org.apache.commons.compress.compressors.lzw;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

public abstract class LZWInputStream extends CompressorInputStream implements InputStreamStatistics {
    protected static final int DEFAULT_CODE_SIZE = 9;
    protected static final int UNUSED_PREFIX = -1;
    private byte[] characters;
    private int clearCode = -1;
    private int codeSize = 9;
    protected final BitInputStream in;
    private final byte[] oneByte = new byte[1];
    private byte[] outputStack;
    private int outputStackLocation;
    private int[] prefixes;
    private int previousCode = -1;
    private byte previousCodeFirstChar;
    private int tableSize;

    /* access modifiers changed from: protected */
    public abstract int addEntry(int i, byte b) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int decompressNextSymbol() throws IOException;

    protected LZWInputStream(InputStream inputStream, ByteOrder byteOrder) {
        this.in = new BitInputStream(inputStream, byteOrder);
    }

    public void close() throws IOException {
        this.in.close();
    }

    public int read() throws IOException {
        int read = read(this.oneByte);
        if (read < 0) {
            return read;
        }
        return this.oneByte[0] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int readFromStack = readFromStack(bArr, i, i2);
        while (true) {
            int i3 = i2 - readFromStack;
            if (i3 > 0) {
                int decompressNextSymbol = decompressNextSymbol();
                if (decompressNextSymbol >= 0) {
                    readFromStack += readFromStack(bArr, i + readFromStack, i3);
                } else if (readFromStack <= 0) {
                    return decompressNextSymbol;
                } else {
                    count(readFromStack);
                    return readFromStack;
                }
            } else {
                count(readFromStack);
                return readFromStack;
            }
        }
    }

    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    /* access modifiers changed from: protected */
    public void setClearCode(int i) {
        this.clearCode = 1 << (i - 1);
    }

    /* access modifiers changed from: protected */
    public void initializeTables(int i, int i2) throws MemoryLimitException {
        if (i > 0) {
            if (i2 > -1) {
                long j = (((long) (1 << i)) * 6) >> 10;
                if (j > ((long) i2)) {
                    throw new MemoryLimitException(j, i2);
                }
            }
            initializeTables(i);
            return;
        }
        throw new IllegalArgumentException("maxCodeSize is " + i + ", must be bigger than 0");
    }

    /* access modifiers changed from: protected */
    public void initializeTables(int i) {
        if (i > 0) {
            int i2 = 1 << i;
            this.prefixes = new int[i2];
            this.characters = new byte[i2];
            this.outputStack = new byte[i2];
            this.outputStackLocation = i2;
            for (int i3 = 0; i3 < 256; i3++) {
                this.prefixes[i3] = -1;
                this.characters[i3] = (byte) i3;
            }
            return;
        }
        throw new IllegalArgumentException("maxCodeSize is " + i + ", must be bigger than 0");
    }

    /* access modifiers changed from: protected */
    public int readNextCode() throws IOException {
        int i = this.codeSize;
        if (i <= 31) {
            return (int) this.in.readBits(i);
        }
        throw new IllegalArgumentException("Code size must not be bigger than 31");
    }

    /* access modifiers changed from: protected */
    public int addEntry(int i, byte b, int i2) {
        int i3 = this.tableSize;
        if (i3 >= i2) {
            return -1;
        }
        this.prefixes[i3] = i;
        this.characters[i3] = b;
        this.tableSize = i3 + 1;
        return i3;
    }

    /* access modifiers changed from: protected */
    public int addRepeatOfPreviousCode() throws IOException {
        int i = this.previousCode;
        if (i != -1) {
            return addEntry(i, this.previousCodeFirstChar);
        }
        throw new IOException("The first code can't be a reference to its preceding code");
    }

    /* access modifiers changed from: protected */
    public int expandCodeToOutputStack(int i, boolean z) throws IOException {
        int i2 = i;
        while (i2 >= 0) {
            byte[] bArr = this.outputStack;
            int i3 = this.outputStackLocation - 1;
            this.outputStackLocation = i3;
            bArr[i3] = this.characters[i2];
            i2 = this.prefixes[i2];
        }
        int i4 = this.previousCode;
        if (i4 != -1 && !z) {
            addEntry(i4, this.outputStack[this.outputStackLocation]);
        }
        this.previousCode = i;
        byte[] bArr2 = this.outputStack;
        int i5 = this.outputStackLocation;
        this.previousCodeFirstChar = bArr2[i5];
        return i5;
    }

    private int readFromStack(byte[] bArr, int i, int i2) {
        int length = this.outputStack.length - this.outputStackLocation;
        if (length <= 0) {
            return 0;
        }
        int min = Math.min(length, i2);
        System.arraycopy(this.outputStack, this.outputStackLocation, bArr, i, min);
        this.outputStackLocation += min;
        return min;
    }

    /* access modifiers changed from: protected */
    public int getCodeSize() {
        return this.codeSize;
    }

    /* access modifiers changed from: protected */
    public void resetCodeSize() {
        setCodeSize(9);
    }

    /* access modifiers changed from: protected */
    public void setCodeSize(int i) {
        this.codeSize = i;
    }

    /* access modifiers changed from: protected */
    public void incrementCodeSize() {
        this.codeSize++;
    }

    /* access modifiers changed from: protected */
    public void resetPreviousCode() {
        this.previousCode = -1;
    }

    /* access modifiers changed from: protected */
    public int getPrefix(int i) {
        return this.prefixes[i];
    }

    /* access modifiers changed from: protected */
    public void setPrefix(int i, int i2) {
        this.prefixes[i] = i2;
    }

    /* access modifiers changed from: protected */
    public int getPrefixesLength() {
        return this.prefixes.length;
    }

    /* access modifiers changed from: protected */
    public int getClearCode() {
        return this.clearCode;
    }

    /* access modifiers changed from: protected */
    public int getTableSize() {
        return this.tableSize;
    }

    /* access modifiers changed from: protected */
    public void setTableSize(int i) {
        this.tableSize = i;
    }
}
