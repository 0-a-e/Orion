package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\u0014\u0010\u0006\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1", "Landroidx/compose/runtime/DerivedStateObserver;", "done", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "start", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
public final class SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1 implements DerivedStateObserver {
    final /* synthetic */ SnapshotStateObserver.ObservedScopeMap this$0;

    SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1(SnapshotStateObserver.ObservedScopeMap observedScopeMap) {
        this.this$0 = observedScopeMap;
    }

    public void start(DerivedState<?> derivedState) {
        SnapshotStateObserver.ObservedScopeMap observedScopeMap = this.this$0;
        observedScopeMap.deriveStateScopeCount = observedScopeMap.deriveStateScopeCount + 1;
    }

    public void done(DerivedState<?> derivedState) {
        SnapshotStateObserver.ObservedScopeMap observedScopeMap = this.this$0;
        observedScopeMap.deriveStateScopeCount = observedScopeMap.deriveStateScopeCount - 1;
    }
}
