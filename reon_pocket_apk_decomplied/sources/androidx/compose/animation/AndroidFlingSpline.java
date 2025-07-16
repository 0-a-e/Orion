package androidx.compose.animation;

import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/animation/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "time", "FlingResult", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SplineBasedDecay.kt */
public final class AndroidFlingSpline {
    public static final int $stable = 8;
    public static final AndroidFlingSpline INSTANCE = new AndroidFlingSpline();
    private static final int NbSamples = 100;
    private static final float[] SplinePositions;
    private static final float[] SplineTimes;

    private AndroidFlingSpline() {
    }

    static {
        float[] fArr = new float[101];
        SplinePositions = fArr;
        float[] fArr2 = new float[101];
        SplineTimes = fArr2;
        SplineBasedDecayKt.computeSplineInfo(fArr, fArr2, 100);
    }

    public final FlingResult flingPosition(float f) {
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
        return new FlingResult(f2, f3);
    }

    public final double deceleration(float f, float f2) {
        return Math.log(((double) (Math.abs(f) * 0.35f)) / ((double) f2));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "", "distanceCoefficient", "", "velocityCoefficient", "(FF)V", "getDistanceCoefficient", "()F", "getVelocityCoefficient", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SplineBasedDecay.kt */
    public static final class FlingResult {
        public static final int $stable = 0;
        private final float distanceCoefficient;
        private final float velocityCoefficient;

        public static /* synthetic */ FlingResult copy$default(FlingResult flingResult, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = flingResult.distanceCoefficient;
            }
            if ((i & 2) != 0) {
                f2 = flingResult.velocityCoefficient;
            }
            return flingResult.copy(f, f2);
        }

        public final float component1() {
            return this.distanceCoefficient;
        }

        public final float component2() {
            return this.velocityCoefficient;
        }

        public final FlingResult copy(float f, float f2) {
            return new FlingResult(f, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingResult)) {
                return false;
            }
            FlingResult flingResult = (FlingResult) obj;
            return Float.compare(this.distanceCoefficient, flingResult.distanceCoefficient) == 0 && Float.compare(this.velocityCoefficient, flingResult.velocityCoefficient) == 0;
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.distanceCoefficient) * 31) + Float.floatToIntBits(this.velocityCoefficient);
        }

        public String toString() {
            return "FlingResult(distanceCoefficient=" + this.distanceCoefficient + ", velocityCoefficient=" + this.velocityCoefficient + ')';
        }

        public FlingResult(float f, float f2) {
            this.distanceCoefficient = f;
            this.velocityCoefficient = f2;
        }

        public final float getDistanceCoefficient() {
            return this.distanceCoefficient;
        }

        public final float getVelocityCoefficient() {
            return this.velocityCoefficient;
        }
    }
}
