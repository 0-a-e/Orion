package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0006\u0010\b\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0012\u0010\b\u001a\u00020\u00072\n\u0010\r\u001a\u00020\u0001\"\u00020\n\u001a\u0011\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\b\u001a\u0006\u0010\u0011\u001a\u00020\u0005\u001a\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n\u001a\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n\u001a\u0012\u0010\u0011\u001a\u00020\u00052\n\u0010\r\u001a\u00020\u0001\"\u00020\n\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"EmptyFloatArray", "", "getEmptyFloatArray", "()[F", "EmptyFloatSet", "Landroidx/collection/MutableFloatSet;", "emptyFloatSet", "Landroidx/collection/FloatSet;", "floatSetOf", "element1", "", "element2", "element3", "elements", "hash", "", "k", "mutableFloatSetOf", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatSet.kt */
public final class FloatSetKt {
    private static final float[] EmptyFloatArray = new float[0];
    private static final MutableFloatSet EmptyFloatSet = new MutableFloatSet(0);

    public static final float[] getEmptyFloatArray() {
        return EmptyFloatArray;
    }

    public static final FloatSet emptyFloatSet() {
        return EmptyFloatSet;
    }

    public static final FloatSet floatSetOf() {
        return EmptyFloatSet;
    }

    public static final FloatSet floatSetOf(float f) {
        return mutableFloatSetOf(f);
    }

    public static final FloatSet floatSetOf(float f, float f2) {
        return mutableFloatSetOf(f, f2);
    }

    public static final FloatSet floatSetOf(float f, float f2, float f3) {
        return mutableFloatSetOf(f, f2, f3);
    }

    public static final FloatSet floatSetOf(float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(fArr.length);
        mutableFloatSet.plusAssign(fArr);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf() {
        return new MutableFloatSet(0, 1, (DefaultConstructorMarker) null);
    }

    public static final MutableFloatSet mutableFloatSetOf(float f) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(1);
        mutableFloatSet.plusAssign(f);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float f, float f2) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(2);
        mutableFloatSet.plusAssign(f);
        mutableFloatSet.plusAssign(f2);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float f, float f2, float f3) {
        MutableFloatSet mutableFloatSet = new MutableFloatSet(3);
        mutableFloatSet.plusAssign(f);
        mutableFloatSet.plusAssign(f2);
        mutableFloatSet.plusAssign(f3);
        return mutableFloatSet;
    }

    public static final MutableFloatSet mutableFloatSetOf(float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "elements");
        MutableFloatSet mutableFloatSet = new MutableFloatSet(fArr.length);
        mutableFloatSet.plusAssign(fArr);
        return mutableFloatSet;
    }

    public static final int hash(float f) {
        int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        return floatToIntBits ^ (floatToIntBits << 16);
    }
}
