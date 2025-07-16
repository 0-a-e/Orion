package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\u0016\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003J\u0016\u0010'\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0005J\u0018\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0005H\u0002J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0005J\u000e\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u000200R+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00058F@BX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00061"}, d2 = {"Landroidx/compose/foundation/pager/PagerScrollPosition;", "", "currentPage", "", "currentPageOffsetFraction", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "(IFLandroidx/compose/foundation/pager/PagerState;)V", "<set-?>", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "currentPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "currentPageOffsetFraction$delegate", "Landroidx/compose/runtime/MutableFloatState;", "hadFirstNotEmptyLayout", "", "lastKnownCurrentPageKey", "nearestRangeState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getNearestRangeState", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutNearestRangeState;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "applyScrollDelta", "", "delta", "currentScrollOffset", "matchPageWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "index", "requestPosition", "scrollOffsetFraction", "update", "page", "pageOffsetFraction", "updateCurrentPageOffsetFraction", "offsetFraction", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerScrollPosition.kt */
public final class PagerScrollPosition {
    public static final int $stable = 8;
    private final MutableIntState currentPage$delegate;
    private final MutableFloatState currentPageOffsetFraction$delegate;
    private boolean hadFirstNotEmptyLayout;
    private Object lastKnownCurrentPageKey;
    private final LazyLayoutNearestRangeState nearestRangeState;
    private final PagerState state;

    public PagerScrollPosition(int i, float f, PagerState pagerState) {
        this.state = pagerState;
        this.currentPage$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.currentPageOffsetFraction$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.nearestRangeState = new LazyLayoutNearestRangeState(i, 30, 100);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PagerScrollPosition(int i, float f, PagerState pagerState, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0.0f : f, pagerState);
    }

    public final PagerState getState() {
        return this.state;
    }

    private final void setCurrentPage(int i) {
        this.currentPage$delegate.setIntValue(i);
    }

    public final int getCurrentPage() {
        return this.currentPage$delegate.getIntValue();
    }

    private final void setCurrentPageOffsetFraction(float f) {
        this.currentPageOffsetFraction$delegate.setFloatValue(f);
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction$delegate.getFloatValue();
    }

    public final LazyLayoutNearestRangeState getNearestRangeState() {
        return this.nearestRangeState;
    }

    public final void updateFromMeasureResult(PagerMeasureResult pagerMeasureResult) {
        MeasuredPage currentPage = pagerMeasureResult.getCurrentPage();
        this.lastKnownCurrentPageKey = currentPage != null ? currentPage.getKey() : null;
        if (this.hadFirstNotEmptyLayout || (!pagerMeasureResult.getVisiblePagesInfo().isEmpty())) {
            this.hadFirstNotEmptyLayout = true;
            MeasuredPage currentPage2 = pagerMeasureResult.getCurrentPage();
            update(currentPage2 != null ? currentPage2.getIndex() : 0, pagerMeasureResult.getCurrentPageOffsetFraction());
        }
    }

    public final void requestPosition(int i, float f) {
        update(i, f);
        this.lastKnownCurrentPageKey = null;
    }

    public final int matchPageWithKey(PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i) {
        int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(pagerLazyLayoutItemProvider, this.lastKnownCurrentPageKey, i);
        if (i != findIndexByKey) {
            setCurrentPage(findIndexByKey);
            this.nearestRangeState.update(i);
        }
        return findIndexByKey;
    }

    private final void update(int i, float f) {
        setCurrentPage(i);
        this.nearestRangeState.update(i);
        if (Math.abs(f) == 0.0f) {
            f = 0.0f;
        }
        setCurrentPageOffsetFraction(f);
    }

    public final void updateCurrentPageOffsetFraction(float f) {
        setCurrentPageOffsetFraction(f);
    }

    public final int currentScrollOffset() {
        return MathKt.roundToInt((((float) getCurrentPage()) + getCurrentPageOffsetFraction()) * ((float) this.state.getPageSizeWithSpacing$foundation_release()));
    }

    public final void applyScrollDelta(int i) {
        float f;
        if (this.state.getPageSizeWithSpacing$foundation_release() == 0) {
            f = 0.0f;
        } else {
            f = ((float) i) / ((float) this.state.getPageSizeWithSpacing$foundation_release());
        }
        setCurrentPageOffsetFraction(getCurrentPageOffsetFraction() + f);
    }
}
