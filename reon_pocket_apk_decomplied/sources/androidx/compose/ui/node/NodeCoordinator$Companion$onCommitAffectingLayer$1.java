package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
final class NodeCoordinator$Companion$onCommitAffectingLayer$1 extends Lambda implements Function1<NodeCoordinator, Unit> {
    public static final NodeCoordinator$Companion$onCommitAffectingLayer$1 INSTANCE = new NodeCoordinator$Companion$onCommitAffectingLayer$1();

    NodeCoordinator$Companion$onCommitAffectingLayer$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NodeCoordinator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(NodeCoordinator nodeCoordinator) {
        OwnedLayer layer = nodeCoordinator.getLayer();
        if (layer != null) {
            layer.invalidate();
        }
    }
}
