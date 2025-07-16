package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutKt$LazyLayout$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ LazyLayoutItemProvider $itemProvider;
    final /* synthetic */ Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> $measurePolicy;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$2(LazyLayoutItemProvider lazyLayoutItemProvider, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> function2, int i, int i2) {
        super(2);
        this.$itemProvider = lazyLayoutItemProvider;
        this.$modifier = modifier;
        this.$prefetchState = lazyLayoutPrefetchState;
        this.$measurePolicy = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyLayoutKt.LazyLayout(this.$itemProvider, this.$modifier, this.$prefetchState, (Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult>) this.$measurePolicy, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
