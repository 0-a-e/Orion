package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"androidx/collection/MutableScatterSet$MutableSetWrapper$iterator$1", "", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "iterator", "", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "remove", "", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ScatterSet.kt */
public final class MutableScatterSet$MutableSetWrapper$iterator$1 implements Iterator<E>, KMutableIterator {
    private int current = -1;
    private final Iterator<E> iterator;
    final /* synthetic */ MutableScatterSet<E> this$0;

    MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet<E> mutableScatterSet) {
        this.this$0 = mutableScatterSet;
        this.iterator = SequencesKt.iterator(new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(mutableScatterSet, this, (Continuation<? super MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1>) null));
    }

    public final int getCurrent() {
        return this.current;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final Iterator<E> getIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public E next() {
        return this.iterator.next();
    }

    public void remove() {
        int i = this.current;
        if (i != -1) {
            this.this$0.removeElementAt(i);
            this.current = -1;
        }
    }
}
