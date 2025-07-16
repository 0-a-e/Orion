package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Snapshot$Companion$$ExternalSyntheticLambda0 implements ObserverHandle {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ Snapshot$Companion$$ExternalSyntheticLambda0(Function2 function2) {
        this.f$0 = function2;
    }

    public final void dispose() {
        Snapshot.Companion.registerApplyObserver$lambda$6(this.f$0);
    }
}
