package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/unit/Density;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidViewHolder.android.kt */
final class AndroidViewHolder$layoutNode$1$2 extends Lambda implements Function1<Density, Unit> {
    final /* synthetic */ LayoutNode $layoutNode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$layoutNode$1$2(LayoutNode layoutNode) {
        super(1);
        this.$layoutNode = layoutNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Density) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Density density) {
        this.$layoutNode.setDensity(density);
    }
}
