package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H@¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0014\u0010\t\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/TooltipStateImpl;", "Landroidx/compose/material3/TooltipState;", "initialIsVisible", "", "isPersistent", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "(ZZLandroidx/compose/foundation/MutatorMutex;)V", "()Z", "isVisible", "job", "Lkotlinx/coroutines/CancellableContinuation;", "", "transition", "Landroidx/compose/animation/core/MutableTransitionState;", "getTransition", "()Landroidx/compose/animation/core/MutableTransitionState;", "dismiss", "onDispose", "show", "mutatePriority", "Landroidx/compose/foundation/MutatePriority;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipStateImpl implements TooltipState {
    private final boolean isPersistent;
    /* access modifiers changed from: private */
    public CancellableContinuation<? super Unit> job;
    private final MutatorMutex mutatorMutex;
    private final MutableTransitionState<Boolean> transition;

    public TooltipStateImpl(boolean z, boolean z2, MutatorMutex mutatorMutex2) {
        this.isPersistent = z2;
        this.mutatorMutex = mutatorMutex2;
        this.transition = new MutableTransitionState<>(Boolean.valueOf(z));
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public MutableTransitionState<Boolean> getTransition() {
        return this.transition;
    }

    public boolean isVisible() {
        return getTransition().getCurrentState().booleanValue() || getTransition().getTargetState().booleanValue();
    }

    public Object show(MutatePriority mutatePriority, Continuation<? super Unit> continuation) {
        Object mutate = this.mutatorMutex.mutate(mutatePriority, new TooltipStateImpl$show$2(this, new TooltipStateImpl$show$cancellableShow$1(this, (Continuation<? super TooltipStateImpl$show$cancellableShow$1>) null), (Continuation<? super TooltipStateImpl$show$2>) null), continuation);
        return mutate == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mutate : Unit.INSTANCE;
    }

    public void dismiss() {
        getTransition().setTargetState(false);
    }

    public void onDispose() {
        CancellableContinuation<? super Unit> cancellableContinuation = this.job;
        if (cancellableContinuation != null) {
            CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, (Throwable) null, 1, (Object) null);
        }
    }
}
