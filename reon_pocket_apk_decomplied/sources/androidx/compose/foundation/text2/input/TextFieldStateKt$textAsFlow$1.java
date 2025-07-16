package androidx.compose.foundation.text2.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldState.kt */
final class TextFieldStateKt$textAsFlow$1 extends Lambda implements Function0<TextFieldCharSequence> {
    final /* synthetic */ TextFieldState $this_textAsFlow;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldStateKt$textAsFlow$1(TextFieldState textFieldState) {
        super(0);
        this.$this_textAsFlow = textFieldState;
    }

    public final TextFieldCharSequence invoke() {
        return this.$this_textAsFlow.getText();
    }
}
