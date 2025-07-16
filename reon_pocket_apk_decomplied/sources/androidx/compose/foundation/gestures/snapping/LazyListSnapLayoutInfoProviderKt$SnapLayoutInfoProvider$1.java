package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, d2 = {"androidx/compose/foundation/gestures/snapping/LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "averageItemSize", "", "calculateApproachOffset", "initialVelocity", "calculateSnappingOffset", "currentVelocity", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListSnapLayoutInfoProvider.kt */
public final class LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ SnapPositionInLayout $positionInLayout;

    LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$1(LazyListState lazyListState, SnapPositionInLayout snapPositionInLayout) {
        this.$lazyListState = lazyListState;
        this.$positionInLayout = snapPositionInLayout;
    }

    private final LazyListLayoutInfo getLayoutInfo() {
        return this.$lazyListState.getLayoutInfo();
    }

    public float calculateApproachOffset(float f) {
        float coerceAtLeast = RangesKt.coerceAtLeast((((float) Math.floor((double) (Math.abs(Math.abs(DecayAnimationSpecKt.calculateTargetValue(SplineBasedDecayKt.splineBasedDecay(this.$lazyListState.getDensity$foundation_release()), 0.0f, f))) / averageItemSize()))) * averageItemSize()) - averageItemSize(), 0.0f);
        return coerceAtLeast == 0.0f ? coerceAtLeast : coerceAtLeast * Math.signum(f);
    }

    public float calculateSnappingOffset(float f) {
        List<LazyListItemInfo> visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
        SnapPositionInLayout snapPositionInLayout = this.$positionInLayout;
        int size = visibleItemsInfo.size();
        float f2 = Float.NEGATIVE_INFINITY;
        float f3 = Float.POSITIVE_INFINITY;
        for (int i = 0; i < size; i++) {
            LazyListItemInfo lazyListItemInfo = visibleItemsInfo.get(i);
            float calculateDistanceToDesiredSnapPosition = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(LazyListSnapLayoutInfoProviderKt.getSingleAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), lazyListItemInfo.getSize(), lazyListItemInfo.getOffset(), lazyListItemInfo.getIndex(), snapPositionInLayout);
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f2) {
                f2 = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f3) {
                f3 = calculateDistanceToDesiredSnapPosition;
            }
        }
        return SnapFlingBehaviorKt.m501calculateFinalOffsetFhqu1e0(LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(this.$lazyListState.getDensity$foundation_release(), f), f2, f3);
    }

    public final float averageItemSize() {
        LazyListLayoutInfo layoutInfo = getLayoutInfo();
        if (!(!layoutInfo.getVisibleItemsInfo().isEmpty())) {
            return 0.0f;
        }
        List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += visibleItemsInfo.get(i2).getSize();
        }
        return ((float) i) / ((float) layoutInfo.getVisibleItemsInfo().size());
    }
}
