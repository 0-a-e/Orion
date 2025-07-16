package androidx.collection;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J:\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0011\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0000J\u0006\u0010\u001f\u001a\u00020\u0003J:\u0010\u001f\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0010\u0010 \u001a\u00020\u00182\b\b\u0001\u0010!\u001a\u00020\u0003J9\u0010\"\u001a\u00020\u00182\b\b\u0001\u0010!\u001a\u00020\u00032!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00180\u0017H\bø\u0001\u0000J\u0013\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0002J\u0006\u0010&\u001a\u00020\u0018J:\u0010&\u001a\u00020\u00182!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001Jb\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(26\u0010*\u001a2\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H(0+H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-Jw\u0010.\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H(0/H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00100Jb\u00101\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(26\u0010*\u001a2\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H(0+H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010-Jw\u00102\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u0010)\u001a\u0002H(2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(,\u0012\u0004\u0012\u0002H(0/H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u00100J:\u00103\u001a\u0002042!\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002040\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00106\u001a\u00020426\u00105\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002040+H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u00107\u001a\u0002042!\u00105\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002040\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001JO\u00108\u001a\u00020426\u00105\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002040+H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0013\u00109\u001a\u00020\u00182\b\b\u0001\u0010!\u001a\u00020\u0003H\u0002J\b\u0010:\u001a\u00020\u0003H\u0016J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018J:\u0010<\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J:\u0010=\u001a\u00020\u00032!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u0006\u0010>\u001a\u00020\u0015J\u0006\u0010?\u001a\u00020\u0015J:\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020CH\u0007JT\u0010@\u001a\u00020A2\b\b\u0002\u0010B\u001a\u00020C2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010E\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020C2\u0014\b\u0004\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020C0\u0017H\bø\u0001\u0000J\u0006\u0010I\u001a\u00020\u0018J:\u0010I\u001a\u00020\u00182!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000e\u0010J\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010K\u001a\u00020\u0015J:\u0010L\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00150\u0017H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\b\u0010M\u001a\u00020AH\u0016R\u0018\u0010\u0005\u001a\u00020\u00038\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\t8\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0007R\u0012\u0010\u000b\u001a\u00020\f8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00038Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u0001\u0001N\u0002\u0007\n\u0005\b20\u0001¨\u0006O"}, d2 = {"Landroidx/collection/LongList;", "", "initialCapacity", "", "(I)V", "_size", "get_size$annotations", "()V", "content", "", "getContent$annotations", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "()Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "()I", "size", "getSize", "any", "", "predicate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "element", "contains", "containsAll", "elements", "count", "elementAt", "index", "elementAtOrElse", "defaultValue", "equals", "other", "first", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "acc", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "block", "forEachIndexed", "forEachReversed", "forEachReversedIndexed", "get", "hashCode", "indexOf", "indexOfFirst", "indexOfLast", "isEmpty", "isNotEmpty", "joinToString", "", "separator", "", "prefix", "postfix", "limit", "truncated", "transform", "last", "lastIndexOf", "none", "reversedAny", "toString", "Landroidx/collection/MutableLongList;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LongList.kt */
public abstract class LongList {
    public int _size;
    public long[] content;

    public /* synthetic */ LongList(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public final String joinToString() {
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 31, (Object) null);
    }

    public final String joinToString(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 30, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, 28, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, 24, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i, (CharSequence) null, 16, (Object) null);
    }

    private LongList(int i) {
        long[] jArr;
        if (i == 0) {
            jArr = LongSetKt.getEmptyLongArray();
        } else {
            jArr = new long[i];
        }
        this.content = jArr;
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

    public final int count() {
        return this._size;
    }

    public final long first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("LongList is empty.");
    }

    public final void forEach(Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            function1.invoke(Long.valueOf(jArr[i2]));
        }
    }

    public final void forEachIndexed(Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            function2.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i2]));
        }
    }

    public final void forEachReversed(Function1<? super Long, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                function1.invoke(Long.valueOf(jArr[i]));
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(Function2<? super Integer, ? super Long, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                function2.invoke(Integer.valueOf(i), Long.valueOf(jArr[i]));
            } else {
                return;
            }
        }
    }

    public final long get(int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        StringBuilder sb = new StringBuilder("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final long elementAt(int i) {
        if (i >= 0 && i < this._size) {
            return this.content[i];
        }
        StringBuilder sb = new StringBuilder("Index ");
        sb.append(i);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final long elementAtOrElse(int i, Function1<? super Integer, Long> function1) {
        Intrinsics.checkNotNullParameter(function1, "defaultValue");
        if (i < 0 || i >= this._size) {
            return function1.invoke(Integer.valueOf(i)).longValue();
        }
        return this.content[i];
    }

    public final boolean isEmpty() {
        return this._size == 0;
    }

    public final boolean isNotEmpty() {
        return this._size != 0;
    }

    public final long last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        throw new NoSuchElementException("LongList is empty.");
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, int i2, Object obj) {
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
            return longList.joinToString(charSequence, charSequence5, charSequence6, i3, charSequence4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            long j = jArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            sb.append(j);
            i3++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
            }
            if ((i2 & 2) != 0) {
                charSequence2 = "";
            }
            if ((i2 & 4) != 0) {
                charSequence3 = "";
            }
            if ((i2 & 8) != 0) {
                i = -1;
            }
            if ((i2 & 16) != 0) {
            }
            Intrinsics.checkNotNullParameter(charSequence, "separator");
            Intrinsics.checkNotNullParameter(charSequence2, "prefix");
            Intrinsics.checkNotNullParameter(charSequence3, "postfix");
            Intrinsics.checkNotNullParameter(charSequence4, "truncated");
            Intrinsics.checkNotNullParameter(function1, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence2);
            long[] jArr = longList.content;
            int i3 = longList._size;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    sb.append(charSequence3);
                    break;
                }
                long j = jArr[i4];
                if (i4 == i) {
                    sb.append(charSequence4);
                    break;
                }
                if (i4 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) function1.invoke(Long.valueOf(j)));
                i4++;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        Intrinsics.checkNotNullParameter(function1, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            long j = jArr[i3];
            if (i3 == i) {
                sb.append(charSequence4);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) function1.invoke(Long.valueOf(j)));
            i3++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r9 = (androidx.collection.LongList) r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.collection.LongList
            r1 = 0
            if (r0 == 0) goto L_0x0030
            androidx.collection.LongList r9 = (androidx.collection.LongList) r9
            int r0 = r9._size
            int r2 = r8._size
            if (r0 == r2) goto L_0x000e
            goto L_0x0030
        L_0x000e:
            long[] r0 = r8.content
            long[] r9 = r9.content
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt.until((int) r1, (int) r2)
            int r3 = r2.getFirst()
            int r2 = r2.getLast()
            if (r3 > r2) goto L_0x002e
        L_0x0020:
            r4 = r0[r3]
            r6 = r9[r3]
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0029
            return r1
        L_0x0029:
            if (r3 == r2) goto L_0x002e
            int r3 = r3 + 1
            goto L_0x0020
        L_0x002e:
            r9 = 1
            return r9
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongList.equals(java.lang.Object):boolean");
    }

    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, 25, (Object) null);
    }

    public final boolean any(Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (function1.invoke(Long.valueOf(jArr[i2])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean reversedAny(Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        long[] jArr = this.content;
        for (int i = this._size - 1; -1 < i; i--) {
            if (function1.invoke(Long.valueOf(jArr[i])).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final boolean contains(long j) {
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (jArr[i2] == j) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(LongList longList) {
        Intrinsics.checkNotNullParameter(longList, "elements");
        IntRange until = RangesKt.until(0, longList._size);
        int first = until.getFirst();
        int last = until.getLast();
        if (first > last) {
            return true;
        }
        while (contains(longList.get(first))) {
            if (first == last) {
                return true;
            }
            first++;
        }
        return false;
    }

    public final int count(Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (function1.invoke(Long.valueOf(jArr[i3])).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public final long first(Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                return j;
            }
        }
        throw new NoSuchElementException("LongList contains no element matching the predicate.");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super R, ? super java.lang.Long, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R fold(R r6, kotlin.jvm.functions.Function2<? super R, ? super java.lang.Long, ? extends R> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            long[] r0 = r5.content
            int r1 = r5._size
            r2 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x0019
            r3 = r0[r2]
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r6 = r7.invoke(r6, r3)
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0019:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongList.fold(java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super java.lang.Long, ? extends R>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldIndexed(R r7, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super R, ? super java.lang.Long, ? extends R> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            long[] r0 = r6.content
            int r1 = r6._size
            r2 = 0
        L_0x000a:
            if (r2 >= r1) goto L_0x001d
            r3 = r0[r2]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.Object r7 = r8.invoke(r5, r7, r3)
            int r2 = r2 + 1
            goto L_0x000a
        L_0x001d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongList.foldIndexed(java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super R, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRight(R r5, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super R, ? extends R> r6) {
        /*
            r4 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            long[] r0 = r4.content
            int r1 = r4._size
            int r1 = r1 + -1
        L_0x000b:
            r2 = -1
            if (r2 >= r1) goto L_0x001b
            r2 = r0[r1]
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r5 = r6.invoke(r2, r5)
            int r1 = r1 + -1
            goto L_0x000b
        L_0x001b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongList.foldRight(java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Long, ? super R, ? extends R>, kotlin.jvm.functions.Function3, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> R foldRightIndexed(R r6, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Long, ? super R, ? extends R> r7) {
        /*
            r5 = this;
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            long[] r0 = r5.content
            int r1 = r5._size
            int r1 = r1 + -1
        L_0x000b:
            r2 = -1
            if (r2 >= r1) goto L_0x001f
            r2 = r0[r1]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r6 = r7.invoke(r4, r2, r6)
            int r1 = r1 + -1
            goto L_0x000b
        L_0x001f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongList.foldRightIndexed(java.lang.Object, kotlin.jvm.functions.Function3):java.lang.Object");
    }

    public final int indexOf(long j) {
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (j == jArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfFirst(Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (function1.invoke(Long.valueOf(jArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public final int indexOfLast(Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return -1;
            }
            if (function1.invoke(Long.valueOf(jArr[i])).booleanValue()) {
                return i;
            }
        }
    }

    public final long last(Function1<? super Long, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 < i) {
                long j = jArr[i];
                if (function1.invoke(Long.valueOf(j)).booleanValue()) {
                    return j;
                }
            } else {
                throw new NoSuchElementException("LongList contains no element matching the predicate.");
            }
        }
    }

    public final int lastIndexOf(long j) {
        long[] jArr = this.content;
        int i = this._size;
        while (true) {
            i--;
            if (-1 >= i) {
                return -1;
            }
            if (jArr[i] == j) {
                return i;
            }
        }
    }

    public int hashCode() {
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += UByte$$ExternalSyntheticBackport0.m(jArr[i3]) * 31;
        }
        return i2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(function1, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i2 = this._size;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                sb.append(charSequence3);
                break;
            }
            long j = jArr[i3];
            if (i3 == i) {
                sb.append(r0);
                break;
            }
            if (i3 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) function1.invoke(Long.valueOf(j)));
            i3++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(function1, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                sb.append(charSequence3);
                break;
            }
            long j = jArr[i2];
            if (i2 == -1) {
                sb.append(r0);
                break;
            }
            if (i2 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) function1.invoke(Long.valueOf(j)));
            i2++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(function1, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                sb.append(r0);
                break;
            }
            long j = jArr[i2];
            if (i2 == -1) {
                sb.append(r1);
                break;
            }
            if (i2 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) function1.invoke(Long.valueOf(j)));
            i2++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(function1, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                sb.append(r0);
                break;
            }
            long j = jArr[i2];
            if (i2 == -1) {
                sb.append(r2);
                break;
            }
            if (i2 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) function1.invoke(Long.valueOf(j)));
            i2++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(function1, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        long[] jArr = this.content;
        int i = this._size;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                sb.append(r1);
                break;
            }
            long j = jArr[i2];
            if (i2 == -1) {
                sb.append(r3);
                break;
            }
            if (i2 != 0) {
                sb.append(r0);
            }
            sb.append((CharSequence) function1.invoke(Long.valueOf(j)));
            i2++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
