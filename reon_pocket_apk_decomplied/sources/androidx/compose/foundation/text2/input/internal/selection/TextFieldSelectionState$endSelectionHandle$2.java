package androidx.compose.foundation.text2.input.internal.selection;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$endSelectionHandle$2 extends Lambda implements Function0<TextFieldHandleState> {
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$endSelectionHandle$2(TextFieldSelectionState textFieldSelectionState) {
        super(0);
        this.this$0 = textFieldSelectionState;
    }

    public final TextFieldHandleState invoke() {
        return this.this$0.getSelectionHandleState(false);
    }
}
