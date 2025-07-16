package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "invoke-KlQnJC8", "(I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldDecoratorModifier.kt */
final class TextFieldDecoratorModifierNode$onImeActionPerformed$1 extends Lambda implements Function1<ImeAction, Unit> {
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldDecoratorModifierNode$onImeActionPerformed$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        super(1);
        this.this$0 = textFieldDecoratorModifierNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1399invokeKlQnJC8(((ImeAction) obj).m6228unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-KlQnJC8  reason: not valid java name */
    public final void m1399invokeKlQnJC8(int i) {
        Function1<KeyboardActionScope, Unit> function1;
        Unit unit = null;
        if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6238getDoneeUduSuo())) {
            function1 = this.this$0.getKeyboardActions().getOnDone();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6239getGoeUduSuo())) {
            function1 = this.this$0.getKeyboardActions().getOnGo();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6240getNexteUduSuo())) {
            function1 = this.this$0.getKeyboardActions().getOnNext();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6242getPreviouseUduSuo())) {
            function1 = this.this$0.getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6243getSearcheUduSuo())) {
            function1 = this.this$0.getKeyboardActions().getOnSearch();
        } else if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6244getSendeUduSuo())) {
            function1 = this.this$0.getKeyboardActions().getOnSend();
        } else {
            if (ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6237getDefaulteUduSuo()) ? true : ImeAction.m6225equalsimpl0(i, ImeAction.Companion.m6241getNoneeUduSuo())) {
                function1 = null;
            } else {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
        }
        if (function1 != null) {
            function1.invoke(this.this$0.keyboardActionScope);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            this.this$0.keyboardActionScope.m1398defaultKeyboardActionKlQnJC8(i);
        }
    }
}
