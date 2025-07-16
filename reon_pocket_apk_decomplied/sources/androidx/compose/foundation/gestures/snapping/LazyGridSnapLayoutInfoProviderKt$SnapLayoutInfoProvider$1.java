package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"androidx/compose/foundation/gestures/snapping/LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "averageItemSize", "", "calculateApproachOffset", "initialVelocity", "calculateSnappingOffset", "currentVelocity", "singleAxisItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridItemInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridSnapLayoutInfoProvider.kt */
public final class LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ LazyGridState $lazyGridState;
    final /* synthetic */ SnapPositionInLayout $positionInLayout;

    LazyGridSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(LazyGridState lazyGridState, SnapPositionInLayout snapPositionInLayout) {
        this.$lazyGridState = lazyGridState;
        this.$positionInLayout = snapPositionInLayout;
    }

    private final LazyGridLayoutInfo getLayoutInfo() {
        return this.$lazyGridState.getLayoutInfo();
    }

    public float calculateApproachOffset(float f) {
        float coerceAtLeast = RangesKt.coerceAtLeast((((float) Math.floor((double) (Math.abs(Math.abs(DecayAnimationSpecKt.calculateTargetValue(SplineBasedDecayKt.splineBasedDecay(this.$lazyGridState.getDensity$foundation_release()), 0.0f, f))) / averageItemSize()))) * averageItemSize()) - averageItemSize(), 0.0f);
        return coerceAtLeast == 0.0f ? coerceAtLeast : coerceAtLeast * Math.signum(f);
    }

    private final List<LazyGridItemInfo> singleAxisItems() {
        List<LazyGridItemInfo> visibleItemsInfo = this.$lazyGridState.getLayoutInfo().getVisibleItemsInfo();
        LazyGridState lazyGridState = this.$lazyGridState;
        ArrayList arrayList = new ArrayList(visibleItemsInfo.size());
        int size = visibleItemsInfo.size();
        for (int i = 0; i < size; i++) {
            LazyGridItemInfo lazyGridItemInfo = visibleItemsInfo.get(i);
            LazyGridItemInfo lazyGridItemInfo2 = lazyGridItemInfo;
            if (lazyGridState.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
                if (lazyGridItemInfo2.getRow() != 0) {
                }
            } else if (lazyGridItemInfo2.getColumn() != 0) {
            }
            arrayList.add(lazyGridItemInfo);
        }
        return arrayList;
    }

    public float calculateSnappingOffset(float f) {
        List<LazyGridItemInfo> visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
        SnapPositionInLayout snapPositionInLayout = this.$positionInLayout;
        int size = visibleItemsInfo.size();
        float f2 = Float.NEGATIVE_INFINITY;
        float f3 = Float.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            LazyGridItemInfo lazyGridItemInfo = visibleItemsInfo.get(i);
            float calculateDistanceToDesiredSnapPosition = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(LazyGridSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo, getLayoutInfo().getOrientation()), lazyGridItemInfo.getIndex(), snapPositionInLayout);
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f2) {
                f2 = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f3) {
                f3 = calculateDistanceToDesiredSnapPosition;
            }
        }
        return SnapFlingBehaviorKt.m501calculateFinalOffsetFhqu1e0(LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(this.$lazyGridState.getDensity$foundation_release(), f), f2, f3);
    }

    public final float averageItemSize() {
        int i;
        List<LazyGridItemInfo> singleAxisItems = singleAxisItems();
        if (!(!singleAxisItems.isEmpty())) {
            return 0.0f;
        }
        int i2 = 0;
        if (getLayoutInfo().getOrientation() == Orientation.Vertical) {
            int size = singleAxisItems.size();
            i = 0;
            while (i2 < size) {
                i += IntSize.m6789getHeightimpl(singleAxisItems.get(i2).m838getSizeYbymL2g());
                i2++;
            }
        } else {
            int size2 = singleAxisItems.size();
            int i3 = 0;
            while (i2 < size2) {
                i3 = i + IntSize.m6790getWidthimpl(singleAxisItems.get(i2).m838getSizeYbymL2g());
                i2++;
            }
        }
        return ((float) i) / ((float) singleAxisItems.size());
    }
}
