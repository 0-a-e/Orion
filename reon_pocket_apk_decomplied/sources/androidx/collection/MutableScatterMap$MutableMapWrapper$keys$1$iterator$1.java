package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"androidx/collection/MutableScatterMap$MutableMapWrapper$keys$1$iterator$1", "", "current", "", "iterator", "", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScatterMap.kt */
public final class MutableScatterMap$MutableMapWrapper$keys$1$iterator$1 implements Iterator<K>, KMutableIterator {
    private int current = -1;
    private final Iterator<Integer> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    MutableScatterMap$MutableMapWrapper$keys$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = SequencesKt.iterator(new MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1(mutableScatterMap, (Continuation<? super MutableScatterMap$MutableMapWrapper$keys$1$iterator$1$iterator$1>) null));
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public K next() {
        this.current = this.iterator.next().intValue();
        return this.this$0.keys[this.current];
    }

    public void remove() {
        int i = this.current;
        if (i >= 0) {
            this.this$0.removeValueAt(i);
            this.current = -1;
        }
    }
}
