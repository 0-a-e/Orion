package androidx.compose.ui.focus;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a \u0010\u0003\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\u001e\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u001e\u0010\u0011\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000e\u001a\u001e\u0010\u0013\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000e\u001a\f\u0010\u0015\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0016\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0002*\u00020\u0002H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"captureFocus", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "clearChildFocus", "forced", "refreshFocusEvents", "clearFocus", "freeFocus", "grantFocus", "performCustomClearFocus", "Landroidx/compose/ui/focus/CustomDestinationResult;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "performCustomClearFocus-Mxy_nc0", "(Landroidx/compose/ui/focus/FocusTargetNode;I)Landroidx/compose/ui/focus/CustomDestinationResult;", "performCustomEnter", "performCustomEnter-Mxy_nc0", "performCustomExit", "performCustomExit-Mxy_nc0", "performCustomRequestFocus", "performCustomRequestFocus-Mxy_nc0", "performRequestFocus", "requestFocus", "requestFocusForChild", "childNode", "requestFocusForOwner", "requireActiveChild", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTransactions.kt */
public final class FocusTransactionsKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTransactions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004c */
        static {
            /*
                androidx.compose.ui.focus.CustomDestinationResult[] r0 = androidx.compose.ui.focus.CustomDestinationResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.compose.ui.focus.CustomDestinationResult r2 = androidx.compose.ui.focus.CustomDestinationResult.None     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                androidx.compose.ui.focus.CustomDestinationResult r3 = androidx.compose.ui.focus.CustomDestinationResult.Redirected     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                androidx.compose.ui.focus.CustomDestinationResult r4 = androidx.compose.ui.focus.CustomDestinationResult.Cancelled     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                androidx.compose.ui.focus.CustomDestinationResult r5 = androidx.compose.ui.focus.CustomDestinationResult.RedirectCancelled     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                androidx.compose.ui.focus.FocusStateImpl[] r0 = androidx.compose.ui.focus.FocusStateImpl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.focus.FocusStateImpl r5 = androidx.compose.ui.focus.FocusStateImpl.Active     // Catch:{ NoSuchFieldError -> 0x003c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Captured     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Inactive     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.WhenMappings.<clinit>():void");
        }
    }

    public static final boolean requestFocus(FocusTargetNode focusTargetNode) {
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (requireTransactionManager.ongoingTransaction) {
                requireTransactionManager.cancelTransaction();
            }
            requireTransactionManager.beginTransaction();
            int i = WhenMappings.$EnumSwitchMapping$0[m3513performCustomRequestFocusMxy_nc0(focusTargetNode, FocusDirection.Companion.m3486getEnterdhqQ8s()).ordinal()];
            boolean z = true;
            if (i == 1) {
                z = performRequestFocus(focusTargetNode);
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                z = false;
            }
            return z;
        } finally {
            requireTransactionManager.commitTransaction();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b0, code lost:
        r5 = r0.getNodes$ui_release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e1, code lost:
        if (grantFocus(r11) != false) goto L_0x0105;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0101, code lost:
        if (grantFocus(r11) != false) goto L_0x0105;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean performRequestFocus(androidx.compose.ui.focus.FocusTargetNode r11) {
        /*
            androidx.compose.ui.focus.FocusStateImpl r0 = r11.getFocusState()
            int[] r1 = androidx.compose.ui.focus.FocusTransactionsKt.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x0105
            r2 = 2
            if (r0 == r2) goto L_0x0105
            r2 = 3
            r3 = 0
            r4 = 0
            if (r0 == r2) goto L_0x00f7
            r2 = 4
            if (r0 != r2) goto L_0x00f1
            r0 = r11
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r2 = 1024(0x400, float:1.435E-42)
            int r2 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r5 = r0.getNode()
            boolean r5 = r5.isAttached()
            if (r5 == 0) goto L_0x00e4
            androidx.compose.ui.Modifier$Node r5 = r0.getNode()
            androidx.compose.ui.Modifier$Node r5 = r5.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x0039:
            if (r0 == 0) goto L_0x00bf
            androidx.compose.ui.node.NodeChain r6 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r6 = r6.getHead$ui_release()
            int r6 = r6.getAggregateChildKindSet$ui_release()
            r6 = r6 & r2
            if (r6 == 0) goto L_0x00aa
        L_0x004a:
            if (r5 == 0) goto L_0x00aa
            int r6 = r5.getKindSet$ui_release()
            r6 = r6 & r2
            if (r6 == 0) goto L_0x00a5
            r7 = r3
            r6 = r5
        L_0x0055:
            if (r6 == 0) goto L_0x00a5
            boolean r8 = r6 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r8 == 0) goto L_0x005e
            r3 = r6
            goto L_0x00bf
        L_0x005e:
            int r8 = r6.getKindSet$ui_release()
            r8 = r8 & r2
            if (r8 == 0) goto L_0x00a0
            boolean r8 = r6 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x00a0
            r8 = r6
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r4
        L_0x0071:
            if (r8 == 0) goto L_0x009d
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r2
            if (r10 == 0) goto L_0x0098
            int r9 = r9 + 1
            if (r9 != r1) goto L_0x0080
            r6 = r8
            goto L_0x0098
        L_0x0080:
            if (r7 != 0) goto L_0x008b
            androidx.compose.runtime.collection.MutableVector r7 = new androidx.compose.runtime.collection.MutableVector
            r10 = 16
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r10]
            r7.<init>(r10, r4)
        L_0x008b:
            if (r6 == 0) goto L_0x0093
            if (r7 == 0) goto L_0x0092
            r7.add(r6)
        L_0x0092:
            r6 = r3
        L_0x0093:
            if (r7 == 0) goto L_0x0098
            r7.add(r8)
        L_0x0098:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x0071
        L_0x009d:
            if (r9 != r1) goto L_0x00a0
            goto L_0x0055
        L_0x00a0:
            androidx.compose.ui.Modifier$Node r6 = androidx.compose.ui.node.DelegatableNodeKt.pop(r7)
            goto L_0x0055
        L_0x00a5:
            androidx.compose.ui.Modifier$Node r5 = r5.getParent$ui_release()
            goto L_0x004a
        L_0x00aa:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00bc
            androidx.compose.ui.node.NodeChain r5 = r0.getNodes$ui_release()
            if (r5 == 0) goto L_0x00bc
            androidx.compose.ui.Modifier$Node r5 = r5.getTail$ui_release()
            goto L_0x0039
        L_0x00bc:
            r5 = r3
            goto L_0x0039
        L_0x00bf:
            androidx.compose.ui.focus.FocusTargetNode r3 = (androidx.compose.ui.focus.FocusTargetNode) r3
            if (r3 == 0) goto L_0x00d7
            androidx.compose.ui.focus.FocusStateImpl r0 = r3.getFocusState()
            boolean r1 = requestFocusForChild(r3, r11)
            if (r1 == 0) goto L_0x0105
            androidx.compose.ui.focus.FocusStateImpl r2 = r3.getFocusState()
            if (r0 == r2) goto L_0x0105
            androidx.compose.ui.focus.FocusEventModifierNodeKt.refreshFocusEventNodes(r3)
            goto L_0x0105
        L_0x00d7:
            boolean r0 = requestFocusForOwner(r11)
            if (r0 == 0) goto L_0x0104
            boolean r0 = grantFocus(r11)
            if (r0 == 0) goto L_0x0104
            goto L_0x0105
        L_0x00e4:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x00f1:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x00f7:
            boolean r0 = clearChildFocus$default(r11, r4, r4, r2, r3)
            if (r0 == 0) goto L_0x0104
            boolean r0 = grantFocus(r11)
            if (r0 == 0) goto L_0x0104
            goto L_0x0105
        L_0x0104:
            r1 = r4
        L_0x0105:
            if (r1 == 0) goto L_0x010a
            androidx.compose.ui.focus.FocusEventModifierNodeKt.refreshFocusEventNodes(r11)
        L_0x010a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.performRequestFocus(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    public static final boolean captureFocus(FocusTargetNode focusTargetNode) {
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (requireTransactionManager.ongoingTransaction) {
                requireTransactionManager.cancelTransaction();
            }
            requireTransactionManager.beginTransaction();
            int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
            boolean z = true;
            if (i == 1) {
                focusTargetNode.setFocusState(FocusStateImpl.Captured);
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            } else if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                z = false;
            }
            return z;
        } finally {
            requireTransactionManager.commitTransaction();
        }
    }

    public static final boolean freeFocus(FocusTargetNode focusTargetNode) {
        FocusTransactionManager requireTransactionManager = FocusTargetNodeKt.requireTransactionManager(focusTargetNode);
        try {
            if (requireTransactionManager.ongoingTransaction) {
                requireTransactionManager.cancelTransaction();
            }
            requireTransactionManager.beginTransaction();
            int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    z = false;
                } else {
                    focusTargetNode.setFocusState(FocusStateImpl.Active);
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                }
            }
            return z;
        } finally {
            requireTransactionManager.commitTransaction();
        }
    }

    public static /* synthetic */ boolean clearFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return clearFocus(focusTargetNode, z, z2);
    }

    public static final boolean clearFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (z2) {
                FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            }
        } else if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
            } else if (!clearChildFocus(focusTargetNode, z, z2)) {
                return false;
            } else {
                focusTargetNode.setFocusState(FocusStateImpl.Inactive);
                if (z2) {
                    FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
                }
            }
        } else if (!z) {
            return z;
        } else {
            focusTargetNode.setFocusState(FocusStateImpl.Inactive);
            if (!z2) {
                return z;
            }
            FocusEventModifierNodeKt.refreshFocusEventNodes(focusTargetNode);
            return z;
        }
        return true;
    }

    private static final boolean grantFocus(FocusTargetNode focusTargetNode) {
        ObserverModifierNodeKt.observeReads(focusTargetNode, new FocusTransactionsKt$grantFocus$1(focusTargetNode));
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i != 3 && i != 4) {
            return true;
        }
        focusTargetNode.setFocusState(FocusStateImpl.Active);
        return true;
    }

    static /* synthetic */ boolean clearChildFocus$default(FocusTargetNode focusTargetNode, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return clearChildFocus(focusTargetNode, z, z2);
    }

    private static final boolean clearChildFocus(FocusTargetNode focusTargetNode, boolean z, boolean z2) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return clearFocus(activeChild, z, z2);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x009b, code lost:
        r3 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean requestFocusForChild(androidx.compose.ui.focus.FocusTargetNode r14, androidx.compose.ui.focus.FocusTargetNode r15) {
        /*
            r0 = r15
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r1 = 1024(0x400, float:1.435E-42)
            int r2 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r3 = r0.getNode()
            boolean r3 = r3.isAttached()
            java.lang.String r4 = "visitAncestors called on an unattached node"
            if (r3 == 0) goto L_0x01dc
            androidx.compose.ui.Modifier$Node r3 = r0.getNode()
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x0022:
            r5 = 16
            r6 = 1
            r7 = 0
            r8 = 0
            if (r0 == 0) goto L_0x00aa
            androidx.compose.ui.node.NodeChain r9 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r9 = r9.getHead$ui_release()
            int r9 = r9.getAggregateChildKindSet$ui_release()
            r9 = r9 & r2
            if (r9 == 0) goto L_0x0095
        L_0x0038:
            if (r3 == 0) goto L_0x0095
            int r9 = r3.getKindSet$ui_release()
            r9 = r9 & r2
            if (r9 == 0) goto L_0x0090
            r9 = r3
            r10 = r8
        L_0x0043:
            if (r9 == 0) goto L_0x0090
            boolean r11 = r9 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r11 == 0) goto L_0x004b
            goto L_0x00ab
        L_0x004b:
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x008b
            boolean r11 = r9 instanceof androidx.compose.ui.node.DelegatingNode
            if (r11 == 0) goto L_0x008b
            r11 = r9
            androidx.compose.ui.node.DelegatingNode r11 = (androidx.compose.ui.node.DelegatingNode) r11
            androidx.compose.ui.Modifier$Node r11 = r11.getDelegate$ui_release()
            r12 = r7
        L_0x005e:
            if (r11 == 0) goto L_0x0088
            int r13 = r11.getKindSet$ui_release()
            r13 = r13 & r2
            if (r13 == 0) goto L_0x0083
            int r12 = r12 + 1
            if (r12 != r6) goto L_0x006d
            r9 = r11
            goto L_0x0083
        L_0x006d:
            if (r10 != 0) goto L_0x0076
            androidx.compose.runtime.collection.MutableVector r10 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r13 = new androidx.compose.ui.Modifier.Node[r5]
            r10.<init>(r13, r7)
        L_0x0076:
            if (r9 == 0) goto L_0x007e
            if (r10 == 0) goto L_0x007d
            r10.add(r9)
        L_0x007d:
            r9 = r8
        L_0x007e:
            if (r10 == 0) goto L_0x0083
            r10.add(r11)
        L_0x0083:
            androidx.compose.ui.Modifier$Node r11 = r11.getChild$ui_release()
            goto L_0x005e
        L_0x0088:
            if (r12 != r6) goto L_0x008b
            goto L_0x0043
        L_0x008b:
            androidx.compose.ui.Modifier$Node r9 = androidx.compose.ui.node.DelegatableNodeKt.pop(r10)
            goto L_0x0043
        L_0x0090:
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            goto L_0x0038
        L_0x0095:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00a7
            androidx.compose.ui.node.NodeChain r3 = r0.getNodes$ui_release()
            if (r3 == 0) goto L_0x00a7
            androidx.compose.ui.Modifier$Node r3 = r3.getTail$ui_release()
            goto L_0x0022
        L_0x00a7:
            r3 = r8
            goto L_0x0022
        L_0x00aa:
            r9 = r8
        L_0x00ab:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r14)
            if (r0 == 0) goto L_0x01d0
            androidx.compose.ui.focus.FocusStateImpl r0 = r14.getFocusState()
            int[] r2 = androidx.compose.ui.focus.FocusTransactionsKt.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r2[r0]
            if (r0 == r6) goto L_0x01c4
            r2 = 2
            if (r0 == r2) goto L_0x01c2
            r2 = 3
            if (r0 == r2) goto L_0x01b2
            r2 = 4
            if (r0 != r2) goto L_0x01ac
            r0 = r14
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            int r1 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x01a2
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x00e5:
            if (r0 == 0) goto L_0x0168
            androidx.compose.ui.node.NodeChain r3 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r1
            if (r3 == 0) goto L_0x0154
        L_0x00f6:
            if (r2 == 0) goto L_0x0154
            int r3 = r2.getKindSet$ui_release()
            r3 = r3 & r1
            if (r3 == 0) goto L_0x014f
            r3 = r2
            r4 = r8
        L_0x0101:
            if (r3 == 0) goto L_0x014f
            boolean r9 = r3 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r9 == 0) goto L_0x010a
            r8 = r3
            goto L_0x0168
        L_0x010a:
            int r9 = r3.getKindSet$ui_release()
            r9 = r9 & r1
            if (r9 == 0) goto L_0x014a
            boolean r9 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r9 == 0) goto L_0x014a
            r9 = r3
            androidx.compose.ui.node.DelegatingNode r9 = (androidx.compose.ui.node.DelegatingNode) r9
            androidx.compose.ui.Modifier$Node r9 = r9.getDelegate$ui_release()
            r10 = r7
        L_0x011d:
            if (r9 == 0) goto L_0x0147
            int r11 = r9.getKindSet$ui_release()
            r11 = r11 & r1
            if (r11 == 0) goto L_0x0142
            int r10 = r10 + 1
            if (r10 != r6) goto L_0x012c
            r3 = r9
            goto L_0x0142
        L_0x012c:
            if (r4 != 0) goto L_0x0135
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Node[] r11 = new androidx.compose.ui.Modifier.Node[r5]
            r4.<init>(r11, r7)
        L_0x0135:
            if (r3 == 0) goto L_0x013d
            if (r4 == 0) goto L_0x013c
            r4.add(r3)
        L_0x013c:
            r3 = r8
        L_0x013d:
            if (r4 == 0) goto L_0x0142
            r4.add(r9)
        L_0x0142:
            androidx.compose.ui.Modifier$Node r9 = r9.getChild$ui_release()
            goto L_0x011d
        L_0x0147:
            if (r10 != r6) goto L_0x014a
            goto L_0x0101
        L_0x014a:
            androidx.compose.ui.Modifier$Node r3 = androidx.compose.ui.node.DelegatableNodeKt.pop(r4)
            goto L_0x0101
        L_0x014f:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x00f6
        L_0x0154:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x0165
            androidx.compose.ui.node.NodeChain r2 = r0.getNodes$ui_release()
            if (r2 == 0) goto L_0x0165
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x00e5
        L_0x0165:
            r2 = r8
            goto L_0x00e5
        L_0x0168:
            androidx.compose.ui.focus.FocusTargetNode r8 = (androidx.compose.ui.focus.FocusTargetNode) r8
            if (r8 != 0) goto L_0x017c
            boolean r0 = requestFocusForOwner(r14)
            if (r0 == 0) goto L_0x017c
            androidx.compose.ui.focus.FocusStateImpl r0 = androidx.compose.ui.focus.FocusStateImpl.Active
            r14.setFocusState(r0)
            boolean r6 = requestFocusForChild(r14, r15)
            goto L_0x01cf
        L_0x017c:
            if (r8 == 0) goto L_0x01c2
            boolean r0 = requestFocusForChild(r8, r14)
            if (r0 == 0) goto L_0x01c2
            boolean r6 = requestFocusForChild(r14, r15)
            androidx.compose.ui.focus.FocusStateImpl r14 = r14.getFocusState()
            androidx.compose.ui.focus.FocusStateImpl r15 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent
            if (r14 != r15) goto L_0x0196
            if (r6 == 0) goto L_0x01cf
            androidx.compose.ui.focus.FocusEventModifierNodeKt.refreshFocusEventNodes(r8)
            goto L_0x01cf
        L_0x0196:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "Deactivated node is focused"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x01a2:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = r4.toString()
            r14.<init>(r15)
            throw r14
        L_0x01ac:
            kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
            r14.<init>()
            throw r14
        L_0x01b2:
            requireActiveChild(r14)
            boolean r14 = clearChildFocus$default(r14, r7, r7, r2, r8)
            if (r14 == 0) goto L_0x01c2
            boolean r14 = grantFocus(r15)
            if (r14 == 0) goto L_0x01c2
            goto L_0x01cf
        L_0x01c2:
            r6 = r7
            goto L_0x01cf
        L_0x01c4:
            boolean r6 = grantFocus(r15)
            if (r6 == 0) goto L_0x01cf
            androidx.compose.ui.focus.FocusStateImpl r15 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent
            r14.setFocusState(r15)
        L_0x01cf:
            return r6
        L_0x01d0:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "Non child node cannot request focus."
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x01dc:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = r4.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.requestFocusForChild(androidx.compose.ui.focus.FocusTargetNode, androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    private static final boolean requestFocusForOwner(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        Owner owner$ui_release;
        NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator$ui_release();
        if (coordinator$ui_release != null && (layoutNode = coordinator$ui_release.getLayoutNode()) != null && (owner$ui_release = layoutNode.getOwner$ui_release()) != null) {
            return owner$ui_release.requestFocus();
        }
        throw new IllegalStateException("Owner not initialized.".toString());
    }

    private static final FocusTargetNode requireActiveChild(FocusTargetNode focusTargetNode) {
        FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
        if (activeChild != null) {
            return activeChild;
        }
        throw new IllegalArgumentException("ActiveParent with no focused child".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ae, code lost:
        r5 = r13.getNodes$ui_release();
     */
    /* renamed from: performCustomRequestFocus-Mxy_nc0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.focus.CustomDestinationResult m3513performCustomRequestFocusMxy_nc0(androidx.compose.ui.focus.FocusTargetNode r13, int r14) {
        /*
            androidx.compose.ui.focus.FocusStateImpl r0 = r13.getFocusState()
            int[] r1 = androidx.compose.ui.focus.FocusTransactionsKt.WhenMappings.$EnumSwitchMapping$1
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x0119
            r2 = 2
            if (r0 == r2) goto L_0x0119
            r3 = 3
            if (r0 == r3) goto L_0x0110
            r4 = 4
            if (r0 != r4) goto L_0x010a
            androidx.compose.ui.node.DelegatableNode r13 = (androidx.compose.ui.node.DelegatableNode) r13
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r5 = r13.getNode()
            boolean r5 = r5.isAttached()
            if (r5 == 0) goto L_0x00fd
            androidx.compose.ui.Modifier$Node r5 = r13.getNode()
            androidx.compose.ui.Modifier$Node r5 = r5.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r13 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r13)
        L_0x0036:
            r6 = 0
            if (r13 == 0) goto L_0x00bd
            androidx.compose.ui.node.NodeChain r7 = r13.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r7 = r7.getHead$ui_release()
            int r7 = r7.getAggregateChildKindSet$ui_release()
            r7 = r7 & r0
            if (r7 == 0) goto L_0x00a8
        L_0x0048:
            if (r5 == 0) goto L_0x00a8
            int r7 = r5.getKindSet$ui_release()
            r7 = r7 & r0
            if (r7 == 0) goto L_0x00a3
            r7 = r5
            r8 = r6
        L_0x0053:
            if (r7 == 0) goto L_0x00a3
            boolean r9 = r7 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r9 == 0) goto L_0x005b
            goto L_0x00be
        L_0x005b:
            int r9 = r7.getKindSet$ui_release()
            r9 = r9 & r0
            if (r9 == 0) goto L_0x009e
            boolean r9 = r7 instanceof androidx.compose.ui.node.DelegatingNode
            if (r9 == 0) goto L_0x009e
            r9 = r7
            androidx.compose.ui.node.DelegatingNode r9 = (androidx.compose.ui.node.DelegatingNode) r9
            androidx.compose.ui.Modifier$Node r9 = r9.getDelegate$ui_release()
            r10 = 0
            r11 = r10
        L_0x006f:
            if (r9 == 0) goto L_0x009b
            int r12 = r9.getKindSet$ui_release()
            r12 = r12 & r0
            if (r12 == 0) goto L_0x0096
            int r11 = r11 + 1
            if (r11 != r1) goto L_0x007e
            r7 = r9
            goto L_0x0096
        L_0x007e:
            if (r8 != 0) goto L_0x0089
            androidx.compose.runtime.collection.MutableVector r8 = new androidx.compose.runtime.collection.MutableVector
            r12 = 16
            androidx.compose.ui.Modifier$Node[] r12 = new androidx.compose.ui.Modifier.Node[r12]
            r8.<init>(r12, r10)
        L_0x0089:
            if (r7 == 0) goto L_0x0091
            if (r8 == 0) goto L_0x0090
            r8.add(r7)
        L_0x0090:
            r7 = r6
        L_0x0091:
            if (r8 == 0) goto L_0x0096
            r8.add(r9)
        L_0x0096:
            androidx.compose.ui.Modifier$Node r9 = r9.getChild$ui_release()
            goto L_0x006f
        L_0x009b:
            if (r11 != r1) goto L_0x009e
            goto L_0x0053
        L_0x009e:
            androidx.compose.ui.Modifier$Node r7 = androidx.compose.ui.node.DelegatableNodeKt.pop(r8)
            goto L_0x0053
        L_0x00a3:
            androidx.compose.ui.Modifier$Node r5 = r5.getParent$ui_release()
            goto L_0x0048
        L_0x00a8:
            androidx.compose.ui.node.LayoutNode r13 = r13.getParent$ui_release()
            if (r13 == 0) goto L_0x00ba
            androidx.compose.ui.node.NodeChain r5 = r13.getNodes$ui_release()
            if (r5 == 0) goto L_0x00ba
            androidx.compose.ui.Modifier$Node r5 = r5.getTail$ui_release()
            goto L_0x0036
        L_0x00ba:
            r5 = r6
            goto L_0x0036
        L_0x00bd:
            r7 = r6
        L_0x00be:
            androidx.compose.ui.focus.FocusTargetNode r7 = (androidx.compose.ui.focus.FocusTargetNode) r7
            if (r7 != 0) goto L_0x00c5
            androidx.compose.ui.focus.CustomDestinationResult r13 = androidx.compose.ui.focus.CustomDestinationResult.None
            return r13
        L_0x00c5:
            androidx.compose.ui.focus.FocusStateImpl r13 = r7.getFocusState()
            int[] r0 = androidx.compose.ui.focus.FocusTransactionsKt.WhenMappings.$EnumSwitchMapping$1
            int r13 = r13.ordinal()
            r13 = r0[r13]
            if (r13 == r1) goto L_0x00f8
            if (r13 == r2) goto L_0x00f5
            if (r13 == r3) goto L_0x00f0
            if (r13 != r4) goto L_0x00ea
            androidx.compose.ui.focus.CustomDestinationResult r13 = m3513performCustomRequestFocusMxy_nc0(r7, r14)
            androidx.compose.ui.focus.CustomDestinationResult r0 = androidx.compose.ui.focus.CustomDestinationResult.None
            if (r13 != r0) goto L_0x00e2
            goto L_0x00e3
        L_0x00e2:
            r6 = r13
        L_0x00e3:
            if (r6 != 0) goto L_0x00fc
            androidx.compose.ui.focus.CustomDestinationResult r6 = m3511performCustomEnterMxy_nc0(r7, r14)
            goto L_0x00fc
        L_0x00ea:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        L_0x00f0:
            androidx.compose.ui.focus.CustomDestinationResult r6 = m3513performCustomRequestFocusMxy_nc0(r7, r14)
            goto L_0x00fc
        L_0x00f5:
            androidx.compose.ui.focus.CustomDestinationResult r6 = androidx.compose.ui.focus.CustomDestinationResult.Cancelled
            goto L_0x00fc
        L_0x00f8:
            androidx.compose.ui.focus.CustomDestinationResult r6 = m3511performCustomEnterMxy_nc0(r7, r14)
        L_0x00fc:
            return r6
        L_0x00fd:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "visitAncestors called on an unattached node"
            java.lang.String r14 = r14.toString()
            r13.<init>(r14)
            throw r13
        L_0x010a:
            kotlin.NoWhenBranchMatchedException r13 = new kotlin.NoWhenBranchMatchedException
            r13.<init>()
            throw r13
        L_0x0110:
            androidx.compose.ui.focus.FocusTargetNode r13 = requireActiveChild(r13)
            androidx.compose.ui.focus.CustomDestinationResult r13 = m3510performCustomClearFocusMxy_nc0(r13, r14)
            return r13
        L_0x0119:
            androidx.compose.ui.focus.CustomDestinationResult r13 = androidx.compose.ui.focus.CustomDestinationResult.None
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionsKt.m3513performCustomRequestFocusMxy_nc0(androidx.compose.ui.focus.FocusTargetNode, int):androidx.compose.ui.focus.CustomDestinationResult");
    }

    /* renamed from: performCustomClearFocus-Mxy_nc0  reason: not valid java name */
    public static final CustomDestinationResult m3510performCustomClearFocusMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        int i2 = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return CustomDestinationResult.Cancelled;
            }
            if (i2 == 3) {
                CustomDestinationResult r0 = m3510performCustomClearFocusMxy_nc0(requireActiveChild(focusTargetNode), i);
                if (r0 == CustomDestinationResult.None) {
                    r0 = null;
                }
                if (r0 == null) {
                    return m3512performCustomExitMxy_nc0(focusTargetNode, i);
                }
                return r0;
            } else if (i2 != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomEnter-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m3511performCustomEnterMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomEnter) {
            focusTargetNode.isProcessingCustomEnter = true;
            try {
                FocusRequester invoke = focusTargetNode.fetchFocusProperties$ui_release().getEnter().invoke(FocusDirection.m3476boximpl(i));
                if (invoke == FocusRequester.Companion.getDefault()) {
                    focusTargetNode.isProcessingCustomEnter = false;
                } else if (invoke == FocusRequester.Companion.getCancel()) {
                    return CustomDestinationResult.Cancelled;
                } else {
                    CustomDestinationResult customDestinationResult = invoke.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                    focusTargetNode.isProcessingCustomEnter = false;
                    return customDestinationResult;
                }
            } finally {
                focusTargetNode.isProcessingCustomEnter = false;
            }
        }
        return CustomDestinationResult.None;
    }

    /* renamed from: performCustomExit-Mxy_nc0  reason: not valid java name */
    private static final CustomDestinationResult m3512performCustomExitMxy_nc0(FocusTargetNode focusTargetNode, int i) {
        if (!focusTargetNode.isProcessingCustomExit) {
            focusTargetNode.isProcessingCustomExit = true;
            try {
                FocusRequester invoke = focusTargetNode.fetchFocusProperties$ui_release().getExit().invoke(FocusDirection.m3476boximpl(i));
                if (invoke == FocusRequester.Companion.getDefault()) {
                    focusTargetNode.isProcessingCustomExit = false;
                } else if (invoke == FocusRequester.Companion.getCancel()) {
                    return CustomDestinationResult.Cancelled;
                } else {
                    CustomDestinationResult customDestinationResult = invoke.focus$ui_release() ? CustomDestinationResult.Redirected : CustomDestinationResult.RedirectCancelled;
                    focusTargetNode.isProcessingCustomExit = false;
                    return customDestinationResult;
                }
            } finally {
                focusTargetNode.isProcessingCustomExit = false;
            }
        }
        return CustomDestinationResult.None;
    }
}
