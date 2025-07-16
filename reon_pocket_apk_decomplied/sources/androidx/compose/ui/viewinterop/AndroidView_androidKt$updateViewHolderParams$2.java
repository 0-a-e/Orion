package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Landroid/view/View;", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/compose/ui/unit/Density;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidView.android.kt */
final class AndroidView_androidKt$updateViewHolderParams$2 extends Lambda implements Function2<LayoutNode, Density, Unit> {
    public static final AndroidView_androidKt$updateViewHolderParams$2 INSTANCE = new AndroidView_androidKt$updateViewHolderParams$2();

    AndroidView_androidKt$updateViewHolderParams$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (Density) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutNode layoutNode, Density density) {
        AndroidView_androidKt.requireViewFactoryHolder(layoutNode).setDensity(density);
    }
}
