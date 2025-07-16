package androidx.compose.foundation.text2.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.text2.input.InputTransformation;
import androidx.compose.foundation.text2.input.TextFieldCharSequence;
import androidx.compose.foundation.text2.input.TextFieldState;
import androidx.compose.foundation.text2.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\f\u001a\u00020\u00072\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\u0002\b\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"androidx/compose/foundation/text2/input/internal/AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1", "Landroidx/compose/foundation/text2/input/internal/TextInputSession;", "text", "Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "getText", "()Landroidx/compose/foundation/text2/input/TextFieldCharSequence;", "onImeAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeAction-KlQnJC8", "(I)V", "requestEdit", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text2/input/internal/EditingBuffer;", "Lkotlin/ExtensionFunctionType;", "sendKeyEvent", "keyEvent", "Landroid/view/KeyEvent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidTextInputSession.android.kt */
public final class AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1 implements TextInputSession {
    final /* synthetic */ ComposeInputMethodManager $composeImm;
    final /* synthetic */ Function1<ImeAction, Unit> $onImeAction;
    final /* synthetic */ TransformedTextFieldState $state;

    AndroidTextInputSession_androidKt$platformSpecificTextInputSession$2$2$textInputSession$1(TransformedTextFieldState transformedTextFieldState, ComposeInputMethodManager composeInputMethodManager, Function1<? super ImeAction, Unit> function1) {
        this.$state = transformedTextFieldState;
        this.$composeImm = composeInputMethodManager;
        this.$onImeAction = function1;
    }

    public TextFieldCharSequence getText() {
        return this.$state.getText();
    }

    public void requestEdit(Function1<? super EditingBuffer, Unit> function1) {
        TransformedTextFieldState transformedTextFieldState = this.$state;
        TextFieldState access$getTextFieldState$p = transformedTextFieldState.textFieldState;
        InputTransformation access$getInputTransformation$p = transformedTextFieldState.inputTransformation;
        TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
        TextFieldCharSequence text = access$getTextFieldState$p.getText();
        access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        function1.invoke(access$getTextFieldState$p.getMainBuffer$foundation_release());
        if (access$getTextFieldState$p.getMainBuffer$foundation_release().getChangeTracker().getChangeCount() != 0 || !TextRange.m6035equalsimpl0(text.m1346getSelectionInCharsd9O1mEE(), access$getTextFieldState$p.getMainBuffer$foundation_release().m1370getSelectiond9O1mEE()) || !Intrinsics.areEqual((Object) text.m1345getCompositionInCharsMzsxiRA(), (Object) access$getTextFieldState$p.getMainBuffer$foundation_release().m1369getCompositionMzsxiRA())) {
            access$getTextFieldState$p.commitEditAsUser(text, access$getInputTransformation$p, false, textFieldEditUndoBehavior);
        }
    }

    public void sendKeyEvent(KeyEvent keyEvent) {
        this.$composeImm.sendKeyEvent(keyEvent);
    }

    /* renamed from: onImeAction-KlQnJC8  reason: not valid java name */
    public void m1366onImeActionKlQnJC8(int i) {
        Function1<ImeAction, Unit> function1 = this.$onImeAction;
        if (function1 != null) {
            function1.invoke(ImeAction.m6222boximpl(i));
        }
    }
}
