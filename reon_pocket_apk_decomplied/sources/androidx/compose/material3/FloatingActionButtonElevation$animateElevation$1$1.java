package androidx.compose.material3;

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
@DebugMetadata(c = "androidx.compose.material3.FloatingActionButtonElevation$animateElevation$1$1", f = "FloatingActionButton.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FloatingActionButton.kt */
final class FloatingActionButtonElevation$animateElevation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FloatingActionButtonElevationAnimatable $animatable;
    int label;
    final /* synthetic */ FloatingActionButtonElevation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FloatingActionButtonElevation$animateElevation$1$1(FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable, FloatingActionButtonElevation floatingActionButtonElevation, Continuation<? super FloatingActionButtonElevation$animateElevation$1$1> continuation) {
        super(2, continuation);
        this.$animatable = floatingActionButtonElevationAnimatable;
        this.this$0 = floatingActionButtonElevation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FloatingActionButtonElevation$animateElevation$1$1(this.$animatable, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FloatingActionButtonElevation$animateElevation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FloatingActionButtonElevationAnimatable floatingActionButtonElevationAnimatable = this.$animatable;
            float access$getDefaultElevation$p = this.this$0.defaultElevation;
            this.label = 1;
            if (floatingActionButtonElevationAnimatable.m1879updateElevationlDy3nrA(access$getDefaultElevation$p, this.this$0.pressedElevation, this.this$0.hoveredElevation, this.this$0.focusedElevation, this) == coroutine_suspended) {
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
