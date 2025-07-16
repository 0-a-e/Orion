package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.OutlineKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\f\u0010$\u001a\u00020%*\u00020&H\u0016J\f\u0010'\u001a\u00020%*\u00020&H\u0002J\f\u0010(\u001a\u00020%*\u00020&H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/BackgroundNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "color", "Landroidx/compose/ui/graphics/Color;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "(JLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "lastLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "lastShape", "lastSize", "Landroidx/compose/ui/geometry/Size;", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawOutline", "drawRect", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Background.kt */
final class BackgroundNode extends Modifier.Node implements DrawModifierNode {
    private float alpha;
    private Brush brush;
    private long color;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Shape lastShape;
    private Size lastSize;
    private Shape shape;

    public /* synthetic */ BackgroundNode(long j, Brush brush2, float f, Shape shape2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, brush2, f, shape2);
    }

    public /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m215getColor0d7_KjU() {
        return this.color;
    }

    /* renamed from: setColor-8_81llA  reason: not valid java name */
    public final void m216setColor8_81llA(long j) {
        this.color = j;
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush2) {
        this.brush = brush2;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape2) {
        this.shape = shape2;
    }

    private BackgroundNode(long j, Brush brush2, float f, Shape shape2) {
        this.color = j;
        this.brush = brush2;
        this.alpha = f;
        this.shape = shape2;
    }

    public void draw(ContentDrawScope contentDrawScope) {
        if (this.shape == RectangleShapeKt.getRectangleShape()) {
            drawRect(contentDrawScope);
        } else {
            drawOutline(contentDrawScope);
        }
        contentDrawScope.drawContent();
    }

    private final void drawRect(ContentDrawScope contentDrawScope) {
        if (!Color.m3817equalsimpl0(this.color, Color.Companion.m3852getUnspecified0d7_KjU())) {
            DrawScope.CC.m4470drawRectnJ9OG0$default(contentDrawScope, this.color, 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        }
        Brush brush2 = this.brush;
        if (brush2 != null) {
            DrawScope.CC.m4469drawRectAsUm42w$default(contentDrawScope, brush2, 0, 0, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 118, (Object) null);
        }
    }

    private final void drawOutline(ContentDrawScope contentDrawScope) {
        Outline outline;
        if (!Size.m3626equalsimpl(contentDrawScope.m4434getSizeNHjbRc(), this.lastSize) || contentDrawScope.getLayoutDirection() != this.lastLayoutDirection || !Intrinsics.areEqual((Object) this.lastShape, (Object) this.shape)) {
            outline = this.shape.m4201createOutlinePq9zytI(contentDrawScope.m4434getSizeNHjbRc(), contentDrawScope.getLayoutDirection(), contentDrawScope);
        } else {
            outline = this.lastOutline;
            Intrinsics.checkNotNull(outline);
        }
        if (!Color.m3817equalsimpl0(this.color, Color.Companion.m3852getUnspecified0d7_KjU())) {
            OutlineKt.m4086drawOutlinewDX37Ww$default(contentDrawScope, outline, this.color, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        }
        Brush brush2 = this.brush;
        if (brush2 != null) {
            OutlineKt.m4084drawOutlinehn5TExg$default(contentDrawScope, outline, brush2, this.alpha, (DrawStyle) null, (ColorFilter) null, 0, 56, (Object) null);
        }
        this.lastOutline = outline;
        this.lastSize = Size.m3619boximpl(contentDrawScope.m4434getSizeNHjbRc());
        this.lastLayoutDirection = contentDrawScope.getLayoutDirection();
        this.lastShape = this.shape;
    }
}
