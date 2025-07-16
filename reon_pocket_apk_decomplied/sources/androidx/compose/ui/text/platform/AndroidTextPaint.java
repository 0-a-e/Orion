package androidx.compose.ui.text.platform;

import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u0018\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)ø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010-\u001a\u00020\u001f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010.\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR1\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f*\u0004\b\n\u0010\u000bR\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "<set-?>", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU$delegate", "(Landroidx/compose/ui/text/platform/AndroidTextPaint;)Ljava/lang/Object;", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "composePaint", "Landroidx/compose/ui/graphics/Paint;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text_release$annotations", "()V", "getShadow$ui_text_release", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text_release", "(Landroidx/compose/ui/graphics/Shadow;)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setBrush", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "size", "Landroidx/compose/ui/geometry/Size;", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextPaint.android.kt */
public final class AndroidTextPaint extends TextPaint {
    public static final int $stable = 8;
    private final Paint composePaint = AndroidPaint_androidKt.asComposePaint(this);
    private DrawStyle drawStyle;
    private Shadow shadow = Shadow.Companion.getNone();
    private TextDecoration textDecoration = TextDecoration.Companion.getNone();

    public static /* synthetic */ void getShadow$ui_text_release$annotations() {
    }

    public AndroidTextPaint(int i, float f) {
        super(i);
        this.density = f;
    }

    public final Shadow getShadow$ui_text_release() {
        return this.shadow;
    }

    public final void setShadow$ui_text_release(Shadow shadow2) {
        this.shadow = shadow2;
    }

    public final void setTextDecoration(TextDecoration textDecoration2) {
        if (textDecoration2 != null && !Intrinsics.areEqual((Object) this.textDecoration, (Object) textDecoration2)) {
            this.textDecoration = textDecoration2;
            setUnderlineText(textDecoration2.contains(TextDecoration.Companion.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.Companion.getLineThrough()));
        }
    }

    public final void setShadow(Shadow shadow2) {
        if (shadow2 != null && !Intrinsics.areEqual((Object) this.shadow, (Object) shadow2)) {
            this.shadow = shadow2;
            if (Intrinsics.areEqual((Object) shadow2, (Object) Shadow.Companion.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.m3562getXimpl(this.shadow.m4200getOffsetF1C5BW0()), Offset.m3563getYimpl(this.shadow.m4200getOffsetF1C5BW0()), ColorKt.m3870toArgb8_81llA(this.shadow.m4199getColor0d7_KjU()));
            }
        }
    }

    /* renamed from: setBrush-12SF9DM$default  reason: not valid java name */
    public static /* synthetic */ void m6318setBrush12SF9DM$default(AndroidTextPaint androidTextPaint, Brush brush, long j, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = Float.NaN;
        }
        androidTextPaint.m6321setBrush12SF9DM(brush, j, f);
    }

    /* renamed from: setBrush-12SF9DM  reason: not valid java name */
    public final void m6321setBrush12SF9DM(Brush brush, long j, float f) {
        if (((brush instanceof SolidColor) && ((SolidColor) brush).m4212getValue0d7_KjU() != Color.Companion.m3852getUnspecified0d7_KjU()) || ((brush instanceof ShaderBrush) && j != Size.Companion.m3639getUnspecifiedNHjbRc())) {
            brush.m3752applyToPq9zytI(j, this.composePaint, Float.isNaN(f) ? this.composePaint.getAlpha() : RangesKt.coerceIn(f, 0.0f, 1.0f));
        } else if (brush == null) {
            this.composePaint.setShader((Shader) null);
        }
    }

    public final void setDrawStyle(DrawStyle drawStyle2) {
        if (drawStyle2 != null && !Intrinsics.areEqual((Object) this.drawStyle, (Object) drawStyle2)) {
            this.drawStyle = drawStyle2;
            if (Intrinsics.areEqual((Object) drawStyle2, (Object) Fill.INSTANCE)) {
                this.composePaint.m4098setStylek9PVt8s(PaintingStyle.Companion.m4106getFillTiuSbCo());
            } else if (drawStyle2 instanceof Stroke) {
                this.composePaint.m4098setStylek9PVt8s(PaintingStyle.Companion.m4107getStrokeTiuSbCo());
                Stroke stroke = (Stroke) drawStyle2;
                this.composePaint.setStrokeWidth(stroke.getWidth());
                this.composePaint.setStrokeMiterLimit(stroke.getMiter());
                this.composePaint.m4097setStrokeJoinWw9F2mQ(stroke.m4556getJoinLxFBmk8());
                this.composePaint.m4096setStrokeCapBeK7IIE(stroke.m4555getCapKaPHkGw());
                this.composePaint.setPathEffect(stroke.getPathEffect());
            }
        }
    }

    /* renamed from: getBlendMode-0nO6VwU$delegate  reason: not valid java name */
    private static Object m6317getBlendMode0nO6VwU$delegate(AndroidTextPaint androidTextPaint) {
        return Reflection.mutableProperty0(new MutablePropertyReference0Impl(androidTextPaint.composePaint, Paint.class, "blendMode", "getBlendMode-0nO6VwU()I", 0));
    }

    /* renamed from: getBlendMode-0nO6VwU  reason: not valid java name */
    public final int m6319getBlendMode0nO6VwU() {
        return this.composePaint.m4087getBlendMode0nO6VwU();
    }

    /* renamed from: setBlendMode-s9anfk8  reason: not valid java name */
    public final void m6320setBlendModes9anfk8(int i) {
        this.composePaint.m4093setBlendModes9anfk8(i);
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m6322setColor8_81llA(long j) {
        if (j != Color.Companion.m3852getUnspecified0d7_KjU()) {
            this.composePaint.m4094setColor8_81llA(j);
            this.composePaint.setShader((Shader) null);
        }
    }
}
