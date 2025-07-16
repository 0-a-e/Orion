package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "isRefreshing", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshStateImpl$Companion$Saver$2 extends Lambda implements Function1<Boolean, PullToRefreshState> {
    final /* synthetic */ Function0<Boolean> $enabled;
    final /* synthetic */ float $positionalThreshold;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshStateImpl$Companion$Saver$2(float f, Function0<Boolean> function0) {
        super(1);
        this.$positionalThreshold = f;
        this.$enabled = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Boolean) obj).booleanValue());
    }

    public final PullToRefreshState invoke(boolean z) {
        return new PullToRefreshStateImpl(z, this.$positionalThreshold, this.$enabled);
    }
}
