package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a9\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0017\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a5\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00142\b\b\u0001\u0010\r\u001a\u00020\u00142\b\b\u0001\u0010\u000e\u001a\u00020\u00142\b\b\u0003\u0010\u000f\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\n\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a1\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\b\u001a,\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0001\u0010\"\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0010\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002\u001a\u001e\u0010'\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0016\u0010+\u001a\u00020,*\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0016\u0010/\u001a\u00020\f*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a%\u00102\u001a\u00020\u0002*\u00020\u00022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000204H\bø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u0016\u00107\u001a\u00020\u0014*\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "saturate", "v", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Color.kt */
public final class ColorKt {
    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    /* renamed from: isSpecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m3864isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA$annotations  reason: not valid java name */
    public static /* synthetic */ void m3866isUnspecified8_81llA$annotations(long j) {
    }

    private static final float saturate(float f) {
        float f2 = 0.0f;
        if (f > 0.0f) {
            f2 = 1.0f;
            if (f < 1.0f) {
                return f;
            }
        }
        return f2;
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    public static final long Color(float f, float f2, float f3, float f4, ColorSpace colorSpace) {
        float minValue = colorSpace.getMinValue(0);
        if (f <= colorSpace.getMaxValue(0) && minValue <= f) {
            float minValue2 = colorSpace.getMinValue(1);
            if (f2 <= colorSpace.getMaxValue(1) && minValue2 <= f2) {
                float minValue3 = colorSpace.getMinValue(2);
                if (f3 <= colorSpace.getMaxValue(2) && minValue3 <= f3 && 0.0f <= f4 && f4 <= 1.0f) {
                    if (colorSpace.isSrgb()) {
                        return Color.m3812constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) ((((((int) ((f * 255.0f) + 0.5f)) << 16) | (((int) ((f4 * 255.0f) + 0.5f)) << 24)) | (((int) ((f2 * 255.0f) + 0.5f)) << 8)) | ((int) ((f3 * 255.0f) + 0.5f)))) & 4294967295L) << 32));
                    } else if (colorSpace.getComponentCount() == 3) {
                        int id$ui_graphics_release = colorSpace.getId$ui_graphics_release();
                        if (id$ui_graphics_release != -1) {
                            short r7 = Float16.m3925constructorimpl(f);
                            short r8 = Float16.m3925constructorimpl(f2);
                            short r9 = Float16.m3925constructorimpl(f3);
                            return Color.m3812constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) r8) & 65535) << 32) | ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) r7) & 65535) << 48)) | ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) r9) & 65535) << 16)) | ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) ((int) ((Math.max(0.0f, Math.min(f4, 1.0f)) * 1023.0f) + 0.5f))) & 1023) << 6)) | ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) id$ui_graphics_release) & 63)));
                        }
                        throw new IllegalArgumentException("Unknown color space, please use a color space in ColorSpaces".toString());
                    } else {
                        throw new IllegalArgumentException("Color only works with ColorSpaces with 3 components".toString());
                    }
                }
            }
        }
        throw new IllegalArgumentException(("red = " + f + ", green = " + f2 + ", blue = " + f3 + ", alpha = " + f4 + " outside the range for " + colorSpace).toString());
    }

    public static final long Color(int i) {
        return Color.m3812constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl((long) i) << 32));
    }

    public static final long Color(long j) {
        return Color.m3812constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl(ULong.m7216constructorimpl(j) & 4294967295L) << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* renamed from: lerp-jxsXWHM  reason: not valid java name */
    public static final long m3867lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long r8 = Color.m3813convertvNxB06k(j, oklab);
        long r1 = Color.m3813convertvNxB06k(j2, oklab);
        float r3 = Color.m3818getAlphaimpl(r8);
        float r4 = Color.m3822getRedimpl(r8);
        float r5 = Color.m3821getGreenimpl(r8);
        float r82 = Color.m3819getBlueimpl(r8);
        float r9 = Color.m3818getAlphaimpl(r1);
        float r6 = Color.m3822getRedimpl(r1);
        float r7 = Color.m3821getGreenimpl(r1);
        float r12 = Color.m3819getBlueimpl(r1);
        return Color.m3813convertvNxB06k(Color(MathHelpersKt.lerp(r4, r6, f), MathHelpersKt.lerp(r5, r7, f), MathHelpersKt.lerp(r82, r12, f), MathHelpersKt.lerp(r3, r9, f), oklab), Color.m3820getColorSpaceimpl(j2));
    }

    /* renamed from: compositeOver--OWjLjI  reason: not valid java name */
    public static final long m3861compositeOverOWjLjI(long j, long j2) {
        long r9 = Color.m3813convertvNxB06k(j, Color.m3820getColorSpaceimpl(j2));
        float r0 = Color.m3818getAlphaimpl(j2);
        float r1 = Color.m3818getAlphaimpl(r9);
        float f = 1.0f - r1;
        float f2 = (r0 * f) + r1;
        float f3 = 0.0f;
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        float r4 = i == 0 ? 0.0f : ((Color.m3822getRedimpl(r9) * r1) + ((Color.m3822getRedimpl(j2) * r0) * f)) / f2;
        float r5 = i == 0 ? 0.0f : ((Color.m3821getGreenimpl(r9) * r1) + ((Color.m3821getGreenimpl(j2) * r0) * f)) / f2;
        float r92 = Color.m3819getBlueimpl(r9);
        float r10 = Color.m3819getBlueimpl(j2);
        if (i != 0) {
            f3 = ((r92 * r1) + ((r10 * r0) * f)) / f2;
        }
        return Color(r4, r5, f3, f2, Color.m3820getColorSpaceimpl(j2));
    }

    /* renamed from: getComponents-8_81llA  reason: not valid java name */
    private static final float[] m3862getComponents8_81llA(long j) {
        return new float[]{Color.m3822getRedimpl(j), Color.m3821getGreenimpl(j), Color.m3819getBlueimpl(j), Color.m3818getAlphaimpl(j)};
    }

    /* renamed from: luminance-8_81llA  reason: not valid java name */
    public static final float m3868luminance8_81llA(long j) {
        ColorSpace r0 = Color.m3820getColorSpaceimpl(j);
        if (ColorModel.m4285equalsimpl0(r0.m4294getModelxdoWZVw(), ColorModel.Companion.m4292getRgbxdoWZVw())) {
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
            DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) r0).getEotfFunc$ui_graphics_release();
            return saturate((float) ((eotfFunc$ui_graphics_release.invoke((double) Color.m3822getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke((double) Color.m3821getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke((double) Color.m3819getBlueimpl(j)) * 0.0722d)));
        }
        throw new IllegalArgumentException(("The specified color must be encoded in an RGB color space. The supplied color space is " + ColorModel.m4288toStringimpl(r0.m4294getModelxdoWZVw())).toString());
    }

    /* renamed from: toArgb-8_81llA  reason: not valid java name */
    public static final int m3870toArgb8_81llA(long j) {
        return (int) ULong.m7216constructorimpl(Color.m3813convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* renamed from: isSpecified-8_81llA  reason: not valid java name */
    public static final boolean m3863isSpecified8_81llA(long j) {
        return j != Color.Companion.m3852getUnspecified0d7_KjU();
    }

    /* renamed from: isUnspecified-8_81llA  reason: not valid java name */
    public static final boolean m3865isUnspecified8_81llA(long j) {
        return j == Color.Companion.m3852getUnspecified0d7_KjU();
    }

    /* renamed from: takeOrElse-DxMtmZc  reason: not valid java name */
    public static final long m3869takeOrElseDxMtmZc(long j, Function0<Color> function0) {
        return j != Color.Companion.m3852getUnspecified0d7_KjU() ? j : function0.invoke().m3826unboximpl();
    }
}
