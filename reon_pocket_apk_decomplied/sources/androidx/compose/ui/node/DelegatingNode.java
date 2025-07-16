package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0004¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u0002H\rH\u0001¢\u0006\u0004\b\u0012\u0010\u0010J\"\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u0016H\b¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0014H\u0010¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000eH\u0004J\u0015\u0010$\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u000eH\u0001¢\u0006\u0002\b%J\u0017\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(H\u0010¢\u0006\u0002\b)J\u0018\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020\u00142\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0001H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u00061"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "delegate", "getDelegate$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "selfKindSet", "", "getSelfKindSet$ui_release$annotations", "getSelfKindSet$ui_release", "()I", "T", "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "delegateUnprotected", "delegateUnprotected$ui_release", "forEachImmediateDelegate", "", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui_release", "markAsAttached", "markAsAttached$ui_release", "markAsDetached", "markAsDetached$ui_release", "reset", "reset$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "undelegate", "instance", "undelegateUnprotected", "undelegateUnprotected$ui_release", "updateCoordinator", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DelegatingNode.kt */
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom((Modifier.Node) this);

    public static /* synthetic */ void getSelfKindSet$ui_release$annotations() {
    }

    public final int getSelfKindSet$ui_release() {
        return this.selfKindSet;
    }

    public void updateCoordinator$ui_release(NodeCoordinator nodeCoordinator) {
        super.updateCoordinator$ui_release(nodeCoordinator);
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.updateCoordinator$ui_release(nodeCoordinator);
        }
    }

    public final Modifier.Node getDelegate$ui_release() {
        return this.delegate;
    }

    public final void setDelegate$ui_release(Modifier.Node node) {
        this.delegate = node;
    }

    public final <T extends DelegatableNode> T delegateUnprotected$ui_release(T t) {
        return delegate(t);
    }

    public final void undelegateUnprotected$ui_release(DelegatableNode delegatableNode) {
        undelegate(delegatableNode);
    }

    /* access modifiers changed from: protected */
    public final <T extends DelegatableNode> T delegate(T t) {
        T node = t.getNode();
        Modifier.Node node2 = null;
        if (node != t) {
            Modifier.Node node3 = t instanceof Modifier.Node ? (Modifier.Node) t : null;
            if (node3 != null) {
                node2 = node3.getParent$ui_release();
            }
            if (node == getNode() && Intrinsics.areEqual((Object) node2, (Object) this)) {
                return t;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        } else if (!node.isAttached()) {
            node.setAsDelegateTo$ui_release(getNode());
            int kindSet$ui_release = getKindSet$ui_release();
            int calculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
            node.setKindSet$ui_release(calculateNodeKindSetFromIncludingDelegates);
            validateDelegateKindSet(calculateNodeKindSetFromIncludingDelegates, node);
            node.setChild$ui_release(this.delegate);
            this.delegate = node;
            node.setParent$ui_release(this);
            updateNodeKindSet(getKindSet$ui_release() | calculateNodeKindSetFromIncludingDelegates, false);
            if (isAttached()) {
                if ((calculateNodeKindSetFromIncludingDelegates & NodeKind.m5647constructorimpl(2)) == 0 || (kindSet$ui_release & NodeKind.m5647constructorimpl(2)) != 0) {
                    updateCoordinator$ui_release(getCoordinator$ui_release());
                } else {
                    NodeChain nodes$ui_release = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release();
                    getNode().updateCoordinator$ui_release((NodeCoordinator) null);
                    nodes$ui_release.syncCoordinators();
                }
                node.markAsAttached$ui_release();
                node.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(node);
            }
            return t;
        } else {
            throw new IllegalStateException("Cannot delegate to an already attached node".toString());
        }
    }

    /* access modifiers changed from: protected */
    public final void undelegate(DelegatableNode delegatableNode) {
        Modifier.Node node = null;
        for (Modifier.Node node2 = this.delegate; node2 != null; node2 = node2.getChild$ui_release()) {
            if (node2 == delegatableNode) {
                if (node2.isAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(node2);
                    node2.runDetachLifecycle$ui_release();
                    node2.markAsDetached$ui_release();
                }
                node2.setAsDelegateTo$ui_release(node2);
                node2.setAggregateChildKindSet$ui_release(0);
                if (node == null) {
                    this.delegate = node2.getChild$ui_release();
                } else {
                    node.setChild$ui_release(node2.getChild$ui_release());
                }
                node2.setChild$ui_release((Modifier.Node) null);
                node2.setParent$ui_release((Modifier.Node) null);
                int kindSet$ui_release = getKindSet$ui_release();
                int calculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
                updateNodeKindSet(calculateNodeKindSetFromIncludingDelegates, true);
                if (isAttached() && (kindSet$ui_release & NodeKind.m5647constructorimpl(2)) != 0 && (NodeKind.m5647constructorimpl(2) & calculateNodeKindSetFromIncludingDelegates) == 0) {
                    NodeChain nodes$ui_release = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release();
                    getNode().updateCoordinator$ui_release((NodeCoordinator) null);
                    nodes$ui_release.syncCoordinators();
                    return;
                }
                return;
            }
            node = node2;
        }
        throw new IllegalStateException(("Could not find delegate: " + delegatableNode).toString());
    }

    private final void validateDelegateKindSet(int i, Modifier.Node node) {
        int kindSet$ui_release = getKindSet$ui_release();
        if ((i & NodeKind.m5647constructorimpl(2)) != 0 && (NodeKind.m5647constructorimpl(2) & kindSet$ui_release) != 0 && !(this instanceof LayoutModifierNode)) {
            throw new IllegalStateException(("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + node).toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
        r5 = r1.getChild$ui_release();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateNodeKindSet(int r4, boolean r5) {
        /*
            r3 = this;
            int r0 = r3.getKindSet$ui_release()
            r3.setKindSet$ui_release(r4)
            if (r0 == r4) goto L_0x005c
            r0 = r3
            androidx.compose.ui.node.DelegatableNode r0 = (androidx.compose.ui.node.DelegatableNode) r0
            boolean r0 = androidx.compose.ui.node.DelegatableNodeKt.isDelegationRoot(r0)
            if (r0 == 0) goto L_0x0015
            r3.setAggregateChildKindSet$ui_release(r4)
        L_0x0015:
            boolean r0 = r3.isAttached()
            if (r0 == 0) goto L_0x005c
            androidx.compose.ui.Modifier$Node r0 = r3.getNode()
            r1 = r3
            androidx.compose.ui.Modifier$Node r1 = (androidx.compose.ui.Modifier.Node) r1
        L_0x0022:
            if (r1 == 0) goto L_0x0033
            int r2 = r1.getKindSet$ui_release()
            r4 = r4 | r2
            r1.setKindSet$ui_release(r4)
            if (r1 == r0) goto L_0x0033
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x0022
        L_0x0033:
            if (r5 == 0) goto L_0x003e
            if (r1 != r0) goto L_0x003e
            int r4 = androidx.compose.ui.node.NodeKindKt.calculateNodeKindSetFromIncludingDelegates(r0)
            r0.setKindSet$ui_release(r4)
        L_0x003e:
            if (r1 == 0) goto L_0x004b
            androidx.compose.ui.Modifier$Node r5 = r1.getChild$ui_release()
            if (r5 == 0) goto L_0x004b
            int r5 = r5.getAggregateChildKindSet$ui_release()
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            r4 = r4 | r5
        L_0x004d:
            if (r1 == 0) goto L_0x005c
            int r5 = r1.getKindSet$ui_release()
            r4 = r4 | r5
            r1.setAggregateChildKindSet$ui_release(r4)
            androidx.compose.ui.Modifier$Node r1 = r1.getParent$ui_release()
            goto L_0x004d
        L_0x005c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.DelegatingNode.updateNodeKindSet(int, boolean):void");
    }

    public final void forEachImmediateDelegate$ui_release(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            function1.invoke(delegate$ui_release);
        }
    }

    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.updateCoordinator$ui_release(getCoordinator$ui_release());
            if (!delegate$ui_release.isAttached()) {
                delegate$ui_release.markAsAttached$ui_release();
            }
        }
    }

    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.runDetachLifecycle$ui_release();
        }
    }

    public void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.reset$ui_release();
        }
    }

    public void runAttachLifecycle$ui_release() {
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    public void markAsDetached$ui_release() {
        for (Modifier.Node delegate$ui_release = getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
            delegate$ui_release.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }
}
