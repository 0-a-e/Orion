package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0010¢\u0006\u0002\b\u0017R+\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00008V@PX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR+\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u00008V@VX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\u0004¨\u0006\u0018"}, d2 = {"Landroidx/compose/animation/core/MutableTransitionState;", "S", "Landroidx/compose/animation/core/TransitionState;", "initialState", "(Ljava/lang/Object;)V", "<set-?>", "currentState", "getCurrentState", "()Ljava/lang/Object;", "setCurrentState$animation_core_release", "currentState$delegate", "Landroidx/compose/runtime/MutableState;", "isIdle", "", "()Z", "targetState", "getTargetState", "setTargetState", "targetState$delegate", "transitionConfigured", "", "transition", "Landroidx/compose/animation/core/Transition;", "transitionConfigured$animation_core_release", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Transition.kt */
public final class MutableTransitionState<S> extends TransitionState<S> {
    public static final int $stable = 0;
    private final MutableState currentState$delegate;
    private final MutableState targetState$delegate;

    public void transitionConfigured$animation_core_release(Transition<S> transition) {
    }

    public MutableTransitionState(S s) {
        super((DefaultConstructorMarker) null);
        this.currentState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.targetState$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(s, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public S getCurrentState() {
        return this.currentState$delegate.getValue();
    }

    public void setCurrentState$animation_core_release(S s) {
        this.currentState$delegate.setValue(s);
    }

    public S getTargetState() {
        return this.targetState$delegate.getValue();
    }

    public void setTargetState(S s) {
        this.targetState$delegate.setValue(s);
    }

    public final boolean isIdle() {
        return Intrinsics.areEqual(getCurrentState(), getTargetState()) && !isRunning$animation_core_release();
    }
}
