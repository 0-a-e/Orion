package androidx.compose.animation.core;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "T", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
final class TransitionKt$updateTransition$1$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Transition<T> $transition;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransitionKt$updateTransition$1$1(Transition<T> transition) {
        super(1);
        this.$transition = transition;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        return new TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1(this.$transition);
    }
}
