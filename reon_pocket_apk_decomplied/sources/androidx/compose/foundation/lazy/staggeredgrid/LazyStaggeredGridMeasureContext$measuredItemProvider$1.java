package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¨\u0006\u000e"}, d2 = {"androidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext$measuredItemProvider$1", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "createItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "index", "", "lane", "span", "key", "", "contentType", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasureContext$measuredItemProvider$1 extends LazyStaggeredGridMeasureProvider {
    final /* synthetic */ LazyStaggeredGridMeasureContext this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridMeasureContext$measuredItemProvider$1(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, boolean z, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridSlots lazyStaggeredGridSlots) {
        super(z, lazyStaggeredGridItemProvider, lazyLayoutMeasureScope, lazyStaggeredGridSlots);
        this.this$0 = lazyStaggeredGridMeasureContext;
    }

    public LazyStaggeredGridMeasuredItem createItem(int i, int i2, int i3, Object obj, Object obj2, List<? extends Placeable> list) {
        return new LazyStaggeredGridMeasuredItem(i, obj, list, this.this$0.isVertical(), this.this$0.getMainAxisSpacing(), i2, i3, this.this$0.getBeforeContentPadding(), this.this$0.getAfterContentPadding(), obj2, this.this$0.getState().getPlacementAnimator$foundation_release());
    }
}
