package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u001f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020\fH\u0017J5\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector;", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "transformSource", "transformDestination", "renderIntent", "transform", "", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I[FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDestination", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getRenderIntent-uksYyKA", "()I", "I", "getSource", "r", "", "g", "b", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "a", "transformToColor-wmQWz5c$ui_graphics_release", "(FFFF)J", "Companion", "RgbConnector", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Connector.kt */
public class Connector {
    public static final Companion Companion;
    /* access modifiers changed from: private */
    public static final Connector OklabToSrgbPerceptual = new Connector(ColorSpaces.INSTANCE.getOklab(), ColorSpaces.INSTANCE.getSrgb(), RenderIntent.Companion.m4315getPerceptualuksYyKA(), (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Connector SrgbIdentity;
    /* access modifiers changed from: private */
    public static final Connector SrgbToOklabPerceptual = new Connector(ColorSpaces.INSTANCE.getSrgb(), ColorSpaces.INSTANCE.getOklab(), RenderIntent.Companion.m4315getPerceptualuksYyKA(), (DefaultConstructorMarker) null);
    private final ColorSpace destination;
    private final int renderIntent;
    private final ColorSpace source;
    private final float[] transform;
    private final ColorSpace transformDestination;
    private final ColorSpace transformSource;

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, i);
    }

