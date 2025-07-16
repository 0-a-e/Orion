package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutModifierNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ&\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0007\u001a\u00020\u0006X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0005\u001a\u00020\u0006X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetDpNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/Dp;", "after", "(Landroidx/compose/ui/layout/AlignmentLine;FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfter-D9Ej5fM", "()F", "setAfter-0680j_4", "(F)V", "F", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "setAlignmentLine", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getBefore-D9Ej5fM", "setBefore-0680j_4", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AlignmentLine.kt */
final class AlignmentLineOffsetDpNode extends Modifier.Node implements LayoutModifierNode {
    private float after;
    private AlignmentLine alignmentLine;
    private float before;

    public /* synthetic */ AlignmentLineOffsetDpNode(AlignmentLine alignmentLine2, float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLine2, f, f2);
    }

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

    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    public final void setAlignmentLine(AlignmentLine alignmentLine2) {
        this.alignmentLine = alignmentLine2;
    }

    /* renamed from: getBefore-D9Ej5fM  reason: not valid java name */
    public final float m516getBeforeD9Ej5fM() {
        return this.before;
    }

    /* renamed from: setBefore-0680j_4  reason: not valid java name */
    public final void m519setBefore0680j_4(float f) {
        this.before = f;
    }

    /* renamed from: getAfter-D9Ej5fM  reason: not valid java name */
    public final float m515getAfterD9Ej5fM() {
        return this.after;
    }

    /* renamed from: setAfter-0680j_4  reason: not valid java name */
    public final void m518setAfter0680j_4(float f) {
        this.after = f;
    }

    private AlignmentLineOffsetDpNode(AlignmentLine alignmentLine2, float f, float f2) {
        this.alignmentLine = alignmentLine2;
        this.before = f;
        this.after = f2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m517measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return AlignmentLineKt.m504alignmentLineOffsetMeasuretjqqzMA(measureScope, this.alignmentLine, this.before, this.after, measurable, j);
    }
}
