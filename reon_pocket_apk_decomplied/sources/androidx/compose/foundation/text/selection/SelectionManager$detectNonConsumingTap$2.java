package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionManager$detectNonConsumingTap$2", f = "SelectionManager.kt", i = {}, l = {664}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SelectionManager.kt */
final class SelectionManager$detectNonConsumingTap$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Offset, Unit> $onTap;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionManager$detectNonConsumingTap$2(Function1<? super Offset, Unit> function1, Continuation<? super SelectionManager$detectNonConsumingTap$2> continuation) {
        super(2, continuation);
        this.$onTap = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SelectionManager$detectNonConsumingTap$2 selectionManager$detectNonConsumingTap$2 = new SelectionManager$detectNonConsumingTap$2(this.$onTap, continuation);
        selectionManager$detectNonConsumingTap$2.L$0 = obj;
        return selectionManager$detectNonConsumingTap$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((SelectionManager$detectNonConsumingTap$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = TapGestureDetectorKt.waitForUpOrCancellation$default((AwaitPointerEventScope) this.L$0, (PointerEventPass) null, this, 1, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PointerInputChange pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null) {
            this.$onTap.invoke(Offset.m3551boximpl(pointerInputChange.m5113getPositionF1C5BW0()));
        }
        return Unit.INSTANCE;
    }
}
