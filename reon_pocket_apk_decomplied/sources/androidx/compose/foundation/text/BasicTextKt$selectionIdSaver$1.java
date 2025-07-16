package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionRegistrar;
import androidx.compose.foundation.text.selection.SelectionRegistrarKt;
import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "invoke", "(Landroidx/compose/runtime/saveable/SaverScope;J)Ljava/lang/Long;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class BasicTextKt$selectionIdSaver$1 extends Lambda implements Function2<SaverScope, Long, Long> {
    final /* synthetic */ SelectionRegistrar $selectionRegistrar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTextKt$selectionIdSaver$1(SelectionRegistrar selectionRegistrar) {
        super(2);
        this.$selectionRegistrar = selectionRegistrar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((SaverScope) obj, ((Number) obj2).longValue());
    }

    public final Long invoke(SaverScope saverScope, long j) {
        if (SelectionRegistrarKt.hasSelection(this.$selectionRegistrar, j)) {
            return Long.valueOf(j);
        }
        return null;
    }
}
