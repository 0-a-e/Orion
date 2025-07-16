package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0002\u0010\u0019J\t\u0010C\u001a\u00020DH\u0001J\u000e\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\u000eR\u0014\u0010\u0017\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000e0\u001dX\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0016\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\"\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010$\"\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0012\u0010/\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\b0\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010$R\u0014\u0010\u0018\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0014\u00104\u001a\u000205X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001bR\u0014\u0010\u0015\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001bR\u001c\u0010\u0012\u001a\u00020\u0013X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0014\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0012\u0010A\u001a\u00020\u000eX\u0005¢\u0006\u0006\u001a\u0004\bB\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006G"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "firstVisibleItemIndices", "", "firstVisibleItemScrollOffsets", "consumedScroll", "", "measureResult", "canScrollForward", "", "isVertical", "remeasureNeeded", "totalItemsCount", "", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "viewportStartOffset", "viewportEndOffset", "beforeContentPadding", "afterContentPadding", "mainAxisItemSpacing", "([I[IFLandroidx/compose/ui/layout/MeasureResult;ZZZILjava/util/List;JIIIIILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "getBeforeContentPadding", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getConsumedScroll", "()F", "setConsumedScroll", "(F)V", "getFirstVisibleItemIndices", "()[I", "getFirstVisibleItemScrollOffsets", "height", "getHeight", "getMainAxisItemSpacing", "getMeasureResult", "()Landroidx/compose/ui/layout/MeasureResult;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getRemeasureNeeded", "getTotalItemsCount", "getViewportEndOffset", "getViewportSize-YbymL2g", "()J", "J", "getViewportStartOffset", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGridMeasureResult.kt */
public final class LazyStaggeredGridMeasureResult implements LazyStaggeredGridLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private boolean canScrollForward;
    private float consumedScroll;
    private final int[] firstVisibleItemIndices;
    private final int[] firstVisibleItemScrollOffsets;
    private final boolean isVertical;
    private final int mainAxisItemSpacing;
    private final MeasureResult measureResult;
    private final Orientation orientation;
    private final boolean remeasureNeeded;
    private final int totalItemsCount;
    private final int viewportEndOffset;
    private final long viewportSize;
    private final int viewportStartOffset;
    private final List<LazyStaggeredGridMeasuredItem> visibleItemsInfo;

    public /* synthetic */ LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f, MeasureResult measureResult2, boolean z, boolean z2, boolean z3, int i, List list, long j, int i2, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(iArr, iArr2, f, measureResult2, z, z2, z3, i, list, j, i2, i3, i4, i5, i6);
    }

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.measureResult.getAlignmentLines();
    }

    public int getHeight() {
        return this.measureResult.getHeight();
    }

    public int getWidth() {
        return this.measureResult.getWidth();
    }

    public void placeChildren() {
        this.measureResult.placeChildren();
    }

    private LazyStaggeredGridMeasureResult(int[] iArr, int[] iArr2, float f, MeasureResult measureResult2, boolean z, boolean z2, boolean z3, int i, List<LazyStaggeredGridMeasuredItem> list, long j, int i2, int i3, int i4, int i5, int i6) {
        boolean z4 = z2;
        this.firstVisibleItemIndices = iArr;
        this.firstVisibleItemScrollOffsets = iArr2;
        this.consumedScroll = f;
        this.measureResult = measureResult2;
        this.canScrollForward = z;
        this.isVertical = z4;
        this.remeasureNeeded = z3;
        this.totalItemsCount = i;
        this.visibleItemsInfo = list;
        this.viewportSize = j;
        this.viewportStartOffset = i2;
        this.viewportEndOffset = i3;
        this.beforeContentPadding = i4;
        this.afterContentPadding = i5;
        this.mainAxisItemSpacing = i6;
        this.orientation = z4 ? Orientation.Vertical : Orientation.Horizontal;
    }

    public final int[] getFirstVisibleItemIndices() {
        return this.firstVisibleItemIndices;
    }

    public final int[] getFirstVisibleItemScrollOffsets() {
        return this.firstVisibleItemScrollOffsets;
    }

    public final float getConsumedScroll() {
        return this.consumedScroll;
    }

    public final void setConsumedScroll(float f) {
        this.consumedScroll = f;
    }

    public final MeasureResult getMeasureResult() {
        return this.measureResult;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    public int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public List<LazyStaggeredGridMeasuredItem> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m943getViewportSizeYbymL2g() {
        return this.viewportSize;
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    public final boolean getCanScrollBackward() {
        return this.firstVisibleItemIndices[0] != 0 || this.firstVisibleItemScrollOffsets[0] > 0;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a4, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean tryToApplyScrollWithoutRemeasure(int r9) {
        /*
            r8 = this;
            boolean r0 = r8.remeasureNeeded
            r1 = 0
            if (r0 != 0) goto L_0x00dc
            java.util.List r0 = r8.getVisibleItemsInfo()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00dc
            int[] r0 = r8.firstVisibleItemIndices
            int r0 = r0.length
            if (r0 != 0) goto L_0x0016
            goto L_0x00dc
        L_0x0016:
            int[] r0 = r8.firstVisibleItemScrollOffsets
            int r0 = r0.length
            if (r0 != 0) goto L_0x001d
            goto L_0x00dc
        L_0x001d:
            java.util.List r0 = r8.getVisibleItemsInfo()
            int r2 = r0.size()
            r3 = r1
        L_0x0026:
            r4 = 1
            if (r3 >= r2) goto L_0x00aa
            java.lang.Object r5 = r0.get(r3)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r5 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r5
            boolean r6 = r5.getNonScrollableItem()
            if (r6 != 0) goto L_0x00a9
            int r6 = r5.getMainAxisOffset()
            if (r6 > 0) goto L_0x003d
            r6 = r4
            goto L_0x003e
        L_0x003d:
            r6 = r1
        L_0x003e:
            int r7 = r5.getMainAxisOffset()
            int r7 = r7 + r9
            if (r7 > 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r4 = r1
        L_0x0047:
            if (r6 == r4) goto L_0x004a
            goto L_0x00a9
        L_0x004a:
            int r4 = r5.getMainAxisOffset()
            int r6 = r8.getViewportStartOffset()
            if (r4 > r6) goto L_0x0075
            if (r9 >= 0) goto L_0x0068
            int r4 = r5.getMainAxisOffset()
            int r6 = r5.getSizeWithSpacings()
            int r4 = r4 + r6
            int r6 = r8.getViewportStartOffset()
            int r4 = r4 - r6
            int r6 = -r9
            if (r4 <= r6) goto L_0x0074
            goto L_0x0075
        L_0x0068:
            int r4 = r8.getViewportStartOffset()
            int r6 = r5.getMainAxisOffset()
            int r4 = r4 - r6
            if (r4 <= r9) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            return r1
        L_0x0075:
            int r4 = r5.getMainAxisOffset()
            int r6 = r5.getSizeWithSpacings()
            int r4 = r4 + r6
            int r6 = r8.getViewportEndOffset()
            if (r4 < r6) goto L_0x00a5
            if (r9 >= 0) goto L_0x0098
            int r4 = r5.getMainAxisOffset()
            int r5 = r5.getSizeWithSpacings()
            int r4 = r4 + r5
            int r5 = r8.getViewportEndOffset()
            int r4 = r4 - r5
            int r5 = -r9
            if (r4 <= r5) goto L_0x00a4
            goto L_0x00a5
        L_0x0098:
            int r4 = r8.getViewportEndOffset()
            int r5 = r5.getMainAxisOffset()
            int r4 = r4 - r5
            if (r4 <= r9) goto L_0x00a4
            goto L_0x00a5
        L_0x00a4:
            return r1
        L_0x00a5:
            int r3 = r3 + 1
            goto L_0x0026
        L_0x00a9:
            return r1
        L_0x00aa:
            int[] r0 = r8.firstVisibleItemScrollOffsets
            int r0 = r0.length
            r2 = r1
        L_0x00ae:
            if (r2 >= r0) goto L_0x00ba
            int[] r3 = r8.firstVisibleItemScrollOffsets
            r5 = r3[r2]
            int r5 = r5 - r9
            r3[r2] = r5
            int r2 = r2 + 1
            goto L_0x00ae
        L_0x00ba:
            java.util.List r0 = r8.getVisibleItemsInfo()
            int r2 = r0.size()
        L_0x00c2:
            if (r1 >= r2) goto L_0x00d0
            java.lang.Object r3 = r0.get(r1)
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem r3 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) r3
            r3.applyScrollDelta(r9)
            int r1 = r1 + 1
            goto L_0x00c2
        L_0x00d0:
            float r0 = (float) r9
            r8.consumedScroll = r0
            boolean r0 = r8.canScrollForward
            if (r0 != 0) goto L_0x00db
            if (r9 <= 0) goto L_0x00db
            r8.canScrollForward = r4
        L_0x00db:
            return r4
        L_0x00dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult.tryToApplyScrollWithoutRemeasure(int):boolean");
    }
}
