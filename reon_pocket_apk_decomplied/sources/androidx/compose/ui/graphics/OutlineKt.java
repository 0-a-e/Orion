package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\u001aN\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aN\u0010\u0005\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0003\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0001\u0010\u001a\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00042,\u0010\u001b\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010\"\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110#¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!2,\u0010%\u001a(\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u001c¢\u0006\u0002\b!H\b\u001a\f\u0010'\u001a\u00020(*\u00020#H\u0002\u001a\u0011\u0010)\u001a\u00020**\u00020\u001dH\u0002¢\u0006\u0002\u0010+\u001a\u0011\u0010)\u001a\u00020**\u00020#H\u0002¢\u0006\u0002\u0010,\u001a\u0011\u0010-\u001a\u00020.*\u00020\u001dH\u0002¢\u0006\u0002\u0010+\u001a\u0011\u0010-\u001a\u00020.*\u00020#H\u0002¢\u0006\u0002\u0010,\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"addOutline", "", "Landroidx/compose/ui/graphics/Path;", "outline", "Landroidx/compose/ui/graphics/Outline;", "drawOutline", "Landroidx/compose/ui/graphics/Canvas;", "paint", "Landroidx/compose/ui/graphics/Paint;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawOutline-hn5TExg", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawOutline-wDX37Ww", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Outline;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOutlineHelper", "drawRectBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Rect;", "Lkotlin/ParameterName;", "name", "rect", "Lkotlin/ExtensionFunctionType;", "drawRoundedRectBlock", "Landroidx/compose/ui/geometry/RoundRect;", "rrect", "drawPathBlock", "path", "hasSameCornerRadius", "", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/geometry/Rect;)J", "(Landroidx/compose/ui/geometry/RoundRect;)J", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Outline.kt */
public final class OutlineKt {
    public static final void addOutline(Path path, Outline outline) {
        if (outline instanceof Outline.Rectangle) {
            path.addRect(((Outline.Rectangle) outline).getRect());
        } else if (outline instanceof Outline.Rounded) {
            path.addRoundRect(((Outline.Rounded) outline).getRoundRect());
        } else if (outline instanceof Outline.Generic) {
            Path.CC.m4116addPathUv8p0NA$default(path, ((Outline.Generic) outline).getPath(), 0, 2, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: drawOutline-wDX37Ww$default  reason: not valid java name */
    public static /* synthetic */ void m4086drawOutlinewDX37Ww$default(DrawScope drawScope, Outline outline, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        m4085drawOutlinewDX37Ww(drawScope, outline, j, (i2 & 4) != 0 ? 1.0f : f, (i2 & 8) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 16) != 0 ? null : colorFilter, (i2 & 32) != 0 ? DrawScope.Companion.m4473getDefaultBlendMode0nO6VwU() : i);
    }

    /* renamed from: drawOutline-hn5TExg$default  reason: not valid java name */
    public static /* synthetic */ void m4084drawOutlinehn5TExg$default(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        if ((i2 & 16) != 0) {
            colorFilter = null;
        }
        ColorFilter colorFilter2 = colorFilter;
        if ((i2 & 32) != 0) {
            i = DrawScope.Companion.m4473getDefaultBlendMode0nO6VwU();
        }
        m4083drawOutlinehn5TExg(drawScope, outline, brush, f2, drawStyle2, colorFilter2, i);
    }

    private static final long topLeft(Rect rect) {
        return OffsetKt.Offset(rect.getLeft(), rect.getTop());
    }

    private static final long size(Rect rect) {
        return SizeKt.Size(rect.getWidth(), rect.getHeight());
    }

    private static final long topLeft(RoundRect roundRect) {
        return OffsetKt.Offset(roundRect.getLeft(), roundRect.getTop());
    }

    private static final long size(RoundRect roundRect) {
        return SizeKt.Size(roundRect.getWidth(), roundRect.getHeight());
    }

    private static final void drawOutlineHelper(DrawScope drawScope, Outline outline, Function2<? super DrawScope, ? super Rect, Unit> function2, Function2<? super DrawScope, ? super RoundRect, Unit> function22, Function2<? super DrawScope, ? super Path, Unit> function23) {
        if (outline instanceof Outline.Rectangle) {
            function2.invoke(drawScope, ((Outline.Rectangle) outline).getRect());
        } else if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                function23.invoke(drawScope, roundRectPath$ui_graphics_release);
            } else {
                function22.invoke(drawScope, rounded.getRoundRect());
            }
        } else if (outline instanceof Outline.Generic) {
            function23.invoke(drawScope, ((Outline.Generic) outline).getPath());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final void drawOutline(Canvas canvas, Outline outline, Paint paint) {
        if (outline instanceof Outline.Rectangle) {
            canvas.drawRect(((Outline.Rectangle) outline).getRect(), paint);
        } else if (outline instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            Path roundRectPath$ui_graphics_release = rounded.getRoundRectPath$ui_graphics_release();
            if (roundRectPath$ui_graphics_release != null) {
                canvas.drawPath(roundRectPath$ui_graphics_release, paint);
                return;
            }
            canvas.drawRoundRect(rounded.getRoundRect().getLeft(), rounded.getRoundRect().getTop(), rounded.getRoundRect().getRight(), rounded.getRoundRect().getBottom(), CornerRadius.m3537getXimpl(rounded.getRoundRect().m3610getBottomLeftCornerRadiuskKHJgLs()), CornerRadius.m3538getYimpl(rounded.getRoundRect().m3610getBottomLeftCornerRadiuskKHJgLs()), paint);
        } else if (outline instanceof Outline.Generic) {
            canvas.drawPath(((Outline.Generic) outline).getPath(), paint);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final boolean hasSameCornerRadius(RoundRect roundRect) {
        boolean z = CornerRadius.m3537getXimpl(roundRect.m3610getBottomLeftCornerRadiuskKHJgLs()) == CornerRadius.m3537getXimpl(roundRect.m3611getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m3537getXimpl(roundRect.m3611getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m3537getXimpl(roundRect.m3613getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m3537getXimpl(roundRect.m3613getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m3537getXimpl(roundRect.m3612getTopLeftCornerRadiuskKHJgLs());
        boolean z2 = CornerRadius.m3538getYimpl(roundRect.m3610getBottomLeftCornerRadiuskKHJgLs()) == CornerRadius.m3538getYimpl(roundRect.m3611getBottomRightCornerRadiuskKHJgLs()) && CornerRadius.m3538getYimpl(roundRect.m3611getBottomRightCornerRadiuskKHJgLs()) == CornerRadius.m3538getYimpl(roundRect.m3613getTopRightCornerRadiuskKHJgLs()) && CornerRadius.m3538getYimpl(roundRect.m3613getTopRightCornerRadiuskKHJgLs()) == CornerRadius.m3538getYimpl(roundRect.m3612getTopLeftCornerRadiuskKHJgLs());
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* renamed from: drawOutline-wDX37Ww  reason: not valid java name */
    public static final void m4085drawOutlinewDX37Ww(DrawScope drawScope, Outline outline, long j, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Path path;
        Outline outline2 = outline;
        if (outline2 instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline2).getRect();
            drawScope.m4430drawRectnJ9OG0(j, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline2 instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline2;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                DrawScope drawScope2 = drawScope;
                long j2 = j;
                drawScope2.m4432drawRoundRectuAw5IA(j2, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m3537getXimpl(roundRect.m3610getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, (Object) null), drawStyle, f, colorFilter, i);
                return;
            }
        } else if (outline2 instanceof Outline.Generic) {
            path = ((Outline.Generic) outline2).getPath();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        drawScope.m4426drawPathLG529CI(path, j, f, drawStyle, colorFilter, i);
    }

    /* renamed from: drawOutline-hn5TExg  reason: not valid java name */
    public static final void m4083drawOutlinehn5TExg(DrawScope drawScope, Outline outline, Brush brush, float f, DrawStyle drawStyle, ColorFilter colorFilter, int i) {
        Path path;
        Outline outline2 = outline;
        if (outline2 instanceof Outline.Rectangle) {
            Rect rect = ((Outline.Rectangle) outline2).getRect();
            drawScope.m4429drawRectAsUm42w(brush, topLeft(rect), size(rect), f, drawStyle, colorFilter, i);
            return;
        }
        if (outline2 instanceof Outline.Rounded) {
            Outline.Rounded rounded = (Outline.Rounded) outline2;
            path = rounded.getRoundRectPath$ui_graphics_release();
            if (path == null) {
                RoundRect roundRect = rounded.getRoundRect();
                DrawScope drawScope2 = drawScope;
                Brush brush2 = brush;
                drawScope2.m4431drawRoundRectZuiqVtQ(brush2, topLeft(roundRect), size(roundRect), CornerRadiusKt.CornerRadius$default(CornerRadius.m3537getXimpl(roundRect.m3610getBottomLeftCornerRadiuskKHJgLs()), 0.0f, 2, (Object) null), f, drawStyle, colorFilter, i);
                return;
            }
        } else if (outline2 instanceof Outline.Generic) {
            path = ((Outline.Generic) outline2).getPath();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        drawScope.m4425drawPathGBMwjPU(path, brush, f, drawStyle, colorFilter, i);
    }
}
