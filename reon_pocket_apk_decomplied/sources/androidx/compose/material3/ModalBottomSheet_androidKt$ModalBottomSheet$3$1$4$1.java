package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1", f = "ModalBottomSheet.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ModalBottomSheet.android.kt */
final class ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Float, Unit> $settleToDismiss;
    /* synthetic */ float F$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1(Function1<? super Float, Unit> function1, Continuation<? super ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1> continuation) {
        super(3, continuation);
        this.$settleToDismiss = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation<? super Unit>) (Continuation) obj3);
    }

    public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
        ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1 modalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1 = new ModalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1(this.$settleToDismiss, continuation);
        modalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1.F$0 = f;
        return modalBottomSheet_androidKt$ModalBottomSheet$3$1$4$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$settleToDismiss.invoke(Boxing.boxFloat(this.F$0));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
