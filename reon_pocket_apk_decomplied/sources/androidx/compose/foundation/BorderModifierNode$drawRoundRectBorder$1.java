package androidx.compose.foundation;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Border.kt */
final class BorderModifierNode$drawRoundRectBorder$1 extends Lambda implements Function1<ContentDrawScope, Unit> {
    final /* synthetic */ long $borderSize;
    final /* synthetic */ Stroke $borderStroke;
    final /* synthetic */ Brush $brush;
    final /* synthetic */ long $cornerRadius;
    final /* synthetic */ boolean $fillArea;
    final /* synthetic */ float $halfStroke;
    final /* synthetic */ float $strokeWidth;
    final /* synthetic */ long $topLeft;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BorderModifierNode$drawRoundRectBorder$1(boolean z, Brush brush, long j, float f, float f2, long j2, long j3, Stroke stroke) {
        super(1);
        this.$fillArea = z;
        this.$brush = brush;
        this.$cornerRadius = j;
        this.$halfStroke = f;
        this.$strokeWidth = f2;
        this.$topLeft = j2;
        this.$borderSize = j3;
        this.$borderStroke = stroke;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentDrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (this.$fillArea) {
            DrawScope.CC.m4471drawRoundRectZuiqVtQ$default(contentDrawScope, this.$brush, 0, 0, this.$cornerRadius, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            return;
        }
        float r1 = CornerRadius.m3537getXimpl(this.$cornerRadius);
        float f = this.$halfStroke;
        if (r1 < f) {
            DrawScope drawScope = contentDrawScope;
            float f2 = this.$strokeWidth;
            float r7 = Size.m3631getWidthimpl(contentDrawScope.m4434getSizeNHjbRc()) - this.$strokeWidth;
            float r8 = Size.m3628getHeightimpl(contentDrawScope.m4434getSizeNHjbRc()) - this.$strokeWidth;
            int r9 = ClipOp.Companion.m3804getDifferencertfAjoo();
            Brush brush = this.$brush;
            long j = this.$cornerRadius;
            DrawContext drawContext = drawScope.getDrawContext();
            long r14 = drawContext.m4412getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().m4523clipRectN_I0leg(f2, f2, r7, r8, r9);
            DrawScope.CC.m4471drawRoundRectZuiqVtQ$default(drawScope, brush, 0, 0, j, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 246, (Object) null);
            drawContext.getCanvas().restore();
            drawContext.m4413setSizeuvyYCjk(r14);
            return;
        }
        DrawScope.CC.m4471drawRoundRectZuiqVtQ$default(contentDrawScope, this.$brush, this.$topLeft, this.$borderSize, BorderKt.m229shrinkKibmq7A(this.$cornerRadius, f), 0.0f, this.$borderStroke, (ColorFilter) null, 0, 208, (Object) null);
    }
}
