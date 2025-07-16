package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t\u001aa\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u0010\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0012*\u00020\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u00162\u0006\u0010\r\u001a\u0002H\u00112\u0006\u0010\u0017\u001a\u0002H\u00112\u0006\u0010\u000e\u001a\u0002H\u0011¢\u0006\u0002\u0010\u0018\u001aC\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00120\u0010\"\b\b\u0000\u0010\u0012*\u00020\u0013*\b\u0012\u0004\u0012\u0002H\u00120\u001a2\u0006\u0010\r\u001a\u0002H\u00122\u0006\u0010\u0017\u001a\u0002H\u00122\u0006\u0010\u000e\u001a\u0002H\u0012¢\u0006\u0002\u0010\u001b\u001a3\u0010\u001c\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0012*\u00020\u0013*\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u00042\u0006\u0010\u001d\u001a\u00020\u0001¢\u0006\u0002\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\" \u0010\u0003\u001a\u00020\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"MillisToNanos", "", "SecondsToMillis", "durationMillis", "Landroidx/compose/animation/core/Animation;", "getDurationMillis", "(Landroidx/compose/animation/core/Animation;)J", "DecayAnimation", "Landroidx/compose/animation/core/DecayAnimation;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "animationSpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "initialValue", "initialVelocity", "TargetBasedAnimation", "Landroidx/compose/animation/core/TargetBasedAnimation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/AnimationSpec;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "targetValue", "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/animation/core/TargetBasedAnimation;", "createAnimation", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "(Landroidx/compose/animation/core/VectorizedAnimationSpec;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/TargetBasedAnimation;", "getVelocityFromNanos", "playTimeNanos", "(Landroidx/compose/animation/core/Animation;J)Ljava/lang/Object;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: Animation.kt */
public final class AnimationKt {
    public static final long MillisToNanos = 1000000;
    public static final long SecondsToMillis = 1000;

    public static final long getDurationMillis(Animation<?, ?> animation) {
        return animation.getDurationNanos() / MillisToNanos;
    }

    public static final <T, V extends AnimationVector> T getVelocityFromNanos(Animation<T, V> animation, long j) {
        return animation.getTypeConverter().getConvertFromVector().invoke(animation.getVelocityVectorFromNanos(j));
    }

    public static final <V extends AnimationVector> TargetBasedAnimation<V, V> createAnimation(VectorizedAnimationSpec<V> vectorizedAnimationSpec, V v, V v2, V v3) {
        return new TargetBasedAnimation(vectorizedAnimationSpec, VectorConvertersKt.TwoWayConverter(AnimationKt$createAnimation$1.INSTANCE, AnimationKt$createAnimation$2.INSTANCE), v, v2, v3);
    }

    public static final <T, V extends AnimationVector> TargetBasedAnimation<T, V> TargetBasedAnimation(AnimationSpec<T> animationSpec, TwoWayConverter<T, V> twoWayConverter, T t, T t2, T t3) {
        return new TargetBasedAnimation(animationSpec, twoWayConverter, t, t2, (AnimationVector) twoWayConverter.getConvertToVector().invoke(t3));
    }

    public static /* synthetic */ DecayAnimation DecayAnimation$default(FloatDecayAnimationSpec floatDecayAnimationSpec, float f, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return DecayAnimation(floatDecayAnimationSpec, f, f2);
    }

    public static final DecayAnimation<Float, AnimationVector1D> DecayAnimation(FloatDecayAnimationSpec floatDecayAnimationSpec, float f, float f2) {
        return new DecayAnimation<>(DecayAnimationSpecKt.generateDecayAnimationSpec(floatDecayAnimationSpec), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(f), AnimationVectorsKt.AnimationVector(f2));
    }
}
