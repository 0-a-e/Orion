package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u000e\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014J\r\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u0015\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0019\u001a\u00020\u000eH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorMutableIterator;", "T", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "index", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;I)V", "expectedModCount", "lastIteratedIndex", "trieIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "add", "", "element", "(Ljava/lang/Object;)V", "checkForComodification", "checkHasIterated", "next", "()Ljava/lang/Object;", "previous", "remove", "reset", "set", "setupTrieIterator", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentVectorMutableIterator.kt */
public final class PersistentVectorMutableIterator<T> extends AbstractListIterator<T> implements ListIterator<T>, KMutableListIterator {
    public static final int $stable = 8;
    private final PersistentVectorBuilder<T> builder;
    private int expectedModCount;
    private int lastIteratedIndex = -1;
    private TrieIterator<? extends T> trieIterator;

    public PersistentVectorMutableIterator(PersistentVectorBuilder<T> persistentVectorBuilder, int i) {
        super(i, persistentVectorBuilder.size());
        this.builder = persistentVectorBuilder;
        this.expectedModCount = persistentVectorBuilder.getModCount$runtime_release();
        setupTrieIterator();
    }

    public T previous() {
        checkForComodification();
        checkHasPrevious$runtime_release();
        this.lastIteratedIndex = getIndex() - 1;
        TrieIterator<? extends T> trieIterator2 = this.trieIterator;
        if (trieIterator2 == null) {
            T[] tail$runtime_release = this.builder.getTail$runtime_release();
            setIndex(getIndex() - 1);
            return tail$runtime_release[getIndex()];
        } else if (getIndex() > trieIterator2.getSize()) {
            T[] tail$runtime_release2 = this.builder.getTail$runtime_release();
            setIndex(getIndex() - 1);
            return tail$runtime_release2[getIndex() - trieIterator2.getSize()];
        } else {
            setIndex(getIndex() - 1);
            return trieIterator2.previous();
        }
    }

    public T next() {
        checkForComodification();
        checkHasNext$runtime_release();
        this.lastIteratedIndex = getIndex();
        TrieIterator<? extends T> trieIterator2 = this.trieIterator;
        if (trieIterator2 == null) {
            T[] tail$runtime_release = this.builder.getTail$runtime_release();
            int index = getIndex();
            setIndex(index + 1);
            return tail$runtime_release[index];
        } else if (trieIterator2.hasNext()) {
            setIndex(getIndex() + 1);
            return trieIterator2.next();
        } else {
            T[] tail$runtime_release2 = this.builder.getTail$runtime_release();
            int index2 = getIndex();
            setIndex(index2 + 1);
            return tail$runtime_release2[index2 - trieIterator2.getSize()];
        }
    }

    private final void reset() {
        setSize(this.builder.size());
        this.expectedModCount = this.builder.getModCount$runtime_release();
        this.lastIteratedIndex = -1;
        setupTrieIterator();
    }

    private final void setupTrieIterator() {
        Object[] root$runtime_release = this.builder.getRoot$runtime_release();
        if (root$runtime_release == null) {
            this.trieIterator = null;
            return;
        }
        int rootSize = UtilsKt.rootSize(this.builder.size());
        int coerceAtMost = RangesKt.coerceAtMost(getIndex(), rootSize);
        int rootShift$runtime_release = (this.builder.getRootShift$runtime_release() / 5) + 1;
        TrieIterator<? extends T> trieIterator2 = this.trieIterator;
        if (trieIterator2 == null) {
            this.trieIterator = new TrieIterator<>(root$runtime_release, coerceAtMost, rootSize, rootShift$runtime_release);
            return;
        }
        Intrinsics.checkNotNull(trieIterator2);
        trieIterator2.reset$runtime_release(root$runtime_release, coerceAtMost, rootSize, rootShift$runtime_release);
    }

    public void add(T t) {
        checkForComodification();
        this.builder.add(getIndex(), t);
        setIndex(getIndex() + 1);
        reset();
    }

    public void remove() {
        checkForComodification();
        checkHasIterated();
        this.builder.remove(this.lastIteratedIndex);
        if (this.lastIteratedIndex < getIndex()) {
            setIndex(this.lastIteratedIndex);
        }
        reset();
    }

    public void set(T t) {
        checkForComodification();
        checkHasIterated();
        this.builder.set(this.lastIteratedIndex, t);
        this.expectedModCount = this.builder.getModCount$runtime_release();
        setupTrieIterator();
    }

    private final void checkForComodification() {
        if (this.expectedModCount != this.builder.getModCount$runtime_release()) {
            throw new ConcurrentModificationException();
        }
    }

    private final void checkHasIterated() {
        if (this.lastIteratedIndex == -1) {
            throw new IllegalStateException();
        }
    }
}
