package androidx.compose.foundation.relocation;

import android.graphics.Rect;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"defaultBringIntoViewParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "toRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BringIntoViewResponder.android.kt */
public final class BringIntoViewResponder_androidKt {
    public static final BringIntoViewParent defaultBringIntoViewParent(CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        return new BringIntoViewResponder_androidKt$defaultBringIntoViewParent$1(compositionLocalConsumerModifierNode);
    }

    /* access modifiers changed from: private */
    public static final Rect toRect(androidx.compose.ui.geometry.Rect rect) {
        return new Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }
}
