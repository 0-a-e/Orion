package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0002\u0010\u0018J\t\u0010D\u001a\u00020EH\u0001J\u0016\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\bR\u0014\u0010\u0016\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u001cX\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001aR\u0011\u0010\"\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010$\"\u0004\b&\u0010'R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001a\"\u0004\b/\u00100R\u0012\u00101\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\b2\u0010\u001aR\u0014\u0010\u0017\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001aR\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0014\u0010\u0013\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u0014\u0010\u0012\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001aR\u0014\u0010\u0011\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001aR\u001a\u0010;\u001a\u00020<8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010\u0010\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u001aR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0012\u0010B\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\bC\u0010\u001a\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006I"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "firstVisibleItemScrollOffset", "", "canScrollForward", "", "consumedScroll", "", "measureResult", "scrollBackAmount", "remeasureNeeded", "visibleItemsInfo", "", "viewportStartOffset", "viewportEndOffset", "totalItemsCount", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "afterContentPadding", "mainAxisItemSpacing", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;IZFLandroidx/compose/ui/layout/MeasureResult;FZLjava/util/List;IIIZLandroidx/compose/foundation/gestures/Orientation;II)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getFirstVisibleItem", "()Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "getFirstVisibleItemScrollOffset", "setFirstVisibleItemScrollOffset", "(I)V", "height", "getHeight", "getMainAxisItemSpacing", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getRemeasureNeeded", "getReverseLayout", "getScrollBackAmount", "getTotalItemsCount", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "", "tryToApplyScrollWithoutRemeasure", "delta", "updateAnimations", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyListMeasureResult.kt */
public final class LazyListMeasureResult implements LazyListLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final LazyListMeasuredItem firstVisibleItem;
    private int firstVisibleItemScrollOffset;
    private final int mainAxisItemSpacing;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final float scrollBackAmount;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<LazyListMeasuredItem> visibleItemsInfo;

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    public LazyListMeasureResult(LazyListMeasuredItem lazyListMeasuredItem, int i, boolean z, float f, MeasureResult measureResult, float f2, boolean z2, List<LazyListMeasuredItem> list, int i2, int i3, int i4, boolean z3, Orientation orientation2, int i5, int i6) {
        this.firstVisibleItem = lazyListMeasuredItem;
        this.firstVisibleItemScrollOffset = i;
        this.canScrollForward = z;
        this.consumedScroll = f;
        this.scrollBackAmount = f2;
        this.remeasureNeeded = z2;
        this.visibleItemsInfo = list;
        this.viewportStartOffset = i2;
        this.viewportEndOffset = i3;
        this.totalItemsCount = i4;
        this.reverseLayout = z3;
        this.orientation = orientation2;
        this.afterContentPadding = i5;
        this.mainAxisItemSpacing = i6;
        this.$$delegate_0 = measureResult;
    }

    public final LazyListMeasuredItem getFirstVisibleItem() {
        return this.firstVisibleItem;
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.firstVisibleItemScrollOffset;
    }

    public final void setFirstVisibleItemScrollOffset(int i) {
        this.firstVisibleItemScrollOffset = i;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final void setConsumedScroll(float f) {
        this.consumedScroll = f;
    }

    public final float getScrollBackAmount() {
        return this.scrollBackAmount;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public List<LazyListMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final boolean getCanScrollBackward() {
        LazyListMeasuredItem lazyListMeasuredItem = this.firstVisibleItem;
        return ((lazyListMeasuredItem != null ? lazyListMeasuredItem.getIndex() : 0) == 0 && this.firstVisibleItemScrollOffset == 0) ? false : true;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m811getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2, types: [int] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean tryToApplyScrollWithoutRemeasure(int r5, boolean r6) {
        /*
            r4 = this;
            boolean r0 = r4.remeasureNeeded
            r1 = 0
            if (r0 != 0) goto L_0x00a4
            java.util.List r0 = r4.getVisibleItemsInfo()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00a4
            androidx.compose.foundation.lazy.LazyListMeasuredItem r0 = r4.firstVisibleItem
            if (r0 == 0) goto L_0x00a4
            int r0 = r0.getSizeWithSpacings()
            int r2 = r4.firstVisibleItemScrollOffset
            int r2 = r2 - r5
            if (r2 < 0) goto L_0x00a4
            if (r2 >= r0) goto L_0x00a4
            java.util.List r0 = r4.getVisibleItemsInfo()
            java.lang.Object r0 = kotlin.collections.CollectionsKt.first(r0)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r0 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r0
            java.util.List r2 = r4.getVisibleItemsInfo()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.last(r2)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r2 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r2
            boolean r3 = r0.getNonScrollableItem()
            if (r3 != 0) goto L_0x00a4
            boolean r3 = r2.getNonScrollableItem()
            if (r3 == 0) goto L_0x003f
            goto L_0x00a4
        L_0x003f:
            if (r5 >= 0) goto L_0x0065
            int r3 = r0.getOffset()
            int r0 = r0.getSizeWithSpacings()
            int r3 = r3 + r0
            int r0 = r4.getViewportStartOffset()
            int r3 = r3 - r0
            int r0 = r2.getOffset()
            int r2 = r2.getSizeWithSpacings()
            int r0 = r0 + r2
            int r2 = r4.getViewportEndOffset()
            int r0 = r0 - r2
            int r0 = java.lang.Math.min(r3, r0)
            int r2 = -r5
            if (r0 <= r2) goto L_0x00a4
            goto L_0x007d
        L_0x0065:
            int r3 = r4.getViewportStartOffset()
            int r0 = r0.getOffset()
            int r3 = r3 - r0
            int r0 = r4.getViewportEndOffset()
            int r2 = r2.getOffset()
            int r0 = r0 - r2
            int r0 = java.lang.Math.min(r3, r0)
            if (r0 <= r5) goto L_0x00a4
        L_0x007d:
            int r0 = r4.firstVisibleItemScrollOffset
            int r0 = r0 - r5
            r4.firstVisibleItemScrollOffset = r0
            java.util.List r0 = r4.getVisibleItemsInfo()
            int r2 = r0.size()
        L_0x008a:
            if (r1 >= r2) goto L_0x0098
            java.lang.Object r3 = r0.get(r1)
            androidx.compose.foundation.lazy.LazyListMeasuredItem r3 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) r3
            r3.applyScrollDelta(r5, r6)
            int r1 = r1 + 1
            goto L_0x008a
        L_0x0098:
            float r6 = (float) r5
            r4.consumedScroll = r6
            boolean r6 = r4.canScrollForward
            r1 = 1
            if (r6 != 0) goto L_0x00a4
            if (r5 <= 0) goto L_0x00a4
            r4.canScrollForward = r1
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureResult.tryToApplyScrollWithoutRemeasure(int, boolean):boolean");
    }
}
