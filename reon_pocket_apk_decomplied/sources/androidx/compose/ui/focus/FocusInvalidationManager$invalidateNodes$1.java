package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusInvalidationManager.kt */
final class FocusInvalidationManager$invalidateNodes$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FocusInvalidationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusInvalidationManager$invalidateNodes$1(FocusInvalidationManager focusInvalidationManager) {
        super(0);
        this.this$0 = focusInvalidationManager;
    }

    public final void invoke() {
        int i;
        int i2;
        FocusState focusState;
        FocusStateImpl focusStateImpl;
        FocusInvalidationManager focusInvalidationManager = this.this$0;
        Iterator it = this.this$0.focusPropertiesNodes.iterator();
        while (true) {
            int i3 = 1024;
            int i4 = 1;
            if (it.hasNext()) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) it.next();
                if (focusPropertiesModifierNode.getNode().isAttached()) {
                    DelegatableNode delegatableNode = focusPropertiesModifierNode;
                    int r5 = NodeKind.m5647constructorimpl(1024);
                    Modifier.Node node = delegatableNode.getNode();
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof FocusTargetNode) {
                            focusInvalidationManager.focusTargetNodes.add((FocusTargetNode) node);
                        } else if ((node.getKindSet$ui_release() & r5) != 0 && (node instanceof DelegatingNode)) {
                            int i5 = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r5) != 0) {
                                    i5++;
                                    if (i5 == 1) {
                                        node = delegate$ui_release;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node != null) {
                                            if (mutableVector != null) {
                                                Boolean.valueOf(mutableVector.add(node));
                                            }
                                            node = null;
                                        }
                                        if (mutableVector != null) {
                                            Boolean.valueOf(mutableVector.add(delegate$ui_release));
                                        }
                                    }
                                }
                            }
                            if (i5 == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                    if (delegatableNode.getNode().isAttached()) {
                        MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                        Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
                        if (child$ui_release == null) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
                        } else {
                            mutableVector2.add(child$ui_release);
                        }
                        while (mutableVector2.isNotEmpty()) {
                            Modifier.Node node2 = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                            if ((node2.getAggregateChildKindSet$ui_release() & r5) == 0) {
                                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2);
                            } else {
                                while (true) {
                                    if (node2 == null) {
                                        break;
                                    } else if ((node2.getKindSet$ui_release() & r5) != 0) {
                                        MutableVector mutableVector3 = null;
                                        while (node2 != null) {
                                            if (node2 instanceof FocusTargetNode) {
                                                focusInvalidationManager.focusTargetNodes.add((FocusTargetNode) node2);
                                            } else if ((node2.getKindSet$ui_release() & r5) != 0 && (node2 instanceof DelegatingNode)) {
                                                int i6 = 0;
                                                for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                                    if ((delegate$ui_release2.getKindSet$ui_release() & r5) != 0) {
                                                        i6++;
                                                        if (i6 == 1) {
                                                            node2 = delegate$ui_release2;
                                                        } else {
                                                            if (mutableVector3 == null) {
                                                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                            }
                                                            if (node2 != null) {
                                                                if (mutableVector3 != null) {
                                                                    Boolean.valueOf(mutableVector3.add(node2));
                                                                }
                                                                node2 = null;
                                                            }
                                                            if (mutableVector3 != null) {
                                                                Boolean.valueOf(mutableVector3.add(delegate$ui_release2));
                                                            }
                                                        }
                                                    }
                                                }
                                                if (i6 == 1) {
                                                }
                                            }
                                            node2 = DelegatableNodeKt.pop(mutableVector3);
                                        }
                                    } else {
                                        node2 = node2.getChild$ui_release();
                                    }
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException("visitChildren called on an unattached node".toString());
                    }
                }
            } else {
                this.this$0.focusPropertiesNodes.clear();
                Set linkedHashSet = new LinkedHashSet();
                FocusInvalidationManager focusInvalidationManager2 = this.this$0;
                for (FocusEventModifierNode focusEventModifierNode : this.this$0.focusEventNodes) {
                    if (!focusEventModifierNode.getNode().isAttached()) {
                        focusEventModifierNode.onFocusEvent(FocusStateImpl.Inactive);
                        i2 = i;
                    } else {
                        DelegatableNode delegatableNode2 = focusEventModifierNode;
                        int r12 = NodeKind.m5647constructorimpl(i3);
                        Modifier.Node node3 = delegatableNode2.getNode();
                        int i7 = 0;
                        int i8 = i;
                        FocusTargetNode focusTargetNode = null;
                        MutableVector mutableVector4 = null;
                        while (node3 != null) {
                            if (node3 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode2 = (FocusTargetNode) node3;
                                if (focusTargetNode != null) {
                                    i7 = i;
                                }
                                if (focusInvalidationManager2.focusTargetNodes.contains(focusTargetNode2)) {
                                    linkedHashSet.add(focusTargetNode2);
                                    i8 = 0;
                                }
                                focusTargetNode = focusTargetNode2;
                            } else if ((node3.getKindSet$ui_release() & r12) != 0 && (node3 instanceof DelegatingNode)) {
                                Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release();
                                int i9 = 0;
                                while (delegate$ui_release3 != null) {
                                    if ((delegate$ui_release3.getKindSet$ui_release() & r12) != 0) {
                                        i9++;
                                        if (i9 == i) {
                                            node3 = delegate$ui_release3;
                                        } else {
                                            if (mutableVector4 == null) {
                                                mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node3 != null) {
                                                if (mutableVector4 != null) {
                                                    Boolean.valueOf(mutableVector4.add(node3));
                                                }
                                                node3 = null;
                                            }
                                            if (mutableVector4 != null) {
                                                Boolean.valueOf(mutableVector4.add(delegate$ui_release3));
                                            }
                                        }
                                    }
                                    delegate$ui_release3 = delegate$ui_release3.getChild$ui_release();
                                    i = 1;
                                }
                                int i10 = i;
                                if (i9 == i10) {
                                    i = i10;
                                }
                            }
                            node3 = DelegatableNodeKt.pop(mutableVector4);
                            i = 1;
                        }
                        if (delegatableNode2.getNode().isAttached()) {
                            MutableVector mutableVector5 = new MutableVector(new Modifier.Node[16], 0);
                            Modifier.Node child$ui_release2 = delegatableNode2.getNode().getChild$ui_release();
                            if (child$ui_release2 == null) {
                                DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, delegatableNode2.getNode());
                            } else {
                                mutableVector5.add(child$ui_release2);
                            }
                            while (mutableVector5.isNotEmpty()) {
                                Modifier.Node node4 = (Modifier.Node) mutableVector5.removeAt(mutableVector5.getSize() - 1);
                                if ((node4.getAggregateChildKindSet$ui_release() & r12) != 0) {
                                    while (true) {
                                        if (node4 == null) {
                                            break;
                                        } else if ((node4.getKindSet$ui_release() & r12) != 0) {
                                            MutableVector mutableVector6 = null;
                                            while (node4 != null) {
                                                if (node4 instanceof FocusTargetNode) {
                                                    FocusTargetNode focusTargetNode3 = (FocusTargetNode) node4;
                                                    if (focusTargetNode != null) {
                                                        i7 = 1;
                                                    }
                                                    if (focusInvalidationManager2.focusTargetNodes.contains(focusTargetNode3)) {
                                                        linkedHashSet.add(focusTargetNode3);
                                                        i8 = 0;
                                                    }
                                                    focusTargetNode = focusTargetNode3;
                                                } else if ((node4.getKindSet$ui_release() & r12) != 0 && (node4 instanceof DelegatingNode)) {
                                                    int i11 = 0;
                                                    for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild$ui_release()) {
                                                        if ((delegate$ui_release4.getKindSet$ui_release() & r12) != 0) {
                                                            i11++;
                                                            if (i11 == 1) {
                                                                node4 = delegate$ui_release4;
                                                            } else {
                                                                if (mutableVector6 == null) {
                                                                    mutableVector6 = new MutableVector(new Modifier.Node[16], 0);
                                                                }
                                                                if (node4 != null) {
                                                                    if (mutableVector6 != null) {
                                                                        Boolean.valueOf(mutableVector6.add(node4));
                                                                    }
                                                                    node4 = null;
                                                                }
                                                                if (mutableVector6 != null) {
                                                                    Boolean.valueOf(mutableVector6.add(delegate$ui_release4));
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (i11 == 1) {
                                                    }
                                                    node4 = DelegatableNodeKt.pop(mutableVector6);
                                                }
                                                node4 = DelegatableNodeKt.pop(mutableVector6);
                                            }
                                        } else {
                                            node4 = node4.getChild$ui_release();
                                        }
                                    }
                                } else {
                                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector5, node4);
                                }
                            }
                            i2 = 1;
                            if (i8 != 0) {
                                if (i7 != 0) {
                                    focusState = FocusEventModifierNodeKt.getFocusState(focusEventModifierNode);
                                } else {
                                    if (focusTargetNode == null || (focusStateImpl = focusTargetNode.getFocusState()) == null) {
                                        focusStateImpl = FocusStateImpl.Inactive;
                                    }
                                    focusState = focusStateImpl;
                                }
                                focusEventModifierNode.onFocusEvent(focusState);
                            }
                        } else {
                            throw new IllegalStateException("visitChildren called on an unattached node".toString());
                        }
                    }
                    i4 = i2;
                    i3 = 1024;
                }
                this.this$0.focusEventNodes.clear();
                for (FocusTargetNode focusTargetNode4 : this.this$0.focusTargetNodes) {
                    if (focusTargetNode4.isAttached()) {
                        FocusStateImpl focusState2 = focusTargetNode4.getFocusState();
                        focusTargetNode4.invalidateFocus$ui_release();
                        if (focusState2 != focusTargetNode4.getFocusState() || linkedHashSet.contains(focusTargetNode4)) {
                            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode4);
                        }
                    }
                }
                this.this$0.focusTargetNodes.clear();
                linkedHashSet.clear();
                if (!this.this$0.focusPropertiesNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusProperties nodes".toString());
                } else if (!this.this$0.focusEventNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusEvent nodes".toString());
                } else if (!this.this$0.focusTargetNodes.isEmpty()) {
                    throw new IllegalStateException("Unprocessed FocusTarget nodes".toString());
                } else {
                    return;
                }
            }
        }
    }
}
