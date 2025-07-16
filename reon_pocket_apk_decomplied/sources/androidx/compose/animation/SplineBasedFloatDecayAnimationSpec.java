package androidx.compose.animation;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/animation/SplineBasedFloatDecayAnimationSpec;", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "flingCalculator", "Landroidx/compose/animation/FlingCalculator;", "flingDistance", "startVelocity", "getDurationNanos", "", "initialValue", "initialVelocity", "getTargetValue", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SplineBasedFloatDecayAnimationSpec.kt */
public final class SplineBasedFloatDecayAnimationSpec implements FloatDecayAnimationSpec {
    public static final int $stable = 0;
    private final FlingCalculator flingCalculator;

    public float getAbsVelocityThreshold() {
        return 0.0f;
    }

    public SplineBasedFloatDecayAnimationSpec(Density density) {
        this.flingCalculator = new FlingCalculator(SplineBasedFloatDecayAnimationSpec_androidKt.getPlatformFlingScrollFriction(), density);
    }

    private final float flingDistance(float f) {
        return this.flingCalculator.flingDistance(f) * Math.signum(f);
    }

    public float getTargetValue(float f, float f2) {
        return f + flingDistance(f2);
    }

    public float getValueFromNanos(long j, float f, float f2) {
        return f + this.flingCalculator.flingInfo(f2).position(j / AnimationKt.MillisToNanos);
    }

    public long getDurationNanos(float f, float f2) {
        return this.flingCalculator.flingDuration(f2) * AnimationKt.MillisToNanos;
    }

    public float getVelocityFromNanos(long j, float f, float f2) {
        return this.flingCalculator.flingInfo(f2).velocity(j / AnimationKt.MillisToNanos);
    }
}
