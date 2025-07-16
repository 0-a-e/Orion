package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$PullToRefreshContainer$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $containerColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Function3<PullToRefreshState, Composer, Integer, Unit> $indicator;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ PullToRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$PullToRefreshContainer$2(PullToRefreshState pullToRefreshState, Modifier modifier, Function3<? super PullToRefreshState, ? super Composer, ? super Integer, Unit> function3, Shape shape, long j, long j2, int i, int i2) {
        super(2);
        this.$state = pullToRefreshState;
        this.$modifier = modifier;
        this.$indicator = function3;
        this.$shape = shape;
        this.$containerColor = j;
        this.$contentColor = j2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PullToRefreshKt.m2634PullToRefreshContainerwBJOh4Y(this.$state, this.$modifier, this.$indicator, this.$shape, this.$containerColor, this.$contentColor, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
