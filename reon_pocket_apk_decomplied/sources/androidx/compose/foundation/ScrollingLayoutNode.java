package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J&\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001c\u0010!\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\"\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0012H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\f\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "scrollerState", "Landroidx/compose/foundation/ScrollState;", "isReversed", "", "isVertical", "(Landroidx/compose/foundation/ScrollState;ZZ)V", "()Z", "setReversed", "(Z)V", "setVertical", "getScrollerState", "()Landroidx/compose/foundation/ScrollState;", "setScrollerState", "(Landroidx/compose/foundation/ScrollState;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
public final class ScrollingLayoutNode extends Modifier.Node implements LayoutModifierNode {
    public static final int $stable = 8;
    private boolean isReversed;
    private boolean isVertical;
    private ScrollState scrollerState;

    public final ScrollState getScrollerState() {
        return this.scrollerState;
    }

    public final void setScrollerState(ScrollState scrollState) {
        this.scrollerState = scrollState;
    }

    public final boolean isReversed() {
        return this.isReversed;
    }

    public final void setReversed(boolean z) {
        this.isReversed = z;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final void setVertical(boolean z) {
        this.isVertical = z;
    }

    public ScrollingLayoutNode(ScrollState scrollState, boolean z, boolean z2) {
        this.scrollerState = scrollState;
        this.isReversed = z;
        this.isVertical = z2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m324measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        CheckScrollableContainerConstraintsKt.m242checkScrollableContainerConstraintsK40F9xA(j, this.isVertical ? Orientation.Vertical : Orientation.Horizontal);
        int i = Integer.MAX_VALUE;
        int r7 = this.isVertical ? Integer.MAX_VALUE : Constraints.m6525getMaxHeightimpl(j);
        if (this.isVertical) {
            i = Constraints.m6526getMaxWidthimpl(j);
        }
        Placeable r12 = measurable.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, i, 0, r7, 5, (Object) null));
        int coerceAtMost = RangesKt.coerceAtMost(r12.getWidth(), Constraints.m6526getMaxWidthimpl(j));
        int coerceAtMost2 = RangesKt.coerceAtMost(r12.getHeight(), Constraints.m6525getMaxHeightimpl(j));
        int height = r12.getHeight() - coerceAtMost2;
        int width = r12.getWidth() - coerceAtMost;
        if (!this.isVertical) {
            height = width;
        }
        this.scrollerState.setMaxValue$foundation_release(height);
        this.scrollerState.setViewportSize$foundation_release(this.isVertical ? coerceAtMost2 : coerceAtMost);
        return MeasureScope.CC.layout$default(measureScope, coerceAtMost, coerceAtMost2, (Map) null, new ScrollingLayoutNode$measure$1(this, height, r12), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.isVertical) {
            return intrinsicMeasurable.minIntrinsicWidth(Integer.MAX_VALUE);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.isVertical) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.isVertical) {
            return intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.isVertical) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }
}
