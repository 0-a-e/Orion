package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTargetNodeKt;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.layout.IntermediateLayoutModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.semantics.SemanticsModifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a \u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u001a \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0000\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a#\u0010\u001c\u001a\u00020\t*\u00020\u00012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\nH\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010 \u001a\u00020\u0001*\u00020\u00012\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\nH\fø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\f\u0010$\u001a\u00020\u000e*\u00020%H\u0002\u001a\f\u0010&\u001a\u00020\t*\u00020%H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0014\u0010\u0006\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u001c\u0010\b\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"Inserted", "", "getInserted$annotations", "()V", "Removed", "getRemoved$annotations", "Updated", "getUpdated$annotations", "includeSelfInTraversal", "", "Landroidx/compose/ui/node/NodeKind;", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "autoInvalidateInsertedNode", "", "node", "Landroidx/compose/ui/Modifier$Node;", "autoInvalidateNodeIncludingDelegates", "remainingSet", "phase", "autoInvalidateNodeSelf", "selfKindSet", "autoInvalidateRemovedNode", "autoInvalidateUpdatedNode", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "calculateNodeKindSetFromIncludingDelegates", "contains", "value", "contains-64DMado", "(II)Z", "or", "other", "or-64DMado", "(II)I", "scheduleInvalidationOfAssociatedFocusTargets", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "specifiesCanFocusProperty", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeKind.kt */
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;

    /* renamed from: contains-64DMado  reason: not valid java name */
    public static final boolean m5655contains64DMado(int i, int i2) {
        return (i & i2) != 0;
    }

    private static /* synthetic */ void getInserted$annotations() {
    }

    private static /* synthetic */ void getRemoved$annotations() {
    }

    private static /* synthetic */ void getUpdated$annotations() {
    }

    /* renamed from: or-64DMado  reason: not valid java name */
    public static final int m5657or64DMado(int i, int i2) {
        return i | i2;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        if (node.getKindSet$ui_release() != 0) {
            return node.getKindSet$ui_release();
        }
        int r0 = NodeKind.m5647constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(2);
        }
        if (node instanceof DrawModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(4);
        }
        if (node instanceof SemanticsModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(8);
        }
        if (node instanceof PointerInputModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(16);
        }
        if (node instanceof ModifierLocalModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(32);
        }
        if (node instanceof ParentDataModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(64);
        }
        if (node instanceof LayoutAwareModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(128);
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(256);
        }
        if (node instanceof IntermediateLayoutModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(512);
        }
        if (node instanceof FocusTargetNode) {
            r0 |= NodeKind.m5647constructorimpl(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(4096);
        }
        if (node instanceof KeyInputModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(8192);
        }
        if (node instanceof RotaryInputModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(16384);
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(32768);
        }
        if (node instanceof SoftKeyboardInterceptionModifierNode) {
            r0 |= NodeKind.m5647constructorimpl(131072);
        }
        return node instanceof TraversableNode ? r0 | NodeKind.m5647constructorimpl(262144) : r0;
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        if (node.isAttached()) {
            autoInvalidateNodeIncludingDelegates(node, -1, 2);
            return;
        }
        throw new IllegalStateException("autoInvalidateRemovedNode called on unattached node".toString());
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        if (node.isAttached()) {
            autoInvalidateNodeIncludingDelegates(node, -1, 1);
            return;
        }
        throw new IllegalStateException("autoInvalidateInsertedNode called on unattached node".toString());
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        if (node.isAttached()) {
            autoInvalidateNodeIncludingDelegates(node, -1, 0);
            return;
        }
        throw new IllegalStateException("autoInvalidateUpdatedNode called on unattached node".toString());
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i, int i2) {
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            autoInvalidateNodeSelf(node, delegatingNode.getSelfKindSet$ui_release() & i, i2);
            int i3 = (~delegatingNode.getSelfKindSet$ui_release()) & i;
            for (Modifier.Node delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                autoInvalidateNodeIncludingDelegates(delegate$ui_release, i3, i2);
            }
            return;
        }
        autoInvalidateNodeSelf(node, i & node.getKindSet$ui_release(), i2);
    }

    private static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if ((NodeKind.m5647constructorimpl(2) & i) != 0 && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    DelegatableNodeKt.m5468requireCoordinator64DMado(node, NodeKind.m5647constructorimpl(2)).onRelease();
                }
            }
            if ((NodeKind.m5647constructorimpl(256) & i) != 0 && (node instanceof GlobalPositionAwareModifierNode)) {
                DelegatableNodeKt.requireLayoutNode(node).invalidateMeasurements$ui_release();
            }
            if ((NodeKind.m5647constructorimpl(4) & i) != 0 && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if ((NodeKind.m5647constructorimpl(8) & i) != 0 && (node instanceof SemanticsModifierNode)) {
                SemanticsModifierNodeKt.invalidateSemantics((SemanticsModifierNode) node);
            }
            if ((NodeKind.m5647constructorimpl(64) & i) != 0 && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if ((NodeKind.m5647constructorimpl(1024) & i) != 0 && (node instanceof FocusTargetNode)) {
                if (i2 == 2) {
                    node.onReset();
                } else {
                    DelegatableNodeKt.requireOwner(node).getFocusOwner().scheduleInvalidation((FocusTargetNode) node);
                }
            }
            if ((NodeKind.m5647constructorimpl(2048) & i) != 0 && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                    if (i2 == 2) {
                        scheduleInvalidationOfAssociatedFocusTargets(focusPropertiesModifierNode);
                    } else {
                        FocusPropertiesModifierNodeKt.invalidateFocusProperties(focusPropertiesModifierNode);
                    }
                }
            }
            if ((i & NodeKind.m5647constructorimpl(4096)) != 0 && (node instanceof FocusEventModifierNode)) {
                FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
            }
        }
    }

    private static final void scheduleInvalidationOfAssociatedFocusTargets(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        DelegatableNode delegatableNode = focusPropertiesModifierNode;
        int r0 = NodeKind.m5647constructorimpl(1024);
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
                            break;
                        } else if ((node.getKindSet$ui_release() & r0) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    FocusTargetNodeKt.invalidateFocusTarget((FocusTargetNode) node);
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

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker.INSTANCE.reset();
        focusPropertiesModifierNode.applyFocusProperties(CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        if (!(node instanceof DelegatingNode)) {
            return calculateNodeKindSetFrom(node);
        }
        DelegatingNode delegatingNode = (DelegatingNode) node;
        int selfKindSet$ui_release = delegatingNode.getSelfKindSet$ui_release();
        for (Modifier.Node delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            selfKindSet$ui_release |= calculateNodeKindSetFromIncludingDelegates(delegate$ui_release);
        }
        return selfKindSet$ui_release;
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI  reason: not valid java name */
    public static final boolean m5656getIncludeSelfInTraversalH91voCI(int i) {
        return (i & NodeKind.m5647constructorimpl(128)) != 0;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int r0 = NodeKind.m5647constructorimpl(1);
        if (element instanceof LayoutModifier) {
            r0 |= NodeKind.m5647constructorimpl(2);
        }
        if (element instanceof DrawModifier) {
            r0 |= NodeKind.m5647constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            r0 |= NodeKind.m5647constructorimpl(8);
        }
        if (element instanceof PointerInputModifier) {
            r0 |= NodeKind.m5647constructorimpl(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            r0 |= NodeKind.m5647constructorimpl(32);
        }
        if (element instanceof FocusEventModifier) {
            r0 |= NodeKind.m5647constructorimpl(4096);
        }
        if (element instanceof FocusOrderModifier) {
            r0 |= NodeKind.m5647constructorimpl(2048);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            r0 |= NodeKind.m5647constructorimpl(256);
        }
        if (element instanceof ParentDataModifier) {
            r0 |= NodeKind.m5647constructorimpl(64);
        }
        return ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) ? r0 | NodeKind.m5647constructorimpl(128) : r0;
    }
}
