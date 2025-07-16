package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u0004*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H@¢\u0006\u0002\u0010\u0015R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "motionDurationScale", "Landroidx/compose/ui/MotionDurationScale;", "(Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/ui/MotionDurationScale;)V", "getFlingDecay", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "setFlingDecay", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "lastAnimationCycleCount", "", "getLastAnimationCycleCount", "()I", "setLastAnimationCycleCount", "(I)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class DefaultFlingBehavior implements FlingBehavior {
    public static final int $stable = 0;
    private DecayAnimationSpec<Float> flingDecay;
    private int lastAnimationCycleCount;
    private final MotionDurationScale motionDurationScale;

    public DefaultFlingBehavior(DecayAnimationSpec<Float> decayAnimationSpec, MotionDurationScale motionDurationScale2) {
        this.flingDecay = decayAnimationSpec;
        this.motionDurationScale = motionDurationScale2;
    }

    public final DecayAnimationSpec<Float> getFlingDecay() {
        return this.flingDecay;
    }

    public final void setFlingDecay(DecayAnimationSpec<Float> decayAnimationSpec) {
        this.flingDecay = decayAnimationSpec;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultFlingBehavior(DecayAnimationSpec decayAnimationSpec, MotionDurationScale motionDurationScale2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(decayAnimationSpec, (i & 2) != 0 ? ScrollableKt.getDefaultScrollMotionDurationScale() : motionDurationScale2);
    }

    public final int getLastAnimationCycleCount() {
        return this.lastAnimationCycleCount;
    }

    public final void setLastAnimationCycleCount(int i) {
        this.lastAnimationCycleCount = i;
    }

    public Object performFling(ScrollScope scrollScope, float f, Continuation<? super Float> continuation) {
        this.lastAnimationCycleCount = 0;
        return BuildersKt.withContext(this.motionDurationScale, new DefaultFlingBehavior$performFling$2(f, this, scrollScope, (Continuation<? super DefaultFlingBehavior$performFling$2>) null), continuation);
    }
}
