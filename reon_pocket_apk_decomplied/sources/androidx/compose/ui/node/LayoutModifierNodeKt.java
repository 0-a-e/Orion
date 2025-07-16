package androidx.compose.ui.node;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0007"}, d2 = {"invalidateLayer", "", "Landroidx/compose/ui/node/LayoutModifierNode;", "invalidateMeasurement", "invalidatePlacement", "remeasureSync", "requestRemeasure", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutModifierNode.kt */
public final class LayoutModifierNodeKt {
    public static final void remeasureSync(LayoutModifierNode layoutModifierNode) {
        DelegatableNodeKt.requireLayoutNode(layoutModifierNode).forceRemeasure();
    }

    public static final void invalidateLayer(LayoutModifierNode layoutModifierNode) {
        DelegatableNodeKt.m5468requireCoordinator64DMado(layoutModifierNode, NodeKind.m5647constructorimpl(2)).invalidateLayer();
    }

    public static final void invalidatePlacement(LayoutModifierNode layoutModifierNode) {
        LayoutNode.requestRelayout$ui_release$default(DelegatableNodeKt.requireLayoutNode(layoutModifierNode), false, 1, (Object) null);
    }

    public static final void invalidateMeasurement(LayoutModifierNode layoutModifierNode) {
        DelegatableNodeKt.requireLayoutNode(layoutModifierNode).invalidateMeasurements$ui_release();
    }

    public static final void requestRemeasure(LayoutModifierNode layoutModifierNode) {
        LayoutNode.requestRemeasure$ui_release$default(DelegatableNodeKt.requireLayoutNode(layoutModifierNode), false, false, 3, (Object) null);
    }
}
