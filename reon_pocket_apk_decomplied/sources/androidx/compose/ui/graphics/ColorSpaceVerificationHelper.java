package androidx.compose.ui.graphics;

import android.graphics.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.graphics.colorspace.TransferParameters;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import androidx.compose.ui.platform.RenderNodeApi29$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/graphics/ColorSpaceVerificationHelper;", "", "()V", "androidColorSpace", "Landroid/graphics/ColorSpace;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "composeColorSpace", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidColorSpace.android.kt */
final class ColorSpaceVerificationHelper {
    public static final ColorSpaceVerificationHelper INSTANCE = new ColorSpaceVerificationHelper();

    private ColorSpaceVerificationHelper() {
    }

    @JvmStatic
    public static final ColorSpace androidColorSpace(androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace) {
        ColorSpace.Rgb.TransferParameters transferParameters;
        ColorSpace.Rgb rgb;
        androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace2 = colorSpace;
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getSrgb())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$5());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getAces())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(ColorSpace.Named.ACES);
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getAcescg())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getAdobeRgb())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getBt2020())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$2());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getBt709())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$6());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getCieLab())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$8());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getCieXyz())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$9());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getDciP3())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$10());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getDisplayP3())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$11());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getExtendedSrgb())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$3());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getLinearExtendedSrgb())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$4());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getLinearSrgb())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$7());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getNtsc1953())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$12());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getProPhotoRgb())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m());
        }
        if (Intrinsics.areEqual((Object) colorSpace2, (Object) ColorSpaces.INSTANCE.getSmpteC())) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(ColorSpace.Named.SMPTE_C);
        }
        if (!(colorSpace2 instanceof Rgb)) {
            return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$5());
        }
        Rgb rgb2 = (Rgb) colorSpace2;
        float[] xyz$ui_graphics_release = rgb2.getWhitePoint().toXyz$ui_graphics_release();
        TransferParameters transferParameters2 = rgb2.getTransferParameters();
        if (transferParameters2 != null) {
            Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1();
            transferParameters = RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m(transferParameters2.getA(), transferParameters2.getB(), transferParameters2.getC(), transferParameters2.getD(), transferParameters2.getE(), transferParameters2.getF(), transferParameters2.getGamma());
        } else {
            transferParameters = null;
        }
        if (transferParameters != null) {
            Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$2();
            rgb = Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(colorSpace.getName(), rgb2.getPrimaries$ui_graphics_release(), xyz$ui_graphics_release, transferParameters);
        } else {
            Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$2();
            rgb = Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(colorSpace.getName(), rgb2.getPrimaries$ui_graphics_release(), xyz$ui_graphics_release, new ColorSpaceVerificationHelper$$ExternalSyntheticLambda45(rgb2.getOetf()), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda46(rgb2.getEotf()), colorSpace2.getMinValue(0), colorSpace2.getMaxValue(0));
        }
        return RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m((Object) rgb);
    }

    /* access modifiers changed from: private */
    public static final double androidColorSpace$lambda$0(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* access modifiers changed from: private */
    public static final double androidColorSpace$lambda$1(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    @JvmStatic
    public static final androidx.compose.ui.graphics.colorspace.ColorSpace composeColorSpace(ColorSpace colorSpace) {
        Rgb rgb;
        WhitePoint whitePoint;
        TransferParameters transferParameters;
        ColorSpace colorSpace2 = colorSpace;
        int m = colorSpace.getId();
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$5())) {
            return ColorSpaces.INSTANCE.getSrgb();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(ColorSpace.Named.ACES)) {
            return ColorSpaces.INSTANCE.getAces();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m())) {
            return ColorSpaces.INSTANCE.getAcescg();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1())) {
            return ColorSpaces.INSTANCE.getAdobeRgb();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$2())) {
            return ColorSpaces.INSTANCE.getBt2020();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$6())) {
            return ColorSpaces.INSTANCE.getBt709();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$8())) {
            return ColorSpaces.INSTANCE.getCieLab();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$9())) {
            return ColorSpaces.INSTANCE.getCieXyz();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$10())) {
            return ColorSpaces.INSTANCE.getDciP3();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$11())) {
            return ColorSpaces.INSTANCE.getDisplayP3();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$3())) {
            return ColorSpaces.INSTANCE.getExtendedSrgb();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$4())) {
            return ColorSpaces.INSTANCE.getLinearExtendedSrgb();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$7())) {
            return ColorSpaces.INSTANCE.getLinearSrgb();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$12())) {
            return ColorSpaces.INSTANCE.getNtsc1953();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(RenderNodeApi29$$ExternalSyntheticApiModelOutline0.m())) {
            return ColorSpaces.INSTANCE.getProPhotoRgb();
        }
        if (m == Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(ColorSpace.Named.SMPTE_C)) {
            return ColorSpaces.INSTANCE.getSmpteC();
        }
        if (Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1((Object) colorSpace)) {
            ColorSpace.Rgb.TransferParameters m2 = Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace));
            if (Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace)).length == 3) {
                whitePoint = new WhitePoint(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace))[0], Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace))[1], Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace))[2]);
            } else {
                whitePoint = new WhitePoint(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace))[0], Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace))[1]);
            }
            WhitePoint whitePoint2 = whitePoint;
            if (m2 != null) {
                transferParameters = new TransferParameters(m2.g, m2.a, m2.b, m2.c, m2.d, m2.e, m2.f);
            } else {
                transferParameters = null;
            }
            rgb = new Rgb(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace)), Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace)), whitePoint2, Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace).getTransform(), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda47(colorSpace2), new ColorSpaceVerificationHelper$$ExternalSyntheticLambda48(colorSpace2), colorSpace2.getMinValue(0), colorSpace2.getMaxValue(0), transferParameters, Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace)));
        } else {
            rgb = ColorSpaces.INSTANCE.getSrgb();
        }
        return rgb;
    }

    /* access modifiers changed from: private */
    public static final double composeColorSpace$lambda$2(ColorSpace colorSpace, double d) {
        return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m$1(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace)).applyAsDouble(d);
    }

    /* access modifiers changed from: private */
    public static final double composeColorSpace$lambda$3(ColorSpace colorSpace, double d) {
        return Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(Api26Bitmap$$ExternalSyntheticApiModelOutline0.m((Object) colorSpace)).applyAsDouble(d);
    }
}
