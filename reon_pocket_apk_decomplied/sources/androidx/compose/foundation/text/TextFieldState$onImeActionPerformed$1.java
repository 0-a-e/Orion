package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "invoke-KlQnJC8", "(I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class TextFieldState$onImeActionPerformed$1 extends Lambda implements Function1<ImeAction, Unit> {
    final /* synthetic */ TextFieldState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldState$onImeActionPerformed$1(TextFieldState textFieldState) {
        super(1);
        this.this$0 = textFieldState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m1149invokeKlQnJC8(((ImeAction) obj).m6228unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-KlQnJC8  reason: not valid java name */
    public final void m1149invokeKlQnJC8(int i) {
        this.this$0.keyboardActionRunner.m1076runActionKlQnJC8(i);
    }
}
