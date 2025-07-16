package androidx.collection;

import com.google.firebase.messaging.Constants;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.scheduling.WorkQueueKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0001DB\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bJ\u0006\u0010\f\u001a\u00020\tJS\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u000028\u0010\u000f\u001a4\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00028\u00010\u0010H\bø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0015\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00028\u0000H\u0001¢\u0006\u0002\u0010\u0018J'\u0010\u0019\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00028\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bH\bø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010!\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u0000H\n¢\u0006\u0002\u0010\"J\u0017\u0010!\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000$H\nJ\u0017\u0010!\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%H\nJ\u001e\u0010!\u001a\u00020\t2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000&H\n¢\u0006\u0002\u0010'J\u0017\u0010!\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000(H\nJ\u0017\u0010!\u001a\u00020\t2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000)H\nJ\u001d\u0010*\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\nJ*\u0010*\u001a\u00020\t2\u001a\u0010,\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0&H\n¢\u0006\u0002\u0010.J\u001d\u0010*\u001a\u00020\t2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-H\nJ#\u0010*\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0(H\nJ\u001d\u0010*\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\nJ#\u0010*\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0)H\nJ\u001d\u00101\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0002\u00102J\u001a\u00103\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003J'\u00103\u001a\u00020\t2\u001a\u0010,\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0&¢\u0006\u0002\u0010.J \u00103\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0(J\u001a\u00103\u001a\u00020\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100J \u00103\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0)J\u0015\u00104\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0002\u00105J\u001b\u00104\u001a\u0002062\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001¢\u0006\u0002\u00107J&\u00108\u001a\u00020\t2\u0018\u00109\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002060\u0010H\bø\u0001\u0000J\u0017\u0010:\u001a\u0004\u0018\u00018\u00012\u0006\u0010;\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u0005H\u0002J\u001e\u0010?\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020\u0005J\u0019\u0010B\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020CH\bR\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006E"}, d2 = {"Landroidx/collection/MutableScatterMap;", "K", "V", "Landroidx/collection/ScatterMap;", "initialCapacity", "", "(I)V", "growthLimit", "adjustStorage", "", "asMutableMap", "", "clear", "compute", "key", "computeBlock", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "findFirstAvailableSlot", "hash1", "findInsertIndex", "(Ljava/lang/Object;)I", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "initializeGrowth", "initializeMetadata", "capacity", "initializeStorage", "minusAssign", "(Ljava/lang/Object;)V", "keys", "Landroidx/collection/ObjectList;", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)V", "", "Lkotlin/sequences/Sequence;", "plusAssign", "from", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "pair", "", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeIf", "predicate", "removeValueAt", "index", "(I)Ljava/lang/Object;", "resizeStorage", "newCapacity", "set", "(Ljava/lang/Object;Ljava/lang/Object;)V", "trim", "writeMetadata", "", "MutableMapWrapper", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScatterMap.kt */
public final class MutableScatterMap<K, V> extends ScatterMap<K, V> {
    private int growthLimit;

    public MutableScatterMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableScatterMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public MutableScatterMap(int i) {
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
        this.keys = new Object[max];
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

    public final V getOrPut(K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        V v = get(k);
        if (v != null) {
            return v;
        }
        V invoke = function0.invoke();
        set(k, invoke);
        return invoke;
    }

    public final V compute(K k, Function2<? super K, ? super V, ? extends V> function2) {
        Object obj;
        Intrinsics.checkNotNullParameter(function2, "computeBlock");
        int findInsertIndex = findInsertIndex(k);
        boolean z = findInsertIndex < 0;
        if (z) {
            obj = null;
        } else {
            obj = this.values[findInsertIndex];
        }
        V invoke = function2.invoke(k, obj);
        if (z) {
            int i = ~findInsertIndex;
            this.keys[i] = k;
            this.values[i] = invoke;
        } else {
            this.values[findInsertIndex] = invoke;
        }
        return invoke;
    }

    public final void set(K k, V v) {
        int findInsertIndex = findInsertIndex(k);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = k;
        this.values[findInsertIndex] = v;
    }

    public final V put(K k, V v) {
        int findInsertIndex = findInsertIndex(k);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        V v2 = this.values[findInsertIndex];
        this.keys[findInsertIndex] = k;
        this.values[findInsertIndex] = v;
        return v2;
    }

    public final void putAll(Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            set(pair.component1(), pair.component2());
        }
    }

