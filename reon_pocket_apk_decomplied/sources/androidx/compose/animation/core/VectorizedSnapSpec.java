package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J-\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J-\u0010\u0012\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/animation/core/VectorizedSnapSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "delayMillis", "", "(I)V", "getDelayMillis", "()I", "durationMillis", "getDurationMillis", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedAnimationSpec.kt */
public final class VectorizedSnapSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 0;
    private final int delayMillis;

    public VectorizedSnapSpec() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    public int getDurationMillis() {
        return 0;
    }

    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedDurationBasedAnimationSpec.CC.$default$getDurationNanos(this, animationVector, animationVector2, animationVector3);
    }

    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, animationVector, animationVector2, animationVector3);
    }

    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        return v3;
    }

    public /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public VectorizedSnapSpec(int i) {
        this.delayMillis = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedSnapSpec(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    public V getValueFromNanos(long j, V v, V v2, V v3) {
        return j < ((long) getDelayMillis()) * AnimationKt.MillisToNanos ? v : v2;
    }
}
