package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 (2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001(B*\u0012#\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J;\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00160\u0005¢\u0006\u0002\b\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "onDragAndDropStart", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "(Lkotlin/jvm/functions/Function1;)V", "lastChildDragAndDropModifierNode", "thisDragAndDropTarget", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "acceptDragAndDropTransfer", "", "startEvent", "drag", "", "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)V", "onChanged", "onDetach", "onDrop", "onEnded", "onEntered", "onExited", "onMoved", "onStarted", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, DragAndDropModifierNode {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DragAndDropModifierNode lastChildDragAndDropModifierNode;
    private final Function1<DragAndDropEvent, DragAndDropTarget> onDragAndDropStart;
    private DragAndDropTarget thisDragAndDropTarget;
    private final Object traverseKey = Companion.DragAndDropTraversableKey.INSTANCE;

    public DragAndDropNode(Function1<? super DragAndDropEvent, ? extends DragAndDropTarget> function1) {
        this.onDragAndDropStart = function1;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion;", "", "()V", "firstChildOrNull", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "predicate", "Lkotlin/Function1;", "", "DragAndDropTraversableKey", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DragAndDropNode.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion$DragAndDropTraversableKey;", "", "()V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: DragAndDropNode.kt */
        private static final class DragAndDropTraversableKey {
            public static final DragAndDropTraversableKey INSTANCE = new DragAndDropTraversableKey();

            private DragAndDropTraversableKey() {
            }
        }

        private Companion() {
        }

        private final DragAndDropModifierNode firstChildOrNull(DragAndDropModifierNode dragAndDropModifierNode, Function1<? super DragAndDropModifierNode, Boolean> function1) {
            if (!dragAndDropModifierNode.getNode().isAttached()) {
                return null;
            }
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TraversableNodeKt.traverseDescendants(dragAndDropModifierNode, DragAndDropTraversableKey.INSTANCE, new DragAndDropNode$Companion$firstChildOrNull$1(function1, objectRef));
            return (DragAndDropModifierNode) objectRef.element;
        }
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public void onDetach() {
        this.thisDragAndDropTarget = null;
        this.lastChildDragAndDropModifierNode = null;
    }

    /* renamed from: drag-12SF9DM  reason: not valid java name */
    public void m3434drag12SF9DM(DragAndDropTransferData dragAndDropTransferData, long j, Function1<? super DrawScope, Unit> function1) {
        DelegatableNodeKt.requireOwner(this).getDragAndDropManager().m3432drag12SF9DM(dragAndDropTransferData, j, function1);
    }

    public boolean acceptDragAndDropTransfer(DragAndDropEvent dragAndDropEvent) {
        if (!isAttached()) {
            return false;
        }
        if (this.thisDragAndDropTarget == null) {
            this.thisDragAndDropTarget = this.onDragAndDropStart.invoke(dragAndDropEvent);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            TraversableNodeKt.traverseChildren(this, new DragAndDropNode$acceptDragAndDropTransfer$2(booleanRef, dragAndDropEvent, this));
            if (booleanRef.element || this.thisDragAndDropTarget != null) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("DragAndDropTarget self reference must be null at the start of a drag and drop session".toString());
    }

    public void onStarted(DragAndDropEvent dragAndDropEvent) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget == null) {
            DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
            if (dragAndDropModifierNode != null) {
                dragAndDropModifierNode.onStarted(dragAndDropEvent);
                return;
            }
            return;
        }
        dragAndDropTarget.onStarted(dragAndDropEvent);
    }

    public void onEntered(DragAndDropEvent dragAndDropEvent) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget == null) {
            DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
            if (dragAndDropModifierNode != null) {
                dragAndDropModifierNode.onEntered(dragAndDropEvent);
                return;
            }
            return;
        }
        dragAndDropTarget.onEntered(dragAndDropEvent);
    }

    public void onMoved(DragAndDropEvent dragAndDropEvent) {
        DragAndDropModifierNode dragAndDropModifierNode;
        DragAndDropModifierNode dragAndDropModifierNode2 = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode2 == null || !DragAndDropNodeKt.m3436containsUv8p0NA(dragAndDropModifierNode2, DragAndDrop_androidKt.getPositionInRoot(dragAndDropEvent))) {
            DragAndDropModifierNode dragAndDropModifierNode3 = this;
            if (!dragAndDropModifierNode3.getNode().isAttached()) {
                dragAndDropModifierNode = null;
            } else {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                TraversableNodeKt.traverseDescendants(dragAndDropModifierNode3, Companion.DragAndDropTraversableKey.INSTANCE, new DragAndDropNode$onMoved$$inlined$firstChildOrNull$1(objectRef, this, dragAndDropEvent));
                dragAndDropModifierNode = (DragAndDropModifierNode) objectRef.element;
            }
        } else {
            dragAndDropModifierNode = dragAndDropModifierNode2;
        }
        if (dragAndDropModifierNode != null && dragAndDropModifierNode2 == null) {
            DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
            if (dragAndDropTarget != null) {
                dragAndDropTarget.onExited(dragAndDropEvent);
            }
            DragAndDropNodeKt.dispatchEntered(dragAndDropModifierNode, dragAndDropEvent);
        } else if (dragAndDropModifierNode == null && dragAndDropModifierNode2 != null) {
            dragAndDropModifierNode2.onExited(dragAndDropEvent);
            DragAndDropTarget dragAndDropTarget2 = this.thisDragAndDropTarget;
            if (dragAndDropTarget2 != null) {
                DragAndDropNodeKt.dispatchEntered(dragAndDropTarget2, dragAndDropEvent);
            }
        } else if (!Intrinsics.areEqual((Object) dragAndDropModifierNode, (Object) dragAndDropModifierNode2)) {
            if (dragAndDropModifierNode2 != null) {
                dragAndDropModifierNode2.onExited(dragAndDropEvent);
            }
            if (dragAndDropModifierNode != null) {
                DragAndDropNodeKt.dispatchEntered(dragAndDropModifierNode, dragAndDropEvent);
            }
        } else if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onMoved(dragAndDropEvent);
        } else {
            DragAndDropTarget dragAndDropTarget3 = this.thisDragAndDropTarget;
            if (dragAndDropTarget3 != null) {
                dragAndDropTarget3.onMoved(dragAndDropEvent);
            }
        }
        this.lastChildDragAndDropModifierNode = dragAndDropModifierNode;
    }

    public void onChanged(DragAndDropEvent dragAndDropEvent) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget == null) {
            DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
            if (dragAndDropModifierNode != null) {
                dragAndDropModifierNode.onChanged(dragAndDropEvent);
                return;
            }
            return;
        }
        dragAndDropTarget.onChanged(dragAndDropEvent);
    }

    public void onExited(DragAndDropEvent dragAndDropEvent) {
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            dragAndDropTarget.onExited(dragAndDropEvent);
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            dragAndDropModifierNode.onExited(dragAndDropEvent);
        }
        this.lastChildDragAndDropModifierNode = null;
    }

    public boolean onDrop(DragAndDropEvent dragAndDropEvent) {
        DragAndDropModifierNode dragAndDropModifierNode = this.lastChildDragAndDropModifierNode;
        if (dragAndDropModifierNode != null) {
            return dragAndDropModifierNode.onDrop(dragAndDropEvent);
        }
        DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
        if (dragAndDropTarget != null) {
            return dragAndDropTarget.onDrop(dragAndDropEvent);
        }
        return false;
    }

    public void onEnded(DragAndDropEvent dragAndDropEvent) {
        if (getNode().isAttached()) {
            TraversableNodeKt.traverseChildren(this, new DragAndDropNode$onEnded$1(dragAndDropEvent));
            DragAndDropTarget dragAndDropTarget = this.thisDragAndDropTarget;
            if (dragAndDropTarget != null) {
                dragAndDropTarget.onEnded(dragAndDropEvent);
            }
            this.thisDragAndDropTarget = null;
            this.lastChildDragAndDropModifierNode = null;
        }
    }
}
