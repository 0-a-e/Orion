package androidx.collection;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001J\u0018\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0003J\u0011\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u0011\u0010\u0013\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u000bH\nJ\u0011\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0001H\u0002J\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u000bH\nJ\u0011\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0003J\u001a\u0010\u0018\u001a\u00020\f2\b\b\u0001\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0001J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u001b\u0010\u001c\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\fJ\u0010\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\u0003R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006!"}, d2 = {"Landroidx/collection/MutableFloatList;", "Landroidx/collection/FloatList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "add", "", "element", "", "", "index", "addAll", "elements", "", "clear", "ensureCapacity", "minusAssign", "plusAssign", "remove", "removeAll", "removeAt", "removeRange", "start", "end", "retainAll", "set", "sort", "sortDescending", "trim", "minCapacity", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatList.kt */
public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableFloatList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public MutableFloatList(int i) {
        super(i, (DefaultConstructorMarker) null);
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final boolean add(float f) {
        ensureCapacity(this._size + 1);
        this.content[this._size] = f;
        this._size++;
        return true;
    }

    public final void add(int i, float f) {
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        }
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        if (i != this._size) {
            ArraysKt.copyInto(fArr, fArr, i + 1, i, this._size);
        }
        fArr[i] = f;
        this._size++;
    }

    public final boolean addAll(int i, float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (fArr.length == 0) {
            return false;
        } else {
            ensureCapacity(this._size + fArr.length);
            float[] fArr2 = this.content;
            if (i != this._size) {
                ArraysKt.copyInto(fArr2, fArr2, fArr.length + i, i, this._size);
            }
            ArraysKt.copyInto$default(fArr, fArr2, i, 0, 0, 12, (Object) null);
            this._size += fArr.length;
            return true;
        }
    }

    public final boolean addAll(int i, FloatList floatList) {
        Intrinsics.checkNotNullParameter(floatList, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (floatList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + floatList._size);
            float[] fArr = this.content;
            if (i != this._size) {
                ArraysKt.copyInto(fArr, fArr, floatList._size + i, i, this._size);
            }
            ArraysKt.copyInto(floatList.content, fArr, i, 0, floatList._size);
            this._size += floatList._size;
            return true;
        }
    }

    public final boolean addAll(FloatList floatList) {
        Intrinsics.checkNotNullParameter(floatList, "elements");
        return addAll(this._size, floatList);
    }

    public final boolean addAll(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "elements");
        return addAll(this._size, fArr);
    }

    public final void plusAssign(FloatList floatList) {
        Intrinsics.checkNotNullParameter(floatList, "elements");
        addAll(this._size, floatList);
    }

    public final void plusAssign(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "elements");
        addAll(this._size, fArr);
    }

    public final void clear() {
        this._size = 0;
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableFloatList._size;
        }
        mutableFloatList.trim(i);
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        if (this.content.length > max) {
            float[] copyOf = Arrays.copyOf(this.content, max);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void ensureCapacity(int i) {
        float[] fArr = this.content;
        if (fArr.length < i) {
            float[] copyOf = Arrays.copyOf(fArr, Math.max(i, (fArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void plusAssign(float f) {
        add(f);
    }

    public final void minusAssign(float f) {
        remove(f);
    }

    public final boolean remove(float f) {
        int indexOf = indexOf(f);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "elements");
        int i = this._size;
        for (float remove : fArr) {
            remove(remove);
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean removeAll(FloatList floatList) {
        Intrinsics.checkNotNullParameter(floatList, "elements");
        int i = this._size;
        int i2 = floatList._size - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                remove(floatList.get(i3));
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

    public final float removeAt(int i) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder("Index ");
            sb.append(i);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        float[] fArr = this.content;
        float f = fArr[i];
        if (i != this._size - 1) {
            ArraysKt.copyInto(fArr, fArr, i, i + 1, this._size);
        }
        this._size--;
        return f;
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

    public final boolean retainAll(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "elements");
        int i = this._size;
        float[] fArr2 = this.content;
        int i2 = this._size - 1;
        while (true) {
            int i3 = -1;
            if (-1 >= i2) {
                break;
            }
            float f = fArr2[i2];
            int length = fArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                if (fArr[i4] == f) {
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

    public final boolean retainAll(FloatList floatList) {
        Intrinsics.checkNotNullParameter(floatList, "elements");
        int i = this._size;
        float[] fArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (!floatList.contains(fArr[i2])) {
                removeAt(i2);
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final float set(int i, float f) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder("set index ");
            sb.append(i);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        float[] fArr = this.content;
        float f2 = fArr[i];
        fArr[i] = f;
        return f2;
    }

    public final void sort() {
        ArraysKt.sort(this.content, 0, this._size);
    }

    public final void sortDescending() {
        ArraysKt.sortDescending(this.content, 0, this._size);
    }

    public final void minusAssign(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "elements");
        for (float remove : fArr) {
            remove(remove);
        }
    }

    public final void minusAssign(FloatList floatList) {
        Intrinsics.checkNotNullParameter(floatList, "elements");
        float[] fArr = floatList.content;
        int i = floatList._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(fArr[i2]);
        }
    }
}
