package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0017\u0018\u0000 g2\u00020\u0001:\u0001gBC\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\b\u00109\u001a\u00020\tH\u0002J\r\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\b;J$\u0010:\u001a\u0002H<\"\u0004\b\u0000\u0010<2\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0>H\b¢\u0006\u0004\b;\u0010?J\b\u0010@\u001a\u00020AH\u0016J\r\u0010B\u001a\u00020\tH\u0010¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\rH\u0016J3\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00032\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0006\u0010K\u001a\u00020\u0005H\u0000¢\u0006\u0002\bLJ\u0015\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bOJ\u0015\u0010P\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0001H\u0010¢\u0006\u0002\bQJ\r\u0010R\u001a\u00020\tH\u0010¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020\u0014H\u0010¢\u0006\u0002\bVJ\u0015\u0010W\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bXJ\u0015\u0010Y\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0005H\u0000¢\u0006\u0002\bZJ\u0015\u0010[\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b\\J\u0015\u0010]\u001a\u00020\t2\u0006\u0010^\u001a\u00020&H\u0000¢\u0006\u0002\b_J\r\u0010`\u001a\u00020\tH\u0010¢\u0006\u0002\baJ\b\u0010b\u001a\u00020\tH\u0002J8\u0010c\u001a\u00020\u00002\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\u001e\u0010d\u001a\u00020\u00012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J\b\u0010e\u001a\u00020\tH\u0002J\b\u0010f\u001a\u00020\tH\u0002R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R4\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001a@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u000fR\u0014\u0010/\u001a\u00020\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,¨\u0006h"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "id", "", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "readObserver", "Lkotlin/Function1;", "", "", "writeObserver", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "applied", "", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "merged", "", "Landroidx/compose/runtime/snapshots/StateObject;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "<set-?>", "Landroidx/compose/runtime/collection/IdentityArraySet;", "modified", "getModified$runtime_release", "()Landroidx/compose/runtime/collection/IdentityArraySet;", "setModified", "(Landroidx/compose/runtime/collection/IdentityArraySet;)V", "previousIds", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "previousPinnedSnapshots", "", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", "([I)V", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "readOnly", "getReadOnly", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshots", "writeCount", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "(I)V", "getWriteObserver$runtime_release", "abandon", "advance", "advance$runtime_release", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "apply", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "closeLocked", "closeLocked$runtime_release", "dispose", "hasPendingChanges", "innerApplyLocked", "snapshotId", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "invalidSnapshots", "innerApplyLocked$runtime_release", "nestedActivated", "snapshot", "nestedActivated$runtime_release", "nestedDeactivated", "nestedDeactivated$runtime_release", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime_release", "recordModified", "state", "recordModified$runtime_release", "recordPrevious", "recordPrevious$runtime_release", "recordPreviousList", "recordPreviousList$runtime_release", "recordPreviousPinnedSnapshot", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshots", "handles", "recordPreviousPinnedSnapshots$runtime_release", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "takeNestedSnapshot", "validateNotApplied", "validateNotAppliedOrPinned", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public class MutableSnapshot extends Snapshot {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int[] EmptyIntArray = new int[0];
    private boolean applied;
    private List<? extends StateObject> merged;
    private IdentityArraySet<StateObject> modified;
    private SnapshotIdSet previousIds = SnapshotIdSet.Companion.getEMPTY();
    private int[] previousPinnedSnapshots = EmptyIntArray;
    private final Function1<Object, Unit> readObserver;
    private int snapshots = 1;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;

    public boolean getReadOnly() {
        return false;
    }

    public Function1<Object, Unit> getReadObserver$runtime_release() {
        return this.readObserver;
    }

    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    public MutableSnapshot(int i, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(i, snapshotIdSet, (DefaultConstructorMarker) null);
        this.readObserver = function1;
        this.writeObserver = function12;
    }

    public boolean hasPendingChanges() {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        return modified$runtime_release != null && modified$runtime_release.isNotEmpty();
    }

    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, Function1 function1, Function1 function12, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            if ((i & 2) != 0) {
                function12 = null;
            }
            return mutableSnapshot.takeNestedMutableSnapshot(function1, function12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        NestedMutableSnapshot nestedMutableSnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(access$getNextSnapshotId$p);
            SnapshotIdSet invalid$runtime_release = getInvalid$runtime_release();
            setInvalid$runtime_release(invalid$runtime_release.set(access$getNextSnapshotId$p));
            nestedMutableSnapshot = new NestedMutableSnapshot(access$getNextSnapshotId$p, SnapshotKt.addRange(invalid$runtime_release, getId() + 1, access$getNextSnapshotId$p), SnapshotKt.mergedReadObserver$default(function1, getReadObserver$runtime_release(), false, 4, (Object) null), SnapshotKt.mergedWriteObserver(function12, getWriteObserver$runtime_release()), this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p2 + 1;
                setId$runtime_release(access$getNextSnapshotId$p2);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
        return nestedMutableSnapshot;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b9, code lost:
        r9.applied = true;
        r4 = r2;
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c0, code lost:
        if (r4 == null) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c6, code lost:
        if (r4.isEmpty() == false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c9, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r4 = r3.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00d1, code lost:
        if (r6 >= r4) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d3, code lost:
        ((kotlin.jvm.functions.Function2) r3.get(r6)).invoke(r2, r9);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00df, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e2, code lost:
        if (r4 == null) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e8, code lost:
        if (r4.isEmpty() == false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00eb, code lost:
        r4 = r3.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f0, code lost:
        if (r6 >= r4) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f2, code lost:
        ((kotlin.jvm.functions.Function2) r3.get(r6)).invoke(r0, r9);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fe, code lost:
        r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0102, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        releasePinnedSnapshotsForCloseLocked$runtime_release();
        androidx.compose.runtime.snapshots.SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0109, code lost:
        if (r2 == null) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010b, code lost:
        r4 = r2.getValues();
        r2 = r2.size();
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0114, code lost:
        if (r6 >= r2) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0116, code lost:
        r7 = r4[r6];
        kotlin.jvm.internal.Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r7);
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0125, code lost:
        if (r0 == null) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0127, code lost:
        r2 = r0.getValues();
        r0 = r0.size();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0130, code lost:
        if (r4 >= r0) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0132, code lost:
        r6 = r2[r4];
        kotlin.jvm.internal.Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r6);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0141, code lost:
        r0 = r9.merged;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0143, code lost:
        if (r0 == null) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0145, code lost:
        r2 = r0.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0149, code lost:
        if (r5 >= r2) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x014b, code lost:
        androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked((androidx.compose.runtime.snapshots.StateObject) r0.get(r5));
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0157, code lost:
        r9.merged = null;
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x015b, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0160, code lost:
        return androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            r9 = this;
            androidx.compose.runtime.collection.IdentityArraySet r0 = r9.getModified$runtime_release()
            r1 = 0
            if (r0 == 0) goto L_0x002c
            java.util.concurrent.atomic.AtomicReference r2 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r2 = r2.get()
            androidx.compose.runtime.snapshots.MutableSnapshot r2 = (androidx.compose.runtime.snapshots.MutableSnapshot) r2
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots
            java.util.concurrent.atomic.AtomicReference r4 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot
            java.lang.Object r4 = r4.get()
            androidx.compose.runtime.snapshots.GlobalSnapshot r4 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r4
            int r4 = r4.getId()
            androidx.compose.runtime.snapshots.SnapshotIdSet r3 = r3.clear(r4)
            java.util.Map r2 = androidx.compose.runtime.snapshots.SnapshotKt.optimisticMerges(r2, r9, r3)
            goto L_0x002d
        L_0x002c:
            r2 = r1
        L_0x002d:
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
            java.lang.Object r4 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r4)
            r5 = r9
            androidx.compose.runtime.snapshots.Snapshot r5 = (androidx.compose.runtime.snapshots.Snapshot) r5     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.snapshots.SnapshotKt.validateOpen(r5)     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x0089
            int r5 = r0.size()     // Catch:{ all -> 0x0164 }
            if (r5 != 0) goto L_0x0045
            goto L_0x0089
        L_0x0045:
            java.util.concurrent.atomic.AtomicReference r3 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch:{ all -> 0x0164 }
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.snapshots.GlobalSnapshot r3 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r3     // Catch:{ all -> 0x0164 }
            int r5 = androidx.compose.runtime.snapshots.SnapshotKt.nextSnapshotId     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = androidx.compose.runtime.snapshots.SnapshotKt.openSnapshots     // Catch:{ all -> 0x0164 }
            int r7 = r3.getId()     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.snapshots.SnapshotIdSet r6 = r6.clear(r7)     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.snapshots.SnapshotApplyResult r2 = r9.innerApplyLocked$runtime_release(r5, r2, r6)     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r5 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE     // Catch:{ all -> 0x0164 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x0164 }
            if (r5 != 0) goto L_0x006d
            monitor-exit(r4)
            return r2
        L_0x006d:
            r9.closeLocked$runtime_release()     // Catch:{ all -> 0x0164 }
            r2 = r3
            androidx.compose.runtime.snapshots.Snapshot r2 = (androidx.compose.runtime.snapshots.Snapshot) r2     // Catch:{ all -> 0x0164 }
            kotlin.jvm.functions.Function1 r5 = androidx.compose.runtime.snapshots.SnapshotKt.emptyLambda     // Catch:{ all -> 0x0164 }
            java.lang.Object unused = androidx.compose.runtime.snapshots.SnapshotKt.takeNewGlobalSnapshot(r2, r5)     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.collection.IdentityArraySet r2 = r3.getModified$runtime_release()     // Catch:{ all -> 0x0164 }
            r9.setModified(r1)     // Catch:{ all -> 0x0164 }
            r3.setModified(r1)     // Catch:{ all -> 0x0164 }
            java.util.List r3 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch:{ all -> 0x0164 }
            goto L_0x00b6
        L_0x0089:
            r9.closeLocked$runtime_release()     // Catch:{ all -> 0x0164 }
            java.util.concurrent.atomic.AtomicReference r2 = androidx.compose.runtime.snapshots.SnapshotKt.currentGlobalSnapshot     // Catch:{ all -> 0x0164 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.snapshots.GlobalSnapshot r2 = (androidx.compose.runtime.snapshots.GlobalSnapshot) r2     // Catch:{ all -> 0x0164 }
            r5 = r2
            androidx.compose.runtime.snapshots.Snapshot r5 = (androidx.compose.runtime.snapshots.Snapshot) r5     // Catch:{ all -> 0x0164 }
            kotlin.jvm.functions.Function1 r6 = androidx.compose.runtime.snapshots.SnapshotKt.emptyLambda     // Catch:{ all -> 0x0164 }
            java.lang.Object unused = androidx.compose.runtime.snapshots.SnapshotKt.takeNewGlobalSnapshot(r5, r6)     // Catch:{ all -> 0x0164 }
            androidx.compose.runtime.collection.IdentityArraySet r2 = r2.getModified$runtime_release()     // Catch:{ all -> 0x0164 }
            r5 = r2
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x0164 }
            if (r5 == 0) goto L_0x00b5
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0164 }
            if (r5 == 0) goto L_0x00b0
            goto L_0x00b5
        L_0x00b0:
            java.util.List r3 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch:{ all -> 0x0164 }
            goto L_0x00b6
        L_0x00b5:
            r2 = r1
        L_0x00b6:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0164 }
            monitor-exit(r4)
            r4 = 1
            r9.applied = r4
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = 0
            if (r4 == 0) goto L_0x00df
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00c9
            goto L_0x00df
        L_0x00c9:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            int r4 = r3.size()
            r6 = r5
        L_0x00d1:
            if (r6 >= r4) goto L_0x00df
            java.lang.Object r7 = r3.get(r6)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r7.invoke(r2, r9)
            int r6 = r6 + 1
            goto L_0x00d1
        L_0x00df:
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            if (r4 == 0) goto L_0x00fe
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x00eb
            goto L_0x00fe
        L_0x00eb:
            int r4 = r3.size()
            r6 = r5
        L_0x00f0:
            if (r6 >= r4) goto L_0x00fe
            java.lang.Object r7 = r3.get(r6)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r7.invoke(r0, r9)
            int r6 = r6 + 1
            goto L_0x00f0
        L_0x00fe:
            java.lang.Object r3 = androidx.compose.runtime.snapshots.SnapshotKt.getLock()
            monitor-enter(r3)
            r9.releasePinnedSnapshotsForCloseLocked$runtime_release()     // Catch:{ all -> 0x0161 }
            androidx.compose.runtime.snapshots.SnapshotKt.checkAndOverwriteUnusedRecordsLocked()     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x0125
            java.lang.Object[] r4 = r2.getValues()     // Catch:{ all -> 0x0161 }
            int r2 = r2.size()     // Catch:{ all -> 0x0161 }
            r6 = r5
        L_0x0114:
            if (r6 >= r2) goto L_0x0125
            r7 = r4[r6]     // Catch:{ all -> 0x0161 }
            java.lang.String r8 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r8)     // Catch:{ all -> 0x0161 }
            androidx.compose.runtime.snapshots.StateObject r7 = (androidx.compose.runtime.snapshots.StateObject) r7     // Catch:{ all -> 0x0161 }
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r7)     // Catch:{ all -> 0x0161 }
            int r6 = r6 + 1
            goto L_0x0114
        L_0x0125:
            if (r0 == 0) goto L_0x0141
            java.lang.Object[] r2 = r0.getValues()     // Catch:{ all -> 0x0161 }
            int r0 = r0.size()     // Catch:{ all -> 0x0161 }
            r4 = r5
        L_0x0130:
            if (r4 >= r0) goto L_0x0141
            r6 = r2[r4]     // Catch:{ all -> 0x0161 }
            java.lang.String r7 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)     // Catch:{ all -> 0x0161 }
            androidx.compose.runtime.snapshots.StateObject r6 = (androidx.compose.runtime.snapshots.StateObject) r6     // Catch:{ all -> 0x0161 }
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r6)     // Catch:{ all -> 0x0161 }
            int r4 = r4 + 1
            goto L_0x0130
        L_0x0141:
            java.util.List<? extends androidx.compose.runtime.snapshots.StateObject> r0 = r9.merged     // Catch:{ all -> 0x0161 }
            if (r0 == 0) goto L_0x0157
            int r2 = r0.size()     // Catch:{ all -> 0x0161 }
        L_0x0149:
            if (r5 >= r2) goto L_0x0157
            java.lang.Object r4 = r0.get(r5)     // Catch:{ all -> 0x0161 }
            androidx.compose.runtime.snapshots.StateObject r4 = (androidx.compose.runtime.snapshots.StateObject) r4     // Catch:{ all -> 0x0161 }
            androidx.compose.runtime.snapshots.SnapshotKt.processForUnusedRecordsLocked(r4)     // Catch:{ all -> 0x0161 }
            int r5 = r5 + 1
            goto L_0x0149
        L_0x0157:
            r9.merged = r1     // Catch:{ all -> 0x0161 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0161 }
            monitor-exit(r3)
            androidx.compose.runtime.snapshots.SnapshotApplyResult$Success r0 = androidx.compose.runtime.snapshots.SnapshotApplyResult.Success.INSTANCE
            androidx.compose.runtime.snapshots.SnapshotApplyResult r0 = (androidx.compose.runtime.snapshots.SnapshotApplyResult) r0
            return r0
        L_0x0161:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x0164:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    public Snapshot getRoot() {
        return this;
    }

    public void dispose() {
        if (!getDisposed$runtime_release()) {
            super.dispose();
            nestedDeactivated$runtime_release(this);
        }
    }

    public Snapshot takeNestedSnapshot(Function1<Object, Unit> function1) {
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(access$getNextSnapshotId$p);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(access$getNextSnapshotId$p, SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, access$getNextSnapshotId$p), function1, this);
        }
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id2 = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p2 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p2 + 1;
                setId$runtime_release(access$getNextSnapshotId$p2);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id2 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }

    public void nestedActivated$runtime_release(Snapshot snapshot) {
        this.snapshots++;
    }

    public void nestedDeactivated$runtime_release(Snapshot snapshot) {
        int i = this.snapshots;
        if (i > 0) {
            int i2 = i - 1;
            this.snapshots = i2;
            if (i2 == 0 && !this.applied) {
                abandon();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("no pending nested snapshots".toString());
    }

    public void notifyObjectsInitialized$runtime_release() {
        if (!this.applied && !getDisposed$runtime_release()) {
            advance$runtime_release();
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getId()).andNot(this.previousIds);
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    private final void validateNotApplied() {
        if (!(!this.applied)) {
            throw new IllegalStateException("Unsupported operation on a snapshot that has been applied".toString());
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (this.applied && this.pinningTrackingHandle < 0) {
            throw new IllegalStateException("Unsupported operation on a disposed or applied snapshot".toString());
        }
    }

    private final void abandon() {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied();
            setModified((IdentityArraySet<StateObject>) null);
            int id = getId();
            Object[] values = modified$runtime_release.getValues();
            int size = modified$runtime_release.size();
            for (int i = 0; i < size; i++) {
                Object obj = values[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                for (StateRecord firstStateRecord = ((StateObject) obj).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
                    if (firstStateRecord.getSnapshotId$runtime_release() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId$runtime_release()))) {
                        firstStateRecord.setSnapshotId$runtime_release(0);
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    public final SnapshotApplyResult innerApplyLocked$runtime_release(int i, Map<StateRecord, ? extends StateRecord> map, SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        StateRecord access$readable;
        StateRecord stateRecord;
        Pair pair;
        Map<StateRecord, ? extends StateRecord> map2 = map;
        SnapshotIdSet or = getInvalid$runtime_release().set(getId()).or(this.previousIds);
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        Object[] values = modified$runtime_release.getValues();
        int size = modified$runtime_release.size();
        List list = null;
        List<? extends StateObject> list2 = null;
        int i2 = 0;
        while (i2 < size) {
            Object obj = values[i2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject stateObject = (StateObject) obj;
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord access$readable2 = SnapshotKt.readable(firstStateRecord, i, snapshotIdSet);
            if (access$readable2 == null || (access$readable = SnapshotKt.readable(firstStateRecord, getId(), or)) == null || Intrinsics.areEqual((Object) access$readable2, (Object) access$readable)) {
                snapshotIdSet2 = or;
            } else {
                snapshotIdSet2 = or;
                StateRecord access$readable3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid$runtime_release());
                if (access$readable3 != null) {
                    if (map2 == null || (stateRecord = (StateRecord) map2.get(access$readable2)) == null) {
                        MutableSnapshot mutableSnapshot = this;
                        stateRecord = stateObject.mergeRecords(access$readable, access$readable2, access$readable3);
                    }
                    if (stateRecord == null) {
                        return new SnapshotApplyResult.Failure(this);
                    }
                    if (!Intrinsics.areEqual((Object) stateRecord, (Object) access$readable3)) {
                        if (Intrinsics.areEqual((Object) stateRecord, (Object) access$readable2)) {
                            if (list == null) {
                                list = new ArrayList();
                            }
                            list.add(TuplesKt.to(stateObject, access$readable2.create()));
                            if (list2 == null) {
                                list2 = new ArrayList<>();
                            }
                            list2.add(stateObject);
                        } else {
                            if (list == null) {
                                list = new ArrayList();
                            }
                            if (!Intrinsics.areEqual((Object) stateRecord, (Object) access$readable)) {
                                pair = TuplesKt.to(stateObject, stateRecord);
                            } else {
                                pair = TuplesKt.to(stateObject, access$readable.create());
                            }
                            list.add(pair);
                        }
                    }
                } else {
                    Void unused = SnapshotKt.readError();
                    throw new KotlinNothingValueException();
                }
            }
            i2++;
            or = snapshotIdSet2;
        }
        if (list != null) {
            advance$runtime_release();
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Pair pair2 = (Pair) list.get(i3);
                StateObject stateObject2 = (StateObject) pair2.component1();
                StateRecord stateRecord2 = (StateRecord) pair2.component2();
                stateRecord2.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord2.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord2);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (list2 != null) {
            int size3 = list2.size();
            for (int i4 = 0; i4 < size3; i4++) {
                modified$runtime_release.remove((StateObject) list2.get(i4));
            }
            List<? extends StateObject> list3 = this.merged;
            if (list3 != null) {
                list2 = CollectionsKt.plus(list3, list2);
            }
            this.merged = list2;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    public final <T> T advance$runtime_release(Function0<? extends T> function0) {
        recordPrevious$runtime_release(getId());
        T invoke = function0.invoke();
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                try {
                    int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                    setId$runtime_release(access$getNextSnapshotId$p);
                    SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
        return invoke;
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int i) {
        if (i >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, i);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        if (iArr.length != 0) {
            int[] iArr2 = this.previousPinnedSnapshots;
            if (iArr2.length != 0) {
                iArr = ArraysKt.plus(iArr2, iArr);
            }
            this.previousPinnedSnapshots = iArr;
        }
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        for (int releasePinningLocked : this.previousPinnedSnapshots) {
            SnapshotKt.releasePinningLocked(releasePinningLocked);
        }
    }

    public void recordModified$runtime_release(StateObject stateObject) {
        IdentityArraySet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = new IdentityArraySet<>();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(stateObject);
    }

    public int getWriteCount$runtime_release() {
        return this.writeCount;
    }

    public void setWriteCount$runtime_release(int i) {
        this.writeCount = i;
    }

    public IdentityArraySet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    public void setModified(IdentityArraySet<StateObject> identityArraySet) {
        this.modified = identityArraySet;
    }

    public final List<StateObject> getMerged$runtime_release() {
        return this.merged;
    }

    public final void setMerged$runtime_release(List<? extends StateObject> list) {
        this.merged = list;
    }

    public final SnapshotIdSet getPreviousIds$runtime_release() {
        return this.previousIds;
    }

    public final void setPreviousIds$runtime_release(SnapshotIdSet snapshotIdSet) {
        this.previousIds = snapshotIdSet;
    }

    public final int[] getPreviousPinnedSnapshots$runtime_release() {
        return this.previousPinnedSnapshots;
    }

    public final void setPreviousPinnedSnapshots$runtime_release(int[] iArr) {
        this.previousPinnedSnapshots = iArr;
    }

    public final boolean getApplied$runtime_release() {
        return this.applied;
    }

    public final void setApplied$runtime_release(boolean z) {
        this.applied = z;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", "()V", "EmptyIntArray", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Snapshot.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void advance$runtime_release() {
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (!getApplied$runtime_release() && !getDisposed$runtime_release()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                int access$getNextSnapshotId$p = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = access$getNextSnapshotId$p + 1;
                setId$runtime_release(access$getNextSnapshotId$p);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getId());
                Unit unit2 = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid$runtime_release(), id + 1, getId()));
        }
    }

    public final void recordPrevious$runtime_release(int i) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(i);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshotIdSet) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshotIdSet);
            Unit unit = Unit.INSTANCE;
        }
    }
}
