package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridDsl.kt */
final class LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<LazyStaggeredGridScope, Unit> $content;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ float $horizontalItemSpacing;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ StaggeredGridCells $rows;
    final /* synthetic */ LazyStaggeredGridState $state;
    final /* synthetic */ boolean $userScrollEnabled;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridDslKt$LazyHorizontalStaggeredGrid$1(StaggeredGridCells staggeredGridCells, Modifier modifier, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z, Arrangement.Vertical vertical, float f, FlingBehavior flingBehavior, boolean z2, Function1<? super LazyStaggeredGridScope, Unit> function1, int i, int i2) {
        super(2);
        this.$rows = staggeredGridCells;
        this.$modifier = modifier;
        this.$state = lazyStaggeredGridState;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$verticalArrangement = vertical;
        this.$horizontalItemSpacing = f;
        this.$flingBehavior = flingBehavior;
        this.$userScrollEnabled = z2;
        this.$content = function1;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyStaggeredGridDslKt.m923LazyHorizontalStaggeredGridcJHQLPU(this.$rows, this.$modifier, this.$state, this.$contentPadding, this.$reverseLayout, this.$verticalArrangement, this.$horizontalItemSpacing, this.$flingBehavior, this.$userScrollEnabled, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
