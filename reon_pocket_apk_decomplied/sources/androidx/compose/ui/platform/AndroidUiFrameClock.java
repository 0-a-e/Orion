package androidx.compose.ui.platform;

import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J(\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002H\u000b0\rH@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/platform/AndroidUiFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "choreographer", "Landroid/view/Choreographer;", "(Landroid/view/Choreographer;)V", "dispatcher", "Landroidx/compose/ui/platform/AndroidUiDispatcher;", "(Landroid/view/Choreographer;Landroidx/compose/ui/platform/AndroidUiDispatcher;)V", "getChoreographer", "()Landroid/view/Choreographer;", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidUiFrameClock.android.kt */
public final class AndroidUiFrameClock implements MonotonicFrameClock {
    public static final int $stable = 8;
    private final Choreographer choreographer;
    private final AndroidUiDispatcher dispatcher;

    public /* synthetic */ CoroutineContext.Key getKey() {
        return MonotonicFrameClock.CC.$default$getKey(this);
    }

    public AndroidUiFrameClock(Choreographer choreographer2, AndroidUiDispatcher androidUiDispatcher) {
        this.choreographer = choreographer2;
        this.dispatcher = androidUiDispatcher;
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return MonotonicFrameClock.DefaultImpls.fold(this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return MonotonicFrameClock.DefaultImpls.plus(this, coroutineContext);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public AndroidUiFrameClock(Choreographer choreographer2) {
        this(choreographer2, (AndroidUiDispatcher) null);
    }

    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        AndroidUiDispatcher androidUiDispatcher = this.dispatcher;
        if (androidUiDispatcher == null) {
            CoroutineContext.Element element = continuation.getContext().get(ContinuationInterceptor.Key);
            androidUiDispatcher = element instanceof AndroidUiDispatcher ? (AndroidUiDispatcher) element : null;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Choreographer.FrameCallback androidUiFrameClock$withFrameNanos$2$callback$1 = new AndroidUiFrameClock$withFrameNanos$2$callback$1(cancellableContinuation, this, function1);
        if (androidUiDispatcher == null || !Intrinsics.areEqual((Object) androidUiDispatcher.getChoreographer(), (Object) getChoreographer())) {
            getChoreographer().postFrameCallback(androidUiFrameClock$withFrameNanos$2$callback$1);
            cancellableContinuation.invokeOnCancellation(new AndroidUiFrameClock$withFrameNanos$2$2(this, androidUiFrameClock$withFrameNanos$2$callback$1));
        } else {
            androidUiDispatcher.postFrameCallback$ui_release(androidUiFrameClock$withFrameNanos$2$callback$1);
            cancellableContinuation.invokeOnCancellation(new AndroidUiFrameClock$withFrameNanos$2$1(androidUiDispatcher, androidUiFrameClock$withFrameNanos$2$callback$1));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
