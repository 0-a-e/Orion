package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0015\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010+J\u001f\u0010,\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010.J\u0017\u0010/\u001a\u0004\u0018\u00018\u00012\u0006\u0010(\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010+J\u001b\u0010/\u001a\u00020'2\u0006\u0010(\u001a\u00028\u00002\u0006\u0010-\u001a\u00028\u0001¢\u0006\u0002\u00100R&\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n0\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\fR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001f8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u00061"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapBuilder;", "K", "V", "Lkotlin/collections/AbstractMutableMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "", "firstKey", "getFirstKey$runtime_release", "()Ljava/lang/Object;", "hashMapBuilder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/LinkedValue;", "getHashMapBuilder$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "keys", "getKeys", "lastKey", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentOrderedMapBuilder.kt */
public final class PersistentOrderedMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {
    public static final int $stable = 8;
    private Object firstKey;
    private final PersistentHashMapBuilder<K, LinkedValue<V>> hashMapBuilder = this.map.getHashMap$runtime_release().builder();
    private Object lastKey = this.map.getLastKey$runtime_release();
    private PersistentOrderedMap<K, V> map;

    public PersistentOrderedMapBuilder(PersistentOrderedMap<K, V> persistentOrderedMap) {
        this.map = persistentOrderedMap;
        this.firstKey = persistentOrderedMap.getFirstKey$runtime_release();
    }

    public final Object getFirstKey$runtime_release() {
        return this.firstKey;
    }

    public final PersistentHashMapBuilder<K, LinkedValue<V>> getHashMapBuilder$runtime_release() {
        return this.hashMapBuilder;
    }

    public int getSize() {
        return this.hashMapBuilder.size();
    }

    public PersistentMap<K, V> build() {
        PersistentOrderedMap<K, V> persistentOrderedMap;
        PersistentHashMap<K, LinkedValue<V>> build = this.hashMapBuilder.build();
        if (build == this.map.getHashMap$runtime_release()) {
            boolean z = true;
            CommonFunctionsKt.m3399assert(this.firstKey == this.map.getFirstKey$runtime_release());
            if (this.lastKey != this.map.getLastKey$runtime_release()) {
                z = false;
            }
            CommonFunctionsKt.m3399assert(z);
            persistentOrderedMap = this.map;
        } else {
            persistentOrderedMap = new PersistentOrderedMap<>(this.firstKey, this.lastKey, build);
        }
        this.map = persistentOrderedMap;
        return persistentOrderedMap;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentOrderedMapBuilderEntries<>(this);
    }

    public Set<K> getKeys() {
        return new PersistentOrderedMapBuilderKeys<>(this);
    }

    public Collection<V> getValues() {
        return new PersistentOrderedMapBuilderValues<>(this);
    }

    public boolean containsKey(Object obj) {
        return this.hashMapBuilder.containsKey(obj);
    }

    public V get(Object obj) {
        LinkedValue linkedValue = this.hashMapBuilder.get(obj);
        if (linkedValue != null) {
            return linkedValue.getValue();
        }
        return null;
    }

    public V put(K k, V v) {
        LinkedValue linkedValue = this.hashMapBuilder.get(k);
        if (linkedValue != null) {
            if (linkedValue.getValue() == v) {
                return v;
            }
            this.hashMapBuilder.put(k, linkedValue.withValue(v));
            return linkedValue.getValue();
        } else if (isEmpty()) {
            this.firstKey = k;
            this.lastKey = k;
            this.hashMapBuilder.put(k, new LinkedValue(v));
            return null;
        } else {
            Object obj = this.lastKey;
            LinkedValue<V> linkedValue2 = this.hashMapBuilder.get(obj);
            Intrinsics.checkNotNull(linkedValue2);
            LinkedValue linkedValue3 = linkedValue2;
            CommonFunctionsKt.m3399assert(!linkedValue3.getHasNext());
            this.hashMapBuilder.put(obj, linkedValue3.withNext(k));
            this.hashMapBuilder.put(k, new LinkedValue(v, obj));
            this.lastKey = k;
            return null;
        }
    }

    public V remove(Object obj) {
        LinkedValue remove = this.hashMapBuilder.remove(obj);
        if (remove == null) {
            return null;
        }
        if (remove.getHasPrevious()) {
            Object obj2 = this.hashMapBuilder.get(remove.getPrevious());
            Intrinsics.checkNotNull(obj2);
            this.hashMapBuilder.put(remove.getPrevious(), ((LinkedValue) obj2).withNext(remove.getNext()));
        } else {
            this.firstKey = remove.getNext();
        }
        if (remove.getHasNext()) {
            Object obj3 = this.hashMapBuilder.get(remove.getNext());
            Intrinsics.checkNotNull(obj3);
            this.hashMapBuilder.put(remove.getNext(), ((LinkedValue) obj3).withPrevious(remove.getPrevious()));
        } else {
            this.lastKey = remove.getPrevious();
        }
        return remove.getValue();
    }

    public final boolean remove(Object obj, Object obj2) {
        LinkedValue linkedValue = this.hashMapBuilder.get(obj);
        if (linkedValue == null || !Intrinsics.areEqual(linkedValue.getValue(), obj2)) {
            return false;
        }
        remove(obj);
        return true;
    }

    public void clear() {
        this.hashMapBuilder.clear();
        this.firstKey = EndOfChain.INSTANCE;
        this.lastKey = EndOfChain.INSTANCE;
    }
}
