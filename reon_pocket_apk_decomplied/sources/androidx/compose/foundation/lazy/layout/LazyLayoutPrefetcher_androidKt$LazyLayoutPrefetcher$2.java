package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPrefetcher.android.kt */
final class LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ LazyLayoutItemContentFactory $itemContentFactory;
    final /* synthetic */ LazyLayoutPrefetchState $prefetchState;
    final /* synthetic */ SubcomposeLayoutState $subcomposeLayoutState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2(LazyLayoutPrefetchState lazyLayoutPrefetchState, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, int i) {
        super(2);
        this.$prefetchState = lazyLayoutPrefetchState;
        this.$itemContentFactory = lazyLayoutItemContentFactory;
        this.$subcomposeLayoutState = subcomposeLayoutState;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(this.$prefetchState, this.$itemContentFactory, this.$subcomposeLayoutState, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
