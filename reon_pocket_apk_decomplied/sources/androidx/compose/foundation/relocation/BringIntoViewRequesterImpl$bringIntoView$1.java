package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewRequesterImpl", f = "BringIntoViewRequester.kt", i = {0, 0, 0, 0}, l = {119}, m = "bringIntoView", n = {"rect", "content$iv", "size$iv", "i$iv"}, s = {"L$0", "L$1", "I$0", "I$1"})
/* compiled from: BringIntoViewRequester.kt */
final class BringIntoViewRequesterImpl$bringIntoView$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BringIntoViewRequesterImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BringIntoViewRequesterImpl$bringIntoView$1(BringIntoViewRequesterImpl bringIntoViewRequesterImpl, Continuation<? super BringIntoViewRequesterImpl$bringIntoView$1> continuation) {
        super(continuation);
        this.this$0 = bringIntoViewRequesterImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.bringIntoView((Rect) null, this);
    }
}
