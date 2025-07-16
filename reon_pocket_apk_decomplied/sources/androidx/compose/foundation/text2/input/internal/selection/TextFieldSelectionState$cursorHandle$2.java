package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text2/input/internal/selection/TextFieldHandleState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$cursorHandle$2 extends Lambda implements Function0<TextFieldHandleState> {
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldSelectionState$cursorHandle$2(TextFieldSelectionState textFieldSelectionState) {
        super(0);
        this.this$0 = textFieldSelectionState;
    }

    public final TextFieldHandleState invoke() {
        TextFieldCharSequence text = this.this$0.textFieldState.getText();
        if (!this.this$0.getShowCursorHandle() || !TextRange.m6036getCollapsedimpl(text.m1346getSelectionInCharsd9O1mEE()) || text.length() <= 0 || (this.this$0.getDraggingHandle() != Handle.Cursor && !this.this$0.getCursorHandleInBounds())) {
            return TextFieldHandleState.Companion.getHidden();
        }
        return new TextFieldHandleState(true, this.this$0.getCursorRect().m3589getBottomCenterF1C5BW0(), ResolvedTextDirection.Ltr, false, (DefaultConstructorMarker) null);
    }
}
