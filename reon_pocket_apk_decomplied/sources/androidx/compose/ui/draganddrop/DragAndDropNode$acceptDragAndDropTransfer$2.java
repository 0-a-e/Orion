package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "child", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "invoke", "(Landroidx/compose/ui/draganddrop/DragAndDropNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
final class DragAndDropNode$acceptDragAndDropTransfer$2 extends Lambda implements Function1<DragAndDropNode, Boolean> {
    final /* synthetic */ Ref.BooleanRef $handledByChild;
    final /* synthetic */ DragAndDropEvent $startEvent;
    final /* synthetic */ DragAndDropNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragAndDropNode$acceptDragAndDropTransfer$2(Ref.BooleanRef booleanRef, DragAndDropEvent dragAndDropEvent, DragAndDropNode dragAndDropNode) {
        super(1);
        this.$handledByChild = booleanRef;
        this.$startEvent = dragAndDropEvent;
        this.this$0 = dragAndDropNode;
    }

    public final Boolean invoke(DragAndDropNode dragAndDropNode) {
        Ref.BooleanRef booleanRef = this.$handledByChild;
        boolean z = booleanRef.element;
        boolean acceptDragAndDropTransfer = dragAndDropNode.acceptDragAndDropTransfer(this.$startEvent);
        DragAndDropNode dragAndDropNode2 = this.this$0;
        if (acceptDragAndDropTransfer) {
            DelegatableNodeKt.requireOwner(dragAndDropNode2).getDragAndDropManager().registerNodeInterest(dragAndDropNode);
        }
        Unit unit = Unit.INSTANCE;
        booleanRef.element = z | acceptDragAndDropTransfer;
        return true;
    }
}
