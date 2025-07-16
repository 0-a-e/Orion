package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/animation/ExitTransitionImpl;", "Landroidx/compose/animation/ExitTransition;", "data", "Landroidx/compose/animation/TransitionData;", "(Landroidx/compose/animation/TransitionData;)V", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class ExitTransitionImpl extends ExitTransition {
    private final TransitionData data;

    public ExitTransitionImpl(TransitionData transitionData) {
        super((DefaultConstructorMarker) null);
        this.data = transitionData;
    }

    public TransitionData getData$animation_release() {
        return this.data;
    }
}
