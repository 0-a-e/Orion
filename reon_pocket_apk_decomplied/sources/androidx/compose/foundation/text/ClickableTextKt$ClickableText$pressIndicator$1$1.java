package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.text.TextLayoutResult;
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
@DebugMetadata(c = "androidx.compose.foundation.text.ClickableTextKt$ClickableText$pressIndicator$1$1", f = "ClickableText.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ClickableText.kt */
final class ClickableTextKt$ClickableText$pressIndicator$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ Function1<Integer, Unit> $onClick;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableTextKt$ClickableText$pressIndicator$1$1(MutableState<TextLayoutResult> mutableState, Function1<? super Integer, Unit> function1, Continuation<? super ClickableTextKt$ClickableText$pressIndicator$1$1> continuation) {
        super(2, continuation);
        this.$layoutResult = mutableState;
        this.$onClick = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableTextKt$ClickableText$pressIndicator$1$1 clickableTextKt$ClickableText$pressIndicator$1$1 = new ClickableTextKt$ClickableText$pressIndicator$1$1(this.$layoutResult, this.$onClick, continuation);
        clickableTextKt$ClickableText$pressIndicator$1$1.L$0 = obj;
        return clickableTextKt$ClickableText$pressIndicator$1$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ClickableTextKt$ClickableText$pressIndicator$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final MutableState<TextLayoutResult> mutableState = this.$layoutResult;
            final Function1<Integer, Unit> function1 = this.$onClick;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, (Function1) null, (Function1) null, (Function3) null, new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m1057invokek4lQ0M(((Offset) obj).m3572unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m1057invokek4lQ0M(long j) {
                    TextLayoutResult value = mutableState.getValue();
                    if (value != null) {
                        function1.invoke(Integer.valueOf(value.m6014getOffsetForPositionk4lQ0M(j)));
                    }
                }
            }, this, 7, (Object) null) == coroutine_suspended) {
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
