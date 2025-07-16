package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.snapshots.StateObject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0001QB\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\b\u0010&\u001a\u00020 H\u0016J3\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\u001d2\u001e\u0010)\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+0*H\bJ\u0016\u0010,\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0016\u0010-\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010.\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010/J\u0015\u00100\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\u001dH\u0016J\u000f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0002J\u0015\u00105\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00101J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00028\u000007H\u0016J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00028\u0000072\u0006\u0010!\u001a\u00020\u0017H\u0016J.\u00108\u001a\u0002H9\"\u0004\b\u0001\u001092\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u0002H90*H\b¢\u0006\u0002\u0010:J\"\u0010;\u001a\u00020\u001d2\u0018\u0010)\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\u001d0*H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010=\u001a\u00020\rH\u0016J\u0015\u0010>\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u0016\u0010?\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0015\u0010@\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0017H\u0016¢\u0006\u0002\u0010/J\u0016\u0010A\u001a\u00020 2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017J\u0016\u0010D\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016J+\u0010E\u001a\u00020\u00172\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u0017H\u0000¢\u0006\u0002\bHJ\u001e\u0010I\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010B\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u0017H\u0016J\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000\bJ3\u0010M\u001a\u00020 2\b\b\u0002\u0010(\u001a\u00020\u001d2\u001e\u0010)\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+0*H\bJ3\u0010N\u001a\u0002H9\"\u0004\b\u0001\u001092\u001d\u0010)\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u0002H90*¢\u0006\u0002\bOH\b¢\u0006\u0002\u0010:J3\u0010P\u001a\u0002H9\"\u0004\b\u0001\u001092\u001d\u0010)\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0004\u0012\u0002H90*¢\u0006\u0002\bOH\b¢\u0006\u0002\u0010:R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8AX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128@X\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00178@X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019¨\u0006R"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "()V", "debuggerDisplayValue", "", "getDebuggerDisplayValue$annotations", "getDebuggerDisplayValue", "()Ljava/util/List;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "size", "", "getSize", "()I", "structure", "getStructure$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "conditionalUpdate", "structural", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "mutate", "R", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "mutateBoolean", "prependStateRecord", "value", "remove", "removeAll", "removeAt", "removeRange", "fromIndex", "toIndex", "retainAll", "retainAllInRange", "start", "end", "retainAllInRange$runtime_release", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "toList", "update", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateList.kt */
public final class SnapshotStateList<T> implements StateObject, List<T>, RandomAccess, KMutableList {
    public static final int $stable = 0;
    private StateRecord firstStateRecord = new StateListStateRecord(ExtensionsKt.persistentListOf());

    public static /* synthetic */ void getDebuggerDisplayValue$annotations() {
    }

    public static /* synthetic */ void getReadable$runtime_release$annotations() {
    }

