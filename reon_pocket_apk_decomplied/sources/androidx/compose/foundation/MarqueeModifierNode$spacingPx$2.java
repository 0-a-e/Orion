package androidx.compose.foundation;

import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicMarquee.kt */
final class MarqueeModifierNode$spacingPx$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ MarqueeSpacing $spacing;
    final /* synthetic */ MarqueeModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MarqueeModifierNode$spacingPx$2(MarqueeSpacing marqueeSpacing, MarqueeModifierNode marqueeModifierNode) {
        super(0);
        this.$spacing = marqueeSpacing;
        this.this$0 = marqueeModifierNode;
    }

    public final Integer invoke() {
        MarqueeSpacing marqueeSpacing = this.$spacing;
        MarqueeModifierNode marqueeModifierNode = this.this$0;
        return Integer.valueOf(marqueeSpacing.calculateSpacing(DelegatableNodeKt.requireDensity(marqueeModifierNode), marqueeModifierNode.getContentWidth(), marqueeModifierNode.getContainerWidth()));
    }
}
