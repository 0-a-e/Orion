package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/ComposeUiNode;", "it", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeUiNode.kt */
final class ComposeUiNode$Companion$SetCompositeKeyHash$1 extends Lambda implements Function2<ComposeUiNode, Integer, Unit> {
    public static final ComposeUiNode$Companion$SetCompositeKeyHash$1 INSTANCE = new ComposeUiNode$Companion$SetCompositeKeyHash$1();

    ComposeUiNode$Companion$SetCompositeKeyHash$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ComposeUiNode composeUiNode, int i) {
        composeUiNode.setCompositeKeyHash(i);
    }
}
