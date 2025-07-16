package androidx.compose.ui.focus;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\u0010\u0005\u001a\u0015\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0006¢\u0006\u0002\b\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"searchBeyondBounds", "T", "Landroidx/compose/ui/focus/FocusTargetNode;", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "searchBeyondBounds--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: BeyondBoundsLayout.kt */
public final class BeyondBoundsLayoutKt {
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0098, code lost:
        r2 = r0.getNodes$ui_release();
     */
    /* renamed from: searchBeyondBounds--OM-vw8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T m3475searchBeyondBoundsOMvw8(androidx.compose.ui.focus.FocusTargetNode r11, int r12, kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope, ? extends T> r13) {
        /*
            r0 = r11
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r1 = 1024(0x400, float:1.435E-42)
            int r1 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r1)
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            boolean r2 = r2.isAttached()
            if (r2 == 0) goto L_0x0144
            androidx.compose.ui.Modifier$Node r2 = r0.getNode()
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x001f:
            r3 = 0
            if (r0 == 0) goto L_0x00a7
            androidx.compose.ui.node.NodeChain r4 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r4 = r4.getHead$ui_release()
            int r4 = r4.getAggregateChildKindSet$ui_release()
            r4 = r4 & r1
            if (r4 == 0) goto L_0x0092
        L_0x0031:
            if (r2 == 0) goto L_0x0092
            int r4 = r2.getKindSet$ui_release()
            r4 = r4 & r1
            if (r4 == 0) goto L_0x008d
            r4 = r2
            r5 = r3
        L_0x003c:
            if (r4 == 0) goto L_0x008d
            boolean r6 = r4 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r6 == 0) goto L_0x0044
            goto L_0x00a8
        L_0x0044:
            int r6 = r4.getKindSet$ui_release()
            r6 = r6 & r1
            if (r6 == 0) goto L_0x0088
            boolean r6 = r4 instanceof androidx.compose.ui.node.DelegatingNode
            if (r6 == 0) goto L_0x0088
            r6 = r4
            androidx.compose.ui.node.DelegatingNode r6 = (androidx.compose.ui.node.DelegatingNode) r6
            androidx.compose.ui.Modifier$Node r6 = r6.getDelegate$ui_release()
            r7 = 0
            r8 = r7
        L_0x0058:
            r9 = 1
            if (r6 == 0) goto L_0x0085
            int r10 = r6.getKindSet$ui_release()
            r10 = r10 & r1
            if (r10 == 0) goto L_0x0080
            int r8 = r8 + 1
            if (r8 != r9) goto L_0x0068
            r4 = r6
            goto L_0x0080
        L_0x0068:
            if (r5 != 0) goto L_0x0073
            androidx.compose.runtime.collection.MutableVector r5 = new androidx.compose.runtime.collection.MutableVector
            r9 = 16
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r9]
            r5.<init>(r9, r7)
        L_0x0073:
            if (r4 == 0) goto L_0x007b
            if (r5 == 0) goto L_0x007a
            r5.add(r4)
        L_0x007a:
            r4 = r3
        L_0x007b:
            if (r5 == 0) goto L_0x0080
            r5.add(r6)
        L_0x0080:
            androidx.compose.ui.Modifier$Node r6 = r6.getChild$ui_release()
            goto L_0x0058
        L_0x0085:
            if (r8 != r9) goto L_0x0088
            goto L_0x003c
        L_0x0088:
            androidx.compose.ui.Modifier$Node r4 = androidx.compose.ui.node.DelegatableNodeKt.pop(r5)
            goto L_0x003c
        L_0x008d:
            androidx.compose.ui.Modifier$Node r2 = r2.getParent$ui_release()
            goto L_0x0031
        L_0x0092:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00a4
            androidx.compose.ui.node.NodeChain r2 = r0.getNodes$ui_release()
            if (r2 == 0) goto L_0x00a4
            androidx.compose.ui.Modifier$Node r2 = r2.getTail$ui_release()
            goto L_0x001f
        L_0x00a4:
            r2 = r3
            goto L_0x001f
        L_0x00a7:
            r4 = r3
        L_0x00a8:
            androidx.compose.ui.focus.FocusTargetNode r4 = (androidx.compose.ui.focus.FocusTargetNode) r4
            if (r4 == 0) goto L_0x00bb
            androidx.compose.ui.layout.BeyondBoundsLayout r0 = r4.getBeyondBoundsLayoutParent()
            androidx.compose.ui.layout.BeyondBoundsLayout r1 = r11.getBeyondBoundsLayoutParent()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x00bb
            return r3
        L_0x00bb:
            androidx.compose.ui.layout.BeyondBoundsLayout r11 = r11.getBeyondBoundsLayoutParent()
            if (r11 == 0) goto L_0x0143
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m3492getUpdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m3479equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x00d4
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r12 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r12 = r12.m5257getAbovehoxUOeE()
            goto L_0x0132
        L_0x00d4:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m3485getDowndhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m3479equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x00e7
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r12 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r12 = r12.m5260getBelowhoxUOeE()
            goto L_0x0132
        L_0x00e7:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m3488getLeftdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m3479equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x00fa
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r12 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r12 = r12.m5261getLefthoxUOeE()
            goto L_0x0132
        L_0x00fa:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m3491getRightdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m3479equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x010d
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r12 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r12 = r12.m5262getRighthoxUOeE()
            goto L_0x0132
        L_0x010d:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m3489getNextdhqQ8s()
            boolean r0 = androidx.compose.ui.focus.FocusDirection.m3479equalsimpl0(r12, r0)
            if (r0 == 0) goto L_0x0120
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r12 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r12 = r12.m5258getAfterhoxUOeE()
            goto L_0x0132
        L_0x0120:
            androidx.compose.ui.focus.FocusDirection$Companion r0 = androidx.compose.ui.focus.FocusDirection.Companion
            int r0 = r0.m3490getPreviousdhqQ8s()
            boolean r12 = androidx.compose.ui.focus.FocusDirection.m3479equalsimpl0(r12, r0)
            if (r12 == 0) goto L_0x0137
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r12 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.Companion
            int r12 = r12.m5259getBeforehoxUOeE()
        L_0x0132:
            java.lang.Object r3 = r11.m5249layouto7g1Pn8(r12, r13)
            goto L_0x0143
        L_0x0137:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Unsupported direction for beyond bounds layout"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0143:
            return r3
        L_0x0144:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "visitAncestors called on an unattached node"
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.BeyondBoundsLayoutKt.m3475searchBeyondBoundsOMvw8(androidx.compose.ui.focus.FocusTargetNode, int, kotlin.jvm.functions.Function1):java.lang.Object");
    }
}