    public /* synthetic */ Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i, float[] fArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(colorSpace, colorSpace2, colorSpace3, colorSpace4, i, fArr);
    }

    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, ColorSpace colorSpace3, ColorSpace colorSpace4, int i, float[] fArr) {
        this.source = colorSpace;
        this.destination = colorSpace2;
        this.transformSource = colorSpace3;
        this.transformDestination = colorSpace4;
        this.renderIntent = i;
        this.transform = fArr;
    }

    public final ColorSpace getSource() {
        return this.source;
    }

    public final ColorSpace getDestination() {
        return this.destination;
    }

    /* renamed from: getRenderIntent-uksYyKA  reason: not valid java name */
    public final int m4298getRenderIntentuksYyKA() {
        return this.renderIntent;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private Connector(ColorSpace colorSpace, ColorSpace colorSpace2, int i) {
        this(colorSpace, colorSpace2, ColorModel.m4285equalsimpl0(colorSpace.m4294getModelxdoWZVw(), ColorModel.Companion.m4292getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace, Illuminant.INSTANCE.getD50(), (Adaptation) null, 2, (Object) null) : colorSpace, ColorModel.m4285equalsimpl0(colorSpace2.m4294getModelxdoWZVw(), ColorModel.Companion.m4292getRgbxdoWZVw()) ? ColorSpaceKt.adapt$default(colorSpace2, Illuminant.INSTANCE.getD50(), (Adaptation) null, 2, (Object) null) : colorSpace2, i, Companion.m4301computeTransformYBCOT_4(colorSpace, colorSpace2, i), (DefaultConstructorMarker) null);
    }

    public final float[] transform(float f, float f2, float f3) {
        return transform(new float[]{f, f2, f3});
    }

    public float[] transform(float[] fArr) {
        float[] xyz = this.transformSource.toXyz(fArr);
        float[] fArr2 = this.transform;
        if (fArr2 != null) {
            xyz[0] = xyz[0] * fArr2[0];
            xyz[1] = xyz[1] * fArr2[1];
            xyz[2] = xyz[2] * fArr2[2];
        }
        return this.transformDestination.fromXyz(xyz);
    }

    /* renamed from: transformToColor-wmQWz5c$ui_graphics_release  reason: not valid java name */
    public long m4299transformToColorwmQWz5c$ui_graphics_release(float f, float f2, float f3, float f4) {
        long xy$ui_graphics_release = this.transformSource.toXy$ui_graphics_release(f, f2, f3);
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        float intBitsToFloat = Float.intBitsToFloat((int) (xy$ui_graphics_release >> 32));
        FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (xy$ui_graphics_release & 4294967295L));
        float z$ui_graphics_release = this.transformSource.toZ$ui_graphics_release(f, f2, f3);
        float[] fArr = this.transform;
        if (fArr != null) {
            intBitsToFloat *= fArr[0];
            intBitsToFloat2 *= fArr[1];
            z$ui_graphics_release *= fArr[2];
        }
        float f5 = intBitsToFloat2;
        float f6 = intBitsToFloat;
        return this.transformDestination.m4295xyzaToColorJlNiLsg$ui_graphics_release(f6, f5, z$ui_graphics_release, f4, this.destination);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J*\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J5\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0014H\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$RgbConnector;", "Landroidx/compose/ui/graphics/colorspace/Connector;", "mSource", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "mDestination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "mTransform", "", "computeTransform", "source", "destination", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/Rgb;Landroidx/compose/ui/graphics/colorspace/Rgb;I)[F", "transform", "v", "transformToColor", "Landroidx/compose/ui/graphics/Color;", "r", "", "g", "b", "a", "transformToColor-wmQWz5c$ui_graphics_release", "(FFFF)J", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Connector.kt */
    public static final class RgbConnector extends Connector {
        private final Rgb mDestination;
        private final Rgb mSource;
        private final float[] mTransform;

        public /* synthetic */ RgbConnector(Rgb rgb, Rgb rgb2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(rgb, rgb2, i);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private RgbConnector(androidx.compose.ui.graphics.colorspace.Rgb r9, androidx.compose.ui.graphics.colorspace.Rgb r10, int r11) {
            /*
                r8 = this;
                r3 = r9
                androidx.compose.ui.graphics.colorspace.ColorSpace r3 = (androidx.compose.ui.graphics.colorspace.ColorSpace) r3
                r4 = r10
                androidx.compose.ui.graphics.colorspace.ColorSpace r4 = (androidx.compose.ui.graphics.colorspace.ColorSpace) r4
                r6 = 0
                r7 = 0
                r0 = r8
                r1 = r3
                r2 = r4
                r5 = r11
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                r8.mSource = r9
                r8.mDestination = r10
                float[] r9 = r8.m4303computeTransformYBCOT_4(r9, r10, r11)
                r8.mTransform = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Connector.RgbConnector.<init>(androidx.compose.ui.graphics.colorspace.Rgb, androidx.compose.ui.graphics.colorspace.Rgb, int):void");
        }

        public float[] transform(float[] fArr) {
            fArr[0] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) fArr[0]);
            fArr[1] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) fArr[1]);
            fArr[2] = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) fArr[2]);
            ColorSpaceKt.mul3x3Float3(this.mTransform, fArr);
            fArr[0] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) fArr[0]);
            fArr[1] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) fArr[1]);
            fArr[2] = (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) fArr[2]);
            return fArr;
        }

        /* renamed from: transformToColor-wmQWz5c$ui_graphics_release  reason: not valid java name */
        public long m4304transformToColorwmQWz5c$ui_graphics_release(float f, float f2, float f3, float f4) {
            float invoke = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) f);
            float invoke2 = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) f2);
            float invoke3 = (float) this.mSource.getEotfFunc$ui_graphics_release().invoke((double) f3);
            return ColorKt.Color((float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) ColorSpaceKt.mul3x3Float3_0(this.mTransform, invoke, invoke2, invoke3)), (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) ColorSpaceKt.mul3x3Float3_1(this.mTransform, invoke, invoke2, invoke3)), (float) this.mDestination.getOetfFunc$ui_graphics_release().invoke((double) ColorSpaceKt.mul3x3Float3_2(this.mTransform, invoke, invoke2, invoke3)), f4, this.mDestination);
        }

        /* renamed from: computeTransform-YBCOT_4  reason: not valid java name */
        private final float[] m4303computeTransformYBCOT_4(Rgb rgb, Rgb rgb2, int i) {
            if (ColorSpaceKt.compare(rgb.getWhitePoint(), rgb2.getWhitePoint())) {
                return ColorSpaceKt.mul3x3(rgb2.getInverseTransform$ui_graphics_release(), rgb.getTransform$ui_graphics_release());
            }
            float[] transform$ui_graphics_release = rgb.getTransform$ui_graphics_release();
            float[] inverseTransform$ui_graphics_release = rgb2.getInverseTransform$ui_graphics_release();
            float[] xyz$ui_graphics_release = rgb.getWhitePoint().toXyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = rgb2.getWhitePoint().toXyz$ui_graphics_release();
            if (!ColorSpaceKt.compare(rgb.getWhitePoint(), Illuminant.INSTANCE.getD50())) {
                float[] transform$ui_graphics_release2 = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
                float[] d50Xyz$ui_graphics_release = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
                float[] copyOf = Arrays.copyOf(d50Xyz$ui_graphics_release, d50Xyz$ui_graphics_release.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                transform$ui_graphics_release = ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release2, xyz$ui_graphics_release, copyOf), rgb.getTransform$ui_graphics_release());
            }
            if (!ColorSpaceKt.compare(rgb2.getWhitePoint(), Illuminant.INSTANCE.getD50())) {
                float[] transform$ui_graphics_release3 = Adaptation.Companion.getBradford().getTransform$ui_graphics_release();
                float[] d50Xyz$ui_graphics_release2 = Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
                float[] copyOf2 = Arrays.copyOf(d50Xyz$ui_graphics_release2, d50Xyz$ui_graphics_release2.length);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, size)");
                inverseTransform$ui_graphics_release = ColorSpaceKt.inverse3x3(ColorSpaceKt.mul3x3(ColorSpaceKt.chromaticAdaptation(transform$ui_graphics_release3, xyz$ui_graphics_release2, copyOf2), rgb2.getTransform$ui_graphics_release()));
            }
            if (RenderIntent.m4310equalsimpl0(i, RenderIntent.Companion.m4314getAbsoluteuksYyKA())) {
                transform$ui_graphics_release = ColorSpaceKt.mul3x3Diag(new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]}, transform$ui_graphics_release);
            }
            return ColorSpaceKt.mul3x3(inverseTransform$ui_graphics_release, transform$ui_graphics_release);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0015R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Connector$Companion;", "", "()V", "OklabToSrgbPerceptual", "Landroidx/compose/ui/graphics/colorspace/Connector;", "getOklabToSrgbPerceptual$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/Connector;", "SrgbIdentity", "getSrgbIdentity$ui_graphics_release", "SrgbToOklabPerceptual", "getSrgbToOklabPerceptual$ui_graphics_release", "computeTransform", "", "source", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "computeTransform-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)[F", "identity", "identity$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Connector.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: computeTransform-YBCOT_4  reason: not valid java name */
        public final float[] m4301computeTransformYBCOT_4(ColorSpace colorSpace, ColorSpace colorSpace2, int i) {
            if (!RenderIntent.m4310equalsimpl0(i, RenderIntent.Companion.m4314getAbsoluteuksYyKA())) {
                return null;
            }
            boolean r8 = ColorModel.m4285equalsimpl0(colorSpace.m4294getModelxdoWZVw(), ColorModel.Companion.m4292getRgbxdoWZVw());
            boolean r1 = ColorModel.m4285equalsimpl0(colorSpace2.m4294getModelxdoWZVw(), ColorModel.Companion.m4292getRgbxdoWZVw());
            if (r8 && r1) {
                return null;
            }
            if (!r8 && !r1) {
                return null;
            }
            if (!r8) {
                colorSpace = colorSpace2;
            }
            Intrinsics.checkNotNull(colorSpace, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            Rgb rgb = (Rgb) colorSpace;
            float[] xyz$ui_graphics_release = r8 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            float[] xyz$ui_graphics_release2 = r1 ? rgb.getWhitePoint().toXyz$ui_graphics_release() : Illuminant.INSTANCE.getD50Xyz$ui_graphics_release();
            return new float[]{xyz$ui_graphics_release[0] / xyz$ui_graphics_release2[0], xyz$ui_graphics_release[1] / xyz$ui_graphics_release2[1], xyz$ui_graphics_release[2] / xyz$ui_graphics_release2[2]};
        }

        public final Connector identity$ui_graphics_release(ColorSpace colorSpace) {
            return new Connector$Companion$identity$1(colorSpace, RenderIntent.Companion.m4316getRelativeuksYyKA());
        }

        public final Connector getSrgbIdentity$ui_graphics_release() {
            return Connector.SrgbIdentity;
        }

        public final Connector getSrgbToOklabPerceptual$ui_graphics_release() {
            return Connector.SrgbToOklabPerceptual;
        }

        public final Connector getOklabToSrgbPerceptual$ui_graphics_release() {
            return Connector.OklabToSrgbPerceptual;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        SrgbIdentity = companion.identity$ui_graphics_release(ColorSpaces.INSTANCE.getSrgb());
    }
}
