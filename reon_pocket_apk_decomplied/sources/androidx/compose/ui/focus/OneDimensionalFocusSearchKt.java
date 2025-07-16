package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a \u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001aE\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\f0\nH\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0011\u001aE\u0010\u0012\u001a\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000e2\u0006\u0010\u000f\u001a\u0002H\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\f0\nH\b\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u0011\u001a \u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a:\u0010\u0014\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\f\u0010\u001a\u001a\u00020\u0007*\u00020\bH\u0002\u001a2\u0010\u001b\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0000ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a \u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a \u0010\u001f\u001a\u00020\u0007*\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002\u001a:\u0010 \u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\nH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0019\"\u0014\u0010\u0000\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0001XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"InvalidFocusDirection", "", "getInvalidFocusDirection$annotations", "()V", "NoActiveChild", "getNoActiveChild$annotations", "backwardFocusSearch", "", "Landroidx/compose/ui/focus/FocusTargetNode;", "onFound", "Lkotlin/Function1;", "forEachItemAfter", "", "T", "Landroidx/compose/runtime/collection/MutableVector;", "item", "action", "(Landroidx/compose/runtime/collection/MutableVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachItemBefore", "forwardFocusSearch", "generateAndSearchChildren", "focusedItem", "direction", "Landroidx/compose/ui/focus/FocusDirection;", "generateAndSearchChildren-4C6V_qg", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "isRoot", "oneDimensionalFocusSearch", "oneDimensionalFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILkotlin/jvm/functions/Function1;)Z", "pickChildForBackwardSearch", "pickChildForForwardSearch", "searchChildren", "searchChildren-4C6V_qg", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: OneDimensionalFocusSearch.kt */
public final class OneDimensionalFocusSearchKt {
    private static final String InvalidFocusDirection = "This function should only be used for 1-D focus search";
    private static final String NoActiveChild = "ActiveParent must have a focusedChild";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: OneDimensionalFocusSearch.kt */
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
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Active     // Catch:{ NoSuchFieldError -> 0x0019 }
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.OneDimensionalFocusSearchKt.WhenMappings.<clinit>():void");
        }
    }

    private static /* synthetic */ void getInvalidFocusDirection$annotations() {
    }

    private static /* synthetic */ void getNoActiveChild$annotations() {
    }

    /* renamed from: oneDimensionalFocusSearch--OM-vw8  reason: not valid java name */
    public static final boolean m3518oneDimensionalFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i, Function1<? super FocusTargetNode, Boolean> function1) {
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3489getNextdhqQ8s())) {
            return forwardFocusSearch(focusTargetNode, function1);
        }
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3490getPreviousdhqQ8s())) {
            return backwardFocusSearch(focusTargetNode, function1);
        }
        throw new IllegalStateException(InvalidFocusDirection.toString());
    }

    private static final boolean forwardFocusSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild == null) {
                throw new IllegalStateException(NoActiveChild.toString());
            } else if (forwardFocusSearch(activeChild, function1) || m3517generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.Companion.m3489getNextdhqQ8s(), function1)) {
                return true;
            } else {
                return false;
            }
        } else if (i == 2 || i == 3) {
            return pickChildForForwardSearch(focusTargetNode, function1);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                return function1.invoke(focusTargetNode).booleanValue();
            } else {
                return pickChildForForwardSearch(focusTargetNode, function1);
            }
        }
    }

    private static final boolean backwardFocusSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        int i = WhenMappings.$EnumSwitchMapping$0[focusTargetNode.getFocusState().ordinal()];
        if (i == 1) {
            FocusTargetNode activeChild = FocusTraversalKt.getActiveChild(focusTargetNode);
            if (activeChild != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[activeChild.getFocusState().ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 || i2 == 3) {
                        return m3517generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.Companion.m3490getPreviousdhqQ8s(), function1);
                    }
                    if (i2 != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IllegalStateException(NoActiveChild.toString());
                } else if (!backwardFocusSearch(activeChild, function1) && !m3517generateAndSearchChildren4C6V_qg(focusTargetNode, activeChild, FocusDirection.Companion.m3490getPreviousdhqQ8s(), function1) && (!activeChild.fetchFocusProperties$ui_release().getCanFocus() || !function1.invoke(activeChild).booleanValue())) {
                    return false;
                }
            } else {
                throw new IllegalStateException(NoActiveChild.toString());
            }
        } else if (i == 2 || i == 3) {
            return pickChildForBackwardSearch(focusTargetNode, function1);
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            } else if (!pickChildForBackwardSearch(focusTargetNode, function1)) {
                if (!(focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() ? function1.invoke(focusTargetNode).booleanValue() : false)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: generateAndSearchChildren-4C6V_qg  reason: not valid java name */
    private static final boolean m3517generateAndSearchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, Function1<? super FocusTargetNode, Boolean> function1) {
        if (m3519searchChildren4C6V_qg(focusTargetNode, focusTargetNode2, i, function1)) {
            return true;
        }
        Boolean bool = (Boolean) BeyondBoundsLayoutKt.m3475searchBeyondBoundsOMvw8(focusTargetNode, i, new OneDimensionalFocusSearchKt$generateAndSearchChildren$1(focusTargetNode, focusTargetNode2, i, function1));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: searchChildren-4C6V_qg  reason: not valid java name */
    public static final boolean m3519searchChildren4C6V_qg(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2, int i, Function1<? super FocusTargetNode, Boolean> function1) {
        if (focusTargetNode.getFocusState() == FocusStateImpl.ActiveParent) {
            MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
            DelegatableNode delegatableNode = focusTargetNode;
            int r4 = NodeKind.m5647constructorimpl(1024);
            if (delegatableNode.getNode().isAttached()) {
                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
                if (child$ui_release == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
                } else {
                    mutableVector2.add(child$ui_release);
                }
                while (mutableVector2.isNotEmpty()) {
                    Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                    if ((node.getAggregateChildKindSet$ui_release() & r4) == 0) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
                    } else {
                        while (true) {
                            if (node == null) {
                                break;
                            } else if ((node.getKindSet$ui_release() & r4) != 0) {
                                MutableVector mutableVector3 = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        mutableVector.add((FocusTargetNode) node);
                                    } else if ((node.getKindSet$ui_release() & r4) != 0 && (node instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                            if ((delegate$ui_release.getKindSet$ui_release() & r4) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node = delegate$ui_release;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node != null) {
                                                        if (mutableVector3 != null) {
                                                            mutableVector3.add(node);
                                                        }
                                                        node = null;
                                                    }
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(delegate$ui_release);
                                                    }
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector3);
                                }
                            } else {
                                node = node.getChild$ui_release();
                            }
                        }
                    }
                }
                mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
                if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3489getNextdhqQ8s())) {
                    IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
                    int first = intRange.getFirst();
                    int last = intRange.getLast();
                    if (first <= last) {
                        boolean z = false;
                        while (true) {
                            if (z) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) mutableVector.getContent()[first];
                                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode3) && forwardFocusSearch(focusTargetNode3, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual(mutableVector.getContent()[first], (Object) focusTargetNode2)) {
                                z = true;
                            }
                            if (first == last) {
                                break;
                            }
                            first++;
                        }
                    }
                } else if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3490getPreviousdhqQ8s())) {
                    IntRange intRange2 = new IntRange(0, mutableVector.getSize() - 1);
                    int first2 = intRange2.getFirst();
                    int last2 = intRange2.getLast();
                    if (first2 <= last2) {
                        boolean z2 = false;
                        while (true) {
                            if (z2) {
                                FocusTargetNode focusTargetNode4 = (FocusTargetNode) mutableVector.getContent()[last2];
                                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode4) && backwardFocusSearch(focusTargetNode4, function1)) {
                                    return true;
                                }
                            }
                            if (Intrinsics.areEqual(mutableVector.getContent()[last2], (Object) focusTargetNode2)) {
                                z2 = true;
                            }
                            if (last2 == first2) {
                                break;
                            }
                            last2--;
                        }
                    }
                } else {
                    throw new IllegalStateException(InvalidFocusDirection.toString());
                }
                if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3489getNextdhqQ8s()) || !focusTargetNode.fetchFocusProperties$ui_release().getCanFocus() || isRoot(focusTargetNode)) {
                    return false;
                }
                return function1.invoke(focusTargetNode).booleanValue();
            }
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        throw new IllegalStateException("This function should only be used within a parent that has focus.".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0098, code lost:
        r1 = r10.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean isRoot(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.node.DelegatableNode r10 = (androidx.compose.ui.node.DelegatableNode) r10
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L_0x00ab
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r10 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r10)
        L_0x001e:
            r2 = 0
            r3 = 1
            r4 = 0
            if (r10 == 0) goto L_0x00a7
            androidx.compose.ui.node.NodeChain r5 = r10.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r5 = r5.getHead$ui_release()
            int r5 = r5.getAggregateChildKindSet$ui_release()
            r5 = r5 & r0
            if (r5 == 0) goto L_0x0092
        L_0x0032:
            if (r1 == 0) goto L_0x0092
            int r5 = r1.getKindSet$ui_release()
            r5 = r5 & r0
            if (r5 == 0) goto L_0x008d
            r5 = r1
            r6 = r4
        L_0x003d:
            if (r5 == 0) goto L_0x008d
            boolean r7 = r5 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r7 == 0) goto L_0x0046
            r4 = r5
            goto L_0x00a7
        L_0x0046:
            int r7 = r5.getKindSet$ui_release()
            r7 = r7 & r0
            if (r7 == 0) goto L_0x0088
            boolean r7 = r5 instanceof androidx.compose.ui.node.DelegatingNode
            if (r7 == 0) goto L_0x0088
            r7 = r5
            androidx.compose.ui.node.DelegatingNode r7 = (androidx.compose.ui.node.DelegatingNode) r7
            androidx.compose.ui.Modifier$Node r7 = r7.getDelegate$ui_release()
            r8 = r2
        L_0x0059:
            if (r7 == 0) goto L_0x0085
            int r9 = r7.getKindSet$ui_release()
            r9 = r9 & r0
            if (r9 == 0) goto L_0x0080
            int r8 = r8 + 1
            if (r8 != r3) goto L_0x0068
            r5 = r7
            goto L_0x0080
        L_0x0068:
            if (r6 != 0) goto L_0x0073
            androidx.compose.runtime.collection.MutableVector r6 = new androidx.compose.runtime.collection.MutableVector
            r9 = 16
            androidx.compose.ui.Modifier$Node[] r9 = new androidx.compose.ui.Modifier.Node[r9]
            r6.<init>(r9, r2)
        L_0x0073:
            if (r5 == 0) goto L_0x007b
            if (r6 == 0) goto L_0x007a
            r6.add(r5)
        L_0x007a:
            r5 = r4
        L_0x007b:
            if (r6 == 0) goto L_0x0080
            r6.add(r7)
        L_0x0080:
            androidx.compose.ui.Modifier$Node r7 = r7.getChild$ui_release()
            goto L_0x0059
        L_0x0085:
            if (r8 != r3) goto L_0x0088
            goto L_0x003d
        L_0x0088:
            androidx.compose.ui.Modifier$Node r5 = androidx.compose.ui.node.DelegatableNodeKt.pop(r6)
            goto L_0x003d
        L_0x008d:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x0032
        L_0x0092:
            androidx.compose.ui.node.LayoutNode r10 = r10.getParent$ui_release()
            if (r10 == 0) goto L_0x00a4
            androidx.compose.ui.node.NodeChain r1 = r10.getNodes$ui_release()
            if (r1 == 0) goto L_0x00a4
            androidx.compose.ui.Modifier$Node r1 = r1.getTail$ui_release()
            goto L_0x001e
        L_0x00a4:
            r1 = r4
            goto L_0x001e
        L_0x00a7:
            if (r4 != 0) goto L_0x00aa
            r2 = r3
        L_0x00aa:
            return r2
        L_0x00ab:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.OneDimensionalFocusSearchKt.isRoot(androidx.compose.ui.focus.FocusTargetNode):boolean");
    }

    private static final boolean pickChildForForwardSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        DelegatableNode delegatableNode = focusTargetNode;
        int r2 = NodeKind.m5647constructorimpl(1024);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & r2) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
                } else {
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui_release() & r2) != 0) {
                            MutableVector mutableVector3 = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    mutableVector.add((FocusTargetNode) node);
                                } else if ((node.getKindSet$ui_release() & r2) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r2) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector3);
                            }
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
            int size = mutableVector.getSize();
            if (size <= 0) {
                return false;
            }
            Object[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                FocusTargetNode focusTargetNode2 = (FocusTargetNode) content[i2];
                if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) && forwardFocusSearch(focusTargetNode2, function1)) {
                    return true;
                }
                i2++;
            } while (i2 < size);
            return false;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    private static final boolean pickChildForBackwardSearch(FocusTargetNode focusTargetNode, Function1<? super FocusTargetNode, Boolean> function1) {
        MutableVector mutableVector = new MutableVector(new FocusTargetNode[16], 0);
        DelegatableNode delegatableNode = focusTargetNode;
        int r2 = NodeKind.m5647constructorimpl(1024);
        if (delegatableNode.getNode().isAttached()) {
            MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
            Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
            if (child$ui_release == null) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
            } else {
                mutableVector2.add(child$ui_release);
            }
            while (mutableVector2.isNotEmpty()) {
                Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                if ((node.getAggregateChildKindSet$ui_release() & r2) == 0) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
                } else {
                    while (true) {
                        if (node == null) {
                            break;
                        } else if ((node.getKindSet$ui_release() & r2) != 0) {
                            MutableVector mutableVector3 = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    mutableVector.add((FocusTargetNode) node);
                                } else if ((node.getKindSet$ui_release() & r2) != 0 && (node instanceof DelegatingNode)) {
                                    int i = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r2) != 0) {
                                            i++;
                                            if (i == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector3 == null) {
                                                    mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector3 != null) {
                                                        mutableVector3.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector3 != null) {
                                                    mutableVector3.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.pop(mutableVector3);
                            }
                        } else {
                            node = node.getChild$ui_release();
                        }
                    }
                }
            }
            mutableVector.sortWith(FocusableChildrenComparator.INSTANCE);
            int size = mutableVector.getSize();
            if (size > 0) {
                int i2 = size - 1;
                Object[] content = mutableVector.getContent();
                do {
                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) content[i2];
                    if (FocusTraversalKt.isEligibleForFocusSearch(focusTargetNode2) && backwardFocusSearch(focusTargetNode2, function1)) {
                        return true;
                    }
                    i2--;
                } while (i2 >= 0);
            }
            return false;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    private static final <T> void forEachItemAfter(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean z = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                if (z) {
                    function1.invoke(mutableVector.getContent()[first]);
                }
                if (Intrinsics.areEqual(mutableVector.getContent()[first], (Object) t)) {
                    z = true;
                }
                if (first != last) {
                    first++;
                } else {
                    return;
                }
            }
        }
    }

    private static final <T> void forEachItemBefore(MutableVector<T> mutableVector, T t, Function1<? super T, Unit> function1) {
        boolean z = false;
        IntRange intRange = new IntRange(0, mutableVector.getSize() - 1);
        int first = intRange.getFirst();
        int last = intRange.getLast();
        if (first <= last) {
            while (true) {
                if (z) {
                    function1.invoke(mutableVector.getContent()[last]);
                }
                if (Intrinsics.areEqual(mutableVector.getContent()[last], (Object) t)) {
                    z = true;
                }
                if (last != first) {
                    last--;
                } else {
                    return;
                }
            }
        }
    }
}
