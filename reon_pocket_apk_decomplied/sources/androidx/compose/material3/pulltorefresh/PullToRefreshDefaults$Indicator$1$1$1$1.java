package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshDefaults$Indicator$1$1$1$1 extends Lambda implements Function0<Float> {
    final /* synthetic */ PullToRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshDefaults$Indicator$1$1$1$1(PullToRefreshState pullToRefreshState) {
        super(0);
        this.$state = pullToRefreshState;
    }

    public final Float invoke() {
        return Float.valueOf(this.$state.getProgress());
    }
}
