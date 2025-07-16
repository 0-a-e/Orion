package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u001b\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "time", "flingPosition-LfoxSSI", "(F)J", "FlingResult", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsConnection.android.kt */
final class AndroidFlingSpline {
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final int NbSamples = 100;
    private static final float[] SplinePositions = new float[101];
    private static final float[] SplineTimes = new float[101];

    private AndroidFlingSpline() {
    }

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i = 0; i < 100; i++) {
            float f11 = ((float) i) / ((float) 100);
            float f12 = 1.0f;
            while (true) {
                f = ((f12 - f9) / 2.0f) + f9;
                f2 = 1.0f - f;
                f3 = f * 3.0f * f2;
                f4 = f * f * f;
                float f13 = (((f2 * 0.175f) + (f * 0.35000002f)) * f3) + f4;
                if (((double) Math.abs(f13 - f11)) < 1.0E-5d) {
                    break;
                } else if (f13 > f11) {
                    f12 = f;
                } else {
                    f9 = f;
                }
            }
            float f14 = 0.5f;
            SplinePositions[i] = (f3 * ((f2 * 0.5f) + f)) + f4;
            float f15 = 1.0f;
            while (true) {
                f5 = ((f15 - f10) / 2.0f) + f10;
                f6 = 1.0f - f5;
                f7 = f5 * 3.0f * f6;
                f8 = f5 * f5 * f5;
                float f16 = (((f6 * f14) + f5) * f7) + f8;
                if (((double) Math.abs(f16 - f11)) < 1.0E-5d) {
                    break;
                }
                if (f16 > f11) {
                    f15 = f5;
                } else {
                    f10 = f5;
                }
                f14 = 0.5f;
            }
            SplineTimes[i] = (f7 * ((f6 * 0.175f) + (f5 * 0.35000002f))) + f8;
        }
        SplineTimes[100] = 1.0f;
        SplinePositions[100] = 1.0f;
    }

    /* renamed from: flingPosition-LfoxSSI  reason: not valid java name */
    public final long m527flingPositionLfoxSSI(float f) {
        float f2;
        float f3;
        float f4 = (float) 100;
        int i = (int) (f4 * f);
        if (i < 100) {
            float f5 = ((float) i) / f4;
            int i2 = i + 1;
            float f6 = ((float) i2) / f4;
            float[] fArr = SplinePositions;
            float f7 = fArr[i];
            f3 = (fArr[i2] - f7) / (f6 - f5);
            f2 = f7 + ((f - f5) * f3);
        } else {
            f2 = 1.0f;
            f3 = 0.0f;
        }
        long floatToRawIntBits = (long) Float.floatToRawIntBits(f2);
        return FlingResult.m529constructorimpl((((long) Float.floatToRawIntBits(f3)) & 4294967295L) | (floatToRawIntBits << 32));
    }

    public final double deceleration(float f, float f2) {
        return Math.log(((double) (Math.abs(f) * 0.35f)) / ((double) f2));
    }

    @JvmInline
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0001\u0002\u0001\u00020\u0003¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/AndroidFlingSpline$FlingResult;", "", "packedValue", "", "constructor-impl", "(J)J", "distanceCoefficient", "", "getDistanceCoefficient-impl", "(J)F", "velocityCoefficient", "getVelocityCoefficient-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: WindowInsetsConnection.android.kt */
    public static final class FlingResult {
        private final long packedValue;

        /* renamed from: box-impl  reason: not valid java name */
        public static final /* synthetic */ FlingResult m528boximpl(long j) {
            return new FlingResult(j);
        }

        /* renamed from: constructor-impl  reason: not valid java name */
        public static long m529constructorimpl(long j) {
            return j;
        }

        /* renamed from: equals-impl  reason: not valid java name */
        public static boolean m530equalsimpl(long j, Object obj) {
            return (obj instanceof FlingResult) && j == ((FlingResult) obj).m536unboximpl();
        }

        /* renamed from: equals-impl0  reason: not valid java name */
        public static final boolean m531equalsimpl0(long j, long j2) {
            return j == j2;
        }

        /* renamed from: hashCode-impl  reason: not valid java name */
        public static int m534hashCodeimpl(long j) {
            return UByte$$ExternalSyntheticBackport0.m(j);
        }

        /* renamed from: toString-impl  reason: not valid java name */
        public static String m535toStringimpl(long j) {
            return "FlingResult(packedValue=" + j + ')';
        }

        public boolean equals(Object obj) {
            return m530equalsimpl(this.packedValue, obj);
        }

        public int hashCode() {
            return m534hashCodeimpl(this.packedValue);
        }

        public String toString() {
            return m535toStringimpl(this.packedValue);
        }

        /* renamed from: unbox-impl  reason: not valid java name */
        public final /* synthetic */ long m536unboximpl() {
            return this.packedValue;
        }

        private /* synthetic */ FlingResult(long j) {
            this.packedValue = j;
        }

        /* renamed from: getDistanceCoefficient-impl  reason: not valid java name */
        public static final float m532getDistanceCoefficientimpl(long j) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j >> 32));
        }

        /* renamed from: getVelocityCoefficient-impl  reason: not valid java name */
        public static final float m533getVelocityCoefficientimpl(long j) {
            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
            return Float.intBitsToFloat((int) (j & 4294967295L));
        }
    }
}
