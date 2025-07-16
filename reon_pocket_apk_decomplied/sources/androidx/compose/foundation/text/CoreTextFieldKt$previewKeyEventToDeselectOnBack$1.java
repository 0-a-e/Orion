package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: CoreTextField.kt */
final class CoreTextFieldKt$previewKeyEventToDeselectOnBack$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ TextFieldSelectionManager $manager;
    final /* synthetic */ TextFieldState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoreTextFieldKt$previewKeyEventToDeselectOnBack$1(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager) {
        super(1);
        this.$state = textFieldState;
        this.$manager = textFieldSelectionManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m1066invokeZmokQxo(((KeyEvent) obj).m4946unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m1066invokeZmokQxo(android.view.KeyEvent keyEvent) {
        boolean z;
        if (this.$state.getHandleState() != HandleState.Selection || !KeyEventHelpers_androidKt.m1070cancelsTextSelectionZmokQxo(keyEvent)) {
            z = false;
        } else {
            z = true;
            TextFieldSelectionManager.m1297deselect_kEHs6E$foundation_release$default(this.$manager, (Offset) null, 1, (Object) null);
        }
        return Boolean.valueOf(z);
    }
}
