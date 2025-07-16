package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
final class LayoutNode$collapsedSemantics$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<SemanticsConfiguration> $config;
    final /* synthetic */ LayoutNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNode$collapsedSemantics$1(LayoutNode layoutNode, Ref.ObjectRef<SemanticsConfiguration> objectRef) {
        super(0);
        this.this$0 = layoutNode;
        this.$config = objectRef;
    }

    public final void invoke() {
        NodeChain nodes$ui_release = this.this$0.getNodes$ui_release();
        int r1 = NodeKind.m5647constructorimpl(8);
        Ref.ObjectRef<SemanticsConfiguration> objectRef = this.$config;
        if ((nodes$ui_release.getAggregateChildKindSet() & r1) != 0) {
            for (Modifier.Node tail$ui_release = nodes$ui_release.getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
                if ((tail$ui_release.getKindSet$ui_release() & r1) != 0) {
                    Modifier.Node node = tail$ui_release;
                    MutableVector mutableVector = null;
                    while (node != null) {
                        if (node instanceof SemanticsModifierNode) {
                            SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) node;
                            if (semanticsModifierNode.getShouldClearDescendantSemantics()) {
                                objectRef.element = new SemanticsConfiguration();
                                ((SemanticsConfiguration) objectRef.element).setClearingSemantics(true);
                            }
                            if (semanticsModifierNode.getShouldMergeDescendantSemantics()) {
                                ((SemanticsConfiguration) objectRef.element).setMergingSemanticsOfDescendants(true);
                            }
                            semanticsModifierNode.applySemantics((SemanticsConfiguration) objectRef.element);
                        } else if ((node.getKindSet$ui_release() & r1) != 0 && (node instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild$ui_release()) {
                                if ((delegate$ui_release.getKindSet$ui_release() & r1) != 0) {
                                    i++;
                                    if (i == 1) {
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
                            if (i == 1) {
                            }
                        }
                        node = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
    }
}
