package androidx.collection;

import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.WorkQueueKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J'\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\bø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001aH\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\nJ\u0011\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001bH\nJ\u0017\u0010\u001c\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\nJ\u001d\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010#J\u001b\u0010\"\u001a\u00020$2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000¢\u0006\u0002\u0010%J&\u0010&\u001a\u00020\b2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020$0(H\bø\u0001\u0000J\u0017\u0010)\u001a\u0004\u0018\u00018\u00002\u0006\u0010*\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010+J\u0010\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u0004H\u0002J\u001e\u0010.\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010/J\u0006\u00100\u001a\u00020\u0004J\u0019\u00101\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u000202H\bR\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00063"}, d2 = {"Landroidx/collection/MutableFloatObjectMap;", "V", "Landroidx/collection/FloatObjectMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "clear", "findAbsoluteInsertIndex", "key", "", "findFirstAvailableSlot", "hash1", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(FLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "keys", "Landroidx/collection/FloatList;", "Landroidx/collection/FloatSet;", "", "plusAssign", "from", "put", "value", "(FLjava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(F)Ljava/lang/Object;", "", "(FLjava/lang/Object;)Z", "removeIf", "predicate", "Lkotlin/Function2;", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "set", "(FLjava/lang/Object;)V", "trim", "writeMetadata", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatObjectMap.kt */
public final class MutableFloatObjectMap<V> extends FloatObjectMap<V> {
    private int growthLimit;

    public MutableFloatObjectMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableFloatObjectMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public MutableFloatObjectMap(int i) {
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
        this.keys = new float[max];
        this.values = new Object[max];
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

    public final V getOrPut(float f, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = get(f);
        if (v != null) {
            return v;
        }
        V invoke = function0.invoke();
        set(f, invoke);
        return invoke;
    }

    public final void set(float f, V v) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(f);
        this.keys[findAbsoluteInsertIndex] = f;
        this.values[findAbsoluteInsertIndex] = v;
    }

    public final V put(float f, V v) {
        int findAbsoluteInsertIndex = findAbsoluteInsertIndex(f);
        V v2 = this.values[findAbsoluteInsertIndex];
        this.keys[findAbsoluteInsertIndex] = f;
        this.values[findAbsoluteInsertIndex] = v;
        return v2;
    }

