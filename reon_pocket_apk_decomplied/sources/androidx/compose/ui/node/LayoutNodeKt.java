package androidx.compose.ui.node;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"DebugChanges", "", "getDebugChanges$annotations", "()V", "DefaultDensity", "Landroidx/compose/ui/unit/Density;", "add", "", "Landroidx/compose/ui/node/LayoutNode;", "child", "requireOwner", "Landroidx/compose/ui/node/Owner;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNodeKt {
    private static final boolean DebugChanges = false;
    /* access modifiers changed from: private */
    public static final Density DefaultDensity = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);

    private static /* synthetic */ void getDebugChanges$annotations() {
    }

    public static final Owner requireOwner(LayoutNode layoutNode) {
        Owner owner$ui_release = layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("LayoutNode should be attached to an owner".toString());
    }

    public static final void add(LayoutNode layoutNode, LayoutNode layoutNode2) {
        layoutNode.insertAt$ui_release(layoutNode.getChildren$ui_release().size(), layoutNode2);
    }
}
