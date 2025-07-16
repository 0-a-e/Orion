package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0000\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "anims", "Landroidx/compose/animation/core/Animations;", "(Landroidx/compose/animation/core/Animations;)V", "endVelocityVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedAnimationSpec.kt */
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {
    public static final int $stable = 8;
    private final Animations anims;
    private V endVelocityVector;
    private V valueVector;
    private V velocityVector;

    public /* synthetic */ boolean isInfinite() {
        return VectorizedFiniteAnimationSpec.CC.$default$isInfinite(this);
    }

    public VectorizedFloatAnimationSpec(Animations animations) {
        this.anims = animations;
    }

    public VectorizedFloatAnimationSpec(final FloatAnimationSpec floatAnimationSpec) {
        this((Animations) new Animations() {
            public FloatAnimationSpec get(int i) {
                return floatAnimationSpec;
            }
        });
    }

    public V getValueFromNanos(long j, V v, V v2, V v3) {
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v);
        }
        V v4 = this.valueVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            v4 = null;
        }
        int size$animation_core_release = v4.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v5 = this.valueVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v5 = null;
            }
            v5.set$animation_core_release(i, this.anims.get(i).getValueFromNanos(j, v.get$animation_core_release(i), v2.get$animation_core_release(i), v3.get$animation_core_release(i)));
        }
        V v6 = this.valueVector;
        if (v6 != null) {
            return v6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        if (this.velocityVector == null) {
            this.velocityVector = AnimationVectorsKt.newInstance(v3);
        }
        V v4 = this.velocityVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v4 = null;
        }
        int size$animation_core_release = v4.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v5 = this.velocityVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                v5 = null;
            }
            v5.set$animation_core_release(i, this.anims.get(i).getVelocityFromNanos(j, v.get$animation_core_release(i), v2.get$animation_core_release(i), v3.get$animation_core_release(i)));
        }
        V v6 = this.velocityVector;
        if (v6 != null) {
            return v6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    public V getEndVelocity(V v, V v2, V v3) {
        if (this.endVelocityVector == null) {
            this.endVelocityVector = AnimationVectorsKt.newInstance(v3);
        }
        V v4 = this.endVelocityVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            v4 = null;
        }
        int size$animation_core_release = v4.getSize$animation_core_release();
        for (int i = 0; i < size$animation_core_release; i++) {
            V v5 = this.endVelocityVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                v5 = null;
            }
            v5.set$animation_core_release(i, this.anims.get(i).getEndVelocity(v.get$animation_core_release(i), v2.get$animation_core_release(i), v3.get$animation_core_release(i)));
        }
        V v6 = this.endVelocityVector;
        if (v6 != null) {
            return v6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        return null;
    }

    public long getDurationNanos(V v, V v2, V v3) {
        Iterator it = RangesKt.until(0, v.getSize$animation_core_release()).iterator();
        long j = 0;
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            j = Math.max(j, this.anims.get(nextInt).getDurationNanos(v.get$animation_core_release(nextInt), v2.get$animation_core_release(nextInt), v3.get$animation_core_release(nextInt)));
        }
        return j;
    }
}
