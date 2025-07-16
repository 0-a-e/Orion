package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$applySemantics$5 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$applySemantics$5(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(0);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    public final Boolean invoke() {
        this.this$0.onImeActionPerformed.invoke(ImeAction.m6222boximpl(this.this$0.getKeyboardOptions().m1083getImeActioneUduSuo()));
        return true;
    }
}
