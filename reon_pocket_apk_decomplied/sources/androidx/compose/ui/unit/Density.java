package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Density.kt */
public interface Density extends FontScaling {
    float getDensity();

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    int m6544roundToPxR2X_6o(long j);

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    int m6545roundToPx0680j_4(float f);

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m6546toDpu2uoSUM(float f);

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m6547toDpu2uoSUM(int i);

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    long m6548toDpSizekrfVVM(long j);

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    float m6549toPxR2X_6o(long j);

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    float m6550toPx0680j_4(float f);

    Rect toRect(DpRect dpRect);

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    long m6551toSizeXkaWNTQ(long j);

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m6552toSpkPz2Gy4(float f);

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m6553toSpkPz2Gy4(int i);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Density.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m6578toDpGaN1DYA(Density density, long j) {
            return FontScaling.CC.m6725$default$toDpGaN1DYA(density, j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m6585toSp0xMU5do(Density density, float f) {
            return FontScaling.CC.m6726$default$toSp0xMU5do(density, f);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m6583toPx0680j_4(Density density, float f) {
            return CC.m6560$default$toPx0680j_4(density, f);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m6577roundToPx0680j_4(Density density, float f) {
            return CC.m6555$default$roundToPx0680j_4(density, f);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m6582toPxR2X_6o(Density density, long j) {
            return CC.m6559$default$toPxR2X_6o(density, j);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m6576roundToPxR2X_6o(Density density, long j) {
            return CC.m6554$default$roundToPxR2X_6o(density, j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m6580toDpu2uoSUM(Density density, int i) {
            return CC.m6557$default$toDpu2uoSUM(density, i);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m6587toSpkPz2Gy4(Density density, int i) {
            return CC.m6563$default$toSpkPz2Gy4(density, i);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m6579toDpu2uoSUM(Density density, float f) {
            return CC.m6556$default$toDpu2uoSUM(density, f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m6586toSpkPz2Gy4(Density density, float f) {
            return CC.m6562$default$toSpkPz2Gy4(density, f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return CC.$default$toRect(density, dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m6584toSizeXkaWNTQ(Density density, long j) {
            return CC.m6561$default$toSizeXkaWNTQ(density, j);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m6581toDpSizekrfVVM(Density density, long j) {
            return CC.m6558$default$toDpSizekrfVVM(density, j);
        }
    }

    /* renamed from: androidx.compose.ui.unit.Density$-CC  reason: invalid class name */
    /* compiled from: Density.kt */
    public final /* synthetic */ class CC {
        /* renamed from: $default$toPx-0680j_4  reason: not valid java name */
        public static float m6560$default$toPx0680j_4(Density _this, float f) {
            return f * _this.getDensity();
        }

        /* renamed from: $default$roundToPx-0680j_4  reason: not valid java name */
        public static int m6555$default$roundToPx0680j_4(Density _this, float f) {
            float r2 = _this.m6550toPx0680j_4(f);
            if (Float.isInfinite(r2)) {
                return Integer.MAX_VALUE;
            }
            return MathKt.roundToInt(r2);
        }

        /* renamed from: $default$toPx--R2X_6o  reason: not valid java name */
        public static float m6559$default$toPxR2X_6o(Density _this, long j) {
            if (TextUnitType.m6839equalsimpl0(TextUnit.m6810getTypeUIouoOA(j), TextUnitType.Companion.m6844getSpUIouoOA())) {
                return _this.m6550toPx0680j_4(_this.m6723toDpGaN1DYA(j));
            }
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }

        /* renamed from: $default$roundToPx--R2X_6o  reason: not valid java name */
        public static int m6554$default$roundToPxR2X_6o(Density _this, long j) {
            return MathKt.roundToInt(_this.m6549toPxR2X_6o(j));
        }

        /* renamed from: $default$toDp-u2uoSUM  reason: not valid java name */
        public static float m6557$default$toDpu2uoSUM(Density _this, int i) {
            return Dp.m6614constructorimpl(((float) i) / _this.getDensity());
        }

        /* renamed from: $default$toSp-kPz2Gy4  reason: not valid java name */
        public static long m6563$default$toSpkPz2Gy4(Density _this, int i) {
            return _this.m6724toSp0xMU5do(_this.m6547toDpu2uoSUM(i));
        }

        /* renamed from: $default$toDp-u2uoSUM  reason: not valid java name */
        public static float m6556$default$toDpu2uoSUM(Density _this, float f) {
            return Dp.m6614constructorimpl(f / _this.getDensity());
        }

        /* renamed from: $default$toSp-kPz2Gy4  reason: not valid java name */
        public static long m6562$default$toSpkPz2Gy4(Density _this, float f) {
            return _this.m6724toSp0xMU5do(_this.m6546toDpu2uoSUM(f));
        }

        public static Rect $default$toRect(Density _this, DpRect dpRect) {
            return new Rect(_this.m6550toPx0680j_4(dpRect.m6697getLeftD9Ej5fM()), _this.m6550toPx0680j_4(dpRect.m6699getTopD9Ej5fM()), _this.m6550toPx0680j_4(dpRect.m6698getRightD9Ej5fM()), _this.m6550toPx0680j_4(dpRect.m6696getBottomD9Ej5fM()));
        }

        /* renamed from: $default$toSize-XkaWNTQ  reason: not valid java name */
        public static long m6561$default$toSizeXkaWNTQ(Density _this, long j) {
            if (j != DpSize.Companion.m6721getUnspecifiedMYxV2XQ()) {
                return SizeKt.Size(_this.m6550toPx0680j_4(DpSize.m6712getWidthD9Ej5fM(j)), _this.m6550toPx0680j_4(DpSize.m6710getHeightD9Ej5fM(j)));
            }
            return Size.Companion.m3639getUnspecifiedNHjbRc();
        }

        /* renamed from: $default$toDpSize-k-rfVVM  reason: not valid java name */
        public static long m6558$default$toDpSizekrfVVM(Density _this, long j) {
            if (j != Size.Companion.m3639getUnspecifiedNHjbRc()) {
                return DpKt.m6636DpSizeYgX7TsA(_this.m6546toDpu2uoSUM(Size.m3631getWidthimpl(j)), _this.m6546toDpu2uoSUM(Size.m3628getHeightimpl(j)));
            }
            return DpSize.Companion.m6721getUnspecifiedMYxV2XQ();
        }
    }
}
