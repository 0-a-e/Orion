package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.TransformedTextFieldState", f = "TransformedTextFieldState.kt", i = {0, 0}, l = {394}, m = "collectImeNotifications", n = {"this", "notifyImeListener"}, s = {"L$0", "L$1"})
/* compiled from: TransformedTextFieldState.kt */
final class TransformedTextFieldState$collectImeNotifications$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TransformedTextFieldState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TransformedTextFieldState$collectImeNotifications$1(TransformedTextFieldState transformedTextFieldState, Continuation<? super TransformedTextFieldState$collectImeNotifications$1> continuation) {
        super(continuation);
        this.this$0 = transformedTextFieldState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collectImeNotifications((TextFieldState.NotifyImeListener) null, this);
    }
}
