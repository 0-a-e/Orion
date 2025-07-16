package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntermediateLayoutModifierNode.kt */
final class IntermediateLayoutModifierNode$onAttach$2 extends Lambda implements Function0<LayoutCoordinates> {
    final /* synthetic */ LayoutNode $closestLookaheadRoot;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntermediateLayoutModifierNode$onAttach$2(LayoutNode layoutNode) {
        super(0);
        this.$closestLookaheadRoot = layoutNode;
    }

    public final LayoutCoordinates invoke() {
        LayoutNode parent$ui_release = this.$closestLookaheadRoot.getParent$ui_release();
        Intrinsics.checkNotNull(parent$ui_release);
        return parent$ui_release.getInnerCoordinator$ui_release().getCoordinates();
    }
}
