package androidx.compose.ui.draganddrop;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "child", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "invoke", "(Landroidx/compose/ui/draganddrop/DragAndDropNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
final class DragAndDropNode$onEnded$1 extends Lambda implements Function1<DragAndDropNode, Boolean> {
    final /* synthetic */ DragAndDropEvent $event;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragAndDropNode$onEnded$1(DragAndDropEvent dragAndDropEvent) {
        super(1);
        this.$event = dragAndDropEvent;
    }

    public final Boolean invoke(DragAndDropNode dragAndDropNode) {
        dragAndDropNode.onEnded(this.$event);
        return true;
    }
}
