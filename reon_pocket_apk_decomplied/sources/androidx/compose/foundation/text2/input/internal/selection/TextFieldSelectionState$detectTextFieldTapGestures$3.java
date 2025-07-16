package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text.selection.SelectionAdjustment;
import androidx.compose.foundation.text2.input.TextFieldCharSequenceKt;
import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import androidx.compose.ui.text.TextRange;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectTextFieldTapGestures$3 implements TapOnPosition {
    final /* synthetic */ TextFieldSelectionState this$0;

    TextFieldSelectionState$detectTextFieldTapGestures$3(TextFieldSelectionState textFieldSelectionState) {
        this.this$0 = textFieldSelectionState;
    }

    /* renamed from: onEvent-k-4lQ0M  reason: not valid java name */
    public final void m1471onEventk4lQ0M(long j) {
        TextFieldSelectionStateKt.logDebug(AnonymousClass1.INSTANCE);
        this.this$0.setShowCursorHandle(false);
        this.this$0.updateTextToolbarState(TextToolbarState.Selection);
        int r11 = TextLayoutState.m1413getOffsetForPosition3MmeM6k$default(this.this$0.textLayoutState, j, false, 2, (Object) null);
        TextFieldSelectionState textFieldSelectionState = this.this$0;
        this.this$0.textFieldState.m1429selectCharsIn5zctL8(TextFieldSelectionState.m1461updateSelectionQNhciaU$default(textFieldSelectionState, TextFieldCharSequenceKt.m1348TextFieldCharSequence3r_uNRQ$default(textFieldSelectionState.textFieldState.getText(), TextRange.Companion.m6047getZerod9O1mEE(), (TextRange) null, 4, (Object) null), r11, r11, false, SelectionAdjustment.Companion.getWord(), false, 32, (Object) null));
    }
}
