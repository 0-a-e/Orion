package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SnapFlingBehavior", f = "SnapFlingBehavior.kt", i = {0, 0, 0, 0, 0}, l = {299}, m = "animateSnap", n = {"this", "animationState", "consumedUpToNow", "targetOffset", "initialVelocity"}, s = {"L$0", "L$1", "L$2", "F$0", "F$1"})
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehavior$animateSnap$1 extends ContinuationImpl {
    float F$0;
    float F$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$animateSnap$1(SnapFlingBehavior snapFlingBehavior, Continuation<? super SnapFlingBehavior$animateSnap$1> continuation) {
        super(continuation);
        this.this$0 = snapFlingBehavior;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.animateSnap((ScrollScope) null, 0.0f, 0.0f, (AnimationState<Float, AnimationVector1D>) null, (AnimationSpec<Float>) null, this);
    }
}
