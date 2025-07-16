package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaceKt;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.Rgb;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JvmInline
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b@\u0018\u0000 :2\u00020\u0001:\u0001:B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001d\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\u000bJ\u0010\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u000bJ\u0010\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u000bJ\u0010\u0010#\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010\u000bJ\u0010\u0010%\u001a\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010\u0013J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)J=\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u000203HÖ\u0001¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001a\u0010\u0017\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b\u0001\u0002\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "", "value", "Lkotlin/ULong;", "constructor-impl", "(J)J", "alpha", "", "getAlpha$annotations", "()V", "getAlpha-impl", "(J)F", "blue", "getBlue$annotations", "getBlue-impl", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace$annotations", "getColorSpace-impl", "(J)Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "green", "getGreen$annotations", "getGreen-impl", "red", "getRed$annotations", "getRed-impl", "getValue-s-VKNKU", "()J", "J", "component1", "component1-impl", "component2", "component2-impl", "component3", "component3-impl", "component4", "component4-impl", "component5", "component5-impl", "convert", "convert-vNxB06k", "(JLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "copy", "copy-wmQWz5c", "(JFFFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Color.kt */
public final class Color {
    /* access modifiers changed from: private */
    public static final long Black = ColorKt.Color(4278190080L);
    /* access modifiers changed from: private */
    public static final long Blue = ColorKt.Color(4278190335L);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long Cyan = ColorKt.Color(4278255615L);
    /* access modifiers changed from: private */
    public static final long DarkGray = ColorKt.Color(4282664004L);
    /* access modifiers changed from: private */
    public static final long Gray = ColorKt.Color(4287137928L);
    /* access modifiers changed from: private */
    public static final long Green = ColorKt.Color(4278255360L);
    /* access modifiers changed from: private */
    public static final long LightGray = ColorKt.Color(4291611852L);
    /* access modifiers changed from: private */
    public static final long Magenta = ColorKt.Color(4294902015L);
    /* access modifiers changed from: private */
    public static final long Red = ColorKt.Color(4294901760L);
    /* access modifiers changed from: private */
    public static final long Transparent = ColorKt.Color(0);
    /* access modifiers changed from: private */
    public static final long Unspecified = ColorKt.Color(0.0f, 0.0f, 0.0f, 0.0f, ColorSpaces.INSTANCE.getUnspecified$ui_graphics_release());
    /* access modifiers changed from: private */
    public static final long White = ColorKt.Color(4294967295L);
    /* access modifiers changed from: private */
    public static final long Yellow = ColorKt.Color(4294967040L);
    private final long value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Color m3806boximpl(long j) {
        return new Color(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m3812constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m3816equalsimpl(long j, Object obj) {
        return (obj instanceof Color) && j == ((Color) obj).m3826unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m3817equalsimpl0(long j, long j2) {
        return ULong.m7223equalsimpl0(j, j2);
    }

    public static /* synthetic */ void getAlpha$annotations() {
    }

    public static /* synthetic */ void getBlue$annotations() {
    }

    public static /* synthetic */ void getColorSpace$annotations() {
    }

    public static /* synthetic */ void getGreen$annotations() {
    }

    public static /* synthetic */ void getRed$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m3823hashCodeimpl(long j) {
        return ULong.m7228hashCodeimpl(j);
    }

    public boolean equals(Object obj) {
        return m3816equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3823hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m3826unboximpl() {
        return this.value;
    }

    private /* synthetic */ Color(long j) {
        this.value = j;
    }

    /* renamed from: getValue-s-VKNKU  reason: not valid java name */
    public final long m3825getValuesVKNKU() {
        return this.value;
    }

    /* renamed from: getColorSpace-impl  reason: not valid java name */
    public static final ColorSpace m3820getColorSpaceimpl(long j) {
        return ColorSpaces.INSTANCE.getColorSpacesArray$ui_graphics_release()[(int) ULong.m7216constructorimpl(j & 63)];
    }

    /* renamed from: convert-vNxB06k  reason: not valid java name */
    public static final long m3813convertvNxB06k(long j, ColorSpace colorSpace) {
        ColorSpace r0 = m3820getColorSpaceimpl(j);
        if (Intrinsics.areEqual((Object) colorSpace, (Object) r0)) {
            return j;
        }
        return ColorSpaceKt.m4297connectYBCOT_4$default(r0, colorSpace, 0, 2, (Object) null).m4299transformToColorwmQWz5c$ui_graphics_release(m3822getRedimpl(j), m3821getGreenimpl(j), m3819getBlueimpl(j), m3818getAlphaimpl(j));
    }

    /* renamed from: getRed-impl  reason: not valid java name */
    public static final float m3822getRedimpl(long j) {
        if (ULong.m7216constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m7216constructorimpl(ULong.m7216constructorimpl(j >>> 48) & 255))) / 255.0f;
        }
        return Float16.m3942toFloatimpl(Float16.m3926constructorimpl((short) ((int) ULong.m7216constructorimpl(ULong.m7216constructorimpl(j >>> 48) & 65535))));
    }

    /* renamed from: getGreen-impl  reason: not valid java name */
    public static final float m3821getGreenimpl(long j) {
        if (ULong.m7216constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m7216constructorimpl(ULong.m7216constructorimpl(j >>> 40) & 255))) / 255.0f;
        }
        return Float16.m3942toFloatimpl(Float16.m3926constructorimpl((short) ((int) ULong.m7216constructorimpl(ULong.m7216constructorimpl(j >>> 32) & 65535))));
    }

