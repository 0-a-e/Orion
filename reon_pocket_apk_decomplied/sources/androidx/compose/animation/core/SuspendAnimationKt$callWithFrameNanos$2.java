package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002\"\b\b\u0002\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "R", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "it", "", "invoke", "(J)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendAnimation.kt */
final class SuspendAnimationKt$callWithFrameNanos$2 extends Lambda implements Function1<Long, R> {
    final /* synthetic */ Function1<Long, R> $onFrame;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendAnimationKt$callWithFrameNanos$2(Function1<? super Long, ? extends R> function1) {
        super(1);
        this.$onFrame = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).longValue());
    }

    public final R invoke(long j) {
        return this.$onFrame.invoke(Long.valueOf(j));
    }
}
