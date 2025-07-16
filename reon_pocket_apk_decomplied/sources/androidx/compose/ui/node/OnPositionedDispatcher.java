package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher;", "", "()V", "cachedNodes", "", "Landroidx/compose/ui/node/LayoutNode;", "[Landroidx/compose/ui/node/LayoutNode;", "layoutNodes", "Landroidx/compose/runtime/collection/MutableVector;", "dispatch", "", "dispatchHierarchy", "layoutNode", "isNotEmpty", "", "onNodePositioned", "node", "onRootNodePositioned", "rootNode", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OnPositionedDispatcher.kt */
public final class OnPositionedDispatcher {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MinArraySize = 16;
    private LayoutNode[] cachedNodes;
    private final MutableVector<LayoutNode> layoutNodes = new MutableVector<>(new LayoutNode[16], 0);

    public final boolean isNotEmpty() {
        return this.layoutNodes.isNotEmpty();
    }

    public final void onNodePositioned(LayoutNode layoutNode) {
        this.layoutNodes.add(layoutNode);
        layoutNode.setNeedsOnPositionedDispatch$ui_release(true);
    }

    public final void onRootNodePositioned(LayoutNode layoutNode) {
        this.layoutNodes.clear();
        this.layoutNodes.add(layoutNode);
        layoutNode.setNeedsOnPositionedDispatch$ui_release(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0014, code lost:
        if (r2 < r0) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatch() {
        /*
            r4 = this;
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.LayoutNode> r0 = r4.layoutNodes
            androidx.compose.ui.node.OnPositionedDispatcher$Companion$DepthComparator r1 = androidx.compose.ui.node.OnPositionedDispatcher.Companion.DepthComparator.INSTANCE
            java.util.Comparator r1 = (java.util.Comparator) r1
            r0.sortWith(r1)
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.LayoutNode> r0 = r4.layoutNodes
            int r0 = r0.getSize()
            androidx.compose.ui.node.LayoutNode[] r1 = r4.cachedNodes
            if (r1 == 0) goto L_0x0016
            int r2 = r1.length
            if (r2 >= r0) goto L_0x0024
        L_0x0016:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.LayoutNode> r1 = r4.layoutNodes
            int r1 = r1.getSize()
            r2 = 16
            int r1 = java.lang.Math.max(r2, r1)
            androidx.compose.ui.node.LayoutNode[] r1 = new androidx.compose.ui.node.LayoutNode[r1]
        L_0x0024:
            r2 = 0
            r4.cachedNodes = r2
            r2 = 0
        L_0x0028:
            if (r2 >= r0) goto L_0x0037
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.LayoutNode> r3 = r4.layoutNodes
            java.lang.Object[] r3 = r3.getContent()
            r3 = r3[r2]
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x0028
        L_0x0037:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.LayoutNode> r2 = r4.layoutNodes
            r2.clear()
            int r0 = r0 + -1
        L_0x003e:
            r2 = -1
            if (r2 >= r0) goto L_0x0052
            r2 = r1[r0]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            boolean r3 = r2.getNeedsOnPositionedDispatch$ui_release()
            if (r3 == 0) goto L_0x004f
            r4.dispatchHierarchy(r2)
        L_0x004f:
            int r0 = r0 + -1
            goto L_0x003e
        L_0x0052:
            r4.cachedNodes = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.OnPositionedDispatcher.dispatch():void");
    }

    private final void dispatchHierarchy(LayoutNode layoutNode) {
        layoutNode.dispatchOnPositionedCallbacks$ui_release();
        int i = 0;
        layoutNode.setNeedsOnPositionedDispatch$ui_release(false);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            do {
                dispatchHierarchy((LayoutNode) content[i]);
                i++;
            } while (i < size);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion;", "", "()V", "MinArraySize", "", "DepthComparator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OnPositionedDispatcher.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion$DepthComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: OnPositionedDispatcher.kt */
        private static final class DepthComparator implements Comparator<LayoutNode> {
            public static final DepthComparator INSTANCE = new DepthComparator();

            private DepthComparator() {
            }

            public int compare(LayoutNode layoutNode, LayoutNode layoutNode2) {
                int compare = Intrinsics.compare(layoutNode2.getDepth$ui_release(), layoutNode.getDepth$ui_release());
                if (compare != 0) {
                    return compare;
                }
                return Intrinsics.compare(layoutNode.hashCode(), layoutNode2.hashCode());
            }
        }
    }
}
