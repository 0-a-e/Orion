package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "it", "invoke", "(F)Ljava/lang/Float;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
final class PagerState$scrollableState$1 extends Lambda implements Function1<Float, Float> {
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerState$scrollableState$1(PagerState pagerState) {
        super(1);
        this.this$0 = pagerState;
    }

    public final Float invoke(float f) {
        return Float.valueOf(this.this$0.performScroll(f));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }
}
