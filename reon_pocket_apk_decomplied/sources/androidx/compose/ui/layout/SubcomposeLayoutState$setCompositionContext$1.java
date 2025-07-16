package androidx.compose.ui.layout;

import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/compose/runtime/CompositionContext;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class SubcomposeLayoutState$setCompositionContext$1 extends Lambda implements Function2<LayoutNode, CompositionContext, Unit> {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$setCompositionContext$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (CompositionContext) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode layoutNode, CompositionContext compositionContext) {
        this.this$0.getState().setCompositionContext(compositionContext);
    }
}
