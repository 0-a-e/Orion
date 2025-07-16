package org.apache.commons.compress.compressors.bzip2;

import java.util.BitSet;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

class BlockSort {
    private static final int CLEARMASK = -2097153;
    private static final int DEPTH_THRESH = 10;
    private static final int FALLBACK_QSORT_SMALL_THRESH = 10;
    private static final int FALLBACK_QSORT_STACK_SIZE = 100;
    private static final int[] INCS = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private static final int QSORT_STACK_SIZE = 1000;
    private static final int SETMASK = 2097152;
    private static final int SMALL_THRESH = 20;
    private static final int STACK_SIZE = 1000;
    private static final int WORK_FACTOR = 30;
    private int[] eclass;
    private boolean firstAttempt;
    private final int[] ftab = new int[65537];
    private final boolean[] mainSort_bigDone = new boolean[256];
    private final int[] mainSort_copy = new int[256];
    private final int[] mainSort_runningOrder = new int[256];
    private final char[] quadrant;
    private final int[] stack_dd = new int[1000];
    private final int[] stack_hh = new int[1000];
    private final int[] stack_ll = new int[1000];
    private int workDone;
    private int workLimit;

    private int fmin(int i, int i2) {
        return i < i2 ? i : i2;
    }

    private static byte med3(byte b, byte b2, byte b3) {
        if (b < b2) {
            if (b2 >= b3) {
                if (b >= b3) {
                    return b;
                }
                return b3;
            }
        } else if (b2 <= b3) {
            if (b <= b3) {
                return b;
            }
            return b3;
        }
        return b2;
    }

    BlockSort(BZip2CompressorOutputStream.Data data) {
        this.quadrant = data.sfmap;
    }

