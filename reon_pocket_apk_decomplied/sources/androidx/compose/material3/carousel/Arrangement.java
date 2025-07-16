package androidx.compose.material3.carousel;

import androidx.annotation.FloatRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeSize", "()F", "getMediumSize", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Arrangement.kt */
public final class Arrangement {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    public Arrangement(int i, float f, int i2, float f2, int i3, float f3, int i4) {
        this.priority = i;
        this.smallSize = f;
        this.smallCount = i2;
        this.mediumSize = f2;
        this.mediumCount = i3;
        this.largeSize = f3;
        this.largeCount = i4;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    private final boolean isValid() {
        int i = this.largeCount;
        if (i > 0 && this.smallCount > 0 && this.mediumCount > 0) {
            float f = this.largeSize;
            float f2 = this.mediumSize;
            if (f <= f2 || f2 <= this.smallSize) {
                return false;
            }
            return true;
        } else if (i <= 0 || this.smallCount <= 0) {
            return true;
        } else {
            if (this.largeSize > this.smallSize) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final float cost(float f) {
        if (!isValid()) {
            return Float.MAX_VALUE;
        }
        return Math.abs(f - this.largeSize) * ((float) this.priority);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JH\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012JP\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "targetSmallSize", "smallSizeRange", "Landroidx/annotation/FloatRange;", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Arrangement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float calculateLargeSize(float f, int i, float f2, int i2, int i3) {
            float f3 = ((float) i2) / 2.0f;
            return (f - ((((float) i) + f3) * f2)) / (((float) i3) + f3);
        }

        private Companion() {
        }

        public final Arrangement findLowestCostArrangement(float f, float f2, FloatRange floatRange, int[] iArr, float f3, int[] iArr2, float f4, int[] iArr3) {
            int[] iArr4 = iArr;
            int[] iArr5 = iArr2;
            float f5 = f4;
            int[] iArr6 = iArr3;
            int length = iArr6.length;
            Arrangement arrangement = null;
            int i = 1;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr6[i2];
                int length2 = iArr5.length;
                int i4 = 0;
                while (i4 < length2) {
                    int i5 = iArr5[i4];
                    int length3 = iArr4.length;
                    Arrangement arrangement2 = arrangement;
                    int i6 = i;
                    int i7 = 0;
                    while (i7 < length3) {
                        int i8 = i7;
                        Arrangement arrangement3 = arrangement2;
                        int i9 = length3;
                        int i10 = i4;
                        int i11 = length2;
                        int i12 = i2;
                        Arrangement fit = fit(i6, f, iArr4[i7], f2, floatRange, i5, f3, i3, f4);
                        if (arrangement3 != null && fit.cost(f5) >= arrangement3.cost(f5)) {
                            arrangement2 = arrangement3;
                        } else if (fit.cost(f5) == 0.0f) {
                            return fit;
                        } else {
                            arrangement2 = fit;
                        }
                        i6++;
                        i7 = i8 + 1;
                        length3 = i9;
                        i4 = i10;
                        length2 = i11;
                        i2 = i12;
                    }
                    int i13 = length2;
                    int i14 = i2;
                    i4++;
                    arrangement = arrangement2;
                    i = i6;
                }
                i2++;
            }
            return arrangement;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x004d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x007b  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0081  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final androidx.compose.material3.carousel.Arrangement fit(int r14, float r15, int r16, float r17, androidx.annotation.FloatRange r18, int r19, float r20, int r21, float r22) {
            /*
                r13 = this;
                r6 = r16
                r7 = r19
                double r0 = r18.from()
                float r0 = (float) r0
                double r1 = r18.to()
                float r1 = (float) r1
                r2 = r17
                float r0 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r0, (float) r1)
                r8 = r21
                float r9 = (float) r8
                float r1 = r22 * r9
                float r10 = (float) r7
                float r2 = r20 * r10
                float r1 = r1 + r2
                float r2 = (float) r6
                float r3 = r0 * r2
                float r1 = r1 + r3
                float r1 = r15 - r1
                r11 = 0
                if (r6 <= 0) goto L_0x0037
                int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
                if (r3 <= 0) goto L_0x0037
                float r1 = r1 / r2
                double r2 = r18.to()
                float r2 = (float) r2
                float r2 = r2 - r0
                float r1 = java.lang.Math.min(r1, r2)
            L_0x0035:
                float r0 = r0 + r1
                goto L_0x0049
            L_0x0037:
                if (r6 <= 0) goto L_0x0049
                int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
                if (r3 >= 0) goto L_0x0049
                float r1 = r1 / r2
                double r2 = r18.from()
                float r2 = (float) r2
                float r2 = r2 - r0
                float r1 = java.lang.Math.max(r1, r2)
                goto L_0x0035
            L_0x0049:
                if (r6 <= 0) goto L_0x004d
                r12 = r0
                goto L_0x004e
            L_0x004d:
                r12 = r11
            L_0x004e:
                r0 = r13
                r1 = r15
                r2 = r16
                r3 = r12
                r4 = r19
                r5 = r21
                float r0 = r0.calculateLargeSize(r1, r2, r3, r4, r5)
                float r1 = r0 + r12
                r2 = 1073741824(0x40000000, float:2.0)
                float r1 = r1 / r2
                if (r7 <= 0) goto L_0x0086
                int r2 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
                if (r2 != 0) goto L_0x0067
                goto L_0x0086
            L_0x0067:
                float r2 = r22 - r0
                float r2 = r2 * r9
                r3 = 1036831949(0x3dcccccd, float:0.1)
                float r3 = r3 * r1
                float r3 = r3 * r10
                float r4 = java.lang.Math.abs(r2)
                float r3 = java.lang.Math.min(r4, r3)
                int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
                if (r2 <= 0) goto L_0x0081
                float r2 = r3 / r10
                float r1 = r1 - r2
                float r3 = r3 / r9
                float r0 = r0 + r3
                goto L_0x0086
            L_0x0081:
                float r2 = r3 / r10
                float r1 = r1 + r2
                float r3 = r3 / r9
                float r0 = r0 - r3
            L_0x0086:
                r9 = r0
                r4 = r1
                androidx.compose.material3.carousel.Arrangement r10 = new androidx.compose.material3.carousel.Arrangement
                r0 = r10
                r1 = r14
                r2 = r12
                r3 = r16
                r5 = r19
                r6 = r9
                r7 = r21
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.Arrangement.Companion.fit(int, float, int, float, androidx.annotation.FloatRange, int, float, int, float):androidx.compose.material3.carousel.Arrangement");
        }
    }
}
