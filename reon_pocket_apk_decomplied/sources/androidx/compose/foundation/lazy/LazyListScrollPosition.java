package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0003H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "updateScrollOffset", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListScrollPosition.kt */
public final class LazyListScrollPosition {
    public static final int $stable = 8;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    public LazyListScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyListScrollPosition(int i, int i2) {
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(i2);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 30, 100);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyListScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    public final void setIndex(int i) {
        this.index$delegate.setIntValue(i);
    }

    private final void setScrollOffset(int i) {
        this.scrollOffset$delegate.setIntValue(i);
    }

    public final int getScrollOffset() {
        return this.scrollOffset$delegate.getIntValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final void updateFromMeasureResult(LazyListMeasureResult lazyListMeasureResult) {
        LazyListMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        this.lastKnownFirstItemKey = firstVisibleItem != null ? firstVisibleItem.getKey() : null;
        if (this.hadFirstNotEmptyLayout || lazyListMeasureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleItemScrollOffset = lazyListMeasureResult.getFirstVisibleItemScrollOffset();
            if (((float) firstVisibleItemScrollOffset) >= 0.0f) {
                LazyListMeasuredItem firstVisibleItem2 = lazyListMeasureResult.getFirstVisibleItem();
                update(firstVisibleItem2 != null ? firstVisibleItem2.getIndex() : 0, firstVisibleItemScrollOffset);
                return;
            }
            throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleItemScrollOffset + ')').toString());
        }
    }

    public final void updateScrollOffset(int i) {
        if (((float) i) >= 0.0f) {
            setScrollOffset(i);
            return;
        }
        throw new IllegalStateException(("scrollOffset should be non-negative (" + i + ')').toString());
    }

    public final void requestPosition(int i, int i2) {
        update(i, i2);
        this.lastKnownFirstItemKey = null;
    }

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyListItemProvider lazyListItemProvider, int i) {
        int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyListItemProvider, this.lastKnownFirstItemKey, i);
        if (i != findIndexByKey) {
            setIndex(findIndexByKey);
            this.nearestRangeState.update(i);
        }
        return findIndexByKey;
    }

    private final void update(int i, int i2) {
        if (((float) i) >= 0.0f) {
            setIndex(i);
            this.nearestRangeState.update(i);
            setScrollOffset(i2);
            return;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
    }
}
