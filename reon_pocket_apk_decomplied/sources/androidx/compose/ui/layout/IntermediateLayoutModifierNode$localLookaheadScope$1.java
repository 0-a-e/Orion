package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntermediateLayoutModifierNode.kt */
final class IntermediateLayoutModifierNode$localLookaheadScope$1 extends Lambda implements Function0<LayoutCoordinates> {
    final /* synthetic */ IntermediateLayoutModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntermediateLayoutModifierNode$localLookaheadScope$1(IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
        super(0);
        this.this$0 = intermediateLayoutModifierNode;
    }

    public final LayoutCoordinates invoke() {
        NodeCoordinator coordinator$ui_release = this.this$0.getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        return coordinator$ui_release;
    }
}
