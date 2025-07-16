package org.apache.commons.compress.compressors.bzip2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.CloseShieldFilterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class BZip2CompressorInputStream extends CompressorInputStream implements BZip2Constants, InputStreamStatistics {
    private static final int EOF = 0;
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private BitInputStream bin;
    private boolean blockRandomised;
    private int blockSize100k;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    private final CRC crc;
    private int currentState;
    private Data data;
    private final boolean decompressConcatenated;
    private int last;
    private int nInUse;
    private int origPtr;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private int su_ch2;
    private int su_chPrev;
    private int su_count;
    private int su_i2;
    private int su_j2;
    private int su_rNToGo;
    private int su_rTPos;
    private int su_tPos;
    private char su_z;

    public BZip2CompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    public BZip2CompressorInputStream(InputStream inputStream, boolean z) throws IOException {
        this.crc = new CRC();
        this.currentState = 1;
        this.bin = new BitInputStream(inputStream == System.in ? new CloseShieldFilterInputStream(inputStream) : inputStream, ByteOrder.BIG_ENDIAN);
        this.decompressConcatenated = z;
        init(true);
        initBlock();
    }

    public int read() throws IOException {
        if (this.bin != null) {
            int read0 = read0();
            count(read0 < 0 ? -1 : 1);
            return read0;
        }
        throw new IOException("Stream closed");
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("offs(" + i + ") < 0.");
        } else if (i2 >= 0) {
            int i3 = i + i2;
            if (i3 > bArr.length) {
                throw new IndexOutOfBoundsException("offs(" + i + ") + len(" + i2 + ") > dest.length(" + bArr.length + ").");
            } else if (this.bin == null) {
                throw new IOException("Stream closed");
            } else if (i2 == 0) {
                return 0;
            } else {
                int i4 = i;
                while (i4 < i3) {
                    int read0 = read0();
                    if (read0 < 0) {
                        break;
                    }
                    bArr[i4] = (byte) read0;
                    count(1);
                    i4++;
                }
                if (i4 == i) {
                    return -1;
                }
                return i4 - i;
            }
        } else {
            throw new IndexOutOfBoundsException("len(" + i2 + ") < 0.");
        }
    }

    public long getCompressedCount() {
        return this.bin.getBytesRead();
    }

    private void makeMaps() {
        boolean[] zArr = this.data.inUse;
        byte[] bArr = this.data.seqToUnseq;
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (zArr[i2]) {
                bArr[i] = (byte) i2;
                i++;
            }
        }
        this.nInUse = i;
    }

    private int read0() throws IOException {
        switch (this.currentState) {
            case 0:
                return -1;
            case 1:
                return setupBlock();
            case 2:
                throw new IllegalStateException();
            case 3:
                return setupRandPartB();
            case 4:
                return setupRandPartC();
            case 5:
                throw new IllegalStateException();
            case 6:
                return setupNoRandPartB();
            case 7:
                return setupNoRandPartC();
            default:
                throw new IllegalStateException();
        }
    }

    private int readNextByte(BitInputStream bitInputStream) throws IOException {
        return (int) bitInputStream.readBits(8);
    }

    private boolean init(boolean z) throws IOException {
        BitInputStream bitInputStream = this.bin;
        if (bitInputStream != null) {
            if (!z) {
                bitInputStream.clearBitCache();
            }
            int readNextByte = readNextByte(this.bin);
            if (readNextByte == -1 && !z) {
                return false;
            }
            int readNextByte2 = readNextByte(this.bin);
            int readNextByte3 = readNextByte(this.bin);
            if (readNextByte == 66 && readNextByte2 == 90 && readNextByte3 == 104) {
                int readNextByte4 = readNextByte(this.bin);
                if (readNextByte4 < 49 || readNextByte4 > 57) {
                    throw new IOException("BZip2 block size is invalid");
                }
                this.blockSize100k = readNextByte4 - 48;
                this.computedCombinedCRC = 0;
                return true;
            }
            throw new IOException(z ? "Stream is not in the BZip2 format" : "Garbage after a valid BZip2 stream");
        }
        throw new IOException("No InputStream");
    }

    private void initBlock() throws IOException {
        BitInputStream bitInputStream = this.bin;
        do {
            char bsGetUByte = bsGetUByte(bitInputStream);
            char bsGetUByte2 = bsGetUByte(bitInputStream);
            char bsGetUByte3 = bsGetUByte(bitInputStream);
            char bsGetUByte4 = bsGetUByte(bitInputStream);
            char bsGetUByte5 = bsGetUByte(bitInputStream);
            char bsGetUByte6 = bsGetUByte(bitInputStream);
            if (bsGetUByte != 23 || bsGetUByte2 != 'r' || bsGetUByte3 != 'E' || bsGetUByte4 != '8' || bsGetUByte5 != 'P' || bsGetUByte6 != 144) {
                boolean z = false;
                if (bsGetUByte == '1' && bsGetUByte2 == 'A' && bsGetUByte3 == 'Y' && bsGetUByte4 == '&' && bsGetUByte5 == 'S' && bsGetUByte6 == 'Y') {
                    this.storedBlockCRC = bsGetInt(bitInputStream);
                    if (bsR(bitInputStream, 1) == 1) {
                        z = true;
                    }
                    this.blockRandomised = z;
                    if (this.data == null) {
                        this.data = new Data(this.blockSize100k);
                    }
                    getAndMoveToFrontDecode();
                    this.crc.initialiseCRC();
                    this.currentState = 1;
                    return;
                }
                this.currentState = 0;
                throw new IOException("Bad block header");
            }
        } while (!complete());
    }

    private void endBlock() throws IOException {
        int finalCRC = this.crc.getFinalCRC();
        this.computedBlockCRC = finalCRC;
        int i = this.storedBlockCRC;
        if (i == finalCRC) {
            int i2 = this.computedCombinedCRC;
            this.computedCombinedCRC = finalCRC ^ ((i2 >>> 31) | (i2 << 1));
            return;
        }
        int i3 = this.storedCombinedCRC;
        this.computedCombinedCRC = ((i3 >>> 31) | (i3 << 1)) ^ i;
        throw new IOException("BZip2 CRC error");
    }

    private boolean complete() throws IOException {
        int bsGetInt = bsGetInt(this.bin);
        this.storedCombinedCRC = bsGetInt;
        this.currentState = 0;
        this.data = null;
        if (bsGetInt != this.computedCombinedCRC) {
            throw new IOException("BZip2 CRC error");
        } else if (!this.decompressConcatenated || !init(false)) {
            return true;
        } else {
            return false;
        }
    }

    public void close() throws IOException {
        BitInputStream bitInputStream = this.bin;
        if (bitInputStream != null) {
            try {
                bitInputStream.close();
            } finally {
                this.data = null;
                this.bin = null;
            }
        }
    }

    private static int bsR(BitInputStream bitInputStream, int i) throws IOException {
        long readBits = bitInputStream.readBits(i);
        if (readBits >= 0) {
            return (int) readBits;
        }
        throw new IOException("Unexpected end of stream");
    }

    private static boolean bsGetBit(BitInputStream bitInputStream) throws IOException {
        return bsR(bitInputStream, 1) != 0;
    }

    private static char bsGetUByte(BitInputStream bitInputStream) throws IOException {
        return (char) bsR(bitInputStream, 8);
    }

    private static int bsGetInt(BitInputStream bitInputStream) throws IOException {
        return bsR(bitInputStream, 32);
    }

    private static void checkBounds(int i, int i2, String str) throws IOException {
        if (i < 0) {
            throw new IOException("Corrupted input, " + str + " value negative");
        } else if (i >= i2) {
            throw new IOException("Corrupted input, " + str + " value too big");
        }
    }

    private static void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i, int i2, int i3) throws IOException {
        int i4 = 0;
        int i5 = 0;
        for (int i6 = i; i6 <= i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                if (cArr[i7] == i6) {
                    iArr3[i5] = i7;
                    i5++;
                }
            }
        }
        int i8 = 23;
        while (true) {
            i8--;
            if (i8 <= 0) {
                break;
            }
            iArr2[i8] = 0;
            iArr[i8] = 0;
        }
        for (int i9 = 0; i9 < i3; i9++) {
            char c = cArr[i9];
            checkBounds(c, BZip2Constants.MAX_ALPHA_SIZE, "length");
            int i10 = c + 1;
            iArr2[i10] = iArr2[i10] + 1;
        }
        int i11 = iArr2[0];
        for (int i12 = 1; i12 < 23; i12++) {
            i11 += iArr2[i12];
            iArr2[i12] = i11;
        }
        int i13 = iArr2[i];
        int i14 = i;
        while (i14 <= i2) {
            int i15 = i14 + 1;
            int i16 = iArr2[i15];
            int i17 = i4 + (i16 - i13);
            iArr[i14] = i17 - 1;
            i4 = i17 << 1;
            i14 = i15;
            i13 = i16;
        }
        for (int i18 = i + 1; i18 <= i2; i18++) {
            iArr2[i18] = ((iArr[i18 - 1] + 1) << 1) - iArr2[i18];
        }
    }

    private void recvDecodingTables() throws IOException {
        BitInputStream bitInputStream = this.bin;
        Data data2 = this.data;
        boolean[] zArr = data2.inUse;
        byte[] bArr = data2.recvDecodingTables_pos;
        byte[] bArr2 = data2.selector;
        byte[] bArr3 = data2.selectorMtf;
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            if (bsGetBit(bitInputStream)) {
                i |= 1 << i2;
            }
        }
        Arrays.fill(zArr, false);
        for (int i3 = 0; i3 < 16; i3++) {
            if (((1 << i3) & i) != 0) {
                int i4 = i3 << 4;
                for (int i5 = 0; i5 < 16; i5++) {
                    if (bsGetBit(bitInputStream)) {
                        zArr[i4 + i5] = true;
                    }
                }
            }
        }
        makeMaps();
        int i6 = this.nInUse + 2;
        int bsR = bsR(bitInputStream, 3);
        int bsR2 = bsR(bitInputStream, 15);
        checkBounds(i6, 259, "alphaSize");
        checkBounds(bsR, 7, "nGroups");
        checkBounds(bsR2, 18003, "nSelectors");
        for (int i7 = 0; i7 < bsR2; i7++) {
            int i8 = 0;
            while (bsGetBit(bitInputStream)) {
                i8++;
            }
            bArr3[i7] = (byte) i8;
        }
        int i9 = bsR;
        while (true) {
            i9--;
            if (i9 < 0) {
                break;
            }
            bArr[i9] = (byte) i9;
        }
        for (int i10 = 0; i10 < bsR2; i10++) {
            int i11 = bArr3[i10] & 255;
            checkBounds(i11, 6, "selectorMtf");
            byte b = bArr[i11];
            while (i11 > 0) {
                bArr[i11] = bArr[i11 - 1];
                i11--;
            }
            bArr[0] = b;
            bArr2[i10] = b;
        }
        char[][] cArr = data2.temp_charArray2d;
        for (int i12 = 0; i12 < bsR; i12++) {
            int bsR3 = bsR(bitInputStream, 5);
            char[] cArr2 = cArr[i12];
            for (int i13 = 0; i13 < i6; i13++) {
                while (bsGetBit(bitInputStream)) {
                    bsR3 += bsGetBit(bitInputStream) ? -1 : 1;
                }
                cArr2[i13] = (char) bsR3;
            }
        }
        createHuffmanDecodingTables(i6, bsR);
    }

    private void createHuffmanDecodingTables(int i, int i2) throws IOException {
        Data data2 = this.data;
        char[][] cArr = data2.temp_charArray2d;
        int[] iArr = data2.minLens;
        int[][] iArr2 = data2.limit;
        int[][] iArr3 = data2.base;
        int[][] iArr4 = data2.perm;
        int i3 = i2;
        for (int i4 = 0; i4 < i3; i4++) {
            char[] cArr2 = cArr[i4];
            int i5 = 32;
            int i6 = i;
            char c = 0;
            while (true) {
                i6--;
                if (i6 < 0) {
                    break;
                }
                char c2 = cArr2[i6];
                if (c2 > c) {
                    c = c2;
                }
                if (c2 < i5) {
                    i5 = c2;
                }
            }
            hbCreateDecodeTables(iArr2[i4], iArr3[i4], iArr4[i4], cArr[i4], i5, c, i);
            iArr[i4] = i5;
        }
    }

    private void getAndMoveToFrontDecode() throws IOException {
        byte[] bArr;
        String str;
        char c;
        int i;
        BZip2CompressorInputStream bZip2CompressorInputStream = this;
        BitInputStream bitInputStream = bZip2CompressorInputStream.bin;
        bZip2CompressorInputStream.origPtr = bsR(bitInputStream, 24);
        recvDecodingTables();
        Data data2 = bZip2CompressorInputStream.data;
        byte[] bArr2 = data2.ll8;
        int[] iArr = data2.unzftab;
        byte[] bArr3 = data2.selector;
        byte[] bArr4 = data2.seqToUnseq;
        char[] cArr = data2.getAndMoveToFrontDecode_yy;
        int[] iArr2 = data2.minLens;
        int[][] iArr3 = data2.limit;
        int[][] iArr4 = data2.base;
        int[][] iArr5 = data2.perm;
        int i2 = bZip2CompressorInputStream.blockSize100k * 100000;
        int i3 = 256;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            cArr[i3] = (char) i3;
            iArr[i3] = 0;
        }
        int i4 = bZip2CompressorInputStream.nInUse + 1;
        int andMoveToFrontDecode0 = getAndMoveToFrontDecode0();
        byte b = bArr3[0] & 255;
        checkBounds(b, 6, "zt");
        int[] iArr6 = iArr4[b];
        int[] iArr7 = iArr3[b];
        int[] iArr8 = iArr5[b];
        int i5 = iArr2[b];
        int i6 = andMoveToFrontDecode0;
        int i7 = 49;
        int i8 = -1;
        int i9 = 0;
        while (i6 != i4) {
            int i10 = i4;
            String str2 = "groupNo";
            String str3 = "zvec";
            String str4 = " exceeds ";
            BitInputStream bitInputStream2 = bitInputStream;
            String str5 = "zn";
            if (i6 == 0 || i6 == 1) {
                int[] iArr9 = iArr2;
                String str6 = str3;
                String str7 = str4;
                String str8 = str5;
                int i11 = i6;
                int i12 = i2;
                BitInputStream bitInputStream3 = bitInputStream2;
                int i13 = i12;
                i6 = i11;
                int i14 = -1;
                int i15 = i7;
                int i16 = i9;
                int i17 = i5;
                int[] iArr10 = iArr8;
                int[] iArr11 = iArr7;
                int[] iArr12 = iArr6;
                int i18 = 1;
                while (true) {
                    if (i6 != 0) {
                        bArr = bArr2;
                        if (i6 != 1) {
                            break;
                        }
                        i14 += i18 << 1;
                    } else {
                        i14 += i18;
                        bArr = bArr2;
                    }
                    if (i15 == 0) {
                        int i19 = i16 + 1;
                        checkBounds(i19, BZip2Constants.MAX_SELECTORS, str2);
                        byte b2 = bArr3[i19] & 255;
                        str = str2;
                        checkBounds(b2, 6, "zt");
                        iArr12 = iArr4[b2];
                        iArr11 = iArr3[b2];
                        iArr10 = iArr5[b2];
                        i17 = iArr9[b2];
                        i16 = i19;
                        i15 = 49;
                    } else {
                        str = str2;
                        i15--;
                    }
                    int i20 = i17;
                    checkBounds(i20, BZip2Constants.MAX_ALPHA_SIZE, str8);
                    int bsR = bsR(bitInputStream3, i20);
                    int i21 = i20;
                    while (bsR > iArr11[i21]) {
                        int i22 = i21 + 1;
                        checkBounds(i22, BZip2Constants.MAX_ALPHA_SIZE, str8);
                        bsR = (bsR << 1) | bsR(bitInputStream3, 1);
                        i21 = i22;
                        iArr5 = iArr5;
                    }
                    int i23 = bsR - iArr12[i21];
                    checkBounds(i23, BZip2Constants.MAX_ALPHA_SIZE, str6);
                    i18 <<= 1;
                    i6 = iArr10[i23];
                    i17 = i20;
                    bArr2 = bArr;
                    str2 = str;
                    iArr5 = iArr5;
                }
                int[][] iArr13 = iArr5;
                char c2 = cArr[0];
                checkBounds(c2, 256, "yy");
                byte b3 = bArr4[c2];
                byte b4 = b3 & 255;
                iArr[b4] = iArr[b4] + i14 + 1;
                int i24 = i8 + 1;
                int i25 = i24 + i14;
                byte[] bArr5 = bArr;
                Arrays.fill(bArr5, i24, i25 + 1, b3);
                int i26 = i13;
                if (i25 < i26) {
                    bArr2 = bArr5;
                    i8 = i25;
                    bitInputStream = bitInputStream3;
                    iArr6 = iArr12;
                    iArr7 = iArr11;
                    iArr8 = iArr10;
                    i5 = i17;
                    i9 = i16;
                    i4 = i10;
                    i7 = i15;
                    iArr2 = iArr9;
                    iArr5 = iArr13;
                    i2 = i26;
                } else {
                    throw new IOException("Block overrun while expanding RLE in MTF, " + i25 + str7 + i26);
                }
            } else {
                i8++;
                if (i8 < i2) {
                    int i27 = i2;
                    checkBounds(i6, 257, "nextSym");
                    int i28 = i6 - 1;
                    char c3 = cArr[i28];
                    int[] iArr14 = iArr2;
                    checkBounds(c3, 256, "yy");
                    byte b5 = bArr4[c3];
                    byte b6 = b5 & 255;
                    iArr[b6] = iArr[b6] + 1;
                    bArr2[i8] = b5;
                    if (i6 <= 16) {
                        while (i28 > 0) {
                            int i29 = i28 - 1;
                            cArr[i28] = cArr[i29];
                            i28 = i29;
                        }
                        c = 0;
                    } else {
                        c = 0;
                        System.arraycopy(cArr, 0, cArr, 1, i28);
                    }
                    cArr[c] = c3;
                    if (i7 == 0) {
                        int i30 = i9 + 1;
                        checkBounds(i30, BZip2Constants.MAX_SELECTORS, str2);
                        byte b7 = bArr3[i30] & 255;
                        checkBounds(b7, 6, "zt");
                        int[] iArr15 = iArr4[b7];
                        int[] iArr16 = iArr3[b7];
                        int[] iArr17 = iArr5[b7];
                        i = iArr14[b7];
                        i9 = i30;
                        iArr6 = iArr15;
                        iArr7 = iArr16;
                        iArr8 = iArr17;
                        i7 = 49;
                    } else {
                        i7--;
                        i = i5;
                    }
                    String str9 = str5;
                    checkBounds(i, BZip2Constants.MAX_ALPHA_SIZE, str9);
                    BitInputStream bitInputStream4 = bitInputStream2;
                    int bsR2 = bsR(bitInputStream4, i);
                    int i31 = i;
                    while (bsR2 > iArr7[i31]) {
                        i31++;
                        checkBounds(i31, BZip2Constants.MAX_ALPHA_SIZE, str9);
                        bsR2 = (bsR2 << 1) | bsR(bitInputStream4, 1);
                    }
                    int i32 = bsR2 - iArr6[i31];
                    checkBounds(i32, BZip2Constants.MAX_ALPHA_SIZE, str3);
                    i6 = iArr8[i32];
                    i5 = i;
                    bitInputStream = bitInputStream4;
                    i4 = i10;
                    i2 = i27;
                    iArr2 = iArr14;
                } else {
                    throw new IOException("Block overrun in MTF, " + i8 + str4 + i2);
                }
            }
            bZip2CompressorInputStream = this;
        }
        bZip2CompressorInputStream.last = i8;
    }

    private int getAndMoveToFrontDecode0() throws IOException {
        Data data2 = this.data;
        byte b = data2.selector[0] & 255;
        checkBounds(b, 6, "zt");
        int[] iArr = data2.limit[b];
        int i = data2.minLens[b];
        checkBounds(i, BZip2Constants.MAX_ALPHA_SIZE, "zn");
        int bsR = bsR(this.bin, i);
        while (bsR > iArr[i]) {
            i++;
            checkBounds(i, BZip2Constants.MAX_ALPHA_SIZE, "zn");
            bsR = (bsR << 1) | bsR(this.bin, 1);
        }
        int i2 = bsR - data2.base[b][i];
        checkBounds(i2, BZip2Constants.MAX_ALPHA_SIZE, "zvec");
        return data2.perm[b][i2];
    }

    private int setupBlock() throws IOException {
        Data data2;
        if (this.currentState == 0 || (data2 = this.data) == null) {
            return -1;
        }
        int[] iArr = data2.cftab;
        int i = this.last + 1;
        int[] initTT = this.data.initTT(i);
        byte[] bArr = this.data.ll8;
        iArr[0] = 0;
        System.arraycopy(this.data.unzftab, 0, iArr, 1, 256);
        int i2 = iArr[0];
        for (int i3 = 1; i3 <= 256; i3++) {
            i2 += iArr[i3];
            iArr[i3] = i2;
        }
        int i4 = this.last;
        for (int i5 = 0; i5 <= i4; i5++) {
            byte b = bArr[i5] & 255;
            int i6 = iArr[b];
            iArr[b] = i6 + 1;
            checkBounds(i6, i, "tt index");
            initTT[i6] = i5;
        }
        int i7 = this.origPtr;
        if (i7 < 0 || i7 >= initTT.length) {
            throw new IOException("Stream corrupted");
        }
        this.su_tPos = initTT[i7];
        this.su_count = 0;
        this.su_i2 = 0;
        this.su_ch2 = 256;
        if (!this.blockRandomised) {
            return setupNoRandPartA();
        }
        this.su_rNToGo = 0;
        this.su_rTPos = 0;
        return setupRandPartA();
    }

    private int setupRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            byte[] bArr = this.data.ll8;
            int i = this.su_tPos;
            byte b = bArr[i] & 255;
            checkBounds(i, this.data.tt.length, "su_tPos");
            this.su_tPos = this.data.tt[this.su_tPos];
            int i2 = this.su_rNToGo;
            byte b2 = 0;
            if (i2 == 0) {
                this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
                int i3 = this.su_rTPos + 1;
                this.su_rTPos = i3;
                if (i3 == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo = i2 - 1;
            }
            if (this.su_rNToGo == 1) {
                b2 = 1;
            }
            byte b3 = b ^ b2;
            this.su_ch2 = b3;
            this.su_i2++;
            this.currentState = 3;
            this.crc.updateCRC(b3);
            return b3;
        }
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupNoRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            byte[] bArr = this.data.ll8;
            int i = this.su_tPos;
            byte b = bArr[i] & 255;
            this.su_ch2 = b;
            checkBounds(i, this.data.tt.length, "su_tPos");
            this.su_tPos = this.data.tt[this.su_tPos];
            this.su_i2++;
            this.currentState = 6;
            this.crc.updateCRC(b);
            return b;
        }
        this.currentState = 5;
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.currentState = 2;
            this.su_count = 1;
            return setupRandPartA();
        }
        int i = this.su_count + 1;
        this.su_count = i;
        if (i >= 4) {
            byte[] bArr = this.data.ll8;
            int i2 = this.su_tPos;
            this.su_z = (char) (bArr[i2] & 255);
            checkBounds(i2, this.data.tt.length, "su_tPos");
            this.su_tPos = this.data.tt[this.su_tPos];
            int i3 = this.su_rNToGo;
            if (i3 == 0) {
                this.su_rNToGo = Rand.rNums(this.su_rTPos) - 1;
                int i4 = this.su_rTPos + 1;
                this.su_rTPos = i4;
                if (i4 == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo = i3 - 1;
            }
            this.su_j2 = 0;
            this.currentState = 4;
            if (this.su_rNToGo == 1) {
                this.su_z = (char) (this.su_z ^ 1);
            }
            return setupRandPartC();
        }
        this.currentState = 2;
        return setupRandPartA();
    }

    private int setupRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            this.crc.updateCRC(this.su_ch2);
            this.su_j2++;
            return this.su_ch2;
        }
        this.currentState = 2;
        this.su_i2++;
        this.su_count = 0;
        return setupRandPartA();
    }

    private int setupNoRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.su_count = 1;
            return setupNoRandPartA();
        }
        int i = this.su_count + 1;
        this.su_count = i;
        if (i < 4) {
            return setupNoRandPartA();
        }
        checkBounds(this.su_tPos, this.data.ll8.length, "su_tPos");
        this.su_z = (char) (this.data.ll8[this.su_tPos] & 255);
        this.su_tPos = this.data.tt[this.su_tPos];
        this.su_j2 = 0;
        return setupNoRandPartC();
    }

    private int setupNoRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            int i = this.su_ch2;
            this.crc.updateCRC(i);
            this.su_j2++;
            this.currentState = 7;
            return i;
        }
        this.su_i2++;
        this.su_count = 0;
        return setupNoRandPartA();
    }

    private static final class Data {
        final int[][] base;
        final int[] cftab;
        final char[] getAndMoveToFrontDecode_yy;
        final boolean[] inUse = new boolean[256];
        final int[][] limit;
        byte[] ll8;
        final int[] minLens;
        final int[][] perm;
        final byte[] recvDecodingTables_pos;
        final byte[] selector = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] selectorMtf = new byte[BZip2Constants.MAX_SELECTORS];
        final byte[] seqToUnseq = new byte[256];
        final char[][] temp_charArray2d;
        int[] tt;
        final int[] unzftab = new int[256];

        Data(int i) {
            int[] iArr = new int[2];
            iArr[1] = 258;
            iArr[0] = 6;
            this.limit = (int[][]) Array.newInstance(Integer.TYPE, iArr);
            int[] iArr2 = new int[2];
            iArr2[1] = 258;
            iArr2[0] = 6;
            this.base = (int[][]) Array.newInstance(Integer.TYPE, iArr2);
            int[] iArr3 = new int[2];
            iArr3[1] = 258;
            iArr3[0] = 6;
            this.perm = (int[][]) Array.newInstance(Integer.TYPE, iArr3);
            this.minLens = new int[6];
            this.cftab = new int[257];
            this.getAndMoveToFrontDecode_yy = new char[256];
            int[] iArr4 = new int[2];
            iArr4[1] = 258;
            iArr4[0] = 6;
            this.temp_charArray2d = (char[][]) Array.newInstance(Character.TYPE, iArr4);
            this.recvDecodingTables_pos = new byte[6];
            this.ll8 = new byte[(i * 100000)];
        }

        /* access modifiers changed from: package-private */
        public int[] initTT(int i) {
            int[] iArr = this.tt;
            if (iArr != null && iArr.length >= i) {
                return iArr;
            }
            int[] iArr2 = new int[i];
            this.tt = iArr2;
            return iArr2;
        }
    }

    public static boolean matches(byte[] bArr, int i) {
        return i >= 3 && bArr[0] == 66 && bArr[1] == 90 && bArr[2] == 104;
    }
}
