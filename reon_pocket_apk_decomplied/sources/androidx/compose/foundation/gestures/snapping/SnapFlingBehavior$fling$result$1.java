package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/snapping/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1", f = "SnapFlingBehavior.kt", i = {0}, l = {174, 187}, m = "invokeSuspend", n = {"remainingScrollOffset"}, s = {"L$0"})
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ Function1<Float, Unit> $onRemainingScrollOffsetUpdate;
    final /* synthetic */ ScrollScope $this_fling;
    Object L$0;
    int label;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$fling$result$1(SnapFlingBehavior snapFlingBehavior, float f, Function1<? super Float, Unit> function1, ScrollScope scrollScope, Continuation<? super SnapFlingBehavior$fling$result$1> continuation) {
        super(2, continuation);
        this.this$0 = snapFlingBehavior;
        this.$initialVelocity = f;
        this.$onRemainingScrollOffsetUpdate = function1;
        this.$this_fling = scrollScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SnapFlingBehavior$fling$result$1(this.this$0, this.$initialVelocity, this.$onRemainingScrollOffsetUpdate, this.$this_fling, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>> continuation) {
        return ((SnapFlingBehavior$fling$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final Ref.FloatRef floatRef;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            float abs = Math.abs(this.this$0.snapLayoutInfoProvider.calculateApproachOffset(this.$initialVelocity)) * Math.signum(this.$initialVelocity);
            floatRef = new Ref.FloatRef();
            floatRef.element = abs;
            this.$onRemainingScrollOffsetUpdate.invoke(Boxing.boxFloat(floatRef.element));
            this.L$0 = floatRef;
            this.label = 1;
            obj2 = this.this$0.tryApproach(this.$this_fling, floatRef.element, this.$initialVelocity, new SnapFlingBehavior$fling$result$1$animationState$1(floatRef, this.$onRemainingScrollOffsetUpdate), this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            floatRef = (Ref.FloatRef) this.L$0;
            obj2 = obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationState animationState = (AnimationState) obj2;
        floatRef.element = this.this$0.snapLayoutInfoProvider.calculateSnappingOffset(((Number) animationState.getVelocity()).floatValue());
        ScrollScope scrollScope = this.$this_fling;
        float f = floatRef.element;
        AnimationState copy$default = AnimationStateKt.copy$default(animationState, 0.0f, 0.0f, 0, 0, false, 30, (Object) null);
        AnimationSpec access$getSnapAnimationSpec$p = this.this$0.snapAnimationSpec;
        final Function1<Float, Unit> function1 = this.$onRemainingScrollOffsetUpdate;
        this.L$0 = null;
        this.label = 2;
        Object access$animateWithTarget = SnapFlingBehaviorKt.animateWithTarget(scrollScope, f, floatRef.element, copy$default, access$getSnapAnimationSpec$p, new Function1<Float, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                floatRef.element -= f;
                function1.invoke(Float.valueOf(floatRef.element));
            }
        }, this);
        return access$animateWithTarget == coroutine_suspended ? coroutine_suspended : access$animateWithTarget;
    }
}
