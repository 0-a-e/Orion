package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SuspendAnimation.kt */
final class SuspendAnimationKt$animate$9 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Animation<T, V> $animation;
    final /* synthetic */ Function1<AnimationScope<T, V>, Unit> $block;
    final /* synthetic */ float $durationScale;
    final /* synthetic */ Ref.ObjectRef<AnimationScope<T, V>> $lateInitScope;
    final /* synthetic */ AnimationState<T, V> $this_animate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SuspendAnimationKt$animate$9(Ref.ObjectRef<AnimationScope<T, V>> objectRef, float f, Animation<T, V> animation, AnimationState<T, V> animationState, Function1<? super AnimationScope<T, V>, Unit> function1) {
        super(1);
        this.$lateInitScope = objectRef;
        this.$durationScale = f;
        this.$animation = animation;
        this.$this_animate = animationState;
        this.$block = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        T t = this.$lateInitScope.element;
        Intrinsics.checkNotNull(t);
        SuspendAnimationKt.doAnimationFrameWithScale((AnimationScope) t, j, this.$durationScale, this.$animation, this.$this_animate, this.$block);
    }
}
