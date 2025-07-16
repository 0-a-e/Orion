package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.Easing;
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
@DebugMetadata(c = "androidx.compose.material3.SegmentedButtonContentMeasurePolicy$measure$1", f = "SegmentedButton.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SegmentedButton.kt */
final class SegmentedButtonContentMeasurePolicy$measure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Integer, AnimationVector1D> $anim;
    final /* synthetic */ int $offsetX;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SegmentedButtonContentMeasurePolicy$measure$1(Animatable<Integer, AnimationVector1D> animatable, int i, Continuation<? super SegmentedButtonContentMeasurePolicy$measure$1> continuation) {
        super(2, continuation);
        this.$anim = animatable;
        this.$offsetX = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SegmentedButtonContentMeasurePolicy$measure$1(this.$anim, this.$offsetX, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SegmentedButtonContentMeasurePolicy$measure$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Integer, AnimationVector1D> animatable = this.$anim;
            Integer boxInt = Boxing.boxInt(this.$offsetX);
            this.label = 1;
            if (Animatable.animateTo$default(animatable, boxInt, AnimationSpecKt.tween$default(350, 0, (Easing) null, 6, (Object) null), (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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
