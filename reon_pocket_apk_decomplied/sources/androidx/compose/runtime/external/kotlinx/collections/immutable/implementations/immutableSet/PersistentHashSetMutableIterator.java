package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0014\u0010\u0010\u001a\u00020\f2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002J\u000e\u0010\u0013\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u000eH\u0016J1\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\b2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetMutableIterator;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)V", "expectedModCount", "", "lastIteratedElement", "Ljava/lang/Object;", "nextWasInvoked", "", "checkForComodification", "", "checkNextWasInvoked", "isCollision", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "next", "()Ljava/lang/Object;", "remove", "resetPath", "hashCode", "element", "pathIndex", "(ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;Ljava/lang/Object;I)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PersistentHashSetMutableIterator.kt */
public final class PersistentHashSetMutableIterator<E> extends PersistentHashSetIterator<E> implements Iterator<E>, KMutableIterator {
    public static final int $stable = 8;
    private final PersistentHashSetBuilder<E> builder;
    private int expectedModCount;
    private E lastIteratedElement;
    private boolean nextWasInvoked;

    public PersistentHashSetMutableIterator(PersistentHashSetBuilder<E> persistentHashSetBuilder) {
        super(persistentHashSetBuilder.getNode$runtime_release());
        this.builder = persistentHashSetBuilder;
        this.expectedModCount = persistentHashSetBuilder.getModCount$runtime_release();
    }

    public E next() {
        checkForComodification();
        E next = super.next();
        this.lastIteratedElement = next;
        this.nextWasInvoked = true;
        return next;
    }

    public void remove() {
        checkNextWasInvoked();
        if (hasNext()) {
            Object currentElement = currentElement();
            TypeIntrinsics.asMutableCollection(this.builder).remove(this.lastIteratedElement);
            resetPath(currentElement != null ? currentElement.hashCode() : 0, this.builder.getNode$runtime_release(), currentElement, 0);
        } else {
            TypeIntrinsics.asMutableCollection(this.builder).remove(this.lastIteratedElement);
        }
        this.lastIteratedElement = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.getModCount$runtime_release();
    }

    private final void resetPath(int i, TrieNode<?> trieNode, E e, int i2) {
        boolean z = true;
        if (isCollision(trieNode)) {
            int indexOf = ArraysKt.indexOf((T[]) trieNode.getBuffer(), e);
            if (indexOf == -1) {
                z = false;
            }
            CommonFunctionsKt.m3399assert(z);
            ((TrieNodeIterator) getPath().get(i2)).reset(trieNode.getBuffer(), indexOf);
            setPathLastIndex(i2);
            return;
        }
        int indexOfCellAt$runtime_release = trieNode.indexOfCellAt$runtime_release(1 << TrieNodeKt.indexSegment(i, i2 * 5));
        ((TrieNodeIterator) getPath().get(i2)).reset(trieNode.getBuffer(), indexOfCellAt$runtime_release);
        Object obj = trieNode.getBuffer()[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            resetPath(i, (TrieNode) obj, e, i2 + 1);
        } else {
            setPathLastIndex(i2);
        }
    }

    private final boolean isCollision(TrieNode<?> trieNode) {
        return trieNode.getBitmap() == 0;
    }

    private final void checkNextWasInvoked() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    private final void checkForComodification() {
        if (this.builder.getModCount$runtime_release() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }
}
