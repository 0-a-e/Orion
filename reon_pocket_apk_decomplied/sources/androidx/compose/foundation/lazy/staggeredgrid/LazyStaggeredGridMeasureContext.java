package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ'\u0010B\u001a\u00020=*\u00020\b2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010FJ\u0012\u0010<\u001a\u00020\u000e*\u00020\b2\u0006\u0010C\u001a\u00020\u0006R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0019\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010$R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u000e*\u00020=8Æ\u0002¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010)\u001a\u00020\u0006*\u00020=8Æ\u0002¢\u0006\u0006\u001a\u0004\b@\u0010A\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "mainAxisAvailableSize", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "beforeContentPadding", "afterContentPadding", "reverseLayout", "mainAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZLandroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJIIZILkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "getBeforeContentPadding", "getConstraints-msEJaDk", "()J", "J", "getContentOffset-nOcc-ac", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "()Z", "getItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "laneCount", "getLaneCount", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getMainAxisAvailableSize", "getMainAxisSpacing", "getMeasureScope", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getMeasuredItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getPinnedItems", "()Ljava/util/List;", "getResolvedSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getReverseLayout", "getState", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "isFullSpan", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "isFullSpan-SZVOQXA", "(J)Z", "getLaneInfo-SZVOQXA", "(J)I", "getSpanRange", "itemIndex", "lane", "getSpanRange-lOCCd4c", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;II)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasure.kt */
public final class LazyStaggeredGridMeasureContext {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final long constraints;
    private final long contentOffset;
    private final CoroutineScope coroutineScope;
    private final boolean isVertical;
    private final LazyStaggeredGridItemProvider itemProvider;
    private final int laneCount;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final int mainAxisAvailableSize;
    private final int mainAxisSpacing;
    private final LazyLayoutMeasureScope measureScope;
    private final LazyStaggeredGridMeasureProvider measuredItemProvider;
    private final List<Integer> pinnedItems;
    private final LazyStaggeredGridSlots resolvedSlots;
    private final boolean reverseLayout;
    private final LazyStaggeredGridState state;

    public /* synthetic */ LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, List list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j2, int i2, int i3, boolean z2, int i4, CoroutineScope coroutineScope2, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i2, i3, z2, i4, coroutineScope2);
    }

    /* renamed from: getLaneInfo-SZVOQXA  reason: not valid java name */
    public final int m933getLaneInfoSZVOQXA(long j) {
        int i = (int) (j >> 32);
        if (((int) (4294967295L & j)) - i != 1) {
            return -2;
        }
        return i;
    }

    /* renamed from: isFullSpan-SZVOQXA  reason: not valid java name */
    public final boolean m935isFullSpanSZVOQXA(long j) {
        return ((int) (4294967295L & j)) - ((int) (j >> 32)) != 1;
    }

    private LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j2, int i2, int i3, boolean z2, int i4, CoroutineScope coroutineScope2) {
        this.state = lazyStaggeredGridState;
        this.pinnedItems = list;
        this.itemProvider = lazyStaggeredGridItemProvider;
        this.resolvedSlots = lazyStaggeredGridSlots;
        this.constraints = j;
        this.isVertical = z;
        this.measureScope = lazyLayoutMeasureScope;
        this.mainAxisAvailableSize = i;
        this.contentOffset = j2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.reverseLayout = z2;
        this.mainAxisSpacing = i4;
        this.coroutineScope = coroutineScope2;
        this.measuredItemProvider = new LazyStaggeredGridMeasureContext$measuredItemProvider$1(this, z, lazyStaggeredGridItemProvider, lazyLayoutMeasureScope, lazyStaggeredGridSlots);
        this.laneInfo = lazyStaggeredGridState.getLaneInfo$foundation_release();
        this.laneCount = lazyStaggeredGridSlots.getSizes().length;
    }

    public final LazyStaggeredGridState getState() {
        return this.state;
    }

    public final List<Integer> getPinnedItems() {
        return this.pinnedItems;
    }

    public final LazyStaggeredGridItemProvider getItemProvider() {
        return this.itemProvider;
    }

    public final LazyStaggeredGridSlots getResolvedSlots() {
        return this.resolvedSlots;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m931getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final LazyLayoutMeasureScope getMeasureScope() {
        return this.measureScope;
    }

    public final int getMainAxisAvailableSize() {
        return this.mainAxisAvailableSize;
    }

    /* renamed from: getContentOffset-nOcc-ac  reason: not valid java name */
    public final long m932getContentOffsetnOccac() {
        return this.contentOffset;
    }

    public final int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final LazyStaggeredGridMeasureProvider getMeasuredItemProvider() {
        return this.measuredItemProvider;
    }

    public final LazyStaggeredGridLaneInfo getLaneInfo() {
        return this.laneInfo;
    }

    public final int getLaneCount() {
        return this.laneCount;
    }

    public final boolean isFullSpan(LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, int i) {
        return lazyStaggeredGridItemProvider.getSpanProvider().isFullSpan(i);
    }

    /* renamed from: getSpanRange-lOCCd4c  reason: not valid java name */
    public final long m934getSpanRangelOCCd4c(LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, int i, int i2) {
        boolean isFullSpan = lazyStaggeredGridItemProvider.getSpanProvider().isFullSpan(i);
        int i3 = isFullSpan ? this.laneCount : 1;
        if (isFullSpan) {
            i2 = 0;
        }
        return SpanRange.m951constructorimpl(i2, i3);
    }
}
