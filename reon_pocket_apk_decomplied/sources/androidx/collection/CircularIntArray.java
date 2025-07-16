package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0003J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u0003R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Landroidx/collection/CircularIntArray;", "", "minCapacity", "", "(I)V", "capacityBitmask", "elements", "", "first", "getFirst", "()I", "head", "last", "getLast", "tail", "addFirst", "", "element", "addLast", "clear", "doubleCapacity", "get", "index", "isEmpty", "", "popFirst", "popLast", "removeFromEnd", "count", "removeFromStart", "size", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CircularIntArray.kt */
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public CircularIntArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1".toString());
        } else if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.capacityBitmask = i - 1;
            this.elements = new int[i];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularIntArray(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 8 : i);
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i = this.head;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            int[] iArr2 = new int[i3];
            ArraysKt.copyInto(iArr, iArr2, 0, i, length);
            ArraysKt.copyInto(this.elements, iArr2, i2, 0, this.head);
            this.elements = iArr2;
            this.head = 0;
            this.tail = length;
            this.capacityBitmask = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void addFirst(int i) {
        int i2 = (this.head - 1) & this.capacityBitmask;
        this.head = i2;
        this.elements[i2] = i;
        if (i2 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int i) {
        int[] iArr = this.elements;
        int i2 = this.tail;
        iArr[i2] = i;
        int i3 = this.capacityBitmask & (i2 + 1);
        this.tail = i3;
        if (i3 == this.head) {
            doubleCapacity();
        }
    }

    public final int popFirst() {
        int i = this.head;
        if (i != this.tail) {
            int i2 = this.elements[i];
            this.head = (i + 1) & this.capacityBitmask;
            return i2;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int popLast() {
        int i = this.head;
        int i2 = this.tail;
        if (i != i2) {
            int i3 = this.capacityBitmask & (i2 - 1);
            int i4 = this.elements[i3];
            this.tail = i3;
            return i4;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final void removeFromStart(int i) {
        if (i > 0) {
            if (i <= size()) {
                this.head = this.capacityBitmask & (this.head + i);
                return;
            }
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final void removeFromEnd(int i) {
        if (i > 0) {
            if (i <= size()) {
                this.tail = this.capacityBitmask & (this.tail - i);
                return;
            }
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final int getFirst() {
        int i = this.head;
        if (i != this.tail) {
            return this.elements[i];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i = this.head;
        int i2 = this.tail;
        if (i != i2) {
            return this.elements[(i2 - 1) & this.capacityBitmask];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int get(int i) {
        if (i < 0 || i >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.elements[this.capacityBitmask & (this.head + i)];
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }
}
