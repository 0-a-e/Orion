package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\fH\u0016R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/layout/NearestRangeKeyIndexMap;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "nearestRange", "Lkotlin/ranges/IntRange;", "intervalContent", "Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;", "(Lkotlin/ranges/IntRange;Landroidx/compose/foundation/lazy/layout/LazyLayoutIntervalContent;)V", "keys", "", "", "[Ljava/lang/Object;", "keysStartIndex", "", "map", "Landroidx/collection/ObjectIntMap;", "getIndex", "key", "getKey", "index", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutKeyIndexMap.kt */
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Object[] keys;
    /* access modifiers changed from: private */
    public final int keysStartIndex;
    private final ObjectIntMap<Object> map;

    public NearestRangeKeyIndexMap(IntRange intRange, LazyLayoutIntervalContent<?> lazyLayoutIntervalContent) {
        IntervalList<?> intervals = lazyLayoutIntervalContent.getIntervals();
        int first = intRange.getFirst();
        if (first >= 0) {
            int min = Math.min(intRange.getLast(), intervals.getSize() - 1);
            if (min < first) {
                this.map = ObjectIntMapKt.emptyObjectIntMap();
                this.keys = new Object[0];
                this.keysStartIndex = 0;
                return;
            }
            int i = (min - first) + 1;
            this.keys = new Object[i];
            this.keysStartIndex = first;
            MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(i);
            intervals.forEach(first, min, new NearestRangeKeyIndexMap$2$1(first, min, mutableObjectIntMap, this));
            this.map = mutableObjectIntMap;
            return;
        }
        throw new IllegalStateException("negative nearestRange.first".toString());
    }

    public int getIndex(Object obj) {
        ObjectIntMap<Object> objectIntMap = this.map;
        int findKeyIndex = objectIntMap.findKeyIndex(obj);
        if (findKeyIndex >= 0) {
            return objectIntMap.values[findKeyIndex];
        }
        return -1;
    }

    public Object getKey(int i) {
        Object[] objArr = this.keys;
        int i2 = i - this.keysStartIndex;
        if (i2 < 0 || i2 > ArraysKt.getLastIndex((T[]) objArr)) {
            return null;
        }
        return objArr[i2];
    }
}
