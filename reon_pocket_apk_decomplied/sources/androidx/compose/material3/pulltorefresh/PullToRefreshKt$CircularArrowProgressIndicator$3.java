package androidx.compose.material3.pulltorefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$CircularArrowProgressIndicator$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ long $color;
    final /* synthetic */ Function0<Float> $progress;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$CircularArrowProgressIndicator$3(Function0<Float> function0, long j, int i) {
        super(2);
        this.$progress = function0;
        this.$color = j;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        PullToRefreshKt.m2633CircularArrowProgressIndicatorRPmYEkk(this.$progress, this.$color, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
