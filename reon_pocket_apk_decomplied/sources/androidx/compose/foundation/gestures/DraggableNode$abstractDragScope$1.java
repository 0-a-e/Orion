package androidx.compose.foundation.gestures;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\b"}, d2 = {"androidx/compose/foundation/gestures/DraggableNode$abstractDragScope$1", "Landroidx/compose/foundation/gestures/AbstractDragScope;", "dragBy", "", "pixels", "Landroidx/compose/ui/geometry/Offset;", "dragBy-k-4lQ0M", "(J)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Draggable.kt */
public final class DraggableNode$abstractDragScope$1 implements AbstractDragScope {
    final /* synthetic */ DraggableNode this$0;

    DraggableNode$abstractDragScope$1(DraggableNode draggableNode) {
        this.this$0 = draggableNode;
    }

    /* renamed from: dragBy-k-4lQ0M  reason: not valid java name */
    public void m405dragByk4lQ0M(long j) {
        this.this$0.getDragScope().dragBy(DraggableKt.m400toFloat3MmeM6k(j, this.this$0.orientation));
    }
}
