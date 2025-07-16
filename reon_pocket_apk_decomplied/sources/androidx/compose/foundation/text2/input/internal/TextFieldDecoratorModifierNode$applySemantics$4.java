package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "newText", "Landroidx/compose/ui/text/AnnotatedString;", "invoke", "(Landroidx/compose/ui/text/AnnotatedString;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$applySemantics$4 extends Lambda implements Function1<AnnotatedString, Boolean> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$applySemantics$4(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(1);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    public final Boolean invoke(AnnotatedString annotatedString) {
        if (this.this$0.getReadOnly() || !this.this$0.getEnabled()) {
            return false;
        }
        TransformedTextFieldState.replaceSelectedText$default(this.this$0.getTextFieldState(), annotatedString, true, (TextFieldEditUndoBehavior) null, 4, (Object) null);
        return true;
    }
}
