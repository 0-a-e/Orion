package androidx.collection;

import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J:\u0010\u0016\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH&J\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u0019\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0002\u0010#J\u0014\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000$J\u0014\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eJ\u0006\u0010%\u001a\u00020\u0004J:\u0010%\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0015\u0010&\u001a\u00028\u00002\b\b\u0001\u0010'\u001a\u00020\u0004¢\u0006\u0002\u0010(J>\u0010)\u001a\u00028\u00002\b\b\u0001\u0010'\u001a\u00020\u00042!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0004\u0012\u00028\u00000\u0019H\bø\u0001\u0000¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0002H\u0002J\u000b\u0010.\u001a\u00028\u0000¢\u0006\u0002\u0010/J?\u0010.\u001a\u00028\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0010\u00101\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0002\u0010/JA\u00101\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100Jb\u00102\u001a\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001a\u0002H326\u00105\u001a2\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(7\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H306H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00108Jw\u00109\u001a\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001a\u0002H32K\u00105\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(7\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H30:H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010;Jb\u0010<\u001a\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001a\u0002H326\u00105\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002H306H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00108Jw\u0010=\u001a\u0002H3\"\u0004\b\u0001\u001032\u0006\u00104\u001a\u0002H32K\u00105\u001aG\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(7\u0012\u0004\u0012\u0002H30:H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010;J:\u0010>\u001a\u00020?2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020?0\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010A\u001a\u00020?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020?06H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010B\u001a\u00020?2!\u0010@\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020?0\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u0010C\u001a\u00020?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b('\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020?06H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0018\u0010D\u001a\u00028\u00002\b\b\u0001\u0010'\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010(J\b\u0010E\u001a\u00020\u0004H\u0016J\u0013\u0010F\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010GJ:\u0010H\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010I\u001a\u00020\u00042!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010J\u001a\u00020\u0017J\u0006\u0010K\u001a\u00020\u0017JR\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020O2\b\b\u0002\u0010P\u001a\u00020O2\b\b\u0002\u0010Q\u001a\u00020O2\b\b\u0002\u0010R\u001a\u00020\u00042\b\b\u0002\u0010S\u001a\u00020O2\u0016\b\u0002\u0010T\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020O\u0018\u00010\u0019H\u0007J\u000b\u0010U\u001a\u00028\u0000¢\u0006\u0002\u0010/J?\u0010U\u001a\u00028\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0013\u0010V\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010GJ\u0010\u0010W\u001a\u0004\u0018\u00018\u0000H\b¢\u0006\u0002\u0010/JA\u0010W\u001a\u0004\u0018\u00018\u00002!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u00100J\u0006\u0010X\u001a\u00020\u0017J:\u0010Y\u001a\u00020\u00172!\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00170\u0019H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010Z\u001a\u00020MH\u0016R\u0018\u0010\u0006\u001a\u00020\u00048\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0000@\u0000X\u000e¢\u0006\n\n\u0002\u0010\f\u0012\u0004\b\u000b\u0010\bR\u0012\u0010\r\u001a\u00020\u000e8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u00048Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013\u0001\u0001[\u0002\u0007\n\u0005\b20\u0001¨\u0006\\"}, d2 = {"Landroidx/collection/ObjectList;", "E", "", "initialCapacity", "", "(I)V", "_size", "get_size$annotations", "()V", "content", "", "getContent$annotations", "[Ljava/lang/Object;", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "size", "getSize", "any", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "asList", "", "contains", "(Ljava/lang/Object;)Z", "containsAll", "elements", "([Ljava/lang/Object;)Z", "", "count", "elementAt", "index", "(I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "equals", "other", "first", "()Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstOrNull", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastIndexOf", "lastOrNull", "none", "reversedAny", "toString", "Landroidx/collection/MutableObjectList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ObjectList.kt */
public abstract class ObjectList<E> {
    public int _size;
    public Object[] content;

    public /* synthetic */ ObjectList(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public abstract List<E> asList();

    public final String joinToString() {
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null);
    }

