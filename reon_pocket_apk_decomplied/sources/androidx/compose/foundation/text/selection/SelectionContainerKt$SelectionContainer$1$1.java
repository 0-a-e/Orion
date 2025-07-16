package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/text/selection/Selection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionContainer.kt */
final class SelectionContainerKt$SelectionContainer$1$1 extends Lambda implements Function1<Selection, Unit> {
    final /* synthetic */ MutableState<Selection> $selection$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionContainerKt$SelectionContainer$1$1(MutableState<Selection> mutableState) {
        super(1);
        this.$selection$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Selection) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Selection selection) {
        SelectionContainerKt.SelectionContainer$lambda$2(this.$selection$delegate, selection);
    }
}
