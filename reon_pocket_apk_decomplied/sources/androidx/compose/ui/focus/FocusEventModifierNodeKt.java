package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"getFocusState", "Landroidx/compose/ui/focus/FocusState;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "invalidateFocusEvent", "", "refreshFocusEventNodes", "Landroidx/compose/ui/focus/FocusTargetNode;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusEventModifierNode.kt */
public final class FocusEventModifierNodeKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusEventModifierNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.ui.focus.FocusStateImpl[] r0 = androidx.compose.ui.focus.FocusStateImpl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Active     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Captured     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Inactive     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusEventModifierNodeKt.WhenMappings.<clinit>():void");
        }
    }

    public static final void invalidateFocusEvent(FocusEventModifierNode focusEventModifierNode) {
        DelegatableNodeKt.requireOwner(focusEventModifierNode).getFocusOwner().scheduleInvalidation(focusEventModifierNode);
    }

    public static final FocusState getFocusState(FocusEventModifierNode focusEventModifierNode) {
        DelegatableNode delegatableNode = focusEventModifierNode;
        int r0 = NodeKind.m5647constructorimpl(1024);
        Modifier.Node node = delegatableNode.getNode();
        MutableVector mutableVector = null;
        while (node != null) {
            if (node instanceof FocusTargetNode) {
                FocusStateImpl focusState = ((FocusTargetNode) node).getFocusState();
                int i = WhenMappings.$EnumSwitchMapping$0[focusState.ordinal()];
                if (i == 1 || i == 2 || i == 3) {
                    return focusState;
                }
            } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                int i2 = 0;
                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                    if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                        i2++;
                        if (i2 == 1) {
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
                if (i2 == 1) {
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
                if ((node2.getAggregateChildKindSet$ui_release() & r0) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node2);
                } else {
                    while (true) {
                        if (node2 == null) {
                            continue;
                            break;
                        } else if ((node2.getKindSet$ui_release() & r0) != 0) {
                            MutableVector mutableVector3 = null;
                            while (node2 != null) {
                                if (node2 instanceof FocusTargetNode) {
                                    FocusStateImpl focusState2 = ((FocusTargetNode) node2).getFocusState();
                                    int i3 = WhenMappings.$EnumSwitchMapping$0[focusState2.ordinal()];
                                    if (i3 == 1 || i3 == 2 || i3 == 3) {
                                        return focusState2;
                                    }
                                } else if ((node2.getKindSet$ui_release() & r0) != 0 && (node2 instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild$ui_release()) {
                                        if ((delegate$ui_release2.getKindSet$ui_release() & r0) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                node2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.pop(mutableVector3);
                            }
                            continue;
                        } else {
                            node2 = node2.getChild$ui_release();
                        }
                    }
                }
            }
            return FocusStateImpl.Inactive;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b9, code lost:
        r4 = r13.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void refreshFocusEventNodes(androidx.compose.ui.focus.FocusTargetNode r13) {
        /*
            androidx.compose.ui.node.DelegatableNode r13 = (androidx.compose.ui.node.DelegatableNode) r13
            r0 = 4096(0x1000, float:5.74E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r0)
            r1 = 1024(0x400, float:1.435E-42)
            int r1 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r2 = r13.getNode()
            r3 = r0 | r1
            androidx.compose.ui.Modifier$Node r4 = r13.getNode()
            boolean r4 = r4.isAttached()
            if (r4 == 0) goto L_0x00c9
            androidx.compose.ui.Modifier$Node r4 = r13.getNode()
            androidx.compose.ui.node.LayoutNode r13 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r13)
        L_0x0026:
            if (r13 == 0) goto L_0x00c8
            androidx.compose.ui.node.NodeChain r5 = r13.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r5 = r5.getHead$ui_release()
            int r5 = r5.getAggregateChildKindSet$ui_release()
            r5 = r5 & r3
            r6 = 0
            if (r5 == 0) goto L_0x00b3
        L_0x0038:
            if (r4 == 0) goto L_0x00b3
            int r5 = r4.getKindSet$ui_release()
            r5 = r5 & r3
            if (r5 == 0) goto L_0x00ae
            if (r4 == r2) goto L_0x004c
            int r5 = r4.getKindSet$ui_release()
            r5 = r5 & r1
            if (r5 == 0) goto L_0x004c
            goto L_0x00c8
        L_0x004c:
            int r5 = r4.getKindSet$ui_release()
            r5 = r5 & r0
            if (r5 == 0) goto L_0x00ae
            r5 = r4
            r7 = r6
        L_0x0055:
            if (r5 == 0) goto L_0x00ae
            boolean r8 = r5 instanceof androidx.compose.ui.focus.FocusEventModifierNode
            if (r8 == 0) goto L_0x0065
            androidx.compose.ui.focus.FocusEventModifierNode r5 = (androidx.compose.ui.focus.FocusEventModifierNode) r5
            androidx.compose.ui.focus.FocusState r8 = getFocusState(r5)
            r5.onFocusEvent(r8)
            goto L_0x00a9
        L_0x0065:
            int r8 = r5.getKindSet$ui_release()
            r8 = r8 & r0
            if (r8 == 0) goto L_0x00a9
            boolean r8 = r5 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x00a9
            r8 = r5
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = 0
            r10 = r9
        L_0x0079:
            r11 = 1
            if (r8 == 0) goto L_0x00a6
            int r12 = r8.getKindSet$ui_release()
            r12 = r12 & r0
            if (r12 == 0) goto L_0x00a1
            int r10 = r10 + 1
            if (r10 != r11) goto L_0x0089
            r5 = r8
            goto L_0x00a1
        L_0x0089:
            if (r7 != 0) goto L_0x0094
            androidx.compose.runtime.collection.MutableVector r7 = new androidx.compose.runtime.collection.MutableVector
            r11 = 16
            androidx.compose.ui.Modifier$Node[] r11 = new androidx.compose.ui.Modifier.Node[r11]
            r7.<init>(r11, r9)
        L_0x0094:
            if (r5 == 0) goto L_0x009c
            if (r7 == 0) goto L_0x009b
            r7.add(r5)
        L_0x009b:
            r5 = r6
        L_0x009c:
            if (r7 == 0) goto L_0x00a1
            r7.add(r8)
        L_0x00a1:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x0079
        L_0x00a6:
            if (r10 != r11) goto L_0x00a9
            goto L_0x0055
        L_0x00a9:
            androidx.compose.ui.Modifier$Node r5 = androidx.compose.ui.node.DelegatableNodeKt.pop(r7)
            goto L_0x0055
        L_0x00ae:
            androidx.compose.ui.Modifier$Node r4 = r4.getParent$ui_release()
            goto L_0x0038
        L_0x00b3:
            androidx.compose.ui.node.LayoutNode r13 = r13.getParent$ui_release()
            if (r13 == 0) goto L_0x00c5
            androidx.compose.ui.node.NodeChain r4 = r13.getNodes$ui_release()
            if (r4 == 0) goto L_0x00c5
            androidx.compose.ui.Modifier$Node r4 = r4.getTail$ui_release()
            goto L_0x0026
        L_0x00c5:
            r4 = r6
            goto L_0x0026
        L_0x00c8:
            return
        L_0x00c9:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusEventModifierNodeKt.refreshFocusEventNodes(androidx.compose.ui.focus.FocusTargetNode):void");
    }
}
