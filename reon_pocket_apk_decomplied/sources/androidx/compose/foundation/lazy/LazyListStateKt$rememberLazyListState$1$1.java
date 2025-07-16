package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/LazyListState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListState.kt */
final class LazyListStateKt$rememberLazyListState$1$1 extends Lambda implements Function0<LazyListState> {
    final /* synthetic */ int $initialFirstVisibleItemIndex;
    final /* synthetic */ int $initialFirstVisibleItemScrollOffset;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListStateKt$rememberLazyListState$1$1(int i, int i2) {
        super(0);
        this.$initialFirstVisibleItemIndex = i;
        this.$initialFirstVisibleItemScrollOffset = i2;
    }

    public final LazyListState invoke() {
        return new LazyListState(this.$initialFirstVisibleItemIndex, this.$initialFirstVisibleItemScrollOffset);
    }
}
