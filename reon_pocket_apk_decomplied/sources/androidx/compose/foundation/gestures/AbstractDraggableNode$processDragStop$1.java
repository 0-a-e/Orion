package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AbstractDraggableNode", f = "Draggable.kt", i = {0, 0, 0}, l = {546, 549}, m = "processDragStop", n = {"this", "$this$processDragStop", "event"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: Draggable.kt */
final class AbstractDraggableNode$processDragStop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbstractDraggableNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractDraggableNode$processDragStop$1(AbstractDraggableNode abstractDraggableNode, Continuation<? super AbstractDraggableNode$processDragStop$1> continuation) {
        super(continuation);
        this.this$0 = abstractDraggableNode;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processDragStop((CoroutineScope) null, (DragEvent.DragStopped) null, this);
    }
}
