package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionObserverHandle;
import androidx.compose.runtime.tooling.RecomposeScopeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/runtime/RecomposeScopeImpl$observe$2", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RecomposeScopeImpl.kt */
public final class RecomposeScopeImpl$observe$2 implements CompositionObserverHandle {
    final /* synthetic */ RecomposeScopeObserver $observer;
    final /* synthetic */ RecomposeScopeImpl this$0;

    RecomposeScopeImpl$observe$2(RecomposeScopeImpl recomposeScopeImpl, RecomposeScopeObserver recomposeScopeObserver) {
        this.this$0 = recomposeScopeImpl;
        this.$observer = recomposeScopeObserver;
    }

    public void dispose() {
        Object access$getCallbackLock$p = RecomposeScopeImplKt.callbackLock;
        RecomposeScopeImpl recomposeScopeImpl = this.this$0;
        RecomposeScopeObserver recomposeScopeObserver = this.$observer;
        synchronized (access$getCallbackLock$p) {
            if (Intrinsics.areEqual((Object) recomposeScopeImpl.observer, (Object) recomposeScopeObserver)) {
                recomposeScopeImpl.observer = null;
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
