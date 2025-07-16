package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B7\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ-\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001e"}, d2 = {"Landroidx/compose/animation/core/VectorizedKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "keyframes", "", "", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "delayMillis", "(Ljava/util/Map;II)V", "getDelayMillis", "()I", "getDurationMillis", "valueVector", "Landroidx/compose/animation/core/AnimationVector;", "velocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "value", "(Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedAnimationSpec.kt */
public final class VectorizedKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final Map<Integer, Pair<V, Easing>> keyframes;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedDurationBasedAnimationSpec.CC.$default$getDurationNanos(this, animationVector, animationVector2, animationVector3);
    }

    public /* synthetic */ AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return VectorizedAnimationSpec.CC.$default$getEndVelocity(this, animationVector, animationVector2, animationVector3);
    }

    public /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public VectorizedKeyframesSpec(Map<Integer, ? extends Pair<? extends V, ? extends Easing>> map, int i, int i2) {
        this.keyframes = map;
        this.durationMillis = i;
        this.delayMillis = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedKeyframesSpec(Map map, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, i, (i3 & 4) != 0 ? 0 : i2);
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    public V getValueFromNanos(long j, V v, V v2, V v3) {
        int clampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (this.keyframes.containsKey(Integer.valueOf(clampPlayTime))) {
            return (AnimationVector) ((Pair) MapsKt.getValue(this.keyframes, Integer.valueOf(clampPlayTime))).getFirst();
        }
        if (clampPlayTime >= getDurationMillis()) {
            return v2;
        }
        if (clampPlayTime <= 0) {
            return v;
        }
        int durationMillis2 = getDurationMillis();
        Easing linearEasing = EasingKt.getLinearEasing();
        int i = 0;
        V v4 = v;
        int i2 = 0;
        for (Map.Entry next : this.keyframes.entrySet()) {
            int intValue = ((Number) next.getKey()).intValue();
            Pair pair = (Pair) next.getValue();
            if (clampPlayTime > intValue && intValue >= i2) {
                v4 = (AnimationVector) pair.getFirst();
                linearEasing = (Easing) pair.getSecond();
                i2 = intValue;
            } else if (clampPlayTime < intValue && intValue <= durationMillis2) {
                v2 = (AnimationVector) pair.getFirst();
                durationMillis2 = intValue;
            }
        }
        float transform = linearEasing.transform(((float) (clampPlayTime - i2)) / ((float) (durationMillis2 - i2)));
        init(v);
        int size$animation_core_release = v4.getSize$animation_core_release();
        while (true) {
            V v5 = null;
            if (i >= size$animation_core_release) {
                break;
            }
            V v6 = this.valueVector;
            if (v6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            } else {
                v5 = v6;
            }
            v5.set$animation_core_release(i, VectorConvertersKt.lerp(v4.get$animation_core_release(i), v2.get$animation_core_release(i), transform));
            i++;
        }
        V v7 = this.valueVector;
        if (v7 != null) {
            return v7;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    private final void init(V v) {
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v);
            this.velocityVector = AnimationVectorsKt.newInstance(v);
        }
    }

    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        long clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (clampPlayTime <= 0) {
            return v3;
        }
        VectorizedAnimationSpec vectorizedAnimationSpec = this;
        AnimationVector valueFromMillis = VectorizedAnimationSpecKt.getValueFromMillis(vectorizedAnimationSpec, clampPlayTime - 1, v, v2, v3);
        AnimationVector valueFromMillis2 = VectorizedAnimationSpecKt.getValueFromMillis(vectorizedAnimationSpec, clampPlayTime, v, v2, v3);
        init(v);
        int size$animation_core_release = valueFromMillis.getSize$animation_core_release();
        int i = 0;
        while (true) {
            V v4 = null;
            if (i >= size$animation_core_release) {
                break;
            }
            V v5 = this.velocityVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            } else {
                v4 = v5;
            }
            v4.set$animation_core_release(i, (valueFromMillis.get$animation_core_release(i) - valueFromMillis2.get$animation_core_release(i)) * 1000.0f);
            i++;
        }
        V v6 = this.velocityVector;
        if (v6 != null) {
            return v6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }
}
