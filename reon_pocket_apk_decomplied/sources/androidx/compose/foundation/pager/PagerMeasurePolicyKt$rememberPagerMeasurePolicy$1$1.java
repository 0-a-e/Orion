package androidx.compose.foundation.pager;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/pager/PagerMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasurePolicy.kt */
final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, PagerMeasureResult> {
    final /* synthetic */ int $beyondBoundsPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ SnapPositionInLayout $snapPositionInLayout;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(Orientation orientation, PaddingValues paddingValues, boolean z, PagerState pagerState, float f, PageSize pageSize, Function0<PagerLazyLayoutItemProvider> function0, Function0<Integer> function02, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i, SnapPositionInLayout snapPositionInLayout) {
        super(2);
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$state = pagerState;
        this.$pageSpacing = f;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = function0;
        this.$pageCount = function02;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondBoundsPageCount = i;
        this.$snapPositionInLayout = snapPositionInLayout;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m980invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final PagerMeasureResult m980invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        long j2;
        int i5;
        Snapshot makeCurrent;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        boolean z = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m242checkScrollableContainerConstraintsK40F9xA(j3, z ? Orientation.Vertical : Orientation.Horizontal);
        if (z) {
            i = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m685calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (z) {
            i2 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m686calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int r7 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m687calculateTopPaddingD9Ej5fM());
        int r8 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m684calculateBottomPaddingD9Ej5fM());
        int i6 = r7 + r8;
        int i7 = i + i2;
        int i8 = z ? i6 : i7;
        if (z && !this.$reverseLayout) {
            i3 = r7;
        } else if (!z || !this.$reverseLayout) {
            i3 = (z || this.$reverseLayout) ? i2 : i;
        } else {
            i3 = r8;
        }
        int i9 = i8 - i3;
        long r17 = ConstraintsKt.m6542offsetNN6EwU(j3, -i7, -i6);
        Density density = lazyLayoutMeasureScope2;
        this.$state.setDensity$foundation_release(density);
        int r14 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$pageSpacing);
        if (z) {
            i4 = Constraints.m6525getMaxHeightimpl(j) - i6;
        } else {
            i4 = Constraints.m6526getMaxWidthimpl(j) - i7;
        }
        if (!this.$reverseLayout || i4 > 0) {
            j2 = IntOffsetKt.IntOffset(i, r7);
        } else {
            if (!z) {
                i += i4;
            }
            if (z) {
                r7 += i4;
            }
            j2 = IntOffsetKt.IntOffset(i, r7);
        }
        long j4 = j2;
        int calculateMainAxisPageSize = this.$pageSize.calculateMainAxisPageSize(density, i4, r14);
        PagerState pagerState = this.$state;
        int r27 = this.$orientation == Orientation.Vertical ? Constraints.m6526getMaxWidthimpl(r17) : calculateMainAxisPageSize;
        if (this.$orientation != Orientation.Vertical) {
            i5 = Constraints.m6525getMaxHeightimpl(r17);
        } else {
            i5 = calculateMainAxisPageSize;
        }
        pagerState.m985setPremeasureConstraintsBRTryo0$foundation_release(ConstraintsKt.Constraints$default(0, r27, 0, i5, 5, (Object) null));
        PagerLazyLayoutItemProvider invoke = this.$itemProviderLambda.invoke();
        int i10 = calculateMainAxisPageSize + r14;
        Snapshot.Companion companion = Snapshot.Companion;
        PagerState pagerState2 = this.$state;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int matchScrollPositionWithKey$foundation_release = pagerState2.matchScrollPositionWithKey$foundation_release(invoke, pagerState2.getCurrentPage());
            int calculateCurrentPageLayoutOffset = PagerMeasurePolicyKt.calculateCurrentPageLayoutOffset(pagerState2, i10);
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
            final long j5 = j;
            int i11 = i4;
            final int i12 = i7;
            final int i13 = i6;
            PagerMeasureResult r2 = PagerMeasureKt.m978measurePager_JDW0YA(lazyLayoutMeasureScope, this.$pageCount.invoke().intValue(), invoke, i11, i3, i9, r14, matchScrollPositionWithKey$foundation_release, calculateCurrentPageLayoutOffset, r17, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j4, calculateMainAxisPageSize, this.$beyondBoundsPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, this.$state.getPinnedPages$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), this.$snapPositionInLayout, this.$state.m982getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                }

                public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
                    return lazyLayoutMeasureScope3.layout(ConstraintsKt.m6540constrainWidthK40F9xA(j5, i + i12), ConstraintsKt.m6539constrainHeightK40F9xA(j5, i2 + i13), MapsKt.emptyMap(), function1);
                }
            });
            PagerState.applyMeasureResult$foundation_release$default(this.$state, r2, false, 2, (Object) null);
            return r2;
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
