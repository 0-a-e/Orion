package androidx.compose.animation.core;

import androidx.compose.animation.core.FloatAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/animation/core/FloatTweenSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "duration", "", "delay", "easing", "Landroidx/compose/animation/core/Easing;", "(IILandroidx/compose/animation/core/Easing;)V", "getDelay", "()I", "getDuration", "clampPlayTime", "", "playTime", "getDurationNanos", "initialValue", "", "targetValue", "initialVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FloatAnimationSpec.kt */
public final class FloatTweenSpec implements FloatAnimationSpec {
    public static final int $stable = 0;
    private final int delay;
    private final int duration;
    private final Easing easing;

    public FloatTweenSpec() {
        this(0, 0, (Easing) null, 7, (DefaultConstructorMarker) null);
    }

    public /* synthetic */ float getEndVelocity(float f, float f2, float f3) {
        return FloatAnimationSpec.CC.$default$getEndVelocity(this, f, f2, f3);
    }

    public FloatTweenSpec(int i, int i2, Easing easing2) {
        this.duration = i;
        this.delay = i2;
        this.easing = easing2;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getDelay() {
        return this.delay;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatTweenSpec(int i, int i2, Easing easing2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? AnimationConstants.DefaultDurationMillis : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? EasingKt.getFastOutSlowInEasing() : easing2);
    }

    public float getValueFromNanos(long j, float f, float f2, float f3) {
        long clampPlayTime = clampPlayTime(j / AnimationKt.MillisToNanos);
        int i = this.duration;
        return VectorConvertersKt.lerp(f, f2, this.easing.transform(RangesKt.coerceIn(i == 0 ? 1.0f : ((float) clampPlayTime) / ((float) i), 0.0f, 1.0f)));
    }

    private final long clampPlayTime(long j) {
        return RangesKt.coerceIn(j - ((long) this.delay), 0, (long) this.duration);
    }

    public long getDurationNanos(float f, float f2, float f3) {
        return ((long) (this.delay + this.duration)) * AnimationKt.MillisToNanos;
    }

    public float getVelocityFromNanos(long j, float f, float f2, float f3) {
        long clampPlayTime = clampPlayTime(j / AnimationKt.MillisToNanos);
        int i = (clampPlayTime > 0 ? 1 : (clampPlayTime == 0 ? 0 : -1));
        if (i < 0) {
            return 0.0f;
        }
        if (i == 0) {
            return f3;
        }
        return (getValueFromNanos(clampPlayTime * AnimationKt.MillisToNanos, f, f2, f3) - getValueFromNanos((clampPlayTime - 1) * AnimationKt.MillisToNanos, f, f2, f3)) * 1000.0f;
    }
}
