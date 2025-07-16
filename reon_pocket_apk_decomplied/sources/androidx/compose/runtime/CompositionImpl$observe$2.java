package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionObserver;
import androidx.compose.runtime.tooling.CompositionObserverHandle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/runtime/CompositionImpl$observe$2", "Landroidx/compose/runtime/tooling/CompositionObserverHandle;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Composition.kt */
public final class CompositionImpl$observe$2 implements CompositionObserverHandle {
    final /* synthetic */ CompositionObserver $observer;
    final /* synthetic */ CompositionImpl this$0;

    CompositionImpl$observe$2(CompositionImpl compositionImpl, CompositionObserver compositionObserver) {
        this.this$0 = compositionImpl;
        this.$observer = compositionObserver;
    }

    public void dispose() {
        Object access$getLock$p = this.this$0.lock;
        CompositionImpl compositionImpl = this.this$0;
        CompositionObserver compositionObserver = this.$observer;
        synchronized (access$getLock$p) {
            if (Intrinsics.areEqual((Object) compositionImpl.getObserverHolder$runtime_release().getObserver(), (Object) compositionObserver)) {
                compositionImpl.getObserverHolder$runtime_release().setObserver((CompositionObserver) null);
                compositionImpl.getObserverHolder$runtime_release().setRoot(false);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
