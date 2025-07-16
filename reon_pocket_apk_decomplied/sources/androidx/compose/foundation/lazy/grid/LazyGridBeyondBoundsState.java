package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.ui.layout.Remeasurement;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridBeyondBoundsState;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "firstPlacedIndex", "", "getFirstPlacedIndex", "()I", "hasVisibleItems", "", "getHasVisibleItems", "()Z", "itemCount", "getItemCount", "lastPlacedIndex", "getLastPlacedIndex", "getState", "()Landroidx/compose/foundation/lazy/grid/LazyGridState;", "remeasure", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridBeyondBoundsModifier.kt */
public final class LazyGridBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public static final int $stable = 0;
    private final LazyGridState state;

    public LazyGridBeyondBoundsState(LazyGridState lazyGridState) {
        this.state = lazyGridState;
    }

    public final LazyGridState getState() {
        return this.state;
    }

    public void remeasure() {
        Remeasurement remeasurement$foundation_release = this.state.getRemeasurement$foundation_release();
        if (remeasurement$foundation_release != null) {
            remeasurement$foundation_release.forceRemeasure();
        }
    }

    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    public boolean getHasVisibleItems() {
        return !this.state.getLayoutInfo().getVisibleItemsInfo().isEmpty();
    }

    public int getFirstPlacedIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    public int getLastPlacedIndex() {
        return ((LazyGridItemInfo) CollectionsKt.last(this.state.getLayoutInfo().getVisibleItemsInfo())).getIndex();
    }
}
