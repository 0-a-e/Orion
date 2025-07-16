package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", i = {0}, l = {228}, m = "snapToFraction", n = {"this"}, s = {"L$0"})
/* compiled from: Transition.kt */
final class SeekableTransitionState$snapToFraction$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$snapToFraction$1(SeekableTransitionState<S> seekableTransitionState, Continuation<? super SeekableTransitionState$snapToFraction$1> continuation) {
        super(continuation);
        this.this$0 = seekableTransitionState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.snapToFraction(0.0f, this);
    }
}
