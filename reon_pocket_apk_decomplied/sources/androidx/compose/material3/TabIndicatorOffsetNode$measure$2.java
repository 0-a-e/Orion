package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TabIndicatorOffsetNode$measure$2", f = "TabRow.kt", i = {}, l = {536}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TabRow.kt */
final class TabIndicatorOffsetNode$measure$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $currentTabWidth;
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $widthAnim;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabIndicatorOffsetNode$measure$2(Animatable<Dp, AnimationVector1D> animatable, float f, Continuation<? super TabIndicatorOffsetNode$measure$2> continuation) {
        super(2, continuation);
        this.$widthAnim = animatable;
        this.$currentTabWidth = f;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TabIndicatorOffsetNode$measure$2(this.$widthAnim, this.$currentTabWidth, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TabIndicatorOffsetNode$measure$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Animatable<Dp, AnimationVector1D> animatable = this.$widthAnim;
            Dp r10 = Dp.m6612boximpl(this.$currentTabWidth);
            this.label = 1;
            if (Animatable.animateTo$default(animatable, r10, (AnimationSpec) null, (Object) null, (Function1) null, this, 14, (Object) null) == coroutine_suspended) {
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
