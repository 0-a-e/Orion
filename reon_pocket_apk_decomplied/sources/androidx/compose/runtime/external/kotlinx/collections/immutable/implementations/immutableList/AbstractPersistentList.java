package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractList;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Lkotlin/collections/AbstractList;", "()V", "addAll", "index", "", "c", "", "elements", "clear", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "", "listIterator", "", "remove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "removeAll", "retainAll", "subList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AbstractPersistentList.kt */
public abstract class AbstractPersistentList<E> extends AbstractList<E> implements PersistentList<E> {
    public static final int $stable = 0;

    public ImmutableList<E> subList(int i, int i2) {
        return ImmutableList.CC.$default$subList((ImmutableList) this, i, i2);
    }

    public PersistentList<E> addAll(Collection<? extends E> collection) {
        PersistentList.Builder builder = builder();
        builder.addAll(collection);
        return builder.build();
    }

    public PersistentList<E> addAll(int i, Collection<? extends E> collection) {
        PersistentList.Builder builder = builder();
        builder.addAll(i, collection);
        return builder.build();
    }

    public PersistentList<E> remove(E e) {
        int indexOf = indexOf(e);
        if (indexOf != -1) {
            return removeAt(indexOf);
        }
        return this;
    }

    public PersistentList<E> removeAll(Collection<? extends E> collection) {
        return removeAll(new AbstractPersistentList$removeAll$1(collection));
    }

    public PersistentList<E> retainAll(Collection<? extends E> collection) {
        return removeAll(new AbstractPersistentList$retainAll$1(collection));
    }

    public PersistentList<E> clear() {
        return UtilsKt.persistentVectorOf();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Iterable<Object> iterable = collection;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<E> iterator() {
        return listIterator();
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }
}
