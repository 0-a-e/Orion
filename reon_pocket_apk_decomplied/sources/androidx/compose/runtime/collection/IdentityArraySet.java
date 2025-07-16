package androidx.compose.runtime.collection;

import androidx.compose.runtime.ActualJvm_jvmKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0012J\u0016\u0010\u001c\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J(\u0010\u001e\u001a\u00020\u00102\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100 H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010!\u001a\u00020\u00142\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00140 H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0012\u0010\"\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0016\u0010&\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0010H\u0016J\u0006\u0010)\u001a\u00020\u0010J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000+H\u0002J\u0013\u0010,\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u001d\u0010-\u001a\u00020\u00142\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00100 H\bJ\b\u0010/\u001a\u000200H\u0016R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR0\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n@BX\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u00061"}, d2 = {"Landroidx/compose/runtime/collection/IdentityArraySet;", "T", "", "", "()V", "<set-?>", "", "size", "getSize", "()I", "", "values", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "add", "", "value", "(Ljava/lang/Object;)Z", "addAll", "", "collection", "", "checkIndexBounds", "index", "clear", "contains", "element", "containsAll", "elements", "fastAny", "block", "Lkotlin/Function1;", "fastForEach", "find", "findExactIndex", "midIndex", "valueHash", "get", "(I)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "iterator", "", "remove", "removeValueIf", "predicate", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IdentityArraySet.kt */
public final class IdentityArraySet<T> implements Set<T>, KMappedMarker {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public int size;
    private Object[] values = new Object[16];

    /* renamed from: addAll  reason: collision with other method in class */
    public boolean m3395addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray(this, tArr);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public int getSize() {
        return this.size;
    }

    public final Object[] getValues() {
        return this.values;
    }

    public boolean contains(Object obj) {
        return obj != null && find(obj) >= 0;
    }

    public final T get(int i) {
        checkIndexBounds(i);
        T t = this.values[i];
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        return t;
    }

    public final boolean add(T t) {
        int i;
        int size2 = size();
        Object[] objArr = this.values;
        if (size2 > 0) {
            i = find(t);
            if (i >= 0) {
                return false;
            }
        } else {
            i = -1;
        }
        int i2 = -(i + 1);
        if (size2 == objArr.length) {
            Object[] objArr2 = new Object[(objArr.length * 2)];
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr2, i2 + 1, i2, size2);
            ArraysKt.copyInto$default(objArr, objArr2, 0, 0, i2, 6, (Object) null);
            this.values = objArr2;
        } else {
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i2 + 1, i2, size2);
        }
        this.values[i2] = t;
        this.size = size() + 1;
        return true;
    }

    public final void clear() {
        ArraysKt.fill$default(this.values, (Object) null, 0, 0, 6, (Object) null);
        this.size = 0;
    }

    public final void fastForEach(Function1<? super T, Unit> function1) {
        Object[] values2 = getValues();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            Object obj = values2[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            function1.invoke(obj);
        }
    }

    public final boolean fastAny(Function1<? super T, Boolean> function1) {
        int size2 = size();
        if (size2 == 0) {
            return false;
        }
        Object[] values2 = getValues();
        for (int i = 0; i < size2; i++) {
            Object obj = values2[i];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            if (function1.invoke(obj).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final void addAll(Collection<? extends T> collection) {
        Object[] objArr;
        Object obj;
        int i;
        if (!collection.isEmpty()) {
            if (!(collection instanceof IdentityArraySet)) {
                for (Object add : collection) {
                    add(add);
                }
                return;
            }
            Object[] objArr2 = this.values;
            IdentityArraySet identityArraySet = (IdentityArraySet) collection;
            Object[] objArr3 = identityArraySet.values;
            int size2 = size();
            int size3 = identityArraySet.size();
            int i2 = size2 + size3;
            boolean z = this.values.length < i2;
            boolean z2 = size2 == 0 || ActualJvm_jvmKt.identityHashCode(objArr2[size2 + -1]) < ActualJvm_jvmKt.identityHashCode(objArr3[0]);
            if (z || !z2) {
                if (z) {
                    objArr = new Object[(size2 > size3 ? size2 * 2 : size3 * 2)];
                } else {
                    objArr = objArr2;
                }
                int i3 = size2 - 1;
                int i4 = size3 - 1;
                int i5 = i2 - 1;
                while (true) {
                    if (i3 < 0 && i4 < 0) {
                        break;
                    }
                    if (i3 < 0) {
                        i = i4 - 1;
                        obj = objArr3[i4];
                    } else if (i4 < 0) {
                        i = i4;
                        obj = objArr2[i3];
                        i3--;
                    } else {
                        Object obj2 = objArr2[i3];
                        Object obj3 = objArr3[i4];
                        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj2);
                        int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj3);
                        if (identityHashCode > identityHashCode2) {
                            i3--;
                        } else {
                            if (identityHashCode >= identityHashCode2) {
                                if (obj2 != obj3) {
                                    int i6 = i3 - 1;
                                    while (i6 >= 0) {
                                        int i7 = i6 - 1;
                                        Object obj4 = objArr2[i6];
                                        if (ActualJvm_jvmKt.identityHashCode(obj4) != identityHashCode2) {
                                            break;
                                        } else if (obj3 == obj4) {
                                            i4--;
                                            break;
                                        } else {
                                            i6 = i7;
                                        }
                                    }
                                } else {
                                    i3--;
                                    i4--;
                                }
                            }
                            i = i4 - 1;
                            obj = obj3;
                        }
                        Object obj5 = obj2;
                        i = i4;
                        obj = obj5;
                    }
                    objArr[i5] = obj;
                    i4 = i;
                    i5--;
                }
                if (i5 >= 0) {
                    ArraysKt.copyInto((T[]) objArr, (T[]) objArr, 0, i5 + 1, i2);
                }
                int i8 = i2 - (i5 + 1);
                ArraysKt.fill((T[]) objArr, null, i8, i2);
                this.values = objArr;
                this.size = i8;
                return;
            }
            ArraysKt.copyInto((T[]) objArr3, (T[]) objArr2, size2, 0, size3);
            this.size = size() + size3;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public final boolean isNotEmpty() {
        return size() > 0;
    }

    public final boolean remove(T t) {
        if (t == null) {
            return false;
        }
        int find = find(t);
        Object[] objArr = this.values;
        int size2 = size();
        if (find < 0) {
            return false;
        }
        int i = size2 - 1;
        if (find < i) {
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr, find, find + 1, size2);
        }
        objArr[i] = null;
        this.size = size() - 1;
        return true;
    }

    public final void removeValueIf(Function1<? super T, Boolean> function1) {
        Object[] values2 = getValues();
        int size2 = size();
        int i = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            Object obj = values2[i2];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
            if (!function1.invoke(obj).booleanValue()) {
                if (i != i2) {
                    values2[i] = obj;
                }
                i++;
            }
        }
        for (int i3 = i; i3 < size2; i3++) {
            values2[i3] = null;
        }
        this.size = i;
    }

    private final int find(Object obj) {
        int size2 = size() - 1;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(obj);
        Object[] objArr = this.values;
        int i = 0;
        while (i <= size2) {
            int i2 = (i + size2) >>> 1;
            Object obj2 = objArr[i2];
            int identityHashCode2 = ActualJvm_jvmKt.identityHashCode(obj2);
            if (identityHashCode2 < identityHashCode) {
                i = i2 + 1;
            } else if (identityHashCode2 > identityHashCode) {
                size2 = i2 - 1;
            } else if (obj2 == obj) {
                return i2;
            } else {
                return findExactIndex(i2, obj, identityHashCode);
            }
        }
        return -(i + 1);
    }

    private final int findExactIndex(int i, Object obj, int i2) {
        Object obj2;
        Object[] objArr = this.values;
        int size2 = size();
        for (int i3 = i - 1; -1 < i3; i3--) {
            Object obj3 = objArr[i3];
            if (obj3 == obj) {
                return i3;
            }
            if (ActualJvm_jvmKt.identityHashCode(obj3) != i2) {
                break;
            }
        }
        do {
            i++;
            if (i >= size2) {
                return -(size2 + 1);
            }
            obj2 = objArr[i];
            if (obj2 == obj) {
                return i;
            }
        } while (ActualJvm_jvmKt.identityHashCode(obj2) == i2);
        return -(i + 1);
    }

    private final void checkIndexBounds(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Index " + i + ", size " + size());
        }
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        Iterable<Object> iterable = collection;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<T> iterator() {
        return new IdentityArraySet$iterator$1(this);
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, IdentityArraySet$toString$1.INSTANCE, 25, (Object) null);
    }
}
