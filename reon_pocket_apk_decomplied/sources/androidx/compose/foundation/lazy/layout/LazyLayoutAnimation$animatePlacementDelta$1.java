package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1", f = "LazyLayoutAnimation.kt", i = {0}, l = {127, 133}, m = "invokeSuspend", n = {"finalSpec"}, s = {"L$0"})
/* compiled from: LazyLayoutAnimation.kt */
final class LazyLayoutAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutAnimation$animatePlacementDelta$1(LazyLayoutAnimation lazyLayoutAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec;
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec2;
        SpringSpec springSpec;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.placementDeltaAnimation.isRunning()) {
                FiniteAnimationSpec<IntOffset> finiteAnimationSpec3 = this.$spec;
                if (finiteAnimationSpec3 instanceof SpringSpec) {
                    springSpec = (SpringSpec) finiteAnimationSpec3;
                } else {
                    springSpec = LazyLayoutAnimationKt.InterruptionSpec;
                }
                finiteAnimationSpec2 = springSpec;
            } else {
                finiteAnimationSpec2 = this.$spec;
            }
            finiteAnimationSpec = finiteAnimationSpec2;
            if (!this.this$0.placementDeltaAnimation.isRunning()) {
                this.L$0 = finiteAnimationSpec;
                this.label = 1;
                if (this.this$0.placementDeltaAnimation.snapTo(IntOffset.m6739boximpl(this.$totalDelta), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
                this.this$0.setPlacementAnimationInProgress(false);
            } catch (CancellationException unused) {
            }
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long r3 = ((IntOffset) this.this$0.placementDeltaAnimation.getValue()).m6757unboximpl();
        long j = this.$totalDelta;
        final long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r3) - IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(r3) - IntOffset.m6749getYimpl(j));
        final LazyLayoutAnimation lazyLayoutAnimation = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (Animatable.animateTo$default(this.this$0.placementDeltaAnimation, IntOffset.m6739boximpl(IntOffset), finiteAnimationSpec, (Object) null, new Function1<Animatable<IntOffset, AnimationVector2D>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Animatable<IntOffset, AnimationVector2D>) (Animatable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Animatable<IntOffset, AnimationVector2D> animatable) {
                LazyLayoutAnimation lazyLayoutAnimation = lazyLayoutAnimation;
                long r1 = animatable.getValue().m6757unboximpl();
                long j = IntOffset;
                lazyLayoutAnimation.m854setPlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m6748getXimpl(r1) - IntOffset.m6748getXimpl(j), IntOffset.m6749getYimpl(r1) - IntOffset.m6749getYimpl(j)));
            }
        }, this, 4, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.setPlacementAnimationInProgress(false);
        return Unit.INSTANCE;
    }
}
