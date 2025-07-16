package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u00017B.\u0012'\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\tJ\u0016\u0010\u001d\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\u0006\u0010\u001f\u001a\u00020\u0005J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0001J)\u0010!\u001a\u00020\u00052!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00150\u0003J\b\u0010#\u001a\u00020\u0015H\u0002J&\u0010$\u001a\u00020\u0011\"\b\b\u0000\u0010%*\u00020\u00012\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u0003H\u0002J\u001d\u0010'\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0003H\bJ\u001e\u0010)\u001a\u00020\u00052\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010+\u001a\u00020\rH\u0007J?\u0010,\u001a\u00020\u0005\"\b\b\u0000\u0010%*\u00020\u00012\u0006\u0010 \u001a\u0002H%2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u0002H%\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\fH\u0002J\u001d\u00100\u001a\u00020\u00052\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0003H\bJ\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0005H\u0002J\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u0005J\u0016\u00106\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007R&\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0017X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0002\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u001aX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "", "onChangedExecutor", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "callback", "(Lkotlin/jvm/functions/Function1;)V", "applyObserver", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "currentMapThreadId", "", "isPaused", "", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "readObserver", "sendingNotifications", "addChanges", "set", "clear", "scope", "clearIf", "predicate", "drainChanges", "ensureMap", "T", "onChanged", "forEachScopeMap", "block", "notifyChanges", "changes", "snapshot", "observeReads", "onValueChangedForScope", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "removeChanges", "removeScopeMapIf", "report", "", "sendNotifications", "start", "stop", "withNoObservations", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateObserver.kt */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new SnapshotStateObserver$applyObserver$1(this);
    private ObserverHandle applyUnsubscribe;
    /* access modifiers changed from: private */
    public ObservedScopeMap currentMap;
    private long currentMapThreadId = -1;
    /* access modifiers changed from: private */
    public boolean isPaused;
    /* access modifiers changed from: private */
    public final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>((Object) null);
    private final Function1<Object, Unit> readObserver = new SnapshotStateObserver$readObserver$1(this);
    /* access modifiers changed from: private */
    public boolean sendingNotifications;

    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z;
        synchronized (this.observedScopeMaps) {
            z = this.sendingNotifications;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            Set<Object> removeChanges = removeChanges();
            if (removeChanges == null) {
                return z2;
            }
            synchronized (this.observedScopeMaps) {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        if (!((ObservedScopeMap) content[i]).recordInvalidation(removeChanges)) {
                            if (!z2) {
                                z2 = false;
                                i++;
                            }
                        }
                        z2 = true;
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new SnapshotStateObserver$sendNotifications$1(this));
    }

    /* access modifiers changed from: private */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        Collection collection;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                collection = set;
            } else if (obj instanceof Set) {
                collection = CollectionsKt.listOf(obj, set);
            } else if (obj instanceof List) {
                collection = CollectionsKt.plus((Collection) obj, CollectionsKt.listOf(set));
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!ComplexDouble$$ExternalSyntheticBackport0.m(this.pendingChanges, obj, collection));
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object obj2;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            obj2 = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else if (obj instanceof List) {
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    obj2 = list.get(1);
                } else if (list.size() > 2) {
                    obj2 = list.subList(1, list.size());
                }
                set = set2;
            } else {
                report();
                throw new KotlinNothingValueException();
            }
        } while (!ComplexDouble$$ExternalSyntheticBackport0.m(this.pendingChanges, obj, obj2));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    private final void forEachScopeMap(Function1<? super ObservedScopeMap, Unit> function1) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    int i = 0;
                    do {
                        function1.invoke(content[i]);
                        i++;
                    } while (i < size);
                }
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    private final void removeScopeMapIf(Function1<? super ObservedScopeMap, Boolean> function1) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    if (function1.invoke(mutableVector.getContent()[i2]).booleanValue()) {
                        i++;
                    } else if (i > 0) {
                        mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                    }
                }
                int i3 = size - i;
                ArraysKt.fill((T[]) mutableVector.getContent(), null, i3, size);
                mutableVector.setSize(i3);
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
    }

    public final <T> void observeReads(T t, Function1<? super T, Unit> function1, Function0<Unit> function0) {
        ObservedScopeMap ensureMap;
        synchronized (this.observedScopeMaps) {
            ensureMap = ensureMap(function1);
        }
        boolean z = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j = this.currentMapThreadId;
        if (j == -1 || j == ActualJvm_jvmKt.currentThreadId()) {
            try {
                this.isPaused = false;
                this.currentMap = ensureMap;
                this.currentMapThreadId = Thread.currentThread().getId();
                ensureMap.observe(t, this.readObserver, function0);
            } finally {
                this.currentMap = observedScopeMap;
                this.isPaused = z;
                this.currentMapThreadId = j;
            }
        } else {
            throw new IllegalArgumentException(("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.").toString());
        }
    }

    @Deprecated(message = "Replace with Snapshot.withoutReadObservation()", replaceWith = @ReplaceWith(expression = "Snapshot.withoutReadObservation(block)", imports = {"androidx.compose.runtime.snapshots.Snapshot"}))
    public final void withNoObservations(Function0<Unit> function0) {
        boolean z = this.isPaused;
        this.isPaused = true;
        try {
            function0.invoke();
        } finally {
            this.isPaused = z;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.Companion.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    public final void notifyChanges(Set<? extends Object> set, Snapshot snapshot) {
        this.applyObserver.invoke(set, snapshot);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap ensureMap(kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r6) {
        /*
            r5 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap> r0 = r5.observedScopeMaps
            int r1 = r0.getSize()
            if (r1 <= 0) goto L_0x001d
            java.lang.Object[] r0 = r0.getContent()
            r2 = 0
        L_0x000d:
            r3 = r0[r2]
            r4 = r3
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r4 = (androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap) r4
            kotlin.jvm.functions.Function1 r4 = r4.getOnChanged()
            if (r4 != r6) goto L_0x0019
            goto L_0x001e
        L_0x0019:
            int r2 = r2 + 1
            if (r2 < r1) goto L_0x000d
        L_0x001d:
            r3 = 0
        L_0x001e:
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r3 = (androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap) r3
            if (r3 != 0) goto L_0x0039
            androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap r0 = new androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r1)
            r1 = 1
            java.lang.Object r6 = kotlin.jvm.internal.TypeIntrinsics.beforeCheckcastToFunctionOfArity(r6, r1)
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            r0.<init>(r6)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap> r6 = r5.observedScopeMaps
            r6.add(r0)
            return r0
        L_0x0039:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ensureMap(kotlin.jvm.functions.Function1):androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap");
    }

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001H\u0002J\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0001J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0004J0\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)J\u0014\u0010*\u001a\u00020$2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0001J.\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0002J\u0018\u00100\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002J)\u00101\u001a\u00020\u00042!\u00102\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b3\u0012\b\b4\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020$0\u0003J\u0012\u00105\u001a\u00020\u00042\n\u00106\u001a\u0006\u0012\u0002\b\u00030\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R6\u0010\u0017\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0018j\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0019X\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u001bX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001c\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u001dX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\fX\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "", "onChanged", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "currentScope", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "currentToken", "", "dependencyToDerivedStates", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/DerivedState;", "deriveStateScopeCount", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "invalidated", "Landroidx/collection/MutableScatterSet;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "valueToScopes", "clear", "clearObsoleteStateReads", "scope", "clearScopeObservations", "hasScopeObservations", "", "notifyInvalidatedScopes", "observe", "readObserver", "block", "Lkotlin/Function0;", "recordInvalidation", "changes", "", "recordRead", "value", "recordedValues", "removeObservation", "removeScopeIf", "predicate", "Lkotlin/ParameterName;", "name", "rereadDerivedState", "derivedState", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotStateObserver.kt */
    private static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int currentToken = -1;
        private final ScopeMap<DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();
        /* access modifiers changed from: private */
        public int deriveStateScopeCount;
        private final DerivedStateObserver derivedStateObserver = new SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1(this);
        private final MutableScatterSet<Object> invalidated = new MutableScatterSet<>(0, 1, (DefaultConstructorMarker) null);
        private final Function1<Object, Unit> onChanged;
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues = new MutableScatterMap<>(0, 1, (DefaultConstructorMarker) null);
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final ScopeMap<Object> valueToScopes = new ScopeMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
        }

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final DerivedStateObserver getDerivedStateObserver() {
            return this.derivedStateObserver;
        }

        public final void recordRead(Object obj) {
            Object obj2 = this.currentScope;
            Intrinsics.checkNotNull(obj2);
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, (DefaultConstructorMarker) null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj2, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(obj, i, obj2, mutableObjectIntMap);
        }

        private final void recordRead(Object obj, int i, Object obj2, MutableObjectIntMap<Object> mutableObjectIntMap) {
            int i2;
            int i3;
            Object obj3 = obj;
            int i4 = i;
            if (this.deriveStateScopeCount <= 0) {
                int put = mutableObjectIntMap.put(obj3, i4, -1);
                if (!(obj3 instanceof DerivedState) || put == i4) {
                    i2 = -1;
                } else {
                    DerivedState.Record currentRecord = ((DerivedState) obj3).getCurrentRecord();
                    this.recordedDerivedStateValues.put(obj3, currentRecord.getCurrentValue());
                    ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                    ScopeMap<DerivedState<?>> scopeMap = this.dependencyToDerivedStates;
                    scopeMap.removeScope(obj3);
                    Object[] objArr = dependencies.keys;
                    long[] jArr = dependencies.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i5 = 0;
                        while (true) {
                            long j = jArr[i5];
                            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                                int i6 = 8;
                                int i7 = 8 - ((~(i5 - length)) >>> 31);
                                int i8 = 0;
                                while (i8 < i7) {
                                    if ((j & 255) < 128) {
                                        StateObject stateObject = (StateObject) objArr[(i5 << 3) + i8];
                                        if (stateObject instanceof StateObjectImpl) {
                                            ReaderKind.Companion companion = ReaderKind.Companion;
                                            ((StateObjectImpl) stateObject).m3416recordReadInh_f27i8$runtime_release(ReaderKind.m3402constructorimpl(2));
                                        }
                                        scopeMap.add(stateObject, obj3);
                                        i3 = 8;
                                    } else {
                                        i3 = i6;
                                    }
                                    j >>= i3;
                                    i8++;
                                    i6 = i3;
                                }
                                if (i7 != i6) {
                                    break;
                                }
                            }
                            if (i5 == length) {
                                break;
                            }
                            i5++;
                        }
                    }
                    i2 = -1;
                }
                if (put == i2) {
                    if (obj3 instanceof StateObjectImpl) {
                        ReaderKind.Companion companion2 = ReaderKind.Companion;
                        ((StateObjectImpl) obj3).m3416recordReadInh_f27i8$runtime_release(ReaderKind.m3402constructorimpl(2));
                    }
                    this.valueToScopes.add(obj3, obj2);
                }
            }
        }

        /* JADX INFO: finally extract failed */
        public final void observe(Object obj, Function1<Object, Unit> function1, Function0<Unit> function0) {
            Object obj2 = this.currentScope;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            int i = this.currentToken;
            this.currentScope = obj;
            this.currentScopeReads = this.scopeToValues.get(obj);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver2 = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                derivedStateObservers.add(derivedStateObserver2);
                Snapshot.Companion.observe(function1, (Function1<Object, Unit>) null, function0);
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                Object obj3 = this.currentScope;
                Intrinsics.checkNotNull(obj3);
                clearObsoleteStateReads(obj3);
                this.currentScope = obj2;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i;
            } catch (Throwable th) {
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        private final void clearObsoleteStateReads(Object obj) {
            int i = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap != null) {
                long[] jArr = mutableObjectIntMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i2 = 0;
                    while (true) {
                        long j = jArr[i2];
                        if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i3 = 8 - ((~(i2 - length)) >>> 31);
                            for (int i4 = 0; i4 < i3; i4++) {
                                if ((255 & j) < 128) {
                                    int i5 = (i2 << 3) + i4;
                                    Object obj2 = mutableObjectIntMap.keys[i5];
                                    boolean z = mutableObjectIntMap.values[i5] != i;
                                    Object obj3 = obj;
                                    if (z) {
                                        removeObservation(obj3, obj2);
                                    }
                                    if (z) {
                                        mutableObjectIntMap.removeValueAt(i5);
                                    }
                                } else {
                                    Object obj4 = obj;
                                }
                                j >>= 8;
                            }
                            Object obj5 = obj;
                            if (i3 != 8) {
                                return;
                            }
                        } else {
                            Object obj6 = obj;
                        }
                        if (i2 != length) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public final void clearScopeObservations(Object obj) {
            Object obj2 = obj;
            MutableObjectIntMap remove = this.scopeToValues.remove(obj2);
            if (remove != null) {
                ObjectIntMap objectIntMap = remove;
                Object[] objArr = objectIntMap.keys;
                int[] iArr = objectIntMap.values;
                long[] jArr = objectIntMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    int i4 = (i << 3) + i3;
                                    Object obj3 = objArr[i4];
                                    int i5 = iArr[i4];
                                    removeObservation(obj2, obj3);
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                return;
                            }
                        }
                        if (i != length) {
                            i++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        public final void removeScopeIf(Function1<Object, Boolean> function1) {
            long[] jArr;
            int i;
            long j;
            int i2;
            int i3;
            long[] jArr2;
            long j2;
            int i4;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j3 = jArr3[i5];
                    long j4 = -9187201950435737472L;
                    if ((((~j3) << 7) & j3 & -9187201950435737472L) != -9187201950435737472L) {
                        int i6 = 8;
                        int i7 = 8 - ((~(i5 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j3 & 255) < 128) {
                                int i9 = (i5 << 3) + i8;
                                Object obj = mutableScatterMap.keys[i9];
                                MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i9];
                                Boolean invoke = function1.invoke(obj);
                                if (invoke.booleanValue()) {
                                    ObjectIntMap objectIntMap = mutableObjectIntMap;
                                    Object[] objArr = objectIntMap.keys;
                                    int[] iArr = objectIntMap.values;
                                    long[] jArr4 = objectIntMap.metadata;
                                    int length2 = jArr4.length - 2;
                                    jArr2 = jArr3;
                                    if (length2 >= 0) {
                                        i3 = i7;
                                        int i10 = 0;
                                        while (true) {
                                            long j5 = jArr4[i10];
                                            i2 = i5;
                                            j = j3;
                                            j2 = -9187201950435737472L;
                                            if ((((~j5) << 7) & j5 & -9187201950435737472L) != -9187201950435737472L) {
                                                int i11 = 8 - ((~(i10 - length2)) >>> 31);
                                                for (int i12 = 0; i12 < i11; i12++) {
                                                    if ((j5 & 255) < 128) {
                                                        int i13 = (i10 << 3) + i12;
                                                        Object obj2 = objArr[i13];
                                                        int i14 = iArr[i13];
                                                        removeObservation(obj, obj2);
                                                    }
                                                    j5 >>= 8;
                                                }
                                                if (i11 != 8) {
                                                    break;
                                                }
                                            }
                                            if (i10 == length2) {
                                                break;
                                            }
                                            i10++;
                                            i5 = i2;
                                            j3 = j;
                                        }
                                    } else {
                                        i2 = i5;
                                        j = j3;
                                        i3 = i7;
                                        j2 = -9187201950435737472L;
                                    }
                                } else {
                                    jArr2 = jArr3;
                                    i2 = i5;
                                    j = j3;
                                    i3 = i7;
                                    j2 = j4;
                                }
                                if (invoke.booleanValue()) {
                                    mutableScatterMap.removeValueAt(i9);
                                }
                                i4 = 8;
                            } else {
                                jArr2 = jArr3;
                                i2 = i5;
                                j = j3;
                                i3 = i7;
                                j2 = j4;
                                i4 = i6;
                            }
                            j3 = j >> i4;
                            i8++;
                            i6 = i4;
                            j4 = j2;
                            jArr3 = jArr2;
                            i7 = i3;
                            i5 = i2;
                        }
                        jArr = jArr3;
                        int i15 = i5;
                        if (i7 == i6) {
                            i = i15;
                        } else {
                            return;
                        }
                    } else {
                        jArr = jArr3;
                        i = i5;
                    }
                    if (i != length) {
                        i5 = i + 1;
                        jArr3 = jArr;
                    } else {
                        return;
                    }
                }
            }
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        private final void removeObservation(Object obj, Object obj2) {
            this.valueToScopes.remove(obj2, obj);
            if ((obj2 instanceof DerivedState) && !this.valueToScopes.contains(obj2)) {
                this.dependencyToDerivedStates.removeScope(obj2);
                this.recordedDerivedStateValues.remove(obj2);
            }
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        /* JADX WARNING: Removed duplicated region for block: B:238:0x02df A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x0284  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean recordInvalidation(java.util.Set<? extends java.lang.Object> r38) {
            /*
                r37 = this;
                r0 = r37
                r1 = r38
                androidx.compose.runtime.collection.ScopeMap<androidx.compose.runtime.DerivedState<?>> r2 = r0.dependencyToDerivedStates
                java.util.HashMap<androidx.compose.runtime.DerivedState<?>, java.lang.Object> r3 = r0.recordedDerivedStateValues
                androidx.compose.runtime.collection.ScopeMap<java.lang.Object> r4 = r0.valueToScopes
                androidx.collection.MutableScatterSet<java.lang.Object> r5 = r0.invalidated
                boolean r6 = r1 instanceof androidx.compose.runtime.collection.IdentityArraySet
                java.lang.String r7 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>"
                r12 = 7
                r13 = 2
                r18 = 0
                if (r6 == 0) goto L_0x02ef
                androidx.compose.runtime.collection.IdentityArraySet r1 = (androidx.compose.runtime.collection.IdentityArraySet) r1
                java.lang.Object[] r6 = r1.getValues()
                int r1 = r1.size()
                r9 = r18
                r19 = r9
            L_0x0024:
                if (r9 >= r1) goto L_0x05e5
                r10 = r6[r9]
                java.lang.String r11 = "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r11)
                boolean r11 = r10 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r11 == 0) goto L_0x004e
                r11 = r10
                androidx.compose.runtime.snapshots.StateObjectImpl r11 = (androidx.compose.runtime.snapshots.StateObjectImpl) r11
                androidx.compose.runtime.snapshots.ReaderKind$Companion r22 = androidx.compose.runtime.snapshots.ReaderKind.Companion
                int r8 = androidx.compose.runtime.snapshots.ReaderKind.m3402constructorimpl(r13)
                boolean r8 = r11.m3415isReadInh_f27i8$runtime_release(r8)
                if (r8 != 0) goto L_0x004e
                r26 = r1
                r25 = r2
                r35 = r4
                r27 = r6
                r33 = r7
                r29 = r9
                goto L_0x02df
            L_0x004e:
                boolean r8 = r2.contains(r10)
                if (r8 == 0) goto L_0x026a
                androidx.collection.MutableScatterMap r8 = r2.getMap()
                java.lang.Object r8 = r8.get(r10)
                if (r8 == 0) goto L_0x026a
                boolean r11 = r8 instanceof androidx.collection.MutableScatterSet
                if (r11 == 0) goto L_0x01d2
                androidx.collection.MutableScatterSet r8 = (androidx.collection.MutableScatterSet) r8
                androidx.collection.ScatterSet r8 = (androidx.collection.ScatterSet) r8
                java.lang.Object[] r11 = r8.elements
                long[] r8 = r8.metadata
                int r14 = r8.length
                int r14 = r14 - r13
                if (r14 < 0) goto L_0x026a
                r38 = r14
                r15 = r18
            L_0x0072:
                r13 = r8[r15]
                r26 = r1
                r25 = r2
                long r1 = ~r13
                long r1 = r1 << r12
                long r1 = r1 & r13
                r23 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r1 = r1 & r23
                int r1 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
                if (r1 == 0) goto L_0x01a7
                int r1 = r15 - r38
                int r1 = ~r1
                int r1 = r1 >>> 31
                r2 = 8
                int r1 = 8 - r1
                r2 = r18
            L_0x0091:
                if (r2 >= r1) goto L_0x0194
                r20 = 255(0xff, double:1.26E-321)
                long r27 = r13 & r20
                r16 = 128(0x80, double:6.32E-322)
                int r27 = (r27 > r16 ? 1 : (r27 == r16 ? 0 : -1))
                if (r27 >= 0) goto L_0x0170
                int r27 = r15 << 3
                int r27 = r27 + r2
                r27 = r11[r27]
                r12 = r27
                androidx.compose.runtime.DerivedState r12 = (androidx.compose.runtime.DerivedState) r12
                kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r7)
                r27 = r6
                java.lang.Object r6 = r3.get(r12)
                androidx.compose.runtime.SnapshotMutationPolicy r29 = r12.getPolicy()
                if (r29 != 0) goto L_0x00ba
                androidx.compose.runtime.SnapshotMutationPolicy r29 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            L_0x00ba:
                r30 = r8
                r8 = r29
                androidx.compose.runtime.DerivedState$Record r29 = r12.getCurrentRecord()
                r31 = r11
                java.lang.Object r11 = r29.getCurrentValue()
                boolean r6 = r8.equivalent(r11, r6)
                if (r6 != 0) goto L_0x0162
                androidx.collection.MutableScatterMap r6 = r4.getMap()
                java.lang.Object r6 = r6.get(r12)
                if (r6 == 0) goto L_0x014b
                boolean r8 = r6 instanceof androidx.collection.MutableScatterSet
                if (r8 == 0) goto L_0x0154
                androidx.collection.MutableScatterSet r6 = (androidx.collection.MutableScatterSet) r6
                androidx.collection.ScatterSet r6 = (androidx.collection.ScatterSet) r6
                java.lang.Object[] r8 = r6.elements
                long[] r6 = r6.metadata
                int r11 = r6.length
                r12 = 2
                int r11 = r11 - r12
                if (r11 < 0) goto L_0x014b
                r29 = r9
                r32 = r10
                r12 = r18
            L_0x00ef:
                r9 = r6[r12]
                r34 = r6
                r33 = r7
                long r6 = ~r9
                r28 = 7
                long r6 = r6 << r28
                long r6 = r6 & r9
                r23 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r6 = r6 & r23
                int r6 = (r6 > r23 ? 1 : (r6 == r23 ? 0 : -1))
                if (r6 == 0) goto L_0x013e
                int r6 = r12 - r11
                int r6 = ~r6
                int r6 = r6 >>> 31
                r7 = 8
                int r6 = 8 - r6
                r7 = r18
            L_0x0111:
                if (r7 >= r6) goto L_0x0137
                r20 = 255(0xff, double:1.26E-321)
                long r35 = r9 & r20
                r16 = 128(0x80, double:6.32E-322)
                int r35 = (r35 > r16 ? 1 : (r35 == r16 ? 0 : -1))
                if (r35 >= 0) goto L_0x012d
                int r19 = r12 << 3
                int r19 = r19 + r7
                r35 = r4
                r4 = r8[r19]
                r5.add(r4)
                r4 = 8
                r19 = 1
                goto L_0x0131
            L_0x012d:
                r35 = r4
                r4 = 8
            L_0x0131:
                long r9 = r9 >> r4
                int r7 = r7 + 1
                r4 = r35
                goto L_0x0111
            L_0x0137:
                r35 = r4
                r4 = 8
                if (r6 != r4) goto L_0x017e
                goto L_0x0140
            L_0x013e:
                r35 = r4
            L_0x0140:
                if (r12 == r11) goto L_0x017e
                int r12 = r12 + 1
                r7 = r33
                r6 = r34
                r4 = r35
                goto L_0x00ef
            L_0x014b:
                r35 = r4
                r33 = r7
                r29 = r9
                r32 = r10
                goto L_0x017e
            L_0x0154:
                r35 = r4
                r33 = r7
                r29 = r9
                r32 = r10
                r5.add(r6)
                r19 = 1
                goto L_0x017e
            L_0x0162:
                r35 = r4
                r33 = r7
                r29 = r9
                r32 = r10
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r4 = r0.statesToReread
                r4.add(r12)
                goto L_0x017e
            L_0x0170:
                r35 = r4
                r27 = r6
                r33 = r7
                r30 = r8
                r29 = r9
                r32 = r10
                r31 = r11
            L_0x017e:
                r4 = 8
                long r13 = r13 >> r4
                int r2 = r2 + 1
                r6 = r27
                r9 = r29
                r8 = r30
                r11 = r31
                r10 = r32
                r7 = r33
                r4 = r35
                r12 = 7
                goto L_0x0091
            L_0x0194:
                r35 = r4
                r27 = r6
                r33 = r7
                r30 = r8
                r29 = r9
                r32 = r10
                r31 = r11
                r4 = 8
                if (r1 != r4) goto L_0x0278
                goto L_0x01b5
            L_0x01a7:
                r35 = r4
                r27 = r6
                r33 = r7
                r30 = r8
                r29 = r9
                r32 = r10
                r31 = r11
            L_0x01b5:
                r14 = r38
                if (r15 == r14) goto L_0x0278
                int r15 = r15 + 1
                r38 = r14
                r2 = r25
                r1 = r26
                r6 = r27
                r9 = r29
                r8 = r30
                r11 = r31
                r10 = r32
                r7 = r33
                r4 = r35
                r12 = 7
                goto L_0x0072
            L_0x01d2:
                r26 = r1
                r25 = r2
                r35 = r4
                r27 = r6
                r33 = r7
                r29 = r9
                r32 = r10
                androidx.compose.runtime.DerivedState r8 = (androidx.compose.runtime.DerivedState) r8
                java.lang.Object r1 = r3.get(r8)
                androidx.compose.runtime.SnapshotMutationPolicy r2 = r8.getPolicy()
                if (r2 != 0) goto L_0x01f0
                androidx.compose.runtime.SnapshotMutationPolicy r2 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            L_0x01f0:
                androidx.compose.runtime.DerivedState$Record r4 = r8.getCurrentRecord()
                java.lang.Object r4 = r4.getCurrentValue()
                boolean r1 = r2.equivalent(r4, r1)
                if (r1 != 0) goto L_0x0264
                androidx.collection.MutableScatterMap r1 = r35.getMap()
                java.lang.Object r1 = r1.get(r8)
                if (r1 == 0) goto L_0x0278
                boolean r2 = r1 instanceof androidx.collection.MutableScatterSet
                if (r2 == 0) goto L_0x025e
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r2 = r1.elements
                long[] r1 = r1.metadata
                int r4 = r1.length
                r6 = 2
                int r4 = r4 - r6
                if (r4 < 0) goto L_0x0278
                r6 = r18
            L_0x021b:
                r7 = r1[r6]
                long r9 = ~r7
                r11 = 7
                long r9 = r9 << r11
                long r9 = r9 & r7
                r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r9 = r9 & r11
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r9 == 0) goto L_0x0259
                int r9 = r6 - r4
                int r9 = ~r9
                int r9 = r9 >>> 31
                r10 = 8
                int r9 = 8 - r9
                r10 = r18
            L_0x0236:
                if (r10 >= r9) goto L_0x0255
                r11 = 255(0xff, double:1.26E-321)
                long r13 = r7 & r11
                r11 = 128(0x80, double:6.32E-322)
                int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r13 >= 0) goto L_0x024f
                int r11 = r6 << 3
                int r11 = r11 + r10
                r11 = r2[r11]
                r5.add(r11)
                r11 = 8
                r19 = 1
                goto L_0x0251
            L_0x024f:
                r11 = 8
            L_0x0251:
                long r7 = r7 >> r11
                int r10 = r10 + 1
                goto L_0x0236
            L_0x0255:
                r11 = 8
                if (r9 != r11) goto L_0x0278
            L_0x0259:
                if (r6 == r4) goto L_0x0278
                int r6 = r6 + 1
                goto L_0x021b
            L_0x025e:
                r5.add(r1)
                r19 = 1
                goto L_0x0278
            L_0x0264:
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                r1.add(r8)
                goto L_0x0278
            L_0x026a:
                r26 = r1
                r25 = r2
                r35 = r4
                r27 = r6
                r33 = r7
                r29 = r9
                r32 = r10
            L_0x0278:
                androidx.collection.MutableScatterMap r1 = r35.getMap()
                r2 = r32
                java.lang.Object r1 = r1.get(r2)
                if (r1 == 0) goto L_0x02df
                boolean r2 = r1 instanceof androidx.collection.MutableScatterSet
                if (r2 == 0) goto L_0x02da
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r2 = r1.elements
                long[] r1 = r1.metadata
                int r4 = r1.length
                r6 = 2
                int r4 = r4 - r6
                if (r4 < 0) goto L_0x02df
                r6 = r18
            L_0x0297:
                r7 = r1[r6]
                long r9 = ~r7
                r11 = 7
                long r9 = r9 << r11
                long r9 = r9 & r7
                r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r9 = r9 & r11
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r9 == 0) goto L_0x02d5
                int r9 = r6 - r4
                int r9 = ~r9
                int r9 = r9 >>> 31
                r10 = 8
                int r9 = 8 - r9
                r10 = r18
            L_0x02b2:
                if (r10 >= r9) goto L_0x02d1
                r11 = 255(0xff, double:1.26E-321)
                long r13 = r7 & r11
                r11 = 128(0x80, double:6.32E-322)
                int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r13 >= 0) goto L_0x02cb
                int r11 = r6 << 3
                int r11 = r11 + r10
                r11 = r2[r11]
                r5.add(r11)
                r11 = 8
                r19 = 1
                goto L_0x02cd
            L_0x02cb:
                r11 = 8
            L_0x02cd:
                long r7 = r7 >> r11
                int r10 = r10 + 1
                goto L_0x02b2
            L_0x02d1:
                r11 = 8
                if (r9 != r11) goto L_0x02df
            L_0x02d5:
                if (r6 == r4) goto L_0x02df
                int r6 = r6 + 1
                goto L_0x0297
            L_0x02da:
                r5.add(r1)
                r19 = 1
            L_0x02df:
                int r9 = r29 + 1
                r2 = r25
                r1 = r26
                r6 = r27
                r7 = r33
                r4 = r35
                r12 = 7
                r13 = 2
                goto L_0x0024
            L_0x02ef:
                r25 = r2
                r35 = r4
                r33 = r7
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r1 = r1.iterator()
                r19 = r18
            L_0x02fd:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x05e5
                java.lang.Object r2 = r1.next()
                boolean r4 = r2 instanceof androidx.compose.runtime.snapshots.StateObjectImpl
                if (r4 == 0) goto L_0x0330
                r4 = r2
                androidx.compose.runtime.snapshots.StateObjectImpl r4 = (androidx.compose.runtime.snapshots.StateObjectImpl) r4
                androidx.compose.runtime.snapshots.ReaderKind$Companion r6 = androidx.compose.runtime.snapshots.ReaderKind.Companion
                r6 = 2
                int r7 = androidx.compose.runtime.snapshots.ReaderKind.m3402constructorimpl(r6)
                boolean r4 = r4.m3415isReadInh_f27i8$runtime_release(r7)
                if (r4 != 0) goto L_0x0330
                r38 = r1
                r1 = r3
                r26 = r25
                r15 = r33
            L_0x0322:
                r6 = 8
                r12 = 7
                r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                r16 = 128(0x80, double:6.32E-322)
                r20 = 255(0xff, double:1.26E-321)
                goto L_0x05dc
            L_0x0330:
                r4 = r25
                boolean r6 = r4.contains(r2)
                if (r6 == 0) goto L_0x0552
                androidx.collection.MutableScatterMap r6 = r4.getMap()
                java.lang.Object r6 = r6.get(r2)
                if (r6 == 0) goto L_0x0552
                boolean r7 = r6 instanceof androidx.collection.MutableScatterSet
                if (r7 == 0) goto L_0x04bc
                androidx.collection.MutableScatterSet r6 = (androidx.collection.MutableScatterSet) r6
                androidx.collection.ScatterSet r6 = (androidx.collection.ScatterSet) r6
                java.lang.Object[] r7 = r6.elements
                long[] r6 = r6.metadata
                int r8 = r6.length
                r9 = 2
                int r8 = r8 - r9
                if (r8 < 0) goto L_0x04ae
                r9 = r18
            L_0x0355:
                r10 = r6[r9]
                long r12 = ~r10
                r14 = 7
                long r12 = r12 << r14
                long r12 = r12 & r10
                r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r12 = r12 & r14
                int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r12 == 0) goto L_0x048c
                int r12 = r9 - r8
                int r12 = ~r12
                int r12 = r12 >>> 31
                r13 = 8
                int r12 = 8 - r12
                r13 = r18
            L_0x0370:
                if (r13 >= r12) goto L_0x0475
                r14 = 255(0xff, double:1.26E-321)
                long r25 = r10 & r14
                r14 = 128(0x80, double:6.32E-322)
                int r25 = (r25 > r14 ? 1 : (r25 == r14 ? 0 : -1))
                if (r25 >= 0) goto L_0x044e
                int r14 = r9 << 3
                int r14 = r14 + r13
                r14 = r7[r14]
                androidx.compose.runtime.DerivedState r14 = (androidx.compose.runtime.DerivedState) r14
                r15 = r33
                kotlin.jvm.internal.Intrinsics.checkNotNull(r14, r15)
                r38 = r1
                java.lang.Object r1 = r3.get(r14)
                androidx.compose.runtime.SnapshotMutationPolicy r25 = r14.getPolicy()
                if (r25 != 0) goto L_0x0398
                androidx.compose.runtime.SnapshotMutationPolicy r25 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            L_0x0398:
                r26 = r4
                r4 = r25
                androidx.compose.runtime.DerivedState$Record r25 = r14.getCurrentRecord()
                r27 = r6
                java.lang.Object r6 = r25.getCurrentValue()
                boolean r1 = r4.equivalent(r6, r1)
                if (r1 != 0) goto L_0x0440
                androidx.collection.MutableScatterMap r1 = r35.getMap()
                java.lang.Object r1 = r1.get(r14)
                if (r1 == 0) goto L_0x0429
                boolean r4 = r1 instanceof androidx.collection.MutableScatterSet
                if (r4 == 0) goto L_0x0432
                androidx.collection.MutableScatterSet r1 = (androidx.collection.MutableScatterSet) r1
                androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
                java.lang.Object[] r4 = r1.elements
                long[] r1 = r1.metadata
                int r6 = r1.length
                r14 = 2
                int r6 = r6 - r14
                if (r6 < 0) goto L_0x0429
                r29 = r2
                r25 = r3
                r14 = r18
            L_0x03cd:
                r2 = r1[r14]
                r30 = r7
                r31 = r8
                long r7 = ~r2
                r28 = 7
                long r7 = r7 << r28
                long r7 = r7 & r2
                r23 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r7 = r7 & r23
                int r7 = (r7 > r23 ? 1 : (r7 == r23 ? 0 : -1))
                if (r7 == 0) goto L_0x041c
                int r7 = r14 - r6
                int r7 = ~r7
                int r7 = r7 >>> 31
                r8 = 8
                int r7 = 8 - r7
                r8 = r18
            L_0x03ef:
                if (r8 >= r7) goto L_0x0415
                r20 = 255(0xff, double:1.26E-321)
                long r32 = r2 & r20
                r16 = 128(0x80, double:6.32E-322)
                int r32 = (r32 > r16 ? 1 : (r32 == r16 ? 0 : -1))
                if (r32 >= 0) goto L_0x040b
                int r19 = r14 << 3
                int r19 = r19 + r8
                r32 = r1
                r1 = r4[r19]
                r5.add(r1)
                r1 = 8
                r19 = 1
                goto L_0x040f
            L_0x040b:
                r32 = r1
                r1 = 8
            L_0x040f:
                long r2 = r2 >> r1
                int r8 = r8 + 1
                r1 = r32
                goto L_0x03ef
            L_0x0415:
                r32 = r1
                r1 = 8
                if (r7 != r1) goto L_0x045e
                goto L_0x041e
            L_0x041c:
                r32 = r1
            L_0x041e:
                if (r14 == r6) goto L_0x045e
                int r14 = r14 + 1
                r7 = r30
                r8 = r31
                r1 = r32
                goto L_0x03cd
            L_0x0429:
                r29 = r2
                r25 = r3
                r30 = r7
                r31 = r8
                goto L_0x045e
            L_0x0432:
                r29 = r2
                r25 = r3
                r30 = r7
                r31 = r8
                r5.add(r1)
                r19 = 1
                goto L_0x045e
            L_0x0440:
                r29 = r2
                r25 = r3
                r30 = r7
                r31 = r8
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                r1.add(r14)
                goto L_0x045e
            L_0x044e:
                r38 = r1
                r29 = r2
                r25 = r3
                r26 = r4
                r27 = r6
                r30 = r7
                r31 = r8
                r15 = r33
            L_0x045e:
                r1 = 8
                long r10 = r10 >> r1
                int r13 = r13 + 1
                r1 = r38
                r33 = r15
                r3 = r25
                r4 = r26
                r6 = r27
                r2 = r29
                r7 = r30
                r8 = r31
                goto L_0x0370
            L_0x0475:
                r38 = r1
                r29 = r2
                r25 = r3
                r26 = r4
                r27 = r6
                r30 = r7
                r31 = r8
                r15 = r33
                r1 = 8
                if (r12 != r1) goto L_0x04b8
                r8 = r31
                goto L_0x049a
            L_0x048c:
                r38 = r1
                r29 = r2
                r25 = r3
                r26 = r4
                r27 = r6
                r30 = r7
                r15 = r33
            L_0x049a:
                if (r9 == r8) goto L_0x04b8
                int r9 = r9 + 1
                r1 = r38
                r33 = r15
                r3 = r25
                r4 = r26
                r6 = r27
                r2 = r29
                r7 = r30
                goto L_0x0355
            L_0x04ae:
                r38 = r1
                r29 = r2
                r25 = r3
                r26 = r4
                r15 = r33
            L_0x04b8:
                r1 = r25
                goto L_0x055b
            L_0x04bc:
                r38 = r1
                r29 = r2
                r25 = r3
                r26 = r4
                r15 = r33
                androidx.compose.runtime.DerivedState r6 = (androidx.compose.runtime.DerivedState) r6
                r1 = r25
                java.lang.Object r2 = r1.get(r6)
                androidx.compose.runtime.SnapshotMutationPolicy r3 = r6.getPolicy()
                if (r3 != 0) goto L_0x04d8
                androidx.compose.runtime.SnapshotMutationPolicy r3 = androidx.compose.runtime.SnapshotStateKt.structuralEqualityPolicy()
            L_0x04d8:
                androidx.compose.runtime.DerivedState$Record r4 = r6.getCurrentRecord()
                java.lang.Object r4 = r4.getCurrentValue()
                boolean r2 = r3.equivalent(r4, r2)
                if (r2 != 0) goto L_0x054c
                androidx.collection.MutableScatterMap r2 = r35.getMap()
                java.lang.Object r2 = r2.get(r6)
                if (r2 == 0) goto L_0x055b
                boolean r3 = r2 instanceof androidx.collection.MutableScatterSet
                if (r3 == 0) goto L_0x0546
                androidx.collection.MutableScatterSet r2 = (androidx.collection.MutableScatterSet) r2
                androidx.collection.ScatterSet r2 = (androidx.collection.ScatterSet) r2
                java.lang.Object[] r3 = r2.elements
                long[] r2 = r2.metadata
                int r4 = r2.length
                r6 = 2
                int r4 = r4 - r6
                if (r4 < 0) goto L_0x055b
                r6 = r18
            L_0x0503:
                r7 = r2[r6]
                long r9 = ~r7
                r11 = 7
                long r9 = r9 << r11
                long r9 = r9 & r7
                r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r9 = r9 & r11
                int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r9 == 0) goto L_0x0541
                int r9 = r6 - r4
                int r9 = ~r9
                int r9 = r9 >>> 31
                r10 = 8
                int r9 = 8 - r9
                r10 = r18
            L_0x051e:
                if (r10 >= r9) goto L_0x053d
                r11 = 255(0xff, double:1.26E-321)
                long r13 = r7 & r11
                r11 = 128(0x80, double:6.32E-322)
                int r13 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r13 >= 0) goto L_0x0537
                int r11 = r6 << 3
                int r11 = r11 + r10
                r11 = r3[r11]
                r5.add(r11)
                r11 = 8
                r19 = 1
                goto L_0x0539
            L_0x0537:
                r11 = 8
            L_0x0539:
                long r7 = r7 >> r11
                int r10 = r10 + 1
                goto L_0x051e
            L_0x053d:
                r11 = 8
                if (r9 != r11) goto L_0x055b
            L_0x0541:
                if (r6 == r4) goto L_0x055b
                int r6 = r6 + 1
                goto L_0x0503
            L_0x0546:
                r5.add(r2)
                r19 = 1
                goto L_0x055b
            L_0x054c:
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r2 = r0.statesToReread
                r2.add(r6)
                goto L_0x055b
            L_0x0552:
                r38 = r1
                r29 = r2
                r1 = r3
                r26 = r4
                r15 = r33
            L_0x055b:
                androidx.collection.MutableScatterMap r2 = r35.getMap()
                r3 = r29
                java.lang.Object r2 = r2.get(r3)
                if (r2 == 0) goto L_0x0322
                boolean r3 = r2 instanceof androidx.collection.MutableScatterSet
                if (r3 == 0) goto L_0x05cb
                androidx.collection.MutableScatterSet r2 = (androidx.collection.MutableScatterSet) r2
                androidx.collection.ScatterSet r2 = (androidx.collection.ScatterSet) r2
                java.lang.Object[] r3 = r2.elements
                long[] r2 = r2.metadata
                int r4 = r2.length
                r6 = 2
                int r4 = r4 - r6
                if (r4 < 0) goto L_0x0322
                r7 = r18
            L_0x057a:
                r8 = r2[r7]
                long r10 = ~r8
                r12 = 7
                long r10 = r10 << r12
                long r10 = r10 & r8
                r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r10 = r10 & r13
                int r10 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
                if (r10 == 0) goto L_0x05bf
                int r10 = r7 - r4
                int r10 = ~r10
                int r10 = r10 >>> 31
                r11 = 8
                int r10 = 8 - r10
                r11 = r18
            L_0x0595:
                if (r11 >= r10) goto L_0x05b6
                r20 = 255(0xff, double:1.26E-321)
                long r23 = r8 & r20
                r16 = 128(0x80, double:6.32E-322)
                int r23 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
                if (r23 >= 0) goto L_0x05af
                int r19 = r7 << 3
                int r19 = r19 + r11
                r6 = r3[r19]
                r5.add(r6)
                r6 = 8
                r19 = 1
                goto L_0x05b1
            L_0x05af:
                r6 = 8
            L_0x05b1:
                long r8 = r8 >> r6
                int r11 = r11 + 1
                r6 = 2
                goto L_0x0595
            L_0x05b6:
                r6 = 8
                r16 = 128(0x80, double:6.32E-322)
                r20 = 255(0xff, double:1.26E-321)
                if (r10 != r6) goto L_0x05dc
                goto L_0x05c5
            L_0x05bf:
                r6 = 8
                r16 = 128(0x80, double:6.32E-322)
                r20 = 255(0xff, double:1.26E-321)
            L_0x05c5:
                if (r7 == r4) goto L_0x05dc
                int r7 = r7 + 1
                r6 = 2
                goto L_0x057a
            L_0x05cb:
                r6 = 8
                r12 = 7
                r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                r16 = 128(0x80, double:6.32E-322)
                r20 = 255(0xff, double:1.26E-321)
                r5.add(r2)
                r19 = 1
            L_0x05dc:
                r3 = r1
                r33 = r15
                r25 = r26
                r1 = r38
                goto L_0x02fd
            L_0x05e5:
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                boolean r1 = r1.isNotEmpty()
                if (r1 == 0) goto L_0x060e
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                int r2 = r1.getSize()
                if (r2 <= 0) goto L_0x0609
                java.lang.Object[] r1 = r1.getContent()
            L_0x05f9:
                r3 = r1[r18]
                androidx.compose.runtime.DerivedState r3 = (androidx.compose.runtime.DerivedState) r3
                r0.rereadDerivedState(r3)
                r3 = 1
                int r4 = r18 + 1
                if (r4 < r2) goto L_0x0606
                goto L_0x0609
            L_0x0606:
                r18 = r4
                goto L_0x05f9
            L_0x0609:
                androidx.compose.runtime.collection.MutableVector<androidx.compose.runtime.DerivedState<?>> r1 = r0.statesToReread
                r1.clear()
            L_0x060e:
                return r19
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotStateObserver.ObservedScopeMap.recordInvalidation(java.util.Set):boolean");
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            long[] jArr;
            long[] jArr2;
            int i;
            MutableObjectIntMap mutableObjectIntMap;
            DerivedState<?> derivedState2 = derivedState;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            Object obj = this.valueToScopes.getMap().get(derivedState2);
            if (obj == null) {
                return;
            }
            if (obj instanceof MutableScatterSet) {
                ScatterSet scatterSet = (MutableScatterSet) obj;
                Object[] objArr = scatterSet.elements;
                long[] jArr3 = scatterSet.metadata;
                int length = jArr3.length - 2;
                if (length >= 0) {
                    int i2 = 0;
                    while (true) {
                        long j = jArr3[i2];
                        if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i3 = 8;
                            int i4 = 8 - ((~(i2 - length)) >>> 31);
                            int i5 = 0;
                            while (i5 < i4) {
                                if ((j & 255) < 128) {
                                    Object obj2 = objArr[(i2 << 3) + i5];
                                    MutableObjectIntMap mutableObjectIntMap2 = mutableScatterMap.get(obj2);
                                    jArr2 = jArr3;
                                    if (mutableObjectIntMap2 == null) {
                                        mutableObjectIntMap = new MutableObjectIntMap(0, 1, (DefaultConstructorMarker) null);
                                        mutableScatterMap.set(obj2, mutableObjectIntMap);
                                        Unit unit = Unit.INSTANCE;
                                    } else {
                                        mutableObjectIntMap = mutableObjectIntMap2;
                                    }
                                    recordRead(derivedState2, id, obj2, mutableObjectIntMap);
                                    i = 8;
                                } else {
                                    jArr2 = jArr3;
                                    i = i3;
                                }
                                j >>= i;
                                i5++;
                                i3 = i;
                                jArr3 = jArr2;
                            }
                            jArr = jArr3;
                            if (i4 != i3) {
                                return;
                            }
                        } else {
                            jArr = jArr3;
                        }
                        if (i2 != length) {
                            i2++;
                            jArr3 = jArr;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                MutableObjectIntMap mutableObjectIntMap3 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap3 == null) {
                    mutableObjectIntMap3 = new MutableObjectIntMap(0, 1, (DefaultConstructorMarker) null);
                    mutableScatterMap.set(obj, mutableObjectIntMap3);
                    Unit unit2 = Unit.INSTANCE;
                }
                recordRead(derivedState2, id, obj, mutableObjectIntMap3);
            }
        }

        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            ScatterSet scatterSet = mutableScatterSet;
            Function1<Object, Unit> function1 = this.onChanged;
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                function1.invoke(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        }
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
            mutableScatterSet.clear();
        }
    }

    public final void clear(Object obj) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.getContent()[i2];
                observedScopeMap.clearScopeObservations(obj);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill((T[]) mutableVector.getContent(), null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clearIf(Function1<Object, Boolean> function1) {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ObservedScopeMap observedScopeMap = (ObservedScopeMap) mutableVector.getContent()[i2];
                observedScopeMap.removeScopeIf(function1);
                if (!observedScopeMap.hasScopeObservations()) {
                    i++;
                } else if (i > 0) {
                    mutableVector.getContent()[i2 - i] = mutableVector.getContent()[i2];
                }
            }
            int i3 = size - i;
            ArraysKt.fill((T[]) mutableVector.getContent(), null, i3, size);
            mutableVector.setSize(i3);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                do {
                    ((ObservedScopeMap) content[i]).clear();
                    i++;
                } while (i < size);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
