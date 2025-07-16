package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00038V@VX\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u0016X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/DrawContext;", "", "<anonymous parameter 0>", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "transform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "getTransform", "()Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawContext.kt */
public interface DrawContext {
    Canvas getCanvas();

    Density getDensity();

    LayoutDirection getLayoutDirection();

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    long m4412getSizeNHjbRc();

    DrawTransform getTransform();

    void setCanvas(Canvas canvas);

    void setDensity(Density density);

    void setLayoutDirection(LayoutDirection layoutDirection);

    /* renamed from: setSize-uvyYCjk  reason: not valid java name */
    void m4413setSizeuvyYCjk(long j);

    /* renamed from: androidx.compose.ui.graphics.drawscope.DrawContext$-CC  reason: invalid class name */
    /* compiled from: DrawContext.kt */
    public final /* synthetic */ class CC {
        public static void $default$setCanvas(DrawContext _this, Canvas canvas) {
        }

        public static void $default$setDensity(DrawContext _this, Density density) {
        }

        public static void $default$setLayoutDirection(DrawContext _this, LayoutDirection layoutDirection) {
        }

        public static Canvas $default$getCanvas(DrawContext _this) {
            return new EmptyCanvas();
        }

        public static LayoutDirection $default$getLayoutDirection(DrawContext _this) {
            return LayoutDirection.Ltr;
        }

        public static Density $default$getDensity(DrawContext _this) {
            return DrawContextKt.getDefaultDensity();
        }
    }
}
