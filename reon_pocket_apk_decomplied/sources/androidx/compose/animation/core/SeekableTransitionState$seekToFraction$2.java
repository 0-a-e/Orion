package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "S", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class SeekableTransitionState$seekToFraction$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.LongRef $duration;
    final /* synthetic */ Transition<S> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$seekToFraction$2(Ref.LongRef longRef, Transition<S> transition) {
        super(0);
        this.$duration = longRef;
        this.$transition = transition;
    }

    public final void invoke() {
        this.$duration.element = this.$transition.getTotalDurationNanos();
    }
}
