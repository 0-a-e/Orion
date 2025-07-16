package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/foundation/layout/PaddingValues;)V", "getPaddingValues", "()Landroidx/compose/foundation/layout/PaddingValues;", "setPaddingValues", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {
    private PaddingValues paddingValues;

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

    public final PaddingValues getPaddingValues() {
        return this.paddingValues;
    }

    public final void setPaddingValues(PaddingValues paddingValues2) {
        this.paddingValues = paddingValues2;
    }

    public PaddingValuesModifier(PaddingValues paddingValues2) {
        this.paddingValues = paddingValues2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m708measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        float f = (float) 0;
        if (Dp.m6613compareTo0680j_4(this.paddingValues.m685calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m6614constructorimpl(f)) < 0 || Dp.m6613compareTo0680j_4(this.paddingValues.m687calculateTopPaddingD9Ej5fM(), Dp.m6614constructorimpl(f)) < 0 || Dp.m6613compareTo0680j_4(this.paddingValues.m686calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()), Dp.m6614constructorimpl(f)) < 0 || Dp.m6613compareTo0680j_4(this.paddingValues.m684calculateBottomPaddingD9Ej5fM(), Dp.m6614constructorimpl(f)) < 0) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
        int r0 = measureScope.m6545roundToPx0680j_4(this.paddingValues.m685calculateLeftPaddingu2uoSUM(measureScope.getLayoutDirection())) + measureScope.m6545roundToPx0680j_4(this.paddingValues.m686calculateRightPaddingu2uoSUM(measureScope.getLayoutDirection()));
        int r1 = measureScope.m6545roundToPx0680j_4(this.paddingValues.m687calculateTopPaddingD9Ej5fM()) + measureScope.m6545roundToPx0680j_4(this.paddingValues.m684calculateBottomPaddingD9Ej5fM());
        Placeable r12 = measurable.m5368measureBRTryo0(ConstraintsKt.m6542offsetNN6EwU(j, -r0, -r1));
        return MeasureScope.CC.layout$default(measureScope, ConstraintsKt.m6540constrainWidthK40F9xA(j, r12.getWidth() + r0), ConstraintsKt.m6539constrainHeightK40F9xA(j, r12.getHeight() + r1), (Map) null, new PaddingValuesModifier$measure$2(r12, measureScope, this), 4, (Object) null);
    }
}
