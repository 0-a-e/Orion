package androidx.compose.foundation.text2;

import androidx.compose.foundation.text2.input.internal.selection.TextFieldSelectionState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicTextField2.kt */
final class BasicTextField2Kt$TextFieldCursorHandle$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ TextFieldSelectionState $selectionState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextField2Kt$TextFieldCursorHandle$3(TextFieldSelectionState textFieldSelectionState, int i) {
        super(2);
        this.$selectionState = textFieldSelectionState;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        BasicTextField2Kt.TextFieldCursorHandle(this.$selectionState, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
