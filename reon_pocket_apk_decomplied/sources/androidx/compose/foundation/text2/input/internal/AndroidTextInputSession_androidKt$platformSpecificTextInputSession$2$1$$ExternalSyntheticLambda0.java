package androidx.compose.foundation.text2.input.internal;

import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2;
import androidx.compose.ui.text.input.ImeOptions;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1$$ExternalSyntheticLambda0 implements TextFieldState.NotifyImeListener {
    public final /* synthetic */ ComposeInputMethodManager f$0;
    public final /* synthetic */ ImeOptions f$1;

    public /* synthetic */ AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$1$$ExternalSyntheticLambda0(ComposeInputMethodManager composeInputMethodManager, ImeOptions imeOptions) {
        this.f$0 = composeInputMethodManager;
        this.f$1 = imeOptions;
    }

    public final void onChange(TextFieldCharSequence textFieldCharSequence, TextFieldCharSequence textFieldCharSequence2) {
        AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2.AnonymousClass1.invokeSuspend$lambda$0(this.f$0, this.f$1, textFieldCharSequence, textFieldCharSequence2);
    }
}
