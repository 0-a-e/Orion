package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/EnterExitState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionKt$createGraphicsLayerBlock$1$alpha$1 extends Lambda implements Function1<Transition.Segment<EnterExitState>, FiniteAnimationSpec<Float>> {
    final /* synthetic */ EnterTransition $enter;
    final /* synthetic */ ExitTransition $exit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionKt$createGraphicsLayerBlock$1$alpha$1(EnterTransition enterTransition, ExitTransition exitTransition) {
        super(1);
        this.$enter = enterTransition;
        this.$exit = exitTransition;
    }

    public final FiniteAnimationSpec<Float> invoke(Transition.Segment<EnterExitState> segment) {
        FiniteAnimationSpec<Float> animationSpec;
        FiniteAnimationSpec<Float> animationSpec2;
        if (segment.isTransitioningTo(EnterExitState.PreEnter, EnterExitState.Visible)) {
            Fade fade = this.$enter.getData$animation_release().getFade();
            if (fade == null || (animationSpec2 = fade.getAnimationSpec()) == null) {
                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
            return animationSpec2;
        } else if (!segment.isTransitioningTo(EnterExitState.Visible, EnterExitState.PostExit)) {
            return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
        } else {
            Fade fade2 = this.$exit.getData$animation_release().getFade();
            if (fade2 == null || (animationSpec = fade2.getAnimationSpec()) == null) {
                return EnterExitTransitionKt.DefaultAlphaAndScaleSpring;
            }
            return animationSpec;
        }
    }
}
