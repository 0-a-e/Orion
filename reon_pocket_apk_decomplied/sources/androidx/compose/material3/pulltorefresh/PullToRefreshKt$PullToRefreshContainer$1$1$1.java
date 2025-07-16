package androidx.compose.material3.pulltorefresh;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshKt$PullToRefreshContainer$1$1$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ PullToRefreshState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshKt$PullToRefreshContainer$1$1$1(PullToRefreshState pullToRefreshState) {
        super(1);
        this.$state = pullToRefreshState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GraphicsLayerScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setTranslationY(this.$state.getVerticalOffset() - Size.m3628getHeightimpl(graphicsLayerScope.m3985getSizeNHjbRc()));
    }
}
