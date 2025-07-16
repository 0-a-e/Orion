package androidx.collection;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0011\u0010\u0016\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0001H\u0002J\u0011\u0010\u0016\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0011\u0010\u0016\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0001H\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0003H\u0002J\u0011\u0010\u0017\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0001J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0007J\u0019\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\bR\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/collection/MutableIntSet;", "Landroidx/collection/IntSet;", "initialCapacity", "", "(I)V", "growthLimit", "add", "", "element", "addAll", "elements", "", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "findFirstAvailableSlot", "hash1", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "plusAssign", "remove", "removeAll", "removeElementAt", "index", "resizeStorage", "newCapacity", "trim", "writeMetadata", "value", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntSet.kt */
public final class MutableIntSet extends IntSet {
    private int growthLimit;

    public MutableIntSet() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableIntSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public MutableIntSet(int i) {
        super((DefaultConstructorMarker) null);
        if (i >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i));
            return;
        }
        throw new IllegalArgumentException("Capacity must be a positive value.".toString());
    }

    private final void initializeStorage(int i) {
        int max = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.elements = new int[max];
    }

    private final void initializeMetadata(int i) {
        long[] jArr;
        if (i == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[(((i + 15) & -8) >> 3)];
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.metadata = jArr;
        long[] jArr2 = this.metadata;
        int i2 = i >> 3;
        long j = 255 << ((i & 7) << 3);
        jArr2[i2] = (jArr2[i2] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    public final boolean add(int i) {
        int i2 = this._size;
        this.elements[findAbsoluteInsertIndex(i)] = i;
        return this._size != i2;
    }

    public final void plusAssign(int i) {
        this.elements[findAbsoluteInsertIndex(i)] = i;
    }

    public final boolean addAll(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        int i = this._size;
        plusAssign(iArr);
        return i != this._size;
    }

    public final boolean addAll(IntSet intSet) {
        Intrinsics.checkNotNullParameter(intSet, "elements");
        int i = this._size;
        plusAssign(intSet);
        return i != this._size;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0065, code lost:
        if (((r8 & ((~r8) << 6)) & -9187201950435737472L) == 0) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0067, code lost:
        r12 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(int r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r0
            androidx.collection.IntSet r2 = (androidx.collection.IntSet) r2
            r3 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r3 = r3 * r1
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r2._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r7 = 0
        L_0x0016:
            long[] r8 = r2.metadata
            int r9 = r3 >> 3
            r10 = r3 & 7
            int r10 = r10 << 3
            r11 = r8[r9]
            long r11 = r11 >>> r10
            r13 = 1
            int r9 = r9 + r13
            r14 = r8[r9]
            int r8 = 64 - r10
            long r8 = r14 << r8
            long r14 = (long) r10
            long r14 = -r14
            r10 = 63
            long r14 = r14 >> r10
            long r8 = r8 & r14
            long r8 = r8 | r11
            long r10 = (long) r4
            r14 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r10 = r10 * r14
            long r10 = r10 ^ r8
            long r14 = r10 - r14
            long r10 = ~r10
            long r10 = r10 & r14
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r14
        L_0x0042:
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x005e
            int r12 = java.lang.Long.numberOfTrailingZeros(r10)
            int r12 = r12 >> 3
            int r12 = r12 + r3
            r12 = r12 & r5
            int[] r6 = r2.elements
            r6 = r6[r12]
            if (r6 != r1) goto L_0x0057
            goto L_0x0068
        L_0x0057:
            r16 = 1
            long r16 = r10 - r16
            long r10 = r10 & r16
            goto L_0x0042
        L_0x005e:
            long r10 = ~r8
            r6 = 6
            long r10 = r10 << r6
            long r8 = r8 & r10
            long r8 = r8 & r14
            int r6 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r6 == 0) goto L_0x0073
            r12 = -1
        L_0x0068:
            if (r12 < 0) goto L_0x006c
            r6 = r13
            goto L_0x006d
        L_0x006c:
            r6 = 0
        L_0x006d:
            if (r6 == 0) goto L_0x0072
            r0.removeElementAt(r12)
        L_0x0072:
            return r6
        L_0x0073:
            int r7 = r7 + 8
            int r3 = r3 + r7
            r3 = r3 & r5
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntSet.remove(int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0060, code lost:
        if (((r5 & ((~r5) << 6)) & -9187201950435737472L) == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0062, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void minusAssign(int r15) {
        /*
            r14 = this;
            r0 = r14
            androidx.collection.IntSet r0 = (androidx.collection.IntSet) r0
            r1 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r15
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
        L_0x0012:
            long[] r5 = r0.metadata
            int r6 = r1 >> 3
            r7 = r1 & 7
            int r7 = r7 << 3
            r8 = r5[r6]
            long r8 = r8 >>> r7
            int r6 = r6 + 1
            r10 = r5[r6]
            int r5 = 64 - r7
            long r5 = r10 << r5
            long r10 = (long) r7
            long r10 = -r10
            r7 = 63
            long r10 = r10 >> r7
            long r5 = r5 & r10
            long r5 = r5 | r8
            long r7 = (long) r2
            r9 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r7 = r7 * r9
            long r7 = r7 ^ r5
            long r9 = r7 - r9
            long r7 = ~r7
            long r7 = r7 & r9
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
        L_0x003e:
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0059
            int r11 = java.lang.Long.numberOfTrailingZeros(r7)
            int r11 = r11 >> 3
            int r11 = r11 + r1
            r11 = r11 & r3
            int[] r12 = r0.elements
            r12 = r12[r11]
            if (r12 != r15) goto L_0x0053
            goto L_0x0063
        L_0x0053:
            r11 = 1
            long r11 = r7 - r11
            long r7 = r7 & r11
            goto L_0x003e
        L_0x0059:
            long r7 = ~r5
            r13 = 6
            long r7 = r7 << r13
            long r5 = r5 & r7
            long r5 = r5 & r9
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0069
            r11 = -1
        L_0x0063:
            if (r11 < 0) goto L_0x0068
            r14.removeElementAt(r11)
        L_0x0068:
            return
        L_0x0069:
            int r4 = r4 + 8
            int r1 = r1 + r4
            r1 = r1 & r3
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableIntSet.minusAssign(int):void");
    }

    public final boolean removeAll(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        int i = this._size;
        minusAssign(iArr);
        return i != this._size;
    }

    public final boolean removeAll(IntSet intSet) {
        Intrinsics.checkNotNullParameter(intSet, "elements");
        int i = this._size;
        minusAssign(intSet);
        return i != this._size;
    }

    private final void removeElementAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i2 = i >> 3;
        int i3 = (i & 7) << 3;
        jArr[i2] = (jArr[i2] & (~(255 << i3))) | (254 << i3);
        int i4 = this._capacity;
        int i5 = ((i - 7) & i4) + (i4 & 7);
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (jArr[i6] & (~(255 << i7))) | (254 << i7);
    }

    public final void clear() {
        this._size = 0;
        if (this.metadata != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(this.metadata, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr[i2] = (jArr[i2] & (~j)) | j;
        }
        initializeGrowth();
    }

    private final int findAbsoluteInsertIndex(int i) {
        int i2 = i;
        int i3 = ScatterMapKt.MurmurHashC1 * i2;
        int i4 = i3 ^ (i3 << 16);
        int i5 = i4 >>> 7;
        int i6 = i4 & WorkQueueKt.MASK;
        int i7 = this._capacity;
        int i8 = i5 & i7;
        int i9 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i10 = i8 >> 3;
            int i11 = (i8 & 7) << 3;
            long j = ((jArr[i10 + 1] << (64 - i11)) & ((-((long) i11)) >> 63)) | (jArr[i10] >>> i11);
            long j2 = (long) i6;
            int i12 = i9;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j4 != 0; j4 &= j4 - 1) {
                int numberOfTrailingZeros = (i8 + (Long.numberOfTrailingZeros(j4) >> 3)) & i7;
                if (this.elements[numberOfTrailingZeros] == i2) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i5);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i5);
                }
                this._size++;
                int i13 = findFirstAvailableSlot >> 3;
                int i14 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit -= ((this.metadata[i13] >> i14) & 255) == 128 ? 1 : 0;
                long[] jArr2 = this.metadata;
                jArr2[i13] = (jArr2[i13] & (~(255 << i14))) | (j2 << i14);
                int i15 = this._capacity;
                int i16 = ((findFirstAvailableSlot - 7) & i15) + (i15 & 7);
                int i17 = i16 >> 3;
                int i18 = (i16 & 7) << 3;
                jArr2[i17] = ((~(255 << i18)) & jArr2[i17]) | (j2 << i18);
                return findFirstAvailableSlot;
            }
            i9 = i12 + 8;
            i8 = (i8 + i9) & i7;
        }
    }

    private final int findFirstAvailableSlot(int i) {
        int i2 = this._capacity;
        int i3 = i & i2;
        int i4 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i5 = i3 >> 3;
            int i6 = (i3 & 7) << 3;
            long j = ((jArr[i5 + 1] << (64 - i6)) & ((-((long) i6)) >> 63)) | (jArr[i5] >>> i6);
            long j2 = j & ((~j) << 7) & -9187201950435737472L;
            if (j2 != 0) {
                return (i3 + (Long.numberOfTrailingZeros(j2) >> 3)) & i2;
            }
            i4 += 8;
            i3 = (i3 + i4) & i2;
        }
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity >= i) {
            return 0;
        }
        resizeStorage(normalizeCapacity);
        return i - this._capacity;
    }

    private final void adjustStorage() {
        if (this._capacity <= 8 || UByte$$ExternalSyntheticBackport0.m(ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) this._size) * 32), ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) this._capacity) * 25)) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        }
    }

    private final void resizeStorage(int i) {
        int[] iArr;
        long[] jArr;
        long[] jArr2 = this.metadata;
        int[] iArr2 = this.elements;
        int i2 = this._capacity;
        initializeStorage(i);
        int[] iArr3 = this.elements;
        int i3 = 0;
        while (i3 < i2) {
            if (((jArr2[i3 >> 3] >> ((i3 & 7) << 3)) & 255) < 128) {
                int i4 = iArr2[i3];
                int i5 = ScatterMapKt.MurmurHashC1 * i4;
                int i6 = i5 ^ (i5 << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i6 >>> 7);
                long j = (long) (i6 & WorkQueueKt.MASK);
                long[] jArr3 = this.metadata;
                int i7 = findFirstAvailableSlot >> 3;
                int i8 = (findFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                iArr = iArr2;
                jArr3[i7] = ((~(255 << i8)) & jArr3[i7]) | (j << i8);
                int i9 = this._capacity;
                int i10 = ((findFirstAvailableSlot - 7) & i9) + (i9 & 7);
                int i11 = i10 >> 3;
                int i12 = (i10 & 7) << 3;
                jArr3[i11] = ((~(255 << i12)) & jArr3[i11]) | (j << i12);
                iArr3[findFirstAvailableSlot] = i4;
            } else {
                jArr = jArr2;
                iArr = iArr2;
            }
            i3++;
            jArr2 = jArr;
            iArr2 = iArr;
        }
    }

    private final void writeMetadata(int i, long j) {
        long[] jArr = this.metadata;
        int i2 = i >> 3;
        int i3 = (i & 7) << 3;
        jArr[i2] = (jArr[i2] & (~(255 << i3))) | (j << i3);
        int i4 = this._capacity;
        int i5 = ((i - 7) & i4) + (i4 & 7);
        int i6 = i5 >> 3;
        int i7 = (i5 & 7) << 3;
        jArr[i6] = (j << i7) | (jArr[i6] & (~(255 << i7)));
    }

    public final void plusAssign(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        for (int plusAssign : iArr) {
            plusAssign(plusAssign);
        }
    }

    public final void plusAssign(IntSet intSet) {
        Intrinsics.checkNotNullParameter(intSet, "elements");
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            plusAssign(iArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void minusAssign(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        for (int minusAssign : iArr) {
            minusAssign(minusAssign);
        }
    }

    public final void minusAssign(IntSet intSet) {
        Intrinsics.checkNotNullParameter(intSet, "elements");
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            minusAssign(iArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
