package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.layout.ModifierInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u001c\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0002mnB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010(\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J?\u0010,\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020\u001901H\bø\u0001\u0000¢\u0006\u0004\b2\u00103J@\u00104\u001a\u00060\rR\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u00108\u001a\u00020\u0019H\u0002J\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J\u001e\u0010<\u001a\u00020\u00192\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/H\u0000ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u0015\u0010<\u001a\u00020\u00192\u0006\u0010?\u001a\u00020\u0006H\u0000¢\u0006\u0002\b@J+\u0010\u0011\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/H\bø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\"\u0010C\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\b¢\u0006\u0002\bEJ=\u0010C\u001a\u00020D\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000¢\u0006\u0004\bF\u0010GJ*\u0010C\u001a\u00020D2\u0006\u0010?\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\b¢\u0006\u0002\bEJ\"\u0010H\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\b¢\u0006\u0002\bIJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0018\u0010K\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0006\u0010L\u001a\u00020DJ\r\u0010M\u001a\u00020DH\u0000¢\u0006\u0002\bNJ\b\u0010O\u001a\u00020\u0010H\u0002J\u0018\u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u001fH\u0002J\u0010\u0010S\u001a\u00020\u00102\u0006\u0010+\u001a\u00020\u0010H\u0002J\r\u0010T\u001a\u00020DH\u0000¢\u0006\u0002\bUJ\u0006\u0010V\u001a\u00020DJ\r\u0010W\u001a\u00020DH\u0000¢\u0006\u0002\bXJ<\u0010Y\u001a\u00020D2\u0006\u00105\u001a\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010#\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u0019H\u0002J\b\u0010Z\u001a\u00020DH\u0002J\u0006\u0010[\u001a\u00020DJ+\u0010#\u001a\u0004\u0018\u0001H-\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/H\bø\u0001\u0000¢\u0006\u0004\b\\\u0010BJ\"\u0010]\u001a\u00020D2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\b¢\u0006\u0002\b^J=\u0010]\u001a\u00020D\"\u0006\b\u0000\u0010-\u0018\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H-0/2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u00020D01H\bø\u0001\u0000¢\u0006\u0004\b_\u0010GJ*\u0010]\u001a\u00020D2\u0006\u0010?\u001a\u00020\u00062\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020D01H\b¢\u0006\u0002\b^J\b\u0010`\u001a\u00020aH\u0016J\u0010\u0010b\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\u0010H\u0002J\u0015\u0010d\u001a\u00020D2\u0006\u0010e\u001a\u00020fH\u0000¢\u0006\u0002\bgJ \u0010h\u001a\u00020D2\u0006\u0010i\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0010H\u0002J\u0017\u0010k\u001a\u00020D2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\blR\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006o"}, d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "buffer", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "current", "<set-?>", "Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "isUpdating", "", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "getTail$ui_release", "createAndInsertNodeAsChild", "element", "parent", "createAndInsertNodeAsParent", "child", "detachAndRemoveNode", "node", "firstFromHead", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getDiffer", "offset", "before", "after", "shouldAttachOnInsert", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "has", "has-H91voCI$ui_release", "(I)Z", "mask", "has$ui_release", "head-H91voCI$ui_release", "(I)Ljava/lang/Object;", "headToTail", "", "headToTail$ui_release", "headToTail-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "headToTailExclusive", "headToTailExclusive$ui_release", "insertChild", "insertParent", "markAsAttached", "markAsDetached", "markAsDetached$ui_release", "padChain", "propagateCoordinator", "start", "coordinator", "removeNode", "resetState", "resetState$ui_release", "runAttachLifecycle", "runDetachLifecycle", "runDetachLifecycle$ui_release", "structuralUpdate", "syncAggregateChildKindSet", "syncCoordinators", "tail-H91voCI$ui_release", "tailToHead", "tailToHead$ui_release", "tailToHead-aLcG6gQ$ui_release", "toString", "", "trimChain", "paddedHead", "updateFrom", "m", "Landroidx/compose/ui/Modifier;", "updateFrom$ui_release", "updateNode", "prev", "next", "useLogger", "useLogger$ui_release", "Differ", "Logger", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NodeChain.kt */
public final class NodeChain {
    public static final int $stable = 8;
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    /* access modifiers changed from: private */
    public Logger logger;
    private NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0015À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", "index", "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeInserted", "atIndex", "newIndex", "element", "child", "inserted", "nodeRemoved", "oldIndex", "nodeReused", "nodeUpdated", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeChain.kt */
    public interface Logger {
        void linearDiffAborted(int i, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeInserted(int i, int i2, Modifier.Element element, Modifier.Node node, Modifier.Node node2);

        void nodeRemoved(int i, Modifier.Element element, Modifier.Node node);

        void nodeReused(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node);

        void nodeUpdated(int i, int i2, Modifier.Element element, Modifier.Element element2, Modifier.Node node);
    }

