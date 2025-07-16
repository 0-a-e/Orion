package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.AnchoredDragScope;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/gestures/AnchoredDraggableState$draggableState$1$dragScope$1", "Landroidx/compose/foundation/gestures/DragScope;", "dragBy", "", "pixels", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnchoredDraggable.kt */
public final class AnchoredDraggableState$draggableState$1$dragScope$1 implements DragScope {
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    AnchoredDraggableState$draggableState$1$dragScope$1(AnchoredDraggableState<T> anchoredDraggableState) {
        this.this$0 = anchoredDraggableState;
    }

    public void dragBy(float f) {
        AnchoredDragScope.CC.dragTo$default(this.this$0.anchoredDragScope, this.this$0.newOffsetForDelta$foundation_release(f), 0.0f, 2, (Object) null);
    }
}
