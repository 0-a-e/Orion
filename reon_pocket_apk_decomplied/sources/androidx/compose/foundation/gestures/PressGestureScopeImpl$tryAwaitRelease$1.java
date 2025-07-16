package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.PressGestureScopeImpl", f = "TapGestureDetector.kt", i = {0}, l = {370}, m = "tryAwaitRelease", n = {"this"}, s = {"L$0"})
/* compiled from: TapGestureDetector.kt */
final class PressGestureScopeImpl$tryAwaitRelease$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PressGestureScopeImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PressGestureScopeImpl$tryAwaitRelease$1(PressGestureScopeImpl pressGestureScopeImpl, Continuation<? super PressGestureScopeImpl$tryAwaitRelease$1> continuation) {
        super(continuation);
        this.this$0 = pressGestureScopeImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryAwaitRelease(this);
    }
}
