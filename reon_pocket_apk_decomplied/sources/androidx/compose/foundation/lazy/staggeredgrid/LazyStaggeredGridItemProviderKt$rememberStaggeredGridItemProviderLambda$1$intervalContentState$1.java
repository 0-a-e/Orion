package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridIntervalContent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridItemProvider.kt */
final class LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProviderLambda$1$intervalContentState$1 extends Lambda implements Function0<LazyStaggeredGridIntervalContent> {
    final /* synthetic */ State<Function1<LazyStaggeredGridScope, Unit>> $latestContent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridItemProviderKt$rememberStaggeredGridItemProviderLambda$1$intervalContentState$1(State<? extends Function1<? super LazyStaggeredGridScope, Unit>> state) {
        super(0);
        this.$latestContent = state;
    }

    public final LazyStaggeredGridIntervalContent invoke() {
        return new LazyStaggeredGridIntervalContent(this.$latestContent.getValue());
    }
}
