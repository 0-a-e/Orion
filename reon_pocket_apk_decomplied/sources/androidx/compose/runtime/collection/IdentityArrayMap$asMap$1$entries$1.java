package androidx.compose.runtime.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0002J\"\u0010\n\u001a\u00020\b2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u001b\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"androidx/compose/runtime/collection/IdentityArrayMap$asMap$1$entries$1", "", "", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "isEmpty", "iterator", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArrayMap.kt */
public final class IdentityArrayMap$asMap$1$entries$1 implements Set<Map.Entry<? extends Key, ? extends Value>>, KMappedMarker {
    final /* synthetic */ IdentityArrayMap<Key, Value> this$0;

    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(Map.Entry<? extends Key, ? extends Value> entry) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Map.Entry<? extends Key, ? extends Value>> collection) {
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

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    IdentityArrayMap$asMap$1$entries$1(IdentityArrayMap<Key, Value> identityArrayMap) {
        this.this$0 = identityArrayMap;
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return contains((Map.Entry) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.this$0.getSize();
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Iterator<Map.Entry<Key, Value>> iterator() {
        return SequencesKt.sequence(new IdentityArrayMap$asMap$1$entries$1$iterator$1(this.this$0, (Continuation<? super IdentityArrayMap$asMap$1$entries$1$iterator$1>) null)).iterator();
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

    public boolean contains(Map.Entry<? extends Key, ? extends Value> entry) {
        return this.this$0.get(entry.getKey()) == entry.getValue();
    }
}
