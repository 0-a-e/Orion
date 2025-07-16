package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\fH\bJ\r\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\tH\u0007J\b\u0010\u0014\u001a\u00020\tH\u0007R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester;", "", "()V", "focusRequesterNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/focus/FocusRequesterModifierNode;", "getFocusRequesterNodes$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "captureFocus", "", "findFocusTarget", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focus", "focus$ui_release", "freeFocus", "requestFocus", "", "restoreFocusedChild", "saveFocusedChild", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusRequester.kt */
public final class FocusRequester {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final FocusRequester Cancel = new FocusRequester();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final FocusRequester Default = new FocusRequester();
    private final MutableVector<FocusRequesterModifierNode> focusRequesterNodes = new MutableVector<>(new FocusRequesterModifierNode[16], 0);

    public final MutableVector<FocusRequesterModifierNode> getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        focus$ui_release();
    }

    public final boolean captureFocus() {
        if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                while (!FocusRequesterModifierNodeKt.captureFocus((FocusRequesterModifierNode) content[i])) {
                    i++;
                    if (i >= size) {
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    public final boolean freeFocus() {
        if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                while (!FocusRequesterModifierNodeKt.freeFocus((FocusRequesterModifierNode) content[i])) {
                    i++;
                    if (i >= size) {
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    public final boolean saveFocusedChild() {
        if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                int i = 0;
                while (!FocusRequesterModifierNodeKt.saveFocusedChild((FocusRequesterModifierNode) content[i])) {
                    i++;
                    if (i >= size) {
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    public final boolean restoreFocusedChild() {
        if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
            int size = mutableVector.getSize();
            if (size <= 0) {
                return false;
            }
            Object[] content = mutableVector.getContent();
            int i = 0;
            boolean z = false;
            do {
                z = FocusRequesterModifierNodeKt.restoreFocusedChild((FocusRequesterModifierNode) content[i]) || z;
                i++;
            } while (i < size);
            return z;
        }
        throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007R\u001c\u0010\u0003\u001a\u00020\u00048GX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion;", "", "()V", "Cancel", "Landroidx/compose/ui/focus/FocusRequester;", "getCancel$annotations", "getCancel", "()Landroidx/compose/ui/focus/FocusRequester;", "Default", "getDefault", "createRefs", "Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "FocusRequesterFactory", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: FocusRequester.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCancel$annotations() {
        }

        private Companion() {
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0002J\t\u0010\u0006\u001a\u00020\u0004H\u0002J\t\u0010\u0007\u001a\u00020\u0004H\u0002J\t\u0010\b\u001a\u00020\u0004H\u0002J\t\u0010\t\u001a\u00020\u0004H\u0002J\t\u0010\n\u001a\u00020\u0004H\u0002J\t\u0010\u000b\u001a\u00020\u0004H\u0002J\t\u0010\f\u001a\u00020\u0004H\u0002J\t\u0010\r\u001a\u00020\u0004H\u0002J\t\u0010\u000e\u001a\u00020\u0004H\u0002J\t\u0010\u000f\u001a\u00020\u0004H\u0002J\t\u0010\u0010\u001a\u00020\u0004H\u0002J\t\u0010\u0011\u001a\u00020\u0004H\u0002J\t\u0010\u0012\u001a\u00020\u0004H\u0002J\t\u0010\u0013\u001a\u00020\u0004H\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/FocusRequester$Companion$FocusRequesterFactory;", "", "()V", "component1", "Landroidx/compose/ui/focus/FocusRequester;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: FocusRequester.kt */
        public static final class FocusRequesterFactory {
            public static final int $stable = 0;
            public static final FocusRequesterFactory INSTANCE = new FocusRequesterFactory();

            private FocusRequesterFactory() {
            }

            public final FocusRequester component1() {
                return new FocusRequester();
            }

            public final FocusRequester component2() {
                return new FocusRequester();
            }

            public final FocusRequester component3() {
                return new FocusRequester();
            }

            public final FocusRequester component4() {
                return new FocusRequester();
            }

            public final FocusRequester component5() {
                return new FocusRequester();
            }

            public final FocusRequester component6() {
                return new FocusRequester();
            }

            public final FocusRequester component7() {
                return new FocusRequester();
            }

            public final FocusRequester component8() {
                return new FocusRequester();
            }

            public final FocusRequester component9() {
                return new FocusRequester();
            }

            public final FocusRequester component10() {
                return new FocusRequester();
            }

            public final FocusRequester component11() {
                return new FocusRequester();
            }

            public final FocusRequester component12() {
                return new FocusRequester();
            }

            public final FocusRequester component13() {
                return new FocusRequester();
            }

            public final FocusRequester component14() {
                return new FocusRequester();
            }

            public final FocusRequester component15() {
                return new FocusRequester();
            }

            public final FocusRequester component16() {
                return new FocusRequester();
            }
        }

        public final FocusRequesterFactory createRefs() {
            return FocusRequesterFactory.INSTANCE;
        }
    }

    private final boolean findFocusTarget(Function1<? super FocusTargetNode, Boolean> function1) {
        Companion companion = Companion;
        if (this == companion.getDefault()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        } else if (this == companion.getCancel()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        } else if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
            int size = mutableVector.getSize();
            if (size <= 0) {
                return false;
            }
            Object[] content = mutableVector.getContent();
            int i = 0;
            boolean z = false;
            do {
                DelegatableNode delegatableNode = (FocusRequesterModifierNode) content[i];
                int r7 = NodeKind.m5647constructorimpl(1024);
                if (delegatableNode.getNode().isAttached()) {
                    MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                    Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
                    if (child$ui_release == null) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
                    } else {
                        mutableVector2.add(child$ui_release);
                    }
                    while (true) {
                        if (!mutableVector2.isNotEmpty()) {
                            Function1<? super FocusTargetNode, Boolean> function12 = function1;
                            break;
                        }
                        Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                        if ((node.getAggregateChildKindSet$ui_release() & r7) == 0) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
                        } else {
                            while (true) {
                                if (node == null) {
                                    break;
                                } else if ((node.getKindSet$ui_release() & r7) != 0) {
                                    MutableVector mutableVector3 = null;
                                    while (node != null) {
                                        if (node instanceof FocusTargetNode) {
                                            if (function1.invoke((FocusTargetNode) node).booleanValue()) {
                                                z = true;
                                                break;
                                            }
                                        } else {
                                            Function1<? super FocusTargetNode, Boolean> function13 = function1;
                                            if ((node.getKindSet$ui_release() & r7) != 0 && (node instanceof DelegatingNode)) {
                                                int i2 = 0;
                                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                                    if ((delegate$ui_release.getKindSet$ui_release() & r7) != 0) {
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
                                        }
                                        node = DelegatableNodeKt.pop(mutableVector3);
                                    }
                                } else {
                                    Function1<? super FocusTargetNode, Boolean> function14 = function1;
                                    node = node.getChild$ui_release();
                                }
                            }
                            Function1<? super FocusTargetNode, Boolean> function15 = function1;
                        }
                    }
                    i++;
                } else {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
            } while (i < size);
            return z;
        } else {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
    }

    public final boolean focus$ui_release() {
        boolean z;
        Companion companion = Companion;
        if (this == companion.getDefault()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        } else if (this == companion.getCancel()) {
            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n".toString());
        } else if (this.focusRequesterNodes.isNotEmpty()) {
            MutableVector<FocusRequesterModifierNode> mutableVector = this.focusRequesterNodes;
            int size = mutableVector.getSize();
            if (size <= 0) {
                return false;
            }
            Object[] content = mutableVector.getContent();
            int i = 0;
            boolean z2 = false;
            do {
                DelegatableNode delegatableNode = (FocusRequesterModifierNode) content[i];
                int r6 = NodeKind.m5647constructorimpl(1024);
                if (delegatableNode.getNode().isAttached()) {
                    MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                    Modifier.Node child$ui_release = delegatableNode.getNode().getChild$ui_release();
                    if (child$ui_release == null) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, delegatableNode.getNode());
                    } else {
                        mutableVector2.add(child$ui_release);
                    }
                    while (true) {
                        if (!mutableVector2.isNotEmpty()) {
                            break;
                        }
                        Modifier.Node node = (Modifier.Node) mutableVector2.removeAt(mutableVector2.getSize() - 1);
                        if ((node.getAggregateChildKindSet$ui_release() & r6) == 0) {
                            DelegatableNodeKt.addLayoutNodeChildren(mutableVector2, node);
                        } else {
                            while (true) {
                                if (node == null) {
                                    continue;
                                    break;
                                } else if ((node.getKindSet$ui_release() & r6) != 0) {
                                    MutableVector mutableVector3 = null;
                                    while (node != null) {
                                        if (node instanceof FocusTargetNode) {
                                            FocusTargetNode focusTargetNode = (FocusTargetNode) node;
                                            if (focusTargetNode.fetchFocusProperties$ui_release().getCanFocus()) {
                                                z = FocusTransactionsKt.requestFocus(focusTargetNode);
                                            } else {
                                                z = TwoDimensionalFocusSearchKt.m3523findChildCorrespondingToFocusEnterOMvw8(focusTargetNode, FocusDirection.Companion.m3486getEnterdhqQ8s(), FocusRequester$focus$1$1.INSTANCE);
                                            }
                                            if (z) {
                                                z2 = true;
                                                break;
                                            }
                                        } else if ((node.getKindSet$ui_release() & r6) != 0 && (node instanceof DelegatingNode)) {
                                            int i2 = 0;
                                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                                if ((delegate$ui_release.getKindSet$ui_release() & r6) != 0) {
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
                                    continue;
                                } else {
                                    node = node.getChild$ui_release();
                                }
                            }
                        }
                    }
                    i++;
                } else {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
            } while (i < size);
            return z2;
        } else {
            throw new IllegalStateException("\n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n".toString());
        }
    }
}
