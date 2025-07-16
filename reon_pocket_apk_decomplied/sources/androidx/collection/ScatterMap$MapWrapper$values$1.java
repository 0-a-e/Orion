package androidx.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"androidx/collection/ScatterMap$MapWrapper$values$1", "", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScatterMap.kt */
public final class ScatterMap$MapWrapper$values$1 implements Collection<V>, KMappedMarker {
    final /* synthetic */ ScatterMap<K, V> this$0;

    public boolean add(V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends V> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeIf(Predicate<? super V> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "array");
        return CollectionToArray.toArray(this, tArr);
    }

    ScatterMap$MapWrapper$values$1(ScatterMap<K, V> scatterMap) {
        this.this$0 = scatterMap;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.this$0._size;
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Iterator<V> iterator() {
        return SequencesKt.iterator(new ScatterMap$MapWrapper$values$1$iterator$1(this.this$0, (Continuation<? super ScatterMap$MapWrapper$values$1$iterator$1>) null));
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        Iterable<Object> iterable = collection;
        ScatterMap<K, V> scatterMap = this.this$0;
        if (((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object containsValue : iterable) {
            if (!scatterMap.containsValue(containsValue)) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Object obj) {
        return this.this$0.containsValue(obj);
    }
}
