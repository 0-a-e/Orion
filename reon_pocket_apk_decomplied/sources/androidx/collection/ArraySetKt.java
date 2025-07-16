package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004H\b\u001a+\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00040\u0006\"\u0002H\u0004¢\u0006\u0002\u0010\u0007\u001a)\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0003H\b\u001a'\u0010\b\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\b\u001a&\u0010\u000f\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\b¢\u0006\u0002\u0010\u0011\u001a \u0010\u0012\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a \u0010\u0014\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a\u0019\u0010\u0016\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\b\u001a'\u0010\u0017\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\b\u001a&\u0010\u0018\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\b¢\u0006\u0002\u0010\u0011\u001a!\u0010\u0019\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u001a\u001a\u00020\u0001H\b\u001a#\u0010\u001b\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\b\u001a\u0019\u0010\u001e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\b\u001a*\u0010\u001f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a#\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001dH\b\u001a\u0018\u0010\"\u001a\u00020\u0001\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\u0000\u001a\u0019\u0010#\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\b\u001a)\u0010$\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\n0\u0003H\b\u001a'\u0010$\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\b\u001a&\u0010%\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010&\u001a\u00020\u0001H\b¢\u0006\u0002\u0010'\u001a&\u0010(\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010\u0010\u001a\u0002H\nH\b¢\u0006\u0002\u0010\u0011\u001a'\u0010)\u001a\u00020\f\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000eH\b\u001a\u0019\u0010*\u001a\u00020+\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u0003H\b\u001a&\u0010,\u001a\u0002H\n\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00032\u0006\u0010&\u001a\u00020\u0001H\b¢\u0006\u0002\u0010'\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"ARRAY_SET_BASE_SIZE", "", "arraySetOf", "Landroidx/collection/ArraySet;", "T", "values", "", "([Ljava/lang/Object;)Landroidx/collection/ArraySet;", "addAllInternal", "", "E", "array", "", "elements", "", "addInternal", "element", "(Landroidx/collection/ArraySet;Ljava/lang/Object;)Z", "allocArrays", "size", "binarySearchInternal", "hash", "clearInternal", "containsAllInternal", "containsInternal", "ensureCapacityInternal", "minimumCapacity", "equalsInternal", "other", "", "hashCodeInternal", "indexOf", "key", "indexOfInternal", "indexOfNull", "isEmptyInternal", "removeAllInternal", "removeAtInternal", "index", "(Landroidx/collection/ArraySet;I)Ljava/lang/Object;", "removeInternal", "retainAllInternal", "toStringInternal", "", "valueAtInternal", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ArraySet.kt */
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, (DefaultConstructorMarker) null);
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "values");
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        for (T add : tArr) {
            arraySet.add(add);
        }
        return arraySet;
    }

    public static final <E> int binarySearchInternal(ArraySet<E> arraySet, int i) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes$collection(), arraySet.get_size$collection(), i);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> int indexOf(ArraySet<E> arraySet, Object obj, int i) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int i2 = arraySet.get_size$collection();
        if (i2 == 0) {
            return -1;
        }
        int binarySearchInternal = binarySearchInternal(arraySet, i);
        if (binarySearchInternal < 0 || Intrinsics.areEqual(obj, arraySet.getArray$collection()[binarySearchInternal])) {
            return binarySearchInternal;
        }
        int i3 = binarySearchInternal + 1;
        while (i3 < i2 && arraySet.getHashes$collection()[i3] == i) {
            if (Intrinsics.areEqual(obj, arraySet.getArray$collection()[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = binarySearchInternal - 1;
        while (i4 >= 0 && arraySet.getHashes$collection()[i4] == i) {
            if (Intrinsics.areEqual(obj, arraySet.getArray$collection()[i4])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public static final <E> int indexOfNull(ArraySet<E> arraySet) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        return indexOf(arraySet, (Object) null, 0);
    }

    public static final <E> void allocArrays(ArraySet<E> arraySet, int i) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        arraySet.setHashes$collection(new int[i]);
        arraySet.setArray$collection(new Object[i]);
    }

    public static final <E> void clearInternal(ArraySet<E> arraySet) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> arraySet, int i) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int i2 = arraySet.get_size$collection();
        if (arraySet.getHashes$collection().length < i) {
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i);
            if (arraySet.get_size$collection() > 0) {
                ArraysKt.copyInto$default(hashes$collection, arraySet.getHashes$collection(), 0, 0, arraySet.get_size$collection(), 6, (Object) null);
                ArraysKt.copyInto$default(array$collection, arraySet.getArray$collection(), 0, 0, arraySet.get_size$collection(), 6, (Object) null);
            }
        }
        if (arraySet.get_size$collection() != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean containsInternal(ArraySet<E> arraySet, E e) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        return arraySet.indexOf(e) >= 0;
    }

    public static final <E> int indexOfInternal(ArraySet<E> arraySet, Object obj) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        return obj == null ? indexOfNull(arraySet) : indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> E valueAtInternal(ArraySet<E> arraySet, int i) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        return arraySet.getArray$collection()[i];
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> arraySet) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        return arraySet.get_size$collection() <= 0;
    }

    public static final <E> boolean addInternal(ArraySet<E> arraySet, E e) {
        int i;
        int i2;
        ArraySet<E> arraySet2 = arraySet;
        E e2 = e;
        Intrinsics.checkNotNullParameter(arraySet2, "<this>");
        int i3 = arraySet.get_size$collection();
        boolean z = false;
        if (e2 == null) {
            i2 = indexOfNull(arraySet);
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            i2 = indexOf(arraySet2, e2, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i4 = ~i2;
        if (i3 >= arraySet.getHashes$collection().length) {
            int i5 = 8;
            if (i3 >= 8) {
                i5 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i5 = 4;
            }
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet2, i5);
            if (i3 == arraySet.get_size$collection()) {
                if (arraySet.getHashes$collection().length == 0) {
                    z = true;
                }
                if (!z) {
                    ArraysKt.copyInto$default(hashes$collection, arraySet.getHashes$collection(), 0, 0, hashes$collection.length, 6, (Object) null);
                    ArraysKt.copyInto$default(array$collection, arraySet.getArray$collection(), 0, 0, array$collection.length, 6, (Object) null);
                }
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i3) {
            int i6 = i4 + 1;
            ArraysKt.copyInto(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i6, i4, i3);
            ArraysKt.copyInto((T[]) arraySet.getArray$collection(), (T[]) arraySet.getArray$collection(), i6, i4, i3);
        }
        if (i3 != arraySet.get_size$collection() || i4 >= arraySet.getHashes$collection().length) {
            throw new ConcurrentModificationException();
        }
        arraySet.getHashes$collection()[i4] = i;
        arraySet.getArray$collection()[i4] = e2;
        arraySet2.set_size$collection(arraySet.get_size$collection() + 1);
        return true;
    }

    public static final <E> void addAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> arraySet2) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        Intrinsics.checkNotNullParameter(arraySet2, "array");
        int i = arraySet2.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i);
        if (arraySet.get_size$collection() != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                arraySet.add(arraySet2.valueAt(i2));
            }
        } else if (i > 0) {
            int i3 = i;
            ArraysKt.copyInto$default(arraySet2.getHashes$collection(), arraySet.getHashes$collection(), 0, 0, i3, 6, (Object) null);
            ArraysKt.copyInto$default(arraySet2.getArray$collection(), arraySet.getArray$collection(), 0, 0, i3, 6, (Object) null);
            if (arraySet.get_size$collection() == 0) {
                arraySet.set_size$collection(i);
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> boolean removeInternal(ArraySet<E> arraySet, E e) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int indexOf = arraySet.indexOf(e);
        if (indexOf < 0) {
            return false;
        }
        arraySet.removeAt(indexOf);
        return true;
    }

    public static final <E> E removeAtInternal(ArraySet<E> arraySet, int i) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int i2 = arraySet.get_size$collection();
        E e = arraySet.getArray$collection()[i];
        if (i2 <= 1) {
            arraySet.clear();
        } else {
            int i3 = i2 - 1;
            int i4 = 8;
            if (arraySet.getHashes$collection().length <= 8 || arraySet.get_size$collection() >= arraySet.getHashes$collection().length / 3) {
                if (i < i3) {
                    int i5 = i + 1;
                    ArraysKt.copyInto(arraySet.getHashes$collection(), arraySet.getHashes$collection(), i, i5, i2);
                    ArraysKt.copyInto((T[]) arraySet.getArray$collection(), (T[]) arraySet.getArray$collection(), i, i5, i2);
                }
                arraySet.getArray$collection()[i3] = null;
            } else {
                if (arraySet.get_size$collection() > 8) {
                    i4 = arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1);
                }
                int[] hashes$collection = arraySet.getHashes$collection();
                Object[] array$collection = arraySet.getArray$collection();
                allocArrays(arraySet, i4);
                if (i > 0) {
                    int i6 = i;
                    ArraysKt.copyInto$default(hashes$collection, arraySet.getHashes$collection(), 0, 0, i6, 6, (Object) null);
                    ArraysKt.copyInto$default(array$collection, arraySet.getArray$collection(), 0, 0, i6, 6, (Object) null);
                }
                if (i < i3) {
                    int i7 = i + 1;
                    ArraysKt.copyInto(hashes$collection, arraySet.getHashes$collection(), i, i7, i2);
                    ArraysKt.copyInto((T[]) array$collection, (T[]) arraySet.getArray$collection(), i, i7, i2);
                }
            }
            if (i2 == arraySet.get_size$collection()) {
                arraySet.set_size$collection(i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> arraySet2) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        Intrinsics.checkNotNullParameter(arraySet2, "array");
        int i = arraySet2.get_size$collection();
        int i2 = arraySet.get_size$collection();
        for (int i3 = 0; i3 < i; i3++) {
            arraySet.remove(arraySet2.valueAt(i3));
        }
        if (i2 != arraySet.get_size$collection()) {
            return true;
        }
        return false;
    }

    public static final <E> boolean equalsInternal(ArraySet<E> arraySet, Object obj) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = arraySet.get_size$collection();
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Set) obj).contains(arraySet.valueAt(i2))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(ArraySet<E> arraySet) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int[] hashes$collection = arraySet.getHashes$collection();
        int i = arraySet.get_size$collection();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += hashes$collection[i3];
        }
        return i2;
    }

    public static final <E> String toStringInternal(ArraySet<E> arraySet) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i = arraySet.get_size$collection();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E valueAt = arraySet.valueAt(i2);
            if (valueAt != arraySet) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        for (Object contains : collection) {
            if (!arraySet.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean addAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        arraySet.ensureCapacity(arraySet.get_size$collection() + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= arraySet.add(add);
        }
        return z;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        boolean z = false;
        for (Object remove : collection) {
            z |= arraySet.remove(remove);
        }
        return z;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        Intrinsics.checkNotNullParameter(collection, "elements");
        boolean z = false;
        for (int i = arraySet.get_size$collection() - 1; -1 < i; i--) {
            if (!CollectionsKt.contains(collection, arraySet.getArray$collection()[i])) {
                arraySet.removeAt(i);
                z = true;
            }
        }
        return z;
    }
}
