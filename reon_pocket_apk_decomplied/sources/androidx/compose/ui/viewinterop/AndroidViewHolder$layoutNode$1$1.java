package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/Modifier;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
final class AndroidViewHolder$layoutNode$1$1 extends Lambda implements Function1<Modifier, Unit> {
    final /* synthetic */ Modifier $coreModifier;
    final /* synthetic */ LayoutNode $layoutNode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$1(LayoutNode layoutNode, Modifier modifier) {
        super(1);
        this.$layoutNode = layoutNode;
        this.$coreModifier = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Modifier) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Modifier modifier) {
        this.$layoutNode.setModifier(modifier.then(this.$coreModifier));
    }
}
