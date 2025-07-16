package androidx.compose.foundation.text2;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldHandleState;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField2.kt */
final class BasicTextField2Kt$TextFieldCursorHandle$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ TextFieldHandleState $cursorHandleState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextField2Kt$TextFieldCursorHandle$1$1(TextFieldHandleState textFieldHandleState) {
        super(1);
        this.$cursorHandleState = textFieldHandleState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, this.$cursorHandleState.m1439getPositionF1C5BW0(), SelectionHandleAnchor.Middle, true, (DefaultConstructorMarker) null));
    }
}
