package androidx.compose.ui.text.caches;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b'\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0016\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0000¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0005J\u0013\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\"J\u001b\u0010#\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010$\u001a\u00028\u0001¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0005H\u0016J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0005H\u0004J\u0010\u0010)\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\b\u0010*\u001a\u00020\u0005H\u0004J\u0017\u0010+\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00028\u0001H\u0000¢\u0006\u0004\b,\u0010-J\u0006\u0010.\u001a\u00020\u0018J\u0013\u0010/\u001a\u00028\u00002\u0006\u00100\u001a\u00020\u0005¢\u0006\u0002\u00101J\u001d\u00102\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u001e\u00103\u001a\u00020\u00162\u0016\u00104\u001a\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\u0000J\u001d\u00105\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010%J\u0015\u00106\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u0000¢\u0006\u0002\u0010\"J\u001b\u00106\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u00107J\u0015\u00108\u001a\u0004\u0018\u00018\u00012\u0006\u00100\u001a\u00020\u0005¢\u0006\u0002\u00101J\u001d\u00109\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010%J#\u00109\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010:\u001a\u00028\u00012\u0006\u0010;\u001a\u00028\u0001¢\u0006\u0002\u0010<J\u001b\u0010=\u001a\u00028\u00012\u0006\u00100\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00028\u0001¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020@H\u0016J\u0013\u0010A\u001a\u00028\u00012\u0006\u00100\u001a\u00020\u0005¢\u0006\u0002\u00101R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00058G¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0012\u0010\u000b¨\u0006B"}, d2 = {"Landroidx/compose/ui/text/caches/SimpleArrayMap;", "K", "V", "", "capacity", "", "(I)V", "map", "(Landroidx/compose/ui/text/caches/SimpleArrayMap;)V", "_size", "get_size", "()I", "set_size", "hashes", "", "keyValues", "", "[Ljava/lang/Object;", "size", "size$annotations", "()V", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "ensureCapacity", "minimumCapacity", "equals", "other", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrDefault", "defaultValue", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "hashCode", "indexOf", "hash", "indexOfKey", "indexOfNull", "indexOfValue", "indexOfValue$ui_text_release", "(Ljava/lang/Object;)I", "isEmpty", "keyAt", "index", "(I)Ljava/lang/Object;", "put", "putAll", "array", "putIfAbsent", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "removeAt", "replace", "oldValue", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Z", "setValueAt", "(ILjava/lang/Object;)Ljava/lang/Object;", "toString", "", "valueAt", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SimpleArrayMap.kt */
public final class SimpleArrayMap<K, V> {
    public static final int $stable = 8;
    private int _size;
    private int[] hashes;
    private Object[] keyValues;

    public SimpleArrayMap() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void size$annotations() {
    }

    /* access modifiers changed from: protected */
    public final int get_size() {
        return this._size;
    }

    /* access modifiers changed from: protected */
    public final void set_size(int i) {
        this._size = i;
    }

    public final int size() {
        return this._size;
    }

