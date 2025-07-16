package androidx.compose.foundation.text2;

import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField2.kt */
final class BasicTextField2Kt$TextFieldSelectionHandles$3 implements OffsetProvider {
    final /* synthetic */ TextFieldSelectionState $selectionState;

    BasicTextField2Kt$TextFieldSelectionHandles$3(TextFieldSelectionState textFieldSelectionState) {
        this.$selectionState = textFieldSelectionState;
    }

    /* renamed from: provide-F1C5BW0  reason: not valid java name */
    public final long m1330provideF1C5BW0() {
        return this.$selectionState.getEndSelectionHandle().m1439getPositionF1C5BW0();
    }
}
