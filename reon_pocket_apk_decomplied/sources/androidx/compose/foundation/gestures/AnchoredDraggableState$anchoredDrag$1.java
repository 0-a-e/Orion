package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState", f = "AnchoredDraggable.kt", i = {0}, l = {520}, m = "anchoredDrag", n = {"this"}, s = {"L$0"})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$anchoredDrag$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$anchoredDrag$1(AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super AnchoredDraggableState$anchoredDrag$1> continuation) {
        super(continuation);
        this.this$0 = anchoredDraggableState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.anchoredDrag((MutatePriority) null, (Function3) null, this);
    }
}
