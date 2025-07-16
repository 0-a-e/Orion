package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectSelectionHandleDragGestures$6 extends Lambda implements Function0<String> {
    final /* synthetic */ Handle $handle;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$detectSelectionHandleDragGestures$6(TextFieldSelectionState textFieldSelectionState, Handle handle) {
        super(0);
        this.this$0 = textFieldSelectionState;
        this.$handle = handle;
    }

    public final String invoke() {
        return "Selection Handle drag cancelled for draggingHandle: " + this.this$0.getDraggingHandle() + " definedOn: " + this.$handle;
    }
}