    /* access modifiers changed from: package-private */
    public void blockSort(BZip2CompressorOutputStream.Data data, int i) {
        this.workLimit = i * 30;
        this.workDone = 0;
        this.firstAttempt = true;
        if (i + 1 < 10000) {
            fallbackSort(data, i);
        } else {
            mainSort(data, i);
            if (this.firstAttempt && this.workDone > this.workLimit) {
                fallbackSort(data, i);
            }
        }
        int[] iArr = data.fmap;
        data.origPtr = -1;
        for (int i2 = 0; i2 <= i; i2++) {
            if (iArr[i2] == 0) {
                data.origPtr = i2;
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void fallbackSort(BZip2CompressorOutputStream.Data data, int i) {
        int i2 = i + 1;
        data.block[0] = data.block[i2];
        fallbackSort(data.fmap, data.block, i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int[] iArr = data.fmap;
            iArr[i3] = iArr[i3] - 1;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (data.fmap[i4] == -1) {
                data.fmap[i4] = i;
                return;
            }
        }
    }

    private void fallbackSimpleSort(int[] iArr, int[] iArr2, int i, int i2) {
        if (i != i2) {
            if (i2 - i > 3) {
                for (int i3 = i2 - 4; i3 >= i; i3--) {
                    int i4 = iArr[i3];
                    int i5 = iArr2[i4];
                    int i6 = i3 + 4;
                    while (i6 <= i2) {
                        int i7 = iArr[i6];
                        if (i5 <= iArr2[i7]) {
                            break;
                        }
                        iArr[i6 - 4] = i7;
                        i6 += 4;
                    }
                    iArr[i6 - 4] = i4;
                }
            }
            for (int i8 = i2 - 1; i8 >= i; i8--) {
                int i9 = iArr[i8];
                int i10 = iArr2[i9];
                int i11 = i8 + 1;
                while (i11 <= i2) {
                    int i12 = iArr[i11];
                    if (i10 <= iArr2[i12]) {
                        break;
                    }
                    iArr[i11 - 1] = i12;
                    i11++;
                }
                iArr[i11 - 1] = i9;
            }
        }
    }

    private void fswap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    private void fvswap(int[] iArr, int i, int i2, int i3) {
        while (i3 > 0) {
            fswap(iArr, i, i2);
            i++;
            i2++;
            i3--;
        }
    }

    private void fpush(int i, int i2, int i3) {
        this.stack_ll[i] = i2;
        this.stack_hh[i] = i3;
    }

    private int[] fpop(int i) {
        return new int[]{this.stack_ll[i], this.stack_hh[i]};
    }

    private void fallbackQSort3(int[] iArr, int[] iArr2, int i, int i2) {
        int i3;
        boolean z;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        char c = 0;
        fpush(0, i, i2);
        long j = 0;
        int i4 = 1;
        long j2 = 0;
        int i5 = 1;
        while (i5 > 0) {
            int i6 = i5 - 1;
            int[] fpop = fpop(i6);
            int i7 = fpop[c];
            int i8 = fpop[i4];
            if (i8 - i7 < 10) {
                fallbackSimpleSort(iArr3, iArr4, i7, i8);
                i5 = i6;
            } else {
                j2 = ((j2 * 7621) + 1) % 32768;
                long j3 = j2 % 3;
                if (j3 == j) {
                    i3 = iArr4[iArr3[i7]];
                } else if (j3 == 1) {
                    i3 = iArr4[iArr3[(i7 + i8) >>> i4]];
                } else {
                    i3 = iArr4[iArr3[i8]];
                }
                long j4 = (long) i3;
                int i9 = i8;
                int i10 = i9;
                int i11 = i7;
                int i12 = i11;
                while (true) {
                    if (i12 <= i9) {
                        int i13 = iArr4[iArr3[i12]] - ((int) j4);
                        if (i13 == 0) {
                            fswap(iArr3, i12, i11);
                            i11++;
                            i12++;
                        } else if (i13 <= 0) {
                            z = true;
                            i12++;
                            iArr4 = iArr2;
                            boolean z2 = z;
                        }
                    }
                    while (i12 <= i9) {
                        int i14 = iArr4[iArr3[i9]] - ((int) j4);
                        if (i14 == 0) {
                            fswap(iArr3, i9, i10);
                            i10--;
                        } else if (i14 < 0) {
                            break;
                        }
                        i9--;
                        iArr4 = iArr2;
                    }
                    if (i12 > i9) {
                        break;
                    }
                    z = true;
                    fswap(iArr3, i12, i9);
                    i12++;
                    i9--;
                    iArr4 = iArr2;
                    boolean z22 = z;
                }
                if (i10 < i11) {
                    iArr4 = iArr2;
                    i5 = i6;
                    c = 0;
                    j = 0;
                    i4 = 1;
                } else {
                    int fmin = fmin(i11 - i7, i12 - i11);
                    fvswap(iArr3, i7, i12 - fmin, fmin);
                    int i15 = i8 - i10;
                    int i16 = i10 - i9;
                    int fmin2 = fmin(i15, i16);
                    fvswap(iArr3, i9 + 1, (i8 - fmin2) + 1, fmin2);
                    int i17 = ((i12 + i7) - i11) - 1;
                    int i18 = (i8 - i16) + 1;
                    if (i17 - i7 > i8 - i18) {
                        fpush(i6, i7, i17);
                        fpush(i5, i18, i8);
                        i5++;
                    } else {
                        fpush(i6, i18, i8);
                        fpush(i5, i7, i17);
                        i5++;
                    }
                    iArr4 = iArr2;
                    i4 = 1;
                    c = 0;
                    j = 0;
                }
            }
        }
    }

    private int[] getEclass() {
        if (this.eclass == null) {
            this.eclass = new int[(this.quadrant.length / 2)];
        }
        return this.eclass;
    }

    /* access modifiers changed from: package-private */
    public final void fallbackSort(int[] iArr, byte[] bArr, int i) {
        int i2;
        int[] iArr2 = new int[257];
        int[] eclass2 = getEclass();
        for (int i3 = 0; i3 < i; i3++) {
            eclass2[i3] = 0;
        }
        for (int i4 = 0; i4 < i; i4++) {
            byte b = bArr[i4] & 255;
            iArr2[b] = iArr2[b] + 1;
        }
        for (int i5 = 1; i5 < 257; i5++) {
            iArr2[i5] = iArr2[i5] + iArr2[i5 - 1];
        }
        for (int i6 = 0; i6 < i; i6++) {
            byte b2 = bArr[i6] & 255;
            int i7 = iArr2[b2] - 1;
            iArr2[b2] = i7;
            iArr[i7] = i6;
        }
        BitSet bitSet = new BitSet(i + 64);
        for (int i8 = 0; i8 < 256; i8++) {
            bitSet.set(iArr2[i8]);
        }
        for (int i9 = 0; i9 < 32; i9++) {
            int i10 = (i9 * 2) + i;
            bitSet.set(i10);
            bitSet.clear(i10 + 1);
        }
        int i11 = 1;
        do {
            int i12 = 0;
            for (int i13 = 0; i13 < i; i13++) {
                if (bitSet.get(i13)) {
                    i12 = i13;
                }
                int i14 = iArr[i13] - i11;
                if (i14 < 0) {
                    i14 += i;
                }
                eclass2[i14] = i12;
            }
            int i15 = -1;
            i2 = 0;
            while (true) {
                int nextClearBit = bitSet.nextClearBit(i15 + 1);
                int i16 = nextClearBit - 1;
                if (i16 < i && (i15 = bitSet.nextSetBit(nextClearBit + 1) - 1) < i) {
                    if (i15 > i16) {
                        i2 += (i15 - i16) + 1;
                        fallbackQSort3(iArr, eclass2, i16, i15);
                        int i17 = -1;
                        while (i16 <= i15) {
                            int i18 = eclass2[iArr[i16]];
                            if (i17 != i18) {
                                bitSet.set(i16);
                                i17 = i18;
                            }
                            i16++;
                        }
                    }
                }
            }
            i11 *= 2;
            if (i11 > i) {
                return;
            }
        } while (i2 != 0);
    }

    private boolean mainSimpleSort(BZip2CompressorOutputStream.Data data, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        BZip2CompressorOutputStream.Data data2 = data;
        int i11 = i2;
        int i12 = (i11 - i) + 1;
        if (i12 < 2) {
            return this.firstAttempt && this.workDone > this.workLimit;
        }
        int i13 = 0;
        while (INCS[i5] < i12) {
            i13 = i5 + 1;
        }
        int[] iArr = data2.fmap;
        char[] cArr = this.quadrant;
        byte[] bArr = data2.block;
        int i14 = i4 + 1;
        boolean z = this.firstAttempt;
        int i15 = this.workLimit;
        int i16 = this.workDone;
        loop1:
        while (true) {
            i5--;
            if (i5 < 0) {
                break;
            }
            int i17 = INCS[i5];
            int i18 = i + i17;
            int i19 = i18 - 1;
            while (i18 <= i11) {
                int i20 = 3;
                while (i18 <= i11) {
                    int i21 = i20 - 1;
                    if (i21 < 0) {
                        break;
                    }
                    int i22 = iArr[i18];
                    int i23 = i22 + i3;
                    int i24 = i18;
                    boolean z2 = false;
                    int i25 = 0;
                    while (true) {
                        if (z2) {
                            iArr[i24] = i25;
                            i10 = i24 - i17;
                            if (i10 <= i19) {
                                i9 = i5;
                                i7 = i17;
                                i6 = i19;
                                i8 = i21;
                                break;
                            }
                            i24 = i10;
                        } else {
                            z2 = true;
                        }
                        int i26 = iArr[i24 - i17];
                        int i27 = i26 + i3;
                        byte b = bArr[i27 + 1];
                        int i28 = i26;
                        byte b2 = bArr[i23 + 1];
                        if (b != b2) {
                            i9 = i5;
                            i7 = i17;
                            i6 = i19;
                            i8 = i21;
                            if ((b & 255) <= (b2 & 255)) {
                                break;
                            }
                        } else {
                            byte b3 = bArr[i27 + 2];
                            byte b4 = bArr[i23 + 2];
                            if (b3 != b4) {
                                i9 = i5;
                                i7 = i17;
                                i6 = i19;
                                i8 = i21;
                                if ((b3 & 255) <= (b4 & 255)) {
                                    break;
                                }
                            } else {
                                byte b5 = bArr[i27 + 3];
                                byte b6 = bArr[i23 + 3];
                                if (b5 != b6) {
                                    i9 = i5;
                                    i7 = i17;
                                    i6 = i19;
                                    i8 = i21;
                                    if ((b5 & 255) <= (b6 & 255)) {
                                        break;
                                    }
                                } else {
                                    byte b7 = bArr[i27 + 4];
                                    byte b8 = bArr[i23 + 4];
                                    if (b7 != b8) {
                                        i9 = i5;
                                        i7 = i17;
                                        i6 = i19;
                                        i8 = i21;
                                        if ((b7 & 255) <= (b8 & 255)) {
                                            break;
                                        }
                                    } else {
                                        byte b9 = bArr[i27 + 5];
                                        byte b10 = bArr[i23 + 5];
                                        if (b9 != b10) {
                                            i9 = i5;
                                            i7 = i17;
                                            i6 = i19;
                                            i8 = i21;
                                            if ((b9 & 255) <= (b10 & 255)) {
                                                break;
                                            }
                                        } else {
                                            int i29 = i27 + 6;
                                            byte b11 = bArr[i29];
                                            int i30 = i23 + 6;
                                            i9 = i5;
                                            byte b12 = bArr[i30];
                                            if (b11 != b12) {
                                                i7 = i17;
                                                i6 = i19;
                                                i8 = i21;
                                                if ((b11 & 255) <= (b12 & 255)) {
                                                    break;
                                                }
                                            } else {
                                                int i31 = i4;
                                                while (true) {
                                                    if (i31 <= 0) {
                                                        i7 = i17;
                                                        i6 = i19;
                                                        i8 = i21;
                                                        break;
                                                    }
                                                    int i32 = i29 + 1;
                                                    int i33 = i31 - 4;
                                                    byte b13 = bArr[i32];
                                                    int i34 = i30 + 1;
                                                    i7 = i17;
                                                    byte b14 = bArr[i34];
                                                    if (b13 != b14) {
                                                        i6 = i19;
                                                        i8 = i21;
                                                        if ((b13 & 255) <= (b14 & 255)) {
                                                            break;
                                                        }
                                                    } else {
                                                        char c = cArr[i29];
                                                        char c2 = cArr[i30];
                                                        if (c != c2) {
                                                            i6 = i19;
                                                            i8 = i21;
                                                            if (c <= c2) {
                                                                break;
                                                            }
                                                        } else {
                                                            int i35 = i29 + 2;
                                                            byte b15 = bArr[i35];
                                                            int i36 = i30 + 2;
                                                            i6 = i19;
                                                            byte b16 = bArr[i36];
                                                            if (b15 != b16) {
                                                                i8 = i21;
                                                                if ((b15 & 255) <= (b16 & 255)) {
                                                                    break;
                                                                }
                                                            } else {
                                                                char c3 = cArr[i32];
                                                                char c4 = cArr[i34];
                                                                if (c3 != c4) {
                                                                    i8 = i21;
                                                                    if (c3 <= c4) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    int i37 = i29 + 3;
                                                                    byte b17 = bArr[i37];
                                                                    int i38 = i30 + 3;
                                                                    i8 = i21;
                                                                    byte b18 = bArr[i38];
                                                                    if (b17 != b18) {
                                                                        if ((b17 & 255) <= (b18 & 255)) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        char c5 = cArr[i35];
                                                                        char c6 = cArr[i36];
                                                                        if (c5 != c6) {
                                                                            if (c5 <= c6) {
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            int i39 = i29 + 4;
                                                                            byte b19 = bArr[i39];
                                                                            i30 += 4;
                                                                            byte b20 = bArr[i30];
                                                                            if (b19 != b20) {
                                                                                if ((b19 & 255) <= (b20 & 255)) {
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                char c7 = cArr[i37];
                                                                                char c8 = cArr[i38];
                                                                                if (c7 != c8) {
                                                                                    if (c7 <= c8) {
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    if (i39 >= i14) {
                                                                                        i39 -= i14;
                                                                                    }
                                                                                    i29 = i39;
                                                                                    if (i30 >= i14) {
                                                                                        i30 -= i14;
                                                                                    }
                                                                                    i16++;
                                                                                    i31 = i33;
                                                                                    i21 = i8;
                                                                                    i17 = i7;
                                                                                    i19 = i6;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i25 = i28;
                        i5 = i9;
                        i21 = i8;
                        i17 = i7;
                        i19 = i6;
                    }
                    i10 = i24;
                    iArr[i10] = i22;
                    i18++;
                    i5 = i9;
                    i20 = i8;
                    i17 = i7;
                    i19 = i6;
                }
                int i40 = i5;
                int i41 = i17;
                int i42 = i19;
                if (z && i18 <= i11 && i16 > i15) {
                    break loop1;
                }
                i5 = i40;
                i17 = i41;
                i19 = i42;
            }
            int i43 = i5;
        }
        this.workDone = i16;
        return z && i16 > i15;
    }

    private static void vswap(int[] iArr, int i, int i2, int i3) {
        int i4 = i3 + i;
        while (i < i4) {
            int i5 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i5;
            i2++;
            i++;
        }
    }

    private void mainQSort3(BZip2CompressorOutputStream.Data data, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        int i6;
        BZip2CompressorOutputStream.Data data2 = data;
        int[] iArr = this.stack_ll;
        int[] iArr2 = this.stack_hh;
        int[] iArr3 = this.stack_dd;
        int[] iArr4 = data2.fmap;
        byte[] bArr = data2.block;
        iArr[0] = i;
        iArr2[0] = i2;
        iArr3[0] = i3;
        boolean z2 = true;
        int i7 = 1;
        while (true) {
            int i8 = i7 - 1;
            if (i8 >= 0) {
                int i9 = iArr[i8];
                int i10 = iArr2[i8];
                int i11 = iArr3[i8];
                if (i10 - i9 < 20 || i11 > 10) {
                    z = z2;
                    if (!mainSimpleSort(data, i9, i10, i11, i4)) {
                        i7 = i8;
                    } else {
                        return;
                    }
                } else {
                    int i12 = i11 + 1;
                    byte med3 = med3(bArr[iArr4[i9] + i12], bArr[iArr4[i10] + i12], bArr[iArr4[(i9 + i10) >>> 1] + i12]) & 255;
                    int i13 = i9;
                    int i14 = i13;
                    int i15 = i10;
                    int i16 = i15;
                    while (true) {
                        if (i14 <= i15) {
                            int i17 = iArr4[i14];
                            int i18 = (bArr[i17 + i12] & 255) - med3;
                            if (i18 == 0) {
                                iArr4[i14] = iArr4[i13];
                                iArr4[i13] = i17;
                                i13++;
                                i14++;
                            } else if (i18 < 0) {
                                i14++;
                            }
                            BZip2CompressorOutputStream.Data data3 = data;
                        }
                        i5 = i16;
                        while (true) {
                            if (i14 > i15) {
                                i6 = i7;
                                break;
                            }
                            int i19 = iArr4[i15];
                            i6 = i7;
                            int i20 = (bArr[i19 + i12] & 255) - med3;
                            if (i20 != 0) {
                                if (i20 <= 0) {
                                    break;
                                }
                                i15--;
                            } else {
                                iArr4[i15] = iArr4[i5];
                                iArr4[i5] = i19;
                                i5--;
                                i15--;
                            }
                            i7 = i6;
                        }
                        if (i14 > i15) {
                            break;
                        }
                        int i21 = iArr4[i14];
                        iArr4[i14] = iArr4[i15];
                        iArr4[i15] = i21;
                        i7 = i6;
                        i15--;
                        i14++;
                        i16 = i5;
                        BZip2CompressorOutputStream.Data data32 = data;
                    }
                    if (i5 < i13) {
                        iArr[i8] = i9;
                        iArr2[i8] = i10;
                        iArr3[i8] = i12;
                        i7 = i6;
                        z = true;
                    } else {
                        int i22 = i13 - i9;
                        int i23 = i14 - i13;
                        if (i22 >= i23) {
                            i22 = i23;
                        }
                        vswap(iArr4, i9, i14 - i22, i22);
                        int i24 = i10 - i5;
                        int i25 = i5 - i15;
                        if (i24 >= i25) {
                            i24 = i25;
                        }
                        z = true;
                        vswap(iArr4, i14, (i10 - i24) + 1, i24);
                        int i26 = (i14 + i9) - i13;
                        int i27 = i10 - i25;
                        iArr[i8] = i9;
                        iArr2[i8] = i26 - 1;
                        iArr3[i8] = i11;
                        iArr[i6] = i26;
                        iArr2[i6] = i27;
                        iArr3[i6] = i12;
                        int i28 = i6 + 1;
                        iArr[i28] = i27 + 1;
                        iArr2[i28] = i10;
                        iArr3[i28] = i11;
                        i7 = i6 + 2;
                    }
                }
                BZip2CompressorOutputStream.Data data4 = data;
                z2 = z;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void mainSort(BZip2CompressorOutputStream.Data data, int i) {
        int[] iArr;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        BZip2CompressorOutputStream.Data data2 = data;
        int i7 = i;
        int[] iArr2 = this.mainSort_runningOrder;
        int[] iArr3 = this.mainSort_copy;
        boolean[] zArr = this.mainSort_bigDone;
        int[] iArr4 = this.ftab;
        byte[] bArr = data2.block;
        int[] iArr5 = data2.fmap;
        char[] cArr = this.quadrant;
        int i8 = this.workLimit;
        boolean z = this.firstAttempt;
        int i9 = 65537;
        while (true) {
            i9--;
            if (i9 < 0) {
                break;
            }
            iArr4[i9] = 0;
        }
        for (int i10 = 0; i10 < 20; i10++) {
            bArr[i7 + i10 + 2] = bArr[(i10 % (i7 + 1)) + 1];
        }
        int i11 = i7 + 21;
        while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            cArr[i11] = 0;
        }
        int i12 = i7 + 1;
        byte b = bArr[i12];
        bArr[0] = b;
        boolean z2 = z;
        int i13 = 255;
        byte b2 = b & 255;
        int i14 = 0;
        while (i14 <= i7) {
            i14++;
            byte b3 = bArr[i14] & 255;
            int i15 = (b2 << 8) + b3;
            iArr4[i15] = iArr4[i15] + 1;
            b2 = b3;
        }
        for (int i16 = 1; i16 <= 65536; i16++) {
            iArr4[i16] = iArr4[i16] + iArr4[i16 - 1];
        }
        boolean z3 = true;
        byte b4 = bArr[1] & 255;
        int i17 = 0;
        while (i17 < i7) {
            byte b5 = bArr[i17 + 2] & 255;
            int i18 = (b4 << 8) + b5;
            int i19 = iArr4[i18] - 1;
            iArr4[i18] = i19;
            iArr5[i19] = i17;
            i17++;
            b4 = b5;
            z3 = true;
        }
        int i20 = ((bArr[i12] & 255) << 8) + (bArr[z3] & 255);
        int i21 = iArr4[i20] - 1;
        iArr4[i20] = i21;
        iArr5[i21] = i7;
        int i22 = 256;
        while (true) {
            i22--;
            if (i22 < 0) {
                break;
            }
            zArr[i22] = false;
            iArr2[i22] = i22;
        }
        int i23 = 364;
        while (i23 != 1) {
            i23 /= 3;
            int i24 = i23;
            while (i24 <= i13) {
                int i25 = iArr2[i24];
                int i26 = iArr4[(i25 + 1) << 8] - iArr4[i25 << 8];
                int i27 = i23 - 1;
                int i28 = iArr2[i24 - i23];
                int i29 = i24;
                while (true) {
                    i6 = i8;
                    if (iArr4[(i28 + 1) << 8] - iArr4[i28 << 8] <= i26) {
                        break;
                    }
                    iArr2[i29] = i28;
                    int i30 = i29 - i23;
                    if (i30 <= i27) {
                        i29 = i30;
                        break;
                    }
                    i28 = iArr2[i30 - i23];
                    i29 = i30;
                    i8 = i6;
                }
                iArr2[i29] = i25;
                i24++;
                i8 = i6;
                i13 = 255;
            }
        }
        int i31 = i8;
        int i32 = 0;
        while (i32 <= i13) {
            int i33 = iArr2[i32];
            int i34 = 0;
            while (i34 <= i13) {
                int i35 = (i33 << 8) + i34;
                int i36 = iArr4[i35];
                if ((i36 & 2097152) != 2097152) {
                    int i37 = i36 & CLEARMASK;
                    int i38 = (iArr4[i35 + 1] & CLEARMASK) - 1;
                    if (i38 > i37) {
                        i5 = 2097152;
                        i2 = i34;
                        int i39 = i13;
                        i4 = i31;
                        iArr = iArr2;
                        i3 = i32;
                        mainQSort3(data, i37, i38, 2, i);
                        if (z2 && this.workDone > i4) {
                            return;
                        }
                    } else {
                        i2 = i34;
                        i4 = i31;
                        i5 = 2097152;
                        iArr = iArr2;
                        i3 = i32;
                    }
                    iArr4[i35] = i36 | i5;
                } else {
                    i2 = i34;
                    i4 = i31;
                    iArr = iArr2;
                    i3 = i32;
                }
                i34 = i2 + 1;
                i32 = i3;
                iArr2 = iArr;
                i13 = 255;
                i31 = i4;
                BZip2CompressorOutputStream.Data data3 = data;
            }
            int i40 = i31;
            int[] iArr6 = iArr2;
            int i41 = i32;
            int i42 = 0;
            for (int i43 = i13; i42 <= i43; i43 = 255) {
                iArr3[i42] = iArr4[(i42 << 8) + i33] & CLEARMASK;
                i42++;
            }
            int i44 = i33 << 8;
            int i45 = iArr4[i44] & CLEARMASK;
            int i46 = (i33 + 1) << 8;
            int i47 = iArr4[i46] & CLEARMASK;
            while (i45 < i47) {
                int i48 = iArr5[i45];
                int i49 = i47;
                byte b6 = bArr[i48] & 255;
                if (!zArr[b6]) {
                    iArr5[iArr3[b6]] = i48 == 0 ? i7 : i48 - 1;
                    iArr3[b6] = iArr3[b6] + 1;
                }
                i45++;
                i47 = i49;
            }
            int i50 = 256;
            while (true) {
                i50--;
                if (i50 < 0) {
                    break;
                }
                int i51 = (i50 << 8) + i33;
                iArr4[i51] = iArr4[i51] | 2097152;
            }
            zArr[i33] = true;
            if (i41 < 255) {
                int i52 = iArr4[i44] & CLEARMASK;
                int i53 = (CLEARMASK & iArr4[i46]) - i52;
                int i54 = 0;
                while ((i53 >> i54) > 65534) {
                    i54++;
                }
                int i55 = 0;
                while (i55 < i53) {
                    int i56 = iArr5[i52 + i55];
                    char c = (char) (i55 >> i54);
                    cArr[i56] = c;
                    int i57 = i52;
                    if (i56 < 20) {
                        cArr[i56 + i7 + 1] = c;
                    }
                    i55++;
                    i52 = i57;
                }
            }
            i32 = i41 + 1;
            iArr2 = iArr6;
            i13 = 255;
            i31 = i40;
            BZip2CompressorOutputStream.Data data4 = data;
        }
    }
}
