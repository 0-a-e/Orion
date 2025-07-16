package androidx.compose.ui.layout;

import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"androidx/compose/ui/layout/LayoutNodeSubcompositionsState$precompose$2", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "placeablesCount", "", "getPlaceablesCount", "()I", "dispose", "", "premeasure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "premeasure-0kLqBqw", "(IJ)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class LayoutNodeSubcompositionsState$precompose$2 implements SubcomposeLayoutState.PrecomposedSlotHandle {
    final /* synthetic */ Object $slotId;
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    LayoutNodeSubcompositionsState$precompose$2(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, Object obj) {
        this.this$0 = layoutNodeSubcompositionsState;
        this.$slotId = obj;
    }

    public void dispose() {
        this.this$0.makeSureStateIsConsistent();
        LayoutNode layoutNode = (LayoutNode) this.this$0.precomposeMap.remove(this.$slotId);
        if (layoutNode == null) {
            return;
        }
        if (this.this$0.precomposedCount > 0) {
            int indexOf = this.this$0.root.getFoldedChildren$ui_release().indexOf(layoutNode);
            if (indexOf >= this.this$0.root.getFoldedChildren$ui_release().size() - this.this$0.precomposedCount) {
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = this.this$0;
                layoutNodeSubcompositionsState.reusableCount = layoutNodeSubcompositionsState.reusableCount + 1;
                LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = this.this$0;
                layoutNodeSubcompositionsState2.precomposedCount = layoutNodeSubcompositionsState2.precomposedCount - 1;
                int size = (this.this$0.root.getFoldedChildren$ui_release().size() - this.this$0.precomposedCount) - this.this$0.reusableCount;
                this.this$0.move(indexOf, size, 1);
                this.this$0.disposeOrReuseStartingFromIndex(size);
                return;
            }
            throw new IllegalStateException("Item is not in pre-composed item range".toString());
        }
        throw new IllegalStateException("No pre-composed items to dispose".toString());
    }

    public int getPlaceablesCount() {
        List<LayoutNode> children$ui_release;
        LayoutNode layoutNode = (LayoutNode) this.this$0.precomposeMap.get(this.$slotId);
        if (layoutNode == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
            return 0;
        }
        return children$ui_release.size();
    }

    /* renamed from: premeasure-0kLqBqw  reason: not valid java name */
    public void m5357premeasure0kLqBqw(int i, long j) {
        LayoutNode layoutNode = (LayoutNode) this.this$0.precomposeMap.get(this.$slotId);
        if (layoutNode != null && layoutNode.isAttached()) {
            int size = layoutNode.getChildren$ui_release().size();
            if (i < 0 || i >= size) {
                throw new IndexOutOfBoundsException("Index (" + i + ") is out of bound of [0, " + size + ')');
            } else if (!layoutNode.isPlaced()) {
                LayoutNode access$getRoot$p = this.this$0.root;
                access$getRoot$p.ignoreRemeasureRequests = true;
                LayoutNodeKt.requireOwner(layoutNode).m5706measureAndLayout0kLqBqw(layoutNode.getChildren$ui_release().get(i), j);
                access$getRoot$p.ignoreRemeasureRequests = false;
            } else {
                throw new IllegalArgumentException("Pre-measure called on node that is not placed".toString());
            }
        }
    }
}
