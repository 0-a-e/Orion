package androidx.compose.material3.pulltorefresh;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "value", "", "<anonymous parameter 1>", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PullToRefresh.kt */
final class PullToRefreshStateImpl$animateTo$2 extends Lambda implements Function2<Float, Float, Unit> {
    final /* synthetic */ PullToRefreshStateImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PullToRefreshStateImpl$animateTo$2(PullToRefreshStateImpl pullToRefreshStateImpl) {
        super(2);
        this.this$0 = pullToRefreshStateImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).floatValue(), ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(float f, float f2) {
        this.this$0.set_verticalOffset(f);
    }
}
