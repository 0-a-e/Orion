package androidx.compose.foundation.pager;

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
/* compiled from: Pager.kt */
final class PagerKt$VerticalPager$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ int $beyondBoundsPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ SnapFlingBehavior $flingBehavior;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function1<Integer, Object> $key;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function4<PagerScope, Integer, Composer, Integer, Unit> $pageContent;
    final /* synthetic */ NestedScrollConnection $pageNestedScrollConnection;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ boolean $userScrollEnabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerKt$VerticalPager$2(PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, SnapFlingBehavior snapFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, int i2, int i3, int i4) {
        super(2);
        this.$state = pagerState;
        this.$modifier = modifier;
        this.$contentPadding = paddingValues;
        this.$pageSize = pageSize;
        this.$beyondBoundsPageCount = i;
        this.$pageSpacing = f;
        this.$horizontalAlignment = horizontal;
        this.$flingBehavior = snapFlingBehavior;
        this.$userScrollEnabled = z;
        this.$reverseLayout = z2;
        this.$key = function1;
        this.$pageNestedScrollConnection = nestedScrollConnection;
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
        PagerState pagerState = this.$state;
        Modifier modifier = this.$modifier;
        PaddingValues paddingValues = this.$contentPadding;
        PageSize pageSize = this.$pageSize;
        int i2 = this.$beyondBoundsPageCount;
        float f = this.$pageSpacing;
        Alignment.Horizontal horizontal = this.$horizontalAlignment;
        SnapFlingBehavior snapFlingBehavior = this.$flingBehavior;
        boolean z = this.$userScrollEnabled;
        boolean z2 = this.$reverseLayout;
        Function1<Integer, Object> function1 = this.$key;
        NestedScrollConnection nestedScrollConnection = this.$pageNestedScrollConnection;
        Function4<PagerScope, Integer, Composer, Integer, Unit> function4 = this.$pageContent;
        PagerState pagerState2 = pagerState;
        PagerKt.m974VerticalPagerxYaah8o(pagerState2, modifier, paddingValues, pageSize, i2, f, horizontal, snapFlingBehavior, z, z2, function1, nestedScrollConnection, function4, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
