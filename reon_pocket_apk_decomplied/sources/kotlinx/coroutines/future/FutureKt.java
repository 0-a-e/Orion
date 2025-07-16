package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.streams.jdk8.StreamsKt$$ExternalSyntheticApiModelOutline0;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007\u001a\u001e\u0010\b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0007H@¢\u0006\u0002\u0010\t\u001aX\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015\u001a\u0018\u0010\u0016\u001a\u00020\u0004*\u00020\u00052\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002¨\u0006\u0017"}, d2 = {"asCompletableFuture", "Ljava/util/concurrent/CompletableFuture;", "T", "Lkotlinx/coroutines/Deferred;", "", "Lkotlinx/coroutines/Job;", "asDeferred", "Ljava/util/concurrent/CompletionStage;", "await", "(Ljava/util/concurrent/CompletionStage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "future", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Ljava/util/concurrent/CompletableFuture;", "setupCancellation", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: Future.kt */
public final class FutureKt {
    public static /* synthetic */ CompletableFuture future$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return future(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> CompletableFuture<T> future(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        if (!coroutineStart.isLazy()) {
            CoroutineContext newCoroutineContext = CoroutineContextKt.newCoroutineContext(coroutineScope, coroutineContext);
            CompletableFuture<T> m = StreamsKt$$ExternalSyntheticApiModelOutline0.m();
            CompletableFutureCoroutine completableFutureCoroutine = new CompletableFutureCoroutine(newCoroutineContext, m);
            CompletableFuture unused = m.handle(StreamsKt$$ExternalSyntheticApiModelOutline0.m((Object) completableFutureCoroutine));
            completableFutureCoroutine.start(coroutineStart, completableFutureCoroutine, function2);
            return m;
        }
        throw new IllegalArgumentException((coroutineStart + " start is not supported").toString());
    }

    public static final <T> CompletableFuture<T> asCompletableFuture(Deferred<? extends T> deferred) {
        CompletableFuture<T> m = StreamsKt$$ExternalSyntheticApiModelOutline0.m();
        setupCancellation(deferred, m);
        deferred.invokeOnCompletion(new FutureKt$asCompletableFuture$1(m, deferred));
        return m;
    }

    public static final CompletableFuture<Unit> asCompletableFuture(Job job) {
        CompletableFuture<Unit> m = StreamsKt$$ExternalSyntheticApiModelOutline0.m();
        setupCancellation(job, m);
        job.invokeOnCompletion(new FutureKt$asCompletableFuture$2(m));
        return m;
    }

    private static final void setupCancellation(Job job, CompletableFuture<?> completableFuture) {
        CompletableFuture unused = completableFuture.handle(new FutureKt$$ExternalSyntheticLambda8(job));
    }

    /* access modifiers changed from: private */
    public static final Unit setupCancellation$lambda$2(Job job, Object obj, Throwable th) {
        CancellationException cancellationException = null;
        if (th != null) {
            if (th instanceof CancellationException) {
                cancellationException = (CancellationException) th;
            }
            if (cancellationException == null) {
                cancellationException = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", th);
            }
        }
        job.cancel(cancellationException);
        return Unit.INSTANCE;
    }

    public static final <T> Deferred<T> asDeferred(CompletionStage<T> completionStage) {
        Throwable cause;
        CompletableFuture m = completionStage.toCompletableFuture();
        if (StreamsKt$$ExternalSyntheticApiModelOutline0.m(m)) {
            try {
                return CompletableDeferredKt.CompletableDeferred(StreamsKt$$ExternalSyntheticApiModelOutline0.m(m));
            } catch (Throwable th) {
                th = th;
                ExecutionException executionException = th instanceof ExecutionException ? th : null;
                if (!(executionException == null || (cause = executionException.getCause()) == null)) {
                    th = cause;
                }
                CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                CompletableDeferred$default.completeExceptionally(th);
                return CompletableDeferred$default;
            }
        } else {
            CompletableDeferred CompletableDeferred$default2 = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
            CompletionStage unused = completionStage.handle(new FutureKt$$ExternalSyntheticLambda7(new FutureKt$asDeferred$2(CompletableDeferred$default2)));
            JobKt.cancelFutureOnCompletion(CompletableDeferred$default2, m);
            return CompletableDeferred$default2;
        }
    }

    /* access modifiers changed from: private */
    public static final Object asDeferred$lambda$4(Function2 function2, Object obj, Throwable th) {
        return function2.invoke(obj, th);
    }

    public static final <T> Object await(CompletionStage<T> completionStage, Continuation<? super T> continuation) {
        CompletableFuture m = completionStage.toCompletableFuture();
        if (StreamsKt$$ExternalSyntheticApiModelOutline0.m(m)) {
            try {
                return StreamsKt$$ExternalSyntheticApiModelOutline0.m(m);
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    cause = e;
                }
                throw cause;
            }
        } else {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            ContinuationHandler continuationHandler = new ContinuationHandler(cancellableContinuation);
            CompletionStage unused = completionStage.handle(StreamsKt$$ExternalSyntheticApiModelOutline0.m((Object) continuationHandler));
            cancellableContinuation.invokeOnCancellation(new FutureKt$await$2$1(m, continuationHandler));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }
}
