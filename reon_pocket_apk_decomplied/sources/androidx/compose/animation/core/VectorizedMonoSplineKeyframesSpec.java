package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ-\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ-\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 R\u0014\u0010\n\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0015\u001a\u00028\u0000X.¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/VectorizedMonoSplineKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "timestamps", "Landroidx/collection/IntList;", "keyframes", "Landroidx/collection/IntObjectMap;", "durationMillis", "", "delayMillis", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;II)V", "getDelayMillis", "()I", "getDurationMillis", "lastInitialValue", "Landroidx/compose/animation/core/AnimationVector;", "lastTargetValue", "monoSpline", "Landroidx/compose/animation/core/MonoSpline;", "valueVector", "velocityVector", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorizedMonoSplineKeyframesSpec.kt */
public final class VectorizedMonoSplineKeyframesSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {
    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final IntObjectMap<V> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private MonoSpline monoSpline;
    private final IntList timestamps;
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

    public VectorizedMonoSplineKeyframesSpec(IntList intList, IntObjectMap<V> intObjectMap, int i, int i2) {
        this.timestamps = intList;
        this.keyframes = intObjectMap;
        this.durationMillis = i;
        this.delayMillis = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VectorizedMonoSplineKeyframesSpec(IntList intList, IntObjectMap intObjectMap, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(intList, intObjectMap, i, (i3 & 8) != 0 ? 0 : i2);
    }

    public int getDurationMillis() {
        return this.durationMillis;
    }

    public int getDelayMillis() {
        return this.delayMillis;
    }

    private final void init(V v, V v2, V v3) {
        if (this.valueVector == null) {
            this.valueVector = AnimationVectorsKt.newInstance(v);
            this.velocityVector = AnimationVectorsKt.newInstance(v3);
        }
        if (this.monoSpline != null) {
            V v4 = this.lastInitialValue;
            V v5 = null;
            if (v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastInitialValue");
                v4 = null;
            }
            if (Intrinsics.areEqual((Object) v4, (Object) v)) {
                V v6 = this.lastTargetValue;
                if (v6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastTargetValue");
                } else {
                    v5 = v6;
                }
                if (Intrinsics.areEqual((Object) v5, (Object) v2)) {
                    return;
                }
            }
        }
        this.lastInitialValue = v;
        this.lastTargetValue = v2;
        int size = this.keyframes.getSize();
        int i = size + 2;
        float[] fArr = new float[i];
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new float[v.getSize$animation_core_release()]);
        }
        List list = arrayList;
        fArr[0] = 0.0f;
        int i3 = size + 1;
        float f = (float) 1000;
        fArr[i3] = ((float) getDurationMillis()) / f;
        float[] fArr2 = (float[]) list.get(0);
        float[] fArr3 = (float[]) list.get(i3);
        int size$animation_core_release = v.getSize$animation_core_release();
        for (int i4 = 0; i4 < size$animation_core_release; i4++) {
            fArr2[i4] = v.get$animation_core_release(i4);
            fArr3[i4] = v2.get$animation_core_release(i4);
        }
        IntList intList = this.timestamps;
        int[] iArr = intList.content;
        int i5 = intList._size;
        int i6 = 0;
        while (i6 < i5) {
            int i7 = iArr[i6];
            V v7 = this.keyframes.get(i7);
            Intrinsics.checkNotNull(v7);
            AnimationVector animationVector = (AnimationVector) v7;
            i6++;
            fArr[i6] = ((float) i7) / f;
            float[] fArr4 = (float[]) list.get(i6);
            int length = fArr4.length;
            for (int i8 = 0; i8 < length; i8++) {
                fArr4[i8] = animationVector.get$animation_core_release(i8);
            }
        }
        this.monoSpline = new MonoSpline(fArr, list);
    }

    public V getValueFromNanos(long j, V v, V v2, V v3) {
        int clampPlayTime = (int) VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (this.keyframes.containsKey(clampPlayTime)) {
            V v4 = this.keyframes.get(clampPlayTime);
            Intrinsics.checkNotNull(v4);
            return (AnimationVector) v4;
        } else if (clampPlayTime >= getDurationMillis()) {
            return v2;
        } else {
            if (clampPlayTime <= 0) {
                return v;
            }
            init(v, v2, v3);
            MonoSpline monoSpline2 = this.monoSpline;
            if (monoSpline2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("monoSpline");
                monoSpline2 = null;
            }
            float f = ((float) clampPlayTime) / ((float) 1000);
            V v5 = this.valueVector;
            if (v5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                v5 = null;
            }
            monoSpline2.getPos(f, (AnimationVector) v5);
            V v6 = this.valueVector;
            if (v6 != null) {
                return v6;
            }
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            return null;
        }
    }

    public V getVelocityFromNanos(long j, V v, V v2, V v3) {
        long clampPlayTime = VectorizedAnimationSpecKt.clampPlayTime(this, j / AnimationKt.MillisToNanos);
        if (clampPlayTime < 0) {
            return v3;
        }
        init(v, v2, v3);
        MonoSpline monoSpline2 = this.monoSpline;
        if (monoSpline2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("monoSpline");
            monoSpline2 = null;
        }
        float f = ((float) clampPlayTime) / ((float) 1000);
        V v4 = this.velocityVector;
        if (v4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            v4 = null;
        }
        monoSpline2.getSlope(f, (AnimationVector) v4);
        V v5 = this.velocityVector;
        if (v5 != null) {
            return v5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }
}