    /* renamed from: getBlue-impl  reason: not valid java name */
    public static final float m3819getBlueimpl(long j) {
        if (ULong.m7216constructorimpl(63 & j) == 0) {
            return ((float) UnsignedKt.ulongToDouble(ULong.m7216constructorimpl(ULong.m7216constructorimpl(j >>> 32) & 255))) / 255.0f;
        }
        return Float16.m3942toFloatimpl(Float16.m3926constructorimpl((short) ((int) ULong.m7216constructorimpl(ULong.m7216constructorimpl(j >>> 16) & 65535))));
    }

    /* renamed from: getAlpha-impl  reason: not valid java name */
    public static final float m3818getAlphaimpl(long j) {
        float f;
        float f2;
        if (ULong.m7216constructorimpl(63 & j) == 0) {
            f2 = (float) UnsignedKt.ulongToDouble(ULong.m7216constructorimpl(ULong.m7216constructorimpl(j >>> 56) & 255));
            f = 255.0f;
        } else {
            f2 = (float) UnsignedKt.ulongToDouble(ULong.m7216constructorimpl(ULong.m7216constructorimpl(j >>> 6) & 1023));
            f = 1023.0f;
        }
        return f2 / f;
    }

    /* renamed from: component1-impl  reason: not valid java name */
    public static final float m3807component1impl(long j) {
        return m3822getRedimpl(j);
    }

    /* renamed from: component2-impl  reason: not valid java name */
    public static final float m3808component2impl(long j) {
        return m3821getGreenimpl(j);
    }

    /* renamed from: component3-impl  reason: not valid java name */
    public static final float m3809component3impl(long j) {
        return m3819getBlueimpl(j);
    }

    /* renamed from: component4-impl  reason: not valid java name */
    public static final float m3810component4impl(long j) {
        return m3818getAlphaimpl(j);
    }

    /* renamed from: component5-impl  reason: not valid java name */
    public static final ColorSpace m3811component5impl(long j) {
        return m3820getColorSpaceimpl(j);
    }