    public NodeChain(LayoutNode layoutNode2) {
        this.layoutNode = layoutNode2;
        InnerNodeCoordinator innerNodeCoordinator = new InnerNodeCoordinator(layoutNode2);
        this.innerCoordinator = innerNodeCoordinator;
        this.outerCoordinator = innerNodeCoordinator;
        Modifier.Node tail2 = innerNodeCoordinator.getTail();
        this.tail = tail2;
        this.head = tail2;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final InnerNodeCoordinator getInnerCoordinator$ui_release() {
        return this.innerCoordinator;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.outerCoordinator;
    }

    public final Modifier.Node getTail$ui_release() {
        return this.tail;
    }

    public final Modifier.Node getHead$ui_release() {
        return this.head;
    }

    private final boolean isUpdating() {
        return this.head == NodeChainKt.SentinelHead;
    }

    /* access modifiers changed from: private */
    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet$ui_release();
    }

    public final void useLogger$ui_release(Logger logger2) {
        this.logger = logger2;
    }

    private final Modifier.Node padChain() {
        if (this.head != NodeChainKt.SentinelHead) {
            Modifier.Node node = this.head;
            node.setParent$ui_release(NodeChainKt.SentinelHead);
            NodeChainKt.SentinelHead.setChild$ui_release(node);
            return NodeChainKt.SentinelHead;
        }
        throw new IllegalStateException("padChain called on already padded chain".toString());
    }

