package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J7\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001a¢\u0006\u0002\b\u001eH@¢\u0006\u0002\u0010\u001fJ\u001c\u0010 \u001a\u00020\u0018*\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\""}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)V", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "visibleItemsAverageSize", "getVisibleItemsAverageSize", "calculateDistanceTo", "", "targetIndex", "targetItemOffset", "getVisibleItemScrollOffset", "index", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridAnimateScrollScope.kt */
public final class LazyStaggeredGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {
    public static final int $stable = 8;
    private final LazyStaggeredGridState state;

    public LazyStaggeredGridAnimateScrollScope(LazyStaggeredGridState lazyStaggeredGridState) {
        this.state = lazyStaggeredGridState;
    }

    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    public int getLastVisibleItemIndex() {
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyStaggeredGridItemInfo != null) {
            return lazyStaggeredGridItemInfo.getIndex();
        }
        return 0;
    }

    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    public int getVisibleItemScrollOffset(int i) {
        long r0 = this.state.getLayoutInfo().getVisibleItemsInfo().get(CollectionsKt.binarySearch$default((List) this.state.getLayoutInfo().getVisibleItemsInfo(), 0, 0, (Function1) new LazyStaggeredGridAnimateScrollScope$getVisibleItemScrollOffset$searchedIndex$1(i), 3, (Object) null)).m927getOffsetnOccac();
        return this.state.isVertical$foundation_release() ? IntOffset.m6749getYimpl(r0) : IntOffset.m6748getXimpl(r0);
    }

    public void snapToItem(ScrollScope scrollScope, int i, int i2) {
        this.state.snapToItemInternal$foundation_release(scrollScope, i, i2);
    }

    public float calculateDistanceTo(int i, int i2) {
        int visibleItemsAverageSize = getVisibleItemsAverageSize();
        int laneCount$foundation_release = (i / this.state.getLaneCount$foundation_release()) - (getFirstVisibleItemIndex() / this.state.getLaneCount$foundation_release());
        int min = Math.min(Math.abs(i2), visibleItemsAverageSize);
        if (i2 < 0) {
            min *= -1;
        }
        return ((((float) visibleItemsAverageSize) * ((float) laneCount$foundation_release)) + ((float) min)) - ((float) getFirstVisibleItemScrollOffset());
    }

    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.CC.scroll$default(this.state, (MutatePriority) null, function2, continuation, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public int getVisibleItemsAverageSize() {
        LazyStaggeredGridLayoutInfo layoutInfo = this.state.getLayoutInfo();
        List<LazyStaggeredGridItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = visibleItemsInfo.get(i2);
            i += this.state.isVertical$foundation_release() ? IntSize.m6789getHeightimpl(lazyStaggeredGridItemInfo.m928getSizeYbymL2g()) : IntSize.m6790getWidthimpl(lazyStaggeredGridItemInfo.m928getSizeYbymL2g());
        }
        return (i / visibleItemsInfo.size()) + layoutInfo.getMainAxisItemSpacing();
    }
}
