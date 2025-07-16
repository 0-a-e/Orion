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
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J&\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001c\u0010\u001e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u001f\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\"\u0010\u0005\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "setMinHeight-0680j_4", "(F)V", "F", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f2, (DefaultConstructorMarker) null);
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m764getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* renamed from: setMinWidth-0680j_4  reason: not valid java name */
    public final void m767setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m763getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* renamed from: setMinHeight-0680j_4  reason: not valid java name */
    public final void m766setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    private UnspecifiedConstraintsNode(float f, float f2) {
        this.minWidth = f;
        this.minHeight = f2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m765measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int i;
        int i2;
        if (Dp.m6619equalsimpl0(this.minWidth, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) || Constraints.m6528getMinWidthimpl(j) != 0) {
            i = Constraints.m6528getMinWidthimpl(j);
        } else {
            i = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.m6545roundToPx0680j_4(this.minWidth), Constraints.m6526getMaxWidthimpl(j)), 0);
        }
        int r2 = Constraints.m6526getMaxWidthimpl(j);
        if (Dp.m6619equalsimpl0(this.minHeight, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) || Constraints.m6527getMinHeightimpl(j) != 0) {
            i2 = Constraints.m6527getMinHeightimpl(j);
        } else {
            i2 = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(measureScope.m6545roundToPx0680j_4(this.minHeight), Constraints.m6525getMaxHeightimpl(j)), 0);
        }
        Placeable r9 = measurable.m5368measureBRTryo0(ConstraintsKt.Constraints(i, r2, i2, Constraints.m6525getMaxHeightimpl(j)));
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new UnspecifiedConstraintsNode$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicWidth(i), !Dp.m6619equalsimpl0(this.minWidth, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.m6545roundToPx0680j_4(this.minWidth) : 0);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicWidth(i), !Dp.m6619equalsimpl0(this.minWidth, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.m6545roundToPx0680j_4(this.minWidth) : 0);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.minIntrinsicHeight(i), !Dp.m6619equalsimpl0(this.minHeight, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.m6545roundToPx0680j_4(this.minHeight) : 0);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return RangesKt.coerceAtLeast(intrinsicMeasurable.maxIntrinsicHeight(i), !Dp.m6619equalsimpl0(this.minHeight, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.m6545roundToPx0680j_4(this.minHeight) : 0);
    }
}
