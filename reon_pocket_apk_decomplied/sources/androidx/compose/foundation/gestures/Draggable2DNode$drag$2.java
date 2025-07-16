package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Drag2DScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.Draggable2DNode$drag$2", f = "Draggable2D.kt", i = {}, l = {288}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Draggable2D.kt */
final class Draggable2DNode$drag$2 extends SuspendLambda implements Function2<Drag2DScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<AbstractDragScope, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Draggable2DNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Draggable2DNode$drag$2(Draggable2DNode draggable2DNode, Function2<? super AbstractDragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Draggable2DNode$drag$2> continuation) {
        super(2, continuation);
        this.this$0 = draggable2DNode;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Draggable2DNode$drag$2 draggable2DNode$drag$2 = new Draggable2DNode$drag$2(this.this$0, this.$block, continuation);
        draggable2DNode$drag$2.L$0 = obj;
        return draggable2DNode$drag$2;
    }

    public final Object invoke(Drag2DScope drag2DScope, Continuation<? super Unit> continuation) {
        return ((Draggable2DNode$drag$2) create(drag2DScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setDrag2DScope((Drag2DScope) this.L$0);
            Function2<AbstractDragScope, Continuation<? super Unit>, Object> function2 = this.$block;
            Draggable2DNode$abstractDragScope$1 access$getAbstractDragScope$p = this.this$0.abstractDragScope;
            this.label = 1;
            if (function2.invoke(access$getAbstractDragScope$p, this) == coroutine_suspended) {
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
