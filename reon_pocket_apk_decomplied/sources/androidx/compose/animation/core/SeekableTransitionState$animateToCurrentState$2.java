package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "S", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class SeekableTransitionState$animateToCurrentState$2 extends Lambda implements Function1<Animatable<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeekableTransitionState$animateToCurrentState$2(SeekableTransitionState<S> seekableTransitionState) {
        super(1);
        this.this$0 = seekableTransitionState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Animatable<Float, AnimationVector1D>) (Animatable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Animatable<Float, AnimationVector1D> animatable) {
        this.this$0.seekToFraction();
    }
}
