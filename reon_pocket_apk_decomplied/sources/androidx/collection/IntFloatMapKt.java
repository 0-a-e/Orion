package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\u001a\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\u001a\u0006\u0010\u0011\u001a\u00020\u0001\u001a\u0016\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a&\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u001a6\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b\u001aF\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b\u001aV\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyIntFloatMap", "Landroidx/collection/MutableIntFloatMap;", "emptyIntFloatMap", "Landroidx/collection/IntFloatMap;", "intFloatMapOf", "key1", "", "value1", "", "key2", "value2", "key3", "value3", "key4", "value4", "key5", "value5", "mutableIntFloatMapOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntFloatMap.kt */
public final class IntFloatMapKt {
    private static final MutableIntFloatMap EmptyIntFloatMap = new MutableIntFloatMap(0);

    public static final IntFloatMap emptyIntFloatMap() {
        return EmptyIntFloatMap;
    }

    public static final IntFloatMap intFloatMapOf() {
        return EmptyIntFloatMap;
    }

    public static final IntFloatMap intFloatMapOf(int i, float f) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        return mutableIntFloatMap;
    }

    public static final IntFloatMap intFloatMapOf(int i, float f, int i2, float f2) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        mutableIntFloatMap.set(i2, f2);
        return mutableIntFloatMap;
    }

    public static final IntFloatMap intFloatMapOf(int i, float f, int i2, float f2, int i3, float f3) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        mutableIntFloatMap.set(i2, f2);
        mutableIntFloatMap.set(i3, f3);
        return mutableIntFloatMap;
    }

    public static final IntFloatMap intFloatMapOf(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        mutableIntFloatMap.set(i2, f2);
        mutableIntFloatMap.set(i3, f3);
        mutableIntFloatMap.set(i4, f4);
        return mutableIntFloatMap;
    }

    public static final IntFloatMap intFloatMapOf(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4, int i5, float f5) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        mutableIntFloatMap.set(i2, f2);
        mutableIntFloatMap.set(i3, f3);
        mutableIntFloatMap.set(i4, f4);
        mutableIntFloatMap.set(i5, f5);
        return mutableIntFloatMap;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf() {
        return new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int i, float f) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        return mutableIntFloatMap;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int i, float f, int i2, float f2) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        mutableIntFloatMap.set(i2, f2);
        return mutableIntFloatMap;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int i, float f, int i2, float f2, int i3, float f3) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        mutableIntFloatMap.set(i2, f2);
        mutableIntFloatMap.set(i3, f3);
        return mutableIntFloatMap;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        mutableIntFloatMap.set(i2, f2);
        mutableIntFloatMap.set(i3, f3);
        mutableIntFloatMap.set(i4, f4);
        return mutableIntFloatMap;
    }

    public static final MutableIntFloatMap mutableIntFloatMapOf(int i, float f, int i2, float f2, int i3, float f3, int i4, float f4, int i5, float f5) {
        MutableIntFloatMap mutableIntFloatMap = new MutableIntFloatMap(0, 1, (DefaultConstructorMarker) null);
        mutableIntFloatMap.set(i, f);
        mutableIntFloatMap.set(i2, f2);
        mutableIntFloatMap.set(i3, f3);
        mutableIntFloatMap.set(i4, f4);
        mutableIntFloatMap.set(i5, f5);
        return mutableIntFloatMap;
    }
}
