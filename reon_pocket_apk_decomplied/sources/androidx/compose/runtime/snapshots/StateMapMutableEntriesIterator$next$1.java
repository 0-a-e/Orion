package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

@Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0010'\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\b\u001a\u00028\u00012\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0002\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\u0006\u001a\u00028\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\u0005\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"androidx/compose/runtime/snapshots/StateMapMutableEntriesIterator$next$1", "", "key", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateMap.kt */
public final class StateMapMutableEntriesIterator$next$1 implements Map.Entry<K, V>, KMutableMap.Entry {
    private final K key;
    final /* synthetic */ StateMapMutableEntriesIterator<K, V> this$0;
    private V value;

    StateMapMutableEntriesIterator$next$1(StateMapMutableEntriesIterator<K, V> stateMapMutableEntriesIterator) {
        this.this$0 = stateMapMutableEntriesIterator;
        Map.Entry<K, V> current = stateMapMutableEntriesIterator.getCurrent();
        Intrinsics.checkNotNull(current);
        this.key = current.getKey();
        Map.Entry<K, V> current2 = stateMapMutableEntriesIterator.getCurrent();
        Intrinsics.checkNotNull(current2);
        this.value = current2.getValue();
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    /* renamed from: setValue  reason: collision with other method in class */
    public void m3414setValue(V v) {
        this.value = v;
    }

    public V setValue(V v) {
        StateMapMutableEntriesIterator<K, V> stateMapMutableEntriesIterator = this.this$0;
        StateMapMutableIterator stateMapMutableIterator = stateMapMutableEntriesIterator;
        if (stateMapMutableIterator.getMap().getModification$runtime_release() == stateMapMutableIterator.modification) {
            V value2 = getValue();
            stateMapMutableEntriesIterator.getMap().put(getKey(), v);
            setValue(v);
            return value2;
        }
        throw new ConcurrentModificationException();
    }
}
