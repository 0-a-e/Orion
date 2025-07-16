package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ^2\u00020\u0001:\u0001^BC\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nB[\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011B#\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014B+\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015B/\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018B#\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001aB+\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b¢\u0006\u0002\u0010\u001bB?\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001cB\u001f\b\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0000\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u001fB[\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020 \u0012\u0006\u0010\t\u001a\u00020 \u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\"J\u0013\u0010<\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J \u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0007J\u0012\u0010?\u001a\u00020\u00052\b\b\u0001\u0010C\u001a\u00020\u0005H\u0007J\u0010\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J\b\u0010E\u001a\u00020\u0005H\u0007J\u0012\u0010E\u001a\u00020\u00052\b\b\u0001\u0010*\u001a\u00020\u0005H\u0007J\u0010\u0010F\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0017H\u0016J\u0010\u0010H\u001a\u00020\u000f2\u0006\u0010G\u001a\u00020\u0017H\u0016J\b\u0010I\u001a\u00020\u0005H\u0007J\u0012\u0010I\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u0005H\u0007J\b\u0010J\u001a\u00020\u0005H\u0007J\u0012\u0010J\u001a\u00020\u00052\b\b\u0001\u0010\u001e\u001a\u00020\u0005H\u0007J\b\u0010K\u001a\u00020\u0017H\u0016J \u0010L\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0007J\u0012\u0010L\u001a\u00020\u00052\b\b\u0001\u0010C\u001a\u00020\u0005H\u0007J%\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0010¢\u0006\u0002\bRJ\u0010\u0010S\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0016J%\u0010T\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u000fH\u0010¢\u0006\u0002\bUJ=\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0001H\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\\\u0010]R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010/R\u0014\u00100\u001a\u00020.X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0014\u00102\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010'R\u0014\u00104\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010'R\u0014\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0013\u0010!\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0014\u0010\u001e\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010,R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006_"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "toXYZ", "", "oetf", "Lkotlin/Function1;", "", "eotf", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "primaries", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "min", "", "max", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "id", "", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "transform", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "transferParameters", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLandroidx/compose/ui/graphics/colorspace/DoubleFunction;Landroidx/compose/ui/graphics/colorspace/DoubleFunction;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "getEotf", "()Lkotlin/jvm/functions/Function1;", "eotfFunc", "getEotfFunc$ui_graphics_release", "()Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "eotfOrig", "getEotfOrig$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "()[F", "isSrgb", "", "()Z", "isWideGamut", "getOetf", "oetfFunc", "getOetfFunc$ui_graphics_release", "oetfOrig", "getOetfOrig$ui_graphics_release", "getPrimaries$ui_graphics_release", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransform$ui_graphics_release", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "equals", "other", "", "fromLinear", "r", "g", "b", "v", "fromXyz", "getInverseTransform", "getMaxValue", "component", "getMinValue", "getPrimaries", "getTransform", "hashCode", "toLinear", "toXy", "", "v0", "v1", "v2", "toXy$ui_graphics_release", "toXyz", "toZ", "toZ$ui_graphics_release", "xyzaToColor", "Landroidx/compose/ui/graphics/Color;", "x", "y", "z", "a", "xyzaToColor-JlNiLsg$ui_graphics_release", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Rgb.kt */
public final class Rgb extends ColorSpace {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final DoubleFunction DoubleIdentity = new Rgb$$ExternalSyntheticLambda5();
    private final Function1<Double, Double> eotf;
    private final DoubleFunction eotfFunc;
    private final DoubleFunction eotfOrig;
    private final float[] inverseTransform;
    private final boolean isSrgb;
    private final boolean isWideGamut;
    /* access modifiers changed from: private */
    public final float max;
    /* access modifiers changed from: private */
    public final float min;
    private final Function1<Double, Double> oetf;
    private final DoubleFunction oetfFunc;
    private final DoubleFunction oetfOrig;
    private final float[] primaries;
    private final TransferParameters transferParameters;
    private final float[] transform;
    private final WhitePoint whitePoint;

    /* access modifiers changed from: private */
    public static final double DoubleIdentity$lambda$12(double d) {
        return d;
    }

    public final WhitePoint getWhitePoint() {
        return this.whitePoint;
    }

    public final TransferParameters getTransferParameters() {
        return this.transferParameters;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint2, float[] fArr2, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f, float f2, TransferParameters transferParameters2, int i) {
        super(str, ColorModel.Companion.m4292getRgbxdoWZVw(), i, (DefaultConstructorMarker) null);
        float[] fArr3 = fArr;
        WhitePoint whitePoint3 = whitePoint2;
        float[] fArr4 = fArr2;
        float f3 = f;
        float f4 = f2;
        this.whitePoint = whitePoint3;
        this.min = f3;
        this.max = f4;
        this.transferParameters = transferParameters2;
        this.oetfOrig = doubleFunction;
        this.oetf = new Rgb$oetf$1(this);
        this.oetfFunc = new Rgb$$ExternalSyntheticLambda0(this);
        this.eotfOrig = doubleFunction2;
        this.eotf = new Rgb$eotf$1(this);
        this.eotfFunc = new Rgb$$ExternalSyntheticLambda4(this);
        if (fArr3.length != 6 && fArr3.length != 9) {
            throw new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
        } else if (f3 < f4) {
            Companion companion = Companion;
            float[] access$xyPrimaries = companion.xyPrimaries(fArr3);
            this.primaries = access$xyPrimaries;
            if (fArr4 == null) {
                this.transform = companion.computeXYZMatrix(access$xyPrimaries, whitePoint3);
            } else if (fArr4.length == 9) {
                this.transform = fArr4;
            } else {
                throw new IllegalArgumentException("Transform must have 9 entries! Has " + fArr4.length);
            }
            this.inverseTransform = ColorSpaceKt.inverse3x3(this.transform);
            this.isWideGamut = companion.isWideGamut(access$xyPrimaries, f3, f4);
            this.isSrgb = companion.isSrgb(access$xyPrimaries, whitePoint2, doubleFunction, doubleFunction2, f, f2, i);
        } else {
            throw new IllegalArgumentException("Invalid range: min=" + f3 + ", max=" + f4 + "; min must be strictly < max");
        }
    }

    public final float[] getPrimaries$ui_graphics_release() {
        return this.primaries;
    }

    public final float[] getTransform$ui_graphics_release() {
        return this.transform;
    }

    public final float[] getInverseTransform$ui_graphics_release() {
        return this.inverseTransform;
    }

    public final DoubleFunction getOetfOrig$ui_graphics_release() {
        return this.oetfOrig;
    }

    public final Function1<Double, Double> getOetf() {
        return this.oetf;
    }

    public final DoubleFunction getOetfFunc$ui_graphics_release() {
        return this.oetfFunc;
    }

    /* access modifiers changed from: private */
    public static final double oetfFunc$lambda$0(Rgb rgb, double d) {
        return RangesKt.coerceIn(rgb.oetfOrig.invoke(d), (double) rgb.min, (double) rgb.max);
    }

    public final DoubleFunction getEotfOrig$ui_graphics_release() {
        return this.eotfOrig;
    }

    public final Function1<Double, Double> getEotf() {
        return this.eotf;
    }

    public final DoubleFunction getEotfFunc$ui_graphics_release() {
        return this.eotfFunc;
    }

    /* access modifiers changed from: private */
    public static final double eotfFunc$lambda$1(Rgb rgb, double d) {
        return rgb.eotfOrig.invoke(RangesKt.coerceIn(d, (double) rgb.min, (double) rgb.max));
    }

    public boolean isWideGamut() {
        return this.isWideGamut;
    }

    public boolean isSrgb() {
        return this.isSrgb;
    }

    public final float[] getPrimaries() {
        float[] fArr = this.primaries;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final float[] getTransform() {
        float[] fArr = this.transform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public final float[] getInverseTransform() {
        float[] fArr = this.inverseTransform;
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r14, float[] r15, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r16, kotlin.jvm.functions.Function1<? super java.lang.Double, java.lang.Double> r17) {
        /*
            r13 = this;
            r0 = r15
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r1 = Companion
            float[] r4 = r1.computePrimaries$ui_graphics_release(r15)
            androidx.compose.ui.graphics.colorspace.WhitePoint r5 = r1.computeWhitePoint(r15)
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda6 r7 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda6
            r0 = r16
            r7.<init>(r0)
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda7 r8 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda7
            r0 = r17
            r8.<init>(r0)
            r11 = 0
            r12 = -1
            r6 = 0
            r9 = 0
            r10 = 1065353216(0x3f800000, float:1.0)
            r2 = r13
            r3 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$2(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$3(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Rgb(String str, float[] fArr, WhitePoint whitePoint2, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12, float f, float f2) {
        this(str, fArr, whitePoint2, (float[]) null, new Rgb$$ExternalSyntheticLambda10(function1), new Rgb$$ExternalSyntheticLambda11(function12), f, f2, (TransferParameters) null, -1);
        Function1<? super Double, Double> function13 = function1;
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$4(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$5(Function1 function1, double d) {
        return ((Number) function1.invoke(Double.valueOf(d))).doubleValue();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r8, float[] r9, androidx.compose.ui.graphics.colorspace.TransferParameters r10) {
        /*
            r7 = this;
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r3 = r0.computePrimaries$ui_graphics_release(r9)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = r0.computeWhitePoint(r9)
            r6 = -1
            r1 = r7
            r2 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.TransferParameters):void");
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint2, TransferParameters transferParameters2) {
        this(str, fArr, whitePoint2, transferParameters2, -1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r12, float[] r13, androidx.compose.ui.graphics.colorspace.WhitePoint r14, androidx.compose.ui.graphics.colorspace.TransferParameters r15, int r16) {
        /*
            r11 = this;
            r9 = r15
            double r0 = r15.getE()
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0019
            double r0 = r15.getF()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0019
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda12 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda12
            r0.<init>(r15)
            goto L_0x001e
        L_0x0019:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda1 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda1
            r0.<init>(r15)
        L_0x001e:
            r5 = r0
            double r0 = r15.getE()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0035
            double r0 = r15.getF()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0035
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2
            r0.<init>(r15)
            goto L_0x003a
        L_0x0035:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda3
            r0.<init>(r15)
        L_0x003a:
            r6 = r0
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r9 = r15
            r10 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, androidx.compose.ui.graphics.colorspace.TransferParameters, int):void");
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$6(TransferParameters transferParameters2, double d) {
        return ColorSpaceKt.rcpResponse(d, transferParameters2.getA(), transferParameters2.getB(), transferParameters2.getC(), transferParameters2.getD(), transferParameters2.getGamma());
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$7(TransferParameters transferParameters2, double d) {
        return ColorSpaceKt.rcpResponse(d, transferParameters2.getA(), transferParameters2.getB(), transferParameters2.getC(), transferParameters2.getD(), transferParameters2.getE(), transferParameters2.getF(), transferParameters2.getGamma());
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$8(TransferParameters transferParameters2, double d) {
        return ColorSpaceKt.response(d, transferParameters2.getA(), transferParameters2.getB(), transferParameters2.getC(), transferParameters2.getD(), transferParameters2.getGamma());
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$9(TransferParameters transferParameters2, double d) {
        return ColorSpaceKt.response(d, transferParameters2.getA(), transferParameters2.getB(), transferParameters2.getC(), transferParameters2.getD(), transferParameters2.getE(), transferParameters2.getF(), transferParameters2.getGamma());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r11, float[] r12, double r13) {
        /*
            r10 = this;
            androidx.compose.ui.graphics.colorspace.Rgb$Companion r0 = Companion
            float[] r3 = r0.computePrimaries$ui_graphics_release(r12)
            androidx.compose.ui.graphics.colorspace.WhitePoint r4 = r0.computeWhitePoint(r12)
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = -1
            r7 = 0
            r1 = r10
            r2 = r11
            r5 = r13
            r1.<init>((java.lang.String) r2, (float[]) r3, (androidx.compose.ui.graphics.colorspace.WhitePoint) r4, (double) r5, (float) r7, (float) r8, (int) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], double):void");
    }

    public Rgb(String str, float[] fArr, WhitePoint whitePoint2, double d) {
        this(str, fArr, whitePoint2, d, 0.0f, 1.0f, -1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Rgb(java.lang.String r21, float[] r22, androidx.compose.ui.graphics.colorspace.WhitePoint r23, double r24, float r26, float r27, int r28) {
        /*
            r20 = this;
            r1 = r24
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x000b
            androidx.compose.ui.graphics.colorspace.DoubleFunction r3 = DoubleIdentity
            goto L_0x0010
        L_0x000b:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda8 r3 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda8
            r3.<init>(r1)
        L_0x0010:
            r17 = r3
            if (r0 != 0) goto L_0x0017
            androidx.compose.ui.graphics.colorspace.DoubleFunction r0 = DoubleIdentity
            goto L_0x001c
        L_0x0017:
            androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda9 r0 = new androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda9
            r0.<init>(r1)
        L_0x001c:
            r18 = r0
            androidx.compose.ui.graphics.colorspace.TransferParameters r19 = new androidx.compose.ui.graphics.colorspace.TransferParameters
            r0 = r19
            r15 = 96
            r16 = 0
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r1 = r24
            r0.<init>(r1, r3, r5, r7, r9, r11, r13, r15, r16)
            r8 = 0
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r23
            r9 = r17
            r10 = r18
            r11 = r26
            r12 = r27
            r13 = r19
            r14 = r28
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.colorspace.Rgb.<init>(java.lang.String, float[], androidx.compose.ui.graphics.colorspace.WhitePoint, double, float, float, int):void");
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$10(double d, double d2) {
        if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d2 = 0.0d;
        }
        return Math.pow(d2, 1.0d / d);
    }

    /* access modifiers changed from: private */
    public static final double _init_$lambda$11(double d, double d2) {
        if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d2 = 0.0d;
        }
        return Math.pow(d2, d);
    }

    public Rgb(Rgb rgb, float[] fArr, WhitePoint whitePoint2) {
        this(rgb.getName(), rgb.primaries, whitePoint2, fArr, rgb.oetfOrig, rgb.eotfOrig, rgb.min, rgb.max, rgb.transferParameters, -1);
    }

    public final float[] getPrimaries(float[] fArr) {
        return ArraysKt.copyInto$default(this.primaries, fArr, 0, 0, 0, 14, (Object) null);
    }

    public final float[] getTransform(float[] fArr) {
        return ArraysKt.copyInto$default(this.transform, fArr, 0, 0, 0, 14, (Object) null);
    }

    public final float[] getInverseTransform(float[] fArr) {
        return ArraysKt.copyInto$default(this.inverseTransform, fArr, 0, 0, 0, 14, (Object) null);
    }

    public float getMinValue(int i) {
        return this.min;
    }

    public float getMaxValue(int i) {
        return this.max;
    }

    public final float[] toLinear(float f, float f2, float f3) {
        return toLinear(new float[]{f, f2, f3});
    }

    public final float[] toLinear(float[] fArr) {
        fArr[0] = (float) this.eotfFunc.invoke((double) fArr[0]);
        fArr[1] = (float) this.eotfFunc.invoke((double) fArr[1]);
        fArr[2] = (float) this.eotfFunc.invoke((double) fArr[2]);
        return fArr;
    }

    public final float[] fromLinear(float f, float f2, float f3) {
        return fromLinear(new float[]{f, f2, f3});
    }

    public final float[] fromLinear(float[] fArr) {
        fArr[0] = (float) this.oetfFunc.invoke((double) fArr[0]);
        fArr[1] = (float) this.oetfFunc.invoke((double) fArr[1]);
        fArr[2] = (float) this.oetfFunc.invoke((double) fArr[2]);
        return fArr;
    }

    public float[] toXyz(float[] fArr) {
        fArr[0] = (float) this.eotfFunc.invoke((double) fArr[0]);
        fArr[1] = (float) this.eotfFunc.invoke((double) fArr[1]);
        fArr[2] = (float) this.eotfFunc.invoke((double) fArr[2]);
        return ColorSpaceKt.mul3x3Float3(this.transform, fArr);
    }

    public long toXy$ui_graphics_release(float f, float f2, float f3) {
        float invoke = (float) this.eotfFunc.invoke((double) f);
        float invoke2 = (float) this.eotfFunc.invoke((double) f2);
        float invoke3 = (float) this.eotfFunc.invoke((double) f3);
        return (((long) Float.floatToRawIntBits(ColorSpaceKt.mul3x3Float3_0(this.transform, invoke, invoke2, invoke3))) << 32) | (((long) Float.floatToRawIntBits(ColorSpaceKt.mul3x3Float3_1(this.transform, invoke, invoke2, invoke3))) & 4294967295L);
    }

    public float toZ$ui_graphics_release(float f, float f2, float f3) {
        return ColorSpaceKt.mul3x3Float3_2(this.transform, (float) this.eotfFunc.invoke((double) f), (float) this.eotfFunc.invoke((double) f2), (float) this.eotfFunc.invoke((double) f3));
    }

    /* renamed from: xyzaToColor-JlNiLsg$ui_graphics_release  reason: not valid java name */
    public long m4323xyzaToColorJlNiLsg$ui_graphics_release(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        return ColorKt.Color((float) this.oetfFunc.invoke((double) ColorSpaceKt.mul3x3Float3_0(this.inverseTransform, f, f2, f3)), (float) this.oetfFunc.invoke((double) ColorSpaceKt.mul3x3Float3_1(this.inverseTransform, f, f2, f3)), (float) this.oetfFunc.invoke((double) ColorSpaceKt.mul3x3Float3_2(this.inverseTransform, f, f2, f3)), f4, colorSpace);
    }

    public float[] fromXyz(float[] fArr) {
        ColorSpaceKt.mul3x3Float3(this.inverseTransform, fArr);
        fArr[0] = (float) this.oetfFunc.invoke((double) fArr[0]);
        fArr[1] = (float) this.oetfFunc.invoke((double) fArr[1]);
        fArr[2] = (float) this.oetfFunc.invoke((double) fArr[2]);
        return fArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        Rgb rgb = (Rgb) obj;
        if (Float.compare(rgb.min, this.min) != 0 || Float.compare(rgb.max, this.max) != 0 || !Intrinsics.areEqual((Object) this.whitePoint, (Object) rgb.whitePoint) || !Arrays.equals(this.primaries, rgb.primaries)) {
            return false;
        }
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            return Intrinsics.areEqual((Object) transferParameters2, (Object) rgb.transferParameters);
        }
        if (rgb.transferParameters == null) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) this.oetfOrig, (Object) rgb.oetfOrig)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.eotfOrig, (Object) rgb.eotfOrig);
    }

    public int hashCode() {
        int hashCode = ((((super.hashCode() * 31) + this.whitePoint.hashCode()) * 31) + Arrays.hashCode(this.primaries)) * 31;
        float f = this.min;
        int i = 0;
        int floatToIntBits = (hashCode + (f == 0.0f ? 0 : Float.floatToIntBits(f))) * 31;
        float f2 = this.max;
        int floatToIntBits2 = (floatToIntBits + (f2 == 0.0f ? 0 : Float.floatToIntBits(f2))) * 31;
        TransferParameters transferParameters2 = this.transferParameters;
        if (transferParameters2 != null) {
            i = transferParameters2.hashCode();
        }
        int i2 = floatToIntBits2 + i;
        return this.transferParameters == null ? (((i2 * 31) + this.oetfOrig.hashCode()) * 31) + this.eotfOrig.hashCode() : i2;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0015\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J(\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002J@\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "()V", "DoubleIdentity", "Landroidx/compose/ui/graphics/colorspace/DoubleFunction;", "area", "", "primaries", "", "compare", "", "point", "", "a", "b", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "computeXYZMatrix", "whitePoint", "contains", "p1", "p2", "cross", "ax", "ay", "bx", "by", "isSrgb", "OETF", "EOTF", "min", "max", "id", "", "isWideGamut", "xyPrimaries", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Rgb.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float cross(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isSrgb(float[] fArr, WhitePoint whitePoint, DoubleFunction doubleFunction, DoubleFunction doubleFunction2, float f, float f2, int i) {
            if (i == 0) {
                return true;
            }
            if (!ColorSpaceKt.compare(fArr, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release()) || !ColorSpaceKt.compare(whitePoint, Illuminant.INSTANCE.getD65()) || f != 0.0f || f2 != 1.0f) {
                return false;
            }
            Rgb srgb = ColorSpaces.INSTANCE.getSrgb();
            for (double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE; d <= 1.0d; d += 0.00392156862745098d) {
                if (!compare(d, doubleFunction, srgb.getOetfOrig$ui_graphics_release()) || !compare(d, doubleFunction2, srgb.getEotfOrig$ui_graphics_release())) {
                    return false;
                }
            }
            return true;
        }

        private final boolean compare(double d, DoubleFunction doubleFunction, DoubleFunction doubleFunction2) {
            return Math.abs(doubleFunction.invoke(d) - doubleFunction2.invoke(d)) <= 0.001d;
        }

        /* access modifiers changed from: private */
        public final boolean isWideGamut(float[] fArr, float f, float f2) {
            return (area(fArr) / area(ColorSpaces.INSTANCE.getNtsc1953Primaries$ui_graphics_release()) > 0.9f && contains(fArr, ColorSpaces.INSTANCE.getSrgbPrimaries$ui_graphics_release())) || (f < 0.0f && f2 > 1.0f);
        }

        private final float area(float[] fArr) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            float f7 = ((((((f * f4) + (f2 * f5)) + (f3 * f6)) - (f4 * f5)) - (f2 * f3)) - (f * f6)) * 0.5f;
            return f7 < 0.0f ? -f7 : f7;
        }

        private final boolean contains(float[] fArr, float[] fArr2) {
            float f = fArr[0];
            float f2 = fArr2[0];
            float f3 = fArr[1];
            float f4 = fArr2[1];
            float f5 = fArr[4];
            float f6 = fArr2[4];
            float f7 = fArr[5];
            float f8 = fArr2[5];
            float[] fArr3 = {f - f2, f3 - f4, fArr[2] - fArr2[2], fArr[3] - fArr2[3], f5 - f6, f7 - f8};
            if (cross(fArr3[0], fArr3[1], f2 - f6, f4 - f8) < 0.0f || cross(fArr2[0] - fArr2[2], fArr2[1] - fArr2[3], fArr3[0], fArr3[1]) < 0.0f || cross(fArr3[2], fArr3[3], fArr2[2] - fArr2[0], fArr2[3] - fArr2[1]) < 0.0f || cross(fArr2[2] - fArr2[4], fArr2[3] - fArr2[5], fArr3[2], fArr3[3]) < 0.0f || cross(fArr3[4], fArr3[5], fArr2[4] - fArr2[2], fArr2[5] - fArr2[3]) < 0.0f || cross(fArr2[4] - fArr2[0], fArr2[5] - fArr2[1], fArr3[4], fArr3[5]) < 0.0f) {
                return false;
            }
            return true;
        }

        public final float[] computePrimaries$ui_graphics_release(float[] fArr) {
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 0.0f, 0.0f});
            float[] mul3x3Float32 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{0.0f, 1.0f, 0.0f});
            float[] mul3x3Float33 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{0.0f, 0.0f, 1.0f});
            float f = mul3x3Float3[0];
            float f2 = mul3x3Float3[1];
            float f3 = f + f2 + mul3x3Float3[2];
            float f4 = mul3x3Float32[0];
            float f5 = mul3x3Float32[1];
            float f6 = f4 + f5 + mul3x3Float32[2];
            float f7 = mul3x3Float33[0];
            float f8 = mul3x3Float33[1];
            float f9 = f7 + f8 + mul3x3Float33[2];
            return new float[]{f / f3, f2 / f3, f4 / f6, f5 / f6, f7 / f9, f8 / f9};
        }

        /* access modifiers changed from: private */
        public final WhitePoint computeWhitePoint(float[] fArr) {
            float[] mul3x3Float3 = ColorSpaceKt.mul3x3Float3(fArr, new float[]{1.0f, 1.0f, 1.0f});
            float f = mul3x3Float3[0];
            float f2 = mul3x3Float3[1];
            float f3 = f + f2 + mul3x3Float3[2];
            return new WhitePoint(f / f3, f2 / f3);
        }

        /* access modifiers changed from: private */
        public final float[] xyPrimaries(float[] fArr) {
            float[] fArr2 = new float[6];
            if (fArr.length == 9) {
                float f = fArr[0];
                float f2 = fArr[1];
                float f3 = f + f2 + fArr[2];
                fArr2[0] = f / f3;
                fArr2[1] = f2 / f3;
                float f4 = fArr[3];
                float f5 = fArr[4];
                float f6 = f4 + f5 + fArr[5];
                fArr2[2] = f4 / f6;
                fArr2[3] = f5 / f6;
                float f7 = fArr[6];
                float f8 = fArr[7];
                float f9 = f7 + f8 + fArr[8];
                fArr2[4] = f7 / f9;
                fArr2[5] = f8 / f9;
            } else {
                ArraysKt.copyInto$default(fArr, fArr2, 0, 0, 6, 6, (Object) null);
            }
            return fArr2;
        }

        /* access modifiers changed from: private */
        public final float[] computeXYZMatrix(float[] fArr, WhitePoint whitePoint) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[4];
            float f6 = fArr[5];
            float x = whitePoint.getX();
            float y = whitePoint.getY();
            float f7 = (float) 1;
            float f8 = (f7 - f) / f2;
            float f9 = f / f2;
            float f10 = (f3 / f4) - f9;
            float f11 = (x / y) - f9;
            float f12 = ((f7 - f3) / f4) - f8;
            float f13 = (f5 / f6) - f9;
            float f14 = (((((f7 - x) / y) - f8) * f10) - (f11 * f12)) / (((((f7 - f5) / f6) - f8) * f10) - (f12 * f13));
            float f15 = (f11 - (f13 * f14)) / f10;
            float f16 = (1.0f - f15) - f14;
            float f17 = f16 / f2;
            float f18 = f15 / f4;
            float f19 = f14 / f6;
            return new float[]{f17 * f, f16, f17 * ((1.0f - f) - f2), f18 * f3, f15, f18 * ((1.0f - f3) - f4), f19 * f5, f14, f19 * ((1.0f - f5) - f6)};
        }
    }
}
