package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\u001a\u001a\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a5\u0010\t\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\n\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u0007H\u0000\u001aA\u0010\u0012\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\n\u0010\u001b\u001a\u00020\u0005*\u00020\u0002\u001a3\u0010\u001c\u001a\u0004\u0018\u0001H\u000b\"\n\b\u0000\u0010\u000b\u0018\u0001*\u00020\u001d*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\rH\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010 \u001a\u00020!H\u0000\u001a\u0016\u0010\"\u001a\u0004\u0018\u00010\u0007*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002\u001a\"\u0010#\u001a\u00020$*\u00020\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\rH\u0000ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\n\u0010'\u001a\u00020(*\u00020\u0002\u001a\n\u0010)\u001a\u00020**\u00020\u0002\u001a\f\u0010+\u001a\u00020,*\u00020\u0002H\u0000\u001a\f\u0010-\u001a\u00020.*\u00020\u0002H\u0000\u001aK\u0010/\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\b\b\u0002\u00100\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a3\u0010/\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\b\b\u0002\u00100\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\b\u001aA\u00103\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a)\u00103\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\b\u001aA\u00106\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0000¢\u0006\u0004\b7\u00105\u001a)\u00106\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\b\u001aA\u00108\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0000¢\u0006\u0004\b9\u00105\u001a)\u00108\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\b\u001aM\u0010:\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\n\u0010;\u001a\u0006\u0012\u0002\b\u00030\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001aA\u0010>\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0000¢\u0006\u0004\b?\u00105\u001aA\u0010@\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00050\u0015H\bø\u0001\u0000¢\u0006\u0004\bA\u00105\u001a)\u0010@\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0015H\b\u001aA\u0010B\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00010\u0015H\bø\u0001\u0000¢\u0006\u0004\bC\u00105\u001a)\u0010B\u001a\u00020\u0005*\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0015H\b\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D"}, d2 = {"isDelegationRoot", "", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "addLayoutNodeChildren", "", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", "ancestors", "", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "ancestors-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/util/List;", "asLayoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "dispatchForKind", "kind", "block", "Lkotlin/Function1;", "dispatchForKind-6rFNWt0", "(Landroidx/compose/ui/Modifier$Node;ILkotlin/jvm/functions/Function1;)V", "has", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "invalidateSubtree", "nearestAncestor", "", "nearestAncestor-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "mask", "", "pop", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireDensity", "Landroidx/compose/ui/unit/Density;", "requireLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "visitAncestors", "includeSelf", "visitAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;IZLkotlin/jvm/functions/Function1;)V", "visitChildren", "visitChildren-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitLocalAncestors", "visitLocalAncestors-6rFNWt0", "visitLocalDescendants", "visitLocalDescendants-6rFNWt0", "visitSelfAndAncestors", "untilType", "visitSelfAndAncestors-5BbP62I", "(Landroidx/compose/ui/node/DelegatableNode;IILkotlin/jvm/functions/Function1;)V", "visitSelfAndChildren", "visitSelfAndChildren-6rFNWt0", "visitSubtree", "visitSubtree-6rFNWt0", "visitSubtreeIf", "visitSubtreeIf-6rFNWt0", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DelegatableNode.kt */
public final class DelegatableNodeKt {
    public static final boolean isDelegationRoot(DelegatableNode delegatableNode) {
        return delegatableNode.getNode() == delegatableNode;
    }

