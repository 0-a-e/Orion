package androidx.compose.foundation.text2;

import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text2.input.ImeActionHandler;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text/KeyboardActionScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicSecureTextField.kt */
final class BasicSecureTextFieldKt$KeyboardActions$2 extends Lambda implements Function1<KeyboardActionScope, Unit> {
    final /* synthetic */ ImeActionHandler $onSubmit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicSecureTextFieldKt$KeyboardActions$2(ImeActionHandler imeActionHandler) {
        super(1);
        this.$onSubmit = imeActionHandler;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyboardActionScope keyboardActionScope) {
        if (!this.$onSubmit.m1333onImeActionKlQnJC8(ImeAction.Companion.m6239getGoeUduSuo())) {
            keyboardActionScope.m1077defaultKeyboardActionKlQnJC8(ImeAction.Companion.m6239getGoeUduSuo());
        }
    }
}
