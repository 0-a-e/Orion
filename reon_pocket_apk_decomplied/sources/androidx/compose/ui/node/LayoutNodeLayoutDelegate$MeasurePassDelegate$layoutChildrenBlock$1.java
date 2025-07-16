package androidx.compose.ui.node;

import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LayoutNodeLayoutDelegate.kt */
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LayoutNodeLayoutDelegate.MeasurePassDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$MeasurePassDelegate$layoutChildrenBlock$1(LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate) {
        super(0);
        this.this$0 = measurePassDelegate;
    }

    public final void invoke() {
        this.this$0.clearPlaceOrder();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass1.INSTANCE);
        this.this$0.getInnerCoordinator().getMeasureResult$ui_release().placeChildren();
        this.this$0.checkChildrenPlaceOrderForUpdates();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass2.INSTANCE);
    }
}
