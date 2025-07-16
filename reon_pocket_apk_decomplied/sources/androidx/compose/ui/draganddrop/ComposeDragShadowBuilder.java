package androidx.compose.ui.draganddrop;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B.\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/draganddrop/ComposeDragShadowBuilder;", "Landroid/view/View$DragShadowBuilder;", "density", "Landroidx/compose/ui/unit/Density;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "onDrawShadow", "canvas", "Landroid/graphics/Canvas;", "onProvideShadowMetrics", "outShadowSize", "Landroid/graphics/Point;", "outShadowTouchPoint", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeDragShadowBuilder.android.kt */
public final class ComposeDragShadowBuilder extends View.DragShadowBuilder {
    public static final int $stable = 0;
    private final long decorationSize;
    private final Density density;
    private final Function1<DrawScope, Unit> drawDragDecoration;

    public /* synthetic */ ComposeDragShadowBuilder(Density density2, long j, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(density2, j, function1);
    }

    private ComposeDragShadowBuilder(Density density2, long j, Function1<? super DrawScope, Unit> function1) {
        this.density = density2;
        this.decorationSize = j;
        this.drawDragDecoration = function1;
    }

    public void onProvideShadowMetrics(Point point, Point point2) {
        Density density2 = this.density;
        point.set(density2.m6545roundToPx0680j_4(density2.m6546toDpu2uoSUM(Size.m3631getWidthimpl(this.decorationSize))), density2.m6545roundToPx0680j_4(density2.m6546toDpu2uoSUM(Size.m3628getHeightimpl(this.decorationSize))));
        point2.set(point.x / 2, point.y / 2);
    }

    public void onDrawShadow(Canvas canvas) {
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        Density density2 = this.density;
        long j = this.decorationSize;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        androidx.compose.ui.graphics.Canvas Canvas = AndroidCanvas_androidKt.Canvas(canvas);
        Function1<DrawScope, Unit> function1 = this.drawDragDecoration;
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        androidx.compose.ui.graphics.Canvas component3 = drawParams.component3();
        long r10 = drawParams.m4369component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.getDrawParams();
        drawParams2.setDensity(density2);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(Canvas);
        drawParams2.m4372setSizeuvyYCjk(j);
        Canvas.save();
        function1.invoke(canvasDrawScope);
        Canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m4372setSizeuvyYCjk(r10);
    }
}