    /* renamed from: copy-wmQWz5c$default  reason: not valid java name */
    public static /* synthetic */ long m3815copywmQWz5c$default(long j, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m3818getAlphaimpl(j);
        }
        float f5 = f;
        if ((i & 2) != 0) {
            f2 = m3822getRedimpl(j);
        }
        float f6 = f2;
        if ((i & 4) != 0) {
            f3 = m3821getGreenimpl(j);
        }
        float f7 = f3;
        if ((i & 8) != 0) {
            f4 = m3819getBlueimpl(j);
        }
        return m3814copywmQWz5c(j, f5, f6, f7, f4);
    }

    /* renamed from: copy-wmQWz5c  reason: not valid java name */
    public static final long m3814copywmQWz5c(long j, float f, float f2, float f3, float f4) {
        return ColorKt.Color(f2, f3, f4, f, m3820getColorSpaceimpl(j));
    }

    public String toString() {
        return m3824toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m3824toStringimpl(long j) {
        return "Color(" + m3822getRedimpl(j) + ", " + m3821getGreenimpl(j) + ", " + m3819getBlueimpl(j) + ", " + m3818getAlphaimpl(j) + ", " + m3820getColorSpaceimpl(j).getName() + ')';
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u000204ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106J(\u00107\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010<\u001a\u00020/H\u0002J?\u0010=\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010>\u001a\u00020/2\b\b\u0002\u00102\u001a\u00020/2\b\b\u0002\u00103\u001a\u000204ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u00106J(\u0010@\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010A\u001a\u00020/H\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007R$\u0010\u000f\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R$\u0010\u0012\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R$\u0010\u0015\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0007R$\u0010\u0018\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\u0007R$\u0010\u001b\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001c\u0010\u0002\u001a\u0004\b\u001d\u0010\u0007R$\u0010\u001e\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u001f\u0010\u0002\u001a\u0004\b \u0010\u0007R$\u0010!\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\"\u0010\u0002\u001a\u0004\b#\u0010\u0007R$\u0010$\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b%\u0010\u0002\u001a\u0004\b&\u0010\u0007R$\u0010'\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b(\u0010\u0002\u001a\u0004\b)\u0010\u0007R$\u0010*\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b+\u0010\u0002\u001a\u0004\b,\u0010\u0007\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/ui/graphics/Color$Companion;", "", "()V", "Black", "Landroidx/compose/ui/graphics/Color;", "getBlack-0d7_KjU$annotations", "getBlack-0d7_KjU", "()J", "J", "Blue", "getBlue-0d7_KjU$annotations", "getBlue-0d7_KjU", "Cyan", "getCyan-0d7_KjU$annotations", "getCyan-0d7_KjU", "DarkGray", "getDarkGray-0d7_KjU$annotations", "getDarkGray-0d7_KjU", "Gray", "getGray-0d7_KjU$annotations", "getGray-0d7_KjU", "Green", "getGreen-0d7_KjU$annotations", "getGreen-0d7_KjU", "LightGray", "getLightGray-0d7_KjU$annotations", "getLightGray-0d7_KjU", "Magenta", "getMagenta-0d7_KjU$annotations", "getMagenta-0d7_KjU", "Red", "getRed-0d7_KjU$annotations", "getRed-0d7_KjU", "Transparent", "getTransparent-0d7_KjU$annotations", "getTransparent-0d7_KjU", "Unspecified", "getUnspecified-0d7_KjU$annotations", "getUnspecified-0d7_KjU", "White", "getWhite-0d7_KjU$annotations", "getWhite-0d7_KjU", "Yellow", "getYellow-0d7_KjU$annotations", "getYellow-0d7_KjU", "hsl", "hue", "", "saturation", "lightness", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/Rgb;", "hsl-JlNiLsg", "(FFFFLandroidx/compose/ui/graphics/colorspace/Rgb;)J", "hslToRgbComponent", "n", "", "h", "s", "l", "hsv", "value", "hsv-JlNiLsg", "hsvToRgbComponent", "v", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Color.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBlack-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3827getBlack0d7_KjU$annotations() {
        }

        /* renamed from: getBlue-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3828getBlue0d7_KjU$annotations() {
        }

        /* renamed from: getCyan-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3829getCyan0d7_KjU$annotations() {
        }

        /* renamed from: getDarkGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3830getDarkGray0d7_KjU$annotations() {
        }

        /* renamed from: getGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3831getGray0d7_KjU$annotations() {
        }

        /* renamed from: getGreen-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3832getGreen0d7_KjU$annotations() {
        }

        /* renamed from: getLightGray-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3833getLightGray0d7_KjU$annotations() {
        }

        /* renamed from: getMagenta-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3834getMagenta0d7_KjU$annotations() {
        }

        /* renamed from: getRed-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3835getRed0d7_KjU$annotations() {
        }

        /* renamed from: getTransparent-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3836getTransparent0d7_KjU$annotations() {
        }

        /* renamed from: getUnspecified-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3837getUnspecified0d7_KjU$annotations() {
        }

        /* renamed from: getWhite-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3838getWhite0d7_KjU$annotations() {
        }

        /* renamed from: getYellow-0d7_KjU$annotations  reason: not valid java name */
        public static /* synthetic */ void m3839getYellow0d7_KjU$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getBlack-0d7_KjU  reason: not valid java name */
        public final long m3842getBlack0d7_KjU() {
            return Color.Black;
        }

        /* renamed from: getDarkGray-0d7_KjU  reason: not valid java name */
        public final long m3845getDarkGray0d7_KjU() {
            return Color.DarkGray;
        }

        /* renamed from: getGray-0d7_KjU  reason: not valid java name */
        public final long m3846getGray0d7_KjU() {
            return Color.Gray;
        }

        /* renamed from: getLightGray-0d7_KjU  reason: not valid java name */
        public final long m3848getLightGray0d7_KjU() {
            return Color.LightGray;
        }

        /* renamed from: getWhite-0d7_KjU  reason: not valid java name */
        public final long m3853getWhite0d7_KjU() {
            return Color.White;
        }

        /* renamed from: getRed-0d7_KjU  reason: not valid java name */
        public final long m3850getRed0d7_KjU() {
            return Color.Red;
        }

        /* renamed from: getGreen-0d7_KjU  reason: not valid java name */
        public final long m3847getGreen0d7_KjU() {
            return Color.Green;
        }

        /* renamed from: getBlue-0d7_KjU  reason: not valid java name */
        public final long m3843getBlue0d7_KjU() {
            return Color.Blue;
        }

        /* renamed from: getYellow-0d7_KjU  reason: not valid java name */
        public final long m3854getYellow0d7_KjU() {
            return Color.Yellow;
        }

        /* renamed from: getCyan-0d7_KjU  reason: not valid java name */
        public final long m3844getCyan0d7_KjU() {
            return Color.Cyan;
        }

        /* renamed from: getMagenta-0d7_KjU  reason: not valid java name */
        public final long m3849getMagenta0d7_KjU() {
            return Color.Magenta;
        }

        /* renamed from: getTransparent-0d7_KjU  reason: not valid java name */
        public final long m3851getTransparent0d7_KjU() {
            return Color.Transparent;
        }

        /* renamed from: getUnspecified-0d7_KjU  reason: not valid java name */
        public final long m3852getUnspecified0d7_KjU() {
            return Color.Unspecified;
        }

        /* renamed from: hsv-JlNiLsg$default  reason: not valid java name */
        public static /* synthetic */ long m3841hsvJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f4 = 1.0f;
            }
            float f5 = f4;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m3856hsvJlNiLsg(f, f2, f3, f5, rgb);
        }

        /* renamed from: hsv-JlNiLsg  reason: not valid java name */
        public final long m3856hsvJlNiLsg(float f, float f2, float f3, float f4, Rgb rgb) {
            if (0.0f <= f && f <= 360.0f && 0.0f <= f2 && f2 <= 1.0f && 0.0f <= f3 && f3 <= 1.0f) {
                return ColorKt.Color(hsvToRgbComponent(5, f, f2, f3), hsvToRgbComponent(3, f, f2, f3), hsvToRgbComponent(1, f, f2, f3), f4, rgb);
            }
            throw new IllegalArgumentException(("HSV (" + f + ", " + f2 + ", " + f3 + ") must be in range (0..360, 0..1, 0..1)").toString());
        }

        private final float hsvToRgbComponent(int i, float f, float f2, float f3) {
            float f4 = (((float) i) + (f / 60.0f)) % 6.0f;
            return f3 - ((f2 * f3) * Math.max(0.0f, Math.min(f4, Math.min(((float) 4) - f4, 1.0f))));
        }

        /* renamed from: hsl-JlNiLsg$default  reason: not valid java name */
        public static /* synthetic */ long m3840hslJlNiLsg$default(Companion companion, float f, float f2, float f3, float f4, Rgb rgb, int i, Object obj) {
            if ((i & 8) != 0) {
                f4 = 1.0f;
            }
            float f5 = f4;
            if ((i & 16) != 0) {
                rgb = ColorSpaces.INSTANCE.getSrgb();
            }
            return companion.m3855hslJlNiLsg(f, f2, f3, f5, rgb);
        }

        /* renamed from: hsl-JlNiLsg  reason: not valid java name */
        public final long m3855hslJlNiLsg(float f, float f2, float f3, float f4, Rgb rgb) {
            if (0.0f <= f && f <= 360.0f && 0.0f <= f2 && f2 <= 1.0f && 0.0f <= f3 && f3 <= 1.0f) {
                return ColorKt.Color(hslToRgbComponent(0, f, f2, f3), hslToRgbComponent(8, f, f2, f3), hslToRgbComponent(4, f, f2, f3), f4, rgb);
            }
            throw new IllegalArgumentException(("HSL (" + f + ", " + f2 + ", " + f3 + ") must be in range (0..360, 0..1, 0..1)").toString());
        }

        private final float hslToRgbComponent(int i, float f, float f2, float f3) {
            float f4 = (((float) i) + (f / 30.0f)) % 12.0f;
            return f3 - ((f2 * Math.min(f3, 1.0f - f3)) * Math.max(-1.0f, Math.min(f4 - ((float) 3), Math.min(((float) 9) - f4, 1.0f))));
        }
    }
}
