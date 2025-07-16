package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001a:\u0010\u0013\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", "", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusTraversal.kt */
public final class FocusTraversalKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusTraversal.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003b */
        static {
            /*
                androidx.compose.ui.unit.LayoutDirection[] r0 = androidx.compose.ui.unit.LayoutDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.compose.ui.unit.LayoutDirection r2 = androidx.compose.ui.unit.LayoutDirection.Ltr     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                androidx.compose.ui.unit.LayoutDirection r3 = androidx.compose.ui.unit.LayoutDirection.Rtl     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                androidx.compose.ui.focus.FocusStateImpl[] r0 = androidx.compose.ui.focus.FocusStateImpl.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.compose.ui.focus.FocusStateImpl r3 = androidx.compose.ui.focus.FocusStateImpl.Active     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.ActiveParent     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Captured     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                androidx.compose.ui.focus.FocusStateImpl r1 = androidx.compose.ui.focus.FocusStateImpl.Inactive     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.WhenMappings.<clinit>():void");
        }
    }

    /* renamed from: customFocusSearch--OM-vw8  reason: not valid java name */
    public static final FocusRequester m3514customFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection) {
        FocusRequester focusRequester;
        FocusRequester focusRequester2;
        FocusProperties fetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3489getNextdhqQ8s())) {
            return fetchFocusProperties$ui_release.getNext();
        }
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3490getPreviousdhqQ8s())) {
            return fetchFocusProperties$ui_release.getPrevious();
        }
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3492getUpdhqQ8s())) {
            return fetchFocusProperties$ui_release.getUp();
        }
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3485getDowndhqQ8s())) {
            return fetchFocusProperties$ui_release.getDown();
        }
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3488getLeftdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                focusRequester2 = fetchFocusProperties$ui_release.getStart();
            } else if (i2 == 2) {
                focusRequester2 = fetchFocusProperties$ui_release.getEnd();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (focusRequester2 == FocusRequester.Companion.getDefault()) {
                focusRequester2 = null;
            }
            if (focusRequester2 == null) {
                return fetchFocusProperties$ui_release.getLeft();
            }
        } else if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3491getRightdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                focusRequester = fetchFocusProperties$ui_release.getEnd();
            } else if (i3 == 2) {
                focusRequester = fetchFocusProperties$ui_release.getStart();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            if (focusRequester == FocusRequester.Companion.getDefault()) {
                focusRequester = null;
            }
            if (focusRequester2 == null) {
                return fetchFocusProperties$ui_release.getRight();
            }
        } else if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3486getEnterdhqQ8s())) {
            return fetchFocusProperties$ui_release.getEnter().invoke(FocusDirection.m3476boximpl(i));
        } else {
            if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3487getExitdhqQ8s())) {
                return fetchFocusProperties$ui_release.getExit().invoke(FocusDirection.m3476boximpl(i));
            }
            throw new IllegalStateException("invalid FocusDirection".toString());
        }
        return focusRequester2;
    }

    /* renamed from: focusSearch-sMXa3k8  reason: not valid java name */
    public static final boolean m3515focusSearchsMXa3k8(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection, Function1<? super FocusTargetNode, Boolean> function1) {
        int i2;
        Boolean r3;
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3489getNextdhqQ8s()) ? true : FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3490getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m3518oneDimensionalFocusSearchOMvw8(focusTargetNode, i, function1);
        }
        if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3488getLeftdhqQ8s()) ? true : FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3491getRightdhqQ8s()) ? true : FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3492getUpdhqQ8s()) ? true : FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3485getDowndhqQ8s())) {
            Boolean r32 = TwoDimensionalFocusSearchKt.m3527twoDimensionalFocusSearchOMvw8(focusTargetNode, i, function1);
            if (r32 != null) {
                return r32.booleanValue();
            }
        } else if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3486getEnterdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                i2 = FocusDirection.Companion.m3491getRightdhqQ8s();
            } else if (i3 == 2) {
                i2 = FocusDirection.Companion.m3488getLeftdhqQ8s();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            FocusTargetNode findActiveFocusNode = findActiveFocusNode(focusTargetNode);
            if (!(findActiveFocusNode == null || (r3 = TwoDimensionalFocusSearchKt.m3527twoDimensionalFocusSearchOMvw8(findActiveFocusNode, i2, function1)) == null)) {
                return r3.booleanValue();
            }
        } else if (FocusDirection.m3479equalsimpl0(i, FocusDirection.Companion.m3487getExitdhqQ8s())) {
            FocusTargetNode findActiveFocusNode2 = findActiveFocusNode(focusTargetNode);
            FocusTargetNode findNonDeactivatedParent = findActiveFocusNode2 != null ? findNonDeactivatedParent(findActiveFocusNode2) : null;
            if (findNonDeactivatedParent != null && !Intrinsics.areEqual((Object) findNonDeactivatedParent, (Object) focusTargetNode)) {
                return function1.invoke(findNonDeactivatedParent).booleanValue();
            }
        } else {
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + FocusDirection.m3481toStringimpl(i)).toString());
        }
        return false;
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator$ui_release();
        if (coordinator$ui_release != null) {
            LayoutCoordinates layoutCoordinates = coordinator$ui_release;
            Rect localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates).localBoundingBoxOf(layoutCoordinates, false);
            if (localBoundingBoxOf != null) {
                return localBoundingBoxOf;
            }
        }
        return Rect.Companion.getZero();
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator coordinator$ui_release;
        LayoutNode layoutNode2;
        NodeCoordinator coordinator$ui_release2 = focusTargetNode.getCoordinator$ui_release();
        if (coordinator$ui_release2 == null || (layoutNode = coordinator$ui_release2.getLayoutNode()) == null || !layoutNode.isPlaced() || (coordinator$ui_release = focusTargetNode.getCoordinator$ui_release()) == null || (layoutNode2 = coordinator$ui_release.getLayoutNode()) == null || !layoutNode2.isAttached()) {
            return false;
        }
        return true;
    }

    public static final FocusTargetNode getActiveChild(FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.getNode().isAttached()) {
            return null;
        }
        DelegatableNode delegatableNode = focusTargetNode;
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
                            continue;
                            break;
                        } else if ((node.getKindSet$ui_release() & r0) != 0) {
                            MutableVector mutableVector2 = null;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    FocusTargetNode focusTargetNode2 = (FocusTargetNode) node;
                                    if (focusTargetNode2.getNode().isAttached()) {
                                        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode2.getFocusState().ordinal()];
                                        if (i == 1 || i == 2 || i == 3) {
                                            return focusTargetNode2;
                                        }
                                    }
                                } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                        if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                            i2++;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
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
            return null;
        }
        throw new IllegalStateException("visitChildren called on an unattached node".toString());
    }

    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode focusTargetNode) {
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i != 1) {
            if (i == 2) {
                DelegatableNode delegatableNode = focusTargetNode;
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
                                    continue;
                                    break;
                                } else if ((node.getKindSet$ui_release() & r0) != 0) {
                                    MutableVector mutableVector2 = null;
                                    while (node != null) {
                                        if (node instanceof FocusTargetNode) {
                                            FocusTargetNode findActiveFocusNode = findActiveFocusNode((FocusTargetNode) node);
                                            if (findActiveFocusNode != null) {
                                                return findActiveFocusNode;
                                            }
                                        } else if ((node.getKindSet$ui_release() & r0) != 0 && (node instanceof DelegatingNode)) {
                                            int i2 = 0;
                                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                                if ((delegate$ui_release.getKindSet$ui_release() & r0) != 0) {
                                                    i2++;
                                                    if (i2 == 1) {
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
                                            if (i2 == 1) {
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
                    return null;
                }
                throw new IllegalStateException("visitChildren called on an unattached node".toString());
            } else if (i != 3) {
                if (i == 4) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return focusTargetNode;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a2, code lost:
        r1 = r10.getNodes$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.ui.focus.FocusTargetNode findNonDeactivatedParent(androidx.compose.ui.focus.FocusTargetNode r10) {
        /*
            androidx.compose.ui.node.DelegatableNode r10 = (androidx.compose.ui.node.DelegatableNode) r10
            r0 = 1024(0x400, float:1.435E-42)
            int r0 = androidx.compose.ui.node.NodeKind.m5647constructorimpl(r0)
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            boolean r1 = r1.isAttached()
            if (r1 == 0) goto L_0x00b2
            androidx.compose.ui.Modifier$Node r1 = r10.getNode()
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            androidx.compose.ui.node.LayoutNode r10 = androidx.compose.ui.node.DelegatableNodeKt.requireLayoutNode(r10)
        L_0x001e:
            r2 = 0
            if (r10 == 0) goto L_0x00b1
            androidx.compose.ui.node.NodeChain r3 = r10.getNodes$ui_release()
            androidx.compose.ui.Modifier$Node r3 = r3.getHead$ui_release()
            int r3 = r3.getAggregateChildKindSet$ui_release()
            r3 = r3 & r0
            if (r3 == 0) goto L_0x009c
        L_0x0030:
            if (r1 == 0) goto L_0x009c
            int r3 = r1.getKindSet$ui_release()
            r3 = r3 & r0
            if (r3 == 0) goto L_0x0097
            r3 = r1
            r4 = r2
        L_0x003b:
            if (r3 == 0) goto L_0x0097
            boolean r5 = r3 instanceof androidx.compose.ui.focus.FocusTargetNode
            if (r5 == 0) goto L_0x004e
            androidx.compose.ui.focus.FocusTargetNode r3 = (androidx.compose.ui.focus.FocusTargetNode) r3
            androidx.compose.ui.focus.FocusProperties r5 = r3.fetchFocusProperties$ui_release()
            boolean r5 = r5.getCanFocus()
            if (r5 == 0) goto L_0x0092
            return r3
        L_0x004e:
            int r5 = r3.getKindSet$ui_release()
            r5 = r5 & r0
            if (r5 == 0) goto L_0x0092
            boolean r5 = r3 instanceof androidx.compose.ui.node.DelegatingNode
            if (r5 == 0) goto L_0x0092
            r5 = r3
            androidx.compose.ui.node.DelegatingNode r5 = (androidx.compose.ui.node.DelegatingNode) r5
            androidx.compose.ui.Modifier$Node r5 = r5.getDelegate$ui_release()
            r6 = 0
            r7 = r6
        L_0x0062:
            r8 = 1
            if (r5 == 0) goto L_0x008f
            int r9 = r5.getKindSet$ui_release()
            r9 = r9 & r0
            if (r9 == 0) goto L_0x008a
            int r7 = r7 + 1
            if (r7 != r8) goto L_0x0072
            r3 = r5
            goto L_0x008a
        L_0x0072:
            if (r4 != 0) goto L_0x007d
            androidx.compose.runtime.collection.MutableVector r4 = new androidx.compose.runtime.collection.MutableVector
            r8 = 16
            androidx.compose.ui.Modifier$Node[] r8 = new androidx.compose.ui.Modifier.Node[r8]
            r4.<init>(r8, r6)
        L_0x007d:
            if (r3 == 0) goto L_0x0085
            if (r4 == 0) goto L_0x0084
            r4.add(r3)
        L_0x0084:
            r3 = r2
        L_0x0085:
            if (r4 == 0) goto L_0x008a
            r4.add(r5)
        L_0x008a:
            androidx.compose.ui.Modifier$Node r5 = r5.getChild$ui_release()
            goto L_0x0062
        L_0x008f:
            if (r7 != r8) goto L_0x0092
            goto L_0x003b
        L_0x0092:
            androidx.compose.ui.Modifier$Node r3 = androidx.compose.ui.node.DelegatableNodeKt.pop(r4)
            goto L_0x003b
        L_0x0097:
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x0030
        L_0x009c:
            androidx.compose.ui.node.LayoutNode r10 = r10.getParent$ui_release()
            if (r10 == 0) goto L_0x00ae
            androidx.compose.ui.node.NodeChain r1 = r10.getNodes$ui_release()
            if (r1 == 0) goto L_0x00ae
            androidx.compose.ui.Modifier$Node r1 = r1.getTail$ui_release()
            goto L_0x001e
        L_0x00ae:
            r1 = r2
            goto L_0x001e
        L_0x00b1:
            return r2
        L_0x00b2:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "visitAncestors called on an unattached node"
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTraversalKt.findNonDeactivatedParent(androidx.compose.ui.focus.FocusTargetNode):androidx.compose.ui.focus.FocusTargetNode");
    }
}
