package androidx.compose.runtime.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0012H\u0016R&\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00040\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"androidx/compose/runtime/collection/IdentityArrayMap$asMap$1", "", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArrayMap.kt */
public final class IdentityArrayMap$asMap$1 implements Map<Key, Value>, KMappedMarker {
    final /* synthetic */ IdentityArrayMap<Key, Value> this$0;

    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Value compute(Key key, BiFunction<? super Key, ? super Value, ? extends Value> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Value computeIfAbsent(Key key, Function<? super Key, ? extends Value> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Value computeIfPresent(Key key, BiFunction<? super Key, ? super Value, ? extends Value> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Value merge(Key key, Value value, BiFunction<? super Value, ? super Value, ? extends Value> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Value put(Key key, Value value) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void putAll(Map<? extends Key, ? extends Value> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Value putIfAbsent(Key key, Value value) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Value remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Value replace(Key key, Value value) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean replace(Key key, Value value, Value value2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public void replaceAll(BiFunction<? super Key, ? super Value, ? extends Value> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    IdentityArrayMap$asMap$1(IdentityArrayMap<Key, Value> identityArrayMap) {
        this.this$0 = identityArrayMap;
    }

    public final /* bridge */ Set<Map.Entry<Key, Value>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Set<Key> keySet() {
        return getKeys();
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<Value> values() {
        return getValues();
    }

    public Set<Map.Entry<Key, Value>> getEntries() {
        return new IdentityArrayMap$asMap$1$entries$1(this.this$0);
    }

    public Set<Key> getKeys() {
        return new IdentityArrayMap$asMap$1$keys$1(this.this$0);
    }

    public int getSize() {
        return this.this$0.getSize();
    }

    public Collection<Value> getValues() {
        return new IdentityArrayMap$asMap$1$values$1(this.this$0);
    }

    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    public Value get(Object obj) {
        if (obj == null) {
            return null;
        }
        return this.this$0.get(obj);
    }

    public boolean containsValue(Object obj) {
        return ArraysKt.contains((T[]) this.this$0.getValues(), obj);
    }

    public boolean containsKey(Object obj) {
        return (obj == null || this.this$0.get(obj) == null) ? false : true;
    }
}
