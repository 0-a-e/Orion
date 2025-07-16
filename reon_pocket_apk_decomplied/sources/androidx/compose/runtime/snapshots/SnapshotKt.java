package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.IdentityArraySet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\n\u001a\b\u0010)\u001a\u00020\bH\u0002\u001a6\u0010)\u001a\u0002H*\"\u0004\b\u0000\u0010*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010,\u001a\b\u0010-\u001a\u00020\bH\u0002\u001a4\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u00101\u001a\u000202H\u0002\u001a\u001f\u00103\u001a\u0002H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*H\u0001¢\u0006\u0002\u00106\u001a'\u00103\u001a\u0002H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u00108\u001a\b\u00109\u001a\u00020\u0007H\u0000\u001aL\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\b\b\u0002\u0010<\u001a\u000202H\u0002\u001aB\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000f2\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fH\u0002\u001a\u0018\u0010?\u001a\u00020\b2\u0006\u00107\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0016H\u0001\u001a.\u0010A\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000204\u0018\u00010B2\u0006\u00109\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u0010H\u0002\u001a\u0010\u0010F\u001a\u0002022\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\u0010\u0010G\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a\b\u0010H\u001a\u00020IH\u0002\u001a1\u0010J\u001a\u0004\u0018\u0001H*\"\b\b\u0000\u0010**\u0002042\u0006\u00105\u001a\u0002H*2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010L\u001a\u0010\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u0001H\u0000\u001a\b\u0010O\u001a\u00020IH\u0002\u001a\"\u0010P\u001a\u0002H*\"\u0004\b\u0000\u0010*2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H*0QH\b¢\u0006\u0002\u0010R\u001a>\u0010S\u001a\u0002H*\"\u0004\b\u0000\u0010*2\u0006\u0010T\u001a\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010U\u001a:\u0010V\u001a\u0002H*\"\b\b\u0000\u0010**\u00020\u00072!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u0002H*0\u000fH\u0002¢\u0006\u0002\u0010W\u001a\u0018\u0010X\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0000\u001a\u0012\u0010Y\u001a\u0004\u0018\u0001042\u0006\u0010@\u001a\u00020\u0016H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u0010[\u001a\u0002042\u0006\u00107\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a \u0010Z\u001a\u0002022\u0006\u00109\u001a\u00020\u00012\u0006\u0010\\\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0010H\u0002\u001a\u0010\u0010]\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0007H\u0002\u001a\u001c\u0010^\u001a\u00020\u0010*\u00020\u00102\u0006\u0010_\u001a\u00020\u00012\u0006\u0010`\u001a\u00020\u0001H\u0000\u001a!\u0010a\u001a\u000204*\u0002042\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002020\u000fH\b\u001a#\u0010c\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016H\u0000¢\u0006\u0002\u0010d\u001a+\u0010e\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010f\u001a+\u0010g\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010f\u001aK\u0010h\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010j\u001a\u0002H*2\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\b¢\u0006\u0002\u0010l\u001a3\u0010m\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0006\u0010j\u001a\u0002H*H\u0000¢\u0006\u0002\u0010n\u001a!\u0010J\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u0016¢\u0006\u0002\u0010d\u001a)\u0010J\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007¢\u0006\u0002\u0010f\u001aE\u0010o\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2!\u0010+\u001a\u001d\u0012\u0013\u0012\u0011H*¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(5\u0012\u0004\u0012\u0002Hi0\u000fH\b¢\u0006\u0002\u0010p\u001aC\u0010q\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\b¢\u0006\u0002\u0010r\u001aK\u0010q\u001a\u0002Hi\"\b\b\u0000\u0010**\u000204\"\u0004\b\u0001\u0010i*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00072\u0017\u0010+\u001a\u0013\u0012\u0004\u0012\u0002H*\u0012\u0004\u0012\u0002Hi0\u000f¢\u0006\u0002\bkH\b¢\u0006\u0002\u0010s\u001a+\u0010t\u001a\u0002H*\"\b\b\u0000\u0010**\u000204*\u0002H*2\u0006\u0010@\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\",\u0010\u0002\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00040\u0003X\u000e¢\u0006\u0002\n\u0000\".\u0010\t\u001a\"\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nj\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b`\rX\u0004¢\u0006\u0002\n\u0000\")\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\b0\u000fX\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000\" \u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000f0\u0003X\u000e¢\u0006\u0002\n\u0000\"\u001c\u0010\u0018\u001a\u00020\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u000e\u0010\u001d\u001a\u00020\u0001X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010#\u001a\u00020\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010&\"\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00070(X\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"INVALID_SNAPSHOT", "", "applyObservers", "", "Lkotlin/Function2;", "", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "emptyLambda", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "Lkotlin/ParameterName;", "name", "invalid", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "globalWriteObservers", "lock", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "nextSnapshotId", "openSnapshots", "pendingApplyObserverCount", "Landroidx/compose/runtime/AtomicInt;", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "advanceGlobalSnapshot", "T", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "checkAndOverwriteUnusedRecordsLocked", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "ownsPreviousSnapshot", "", "current", "Landroidx/compose/runtime/snapshots/StateRecord;", "r", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "snapshot", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "currentSnapshot", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "notifyWrite", "state", "optimisticMerges", "", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "overwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "readError", "", "readable", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "releasePinningLocked", "handle", "reportReadonlySnapshotWrite", "sync", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "takeNewGlobalSnapshot", "previousGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "trackPinning", "usedLocked", "valid", "data", "candidateSnapshot", "validateOpen", "addRange", "from", "until", "findYoungestOr", "predicate", "newOverwritableRecordLocked", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecordLocked", "overwritable", "R", "candidate", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writableRecord", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snapshot.kt */
public final class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;
    /* access modifiers changed from: private */
    public static List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> applyObservers = CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    /* access modifiers changed from: private */
    public static final Function1<SnapshotIdSet, Unit> emptyLambda = SnapshotKt$emptyLambda$1.INSTANCE;
    private static final SnapshotWeakSet<StateObject> extraStateObjects = new SnapshotWeakSet<>();
    /* access modifiers changed from: private */
    public static List<? extends Function1<Object, Unit>> globalWriteObservers = CollectionsKt.emptyList();
    private static final Object lock = new Object();
    /* access modifiers changed from: private */
    public static int nextSnapshotId;
    /* access modifiers changed from: private */
    public static SnapshotIdSet openSnapshots;
    /* access modifiers changed from: private */
    public static AtomicInt pendingApplyObserverCount = new AtomicInt(0);
    private static final SnapshotDoubleIndexHeap pinningTable = new SnapshotDoubleIndexHeap();
    private static final Snapshot snapshotInitializer;
    /* access modifiers changed from: private */
    public static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();

    public static /* synthetic */ void getLock$annotations() {
    }

    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    public static final int trackPinning(int i, SnapshotIdSet snapshotIdSet) {
        int add;
        int lowest = snapshotIdSet.lowest(i);
        synchronized (getLock()) {
            add = pinningTable.add(lowest);
        }
        return add;
    }

    public static final void releasePinningLocked(int i) {
        pinningTable.remove(i);
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        return snapshot == null ? currentGlobalSnapshot.get() : snapshot;
    }

    static {
        openSnapshots = SnapshotIdSet.Companion.getEMPTY();
        nextSnapshotId = 1;
        int i = nextSnapshotId;
        nextSnapshotId = i + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i, SnapshotIdSet.Companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        snapshotInitializer = atomicReference.get();
    }

    static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z);
    }

    /* access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1<Object, Unit> function1, boolean z) {
        boolean z2 = snapshot instanceof MutableSnapshot;
        if (!z2 && snapshot != null) {
            return new TransparentObserverSnapshot(snapshot, function1, false, z);
        }
        return new TransparentObserverMutableSnapshot(z2 ? (MutableSnapshot) snapshot : null, function1, (Function1<Object, Unit>) null, false, z);
    }

    static /* synthetic */ Function1 mergedReadObserver$default(Function1 function1, Function1 function12, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return mergedReadObserver(function1, function12, z);
    }

    /* access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedReadObserver(Function1<Object, Unit> function1, Function1<Object, Unit> function12, boolean z) {
        if (!z) {
            function12 = null;
        }
        if (function1 == null || function12 == null || Intrinsics.areEqual((Object) function1, (Object) function12)) {
            return function1 == null ? function12 : function1;
        }
        return new SnapshotKt$mergedReadObserver$1(function1, function12);
    }

    /* access modifiers changed from: private */
    public static final Function1<Object, Unit> mergedWriteObserver(Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        if (function1 == null || function12 == null || Intrinsics.areEqual((Object) function1, (Object) function12)) {
            return function1 == null ? function12 : function1;
        }
        return new SnapshotKt$mergedWriteObserver$1(function1, function12);
    }

    public static final Object getLock() {
        return lock;
    }

    public static final <T> T sync(Function0<? extends T> function0) {
        T invoke;
        synchronized (getLock()) {
            try {
                invoke = function0.invoke();
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        return invoke;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    /* access modifiers changed from: private */
    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T invoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i = nextSnapshotId;
            nextSnapshotId = i + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i);
            Unit unit = Unit.INSTANCE;
        }
        return invoke;
    }

    /* access modifiers changed from: private */
    public static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        GlobalSnapshot globalSnapshot;
        IdentityArraySet<StateObject> modified$runtime_release;
        T takeNewGlobalSnapshot;
        Snapshot snapshot = snapshotInitializer;
        Intrinsics.checkNotNull(snapshot, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) snapshot;
        synchronized (getLock()) {
            globalSnapshot = currentGlobalSnapshot.get();
            modified$runtime_release = globalSnapshot.getModified$runtime_release();
            if (modified$runtime_release != null) {
                pendingApplyObserverCount.add(1);
            }
            takeNewGlobalSnapshot = takeNewGlobalSnapshot(globalSnapshot, function1);
        }
        if (modified$runtime_release != null) {
            try {
                List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> list = applyObservers;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    ((Function2) list.get(i)).invoke(modified$runtime_release, globalSnapshot);
                }
            } finally {
                pendingApplyObserverCount.add(-1);
            }
        }
        synchronized (getLock()) {
            checkAndOverwriteUnusedRecordsLocked();
            if (modified$runtime_release != null) {
                Object[] values = modified$runtime_release.getValues();
                int size2 = modified$runtime_release.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Object obj = values[i2];
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
                    processForUnusedRecordsLocked((StateObject) obj);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return takeNewGlobalSnapshot;
    }

    /* access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(SnapshotKt$advanceGlobalSnapshot$3.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        return (Snapshot) advanceGlobalSnapshot(new SnapshotKt$takeNewSnapshot$1(function1));
    }

    /* access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        int lowestOrDefault;
        if (!openSnapshots.get(snapshot.getId())) {
            StringBuilder sb = new StringBuilder("Snapshot is not open: id=");
            sb.append(snapshot.getId());
            sb.append(", disposed=");
            sb.append(snapshot.getDisposed$runtime_release());
            sb.append(", applied=");
            MutableSnapshot mutableSnapshot = snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null;
            sb.append(mutableSnapshot != null ? Boolean.valueOf(mutableSnapshot.getApplied$runtime_release()) : "read-only");
            sb.append(", lowestPin=");
            synchronized (getLock()) {
                lowestOrDefault = pinningTable.lowestOrDefault(-1);
            }
            sb.append(lowestOrDefault);
            throw new IllegalStateException(sb.toString().toString());
        }
    }

    private static final boolean valid(int i, int i2, SnapshotIdSet snapshotIdSet) {
        return i2 != 0 && i2 <= i && !snapshotIdSet.get(i2);
    }

    private static final boolean valid(StateRecord stateRecord, int i, SnapshotIdSet snapshotIdSet) {
        return valid(i, stateRecord.getSnapshotId$runtime_release(), snapshotIdSet);
    }

    /* access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T t, int i, SnapshotIdSet snapshotIdSet) {
        T t2 = null;
        while (t != null) {
            if (valid((StateRecord) t, i, snapshotIdSet) && (t2 == null || t2.getSnapshotId$runtime_release() < t.getSnapshotId$runtime_release())) {
                t2 = t;
            }
            t = t.getNext$runtime_release();
        }
        if (t2 != null) {
            return t2;
        }
        return null;
    }

    public static final <T extends StateRecord> T readable(T t, StateObject stateObject) {
        T readable;
        Snapshot current = Snapshot.Companion.getCurrent();
        Function1<Object, Unit> readObserver$runtime_release = current.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(stateObject);
        }
        T readable2 = readable(t, current.getId(), current.getInvalid$runtime_release());
        if (readable2 != null) {
            return readable2;
        }
        synchronized (getLock()) {
            Snapshot current2 = Snapshot.Companion.getCurrent();
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            readable = readable(firstStateRecord, current2.getId(), current2.getInvalid$runtime_release());
            if (readable == null) {
                readError();
                throw new KotlinNothingValueException();
            }
        }
        return readable;
    }

    public static final <T extends StateRecord> T readable(T t, StateObject stateObject, Snapshot snapshot) {
        Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(stateObject);
        }
        T readable = readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    private static final StateRecord usedLocked(StateObject stateObject) {
        int lowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.Companion.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            if (firstStateRecord.getSnapshotId$runtime_release() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, lowestOrDefault, empty)) {
                if (stateRecord != null) {
                    return firstStateRecord.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release() ? firstStateRecord : stateRecord;
                }
                stateRecord = firstStateRecord;
            }
        }
        return null;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        int lowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord stateRecord2 = null;
        StateRecord stateRecord3 = null;
        int i = 0;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext$runtime_release()) {
            int snapshotId$runtime_release = firstStateRecord.getSnapshotId$runtime_release();
            if (snapshotId$runtime_release != 0) {
                if (snapshotId$runtime_release >= lowestOrDefault) {
                    i++;
                } else if (stateRecord2 == null) {
                    i++;
                    stateRecord2 = firstStateRecord;
                } else {
                    if (firstStateRecord.getSnapshotId$runtime_release() < stateRecord2.getSnapshotId$runtime_release()) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord;
                    } else {
                        stateRecord = firstStateRecord;
                    }
                    if (stateRecord3 == null) {
                        stateRecord3 = stateObject.getFirstStateRecord();
                        StateRecord stateRecord4 = stateRecord3;
                        while (true) {
                            if (stateRecord3 == null) {
                                stateRecord3 = stateRecord4;
                                break;
                            } else if (stateRecord3.getSnapshotId$runtime_release() >= lowestOrDefault) {
                                break;
                            } else {
                                if (stateRecord4.getSnapshotId$runtime_release() < stateRecord3.getSnapshotId$runtime_release()) {
                                    stateRecord4 = stateRecord3;
                                }
                                stateRecord3 = stateRecord3.getNext$runtime_release();
                            }
                        }
                    }
                    stateRecord2.setSnapshotId$runtime_release(0);
                    stateRecord2.assign(stateRecord3);
                    stateRecord2 = stateRecord;
                }
            }
        }
        if (i > 1) {
            return true;
        }
        return false;
    }

    private static final StateRecord findYoungestOr(StateRecord stateRecord, Function1<? super StateRecord, Boolean> function1) {
        StateRecord stateRecord2 = stateRecord;
        while (stateRecord != null) {
            if (function1.invoke(stateRecord).booleanValue()) {
                return stateRecord;
            }
            if (stateRecord2.getSnapshotId$runtime_release() < stateRecord.getSnapshotId$runtime_release()) {
                stateRecord2 = stateRecord;
            }
            stateRecord = stateRecord.getNext$runtime_release();
        }
        return stateRecord2;
    }

    /* access modifiers changed from: private */
    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> snapshotWeakSet = extraStateObjects;
        int size$runtime_release = snapshotWeakSet.getSize$runtime_release();
        int i = 0;
        int i2 = 0;
        while (true) {
            Object obj = null;
            if (i >= size$runtime_release) {
                break;
            }
            WeakReference weakReference = snapshotWeakSet.getValues$runtime_release()[i];
            if (weakReference != null) {
                obj = weakReference.get();
            }
            if (obj != null && !(!overwriteUnusedRecordsLocked((StateObject) obj))) {
                if (i2 != i) {
                    snapshotWeakSet.getValues$runtime_release()[i2] = weakReference;
                    snapshotWeakSet.getHashes$runtime_release()[i2] = snapshotWeakSet.getHashes$runtime_release()[i];
                }
                i2++;
            }
            i++;
        }
        for (int i3 = i2; i3 < size$runtime_release; i3++) {
            snapshotWeakSet.getValues$runtime_release()[i3] = null;
            snapshotWeakSet.getHashes$runtime_release()[i3] = 0;
        }
        if (i2 != size$runtime_release) {
            snapshotWeakSet.setSize$runtime_release(i2);
        }
    }

    /* access modifiers changed from: private */
    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            extraStateObjects.add(stateObject);
        }
    }

    public static final <T extends StateRecord> T writableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(stateObject);
        }
        T readable = readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable == null) {
            readError();
            throw new KotlinNothingValueException();
        } else if (readable.getSnapshotId$runtime_release() == snapshot.getId()) {
            return readable;
        } else {
            T newWritableRecord = newWritableRecord(readable, stateObject, snapshot);
            snapshot.recordModified$runtime_release(stateObject);
            return newWritableRecord;
        }
    }

    public static final <T extends StateRecord> T overwritableRecord(T t, StateObject stateObject, Snapshot snapshot, T t2) {
        T newOverwritableRecordLocked;
        if (snapshot.getReadOnly()) {
            snapshot.recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        if (t2.getSnapshotId$runtime_release() == id) {
            return t2;
        }
        synchronized (getLock()) {
            newOverwritableRecordLocked = newOverwritableRecordLocked(t, stateObject);
        }
        newOverwritableRecordLocked.setSnapshotId$runtime_release(id);
        snapshot.recordModified$runtime_release(stateObject);
        return newOverwritableRecordLocked;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T t, StateObject stateObject, Snapshot snapshot) {
        T newOverwritableRecordLocked = newOverwritableRecordLocked(t, stateObject);
        newOverwritableRecordLocked.assign(t);
        newOverwritableRecordLocked.setSnapshotId$runtime_release(snapshot.getId());
        return newOverwritableRecordLocked;
    }

    public static final <T extends StateRecord> T newOverwritableRecordLocked(T t, StateObject stateObject) {
        T usedLocked = usedLocked(stateObject);
        if (usedLocked != null) {
            usedLocked.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return usedLocked;
        }
        T create = t.create();
        create.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        create.setNext$runtime_release(stateObject.getFirstStateRecord());
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$15");
        stateObject.prependStateRecord(create);
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return create;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject stateObject) {
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount$runtime_release() + 1);
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(stateObject);
        }
    }

    public static final <T extends StateRecord, R> R writable(T t, StateObject stateObject, Function1<? super T, ? extends R> function1) {
        Snapshot current;
        R invoke;
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(writableRecord(t, stateObject, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, stateObject);
        return invoke;
    }

    public static final <T extends StateRecord, R> R overwritable(T t, StateObject stateObject, T t2, Function1<? super T, ? extends R> function1) {
        Snapshot current;
        R invoke;
        getSnapshotInitializer();
        synchronized (getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(overwritableRecord(t, stateObject, current, t2));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(current, stateObject);
        return invoke;
    }

    /* access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        StateRecord readable;
        IdentityArraySet<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet or = mutableSnapshot2.getInvalid$runtime_release().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        Object[] values = modified$runtime_release.getValues();
        int size = modified$runtime_release.size();
        HashMap hashMap = null;
        for (int i = 0; i < size; i++) {
            Object obj = values[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            StateObject stateObject = (StateObject) obj;
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            StateRecord readable2 = readable(firstStateRecord, id, snapshotIdSet);
            if (!(readable2 == null || (readable = readable(firstStateRecord, id, or)) == null || Intrinsics.areEqual((Object) readable2, (Object) readable))) {
                StateRecord readable3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid$runtime_release());
                if (readable3 != null) {
                    StateRecord mergeRecords = stateObject.mergeRecords(readable, readable2, readable3);
                    if (mergeRecords == null) {
                        return null;
                    }
                    Map map = hashMap;
                    if (map == null) {
                        hashMap = new HashMap();
                        map = hashMap;
                    }
                    map.put(readable2, mergeRecords);
                } else {
                    readError();
                    throw new KotlinNothingValueException();
                }
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    public static final <T extends StateRecord> T current(T t, Snapshot snapshot) {
        T readable = readable(t, snapshot.getId(), snapshot.getInvalid$runtime_release());
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final <T extends StateRecord> T current(T t) {
        T readable;
        Snapshot current = Snapshot.Companion.getCurrent();
        T readable2 = readable(t, current.getId(), current.getInvalid$runtime_release());
        if (readable2 != null) {
            return readable2;
        }
        synchronized (getLock()) {
            Snapshot current2 = Snapshot.Companion.getCurrent();
            readable = readable(t, current2.getId(), current2.getInvalid$runtime_release());
        }
        if (readable != null) {
            return readable;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final <T extends StateRecord, R> R withCurrent(T t, Function1<? super T, ? extends R> function1) {
        return function1.invoke(current(t));
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, int i, int i2) {
        while (i < i2) {
            snapshotIdSet = snapshotIdSet.set(i);
            i++;
        }
        return snapshotIdSet;
    }

    public static final <T extends StateRecord> T newWritableRecord(T t, StateObject stateObject, Snapshot snapshot) {
        T newWritableRecordLocked;
        synchronized (getLock()) {
            newWritableRecordLocked = newWritableRecordLocked(t, stateObject, snapshot);
        }
        return newWritableRecordLocked;
    }

    public static final <T extends StateRecord, R> R writable(T t, StateObject stateObject, Snapshot snapshot, Function1<? super T, ? extends R> function1) {
        R invoke;
        synchronized (getLock()) {
            try {
                invoke = function1.invoke(writableRecord(t, stateObject, snapshot));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        notifyWrite(snapshot, stateObject);
        return invoke;
    }
}
