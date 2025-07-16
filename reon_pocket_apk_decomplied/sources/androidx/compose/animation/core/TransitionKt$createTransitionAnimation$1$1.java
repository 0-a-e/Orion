package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0004*\u00020\u0005*\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "S", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class TransitionKt$createTransitionAnimation$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Transition<S> $this_createTransitionAnimation;
    final /* synthetic */ Transition<S>.TransitionAnimationState<T, V> $transitionAnimation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransitionKt$createTransitionAnimation$1$1(Transition<S> transition, Transition<S>.TransitionAnimationState<T, V> transitionAnimationState) {
        super(1);
        this.$this_createTransitionAnimation = transition;
        this.$transitionAnimation = transitionAnimationState;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        this.$this_createTransitionAnimation.addAnimation$animation_core_release(this.$transitionAnimation);
        return new TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1(this.$this_createTransitionAnimation, this.$transitionAnimation);
    }
}
