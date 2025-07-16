package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivated", "", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "root", "Landroidx/compose/runtime/snapshots/Snapshot;", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "deactivate", "dispose", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class NestedMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private boolean deactivated;
    private final MutableSnapshot parent;

    public final MutableSnapshot getParent() {
        return this.parent;
    }

    public NestedMutableSnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot mutableSnapshot) {
        super(i, snapshotIdSet, function1, function12);
        this.parent = mutableSnapshot;
        mutableSnapshot.nestedActivated$runtime_release(this);
    }

    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            super.dispose();
            deactivate();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0068, code lost:
        if (r3 == null) goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r7 = this;
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent
            boolean r0 = r0.getApplied$runtime_release()
            if (r0 != 0) goto L_0x00ca
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent
            boolean r0 = r0.getDisposed$runtime_release()
            if (r0 == 0) goto L_0x0012
            goto L_0x00ca
        L_0x0012:
            androidx.compose.runtime.collection.IdentityArraySet r0 = r7.getModified$runtime_release()
            int r1 = r7.getId()
            r2 = 0
            if (r0 == 0) goto L_0x002b
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = r7.parent
            r4 = r7
            androidx.compose.runtime.snapshots.MutableSnapshot r4 = (androidx.compose.runtime.snapshots.MutableSnapshot) r4
            androidx.compose.runtime.snapshots.SnapshotIdSet r5 = r3.getInvalid$runtime_release()
            java.util.Map r3 = androidx.compose.runtime.snapshots.SnapshotKt.optimisticMerges(r3, r4, r5)
            goto L_0x002c
        L_0x002b:
            r3 = r2
        L_0x002c:
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            r5 = r7
            androidx.compose.runtime.snapshots.Snapshot r5 = (androidx.compose.runtime.snapshots.Snapshot) r5     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotKt.validateOpen(r5)     // Catch:{ all -> 0x00c7 }
            if (r0 == 0) goto L_0x0073
            int r5 = r0.size()     // Catch:{ all -> 0x00c7 }
            if (r5 != 0) goto L_0x0040
            goto L_0x0073
        L_0x0040:
            androidx.compose.runtime.snapshots.MutableSnapshot r5 = r7.parent     // Catch:{ all -> 0x00c7 }
            int r5 = r5.getId()     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.MutableSnapshot r6 = r7.parent     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r6.getInvalid$runtime_release()     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotApplyResult r3 = r7.innerApplyLocked$runtime_release(r5, r3, r6)     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r5 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch:{ all -> 0x00c7 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x00c7 }
            if (r5 != 0) goto L_0x005a
            monitor-exit(r4)
            return r3
        L_0x005a:
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = r7.parent     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.collection.IdentityArraySet r3 = r3.getModified$runtime_release()     // Catch:{ all -> 0x00c7 }
            if (r3 == 0) goto L_0x006a
            r5 = r0
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x00c7 }
            r3.addAll(r5)     // Catch:{ all -> 0x00c7 }
            if (r3 != 0) goto L_0x0076
        L_0x006a:
            androidx.compose.runtime.snapshots.MutableSnapshot r3 = r7.parent     // Catch:{ all -> 0x00c7 }
            r3.setModified(r0)     // Catch:{ all -> 0x00c7 }
            r7.setModified(r2)     // Catch:{ all -> 0x00c7 }
            goto L_0x0076
        L_0x0073:
            r7.closeAndReleasePinning$runtime_release()     // Catch:{ all -> 0x00c7 }
        L_0x0076:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch:{ all -> 0x00c7 }
            int r0 = r0.getId()     // Catch:{ all -> 0x00c7 }
            if (r0 >= r1) goto L_0x0083
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch:{ all -> 0x00c7 }
            r0.advance$runtime_release()     // Catch:{ all -> 0x00c7 }
        L_0x0083:
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r0.getInvalid$runtime_release()     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.clear(r1)     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r7.getPreviousIds$runtime_release()     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r2 = r2.andNot(r3)     // Catch:{ all -> 0x00c7 }
            r0.setInvalid$runtime_release(r2)     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch:{ all -> 0x00c7 }
            r0.recordPrevious$runtime_release(r1)     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch:{ all -> 0x00c7 }
            int r1 = r7.takeoverPinnedSnapshot$runtime_release()     // Catch:{ all -> 0x00c7 }
            r0.recordPreviousPinnedSnapshot$runtime_release(r1)     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r1 = r7.getPreviousIds$runtime_release()     // Catch:{ all -> 0x00c7 }
            r0.recordPreviousList$runtime_release(r1)     // Catch:{ all -> 0x00c7 }
            androidx.compose.runtime.snapshots.MutableSnapshot r0 = r7.parent     // Catch:{ all -> 0x00c7 }
            int[] r1 = r7.getPreviousPinnedSnapshots$runtime_release()     // Catch:{ all -> 0x00c7 }
            r0.recordPreviousPinnedSnapshots$runtime_release(r1)     // Catch:{ all -> 0x00c7 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00c7 }
            monitor-exit(r4)
            r0 = 1
            r7.setApplied$runtime_release(r0)
            r7.deactivate()
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        L_0x00c7:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x00ca:
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure r0 = new androidx.compose.runtime.snapshots.SnapshotApplyResult$Failure
            r1 = r7
            androidx.compose.runtime.snapshots.Snapshot r1 = (androidx.compose.runtime.snapshots.Snapshot) r1
            r0.<init>(r1)
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.NestedMutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    private final void deactivate() {
        if (!this.deactivated) {
            this.deactivated = true;
            this.parent.nestedDeactivated$runtime_release(this);
        }
    }
}
