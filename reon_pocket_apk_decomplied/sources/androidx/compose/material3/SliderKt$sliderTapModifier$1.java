package androidx.compose.material3;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$1", f = "Slider.kt", i = {}, l = {1469}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Slider.kt */
final class SliderKt$sliderTapModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SliderState $state;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$sliderTapModifier$1(SliderState sliderState, Continuation<? super SliderKt$sliderTapModifier$1> continuation) {
        super(2, continuation);
        this.$state = sliderState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SliderKt$sliderTapModifier$1 sliderKt$sliderTapModifier$1 = new SliderKt$sliderTapModifier$1(this.$state, continuation);
        sliderKt$sliderTapModifier$1.L$0 = obj;
        return sliderKt$sliderTapModifier$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((SliderKt$sliderTapModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final SliderState sliderState = this.$state;
            final SliderState sliderState2 = this.$state;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, (Function1) null, (Function1) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m2203invokek4lQ0M(((Offset) obj).m3572unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m2203invokek4lQ0M(long j) {
                    sliderState2.dispatchRawDelta(0.0f);
                    sliderState2.getGestureEndAction$material3_release().invoke();
                }
            }, this, 3, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$1$1", f = "Slider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$1$1  reason: invalid class name */
    /* compiled from: Slider.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        int label;

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m2202invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m3572unboximpl(), (Continuation) obj3);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m2202invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass1 r2 = new AnonymousClass1(sliderState, continuation);
            r2.J$0 = j;
            return r2.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                sliderState.m2215onPressk4lQ0M$material3_release(this.J$0);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
