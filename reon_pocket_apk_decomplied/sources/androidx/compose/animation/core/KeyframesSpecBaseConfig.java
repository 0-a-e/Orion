package androidx.compose.animation.core;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.animation.core.KeyframeBaseEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00028\u0000H ¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0017\u001a\u00028\u0001*\u00028\u00002\b\b\u0001\u0010\u0018\u001a\u00020\u0007H\u0004¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u00028\u0001*\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0004¢\u0006\u0002\u0010\u001dJ\u001a\u0010\u001e\u001a\u00028\u0001*\u00028\u00012\u0006\u0010\u001f\u001a\u00020 H\u0004¢\u0006\u0002\u0010!R\u001c\u0010\u0006\u001a\u00020\u00078GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0001\u0002\"#¨\u0006$"}, d2 = {"Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "T", "E", "Landroidx/compose/animation/core/KeyframeBaseEntity;", "", "()V", "delayMillis", "", "getDelayMillis", "()I", "setDelayMillis", "(I)V", "durationMillis", "getDurationMillis", "setDurationMillis", "keyframes", "Landroidx/collection/MutableIntObjectMap;", "getKeyframes$animation_core_release", "()Landroidx/collection/MutableIntObjectMap;", "createEntityFor", "value", "createEntityFor$animation_core_release", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframeBaseEntity;", "at", "timeStamp", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframeBaseEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframeBaseEntity;", "using", "easing", "Landroidx/compose/animation/core/Easing;", "(Landroidx/compose/animation/core/KeyframeBaseEntity;Landroidx/compose/animation/core/Easing;)Landroidx/compose/animation/core/KeyframeBaseEntity;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnimationSpec.kt */
public abstract class KeyframesSpecBaseConfig<T, E extends KeyframeBaseEntity<T>> {
    public static final int $stable = 8;
    private int delayMillis;
    private int durationMillis;
    private final MutableIntObjectMap<E> keyframes;

    public /* synthetic */ KeyframesSpecBaseConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract E createEntityFor$animation_core_release(T t);

    private KeyframesSpecBaseConfig() {
        this.durationMillis = AnimationConstants.DefaultDurationMillis;
        this.keyframes = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final void setDurationMillis(int i) {
        this.durationMillis = i;
    }

    public final int getDelayMillis() {
        return this.delayMillis;
    }

    public final void setDelayMillis(int i) {
        this.delayMillis = i;
    }

    public final MutableIntObjectMap<E> getKeyframes$animation_core_release() {
        return this.keyframes;
    }

    public E at(T t, int i) {
        E createEntityFor$animation_core_release = createEntityFor$animation_core_release(t);
        this.keyframes.set(i, createEntityFor$animation_core_release);
        return createEntityFor$animation_core_release;
    }

    public E atFraction(T t, float f) {
        return at(t, MathKt.roundToInt(((float) this.durationMillis) * f));
    }

    public final E using(E e, Easing easing) {
        e.setEasing$animation_core_release(easing);
        return e;
    }
}
