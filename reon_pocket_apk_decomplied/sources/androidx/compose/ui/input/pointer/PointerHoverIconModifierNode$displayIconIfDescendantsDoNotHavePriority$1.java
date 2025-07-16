package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "it", "Landroidx/compose/ui/input/pointer/PointerHoverIconModifierNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PointerIcon.kt */
final class PointerHoverIconModifierNode$displayIconIfDescendantsDoNotHavePriority$1 extends Lambda implements Function1<PointerHoverIconModifierNode, TraversableNode.Companion.TraverseDescendantsAction> {
    final /* synthetic */ Ref.BooleanRef $hasIconRightsOverDescendants;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PointerHoverIconModifierNode$displayIconIfDescendantsDoNotHavePriority$1(Ref.BooleanRef booleanRef) {
        super(1);
        this.$hasIconRightsOverDescendants = booleanRef;
    }

    public final TraversableNode.Companion.TraverseDescendantsAction invoke(PointerHoverIconModifierNode pointerHoverIconModifierNode) {
        if (!pointerHoverIconModifierNode.cursorInBoundsOfNode) {
            return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
        }
        this.$hasIconRightsOverDescendants.element = false;
        return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
    }
}