    public /* synthetic */ StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return StateObject.CC.$default$mergeRecords(this, stateRecord, stateRecord2, stateRecord3);
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ T remove(int i) {
        return removeAt(i);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public void prependStateRecord(StateRecord stateRecord) {
        stateRecord.setNext$runtime_release(getFirstStateRecord());
        Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.firstStateRecord = (StateListStateRecord) stateRecord;
    }

    public final List<T> toList() {
        return getReadable$runtime_release().getList$runtime_release();
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord2, this);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "structuralChange", "getStructuralChange$runtime_release", "setStructuralChange$runtime_release", "assign", "", "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SnapshotStateList.kt */
    public static final class StateListStateRecord<T> extends StateRecord {
        public static final int $stable = 8;
        private PersistentList<? extends T> list;
        private int modification;
        private int structuralChange;

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            this.list = persistentList;
        }

        public StateListStateRecord(PersistentList<? extends T> persistentList) {
            this.list = persistentList;
        }

        public final int getModification$runtime_release() {
            return this.modification;
        }

        public final void setModification$runtime_release(int i) {
            this.modification = i;
        }

        public final int getStructuralChange$runtime_release() {
            return this.structuralChange;
        }

        public final void setStructuralChange$runtime_release(int i) {
            this.structuralChange = i;
        }

        public void assign(StateRecord stateRecord) {
            synchronized (SnapshotStateListKt.sync) {
                Intrinsics.checkNotNull(stateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord.assign$lambda$0>");
                this.list = ((StateListStateRecord) stateRecord).list;
                this.modification = ((StateListStateRecord) stateRecord).modification;
                this.structuralChange = ((StateListStateRecord) stateRecord).structuralChange;
                Unit unit = Unit.INSTANCE;
            }
        }

        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    public boolean contains(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().contains(obj);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return getReadable$runtime_release().getList$runtime_release().containsAll(collection);
    }

    public T get(int i) {
        return getReadable$runtime_release().getList$runtime_release().get(i);
    }

    public int indexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(obj);
    }

    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    public Iterator<T> iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object obj) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(obj);
    }

    public ListIterator<T> listIterator() {
        return new StateListIterator<>(this, 0);
    }

    public ListIterator<T> listIterator(int i) {
        return new StateListIterator<>(this, i);
    }

    public List<T> subList(int i, int i2) {
        if (i >= 0 && i <= i2 && i2 <= size()) {
            return new SubList<>(this, i, i2);
        }
        throw new IllegalArgumentException("fromIndex or toIndex are out of bounds".toString());
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        return mutateBoolean(new SnapshotStateList$addAll$1(i, collection));
    }

    public T removeAt(int i) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        T t = get(i);
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList removeAt = list$runtime_release.removeAt(i);
            if (Intrinsics.areEqual((Object) removeAt, (Object) list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(removeAt);
                        z = true;
                        stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return t;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        return mutateBoolean(new SnapshotStateList$retainAll$1(collection));
    }

    public T set(int i, T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        T t2 = get(i);
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = list$runtime_release.set(i, t);
            if (Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(persistentList);
                        z = true;
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return t2;
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> collection, int i, int i2) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        int size = size();
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            builder.subList(i, i2).retainAll(collection);
            Unit unit2 = Unit.INSTANCE;
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(build);
                        z = true;
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return size - size();
    }

    private final <R> R writable(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        Snapshot current;
        R invoke;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord stateRecord = (StateListStateRecord) firstStateRecord2;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            try {
                current = Snapshot.Companion.getCurrent();
                invoke = function1.invoke(SnapshotKt.writableRecord(stateRecord, this, current));
                InlineMarker.finallyStart(1);
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(current, this);
        return invoke;
    }

    private final <R> R withCurrent(Function1<? super StateListStateRecord<T>, ? extends R> function1) {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return function1.invoke(SnapshotKt.current((StateListStateRecord) firstStateRecord2));
    }

    private final <R> R mutate(Function1<? super List<T>, ? extends R> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        R invoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(build);
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                            stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                            z = true;
                        } else {
                            z = false;
                        }
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return invoke;
    }

    private final boolean conditionalUpdate(boolean z, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z2;
        Snapshot current;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            z2 = false;
            if (Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(persistentList);
                            if (z) {
                                stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                            }
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                            z2 = true;
                        }
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, this);
        } while (!z2);
        return true;
    }

    static /* synthetic */ boolean conditionalUpdate$default(SnapshotStateList snapshotStateList, boolean z, Function1 function1, int i, Object obj) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z2;
        Snapshot current;
        if ((i & 1) != 0) {
            z = true;
        }
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            z2 = false;
            if (Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord3 = snapshotStateList.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                try {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                    synchronized (SnapshotStateListKt.sync) {
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(persistentList);
                            if (z) {
                                stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                            }
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                            z2 = true;
                        }
                        InlineMarker.finallyStart(1);
                    }
                    InlineMarker.finallyEnd(1);
                    InlineMarker.finallyStart(1);
                } catch (Throwable th) {
                    throw th;
                }
            }
            InlineMarker.finallyEnd(1);
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!z2);
        return true;
    }

    public final int getStructure$runtime_release() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2)).getStructuralChange$runtime_release();
    }

    public boolean add(T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList add = list$runtime_release.add(t);
            z = false;
            if (Intrinsics.areEqual((Object) add, (Object) list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(add);
                        stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    public void add(int i, T t) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList add = list$runtime_release.add(i, t);
            if (!Intrinsics.areEqual((Object) add, (Object) list$runtime_release)) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(add);
                            z = true;
                            stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        } else {
                            z = false;
                        }
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            } else {
                return;
            }
        } while (!z);
    }

    public boolean addAll(Collection<? extends T> collection) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends T> addAll = list$runtime_release.addAll(collection);
            z = false;
            if (Intrinsics.areEqual((Object) addAll, (Object) list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(addAll);
                        stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    public void clear() {
        Snapshot current;
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateRecord stateRecord = (StateListStateRecord) firstStateRecord2;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.Companion.getCurrent();
            StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
            synchronized (SnapshotStateListKt.sync) {
                stateListStateRecord.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord.setModification$runtime_release(stateListStateRecord.getModification$runtime_release() + 1);
                stateListStateRecord.setStructuralChange$runtime_release(stateListStateRecord.getStructuralChange$runtime_release() + 1);
            }
        }
        SnapshotKt.notifyWrite(current, this);
    }

    public boolean remove(Object obj) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList remove = list$runtime_release.remove(obj);
            z = false;
            if (Intrinsics.areEqual((Object) remove, (Object) list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(remove);
                        stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        boolean z;
        Snapshot current;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<? extends Object> removeAll = list$runtime_release.removeAll(collection);
            z = false;
            if (Intrinsics.areEqual((Object) removeAll, (Object) list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(removeAll);
                        stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        z = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return true;
    }

    public final void removeRange(int i, int i2) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            builder.subList(i, i2).clear();
            Unit unit2 = Unit.INSTANCE;
            PersistentList build = builder.build();
            if (!Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.Companion.getCurrent();
                    StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                    synchronized (SnapshotStateListKt.sync) {
                        if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                            stateListStateRecord2.setList$runtime_release(build);
                            z = true;
                            stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                            stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                        } else {
                            z = false;
                        }
                    }
                }
                SnapshotKt.notifyWrite(current, this);
            } else {
                return;
            }
        } while (!z);
    }

    public final List<T> getDebuggerDisplayValue() {
        StateRecord firstStateRecord2 = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2)).getList$runtime_release();
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Boolean invoke;
        Snapshot current;
        boolean z;
        do {
            synchronized (SnapshotStateListKt.sync) {
                StateRecord firstStateRecord2 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder builder = list$runtime_release.builder();
            invoke = function1.invoke(builder);
            PersistentList build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord3 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                synchronized (SnapshotStateListKt.sync) {
                    if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateListStateRecord2.setList$runtime_release(build);
                        z = true;
                        stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                        stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z);
        return invoke.booleanValue();
    }

    private final void update(boolean z, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> function1) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z2;
        SnapshotStateList snapshotStateList = this;
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord2 = getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            if (!Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                StateRecord firstStateRecord3 = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    try {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, this, current);
                        synchronized (SnapshotStateListKt.sync) {
                            if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord2.setList$runtime_release(persistentList);
                                if (z) {
                                    stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                                }
                                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            InlineMarker.finallyStart(1);
                        }
                        InlineMarker.finallyEnd(1);
                        InlineMarker.finallyStart(1);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                InlineMarker.finallyEnd(1);
                SnapshotKt.notifyWrite(current, this);
            } else {
                return;
            }
        } while (!z2);
    }

    static /* synthetic */ void update$default(SnapshotStateList snapshotStateList, boolean z, Function1 function1, int i, Object obj) {
        int modification$runtime_release;
        PersistentList list$runtime_release;
        Snapshot current;
        boolean z2;
        if ((i & 1) != 0) {
            z = true;
        }
        do {
            synchronized (SnapshotStateListKt.sync) {
                try {
                    StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
                    Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                    StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord2);
                    modification$runtime_release = stateListStateRecord.getModification$runtime_release();
                    list$runtime_release = stateListStateRecord.getList$runtime_release();
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                } finally {
                    InlineMarker.finallyStart(1);
                    InlineMarker.finallyEnd(1);
                }
            }
            InlineMarker.finallyEnd(1);
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList persistentList = (PersistentList) function1.invoke(list$runtime_release);
            if (!Intrinsics.areEqual((Object) persistentList, (Object) list$runtime_release)) {
                StateRecord firstStateRecord3 = snapshotStateList.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord3, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateRecord stateRecord = (StateListStateRecord) firstStateRecord3;
                SnapshotKt.getSnapshotInitializer();
                synchronized (SnapshotKt.getLock()) {
                    try {
                        current = Snapshot.Companion.getCurrent();
                        StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateRecord, snapshotStateList, current);
                        synchronized (SnapshotStateListKt.sync) {
                            if (stateListStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                                stateListStateRecord2.setList$runtime_release(persistentList);
                                if (z) {
                                    stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange$runtime_release() + 1);
                                }
                                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification$runtime_release() + 1);
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            InlineMarker.finallyStart(1);
                        }
                        InlineMarker.finallyEnd(1);
                        InlineMarker.finallyStart(1);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                InlineMarker.finallyEnd(1);
                SnapshotKt.notifyWrite(current, snapshotStateList);
            } else {
                return;
            }
        } while (!z2);
    }
}
