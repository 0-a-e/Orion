package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableSet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u000b\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001d\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\u001b\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\"\u0010\u0014\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016J\"\u0010\u0015\u001a\u00020\u000f2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\rH\u0016¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotMapEntrySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "addAll", "elements", "", "contains", "", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateMap.kt */
final class SnapshotMapEntrySet<K, V> extends SnapshotMapSet<K, V, Map.Entry<K, V>> {
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        return ((Boolean) add((Map.Entry) obj)).booleanValue();
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!TypeIntrinsics.isMutableMapEntry(obj)) {
            return false;
        }
        return contains((Map.Entry) obj);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (!TypeIntrinsics.isMutableMapEntry(obj)) {
            return false;
        }
        return remove((Map.Entry) obj);
    }

    public SnapshotMapEntrySet(SnapshotStateMap<K, V> snapshotStateMap) {
        super(snapshotStateMap);
    }

    public Void add(Map.Entry<K, V> entry) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Void addAll(Collection<? extends Map.Entry<K, V>> collection) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new StateMapMutableEntriesIterator<>(getMap(), ((ImmutableSet) getMap().getReadable$runtime_release().getMap$runtime_release().entrySet()).iterator());
    }

    public boolean remove(Map.Entry<K, V> entry) {
        return getMap().remove(entry.getKey()) != null;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        Iterator<? extends Object> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                if (getMap().remove(((Map.Entry) it.next()).getKey()) != null || z) {
                    z = true;
                }
            }
        }
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        PersistentMap map$runtime_release;
        int modification$runtime_release;
        boolean z;
        Snapshot current;
        Iterable<Map.Entry> iterable = collection;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Map.Entry entry : iterable) {
            Pair pair = TuplesKt.to(entry.getKey(), entry.getValue());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        SnapshotStateMap map = getMap();
        boolean z2 = false;
        do {
            synchronized (SnapshotStateMapKt.sync) {
                StateRecord firstStateRecord = map.getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.current((SnapshotStateMap.StateMapStateRecord) firstStateRecord);
                map$runtime_release = stateMapStateRecord.getMap$runtime_release();
                modification$runtime_release = stateMapStateRecord.getModification$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(map$runtime_release);
            PersistentMap.Builder builder = map$runtime_release.builder();
            Map map2 = builder;
            Iterator it = map.entrySet().iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry2 = (Map.Entry) it.next();
                if (!linkedHashMap.containsKey(entry2.getKey()) || !Intrinsics.areEqual(linkedHashMap.get(entry2.getKey()), entry2.getValue())) {
                    map2.remove(entry2.getKey());
                    z2 = true;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            PersistentMap build = builder.build();
            if (Intrinsics.areEqual((Object) build, (Object) map$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = map.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateMap.StateMapStateRecord<K of androidx.compose.runtime.snapshots.SnapshotStateMap, V of androidx.compose.runtime.snapshots.SnapshotStateMap>");
            StateRecord stateRecord = (SnapshotStateMap.StateMapStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.Companion.getCurrent();
                SnapshotStateMap.StateMapStateRecord stateMapStateRecord2 = (SnapshotStateMap.StateMapStateRecord) SnapshotKt.writableRecord(stateRecord, map, current);
                synchronized (SnapshotStateMapKt.sync) {
                    if (stateMapStateRecord2.getModification$runtime_release() == modification$runtime_release) {
                        stateMapStateRecord2.setMap$runtime_release(build);
                        stateMapStateRecord2.setModification$runtime_release(stateMapStateRecord2.getModification$runtime_release() + 1);
                    } else {
                        z = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, map);
        } while (!z);
        return z2;
    }

    public boolean contains(Map.Entry<K, V> entry) {
        return Intrinsics.areEqual(getMap().get(entry.getKey()), (Object) entry.getValue());
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Iterable<Map.Entry> iterable = collection;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Map.Entry contains : iterable) {
            if (!contains((Object) contains)) {
                return false;
            }
        }
        return true;
    }
}
