package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$BasicText$selectionController$selectableId$1 extends Lambda implements Function0<Long> {
    final /* synthetic */ SelectionRegistrar $selectionRegistrar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$BasicText$selectionController$selectableId$1(SelectionRegistrar selectionRegistrar) {
        super(0);
        this.$selectionRegistrar = selectionRegistrar;
    }

    public final Long invoke() {
        return Long.valueOf(this.$selectionRegistrar.nextSelectableId());
    }
}
