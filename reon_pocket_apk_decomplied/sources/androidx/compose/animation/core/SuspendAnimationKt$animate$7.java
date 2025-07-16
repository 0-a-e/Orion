package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendAnimation.kt */
final class SuspendAnimationKt$animate$7 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AnimationState<T, V> $this_animate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendAnimationKt$animate$7(AnimationState<T, V> animationState) {
        super(0);
        this.$this_animate = animationState;
    }

    public final void invoke() {
        this.$this_animate.setRunning$animation_core_release(false);
    }
}
