package androidx.collection;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\u0018\u0010\b\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u0018\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0001J\u0018\u0010\r\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0003J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002J\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\nJ\u0011\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0003H\nJ\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u0003J\u001a\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\u0018\u001a\u00020\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u0003J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0001J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001b\u0010\u001b\u001a\u00020\u00032\b\b\u0001\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bJ\u0010\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u0003R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, d2 = {"Landroidx/collection/MutableIntList;", "Landroidx/collection/IntList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "add", "", "element", "", "index", "addAll", "elements", "", "clear", "ensureCapacity", "minusAssign", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "set", "sort", "sortDescending", "trim", "minCapacity", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntList.kt */
public final class MutableIntList extends IntList {
    public MutableIntList() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableIntList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public MutableIntList(int i) {
        super(i, (DefaultConstructorMarker) null);
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final boolean add(int i) {
        ensureCapacity(this._size + 1);
        this.content[this._size] = i;
        this._size++;
        return true;
    }

    public final void add(int i, int i2) {
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        }
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        if (i != this._size) {
            ArraysKt.copyInto(iArr, iArr, i + 1, i, this._size);
        }
        iArr[i] = i2;
        this._size++;
    }

    public final boolean addAll(int i, int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (iArr.length == 0) {
            return false;
        } else {
            ensureCapacity(this._size + iArr.length);
            int[] iArr2 = this.content;
            if (i != this._size) {
                ArraysKt.copyInto(iArr2, iArr2, iArr.length + i, i, this._size);
            }
            ArraysKt.copyInto$default(iArr, iArr2, i, 0, 0, 12, (Object) null);
            this._size += iArr.length;
            return true;
        }
    }

    public final boolean addAll(int i, IntList intList) {
        Intrinsics.checkNotNullParameter(intList, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (intList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + intList._size);
            int[] iArr = this.content;
            if (i != this._size) {
                ArraysKt.copyInto(iArr, iArr, intList._size + i, i, this._size);
            }
            ArraysKt.copyInto(intList.content, iArr, i, 0, intList._size);
            this._size += intList._size;
            return true;
        }
    }

    public final boolean addAll(IntList intList) {
        Intrinsics.checkNotNullParameter(intList, "elements");
        return addAll(this._size, intList);
    }

    public final boolean addAll(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        return addAll(this._size, iArr);
    }

    public final void plusAssign(IntList intList) {
        Intrinsics.checkNotNullParameter(intList, "elements");
        addAll(this._size, intList);
    }

    public final void plusAssign(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        addAll(this._size, iArr);
    }

    public final void clear() {
        this._size = 0;
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableIntList._size;
        }
        mutableIntList.trim(i);
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        if (this.content.length > max) {
            int[] copyOf = Arrays.copyOf(this.content, max);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void ensureCapacity(int i) {
        int[] iArr = this.content;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, Math.max(i, (iArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void plusAssign(int i) {
        add(i);
    }

    public final void minusAssign(int i) {
        remove(i);
    }

    public final boolean remove(int i) {
        int indexOf = indexOf(i);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        int i = this._size;
        for (int remove : iArr) {
            remove(remove);
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean removeAll(IntList intList) {
        Intrinsics.checkNotNullParameter(intList, "elements");
        int i = this._size;
        int i2 = intList._size - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                remove(intList.get(i3));
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final int removeAt(int i) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder("Index ");
            sb.append(i);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int[] iArr = this.content;
        int i2 = iArr[i];
        if (i != this._size - 1) {
            ArraysKt.copyInto(iArr, iArr, i, i + 1, this._size);
        }
        this._size--;
        return i2;
    }

    public final void removeRange(int i, int i2) {
        if (i < 0 || i > this._size || i2 < 0 || i2 > this._size) {
            throw new IndexOutOfBoundsException("Start (" + i + ") and end (" + i2 + ") must be in 0.." + this._size);
        } else if (i2 < i) {
            throw new IllegalArgumentException("Start (" + i + ") is more than end (" + i2 + ')');
        } else if (i2 != i) {
            if (i2 < this._size) {
                ArraysKt.copyInto(this.content, this.content, i, i2, this._size);
            }
            this._size -= i2 - i;
        }
    }

    public final boolean retainAll(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        int i = this._size;
        int[] iArr2 = this.content;
        int i2 = this._size - 1;
        while (true) {
            int i3 = -1;
            if (-1 >= i2) {
                break;
            }
            int i4 = iArr2[i2];
            int length = iArr.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if (iArr[i5] == i4) {
                    i3 = i5;
                    break;
                }
                i5++;
            }
            if (i3 < 0) {
                removeAt(i2);
            }
            i2--;
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean retainAll(IntList intList) {
        Intrinsics.checkNotNullParameter(intList, "elements");
        int i = this._size;
        int[] iArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (!intList.contains(iArr[i2])) {
                removeAt(i2);
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final int set(int i, int i2) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder("set index ");
            sb.append(i);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int[] iArr = this.content;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    public final void sort() {
        ArraysKt.sort(this.content, 0, this._size);
    }

    public final void sortDescending() {
        ArraysKt.sortDescending(this.content, 0, this._size);
    }

    public final void minusAssign(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "elements");
        for (int remove : iArr) {
            remove(remove);
        }
    }

    public final void minusAssign(IntList intList) {
        Intrinsics.checkNotNullParameter(intList, "elements");
        int[] iArr = intList.content;
        int i = intList._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(iArr[i2]);
        }
    }
}
