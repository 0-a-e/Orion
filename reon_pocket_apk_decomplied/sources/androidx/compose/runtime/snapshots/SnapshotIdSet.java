package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB)\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\u001d\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u0012H\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0002J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "upperSet", "", "lowerSet", "lowerBound", "belowBound", "", "(JJI[I)V", "and", "bits", "andNot", "clear", "bit", "fastForEach", "", "block", "Lkotlin/Function1;", "get", "", "iterator", "", "lowest", "default", "or", "set", "toString", "", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotIdSet.kt */
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final SnapshotIdSet EMPTY = new SnapshotIdSet(0, 0, 0, (int[]) null);
    /* access modifiers changed from: private */
    public final int[] belowBound;
    /* access modifiers changed from: private */
    public final int lowerBound;
    /* access modifiers changed from: private */
    public final long lowerSet;
    /* access modifiers changed from: private */
    public final long upperSet;

    private SnapshotIdSet(long j, long j2, int i, int[] iArr) {
        this.upperSet = j;
        this.lowerSet = j2;
        this.lowerBound = i;
        this.belowBound = iArr;
    }

    public final boolean get(int i) {
        int[] iArr;
        int i2 = i - this.lowerBound;
        boolean z = true;
        if (i2 < 0 || i2 >= 64) {
            if (i2 < 64 || i2 >= 128) {
                if (i2 > 0 || (iArr = this.belowBound) == null) {
                    return false;
                }
                if (SnapshotIdSetKt.binarySearch(iArr, i) < 0) {
                    z = false;
                }
                return z;
            } else if (((1 << (i2 - 64)) & this.upperSet) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (((1 << i2) & this.lowerSet) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final SnapshotIdSet set(int i) {
        int i2;
        int[] iArr;
        int i3 = i;
        int i4 = this.lowerBound;
        int i5 = i3 - i4;
        long j = 0;
        if (i5 >= 0 && i5 < 64) {
            long j2 = 1 << i5;
            long j3 = this.lowerSet;
            if ((j3 & j2) == 0) {
                return new SnapshotIdSet(this.upperSet, j3 | j2, i4, this.belowBound);
            }
        } else if (i5 >= 64 && i5 < 128) {
            long j4 = 1 << (i5 - 64);
            long j5 = this.upperSet;
            if ((j5 & j4) == 0) {
                return new SnapshotIdSet(j5 | j4, this.lowerSet, i4, this.belowBound);
            }
        } else if (i5 < 128) {
            int[] iArr2 = this.belowBound;
            if (iArr2 == null) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, i4, new int[]{i});
            }
            int binarySearch = SnapshotIdSetKt.binarySearch(iArr2, i3);
            if (binarySearch < 0) {
                int i6 = -(binarySearch + 1);
                int length = iArr2.length;
                int[] iArr3 = new int[(length + 1)];
                ArraysKt.copyInto(iArr2, iArr3, 0, 0, i6);
                ArraysKt.copyInto(iArr2, iArr3, i6 + 1, i6, length);
                iArr3[i6] = i3;
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr3);
            }
        } else if (!get(i)) {
            long j6 = this.upperSet;
            long j7 = this.lowerSet;
            int i7 = this.lowerBound;
            int i8 = ((i3 + 1) / 64) * 64;
            List list = null;
            long j8 = j7;
            long j9 = j6;
            while (true) {
                if (i7 >= i8) {
                    i2 = i7;
                    break;
                }
                if (j8 != j) {
                    if (list == null) {
                        list = new ArrayList();
                        int[] iArr4 = this.belowBound;
                        if (iArr4 != null) {
                            for (int valueOf : iArr4) {
                                list.add(Integer.valueOf(valueOf));
                            }
                        }
                    }
                    for (int i9 = 0; i9 < 64; i9++) {
                        if (((1 << i9) & j8) != 0) {
                            list.add(Integer.valueOf(i9 + i7));
                        }
                    }
                    j = 0;
                }
                if (j9 == j) {
                    i2 = i8;
                    j8 = j;
                    break;
                }
                i7 += 64;
                j8 = j9;
                j9 = j;
            }
            if (list == null || (iArr = CollectionsKt.toIntArray(list)) == null) {
                iArr = this.belowBound;
            }
            return new SnapshotIdSet(j9, j8, i2, iArr).set(i3);
        }
        return this;
    }

    public final SnapshotIdSet clear(int i) {
        int[] iArr;
        int binarySearch;
        int i2 = i;
        int i3 = this.lowerBound;
        int i4 = i2 - i3;
        if (i4 >= 0 && i4 < 64) {
            long j = 1 << i4;
            long j2 = this.lowerSet;
            if ((j2 & j) != 0) {
                return new SnapshotIdSet(this.upperSet, j2 & (~j), i3, this.belowBound);
            }
        } else if (i4 >= 64 && i4 < 128) {
            long j3 = 1 << (i4 - 64);
            long j4 = this.upperSet;
            if ((j4 & j3) != 0) {
                return new SnapshotIdSet(j4 & (~j3), this.lowerSet, i3, this.belowBound);
            }
        } else if (i4 < 0 && (iArr = this.belowBound) != null && (binarySearch = SnapshotIdSetKt.binarySearch(iArr, i2)) >= 0) {
            int length = iArr.length;
            int i5 = length - 1;
            if (i5 == 0) {
                return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, (int[]) null);
            }
            int[] iArr2 = new int[i5];
            if (binarySearch > 0) {
                ArraysKt.copyInto(iArr, iArr2, 0, 0, binarySearch);
            }
            if (binarySearch < i5) {
                ArraysKt.copyInto(iArr, iArr2, binarySearch, binarySearch + 1, length);
            }
            return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, iArr2);
        }
        return this;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet snapshotIdSet) {
        int[] iArr;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        int i = snapshotIdSet.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && snapshotIdSet.belowBound == (iArr = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet & (~snapshotIdSet.upperSet), this.lowerSet & (~snapshotIdSet.lowerSet), i2, iArr);
        }
        Iterator it = snapshotIdSet.iterator();
        SnapshotIdSet snapshotIdSet3 = this;
        while (it.hasNext()) {
            SnapshotIdSet snapshotIdSet4 = snapshotIdSet3;
            snapshotIdSet3 = snapshotIdSet3.clear(((Number) it.next()).intValue());
        }
        SnapshotIdSet snapshotIdSet5 = snapshotIdSet3;
        return snapshotIdSet3;
    }

    public final SnapshotIdSet and(SnapshotIdSet snapshotIdSet) {
        int[] iArr;
        SnapshotIdSet<Number> snapshotIdSet2 = snapshotIdSet;
        SnapshotIdSet snapshotIdSet3 = EMPTY;
        if (Intrinsics.areEqual((Object) snapshotIdSet2, (Object) snapshotIdSet3) || Intrinsics.areEqual((Object) this, (Object) snapshotIdSet3)) {
            return snapshotIdSet3;
        }
        int i = snapshotIdSet2.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && snapshotIdSet2.belowBound == (iArr = this.belowBound)) {
            long j = this.upperSet;
            long j2 = snapshotIdSet2.upperSet;
            long j3 = this.lowerSet;
            long j4 = snapshotIdSet2.lowerSet;
            long j5 = j3 & j4;
            if ((j & j2) == 0 && j5 == 0 && iArr == null) {
                return snapshotIdSet3;
            }
            return new SnapshotIdSet(j2 & j, j3 & j4, i2, iArr);
        } else if (this.belowBound == null) {
            for (Number intValue : this) {
                int intValue2 = intValue.intValue();
                if (snapshotIdSet2.get(intValue2)) {
                    snapshotIdSet3 = snapshotIdSet3.set(intValue2);
                }
            }
            return snapshotIdSet3;
        } else {
            for (Number intValue3 : snapshotIdSet2) {
                int intValue4 = intValue3.intValue();
                if (get(intValue4)) {
                    snapshotIdSet3 = snapshotIdSet3.set(intValue4);
                }
            }
            return snapshotIdSet3;
        }
    }

    public final SnapshotIdSet or(SnapshotIdSet snapshotIdSet) {
        int[] iArr;
        SnapshotIdSet snapshotIdSet2 = EMPTY;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet;
        }
        int i = snapshotIdSet.lowerBound;
        int i2 = this.lowerBound;
        if (i == i2 && snapshotIdSet.belowBound == (iArr = this.belowBound)) {
            return new SnapshotIdSet(this.upperSet | snapshotIdSet.upperSet, this.lowerSet | snapshotIdSet.lowerSet, i2, iArr);
        }
        if (this.belowBound == null) {
            Iterator it = iterator();
            while (it.hasNext()) {
                snapshotIdSet = snapshotIdSet.set(((Number) it.next()).intValue());
            }
            return snapshotIdSet;
        }
        Iterator it2 = snapshotIdSet.iterator();
        SnapshotIdSet snapshotIdSet3 = this;
        while (it2.hasNext()) {
            SnapshotIdSet snapshotIdSet4 = snapshotIdSet3;
            snapshotIdSet3 = snapshotIdSet3.set(((Number) it2.next()).intValue());
        }
        SnapshotIdSet snapshotIdSet5 = snapshotIdSet3;
        return snapshotIdSet3;
    }

    public Iterator<Integer> iterator() {
        return SequencesKt.sequence(new SnapshotIdSet$iterator$1(this, (Continuation<? super SnapshotIdSet$iterator$1>) null)).iterator();
    }

    public final void fastForEach(Function1<? super Integer, Unit> function1) {
        int[] access$getBelowBound$p = this.belowBound;
        if (access$getBelowBound$p != null) {
            for (int valueOf : access$getBelowBound$p) {
                function1.invoke(Integer.valueOf(valueOf));
            }
        }
        if (this.lowerSet != 0) {
            for (int i = 0; i < 64; i++) {
                if ((this.lowerSet & (1 << i)) != 0) {
                    function1.invoke(Integer.valueOf(this.lowerBound + i));
                }
            }
        }
        if (this.upperSet != 0) {
            for (int i2 = 0; i2 < 64; i2++) {
                if ((this.upperSet & (1 << i2)) != 0) {
                    function1.invoke(Integer.valueOf(i2 + 64 + this.lowerBound));
                }
            }
        }
    }

    public final int lowest(int i) {
        int[] iArr = this.belowBound;
        if (iArr != null) {
            return iArr[0];
        }
        long j = this.lowerSet;
        if (j != 0) {
            return this.lowerBound + SnapshotIdSetKt.lowestBitOf(j);
        }
        long j2 = this.upperSet;
        return j2 != 0 ? this.lowerBound + 64 + SnapshotIdSetKt.lowestBitOf(j2) : i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" [");
        Iterable<Number> iterable = this;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Number intValue : iterable) {
            arrayList.add(String.valueOf(intValue.intValue()));
        }
        sb.append(ListUtilsKt.fastJoinToString$default((List) arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        sb.append(']');
        return sb.toString();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotIdSet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.EMPTY;
        }
    }
}