    /* access modifiers changed from: protected */
    public final int indexOf(Object obj, int i) {
        int i2 = this._size;
        if (i2 == 0) {
            return -1;
        }
        int binarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, i2, i);
        if (binarySearchInternal < 0 || Intrinsics.areEqual(obj, this.keyValues[binarySearchInternal << 1])) {
            return binarySearchInternal;
        }
        int i3 = binarySearchInternal + 1;
        while (i3 < i2 && this.hashes[i3] == i) {
            if (Intrinsics.areEqual(obj, this.keyValues[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = binarySearchInternal - 1;
        while (i4 >= 0 && this.hashes[i4] == i) {
            if (Intrinsics.areEqual(obj, this.keyValues[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    /* access modifiers changed from: protected */
    public final int indexOfNull() {
        int i = this._size;
        if (i == 0) {
            return -1;
        }
        int binarySearchInternal = ContainerHelpersKt.binarySearchInternal(this.hashes, i, 0);
        if (binarySearchInternal < 0 || this.keyValues[binarySearchInternal << 1] == null) {
            return binarySearchInternal;
        }
        int i2 = binarySearchInternal + 1;
        while (i2 < i && this.hashes[i2] == 0) {
            if (this.keyValues[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = binarySearchInternal - 1;
        while (i3 >= 0 && this.hashes[i3] == 0) {
            if (this.keyValues[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            this.hashes = new int[i];
            this.keyValues = new Object[(i << 1)];
        }
        this._size = 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SimpleArrayMap(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this(0, 1, (DefaultConstructorMarker) null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }

    public final void clear() {
        if (this._size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.keyValues = ContainerHelpersKt.EMPTY_OBJECTS;
            this._size = 0;
        }
        if (this._size > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public final void ensureCapacity(int i) {
        int i2 = this._size;
        int[] iArr = this.hashes;
        if (iArr.length < i) {
            int[] copyOf = Arrays.copyOf(iArr, i);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.keyValues, i << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.keyValues = copyOf2;
        }
        if (this._size != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean containsKey(K k) {
        return indexOfKey(k) >= 0;
    }

    public final int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    public final int indexOfValue$ui_text_release(V v) {
        int i = this._size << 1;
        Object[] objArr = this.keyValues;
        if (v == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (Intrinsics.areEqual((Object) v, objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final boolean containsValue(V v) {
        return indexOfValue$ui_text_release(v) >= 0;
    }

    public final V get(K k) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return this.keyValues[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public final V getOrDefault(K k, V v) {
        int indexOfKey = indexOfKey(k);
        return indexOfKey >= 0 ? this.keyValues[(indexOfKey << 1) + 1] : v;
    }

    public final K keyAt(int i) {
        return this.keyValues[i << 1];
    }

    public final V valueAt(int i) {
        return this.keyValues[(i << 1) + 1];
    }

    public final V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V[] vArr = this.keyValues;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    public final boolean isEmpty() {
        return this._size <= 0;
    }

    public final V put(K k, V v) {
        int i;
        int i2;
        int i3 = this._size;
        if (k == null) {
            i2 = indexOfNull();
            i = 0;
        } else {
            i = k.hashCode();
            i2 = indexOf(k, i);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.keyValues;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = ~i2;
        int[] iArr = this.hashes;
        if (i3 >= iArr.length) {
            int i6 = 8;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i6 = 4;
            }
            int[] copyOf = Arrays.copyOf(iArr, i6);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.hashes = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.keyValues, i6 << 1);
            Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
            this.keyValues = copyOf2;
            if (i3 != this._size) {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr2 = this.hashes;
            int i7 = i5 + 1;
            ArraysKt.copyInto(iArr2, iArr2, i7, i5, i3);
            Object[] objArr = this.keyValues;
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i7 << 1, i5 << 1, this._size << 1);
        }
        int i8 = this._size;
        if (i3 == i8) {
            int[] iArr3 = this.hashes;
            if (i5 < iArr3.length) {
                iArr3[i5] = i;
                Object[] objArr2 = this.keyValues;
                int i9 = i5 << 1;
                objArr2[i9] = k;
                objArr2[i9 + 1] = v;
                this._size = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap._size;
        ensureCapacity(this._size + i);
        if (this._size != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i > 0) {
            ArraysKt.copyInto(simpleArrayMap.hashes, this.hashes, 0, 0, i);
            ArraysKt.copyInto((T[]) simpleArrayMap.keyValues, (T[]) this.keyValues, 0, 0, i << 1);
            this._size = i;
        }
    }

    public final V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public final V remove(K k) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public final boolean remove(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0 || !Intrinsics.areEqual((Object) v, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public final V removeAt(int i) {
        V[] vArr = this.keyValues;
        int i2 = i << 1;
        V v = vArr[i2 + 1];
        int i3 = this._size;
        if (i3 <= 1) {
            clear();
        } else {
            int i4 = i3 - 1;
            int[] iArr = this.hashes;
            int i5 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i4) {
                    int i6 = i + 1;
                    ArraysKt.copyInto(iArr, iArr, i, i6, i3);
                    Object[] objArr = this.keyValues;
                    ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i2, i6 << 1, i3 << 1);
                }
                Object[] objArr2 = this.keyValues;
                int i7 = i4 << 1;
                objArr2[i7] = null;
                objArr2[i7 + 1] = null;
            } else {
                if (i3 > 8) {
                    i5 = i3 + (i3 >> 1);
                }
                int[] iArr2 = new int[i5];
                this.hashes = iArr2;
                this.keyValues = new Object[(i5 << 1)];
                if (i > 0) {
                    ArraysKt.copyInto(iArr, iArr2, 0, 0, i);
                    ArraysKt.copyInto((T[]) vArr, (T[]) this.keyValues, 0, 0, i2);
                }
                if (i < i4) {
                    int i8 = i + 1;
                    ArraysKt.copyInto(iArr, this.hashes, i, i8, i3);
                    ArraysKt.copyInto((T[]) vArr, (T[]) this.keyValues, i2, i8 << 1, i3 << 1);
                }
            }
            if (i3 == this._size) {
                this._size = i4;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return v;
    }

    public final V replace(K k, V v) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v);
        }
        return null;
    }

    public final boolean replace(K k, V v, V v2) {
        int indexOfKey = indexOfKey(k);
        if (indexOfKey < 0 || valueAt(indexOfKey) != v) {
            return false;
        }
        setValueAt(indexOfKey, v2);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i = this._size;
                if (i != simpleArrayMap._size) {
                    return false;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    Object keyAt = keyAt(i2);
                    Object valueAt = valueAt(i2);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(valueAt, obj2)) {
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof Map) || this._size != ((Map) obj).size()) {
                return false;
            } else {
                int i3 = this._size;
                for (int i4 = 0; i4 < i3; i4++) {
                    Object keyAt2 = keyAt(i4);
                    Object valueAt2 = valueAt(i4);
                    Object obj3 = ((Map) obj).get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !((Map) obj).containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(valueAt2, obj3)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.keyValues;
        int i = this._size;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this._size * 28);
        sb.append('{');
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object keyAt = keyAt(i2);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