    private final Modifier.Node trimChain(Modifier.Node node) {
        if (node == NodeChainKt.SentinelHead) {
            Modifier.Node child$ui_release = NodeChainKt.SentinelHead.getChild$ui_release();
            if (child$ui_release == null) {
                child$ui_release = this.tail;
            }
            child$ui_release.setParent$ui_release((Modifier.Node) null);
            NodeChainKt.SentinelHead.setChild$ui_release((Modifier.Node) null);
            NodeChainKt.SentinelHead.setAggregateChildKindSet$ui_release(-1);
            NodeChainKt.SentinelHead.updateCoordinator$ui_release((NodeCoordinator) null);
            if (child$ui_release != NodeChainKt.SentinelHead) {
                return child$ui_release;
            }
            throw new IllegalStateException("trimChain did not update the head".toString());
        }
        throw new IllegalStateException("trimChain called on already trimmed chain".toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateFrom$ui_release(androidx.compose.ui.Modifier r19) {
        /*
            r18 = this;
            r6 = r18
            androidx.compose.ui.Modifier$Node r7 = r18.padChain()
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.Modifier$Element> r8 = r6.current
            r0 = 0
            if (r8 == 0) goto L_0x0010
            int r1 = r8.getSize()
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.Modifier$Element> r2 = r6.buffer
            r3 = 16
            if (r2 != 0) goto L_0x001e
            androidx.compose.runtime.collection.MutableVector r2 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Element[] r4 = new androidx.compose.ui.Modifier.Element[r3]
            r2.<init>(r4, r0)
        L_0x001e:
            r4 = r19
            androidx.compose.runtime.collection.MutableVector r9 = androidx.compose.ui.node.NodeChainKt.fillVector(r4, r2)
            int r2 = r9.getSize()
            r10 = 0
            java.lang.String r4 = "expected prior modifier list to be non-empty"
            r11 = 1
            if (r2 != r1) goto L_0x00c2
            androidx.compose.ui.Modifier$Node r2 = r7.getChild$ui_release()
            r3 = r2
            r2 = r0
        L_0x0034:
            if (r3 == 0) goto L_0x0092
            if (r2 >= r1) goto L_0x0092
            if (r8 == 0) goto L_0x0088
            java.lang.Object[] r5 = r8.getContent()
            r5 = r5[r2]
            r15 = r5
            androidx.compose.ui.Modifier$Element r15 = (androidx.compose.ui.Modifier.Element) r15
            java.lang.Object[] r5 = r9.getContent()
            r5 = r5[r2]
            androidx.compose.ui.Modifier$Element r5 = (androidx.compose.ui.Modifier.Element) r5
            int r12 = androidx.compose.ui.node.NodeChainKt.actionForModifiers(r15, r5)
            if (r12 == 0) goto L_0x007c
            if (r12 == r11) goto L_0x0065
            r13 = 2
            if (r12 == r13) goto L_0x0057
            goto L_0x0075
        L_0x0057:
            androidx.compose.ui.node.NodeChain$Logger r12 = r6.logger
            if (r12 == 0) goto L_0x0075
            r13 = r2
            r14 = r2
            r16 = r5
            r17 = r3
            r12.nodeReused(r13, r14, r15, r16, r17)
            goto L_0x0075
        L_0x0065:
            r6.updateNode(r15, r5, r3)
            androidx.compose.ui.node.NodeChain$Logger r12 = r6.logger
            if (r12 == 0) goto L_0x0075
            r13 = r2
            r14 = r2
            r16 = r5
            r17 = r3
            r12.nodeUpdated(r13, r14, r15, r16, r17)
        L_0x0075:
            androidx.compose.ui.Modifier$Node r3 = r3.getChild$ui_release()
            int r2 = r2 + 1
            goto L_0x0034
        L_0x007c:
            androidx.compose.ui.node.NodeChain$Logger r12 = r6.logger
            if (r12 == 0) goto L_0x0083
            r12.linearDiffAborted(r2, r15, r5, r3)
        L_0x0083:
            androidx.compose.ui.Modifier$Node r3 = r3.getParent$ui_release()
            goto L_0x0092
        L_0x0088:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x0092:
            r5 = r3
            if (r2 >= r1) goto L_0x0162
            if (r8 == 0) goto L_0x00b8
            if (r5 == 0) goto L_0x00ab
            androidx.compose.ui.node.LayoutNode r0 = r6.layoutNode
            boolean r12 = r0.isAttached()
            r0 = r18
            r1 = r2
            r2 = r8
            r3 = r9
            r4 = r5
            r5 = r12
            r0.structuralUpdate(r1, r2, r3, r4, r5)
            goto L_0x0161
        L_0x00ab:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "structuralUpdate requires a non-null tail"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00b8:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x00c2:
            androidx.compose.ui.node.LayoutNode r2 = r6.layoutNode
            boolean r2 = r2.isAttached()
            if (r2 != 0) goto L_0x00f6
            if (r1 != 0) goto L_0x00f6
            r1 = r7
        L_0x00cd:
            int r2 = r9.getSize()
            if (r0 >= r2) goto L_0x00f1
            java.lang.Object[] r2 = r9.getContent()
            r2 = r2[r0]
            r15 = r2
            androidx.compose.ui.Modifier$Element r15 = (androidx.compose.ui.Modifier.Element) r15
            androidx.compose.ui.Modifier$Node r2 = r6.createAndInsertNodeAsChild(r15, r1)
            androidx.compose.ui.node.NodeChain$Logger r12 = r6.logger
            if (r12 == 0) goto L_0x00ed
            r13 = 0
            r14 = r0
            r16 = r1
            r17 = r2
            r12.nodeInserted(r13, r14, r15, r16, r17)
        L_0x00ed:
            int r0 = r0 + 1
            r1 = r2
            goto L_0x00cd
        L_0x00f1:
            r18.syncAggregateChildKindSet()
            goto L_0x0161
        L_0x00f6:
            int r1 = r9.getSize()
            if (r1 != 0) goto L_0x0149
            if (r8 == 0) goto L_0x013f
            androidx.compose.ui.Modifier$Node r1 = r7.getChild$ui_release()
            r2 = r0
        L_0x0103:
            if (r1 == 0) goto L_0x0125
            int r3 = r8.getSize()
            if (r2 >= r3) goto L_0x0125
            androidx.compose.ui.node.NodeChain$Logger r3 = r6.logger
            if (r3 == 0) goto L_0x011a
            java.lang.Object[] r4 = r8.getContent()
            r4 = r4[r2]
            androidx.compose.ui.Modifier$Element r4 = (androidx.compose.ui.Modifier.Element) r4
            r3.nodeRemoved(r2, r4, r1)
        L_0x011a:
            androidx.compose.ui.Modifier$Node r1 = r6.detachAndRemoveNode(r1)
            androidx.compose.ui.Modifier$Node r1 = r1.getChild$ui_release()
            int r2 = r2 + 1
            goto L_0x0103
        L_0x0125:
            androidx.compose.ui.node.InnerNodeCoordinator r1 = r6.innerCoordinator
            androidx.compose.ui.node.LayoutNode r2 = r6.layoutNode
            androidx.compose.ui.node.LayoutNode r2 = r2.getParent$ui_release()
            if (r2 == 0) goto L_0x0134
            androidx.compose.ui.node.NodeCoordinator r2 = r2.getInnerCoordinator$ui_release()
            goto L_0x0135
        L_0x0134:
            r2 = r10
        L_0x0135:
            r1.setWrappedBy$ui_release(r2)
            androidx.compose.ui.node.InnerNodeCoordinator r1 = r6.innerCoordinator
            androidx.compose.ui.node.NodeCoordinator r1 = (androidx.compose.ui.node.NodeCoordinator) r1
            r6.outerCoordinator = r1
            goto L_0x0162
        L_0x013f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r4.toString()
            r0.<init>(r1)
            throw r0
        L_0x0149:
            if (r8 != 0) goto L_0x0152
            androidx.compose.runtime.collection.MutableVector r8 = new androidx.compose.runtime.collection.MutableVector
            androidx.compose.ui.Modifier$Element[] r1 = new androidx.compose.ui.Modifier.Element[r3]
            r8.<init>(r1, r0)
        L_0x0152:
            androidx.compose.ui.node.LayoutNode r0 = r6.layoutNode
            boolean r5 = r0.isAttached()
            r1 = 0
            r0 = r18
            r2 = r8
            r3 = r9
            r4 = r7
            r0.structuralUpdate(r1, r2, r3, r4, r5)
        L_0x0161:
            r0 = r11
        L_0x0162:
            r6.current = r9
            if (r8 == 0) goto L_0x016a
            r8.clear()
            r10 = r8
        L_0x016a:
            r6.buffer = r10
            androidx.compose.ui.Modifier$Node r1 = r6.trimChain(r7)
            r6.head = r1
            if (r0 == 0) goto L_0x0177
            r18.syncCoordinators()
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeChain.updateFrom$ui_release(androidx.compose.ui.Modifier):void");
    }

    public final void syncCoordinators() {
        LayoutModifierNodeCoordinator layoutModifierNodeCoordinator;
        NodeCoordinator nodeCoordinator = this.innerCoordinator;
        for (Modifier.Node parent$ui_release = this.tail.getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
            LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(parent$ui_release);
            if (asLayoutModifierNode != null) {
                if (parent$ui_release.getCoordinator$ui_release() != null) {
                    NodeCoordinator coordinator$ui_release = parent$ui_release.getCoordinator$ui_release();
                    Intrinsics.checkNotNull(coordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) coordinator$ui_release;
                    LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
                    layoutModifierNodeCoordinator.setLayoutModifierNode$ui_release(asLayoutModifierNode);
                    if (layoutModifierNode != parent$ui_release) {
                        layoutModifierNodeCoordinator.onLayoutModifierNodeChanged();
                    }
                } else {
                    layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(this.layoutNode, asLayoutModifierNode);
                    parent$ui_release.updateCoordinator$ui_release(layoutModifierNodeCoordinator);
                }
                NodeCoordinator nodeCoordinator2 = layoutModifierNodeCoordinator;
                nodeCoordinator.setWrappedBy$ui_release(nodeCoordinator2);
                layoutModifierNodeCoordinator.setWrapped$ui_release(nodeCoordinator);
                nodeCoordinator = nodeCoordinator2;
            } else {
                parent$ui_release.updateCoordinator$ui_release(nodeCoordinator);
            }
        }
        LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
        nodeCoordinator.setWrappedBy$ui_release(parent$ui_release2 != null ? parent$ui_release2.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = nodeCoordinator;
    }

    private final void syncAggregateChildKindSet() {
        Modifier.Node parent$ui_release = this.tail.getParent$ui_release();
        int i = 0;
        while (parent$ui_release != null && parent$ui_release != NodeChainKt.SentinelHead) {
            i |= parent$ui_release.getKindSet$ui_release();
            parent$ui_release.setAggregateChildKindSet$ui_release(i);
            parent$ui_release = parent$ui_release.getParent$ui_release();
        }
    }

    public final List<ModifierInfo> getModifierInfo() {
        MutableVector<Modifier.Element> mutableVector = this.current;
        if (mutableVector == null) {
            return CollectionsKt.emptyList();
        }
        int i = 0;
        MutableVector mutableVector2 = new MutableVector(new ModifierInfo[mutableVector.getSize()], 0);
        Modifier.Node head$ui_release = getHead$ui_release();
        while (head$ui_release != null && head$ui_release != getTail$ui_release()) {
            NodeCoordinator coordinator$ui_release = head$ui_release.getCoordinator$ui_release();
            if (coordinator$ui_release != null) {
                OwnedLayer layer = coordinator$ui_release.getLayer();
                OwnedLayer layer2 = this.innerCoordinator.getLayer();
                Modifier.Node child$ui_release = head$ui_release.getChild$ui_release();
                if (child$ui_release != this.tail || head$ui_release.getCoordinator$ui_release() == child$ui_release.getCoordinator$ui_release()) {
                    layer2 = null;
                }
                if (layer == null) {
                    layer = layer2;
                }
                mutableVector2.add(new ModifierInfo((Modifier) mutableVector.getContent()[i], coordinator$ui_release, layer));
                head$ui_release = head$ui_release.getChild$ui_release();
                i++;
            } else {
                throw new IllegalArgumentException("getModifierInfo called on node with no coordinator".toString());
            }
        }
        return mutableVector2.asMutableList();
    }

    private final Differ getDiffer(Modifier.Node node, int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, boolean z) {
        Differ differ = this.cachedDiffer;
        if (differ == null) {
            Differ differ2 = new Differ(node, i, mutableVector, mutableVector2, z);
            this.cachedDiffer = differ2;
            return differ2;
        }
        differ.setNode(node);
        differ.setOffset(i);
        differ.setBefore(mutableVector);
        differ.setAfter(mutableVector2);
        differ.setShouldAttachOnInsert(z);
        return differ;
    }

    /* access modifiers changed from: private */
    public final void propagateCoordinator(Modifier.Node node, NodeCoordinator nodeCoordinator) {
        Modifier.Node parent$ui_release = node.getParent$ui_release();
        while (parent$ui_release != null) {
            if (parent$ui_release == NodeChainKt.SentinelHead) {
                LayoutNode parent$ui_release2 = this.layoutNode.getParent$ui_release();
                nodeCoordinator.setWrappedBy$ui_release(parent$ui_release2 != null ? parent$ui_release2.getInnerCoordinator$ui_release() : null);
                this.outerCoordinator = nodeCoordinator;
                return;
            } else if ((NodeKind.m5647constructorimpl(2) & parent$ui_release.getKindSet$ui_release()) == 0) {
                parent$ui_release.updateCoordinator$ui_release(nodeCoordinator);
                parent$ui_release = parent$ui_release.getParent$ui_release();
            } else {
                return;
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", "offset", "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "shouldAttachOnInsert", "", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;Z)V", "getAfter", "()Landroidx/compose/runtime/collection/MutableVector;", "setAfter", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getBefore", "setBefore", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "getOffset", "()I", "setOffset", "(I)V", "getShouldAttachOnInsert", "()Z", "setShouldAttachOnInsert", "(Z)V", "areItemsTheSame", "oldIndex", "newIndex", "insert", "", "remove", "atIndex", "same", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NodeChain.kt */
    private final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        private int offset;
        private boolean shouldAttachOnInsert;

        public Differ(Modifier.Node node2, int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, boolean z) {
            this.node = node2;
            this.offset = i;
            this.before = mutableVector;
            this.after = mutableVector2;
            this.shouldAttachOnInsert = z;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final void setNode(Modifier.Node node2) {
            this.node = node2;
        }

        public final int getOffset() {
            return this.offset;
        }

        public final void setOffset(int i) {
            this.offset = i;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            this.before = mutableVector;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            this.after = mutableVector;
        }

        public final boolean getShouldAttachOnInsert() {
            return this.shouldAttachOnInsert;
        }

        public final void setShouldAttachOnInsert(boolean z) {
            this.shouldAttachOnInsert = z;
        }

        public boolean areItemsTheSame(int i, int i2) {
            return NodeChainKt.actionForModifiers((Modifier.Element) this.before.getContent()[this.offset + i], (Modifier.Element) this.after.getContent()[this.offset + i2]) != 0;
        }

        public void insert(int i) {
            int i2 = this.offset + i;
            Modifier.Node node2 = this.node;
            this.node = NodeChain.this.createAndInsertNodeAsChild((Modifier.Element) this.after.getContent()[i2], node2);
            Logger access$getLogger$p = NodeChain.this.logger;
            if (access$getLogger$p != null) {
                access$getLogger$p.nodeInserted(i2, i2, (Modifier.Element) this.after.getContent()[i2], node2, this.node);
            }
            if (this.shouldAttachOnInsert) {
                Modifier.Node child$ui_release = this.node.getChild$ui_release();
                Intrinsics.checkNotNull(child$ui_release);
                NodeCoordinator coordinator$ui_release = child$ui_release.getCoordinator$ui_release();
                Intrinsics.checkNotNull(coordinator$ui_release);
                LayoutModifierNode asLayoutModifierNode = DelegatableNodeKt.asLayoutModifierNode(this.node);
                if (asLayoutModifierNode != null) {
                    LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = new LayoutModifierNodeCoordinator(NodeChain.this.getLayoutNode(), asLayoutModifierNode);
                    NodeCoordinator nodeCoordinator = layoutModifierNodeCoordinator;
                    this.node.updateCoordinator$ui_release(nodeCoordinator);
                    NodeChain.this.propagateCoordinator(this.node, nodeCoordinator);
                    layoutModifierNodeCoordinator.setWrappedBy$ui_release(coordinator$ui_release.getWrappedBy$ui_release());
                    layoutModifierNodeCoordinator.setWrapped$ui_release(coordinator$ui_release);
                    coordinator$ui_release.setWrappedBy$ui_release(nodeCoordinator);
                } else {
                    this.node.updateCoordinator$ui_release(coordinator$ui_release);
                }
                this.node.markAsAttached$ui_release();
                this.node.runAttachLifecycle$ui_release();
                NodeKindKt.autoInvalidateInsertedNode(this.node);
                return;
            }
            this.node.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
        }

        public void remove(int i, int i2) {
            Modifier.Node child$ui_release = this.node.getChild$ui_release();
            Intrinsics.checkNotNull(child$ui_release);
            Logger access$getLogger$p = NodeChain.this.logger;
            if (access$getLogger$p != null) {
                access$getLogger$p.nodeRemoved(i2, (Modifier.Element) this.before.getContent()[this.offset + i2], child$ui_release);
            }
            if ((NodeKind.m5647constructorimpl(2) & child$ui_release.getKindSet$ui_release()) != 0) {
                NodeCoordinator coordinator$ui_release = child$ui_release.getCoordinator$ui_release();
                Intrinsics.checkNotNull(coordinator$ui_release);
                NodeCoordinator wrappedBy$ui_release = coordinator$ui_release.getWrappedBy$ui_release();
                NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped$ui_release();
                Intrinsics.checkNotNull(wrapped$ui_release);
                if (wrappedBy$ui_release != null) {
                    wrappedBy$ui_release.setWrapped$ui_release(wrapped$ui_release);
                }
                wrapped$ui_release.setWrappedBy$ui_release(wrappedBy$ui_release);
                NodeChain.this.propagateCoordinator(this.node, wrapped$ui_release);
            }
            this.node = NodeChain.this.detachAndRemoveNode(child$ui_release);
        }

        public void same(int i, int i2) {
            Modifier.Node child$ui_release = this.node.getChild$ui_release();
            Intrinsics.checkNotNull(child$ui_release);
            this.node = child$ui_release;
            Modifier.Element element = (Modifier.Element) this.before.getContent()[this.offset + i];
            Modifier.Element element2 = (Modifier.Element) this.after.getContent()[this.offset + i2];
            if (!Intrinsics.areEqual((Object) element, (Object) element2)) {
                NodeChain.this.updateNode(element, element2, this.node);
                Logger access$getLogger$p = NodeChain.this.logger;
                if (access$getLogger$p != null) {
                    int i3 = this.offset;
                    access$getLogger$p.nodeUpdated(i3 + i, i3 + i2, element, element2, this.node);
                    return;
                }
                return;
            }
            Logger access$getLogger$p2 = NodeChain.this.logger;
            if (access$getLogger$p2 != null) {
                int i4 = this.offset;
                access$getLogger$p2.nodeReused(i4 + i, i4 + i2, element, element2, this.node);
            }
        }
    }

    private final void structuralUpdate(int i, MutableVector<Modifier.Element> mutableVector, MutableVector<Modifier.Element> mutableVector2, Modifier.Node node, boolean z) {
        MyersDiffKt.executeDiff(mutableVector.getSize() - i, mutableVector2.getSize() - i, getDiffer(node, i, mutableVector, mutableVector2, z));
        syncAggregateChildKindSet();
    }

    /* access modifiers changed from: private */
    public final Modifier.Node detachAndRemoveNode(Modifier.Node node) {
        if (node.isAttached()) {
            NodeKindKt.autoInvalidateRemovedNode(node);
            node.runDetachLifecycle$ui_release();
            node.markAsDetached$ui_release();
        }
        return removeNode(node);
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child$ui_release = node.getChild$ui_release();
        Modifier.Node parent$ui_release = node.getParent$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(parent$ui_release);
            node.setChild$ui_release((Modifier.Node) null);
        }
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(child$ui_release);
            node.setParent$ui_release((Modifier.Node) null);
        }
        Intrinsics.checkNotNull(parent$ui_release);
        return parent$ui_release;
    }

    private final Modifier.Node createAndInsertNodeAsParent(Modifier.Element element, Modifier.Node node) {
        Modifier.Node node2;
        if (element instanceof ModifierNodeElement) {
            node2 = ((ModifierNodeElement) element).create();
            node2.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node2));
        } else {
            node2 = new BackwardsCompatNode(element);
        }
        if (!node2.isAttached()) {
            node2.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
            return insertParent(node2, node);
        }
        throw new IllegalStateException("createAndInsertNodeAsParent called on an attached node".toString());
    }

    private final Modifier.Node insertParent(Modifier.Node node, Modifier.Node node2) {
        Modifier.Node parent$ui_release = node2.getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.setChild$ui_release(node);
            node.setParent$ui_release(parent$ui_release);
        }
        node2.setParent$ui_release(node);
        node.setChild$ui_release(node2);
        return node;
    }

