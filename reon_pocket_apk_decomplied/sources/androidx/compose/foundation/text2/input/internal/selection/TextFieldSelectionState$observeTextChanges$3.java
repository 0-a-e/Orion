package androidx.compose.foundation.text2.input.internal.selection;

import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextFieldSelectionState.kt */
/* synthetic */ class TextFieldSelectionState$observeTextChanges$3 extends FunctionReferenceImpl implements Function2<TextFieldCharSequence, CharSequence, Boolean> {
    public static final TextFieldSelectionState$observeTextChanges$3 INSTANCE = new TextFieldSelectionState$observeTextChanges$3();

    TextFieldSelectionState$observeTextChanges$3() {
        super(2, TextFieldCharSequence.class, "contentEquals", "contentEquals(Ljava/lang/CharSequence;)Z", 0);
    }

    public final Boolean invoke(TextFieldCharSequence textFieldCharSequence, CharSequence charSequence) {
        return Boolean.valueOf(textFieldCharSequence.contentEquals(charSequence));
    }
}
