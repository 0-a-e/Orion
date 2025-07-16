package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$rememberPullToRefreshState$2$1 extends Lambda implements Function0<PullToRefreshState> {
    final /* synthetic */ Function0<Boolean> $enabled;
    final /* synthetic */ float $positionalThresholdPx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$rememberPullToRefreshState$2$1(float f, Function0<Boolean> function0) {
        super(0);
        this.$positionalThresholdPx = f;
        this.$enabled = function0;
    }

    public final PullToRefreshState invoke() {
        return new PullToRefreshStateImpl(false, this.$positionalThresholdPx, this.$enabled);
    }
}
