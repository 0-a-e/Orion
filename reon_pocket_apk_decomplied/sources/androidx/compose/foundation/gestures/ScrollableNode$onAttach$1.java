package androidx.compose.foundation.gestures;

import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableNode$onAttach$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ScrollableNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollableNode$onAttach$1(ScrollableNode scrollableNode) {
        super(0);
        this.this$0 = scrollableNode;
    }

    public final void invoke() {
        CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalDensity());
    }
}
