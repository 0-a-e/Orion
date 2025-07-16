package androidx.compose.foundation.pager;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/pager/PagerLayoutIntervalContent;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPager.kt */
final class LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1 extends Lambda implements Function0<PagerLayoutIntervalContent> {
    final /* synthetic */ State<Function4<PagerScope, Integer, Composer, Integer, Unit>> $latestContent;
    final /* synthetic */ State<Function1<Integer, Object>> $latestKey;
    final /* synthetic */ Function0<Integer> $pageCount;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1(State<? extends Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>> state, State<? extends Function1<? super Integer, ? extends Object>> state2, Function0<Integer> function0) {
        super(0);
        this.$latestContent = state;
        this.$latestKey = state2;
        this.$pageCount = function0;
    }

    public final PagerLayoutIntervalContent invoke() {
        return new PagerLayoutIntervalContent(this.$latestContent.getValue(), this.$latestKey.getValue(), this.$pageCount.invoke().intValue());
    }
}
