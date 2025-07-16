package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B0\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u0013\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\f\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/draganddrop/DropTargetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/draganddrop/DragAndDropTargetNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/draganddrop/DragAndDropTarget;)V", "getShouldStartDragAndDrop", "()Lkotlin/jvm/functions/Function1;", "getTarget", "()Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "create", "equals", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropTarget.kt */
final class DropTargetElement extends ModifierNodeElement<DragAndDropTargetNode> {
    private final Function1<DragAndDropEvent, Boolean> shouldStartDragAndDrop;
    private final DragAndDropTarget target;

    public final Function1<DragAndDropEvent, Boolean> getShouldStartDragAndDrop() {
        return this.shouldStartDragAndDrop;
    }

    public final DragAndDropTarget getTarget() {
        return this.target;
    }

    public DropTargetElement(Function1<? super DragAndDropEvent, Boolean> function1, DragAndDropTarget dragAndDropTarget) {
        this.shouldStartDragAndDrop = function1;
        this.target = dragAndDropTarget;
    }

    public DragAndDropTargetNode create() {
        return new DragAndDropTargetNode(this.shouldStartDragAndDrop, this.target);
    }

    public void update(DragAndDropTargetNode dragAndDropTargetNode) {
        dragAndDropTargetNode.setTarget(this.target);
        dragAndDropTargetNode.setShouldStartDragAndDrop(this.shouldStartDragAndDrop);
    }

    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("dropTarget");
        inspectorInfo.getProperties().set("target", this.target);
        inspectorInfo.getProperties().set("shouldStartDragAndDrop", this.shouldStartDragAndDrop);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DropTargetElement)) {
            return false;
        }
        DropTargetElement dropTargetElement = (DropTargetElement) obj;
        if (!Intrinsics.areEqual((Object) this.target, (Object) dropTargetElement.target)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.shouldStartDragAndDrop, (Object) dropTargetElement.shouldStartDragAndDrop);
    }

    public int hashCode() {
        return (this.target.hashCode() * 31) + this.shouldStartDragAndDrop.hashCode();
    }
}
