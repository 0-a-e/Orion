package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.ui.layout.Remeasurement;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/pager/PagerBeyondBoundsState;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "beyondBoundsPageCount", "", "(Landroidx/compose/foundation/pager/PagerState;I)V", "firstPlacedIndex", "getFirstPlacedIndex", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "itemCount", "getItemCount", "lastPlacedIndex", "getLastPlacedIndex", "remeasure", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerBeyondBoundsModifier.kt */
public final class PagerBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public static final int $stable = 0;
    private final int beyondBoundsPageCount;
    private final PagerState state;

    public PagerBeyondBoundsState(PagerState pagerState, int i) {
        this.state = pagerState;
        this.beyondBoundsPageCount = i;
    }

    public void remeasure() {
        Remeasurement remeasurement$foundation_release = this.state.getRemeasurement$foundation_release();
        if (remeasurement$foundation_release != null) {
            remeasurement$foundation_release.forceRemeasure();
        }
    }

    public int getItemCount() {
        return this.state.getPageCount();
    }

    public boolean getHasVisibleItems() {
        return !this.state.getLayoutInfo().getVisiblePagesInfo().isEmpty();
    }

    public int getFirstPlacedIndex() {
        return Math.max(0, this.state.getFirstVisiblePage$foundation_release() - this.beyondBoundsPageCount);
    }

    public int getLastPlacedIndex() {
        return Math.min(getItemCount() - 1, ((PageInfo) CollectionsKt.last(this.state.getLayoutInfo().getVisiblePagesInfo())).getIndex() + this.beyondBoundsPageCount);
    }
}
