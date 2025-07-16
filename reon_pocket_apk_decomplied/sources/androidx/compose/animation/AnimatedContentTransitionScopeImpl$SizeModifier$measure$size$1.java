package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "S", "Landroidx/compose/animation/core/Transition$Segment;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimatedContent.kt */
final class AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$1 extends Lambda implements Function1<Transition.Segment<S>, FiniteAnimationSpec<IntSize>> {
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S> this$0;
    final /* synthetic */ AnimatedContentTransitionScopeImpl<S>.SizeModifier this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnimatedContentTransitionScopeImpl$SizeModifier$measure$size$1(AnimatedContentTransitionScopeImpl<S> animatedContentTransitionScopeImpl, AnimatedContentTransitionScopeImpl<S>.SizeModifier sizeModifier) {
        super(1);
        this.this$0 = animatedContentTransitionScopeImpl;
        this.this$1 = sizeModifier;
    }

    public final FiniteAnimationSpec<IntSize> invoke(Transition.Segment<S> segment) {
        FiniteAnimationSpec<IntSize> r5;
        State state = this.this$0.getTargetSizeMap$animation_release().get(segment.getInitialState());
        long r0 = state != null ? ((IntSize) state.getValue()).m6794unboximpl() : IntSize.Companion.m6795getZeroYbymL2g();
        State state2 = this.this$0.getTargetSizeMap$animation_release().get(segment.getTargetState());
        long r2 = state2 != null ? ((IntSize) state2.getValue()).m6794unboximpl() : IntSize.Companion.m6795getZeroYbymL2g();
        SizeTransform value = this.this$1.getSizeTransform().getValue();
        return (value == null || (r5 = value.m115createAnimationSpecTemP2vQ(r0, r2)) == null) ? AnimationSpecKt.spring$default(0.0f, 0.0f, (Object) null, 7, (Object) null) : r5;
    }
}
