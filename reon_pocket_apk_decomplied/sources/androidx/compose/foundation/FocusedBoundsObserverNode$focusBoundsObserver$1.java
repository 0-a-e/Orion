package androidx.compose.foundation;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "focusedBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: FocusedBounds.kt */
final class FocusedBoundsObserverNode$focusBoundsObserver$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {
    final /* synthetic */ FocusedBoundsObserverNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusedBoundsObserverNode$focusBoundsObserver$1(FocusedBoundsObserverNode focusedBoundsObserverNode) {
        super(1);
        this.this$0 = focusedBoundsObserverNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LayoutCoordinates layoutCoordinates) {
        if (this.this$0.isAttached()) {
            this.this$0.getOnPositioned().invoke(layoutCoordinates);
            Function1 access$getParent = this.this$0.getParent();
            if (access$getParent != null) {
                access$getParent.invoke(layoutCoordinates);
            }
        }
    }
}
