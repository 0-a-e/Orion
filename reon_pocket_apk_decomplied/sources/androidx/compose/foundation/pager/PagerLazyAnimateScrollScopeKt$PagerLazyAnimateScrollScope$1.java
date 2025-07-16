package androidx.compose.foundation.pager;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J7\u0010\u0014\u001a\u00020\u00152'\u0010\u0016\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0017¢\u0006\u0002\b\u001bH@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005¨\u0006\u001f"}, d2 = {"androidx/compose/foundation/pager/PagerLazyAnimateScrollScopeKt$PagerLazyAnimateScrollScope$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "visibleItemsAverageSize", "getVisibleItemsAverageSize", "calculateDistanceTo", "", "targetIndex", "targetItemOffset", "getVisibleItemScrollOffset", "index", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerLazyAnimateScrollScope.kt */
public final class PagerLazyAnimateScrollScopeKt$PagerLazyAnimateScrollScope$1 implements LazyLayoutAnimateScrollScope {
    final /* synthetic */ PagerState $state;

    PagerLazyAnimateScrollScopeKt$PagerLazyAnimateScrollScope$1(PagerState pagerState) {
        this.$state = pagerState;
    }

    public int getFirstVisibleItemIndex() {
        return this.$state.getFirstVisiblePage$foundation_release();
    }

    public int getFirstVisibleItemScrollOffset() {
        return this.$state.getFirstVisiblePageOffset$foundation_release();
    }

    public int getLastVisibleItemIndex() {
        return ((PageInfo) CollectionsKt.last(this.$state.getLayoutInfo().getVisiblePagesInfo())).getIndex();
    }

    public int getItemCount() {
        return this.$state.getPageCount();
    }

    public int getVisibleItemScrollOffset(int i) {
        PageInfo pageInfo;
        List<PageInfo> visiblePagesInfo = this.$state.getLayoutInfo().getVisiblePagesInfo();
        int size = visiblePagesInfo.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                pageInfo = null;
                break;
            }
            pageInfo = visiblePagesInfo.get(i2);
            if (pageInfo.getIndex() == i) {
                break;
            }
            i2++;
        }
        PageInfo pageInfo2 = pageInfo;
        if (pageInfo2 != null) {
            return pageInfo2.getOffset();
        }
        return 0;
    }

    public void snapToItem(ScrollScope scrollScope, int i, int i2) {
        this.$state.snapToItem$foundation_release(i, ((float) i2) / ((float) this.$state.getPageSizeWithSpacing$foundation_release()));
    }

    public float calculateDistanceTo(int i, int i2) {
        return (((float) (i - this.$state.getCurrentPage())) * ((float) getVisibleItemsAverageSize())) + ((float) i2);
    }

    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.CC.scroll$default(this.$state, (MutatePriority) null, function2, continuation, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }

    public int getVisibleItemsAverageSize() {
        return this.$state.getPageSize$foundation_release() + this.$state.getPageSpacing$foundation_release();
    }
}
