package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TapAndDoubleTapGestureKt", f = "TapAndDoubleTapGesture.kt", i = {0}, l = {108}, m = "consumeUntilUp", n = {"$this$consumeUntilUp"}, s = {"L$0"})
/* compiled from: TapAndDoubleTapGesture.kt */
final class TapAndDoubleTapGestureKt$consumeUntilUp$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    TapAndDoubleTapGestureKt$consumeUntilUp$1(Continuation<? super TapAndDoubleTapGestureKt$consumeUntilUp$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TapAndDoubleTapGestureKt.consumeUntilUp((AwaitPointerEventScope) null, this);
    }
}
