package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00158V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"androidx/compose/ui/graphics/drawscope/CanvasDrawScope$drawContext$1", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "value", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "transform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "getTransform", "()Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CanvasDrawScope.kt */
public final class CanvasDrawScope$drawContext$1 implements DrawContext {
    final /* synthetic */ CanvasDrawScope this$0;
    private final DrawTransform transform = CanvasDrawScopeKt.asDrawTransform(this);

    CanvasDrawScope$drawContext$1(CanvasDrawScope canvasDrawScope) {
        this.this$0 = canvasDrawScope;
    }

    public Canvas getCanvas() {
        return this.this$0.getDrawParams().getCanvas();
    }

    public void setCanvas(Canvas canvas) {
        this.this$0.getDrawParams().setCanvas(canvas);
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m4373getSizeNHjbRc() {
        return this.this$0.getDrawParams().m4371getSizeNHjbRc();
    }

    /* renamed from: setSize-uvyYCjk  reason: not valid java name */
    public void m4374setSizeuvyYCjk(long j) {
        this.this$0.getDrawParams().m4372setSizeuvyYCjk(j);
    }

    public DrawTransform getTransform() {
        return this.transform;
    }

    public LayoutDirection getLayoutDirection() {
        return this.this$0.getDrawParams().getLayoutDirection();
    }

    public void setLayoutDirection(LayoutDirection layoutDirection) {
        this.this$0.getDrawParams().setLayoutDirection(layoutDirection);
    }

    public Density getDensity() {
        return this.this$0.getDrawParams().getDensity();
    }

    public void setDensity(Density density) {
        this.this$0.getDrawParams().setDensity(density);
    }
}
