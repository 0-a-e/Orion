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
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001c\u0010\u0015\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J$\u0010\u0017\u001a\u00020\u0018*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u001b\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u001c\u0010\u001c\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001d"}, d2 = {"Landroidx/compose/foundation/layout/IntrinsicSizeModifier;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "enforceIncoming", "", "getEnforceIncoming", "()Z", "calculateContentConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "calculateContentConstraints-l58MMJ0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Intrinsic.kt */
abstract class IntrinsicSizeModifier extends Modifier.Node implements LayoutModifierNode {
    /* renamed from: calculateContentConstraints-l58MMJ0  reason: not valid java name */
    public abstract long m620calculateContentConstraintsl58MMJ0(MeasureScope measureScope, Measurable measurable, long j);

    public abstract boolean getEnforceIncoming();

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m621measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long r0 = m620calculateContentConstraintsl58MMJ0(measureScope, measurable, j);
        if (getEnforceIncoming()) {
            r0 = ConstraintsKt.m6538constrainN9IONVI(j, r0);
        }
        Placeable r9 = measurable.m5368measureBRTryo0(r0);
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new IntrinsicSizeModifier$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }
}
