package androidx.compose.foundation.pager;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fH\u0002J\n\u0010\r\u001a\u00020\u000e*\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"androidx/compose/foundation/pager/PagerKt$SnapLayoutInfoProvider$1", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "calculateApproachOffset", "", "initialVelocity", "calculateSnappingOffset", "currentVelocity", "searchForSnappingBounds", "Lkotlin/Pair;", "isValidDistance", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Pager.kt */
public final class PagerKt$SnapLayoutInfoProvider$1 implements SnapLayoutInfoProvider {
    final /* synthetic */ DecayAnimationSpec<Float> $decayAnimationSpec;
    final /* synthetic */ PagerSnapDistance $pagerSnapDistance;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ float $snapPositionalThreshold;

    public final boolean isValidDistance(float f) {
        return (f == Float.POSITIVE_INFINITY || f == Float.NEGATIVE_INFINITY) ? false : true;
    }

    PagerKt$SnapLayoutInfoProvider$1(PagerState pagerState, float f, DecayAnimationSpec<Float> decayAnimationSpec, PagerSnapDistance pagerSnapDistance) {
        this.$pagerState = pagerState;
        this.$snapPositionalThreshold = f;
        this.$decayAnimationSpec = decayAnimationSpec;
        this.$pagerSnapDistance = pagerSnapDistance;
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return this.$pagerState.getLayoutInfo();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float calculateSnappingOffset(float r7) {
        /*
            r6 = this;
            kotlin.Pair r0 = r6.searchForSnappingBounds()
            java.lang.Object r1 = r0.component1()
            java.lang.Number r1 = (java.lang.Number) r1
            float r1 = r1.floatValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            androidx.compose.foundation.pager.PagerState r2 = r6.$pagerState
            boolean r2 = androidx.compose.foundation.pager.PagerKt.isScrollingForward(r2)
            androidx.compose.foundation.pager.PagerState r3 = r6.$pagerState
            float r3 = androidx.compose.foundation.pager.PagerKt.dragGestureDelta(r3)
            androidx.compose.foundation.pager.PagerLayoutInfo r4 = r6.getLayoutInfo()
            int r4 = r4.getPageSize()
            float r4 = (float) r4
            float r3 = r3 / r4
            int r4 = (int) r3
            float r4 = (float) r4
            float r3 = r3 - r4
            androidx.compose.foundation.pager.PagerState r4 = r6.$pagerState
            androidx.compose.ui.unit.Density r4 = r4.getDensity$foundation_release()
            int r7 = androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(r4, r7)
            androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r4 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.Companion
            int r4 = r4.m498getClosestItembbeMdSM()
            boolean r4 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m494equalsimpl0(r7, r4)
            r5 = 0
            if (r4 == 0) goto L_0x007d
            float r7 = java.lang.Math.abs(r3)
            float r3 = r6.$snapPositionalThreshold
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0055
            if (r2 == 0) goto L_0x0099
            goto L_0x0089
        L_0x0055:
            androidx.compose.foundation.pager.PagerState r7 = r6.$pagerState
            float r7 = r7.getCurrentPageOffsetFraction()
            float r7 = java.lang.Math.abs(r7)
            androidx.compose.foundation.pager.PagerState r3 = r6.$pagerState
            float r3 = r3.getPositionThresholdFraction$foundation_release()
            float r3 = java.lang.Math.abs(r3)
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x0070
            if (r2 == 0) goto L_0x0089
            goto L_0x0099
        L_0x0070:
            float r7 = java.lang.Math.abs(r1)
            float r2 = java.lang.Math.abs(r0)
            int r7 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x0089
            goto L_0x0099
        L_0x007d:
            androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r2 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.Companion
            int r2 = r2.m499getNextItembbeMdSM()
            boolean r2 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m494equalsimpl0(r7, r2)
            if (r2 == 0) goto L_0x008b
        L_0x0089:
            r1 = r0
            goto L_0x0099
        L_0x008b:
            androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r0 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.Companion
            int r0 = r0.m500getPreviousItembbeMdSM()
            boolean r7 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.m494equalsimpl0(r7, r0)
            if (r7 == 0) goto L_0x0098
            goto L_0x0099
        L_0x0098:
            r1 = r5
        L_0x0099:
            boolean r7 = r6.isValidDistance(r1)
            if (r7 == 0) goto L_0x00a0
            r5 = r1
        L_0x00a0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerKt$SnapLayoutInfoProvider$1.calculateSnappingOffset(float):float");
    }

    public float calculateApproachOffset(float f) {
        int i;
        int pageSize$foundation_release = this.$pagerState.getPageSize$foundation_release() + this.$pagerState.getPageSpacing$foundation_release();
        float calculateTargetValue = DecayAnimationSpecKt.calculateTargetValue(this.$decayAnimationSpec, 0.0f, f);
        if (f < 0.0f) {
            i = this.$pagerState.getFirstVisiblePage$foundation_release() + 1;
        } else {
            i = this.$pagerState.getFirstVisiblePage$foundation_release();
        }
        int i2 = i;
        int coerceAtLeast = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(this.$pagerSnapDistance.calculateTargetPage(i2, RangesKt.coerceIn(((int) (calculateTargetValue / ((float) pageSize$foundation_release))) + i, 0, this.$pagerState.getPageCount()), f, this.$pagerState.getPageSize$foundation_release(), this.$pagerState.getPageSpacing$foundation_release()), 0, this.$pagerState.getPageCount()) - i) * pageSize$foundation_release) - pageSize$foundation_release, 0);
        if (coerceAtLeast == 0) {
            return (float) coerceAtLeast;
        }
        return Math.signum(f) * ((float) coerceAtLeast);
    }

    private final Pair<Float, Float> searchForSnappingBounds() {
        int pageSize$foundation_release = this.$pagerState.getPageSize$foundation_release() + this.$pagerState.getPageSpacing$foundation_release();
        int currentPage = this.$pagerState.getCurrentPage();
        int calculateCurrentPageLayoutOffset = PagerMeasurePolicyKt.calculateCurrentPageLayoutOffset(this.$pagerState, pageSize$foundation_release);
        int size = getLayoutInfo().getVisiblePagesInfo().size() / 2;
        int i = calculateCurrentPageLayoutOffset;
        float f = Float.NEGATIVE_INFINITY;
        float f2 = Float.POSITIVE_INFINITY;
        for (int i2 = currentPage; i2 >= RangesKt.coerceAtLeast(currentPage - size, 0); i2--) {
            float calculateDistanceToDesiredSnapPosition = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), i, i2, PagerStateKt.getSnapAlignmentStartToStart());
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f) {
                f = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f2) {
                f2 = calculateDistanceToDesiredSnapPosition;
            }
            i -= pageSize$foundation_release;
        }
        int i3 = calculateCurrentPageLayoutOffset + pageSize$foundation_release;
        for (int i4 = currentPage + 1; i4 <= RangesKt.coerceAtMost(currentPage + size, this.$pagerState.getPageCount() - 1); i4++) {
            float calculateDistanceToDesiredSnapPosition2 = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), i3, i4, PagerStateKt.getSnapAlignmentStartToStart());
            if (calculateDistanceToDesiredSnapPosition2 >= 0.0f && calculateDistanceToDesiredSnapPosition2 < f2) {
                f2 = calculateDistanceToDesiredSnapPosition2;
            }
            if (calculateDistanceToDesiredSnapPosition2 <= 0.0f && calculateDistanceToDesiredSnapPosition2 > f) {
                f = calculateDistanceToDesiredSnapPosition2;
            }
            i3 += pageSize$foundation_release;
        }
        if (f == Float.NEGATIVE_INFINITY) {
            f = f2;
        }
        if (f2 == Float.POSITIVE_INFINITY) {
            f2 = f;
        }
        return TuplesKt.to(Float.valueOf(f), Float.valueOf(f2));
    }
}
