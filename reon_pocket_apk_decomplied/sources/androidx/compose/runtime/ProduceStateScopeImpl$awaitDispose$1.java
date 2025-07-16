package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.ProduceStateScopeImpl", f = "ProduceState.kt", i = {0}, l = {224}, m = "awaitDispose", n = {"onDispose"}, s = {"L$0"})
/* compiled from: ProduceState.kt */
final class ProduceStateScopeImpl$awaitDispose$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProduceStateScopeImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProduceStateScopeImpl$awaitDispose$1(ProduceStateScopeImpl<T> produceStateScopeImpl, Continuation<? super ProduceStateScopeImpl$awaitDispose$1> continuation) {
        super(continuation);
        this.this$0 = produceStateScopeImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.awaitDispose((Function0<Unit>) null, this);
    }
}
