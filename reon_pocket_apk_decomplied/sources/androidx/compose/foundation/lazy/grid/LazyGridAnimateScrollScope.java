package androidx.compose.foundation.lazy.grid;

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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0016J7\u0010\u001c\u001a\u00020\u001d2'\u0010\u001e\u001a#\b\u0001\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0!\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001f¢\u0006\u0002\b#H@¢\u0006\u0002\u0010$J\u001c\u0010%\u001a\u00020\u001d*\u00020 2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006'"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;)V", "firstVisibleItemIndex", "", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "itemCount", "getItemCount", "lastVisibleItemIndex", "getLastVisibleItemIndex", "visibleItemsAverageSize", "getVisibleItemsAverageSize", "calculateDistanceTo", "", "targetIndex", "targetItemOffset", "calculateLineAverageMainAxisSize", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "isVertical", "", "getVisibleItemScrollOffset", "index", "scroll", "", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapToItem", "scrollOffset", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridAnimateScrollScope.kt */
public final class LazyGridAnimateScrollScope implements LazyLayoutAnimateScrollScope {
    public static final int $stable = 0;
    private final LazyGridState state;

    public LazyGridAnimateScrollScope(LazyGridState lazyGridState) {
        this.state = lazyGridState;
    }

    public int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    public int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    public int getLastVisibleItemIndex() {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return 0;
    }

    public int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    public int getVisibleItemsAverageSize() {
        return calculateLineAverageMainAxisSize(this.state.getLayoutInfo(), this.state.isVertical$foundation_release());
    }

    public int getVisibleItemScrollOffset(int i) {
        LazyGridItemInfo lazyGridItemInfo;
        int i2;
        List<LazyGridItemInfo> visibleItemsInfo = this.state.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                lazyGridItemInfo = null;
                break;
            }
            lazyGridItemInfo = visibleItemsInfo.get(i3);
            if (lazyGridItemInfo.getIndex() == i) {
                break;
            }
            i3++;
        }
        LazyGridItemInfo lazyGridItemInfo2 = lazyGridItemInfo;
        if (lazyGridItemInfo2 == null) {
            return 0;
        }
        if (this.state.isVertical$foundation_release()) {
            i2 = IntOffset.m6749getYimpl(lazyGridItemInfo2.m837getOffsetnOccac());
        } else {
            i2 = IntOffset.m6748getXimpl(lazyGridItemInfo2.m837getOffsetnOccac());
        }
        return i2;
    }

    public void snapToItem(ScrollScope scrollScope, int i, int i2) {
        this.state.snapToItemIndexInternal$foundation_release(i, i2);
    }

    public float calculateDistanceTo(int i, int i2) {
        int slotsPerLine$foundation_release = this.state.getSlotsPerLine$foundation_release();
        int visibleItemsAverageSize = getVisibleItemsAverageSize();
        int i3 = 1;
        boolean z = i < getFirstVisibleItemIndex();
        int firstVisibleItemIndex = i - getFirstVisibleItemIndex();
        int i4 = slotsPerLine$foundation_release - 1;
        if (z) {
            i3 = -1;
        }
        int i5 = (firstVisibleItemIndex + (i4 * i3)) / slotsPerLine$foundation_release;
        int min = Math.min(Math.abs(i2), visibleItemsAverageSize);
        if (i2 < 0) {
            min *= -1;
        }
        return (((float) (visibleItemsAverageSize * i5)) + ((float) min)) - ((float) getFirstVisibleItemScrollOffset());
    }

    private final int calculateLineAverageMainAxisSize(LazyGridLayoutInfo lazyGridLayoutInfo, boolean z) {
        int i;
        List<LazyGridItemInfo> visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
        Function1 lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1 = new LazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1(z, visibleItemsInfo);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < visibleItemsInfo.size()) {
            int intValue = ((Number) lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1.invoke(Integer.valueOf(i2))).intValue();
            if (intValue == -1) {
                i2++;
            } else {
                int i5 = 0;
                while (i2 < visibleItemsInfo.size() && ((Number) lazyGridAnimateScrollScope$calculateLineAverageMainAxisSize$lineOf$1.invoke(Integer.valueOf(i2))).intValue() == intValue) {
                    if (z) {
                        i = IntSize.m6789getHeightimpl(visibleItemsInfo.get(i2).m838getSizeYbymL2g());
                    } else {
                        i = IntSize.m6790getWidthimpl(visibleItemsInfo.get(i2).m838getSizeYbymL2g());
                    }
                    i5 = Math.max(i5, i);
                    i2++;
                }
                i3 += i5;
                i4++;
            }
        }
        return (i3 / i4) + lazyGridLayoutInfo.getMainAxisItemSpacing();
    }

    public Object scroll(Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll$default = ScrollableState.CC.scroll$default(this.state, (MutatePriority) null, function2, continuation, 1, (Object) null);
        return scroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scroll$default : Unit.INSTANCE;
    }
}
