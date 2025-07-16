package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
final class GlobalSnapshot$takeNestedSnapshot$1 extends Lambda implements Function1<SnapshotIdSet, ReadonlySnapshot> {
    final /* synthetic */ Function1<Object, Unit> $readObserver;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalSnapshot$takeNestedSnapshot$1(Function1<Object, Unit> function1) {
        super(1);
        this.$readObserver = function1;
    }

    public final ReadonlySnapshot invoke(SnapshotIdSet snapshotIdSet) {
        int access$getNextSnapshotId$p;
        synchronized (SnapshotKt.getLock()) {
            access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
        }
        return new ReadonlySnapshot(access$getNextSnapshotId$p, snapshotIdSet, this.$readObserver);
    }
}
