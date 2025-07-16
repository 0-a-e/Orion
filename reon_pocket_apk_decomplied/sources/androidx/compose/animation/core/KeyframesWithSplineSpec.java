package androidx.compose.animation.core;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u000eB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J,\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\b\b\u0001\u0010\n*\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\n0\rH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/animation/core/KeyframesWithSplineSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "config", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "(Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;)V", "getConfig", "()Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "KeyframesWithSplineSpecConfig", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSpec.kt */
public final class KeyframesWithSplineSpec<T> implements DurationBasedAnimationSpec<T> {
    public static final int $stable = 0;
    private final KeyframesWithSplineSpecConfig<T> config;

    public KeyframesWithSplineSpec(KeyframesWithSplineSpecConfig<T> keyframesWithSplineSpecConfig) {
        this.config = keyframesWithSplineSpecConfig;
    }

    public final KeyframesWithSplineSpecConfig<T> getConfig() {
        return this.config;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0006\u001a\u00028\u0001H\u0010¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "T", "Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "()V", "createEntityFor", "value", "createEntityFor$animation_core_release", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframesSpec$KeyframeEntity;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnimationSpec.kt */
    public static final class KeyframesWithSplineSpecConfig<T> extends KeyframesSpecBaseConfig<T, KeyframesSpec.KeyframeEntity<T>> {
        public static final int $stable = 0;

        public KeyframesWithSplineSpecConfig() {
            super((DefaultConstructorMarker) null);
        }

        public KeyframesSpec.KeyframeEntity<T> createEntityFor$animation_core_release(T t) {
            return new KeyframesSpec.KeyframeEntity<>(t, (Easing) null, 2, (DefaultConstructorMarker) null);
        }
    }

    public <V extends AnimationVector> VectorizedDurationBasedAnimationSpec<V> vectorize(TwoWayConverter<T, V> twoWayConverter) {
        int i = 0;
        MutableIntList mutableIntList = new MutableIntList(0, 1, (DefaultConstructorMarker) null);
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, (DefaultConstructorMarker) null);
        IntObjectMap keyframes$animation_core_release = this.config.getKeyframes$animation_core_release();
        int[] iArr = keyframes$animation_core_release.keys;
        Object[] objArr = keyframes$animation_core_release.values;
        long[] jArr = keyframes$animation_core_release.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                long j = jArr[i2];
                if ((((~j) << 7) & j & -9187201950435737472L) != -9187201950435737472L) {
                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                    for (int i4 = i; i4 < i3; i4++) {
                        if ((255 & j) < 128) {
                            int i5 = (i2 << 3) + i4;
                            int i6 = iArr[i5];
                            mutableIntList.add(i6);
                            mutableIntObjectMap.set(i6, twoWayConverter.getConvertToVector().invoke(((KeyframesSpec.KeyframeEntity) objArr[i5]).getValue$animation_core_release()));
                        }
                        j >>= 8;
                    }
                    if (i3 != 8) {
                        break;
                    }
                }
                if (i2 == length) {
                    break;
                }
                i2++;
                i = 0;
            }
        }
        mutableIntList.sort();
        return new VectorizedMonoSplineKeyframesSpec<>(mutableIntList, mutableIntObjectMap, this.config.getDurationMillis(), this.config.getDelayMillis());
    }
}
