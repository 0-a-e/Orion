package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridState.kt */
final class LazyStaggeredGridStateKt$rememberLazyStaggeredGridState$1$1 extends Lambda implements Function0<LazyStaggeredGridState> {
    final /* synthetic */ int $initialFirstVisibleItemIndex;
    final /* synthetic */ int $initialFirstVisibleItemScrollOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridStateKt$rememberLazyStaggeredGridState$1$1(int i, int i2) {
        super(0);
        this.$initialFirstVisibleItemIndex = i;
        this.$initialFirstVisibleItemScrollOffset = i2;
    }

    public final LazyStaggeredGridState invoke() {
        return new LazyStaggeredGridState(this.$initialFirstVisibleItemIndex, this.$initialFirstVisibleItemScrollOffset);
    }
}
