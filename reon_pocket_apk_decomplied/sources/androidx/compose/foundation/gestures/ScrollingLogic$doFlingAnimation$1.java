package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic", f = "Scrollable.kt", i = {0}, l = {831}, m = "doFlingAnimation-QWom1Mo", n = {"result"}, s = {"L$0"})
/* compiled from: Scrollable.kt */
final class ScrollingLogic$doFlingAnimation$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollingLogic$doFlingAnimation$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$doFlingAnimation$1> continuation) {
        super(continuation);
        this.this$0 = scrollingLogic;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m466doFlingAnimationQWom1Mo(0, this);
    }
}
