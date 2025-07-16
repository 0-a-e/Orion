package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt", f = "Scrollable.kt", i = {0}, l = {701}, m = "awaitScrollEvent", n = {"$this$awaitScrollEvent"}, s = {"L$0"})
/* compiled from: Scrollable.kt */
final class ScrollableKt$awaitScrollEvent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    ScrollableKt$awaitScrollEvent$1(Continuation<? super ScrollableKt$awaitScrollEvent$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScrollableKt.awaitScrollEvent((AwaitPointerEventScope) null, this);
    }
}
