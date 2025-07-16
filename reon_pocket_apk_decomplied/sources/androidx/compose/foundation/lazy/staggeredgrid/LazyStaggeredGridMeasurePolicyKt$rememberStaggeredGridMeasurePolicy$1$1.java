package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;J)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasurePolicy.kt */
final class LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Function0<LazyStaggeredGridItemProvider> $itemProviderLambda;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridStaggeredGridSlotsProvider $slots;
    final /* synthetic */ LazyStaggeredGridState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(Orientation orientation, LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Function0<? extends LazyStaggeredGridItemProvider> function0, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, float f, CoroutineScope coroutineScope) {
        super(2);
        this.$orientation = orientation;
        this.$slots = lazyGridStaggeredGridSlotsProvider;
        this.$itemProviderLambda = function0;
        this.$state = lazyStaggeredGridState;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$mainAxisSpacing = f;
        this.$coroutineScope = coroutineScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m940invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyStaggeredGridMeasureResult m940invoke0kLqBqw(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j) {
        long j2;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j3 = j;
        CheckScrollableContainerConstraintsKt.m242checkScrollableContainerConstraintsK40F9xA(j3, this.$orientation);
        LazyStaggeredGridSlots r10 = this.$slots.m922invoke0kLqBqw(lazyLayoutMeasureScope2, j3);
        boolean z = this.$orientation == Orientation.Vertical;
        LazyStaggeredGridItemProvider invoke = this.$itemProviderLambda.invoke();
        this.$state.setSlots$foundation_release(r10);
        this.$state.setVertical$foundation_release(z);
        this.$state.setSpanProvider$foundation_release(invoke.getSpanProvider());
        int r14 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(this.$contentPadding, this.$orientation, this.$reverseLayout, lazyLayoutMeasureScope.getLayoutDirection()));
        int r16 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(this.$contentPadding, this.$orientation, this.$reverseLayout, lazyLayoutMeasureScope.getLayoutDirection()));
        int r4 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(this.$contentPadding, this.$orientation, lazyLayoutMeasureScope.getLayoutDirection()));
        int r13 = ((z ? Constraints.m6525getMaxHeightimpl(j) : Constraints.m6526getMaxWidthimpl(j)) - r14) - r16;
        if (z) {
            j2 = IntOffsetKt.IntOffset(r4, r14);
        } else {
            j2 = IntOffsetKt.IntOffset(r14, r4);
        }
        long j4 = j2;
        PaddingValues paddingValues = this.$contentPadding;
        int r42 = lazyLayoutMeasureScope2.m6545roundToPx0680j_4(Dp.m6614constructorimpl(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection())));
        PaddingValues paddingValues2 = this.$contentPadding;
        LazyStaggeredGridMeasureResult r1 = LazyStaggeredGridMeasureKt.m938measureStaggeredGridsdzDtKU(lazyLayoutMeasureScope, this.$state, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release()), invoke, r10, Constraints.m6517copyZbe2FdA$default(j, ConstraintsKt.m6540constrainWidthK40F9xA(j3, r42), 0, ConstraintsKt.m6539constrainHeightK40F9xA(j3, lazyLayoutMeasureScope2.m6545roundToPx0680j_4(Dp.m6614constructorimpl(paddingValues2.m687calculateTopPaddingD9Ej5fM() + paddingValues2.m684calculateBottomPaddingD9Ej5fM()))), 0, 10, (Object) null), z, this.$reverseLayout, j4, r13, lazyLayoutMeasureScope2.m6545roundToPx0680j_4(this.$mainAxisSpacing), r14, r16, this.$coroutineScope);
        LazyStaggeredGridState.applyMeasureResult$foundation_release$default(this.$state, r1, false, 2, (Object) null);
        return r1;
    }
}
