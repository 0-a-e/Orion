package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/animation/core/AnimationScope;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehaviorKt$animateWithTarget$2 extends Lambda implements Function1<AnimationScope<Float, AnimationVector1D>, Unit> {
    final /* synthetic */ float $cancelOffset;
    final /* synthetic */ Ref.FloatRef $consumedUpToNow;
    final /* synthetic */ Function1<Float, Unit> $onAnimationStep;
    final /* synthetic */ ScrollScope $this_animateWithTarget;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapFlingBehaviorKt$animateWithTarget$2(float f, Ref.FloatRef floatRef, ScrollScope scrollScope, Function1<? super Float, Unit> function1) {
        super(1);
        this.$cancelOffset = f;
        this.$consumedUpToNow = floatRef;
        this.$this_animateWithTarget = scrollScope;
        this.$onAnimationStep = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AnimationScope<Float, AnimationVector1D>) (AnimationScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
        float access$coerceToTarget = SnapFlingBehaviorKt.coerceToTarget(animationScope.getValue().floatValue(), this.$cancelOffset);
        float f = access$coerceToTarget - this.$consumedUpToNow.element;
        float scrollBy = this.$this_animateWithTarget.scrollBy(f);
        this.$onAnimationStep.invoke(Float.valueOf(scrollBy));
        if (Math.abs(f - scrollBy) > 0.5f || access$coerceToTarget != animationScope.getValue().floatValue()) {
            animationScope.cancelAnimation();
        }
        this.$consumedUpToNow.element += scrollBy;
    }
}
