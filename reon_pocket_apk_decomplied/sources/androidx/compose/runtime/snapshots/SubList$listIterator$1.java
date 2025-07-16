package androidx.compose.runtime.snapshots;

import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableListIterator;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\r\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\u0015\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0011"}, d2 = {"androidx/compose/runtime/snapshots/SubList$listIterator$1", "", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "", "previous", "previousIndex", "remove", "set", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapshotStateList.kt */
public final class SubList$listIterator$1 implements ListIterator<T>, KMutableListIterator {
    final /* synthetic */ Ref.IntRef $current;
    final /* synthetic */ SubList<T> this$0;

    SubList$listIterator$1(Ref.IntRef intRef, SubList<T> subList) {
        this.$current = intRef;
        this.this$0 = subList;
    }

    public boolean hasPrevious() {
        return this.$current.element >= 0;
    }

    public int nextIndex() {
        return this.$current.element + 1;
    }

    public T previous() {
        int i = this.$current.element;
        SnapshotStateListKt.validateRange(i, this.this$0.size());
        this.$current.element = i - 1;
        return this.this$0.get(i);
    }

    public int previousIndex() {
        return this.$current.element;
    }

    public Void add(T t) {
        Void unused = SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }

    public boolean hasNext() {
        return this.$current.element < this.this$0.size() - 1;
    }

    public T next() {
        int i = this.$current.element + 1;
        SnapshotStateListKt.validateRange(i, this.this$0.size());
        this.$current.element = i;
        return this.this$0.get(i);
    }

    public Void remove() {
        Void unused = SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }

    public Void set(T t) {
        Void unused = SnapshotStateListKt.modificationError();
        throw new KotlinNothingValueException();
    }
}
