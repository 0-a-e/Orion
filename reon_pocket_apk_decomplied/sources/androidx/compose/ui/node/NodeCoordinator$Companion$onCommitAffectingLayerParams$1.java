package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
final class NodeCoordinator$Companion$onCommitAffectingLayerParams$1 extends Lambda implements Function1<NodeCoordinator, Unit> {
    public static final NodeCoordinator$Companion$onCommitAffectingLayerParams$1 INSTANCE = new NodeCoordinator$Companion$onCommitAffectingLayerParams$1();

    NodeCoordinator$Companion$onCommitAffectingLayerParams$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NodeCoordinator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NodeCoordinator nodeCoordinator) {
        if (nodeCoordinator.isValidOwnerScope()) {
            LayerPositionalProperties access$getLayerPositionalProperties$p = nodeCoordinator.layerPositionalProperties;
            if (access$getLayerPositionalProperties$p == null) {
                NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, (Object) null);
                return;
            }
            NodeCoordinator.tmpLayerPositionalProperties.copyFrom(access$getLayerPositionalProperties$p);
            NodeCoordinator.updateLayerParameters$default(nodeCoordinator, false, 1, (Object) null);
            if (!NodeCoordinator.tmpLayerPositionalProperties.hasSameValuesAs(access$getLayerPositionalProperties$p)) {
                LayoutNode layoutNode = nodeCoordinator.getLayoutNode();
                LayoutNodeLayoutDelegate layoutDelegate$ui_release = layoutNode.getLayoutDelegate$ui_release();
                if (layoutDelegate$ui_release.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                    if (layoutDelegate$ui_release.getCoordinatesAccessedDuringModifierPlacement() || layoutDelegate$ui_release.getCoordinatesAccessedDuringPlacement()) {
                        LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, (Object) null);
                    }
                    layoutDelegate$ui_release.getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                }
                Owner owner$ui_release = layoutNode.getOwner$ui_release();
                if (owner$ui_release != null) {
                    owner$ui_release.requestOnPositionedCallback(layoutNode);
                }
            }
        }
    }
}
