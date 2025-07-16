package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$LazyList$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ Function1<LazyListScope, Unit> $content;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ boolean $userScrollEnabled;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$LazyList$1(Modifier modifier, LazyListState lazyListState, PaddingValues paddingValues, boolean z, boolean z2, FlingBehavior flingBehavior, boolean z3, int i, Alignment.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, Arrangement.Horizontal horizontal2, Function1<? super LazyListScope, Unit> function1, int i2, int i3, int i4) {
        super(2);
        this.$modifier = modifier;
        this.$state = lazyListState;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$isVertical = z2;
        this.$flingBehavior = flingBehavior;
        this.$userScrollEnabled = z3;
        this.$beyondBoundsItemCount = i;
        this.$horizontalAlignment = horizontal;
        this.$verticalArrangement = vertical;
        this.$verticalAlignment = vertical2;
        this.$horizontalArrangement = horizontal2;
        this.$content = function1;
        this.$$changed = i2;
        this.$$changed1 = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        Modifier modifier = this.$modifier;
        LazyListState lazyListState = this.$state;
        PaddingValues paddingValues = this.$contentPadding;
        boolean z = this.$reverseLayout;
        boolean z2 = this.$isVertical;
        FlingBehavior flingBehavior = this.$flingBehavior;
        boolean z3 = this.$userScrollEnabled;
        int i2 = this.$beyondBoundsItemCount;
        Alignment.Horizontal horizontal = this.$horizontalAlignment;
        Arrangement.Vertical vertical = this.$verticalArrangement;
        Alignment.Vertical vertical2 = this.$verticalAlignment;
        Arrangement.Horizontal horizontal2 = this.$horizontalArrangement;
        Function1<LazyListScope, Unit> function1 = this.$content;
        Modifier modifier2 = modifier;
        LazyListKt.LazyList(modifier2, lazyListState, paddingValues, z, z2, flingBehavior, z3, i2, horizontal, vertical, vertical2, horizontal2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
