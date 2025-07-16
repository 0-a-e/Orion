package androidx.activity.compose;

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
@DebugMetadata(c = "androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$1$1", f = "PredictiveBackHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PredictiveBackHandler.kt */
final class PredictiveBackHandlerKt$PredictiveBackHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 $backCallBack;
    final /* synthetic */ boolean $enabled;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PredictiveBackHandlerKt$PredictiveBackHandler$1$1(PredictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1 predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1, boolean z, Continuation<? super PredictiveBackHandlerKt$PredictiveBackHandler$1$1> continuation) {
        super(2, continuation);
        this.$backCallBack = predictiveBackHandlerKt$PredictiveBackHandler$backCallBack$1$1;
        this.$enabled = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PredictiveBackHandlerKt$PredictiveBackHandler$1$1(this.$backCallBack, this.$enabled, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PredictiveBackHandlerKt$PredictiveBackHandler$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$backCallBack.setEnabled(this.$enabled);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
