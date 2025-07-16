package androidx.compose.foundation.lazy.grid;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"androidx/compose/foundation/lazy/grid/LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "createLine", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "index", "", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "mainAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;Ljava/util/List;I)Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 extends LazyGridMeasuredLineProvider {
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyGridSlots $resolvedSlots;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(boolean z, LazyGridSlots lazyGridSlots, int i, int i2, LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider) {
        super(z, lazyGridSlots, i, i2, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1, lazyGridSpanLayoutProvider);
        this.$isVertical = z;
        this.$resolvedSlots = lazyGridSlots;
    }

    public LazyGridMeasuredLine createLine(int i, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i2) {
        return new LazyGridMeasuredLine(i, lazyGridMeasuredItemArr, this.$resolvedSlots, list, this.$isVertical, i2);
    }
}
