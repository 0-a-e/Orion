package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006JU\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000eH@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/gestures/snapping/LowVelocityApproachAnimation;", "Landroidx/compose/foundation/gestures/snapping/ApproachAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "lowVelocityAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;)V", "approachAnimation", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "scope", "Landroidx/compose/foundation/gestures/ScrollScope;", "offset", "velocity", "onAnimationStep", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "delta", "", "(Landroidx/compose/foundation/gestures/ScrollScope;FFLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SnapFlingBehavior.kt */
final class LowVelocityApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {
    private final AnimationSpec<Float> lowVelocityAnimationSpec;

    public LowVelocityApproachAnimation(AnimationSpec<Float> animationSpec) {
        this.lowVelocityAnimationSpec = animationSpec;
    }

    public /* bridge */ /* synthetic */ Object approachAnimation(ScrollScope scrollScope, Object obj, Object obj2, Function1 function1, Continuation continuation) {
        return approachAnimation(scrollScope, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), (Function1<? super Float, Unit>) function1, (Continuation<? super AnimationResult<Float, AnimationVector1D>>) continuation);
    }

    public Object approachAnimation(ScrollScope scrollScope, float f, float f2, Function1<? super Float, Unit> function1, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        Object access$animateWithTarget = SnapFlingBehaviorKt.animateWithTarget(scrollScope, Math.abs(f) * Math.signum(f2), f, AnimationStateKt.AnimationState$default(0.0f, f2, 0, 0, false, 28, (Object) null), this.lowVelocityAnimationSpec, function1, continuation);
        return access$animateWithTarget == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$animateWithTarget : (AnimationResult) access$animateWithTarget;
    }
}
