package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AbstractDraggableNode", f = "Draggable.kt", i = {0, 0}, l = {554, 557}, m = "processDragCancel", n = {"this", "$this$processDragCancel"}, s = {"L$0", "L$1"})
/* compiled from: Draggable.kt */
final class AbstractDraggableNode$processDragCancel$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbstractDraggableNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractDraggableNode$processDragCancel$1(AbstractDraggableNode abstractDraggableNode, Continuation<? super AbstractDraggableNode$processDragCancel$1> continuation) {
        super(continuation);
        this.this$0 = abstractDraggableNode;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processDragCancel((CoroutineScope) null, this);
    }
}
