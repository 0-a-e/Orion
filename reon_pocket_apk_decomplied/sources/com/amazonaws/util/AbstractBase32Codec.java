package com.amazonaws.util;

abstract class AbstractBase32Codec implements Codec {
    private static final int BITS_3 = 3;
    private static final int BITS_4 = 4;
    private static final int BITS_5 = 5;
    private static final int BIT_MULTIPLIER = 8;
    private static final int MASK_2BITS = 3;
    private static final int MASK_3BITS = 7;
    private static final int MASK_4BITS = 15;
    private static final int MASK_5BITS = 31;
    private static final byte PAD = 61;
    private final byte[] alpahbets;

    /* access modifiers changed from: protected */
    public abstract int pos(byte b);

    protected AbstractBase32Codec(byte[] bArr) {
        this.alpahbets = bArr;
    }

    public final byte[] encode(byte[] bArr) {
        int length = bArr.length / 5;
        int length2 = bArr.length % 5;
        int i = 0;
        if (length2 == 0) {
            byte[] bArr2 = new byte[(length * 8)];
            int i2 = 0;
            while (i < bArr.length) {
                encode5bytes(bArr, i, bArr2, i2);
                i += 5;
                i2 += 8;
            }
            return bArr2;
        }
        byte[] bArr3 = new byte[((length + 1) * 8)];
        int i3 = 0;
        while (i < bArr.length - length2) {
            encode5bytes(bArr, i, bArr3, i3);
            i += 5;
            i3 += 8;
        }
        if (length2 == 1) {
            encode1byte(bArr, i, bArr3, i3);
        } else if (length2 == 2) {
            encode2bytes(bArr, i, bArr3, i3);
        } else if (length2 == 3) {
            encode3bytes(bArr, i, bArr3, i3);
        } else if (length2 == 4) {
            encode4bytes(bArr, i, bArr3, i3);
        }
        return bArr3;
    }

