package androidx.compose.foundation.text;

import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/focus/FocusState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$CoreTextField$focusModifier$1 extends Lambda implements Function1<FocusState, Unit> {
    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ ImeOptions $imeOptions;
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ OffsetMapping $offsetMapping;
    final /* synthetic */ boolean $readOnly;
    final /* synthetic */ TextFieldState $state;
    final /* synthetic */ TextInputService $textInputService;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$CoreTextField$focusModifier$1(TextFieldState textFieldState, TextInputService textInputService, boolean z, boolean z2, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester) {
        super(1);
        this.$state = textFieldState;
        this.$textInputService = textInputService;
        this.$enabled = z;
        this.$readOnly = z2;
        this.$value = textFieldValue;
        this.$imeOptions = imeOptions;
        this.$offsetMapping = offsetMapping;
        this.$manager = textFieldSelectionManager;
        this.$coroutineScope = coroutineScope;
        this.$bringIntoViewRequester = bringIntoViewRequester;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusState) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FocusState focusState) {
        TextLayoutResultProxy layoutResult;
        if (this.$state.getHasFocus() != focusState.isFocused()) {
            this.$state.setHasFocus(focusState.isFocused());
            if (this.$textInputService != null) {
                if (!this.$state.getHasFocus() || !this.$enabled || this.$readOnly) {
                    CoreTextFieldKt.endInputSession(this.$state);
                } else {
                    CoreTextFieldKt.startInputSession(this.$textInputService, this.$state, this.$value, this.$imeOptions, this.$offsetMapping);
                }
                if (focusState.isFocused() && (layoutResult = this.$state.getLayoutResult()) != null) {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(this.$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1(this.$bringIntoViewRequester, this.$value, this.$state, layoutResult, this.$offsetMapping, (Continuation<? super CoreTextFieldKt$CoreTextField$focusModifier$1$1$1>) null), 3, (Object) null);
                }
            }
            if (!focusState.isFocused()) {
                TextFieldSelectionManager.m1297deselect_kEHs6E$foundation_release$default(this.$manager, (Offset) null, 1, (Object) null);
            }
        }
    }
}
