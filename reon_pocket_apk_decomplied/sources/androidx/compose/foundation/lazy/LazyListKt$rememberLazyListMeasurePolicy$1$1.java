package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "containerConstraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/LazyListMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyListItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState lazyListState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyListItemProvider> function0, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        super(2);
        this.$state = lazyListState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$beyondBoundsItemCount = i;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m805invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyListMeasureResult m805invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        int i;
        int i2;
        int i3;
        float f;
        int i4;
        long j2;
        Snapshot makeCurrent;
        float f2;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        boolean z = this.$state.getHasLookaheadPassOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
        CheckScrollableContainerConstraintsKt.m242checkScrollableContainerConstraintsK40F9xA(j3, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m685calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m686calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int r4 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m687calculateTopPaddingD9Ej5fM());
        int r5 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$contentPadding.m684calculateBottomPaddingD9Ej5fM());
        int i5 = r4 + r5;
        int i6 = i + i2;
        boolean z2 = this.$isVertical;
        int i7 = z2 ? i5 : i6;
        if (z2 && !this.$reverseLayout) {
            i3 = r4;
        } else if (!z2 || !this.$reverseLayout) {
            i3 = (z2 || this.$reverseLayout) ? i2 : i;
        } else {
            i3 = r5;
        }
        int i8 = i7 - i3;
        long r20 = ConstraintsKt.m6542offsetNN6EwU(j3, -i6, -i5);
        Density density = lazyLayoutMeasureScope2;
        this.$state.setDensity$foundation_release(density);
        LazyListItemProvider invoke = this.$itemProviderLambda.invoke();
        invoke.getItemScope().setMaxSize(Constraints.m6526getMaxWidthimpl(r20), Constraints.m6525getMaxHeightimpl(r20));
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                f = vertical.m570getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("null verticalArrangement when isVertical == true".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                f = horizontal.m552getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("null horizontalAlignment when isVertical == false".toString());
            }
        }
        int r22 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(f);
        int itemCount = invoke.getItemCount();
        if (this.$isVertical) {
            i4 = Constraints.m6525getMaxHeightimpl(j) - i5;
        } else {
            i4 = Constraints.m6526getMaxWidthimpl(j) - i6;
        }
        int i9 = i4;
        if (!this.$reverseLayout || i9 > 0) {
            j2 = IntOffsetKt.IntOffset(i, r4);
        } else {
            boolean z3 = this.$isVertical;
            if (!z3) {
                i += i9;
            }
            if (z3) {
                r4 += i9;
            }
            j2 = IntOffsetKt.IntOffset(i, r4);
        }
        LazyListItemProvider lazyListItemProvider = invoke;
        Density density2 = density;
        int i10 = i6;
        int i11 = i5;
        LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(r20, this.$isVertical, invoke, lazyLayoutMeasureScope, itemCount, r22, this.$horizontalAlignment, this.$verticalAlignment, this.$reverseLayout, i3, i8, j2, this.$state);
        this.$state.m818setPremeasureConstraintsBRTryo0$foundation_release(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m815getChildConstraintsmsEJaDk());
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.$state;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider, lazyListState.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
            if (lazyLayoutMeasureScope.isLookingAhead() || !z) {
                f2 = this.$state.getScrollToBeConsumed$foundation_release();
            } else {
                f2 = this.$state.getScrollDeltaBetweenPasses$foundation_release();
            }
            float f3 = f2;
            LazyListMeasuredItemProvider lazyListMeasuredItemProvider = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
            boolean z4 = this.$isVertical;
            List<Integer> headerIndexes = lazyListItemProvider.getHeaderIndexes();
            Arrangement.Vertical vertical2 = this.$verticalArrangement;
            Arrangement.Horizontal horizontal2 = this.$horizontalArrangement;
            boolean z5 = this.$reverseLayout;
            LazyListItemAnimator itemAnimator$foundation_release = this.$state.getItemAnimator$foundation_release();
            int i12 = this.$beyondBoundsItemCount;
            boolean isLookingAhead = lazyLayoutMeasureScope.isLookingAhead();
            LazyListLayoutInfo postLookaheadLayoutInfo$foundation_release = this.$state.getPostLookaheadLayoutInfo$foundation_release();
            CoroutineScope coroutineScope$foundation_release = this.$state.getCoroutineScope$foundation_release();
            if (coroutineScope$foundation_release != null) {
                final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
                final long j4 = j;
                final int i13 = i10;
                final int i14 = i11;
                boolean z6 = z4;
                LazyListMeasureResult r0 = LazyListMeasureKt.m810measureLazyList5IMabDg(itemCount, lazyListMeasuredItemProvider, i9, i3, i8, r22, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, f3, r20, z6, headerIndexes, vertical2, horizontal2, z5, density2, itemAnimator$foundation_release, i12, calculateLazyLayoutPinnedIndices, z, isLookingAhead, postLookaheadLayoutInfo$foundation_release, coroutineScope$foundation_release, this.$state.m816getPlacementScopeInvalidatorzYiylxw$foundation_release(), new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                    }

                    public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
                        return lazyLayoutMeasureScope3.layout(ConstraintsKt.m6540constrainWidthK40F9xA(j4, i + i13), ConstraintsKt.m6539constrainHeightK40F9xA(j4, i2 + i14), MapsKt.emptyMap(), function1);
                    }
                });
                LazyListState.applyMeasureResult$foundation_release$default(this.$state, r0, lazyLayoutMeasureScope.isLookingAhead(), false, 4, (Object) null);
                return r0;
            }
            throw new IllegalArgumentException("coroutineScope should be not null".toString());
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }
}
