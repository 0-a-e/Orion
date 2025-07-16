package androidx.compose.foundation.layout;

import android.view.WindowInsetsAnimationController;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2", f = "WindowInsetsConnection.android.kt", i = {}, l = {364}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WindowInsetsConnection.android.kt */
final class WindowInsetsNestedScrollConnection$fling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WindowInsetsAnimationController $animationController;
    final /* synthetic */ int $current;
    final /* synthetic */ Ref.FloatRef $endVelocity;
    final /* synthetic */ float $flingAmount;
    final /* synthetic */ int $hidden;
    final /* synthetic */ int $shown;
    final /* synthetic */ SplineBasedFloatDecayAnimationSpec $spec;
    final /* synthetic */ boolean $targetShown;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WindowInsetsNestedScrollConnection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInsetsNestedScrollConnection$fling$2(WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection, int i, float f, SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec, int i2, int i3, Ref.FloatRef floatRef, WindowInsetsAnimationController windowInsetsAnimationController, boolean z, Continuation<? super WindowInsetsNestedScrollConnection$fling$2> continuation) {
        super(2, continuation);
        this.this$0 = windowInsetsNestedScrollConnection;
        this.$current = i;
        this.$flingAmount = f;
        this.$spec = splineBasedFloatDecayAnimationSpec;
        this.$hidden = i2;
        this.$shown = i3;
        this.$endVelocity = floatRef;
        this.$animationController = windowInsetsAnimationController;
        this.$targetShown = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WindowInsetsNestedScrollConnection$fling$2 windowInsetsNestedScrollConnection$fling$2 = new WindowInsetsNestedScrollConnection$fling$2(this.this$0, this.$current, this.$flingAmount, this.$spec, this.$hidden, this.$shown, this.$endVelocity, this.$animationController, this.$targetShown, continuation);
        windowInsetsNestedScrollConnection$fling$2.L$0 = obj;
        return windowInsetsNestedScrollConnection$fling$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowInsetsNestedScrollConnection$fling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1", f = "WindowInsetsConnection.android.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.layout.WindowInsetsNestedScrollConnection$fling$2$1  reason: invalid class name */
    /* compiled from: WindowInsetsConnection.android.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(i2, f, splineBasedFloatDecayAnimationSpec, i3, i4, windowInsetsNestedScrollConnection2, floatRef, windowInsetsAnimationController, z, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final int i2 = i3;
                final int i3 = i4;
                final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = windowInsetsNestedScrollConnection2;
                final Ref.FloatRef floatRef = floatRef;
                final WindowInsetsAnimationController windowInsetsAnimationController = windowInsetsAnimationController;
                final boolean z = z;
                this.label = 1;
                if (SuspendAnimationKt.animateDecay((float) i2, f, (FloatDecayAnimationSpec) splineBasedFloatDecayAnimationSpec, (Function2<? super Float, ? super Float, Unit>) new Function2<Float, Float, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(float f, float f2) {
                        float f3 = (float) i2;
                        if (f > ((float) i3) || f3 > f) {
                            floatRef.element = f2;
                            windowInsetsAnimationController.finish(z);
                            windowInsetsNestedScrollConnection.animationController = null;
                            Job access$getAnimationJob$p = windowInsetsNestedScrollConnection.animationJob;
                            if (access$getAnimationJob$p != null) {
                                access$getAnimationJob$p.cancel((CancellationException) new WindowInsetsAnimationCancelledException());
                                return;
                            }
                            return;
                        }
                        windowInsetsNestedScrollConnection.adjustInsets(f);
                    }
                }, (Continuation<? super Unit>) this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = this.this$0;
            final int i2 = this.$current;
            final float f = this.$flingAmount;
            final SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec = this.$spec;
            final int i3 = this.$hidden;
            final int i4 = this.$shown;
            final WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection2 = this.this$0;
            final Ref.FloatRef floatRef = this.$endVelocity;
            final WindowInsetsAnimationController windowInsetsAnimationController = this.$animationController;
            final boolean z = this.$targetShown;
            windowInsetsNestedScrollConnection.animationJob = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            Job access$getAnimationJob$p = this.this$0.animationJob;
            if (access$getAnimationJob$p != null) {
                this.label = 1;
                if (access$getAnimationJob$p.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.animationJob = null;
        return Unit.INSTANCE;
    }
}
