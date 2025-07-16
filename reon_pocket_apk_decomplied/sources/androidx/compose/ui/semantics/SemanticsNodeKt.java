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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u0007H\u0002\u001a\"\u0010\u0011\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0013H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0010*\u00020\u0007H\u0002\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"outerMergingSemantics", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/LayoutNode;", "getOuterMergingSemantics", "(Landroidx/compose/ui/node/LayoutNode;)Landroidx/compose/ui/node/SemanticsModifierNode;", "role", "Landroidx/compose/ui/semantics/Role;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRole", "(Landroidx/compose/ui/semantics/SemanticsNode;)Landroidx/compose/ui/semantics/Role;", "SemanticsNode", "layoutNode", "mergingEnabled", "", "outerSemanticsNode", "contentDescriptionFakeNodeId", "", "findClosestParentNode", "selector", "Lkotlin/Function1;", "roleFakeNodeId", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: SemanticsNode.kt */
public final class SemanticsNodeKt {
    public static final SemanticsNode SemanticsNode(LayoutNode layoutNode, boolean z) {
        NodeChain nodes$ui_release = layoutNode.getNodes$ui_release();
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
        Modifier.Node node3 = ((SemanticsModifierNode) node).getNode();
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        Intrinsics.checkNotNull(collapsedSemantics$ui_release);
        return new SemanticsNode(node3, z, layoutNode, collapsedSemantics$ui_release);
    }

    public static /* synthetic */ SemanticsNode SemanticsNode$default(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode, int i, Object obj) {
        if ((i & 4) != 0) {
            layoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode);
        }
        return SemanticsNode(semanticsModifierNode, z, layoutNode);
    }

    public static final SemanticsNode SemanticsNode(SemanticsModifierNode semanticsModifierNode, boolean z, LayoutNode layoutNode) {
        Modifier.Node node = semanticsModifierNode.getNode();
        SemanticsConfiguration collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release();
        if (collapsedSemantics$ui_release == null) {
            collapsedSemantics$ui_release = new SemanticsConfiguration();
        }
        return new SemanticsNode(node, z, layoutNode, collapsedSemantics$ui_release);
    }

    public static final SemanticsModifierNode getOuterMergingSemantics(LayoutNode layoutNode) {
        NodeChain nodes$ui_release = layoutNode.getNodes$ui_release();
        int r0 = NodeKind.m5647constructorimpl(8);
        Modifier.Node node = null;
        if ((nodes$ui_release.getAggregateChildKindSet() & r0) != 0) {
            Modifier.Node head$ui_release = nodes$ui_release.getHead$ui_release();
            loop0:
            while (true) {
                if (head$ui_release != null) {
                    if ((head$ui_release.getKindSet$ui_release() & r0) != 0) {
                        Modifier.Node node2 = head$ui_release;
                        MutableVector mutableVector = null;
                        while (true) {
                            if (node2 == null) {
                                break;
                            }
                            if (node2 instanceof SemanticsModifierNode) {
                                if (((SemanticsModifierNode) node2).getShouldMergeDescendantSemantics()) {
                                    node = node2;
                                    break loop0;
                                }
                            } else if ((node2.getKindSet$ui_release() & r0) != 0 && (node2 instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
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
                    if ((head$ui_release.getAggregateChildKindSet$ui_release() & r0) == 0) {
                        break;
                    }
                    head$ui_release = head$ui_release.getChild$ui_release();
                } else {
                    break;
                }
            }
        }
        return (SemanticsModifierNode) node;
    }

    public static final LayoutNode findClosestParentNode(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        for (LayoutNode parent$ui_release = layoutNode.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            if (function1.invoke(parent$ui_release).booleanValue()) {
                return parent$ui_release;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final Role getRole(SemanticsNode semanticsNode) {
        return (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getRole());
    }

    /* access modifiers changed from: private */
    public static final int contentDescriptionFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 2000000000;
    }

    /* access modifiers changed from: private */
    public static final int roleFakeNodeId(SemanticsNode semanticsNode) {
        return semanticsNode.getId() + 1000000000;
    }
}
