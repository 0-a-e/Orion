package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"kotlin/coroutines/ContinuationKt$Continuation$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 176)
/* compiled from: Continuation.kt */
public final class ContinuationKt$Continuation$1 implements Continuation<T> {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Function1<Result<? extends T>, Unit> $resumeWith;

    public ContinuationKt$Continuation$1(CoroutineContext coroutineContext, Function1<? super Result<? extends T>, Unit> function1) {
        this.$context = coroutineContext;
        this.$resumeWith = function1;
    }

    public CoroutineContext getContext() {
        return this.$context;
    }

    public void resumeWith(Object obj) {
        this.$resumeWith.invoke(Result.m7041boximpl(obj));
    }
}
