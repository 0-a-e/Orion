package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt", f = "TapGestureDetector.kt", i = {0, 0, 1, 1}, l = {305, 320}, m = "waitForUpOrCancellation", n = {"$this$waitForUpOrCancellation", "pass", "$this$waitForUpOrCancellation", "pass"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: TapGestureDetector.kt */
final class TapGestureDetectorKt$waitForUpOrCancellation$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    TapGestureDetectorKt$waitForUpOrCancellation$2(Continuation<? super TapGestureDetectorKt$waitForUpOrCancellation$2> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return TapGestureDetectorKt.waitForUpOrCancellation((AwaitPointerEventScope) null, (PointerEventPass) null, this);
    }
}
