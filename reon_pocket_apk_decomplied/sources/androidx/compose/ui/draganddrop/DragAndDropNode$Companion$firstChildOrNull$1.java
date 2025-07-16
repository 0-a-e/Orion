package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "child", "Landroidx/compose/ui/node/TraversableNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
public final class DragAndDropNode$Companion$firstChildOrNull$1 extends Lambda implements Function1<TraversableNode, TraversableNode.Companion.TraverseDescendantsAction> {
    final /* synthetic */ Ref.ObjectRef<DragAndDropModifierNode> $match;
    final /* synthetic */ Function1<DragAndDropModifierNode, Boolean> $predicate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragAndDropNode$Companion$firstChildOrNull$1(Function1<? super DragAndDropModifierNode, Boolean> function1, Ref.ObjectRef<DragAndDropModifierNode> objectRef) {
        super(1);
        this.$predicate = function1;
        this.$match = objectRef;
    }

    public final TraversableNode.Companion.TraverseDescendantsAction invoke(TraversableNode traversableNode) {
        if (!(traversableNode instanceof DragAndDropModifierNode) || !this.$predicate.invoke(traversableNode).booleanValue()) {
            return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
        }
        this.$match.element = traversableNode;
        return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
    }
}
