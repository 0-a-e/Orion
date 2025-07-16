package androidx.compose.ui.node;

import androidx.compose.ui.platform.ViewConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/ComposeUiNode;", "it", "Landroidx/compose/ui/platform/ViewConfiguration;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ComposeUiNode.kt */
final class ComposeUiNode$Companion$SetViewConfiguration$1 extends Lambda implements Function2<ComposeUiNode, ViewConfiguration, Unit> {
    public static final ComposeUiNode$Companion$SetViewConfiguration$1 INSTANCE = new ComposeUiNode$Companion$SetViewConfiguration$1();

    ComposeUiNode$Companion$SetViewConfiguration$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ComposeUiNode) obj, (ViewConfiguration) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ComposeUiNode composeUiNode, ViewConfiguration viewConfiguration) {
        composeUiNode.setViewConfiguration(viewConfiguration);
    }
}
