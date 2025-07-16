package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"rootLookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "getRootLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)Landroidx/compose/ui/node/LookaheadDelegate;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadLayoutCoordinates.kt */
public final class LookaheadLayoutCoordinatesKt {
    public static final LookaheadDelegate getRootLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        LayoutNode layoutNode = lookaheadDelegate.getLayoutNode();
        while (true) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            LayoutNode layoutNode2 = null;
            if ((parent$ui_release != null ? parent$ui_release.getLookaheadRoot$ui_release() : null) != null) {
                LayoutNode parent$ui_release2 = layoutNode.getParent$ui_release();
                if (parent$ui_release2 != null) {
                    layoutNode2 = parent$ui_release2.getLookaheadRoot$ui_release();
                }
                Intrinsics.checkNotNull(layoutNode2);
                if (layoutNode2.isVirtualLookaheadRoot$ui_release()) {
                    layoutNode = layoutNode.getParent$ui_release();
                    Intrinsics.checkNotNull(layoutNode);
                } else {
                    LayoutNode parent$ui_release3 = layoutNode.getParent$ui_release();
                    Intrinsics.checkNotNull(parent$ui_release3);
                    layoutNode = parent$ui_release3.getLookaheadRoot$ui_release();
                    Intrinsics.checkNotNull(layoutNode);
                }
            } else {
                LookaheadDelegate lookaheadDelegate2 = layoutNode.getOuterCoordinator$ui_release().getLookaheadDelegate();
                Intrinsics.checkNotNull(lookaheadDelegate2);
                return lookaheadDelegate2;
            }
        }
    }
}
