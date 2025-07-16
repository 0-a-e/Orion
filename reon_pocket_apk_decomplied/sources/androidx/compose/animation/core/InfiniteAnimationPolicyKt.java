package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.platform.InfiniteAnimationPolicy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012#\b\u0004\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u0002H\u00010\u0003HH¢\u0006\u0002\u0010\b\u001a7\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\n\u0012\u0004\u0012\u0002H\u00010\u0003H@¢\u0006\u0002\u0010\b¨\u0006\u000b"}, d2 = {"withInfiniteAnimationFrameMillis", "R", "onFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "frameTimeMillis", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withInfiniteAnimationFrameNanos", "frameTimeNanos", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: InfiniteAnimationPolicy.kt */
public final class InfiniteAnimationPolicyKt {
    public static final <R> Object withInfiniteAnimationFrameNanos(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        InfiniteAnimationPolicy infiniteAnimationPolicy = (InfiniteAnimationPolicy) continuation.getContext().get(InfiniteAnimationPolicy.Key);
        if (infiniteAnimationPolicy == null) {
            return MonotonicFrameClockKt.withFrameNanos(function1, continuation);
        }
        return infiniteAnimationPolicy.onInfiniteOperation(new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2(function1, (Continuation<? super InfiniteAnimationPolicyKt$withInfiniteAnimationFrameNanos$2>) null), continuation);
    }

    public static final <R> Object withInfiniteAnimationFrameMillis(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        return withInfiniteAnimationFrameNanos(new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2(function1), continuation);
    }

    private static final <R> Object withInfiniteAnimationFrameMillis$$forInline(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        InlineMarker.mark(0);
        Object withInfiniteAnimationFrameNanos = withInfiniteAnimationFrameNanos(new InfiniteAnimationPolicyKt$withInfiniteAnimationFrameMillis$2(function1), continuation);
        InlineMarker.mark(1);
        return withInfiniteAnimationFrameNanos;
    }
}
