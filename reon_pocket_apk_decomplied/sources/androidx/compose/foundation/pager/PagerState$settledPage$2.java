package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
final class PagerState$settledPage$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerState$settledPage$2(PagerState pagerState) {
        super(0);
        this.this$0 = pagerState;
    }

    public final Integer invoke() {
        int i;
        if (this.this$0.isScrollInProgress()) {
            i = this.this$0.getSettledPageState();
        } else {
            i = this.this$0.getCurrentPage();
        }
        return Integer.valueOf(i);
    }
}
