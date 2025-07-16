package androidx.compose.foundation;

import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Focusable.kt */
final class FocusablePinnableContainerNode$retrievePinnableContainer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef<PinnableContainer> $container;
    final /* synthetic */ FocusablePinnableContainerNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FocusablePinnableContainerNode$retrievePinnableContainer$1(Ref.ObjectRef<PinnableContainer> objectRef, FocusablePinnableContainerNode focusablePinnableContainerNode) {
        super(0);
        this.$container = objectRef;
        this.this$0 = focusablePinnableContainerNode;
    }

    public final void invoke() {
        this.$container.element = CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, PinnableContainerKt.getLocalPinnableContainer());
    }
}
