package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0003J\u0016\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0015\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006#"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "index", "getIndex", "()I", "setIndex", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableIntState;", "lastKnownFirstItemKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollOffset", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridScrollPosition.kt */
public final class LazyGridScrollPosition {
    public static final int $stable = 8;
    private boolean hadFirstNotEmptyLayout;
    private final MutableIntState index$delegate;
    private Object lastKnownFirstItemKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final MutableIntState scrollOffset$delegate;

    public LazyGridScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyGridScrollPosition(int i, int i2) {
        this.index$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.scrollOffset$delegate = SnapshotIntStateKt.mutableIntStateOf(i2);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 90, 200);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyGridScrollPosition(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    private final void setIndex(int i) {
        this.index$delegate.setIntValue(i);
    }

    public final int getIndex() {
        return this.index$delegate.getIntValue();
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

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) kotlin.collections.ArraysKt.firstOrNull((T[]) (r0 = r0.getItems()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r4) {
        /*
            r3 = this;
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r0 = r4.getFirstVisibleLine()
            if (r0 == 0) goto L_0x0019
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r0 = r0.getItems()
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = kotlin.collections.ArraysKt.firstOrNull((T[]) r0)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r0 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r0
            if (r0 == 0) goto L_0x0019
            java.lang.Object r0 = r0.getKey()
            goto L_0x001a
        L_0x0019:
            r0 = 0
        L_0x001a:
            r3.lastKnownFirstItemKey = r0
            boolean r0 = r3.hadFirstNotEmptyLayout
            if (r0 != 0) goto L_0x0026
            int r0 = r4.getTotalItemsCount()
            if (r0 <= 0) goto L_0x0050
        L_0x0026:
            r0 = 1
            r3.hadFirstNotEmptyLayout = r0
            int r0 = r4.getFirstVisibleLineScrollOffset()
            float r1 = (float) r0
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0051
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r4 = r4.getFirstVisibleLine()
            if (r4 == 0) goto L_0x004c
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r4 = r4.getItems()
            if (r4 == 0) goto L_0x004c
            java.lang.Object r4 = kotlin.collections.ArraysKt.firstOrNull((T[]) r4)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r4 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r4
            if (r4 == 0) goto L_0x004c
            int r4 = r4.getIndex()
            goto L_0x004d
        L_0x004c:
            r4 = 0
        L_0x004d:
            r3.update(r4, r0)
        L_0x0050:
            return
        L_0x0051:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = "scrollOffset should be non-negative ("
            r4.<init>(r1)
            r4.append(r0)
            r0 = 41
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridScrollPosition.updateFromMeasureResult(androidx.compose.foundation.lazy.grid.LazyGridMeasureResult):void");
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

    public final int updateScrollPositionIfTheFirstItemWasMoved(LazyGridItemProvider lazyGridItemProvider, int i) {
        int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyGridItemProvider, this.lastKnownFirstItemKey, i);
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
