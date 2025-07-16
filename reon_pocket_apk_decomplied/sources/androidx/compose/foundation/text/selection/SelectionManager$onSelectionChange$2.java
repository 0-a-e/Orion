package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newSelection", "Landroidx/compose/foundation/text/selection/Selection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
final class SelectionManager$onSelectionChange$2 extends Lambda implements Function1<Selection, Unit> {
    final /* synthetic */ Function1<Selection, Unit> $newOnSelectionChange;
    final /* synthetic */ SelectionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionManager$onSelectionChange$2(SelectionManager selectionManager, Function1<? super Selection, Unit> function1) {
        super(1);
        this.this$0 = selectionManager;
        this.$newOnSelectionChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Selection) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Selection selection) {
        this.this$0.setSelection(selection);
        this.$newOnSelectionChange.invoke(selection);
    }
}
