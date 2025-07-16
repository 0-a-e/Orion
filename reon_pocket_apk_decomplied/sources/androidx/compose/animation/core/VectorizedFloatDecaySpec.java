package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\n\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u0010\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u001c"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatDecaySpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "getFloatDecaySpec", "()Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "targetVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getTargetValue", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DecayAnimationSpec.kt */
final class VectorizedFloatDecaySpec<V extends AnimationVector> implements VectorizedDecayAnimationSpec<V> {
    private final float absVelocityThreshold;
    private final FloatDecayAnimationSpec floatDecaySpec;
    private V targetVector;
    private V valueVector;
    private V velocityVector;

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        this.floatDecaySpec = floatDecayAnimationSpec;
        this.absVelocityThreshold = floatDecayAnimationSpec.getAbsVelocityThreshold();
    }

    public final FloatDecayAnimationSpec getFloatDecaySpec() {
        return this.floatDecaySpec;
    }

    public float getAbsVelocityThreshold() {
        return this.absVelocityThreshold;
    }

    public V getValueFromNanos(long j, V v, V v2) {
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.valueVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v3 = null;
        }
        int size$animation_core_release = v3.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.valueVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.floatDecaySpec.getValueFromNanos(j, v.get$animation_core_release(i), v2.get$animation_core_release(i)));
        }
        V v5 = this.valueVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    public long getDurationNanos(V v, V v2) {
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.velocityVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v3 = null;
        }
        int size$animation_core_release = v3.getSize$animation_core_release();
        long j = 0;
        for (int i = 0; i < size$animation_core_release; i++) {
            j = Math.max(j, this.floatDecaySpec.getDurationNanos(v.get$animation_core_release(i), v2.get$animation_core_release(i)));
        }
        return j;
    }

    public V getVelocityFromNanos(long j, V v, V v2) {
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.velocityVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v3 = null;
        }
        int size$animation_core_release = v3.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.velocityVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.floatDecaySpec.getVelocityFromNanos(j, v.get$animation_core_release(i), v2.get$animation_core_release(i)));
        }
        V v5 = this.velocityVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    public V getTargetValue(V v, V v2) {
        if (this.targetVector == null) {
            this.targetVector = AnimationVectorsKt.newInstance(v);
        }
        V v3 = this.targetVector;
        if (v3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            v3 = null;
        }
        int size$animation_core_release = v3.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v4 = this.targetVector;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                v4 = null;
            }
            v4.set$animation_core_release(i, this.floatDecaySpec.getTargetValue(v.get$animation_core_release(i), v2.get$animation_core_release(i)));
        }
        V v5 = this.targetVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        return null;
    }
}