    public final String joinToString(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 60, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, (Function1) null, 56, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, (CharSequence) null, (Function1) null, 48, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, charSequence4, (Function1) null, 32, (Object) null);
    }

    private ObjectList(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = ObjectListKt.EmptyArray;
        } else {
            objArr = new Object[i];
        }
        this.content = objArr;
    }

    public final int getSize() {
        return this._size;
    }

    public final int getLastIndex() {
        return this._size - 1;
    }

    public final IntRange getIndices() {
        return RangesKt.until(0, this._size);
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    public final boolean containsAll(E[] eArr) {
        Intrinsics.checkNotNullParameter(eArr, "elements");
        for (E contains : eArr) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean containsAll(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "elements");
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!contains(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int count() {
        return this._size;
    }

    public final E first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("ObjectList is empty.");
    }

    public final E firstOrNull() {
        if (isEmpty()) {
            return null;
        }
        return get(0);
    }

    public final void forEach(Function1<? super E, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            function1.invoke(objArr[i2]);
        }
    }

    public final void forEachIndexed(Function2<? super Integer, ? super E, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            function2.invoke(Integer.valueOf(i2), objArr[i2]);
        }
    }

    public final void forEachReversed(Function1<? super E, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                function1.invoke(objArr[i]);
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super E, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                function2.invoke(Integer.valueOf(i), objArr[i]);
            } else {
                return;
            }
        }
    }

    public final E get(int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        StringBuilder sb = new StringBuilder("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final E elementAt(int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        StringBuilder sb = new StringBuilder("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final E elementAtOrElse(int i, Function1<? super Integer, ? extends E> function1) {
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        if (i < 0 || i >= this._size) {
            return function1.invoke(Integer.valueOf(i));
        }
        return this.content[i];
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final E last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        throw new NoSuchElementException("ObjectList is empty.");
    }

    public final E lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.content[this._size - 1];
    }

    public static /* synthetic */ String joinToString$default(ObjectList objectList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
            }
            if ((i2 & 2) != 0) {
                charSequence2 = "";
            }
            CharSequence charSequence5 = charSequence2;
            if ((i2 & 4) != 0) {
                charSequence3 = "";
            }
            CharSequence charSequence6 = charSequence3;
            if ((i2 & 8) != 0) {
                i = -1;
            }
            int i3 = i;
            if ((i2 & 16) != 0) {
                charSequence4 = "...";
            }
            CharSequence charSequence7 = charSequence4;
            if ((i2 & 32) != 0) {
                function1 = null;
            }
            return objectList.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence7, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super E, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        Object[] objArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            Object obj = objArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            if (function1 == null) {
                sb.append(obj);
            } else {
                sb.append((CharSequence) function1.invoke(obj));
            }
            i3++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r7 = (androidx.collection.ObjectList) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.collection.ObjectList
            r1 = 0
            if (r0 == 0) goto L_0x0032
            androidx.collection.ObjectList r7 = (androidx.collection.ObjectList) r7
            int r0 = r7._size
            int r2 = r6._size
            if (r0 == r2) goto L_0x000e
            goto L_0x0032
        L_0x000e:
            java.lang.Object[] r0 = r6.content
            java.lang.Object[] r7 = r7.content
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r1, (int) r2)
            int r3 = r2.getFirst()
            int r2 = r2.getLast()
            if (r3 > r2) goto L_0x0030
        L_0x0020:
            r4 = r0[r3]
            r5 = r7[r3]
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            if (r3 == r2) goto L_0x0030
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0030:
            r7 = 1
            return r7
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.equals(java.lang.Object):boolean");
    }

    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, new ObjectList$toString$1(this), 25, (Object) null);
    }

    public final boolean any(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (function1.invoke(objArr[i2]).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean reversedAny(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Object[] objArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (function1.invoke(objArr[i]).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(Iterable<? extends E> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "elements");
        for (Object contains : iterable) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public final boolean containsAll(ObjectList<E> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "elements");
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!contains(objArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final int count(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (function1.invoke(objArr[i3]).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public final E first(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        E[] eArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            E e = eArr[i2];
            if (function1.invoke(e).booleanValue()) {
                return e;
            }
        }
        throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
    }

    public final E firstOrNull(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        E[] eArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            E e = eArr[i2];
            if (function1.invoke(e).booleanValue()) {
                return e;
            }
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super R, ? super E, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R fold(R r5, kotlin.jvm.functions.Function2<? super R, ? super E, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object[] r0 = r4.content
            int r1 = r4._size
            r2 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x0015
            r3 = r0[r2]
            java.lang.Object r5 = r6.invoke(r5, r3)
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0015:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.fold(java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super E, ? extends R>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldIndexed(R r6, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super E, ? extends R> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Object[] r0 = r5.content
            int r1 = r5._size
            r2 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x0019
            r3 = r0[r2]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.Object r6 = r7.invoke(r4, r6, r3)
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0019:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.foldIndexed(java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super E, ? super R, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRight(R r4, kotlin.jvm.functions.Function2<? super E, ? super R, ? extends R> r5) {
        /*
            r3 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.Object[] r0 = r3.content
            int r1 = r3._size
            int r1 = r1 + -1
        L_0x000b:
            r2 = -1
            if (r2 >= r1) goto L_0x0017
            r2 = r0[r1]
            java.lang.Object r4 = r5.invoke(r2, r4)
            int r1 = r1 + -1
            goto L_0x000b
        L_0x0017:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.foldRight(java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super E, ? super R, ? extends R>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRightIndexed(R r5, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super E, ? super R, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Object[] r0 = r4.content
            int r1 = r4._size
            int r1 = r1 + -1
        L_0x000b:
            r2 = -1
            if (r2 >= r1) goto L_0x001b
            r2 = r0[r1]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            java.lang.Object r5 = r6.invoke(r3, r2, r5)
            int r1 = r1 + -1
            goto L_0x000b
        L_0x001b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ObjectList.foldRightIndexed(java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public final int indexOf(E e) {
        int i = 0;
        if (e == null) {
            Object[] objArr = this.content;
            int i2 = this._size;
            while (i < i2) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        Object[] objArr2 = this.content;
        int i3 = this._size;
        while (i < i3) {
            if (e.equals(objArr2[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final int indexOfFirst(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (function1.invoke(objArr[i2]).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfLast(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Object[] objArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return -1;
            }
            if (function1.invoke(objArr[i]).booleanValue()) {
                return i;
            }
        }
    }

    public final E last(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        E[] eArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                E e = eArr[i];
                if (function1.invoke(e).booleanValue()) {
                    return e;
                }
            } else {
                throw new NoSuchElementException("ObjectList contains no element matching the predicate.");
            }
        }
    }

    public final E lastOrNull(Function1<? super E, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        E[] eArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return null;
            }
            E e = eArr[i];
            if (function1.invoke(e).booleanValue()) {
                return e;
            }
        }
    }

    public final int lastIndexOf(E e) {
        if (e == null) {
            Object[] objArr = this.content;
            for (int i = this._size - 1; -1 < i; i--) {
                if (objArr[i] == null) {
                    return i;
                }
            }
        } else {
            Object[] objArr2 = this.content;
            for (int i2 = this._size - 1; -1 < i2; i2--) {
                if (e.equals(objArr2[i2])) {
                    return i2;
                }
            }
        }
        return -1;
    }

    public int hashCode() {
        Object[] objArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            i2 += (obj != null ? obj.hashCode() : 0) * 31;
        }
        return i2;
    }
}
