package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "destination", "Landroidx/compose/ui/focus/FocusTargetNode;", "invoke", "(Landroidx/compose/ui/focus/FocusTargetNode;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusOwnerImpl.kt */
final class FocusOwnerImpl$moveFocus$foundNextItem$1 extends Lambda implements Function1<FocusTargetNode, Boolean> {
    final /* synthetic */ int $focusDirection;
    final /* synthetic */ Ref.BooleanRef $isCancelled;
    final /* synthetic */ FocusTargetNode $source;
    final /* synthetic */ FocusOwnerImpl this$0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusOwnerImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                androidx.compose.ui.focus.CustomDestinationResult[] r0 = androidx.compose.ui.focus.CustomDestinationResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.CustomDestinationResult.Redirected     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.CustomDestinationResult.Cancelled     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.CustomDestinationResult.RedirectCancelled     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.CustomDestinationResult.None     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusOwnerImpl$moveFocus$foundNextItem$1(FocusTargetNode focusTargetNode, FocusOwnerImpl focusOwnerImpl, int i, Ref.BooleanRef booleanRef) {
        super(1);
        this.$source = focusTargetNode;
        this.this$0 = focusOwnerImpl;
        this.$focusDirection = i;
        this.$isCancelled = booleanRef;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a6, code lost:
        r3 = r0.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(androidx.compose.ui.focus.FocusTargetNode r12) {
        /*
            r11 = this;
            androidx.compose.ui.focus.FocusTargetNode r0 = r11.$source
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r0)
            r1 = 0
            if (r0 == 0) goto L_0x000e
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r1)
            return r12
        L_0x000e:
            r0 = r12
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            r2 = 1024(0x400, float:1.435E-42)
            int r2 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r2)
            androidx.compose.ui.Modifier$Node r3 = r0.getNode()
            boolean r3 = r3.isAttached()
            if (r3 == 0) goto L_0x010a
            androidx.compose.ui.Modifier$Node r3 = r0.getNode()
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r0)
        L_0x002d:
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x00b5
            androidx.compose.ui.node.NodeChain r6 = r0.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r6 = r6.getHead$ui_release()
            int r6 = r6.getAggregateChildKindSet$ui_release()
            r6 = r6 & r2
            if (r6 == 0) goto L_0x00a0
        L_0x0040:
            if (r3 == 0) goto L_0x00a0
            int r6 = r3.getKindSet$ui_release()
            r6 = r6 & r2
            if (r6 == 0) goto L_0x009b
            r6 = r3
            r7 = r4
        L_0x004b:
            if (r6 == 0) goto L_0x009b
            boolean r8 = r6 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r8 == 0) goto L_0x0054
            r4 = r6
            goto L_0x00b5
        L_0x0054:
            int r8 = r6.getKindSet$ui_release()
            r8 = r8 & r2
            if (r8 == 0) goto L_0x0096
            boolean r8 = r6 instanceof androidx.compose.ui.node.DelegatingNode
            if (r8 == 0) goto L_0x0096
            r8 = r6
            androidx.compose.ui.node.DelegatingNode r8 = (androidx.compose.ui.node.DelegatingNode) r8
            androidx.compose.ui.Modifier$Node r8 = r8.getDelegate$ui_release()
            r9 = r1
        L_0x0067:
            if (r8 == 0) goto L_0x0093
            int r10 = r8.getKindSet$ui_release()
            r10 = r10 & r2
            if (r10 == 0) goto L_0x008e
            int r9 = r9 + 1
            if (r9 != r5) goto L_0x0076
            r6 = r8
            goto L_0x008e
        L_0x0076:
            if (r7 != 0) goto L_0x0081
            androidx.compose.runtime.collection.MutableVector r7 = new androidx.compose.runtime.collection.MutableVector
            r10 = 16
            androidx.compose.ui.Modifier$Node[] r10 = new androidx.compose.ui.Modifier.Node[r10]
            r7.<init>(r10, r1)
        L_0x0081:
            if (r6 == 0) goto L_0x0089
            if (r7 == 0) goto L_0x0088
            r7.add(r6)
        L_0x0088:
            r6 = r4
        L_0x0089:
            if (r7 == 0) goto L_0x008e
            r7.add(r8)
        L_0x008e:
            androidx.compose.ui.Modifier$Node r8 = r8.getChild$ui_release()
            goto L_0x0067
        L_0x0093:
            if (r9 != r5) goto L_0x0096
            goto L_0x004b
        L_0x0096:
            androidx.compose.ui.Modifier$Node r6 = androidx.compose.ui.node.DelegatableNodeKt.pop(r7)
            goto L_0x004b
        L_0x009b:
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            goto L_0x0040
        L_0x00a0:
            androidx.compose.ui.node.LayoutNode r0 = r0.getParent$ui_release()
            if (r0 == 0) goto L_0x00b2
            androidx.compose.ui.node.NodeChain r3 = r0.getNodes$ui_release()
            if (r3 == 0) goto L_0x00b2
            androidx.compose.ui.Modifier$Node r3 = r3.getTail$ui_release()
            goto L_0x002d
        L_0x00b2:
            r3 = r4
            goto L_0x002d
        L_0x00b5:
            if (r4 == 0) goto L_0x00fe
            androidx.compose.ui.focus.FocusOwnerImpl r0 = r11.this$0
            androidx.compose.ui.focus.FocusTransactionManager r0 = r0.getFocusTransactionManager()
            int r1 = r11.$focusDirection
            kotlin.jvm.internal.Ref$BooleanRef r2 = r11.$isCancelled
            boolean r3 = r0.ongoingTransaction     // Catch:{ all -> 0x00f9 }
            if (r3 == 0) goto L_0x00ca
            r0.cancelTransaction()     // Catch:{ all -> 0x00f9 }
        L_0x00ca:
            r0.beginTransaction()     // Catch:{ all -> 0x00f9 }
            androidx.compose.ui.focus.CustomDestinationResult r1 = androidx.compose.ui.focus.FocusTransactionsKt.m3513performCustomRequestFocusMxy_nc0(r12, r1)     // Catch:{ all -> 0x00f9 }
            int[] r3 = androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x00f9 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x00f9 }
            r1 = r3[r1]     // Catch:{ all -> 0x00f9 }
            if (r1 == r5) goto L_0x00f1
            r3 = 2
            if (r1 == r3) goto L_0x00ef
            r3 = 3
            if (r1 == r3) goto L_0x00ef
            r2 = 4
            if (r1 != r2) goto L_0x00e9
            boolean r5 = androidx.compose.ui.focus.FocusTransactionsKt.performRequestFocus(r12)     // Catch:{ all -> 0x00f9 }
            goto L_0x00f1
        L_0x00e9:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x00f9 }
            r12.<init>()     // Catch:{ all -> 0x00f9 }
            throw r12     // Catch:{ all -> 0x00f9 }
        L_0x00ef:
            r2.element = r5     // Catch:{ all -> 0x00f9 }
        L_0x00f1:
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x00f9 }
            r0.commitTransaction()
            return r12
        L_0x00f9:
            r12 = move-exception
            r0.commitTransaction()
            throw r12
        L_0x00fe:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "Focus search landed at the root."
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        L_0x010a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$foundNextItem$1.invoke(androidx.compose.ui.focus.FocusTargetNode):java.lang.Boolean");
    }
}
