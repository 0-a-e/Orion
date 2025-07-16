package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0016\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"androidx/compose/ui/node/NodeCoordinator$Companion$PointerInputSource$1", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "Landroidx/compose/ui/Modifier$Node;", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeCoordinator.kt */
public final class NodeCoordinator$Companion$PointerInputSource$1 implements NodeCoordinator.HitTestSource {
    public boolean shouldHitTestChildren(LayoutNode layoutNode) {
        return true;
    }

    NodeCoordinator$Companion$PointerInputSource$1() {
    }

    /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
    public void m5638childHitTestYqVAtuI(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2) {
        layoutNode.m5507hitTestM_7yMNQ$ui_release(j, hitTestResult, z, z2);
    }

    /* renamed from: entityType-OLwlOKw  reason: not valid java name */
    public int m5639entityTypeOLwlOKw() {
        return NodeKind.m5647constructorimpl(16);
    }

    public boolean interceptOutOfBoundsChildEvents(Modifier.Node node) {
        int r1 = NodeKind.m5647constructorimpl(16);
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof PointerInputModifierNode) {
                if (((PointerInputModifierNode) node).interceptOutOfBoundsChildEvents()) {
                    return true;
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
        return false;
    }
}
