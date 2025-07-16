package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Vector.kt */
final class VectorComponent$drawVectorBlock$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ VectorComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VectorComponent$drawVectorBlock$1(VectorComponent vectorComponent) {
        super(1);
        this.this$0 = vectorComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        GroupComponent root = this.this$0.getRoot();
        VectorComponent vectorComponent = this.this$0;
        float access$getRootScaleX$p = vectorComponent.rootScaleX;
        float access$getRootScaleY$p = vectorComponent.rootScaleY;
        long r3 = Offset.Companion.m3578getZeroF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long r6 = drawContext.m4412getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().m4527scale0AR0LA0(access$getRootScaleX$p, access$getRootScaleY$p, r3);
        root.draw(drawScope);
        drawContext.getCanvas().restore();
        drawContext.m4413setSizeuvyYCjk(r6);
    }
}
