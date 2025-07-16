package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionGesturesKt", f = "SelectionGestures.kt", i = {0, 0, 1, 1}, l = {153, 176}, m = "mouseSelection", n = {"$this$mouseSelection", "observer", "$this$mouseSelection", "observer"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: SelectionGestures.kt */
final class SelectionGesturesKt$mouseSelection$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SelectionGesturesKt$mouseSelection$1(Continuation<? super SelectionGesturesKt$mouseSelection$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SelectionGesturesKt.mouseSelection((AwaitPointerEventScope) null, (MouseSelectionObserver) null, (ClicksCounter) null, (PointerEvent) null, this);
    }
}
