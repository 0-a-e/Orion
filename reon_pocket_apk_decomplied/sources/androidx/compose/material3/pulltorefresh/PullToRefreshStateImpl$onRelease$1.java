package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl", f = "PullToRefresh.kt", i = {0, 0}, l = {364}, m = "onRelease", n = {"this", "velocity"}, s = {"L$0", "F$0"})
/* compiled from: PullToRefresh.kt */
final class PullToRefreshStateImpl$onRelease$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PullToRefreshStateImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshStateImpl$onRelease$1(PullToRefreshStateImpl pullToRefreshStateImpl, Continuation<? super PullToRefreshStateImpl$onRelease$1> continuation) {
        super(continuation);
        this.this$0 = pullToRefreshStateImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.onRelease(0.0f, this);
    }
}
