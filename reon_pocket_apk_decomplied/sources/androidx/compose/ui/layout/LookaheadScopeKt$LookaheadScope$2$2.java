package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "scope", "Landroidx/compose/ui/layout/LookaheadScopeImpl;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LookaheadScope.kt */
final class LookaheadScopeKt$LookaheadScope$2$2 extends Lambda implements Function2<LayoutNode, LookaheadScopeImpl, Unit> {
    public static final LookaheadScopeKt$LookaheadScope$2$2 INSTANCE = new LookaheadScopeKt$LookaheadScope$2$2();

    LookaheadScopeKt$LookaheadScope$2$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((LayoutNode) obj, (LookaheadScopeImpl) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(final LayoutNode layoutNode, LookaheadScopeImpl lookaheadScopeImpl) {
        lookaheadScopeImpl.setScopeCoordinates(new Function0<LayoutCoordinates>() {
            public final LayoutCoordinates invoke() {
                LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
                Intrinsics.checkNotNull(parent$ui_release);
                return parent$ui_release.getInnerCoordinator$ui_release().getCoordinates();
            }
        });
    }
}
