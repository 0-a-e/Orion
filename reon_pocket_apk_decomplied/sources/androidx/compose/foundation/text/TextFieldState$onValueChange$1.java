package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/text/input/TextFieldValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class TextFieldState$onValueChange$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ TextFieldState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldState$onValueChange$1(TextFieldState textFieldState) {
        super(1);
        this.this$0 = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        String text = textFieldValue.getText();
        AnnotatedString untransformedText = this.this$0.getUntransformedText();
        if (!Intrinsics.areEqual((Object) text, (Object) untransformedText != null ? untransformedText.getText() : null)) {
            this.this$0.setHandleState(HandleState.None);
        }
        this.this$0.onValueChangeOriginal.invoke(textFieldValue);
        this.this$0.getRecomposeScope().invalidate();
    }
}
