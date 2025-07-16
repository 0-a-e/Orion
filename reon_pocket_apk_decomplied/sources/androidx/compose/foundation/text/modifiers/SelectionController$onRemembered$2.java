package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextLayoutResult;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionController.kt */
final class SelectionController$onRemembered$2 extends Lambda implements Function0<TextLayoutResult> {
    final /* synthetic */ SelectionController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionController$onRemembered$2(SelectionController selectionController) {
        super(0);
        this.this$0 = selectionController;
    }

    public final TextLayoutResult invoke() {
        return this.this$0.params.getTextLayoutResult();
    }
}
