package androidx.compose.foundation.text2.input.internal;

import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/text/TextLayoutResult;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TextLayoutState.kt */
final class TextLayoutState$layoutWithNewMeasureInputs$1$textLayoutProvider$1 extends Lambda implements Function0<TextLayoutResult> {
    final /* synthetic */ TextLayoutState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextLayoutState$layoutWithNewMeasureInputs$1$textLayoutProvider$1(TextLayoutState textLayoutState) {
        super(0);
        this.this$0 = textLayoutState;
    }

    public final TextLayoutResult invoke() {
        return this.this$0.layoutCache.getValue();
    }
}
