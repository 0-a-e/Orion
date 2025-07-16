package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"EmptyLazyStaggeredGridLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "getEmptyLazyStaggeredGridLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "findVisibleItem", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "itemIndex", "", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasureResult.kt */
public final class LazyStaggeredGridMeasureResultKt {
    private static final LazyStaggeredGridMeasureResult EmptyLazyStaggeredGridLayoutInfo = new LazyStaggeredGridMeasureResult(new int[0], new int[0], 0.0f, new LazyStaggeredGridMeasureResultKt$EmptyLazyStaggeredGridLayoutInfo$1(), false, false, false, 0, CollectionsKt.emptyList(), IntSize.Companion.m6795getZeroYbymL2g(), 0, 0, 0, 0, 0, (DefaultConstructorMarker) null);

    public static final LazyStaggeredGridItemInfo findVisibleItem(LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, int i) {
        if (lazyStaggeredGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return null;
        }
        int index = ((LazyStaggeredGridItemInfo) CollectionsKt.first(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo())).getIndex();
        if (i > ((LazyStaggeredGridItemInfo) CollectionsKt.last(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo())).getIndex() || index > i) {
            return null;
        }
        return (LazyStaggeredGridItemInfo) CollectionsKt.getOrNull(lazyStaggeredGridLayoutInfo.getVisibleItemsInfo(), CollectionsKt.binarySearch$default((List) lazyStaggeredGridLayoutInfo.getVisibleItemsInfo(), 0, 0, (Function1) new LazyStaggeredGridMeasureResultKt$findVisibleItem$index$1(i), 3, (Object) null));
    }

    public static final LazyStaggeredGridMeasureResult getEmptyLazyStaggeredGridLayoutInfo() {
        return EmptyLazyStaggeredGridLayoutInfo;
    }
}