    private final void encode5bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.alpahbets;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        byte b2 = bArr[i + 1];
        bArr2[i2 + 1] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        bArr2[i2 + 2] = bArr3[(b2 >>> 1) & 31];
        byte b3 = bArr[i + 2];
        bArr2[i2 + 3] = bArr3[((b2 & 1) << 4) | ((b3 >>> 4) & 15)];
        byte b4 = bArr[i + 3];
        bArr2[i2 + 4] = bArr3[((b3 & 15) << 1) | ((b4 >>> 7) & 1)];
        bArr2[i2 + 5] = bArr3[(b4 >>> 2) & 31];
        byte b5 = bArr[i + 4];
        bArr2[i2 + 6] = bArr3[((b5 >>> 5) & 7) | ((b4 & 3) << 3)];
        bArr2[i2 + 7] = bArr3[b5 & 31];
    }

    private final void encode4bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.alpahbets;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        byte b2 = bArr[i + 1];
        bArr2[i2 + 1] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        bArr2[i2 + 2] = bArr3[(b2 >>> 1) & 31];
        byte b3 = bArr[i + 2];
        bArr2[i2 + 3] = bArr3[((b2 & 1) << 4) | ((b3 >>> 4) & 15)];
        byte b4 = bArr[i + 3];
        bArr2[i2 + 4] = bArr3[((b4 >>> 7) & 1) | ((b3 & 15) << 1)];
        bArr2[i2 + 5] = bArr3[(b4 >>> 2) & 31];
        bArr2[i2 + 6] = bArr3[(b4 & 3) << 3];
        bArr2[i2 + 7] = 61;
    }

    private final void encode3bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.alpahbets;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        byte b2 = bArr[i + 1];
        bArr2[i2 + 1] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        bArr2[i2 + 2] = bArr3[(b2 >>> 1) & 31];
        int i3 = i2 + 4;
        byte b3 = bArr[i + 2];
        bArr2[i2 + 3] = bArr3[((b3 >>> 4) & 15) | ((b2 & 1) << 4)];
        int i4 = i2 + 5;
        bArr2[i3] = bArr3[(b3 & 15) << 1];
        int i5 = 0;
        while (i5 < 3) {
            bArr2[i4] = 61;
            i5++;
            i4++;
        }
    }

    private final void encode2bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArr3 = this.alpahbets;
        int i3 = i + 1;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        byte b2 = bArr[i3];
        bArr2[i2 + 1] = bArr3[((b & 7) << 2) | ((b2 >>> 6) & 3)];
        int i4 = i2 + 3;
        bArr2[i2 + 2] = bArr3[(b2 >>> 1) & 31];
        int i5 = i2 + 4;
        bArr2[i4] = bArr3[(b2 & 1) << 4];
        int i6 = 0;
        while (i6 < 4) {
            bArr2[i5] = 61;
            i6++;
            i5++;
        }
    }

    private final void encode1byte(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = i2 + 1;
        byte[] bArr3 = this.alpahbets;
        byte b = bArr[i];
        bArr2[i2] = bArr3[(b >>> 3) & 31];
        int i4 = i2 + 2;
        bArr2[i3] = bArr3[(b & 7) << 2];
        int i5 = 0;
        while (i5 < 6) {
            bArr2[i4] = 61;
            i5++;
            i4++;
        }
    }

    private final void decode5bytes(byte[] bArr, int i, byte[] bArr2, int i2) {
        int pos = pos(bArr[i + 1]);
        bArr2[i2] = (byte) ((pos(bArr[i]) << 3) | ((pos >>> 2) & 7));
        int pos2 = ((pos & 3) << 6) | (pos(bArr[i + 2]) << 1);
        int pos3 = pos(bArr[i + 3]);
        bArr2[i2 + 1] = (byte) (pos2 | ((pos3 >>> 4) & 1));
        int pos4 = pos(bArr[i + 4]);
        bArr2[i2 + 2] = (byte) (((pos3 & 15) << 4) | ((pos4 >>> 1) & 15));
        int pos5 = pos(bArr[i + 6]);
        bArr2[i2 + 3] = (byte) (((pos4 & 1) << 7) | (pos(bArr[i + 5]) << 2) | ((pos5 >>> 3) & 3));
        bArr2[i2 + 4] = (byte) (pos(bArr[i + 7]) | ((pos5 & 7) << 5));
    }

    private final void decode1to4bytes(int i, byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i3 + 1;
        int i5 = i2 + 2;
        int pos = pos(bArr[i2 + 1]);
        bArr2[i3] = (byte) ((pos(bArr[i2]) << 3) | ((pos >>> 2) & 7));
        if (i == 1) {
            CodecUtils.sanityCheckLastPos(pos, 3);
            return;
        }
        int i6 = i3 + 2;
        int pos2 = ((pos & 3) << 6) | (pos(bArr[i5]) << 1);
        int i7 = i2 + 4;
        int pos3 = pos(bArr[i2 + 3]);
        bArr2[i4] = (byte) (pos2 | ((pos3 >>> 4) & 1));
        if (i == 2) {
            CodecUtils.sanityCheckLastPos(pos3, 15);
            return;
        }
        int i8 = i3 + 3;
        int i9 = i2 + 5;
        int pos4 = pos(bArr[i7]);
        bArr2[i6] = (byte) ((15 & (pos4 >>> 1)) | ((pos3 & 15) << 4));
        if (i == 3) {
            CodecUtils.sanityCheckLastPos(pos4, 1);
            return;
        }
        int pos5 = pos(bArr[i2 + 6]);
        bArr2[i8] = (byte) (((pos4 & 1) << 7) | (pos(bArr[i9]) << 2) | ((pos5 >>> 3) & 3));
        CodecUtils.sanityCheckLastPos(pos5, 7);
    }

    public final byte[] decode(byte[] bArr, int i) {
        int i2;
        if (i % 8 == 0) {
            int i3 = i - 1;
            int i4 = 0;
            while (i4 < 6 && i3 > -1 && bArr[i3] == 61) {
                i3--;
                i4++;
            }
            if (i4 != 0) {
                int i5 = 4;
                if (i4 != 1) {
                    i2 = 3;
                    if (i4 != 3) {
                        if (i4 == 4) {
                            i5 = 2;
                        } else if (i4 == 6) {
                            i2 = 1;
                        } else {
                            throw new IllegalArgumentException("Invalid number of paddings " + i4);
                        }
                    }
                }
                i2 = i5;
            } else {
                i2 = 5;
            }
            int i6 = ((i / 8) * 5) - (5 - i2);
            byte[] bArr2 = new byte[i6];
            int i7 = 0;
            int i8 = 0;
            while (i8 < i6 - (i2 % 5)) {
                decode5bytes(bArr, i7, bArr2, i8);
                i7 += 8;
                i8 += 5;
            }
            if (i2 < 5) {
                decode1to4bytes(i2, bArr, i7, bArr2, i8);
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input is expected to be encoded in multiple of 8 bytes but found: " + i);
    }
}
