package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ%\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J-\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J-\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00028\u00002\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/VectorizedRepeatableSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "iterations", "", "animation", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "(ILandroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "durationNanos", "", "getDurationNanos$animation_core_release", "()J", "initialOffsetNanos", "getDurationNanos", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "repetitionPlayTimeNanos", "repetitionStartVelocity", "start", "startVelocity", "end", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedAnimationSpec.kt */
public final class VectorizedRepeatableSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final VectorizedDurationBasedAnimationSpec<V> animation;
    private final long durationNanos;
    private final long initialOffsetNanos;
    private final int iterations;
    private final RepeatMode repeatMode;

    public /* synthetic */ VectorizedRepeatableSpec(int i, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, vectorizedDurationBasedAnimationSpec, repeatMode2, j);
    }

    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, animationVector, animationVector2, animationVector3);
    }

    public /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    private VectorizedRepeatableSpec(int i, VectorizedDurationBasedAnimationSpec<V> vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2, long j) {
        this.iterations = i;
        this.animation = vectorizedDurationBasedAnimationSpec;
        this.repeatMode = repeatMode2;
        if (i >= 1) {
            this.durationNanos = ((long) (vectorizedDurationBasedAnimationSpec.getDelayMillis() + vectorizedDurationBasedAnimationSpec.getDurationMillis())) * AnimationKt.MillisToNanos;
            this.initialOffsetNanos = j * AnimationKt.MillisToNanos;
            return;
        }
        throw new IllegalArgumentException("Iterations count can't be less than 1");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedRepeatableSpec(int i, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, vectorizedDurationBasedAnimationSpec, (i2 & 4) != 0 ? RepeatMode.Restart : repeatMode2, (i2 & 8) != 0 ? StartOffset.m151constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null) : j, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedRepeatableSpec(int i, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, vectorizedDurationBasedAnimationSpec, (i2 & 4) != 0 ? RepeatMode.Restart : repeatMode2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the constructor that accepts start offset.")
    public /* synthetic */ VectorizedRepeatableSpec(int i, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode2) {
        this(i, vectorizedDurationBasedAnimationSpec, repeatMode2, StartOffset.m151constructorimpl$default(0, 0, 2, (DefaultConstructorMarker) null), (DefaultConstructorMarker) null);
    }

    public final long getDurationNanos$animation_core_release() {
        return this.durationNanos;
    }

    private final long repetitionPlayTimeNanos(long j) {
        long j2 = this.initialOffsetNanos;
        if (j + j2 <= 0) {
            return 0;
        }
        long j3 = j + j2;
        long min = Math.min(j3 / this.durationNanos, ((long) this.iterations) - 1);
        if (this.repeatMode == RepeatMode.Restart || min % ((long) 2) == 0) {
            return j3 - (min * this.durationNanos);
        }
        return ((min + 1) * this.durationNanos) - j3;
    }

    private final V repetitionStartVelocity(long j, V v, V v2, V v3) {
        long j2 = this.initialOffsetNanos;
        long j3 = this.durationNanos;
        if (j + j2 <= j3) {
            return v2;
        }
        return getVelocityFromNanos(j3 - j2, v, v2, v3);
    }

    public V getValueFromNanos(long j, V v, V v2, V v3) {
        return this.animation.getValueFromNanos(repetitionPlayTimeNanos(j), v, v2, repetitionStartVelocity(j, v, v3, v2));
    }

    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        return this.animation.getVelocityFromNanos(repetitionPlayTimeNanos(j), v, v2, repetitionStartVelocity(j, v, v3, v2));
    }

    public long getDurationNanos(V v, V v2, V v3) {
        return (((long) this.iterations) * this.durationNanos) - this.initialOffsetNanos;
    }
}
