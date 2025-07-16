package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.persistentOrderedMap;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\fR\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapKeysIterator;", "K", "V", "", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMap;)V", "internal", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedMap/PersistentOrderedMapLinksIterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentOrderedMapContentIterators.kt */
public final class PersistentOrderedMapKeysIterator<K, V> implements Iterator<K>, KMappedMarker {
    public static final int $stable = 8;
    private final PersistentOrderedMapLinksIterator<K, V> internal;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public PersistentOrderedMapKeysIterator(PersistentOrderedMap<K, V> persistentOrderedMap) {
        this.internal = new PersistentOrderedMapLinksIterator<>(persistentOrderedMap.getFirstKey$runtime_release(), persistentOrderedMap.getHashMap$runtime_release());
    }

    public boolean hasNext() {
        return this.internal.hasNext();
    }

    public K next() {
        K nextKey$runtime_release = this.internal.getNextKey$runtime_release();
        this.internal.next();
        return nextKey$runtime_release;
    }
}
