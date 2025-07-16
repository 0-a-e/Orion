package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u001a\u0014\u0010\u000b\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0001*\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"singleAxisViewportSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "lazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "positionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "offsetOnMainAxis", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "sizeOnMainAxis", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridSnapLayoutInfoProvider.kt */
public final class LazyGridSnapLayoutInfoProviderKt {
    public static /* synthetic */ SnapLayoutInfoProvider SnapLayoutInfoProvider$default(LazyGridState lazyGridState, SnapPositionInLayout snapPositionInLayout, int i, Object obj) {
        if ((i & 2) != 0) {
            snapPositionInLayout = SnapPositionInLayout.Companion.getCenterToCenter();
        }
        return SnapLayoutInfoProvider(lazyGridState, snapPositionInLayout);
    }

    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(LazyGridState lazyGridState, SnapPositionInLayout snapPositionInLayout) {
        return new LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(lazyGridState, snapPositionInLayout);
    }

    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        if (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical) {
            return IntSize.m6789getHeightimpl(lazyGridLayoutInfo.m840getViewportSizeYbymL2g());
        }
        return IntSize.m6790getWidthimpl(lazyGridLayoutInfo.m840getViewportSizeYbymL2g());
    }

    public static final int sizeOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return IntSize.m6789getHeightimpl(lazyGridItemInfo.m838getSizeYbymL2g());
        }
        return IntSize.m6790getWidthimpl(lazyGridItemInfo.m838getSizeYbymL2g());
    }

    public static final int offsetOnMainAxis(LazyGridItemInfo lazyGridItemInfo, Orientation orientation) {
        if (orientation == Orientation.Vertical) {
            return IntOffset.m6749getYimpl(lazyGridItemInfo.m837getOffsetnOccac());
        }
        return IntOffset.m6748getXimpl(lazyGridItemInfo.m837getOffsetnOccac());
    }
}
