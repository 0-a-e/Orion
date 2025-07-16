package androidx.compose.animation.core;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b\u001a(\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a8\u0010\u0011\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a9\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\b\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\b¨\u0006\u001d"}, d2 = {"estimateAnimationDurationMillis", "", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "firstRoot", "Landroidx/compose/animation/core/ComplexDouble;", "p0", "v0", "estimateDurationInternal", "secondRoot", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SpringEstimation.kt */
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float f, float f2, float f3, float f4, float f5) {
        return estimateAnimationDurationMillis((double) f, (double) f2, (double) f3, (double) f4, (double) f5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5) {
        double sqrt = 2.0d * d2 * Math.sqrt(d);
        double d6 = (sqrt * sqrt) - (4.0d * d);
        double d7 = -sqrt;
        ComplexDouble complexSqrt = ComplexDoubleKt.complexSqrt(d6);
        complexSqrt._real = complexSqrt._real + d7;
        complexSqrt._real = complexSqrt._real * 0.5d;
        complexSqrt._imaginary = complexSqrt._imaginary * 0.5d;
        ComplexDouble complexSqrt2 = ComplexDoubleKt.complexSqrt(d6);
        double d8 = (double) -1;
        complexSqrt2._real = complexSqrt2._real * d8;
        complexSqrt2._imaginary = complexSqrt2._imaginary * d8;
        complexSqrt2._real = complexSqrt2._real + d7;
        complexSqrt2._real = complexSqrt2._real * 0.5d;
        complexSqrt2._imaginary = complexSqrt2._imaginary * 0.5d;
        return estimateDurationInternal(complexSqrt, complexSqrt2, d2, d3, d4, d5);
    }

    public static final long estimateAnimationDurationMillis(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2;
        double sqrt = d7 / (Math.sqrt(d * d3) * 2.0d);
        double d8 = (d7 * d7) - ((4.0d * d3) * d);
        double d9 = 1.0d / (2.0d * d3);
        double d10 = -d7;
        ComplexDouble complexSqrt = ComplexDoubleKt.complexSqrt(d8);
        complexSqrt._real = complexSqrt._real + d10;
        complexSqrt._real = complexSqrt._real * d9;
        complexSqrt._imaginary = complexSqrt._imaginary * d9;
        ComplexDouble complexSqrt2 = ComplexDoubleKt.complexSqrt(d8);
        double d11 = (double) -1;
        complexSqrt2._real = complexSqrt2._real * d11;
        complexSqrt2._imaginary = complexSqrt2._imaginary * d11;
        complexSqrt2._real = complexSqrt2._real + d10;
        complexSqrt2._real = complexSqrt2._real * d9;
        complexSqrt2._imaginary = complexSqrt2._imaginary * d9;
        return estimateDurationInternal(complexSqrt, complexSqrt2, sqrt, d4, d5, d6);
    }

    private static final double estimateUnderDamped(ComplexDouble complexDouble, double d, double d2, double d3) {
        double real = complexDouble.getReal();
        double imaginary = (d2 - (real * d)) / complexDouble.getImaginary();
        return Math.log(d3 / Math.sqrt((d * d) + (imaginary * imaginary))) / real;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4 A[LOOP:1: B:38:0x00a7->B:42:0x00b4, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateCriticallyDamped(androidx.compose.animation.core.ComplexDouble r20, double r21, double r23, double r25) {
        /*
            r0 = r25
            double r2 = r20.getReal()
            double r4 = r2 * r21
            double r6 = r23 - r4
            double r8 = r0 / r21
            double r8 = java.lang.Math.abs(r8)
            double r8 = java.lang.Math.log(r8)
            double r8 = r8 / r2
            double r10 = r0 / r6
            double r10 = java.lang.Math.abs(r10)
            double r10 = java.lang.Math.log(r10)
            r14 = r10
            r13 = 0
        L_0x0021:
            r12 = 6
            if (r13 >= r12) goto L_0x0032
            double r14 = r14 / r2
            double r14 = java.lang.Math.abs(r14)
            double r14 = java.lang.Math.log(r14)
            double r14 = r10 - r14
            int r13 = r13 + 1
            goto L_0x0021
        L_0x0032:
            double r14 = r14 / r2
            boolean r10 = java.lang.Double.isInfinite(r8)
            r11 = 1
            if (r10 != 0) goto L_0x0042
            boolean r10 = java.lang.Double.isNaN(r8)
            if (r10 != 0) goto L_0x0042
            r10 = r11
            goto L_0x0043
        L_0x0042:
            r10 = 0
        L_0x0043:
            r10 = r10 ^ r11
            if (r10 == 0) goto L_0x0048
            r8 = r14
            goto L_0x005f
        L_0x0048:
            boolean r10 = java.lang.Double.isInfinite(r14)
            if (r10 != 0) goto L_0x0056
            boolean r10 = java.lang.Double.isNaN(r14)
            if (r10 != 0) goto L_0x0056
            r10 = r11
            goto L_0x0057
        L_0x0056:
            r10 = 0
        L_0x0057:
            r10 = r10 ^ r11
            if (r10 == 0) goto L_0x005b
            goto L_0x005f
        L_0x005b:
            double r8 = java.lang.Math.max(r8, r14)
        L_0x005f:
            double r12 = r4 + r6
            double r12 = -r12
            double r14 = r2 * r6
            double r12 = r12 / r14
            double r14 = r2 * r12
            double r16 = java.lang.Math.exp(r14)
            double r16 = r16 * r21
            double r18 = r6 * r12
            double r14 = java.lang.Math.exp(r14)
            double r18 = r18 * r14
            double r14 = r16 + r18
            boolean r10 = java.lang.Double.isNaN(r12)
            if (r10 != 0) goto L_0x00a0
            r16 = 0
            int r10 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r10 > 0) goto L_0x0084
            goto L_0x00a0
        L_0x0084:
            int r10 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x0098
            double r12 = -r14
            int r10 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r10 >= 0) goto L_0x0098
            int r10 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r10 >= 0) goto L_0x00a0
            int r10 = (r21 > r16 ? 1 : (r21 == r16 ? 0 : -1))
            if (r10 <= 0) goto L_0x00a0
            r8 = r16
            goto L_0x00a0
        L_0x0098:
            r8 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = r8 / r2
            double r8 = -r8
            double r12 = r21 / r6
            double r8 = r8 - r12
            goto L_0x00a1
        L_0x00a0:
            double r0 = -r0
        L_0x00a1:
            r12 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r10 = 0
        L_0x00a7:
            r14 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x00da
            r12 = 100
            if (r10 >= r12) goto L_0x00da
            int r10 = r10 + 1
            double r12 = r6 * r8
            double r12 = r21 + r12
            double r14 = r2 * r8
            double r16 = java.lang.Math.exp(r14)
            double r12 = r12 * r16
            double r12 = r12 + r0
            r23 = r0
            double r0 = (double) r11
            double r0 = r0 + r14
            double r0 = r0 * r6
            double r0 = r0 + r4
            double r14 = java.lang.Math.exp(r14)
            double r0 = r0 * r14
            double r12 = r12 / r0
            double r0 = r8 - r12
            double r8 = r8 - r0
            double r12 = java.lang.Math.abs(r8)
            r8 = r0
            r0 = r23
            goto L_0x00a7
        L_0x00da:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateCriticallyDamped(androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final double estimateOverDamped(androidx.compose.animation.core.ComplexDouble r29, androidx.compose.animation.core.ComplexDouble r30, double r31, double r33, double r35) {
        /*
            r0 = r35
            double r12 = r29.getReal()
            double r14 = r30.getReal()
            double r2 = r12 * r31
            double r2 = r2 - r33
            double r16 = r12 - r14
            double r10 = r2 / r16
            double r18 = r31 - r10
            double r2 = r0 / r18
            double r2 = java.lang.Math.abs(r2)
            double r2 = java.lang.Math.log(r2)
            double r2 = r2 / r12
            double r4 = r0 / r10
            double r4 = java.lang.Math.abs(r4)
            double r4 = java.lang.Math.log(r4)
            double r4 = r4 / r14
            boolean r6 = java.lang.Double.isInfinite(r2)
            r20 = 0
            r7 = 1
            if (r6 != 0) goto L_0x003b
            boolean r6 = java.lang.Double.isNaN(r2)
            if (r6 != 0) goto L_0x003b
            r6 = r7
            goto L_0x003d
        L_0x003b:
            r6 = r20
        L_0x003d:
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x0043
            r21 = r4
            goto L_0x005d
        L_0x0043:
            boolean r6 = java.lang.Double.isInfinite(r4)
            if (r6 != 0) goto L_0x0051
            boolean r6 = java.lang.Double.isNaN(r4)
            if (r6 != 0) goto L_0x0051
            r6 = r7
            goto L_0x0053
        L_0x0051:
            r6 = r20
        L_0x0053:
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x0057
            goto L_0x005b
        L_0x0057:
            double r2 = java.lang.Math.max(r2, r4)
        L_0x005b:
            r21 = r2
        L_0x005d:
            double r23 = r18 * r12
            double r2 = -r10
            double r2 = r2 * r14
            double r2 = r23 / r2
            double r2 = java.lang.Math.log(r2)
            double r4 = r14 - r12
            double r6 = r2 / r4
            boolean r2 = java.lang.Double.isNaN(r6)
            if (r2 != 0) goto L_0x00a7
            r25 = 0
            int r2 = (r6 > r25 ? 1 : (r6 == r25 ? 0 : -1))
            if (r2 > 0) goto L_0x0078
            goto L_0x00a7
        L_0x0078:
            int r2 = (r6 > r25 ? 1 : (r6 == r25 ? 0 : -1))
            if (r2 <= 0) goto L_0x0097
            r2 = r18
            r4 = r12
            r8 = r10
            r27 = r10
            r10 = r14
            double r2 = estimateOverDamped$xInflection(r2, r4, r6, r8, r10)
            double r2 = -r2
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 >= 0) goto L_0x0099
            int r2 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a9
            int r2 = (r18 > r25 ? 1 : (r18 == r25 ? 0 : -1))
            if (r2 >= 0) goto L_0x00a9
            r21 = r25
            goto L_0x00a9
        L_0x0097:
            r27 = r10
        L_0x0099:
            double r10 = r27 * r14
            double r10 = r10 * r14
            double r2 = -r10
            double r4 = r23 * r12
            double r2 = r2 / r4
            double r2 = java.lang.Math.log(r2)
            double r21 = r2 / r16
            goto L_0x00aa
        L_0x00a7:
            r27 = r10
        L_0x00a9:
            double r0 = -r0
        L_0x00aa:
            double r2 = r12 * r21
            double r2 = java.lang.Math.exp(r2)
            double r2 = r2 * r23
            double r10 = r27 * r14
            double r4 = r14 * r21
            double r4 = java.lang.Math.exp(r4)
            double r4 = r4 * r10
            double r2 = r2 + r4
            double r2 = java.lang.Math.abs(r2)
            r4 = 4547007122018943789(0x3f1a36e2eb1c432d, double:1.0E-4)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x00ca
            return r21
        L_0x00ca:
            r2 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            r4 = r20
        L_0x00d1:
            r5 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x010c
            r2 = 100
            if (r4 >= r2) goto L_0x010c
            int r4 = r4 + 1
            double r2 = r12 * r21
            double r5 = java.lang.Math.exp(r2)
            double r5 = r5 * r18
            double r7 = r14 * r21
            double r16 = java.lang.Math.exp(r7)
            double r16 = r16 * r27
            double r5 = r5 + r16
            double r5 = r5 + r0
            double r2 = java.lang.Math.exp(r2)
            double r2 = r2 * r23
            double r7 = java.lang.Math.exp(r7)
            double r7 = r7 * r10
            double r2 = r2 + r7
            double r5 = r5 / r2
            double r2 = r21 - r5
            double r21 = r21 - r2
            double r5 = java.lang.Math.abs(r21)
            r21 = r2
            r2 = r5
            goto L_0x00d1
        L_0x010c:
            return r21
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SpringEstimationKt.estimateOverDamped(androidx.compose.animation.core.ComplexDouble, androidx.compose.animation.core.ComplexDouble, double, double, double):double");
    }

    private static final double estimateOverDamped$xInflection(double d, double d2, double d3, double d4, double d5) {
        return (d * Math.exp(d2 * d3)) + (d4 * Math.exp(d5 * d3));
    }

    private static final long estimateDurationInternal(ComplexDouble complexDouble, ComplexDouble complexDouble2, double d, double d2, double d3, double d4) {
        double d5;
        double d6 = d2;
        int i = (d3 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (d3 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
        if (i == 0 && d6 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 0;
        }
        if (i < 0) {
            d6 = -d6;
        }
        double abs = Math.abs(d3);
        if (d > 1.0d) {
            d5 = estimateOverDamped(complexDouble, complexDouble2, abs, d6, d4);
        } else if (d < 1.0d) {
            d5 = estimateUnderDamped(complexDouble, abs, d6, d4);
        } else {
            d5 = estimateCriticallyDamped(complexDouble, abs, d6, d4);
        }
        return (long) (d5 * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double d, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
        return d - (function1.invoke(Double.valueOf(d)).doubleValue() / function12.invoke(Double.valueOf(d)).doubleValue());
    }

    private static final boolean isNotFinite(double d) {
        return !(!Double.isInfinite(d) && !Double.isNaN(d));
    }
}
