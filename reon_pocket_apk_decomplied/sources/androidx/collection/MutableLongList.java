package androidx.collection;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\b\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0001J\u0018\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001J\u0018\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0003J\u0011\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u0011\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\nJ\u0011\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0011\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u0011\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\nJ\u0011\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\n\u001a\u00020\u0003J\u001a\u0010\u0018\u001a\u00020\t2\b\b\u0001\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u001b\u0010\u001c\u001a\u00020\f2\b\b\u0001\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\tJ\u0010\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u0003R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Landroidx/collection/MutableLongList;", "Landroidx/collection/LongList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "add", "", "index", "element", "", "", "addAll", "elements", "", "clear", "ensureCapacity", "minusAssign", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "set", "sort", "sortDescending", "trim", "minCapacity", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LongList.kt */
public final class MutableLongList extends LongList {
    public MutableLongList() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableLongList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public MutableLongList(int i) {
        super(i, (DefaultConstructorMarker) null);
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final boolean add(long j) {
        ensureCapacity(this._size + 1);
        this.content[this._size] = j;
        this._size++;
        return true;
    }

    public final void add(int i, long j) {
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        }
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        if (i != this._size) {
            ArraysKt.copyInto(jArr, jArr, i + 1, i, this._size);
        }
        jArr[i] = j;
        this._size++;
    }

    public final boolean addAll(int i, long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (jArr.length == 0) {
            return false;
        } else {
            ensureCapacity(this._size + jArr.length);
            long[] jArr2 = this.content;
            if (i != this._size) {
                ArraysKt.copyInto(jArr2, jArr2, jArr.length + i, i, this._size);
            }
            ArraysKt.copyInto$default(jArr, jArr2, i, 0, 0, 12, (Object) null);
            this._size += jArr.length;
            return true;
        }
    }

    public final boolean addAll(int i, LongList longList) {
        Intrinsics.checkNotNullParameter(longList, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (longList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + longList._size);
            long[] jArr = this.content;
            if (i != this._size) {
                ArraysKt.copyInto(jArr, jArr, longList._size + i, i, this._size);
            }
            ArraysKt.copyInto(longList.content, jArr, i, 0, longList._size);
            this._size += longList._size;
            return true;
        }
    }

    public final boolean addAll(LongList longList) {
        Intrinsics.checkNotNullParameter(longList, "elements");
        return addAll(this._size, longList);
    }

    public final boolean addAll(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "elements");
        return addAll(this._size, jArr);
    }

    public final void plusAssign(LongList longList) {
        Intrinsics.checkNotNullParameter(longList, "elements");
        addAll(this._size, longList);
    }

    public final void plusAssign(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "elements");
        addAll(this._size, jArr);
    }

    public final void clear() {
        this._size = 0;
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableLongList._size;
        }
        mutableLongList.trim(i);
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        if (this.content.length > max) {
            long[] copyOf = Arrays.copyOf(this.content, max);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void ensureCapacity(int i) {
        long[] jArr = this.content;
        if (jArr.length < i) {
            long[] copyOf = Arrays.copyOf(jArr, Math.max(i, (jArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void plusAssign(long j) {
        add(j);
    }

    public final void minusAssign(long j) {
        remove(j);
    }

    public final boolean remove(long j) {
        int indexOf = indexOf(j);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "elements");
        int i = this._size;
        for (long remove : jArr) {
            remove(remove);
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean removeAll(LongList longList) {
        Intrinsics.checkNotNullParameter(longList, "elements");
        int i = this._size;
        int i2 = longList._size - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                remove(longList.get(i3));
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

    public final long removeAt(int i) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder("Index ");
            sb.append(i);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        long[] jArr = this.content;
        long j = jArr[i];
        if (i != this._size - 1) {
            ArraysKt.copyInto(jArr, jArr, i, i + 1, this._size);
        }
        this._size--;
        return j;
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

    public final boolean retainAll(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "elements");
        int i = this._size;
        long[] jArr2 = this.content;
        int i2 = this._size - 1;
        while (true) {
            int i3 = -1;
            if (-1 >= i2) {
                break;
            }
            long j = jArr2[i2];
            int length = jArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (jArr[i4] == j) {
                    i3 = i4;
                    break;
                }
                i4++;
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

    public final boolean retainAll(LongList longList) {
        Intrinsics.checkNotNullParameter(longList, "elements");
        int i = this._size;
        long[] jArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (!longList.contains(jArr[i2])) {
                removeAt(i2);
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final long set(int i, long j) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder("set index ");
            sb.append(i);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        long[] jArr = this.content;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    public final void sort() {
        ArraysKt.sort(this.content, 0, this._size);
    }

    public final void sortDescending() {
        ArraysKt.sortDescending(this.content, 0, this._size);
    }

    public final void minusAssign(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "elements");
        for (long remove : jArr) {
            remove(remove);
        }
    }

    public final void minusAssign(LongList longList) {
        Intrinsics.checkNotNullParameter(longList, "elements");
        long[] jArr = longList.content;
        int i = longList._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(jArr[i2]);
        }
    }
}
