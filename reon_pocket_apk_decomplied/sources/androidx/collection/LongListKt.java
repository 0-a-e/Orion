package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0006\u0010\u0003\u001a\u00020\u0001\u001a\u000e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0012\u0010\u0003\u001a\u00020\u00012\n\u0010\b\u001a\u00020\t\"\u00020\u0005\u001a\t\u0010\n\u001a\u00020\u000bH\b\u001a\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u001a\u0015\u0010\n\u001a\u00020\u000b2\n\u0010\b\u001a\u00020\t\"\u00020\u0005H\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"EmptyLongList", "Landroidx/collection/LongList;", "emptyLongList", "longListOf", "element1", "", "element2", "element3", "elements", "", "mutableLongListOf", "Landroidx/collection/MutableLongList;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LongList.kt */
public final class LongListKt {
    private static final LongList EmptyLongList = new MutableLongList(0);

    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    public static final LongList longListOf() {
        return EmptyLongList;
    }

    public static final LongList longListOf(long j) {
        return mutableLongListOf(j);
    }

    public static final LongList longListOf(long j, long j2) {
        return mutableLongListOf(j, j2);
    }

    public static final LongList longListOf(long j, long j2, long j3) {
        return mutableLongListOf(j, j2, j3);
    }

    public static final LongList longListOf(long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "elements");
        MutableLongList mutableLongList = new MutableLongList(jArr.length);
        mutableLongList.plusAssign(jArr);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, (DefaultConstructorMarker) null);
    }

    public static final MutableLongList mutableLongListOf(long j) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j, long j2) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j);
        mutableLongList.add(j2);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j, long j2, long j3) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j);
        mutableLongList.add(j2);
        mutableLongList.add(j3);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "elements");
        MutableLongList mutableLongList = new MutableLongList(jArr.length);
        mutableLongList.plusAssign(jArr);
        return mutableLongList;
    }
}
