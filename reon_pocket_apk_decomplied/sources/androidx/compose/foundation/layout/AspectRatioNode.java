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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010&\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J \u0010,\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J \u0010.\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AspectRatio.kt */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m583measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long r0 = m574findSizeToXhtMw(j);
        if (!IntSize.m6788equalsimpl0(r0, IntSize.Companion.m6795getZeroYbymL2g())) {
            j = Constraints.Companion.m6534fixedJhjzzOo(IntSize.m6790getWidthimpl(r0), IntSize.m6789getHeightimpl(r0));
        }
        Placeable r9 = measurable.m5368measureBRTryo0(j);
        return MeasureScope.CC.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new AspectRatioNode$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) i) * this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) i) * this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) i) / this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) i) / this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: findSize-ToXhtMw  reason: not valid java name */
    private final long m574findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long r2 = m578tryMaxWidthJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m6788equalsimpl0(r2, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r2;
            }
            long r22 = m576tryMaxHeightJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m6788equalsimpl0(r22, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r22;
            }
            long r23 = m582tryMinWidthJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m6788equalsimpl0(r23, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r23;
            }
            long r24 = m580tryMinHeightJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m6788equalsimpl0(r24, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r24;
            }
            long r25 = m577tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m6788equalsimpl0(r25, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r25;
            }
            long r26 = m575tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m6788equalsimpl0(r26, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r26;
            }
            long r27 = m581tryMinWidthJN0ABg(j, false);
            if (!IntSize.m6788equalsimpl0(r27, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r27;
            }
            long r11 = m579tryMinHeightJN0ABg(j, false);
            if (!IntSize.m6788equalsimpl0(r11, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r11;
            }
        } else {
            long r28 = m576tryMaxHeightJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m6788equalsimpl0(r28, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r28;
            }
            long r29 = m578tryMaxWidthJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m6788equalsimpl0(r29, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r29;
            }
            long r210 = m580tryMinHeightJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m6788equalsimpl0(r210, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r210;
            }
            long r211 = m582tryMinWidthJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m6788equalsimpl0(r211, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r211;
            }
            long r212 = m575tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m6788equalsimpl0(r212, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r212;
            }
            long r213 = m577tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m6788equalsimpl0(r213, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r213;
            }
            long r214 = m579tryMinHeightJN0ABg(j, false);
            if (!IntSize.m6788equalsimpl0(r214, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r214;
            }
            long r112 = m581tryMinWidthJN0ABg(j, false);
            if (!IntSize.m6788equalsimpl0(r112, IntSize.Companion.m6795getZeroYbymL2g())) {
                return r112;
            }
        }
        return IntSize.Companion.m6795getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m578tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m577tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg  reason: not valid java name */
    private final long m577tryMaxWidthJN0ABg(long j, boolean z) {
        int roundToInt;
        int r0 = Constraints.m6526getMaxWidthimpl(j);
        if (r0 != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(((float) r0) / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(r0, roundToInt);
            if (!z || ConstraintsKt.m6541isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m6795getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m576tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m575tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg  reason: not valid java name */
    private final long m575tryMaxHeightJN0ABg(long j, boolean z) {
        int roundToInt;
        int r0 = Constraints.m6525getMaxHeightimpl(j);
        if (r0 != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(((float) r0) * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, r0);
            if (!z || ConstraintsKt.m6541isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m6795getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m582tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m581tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg  reason: not valid java name */
    private final long m581tryMinWidthJN0ABg(long j, boolean z) {
        int r0 = Constraints.m6528getMinWidthimpl(j);
        int roundToInt = MathKt.roundToInt(((float) r0) / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(r0, roundToInt);
            if (!z || ConstraintsKt.m6541isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m6795getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m580tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioNode.m579tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg  reason: not valid java name */
    private final long m579tryMinHeightJN0ABg(long j, boolean z) {
        int r0 = Constraints.m6527getMinHeightimpl(j);
        int roundToInt = MathKt.roundToInt(((float) r0) * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, r0);
            if (!z || ConstraintsKt.m6541isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m6795getZeroYbymL2g();
    }
}
