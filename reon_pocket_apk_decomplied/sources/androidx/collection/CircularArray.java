package androidx.collection;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\u0016\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000b\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u000b\u0010\u001e\u001a\u00028\u0000¢\u0006\u0002\u0010\fJ\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010\"\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/collection/CircularArray;", "E", "", "minCapacity", "", "(I)V", "capacityBitmask", "elements", "", "[Ljava/lang/Object;", "first", "getFirst", "()Ljava/lang/Object;", "head", "last", "getLast", "tail", "addFirst", "", "element", "(Ljava/lang/Object;)V", "addLast", "clear", "doubleCapacity", "get", "index", "(I)Ljava/lang/Object;", "isEmpty", "", "popFirst", "popLast", "removeFromEnd", "count", "removeFromStart", "size", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CircularArray.kt */
public final class CircularArray<E> {
    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;

    public CircularArray() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public CircularArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1".toString());
        } else if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.capacityBitmask = i - 1;
            this.elements = new Object[i];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30".toString());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularArray(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 8 : i);
    }

    private final void doubleCapacity() {
        E[] eArr = this.elements;
        int length = eArr.length;
        int i = this.head;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            E[] eArr2 = new Object[i3];
            ArraysKt.copyInto((T[]) eArr, (T[]) eArr2, 0, i, length);
            ArraysKt.copyInto((T[]) this.elements, (T[]) eArr2, i2, 0, this.head);
            this.elements = eArr2;
            this.head = 0;
            this.tail = length;
            this.capacityBitmask = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void addFirst(E e) {
        int i = (this.head - 1) & this.capacityBitmask;
        this.head = i;
        this.elements[i] = e;
        if (i == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e) {
        E[] eArr = this.elements;
        int i = this.tail;
        eArr[i] = e;
        int i2 = this.capacityBitmask & (i + 1);
        this.tail = i2;
        if (i2 == this.head) {
            doubleCapacity();
        }
    }

    public final E popFirst() {
        int i = this.head;
        if (i != this.tail) {
            E[] eArr = this.elements;
            E e = eArr[i];
            eArr[i] = null;
            this.head = (i + 1) & this.capacityBitmask;
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E popLast() {
        int i = this.head;
        int i2 = this.tail;
        if (i != i2) {
            int i3 = this.capacityBitmask & (i2 - 1);
            E[] eArr = this.elements;
            E e = eArr[i3];
            eArr[i3] = null;
            this.tail = i3;
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final void removeFromStart(int i) {
        if (i > 0) {
            if (i <= size()) {
                int length = this.elements.length;
                int i2 = this.head;
                if (i < length - i2) {
                    length = i2 + i;
                }
                while (i2 < length) {
                    this.elements[i2] = null;
                    i2++;
                }
                int i3 = this.head;
                int i4 = length - i3;
                int i5 = i - i4;
                this.head = this.capacityBitmask & (i3 + i4);
                if (i5 > 0) {
                    for (int i6 = 0; i6 < i5; i6++) {
                        this.elements[i6] = null;
                    }
                    this.head = i5;
                    return;
                }
                return;
            }
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final void removeFromEnd(int i) {
        if (i > 0) {
            if (i <= size()) {
                int i2 = this.tail;
                int i3 = i < i2 ? i2 - i : 0;
                for (int i4 = i3; i4 < i2; i4++) {
                    this.elements[i4] = null;
                }
                int i5 = this.tail;
                int i6 = i5 - i3;
                int i7 = i - i6;
                this.tail = i5 - i6;
                if (i7 > 0) {
                    int length = this.elements.length;
                    this.tail = length;
                    int i8 = length - i7;
                    for (int i9 = i8; i9 < length; i9++) {
                        this.elements[i9] = null;
                    }
                    this.tail = i8;
                    return;
                }
                return;
            }
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final E getFirst() {
        int i = this.head;
        if (i != this.tail) {
            E e = this.elements[i];
            Intrinsics.checkNotNull(e);
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getLast() {
        int i = this.head;
        int i2 = this.tail;
        if (i != i2) {
            E e = this.elements[(i2 - 1) & this.capacityBitmask];
            Intrinsics.checkNotNull(e);
            return e;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E get(int i) {
        if (i < 0 || i >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.elements[this.capacityBitmask & (this.head + i)];
        Intrinsics.checkNotNull(e);
        return e;
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }
}
