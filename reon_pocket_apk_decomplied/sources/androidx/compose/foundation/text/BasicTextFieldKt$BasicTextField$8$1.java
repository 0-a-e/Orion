package androidx.compose.foundation.text;

import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/text/input/TextFieldValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$BasicTextField$8$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$BasicTextField$8$1(TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1) {
        super(1);
        this.$value = textFieldValue;
        this.$onValueChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        if (!Intrinsics.areEqual((Object) this.$value, (Object) textFieldValue)) {
            this.$onValueChange.invoke(textFieldValue);
        }
    }
}
