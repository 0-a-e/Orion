package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u000bJ\r\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/BufferIterator;", "T", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "buffer", "", "index", "", "size", "([Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "previous", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BufferIterator.kt */
public final class BufferIterator<T> extends AbstractListIterator<T> {
    public static final int $stable = 8;
    private final T[] buffer;

    public BufferIterator(T[] tArr, int i, int i2) {
        super(i, i2);
        this.buffer = tArr;
    }

    public T next() {
        if (hasNext()) {
            T[] tArr = this.buffer;
            int index = getIndex();
            setIndex(index + 1);
            return tArr[index];
        }
        throw new NoSuchElementException();
    }

    public T previous() {
        if (hasPrevious()) {
            T[] tArr = this.buffer;
            setIndex(getIndex() - 1);
            return tArr[getIndex()];
        }
        throw new NoSuchElementException();
    }
}
