package androidx.compose.material.ripple;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.ripple.StateLayer$handleInteraction$2", f = "Ripple.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Ripple.kt */
final class StateLayer$handleInteraction$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $outgoingAnimationSpec;
    int label;
    final /* synthetic */ StateLayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StateLayer$handleInteraction$2(StateLayer stateLayer, AnimationSpec<Float> animationSpec, Continuation<? super StateLayer$handleInteraction$2> continuation) {
        super(2, continuation);
        this.this$0 = stateLayer;
        this.$outgoingAnimationSpec = animationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StateLayer$handleInteraction$2(this.this$0, this.$outgoingAnimationSpec, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StateLayer$handleInteraction$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (Animatable.animateTo$default(this.this$0.animatedAlpha, Boxing.boxFloat(0.0f), this.$outgoingAnimationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
