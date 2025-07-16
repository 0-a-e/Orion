package androidx.compose.ui.draganddrop;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a1\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u000b\u001a\u00020\b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"DragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", "target", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "contains", "position", "Landroidx/compose/ui/geometry/Offset;", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;J)Z", "dispatchEntered", "", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DragAndDropNode.kt */
public final class DragAndDropNodeKt {
    public static final DragAndDropModifierNode DragAndDropModifierNode() {
        return new DragAndDropNode(DragAndDropNodeKt$DragAndDropModifierNode$1.INSTANCE);
    }

    public static final DragAndDropModifierNode DragAndDropModifierNode(Function1<? super DragAndDropEvent, Boolean> function1, DragAndDropTarget dragAndDropTarget) {
        return new DragAndDropNode(new DragAndDropNodeKt$DragAndDropModifierNode$2(function1, dragAndDropTarget));
    }

    /* access modifiers changed from: private */
    public static final void dispatchEntered(DragAndDropTarget dragAndDropTarget, DragAndDropEvent dragAndDropEvent) {
        dragAndDropTarget.onEntered(dragAndDropEvent);
        dragAndDropTarget.onMoved(dragAndDropEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: contains-Uv8p0NA  reason: not valid java name */
    public static final boolean m3436containsUv8p0NA(DragAndDropModifierNode dragAndDropModifierNode, long j) {
        if (!dragAndDropModifierNode.getNode().isAttached()) {
            return false;
        }
        LayoutCoordinates coordinates = DelegatableNodeKt.requireLayoutNode(dragAndDropModifierNode).getCoordinates();
        if (!coordinates.isAttached()) {
            return false;
        }
        long r2 = coordinates.m5318getSizeYbymL2g();
        int r0 = IntSize.m6790getWidthimpl(r2);
        int r22 = IntSize.m6789getHeightimpl(r2);
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
        float r5 = Offset.m3552component1impl(positionInRoot);
        float r3 = Offset.m3553component2impl(positionInRoot);
        float f = ((float) r0) + r5;
        float f2 = ((float) r22) + r3;
        float r4 = Offset.m3562getXimpl(j);
        if (r5 > r4 || r4 > f) {
            return false;
        }
        float r52 = Offset.m3563getYimpl(j);
        if (r3 > r52 || r52 > f2) {
            return false;
        }
        return true;
    }
}
