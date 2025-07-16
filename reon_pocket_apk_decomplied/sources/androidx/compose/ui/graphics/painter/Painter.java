package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0002J2\u0010\u001e\u001a\u00020\n*\u00020\t2\u0006\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006ø\u0001\u0000¢\u0006\u0004\b \u0010!J\f\u0010\"\u001a\u00020\n*\u00020\tH$R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\u00020\rX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/ui/graphics/painter/Painter;", "", "()V", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "drawLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "layerPaint", "Landroidx/compose/ui/graphics/Paint;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "useLayer", "", "applyAlpha", "applyColorFilter", "applyLayoutDirection", "configureAlpha", "configureColorFilter", "configureLayoutDirection", "rtl", "obtainPaint", "draw", "size", "draw-x_KDEd0", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/ui/graphics/ColorFilter;)V", "onDraw", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Painter.kt */
public abstract class Painter {
    private float alpha = 1.0f;
    private ColorFilter colorFilter;
    private final Function1<DrawScope, Unit> drawLambda = new Painter$drawLambda$1(this);
    private Paint layerPaint;
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private boolean useLayer;

    /* access modifiers changed from: protected */
    public boolean applyAlpha(float f) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean applyColorFilter(ColorFilter colorFilter2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean applyLayoutDirection(LayoutDirection layoutDirection2) {
        return false;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc  reason: not valid java name */
    public abstract long m4570getIntrinsicSizeNHjbRc();

    /* access modifiers changed from: protected */
    public abstract void onDraw(DrawScope drawScope);

    private final Paint obtainPaint() {
        Paint paint = this.layerPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        this.layerPaint = Paint;
        return Paint;
    }

    private final void configureColorFilter(ColorFilter colorFilter2) {
        if (!Intrinsics.areEqual((Object) this.colorFilter, (Object) colorFilter2)) {
            if (!applyColorFilter(colorFilter2)) {
                if (colorFilter2 == null) {
                    Paint paint = this.layerPaint;
                    if (paint != null) {
                        paint.setColorFilter((ColorFilter) null);
                    }
                    this.useLayer = false;
                } else {
                    obtainPaint().setColorFilter(colorFilter2);
                    this.useLayer = true;
                }
            }
            this.colorFilter = colorFilter2;
        }
    }

    private final void configureAlpha(float f) {
        if (this.alpha != f) {
            if (!applyAlpha(f)) {
                if (f == 1.0f) {
                    Paint paint = this.layerPaint;
                    if (paint != null) {
                        paint.setAlpha(f);
                    }
                    this.useLayer = false;
                } else {
                    obtainPaint().setAlpha(f);
                    this.useLayer = true;
                }
            }
            this.alpha = f;
        }
    }

    private final void configureLayoutDirection(LayoutDirection layoutDirection2) {
        if (this.layoutDirection != layoutDirection2) {
            applyLayoutDirection(layoutDirection2);
            this.layoutDirection = layoutDirection2;
        }
    }

    /* renamed from: draw-x_KDEd0$default  reason: not valid java name */
    public static /* synthetic */ void m4568drawx_KDEd0$default(Painter painter, DrawScope drawScope, long j, float f, ColorFilter colorFilter2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                f = 1.0f;
            }
            float f2 = f;
            if ((i & 4) != 0) {
                colorFilter2 = null;
            }
            painter.m4569drawx_KDEd0(drawScope, j, f2, colorFilter2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
    }

    /* renamed from: draw-x_KDEd0  reason: not valid java name */
    public final void m4569drawx_KDEd0(DrawScope drawScope, long j, float f, ColorFilter colorFilter2) {
        configureAlpha(f);
        configureColorFilter(colorFilter2);
        configureLayoutDirection(drawScope.getLayoutDirection());
        float r8 = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc()) - Size.m3631getWidthimpl(j);
        float r0 = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc()) - Size.m3628getHeightimpl(j);
        drawScope.getDrawContext().getTransform().inset(0.0f, 0.0f, r8, r0);
        if (f > 0.0f && Size.m3631getWidthimpl(j) > 0.0f && Size.m3628getHeightimpl(j) > 0.0f) {
            if (this.useLayer) {
                Rect r5 = RectKt.m3602Recttz77jQw(Offset.Companion.m3578getZeroF1C5BW0(), SizeKt.Size(Size.m3631getWidthimpl(j), Size.m3628getHeightimpl(j)));
                Canvas canvas = drawScope.getDrawContext().getCanvas();
                try {
                    canvas.saveLayer(r5, obtainPaint());
                    onDraw(drawScope);
                } finally {
                    canvas.restore();
                }
            } else {
                onDraw(drawScope);
            }
        }
        drawScope.getDrawContext().getTransform().inset(-0.0f, -0.0f, -r8, -r0);
    }
}