    /* access modifiers changed from: private */
    public final Modifier.Node createAndInsertNodeAsChild(Modifier.Element element, Modifier.Node node) {
        Modifier.Node node2;
        if (element instanceof ModifierNodeElement) {
            node2 = ((ModifierNodeElement) element).create();
            node2.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node2));
        } else {
            node2 = new BackwardsCompatNode(element);
        }
        if (!node2.isAttached()) {
            node2.setInsertedNodeAwaitingAttachForInvalidation$ui_release(true);
            return insertChild(node2, node);
        }
        throw new IllegalStateException("A ModifierNodeElement cannot return an already attached node from create() ".toString());
    }

    private final Modifier.Node insertChild(Modifier.Node node, Modifier.Node node2) {
        Modifier.Node child$ui_release = node2.getChild$ui_release();
        if (child$ui_release != null) {
            child$ui_release.setParent$ui_release(node);
            node.setChild$ui_release(child$ui_release);
        }
        node2.setChild$ui_release(node);
        node.setParent$ui_release(node2);
        return node;
    }

    /* access modifiers changed from: private */
    public final void updateNode(Modifier.Element element, Modifier.Element element2, Modifier.Node node) {
        if ((element instanceof ModifierNodeElement) && (element2 instanceof ModifierNodeElement)) {
            NodeChainKt.updateUnsafe((ModifierNodeElement) element2, node);
            if (node.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
            }
        } else if (node instanceof BackwardsCompatNode) {
            ((BackwardsCompatNode) node).setElement(element2);
            if (node.isAttached()) {
                NodeKindKt.autoInvalidateUpdatedNode(node);
            } else {
                node.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(true);
            }
        } else {
            throw new IllegalStateException("Unknown Modifier.Node type".toString());
        }
    }

    public final void headToTail$ui_release(int i, Function1<? super Modifier.Node, Unit> function1) {
        if ((getAggregateChildKindSet() & i) != 0) {
            Modifier.Node head$ui_release = getHead$ui_release();
            while (head$ui_release != null) {
                if ((head$ui_release.getKindSet$ui_release() & i) != 0) {
                    function1.invoke(head$ui_release);
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                    head$ui_release = head$ui_release.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final void headToTail$ui_release(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            function1.invoke(head$ui_release);
        }
    }

    public final void headToTailExclusive$ui_release(Function1<? super Modifier.Node, Unit> function1) {
        Modifier.Node head$ui_release = getHead$ui_release();
        while (head$ui_release != null && head$ui_release != getTail$ui_release()) {
            function1.invoke(head$ui_release);
            head$ui_release = head$ui_release.getChild$ui_release();
        }
    }

    public final void tailToHead$ui_release(int i, Function1<? super Modifier.Node, Unit> function1) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if ((tail$ui_release.getKindSet$ui_release() & i) != 0) {
                    function1.invoke(tail$ui_release);
                }
            }
        }
    }

    public final void tailToHead$ui_release(Function1<? super Modifier.Node, Unit> function1) {
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            function1.invoke(tail$ui_release);
        }
    }

    /* renamed from: has-H91voCI$ui_release  reason: not valid java name */
    public final boolean m5597hasH91voCI$ui_release(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    public final boolean has$ui_release(int i) {
        return (i & getAggregateChildKindSet()) != 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (this.head != this.tail) {
            Modifier.Node head$ui_release = getHead$ui_release();
            while (true) {
                if (head$ui_release == null || head$ui_release == getTail$ui_release()) {
                    break;
                }
                sb.append(String.valueOf(head$ui_release));
                if (head$ui_release.getChild$ui_release() == this.tail) {
                    sb.append("]");
                    break;
                }
                sb.append(",");
                head$ui_release = head$ui_release.getChild$ui_release();
            }
        } else {
            sb.append("]");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void resetState$ui_release() {
        int size;
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if (tail$ui_release.isAttached()) {
                tail$ui_release.reset$ui_release();
            }
        }
        MutableVector<Modifier.Element> mutableVector = this.current;
        if (mutableVector == null || (size = mutableVector.getSize()) <= 0) {
            runDetachLifecycle$ui_release();
            markAsDetached$ui_release();
        }
        Object[] content = mutableVector.getContent();
        int i = 0;
        do {
            Modifier.Element element = (Modifier.Element) content[i];
            if (element instanceof SuspendPointerInputElement) {
                mutableVector.set(i, new ForceUpdateElement((ModifierNodeElement) element));
            }
            i++;
        } while (i < size);
        runDetachLifecycle$ui_release();
        markAsDetached$ui_release();
    }

    public final void markAsAttached() {
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            head$ui_release.markAsAttached$ui_release();
        }
    }

    public final void runAttachLifecycle() {
        for (Modifier.Node head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            head$ui_release.runAttachLifecycle$ui_release();
            if (head$ui_release.getInsertedNodeAwaitingAttachForInvalidation$ui_release()) {
                NodeKindKt.autoInvalidateInsertedNode(head$ui_release);
            }
            if (head$ui_release.getUpdatedNodeAwaitingAttachForInvalidation$ui_release()) {
                NodeKindKt.autoInvalidateUpdatedNode(head$ui_release);
            }
            head$ui_release.setInsertedNodeAwaitingAttachForInvalidation$ui_release(false);
            head$ui_release.setUpdatedNodeAwaitingAttachForInvalidation$ui_release(false);
        }
    }

    public final void markAsDetached$ui_release() {
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if (tail$ui_release.isAttached()) {
                tail$ui_release.markAsDetached$ui_release();
            }
        }
    }

    public final void runDetachLifecycle$ui_release() {
        for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if (tail$ui_release.isAttached()) {
                tail$ui_release.runDetachLifecycle$ui_release();
            }
        }
    }

    /* renamed from: firstFromHead-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m5596firstFromHeadaLcG6gQ$ui_release(int i, Function1<? super T, Boolean> function1) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (T head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                Modifier.Node node = (Modifier.Node) head$ui_release;
                if ((head$ui_release.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = (Modifier.Node) head$ui_release;
                    T t = head$ui_release;
                    MutableVector mutableVector = null;
                    while (t != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (!(t instanceof Object)) {
                            Modifier.Node node3 = (Modifier.Node) t;
                            if ((t.getKindSet$ui_release() & i) != 0 && (t instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (T delegate$ui_release = ((DelegatingNode) t).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    Modifier.Node node4 = (Modifier.Node) delegate$ui_release;
                                    if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            t = delegate$ui_release;
                                        } else {
                                            MutableVector mutableVector2 = mutableVector;
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector3 = mutableVector;
                                            }
                                            Modifier.Node node5 = (Modifier.Node) t;
                                            if (t != null) {
                                                MutableVector mutableVector4 = mutableVector;
                                                if (mutableVector != null) {
                                                    mutableVector.add(t);
                                                }
                                                t = null;
                                            }
                                            MutableVector mutableVector5 = mutableVector;
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                        } else if (function1.invoke(t).booleanValue()) {
                            return t;
                        }
                        MutableVector mutableVector6 = mutableVector;
                        t = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
                    break;
                }
            }
        }
        return null;
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> void m5599headToTailaLcG6gQ$ui_release(int i, Function1<? super T, Unit> function1) {
        if ((getAggregateChildKindSet() & i) != 0) {
            Modifier.Node head$ui_release = getHead$ui_release();
            while (head$ui_release != null) {
                Modifier.Node node = head$ui_release;
                if ((head$ui_release.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = head$ui_release;
                    Modifier.Node node3 = head$ui_release;
                    MutableVector mutableVector = null;
                    while (node3 != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node3 instanceof Object) {
                            function1.invoke(node3);
                        } else {
                            Modifier.Node node4 = node3;
                            if ((node3.getKindSet$ui_release() & i) != 0 && (node3 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    Modifier.Node node5 = delegate$ui_release;
                                    if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node3 = delegate$ui_release;
                                        } else {
                                            MutableVector mutableVector2 = mutableVector;
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector3 = mutableVector;
                                            }
                                            Modifier.Node node6 = node3;
                                            if (node3 != null) {
                                                MutableVector mutableVector4 = mutableVector;
                                                if (mutableVector != null) {
                                                    mutableVector.add(node3);
                                                }
                                                node3 = null;
                                            }
                                            MutableVector mutableVector5 = mutableVector;
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                        }
                        MutableVector mutableVector6 = mutableVector;
                        node3 = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) != 0) {
                    head$ui_release = head$ui_release.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> void m5601tailToHeadaLcG6gQ$ui_release(int i, Function1<? super T, Unit> function1) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                Modifier.Node node = tail$ui_release;
                if ((tail$ui_release.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = tail$ui_release;
                    Modifier.Node node3 = tail$ui_release;
                    MutableVector mutableVector = null;
                    while (node3 != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (node3 instanceof Object) {
                            function1.invoke(node3);
                        } else {
                            Modifier.Node node4 = node3;
                            if ((node3.getKindSet$ui_release() & i) != 0 && (node3 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                    Modifier.Node node5 = delegate$ui_release;
                                    if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node3 = delegate$ui_release;
                                        } else {
                                            MutableVector mutableVector2 = mutableVector;
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                MutableVector mutableVector3 = mutableVector;
                                            }
                                            Modifier.Node node6 = node3;
                                            if (node3 != null) {
                                                MutableVector mutableVector4 = mutableVector;
                                                if (mutableVector != null) {
                                                    mutableVector.add(node3);
                                                }
                                                node3 = null;
                                            }
                                            MutableVector mutableVector5 = mutableVector;
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                        }
                        MutableVector mutableVector6 = mutableVector;
                        node3 = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
    }

    /* renamed from: tail-H91voCI$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m5600tailH91voCI$ui_release(int i) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (T tail$ui_release = getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                Modifier.Node node = (Modifier.Node) tail$ui_release;
                if ((tail$ui_release.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = (Modifier.Node) tail$ui_release;
                    T t = tail$ui_release;
                    MutableVector mutableVector = null;
                    while (t != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (t instanceof Object) {
                            return t;
                        }
                        Modifier.Node node3 = (Modifier.Node) t;
                        if ((t.getKindSet$ui_release() & i) != 0 && (t instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (T delegate$ui_release = ((DelegatingNode) t).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                Modifier.Node node4 = (Modifier.Node) delegate$ui_release;
                                if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                    i2++;
                                    if (i2 == 1) {
                                        t = delegate$ui_release;
                                    } else {
                                        MutableVector mutableVector2 = mutableVector;
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            MutableVector mutableVector3 = mutableVector;
                                        }
                                        Modifier.Node node5 = (Modifier.Node) t;
                                        if (t != null) {
                                            MutableVector mutableVector4 = mutableVector;
                                            if (mutableVector != null) {
                                                mutableVector.add(t);
                                            }
                                            t = null;
                                        }
                                        MutableVector mutableVector5 = mutableVector;
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i2 == 1) {
                            }
                        }
                        MutableVector mutableVector6 = mutableVector;
                        t = DelegatableNodeKt.pop(mutableVector);
                    }
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: head-H91voCI$ui_release  reason: not valid java name */
    public final /* synthetic */ <T> T m5598headH91voCI$ui_release(int i) {
        if ((getAggregateChildKindSet() & i) != 0) {
            for (T head$ui_release = getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
                Modifier.Node node = (Modifier.Node) head$ui_release;
                if ((head$ui_release.getKindSet$ui_release() & i) != 0) {
                    Modifier.Node node2 = (Modifier.Node) head$ui_release;
                    T t = head$ui_release;
                    MutableVector mutableVector = null;
                    while (t != null) {
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (t instanceof Object) {
                            return t;
                        }
                        Modifier.Node node3 = (Modifier.Node) t;
                        if ((t.getKindSet$ui_release() & i) != 0 && (t instanceof DelegatingNode)) {
                            int i2 = 0;
                            for (T delegate$ui_release = ((DelegatingNode) t).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                Modifier.Node node4 = (Modifier.Node) delegate$ui_release;
                                if ((delegate$ui_release.getKindSet$ui_release() & i) != 0) {
                                    i2++;
                                    if (i2 == 1) {
                                        t = delegate$ui_release;
                                    } else {
                                        MutableVector mutableVector2 = mutableVector;
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            MutableVector mutableVector3 = mutableVector;
                                        }
                                        Modifier.Node node5 = (Modifier.Node) t;
                                        if (t != null) {
                                            MutableVector mutableVector4 = mutableVector;
                                            if (mutableVector != null) {
                                                mutableVector.add(t);
                                            }
                                            t = null;
                                        }
                                        MutableVector mutableVector5 = mutableVector;
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate$ui_release);
                                        }
                                    }
                                }
                            }
                            if (i2 == 1) {
                            }
                        }
                        MutableVector mutableVector6 = mutableVector;
                        t = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head$ui_release.getAggregateChildKindSet$ui_release() & i) == 0) {
                    break;
                }
            }
        }
        return null;
    }
}
