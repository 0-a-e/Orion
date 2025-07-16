package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl$nestedScrollConnection$1", f = "PullToRefresh.kt", i = {}, l = {341}, m = "onPreFling-QWom1Mo", n = {}, s = {})
/* compiled from: PullToRefresh.kt */
final class PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1 extends ContinuationImpl {
    float F$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PullToRefreshStateImpl$nestedScrollConnection$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1(PullToRefreshStateImpl$nestedScrollConnection$1 pullToRefreshStateImpl$nestedScrollConnection$1, Continuation<? super PullToRefreshStateImpl$nestedScrollConnection$1$onPreFling$1> continuation) {
        super(continuation);
        this.this$0 = pullToRefreshStateImpl$nestedScrollConnection$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m2644onPreFlingQWom1Mo(0, this);
    }
}
