package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1", f = "LazyLayoutAnimation.kt", i = {}, l = {155, 156}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LazyLayoutAnimation.kt */
final class LazyLayoutAnimation$animateAppearance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<Float> $spec;
    int label;
    final /* synthetic */ LazyLayoutAnimation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutAnimation$animateAppearance$1(LazyLayoutAnimation lazyLayoutAnimation, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super LazyLayoutAnimation$animateAppearance$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimation;
        this.$spec = finiteAnimationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimation$animateAppearance$1(this.this$0, this.$spec, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimation$animateAppearance$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.visibilityAnimation.snapTo(Boxing.boxFloat(0.0f), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
                this.this$0.setAppearanceAnimationInProgress(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                this.this$0.setAppearanceAnimationInProgress(false);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final LazyLayoutAnimation lazyLayoutAnimation = this.this$0;
        this.label = 2;
        if (Animatable.animateTo$default(this.this$0.visibilityAnimation, Boxing.boxFloat(1.0f), this.$spec, (Object) null, new Function1<Animatable<Float, AnimationVector1D>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Animatable<Float, AnimationVector1D>) (Animatable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Animatable<Float, AnimationVector1D> animatable) {
                lazyLayoutAnimation.setVisibility(animatable.getValue().floatValue());
            }
        }, this, 4, (Object) null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.setAppearanceAnimationInProgress(false);
        return Unit.INSTANCE;
    }
}
