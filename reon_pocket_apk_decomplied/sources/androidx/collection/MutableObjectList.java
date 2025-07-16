package androidx.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003678B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0019\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J#\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\u0010\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eJ\u0006\u0010\u001f\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00028\u0000H\n¢\u0006\u0002\u0010\"J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001c\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002¢\u0006\u0002\u0010#J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0002J\u0017\u0010!\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0002J\u0016\u0010$\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00028\u0000H\n¢\u0006\u0002\u0010\"J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0002J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001c\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0002¢\u0006\u0002\u0010#J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0002J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0002J\u0017\u0010$\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0002J\u0013\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014J\u0019\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aJ\u0014\u0010&\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ\u0015\u0010'\u001a\u00028\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u0004¢\u0006\u0002\u0010(J/\u0010)\u001a\u00020\u000f2!\u0010*\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\f0+H\bø\u0001\u0000J\u001a\u0010.\u001a\u00020\u000f2\b\b\u0001\u0010/\u001a\u00020\u00042\b\b\u0001\u00100\u001a\u00020\u0004J\u0014\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0019\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0002\u0010\u0016J\u0014\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0014\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J\u0014\u00101\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bJ \u00102\u001a\u00028\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u000f2\b\b\u0002\u00105\u001a\u00020\u0004R\u0012\u0010\u0006\u001a\u00020\u00048Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00069"}, d2 = {"Landroidx/collection/MutableObjectList;", "E", "Landroidx/collection/ObjectList;", "initialCapacity", "", "(I)V", "capacity", "getCapacity", "()I", "list", "Landroidx/collection/MutableObjectList$ObjectListMutableList;", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "Landroidx/collection/ScatterSet;", "", "([Ljava/lang/Object;)Z", "(I[Ljava/lang/Object;)Z", "", "", "", "Lkotlin/sequences/Sequence;", "asList", "asMutableList", "", "clear", "ensureCapacity", "minusAssign", "(Ljava/lang/Object;)V", "([Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "removeIf", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "removeRange", "start", "end", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "trim", "minCapacity", "MutableObjectListIterator", "ObjectListMutableList", "SubList", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ObjectList.kt */
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    public MutableObjectList() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableObjectList(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 16 : i);
    }

    public MutableObjectList(int i) {
        super(i, (DefaultConstructorMarker) null);
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final boolean add(E e) {
        ensureCapacity(this._size + 1);
        this.content[this._size] = e;
        this._size++;
        return true;
    }

    public final void add(int i, E e) {
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        }
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        if (i != this._size) {
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr, i + 1, i, this._size);
        }
        objArr[i] = e;
        this._size++;
    }

    public final boolean addAll(int i, E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (eArr.length == 0) {
            return false;
        } else {
            ensureCapacity(this._size + eArr.length);
            Object[] objArr = this.content;
            if (i != this._size) {
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, eArr.length + i, i, this._size);
            }
            ArraysKt.copyInto$default((Object[]) eArr, objArr, i, 0, 0, 12, (Object) null);
            this._size += eArr.length;
            return true;
        }
    }

    public final boolean addAll(int i, Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        }
        int i2 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(this._size + collection.size());
        Object[] objArr = this.content;
        if (i != this._size) {
            ArraysKt.copyInto((T[]) objArr, (T[]) objArr, collection.size() + i, i, this._size);
        }
        for (Object next : collection) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            objArr[i2 + i] = next;
            i2 = i3;
        }
        this._size += collection.size();
        return true;
    }

    public final boolean addAll(int i, ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        if (i < 0 || i > this._size) {
            throw new IndexOutOfBoundsException("Index " + i + " must be in 0.." + this._size);
        } else if (objectList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + objectList._size);
            Object[] objArr = this.content;
            if (i != this._size) {
                ArraysKt.copyInto((T[]) objArr, (T[]) objArr, objectList._size + i, i, this._size);
            }
            ArraysKt.copyInto((T[]) objectList.content, (T[]) objArr, i, 0, objectList._size);
            this._size += objectList._size;
            return true;
        }
    }

    public final boolean addAll(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        int i = this._size;
        plusAssign(objectList);
        return i != this._size;
    }

    public final boolean addAll(ScatterSet<E> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "elements");
        int i = this._size;
        plusAssign(scatterSet);
        return i != this._size;
    }

    public final boolean addAll(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        int i = this._size;
        plusAssign(eArr);
        return i != this._size;
    }

    public final boolean addAll(List<? extends E> list2) {
        Intrinsics.checkNotNullParameter(list2, "elements");
        int i = this._size;
        plusAssign(list2);
        return i != this._size;
    }

    public final boolean addAll(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        int i = this._size;
        plusAssign(iterable);
        return i != this._size;
    }

    public final boolean addAll(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        int i = this._size;
        plusAssign(sequence);
        return i != this._size;
    }

    public final void plusAssign(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        if (!objectList.isEmpty()) {
            ensureCapacity(this._size + objectList._size);
            ArraysKt.copyInto((T[]) objectList.content, (T[]) this.content, this._size, 0, objectList._size);
            this._size += objectList._size;
        }
    }

    public final void plusAssign(ScatterSet<E> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "elements");
        if (!scatterSet.isEmpty()) {
            ensureCapacity(this._size + scatterSet.getSize());
            Object[] objArr = scatterSet.elements;
            long[] jArr = scatterSet.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                add(objArr[(i << 3) + i3]);
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            return;
                        }
                    }
                    if (i != length) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void plusAssign(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        if (eArr.length != 0) {
            ensureCapacity(this._size + eArr.length);
            ArraysKt.copyInto$default((Object[]) eArr, this.content, this._size, 0, 0, 12, (Object) null);
            this._size += eArr.length;
        }
    }

    public final void plusAssign(List<? extends E> list2) {
        Intrinsics.checkNotNullParameter(list2, "elements");
        if (!list2.isEmpty()) {
            int i = this._size;
            ensureCapacity(list2.size() + i);
            Object[] objArr = this.content;
            int size = list2.size();
            for (int i2 = 0; i2 < size; i2++) {
                objArr[i2 + i] = list2.get(i2);
            }
            this._size += list2.size();
        }
    }

    public final void clear() {
        ArraysKt.fill((T[]) this.content, null, 0, this._size);
        this._size = 0;
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = mutableObjectList._size;
        }
        mutableObjectList.trim(i);
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        if (this.content.length > max) {
            Object[] copyOf = Arrays.copyOf(this.content, max);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void ensureCapacity(int i) {
        Object[] objArr = this.content;
        if (objArr.length < i) {
            Object[] copyOf = Arrays.copyOf(objArr, Math.max(i, (objArr.length * 3) / 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final void plusAssign(E e) {
        add(e);
    }

    public final void minusAssign(E e) {
        remove(e);
    }

    public final boolean remove(E e) {
        int indexOf = indexOf(e);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final void removeIf(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int i = this._size;
        Object[] objArr = this.content;
        int i2 = 0;
        IntRange until = RangesKt.until(0, this._size);
        int first = until.getFirst();
        int last = until.getLast();
        if (first <= last) {
            while (true) {
                objArr[first - i2] = objArr[first];
                if (function1.invoke(objArr[first]).booleanValue()) {
                    i2++;
                }
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        ArraysKt.fill((T[]) objArr, null, i - i2, i);
        this._size -= i2;
    }

    public final boolean removeAll(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        int i = this._size;
        for (E remove : eArr) {
            remove(remove);
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean removeAll(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        int i = this._size;
        minusAssign(objectList);
        return i != this._size;
    }

    public final boolean removeAll(ScatterSet<E> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "elements");
        int i = this._size;
        minusAssign(scatterSet);
        return i != this._size;
    }

    public final boolean removeAll(List<? extends E> list2) {
        Intrinsics.checkNotNullParameter(list2, "elements");
        int i = this._size;
        minusAssign(list2);
        return i != this._size;
    }

    public final boolean removeAll(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        int i = this._size;
        minusAssign(iterable);
        return i != this._size;
    }

    public final boolean removeAll(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        int i = this._size;
        minusAssign(sequence);
        return i != this._size;
    }

    public final void minusAssign(List<? extends E> list2) {
        Intrinsics.checkNotNullParameter(list2, "elements");
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            remove(list2.get(i));
        }
    }

    public final E removeAt(int i) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder("Index ");
            sb.append(i);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        E[] eArr = this.content;
        E e = eArr[i];
        if (i != this._size - 1) {
            ArraysKt.copyInto((T[]) eArr, (T[]) eArr, i, i + 1, this._size);
        }
        this._size--;
        eArr[this._size] = null;
        return e;
    }

    public final void removeRange(int i, int i2) {
        if (i < 0 || i > this._size || i2 < 0 || i2 > this._size) {
            throw new IndexOutOfBoundsException("Start (" + i + ") and end (" + i2 + ") must be in 0.." + this._size);
        } else if (i2 < i) {
            throw new IllegalArgumentException("Start (" + i + ") is more than end (" + i2 + ')');
        } else if (i2 != i) {
            if (i2 < this._size) {
                ArraysKt.copyInto((T[]) this.content, (T[]) this.content, i, i2, this._size);
            }
            int i3 = this._size - (i2 - i);
            ArraysKt.fill((T[]) this.content, null, i3, this._size);
            this._size = i3;
        }
    }

    public final boolean retainAll(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (ArraysKt.indexOf((T[]) eArr, objArr[i2]) < 0) {
                removeAt(i2);
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean retainAll(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (!objectList.contains(objArr[i2])) {
                removeAt(i2);
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean retainAll(Collection<? extends E> collection) {
        Intrinsics.checkNotNullParameter(collection, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (!collection.contains(objArr[i2])) {
                removeAt(i2);
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean retainAll(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (!CollectionsKt.contains(iterable, objArr[i2])) {
                removeAt(i2);
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final boolean retainAll(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        int i = this._size;
        Object[] objArr = this.content;
        for (int i2 = this._size - 1; -1 < i2; i2--) {
            if (!SequencesKt.contains(sequence, objArr[i2])) {
                removeAt(i2);
            }
        }
        if (i != this._size) {
            return true;
        }
        return false;
    }

    public final E set(int i, E e) {
        if (i < 0 || i >= this._size) {
            StringBuilder sb = new StringBuilder("set index ");
            sb.append(i);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        E[] eArr = this.content;
        E e2 = eArr[i];
        eArr[i] = e;
        return e2;
    }

    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList == null) {
            objectListMutableList = new ObjectListMutableList<>(this);
            this.list = objectListMutableList;
        }
        return objectListMutableList;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/collection/MutableObjectList$MutableObjectListIterator;", "T", "", "list", "", "index", "", "(Ljava/util/List;I)V", "prevIndex", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ObjectList.kt */
    private static final class MutableObjectListIterator<T> implements ListIterator<T>, KMutableListIterator {
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(List<T> list2, int i) {
            Intrinsics.checkNotNullParameter(list2, "list");
            this.list = list2;
            this.prevIndex = i - 1;
        }

        public boolean hasNext() {
            return this.prevIndex < this.list.size() - 1;
        }

        public T next() {
            List<T> list2 = this.list;
            int i = this.prevIndex + 1;
            this.prevIndex = i;
            return list2.get(i);
        }

        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        public boolean hasPrevious() {
            return this.prevIndex >= 0;
        }

        public int nextIndex() {
            return this.prevIndex + 1;
        }

        public T previous() {
            List<T> list2 = this.list;
            int i = this.prevIndex;
            this.prevIndex = i - 1;
            return list2.get(i);
        }

        public int previousIndex() {
            return this.prevIndex;
        }

        public void add(T t) {
            List<T> list2 = this.list;
            int i = this.prevIndex + 1;
            this.prevIndex = i;
            list2.add(i, t);
        }

        public void set(T t) {
            this.list.set(this.prevIndex, t);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0002J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001e\u0010%\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006*"}, d2 = {"Landroidx/collection/MutableObjectList$ObjectListMutableList;", "T", "", "objectList", "Landroidx/collection/MutableObjectList;", "(Landroidx/collection/MutableObjectList;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ObjectList.kt */
    private static final class ObjectListMutableList<T> implements List<T>, KMutableList {
        private final MutableObjectList<T> objectList;

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray(this, tArr);
        }

        public ObjectListMutableList(MutableObjectList<T> mutableObjectList) {
            Intrinsics.checkNotNullParameter(mutableObjectList, "objectList");
            this.objectList = mutableObjectList;
        }

        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        public boolean contains(Object obj) {
            return this.objectList.contains(obj);
        }

        public boolean containsAll(Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.objectList.containsAll(collection);
        }

        public T get(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.get(i);
        }

        public int indexOf(Object obj) {
            return this.objectList.indexOf(obj);
        }

        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        public Iterator<T> iterator() {
            return new MutableObjectListIterator<>(this, 0);
        }

        public int lastIndexOf(Object obj) {
            return this.objectList.lastIndexOf(obj);
        }

        public boolean add(T t) {
            return this.objectList.add(t);
        }

        public void add(int i, T t) {
            this.objectList.add(i, t);
        }

        public boolean addAll(int i, Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.objectList.addAll(i, collection);
        }

        public boolean addAll(Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.objectList.addAll(collection);
        }

        public void clear() {
            this.objectList.clear();
        }

        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator<>(this, 0);
        }

        public ListIterator<T> listIterator(int i) {
            return new MutableObjectListIterator<>(this, i);
        }

        public boolean remove(Object obj) {
            return this.objectList.remove(obj);
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.objectList.removeAll(collection);
        }

        public T removeAt(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.removeAt(i);
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            return this.objectList.retainAll(collection);
        }

        public T set(int i, T t) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.set(i, t);
        }

        public List<T> subList(int i, int i2) {
            List list = this;
            ObjectListKt.checkSubIndex(list, i, i2);
            return new SubList<>(list, i, i2);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\fH\u0016J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0002J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/collection/MutableObjectList$SubList;", "T", "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ObjectList.kt */
    private static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        private final List<T> list;
        private final int start;

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public <T> T[] toArray(T[] tArr) {
            Intrinsics.checkNotNullParameter(tArr, "array");
            return CollectionToArray.toArray(this, tArr);
        }

        public SubList(List<T> list2, int i, int i2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            this.list = list2;
            this.start = i;
            this.end = i2;
        }

        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public int getSize() {
            return this.end - this.start;
        }

        public boolean contains(Object obj) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (Intrinsics.areEqual((Object) this.list.get(i2), obj)) {
                    return true;
                }
            }
            return false;
        }

        public boolean containsAll(Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public T get(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.list.get(i + this.start);
        }

        public int indexOf(Object obj) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (Intrinsics.areEqual((Object) this.list.get(i2), obj)) {
                    return i2 - this.start;
                }
            }
            return -1;
        }

        public boolean isEmpty() {
            return this.end == this.start;
        }

        public Iterator<T> iterator() {
            return new MutableObjectListIterator<>(this, 0);
        }

        public int lastIndexOf(Object obj) {
            int i = this.end - 1;
            int i2 = this.start;
            if (i2 > i) {
                return -1;
            }
            while (!Intrinsics.areEqual((Object) this.list.get(i), obj)) {
                if (i == i2) {
                    return -1;
                }
                i--;
            }
            return i - this.start;
        }

        public boolean add(T t) {
            List<T> list2 = this.list;
            int i = this.end;
            this.end = i + 1;
            list2.add(i, t);
            return true;
        }

        public void add(int i, T t) {
            this.list.add(i + this.start, t);
            this.end++;
        }

        public boolean addAll(int i, Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            this.list.addAll(i + this.start, collection);
            this.end += collection.size();
            return collection.size() > 0;
        }

        public boolean addAll(Collection<? extends T> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            this.list.addAll(this.end, collection);
            this.end += collection.size();
            return collection.size() > 0;
        }

        public void clear() {
            int i = this.end - 1;
            int i2 = this.start;
            if (i2 <= i) {
                while (true) {
                    this.list.remove(i);
                    if (i == i2) {
                        break;
                    }
                    i--;
                }
            }
            this.end = this.start;
        }

        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator<>(this, 0);
        }

        public ListIterator<T> listIterator(int i) {
            return new MutableObjectListIterator<>(this, i);
        }

        public boolean remove(Object obj) {
            int i = this.end;
            for (int i2 = this.start; i2 < i; i2++) {
                if (Intrinsics.areEqual((Object) this.list.get(i2), obj)) {
                    this.list.remove(i2);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            int i = this.end;
            for (Object remove : collection) {
                remove(remove);
            }
            return i != this.end;
        }

        public T removeAt(int i) {
            ObjectListKt.checkIndex(this, i);
            this.end--;
            return this.list.remove(i + this.start);
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            Intrinsics.checkNotNullParameter(collection, "elements");
            int i = this.end;
            int i2 = i - 1;
            int i3 = this.start;
            if (i3 <= i2) {
                while (true) {
                    if (!collection.contains(this.list.get(i2))) {
                        this.list.remove(i2);
                        this.end--;
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2--;
                }
            }
            return i != this.end;
        }

        public T set(int i, T t) {
            ObjectListKt.checkIndex(this, i);
            return this.list.set(i + this.start, t);
        }

        public List<T> subList(int i, int i2) {
            List list2 = this;
            ObjectListKt.checkSubIndex(list2, i, i2);
            return new SubList<>(list2, i, i2);
        }
    }

    public final void plusAssign(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        for (Object add : iterable) {
            add(add);
        }
    }

    public final void plusAssign(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        for (Object add : sequence) {
            add(add);
        }
    }

    public final void minusAssign(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        for (E remove : eArr) {
            remove(remove);
        }
    }

    public final void minusAssign(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            remove(objArr[i2]);
        }
    }

    public final void minusAssign(ScatterSet<E> scatterSet) {
        Intrinsics.checkNotNullParameter(scatterSet, "elements");
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            remove(objArr[(i << 3) + i3]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        return;
                    }
                }
                if (i != length) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public final void minusAssign(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        for (Object remove : iterable) {
            remove(remove);
        }
    }

    public final void minusAssign(Sequence<? extends E> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "elements");
        for (Object remove : sequence) {
            remove(remove);
        }
    }
}
