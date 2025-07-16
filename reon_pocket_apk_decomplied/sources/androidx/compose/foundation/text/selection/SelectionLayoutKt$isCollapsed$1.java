package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/foundation/text/selection/SelectableInfo;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: SelectionLayout.kt */
final class SelectionLayoutKt$isCollapsed$1 extends Lambda implements Function1<SelectableInfo, Unit> {
    final /* synthetic */ Ref.BooleanRef $allTextsEmpty;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectionLayoutKt$isCollapsed$1(Ref.BooleanRef booleanRef) {
        super(1);
        this.$allTextsEmpty = booleanRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SelectableInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SelectableInfo selectableInfo) {
        if (selectableInfo.getInputText().length() > 0) {
            this.$allTextsEmpty.element = false;
        }
    }
}
