package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u001d\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\b\bH\n¢\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "it", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class SubcomposeLayoutState$setMeasurePolicy$1 extends Lambda implements Function2<LayoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>, Unit> {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$setMeasurePolicy$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult>) (Function2) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode layoutNode, Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> function2) {
        layoutNode.setMeasurePolicy(this.this$0.getState().createMeasurePolicy(function2));
    }
}
