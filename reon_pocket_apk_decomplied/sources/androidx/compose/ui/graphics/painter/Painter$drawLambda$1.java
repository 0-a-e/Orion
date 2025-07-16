package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Painter.kt */
final class Painter$drawLambda$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ Painter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Painter$drawLambda$1(Painter painter) {
        super(1);
        this.this$0 = painter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawScope drawScope) {
        this.this$0.onDraw(drawScope);
    }
}
