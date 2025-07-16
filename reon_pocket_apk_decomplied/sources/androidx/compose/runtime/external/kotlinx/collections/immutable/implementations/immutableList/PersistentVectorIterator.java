package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B;\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\r\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorIterator;", "T", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "root", "", "", "tail", "index", "", "size", "trieHeight", "([Ljava/lang/Object;[Ljava/lang/Object;III)V", "[Ljava/lang/Object;", "trieIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "next", "()Ljava/lang/Object;", "previous", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentVectorIterator.kt */
public final class PersistentVectorIterator<T> extends AbstractListIterator<T> {
    public static final int $stable = 8;
    private final T[] tail;
    private final TrieIterator<T> trieIterator;

    public PersistentVectorIterator(Object[] objArr, T[] tArr, int i, int i2, int i3) {
        super(i, i2);
        this.tail = tArr;
        int rootSize = UtilsKt.rootSize(i2);
        this.trieIterator = new TrieIterator<>(objArr, RangesKt.coerceAtMost(i, rootSize), rootSize, i3);
    }

    public T next() {
        checkHasNext$runtime_release();
        if (this.trieIterator.hasNext()) {
            setIndex(getIndex() + 1);
            return this.trieIterator.next();
        }
        T[] tArr = this.tail;
        int index = getIndex();
        setIndex(index + 1);
        return tArr[index - this.trieIterator.getSize()];
    }

    public T previous() {
        checkHasPrevious$runtime_release();
        if (getIndex() > this.trieIterator.getSize()) {
            T[] tArr = this.tail;
            setIndex(getIndex() - 1);
            return tArr[getIndex() - this.trieIterator.getSize()];
        }
        setIndex(getIndex() - 1);
        return this.trieIterator.previous();
    }
}
