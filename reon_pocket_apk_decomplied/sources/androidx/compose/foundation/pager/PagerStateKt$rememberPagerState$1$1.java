package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/pager/PagerStateImpl;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
final class PagerStateKt$rememberPagerState$1$1 extends Lambda implements Function0<PagerStateImpl> {
    final /* synthetic */ int $initialPage;
    final /* synthetic */ float $initialPageOffsetFraction;
    final /* synthetic */ Function0<Integer> $pageCount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerStateKt$rememberPagerState$1$1(int i, float f, Function0<Integer> function0) {
        super(0);
        this.$initialPage = i;
        this.$initialPageOffsetFraction = f;
        this.$pageCount = function0;
    }

    public final PagerStateImpl invoke() {
        return new PagerStateImpl(this.$initialPage, this.$initialPageOffsetFraction, this.$pageCount);
    }
}
