package androidx.compose.material3;

import androidx.compose.foundation.gestures.DragScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, d2 = {"<anonymous>", "", "T", "Landroidx/compose/material3/AnchoredDragScope;", "it", "Landroidx/compose/material3/DraggableAnchors;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.AnchoredDraggableState$draggableState$1$drag$2", f = "AnchoredDraggable.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnchoredDraggable.kt */
final class AnchoredDraggableState$draggableState$1$drag$2 extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> $block;
    int label;
    final /* synthetic */ AnchoredDraggableState$draggableState$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnchoredDraggableState$draggableState$1$drag$2(AnchoredDraggableState$draggableState$1 anchoredDraggableState$draggableState$1, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnchoredDraggableState$draggableState$1$drag$2> continuation) {
        super(3, continuation);
        this.this$0 = anchoredDraggableState$draggableState$1;
        this.$block = function2;
    }

    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors<T> draggableAnchors, Continuation<? super Unit> continuation) {
        return new AnchoredDraggableState$draggableState$1$drag$2(this.this$0, this.$block, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnchoredDraggableState$draggableState$1$dragScope$1 access$getDragScope$p = this.this$0.dragScope;
            Function2<DragScope, Continuation<? super Unit>, Object> function2 = this.$block;
            this.label = 1;
            if (function2.invoke(access$getDragScope$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
