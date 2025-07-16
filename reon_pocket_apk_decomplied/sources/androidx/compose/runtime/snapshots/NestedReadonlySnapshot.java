package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0001\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0002\u0010\u000bJ\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0010¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0001H\u0010¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\tH\u0010¢\u0006\u0002\b&J\u0015\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000eH\u0010¢\u0006\u0002\b)J\u001e\u0010*\u001a\u00020\u00002\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8PX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\"\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078PX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014¨\u0006+"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "parent", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/Snapshot;)V", "modified", "Landroidx/compose/runtime/collection/IdentityArraySet;", "Landroidx/compose/runtime/snapshots/StateObject;", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "getParent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "", "getReadOnly", "()Z", "root", "getRoot", "writeObserver", "getWriteObserver$runtime_release", "dispose", "hasPendingChanges", "nestedActivated", "", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "takeNestedSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class NestedReadonlySnapshot extends Snapshot {
    public static final int $stable = 8;
    private final Snapshot parent;
    private final Function1<Object, Unit> readObserver;

    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return null;
    }

    public boolean getReadOnly() {
        return true;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return null;
    }

    public boolean hasPendingChanges() {
        return false;
    }

    public void notifyObjectsInitialized$runtime_release() {
    }

    public final Snapshot getParent() {
        return this.parent;
    }

    public NestedReadonlySnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Snapshot snapshot) {
        super(i, snapshotIdSet, (DefaultConstructorMarker) null);
        this.parent = snapshot;
        snapshot.nestedActivated$runtime_release(this);
        if (function1 != null) {
            Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
            if (readObserver$runtime_release != null) {
                function1 = new NestedReadonlySnapshot$readObserver$1$1$1(function1, readObserver$runtime_release);
            }
        } else {
            function1 = snapshot.getReadObserver$runtime_release();
        }
        this.readObserver = function1;
    }

    public Snapshot getRoot() {
        return this.parent.getRoot();
    }

    public NestedReadonlySnapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        return new NestedReadonlySnapshot(getId(), getInvalid$runtime_release(), function1, this.parent);
    }

    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            if (getId() != this.parent.getId()) {
                closeAndReleasePinning$runtime_release();
            }
            this.parent.nestedDeactivated$runtime_release(this);
            super.dispose();
        }
    }

    public Void recordModified$runtime_release(StateObject stateObject) {
        Void unused = SnapshotKt.reportReadonlySnapshotWrite();
        throw new KotlinNothingValueException();
    }

    public Void nestedDeactivated$runtime_release(Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Void nestedActivated$runtime_release(Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }
}
