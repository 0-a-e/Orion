package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultDraggable2DState$drag$2", f = "Draggable2D.kt", i = {}, l = {355}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Draggable2D.kt */
final class DefaultDraggable2DState$drag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Drag2DScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MutatePriority $dragPriority;
    int label;
    final /* synthetic */ DefaultDraggable2DState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultDraggable2DState$drag$2(DefaultDraggable2DState defaultDraggable2DState, MutatePriority mutatePriority, Function2<? super Drag2DScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultDraggable2DState$drag$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultDraggable2DState;
        this.$dragPriority = mutatePriority;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultDraggable2DState$drag$2(this.this$0, this.$dragPriority, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultDraggable2DState$drag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.drag2DMutex.mutateWith(this.this$0.drag2DScope, this.$dragPriority, this.$block, this) == coroutine_suspended) {
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
