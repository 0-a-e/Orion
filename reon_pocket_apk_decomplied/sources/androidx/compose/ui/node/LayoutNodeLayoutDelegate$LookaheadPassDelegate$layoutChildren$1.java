package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LookaheadDelegate $lookaheadDelegate;
    final /* synthetic */ LayoutNodeLayoutDelegate.LookaheadPassDelegate this$0;
    final /* synthetic */ LayoutNodeLayoutDelegate this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate, LookaheadDelegate lookaheadDelegate, LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        super(0);
        this.this$0 = lookaheadPassDelegate;
        this.$lookaheadDelegate = lookaheadDelegate;
        this.this$1 = layoutNodeLayoutDelegate;
    }

    public final void invoke() {
        this.this$0.clearPlaceOrder();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass1.INSTANCE);
        LookaheadDelegate lookaheadDelegate = this.this$0.getInnerCoordinator().getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            boolean isPlacingForAlignment$ui_release = lookaheadDelegate.isPlacingForAlignment$ui_release();
            List<LayoutNode> children$ui_release = this.this$1.layoutNode.getChildren$ui_release();
            int size = children$ui_release.size();
            for (int i = 0; i < size; i++) {
                LookaheadDelegate lookaheadDelegate2 = children$ui_release.get(i).getOuterCoordinator$ui_release().getLookaheadDelegate();
                if (lookaheadDelegate2 != null) {
                    lookaheadDelegate2.setPlacingForAlignment$ui_release(isPlacingForAlignment$ui_release);
                }
            }
        }
        this.$lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
        LookaheadDelegate lookaheadDelegate3 = this.this$0.getInnerCoordinator().getLookaheadDelegate();
        if (lookaheadDelegate3 != null) {
            lookaheadDelegate3.isPlacingForAlignment$ui_release();
            List<LayoutNode> children$ui_release2 = this.this$1.layoutNode.getChildren$ui_release();
            int size2 = children$ui_release2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                LookaheadDelegate lookaheadDelegate4 = children$ui_release2.get(i2).getOuterCoordinator$ui_release().getLookaheadDelegate();
                if (lookaheadDelegate4 != null) {
                    lookaheadDelegate4.setPlacingForAlignment$ui_release(false);
                }
            }
        }
        this.this$0.checkChildrenPlaceOrderForUpdates();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass4.INSTANCE);
    }
}
