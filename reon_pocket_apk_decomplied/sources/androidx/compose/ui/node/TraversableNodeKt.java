package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.TraversableNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u0001¢\u0006\u0002\u0010\u0003\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a-\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u0007\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\u000e\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u0002H\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\n¨\u0006\u0010"}, d2 = {"findNearestAncestor", "T", "Landroidx/compose/ui/node/TraversableNode;", "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "key", "", "traverseAncestors", "", "block", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TraversableNode.kt */
public final class TraversableNodeKt {
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ad, code lost:
        r2 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T extends androidx.compose.ui.node.TraversableNode> T findNearestAncestor(T r11) {
        /*
            r0 = r11
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r1 = 262144(0x40000, float:3.67342E-40)
            int r1 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x00bd
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x001f:
            r3 = 0
            if (r0 == 0) goto L_0x00bc
            androidx.compose.ui.node.NodeChain r4 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r4 = r4.getHead$ui_release()
            int r4 = r4.getAggregateChildKindSet$ui_release()
            r4 = r4 & r1
            if (r4 == 0) goto L_0x00a7
        L_0x0031:
            if (r2 == 0) goto L_0x00a7
            int r4 = r2.getKindSet$ui_release()
            r4 = r4 & r1
            if (r4 == 0) goto L_0x00a2
            r4 = r2
            r5 = r3
        L_0x003c:
            if (r4 == 0) goto L_0x00a2
            boolean r6 = r4 instanceof androidx.compose.ui.node.TraversableNode
            if (r6 == 0) goto L_0x0059
            androidx.compose.ui.node.TraversableNode r4 = (androidx.compose.ui.node.TraversableNode) r4
            java.lang.Object r6 = r11.getTraverseKey()
            java.lang.Object r7 = r4.getTraverseKey()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x009d
            boolean r6 = androidx.compose.ui.Actual_jvmKt.areObjectsOfSameType(r11, r4)
            if (r6 == 0) goto L_0x009d
            return r4
        L_0x0059:
            int r6 = r4.getKindSet$ui_release()
            r6 = r6 & r1
            if (r6 == 0) goto L_0x009d
            boolean r6 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L_0x009d
            r6 = r4
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate$ui_release()
            r7 = 0
            r8 = r7
        L_0x006d:
            r9 = 1
            if (r6 == 0) goto L_0x009a
            int r10 = r6.getKindSet$ui_release()
            r10 = r10 & r1
            if (r10 == 0) goto L_0x0095
            int r8 = r8 + 1
            if (r8 != r9) goto L_0x007d
            r4 = r6
            goto L_0x0095
        L_0x007d:
            if (r5 != 0) goto L_0x0088
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r9 = 16
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r9]
            r5.<init>(r9, r7)
        L_0x0088:
            if (r4 == 0) goto L_0x0090
            if (r5 == 0) goto L_0x008f
            r5.add(r4)
        L_0x008f:
            r4 = r3
        L_0x0090:
            if (r5 == 0) goto L_0x0095
            r5.add(r6)
        L_0x0095:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L_0x006d
        L_0x009a:
            if (r8 != r9) goto L_0x009d
            goto L_0x003c
        L_0x009d:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.pop(r5)
            goto L_0x003c
        L_0x00a2:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x0031
        L_0x00a7:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00b9
            androidx.compose.ui.node.NodeChain r2 = r0.getNodes$ui_release()
            if (r2 == 0) goto L_0x00b9
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x001f
        L_0x00b9:
            r2 = r3
            goto L_0x001f
        L_0x00bc:
            return r3
        L_0x00bd:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.findNearestAncestor(androidx.compose.ui.node.TraversableNode):androidx.compose.ui.node.TraversableNode");
    }

    public static final <T extends TraversableNode> void traverseAncestors(T t, Function1<? super T, Boolean> function1) {
        NodeChain nodes$ui_release;
        DelegatableNode delegatableNode = (DelegatableNode) t;
        int r1 = NodeKind.m5647constructorimpl(262144);
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r1) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & r1) != 0) {
                            Modifier.Node node = parent$ui_release;
                            MutableVector mutableVector = null;
                            while (node != null) {
                                boolean z = true;
                                if (node instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) node;
                                    if (Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) && Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                        z = function1.invoke(traversableNode).booleanValue();
                                    }
                                    if (!z) {
                                        return;
                                    }
                                } else if ((node.getKindSet$ui_release() & r1) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node);
                                                    }
                                                    node = null;
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
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    public static final <T extends TraversableNode> void traverseChildren(T t, Function1<? super T, Boolean> function1) {
        DelegatableNode delegatableNode = (DelegatableNode) t;
        int r1 = NodeKind.m5647constructorimpl(262144);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & r1) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
                } else {
                    while (true) {
                        if (node == null) {
                            continue;
                            break;
                        } else if ((node.getKindSet$ui_release() & r1) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                if (node instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) node;
                                    if (!((!Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) || !Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) ? true : function1.invoke(traversableNode).booleanValue())) {
                                        return;
                                    }
                                } else if ((node.getKindSet$ui_release() & r1) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
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

    public static final <T extends TraversableNode> void traverseDescendants(T t, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction;
        DelegatableNode delegatableNode = (DelegatableNode) t;
        int r1 = NodeKind.m5647constructorimpl(262144);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & r1) != 0) {
                    Modifier.Node node2 = node;
                    while (true) {
                        if (node2 == null) {
                            break;
                        }
                        if ((node2.getKindSet$ui_release() & r1) != 0) {
                            Modifier.Node node3 = node2;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) node3;
                                    if (!Intrinsics.areEqual(t.getTraverseKey(), traversableNode.getTraverseKey()) || !Actual_jvmKt.areObjectsOfSameType(t, traversableNode)) {
                                        traverseDescendantsAction = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                    } else {
                                        traverseDescendantsAction = (TraversableNode.Companion.TraverseDescendantsAction) function1.invoke(traversableNode);
                                    }
                                    if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                        if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if ((node3.getKindSet$ui_release() & r1) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node3 = delegate$ui_release;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node3);
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        }
                        node2 = node2.getChild$ui_release();
                    }
                }
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
            }
            return;
        }
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a0, code lost:
        r1 = r10.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.node.TraversableNode findNearestAncestor(androidx.compose.ui.node.DelegatableNode r10, java.lang.Object r11) {
        /*
            r0 = 262144(0x40000, float:3.67342E-40)
            int r0 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L_0x00b0
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r10 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r10)
        L_0x001c:
            r2 = 0
            if (r10 == 0) goto L_0x00af
            androidx.compose.ui.node.NodeChain r3 = r10.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r0
            if (r3 == 0) goto L_0x009a
        L_0x002e:
            if (r1 == 0) goto L_0x009a
            int r3 = r1.getKindSet$ui_release()
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0095
            r3 = r1
            r4 = r2
        L_0x0039:
            if (r3 == 0) goto L_0x0095
            boolean r5 = r3 instanceof androidx.compose.ui.node.TraversableNode
            if (r5 == 0) goto L_0x004c
            androidx.compose.ui.node.TraversableNode r3 = (androidx.compose.ui.node.TraversableNode) r3
            java.lang.Object r5 = r3.getTraverseKey()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0090
            return r3
        L_0x004c:
            int r5 = r3.getKindSet$ui_release()
            r5 = r5 & r0
            if (r5 == 0) goto L_0x0090
            boolean r5 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r5 == 0) goto L_0x0090
            r5 = r3
            androidx.compose.ui.node.DelegatingNode r5 = (androidx.compose.ui.node.DelegatingNode) r5
            androidx.compose.ui.Modifier$Node r5 = r5.getDelegate$ui_release()
            r6 = 0
            r7 = r6
        L_0x0060:
            r8 = 1
            if (r5 == 0) goto L_0x008d
            int r9 = r5.getKindSet$ui_release()
            r9 = r9 & r0
            if (r9 == 0) goto L_0x0088
            int r7 = r7 + 1
            if (r7 != r8) goto L_0x0070
            r3 = r5
            goto L_0x0088
        L_0x0070:
            if (r4 != 0) goto L_0x007b
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            r8 = 16
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r8]
            r4.<init>(r8, r6)
        L_0x007b:
            if (r3 == 0) goto L_0x0083
            if (r4 == 0) goto L_0x0082
            r4.add(r3)
        L_0x0082:
            r3 = r2
        L_0x0083:
            if (r4 == 0) goto L_0x0088
            r4.add(r5)
        L_0x0088:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L_0x0060
        L_0x008d:
            if (r7 != r8) goto L_0x0090
            goto L_0x0039
        L_0x0090:
            androidx.compose.ui.Modifier$Node r3 = androidx.compose.ui.node.DelegatableNodeKt.pop(r4)
            goto L_0x0039
        L_0x0095:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x002e
        L_0x009a:
            androidx.compose.ui.node.LayoutNode r10 = r10.getParent$ui_release()
            if (r10 == 0) goto L_0x00ac
            androidx.compose.ui.node.NodeChain r1 = r10.getNodes$ui_release()
            if (r1 == 0) goto L_0x00ac
            androidx.compose.ui.Modifier$Node r1 = r1.getTail$ui_release()
            goto L_0x001c
        L_0x00ac:
            r1 = r2
            goto L_0x001c
        L_0x00af:
            return r2
        L_0x00b0:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "visitAncestors called on an unattached node"
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.TraversableNodeKt.findNearestAncestor(androidx.compose.ui.node.DelegatableNode, java.lang.Object):androidx.compose.ui.node.TraversableNode");
    }

    public static final void traverseAncestors(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, Boolean> function1) {
        NodeChain nodes$ui_release;
        int r0 = NodeKind.m5647constructorimpl(262144);
        if (delegatableNode.getNode().isAttached()) {
            Modifier.Node parent$ui_release = delegatableNode.getNode().getParent$ui_release();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r0) != 0) {
                    while (parent$ui_release != null) {
                        if ((parent$ui_release.getKindSet$ui_release() & r0) != 0) {
                            Modifier.Node node = parent$ui_release;
                            MutableVector mutableVector = null;
                            while (node != null) {
                                boolean z = true;
                                if (node instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) node;
                                    if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                        z = function1.invoke(traversableNode).booleanValue();
                                    }
                                    if (!z) {
                                        return;
                                    }
                                } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node);
                                                    }
                                                    node = null;
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
                                node = DelegatableNodeKt.pop(mutableVector);
                            }
                            continue;
                        }
                        parent$ui_release = parent$ui_release.getParent$ui_release();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                parent$ui_release = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            return;
        }
        throw new IllegalStateException("visitAncestors called on an unattached node".toString());
    }

    public static final void traverseChildren(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, Boolean> function1) {
        int r0 = NodeKind.m5647constructorimpl(262144);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & r0) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
                } else {
                    while (true) {
                        if (node == null) {
                            continue;
                            break;
                        } else if ((node.getKindSet$ui_release() & r0) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                if (node instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) node;
                                    if (!(Intrinsics.areEqual(obj, traversableNode.getTraverseKey()) ? function1.invoke(traversableNode).booleanValue() : true)) {
                                        return;
                                    }
                                } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
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

    public static final void traverseDescendants(DelegatableNode delegatableNode, Object obj, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> function1) {
        TraversableNode.Companion.TraverseDescendantsAction traverseDescendantsAction;
        int r0 = NodeKind.m5647constructorimpl(262144);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, delegatableNode.getNode());
            } else {
                mutableVector.add(child$ui_release);
            }
            while (mutableVector.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & r0) != 0) {
                    Modifier.Node node2 = node;
                    while (true) {
                        if (node2 == null) {
                            break;
                        }
                        if ((node2.getKindSet$ui_release() & r0) != 0) {
                            Modifier.Node node3 = node2;
                            MutableVector mutableVector2 = null;
                            while (node3 != null) {
                                if (node3 instanceof TraversableNode) {
                                    TraversableNode traversableNode = (TraversableNode) node3;
                                    if (Intrinsics.areEqual(obj, traversableNode.getTraverseKey())) {
                                        traverseDescendantsAction = (TraversableNode.Companion.TraverseDescendantsAction) function1.invoke(traversableNode);
                                    } else {
                                        traverseDescendantsAction = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                                    }
                                    if (traverseDescendantsAction != TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) {
                                        if (traverseDescendantsAction == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) {
                                            break;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if ((node3.getKindSet$ui_release() & r0) != 0 && (node3 instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node3 = delegate$ui_release;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node3 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node3);
                                                    }
                                                    node3 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node3 = DelegatableNodeKt.pop(mutableVector2);
                            }
                            continue;
                        }
                        node2 = node2.getChild$ui_release();
                    }
                }
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
            }
            return;
        }
        throw new IllegalStateException("visitSubtreeIf called on an unattached node".toString());
    }
}
