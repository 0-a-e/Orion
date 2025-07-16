package org.apache.commons.compress.archivers.zip;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.utils.IOUtils;

class BinaryTree {
    private static final int NODE = -2;
    private static final int UNDEFINED = -1;
    private final int[] tree;

    public BinaryTree(int i) {
        if (i < 0 || i > 30) {
            throw new IllegalArgumentException("depth must be bigger than 0 and not bigger than 30 but is " + i);
        }
        int[] iArr = new int[((int) ((1 << (i + 1)) - 1))];
        this.tree = iArr;
        Arrays.fill(iArr, -1);
    }

    public void addLeaf(int i, int i2, int i3, int i4) {
        if (i3 == 0) {
            int[] iArr = this.tree;
            if (iArr[i] == -1) {
                iArr[i] = i4;
                return;
            }
            throw new IllegalArgumentException("Tree value at index " + i + " has already been assigned (" + this.tree[i] + ")");
        }
        this.tree[i] = -2;
        addLeaf((i * 2) + 1 + (i2 & 1), i2 >>> 1, i3 - 1, i4);
    }

    public int read(BitStream bitStream) throws IOException {
        int i = 0;
        while (true) {
            int nextBit = bitStream.nextBit();
            if (nextBit == -1) {
                return -1;
            }
            int i2 = (i * 2) + 1 + nextBit;
            int i3 = this.tree[i2];
            if (i3 == -2) {
                i = i2;
            } else if (i3 != -1) {
                return i3;
            } else {
                throw new IOException("The child " + nextBit + " of node at index " + i + " is not defined");
            }
        }
    }

    static BinaryTree decode(InputStream inputStream, int i) throws IOException {
        if (i >= 0) {
            int read = inputStream.read() + 1;
            if (read != 0) {
                byte[] bArr = new byte[read];
                if (IOUtils.readFully(inputStream, bArr) == read) {
                    int[] iArr = new int[i];
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i2 < read) {
                        byte b = bArr[i2];
                        int i5 = ((b & 240) >> 4) + 1;
                        if (i3 + i5 <= i) {
                            int i6 = (b & 15) + 1;
                            int i7 = 0;
                            while (i7 < i5) {
                                iArr[i3] = i6;
                                i7++;
                                i3++;
                            }
                            i4 = Math.max(i4, i6);
                            i2++;
                        } else {
                            throw new IOException("Number of values exceeds given total number of values");
                        }
                    }
                    int[] iArr2 = new int[i];
                    for (int i8 = 0; i8 < i; i8++) {
                        iArr2[i8] = i8;
                    }
                    int[] iArr3 = new int[i];
                    int i9 = 0;
                    for (int i10 = 0; i10 < i; i10++) {
                        for (int i11 = 0; i11 < i; i11++) {
                            if (iArr[i11] == i10) {
                                iArr3[i9] = i10;
                                iArr2[i9] = i11;
                                i9++;
                            }
                        }
                    }
                    int[] iArr4 = new int[i];
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    for (int i15 = i - 1; i15 >= 0; i15--) {
                        i12 += i13;
                        int i16 = iArr3[i15];
                        if (i16 != i14) {
                            i13 = 1 << (16 - i16);
                            i14 = i16;
                        }
                        iArr4[iArr2[i15]] = i12;
                    }
                    BinaryTree binaryTree = new BinaryTree(i4);
                    for (int i17 = 0; i17 < i; i17++) {
                        int i18 = iArr[i17];
                        if (i18 > 0) {
                            binaryTree.addLeaf(0, Integer.reverse(iArr4[i17] << 16), i18, i17);
                        }
                    }
                    return binaryTree;
                }
                throw new EOFException();
            }
            throw new IOException("Cannot read the size of the encoded tree, unexpected end of stream");
        }
        throw new IllegalArgumentException("totalNumberOfValues must be bigger than 0, is " + i);
    }
}
