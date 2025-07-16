package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshDefaults$Indicator$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $color;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ PullToRefreshState $state;
    final /* synthetic */ PullToRefreshDefaults $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshDefaults$Indicator$2(PullToRefreshDefaults pullToRefreshDefaults, PullToRefreshState pullToRefreshState, Modifier modifier, long j, int i, int i2) {
        super(2);
        this.$tmp0_rcvr = pullToRefreshDefaults;
        this.$state = pullToRefreshState;
        this.$modifier = modifier;
        this.$color = j;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.m2631IndicatorFNF3uiM(this.$state, this.$modifier, this.$color, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
