package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
final class SnapshotStateObserver$sendNotifications$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SnapshotStateObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapshotStateObserver$sendNotifications$1(SnapshotStateObserver snapshotStateObserver) {
        super(0);
        this.this$0 = snapshotStateObserver;
    }

    /* JADX INFO: finally extract failed */
    public final void invoke() {
        do {
            MutableVector access$getObservedScopeMaps$p = this.this$0.observedScopeMaps;
            SnapshotStateObserver snapshotStateObserver = this.this$0;
            synchronized (access$getObservedScopeMaps$p) {
                if (!snapshotStateObserver.sendingNotifications) {
                    snapshotStateObserver.sendingNotifications = true;
                    try {
                        MutableVector access$getObservedScopeMaps$p2 = snapshotStateObserver.observedScopeMaps;
                        int size = access$getObservedScopeMaps$p2.getSize();
                        if (size > 0) {
                            Object[] content = access$getObservedScopeMaps$p2.getContent();
                            int i = 0;
                            do {
                                ((SnapshotStateObserver.ObservedScopeMap) content[i]).notifyInvalidatedScopes();
                                i++;
                            } while (i < size);
                        }
                        snapshotStateObserver.sendingNotifications = false;
                    } catch (Throwable th) {
                        snapshotStateObserver.sendingNotifications = false;
                        throw th;
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        } while (this.this$0.drainChanges());
    }
}
