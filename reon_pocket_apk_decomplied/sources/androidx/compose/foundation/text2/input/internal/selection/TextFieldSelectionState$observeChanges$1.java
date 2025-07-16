package androidx.compose.foundation.text2.input.internal.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState", f = "TextFieldSelectionState.kt", i = {0}, l = {393}, m = "observeChanges", n = {"this"}, s = {"L$0"})
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$observeChanges$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$observeChanges$1(TextFieldSelectionState textFieldSelectionState, Continuation<? super TextFieldSelectionState$observeChanges$1> continuation) {
        super(continuation);
        this.this$0 = textFieldSelectionState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.observeChanges(this);
    }
}
