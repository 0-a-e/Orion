package androidx.compose.animation;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntSize;", "it", "Landroidx/compose/animation/EnterExitState;", "invoke-YEO4UFw", "(Landroidx/compose/animation/EnterExitState;)J"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnterExitTransition.kt */
final class EnterExitTransitionModifierNode$measure$animSize$1 extends Lambda implements Function1<EnterExitState, IntSize> {
    final /* synthetic */ long $target;
    final /* synthetic */ EnterExitTransitionModifierNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EnterExitTransitionModifierNode$measure$animSize$1(EnterExitTransitionModifierNode enterExitTransitionModifierNode, long j) {
        super(1);
        this.this$0 = enterExitTransitionModifierNode;
        this.$target = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return IntSize.m6782boximpl(m95invokeYEO4UFw((EnterExitState) obj));
    }

    /* renamed from: invoke-YEO4UFw  reason: not valid java name */
    public final long m95invokeYEO4UFw(EnterExitState enterExitState) {
        return this.this$0.m92sizeByStateUzc_VyU(enterExitState, this.$target);
    }
}
