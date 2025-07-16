package androidx.compose.runtime.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0002R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"androidx/compose/runtime/collection/IdentityArrayMap$asMap$1$values$1", "", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArrayMap.kt */
public final class IdentityArrayMap$asMap$1$values$1 implements Collection<Value>, KMappedMarker {
    final /* synthetic */ IdentityArrayMap<Key, Value> this$0;

    public boolean add(Value value) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean addAll(Collection<? extends Value> collection) {
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

    public boolean removeIf(Predicate<? super Value> predicate) {
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

    IdentityArrayMap$asMap$1$values$1(IdentityArrayMap<Key, Value> identityArrayMap) {
        this.this$0 = identityArrayMap;
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

    public Iterator<Value> iterator() {
        return SequencesKt.sequence(new IdentityArrayMap$asMap$1$values$1$iterator$1(this.this$0, (Continuation<? super IdentityArrayMap$asMap$1$values$1$iterator$1>) null)).iterator();
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean contains(Object obj) {
        int size = this.this$0.getSize();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual(this.this$0.getValues()[i], obj)) {
                return true;
            }
        }
        return false;
    }
}
