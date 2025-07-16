package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Switch.kt */
final class SwitchKt$Switch$3$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $offset;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ float $targetValue;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SwitchKt$Switch$3$1(Animatable<Float, AnimationVector1D> animatable, float f, CoroutineScope coroutineScope) {
        super(1);
        this.$offset = animatable;
        this.$targetValue = f;
        this.$scope = coroutineScope;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SwitchKt$Switch$3$1$1", f = "Switch.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SwitchKt$Switch$3$1$1  reason: invalid class name */
    /* compiled from: Switch.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(animatable, f, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Animatable<Float, AnimationVector1D> animatable = animatable;
                Float boxFloat = Boxing.boxFloat(f);
                this.label = 1;
                if (Animatable.animateTo$default(animatable, boxFloat, SwitchKt.AnimationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        if (this.$offset.getTargetValue().floatValue() != this.$targetValue) {
            CoroutineScope coroutineScope = this.$scope;
            final Animatable<Float, AnimationVector1D> animatable = this.$offset;
            final float f = this.$targetValue;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
        return new SwitchKt$Switch$3$1$invoke$$inlined$onDispose$1();
    }
}
