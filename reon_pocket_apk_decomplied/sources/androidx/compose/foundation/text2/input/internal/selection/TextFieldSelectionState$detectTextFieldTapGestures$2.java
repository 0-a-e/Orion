package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text2.input.internal.TextLayoutState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
final class TextFieldSelectionState$detectTextFieldTapGestures$2 implements TapOnPosition {
    final /* synthetic */ Function0<Unit> $requestFocus;
    final /* synthetic */ Function0<Unit> $showKeyboard;
    final /* synthetic */ TextFieldSelectionState this$0;

    TextFieldSelectionState$detectTextFieldTapGestures$2(Function0<Unit> function0, TextFieldSelectionState textFieldSelectionState, Function0<Unit> function02) {
        this.$requestFocus = function0;
        this.this$0 = textFieldSelectionState;
        this.$showKeyboard = function02;
    }

    /* renamed from: onEvent-k-4lQ0M  reason: not valid java name */
    public final void m1470onEventk4lQ0M(long j) {
        TextFieldSelectionStateKt.logDebug(AnonymousClass1.INSTANCE);
        this.$requestFocus.invoke();
        if (this.this$0.getEditable() && this.this$0.isFocused()) {
            this.$showKeyboard.invoke();
            if (this.this$0.textFieldState.getText().length() > 0) {
                this.this$0.setShowCursorHandle(true);
            }
            this.this$0.updateTextToolbarState(TextToolbarState.None);
            int r8 = TextLayoutState.m1413getOffsetForPosition3MmeM6k$default(this.this$0.textLayoutState, j, false, 2, (Object) null);
            if (r8 >= 0) {
                this.this$0.textFieldState.placeCursorBeforeCharAt(r8);
            }
        }
    }
}