    public static final void visitAncestors(DelegatableNode delegatableNode, int i, boolean z, Function1<? super Modifier.Node, Unit> function1) {
        NodeChain nodes$ui_release;
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & i) != 0) {
                            function1.invoke(node);
                        }
                        node = node.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    public static /* synthetic */ void visitAncestors$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        NodeChain nodes$ui_release;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & i) != 0) {
                            function1.invoke(node);
                        }
                        node = node.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003d, code lost:
        r0 = r3.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.Modifier.Node nearestAncestor(androidx.compose.ui.node.DelegatableNode r3, int r4) {
        /*
            androidx.compose.ui.Modifier$Node r0 = r3.getNode()
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x004b
            androidx.compose.ui.Modifier$Node r0 = r3.getNode()
            androidx.compose.ui.Modifier$Node r0 = r0.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r3 = requireLayoutNode(r3)
        L_0x0016:
            r1 = 0
            if (r3 == 0) goto L_0x004a
            androidx.compose.ui.node.NodeChain r2 = r3.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r2 = r2.getHead$ui_release()
            int r2 = r2.getAggregateChildKindSet$ui_release()
            r2 = r2 & r4
            if (r2 == 0) goto L_0x0037
        L_0x0028:
            if (r0 == 0) goto L_0x0037
            int r2 = r0.getKindSet$ui_release()
            r2 = r2 & r4
            if (r2 == 0) goto L_0x0032
            return r0
        L_0x0032:
            androidx.compose.ui.Modifier$Node r0 = r0.getParent$ui_release()
            goto L_0x0028
        L_0x0037:
            androidx.compose.ui.node.LayoutNode r3 = r3.getParent$ui_release()
            if (r3 == 0) goto L_0x0048
            androidx.compose.ui.node.NodeChain r0 = r3.getNodes$ui_release()
            if (r0 == 0) goto L_0x0048
            androidx.compose.ui.Modifier$Node r0 = r0.getTail$ui_release()
            goto L_0x0016
        L_0x0048:
            r0 = r1
            goto L_0x0016
        L_0x004a:
            return r1
        L_0x004b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "nearestAncestor called on an unattached node"
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.nearestAncestor(androidx.compose.ui.node.DelegatableNode, int):androidx.compose.ui.Modifier$Node");
    }

    public static final void visitSubtree(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> function1) {
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            NestedVectorStack nestedVectorStack = new NestedVectorStack();
            for (LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode); requireLayoutNode != null; requireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null) {
                if (child$ui_release == null) {
                    child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
                }
                if ((child$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                    while (child$ui_release != null) {
                        if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                            function1.invoke(child$ui_release);
                        }
                        child$ui_release = child$ui_release.getChild$ui_release();
                    }
                }
                nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
                child$ui_release = null;
            }
            return;
        }
        throw new IllegalStateException("visitSubtree called on an unattached node".toString());
    }

    /* access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> mutableVector, Modifier.Node node) {
        MutableVector<LayoutNode> mutableVector2 = requireLayoutNode(node).get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            int i = size - 1;
            Object[] content = mutableVector2.getContent();
            do {
                mutableVector.add(((LayoutNode) content[i]).getNodes$ui_release().getHead$ui_release());
                i--;
            } while (i >= 0);
        }
    }

    public static final void visitChildren(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> function1) {
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & i) == 0) {
                    addLayoutNodeChildren(mutableVector, node);
                } else {
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui_release() & i) != 0) {
                            function1.invoke(node);
                            break;
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    public static final void visitSubtreeIf(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Boolean> function1) {
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = node;
                    while (true) {
                        if (node2 != null) {
                            if ((node2.getKindSet$ui_release() & i) != 0 && !function1.invoke(node2).booleanValue()) {
                                break;
                            }
                            node2 = node2.getChild$ui_release();
                        } else {
                            break;
                        }
                    }
                }
                addLayoutNodeChildren(mutableVector, node);
            }
            return;
        }
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }

    public static final void visitLocalDescendants(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> function1) {
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = delegatableNode.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
                for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                    if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                        function1.invoke(child$ui_release);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
    }

    public static final void visitLocalAncestors(DelegatableNode delegatableNode, int i, Function1<? super Modifier.Node, Unit> function1) {
        if (delegatableNode.getNode().isAttached()) {
            for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                    function1.invoke(parent$ui_release);
                }
            }
            return;
        }
        throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c6, code lost:
        r2 = r11.getNodes$ui_release();
     */
    /* renamed from: visitSelfAndAncestors-5BbP62I  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> void m5474visitSelfAndAncestors5BbP62I(androidx.compose.ui.node.DelegatableNode r11, int r12, int r13, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r14) {
        /*
            androidx.compose.ui.Modifier$Node r0 = r11.getNode()
            r1 = r12 | r13
            androidx.compose.ui.Modifier$Node r2 = r11.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x00d6
            androidx.compose.ui.Modifier$Node r2 = r11.getNode()
            androidx.compose.ui.node.LayoutNode r11 = requireLayoutNode(r11)
        L_0x0018:
            if (r11 == 0) goto L_0x00d5
            androidx.compose.ui.node.NodeChain r3 = r11.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r1
            r4 = 0
            if (r3 == 0) goto L_0x00c0
        L_0x002a:
            if (r2 == 0) goto L_0x00c0
            int r3 = r2.getKindSet$ui_release()
            r3 = r3 & r1
            if (r3 == 0) goto L_0x00ba
            r3 = r2
            androidx.compose.ui.Modifier$Node r3 = (androidx.compose.ui.Modifier.Node) r3
            if (r2 == r0) goto L_0x0040
            int r3 = r2.getKindSet$ui_release()
            r3 = r3 & r13
            if (r3 == 0) goto L_0x0040
            return
        L_0x0040:
            int r3 = r2.getKindSet$ui_release()
            r3 = r3 & r12
            if (r3 == 0) goto L_0x00ba
            r3 = r2
            r5 = r4
        L_0x0049:
            if (r3 == 0) goto L_0x00ba
            r6 = 3
            java.lang.String r7 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r6, r7)
            boolean r6 = r3 instanceof java.lang.Object
            if (r6 == 0) goto L_0x0059
            r14.invoke(r3)
            goto L_0x00b2
        L_0x0059:
            r6 = r3
            androidx.compose.ui.Modifier$Node r6 = (androidx.compose.ui.Modifier.Node) r6
            int r6 = r3.getKindSet$ui_release()
            r6 = r6 & r12
            if (r6 == 0) goto L_0x00b2
            boolean r6 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L_0x00b2
            r6 = r3
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate$ui_release()
            r7 = 0
            r8 = r7
        L_0x0070:
            r9 = 1
            if (r6 == 0) goto L_0x00af
            r10 = r6
            androidx.compose.ui.Modifier$Node r10 = (androidx.compose.ui.Modifier.Node) r10
            int r10 = r6.getKindSet$ui_release()
            r10 = r10 & r12
            if (r10 == 0) goto L_0x00aa
            int r8 = r8 + 1
            if (r8 != r9) goto L_0x0083
            r3 = r6
            goto L_0x00aa
        L_0x0083:
            r9 = r5
            androidx.compose.runtime.collection.MutableVector r9 = (androidx.compose.runtime.collection.MutableVector) r9
            if (r5 != 0) goto L_0x0094
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r9 = 16
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r9]
            r5.<init>(r9, r7)
            r9 = r5
            androidx.compose.runtime.collection.MutableVector r9 = (androidx.compose.runtime.collection.MutableVector) r9
        L_0x0094:
            r9 = r3
            androidx.compose.ui.Modifier$Node r9 = (androidx.compose.ui.Modifier.Node) r9
            if (r3 == 0) goto L_0x00a2
            r9 = r5
            androidx.compose.runtime.collection.MutableVector r9 = (androidx.compose.runtime.collection.MutableVector) r9
            if (r5 == 0) goto L_0x00a1
            r5.add(r3)
        L_0x00a1:
            r3 = r4
        L_0x00a2:
            r9 = r5
            androidx.compose.runtime.collection.MutableVector r9 = (androidx.compose.runtime.collection.MutableVector) r9
            if (r5 == 0) goto L_0x00aa
            r5.add(r6)
        L_0x00aa:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L_0x0070
        L_0x00af:
            if (r8 != r9) goto L_0x00b2
            goto L_0x0049
        L_0x00b2:
            r3 = r5
            androidx.compose.runtime.collection.MutableVector r3 = (androidx.compose.runtime.collection.MutableVector) r3
            androidx.compose.ui.Modifier$Node r3 = pop(r5)
            goto L_0x0049
        L_0x00ba:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x002a
        L_0x00c0:
            androidx.compose.ui.node.LayoutNode r11 = r11.getParent$ui_release()
            if (r11 == 0) goto L_0x00d2
            androidx.compose.ui.node.NodeChain r2 = r11.getNodes$ui_release()
            if (r2 == 0) goto L_0x00d2
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x0018
        L_0x00d2:
            r2 = r4
            goto L_0x0018
        L_0x00d5:
            return
        L_0x00d6:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "visitAncestors called on an unattached node"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.m5474visitSelfAndAncestors5BbP62I(androidx.compose.ui.node.DelegatableNode, int, int, kotlin.jvm.functions.Function1):void");
    }

    /* renamed from: visitSelfAndChildren-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m5475visitSelfAndChildren6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        Modifier.Node node = delegatableNode.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node instanceof Object) {
                function1.invoke(node);
            } else {
                Modifier.Node node2 = node;
                if ((node.getKindSet$ui_release() & i) != 0 && (node instanceof DelegatingNode)) {
                    int i2 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        Modifier.Node node3 = delegate$ui_release;
                        if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                            i2++;
                            if (i2 == 1) {
                                node = delegate$ui_release;
                            } else {
                                MutableVector mutableVector2 = mutableVector;
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    MutableVector mutableVector3 = mutableVector;
                                }
                                Modifier.Node node4 = node;
                                if (node != null) {
                                    MutableVector mutableVector4 = mutableVector;
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                MutableVector mutableVector5 = mutableVector;
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
            }
            MutableVector mutableVector6 = mutableVector;
            node = pop(mutableVector);
        }
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector7, delegatableNode.getNode());
            } else {
                mutableVector7.add(child$ui_release);
            }
            while (mutableVector7.isNotEmpty()) {
                Modifier.Node node5 = (Modifier.Node) mutableVector7.removeAt(mutableVector7.getSize() - 1);
                if ((node5.getAggregateChildKindSet$ui_release() & i) == 0) {
                    addLayoutNodeChildren(mutableVector7, node5);
                } else {
                    while (true) {
                        if (node5 == null) {
                            break;
                        } else if ((node5.getKindSet$ui_release() & i) != 0) {
                            Modifier.Node node6 = node5;
                            MutableVector mutableVector8 = null;
                            while (node5 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if (node5 instanceof Object) {
                                    function1.invoke(node5);
                                } else {
                                    Modifier.Node node7 = node5;
                                    if ((node5.getKindSet$ui_release() & i) != 0 && (node5 instanceof DelegatingNode)) {
                                        int i3 = 0;
                                        for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node5).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                            Modifier.Node node8 = delegate$ui_release2;
                                            if ((delegate$ui_release2.getKindSet$ui_release() & i) != 0) {
                                                i3++;
                                                if (i3 == 1) {
                                                    node5 = delegate$ui_release2;
                                                } else {
                                                    MutableVector mutableVector9 = mutableVector8;
                                                    if (mutableVector8 == null) {
                                                        mutableVector8 = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector10 = mutableVector8;
                                                    }
                                                    Modifier.Node node9 = node5;
                                                    if (node5 != null) {
                                                        MutableVector mutableVector11 = mutableVector8;
                                                        if (mutableVector8 != null) {
                                                            mutableVector8.add(node5);
                                                        }
                                                        node5 = null;
                                                    }
                                                    MutableVector mutableVector12 = mutableVector8;
                                                    if (mutableVector8 != null) {
                                                        mutableVector8.add(delegate$ui_release2);
                                                    }
                                                }
                                            }
                                        }
                                        if (i3 == 1) {
                                        }
                                    }
                                }
                                MutableVector mutableVector13 = mutableVector8;
                                node5 = pop(mutableVector8);
                            }
                        } else {
                            node5 = node5.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* renamed from: has-64DMado  reason: not valid java name */
    public static final boolean m5466has64DMado(DelegatableNode delegatableNode, int i) {
        return (delegatableNode.getNode().getAggregateChildKindSet$ui_release() & i) != 0;
    }

    /* renamed from: requireCoordinator-64DMado  reason: not valid java name */
    public static final NodeCoordinator m5468requireCoordinator64DMado(DelegatableNode delegatableNode, int i) {
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(coordinator$ui_release);
        if (coordinator$ui_release.getTail() != delegatableNode || !NodeKindKt.m5656getIncludeSelfInTraversalH91voCI(i)) {
            return coordinator$ui_release;
        }
        NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped$ui_release();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator$ui_release();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.getLayoutNode();
        }
        throw new IllegalStateException("Cannot obtain node coordinator. Is the Modifier.Node attached?".toString());
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Owner owner$ui_release = requireLayoutNode(delegatableNode).getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("This node does not have an owner.".toString());
    }

    public static final Density requireDensity(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getDensity();
    }

    public static final LayoutDirection requireLayoutDirection(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getLayoutDirection();
    }

    public static final void invalidateSubtree(DelegatableNode delegatableNode) {
        if (delegatableNode.getNode().isAttached()) {
            LayoutNode.invalidateSubtree$default(requireLayoutNode(delegatableNode), false, 1, (Object) null);
        }
    }

    /* renamed from: dispatchForKind-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m5465dispatchForKind6rFNWt0(Modifier.Node node, int i, Function1<? super T, Unit> function1) {
        MutableVector mutableVector = null;
        while (node != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node instanceof Object) {
                function1.invoke(node);
            } else {
                Modifier.Node node2 = node;
                if ((node.getKindSet$ui_release() & i) != 0 && (node instanceof DelegatingNode)) {
                    int i2 = 0;
                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                        Modifier.Node node3 = delegate$ui_release;
                        if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                            i2++;
                            if (i2 == 1) {
                                node = delegate$ui_release;
                            } else {
                                MutableVector mutableVector2 = mutableVector;
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                    MutableVector mutableVector3 = mutableVector;
                                }
                                Modifier.Node node4 = node;
                                if (node != null) {
                                    MutableVector mutableVector4 = mutableVector;
                                    if (mutableVector != null) {
                                        mutableVector.add(node);
                                    }
                                    node = null;
                                }
                                MutableVector mutableVector5 = mutableVector;
                                if (mutableVector != null) {
                                    mutableVector.add(delegate$ui_release);
                                }
                            }
                        }
                    }
                    if (i2 == 1) {
                    }
                }
            }
            MutableVector mutableVector6 = mutableVector;
            node = pop(mutableVector);
        }
    }

    /* access modifiers changed from: private */
    public static final Modifier.Node pop(MutableVector<Modifier.Node> mutableVector) {
        if (mutableVector == null || mutableVector.isEmpty()) {
            return null;
        }
        return mutableVector.removeAt(mutableVector.getSize() - 1);
    }

    /* renamed from: visitLocalDescendants-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m5473visitLocalDescendants6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = delegatableNode.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
                for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                    if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                        Modifier.Node node2 = child$ui_release;
                        Modifier.Node node3 = child$ui_release;
                        MutableVector mutableVector = null;
                        while (node3 != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (node3 instanceof Object) {
                                function1.invoke(node3);
                            } else {
                                Modifier.Node node4 = node3;
                                if ((node3.getKindSet$ui_release() & i) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        Modifier.Node node5 = delegate$ui_release;
                                        if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node3 = delegate$ui_release;
                                            } else {
                                                MutableVector mutableVector2 = mutableVector;
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                    MutableVector mutableVector3 = mutableVector;
                                                }
                                                Modifier.Node node6 = node3;
                                                if (node3 != null) {
                                                    MutableVector mutableVector4 = mutableVector;
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node3);
                                                    }
                                                    node3 = null;
                                                }
                                                MutableVector mutableVector5 = mutableVector;
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                            }
                            MutableVector mutableVector6 = mutableVector;
                            node3 = pop(mutableVector);
                        }
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("visitLocalDescendants called on an unattached node".toString());
    }

    /* renamed from: visitLocalAncestors-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m5472visitLocalAncestors6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (delegatableNode.getNode().isAttached()) {
            for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                if ((parent$ui_release.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node = parent$ui_release;
                    Modifier.Node node2 = parent$ui_release;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node2 instanceof Object) {
                            function1.invoke(node2);
                        } else {
                            Modifier.Node node3 = node2;
                            if ((node2.getKindSet$ui_release() & i) != 0 && (node2 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    Modifier.Node node4 = delegate$ui_release;
                                    if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node2 = delegate$ui_release;
                                        } else {
                                            MutableVector mutableVector2 = mutableVector;
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector3 = mutableVector;
                                            }
                                            Modifier.Node node5 = node2;
                                            if (node2 != null) {
                                                MutableVector mutableVector4 = mutableVector;
                                                if (mutableVector != null) {
                                                    mutableVector.add(node2);
                                                }
                                                node2 = null;
                                            }
                                            MutableVector mutableVector5 = mutableVector;
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                        }
                        MutableVector mutableVector6 = mutableVector;
                        node2 = pop(mutableVector);
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("visitLocalAncestors called on an unattached node".toString());
    }

    /* renamed from: visitAncestors-Y-YKmho  reason: not valid java name */
    public static final /* synthetic */ <T> void m5469visitAncestorsYYKmho(DelegatableNode delegatableNode, int i, boolean z, Function1<? super T, Unit> function1) {
        NodeChain nodes$ui_release;
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & i) != 0) {
                            Modifier.Node node2 = node;
                            Modifier.Node node3 = node;
                            MutableVector mutableVector = null;
                            while (node3 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if (node3 instanceof Object) {
                                    function1.invoke(node3);
                                } else {
                                    Modifier.Node node4 = node3;
                                    if ((node3.getKindSet$ui_release() & i) != 0 && (node3 instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            Modifier.Node node5 = delegate$ui_release;
                                            if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node3 = delegate$ui_release;
                                                } else {
                                                    MutableVector mutableVector2 = mutableVector;
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector3 = mutableVector;
                                                    }
                                                    Modifier.Node node6 = node3;
                                                    if (node3 != null) {
                                                        MutableVector mutableVector4 = mutableVector;
                                                        if (mutableVector != null) {
                                                            mutableVector.add(node3);
                                                        }
                                                        node3 = null;
                                                    }
                                                    MutableVector mutableVector5 = mutableVector;
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                }
                                MutableVector mutableVector6 = mutableVector;
                                node3 = pop(mutableVector);
                            }
                        }
                        node = node.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* renamed from: visitAncestors-Y-YKmho$default  reason: not valid java name */
    public static /* synthetic */ void m5470visitAncestorsYYKmho$default(DelegatableNode delegatableNode, int i, boolean z, Function1 function1, int i2, Object obj) {
        NodeChain nodes$ui_release;
        if ((i2 & 2) != 0) {
            z = false;
        }
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node node = z ? delegatableNode.getNode() : delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & i) != 0) {
                    while (node != null) {
                        if ((node.getKindSet$ui_release() & i) != 0) {
                            Modifier.Node node2 = node;
                            Modifier.Node node3 = node;
                            MutableVector mutableVector = null;
                            while (node3 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if (node3 instanceof Object) {
                                    function1.invoke(node3);
                                } else {
                                    Modifier.Node node4 = node3;
                                    if ((node3.getKindSet$ui_release() & i) != 0 && (node3 instanceof DelegatingNode)) {
                                        int i3 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            Modifier.Node node5 = delegate$ui_release;
                                            if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                                i3++;
                                                if (i3 == 1) {
                                                    node3 = delegate$ui_release;
                                                } else {
                                                    MutableVector mutableVector2 = mutableVector;
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector3 = mutableVector;
                                                    }
                                                    Modifier.Node node6 = node3;
                                                    if (node3 != null) {
                                                        MutableVector mutableVector4 = mutableVector;
                                                        if (mutableVector != null) {
                                                            mutableVector.add(node3);
                                                        }
                                                        node3 = null;
                                                    }
                                                    MutableVector mutableVector5 = mutableVector;
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                        }
                                        if (i3 == 1) {
                                        }
                                    }
                                }
                                MutableVector mutableVector6 = mutableVector;
                                node3 = pop(mutableVector);
                            }
                        }
                        node = node.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c0, code lost:
        r0 = r10.getNodes$ui_release();
     */
    /* renamed from: ancestors-64DMado  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> java.util.List<T> m5464ancestors64DMado(androidx.compose.ui.node.DelegatableNode r10, int r11) {
        /*
            androidx.compose.ui.Modifier$Node r0 = r10.getNode()
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x00d3
            androidx.compose.ui.Modifier$Node r0 = r10.getNode()
            androidx.compose.ui.Modifier$Node r0 = r0.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r10 = requireLayoutNode(r10)
            r1 = 0
            r2 = r1
        L_0x0018:
            if (r10 == 0) goto L_0x00cf
            androidx.compose.ui.node.NodeChain r3 = r10.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r11
            if (r3 == 0) goto L_0x00ba
        L_0x0029:
            if (r0 == 0) goto L_0x00ba
            int r3 = r0.getKindSet$ui_release()
            r3 = r3 & r11
            if (r3 == 0) goto L_0x00b4
            r3 = r0
            androidx.compose.ui.Modifier$Node r3 = (androidx.compose.ui.Modifier.Node) r3
            r3 = r0
            r4 = r1
        L_0x0037:
            if (r3 == 0) goto L_0x00b4
            r5 = 3
            java.lang.String r6 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r5, r6)
            boolean r5 = r3 instanceof java.lang.Object
            if (r5 == 0) goto L_0x0053
            if (r2 != 0) goto L_0x004c
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
        L_0x004c:
            r5 = r2
            java.util.List r5 = (java.util.List) r5
            r2.add(r3)
            goto L_0x00ac
        L_0x0053:
            r5 = r3
            androidx.compose.ui.Modifier$Node r5 = (androidx.compose.ui.Modifier.Node) r5
            int r5 = r3.getKindSet$ui_release()
            r5 = r5 & r11
            if (r5 == 0) goto L_0x00ac
            boolean r5 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r5 == 0) goto L_0x00ac
            r5 = r3
            androidx.compose.ui.node.DelegatingNode r5 = (androidx.compose.ui.node.DelegatingNode) r5
            androidx.compose.ui.Modifier$Node r5 = r5.getDelegate$ui_release()
            r6 = 0
            r7 = r6
        L_0x006a:
            r8 = 1
            if (r5 == 0) goto L_0x00a9
            r9 = r5
            androidx.compose.ui.Modifier$Node r9 = (androidx.compose.ui.Modifier.Node) r9
            int r9 = r5.getKindSet$ui_release()
            r9 = r9 & r11
            if (r9 == 0) goto L_0x00a4
            int r7 = r7 + 1
            if (r7 != r8) goto L_0x007d
            r3 = r5
            goto L_0x00a4
        L_0x007d:
            r8 = r4
            androidx.compose.runtime.collection.MutableVector r8 = (androidx.compose.runtime.collection.MutableVector) r8
            if (r4 != 0) goto L_0x008e
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            r8 = 16
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r8]
            r4.<init>(r8, r6)
            r8 = r4
            androidx.compose.runtime.collection.MutableVector r8 = (androidx.compose.runtime.collection.MutableVector) r8
        L_0x008e:
            r8 = r3
            androidx.compose.ui.Modifier$Node r8 = (androidx.compose.ui.Modifier.Node) r8
            if (r3 == 0) goto L_0x009c
            r8 = r4
            androidx.compose.runtime.collection.MutableVector r8 = (androidx.compose.runtime.collection.MutableVector) r8
            if (r4 == 0) goto L_0x009b
            r4.add(r3)
        L_0x009b:
            r3 = r1
        L_0x009c:
            r8 = r4
            androidx.compose.runtime.collection.MutableVector r8 = (androidx.compose.runtime.collection.MutableVector) r8
            if (r4 == 0) goto L_0x00a4
            r4.add(r5)
        L_0x00a4:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L_0x006a
        L_0x00a9:
            if (r7 != r8) goto L_0x00ac
            goto L_0x0037
        L_0x00ac:
            r3 = r4
            androidx.compose.runtime.collection.MutableVector r3 = (androidx.compose.runtime.collection.MutableVector) r3
            androidx.compose.ui.Modifier$Node r3 = pop(r4)
            goto L_0x0037
        L_0x00b4:
            androidx.compose.ui.Modifier$Node r0 = r0.getParent$ui_release()
            goto L_0x0029
        L_0x00ba:
            androidx.compose.ui.node.LayoutNode r10 = r10.getParent$ui_release()
            if (r10 == 0) goto L_0x00cc
            androidx.compose.ui.node.NodeChain r0 = r10.getNodes$ui_release()
            if (r0 == 0) goto L_0x00cc
            androidx.compose.ui.Modifier$Node r0 = r0.getTail$ui_release()
            goto L_0x0018
        L_0x00cc:
            r0 = r1
            goto L_0x0018
        L_0x00cf:
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            return r2
        L_0x00d3:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "visitAncestors called on an unattached node"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.m5464ancestors64DMado(androidx.compose.ui.node.DelegatableNode, int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        r0 = r9.getNodes$ui_release();
     */
    /* renamed from: nearestAncestor-64DMado  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ <T> T m5467nearestAncestor64DMado(androidx.compose.ui.node.DelegatableNode r9, int r10) {
        /*
            androidx.compose.ui.Modifier$Node r0 = r9.getNode()
            boolean r0 = r0.isAttached()
            if (r0 == 0) goto L_0x00c0
            androidx.compose.ui.Modifier$Node r0 = r9.getNode()
            androidx.compose.ui.Modifier$Node r0 = r0.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r9 = requireLayoutNode(r9)
        L_0x0016:
            r1 = 0
            if (r9 == 0) goto L_0x00bf
            androidx.compose.ui.node.NodeChain r2 = r9.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r2 = r2.getHead$ui_release()
            int r2 = r2.getAggregateChildKindSet$ui_release()
            r2 = r2 & r10
            if (r2 == 0) goto L_0x00aa
        L_0x0028:
            if (r0 == 0) goto L_0x00aa
            int r2 = r0.getKindSet$ui_release()
            r2 = r2 & r10
            if (r2 == 0) goto L_0x00a4
            r2 = r0
            androidx.compose.ui.Modifier$Node r2 = (androidx.compose.ui.Modifier.Node) r2
            r2 = r0
            r3 = r1
        L_0x0036:
            if (r2 == 0) goto L_0x00a4
            r4 = 3
            java.lang.String r5 = "T"
            kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(r4, r5)
            boolean r4 = r2 instanceof java.lang.Object
            if (r4 == 0) goto L_0x0043
            return r2
        L_0x0043:
            r4 = r2
            androidx.compose.ui.Modifier$Node r4 = (androidx.compose.ui.Modifier.Node) r4
            int r4 = r2.getKindSet$ui_release()
            r4 = r4 & r10
            if (r4 == 0) goto L_0x009c
            boolean r4 = r2 instanceof androidx.compose.ui.node.DelegatingNode
            if (r4 == 0) goto L_0x009c
            r4 = r2
            androidx.compose.ui.node.DelegatingNode r4 = (androidx.compose.ui.node.DelegatingNode) r4
            androidx.compose.ui.Modifier$Node r4 = r4.getDelegate$ui_release()
            r5 = 0
            r6 = r5
        L_0x005a:
            r7 = 1
            if (r4 == 0) goto L_0x0099
            r8 = r4
            androidx.compose.ui.Modifier$Node r8 = (androidx.compose.ui.Modifier.Node) r8
            int r8 = r4.getKindSet$ui_release()
            r8 = r8 & r10
            if (r8 == 0) goto L_0x0094
            int r6 = r6 + 1
            if (r6 != r7) goto L_0x006d
            r2 = r4
            goto L_0x0094
        L_0x006d:
            r7 = r3
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
            if (r3 != 0) goto L_0x007e
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            r7 = 16
            androidx.compose.ui.Modifier$Node[] r7 = new androidx.compose.ui.Modifier.Node[r7]
            r3.<init>(r7, r5)
            r7 = r3
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
        L_0x007e:
            r7 = r2
            androidx.compose.ui.Modifier$Node r7 = (androidx.compose.ui.Modifier.Node) r7
            if (r2 == 0) goto L_0x008c
            r7 = r3
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
            if (r3 == 0) goto L_0x008b
            r3.add(r2)
        L_0x008b:
            r2 = r1
        L_0x008c:
            r7 = r3
            androidx.compose.runtime.collection.MutableVector r7 = (androidx.compose.runtime.collection.MutableVector) r7
            if (r3 == 0) goto L_0x0094
            r3.add(r4)
        L_0x0094:
            androidx.compose.ui.Modifier$Node r4 = r4.getChild$ui_release()
            goto L_0x005a
        L_0x0099:
            if (r6 != r7) goto L_0x009c
            goto L_0x0036
        L_0x009c:
            r2 = r3
            androidx.compose.runtime.collection.MutableVector r2 = (androidx.compose.runtime.collection.MutableVector) r2
            androidx.compose.ui.Modifier$Node r2 = pop(r3)
            goto L_0x0036
        L_0x00a4:
            androidx.compose.ui.Modifier$Node r0 = r0.getParent$ui_release()
            goto L_0x0028
        L_0x00aa:
            androidx.compose.ui.node.LayoutNode r9 = r9.getParent$ui_release()
            if (r9 == 0) goto L_0x00bc
            androidx.compose.ui.node.NodeChain r0 = r9.getNodes$ui_release()
            if (r0 == 0) goto L_0x00bc
            androidx.compose.ui.Modifier$Node r0 = r0.getTail$ui_release()
            goto L_0x0016
        L_0x00bc:
            r0 = r1
            goto L_0x0016
        L_0x00bf:
            return r1
        L_0x00c0:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "visitAncestors called on an unattached node"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatableNodeKt.m5467nearestAncestor64DMado(androidx.compose.ui.node.DelegatableNode, int):java.lang.Object");
    }

    /* renamed from: visitSubtree-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m5476visitSubtree6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            LayoutNode requireLayoutNode = requireLayoutNode(delegatableNode);
            NestedVectorStack nestedVectorStack = new NestedVectorStack();
            while (requireLayoutNode != null) {
                if (child$ui_release == null) {
                    child$ui_release = requireLayoutNode.getNodes$ui_release().getHead$ui_release();
                }
                if ((child$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                    while (child$ui_release != null) {
                        if ((child$ui_release.getKindSet$ui_release() & i) != 0) {
                            Modifier.Node node = child$ui_release;
                            Modifier.Node node2 = child$ui_release;
                            MutableVector mutableVector = null;
                            while (node2 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if (node2 instanceof Object) {
                                    function1.invoke(node2);
                                } else {
                                    Modifier.Node node3 = node2;
                                    if ((node2.getKindSet$ui_release() & i) != 0 && (node2 instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            Modifier.Node node4 = delegate$ui_release;
                                            if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node2 = delegate$ui_release;
                                                } else {
                                                    MutableVector mutableVector2 = mutableVector;
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector3 = mutableVector;
                                                    }
                                                    Modifier.Node node5 = node2;
                                                    if (node2 != null) {
                                                        MutableVector mutableVector4 = mutableVector;
                                                        if (mutableVector != null) {
                                                            mutableVector.add(node2);
                                                        }
                                                        node2 = null;
                                                    }
                                                    MutableVector mutableVector5 = mutableVector;
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                }
                                MutableVector mutableVector6 = mutableVector;
                                node2 = pop(mutableVector);
                            }
                        }
                        child$ui_release = child$ui_release.getChild$ui_release();
                    }
                }
                nestedVectorStack.push(requireLayoutNode.get_children$ui_release());
                requireLayoutNode = nestedVectorStack.isNotEmpty() ? (LayoutNode) nestedVectorStack.pop() : null;
                child$ui_release = null;
            }
            return;
        }
        throw new IllegalStateException("visitSubtree called on an unattached node".toString());
    }

    /* renamed from: visitChildren-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m5471visitChildren6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1) {
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & i) == 0) {
                    addLayoutNodeChildren(mutableVector, node);
                } else {
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui_release() & i) != 0) {
                            Modifier.Node node2 = node;
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if (node instanceof Object) {
                                    function1.invoke(node);
                                } else {
                                    Modifier.Node node3 = node;
                                    if ((node.getKindSet$ui_release() & i) != 0 && (node instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            Modifier.Node node4 = delegate$ui_release;
                                            if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node = delegate$ui_release;
                                                } else {
                                                    MutableVector mutableVector3 = mutableVector2;
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector4 = mutableVector2;
                                                    }
                                                    Modifier.Node node5 = node;
                                                    if (node != null) {
                                                        MutableVector mutableVector5 = mutableVector2;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(node);
                                                        }
                                                        node = null;
                                                    }
                                                    MutableVector mutableVector6 = mutableVector2;
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                }
                                MutableVector mutableVector7 = mutableVector2;
                                node = pop(mutableVector2);
                            }
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            return;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* renamed from: visitSubtreeIf-6rFNWt0  reason: not valid java name */
    public static final /* synthetic */ <T> void m5477visitSubtreeIf6rFNWt0(DelegatableNode delegatableNode, int i, Function1<? super T, Boolean> function1) {
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = node;
                    while (true) {
                        if (node2 == null) {
                            break;
                        }
                        if ((node2.getKindSet$ui_release() & i) != 0) {
                            Modifier.Node node3 = node2;
                            Modifier.Node node4 = node2;
                            MutableVector mutableVector2 = null;
                            while (node4 != null) {
                                Intrinsics.reifiedOperationMarker(3, "T");
                                if (node4 instanceof Object) {
                                    if (!function1.invoke(node4).booleanValue()) {
                                        break;
                                    }
                                } else {
                                    Modifier.Node node5 = node4;
                                    if ((node4.getKindSet$ui_release() & i) != 0 && (node4 instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            Modifier.Node node6 = delegate$ui_release;
                                            if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node4 = delegate$ui_release;
                                                } else {
                                                    MutableVector mutableVector3 = mutableVector2;
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                        MutableVector mutableVector4 = mutableVector2;
                                                    }
                                                    Modifier.Node node7 = node4;
                                                    if (node4 != null) {
                                                        MutableVector mutableVector5 = mutableVector2;
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(node4);
                                                        }
                                                        node4 = null;
                                                    }
                                                    MutableVector mutableVector6 = mutableVector2;
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                }
                                MutableVector mutableVector7 = mutableVector2;
                                node4 = pop(mutableVector2);
                            }
                            continue;
                        }
                        node2 = node2.getChild$ui_release();
                    }
                }
                addLayoutNodeChildren(mutableVector, node);
            }
            return;
        }
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }

    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node node) {
        if ((NodeKind.m5647constructorimpl(2) & node.getKindSet$ui_release()) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release();
                while (delegate$ui_release != null) {
                    if (delegate$ui_release instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) delegate$ui_release;
                    }
                    if (!(delegate$ui_release instanceof DelegatingNode) || (NodeKind.m5647constructorimpl(2) & delegate$ui_release.getKindSet$ui_release()) == 0) {
                        delegate$ui_release = delegate$ui_release.getChild$ui_release();
                    } else {
                        delegate$ui_release = ((DelegatingNode) delegate$ui_release).getDelegate$ui_release();
                    }
                }
            }
        }
        return null;
    }
}
