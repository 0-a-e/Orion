package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ButtonElevation$animateElevation$2$1", f = "Button.kt", i = {}, l = {952, 960}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Button.kt */
final class ButtonElevation$animateElevation$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ ButtonElevation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ButtonElevation$animateElevation$2$1(Animatable<Dp, AnimationVector1D> animatable, float f, boolean z, ButtonElevation buttonElevation, Interaction interaction, Continuation<? super ButtonElevation$animateElevation$2$1> continuation) {
        super(2, continuation);
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z;
        this.this$0 = buttonElevation;
        this.$interaction = interaction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ButtonElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.this$0, this.$interaction, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ButtonElevation$animateElevation$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Dp.m6619equalsimpl0(this.$animatable.getTargetValue().m6628unboximpl(), this.$target)) {
                if (!this.$enabled) {
                    this.label = 1;
                    if (this.$animatable.snapTo(Dp.m6612boximpl(this.$target), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    float r7 = this.$animatable.getTargetValue().m6628unboximpl();
                    Interaction interaction = null;
                    if (Dp.m6619equalsimpl0(r7, this.this$0.pressedElevation)) {
                        interaction = new PressInteraction.Press(Offset.Companion.m3578getZeroF1C5BW0(), (DefaultConstructorMarker) null);
                    } else if (Dp.m6619equalsimpl0(r7, this.this$0.hoveredElevation)) {
                        interaction = new HoverInteraction.Enter();
                    } else if (Dp.m6619equalsimpl0(r7, this.this$0.focusedElevation)) {
                        interaction = new FocusInteraction.Focus();
                    }
                    this.label = 2;
                    if (ElevationKt.m1833animateElevationrAjV9yQ(this.$animatable, this.$target, interaction, this.$interaction, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i == 1 || i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
