package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPager.kt */
final class LazyLayoutPagerKt$Pager$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ int $beyondBoundsPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ SnapFlingBehavior $flingBehavior;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function1<Integer, Object> $key;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function4<PagerScope, Integer, Composer, Integer, Unit> $pageContent;
    final /* synthetic */ NestedScrollConnection $pageNestedScrollConnection;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ boolean $userScrollEnabled;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutPagerKt$Pager$2(Modifier modifier, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, SnapFlingBehavior snapFlingBehavior, boolean z2, int i, float f, PageSize pageSize, NestedScrollConnection nestedScrollConnection, Function1<? super Integer, ? extends Object> function1, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, int i2, int i3, int i4) {
        super(2);
        this.$modifier = modifier;
        this.$state = pagerState;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$orientation = orientation;
        this.$flingBehavior = snapFlingBehavior;
        this.$userScrollEnabled = z2;
        this.$beyondBoundsPageCount = i;
        this.$pageSpacing = f;
        this.$pageSize = pageSize;
        this.$pageNestedScrollConnection = nestedScrollConnection;
        this.$key = function1;
        this.$horizontalAlignment = horizontal;
        this.$verticalAlignment = vertical;
        this.$pageContent = function4;
        this.$$changed = i2;
        this.$$changed1 = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Composer composer2 = composer;
        Modifier modifier = this.$modifier;
        Modifier modifier2 = modifier;
        LazyLayoutPagerKt.m968Pagerfs30GE4(modifier2, this.$state, this.$contentPadding, this.$reverseLayout, this.$orientation, this.$flingBehavior, this.$userScrollEnabled, this.$beyondBoundsPageCount, this.$pageSpacing, this.$pageSize, this.$pageNestedScrollConnection, this.$key, this.$horizontalAlignment, this.$verticalAlignment, this.$pageContent, composer2, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
