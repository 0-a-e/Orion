package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\u0010\fJ&\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!R,\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/WrapContentNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "unbounded", "", "alignmentCallback", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/IntOffset;", "(Landroidx/compose/foundation/layout/Direction;ZLkotlin/jvm/functions/Function2;)V", "getAlignmentCallback", "()Lkotlin/jvm/functions/Function2;", "setAlignmentCallback", "(Lkotlin/jvm/functions/Function2;)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getUnbounded", "()Z", "setUnbounded", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {
    private Function2<? super IntSize, ? super LayoutDirection, IntOffset> alignmentCallback;
    private Direction direction;
    private boolean unbounded;

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifierNode.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public final Direction getDirection() {
        return this.direction;
    }

    public final void setDirection(Direction direction2) {
        this.direction = direction2;
    }

    public final boolean getUnbounded() {
        return this.unbounded;
    }

    public final void setUnbounded(boolean z) {
        this.unbounded = z;
    }

    public final Function2<IntSize, LayoutDirection, IntOffset> getAlignmentCallback() {
        return this.alignmentCallback;
    }

    public final void setAlignmentCallback(Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2) {
        this.alignmentCallback = function2;
    }

    public WrapContentNode(Direction direction2, boolean z, Function2<? super IntSize, ? super LayoutDirection, IntOffset> function2) {
        this.direction = direction2;
        this.unbounded = z;
        this.alignmentCallback = function2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m804measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int i;
        int i2 = 0;
        int r0 = this.direction != Direction.Vertical ? 0 : Constraints.m6528getMinWidthimpl(j);
        if (this.direction == Direction.Horizontal) {
            i2 = Constraints.m6527getMinHeightimpl(j);
        }
        int i3 = Integer.MAX_VALUE;
        if (this.direction == Direction.Vertical || !this.unbounded) {
            i = Constraints.m6526getMaxWidthimpl(j);
        } else {
            i = Integer.MAX_VALUE;
        }
        if (this.direction == Direction.Horizontal || !this.unbounded) {
            i3 = Constraints.m6525getMaxHeightimpl(j);
        }
        Placeable r3 = measurable.m5368measureBRTryo0(ConstraintsKt.Constraints(r0, i, i2, i3));
        int coerceIn = RangesKt.coerceIn(r3.getWidth(), Constraints.m6528getMinWidthimpl(j), Constraints.m6526getMaxWidthimpl(j));
        int coerceIn2 = RangesKt.coerceIn(r3.getHeight(), Constraints.m6527getMinHeightimpl(j), Constraints.m6525getMaxHeightimpl(j));
        return MeasureScope.CC.layout$default(measureScope, coerceIn, coerceIn2, (Map) null, new WrapContentNode$measure$1(this, coerceIn, r3, coerceIn2, measureScope), 4, (Object) null);
    }
}
