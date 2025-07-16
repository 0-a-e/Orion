package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H ¢\u0006\u0002\b\u0016R\u0012\u0010\u0004\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8@@@X\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u0010\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006\u0001\u0003\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/TransitionState;", "S", "", "()V", "currentState", "getCurrentState", "()Ljava/lang/Object;", "<set-?>", "", "isRunning", "isRunning$animation_core_release", "()Z", "setRunning$animation_core_release", "(Z)V", "isRunning$delegate", "Landroidx/compose/runtime/MutableState;", "targetState", "getTargetState", "transitionConfigured", "", "transition", "Landroidx/compose/animation/core/Transition;", "transitionConfigured$animation_core_release", "Landroidx/compose/animation/core/MutableTransitionState;", "Landroidx/compose/animation/core/PreventExhaustiveWhenTransitionState;", "Landroidx/compose/animation/core/SeekableTransitionState;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public abstract class TransitionState<S> {
    public static final int $stable = 0;
    private final MutableState isRunning$delegate;

    public /* synthetic */ TransitionState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract S getCurrentState();

    public abstract S getTargetState();

    public abstract void transitionConfigured$animation_core_release(Transition<S> transition);

    private TransitionState() {
        this.isRunning$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final boolean isRunning$animation_core_release() {
        return ((Boolean) this.isRunning$delegate.getValue()).booleanValue();
    }

    public final void setRunning$animation_core_release(boolean z) {
        this.isRunning$delegate.setValue(Boolean.valueOf(z));
    }
}
