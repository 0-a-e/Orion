package androidx.compose.foundation.text;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$4 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextInputService $textInputService;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$4(TextInputService textInputService, TextFieldState textFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions) {
        super(1);
        this.$textInputService = textInputService;
        this.$state = textFieldState;
        this.$value = textFieldValue;
        this.$imeOptions = imeOptions;
    }

    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
        if (this.$textInputService != null && this.$state.getHasFocus()) {
            this.$state.setInputSession(TextFieldDelegate.Companion.restartInput$foundation_release(this.$textInputService, this.$value, this.$state.getProcessor(), this.$imeOptions, this.$state.getOnValueChange(), this.$state.getOnImeActionPerformed()));
        }
        return new CoreTextFieldKt$CoreTextField$4$invoke$$inlined$onDispose$1();
    }
}
