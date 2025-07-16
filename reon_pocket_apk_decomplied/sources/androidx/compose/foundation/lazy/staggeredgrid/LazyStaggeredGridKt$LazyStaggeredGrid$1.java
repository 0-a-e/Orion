package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
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
/* compiled from: LazyStaggeredGrid.kt */
final class LazyStaggeredGridKt$LazyStaggeredGrid$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function1<LazyStaggeredGridScope, Unit> $content;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridStaggeredGridSlotsProvider $slots;
    final /* synthetic */ LazyStaggeredGridState $state;
    final /* synthetic */ boolean $userScrollEnabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridKt$LazyStaggeredGrid$1(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, float f, float f2, Function1<? super LazyStaggeredGridScope, Unit> function1, int i, int i2, int i3) {
        super(2);
        this.$state = lazyStaggeredGridState;
        this.$orientation = orientation;
        this.$slots = lazyGridStaggeredGridSlotsProvider;
        this.$modifier = modifier;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$flingBehavior = flingBehavior;
        this.$userScrollEnabled = z2;
        this.$mainAxisSpacing = f;
        this.$crossAxisSpacing = f2;
        this.$content = function1;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyStaggeredGridKt.m929LazyStaggeredGridLJWHXA8(this.$state, this.$orientation, this.$slots, this.$modifier, this.$contentPadding, this.$reverseLayout, this.$flingBehavior, this.$userScrollEnabled, this.$mainAxisSpacing, this.$crossAxisSpacing, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
