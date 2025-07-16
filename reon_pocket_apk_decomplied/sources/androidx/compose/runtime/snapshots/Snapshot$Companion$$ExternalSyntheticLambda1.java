package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Snapshot$Companion$$ExternalSyntheticLambda1 implements ObserverHandle {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ Snapshot$Companion$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    public final void dispose() {
        Snapshot.Companion.registerGlobalWriteObserver$lambda$9(this.f$0);
    }
}
