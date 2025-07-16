package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyIntLongMap", "Landroidx/collection/MutableIntLongMap;", "emptyIntLongMap", "Landroidx/collection/IntLongMap;", "intLongMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntLongMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntLongMap.kt */
public final class IntLongMapKt {
    private static final MutableIntLongMap EmptyIntLongMap = new MutableIntLongMap(0);

    public static final IntLongMap emptyIntLongMap() {
        return EmptyIntLongMap;
    }

    public static final IntLongMap intLongMapOf() {
        return EmptyIntLongMap;
    }

    public static final IntLongMap intLongMapOf(int i, long j) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntLongMap.set(i, j);
        return mutableIntLongMap;
    }

    public static final IntLongMap intLongMapOf(int i, long j, int i2, long j2) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        return mutableIntLongMap;
    }

    public static final IntLongMap intLongMapOf(int i, long j, int i2, long j2, int i3, long j3) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        return mutableIntLongMap;
    }

    public static final IntLongMap intLongMapOf(int i, long j, int i2, long j2, int i3, long j3, int i4, long j4) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        mutableIntLongMap.set(i4, j4);
        return mutableIntLongMap;
    }

    public static final IntLongMap intLongMapOf(int i, long j, int i2, long j2, int i3, long j3, int i4, long j4, int i5, long j5) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        int i6 = i;
        long j6 = j;
        mutableIntLongMap.set(i, j);
        int i7 = i2;
        long j7 = j2;
        mutableIntLongMap.set(i2, j2);
        int i8 = i3;
        long j8 = j3;
        mutableIntLongMap.set(i3, j3);
        int i9 = i4;
        long j9 = j4;
        mutableIntLongMap.set(i4, j4);
        mutableIntLongMap.set(i5, j5);
        return mutableIntLongMap;
    }

    public static final MutableIntLongMap mutableIntLongMapOf() {
        return new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntLongMap.set(i, j);
        return mutableIntLongMap;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j, int i2, long j2) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        return mutableIntLongMap;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j, int i2, long j2, int i3, long j3) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        return mutableIntLongMap;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j, int i2, long j2, int i3, long j3, int i4, long j4) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntLongMap.set(i, j);
        mutableIntLongMap.set(i2, j2);
        mutableIntLongMap.set(i3, j3);
        mutableIntLongMap.set(i4, j4);
        return mutableIntLongMap;
    }

    public static final MutableIntLongMap mutableIntLongMapOf(int i, long j, int i2, long j2, int i3, long j3, int i4, long j4, int i5, long j5) {
        MutableIntLongMap mutableIntLongMap = new MutableIntLongMap(0, 1, (DefaultConstructorMarker) null);
        int i6 = i;
        long j6 = j;
        mutableIntLongMap.set(i, j);
        int i7 = i2;
        long j7 = j2;
        mutableIntLongMap.set(i2, j2);
        int i8 = i3;
        long j8 = j3;
        mutableIntLongMap.set(i3, j3);
        int i9 = i4;
        long j9 = j4;
        mutableIntLongMap.set(i4, j4);
        mutableIntLongMap.set(i5, j5);
        return mutableIntLongMap;
    }
}
