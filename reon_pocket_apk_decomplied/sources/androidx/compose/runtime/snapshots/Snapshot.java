package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 S2\u00020\u0001:\u0001SB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u00100\u001a\u00020\"H\u0000¢\u0006\u0002\b1J\r\u00102\u001a\u00020\"H\u0010¢\u0006\u0002\b3J\b\u00104\u001a\u00020\"H\u0016J\"\u00105\u001a\u0002H6\"\u0004\b\u0000\u001062\f\u00107\u001a\b\u0012\u0004\u0012\u0002H608H\b¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\bH&J\n\u0010;\u001a\u0004\u0018\u00010\u0000H\u0011J\u0015\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0000H ¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0000H ¢\u0006\u0002\b@J\r\u0010A\u001a\u00020\"H ¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\"2\u0006\u0010D\u001a\u00020\u001aH ¢\u0006\u0002\bEJ\r\u0010F\u001a\u00020\"H\u0000¢\u0006\u0002\bGJ\r\u0010H\u001a\u00020\"H\u0010¢\u0006\u0002\bIJ\u0012\u0010J\u001a\u00020\"2\b\u0010=\u001a\u0004\u0018\u00010\u0000H\u0011J \u0010K\u001a\u00020\u00002\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!H&J\r\u0010L\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ\n\u0010N\u001a\u0004\u0018\u00010\u0000H\u0007J\u0012\u0010O\u001a\u00020\"2\b\u0010P\u001a\u0004\u0018\u00010\u0000H\u0007J\r\u0010Q\u001a\u00020\"H\u0000¢\u0006\u0002\bRR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003@PX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u00020\b8À\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u001a\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X \u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u0003X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!X \u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0012\u0010%\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\nR\u0012\u0010'\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R$\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00038P@PX\u000e¢\u0006\f\u001a\u0004\b,\u0010\u000f\"\u0004\b-\u0010\u0011R \u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\"\u0018\u00010!X \u0004¢\u0006\u0006\u001a\u0004\b/\u0010$\u0001\u0004TUVW¨\u0006X"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot;", "", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "disposed", "", "getDisposed$runtime_release", "()Z", "setDisposed$runtime_release", "(Z)V", "<set-?>", "getId", "()I", "setId$runtime_release", "(I)V", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "isPinned", "isPinned$runtime_release", "modified", "Landroidx/compose/runtime/collection/IdentityArraySet;", "Landroidx/compose/runtime/snapshots/StateObject;", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "pinningTrackingHandle", "getPinningTrackingHandle$annotations", "()V", "readObserver", "Lkotlin/Function1;", "", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "value", "writeCount", "getWriteCount$runtime_release", "setWriteCount$runtime_release", "writeObserver", "getWriteObserver$runtime_release", "closeAndReleasePinning", "closeAndReleasePinning$runtime_release", "closeLocked", "closeLocked$runtime_release", "dispose", "enter", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "hasPendingChanges", "makeCurrent", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "releasePinnedSnapshotLocked", "releasePinnedSnapshotLocked$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "restoreCurrent", "takeNestedSnapshot", "takeoverPinnedSnapshot", "takeoverPinnedSnapshot$runtime_release", "unsafeEnter", "unsafeLeave", "oldSnapshot", "validateNotDisposed", "validateNotDisposed$runtime_release", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public abstract class Snapshot {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean disposed;
    private int id;
    private SnapshotIdSet invalid;
    /* access modifiers changed from: private */
    public int pinningTrackingHandle;

    public /* synthetic */ Snapshot(int i, SnapshotIdSet snapshotIdSet, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, snapshotIdSet);
    }

    private static /* synthetic */ void getPinningTrackingHandle$annotations() {
    }

    public abstract IdentityArraySet<StateObject> getModified$runtime_release();

    public abstract Function1<Object, Unit> getReadObserver$runtime_release();

    public abstract boolean getReadOnly();

    public abstract Snapshot getRoot();

    public int getWriteCount$runtime_release() {
        return 0;
    }

    public abstract Function1<Object, Unit> getWriteObserver$runtime_release();

    public abstract boolean hasPendingChanges();

    public abstract void nestedActivated$runtime_release(Snapshot snapshot);

    public abstract void nestedDeactivated$runtime_release(Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime_release();

    public abstract void recordModified$runtime_release(StateObject stateObject);

    public abstract Snapshot takeNestedSnapshot(Function1<Object, Unit> function1);

    private Snapshot(int i, SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
        this.id = i;
        this.pinningTrackingHandle = i != 0 ? SnapshotKt.trackPinning(i, getInvalid$runtime_release()) : -1;
    }

    public SnapshotIdSet getInvalid$runtime_release() {
        return this.invalid;
    }

    public void setInvalid$runtime_release(SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
    }

    public int getId() {
        return this.id;
    }

    public void setId$runtime_release(int i) {
        this.id = i;
    }

    public void setWriteCount$runtime_release(int i) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot".toString());
    }

    public void dispose() {
        this.disposed = true;
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Snapshot takeNestedSnapshot$default(Snapshot snapshot, Function1 function1, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            return snapshot.takeNestedSnapshot(function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
    }

    public final <T> T enter(Function0<? extends T> function0) {
        Snapshot makeCurrent = makeCurrent();
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            restoreCurrent(makeCurrent);
            InlineMarker.finallyEnd(1);
        }
    }

    public Snapshot makeCurrent() {
        Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
        SnapshotKt.threadSnapshot.set(this);
        return snapshot;
    }

    public void restoreCurrent(Snapshot snapshot) {
        SnapshotKt.threadSnapshot.set(snapshot);
    }

    public final Snapshot unsafeEnter() {
        return makeCurrent();
    }

    public final void unsafeLeave(Snapshot snapshot) {
        if (SnapshotKt.threadSnapshot.get() == this) {
            restoreCurrent(snapshot);
            return;
        }
        throw new IllegalStateException(("Cannot leave snapshot; " + this + " is not the current snapshot").toString());
    }

    public final boolean getDisposed$runtime_release() {
        return this.disposed;
    }

    public final void setDisposed$runtime_release(boolean z) {
        this.disposed = z;
    }

    public final boolean isPinned$runtime_release() {
        return this.pinningTrackingHandle >= 0;
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId());
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePinnedSnapshotLocked$runtime_release();
    }

    public final void validateNotDisposed$runtime_release() {
        if (!(!this.disposed)) {
            throw new IllegalArgumentException("Cannot use a disposed snapshot".toString());
        }
    }

    public final void releasePinnedSnapshotLocked$runtime_release() {
        int i = this.pinningTrackingHandle;
        if (i >= 0) {
            SnapshotKt.releasePinningLocked(i);
            this.pinningTrackingHandle = -1;
        }
    }

    public final int takeoverPinnedSnapshot$runtime_release() {
        int i = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return i;
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0001J\"\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\b¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011JO\u0010\u0012\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0007J&\u0010\u0019\u001a\u00020\u001a2\u001e\u0010\u001b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u001cJ\u001a\u0010\u001e\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0014J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0001J\u0012\u0010 \u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0001J\u0006\u0010\"\u001a\u00020\u0011J6\u0010#\u001a\u00020$2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014J\u001e\u0010%\u001a\u00020\u00042\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014J\"\u0010&\u001a\u0002H'\"\u0004\b\u0000\u0010'2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H'0\u000eH\b¢\u0006\u0002\u0010\u000fJ4\u0010(\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u0002H\f0\u000e¢\u0006\u0002\b)H\b\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006*"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", "()V", "current", "Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "isApplyObserverNotificationPending", "", "()Z", "createNonObservableSnapshot", "global", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "notifyObjectsInitialized", "", "observe", "readObserver", "Lkotlin/Function1;", "writeObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "openSnapshotCount", "", "registerApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "observer", "Lkotlin/Function2;", "", "registerGlobalWriteObserver", "removeCurrent", "restoreCurrent", "previous", "sendApplyNotifications", "takeMutableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "takeSnapshot", "withMutableSnapshot", "R", "withoutReadObservation", "Landroidx/compose/runtime/DisallowComposableCalls;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Snapshot.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final boolean isApplyObserverNotificationPending() {
            return SnapshotKt.pendingApplyObserverCount.get() > 0;
        }

        public static /* synthetic */ Snapshot takeSnapshot$default(Companion companion, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            return companion.takeSnapshot(function1);
        }

        public final Snapshot takeSnapshot(Function1<Object, Unit> function1) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(function1);
        }

        public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Companion companion, Function1 function1, Function1 function12, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return companion.takeMutableSnapshot(function1, function12);
        }

        public final MutableSnapshot takeMutableSnapshot(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
            MutableSnapshot takeNestedMutableSnapshot;
            Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = currentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) currentSnapshot : null;
            if (mutableSnapshot != null && (takeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(function1, function12)) != null) {
                return takeNestedMutableSnapshot;
            }
            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
        }

        public final <T> T global(Function0<? extends T> function0) {
            Snapshot removeCurrent = removeCurrent();
            T invoke = function0.invoke();
            Snapshot.Companion.restoreCurrent(removeCurrent);
            return invoke;
        }

        public final <R> R withMutableSnapshot(Function0<? extends R> function0) {
            Snapshot snapshot;
            Snapshot makeCurrent;
            MutableSnapshot takeMutableSnapshot$default = takeMutableSnapshot$default(this, (Function1) null, (Function1) null, 3, (Object) null);
            try {
                snapshot = takeMutableSnapshot$default;
                makeCurrent = snapshot.makeCurrent();
                R invoke = function0.invoke();
                InlineMarker.finallyStart(1);
                snapshot.restoreCurrent(makeCurrent);
                InlineMarker.finallyEnd(1);
                takeMutableSnapshot$default.apply().check();
                InlineMarker.finallyStart(1);
                takeMutableSnapshot$default.dispose();
                InlineMarker.finallyEnd(1);
                return invoke;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                takeMutableSnapshot$default.dispose();
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }

        public static /* synthetic */ Object observe$default(Companion companion, Function1 function1, Function1 function12, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return companion.observe(function1, function12, function0);
        }

        public final <T> T observe(Function1<Object, Unit> function1, Function1<Object, Unit> function12, Function0<? extends T> function0) {
            Snapshot snapshot;
            Snapshot makeCurrent;
            if (function1 == null && function12 == null) {
                return function0.invoke();
            }
            Snapshot snapshot2 = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot2 == null || (snapshot2 instanceof MutableSnapshot)) {
                snapshot = new TransparentObserverMutableSnapshot(snapshot2 instanceof MutableSnapshot ? (MutableSnapshot) snapshot2 : null, function1, function12, true, false);
            } else if (function1 == null) {
                return function0.invoke();
            } else {
                snapshot = snapshot2.takeNestedSnapshot(function1);
            }
            try {
                makeCurrent = snapshot.makeCurrent();
                T invoke = function0.invoke();
                snapshot.restoreCurrent(makeCurrent);
                snapshot.dispose();
                return invoke;
            } catch (Throwable th) {
                snapshot.dispose();
                throw th;
            }
        }

        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot) SnapshotKt.threadSnapshot.get(), (Function1) null, false, 6, (Object) null);
        }

        public final <T> T withoutReadObservation(Function0<? extends T> function0) {
            Snapshot makeCurrent;
            Snapshot createNonObservableSnapshot = createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                T invoke = function0.invoke();
                InlineMarker.finallyStart(1);
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                InlineMarker.finallyEnd(1);
                InlineMarker.finallyStart(1);
                createNonObservableSnapshot.dispose();
                InlineMarker.finallyEnd(1);
                return invoke;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                createNonObservableSnapshot.dispose();
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }

        public final ObserverHandle registerApplyObserver(Function2<? super Set<? extends Object>, ? super Snapshot, Unit> function2) {
            Object unused = SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers = CollectionsKt.plus(SnapshotKt.applyObservers, function2);
                Unit unit = Unit.INSTANCE;
            }
            return new Snapshot$Companion$$ExternalSyntheticLambda0(function2);
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
        }

        public final int openSnapshotCount() {
            return CollectionsKt.toList(SnapshotKt.openSnapshots).size();
        }

        public final Snapshot removeCurrent() {
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(null);
            }
            return snapshot;
        }

        public final void restoreCurrent(Snapshot snapshot) {
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(snapshot);
            }
        }

        public final ObserverHandle registerGlobalWriteObserver(Function1<Object, Unit> function1) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers = CollectionsKt.plus(SnapshotKt.globalWriteObservers, function1);
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.advanceGlobalSnapshot();
            return new Snapshot$Companion$$ExternalSyntheticLambda1(function1);
        }

        public final void sendApplyNotifications() {
            boolean z;
            synchronized (SnapshotKt.getLock()) {
                IdentityArraySet<StateObject> modified$runtime_release = ((GlobalSnapshot) SnapshotKt.currentGlobalSnapshot.get()).getModified$runtime_release();
                z = false;
                if (modified$runtime_release != null && modified$runtime_release.isNotEmpty()) {
                    z = true;
                }
            }
            if (z) {
                SnapshotKt.advanceGlobalSnapshot();
            }
        }

        /* access modifiers changed from: private */
        public static final void registerApplyObserver$lambda$6(Function2 function2) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers = CollectionsKt.minus(SnapshotKt.applyObservers, function2);
                Unit unit = Unit.INSTANCE;
            }
        }

        /* access modifiers changed from: private */
        public static final void registerGlobalWriteObserver$lambda$9(Function1 function1) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers = CollectionsKt.minus(SnapshotKt.globalWriteObservers, function1);
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.advanceGlobalSnapshot();
        }
    }

    public final void closeAndReleasePinning$runtime_release() {
        synchronized (SnapshotKt.getLock()) {
            closeLocked$runtime_release();
            releasePinnedSnapshotsForCloseLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }
}
