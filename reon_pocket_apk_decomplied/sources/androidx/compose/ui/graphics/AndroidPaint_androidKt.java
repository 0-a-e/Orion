package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\u0010\u0010\u0005\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\t*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\f\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0010\u001a\u00020\u0011*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0015\u0010\u0012\u001a\u00020\u0013*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0010\u0010\u0014\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0010\u0010\u0015\u001a\u00020\u0006*\u00060\u0003j\u0002`\u0007H\u0000\u001a\u0015\u0010\u0016\u001a\u00020\u0017*\u00060\u0003j\u0002`\u0007H\u0000¢\u0006\u0002\u0010\u000f\u001a\u0018\u0010\u0018\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u001b\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\tH\u0000\u001a\"\u0010\u001c\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\"\u0010!\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001a\u0010$\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010%H\u0000\u001a\"\u0010&\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u000eH\u0000ø\u0001\u0000¢\u0006\u0004\b'\u0010 \u001a\u001a\u0010(\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010)H\u0000\u001a \u0010*\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u000e\u0010\u001a\u001a\n\u0018\u00010+j\u0004\u0018\u0001`,H\u0000\u001a\"\u0010-\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0011H\u0000ø\u0001\u0000¢\u0006\u0004\b.\u0010 \u001a\"\u0010/\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0013H\u0000ø\u0001\u0000¢\u0006\u0004\b0\u0010 \u001a\u0018\u00101\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a\u0018\u00102\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a\"\u00103\u001a\u00020\u0019*\u00060\u0003j\u0002`\u00072\u0006\u0010\u001a\u001a\u00020\u0017H\u0000ø\u0001\u0000¢\u0006\u0004\b4\u0010 *\n\u00105\"\u00020\u00032\u00020\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Paint", "Landroidx/compose/ui/graphics/Paint;", "makeNativePaint", "Landroid/graphics/Paint;", "asComposePaint", "getNativeAlpha", "", "Landroidx/compose/ui/graphics/NativePaint;", "getNativeAntiAlias", "", "getNativeColor", "Landroidx/compose/ui/graphics/Color;", "(Landroid/graphics/Paint;)J", "getNativeFilterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "(Landroid/graphics/Paint;)I", "getNativeStrokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getNativeStrokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getNativeStrokeMiterLimit", "getNativeStrokeWidth", "getNativeStyle", "Landroidx/compose/ui/graphics/PaintingStyle;", "setNativeAlpha", "", "value", "setNativeAntiAlias", "setNativeBlendMode", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setNativeBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "setNativeColor", "setNativeColor-4WTKRHQ", "(Landroid/graphics/Paint;J)V", "setNativeColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "setNativeFilterQuality", "setNativeFilterQuality-50PEsBU", "setNativePathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "setNativeShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "setNativeStrokeCap", "setNativeStrokeCap-CSYIeUk", "setNativeStrokeJoin", "setNativeStrokeJoin-kLtJ_vA", "setNativeStrokeMiterLimit", "setNativeStrokeWidth", "setNativeStyle", "setNativeStyle--5YerkU", "NativePaint", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidPaint.android.kt */
public final class AndroidPaint_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidPaint.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|(2:21|22)|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        static {
            /*
                android.graphics.Paint$Style[] r0 = android.graphics.Paint.Style.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                $EnumSwitchMapping$0 = r0
                android.graphics.Paint$Cap[] r0 = android.graphics.Paint.Cap.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.graphics.Paint$Cap r2 = android.graphics.Paint.Cap.BUTT     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                r2 = 2
                android.graphics.Paint$Cap r3 = android.graphics.Paint.Cap.ROUND     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 3
                android.graphics.Paint$Cap r4 = android.graphics.Paint.Cap.SQUARE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                $EnumSwitchMapping$1 = r0
                android.graphics.Paint$Join[] r0 = android.graphics.Paint.Join.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.graphics.Paint$Join r4 = android.graphics.Paint.Join.MITER     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                android.graphics.Paint$Join r1 = android.graphics.Paint.Join.BEVEL     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                android.graphics.Paint$Join r1 = android.graphics.Paint.Join.ROUND     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                $EnumSwitchMapping$2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.AndroidPaint_androidKt.WhenMappings.<clinit>():void");
        }
    }

    public static final Paint Paint() {
        return new AndroidPaint();
    }

    public static final Paint asComposePaint(Paint paint) {
        return new AndroidPaint(paint);
    }

    public static final Paint makeNativePaint() {
        return new Paint(7);
    }

    /* renamed from: setNativeBlendMode-GB0RdKg  reason: not valid java name */
    public static final void m3688setNativeBlendModeGB0RdKg(Paint paint, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.INSTANCE.m4281setBlendModeGB0RdKg(paint, i);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m3655toPorterDuffModes9anfk8(i)));
        }
    }

    public static final void setNativeColorFilter(Paint paint, ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
    }

    public static final float getNativeAlpha(Paint paint) {
        return ((float) paint.getAlpha()) / 255.0f;
    }

    public static final void setNativeAlpha(Paint paint, float f) {
        paint.setAlpha((int) ((float) Math.rint((double) (f * 255.0f))));
    }

    public static final boolean getNativeAntiAlias(Paint paint) {
        return paint.isAntiAlias();
    }

    public static final void setNativeAntiAlias(Paint paint, boolean z) {
        paint.setAntiAlias(z);
    }

    public static final long getNativeColor(Paint paint) {
        return ColorKt.Color(paint.getColor());
    }

    /* renamed from: setNativeColor-4WTKRHQ  reason: not valid java name */
    public static final void m3689setNativeColor4WTKRHQ(Paint paint, long j) {
        paint.setColor(ColorKt.m3870toArgb8_81llA(j));
    }

    /* renamed from: setNativeStyle--5YerkU  reason: not valid java name */
    public static final void m3693setNativeStyle5YerkU(Paint paint, int i) {
        Paint.Style style;
        if (PaintingStyle.m4102equalsimpl0(i, PaintingStyle.Companion.m4107getStrokeTiuSbCo())) {
            style = Paint.Style.STROKE;
        } else {
            style = Paint.Style.FILL;
        }
        paint.setStyle(style);
    }

    public static final int getNativeStyle(Paint paint) {
        Paint.Style style = paint.getStyle();
        if ((style == null ? -1 : WhenMappings.$EnumSwitchMapping$0[style.ordinal()]) == 1) {
            return PaintingStyle.Companion.m4107getStrokeTiuSbCo();
        }
        return PaintingStyle.Companion.m4106getFillTiuSbCo();
    }

    public static final float getNativeStrokeWidth(Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final void setNativeStrokeWidth(Paint paint, float f) {
        paint.setStrokeWidth(f);
    }

    public static final int getNativeStrokeCap(Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i = strokeCap == null ? -1 : WhenMappings.$EnumSwitchMapping$1[strokeCap.ordinal()];
        if (i == 1) {
            return StrokeCap.Companion.m4230getButtKaPHkGw();
        }
        if (i == 2) {
            return StrokeCap.Companion.m4231getRoundKaPHkGw();
        }
        if (i != 3) {
            return StrokeCap.Companion.m4230getButtKaPHkGw();
        }
        return StrokeCap.Companion.m4232getSquareKaPHkGw();
    }

    /* renamed from: setNativeStrokeCap-CSYIeUk  reason: not valid java name */
    public static final void m3691setNativeStrokeCapCSYIeUk(Paint paint, int i) {
        Paint.Cap cap;
        if (StrokeCap.m4226equalsimpl0(i, StrokeCap.Companion.m4232getSquareKaPHkGw())) {
            cap = Paint.Cap.SQUARE;
        } else if (StrokeCap.m4226equalsimpl0(i, StrokeCap.Companion.m4231getRoundKaPHkGw())) {
            cap = Paint.Cap.ROUND;
        } else if (StrokeCap.m4226equalsimpl0(i, StrokeCap.Companion.m4230getButtKaPHkGw())) {
            cap = Paint.Cap.BUTT;
        } else {
            cap = Paint.Cap.BUTT;
        }
        paint.setStrokeCap(cap);
    }

    public static final int getNativeStrokeJoin(Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i = strokeJoin == null ? -1 : WhenMappings.$EnumSwitchMapping$2[strokeJoin.ordinal()];
        if (i == 1) {
            return StrokeJoin.Companion.m4241getMiterLxFBmk8();
        }
        if (i == 2) {
            return StrokeJoin.Companion.m4240getBevelLxFBmk8();
        }
        if (i != 3) {
            return StrokeJoin.Companion.m4241getMiterLxFBmk8();
        }
        return StrokeJoin.Companion.m4242getRoundLxFBmk8();
    }

    /* renamed from: setNativeStrokeJoin-kLtJ_vA  reason: not valid java name */
    public static final void m3692setNativeStrokeJoinkLtJ_vA(Paint paint, int i) {
        Paint.Join join;
        if (StrokeJoin.m4236equalsimpl0(i, StrokeJoin.Companion.m4241getMiterLxFBmk8())) {
            join = Paint.Join.MITER;
        } else if (StrokeJoin.m4236equalsimpl0(i, StrokeJoin.Companion.m4240getBevelLxFBmk8())) {
            join = Paint.Join.BEVEL;
        } else if (StrokeJoin.m4236equalsimpl0(i, StrokeJoin.Companion.m4242getRoundLxFBmk8())) {
            join = Paint.Join.ROUND;
        } else {
            join = Paint.Join.MITER;
        }
        paint.setStrokeJoin(join);
    }

    public static final float getNativeStrokeMiterLimit(Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final void setNativeStrokeMiterLimit(Paint paint, float f) {
        paint.setStrokeMiter(f);
    }

    public static final int getNativeFilterQuality(Paint paint) {
        if (!paint.isFilterBitmap()) {
            return FilterQuality.Companion.m3919getNonefv9h1I();
        }
        return FilterQuality.Companion.m3917getLowfv9h1I();
    }

    /* renamed from: setNativeFilterQuality-50PEsBU  reason: not valid java name */
    public static final void m3690setNativeFilterQuality50PEsBU(Paint paint, int i) {
        paint.setFilterBitmap(!FilterQuality.m3912equalsimpl0(i, FilterQuality.Companion.m3919getNonefv9h1I()));
    }

    public static final void setNativeShader(Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    public static final void setNativePathEffect(Paint paint, PathEffect pathEffect) {
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        paint.setPathEffect(androidPathEffect != null ? androidPathEffect.getNativePathEffect() : null);
    }
}
