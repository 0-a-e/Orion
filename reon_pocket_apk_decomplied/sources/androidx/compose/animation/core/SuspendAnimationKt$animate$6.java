package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendAnimation.kt */
final class SuspendAnimationKt$animate$6 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Animation<T, V> $animation;
    final /* synthetic */ Function1<AnimationScope<T, V>, Unit> $block;
    final /* synthetic */ float $durationScale;
    final /* synthetic */ T $initialValue;
    final /* synthetic */ V $initialVelocityVector;
    final /* synthetic */ Ref.ObjectRef<AnimationScope<T, V>> $lateInitScope;
    final /* synthetic */ AnimationState<T, V> $this_animate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendAnimationKt$animate$6(Ref.ObjectRef<AnimationScope<T, V>> objectRef, T t, Animation<T, V> animation, V v, AnimationState<T, V> animationState, float f, Function1<? super AnimationScope<T, V>, Unit> function1) {
        super(1);
        this.$lateInitScope = objectRef;
        this.$initialValue = t;
        this.$animation = animation;
        this.$initialVelocityVector = v;
        this.$this_animate = animationState;
        this.$durationScale = f;
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        Ref.ObjectRef<AnimationScope<T, V>> objectRef = this.$lateInitScope;
        T t = this.$initialValue;
        TwoWayConverter<T, V> typeConverter = this.$animation.getTypeConverter();
        V v = this.$initialVelocityVector;
        T targetValue = this.$animation.getTargetValue();
        final AnimationState<T, V> animationState = this.$this_animate;
        AnimationScope animationScope = new AnimationScope(t, typeConverter, v, j, targetValue, j, true, new Function0<Unit>() {
            public final void invoke() {
                animationState.setRunning$animation_core_release(false);
            }
        });
        SuspendAnimationKt.doAnimationFrameWithScale(animationScope, j, this.$durationScale, this.$animation, this.$this_animate, this.$block);
        objectRef.element = animationScope;
    }
}
