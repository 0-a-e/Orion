package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0}, l = {225}, m = "awaitDown", n = {"$this$awaitDown"}, s = {"L$0"})
/* compiled from: SelectionGestures.kt */
final class SelectionGesturesKt$awaitDown$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    SelectionGesturesKt$awaitDown$1(Continuation<? super SelectionGesturesKt$awaitDown$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SelectionGesturesKt.awaitDown((AwaitPointerEventScope) null, this);
    }
}
