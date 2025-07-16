package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.colorspace.Connector;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a8\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0011H\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\nH\u0000\u001a\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0000\u001a\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0000\u001a\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0000\u001a\u0018\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0000\u001a(\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0000\u001a(\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0000\u001a(\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0000\u001a8\u0010 \u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001aH\u0010 \u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a8\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001aH\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0000\u001a\u001e\u0010$\u001a\u00020%*\u00020%2\u0006\u0010&\u001a\u00020\u00112\b\b\u0002\u0010'\u001a\u00020(H\u0007\u001a(\u0010)\u001a\u00020**\u00020%2\b\b\u0002\u0010+\u001a\u00020%2\b\b\u0002\u0010,\u001a\u00020-ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"absRcpResponse", "", "x", "a", "b", "c", "d", "g", "absResponse", "chromaticAdaptation", "", "matrix", "srcWhitePoint", "dstWhitePoint", "compare", "", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "inverse3x3", "m", "mul3x3", "lhs", "rhs", "mul3x3Diag", "mul3x3Float3", "mul3x3Float3_0", "", "r0", "r1", "r2", "mul3x3Float3_1", "mul3x3Float3_2", "rcpResponse", "e", "f", "response", "adapt", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "whitePoint", "adaptation", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "connect", "Landroidx/compose/ui/graphics/colorspace/Connector;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "connect-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)Landroidx/compose/ui/graphics/colorspace/Connector;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ColorSpace.kt */
public final class ColorSpaceKt {
    public static final ColorSpace adapt(ColorSpace colorSpace, WhitePoint whitePoint) {
        return adapt$default(colorSpace, whitePoint, (Adaptation) null, 2, (Object) null);
    }

    /* renamed from: connect-YBCOT_4$default  reason: not valid java name */
    public static /* synthetic */ Connector m4297connectYBCOT_4$default(ColorSpace colorSpace, ColorSpace colorSpace2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            colorSpace2 = ColorSpaces.INSTANCE.getSrgb();
        }
        if ((i2 & 2) != 0) {
            i = RenderIntent.Companion.m4315getPerceptualuksYyKA();
        }
        return m4296connectYBCOT_4(colorSpace, colorSpace2, i);
    }

    /* renamed from: connect-YBCOT_4  reason: not valid java name */
    public static final Connector m4296connectYBCOT_4(ColorSpace colorSpace, ColorSpace colorSpace2, int i) {
        if (colorSpace == ColorSpaces.INSTANCE.getSrgb()) {
            if (colorSpace2 == ColorSpaces.INSTANCE.getSrgb()) {
                return Connector.Companion.getSrgbIdentity$ui_graphics_release();
            }
            if (colorSpace2 == ColorSpaces.INSTANCE.getOklab() && RenderIntent.m4310equalsimpl0(i, RenderIntent.Companion.m4315getPerceptualuksYyKA())) {
                return Connector.Companion.getSrgbToOklabPerceptual$ui_graphics_release();
            }
        } else if (colorSpace == ColorSpaces.INSTANCE.getOklab() && colorSpace2 == ColorSpaces.INSTANCE.getSrgb() && RenderIntent.m4310equalsimpl0(i, RenderIntent.Companion.m4315getPerceptualuksYyKA())) {
            return Connector.Companion.getOklabToSrgbPerceptual$ui_graphics_release();
        }
        if (colorSpace == colorSpace2) {
            return Connector.Companion.identity$ui_graphics_release(colorSpace);
        }
        if (!ColorModel.m4285equalsimpl0(colorSpace.m4294getModelxdoWZVw(), ColorModel.Companion.m4292getRgbxdoWZVw()) || !ColorModel.m4285equalsimpl0(colorSpace2.m4294getModelxdoWZVw(), ColorModel.Companion.m4292getRgbxdoWZVw())) {
            return new Connector(colorSpace, colorSpace2, i, (DefaultConstructorMarker) null);
        }
        Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Intrinsics.checkNotNull(colorSpace2, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        return new Connector.RgbConnector((Rgb) colorSpace, (Rgb) colorSpace2, i, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ColorSpace adapt$default(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation, int i, Object obj) {
        if ((i & 2) != 0) {
            adaptation = Adaptation.Companion.getBradford();
        }
        return adapt(colorSpace, whitePoint, adaptation);
    }

    public static final ColorSpace adapt(ColorSpace colorSpace, WhitePoint whitePoint, Adaptation adaptation) {
        if (!ColorModel.m4285equalsimpl0(colorSpace.m4294getModelxdoWZVw(), ColorModel.Companion.m4292getRgbxdoWZVw())) {
            return colorSpace;
        }
        Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        Rgb rgb = (Rgb) colorSpace;
        if (compare(rgb.getWhitePoint(), whitePoint)) {
            return colorSpace;
        }
        return new Rgb(rgb, mul3x3(chromaticAdaptation(adaptation.getTransform$ui_graphics_release(), rgb.getWhitePoint().toXyz$ui_graphics_release(), whitePoint.toXyz$ui_graphics_release()), rgb.getTransform$ui_graphics_release()), whitePoint);
    }

    public static final double rcpResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= d5 * d4 ? (Math.pow(d, 1.0d / d6) - d3) / d2 : d / d4;
    }

    public static final double response(double d, double d2, double d3, double d4, double d5, double d6) {
        return d >= d5 ? Math.pow((d2 * d) + d3, d6) : d * d4;
    }

    public static final double rcpResponse(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= d5 * d4 ? (Math.pow(d - d6, 1.0d / d8) - d3) / d2 : (d - d7) / d4;
    }

    public static final double response(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        return d >= d5 ? Math.pow((d2 * d) + d3, d8) + d6 : (d4 * d) + d7;
    }

    public static final double absRcpResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d;
        return Math.copySign(rcpResponse(d7 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -d7 : d7, d2, d3, d4, d5, d6), d7);
    }

    public static final double absResponse(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d;
        return Math.copySign(response(d7 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -d7 : d7, d2, d3, d4, d5, d6), d7);
    }

    public static final boolean compare(TransferParameters transferParameters, TransferParameters transferParameters2) {
        return transferParameters2 != null && Math.abs(transferParameters.getA() - transferParameters2.getA()) < 0.001d && Math.abs(transferParameters.getB() - transferParameters2.getB()) < 0.001d && Math.abs(transferParameters.getC() - transferParameters2.getC()) < 0.001d && Math.abs(transferParameters.getD() - transferParameters2.getD()) < 0.002d && Math.abs(transferParameters.getE() - transferParameters2.getE()) < 0.001d && Math.abs(transferParameters.getF() - transferParameters2.getF()) < 0.001d && Math.abs(transferParameters.getGamma() - transferParameters2.getGamma()) < 0.001d;
    }

    public static final boolean compare(WhitePoint whitePoint, WhitePoint whitePoint2) {
        if (whitePoint == whitePoint2) {
            return true;
        }
        return Math.abs(whitePoint.getX() - whitePoint2.getX()) < 0.001f && Math.abs(whitePoint.getY() - whitePoint2.getY()) < 0.001f;
    }

    public static final boolean compare(float[] fArr, float[] fArr2) {
        if (fArr == fArr2) {
            return true;
        }
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (Float.compare(fArr[i], fArr2[i]) != 0 && Math.abs(fArr[i] - fArr2[i]) > 0.001f) {
                return false;
            }
        }
        return true;
    }

    public static final float[] inverse3x3(float[] fArr) {
        float[] fArr2 = fArr;
        float f = fArr2[0];
        float f2 = fArr2[3];
        float f3 = fArr2[6];
        float f4 = fArr2[1];
        float f5 = fArr2[4];
        float f6 = fArr2[7];
        float f7 = fArr2[2];
        float f8 = fArr2[5];
        float f9 = fArr2[8];
        float f10 = (f5 * f9) - (f6 * f8);
        float f11 = (f6 * f7) - (f4 * f9);
        float f12 = (f4 * f8) - (f5 * f7);
        float f13 = (f * f10) + (f2 * f11) + (f3 * f12);
        float[] fArr3 = new float[fArr2.length];
        fArr3[0] = f10 / f13;
        fArr3[1] = f11 / f13;
        fArr3[2] = f12 / f13;
        fArr3[3] = ((f3 * f8) - (f2 * f9)) / f13;
        fArr3[4] = ((f9 * f) - (f3 * f7)) / f13;
        fArr3[5] = ((f7 * f2) - (f8 * f)) / f13;
        fArr3[6] = ((f2 * f6) - (f3 * f5)) / f13;
        fArr3[7] = ((f3 * f4) - (f6 * f)) / f13;
        fArr3[8] = ((f * f5) - (f2 * f4)) / f13;
        return fArr3;
    }

    public static final float[] mul3x3(float[] fArr, float[] fArr2) {
        float f = fArr[0];
        float f2 = fArr2[0];
        float f3 = fArr[3];
        float f4 = fArr2[1];
        float f5 = fArr[6];
        float f6 = fArr2[2];
        float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
        float f8 = fArr[1];
        float f9 = fArr[4];
        float f10 = fArr[7];
        float f11 = (f8 * f2) + (f9 * f4) + (f10 * f6);
        float f12 = fArr[2];
        float f13 = fArr[5];
        float f14 = fArr[8];
        float f15 = (f2 * f12) + (f4 * f13) + (f6 * f14);
        float f16 = fArr2[3];
        float f17 = fArr2[4];
        float f18 = fArr2[5];
        float f19 = (f * f16) + (f3 * f17) + (f5 * f18);
        float f20 = (f16 * f12) + (f17 * f13) + (f18 * f14);
        float f21 = fArr2[6];
        float f22 = fArr2[7];
        float f23 = (f * f21) + (f3 * f22);
        float f24 = fArr2[8];
        return new float[]{f7, f11, f15, f19, (f8 * f16) + (f9 * f17) + (f10 * f18), f20, f23 + (f5 * f24), (f8 * f21) + (f9 * f22) + (f10 * f24), (f12 * f21) + (f13 * f22) + (f14 * f24)};
    }

    public static final float[] mul3x3Float3(float[] fArr, float[] fArr2) {
        float f = fArr2[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        fArr2[0] = (fArr[0] * f) + (fArr[3] * f2) + (fArr[6] * f3);
        fArr2[1] = (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f3);
        fArr2[2] = (fArr[2] * f) + (fArr[5] * f2) + (fArr[8] * f3);
        return fArr2;
    }

    public static final float mul3x3Float3_0(float[] fArr, float f, float f2, float f3) {
        return (fArr[0] * f) + (fArr[3] * f2) + (fArr[6] * f3);
    }

    public static final float mul3x3Float3_1(float[] fArr, float f, float f2, float f3) {
        return (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f3);
    }

    public static final float mul3x3Float3_2(float[] fArr, float f, float f2, float f3) {
        return (fArr[2] * f) + (fArr[5] * f2) + (fArr[8] * f3);
    }

    public static final float[] mul3x3Diag(float[] fArr, float[] fArr2) {
        float f = fArr[0];
        float f2 = fArr2[0] * f;
        float f3 = fArr[1];
        float f4 = fArr2[1] * f3;
        float f5 = fArr[2];
        return new float[]{f2, f4, fArr2[2] * f5, fArr2[3] * f, fArr2[4] * f3, fArr2[5] * f5, f * fArr2[6], f3 * fArr2[7], f5 * fArr2[8]};
    }

    public static final float[] chromaticAdaptation(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] mul3x3Float3 = mul3x3Float3(fArr, fArr2);
        float[] mul3x3Float32 = mul3x3Float3(fArr, fArr3);
        return mul3x3(inverse3x3(fArr), mul3x3Diag(new float[]{mul3x3Float32[0] / mul3x3Float3[0], mul3x3Float32[1] / mul3x3Float3[1], mul3x3Float32[2] / mul3x3Float3[2]}, fArr));
    }
}
