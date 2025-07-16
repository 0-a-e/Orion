package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeMeasuringIntrinsics;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "intrinsicMeasurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: IntermediateLayoutModifierNode.kt */
final class IntermediateLayoutModifierNode$minIntermediateIntrinsicHeight$1 implements NodeMeasuringIntrinsics.MeasureBlock {
    final /* synthetic */ IntermediateLayoutModifierNode this$0;

    IntermediateLayoutModifierNode$minIntermediateIntrinsicHeight$1(IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
        this.this$0 = intermediateLayoutModifierNode;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m5303measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        return this.this$0.getMeasureBlock$ui_release().invoke(this.this$0.intermediateMeasureScope, measurable, Constraints.m6514boximpl(j));
    }
}
