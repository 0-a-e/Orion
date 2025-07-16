package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyLongIntMap", "Landroidx/collection/MutableLongIntMap;", "emptyLongIntMap", "Landroidx/collection/LongIntMap;", "longIntMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableLongIntMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LongIntMap.kt */
public final class LongIntMapKt {
    private static final MutableLongIntMap EmptyLongIntMap = new MutableLongIntMap(0);

    public static final LongIntMap emptyLongIntMap() {
        return EmptyLongIntMap;
    }

    public static final LongIntMap longIntMapOf() {
        return EmptyLongIntMap;
    }

    public static final LongIntMap longIntMapOf(long j, int i) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        mutableLongIntMap.set(j, i);
        return mutableLongIntMap;
    }

    public static final LongIntMap longIntMapOf(long j, int i, long j2, int i2) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        return mutableLongIntMap;
    }

    public static final LongIntMap longIntMapOf(long j, int i, long j2, int i2, long j3, int i3) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        return mutableLongIntMap;
    }

    public static final LongIntMap longIntMapOf(long j, int i, long j2, int i2, long j3, int i3, long j4, int i4) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        mutableLongIntMap.set(j4, i4);
        return mutableLongIntMap;
    }

    public static final LongIntMap longIntMapOf(long j, int i, long j2, int i2, long j3, int i3, long j4, int i4, long j5, int i5) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        long j6 = j;
        int i6 = i;
        mutableLongIntMap.set(j, i);
        long j7 = j2;
        int i7 = i2;
        mutableLongIntMap.set(j2, i2);
        long j8 = j3;
        int i8 = i3;
        mutableLongIntMap.set(j3, i3);
        long j9 = j4;
        int i9 = i4;
        mutableLongIntMap.set(j4, i4);
        mutableLongIntMap.set(j5, i5);
        return mutableLongIntMap;
    }

    public static final MutableLongIntMap mutableLongIntMapOf() {
        return new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        mutableLongIntMap.set(j, i);
        return mutableLongIntMap;
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i, long j2, int i2) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        return mutableLongIntMap;
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i, long j2, int i2, long j3, int i3) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        return mutableLongIntMap;
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i, long j2, int i2, long j3, int i3, long j4, int i4) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        mutableLongIntMap.set(j, i);
        mutableLongIntMap.set(j2, i2);
        mutableLongIntMap.set(j3, i3);
        mutableLongIntMap.set(j4, i4);
        return mutableLongIntMap;
    }

    public static final MutableLongIntMap mutableLongIntMapOf(long j, int i, long j2, int i2, long j3, int i3, long j4, int i4, long j5, int i5) {
        MutableLongIntMap mutableLongIntMap = new MutableLongIntMap(0, 1, (DefaultConstructorMarker) null);
        long j6 = j;
        int i6 = i;
        mutableLongIntMap.set(j, i);
        long j7 = j2;
        int i7 = i2;
        mutableLongIntMap.set(j2, i2);
        long j8 = j3;
        int i8 = i3;
        mutableLongIntMap.set(j3, i3);
        long j9 = j4;
        int i9 = i4;
        mutableLongIntMap.set(j4, i4);
        mutableLongIntMap.set(j5, i5);
        return mutableLongIntMap;
    }
}
