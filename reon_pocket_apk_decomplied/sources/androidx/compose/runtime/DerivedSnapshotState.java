package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001'B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001eJ:\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00018\u00008G¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011¨\u0006("}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/DerivedState;", "calculation", "Lkotlin/Function0;", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "currentRecord", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "debuggerDisplayValue", "getDebuggerDisplayValue$annotations", "()V", "getDebuggerDisplayValue", "()Ljava/lang/Object;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "value", "getValue", "current", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readable", "forceDependencyReads", "", "displayValue", "", "prependStateRecord", "", "toString", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DerivedState.kt */
final class DerivedSnapshotState<T> extends StateObjectImpl implements DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>();
    private final SnapshotMutationPolicy<T> policy;

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    public DerivedSnapshotState(Function0<? extends T> function0, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 +*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001+B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\u001a\u0010$\u001a\u00020%2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)J\u001a\u0010*\u001a\u00020\u00152\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'2\u0006\u0010(\u001a\u00020)R\u0014\u0010\u0005\u001a\u00028\u00018VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019¨\u0006,"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "()V", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "dependencies", "Landroidx/collection/ObjectIntMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "getDependencies", "()Landroidx/collection/ObjectIntMap;", "setDependencies", "(Landroidx/collection/ObjectIntMap;)V", "result", "", "getResult", "setResult", "(Ljava/lang/Object;)V", "resultHash", "", "getResultHash", "()I", "setResultHash", "(I)V", "validSnapshotId", "getValidSnapshotId", "setValidSnapshotId", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "assign", "", "value", "create", "isValid", "", "derivedState", "Landroidx/compose/runtime/DerivedState;", "snapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "readableHash", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DerivedState.kt */
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final Object Unset = new Object();
        private ObjectIntMap<StateObject> dependencies = ObjectIntMapKt.emptyObjectIntMap();
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", "", "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: DerivedState.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }
        }

        public final int getValidSnapshotId() {
            return this.validSnapshotId;
        }

        public final void setValidSnapshotId(int i) {
            this.validSnapshotId = i;
        }

        public final int getValidSnapshotWriteCount() {
            return this.validSnapshotWriteCount;
        }

        public final void setValidSnapshotWriteCount(int i) {
            this.validSnapshotWriteCount = i;
        }

        public ObjectIntMap<StateObject> getDependencies() {
            return this.dependencies;
        }

        public void setDependencies(ObjectIntMap<StateObject> objectIntMap) {
            this.dependencies = objectIntMap;
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final int getResultHash() {
            return this.resultHash;
        }

        public final void setResultHash(int i) {
            this.resultHash = i;
        }

        public void assign(StateRecord stateRecord) {
            Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            ResultRecord resultRecord = (ResultRecord) stateRecord;
            setDependencies(resultRecord.getDependencies());
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        public StateRecord create() {
            return new ResultRecord();
        }

        public T getCurrentValue() {
            return this.result;
        }

        public final boolean isValid(DerivedState<?> derivedState, Snapshot snapshot) {
            boolean z;
            boolean z2;
            synchronized (SnapshotKt.getLock()) {
                z = false;
                z2 = (this.validSnapshotId == snapshot.getId() && this.validSnapshotWriteCount == snapshot.getWriteCount$runtime_release()) ? false : true;
            }
            if (this.result != Unset && (!z2 || this.resultHash == readableHash(derivedState, snapshot))) {
                z = true;
            }
            if (z && z2) {
                synchronized (SnapshotKt.getLock()) {
                    this.validSnapshotId = snapshot.getId();
                    this.validSnapshotWriteCount = snapshot.getWriteCount$runtime_release();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return z;
        }

        /* JADX INFO: finally extract failed */
        public final int readableHash(DerivedState<?> derivedState, Snapshot snapshot) {
            ObjectIntMap<StateObject> dependencies2;
            int i;
            int i2;
            StateRecord stateRecord;
            DerivedState<?> derivedState2 = derivedState;
            Snapshot snapshot2 = snapshot;
            synchronized (SnapshotKt.getLock()) {
                try {
                    dependencies2 = getDependencies();
                } catch (Throwable th) {
                    throw th;
                }
            }
            char c = 7;
            if (!dependencies2.isNotEmpty()) {
                return 7;
            }
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            int size = derivedStateObservers.getSize();
            if (size > 0) {
                Object[] content = derivedStateObservers.getContent();
                int i3 = 0;
                do {
                    ((DerivedStateObserver) content[i3]).start(derivedState2);
                    i3++;
                } while (i3 < size);
            }
            try {
                Object[] objArr = dependencies2.keys;
                int[] iArr = dependencies2.values;
                long[] jArr = dependencies2.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i4 = 7;
                    int i5 = 0;
                    while (true) {
                        long j = jArr[i5];
                        if ((((~j) << c) & j & -9187201950435737472L) != -9187201950435737472L) {
                            int i6 = 8;
                            int i7 = 8 - ((~(i5 - length)) >>> 31);
                            int i8 = 0;
                            while (i8 < i7) {
                                if ((j & 255) < 128) {
                                    int i9 = (i5 << 3) + i8;
                                    StateObject stateObject = (StateObject) objArr[i9];
                                    if (iArr[i9] == 1) {
                                        if (stateObject instanceof DerivedSnapshotState) {
                                            stateRecord = ((DerivedSnapshotState) stateObject).current(snapshot2);
                                        } else {
                                            stateRecord = SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot2);
                                        }
                                        i4 = (((i4 * 31) + ActualJvm_jvmKt.identityHashCode(stateRecord)) * 31) + stateRecord.getSnapshotId$runtime_release();
                                    }
                                    i2 = 8;
                                } else {
                                    i2 = i6;
                                }
                                j >>= i2;
                                i8++;
                                i6 = i2;
                            }
                            if (i7 != i6) {
                                break;
                            }
                        }
                        if (i5 == length) {
                            break;
                        }
                        i5++;
                        c = 7;
                    }
                    i = i4;
                } else {
                    i = 7;
                }
                Unit unit = Unit.INSTANCE;
                int size2 = derivedStateObservers.getSize();
                if (size2 <= 0) {
                    return i;
                }
                Object[] content2 = derivedStateObservers.getContent();
                int i10 = 0;
                do {
                    ((DerivedStateObserver) content2[i10]).done(derivedState2);
                    i10++;
                } while (i10 < size2);
                return i;
            } catch (Throwable th2) {
                int size3 = derivedStateObservers.getSize();
                if (size3 > 0) {
                    Object[] content3 = derivedStateObservers.getContent();
                    int i11 = 0;
                    do {
                        ((DerivedStateObserver) content3[i11]).done(derivedState2);
                        i11++;
                    } while (i11 < size3);
                }
                throw th2;
            }
        }
    }

    public final StateRecord current(Snapshot snapshot) {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    private final ResultRecord<T> currentRecord(ResultRecord<T> resultRecord, Snapshot snapshot, boolean z, Function0<? extends T> function0) {
        SnapshotMutationPolicy policy2;
        int i;
        ResultRecord<T> resultRecord2 = resultRecord;
        DerivedState derivedState = this;
        if (resultRecord2.isValid(derivedState, snapshot)) {
            if (z) {
                MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
                int size = derivedStateObservers.getSize();
                if (size > 0) {
                    Object[] content = derivedStateObservers.getContent();
                    int i2 = 0;
                    do {
                        ((DerivedStateObserver) content[i2]).start(derivedState);
                        i2++;
                    } while (i2 < size);
                }
                try {
                    ObjectIntMap<StateObject> dependencies = resultRecord.getDependencies();
                    IntRef intRef = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
                    if (intRef == null) {
                        intRef = new IntRef(0);
                        SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(intRef);
                    }
                    int element = intRef.getElement();
                    Object[] objArr = dependencies.keys;
                    int[] iArr = dependencies.values;
                    long[] jArr = dependencies.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i3 = 0;
                        while (true) {
                            long j = jArr[i3];
                            long[] jArr2 = jArr;
                            if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                                int i4 = 8;
                                int i5 = 8 - ((~(i3 - length)) >>> 31);
                                int i6 = 0;
                                while (i6 < i5) {
                                    if ((j & 255) < 128) {
                                        int i7 = (i3 << 3) + i6;
                                        StateObject stateObject = (StateObject) objArr[i7];
                                        intRef.setElement(element + iArr[i7]);
                                        Function1<Object, Unit> readObserver$runtime_release = snapshot.getReadObserver$runtime_release();
                                        if (readObserver$runtime_release != null) {
                                            readObserver$runtime_release.invoke(stateObject);
                                        }
                                        i = 8;
                                    } else {
                                        i = i4;
                                    }
                                    j >>= i;
                                    i6++;
                                    i4 = i;
                                    Snapshot snapshot2 = snapshot;
                                }
                                if (i5 != i4) {
                                    break;
                                }
                            }
                            if (i3 == length) {
                                break;
                            }
                            i3++;
                            Snapshot snapshot3 = snapshot;
                            jArr = jArr2;
                        }
                    }
                    intRef.setElement(element);
                    Unit unit = Unit.INSTANCE;
                    int size2 = derivedStateObservers.getSize();
                    if (size2 > 0) {
                        Object[] content2 = derivedStateObservers.getContent();
                        int i8 = 0;
                        do {
                            ((DerivedStateObserver) content2[i8]).done(derivedState);
                            i8++;
                        } while (i8 < size2);
                    }
                } catch (Throwable th) {
                    int size3 = derivedStateObservers.getSize();
                    if (size3 > 0) {
                        Object[] content3 = derivedStateObservers.getContent();
                        int i9 = 0;
                        do {
                            ((DerivedStateObserver) content3[i9]).done(derivedState);
                            i9++;
                        } while (i9 < size3);
                    }
                    throw th;
                }
            }
            return resultRecord2;
        }
        int i10 = 0;
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, (DefaultConstructorMarker) null);
        IntRef intRef2 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
        if (intRef2 == null) {
            intRef2 = new IntRef(0);
            SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.set(intRef2);
        }
        int element2 = intRef2.getElement();
        MutableVector<DerivedStateObserver> derivedStateObservers2 = SnapshotStateKt.derivedStateObservers();
        int size4 = derivedStateObservers2.getSize();
        if (size4 > 0) {
            Object[] content4 = derivedStateObservers2.getContent();
            int i11 = 0;
            do {
                ((DerivedStateObserver) content4[i11]).start(derivedState);
                i11++;
            } while (i11 < size4);
        }
        try {
            intRef2.setElement(element2 + 1);
            Object observe = Snapshot.Companion.observe(new DerivedSnapshotState$currentRecord$result$1$1$result$1(this, intRef2, mutableObjectIntMap, element2), (Function1<Object, Unit>) null, function0);
            intRef2.setElement(element2);
            int size5 = derivedStateObservers2.getSize();
            if (size5 > 0) {
                Object[] content5 = derivedStateObservers2.getContent();
                do {
                    ((DerivedStateObserver) content5[i10]).done(derivedState);
                    i10++;
                } while (i10 < size5);
            }
            synchronized (SnapshotKt.getLock()) {
                Snapshot current = Snapshot.Companion.getCurrent();
                if (resultRecord.getResult() == ResultRecord.Companion.getUnset() || (policy2 = getPolicy()) == null || !policy2.equivalent(observe, resultRecord.getResult())) {
                    resultRecord2 = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                    resultRecord2.setDependencies(mutableObjectIntMap);
                    resultRecord2.setResultHash(resultRecord2.readableHash(this, current));
                    resultRecord2.setValidSnapshotId(snapshot.getId());
                    resultRecord2.setValidSnapshotWriteCount(snapshot.getWriteCount$runtime_release());
                    resultRecord2.setResult(observe);
                } else {
                    resultRecord2.setDependencies(mutableObjectIntMap);
                    resultRecord2.setResultHash(resultRecord2.readableHash(this, current));
                    resultRecord2.setValidSnapshotId(snapshot.getId());
                    resultRecord2.setValidSnapshotWriteCount(snapshot.getWriteCount$runtime_release());
                }
            }
            IntRef intRef3 = (IntRef) SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel.get();
            if (intRef3 != null && intRef3.getElement() == 0) {
                Snapshot.Companion.notifyObjectsInitialized();
            }
            return resultRecord2;
        } catch (Throwable th2) {
            int size6 = derivedStateObservers2.getSize();
            if (size6 > 0) {
                Object[] content6 = derivedStateObservers2.getContent();
                do {
                    ((DerivedStateObserver) content6[i10]).done(derivedState);
                    i10++;
                } while (i10 < size6);
            }
            throw th2;
        }
    }

    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    public void prependStateRecord(StateRecord stateRecord) {
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = (ResultRecord) stateRecord;
    }

    public T getValue() {
        Function1<Object, Unit> readObserver$runtime_release = Snapshot.Companion.getCurrent().getReadObserver$runtime_release();
        if (readObserver$runtime_release != null) {
            readObserver$runtime_release.invoke(this);
        }
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), true, this.calculation).getResult();
    }

    public DerivedState.Record<T> getCurrentRecord() {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first), Snapshot.Companion.getCurrent(), false, this.calculation);
    }

    public String toString() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }

    public final T getDebuggerDisplayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return resultRecord.getResult();
        }
        return null;
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        if (resultRecord.isValid(this, Snapshot.Companion.getCurrent())) {
            return String.valueOf(resultRecord.getResult());
        }
        return "<Not calculated>";
    }
}
