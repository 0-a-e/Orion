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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u001f\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010%\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016J&\u0010'\u001a\u00020(*\u00020)2\u0006\u0010\"\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001bH\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001c\u0010.\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0016J\u001c\u0010/\u001a\u00020 *\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010&\u001a\u00020 H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0007\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0006\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0005\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0012R\"\u0010\u0003\u001a\u00020\u0004X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\u001c8BX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "getMaxHeight-D9Ej5fM", "()F", "setMaxHeight-0680j_4", "(F)V", "F", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMinWidth-D9Ej5fM", "setMinWidth-0680j_4", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Size.kt */
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SizeNode(float f, float f2, float f3, float f4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f2, (i & 4) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f3, (i & 8) != 0 ? Dp.Companion.m6634getUnspecifiedD9Ej5fM() : f4, z, (DefaultConstructorMarker) null);
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public final float m754getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* renamed from: setMinWidth-0680j_4  reason: not valid java name */
    public final void m759setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public final float m753getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* renamed from: setMinHeight-0680j_4  reason: not valid java name */
    public final void m758setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* renamed from: getMaxWidth-D9Ej5fM  reason: not valid java name */
    public final float m752getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    /* renamed from: setMaxWidth-0680j_4  reason: not valid java name */
    public final void m757setMaxWidth0680j_4(float f) {
        this.maxWidth = f;
    }

    /* renamed from: getMaxHeight-D9Ej5fM  reason: not valid java name */
    public final float m751getMaxHeightD9Ej5fM() {
        return this.maxHeight;
    }

    /* renamed from: setMaxHeight-0680j_4  reason: not valid java name */
    public final void m756setMaxHeight0680j_4(float f) {
        this.maxHeight = f;
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    public final void setEnforceIncoming(boolean z) {
        this.enforceIncoming = z;
    }

    private SizeNode(float f, float f2, float f3, float f4, boolean z) {
        this.minWidth = f;
        this.minHeight = f2;
        this.maxWidth = f3;
        this.maxHeight = f4;
        this.enforceIncoming = z;
    }

    /* renamed from: getTargetConstraints-OenEA2s  reason: not valid java name */
    private final long m750getTargetConstraintsOenEA2s(Density density) {
        int i;
        int coerceAtLeast;
        int i2 = 0;
        int coerceAtLeast2 = !Dp.m6619equalsimpl0(this.maxWidth, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.m6545roundToPx0680j_4(this.maxWidth), 0) : Integer.MAX_VALUE;
        int coerceAtLeast3 = !Dp.m6619equalsimpl0(this.maxHeight, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) ? RangesKt.coerceAtLeast(density.m6545roundToPx0680j_4(this.maxHeight), 0) : Integer.MAX_VALUE;
        if (Dp.m6619equalsimpl0(this.minWidth, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) || (i = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.m6545roundToPx0680j_4(this.minWidth), coerceAtLeast2), 0)) == Integer.MAX_VALUE) {
            i = 0;
        }
        if (!Dp.m6619equalsimpl0(this.minHeight, Dp.Companion.m6634getUnspecifiedD9Ej5fM()) && (coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(density.m6545roundToPx0680j_4(this.minHeight), coerceAtLeast3), 0)) != Integer.MAX_VALUE) {
            i2 = coerceAtLeast;
        }
        return ConstraintsKt.Constraints(i, coerceAtLeast2, i2, coerceAtLeast3);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m755measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long j2;
        int i;
        int i2;
        int i3;
        int i4;
        long r0 = m750getTargetConstraintsOenEA2s(measureScope);
        if (this.enforceIncoming) {
            j2 = ConstraintsKt.m6538constrainN9IONVI(j, r0);
        } else {
            if (!Dp.m6619equalsimpl0(this.minWidth, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                i = Constraints.m6528getMinWidthimpl(r0);
            } else {
                i = RangesKt.coerceAtMost(Constraints.m6528getMinWidthimpl(j), Constraints.m6526getMaxWidthimpl(r0));
            }
            if (!Dp.m6619equalsimpl0(this.maxWidth, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                i2 = Constraints.m6526getMaxWidthimpl(r0);
            } else {
                i2 = RangesKt.coerceAtLeast(Constraints.m6526getMaxWidthimpl(j), Constraints.m6528getMinWidthimpl(r0));
            }
            if (!Dp.m6619equalsimpl0(this.minHeight, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                i3 = Constraints.m6527getMinHeightimpl(r0);
            } else {
                i3 = RangesKt.coerceAtMost(Constraints.m6527getMinHeightimpl(j), Constraints.m6525getMaxHeightimpl(r0));
            }
            if (!Dp.m6619equalsimpl0(this.maxHeight, Dp.Companion.m6634getUnspecifiedD9Ej5fM())) {
                i4 = Constraints.m6525getMaxHeightimpl(r0);
            } else {
                i4 = RangesKt.coerceAtLeast(Constraints.m6525getMaxHeightimpl(j), Constraints.m6527getMinHeightimpl(r0));
            }
            j2 = ConstraintsKt.Constraints(i, i2, i3, i4);
        }
        Placeable r9 = measurable.m5368measureBRTryo0(j2);
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new SizeNode$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long r0 = m750getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6524getHasFixedWidthimpl(r0)) {
            return Constraints.m6526getMaxWidthimpl(r0);
        }
        return ConstraintsKt.m6540constrainWidthK40F9xA(r0, intrinsicMeasurable.minIntrinsicWidth(i));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long r0 = m750getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6523getHasFixedHeightimpl(r0)) {
            return Constraints.m6525getMaxHeightimpl(r0);
        }
        return ConstraintsKt.m6539constrainHeightK40F9xA(r0, intrinsicMeasurable.minIntrinsicHeight(i));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long r0 = m750getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6524getHasFixedWidthimpl(r0)) {
            return Constraints.m6526getMaxWidthimpl(r0);
        }
        return ConstraintsKt.m6540constrainWidthK40F9xA(r0, intrinsicMeasurable.maxIntrinsicWidth(i));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        long r0 = m750getTargetConstraintsOenEA2s(intrinsicMeasureScope);
        if (Constraints.m6523getHasFixedHeightimpl(r0)) {
            return Constraints.m6525getMaxHeightimpl(r0);
        }
        return ConstraintsKt.m6539constrainHeightK40F9xA(r0, intrinsicMeasurable.maxIntrinsicHeight(i));
    }
}
