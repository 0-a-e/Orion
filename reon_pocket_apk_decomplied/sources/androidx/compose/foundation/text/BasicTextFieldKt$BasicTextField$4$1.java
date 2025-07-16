package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newTextFieldValueState", "Landroidx/compose/ui/text/input/TextFieldValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField.kt */
final class BasicTextFieldKt$BasicTextField$4$1 extends Lambda implements Function1<TextFieldValue, Unit> {
    final /* synthetic */ MutableState<String> $lastTextValue$delegate;
    final /* synthetic */ Function1<String, Unit> $onValueChange;
    final /* synthetic */ MutableState<TextFieldValue> $textFieldValueState$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextFieldKt$BasicTextField$4$1(Function1<? super String, Unit> function1, MutableState<TextFieldValue> mutableState, MutableState<String> mutableState2) {
        super(1);
        this.$onValueChange = function1;
        this.$textFieldValueState$delegate = mutableState;
        this.$lastTextValue$delegate = mutableState2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TextFieldValue) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TextFieldValue textFieldValue) {
        BasicTextFieldKt.BasicTextField$lambda$3(this.$textFieldValueState$delegate, textFieldValue);
        boolean z = !Intrinsics.areEqual((Object) BasicTextFieldKt.BasicTextField$lambda$6(this.$lastTextValue$delegate), (Object) textFieldValue.getText());
        BasicTextFieldKt.BasicTextField$lambda$7(this.$lastTextValue$delegate, textFieldValue.getText());
        if (z) {
            this.$onValueChange.invoke(textFieldValue.getText());
        }
    }
}