    public final void putAll(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        for (Pair pair : iterable) {
            set(pair.component1(), pair.component2());
        }
    }

    public final void putAll(Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "pairs");
        for (Pair pair : sequence) {
            set(pair.component1(), pair.component2());
        }
    }

    public final void plusAssign(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        set(pair.getFirst(), pair.getSecond());
    }

    public final void plusAssign(Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "pairs");
        putAll(pairArr);
    }

    public final void plusAssign(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "pairs");
        putAll(iterable);
    }

    public final void plusAssign(Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "pairs");
        putAll(sequence);
    }

    public final void plusAssign(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, Constants.MessagePayloadKeys.FROM);
        putAll(map);
    }

    public final void plusAssign(ScatterMap<K, V> scatterMap) {
        Intrinsics.checkNotNullParameter(scatterMap, Constants.MessagePayloadKeys.FROM);
        putAll(scatterMap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006c, code lost:
        if (((r5 & ((~r5) << 6)) & -9187201950435737472L) == 0) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006e, code lost:
        r11 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V remove(K r15) {
        /*
            r14 = this;
            r0 = r14
            androidx.collection.ScatterMap r0 = (androidx.collection.ScatterMap) r0
            r1 = 0
            if (r15 == 0) goto L_0x000b
            int r2 = r15.hashCode()
            goto L_0x000c
        L_0x000b:
            r2 = r1
        L_0x000c:
            r3 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r2 = r2 * r3
            int r3 = r2 << 16
            r2 = r2 ^ r3
            r3 = r2 & 127(0x7f, float:1.78E-43)
            int r4 = r0._capacity
            int r2 = r2 >>> 7
        L_0x0019:
            r2 = r2 & r4
            long[] r5 = r0.metadata
            int r6 = r2 >> 3
            r7 = r2 & 7
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
            long r7 = (long) r3
            r9 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r7 = r7 * r9
            long r7 = r7 ^ r5
            long r9 = r7 - r9
            long r7 = ~r7
            long r7 = r7 & r9
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
        L_0x0046:
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0065
            int r11 = java.lang.Long.numberOfTrailingZeros(r7)
            int r11 = r11 >> 3
            int r11 = r11 + r2
            r11 = r11 & r4
            java.lang.Object[] r12 = r0.keys
            r12 = r12[r11]
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r15)
            if (r12 == 0) goto L_0x005f
            goto L_0x006f
        L_0x005f:
            r11 = 1
            long r11 = r7 - r11
            long r7 = r7 & r11
            goto L_0x0046
        L_0x0065:
            long r7 = ~r5
            r13 = 6
            long r7 = r7 << r13
            long r5 = r5 & r7
            long r5 = r5 & r9
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0078
            r11 = -1
        L_0x006f:
            if (r11 < 0) goto L_0x0076
            java.lang.Object r15 = r14.removeValueAt(r11)
            return r15
        L_0x0076:
            r15 = 0
            return r15
        L_0x0078:
            int r1 = r1 + 8
            int r2 = r2 + r1
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap.remove(java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0071, code lost:
        if (((r8 & ((~r8) << 6)) & -9187201950435737472L) == 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0073, code lost:
        r12 = -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(K r19, V r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r0
            androidx.collection.ScatterMap r2 = (androidx.collection.ScatterMap) r2
            if (r1 == 0) goto L_0x000e
            int r4 = r19.hashCode()
            goto L_0x000f
        L_0x000e:
            r4 = 0
        L_0x000f:
            r5 = -862048943(0xffffffffcc9e2d51, float:-8.2930312E7)
            int r4 = r4 * r5
            int r5 = r4 << 16
            r4 = r4 ^ r5
            r5 = r4 & 127(0x7f, float:1.78E-43)
            int r6 = r2._capacity
            int r4 = r4 >>> 7
            r4 = r4 & r6
            r7 = 0
        L_0x001e:
            long[] r8 = r2.metadata
            int r9 = r4 >> 3
            r10 = r4 & 7
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
            long r10 = (long) r5
            r14 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r10 = r10 * r14
            long r10 = r10 ^ r8
            long r14 = r10 - r14
            long r10 = ~r10
            long r10 = r10 & r14
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r14
        L_0x004a:
            r16 = 0
            int r12 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x006a
            int r12 = java.lang.Long.numberOfTrailingZeros(r10)
            int r12 = r12 >> 3
            int r12 = r12 + r4
            r12 = r12 & r6
            java.lang.Object[] r3 = r2.keys
            r3 = r3[r12]
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 == 0) goto L_0x0063
            goto L_0x0074
        L_0x0063:
            r16 = 1
            long r16 = r10 - r16
            long r10 = r10 & r16
            goto L_0x004a
        L_0x006a:
            long r10 = ~r8
            r3 = 6
            long r10 = r10 << r3
            long r8 = r8 & r10
            long r8 = r8 & r14
            int r3 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x0088
            r12 = -1
        L_0x0074:
            if (r12 < 0) goto L_0x0086
            java.lang.Object[] r1 = r0.values
            r1 = r1[r12]
            r3 = r20
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x0086
            r0.removeValueAt(r12)
            return r13
        L_0x0086:
            r8 = 0
            return r8
        L_0x0088:
            r3 = r20
            r8 = 0
            int r7 = r7 + 8
            int r4 = r4 + r7
            r4 = r4 & r6
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap.remove(java.lang.Object, java.lang.Object):boolean");
    }

    public final void removeIf(Function2<? super K, ? super V, Boolean> function2) {
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
                            if (function2.invoke(this.keys[i4], this.values[i4]).booleanValue()) {
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

    public final void minusAssign(K k) {
        remove(k);
    }

    public final void minusAssign(K[] kArr) {
        Intrinsics.checkNotNullParameter(kArr, "keys");
        for (K remove : kArr) {
            remove(remove);
        }
    }

    public final void minusAssign(Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "keys");
        for (Object remove : iterable) {
            remove(remove);
        }
    }

    public final void minusAssign(Sequence<? extends K> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "keys");
        for (Object remove : sequence) {
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
        this.keys[i] = null;
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
        ArraysKt.fill((T[]) this.keys, null, 0, this._capacity);
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
        int i2;
        int i3;
        long[] jArr = this.metadata;
        Object[] objArr = this.keys;
        Object[] objArr2 = this.values;
        int i4 = this._capacity;
        initializeStorage(i);
        Object[] objArr3 = this.keys;
        Object[] objArr4 = this.values;
        int i5 = 0;
        while (i5 < i4) {
            if (((jArr[i5 >> 3] >> ((i5 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i5];
                if (obj != null) {
                    i3 = obj.hashCode();
                } else {
                    i3 = 0;
                }
                int i6 = i3 * ScatterMapKt.MurmurHashC1;
                int i7 = i6 ^ (i6 << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i7 >>> 7);
                long j = (long) (i7 & WorkQueueKt.MASK);
                long[] jArr2 = this.metadata;
                int i8 = findFirstAvailableSlot >> 3;
                int i9 = (findFirstAvailableSlot & 7) << 3;
                i2 = i5;
                jArr2[i8] = (jArr2[i8] & (~(255 << i9))) | (j << i9);
                int i10 = this._capacity;
                int i11 = ((findFirstAvailableSlot - 7) & i10) + (i10 & 7);
                int i12 = i11 >> 3;
                int i13 = (i11 & 7) << 3;
                jArr2[i12] = (jArr2[i12] & (~(255 << i13))) | (j << i13);
                objArr3[findFirstAvailableSlot] = obj;
                objArr4[findFirstAvailableSlot] = objArr2[i2];
            } else {
                i2 = i5;
            }
            i5 = i2 + 1;
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

    public final Map<K, V> asMutableMap() {
        return new MutableMapWrapper();
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\b\u0004\u0018\u00002\u00120\u0001R\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00112\u0014\u0010\u0017\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H\u0016J\u0017\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR&\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/collection/MutableScatterMap$MutableMapWrapper;", "Landroidx/collection/ScatterMap$MapWrapper;", "Landroidx/collection/ScatterMap;", "", "(Landroidx/collection/MutableScatterMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "values", "", "getValues", "()Ljava/util/Collection;", "clear", "", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ScatterMap.kt */
    private final class MutableMapWrapper extends ScatterMap<K, V>.MapWrapper implements Map<K, V>, KMutableMap {
        public MutableMapWrapper() {
            super();
        }

        public Set<Map.Entry<K, V>> getEntries() {
            return new MutableScatterMap$MutableMapWrapper$entries$1(MutableScatterMap.this);
        }

        public Set<K> getKeys() {
            return new MutableScatterMap$MutableMapWrapper$keys$1(MutableScatterMap.this);
        }

        public Collection<V> getValues() {
            return new MutableScatterMap$MutableMapWrapper$values$1(MutableScatterMap.this);
        }

        public void clear() {
            MutableScatterMap.this.clear();
        }

        public V remove(Object obj) {
            return MutableScatterMap.this.remove(obj);
        }

        public V put(K k, V v) {
            return MutableScatterMap.this.put(k, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            Intrinsics.checkNotNullParameter(map, Constants.MessagePayloadKeys.FROM);
            for (Map.Entry next : map.entrySet()) {
                put(next.getKey(), next.getValue());
            }
        }
    }

    public final void putAll(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, Constants.MessagePayloadKeys.FROM);
        for (Map.Entry next : map.entrySet()) {
            set(next.getKey(), next.getValue());
        }
    }

    public final void putAll(ScatterMap<K, V> scatterMap) {
        Intrinsics.checkNotNullParameter(scatterMap, Constants.MessagePayloadKeys.FROM);
        Object[] objArr = scatterMap.keys;
        Object[] objArr2 = scatterMap.values;
        long[] jArr = scatterMap.metadata;
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
                            set(objArr[i4], objArr2[i4]);
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

    public final void minusAssign(ScatterSet<K> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "keys");
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            remove(objArr[(i << 3) + i3]);
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

    public final void minusAssign(ObjectList<K> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "keys");
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(objArr[i2]);
        }
    }

    public final int findInsertIndex(K k) {
        int i;
        K k2 = k;
        if (k2 != null) {
            i = k.hashCode();
        } else {
            i = 0;
        }
        int i2 = i * ScatterMapKt.MurmurHashC1;
        int i3 = i2 ^ (i2 << 16);
        int i4 = i3 >>> 7;
        int i5 = i3 & WorkQueueKt.MASK;
        int i6 = this._capacity;
        int i7 = i4 & i6;
        int i8 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i9 = i7 >> 3;
            int i10 = (i7 & 7) << 3;
            long j = ((jArr[i9 + 1] << (64 - i10)) & ((-((long) i10)) >> 63)) | (jArr[i9] >>> i10);
            long j2 = (long) i5;
            int i11 = i5;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & -9187201950435737472L; j4 != 0; j4 &= j4 - 1) {
                int numberOfTrailingZeros = (i7 + (Long.numberOfTrailingZeros(j4) >> 3)) & i6;
                if (Intrinsics.areEqual(this.keys[numberOfTrailingZeros], (Object) k2)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & -9187201950435737472L) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i4);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i4);
                }
                this._size++;
                int i12 = findFirstAvailableSlot >> 3;
                int i13 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit -= ((this.metadata[i12] >> i13) & 255) == 128 ? 1 : 0;
                long[] jArr2 = this.metadata;
                jArr2[i12] = (jArr2[i12] & (~(255 << i13))) | (j2 << i13);
                int i14 = this._capacity;
                int i15 = ((findFirstAvailableSlot - 7) & i14) + (i14 & 7);
                int i16 = i15 >> 3;
                int i17 = (i15 & 7) << 3;
                jArr2[i16] = ((~(255 << i17)) & jArr2[i16]) | (j2 << i17);
                return ~findFirstAvailableSlot;
            }
            i8 += 8;
            i7 = (i7 + i8) & i6;
            i5 = i11;
        }
    }
}
