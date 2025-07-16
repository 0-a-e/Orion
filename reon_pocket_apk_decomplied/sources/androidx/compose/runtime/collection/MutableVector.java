package androidx.compose.runtime.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0003stuB\u001f\b\u0001\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u001b\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\bJ\u0019\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010$J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u001c\u0010\"\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0017\u0010\"\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&H\bJ(\u0010'\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J\u0006\u0010+\u001a\u00020\u001fJ\u0016\u0010,\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001eJ\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010-\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0014\u0010.\u001a\u00020\u001c2\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u000e\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u0007J\u000b\u00102\u001a\u00028\u0000¢\u0006\u0002\u00103J-\u00102\u001a\u00028\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J\u0010\u00105\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0002\u00103J/\u00105\u001a\u0004\u0018\u00018\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104JP\u00106\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72'\u00109\u001a#\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70:H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010>Je\u0010?\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72<\u00109\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70@H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010AJP\u0010B\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72'\u00109\u001a#\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002H70:H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010>Je\u0010C\u001a\u0002H7\"\u0004\b\u0001\u001072\u0006\u00108\u001a\u0002H72<\u00109\u001a8\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u0011H7¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u0002H70@H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010AJ(\u0010D\u001a\u00020\u001f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J.\u0010F\u001a\u00020\u001f2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0:H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010G\u001a\u00020\u001f2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J.\u0010H\u001a\u00020\u001f2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0:H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010I\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007H\n¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010LJ(\u0010M\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J(\u0010N\u001a\u00020\u00072\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010O\u001a\u00020\u001cJ\u0006\u0010P\u001a\u00020\u001cJ\u000b\u0010Q\u001a\u00028\u0000¢\u0006\u0002\u00103J-\u0010Q\u001a\u00028\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J\u0013\u0010R\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010LJ\u0010\u0010S\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0002\u00103J/\u0010S\u001a\u0004\u0018\u00018\u00002\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00104J;\u0010T\u001a\b\u0012\u0004\u0012\u0002H70\u0005\"\u0006\b\u0001\u00107\u0018\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010VJP\u0010W\u001a\b\u0012\u0004\u0012\u0002H70\u0005\"\u0006\b\u0001\u00107\u0018\u00012'\u0010U\u001a#\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H70:H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010XJM\u0010Y\u001a\b\u0012\u0004\u0012\u0002H70\u0000\"\u0006\b\u0001\u00107\u0018\u00012)\u0010U\u001a%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b( \u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H70:H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J8\u0010Z\u001a\b\u0012\u0004\u0012\u0002H70\u0000\"\u0006\b\u0001\u00107\u0018\u00012\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u0001H70)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0016\u0010[\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00028\u0000H\n¢\u0006\u0002\u0010\\J\u0016\u0010]\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00028\u0000H\n¢\u0006\u0002\u0010\\J\u0013\u0010^\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J\u0014\u0010_\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000&J\u0013\u0010`\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0002\u0010JJ\u001d\u0010a\u001a\u00020\u001f2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\bJ\u0016\u0010b\u001a\u00020\u001f2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007J\u0014\u0010e\u001a\u00020\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000%J(\u0010f\u001a\u00020\u001c2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001c0)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u001e\u0010g\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010hJ\u0010\u0010i\u001a\u00020\u001f2\u0006\u0010j\u001a\u00020\u0007H\u0001J\u001e\u0010k\u001a\u00020\u001f2\u0016\u0010l\u001a\u0012\u0012\u0004\u0012\u00028\u00000mj\b\u0012\u0004\u0012\u00028\u0000`nJ(\u0010o\u001a\u00020\u00072\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070)H\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010q\u001a\u00020rH\u0001R.\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00058\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010\u000f\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0012\u0010\u0010\u001a\u00020\u00118Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u00078Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016¨\u0006v"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector;", "T", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "content", "", "size", "", "([Ljava/lang/Object;I)V", "getContent$annotations", "()V", "getContent", "()[Ljava/lang/Object;", "setContent", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "list", "", "<set-?>", "getSize", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "([Ljava/lang/Object;)Z", "", "", "any", "predicate", "Lkotlin/Function1;", "asMutableList", "clear", "contains", "containsAll", "contentEquals", "other", "ensureCapacity", "capacity", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "last", "lastIndexOf", "lastOrNull", "map", "transform", "(Lkotlin/jvm/functions/Function1;)[Ljava/lang/Object;", "mapIndexed", "(Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "mapIndexedNotNull", "mapNotNull", "minusAssign", "(Ljava/lang/Object;)V", "plusAssign", "remove", "removeAll", "removeAt", "removeIf", "removeRange", "start", "end", "retainAll", "reversedAny", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setSize", "newSize", "sortWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sumBy", "selector", "throwNoSuchElementException", "", "MutableVectorList", "SubList", "VectorListIterator", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MutableVector.kt */
public final class MutableVector<T> implements RandomAccess {
    public static final int $stable = 8;
    private T[] content;
    private List<T> list;
    private int size;

    public static /* synthetic */ void getContent$annotations() {
    }

    public MutableVector(T[] tArr, int i) {
        this.content = tArr;
        this.size = i;
    }

    public final T[] getContent() {
        return this.content;
    }

    public final void setContent(T[] tArr) {
        this.content = tArr;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getLastIndex() {
        return getSize() - 1;
    }

    public final IntRange getIndices() {
        return new IntRange(0, getSize() - 1);
    }

    public final boolean add(T t) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i = this.size;
        tArr[i] = t;
        this.size = i + 1;
        return true;
    }

    public final void add(int i, T t) {
        ensureCapacity(this.size + 1);
        T[] tArr = this.content;
        int i2 = this.size;
        if (i != i2) {
            ArraysKt.copyInto(tArr, tArr, i + 1, i, i2);
        }
        tArr[i] = t;
        this.size++;
    }

    public final boolean addAll(int i, List<? extends T> list2) {
        if (list2.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + list2.size());
        T[] tArr = this.content;
        if (i != this.size) {
            ArraysKt.copyInto(tArr, tArr, list2.size() + i, i, this.size);
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            tArr[i + i2] = list2.get(i2);
        }
        this.size += list2.size();
        return true;
    }

    public final boolean addAll(int i, MutableVector<T> mutableVector) {
        if (mutableVector.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + mutableVector.size);
        T[] tArr = this.content;
        int i2 = this.size;
        if (i != i2) {
            ArraysKt.copyInto(tArr, tArr, mutableVector.size + i, i, i2);
        }
        ArraysKt.copyInto(mutableVector.content, tArr, i, 0, mutableVector.size);
        this.size += mutableVector.size;
        return true;
    }

    public final boolean addAll(List<? extends T> list2) {
        return addAll(getSize(), list2);
    }

    public final boolean addAll(MutableVector<T> mutableVector) {
        return addAll(getSize(), mutableVector);
    }

    public final boolean addAll(T[] tArr) {
        if (tArr.length == 0) {
            return false;
        }
        ensureCapacity(this.size + tArr.length);
        ArraysKt.copyInto$default((Object[]) tArr, (Object[]) this.content, this.size, 0, 0, 12, (Object) null);
        this.size += tArr.length;
        return true;
    }

    public final boolean addAll(int i, Collection<? extends T> collection) {
        int i2 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(this.size + collection.size());
        T[] tArr = this.content;
        if (i != this.size) {
            ArraysKt.copyInto(tArr, tArr, collection.size() + i, i, this.size);
        }
        for (T next : collection) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            tArr[i2 + i] = next;
            i2 = i3;
        }
        this.size += collection.size();
        return true;
    }

    public final boolean addAll(Collection<? extends T> collection) {
        return addAll(this.size, collection);
    }

    public final boolean any(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        if (size2 > 0) {
            Object[] content2 = getContent();
            int i = 0;
            while (!function1.invoke(content2[i]).booleanValue()) {
                i++;
                if (i >= size2) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean reversedAny(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        if (size2 <= 0) {
            return false;
        }
        int i = size2 - 1;
        Object[] content2 = getContent();
        while (!function1.invoke(content2[i]).booleanValue()) {
            i--;
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    public final List<T> asMutableList() {
        List<T> list2 = this.list;
        if (list2 != null) {
            return list2;
        }
        List<T> mutableVectorList = new MutableVectorList<>(this);
        this.list = mutableVectorList;
        return mutableVectorList;
    }

    public final void clear() {
        T[] tArr = this.content;
        int size2 = getSize();
        while (true) {
            size2--;
            if (-1 < size2) {
                tArr[size2] = null;
            } else {
                this.size = 0;
                return;
            }
        }
    }

    public final boolean containsAll(List<? extends T> list2) {
        int size2 = list2.size();
        for (int i = 0; i < size2; i++) {
            if (!contains(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final boolean containsAll(Collection<? extends T> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean contentEquals(MutableVector<T> mutableVector) {
        if (mutableVector.size != this.size) {
            return false;
        }
        int size2 = getSize() - 1;
        if (size2 >= 0) {
            int i = 0;
            while (Intrinsics.areEqual(mutableVector.getContent()[i], getContent()[i])) {
                if (i != size2) {
                    i++;
                }
            }
            return false;
        }
        return true;
    }

    public final void ensureCapacity(int i) {
        T[] tArr = this.content;
        if (tArr.length < i) {
            T[] copyOf = Arrays.copyOf(tArr, Math.max(i, tArr.length * 2));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final T first() {
        if (!isEmpty()) {
            return getContent()[0];
        }
        throw new NoSuchElementException("MutableVector is empty.");
    }

    public final T first(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        if (size2 > 0) {
            T[] content2 = getContent();
            int i = 0;
            do {
                T t = content2[i];
                if (function1.invoke(t).booleanValue()) {
                    return t;
                }
                i++;
            } while (i < size2);
        }
        throwNoSuchElementException();
        throw new KotlinNothingValueException();
    }

    public final T firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return getContent()[0];
    }

    public final T firstOrNull(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        if (size2 <= 0) {
            return null;
        }
        T[] content2 = getContent();
        int i = 0;
        do {
            T t = content2[i];
            if (function1.invoke(t).booleanValue()) {
                return t;
            }
            i++;
        } while (i < size2);
        return null;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R fold(R r5, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> r6) {
        /*
            r4 = this;
            int r0 = r4.getSize()
            if (r0 <= 0) goto L_0x0015
            java.lang.Object[] r1 = r4.getContent()
            r2 = 0
        L_0x000b:
            r3 = r1[r2]
            java.lang.Object r5 = r6.invoke(r5, r3)
            int r2 = r2 + 1
            if (r2 < r0) goto L_0x000b
        L_0x0015:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.fold(java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super T, ? extends R>, kotlin.jvm.functions.Function3] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldIndexed(R r6, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super T, ? extends R> r7) {
        /*
            r5 = this;
            int r0 = r5.getSize()
            if (r0 <= 0) goto L_0x0019
            java.lang.Object[] r1 = r5.getContent()
            r2 = 0
        L_0x000b:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r4 = r1[r2]
            java.lang.Object r6 = r7.invoke(r3, r6, r4)
            int r2 = r2 + 1
            if (r2 < r0) goto L_0x000b
        L_0x0019:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.foldIndexed(java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super T, ? super R, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRight(R r4, kotlin.jvm.functions.Function2<? super T, ? super R, ? extends R> r5) {
        /*
            r3 = this;
            int r0 = r3.getSize()
            if (r0 <= 0) goto L_0x0016
            int r0 = r0 + -1
            java.lang.Object[] r1 = r3.getContent()
        L_0x000c:
            r2 = r1[r0]
            java.lang.Object r4 = r5.invoke(r2, r4)
            int r0 = r0 + -1
            if (r0 >= 0) goto L_0x000c
        L_0x0016:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.foldRight(java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super T, ? super R, ? extends R>, kotlin.jvm.functions.Function3] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRightIndexed(R r5, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super T, ? super R, ? extends R> r6) {
        /*
            r4 = this;
            int r0 = r4.getSize()
            if (r0 <= 0) goto L_0x001a
            int r0 = r0 + -1
            java.lang.Object[] r1 = r4.getContent()
        L_0x000c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            r3 = r1[r0]
            java.lang.Object r5 = r6.invoke(r2, r3, r5)
            int r0 = r0 + -1
            if (r0 >= 0) goto L_0x000c
        L_0x001a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.MutableVector.foldRightIndexed(java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public final void forEach(Function1<? super T, Unit> function1) {
        int size2 = getSize();
        if (size2 > 0) {
            Object[] content2 = getContent();
            int i = 0;
            do {
                function1.invoke(content2[i]);
                i++;
            } while (i < size2);
        }
    }

    public final void forEachIndexed(Function2<? super Integer, ? super T, Unit> function2) {
        int size2 = getSize();
        if (size2 > 0) {
            Object[] content2 = getContent();
            int i = 0;
            do {
                function2.invoke(Integer.valueOf(i), content2[i]);
                i++;
            } while (i < size2);
        }
    }

    public final void forEachReversed(Function1<? super T, Unit> function1) {
        int size2 = getSize();
        if (size2 > 0) {
            int i = size2 - 1;
            Object[] content2 = getContent();
            do {
                function1.invoke(content2[i]);
                i--;
            } while (i >= 0);
        }
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super T, Unit> function2) {
        if (getSize() > 0) {
            int size2 = getSize() - 1;
            Object[] content2 = getContent();
            do {
                function2.invoke(Integer.valueOf(size2), content2[size2]);
                size2--;
            } while (size2 >= 0);
        }
    }

    public final T get(int i) {
        return getContent()[i];
    }

    public final int indexOf(T t) {
        int i = this.size;
        if (i <= 0) {
            return -1;
        }
        T[] tArr = this.content;
        int i2 = 0;
        while (!Intrinsics.areEqual((Object) t, (Object) tArr[i2])) {
            i2++;
            if (i2 >= i) {
                return -1;
            }
        }
        return i2;
    }

    public final int indexOfFirst(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        if (size2 <= 0) {
            return -1;
        }
        Object[] content2 = getContent();
        int i = 0;
        while (!function1.invoke(content2[i]).booleanValue()) {
            i++;
            if (i >= size2) {
                return -1;
            }
        }
        return i;
    }

    public final int indexOfLast(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        if (size2 <= 0) {
            return -1;
        }
        int i = size2 - 1;
        Object[] content2 = getContent();
        while (!function1.invoke(content2[i]).booleanValue()) {
            i--;
            if (i < 0) {
                return -1;
            }
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isNotEmpty() {
        return this.size != 0;
    }

    public final T last() {
        if (!isEmpty()) {
            return getContent()[getSize() - 1];
        }
        throw new NoSuchElementException("MutableVector is empty.");
    }

    public final T last(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        if (size2 > 0) {
            int i = size2 - 1;
            T[] content2 = getContent();
            do {
                T t = content2[i];
                if (function1.invoke(t).booleanValue()) {
                    return t;
                }
                i--;
            } while (i >= 0);
        }
        throwNoSuchElementException();
        throw new KotlinNothingValueException();
    }

    public final int lastIndexOf(T t) {
        int i = this.size;
        if (i <= 0) {
            return -1;
        }
        int i2 = i - 1;
        T[] tArr = this.content;
        while (!Intrinsics.areEqual((Object) t, (Object) tArr[i2])) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
        }
        return i2;
    }

    public final T lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return getContent()[getSize() - 1];
    }

    public final T lastOrNull(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        if (size2 <= 0) {
            return null;
        }
        int i = size2 - 1;
        T[] content2 = getContent();
        do {
            T t = content2[i];
            if (function1.invoke(t).booleanValue()) {
                return t;
            }
            i--;
        } while (i >= 0);
        return null;
    }

    public final /* synthetic */ <R> R[] map(Function1<? super T, ? extends R> function1) {
        int size2 = getSize();
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] rArr = new Object[size2];
        for (int i = 0; i < size2; i++) {
            Object obj = getContent()[i];
            Object obj2 = obj;
            rArr[i] = function1.invoke(obj);
        }
        return rArr;
    }

    public final /* synthetic */ <R> R[] mapIndexed(Function2<? super Integer, ? super T, ? extends R> function2) {
        int size2 = getSize();
        Intrinsics.reifiedOperationMarker(0, "R");
        R[] rArr = new Object[size2];
        for (int i = 0; i < size2; i++) {
            Integer valueOf = Integer.valueOf(i);
            Object obj = getContent()[i];
            Object obj2 = obj;
            rArr[i] = function2.invoke(valueOf, obj);
        }
        return rArr;
    }

    public final /* synthetic */ <R> MutableVector<R> mapIndexedNotNull(Function2<? super Integer, ? super T, ? extends R> function2) {
        int size2 = getSize();
        int i = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] objArr = new Object[size2];
        if (size2 > 0) {
            Object[] content2 = getContent();
            int i2 = 0;
            do {
                Object invoke = function2.invoke(Integer.valueOf(i), content2[i]);
                if (invoke != null) {
                    objArr[i2] = invoke;
                    i2++;
                }
                i++;
            } while (i < size2);
            i = i2;
        }
        return new MutableVector<>(objArr, i);
    }

    public final /* synthetic */ <R> MutableVector<R> mapNotNull(Function1<? super T, ? extends R> function1) {
        int size2 = getSize();
        int i = 0;
        Intrinsics.reifiedOperationMarker(0, "R?");
        Object[] objArr = new Object[size2];
        if (size2 > 0) {
            Object[] content2 = getContent();
            int i2 = 0;
            do {
                Object invoke = function1.invoke(content2[i]);
                if (invoke != null) {
                    objArr[i2] = invoke;
                    i2++;
                }
                i++;
            } while (i < size2);
            i = i2;
        }
        return new MutableVector<>(objArr, i);
    }

    public final void plusAssign(T t) {
        add(t);
    }

    public final void minusAssign(T t) {
        remove(t);
    }

    public final boolean remove(T t) {
        int indexOf = indexOf(t);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(List<? extends T> list2) {
        int i = this.size;
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            remove(list2.get(i2));
        }
        if (i != this.size) {
            return true;
        }
        return false;
    }

    public final boolean removeAll(MutableVector<T> mutableVector) {
        int i = this.size;
        int size2 = mutableVector.getSize() - 1;
        if (size2 >= 0) {
            int i2 = 0;
            while (true) {
                remove(mutableVector.getContent()[i2]);
                if (i2 == size2) {
                    break;
                }
                i2++;
            }
        }
        if (i != this.size) {
            return true;
        }
        return false;
    }

    public final boolean removeAll(Collection<? extends T> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int i = this.size;
        for (Object remove : collection) {
            remove(remove);
        }
        if (i != this.size) {
            return true;
        }
        return false;
    }

    public final T removeAt(int i) {
        T[] tArr = this.content;
        T t = tArr[i];
        if (i != getSize() - 1) {
            ArraysKt.copyInto(tArr, tArr, i, i + 1, this.size);
        }
        int i2 = this.size - 1;
        this.size = i2;
        tArr[i2] = null;
        return t;
    }

    public final void removeRange(int i, int i2) {
        if (i2 > i) {
            int i3 = this.size;
            if (i2 < i3) {
                T[] tArr = this.content;
                ArraysKt.copyInto(tArr, tArr, i, i2, i3);
            }
            int i4 = this.size - (i2 - i);
            int size2 = getSize() - 1;
            if (i4 <= size2) {
                int i5 = i4;
                while (true) {
                    this.content[i5] = null;
                    if (i5 == size2) {
                        break;
                    }
                    i5++;
                }
            }
            this.size = i4;
        }
    }

    public final void setSize(int i) {
        this.size = i;
    }

    public final void removeIf(Function1<? super T, Boolean> function1) {
        int size2 = getSize();
        int i = 0;
        for (int i2 = 0; i2 < size2; i2++) {
            if (function1.invoke(getContent()[i2]).booleanValue()) {
                i++;
            } else if (i > 0) {
                getContent()[i2 - i] = getContent()[i2];
            }
        }
        int i3 = size2 - i;
        ArraysKt.fill((T[]) getContent(), null, i3, size2);
        setSize(i3);
    }

    public final boolean retainAll(Collection<? extends T> collection) {
        int i = this.size;
        for (int size2 = getSize() - 1; -1 < size2; size2--) {
            if (!collection.contains(getContent()[size2])) {
                removeAt(size2);
            }
        }
        if (i != this.size) {
            return true;
        }
        return false;
    }

    public final T set(int i, T t) {
        T[] tArr = this.content;
        T t2 = tArr[i];
        tArr[i] = t;
        return t2;
    }

    public final void sortWith(Comparator<T> comparator) {
        ArraysKt.sortWith(this.content, comparator, 0, this.size);
    }

    public final int sumBy(Function1<? super T, Integer> function1) {
        int size2 = getSize();
        int i = 0;
        if (size2 > 0) {
            Object[] content2 = getContent();
            int i2 = 0;
            do {
                i += function1.invoke(content2[i2]).intValue();
                i2++;
            } while (i2 < size2);
        }
        return i;
    }

    public final Void throwNoSuchElementException() {
        throw new NoSuchElementException("MutableVector contains no element matching the predicate.");
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bJ\t\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u000f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\r\u0010\u0012\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0015\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$VectorListIterator;", "T", "", "list", "", "index", "", "(Ljava/util/List;I)V", "add", "", "element", "(Ljava/lang/Object;)V", "hasNext", "", "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MutableVector.kt */
    private static final class VectorListIterator<T> implements ListIterator<T>, KMutableListIterator {
        private int index;
        private final List<T> list;

        public VectorListIterator(List<T> list2, int i) {
            this.list = list2;
            this.index = i;
        }

        public boolean hasNext() {
            return this.index < this.list.size();
        }

        public T next() {
            List<T> list2 = this.list;
            int i = this.index;
            this.index = i + 1;
            return list2.get(i);
        }

        public void remove() {
            int i = this.index - 1;
            this.index = i;
            this.list.remove(i);
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public int nextIndex() {
            return this.index;
        }

        public T previous() {
            int i = this.index - 1;
            this.index = i;
            return this.list.get(i);
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void add(T t) {
            this.list.add(this.index, t);
            this.index++;
        }

        public void set(T t) {
            this.list.set(this.index, t);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\rJ\u0016\u0010\u0016\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0016\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001dH\u0002J\u0015\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aJ\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0015\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\rJ\u0016\u0010\"\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u0013H\u0016J\u001e\u0010%\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$MutableVectorList;", "T", "", "vector", "Landroidx/compose/runtime/collection/MutableVector;", "(Landroidx/compose/runtime/collection/MutableVector;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MutableVector.kt */
    private static final class MutableVectorList<T> implements List<T>, KMutableList {
        private final MutableVector<T> vector;

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public <T> T[] toArray(T[] tArr) {
            return CollectionToArray.toArray(this, tArr);
        }

        public MutableVectorList(MutableVector<T> mutableVector) {
            this.vector = mutableVector;
        }

        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        public final /* bridge */ int size() {
            return getSize();
        }

        public int getSize() {
            return this.vector.getSize();
        }

        public boolean contains(Object obj) {
            return this.vector.contains(obj);
        }

        public boolean containsAll(Collection<? extends Object> collection) {
            return this.vector.containsAll(collection);
        }

        public T get(int i) {
            MutableVectorKt.checkIndex(this, i);
            return this.vector.getContent()[i];
        }

        public int indexOf(Object obj) {
            return this.vector.indexOf(obj);
        }

        public boolean isEmpty() {
            return this.vector.isEmpty();
        }

        public Iterator<T> iterator() {
            return new VectorListIterator<>(this, 0);
        }

        public int lastIndexOf(Object obj) {
            return this.vector.lastIndexOf(obj);
        }

        public boolean add(T t) {
            return this.vector.add(t);
        }

        public void add(int i, T t) {
            this.vector.add(i, t);
        }

        public boolean addAll(int i, Collection<? extends T> collection) {
            return this.vector.addAll(i, collection);
        }

        public boolean addAll(Collection<? extends T> collection) {
            return this.vector.addAll(collection);
        }

        public void clear() {
            this.vector.clear();
        }

        public ListIterator<T> listIterator() {
            return new VectorListIterator<>(this, 0);
        }

        public ListIterator<T> listIterator(int i) {
            return new VectorListIterator<>(this, i);
        }

        public boolean remove(Object obj) {
            return this.vector.remove(obj);
        }

        public boolean removeAll(Collection<? extends Object> collection) {
            return this.vector.removeAll(collection);
        }

        public T removeAt(int i) {
            MutableVectorKt.checkIndex(this, i);
            return this.vector.removeAt(i);
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            return this.vector.retainAll(collection);
        }

        public T set(int i, T t) {
            MutableVectorKt.checkIndex(this, i);
            return this.vector.set(i, t);
        }

        public List<T> subList(int i, int i2) {
            List list = this;
            MutableVectorKt.checkSubIndex(list, i, i2);
            return new SubList<>(list, i, i2);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\t\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0016\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\fH\u0016J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001eH\u0002J\u0015\u0010\u001f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001bJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!H\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00010!2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0015\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000eJ\u0016\u0010#\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u0015\u0010$\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010%\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014H\u0016J\u001e\u0010&\u001a\u00028\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Landroidx/compose/runtime/collection/MutableVector$SubList;", "T", "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MutableVector.kt */
    private static final class SubList<T> implements List<T>, KMutableList {
        private int end;
        private final List<T> list;
        private final int start;

        public Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        public <T> T[] toArray(T[] tArr) {
            return CollectionToArray.toArray(this, tArr);
        }

        public SubList(List<T> list2, int i, int i2) {
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
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public T get(int i) {
            MutableVectorKt.checkIndex(this, i);
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
            return new VectorListIterator<>(this, 0);
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
            this.list.addAll(i + this.start, collection);
            this.end += collection.size();
            return collection.size() > 0;
        }

        public boolean addAll(Collection<? extends T> collection) {
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
            return new VectorListIterator<>(this, 0);
        }

        public ListIterator<T> listIterator(int i) {
            return new VectorListIterator<>(this, i);
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
            int i = this.end;
            for (Object remove : collection) {
                remove(remove);
            }
            return i != this.end;
        }

        public T removeAt(int i) {
            MutableVectorKt.checkIndex(this, i);
            this.end--;
            return this.list.remove(i + this.start);
        }

        public boolean retainAll(Collection<? extends Object> collection) {
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
            MutableVectorKt.checkIndex(this, i);
            return this.list.set(i + this.start, t);
        }

        public List<T> subList(int i, int i2) {
            List list2 = this;
            MutableVectorKt.checkSubIndex(list2, i, i2);
            return new SubList<>(list2, i, i2);
        }
    }

    public final boolean contains(T t) {
        int size2 = getSize() - 1;
        if (size2 >= 0) {
            int i = 0;
            while (!Intrinsics.areEqual(getContent()[i], (Object) t)) {
                if (i != size2) {
                    i++;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean containsAll(MutableVector<T> mutableVector) {
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (contains(mutableVector.getContent()[first])) {
                if (first != last) {
                    first++;
                }
            }
            return false;
        }
        return true;
    }
}
