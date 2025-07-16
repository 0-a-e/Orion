package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.IntervalList;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPager.kt */
final class PagerLazyLayoutItemProvider$Item$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $index;
    final /* synthetic */ PagerLazyLayoutItemProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerLazyLayoutItemProvider$Item$1(PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i) {
        super(2);
        this.this$0 = pagerLazyLayoutItemProvider;
        this.$index = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C*198@8397L32:LazyLayoutPager.kt#g6yjnt");
        if ((i & 11) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1142237095, i, -1, "androidx.compose.foundation.pager.PagerLazyLayoutItemProvider.Item.<anonymous> (LazyLayoutPager.kt:197)");
            }
            LazyLayoutIntervalContent access$getIntervalContent$p = this.this$0.intervalContent;
            int i2 = this.$index;
            PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider = this.this$0;
            IntervalList.Interval interval = access$getIntervalContent$p.getIntervals().get(i2);
            ((PagerIntervalContent) interval.getValue()).getItem().invoke(pagerLazyLayoutItemProvider.pagerScopeImpl, Integer.valueOf(i2 - interval.getStartIndex()), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
