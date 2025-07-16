package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.SemanticsModifierNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsOwner;", "", "rootNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "rootSemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRootSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedRootSemanticsNode", "getUnmergedRootSemanticsNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsOwner.kt */
public final class SemanticsOwner {
    public static final int $stable = 8;
    private final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode layoutNode) {
        this.rootNode = layoutNode;
    }

    public final SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        NodeChain nodes$ui_release = this.rootNode.getNodes$ui_release();
        int r1 = NodeKind.m5647constructorimpl(8);
        Modifier.Node node = null;
        if ((nodes$ui_release.getAggregateChildKindSet() & r1) != 0) {
            Modifier.Node head$ui_release = nodes$ui_release.getHead$ui_release();
            loop0:
            while (true) {
                if (head$ui_release != null) {
                    if ((head$ui_release.getKindSet$ui_release() & r1) != 0) {
                        Modifier.Node node2 = head$ui_release;
                        MutableVector mutableVector = null;
                        while (true) {
                            if (node2 == null) {
                                break;
                            } else if (node2 instanceof SemanticsModifierNode) {
                                node = node2;
                                break loop0;
                            } else {
                                if ((node2.getKindSet$ui_release() & r1) != 0 && (node2 instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node2 = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector);
                            }
                        }
                    }
                    if ((head$ui_release.getAggregateChildKindSet$ui_release() & r1) == 0) {
                        break;
                    }
                    head$ui_release = head$ui_release.getChild$ui_release();
                } else {
                    break;
                }
            }
        }
        Intrinsics.checkNotNull(node);
        return new SemanticsNode(((SemanticsModifierNode) node).getNode(), false, this.rootNode, new SemanticsConfiguration());
    }
}
