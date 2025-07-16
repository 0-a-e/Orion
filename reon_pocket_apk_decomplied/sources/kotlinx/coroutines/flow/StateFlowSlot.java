package kotlinx.coroutines.flow;

import androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Concurrent_commonKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\fH@¢\u0006\u0002\u0010\rJ'\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00100\u000f2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\tR\"\u0010\u0004\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "()V", "_state", "Ljava/util/concurrent/atomic/AtomicReference;", "", "Lkotlinx/coroutines/internal/WorkaroundAtomicReference;", "allocateLocked", "", "flow", "awaitPending", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "freeLocked", "", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: StateFlow.kt */
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    /* access modifiers changed from: private */
    public final AtomicReference<Object> _state = new AtomicReference<>((Object) null);

    public boolean allocateLocked(StateFlowImpl<?> stateFlowImpl) {
        if (Concurrent_commonKt.getValue(this._state) != null) {
            return false;
        }
        Concurrent_commonKt.setValue(this._state, StateFlowKt.NONE);
        return true;
    }

    public Continuation<Unit>[] freeLocked(StateFlowImpl<?> stateFlowImpl) {
        Concurrent_commonKt.setValue(this._state, null);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    public final void makePending() {
        AtomicReference<Object> atomicReference = this._state;
        while (true) {
            Object value = Concurrent_commonKt.getValue(atomicReference);
            if (value != null && value != StateFlowKt.PENDING) {
                if (value == StateFlowKt.NONE) {
                    if (ComplexDouble$$ExternalSyntheticBackport0.m(this._state, value, StateFlowKt.PENDING)) {
                        return;
                    }
                } else if (ComplexDouble$$ExternalSyntheticBackport0.m(this._state, value, StateFlowKt.NONE)) {
                    Result.Companion companion = Result.Companion;
                    ((CancellableContinuationImpl) value).resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final boolean takePending() {
        Object andSet = this._state.getAndSet(StateFlowKt.NONE);
        Intrinsics.checkNotNull(andSet);
        if (DebugKt.getASSERTIONS_ENABLED() && !(!(andSet instanceof CancellableContinuationImpl))) {
            throw new AssertionError();
        } else if (andSet == StateFlowKt.PENDING) {
            return true;
        } else {
            return false;
        }
    }

    public final Object awaitPending(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        if (!DebugKt.getASSERTIONS_ENABLED() || (true ^ (Concurrent_commonKt.getValue(this._state) instanceof CancellableContinuationImpl))) {
            if (!ComplexDouble$$ExternalSyntheticBackport0.m(this._state, StateFlowKt.NONE, cancellableContinuation)) {
                if (!DebugKt.getASSERTIONS_ENABLED() || Concurrent_commonKt.getValue(this._state) == StateFlowKt.PENDING) {
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
                } else {
                    throw new AssertionError();
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return result;
            }
            return Unit.INSTANCE;
        }
        throw new AssertionError();
    }
}
