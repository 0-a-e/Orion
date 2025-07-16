package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusableChildrenComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Lkotlin/Comparator;", "()V", "compare", "", "focusTarget1", "focusTarget2", "pathFromRoot", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OneDimensionalFocusSearch.kt */
final class FocusableChildrenComparator implements Comparator<FocusTargetNode> {
    public static final FocusableChildrenComparator INSTANCE = new FocusableChildrenComparator();

    private FocusableChildrenComparator() {
    }

    public int compare(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        if (focusTargetNode == null) {
            throw new IllegalArgumentException("compare requires non-null focus targets".toString());
        } else if (focusTargetNode2 != null) {
            int i = 0;
            if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode) && FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2)) {
                LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
                if (Intrinsics.areEqual((Object) requireLayoutNode, (Object) requireLayoutNode2)) {
                    return 0;
                }
                MutableVector<LayoutNode> pathFromRoot = pathFromRoot(requireLayoutNode);
                MutableVector<LayoutNode> pathFromRoot2 = pathFromRoot(requireLayoutNode2);
                int min = Math.min(pathFromRoot.getSize() - 1, pathFromRoot2.getSize() - 1);
                if (min >= 0) {
                    while (Intrinsics.areEqual(pathFromRoot.getContent()[i], pathFromRoot2.getContent()[i])) {
                        if (i != min) {
                            i++;
                        }
                    }
                    return Intrinsics.compare(((LayoutNode) pathFromRoot.getContent()[i]).getPlaceOrder$ui_release(), ((LayoutNode) pathFromRoot2.getContent()[i]).getPlaceOrder$ui_release());
                }
                throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.".toString());
            } else if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode)) {
                return -1;
            } else {
                return FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) ? 1 : 0;
            }
        } else {
            throw new IllegalArgumentException("compare requires non-null focus targets".toString());
        }
    }

    private final MutableVector<LayoutNode> pathFromRoot(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = new MutableVector<>(new LayoutNode[16], 0);
        while (layoutNode != null) {
            mutableVector.add(0, layoutNode);
            layoutNode = layoutNode.getParent$ui_release();
        }
        return mutableVector;
    }
}