    public final void plusAssign(FloatObjectMap<V> floatObjectMap) {
        Intrinsics.checkNotNullParameter(floatObjectMap, Constants.MessagePayloadKeys.FROM);
        putAll(floatObjectMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0066, code lost:
        if (((r5 & ((~r5) << 6)) & -9187201950435737472L) == 0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0068, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V remove(float r15) {
        /*
            r14 = this;
            r0 = r14
            androidx.collection.FloatObjectMap r0 = (androidx.collection.FloatObjectMap) r0
            int r1 = java.lang.Float.floatToIntBits(r15)
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r0._capacity
            int r1 = r1 >>> 7
            r1 = r1 & r3
            r4 = 0
        L_0x0016:
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
        L_0x0042:
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x005f
            int r11 = java.lang.Long.numberOfTrailingZeros(r7)
            int r11 = r11 >> 3
            int r11 = r11 + r1
            r11 = r11 & r3
            float[] r12 = r0.keys
            r12 = r12[r11]
            int r12 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r12 != 0) goto L_0x0059
            goto L_0x0069
        L_0x0059:
            r11 = 1
            long r11 = r7 - r11
            long r7 = r7 & r11
            goto L_0x0042
        L_0x005f:
            long r7 = ~r5
            r13 = 6
            long r7 = r7 << r13
            long r5 = r5 & r7
            long r5 = r5 & r9
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0072
            r11 = -1
        L_0x0069:
            if (r11 < 0) goto L_0x0070
            java.lang.Object r15 = r14.removeValueAt(r11)
            return r15
        L_0x0070:
            r15 = 0
            return r15
        L_0x0072:
            int r4 = r4 + 8
            int r1 = r1 + r4
            r1 = r1 & r3
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableFloatObjectMap.remove(float):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0069, code lost:
        if (((r7 & ((~r7) << 6)) & -9187201950435737472L) == 0) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006b, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(float r18, V r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r0
            androidx.collection.FloatObjectMap r1 = (androidx.collection.FloatObjectMap) r1
            int r2 = java.lang.Float.floatToIntBits(r18)
            r3 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r3
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r1._capacity
            int r2 = r2 >>> 7
            r2 = r2 & r4
            r5 = 0
            r6 = r5
        L_0x0019:
            long[] r7 = r1.metadata
            int r8 = r2 >> 3
            r9 = r2 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r3
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L_0x0045:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L_0x0062
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            float[] r15 = r1.keys
            r15 = r15[r11]
            int r15 = (r15 > r18 ? 1 : (r15 == r18 ? 0 : -1))
            if (r15 != 0) goto L_0x005c
            goto L_0x006c
        L_0x005c:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L_0x0045
        L_0x0062:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
            r11 = -1
        L_0x006c:
            if (r11 < 0) goto L_0x007e
            java.lang.Object[] r1 = r0.values
            r1 = r1[r11]
            r7 = r19
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r7)
            if (r1 == 0) goto L_0x007e
            r0.removeValueAt(r11)
            return r12
        L_0x007e:
            return r5
        L_0x007f:
            r7 = r19
            int r6 = r6 + 8
            int r2 = r2 + r6
            r2 = r2 & r4
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableFloatObjectMap.remove(float, java.lang.Object):boolean");
    }

    public final void removeIf(Function2<? super Float, ? super V, Boolean> function2) {
        Intrinsics.checkNotNullParameter(function2, "predicate");
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            if (function2.invoke(Float.valueOf(this.keys[i4]), this.values[i4]).booleanValue()) {
                                removeValueAt(i4);
                            }
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

    public final void minusAssign(float f) {
        remove(f);
    }

    public final void minusAssign(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "keys");
        for (float remove : fArr) {
            remove(remove);
        }
    }

    public final V removeValueAt(int i) {
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
        V v = this.values[i];
        this.values[i] = null;
        return v;
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
        ArraysKt.fill((T[]) this.values, null, 0, this._capacity);
        initializeGrowth();
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
        float[] fArr;
        long[] jArr;
        long[] jArr2 = this.metadata;
        float[] fArr2 = this.keys;
        Object[] objArr = this.values;
        int i2 = this._capacity;
        initializeStorage(i);
        float[] fArr3 = this.keys;
        Object[] objArr2 = this.values;
        int i3 = 0;
        while (i3 < i2) {
            if (((jArr2[i3 >> 3] >> ((i3 & 7) << 3)) & 255) < 128) {
                float f = fArr2[i3];
                int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
                int i4 = floatToIntBits ^ (floatToIntBits << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i4 >>> 7);
                long j = (long) (i4 & WorkQueueKt.MASK);
                long[] jArr3 = this.metadata;
                int i5 = findFirstAvailableSlot >> 3;
                int i6 = (findFirstAvailableSlot & 7) << 3;
                jArr = jArr2;
                fArr = fArr2;
                jArr3[i5] = (jArr3[i5] & (~(255 << i6))) | (j << i6);
                int i7 = this._capacity;
                int i8 = ((findFirstAvailableSlot - 7) & i7) + (i7 & 7);
                int i9 = i8 >> 3;
                int i10 = (i8 & 7) << 3;
                jArr3[i9] = ((~(255 << i10)) & jArr3[i9]) | (j << i10);
                fArr3[findFirstAvailableSlot] = f;
                objArr2[findFirstAvailableSlot] = objArr[i3];
            } else {
                jArr = jArr2;
                fArr = fArr2;
            }
            i3++;
            jArr2 = jArr;
            fArr2 = fArr;
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

    public final void putAll(FloatObjectMap<V> floatObjectMap) {
        Intrinsics.checkNotNullParameter(floatObjectMap, Constants.MessagePayloadKeys.FROM);
        float[] fArr = floatObjectMap.keys;
        Object[] objArr = floatObjectMap.values;
        long[] jArr = floatObjectMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            set(fArr[i4], objArr[i4]);
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

    public final void minusAssign(FloatSet floatSet) {
        Intrinsics.checkNotNullParameter(floatSet, "keys");
        float[] fArr = floatSet.elements;
        long[] jArr = floatSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            remove(fArr[(i << 3) + i3]);
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

    public final void minusAssign(FloatList floatList) {
        Intrinsics.checkNotNullParameter(floatList, "keys");
        float[] fArr = floatList.content;
        int i = floatList._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(fArr[i2]);
        }
    }

    private final int findAbsoluteInsertIndex(float f) {
        int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        int i = floatToIntBits ^ (floatToIntBits << 16);
        int i2 = i >>> 7;
        int i3 = i & WorkQueueKt.MASK;
        int i4 = this._capacity;
        int i5 = i2 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-((long) i8)) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (long) i3;
            int i9 = i6;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j4 != 0; j4 &= j4 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j4) >> 3) + i5) & i4;
                if (this.keys[numberOfTrailingZeros] == f) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i2);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i2);
                }
                this._size++;
                int i10 = findFirstAvailableSlot >> 3;
                int i11 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit -= ((this.metadata[i10] >> i11) & 255) == 128 ? 1 : 0;
                long[] jArr2 = this.metadata;
                jArr2[i10] = (jArr2[i10] & (~(255 << i11))) | (j2 << i11);
                int i12 = this._capacity;
                int i13 = ((findFirstAvailableSlot - 7) & i12) + (i12 & 7);
                int i14 = i13 >> 3;
                int i15 = (i13 & 7) << 3;
                jArr2[i14] = ((~(255 << i15)) & jArr2[i14]) | (j2 << i15);
                return findFirstAvailableSlot;
            }
            i6 = i9 + 8;
            i5 = (i5 + i6) & i4;
        }
    }
}
