package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0001\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010,\u001a\u00020\u0006H\u0016J\b\u0010-\u001a\u00020\bH\u0016J\u0015\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0001H\u0010¢\u0006\u0002\b1J\u0015\u00102\u001a\u00020/2\u0006\u00100\u001a\u00020\u0001H\u0010¢\u0006\u0002\b3J\r\u00104\u001a\u00020\u0006H\u0010¢\u0006\u0002\b5J\u0015\u00106\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u001cH\u0010¢\u0006\u0002\b8J\u001e\u00109\u001a\u00020\u00012\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8V@PX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00158P@PX\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R4\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8P@VX\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\"\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\rR\"\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$¨\u0006:"}, d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "previousSnapshot", "specifiedReadObserver", "Lkotlin/Function1;", "", "", "mergeParentObservers", "", "ownsPreviousSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;ZZ)V", "currentSnapshot", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "value", "", "id", "getId", "()I", "setId$runtime_release", "(I)V", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "Landroidx/compose/runtime/collection/IdentityArraySet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "setModified", "(Landroidx/compose/runtime/collection/IdentityArraySet;)V", "readObserver", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "()Z", "root", "getRoot", "writeObserver", "getWriteObserver$runtime_release", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class TransparentObserverSnapshot extends Snapshot {
    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsPreviousSnapshot;
    private final Snapshot previousSnapshot;
    private final Function1<Object, Unit> readObserver;
    private final Snapshot root;
    private final Function1<Object, Unit> writeObserver;

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0013, code lost:
        r4 = r4.getReadObserver$runtime_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TransparentObserverSnapshot(androidx.compose.runtime.snapshots.Snapshot r4, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            androidx.compose.runtime.snapshots.SnapshotIdSet$Companion r0 = androidx.compose.runtime.snapshots.SnapshotIdSet.Companion
            androidx.compose.runtime.snapshots.SnapshotIdSet r0 = r0.getEMPTY()
            r1 = 0
            r2 = 0
            r3.<init>(r2, r0, r1)
            r3.previousSnapshot = r4
            r3.mergeParentObservers = r6
            r3.ownsPreviousSnapshot = r7
            if (r4 == 0) goto L_0x0019
            kotlin.jvm.functions.Function1 r4 = r4.getReadObserver$runtime_release()
            if (r4 != 0) goto L_0x0027
        L_0x0019:
            java.util.concurrent.atomic.AtomicReference r4 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r4 = r4.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r4 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r4
            kotlin.jvm.functions.Function1 r4 = r4.getReadObserver$runtime_release()
        L_0x0027:
            kotlin.jvm.functions.Function1 r4 = androidx.compose.runtime.snapshots.SnapshotKt.mergedReadObserver(r5, r4, r6)
            r3.readObserver = r4
            r4 = r3
            androidx.compose.runtime.snapshots.Snapshot r4 = (androidx.compose.runtime.snapshots.Snapshot) r4
            r3.root = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.TransparentObserverSnapshot.<init>(androidx.compose.runtime.snapshots.Snapshot, kotlin.jvm.functions.Function1, boolean, boolean):void");
    }

    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    public Snapshot getRoot() {
        return this.root;
    }

    private final Snapshot getCurrentSnapshot() {
        Snapshot snapshot = this.previousSnapshot;
        return snapshot == null ? (Snapshot) SnapshotKt.currentGlobalSnapshot.get() : snapshot;
    }

    public void dispose() {
        Snapshot snapshot;
        setDisposed$runtime_release(true);
        if (this.ownsPreviousSnapshot && (snapshot = this.previousSnapshot) != null) {
            snapshot.dispose();
        }
    }

    public int getId() {
        return getCurrentSnapshot().getId();
    }

    public void setId$runtime_release(int i) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public SnapshotIdSet getInvalid$runtime_release() {
        return getCurrentSnapshot().getInvalid$runtime_release();
    }

    public void setInvalid$runtime_release(SnapshotIdSet snapshotIdSet) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return getCurrentSnapshot().getModified$runtime_release();
    }

    public void setModified(IdentityArraySet<StateObject> identityArraySet) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    public void recordModified$runtime_release(StateObject stateObject) {
        getCurrentSnapshot().recordModified$runtime_release(stateObject);
    }

    public Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(function1, getReadObserver$runtime_release(), false, 4, (Object) null);
        if (!this.mergeParentObservers) {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot((Function1<Object, Unit>) null), mergedReadObserver$default, true);
        }
        return getCurrentSnapshot().takeNestedSnapshot(mergedReadObserver$default);
    }

    public void notifyObjectsInitialized$runtime_release() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime_release();
    }

    public Void nestedActivated$runtime_release(Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Void nestedDeactivated$runtime_release(Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }
}
