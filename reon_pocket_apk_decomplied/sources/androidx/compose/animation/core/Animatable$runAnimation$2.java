package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", i = {0, 0}, l = {312}, m = "invokeSuspend", n = {"endState", "clampingNeeded"}, s = {"L$0", "L$1"})
/* compiled from: Animatable.kt */
final class Animatable$runAnimation$2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<T, V>>, Object> {
    final /* synthetic */ Animation<T, V> $animation;
    final /* synthetic */ Function1<Animatable<T, V>, Unit> $block;
    final /* synthetic */ T $initialVelocity;
    final /* synthetic */ long $startTime;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Animatable<T, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Animatable$runAnimation$2(Animatable<T, V> animatable, T t, Animation<T, V> animation, long j, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super Animatable$runAnimation$2> continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$initialVelocity = t;
        this.$animation = animation;
        this.$startTime = j;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Animatable$runAnimation$2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, continuation);
    }

    public final Object invoke(Continuation<? super AnimationResult<T, V>> continuation) {
        return ((Animatable$runAnimation$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        final AnimationState animationState;
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getInternalState$animation_core_release().setVelocityVector$animation_core_release((AnimationVector) this.this$0.getTypeConverter().getConvertToVector().invoke(this.$initialVelocity));
            this.this$0.setTargetValue(this.$animation.getTargetValue());
            this.this$0.setRunning(true);
            animationState = AnimationStateKt.copy$default((AnimationState) this.this$0.getInternalState$animation_core_release(), (Object) null, (AnimationVector) null, 0, Long.MIN_VALUE, false, 23, (Object) null);
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            Animation<T, V> animation = this.$animation;
            long j = this.$startTime;
            final Animatable<T, V> animatable = this.this$0;
            final Function1<Animatable<T, V>, Unit> function1 = this.$block;
            this.L$0 = animationState;
            this.L$1 = booleanRef2;
            this.label = 1;
            if (SuspendAnimationKt.animate(animationState, animation, j, new Function1<AnimationScope<T, V>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((AnimationScope) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(AnimationScope<T, V> animationScope) {
                    SuspendAnimationKt.updateState(animationScope, animatable.getInternalState$animation_core_release());
                    Object access$clampToBounds = animatable.clampToBounds(animationScope.getValue());
                    if (!Intrinsics.areEqual(access$clampToBounds, (Object) animationScope.getValue())) {
                        animatable.getInternalState$animation_core_release().setValue$animation_core_release(access$clampToBounds);
                        animationState.setValue$animation_core_release(access$clampToBounds);
                        Function1<Animatable<T, V>, Unit> function1 = function1;
                        if (function1 != null) {
                            function1.invoke(animatable);
                        }
                        animationScope.cancelAnimation();
                        booleanRef2.element = true;
                        return;
                    }
                    Function1<Animatable<T, V>, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(animatable);
                    }
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$1;
            animationState = (AnimationState) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException e) {
                this.this$0.endAnimation();
                throw e;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AnimationEndReason animationEndReason = booleanRef.element ? AnimationEndReason.BoundReached : AnimationEndReason.Finished;
        this.this$0.endAnimation();
        return new AnimationResult(animationState, animationEndReason);
    }
}
