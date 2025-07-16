package androidx.compose.ui.graphics.vector;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "it", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: VectorCompose.kt */
final class VectorComposeKt$Group$2$9 extends Lambda implements Function2<GroupComponent, List<? extends PathNode>, Unit> {
    public static final VectorComposeKt$Group$2$9 INSTANCE = new VectorComposeKt$Group$2$9();

    VectorComposeKt$Group$2$9() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GroupComponent) obj, (List<? extends PathNode>) (List) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(GroupComponent groupComponent, List<? extends PathNode> list) {
        groupComponent.setClipPathData(list);
    }
}
