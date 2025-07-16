package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B-\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\r\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u000e\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\r\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J7\u0010\u0018\u001a\u00020\u00122\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0019\u0010\nR\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/TrieIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "root", "", "", "index", "", "size", "height", "([Ljava/lang/Object;III)V", "isInRightEdge", "", "path", "[Ljava/lang/Object;", "elementAtCurrentIndex", "()Ljava/lang/Object;", "fillPath", "", "startLevel", "fillPathIfNeeded", "indexPredicate", "next", "previous", "reset", "reset$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TrieIterator.kt */
public final class TrieIterator<E> extends AbstractListIterator<E> {
    public static final int $stable = 8;
    private int height;
    private boolean isInRightEdge;
    private Object[] path;

    public TrieIterator(Object[] objArr, int i, int i2, int i3) {
        super(i, i2);
        this.height = i3;
        Object[] objArr2 = new Object[i3];
        this.path = objArr2;
        boolean z = i == i2;
        this.isInRightEdge = z;
        objArr2[0] = objArr;
        fillPath(i - (z ? 1 : 0), 1);
    }

    public final void reset$runtime_release(Object[] objArr, int i, int i2, int i3) {
        setIndex(i);
        setSize(i2);
        this.height = i3;
        if (this.path.length < i3) {
            this.path = new Object[i3];
        }
        boolean z = false;
        this.path[0] = objArr;
        if (i == i2) {
            z = true;
        }
        this.isInRightEdge = z;
        fillPath(i - (z ? 1 : 0), 1);
    }

    private final void fillPath(int i, int i2) {
        int i3 = (this.height - i2) * 5;
        while (i2 < this.height) {
            Object[] objArr = this.path;
            Object[] objArr2 = objArr[i2 - 1];
            Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[i2] = objArr2[UtilsKt.indexSegment(i, i3)];
            i3 -= 5;
            i2++;
        }
    }

    private final void fillPathIfNeeded(int i) {
        int i2 = 0;
        while (UtilsKt.indexSegment(getIndex(), i2) == i) {
            i2 += 5;
        }
        if (i2 > 0) {
            fillPath(getIndex(), ((this.height - 1) - (i2 / 5)) + 1);
        }
    }

    private final E elementAtCurrentIndex() {
        Object obj = this.path[this.height - 1];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return ((Object[]) obj)[getIndex() & 31];
    }

    public E next() {
        if (hasNext()) {
            E elementAtCurrentIndex = elementAtCurrentIndex();
            setIndex(getIndex() + 1);
            if (getIndex() == getSize()) {
                this.isInRightEdge = true;
                return elementAtCurrentIndex;
            }
            fillPathIfNeeded(0);
            return elementAtCurrentIndex;
        }
        throw new NoSuchElementException();
    }

    public E previous() {
        if (hasPrevious()) {
            setIndex(getIndex() - 1);
            if (this.isInRightEdge) {
                this.isInRightEdge = false;
                return elementAtCurrentIndex();
            }
            fillPathIfNeeded(31);
            return elementAtCurrentIndex();
        }
        throw new NoSuchElementException();
    }
}
