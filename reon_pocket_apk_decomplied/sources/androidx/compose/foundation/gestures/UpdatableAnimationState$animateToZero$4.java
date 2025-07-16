package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.AnimationVector1D;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "frameTime", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UpdatableAnimationState.kt */
final class UpdatableAnimationState$animateToZero$4 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function1<Float, Unit> $beforeFrame;
    final /* synthetic */ float $durationScale;
    final /* synthetic */ UpdatableAnimationState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UpdatableAnimationState$animateToZero$4(UpdatableAnimationState updatableAnimationState, float f, Function1<? super Float, Unit> function1) {
        super(1);
        this.this$0 = updatableAnimationState;
        this.$durationScale = f;
        this.$beforeFrame = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        long j2;
        if (this.this$0.lastFrameTime == Long.MIN_VALUE) {
            this.this$0.lastFrameTime = j;
        }
        AnimationVector1D animationVector1D = new AnimationVector1D(this.this$0.getValue());
        if (this.$durationScale == 0.0f) {
            j2 = this.this$0.vectorizedSpec.getDurationNanos(new AnimationVector1D(this.this$0.getValue()), UpdatableAnimationState.Companion.getZeroVector(), this.this$0.lastVelocity);
        } else {
            j2 = MathKt.roundToLong(((float) (j - this.this$0.lastFrameTime)) / this.$durationScale);
        }
        AnimationVector animationVector = animationVector1D;
        float value = ((AnimationVector1D) this.this$0.vectorizedSpec.getValueFromNanos(j2, animationVector, UpdatableAnimationState.Companion.getZeroVector(), this.this$0.lastVelocity)).getValue();
        UpdatableAnimationState updatableAnimationState = this.this$0;
        updatableAnimationState.lastVelocity = (AnimationVector1D) updatableAnimationState.vectorizedSpec.getVelocityFromNanos(j2, animationVector, UpdatableAnimationState.Companion.getZeroVector(), this.this$0.lastVelocity);
        this.this$0.lastFrameTime = j;
        this.this$0.setValue(value);
        this.$beforeFrame.invoke(Float.valueOf(this.this$0.getValue() - value));
    }
}
