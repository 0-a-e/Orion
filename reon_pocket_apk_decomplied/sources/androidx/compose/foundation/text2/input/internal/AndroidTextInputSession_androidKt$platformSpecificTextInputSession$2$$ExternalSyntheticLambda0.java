package androidx.compose.foundation.text2.input.internal;

import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$$ExternalSyntheticLambda0 implements PlatformTextInputMethodRequest {
    public final /* synthetic */ TransformedTextFieldState f$0;
    public final /* synthetic */ ImeOptions f$1;
    public final /* synthetic */ ComposeInputMethodManager f$2;
    public final /* synthetic */ Function1 f$3;

    public /* synthetic */ AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$$ExternalSyntheticLambda0(TransformedTextFieldState transformedTextFieldState, ImeOptions imeOptions, ComposeInputMethodManager composeInputMethodManager, Function1 function1) {
        this.f$0 = transformedTextFieldState;
        this.f$1 = imeOptions;
        this.f$2 = composeInputMethodManager;
        this.f$3 = function1;
    }

    public final InputConnection createInputConnection(EditorInfo editorInfo) {
        return AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2.invokeSuspend$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, editorInfo);
    }
}
