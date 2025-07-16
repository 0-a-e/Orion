package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.internal.selection.TextToolbarState;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "start", "", "end", "relativeToOriginal", "invoke", "(IIZ)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$applySemantics$3 extends Lambda implements Function3<Integer, Integer, Boolean, Boolean> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$applySemantics$3(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(3);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), ((Boolean) obj3).booleanValue());
    }

    public final Boolean invoke(int i, int i2, boolean z) {
        TextFieldCharSequence textFieldCharSequence;
        if (z) {
            textFieldCharSequence = this.this$0.getTextFieldState().getUntransformedText();
        } else {
            textFieldCharSequence = this.this$0.getTextFieldState().getText();
        }
        long r1 = textFieldCharSequence.m1346getSelectionInCharsd9O1mEE();
        if (!this.this$0.getEnabled() || Math.min(i, i2) < 0 || Math.max(i, i2) > textFieldCharSequence.length()) {
            return false;
        }
        if (i == TextRange.m6042getStartimpl(r1) && i2 == TextRange.m6037getEndimpl(r1)) {
            return true;
        }
        long TextRange = TextRangeKt.TextRange(i, i2);
        if (z || i == i2) {
            this.this$0.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.None);
        } else {
            this.this$0.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.Selection);
        }
        if (z) {
            this.this$0.getTextFieldState().m1430selectUntransformedCharsIn5zctL8(TextRange);
        } else {
            this.this$0.getTextFieldState().m1429selectCharsIn5zctL8(TextRange);
        }
        return true;
    }
}
