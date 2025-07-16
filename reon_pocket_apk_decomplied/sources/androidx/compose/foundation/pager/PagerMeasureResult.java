package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0002\u0010\u0019J\t\u0010F\u001a\u00020GH\u0001J\u000e\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u0007R\u0014\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u001dX\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001bR\u0014\u0010\u0010\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010$\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010\u0016\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010&\"\u0004\b(\u0010)R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010+R\u001a\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001b\"\u0004\b2\u00103R\u0012\u00104\u001a\u00020\u0007X\u0005¢\u0006\u0006\u001a\u0004\b5\u0010\u001bR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001bR\u0014\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001bR\u0011\u0010\u0018\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b:\u0010&R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010&R\u0014\u0010\r\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001bR\u001a\u0010=\u001a\u00020>8VX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010\f\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u001bR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0012\u0010D\u001a\u00020\u0007X\u0005¢\u0006\u0006\u001a\u0004\bE\u0010\u001b\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006J"}, d2 = {"Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "Landroidx/compose/ui/layout/MeasureResult;", "visiblePagesInfo", "", "Landroidx/compose/foundation/pager/MeasuredPage;", "pageSize", "", "pageSpacing", "afterContentPadding", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "viewportStartOffset", "viewportEndOffset", "reverseLayout", "", "beyondBoundsPageCount", "firstVisiblePage", "currentPage", "currentPageOffsetFraction", "", "firstVisiblePageScrollOffset", "canScrollForward", "measureResult", "remeasureNeeded", "(Ljava/util/List;IIILandroidx/compose/foundation/gestures/Orientation;IIZILandroidx/compose/foundation/pager/MeasuredPage;Landroidx/compose/foundation/pager/MeasuredPage;FIZLandroidx/compose/ui/layout/MeasureResult;Z)V", "getAfterContentPadding", "()I", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getAlignmentLines", "()Ljava/util/Map;", "beforeContentPadding", "getBeforeContentPadding", "getBeyondBoundsPageCount", "canScrollBackward", "getCanScrollBackward", "()Z", "getCanScrollForward", "setCanScrollForward", "(Z)V", "getCurrentPage", "()Landroidx/compose/foundation/pager/MeasuredPage;", "getCurrentPageOffsetFraction", "()F", "setCurrentPageOffsetFraction", "(F)V", "getFirstVisiblePage", "getFirstVisiblePageScrollOffset", "setFirstVisiblePageScrollOffset", "(I)V", "height", "getHeight", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getPageSize", "getPageSpacing", "getRemeasureNeeded", "getReverseLayout", "getViewportEndOffset", "viewportSize", "Landroidx/compose/ui/unit/IntSize;", "getViewportSize-YbymL2g", "()J", "getViewportStartOffset", "getVisiblePagesInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "", "tryToApplyScrollWithoutRemeasure", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasureResult.kt */
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    public static final int $stable = 8;
    private final /* synthetic */ MeasureResult $$delegate_0;
    private final int afterContentPadding;
    private final int beyondBoundsPageCount;
    private boolean canScrollForward;
    private final MeasuredPage currentPage;
    private float currentPageOffsetFraction;
    private final MeasuredPage firstVisiblePage;
    private int firstVisiblePageScrollOffset;
    private final Orientation orientation;
    private final int pageSize;
    private final int pageSpacing;
    private final boolean remeasureNeeded;
    private final boolean reverseLayout;
    private final int viewportEndOffset;
    private final int viewportStartOffset;
    private final List<MeasuredPage> visiblePagesInfo;

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

    public PagerMeasureResult(List<MeasuredPage> list, int i, int i2, int i3, Orientation orientation2, int i4, int i5, boolean z, int i6, MeasuredPage measuredPage, MeasuredPage measuredPage2, float f, int i7, boolean z2, MeasureResult measureResult, boolean z3) {
        this.visiblePagesInfo = list;
        this.pageSize = i;
        this.pageSpacing = i2;
        this.afterContentPadding = i3;
        this.orientation = orientation2;
        this.viewportStartOffset = i4;
        this.viewportEndOffset = i5;
        this.reverseLayout = z;
        this.beyondBoundsPageCount = i6;
        this.firstVisiblePage = measuredPage;
        this.currentPage = measuredPage2;
        this.currentPageOffsetFraction = f;
        this.firstVisiblePageScrollOffset = i7;
        this.canScrollForward = z2;
        this.remeasureNeeded = z3;
        this.$$delegate_0 = measureResult;
    }

    public List<MeasuredPage> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getPageSpacing() {
        return this.pageSpacing;
    }

    public int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public Orientation getOrientation() {
        return this.orientation;
    }

    public int getViewportStartOffset() {
        return this.viewportStartOffset;
    }

    public int getViewportEndOffset() {
        return this.viewportEndOffset;
    }

    public boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public int getBeyondBoundsPageCount() {
        return this.beyondBoundsPageCount;
    }

    public final MeasuredPage getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    public final MeasuredPage getCurrentPage() {
        return this.currentPage;
    }

    public final float getCurrentPageOffsetFraction() {
        return this.currentPageOffsetFraction;
    }

    public final void setCurrentPageOffsetFraction(float f) {
        this.currentPageOffsetFraction = f;
    }

    public final int getFirstVisiblePageScrollOffset() {
        return this.firstVisiblePageScrollOffset;
    }

    public final void setFirstVisiblePageScrollOffset(int i) {
        this.firstVisiblePageScrollOffset = i;
    }

    public final boolean getCanScrollForward() {
        return this.canScrollForward;
    }

    public final void setCanScrollForward(boolean z) {
        this.canScrollForward = z;
    }

    public final boolean getRemeasureNeeded() {
        return this.remeasureNeeded;
    }

    /* renamed from: getViewportSize-YbymL2g  reason: not valid java name */
    public long m981getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    public int getBeforeContentPadding() {
        return -getViewportStartOffset();
    }

    public final boolean getCanScrollBackward() {
        MeasuredPage measuredPage = this.firstVisiblePage;
        return ((measuredPage != null ? measuredPage.getIndex() : 0) == 0 && this.firstVisiblePageScrollOffset == 0) ? false : true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2, types: [int] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean tryToApplyScrollWithoutRemeasure(int r7) {
        /*
            r6 = this;
            int r0 = r6.getPageSize()
            int r1 = r6.getPageSpacing()
            int r0 = r0 + r1
            boolean r1 = r6.remeasureNeeded
            r2 = 0
            if (r1 != 0) goto L_0x00b2
            java.util.List r1 = r6.getVisiblePagesInfo()
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00b2
            androidx.compose.foundation.pager.MeasuredPage r1 = r6.firstVisiblePage
            if (r1 == 0) goto L_0x00b2
            int r1 = r6.firstVisiblePageScrollOffset
            int r1 = r1 - r7
            if (r1 < 0) goto L_0x00b2
            if (r1 >= r0) goto L_0x00b2
            if (r0 == 0) goto L_0x0029
            float r1 = (float) r7
            float r3 = (float) r0
            float r1 = r1 / r3
            goto L_0x002a
        L_0x0029:
            r1 = 0
        L_0x002a:
            float r3 = r6.currentPageOffsetFraction
            float r3 = r3 - r1
            androidx.compose.foundation.pager.MeasuredPage r4 = r6.currentPage
            if (r4 == 0) goto L_0x00b2
            r4 = 1056964608(0x3f000000, float:0.5)
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            r4 = -1090519040(0xffffffffbf000000, float:-0.5)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x003f
            goto L_0x00b2
        L_0x003f:
            java.util.List r3 = r6.getVisiblePagesInfo()
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r3)
            androidx.compose.foundation.pager.MeasuredPage r3 = (androidx.compose.foundation.pager.MeasuredPage) r3
            java.util.List r4 = r6.getVisiblePagesInfo()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.last(r4)
            androidx.compose.foundation.pager.MeasuredPage r4 = (androidx.compose.foundation.pager.MeasuredPage) r4
            if (r7 >= 0) goto L_0x0071
            int r3 = r3.getOffset()
            int r3 = r3 + r0
            int r5 = r6.getViewportStartOffset()
            int r3 = r3 - r5
            int r4 = r4.getOffset()
            int r4 = r4 + r0
            int r0 = r6.getViewportEndOffset()
            int r4 = r4 - r0
            int r0 = java.lang.Math.min(r3, r4)
            int r3 = -r7
            if (r0 <= r3) goto L_0x00b2
            goto L_0x0089
        L_0x0071:
            int r0 = r6.getViewportStartOffset()
            int r3 = r3.getOffset()
            int r0 = r0 - r3
            int r3 = r6.getViewportEndOffset()
            int r4 = r4.getOffset()
            int r3 = r3 - r4
            int r0 = java.lang.Math.min(r0, r3)
            if (r0 <= r7) goto L_0x00b2
        L_0x0089:
            float r0 = r6.currentPageOffsetFraction
            float r0 = r0 - r1
            r6.currentPageOffsetFraction = r0
            int r0 = r6.firstVisiblePageScrollOffset
            int r0 = r0 - r7
            r6.firstVisiblePageScrollOffset = r0
            java.util.List r0 = r6.getVisiblePagesInfo()
            int r1 = r0.size()
        L_0x009b:
            if (r2 >= r1) goto L_0x00a9
            java.lang.Object r3 = r0.get(r2)
            androidx.compose.foundation.pager.MeasuredPage r3 = (androidx.compose.foundation.pager.MeasuredPage) r3
            r3.applyScrollDelta(r7)
            int r2 = r2 + 1
            goto L_0x009b
        L_0x00a9:
            boolean r0 = r6.canScrollForward
            r2 = 1
            if (r0 != 0) goto L_0x00b2
            if (r7 <= 0) goto L_0x00b2
            r6.canScrollForward = r2
        L_0x00b2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerMeasureResult.tryToApplyScrollWithoutRemeasure(int):boolean");
    }
}
