package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.DegreesKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001ab\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001aP\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a!\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\bH\b\u001a.\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010 \u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\b\u001a:\u0010 \u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u000e2\b\b\u0002\u0010\"\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\b\u001aF\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\b\u001aB\u0010#\u001a\u00020\u0001*\u00020\u00022\u0006\u0010$\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020&2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aB\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010*\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020&2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b+\u0010(\u001aB\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010,\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020&2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b-\u0010(\u001aJ\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\b\b\u0002\u0010%\u001a\u00020&2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a:\u00102\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\b\u001a?\u00103\u001a\u00020\u0001*\u00020\u00022\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\t2\u0017\u00106\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\tH\b\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"clipPath", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "clipPath-KD09W0M", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;ILkotlin/jvm/functions/Function1;)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-rOu3jXo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFILkotlin/jvm/functions/Function1;)V", "draw", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "draw-GRGpd60", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "drawIntoCanvas", "inset", "horizontal", "vertical", "rotate", "degrees", "pivot", "Landroidx/compose/ui/geometry/Offset;", "rotate-Rg1IO4c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FJLkotlin/jvm/functions/Function1;)V", "rotateRad", "radians", "rotateRad-Rg1IO4c", "scale", "scale-Rg1IO4c", "scaleX", "scaleY", "scale-Fgt4K4Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLkotlin/jvm/functions/Function1;)V", "translate", "withTransform", "transformBlock", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "drawBlock", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DrawScope.kt */
public final class DrawScopeKt {
    public static final void inset(DrawScope drawScope, float f, float f2, float f3, float f4, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f2, f3, f4);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().inset(-f, -f2, -f3, -f4);
    }

    public static final void inset(DrawScope drawScope, float f, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f, f, f);
        function1.invoke(drawScope);
        float f2 = -f;
        drawScope.getDrawContext().getTransform().inset(f2, f2, f2, f2);
    }

    public static final void translate(DrawScope drawScope, float f, float f2, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().translate(f, f2);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f, -f2);
    }

    public static /* synthetic */ void translate$default(DrawScope drawScope, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().translate(f, f2);
        function1.invoke(drawScope);
        drawScope.getDrawContext().getTransform().translate(-f, -f2);
    }

    /* renamed from: rotate-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m4515rotateRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.m4433getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4526rotateUv8p0NA(f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r0);
    }

    /* renamed from: rotateRad-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m4517rotateRadRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.m4433getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4526rotateUv8p0NA(DegreesKt.degrees(f), j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r0);
    }

    /* renamed from: scale-Fgt4K4Q$default  reason: not valid java name */
    public static /* synthetic */ void m4519scaleFgt4K4Q$default(DrawScope drawScope, float f, float f2, long j, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            j = drawScope.m4433getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4527scale0AR0LA0(f, f2, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r0);
    }

    /* renamed from: scale-Rg1IO4c$default  reason: not valid java name */
    public static /* synthetic */ void m4521scaleRg1IO4c$default(DrawScope drawScope, float f, long j, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            j = drawScope.m4433getCenterF1C5BW0();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4527scale0AR0LA0(f, f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r0);
    }

    /* renamed from: clipRect-rOu3jXo$default  reason: not valid java name */
    public static /* synthetic */ void m4512clipRectrOu3jXo$default(DrawScope drawScope, float f, float f2, float f3, float f4, int i, Function1 function1, int i2, Object obj) {
        float f5 = (i2 & 1) != 0 ? 0.0f : f;
        float f6 = (i2 & 2) != 0 ? 0.0f : f2;
        if ((i2 & 4) != 0) {
            f3 = Size.m3631getWidthimpl(drawScope.m4434getSizeNHjbRc());
        }
        float f7 = f3;
        if ((i2 & 8) != 0) {
            f4 = Size.m3628getHeightimpl(drawScope.m4434getSizeNHjbRc());
        }
        float f8 = f4;
        if ((i2 & 16) != 0) {
            i = ClipOp.Companion.m3805getIntersectrtfAjoo();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r9 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4523clipRectN_I0leg(f5, f6, f7, f8, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r9);
    }

    /* renamed from: clipPath-KD09W0M$default  reason: not valid java name */
    public static /* synthetic */ void m4510clipPathKD09W0M$default(DrawScope drawScope, Path path, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = ClipOp.Companion.m3805getIntersectrtfAjoo();
        }
        DrawContext drawContext = drawScope.getDrawContext();
        long r0 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4522clipPathmtrdDE(path, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r0);
    }

    public static final void drawIntoCanvas(DrawScope drawScope, Function1<? super Canvas, Unit> function1) {
        function1.invoke(drawScope.getDrawContext().getCanvas());
    }

    public static final void withTransform(DrawScope drawScope, Function1<? super DrawTransform, Unit> function1, Function1<? super DrawScope, Unit> function12) {
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        function1.invoke(drawContext.getTransform());
        function12.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r1);
    }

    /* renamed from: draw-GRGpd60  reason: not valid java name */
    public static final void m4513drawGRGpd60(DrawScope drawScope, Density density, LayoutDirection layoutDirection, Canvas canvas, long j, Function1<? super DrawScope, Unit> function1) {
        Density density2 = drawScope.getDrawContext().getDensity();
        LayoutDirection layoutDirection2 = drawScope.getDrawContext().getLayoutDirection();
        Canvas canvas2 = drawScope.getDrawContext().getCanvas();
        long r3 = drawScope.getDrawContext().m4412getSizeNHjbRc();
        DrawContext drawContext = drawScope.getDrawContext();
        drawContext.setDensity(density);
        drawContext.setLayoutDirection(layoutDirection);
        drawContext.setCanvas(canvas);
        drawContext.m4413setSizeuvyYCjk(j);
        canvas.save();
        function1.invoke(drawScope);
        canvas.restore();
        DrawContext drawContext2 = drawScope.getDrawContext();
        drawContext2.setDensity(density2);
        drawContext2.setLayoutDirection(layoutDirection2);
        drawContext2.setCanvas(canvas2);
        drawContext2.m4413setSizeuvyYCjk(r3);
    }

    public static final void inset(DrawScope drawScope, float f, float f2, Function1<? super DrawScope, Unit> function1) {
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        function1.invoke(drawScope);
        float f3 = -f;
        float f4 = -f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
    }

    public static /* synthetic */ void inset$default(DrawScope drawScope, float f, float f2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        drawScope.getDrawContext().getTransform().inset(f, f2, f, f2);
        function1.invoke(drawScope);
        float f3 = -f;
        float f4 = -f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
    }

    /* renamed from: rotate-Rg1IO4c  reason: not valid java name */
    public static final void m4514rotateRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4526rotateUv8p0NA(f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r1);
    }

    /* renamed from: rotateRad-Rg1IO4c  reason: not valid java name */
    public static final void m4516rotateRadRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4526rotateUv8p0NA(DegreesKt.degrees(f), j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r1);
    }

    /* renamed from: scale-Fgt4K4Q  reason: not valid java name */
    public static final void m4518scaleFgt4K4Q(DrawScope drawScope, float f, float f2, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4527scale0AR0LA0(f, f2, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r1);
    }

    /* renamed from: scale-Rg1IO4c  reason: not valid java name */
    public static final void m4520scaleRg1IO4c(DrawScope drawScope, float f, long j, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4527scale0AR0LA0(f, f, j);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r1);
    }

    /* renamed from: clipRect-rOu3jXo  reason: not valid java name */
    public static final void m4511clipRectrOu3jXo(DrawScope drawScope, float f, float f2, float f3, float f4, int i, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4523clipRectN_I0leg(f, f2, f3, f4, i);
        DrawScope drawScope2 = drawScope;
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r1);
    }

    /* renamed from: clipPath-KD09W0M  reason: not valid java name */
    public static final void m4509clipPathKD09W0M(DrawScope drawScope, Path path, int i, Function1<? super DrawScope, Unit> function1) {
        DrawContext drawContext = drawScope.getDrawContext();
        long r1 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4522clipPathmtrdDE(path, i);
        function1.invoke(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r1);
    }
}
