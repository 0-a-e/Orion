package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\fJ\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002J\u0018\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u0002H\u0016J\u0016\u00102\u001a\u0002032\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0007J\u0018\u00104\u001a\u0002032\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002J\u000e\u00105\u001a\u0002032\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u0002032\u0006\u0010(\u001a\u00020\u0002J\u0018\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020;2\u0006\u0010\u0017\u001a\u00020\u0002H\u0007R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R+\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028F@BX\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R+\u0010$\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@BX\u0002¢\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R+\u0010(\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00028F@BX\u0002¢\u0006\u0012\n\u0004\b+\u0010\u001d\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001b¨\u0006<"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "", "initialIndices", "initialOffsets", "fillIndices", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "targetIndex", "laneCount", "([I[ILkotlin/jvm/functions/Function2;)V", "hadFirstNotEmptyLayout", "", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "indices", "getIndices", "()[I", "setIndices", "([I)V", "indices$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "scrollOffsets", "getScrollOffsets", "setScrollOffsets", "scrollOffsets$delegate", "calculateFirstVisibleIndex", "calculateFirstVisibleScrollOffset", "offsets", "equivalent", "a", "b", "requestPosition", "", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "updateScrollOffset", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridScrollPosition.kt */
public final class LazyStaggeredGridScrollPosition implements SnapshotMutationPolicy<int[]> {
    public static final int $stable = 8;
    private final Function2<Integer, Integer, int[]> fillIndices;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private final MutableState indices$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;
    private final MutableState scrollOffsets$delegate;

    public /* synthetic */ Object merge(Object obj, Object obj2, Object obj3) {
        return SnapshotMutationPolicy.CC.$default$merge(this, obj, obj2, obj3);
    }

    public LazyStaggeredGridScrollPosition(int[] iArr, int[] iArr2, Function2<? super Integer, ? super Integer, int[]> function2) {
        this.fillIndices = function2;
        SnapshotMutationPolicy snapshotMutationPolicy = this;
        this.indices$delegate = SnapshotStateKt.mutableStateOf(iArr, snapshotMutationPolicy);
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(calculateFirstVisibleIndex(iArr));
        this.scrollOffsets$delegate = SnapshotStateKt.mutableStateOf(iArr2, snapshotMutationPolicy);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(calculateFirstVisibleScrollOffset(iArr, iArr2));
        Integer minOrNull = ArraysKt.minOrNull(iArr);
        this.nearestRangeState = new LazyLayoutNearestRangeState(minOrNull != null ? minOrNull.intValue() : 0, 90, 200);
    }

    private final void setIndices(int[] iArr) {
        this.indices$delegate.setValue(iArr);
    }

    public final int[] getIndices() {
        return (int[]) this.indices$delegate.getValue();
    }

    private final void setIndex(int i) {
        this.index$delegate.setIntValue(i);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    private final void setScrollOffsets(int[] iArr) {
        this.scrollOffsets$delegate.setValue(iArr);
    }

    public final int[] getScrollOffsets() {
        return (int[]) this.scrollOffsets$delegate.getValue();
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setIntValue(i);
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    private final int calculateFirstVisibleScrollOffset(int[] iArr, int[] iArr2) {
        int calculateFirstVisibleIndex = calculateFirstVisibleIndex(iArr);
        int length = iArr2.length;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < length; i2++) {
            if (iArr[i2] == calculateFirstVisibleIndex) {
                i = Math.min(i, iArr2[i2]);
            }
        }
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final void updateFromMeasureResult(LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult) {
        Object obj;
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem;
        Snapshot makeCurrent;
        int calculateFirstVisibleIndex = calculateFirstVisibleIndex(lazyStaggeredGridMeasureResult.getFirstVisibleItemIndices());
        List<LazyStaggeredGridMeasuredItem> visibleItemsInfo = lazyStaggeredGridMeasureResult.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i = 0;
        while (true) {
            obj = null;
            if (i >= size) {
                lazyStaggeredGridMeasuredItem = null;
                break;
            }
            lazyStaggeredGridMeasuredItem = visibleItemsInfo.get(i);
            if (lazyStaggeredGridMeasuredItem.getIndex() == calculateFirstVisibleIndex) {
                break;
            }
            i++;
        }
        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = lazyStaggeredGridMeasuredItem;
        if (lazyStaggeredGridMeasuredItem2 != null) {
            obj = lazyStaggeredGridMeasuredItem2.getKey();
        }
        this.lastKnownFirstItemKey = obj;
        this.nearestRangeState.update(calculateFirstVisibleIndex);
        if (this.hadFirstNotEmptyLayout || lazyStaggeredGridMeasureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                update(lazyStaggeredGridMeasureResult.getFirstVisibleItemIndices(), lazyStaggeredGridMeasureResult.getFirstVisibleItemScrollOffsets());
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
            } catch (Throwable th) {
                createNonObservableSnapshot.dispose();
                throw th;
            }
        }
    }

    public final void updateScrollOffset(int[] iArr) {
        setScrollOffsets(iArr);
        setScrollOffset(calculateFirstVisibleScrollOffset(getIndices(), iArr));
    }

    public final void requestPosition(int i, int i2) {
        int[] invoke = this.fillIndices.invoke(Integer.valueOf(i), Integer.valueOf(getIndices().length));
        int length = invoke.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = i2;
        }
        update(invoke, iArr);
        this.nearestRangeState.update(i);
        this.lastKnownFirstItemKey = null;
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved(LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr) {
        Object obj = this.lastKnownFirstItemKey;
        int i = 0;
        Integer orNull = ArraysKt.getOrNull(iArr, 0);
        if (orNull != null) {
            i = orNull.intValue();
        }
        int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyLayoutItemProvider, obj, i);
        if (ArraysKt.contains(iArr, findIndexByKey)) {
            return iArr;
        }
        this.nearestRangeState.update(findIndexByKey);
        int[] invoke = this.fillIndices.invoke(Integer.valueOf(findIndexByKey), Integer.valueOf(iArr.length));
        setIndices(invoke);
        setIndex(calculateFirstVisibleIndex(invoke));
        return invoke;
    }

    private final void update(int[] iArr, int[] iArr2) {
        setIndices(iArr);
        setIndex(calculateFirstVisibleIndex(iArr));
        setScrollOffsets(iArr2);
        setScrollOffset(calculateFirstVisibleScrollOffset(iArr, iArr2));
    }

    public boolean equivalent(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    private final int calculateFirstVisibleIndex(int[] iArr) {
        int i = Integer.MAX_VALUE;
        for (int i2 : iArr) {
            if (i2 <= 0) {
                return 0;
            }
            if (i > i2) {
                i = i2;
            }
        }
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }
}
