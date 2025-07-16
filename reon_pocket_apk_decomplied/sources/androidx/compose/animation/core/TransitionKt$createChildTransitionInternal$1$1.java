package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "S", "T", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class TransitionKt$createChildTransitionInternal$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Transition<S> $this_createChildTransitionInternal;
    final /* synthetic */ Transition<T> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransitionKt$createChildTransitionInternal$1$1(Transition<S> transition, Transition<T> transition2) {
        super(1);
        this.$this_createChildTransitionInternal = transition;
        this.$transition = transition2;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        this.$this_createChildTransitionInternal.addTransition$animation_core_release(this.$transition);
        return new TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1(this.$this_createChildTransitionInternal, this.$transition);
    }
}
