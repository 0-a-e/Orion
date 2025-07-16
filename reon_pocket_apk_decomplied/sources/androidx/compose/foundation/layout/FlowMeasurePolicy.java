package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÂ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u0016\u0010\"\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\t\u0010%\u001a\u00020\u000bHÂ\u0003J\t\u0010&\u001a\u00020\rHÂ\u0003J\u0016\u0010'\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010$J\t\u0010)\u001a\u00020\u0010HÂ\u0003Jg\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0010HÖ\u0001J,\u00102\u001a\u00020\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0015042\u0006\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010J$\u00108\u001a\u00020\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0015042\u0006\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0010J,\u0010;\u001a\u00020\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0015042\u0006\u0010<\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010J\t\u0010=\u001a\u00020>HÖ\u0001J\"\u0010?\u001a\u00020\u0010*\u00020@2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0015042\u0006\u0010A\u001a\u00020\u0010H\u0016J\"\u0010B\u001a\u00020\u0010*\u00020@2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0015042\u0006\u00109\u001a\u00020\u0010H\u0016J,\u0010C\u001a\u00020D*\u00020E2\f\u00103\u001a\b\u0012\u0004\u0012\u00020F042\u0006\u0010G\u001a\u00020HH\u0016ø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\"\u0010K\u001a\u00020\u0010*\u00020@2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0015042\u0006\u0010A\u001a\u00020\u0010H\u0016J\"\u0010L\u001a\u00020\u0010*\u00020@2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u0015042\u0006\u00109\u001a\u00020\u0010H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u00020\tX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\tX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0012R.\u0010\u0013\u001a\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0019\u001a\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R.\u0010\u001b\u001a\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R.\u0010\u001d\u001a\u001f\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006M"}, d2 = {"Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "mainAxisArrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "crossAxisArrangementSpacing", "maxItemsInMainAxis", "", "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;FILkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "maxCrossAxisIntrinsicItemSize", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "Lkotlin/ExtensionFunctionType;", "getMaxCrossAxisIntrinsicItemSize", "()Lkotlin/jvm/functions/Function3;", "maxMainAxisIntrinsicItemSize", "getMaxMainAxisIntrinsicItemSize", "minCrossAxisIntrinsicItemSize", "getMinCrossAxisIntrinsicItemSize", "minMainAxisIntrinsicItemSize", "getMinMainAxisIntrinsicItemSize", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "component7", "component7-D9Ej5fM", "component8", "copy", "copy-cBR-a5Y", "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;FI)Landroidx/compose/foundation/layout/FlowMeasurePolicy;", "equals", "", "other", "", "hashCode", "intrinsicCrossAxisSize", "measurables", "", "mainAxisAvailable", "mainAxisSpacing", "crossAxisSpacing", "maxIntrinsicMainAxisSize", "height", "arrangementSpacing", "minIntrinsicMainAxisSize", "crossAxisAvailable", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "width", "maxIntrinsicWidth", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FlowLayout.kt */
final class FlowMeasurePolicy implements MeasurePolicy {
    private final CrossAxisAlignment crossAxisAlignment;
    private final float crossAxisArrangementSpacing;
    private final SizeMode crossAxisSize;
    private final Arrangement.Horizontal horizontalArrangement;
    private final float mainAxisArrangementSpacing;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxCrossAxisIntrinsicItemSize;
    private final int maxItemsInMainAxis;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> maxMainAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minCrossAxisIntrinsicItemSize;
    private final Function3<IntrinsicMeasurable, Integer, Integer, Integer> minMainAxisIntrinsicItemSize;
    private final LayoutOrientation orientation;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ FlowMeasurePolicy(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, horizontal, vertical, f, sizeMode, crossAxisAlignment2, f2, i);
    }

    private final LayoutOrientation component1() {
        return this.orientation;
    }

    private final Arrangement.Horizontal component2() {
        return this.horizontalArrangement;
    }

    private final Arrangement.Vertical component3() {
        return this.verticalArrangement;
    }

    /* renamed from: component4-D9Ej5fM  reason: not valid java name */
    private final float m609component4D9Ej5fM() {
        return this.mainAxisArrangementSpacing;
    }

    private final SizeMode component5() {
        return this.crossAxisSize;
    }

    private final CrossAxisAlignment component6() {
        return this.crossAxisAlignment;
    }

    /* renamed from: component7-D9Ej5fM  reason: not valid java name */
    private final float m610component7D9Ej5fM() {
        return this.crossAxisArrangementSpacing;
    }

    private final int component8() {
        return this.maxItemsInMainAxis;
    }

    /* renamed from: copy-cBR-a5Y$default  reason: not valid java name */
    public static /* synthetic */ FlowMeasurePolicy m611copycBRa5Y$default(FlowMeasurePolicy flowMeasurePolicy, LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, float f2, int i, int i2, Object obj) {
        FlowMeasurePolicy flowMeasurePolicy2 = flowMeasurePolicy;
        int i3 = i2;
        return flowMeasurePolicy.m612copycBRa5Y((i3 & 1) != 0 ? flowMeasurePolicy2.orientation : layoutOrientation, (i3 & 2) != 0 ? flowMeasurePolicy2.horizontalArrangement : horizontal, (i3 & 4) != 0 ? flowMeasurePolicy2.verticalArrangement : vertical, (i3 & 8) != 0 ? flowMeasurePolicy2.mainAxisArrangementSpacing : f, (i3 & 16) != 0 ? flowMeasurePolicy2.crossAxisSize : sizeMode, (i3 & 32) != 0 ? flowMeasurePolicy2.crossAxisAlignment : crossAxisAlignment2, (i3 & 64) != 0 ? flowMeasurePolicy2.crossAxisArrangementSpacing : f2, (i3 & 128) != 0 ? flowMeasurePolicy2.maxItemsInMainAxis : i);
    }

    /* renamed from: copy-cBR-a5Y  reason: not valid java name */
    public final FlowMeasurePolicy m612copycBRa5Y(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, float f2, int i) {
        return new FlowMeasurePolicy(layoutOrientation, horizontal, vertical, f, sizeMode, crossAxisAlignment2, f2, i, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) obj;
        return this.orientation == flowMeasurePolicy.orientation && Intrinsics.areEqual((Object) this.horizontalArrangement, (Object) flowMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual((Object) this.verticalArrangement, (Object) flowMeasurePolicy.verticalArrangement) && Dp.m6619equalsimpl0(this.mainAxisArrangementSpacing, flowMeasurePolicy.mainAxisArrangementSpacing) && this.crossAxisSize == flowMeasurePolicy.crossAxisSize && Intrinsics.areEqual((Object) this.crossAxisAlignment, (Object) flowMeasurePolicy.crossAxisAlignment) && Dp.m6619equalsimpl0(this.crossAxisArrangementSpacing, flowMeasurePolicy.crossAxisArrangementSpacing) && this.maxItemsInMainAxis == flowMeasurePolicy.maxItemsInMainAxis;
    }

    public int hashCode() {
        int hashCode = this.orientation.hashCode() * 31;
        Arrangement.Horizontal horizontal = this.horizontalArrangement;
        int i = 0;
        int hashCode2 = (hashCode + (horizontal == null ? 0 : horizontal.hashCode())) * 31;
        Arrangement.Vertical vertical = this.verticalArrangement;
        if (vertical != null) {
            i = vertical.hashCode();
        }
        return ((((((((((hashCode2 + i) * 31) + Dp.m6620hashCodeimpl(this.mainAxisArrangementSpacing)) * 31) + this.crossAxisSize.hashCode()) * 31) + this.crossAxisAlignment.hashCode()) * 31) + Dp.m6620hashCodeimpl(this.crossAxisArrangementSpacing)) * 31) + this.maxItemsInMainAxis;
    }

    public String toString() {
        return "FlowMeasurePolicy(orientation=" + this.orientation + ", horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", mainAxisArrangementSpacing=" + Dp.m6625toStringimpl(this.mainAxisArrangementSpacing) + ", crossAxisSize=" + this.crossAxisSize + ", crossAxisAlignment=" + this.crossAxisAlignment + ", crossAxisArrangementSpacing=" + Dp.m6625toStringimpl(this.crossAxisArrangementSpacing) + ", maxItemsInMainAxis=" + this.maxItemsInMainAxis + ')';
    }

    private FlowMeasurePolicy(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, float f2, int i) {
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function3;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function32;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function33;
        Function3<IntrinsicMeasurable, Integer, Integer, Integer> function34;
        this.orientation = layoutOrientation;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.mainAxisArrangementSpacing = f;
        this.crossAxisSize = sizeMode;
        this.crossAxisAlignment = crossAxisAlignment2;
        this.crossAxisArrangementSpacing = f2;
        this.maxItemsInMainAxis = i;
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            function3 = FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function3 = FlowMeasurePolicy$maxMainAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.maxMainAxisIntrinsicItemSize = function3;
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            function32 = FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function32 = FlowMeasurePolicy$maxCrossAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.maxCrossAxisIntrinsicItemSize = function32;
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            function33 = FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function33 = FlowMeasurePolicy$minCrossAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.minCrossAxisIntrinsicItemSize = function33;
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            function34 = FlowMeasurePolicy$minMainAxisIntrinsicItemSize$1.INSTANCE;
        } else {
            function34 = FlowMeasurePolicy$minMainAxisIntrinsicItemSize$2.INSTANCE;
        }
        this.minMainAxisIntrinsicItemSize = function34;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m613measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        MeasureScope measureScope2 = measureScope;
        long j2 = j;
        if (list.isEmpty()) {
            return MeasureScope.CC.layout$default(measureScope, 0, 0, (Map) null, FlowMeasurePolicy$measure$1.INSTANCE, 4, (Object) null);
        }
        RowColumnMeasurementHelper rowColumnMeasurementHelper = new RowColumnMeasurementHelper(this.orientation, this.horizontalArrangement, this.verticalArrangement, this.mainAxisArrangementSpacing, this.crossAxisSize, this.crossAxisAlignment, list, new Placeable[list.size()], (DefaultConstructorMarker) null);
        MeasureScope measureScope3 = measureScope;
        RowColumnMeasurementHelper rowColumnMeasurementHelper2 = rowColumnMeasurementHelper;
        RowColumnMeasurementHelper rowColumnMeasurementHelper3 = rowColumnMeasurementHelper;
        FlowResult r1 = FlowLayoutKt.m607breakDownItemsw1Onq5I(measureScope3, rowColumnMeasurementHelper2, this.orientation, OrientationIndependentConstraints.m639constructorimpl(j2, this.orientation), this.maxItemsInMainAxis);
        MutableVector<RowColumnMeasureHelperResult> items = r1.getItems();
        int size = items.getSize();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = ((RowColumnMeasureHelperResult) items.getContent()[i2]).getCrossAxisSize();
        }
        int[] iArr2 = new int[size];
        int crossAxisTotalSize = r1.getCrossAxisTotalSize() + (measureScope2.m6545roundToPx0680j_4(this.crossAxisArrangementSpacing) * (items.getSize() - 1));
        if (this.orientation == LayoutOrientation.Horizontal) {
            Arrangement.Vertical vertical = this.verticalArrangement;
            if (vertical != null) {
                vertical.arrange(measureScope2, crossAxisTotalSize, iArr, iArr2);
            } else {
                throw new IllegalArgumentException("null verticalArrangement".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.horizontalArrangement;
            if (horizontal != null) {
                horizontal.arrange(measureScope2, crossAxisTotalSize, iArr, measureScope.getLayoutDirection(), iArr2);
            } else {
                throw new IllegalArgumentException("null horizontalArrangement".toString());
            }
        }
        if (this.orientation == LayoutOrientation.Horizontal) {
            int i3 = crossAxisTotalSize;
            crossAxisTotalSize = r1.getMainAxisTotalSize();
            i = i3;
        } else {
            i = r1.getMainAxisTotalSize();
        }
        return MeasureScope.CC.layout$default(measureScope, ConstraintsKt.m6540constrainWidthK40F9xA(j2, crossAxisTotalSize), ConstraintsKt.m6539constrainHeightK40F9xA(j2, i), (Map) null, new FlowMeasurePolicy$measure$6(r1, rowColumnMeasurementHelper3, iArr2, measureScope2), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        if (this.orientation == LayoutOrientation.Horizontal) {
            return minIntrinsicMainAxisSize(list, i, intrinsicMeasureScope.m6545roundToPx0680j_4(this.mainAxisArrangementSpacing), intrinsicMeasureScope.m6545roundToPx0680j_4(this.crossAxisArrangementSpacing));
        }
        return intrinsicCrossAxisSize(list, i, intrinsicMeasureScope.m6545roundToPx0680j_4(this.mainAxisArrangementSpacing), intrinsicMeasureScope.m6545roundToPx0680j_4(this.crossAxisArrangementSpacing));
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        if (this.orientation == LayoutOrientation.Horizontal) {
            return intrinsicCrossAxisSize(list, i, intrinsicMeasureScope.m6545roundToPx0680j_4(this.mainAxisArrangementSpacing), intrinsicMeasureScope.m6545roundToPx0680j_4(this.crossAxisArrangementSpacing));
        }
        return minIntrinsicMainAxisSize(list, i, intrinsicMeasureScope.m6545roundToPx0680j_4(this.mainAxisArrangementSpacing), intrinsicMeasureScope.m6545roundToPx0680j_4(this.crossAxisArrangementSpacing));
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        if (this.orientation == LayoutOrientation.Horizontal) {
            return intrinsicCrossAxisSize(list, i, intrinsicMeasureScope.m6545roundToPx0680j_4(this.mainAxisArrangementSpacing), intrinsicMeasureScope.m6545roundToPx0680j_4(this.crossAxisArrangementSpacing));
        }
        return maxIntrinsicMainAxisSize(list, i, intrinsicMeasureScope.m6545roundToPx0680j_4(this.mainAxisArrangementSpacing));
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        if (this.orientation == LayoutOrientation.Horizontal) {
            return maxIntrinsicMainAxisSize(list, i, intrinsicMeasureScope.m6545roundToPx0680j_4(this.mainAxisArrangementSpacing));
        }
        return intrinsicCrossAxisSize(list, i, intrinsicMeasureScope.m6545roundToPx0680j_4(this.mainAxisArrangementSpacing), intrinsicMeasureScope.m6545roundToPx0680j_4(this.crossAxisArrangementSpacing));
    }

    public final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, int i, int i2, int i3) {
        return FlowLayoutKt.minIntrinsicMainAxisSize(list, this.minMainAxisIntrinsicItemSize, this.minCrossAxisIntrinsicItemSize, i, i2, i3, this.maxItemsInMainAxis);
    }

    public final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, int i, int i2) {
        return FlowLayoutKt.maxIntrinsicMainAxisSize(list, this.maxMainAxisIntrinsicItemSize, i, i2, this.maxItemsInMainAxis);
    }

    public final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, int i, int i2, int i3) {
        return FlowLayoutKt.intrinsicCrossAxisSize(list, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minMainAxisIntrinsicItemSize, (Function3<? super IntrinsicMeasurable, ? super Integer, ? super Integer, Integer>) this.minCrossAxisIntrinsicItemSize, i, i2, i3, this.maxItemsInMainAxis);
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxMainAxisIntrinsicItemSize() {
        return this.maxMainAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMaxCrossAxisIntrinsicItemSize() {
        return this.maxCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinCrossAxisIntrinsicItemSize() {
        return this.minCrossAxisIntrinsicItemSize;
    }

    public final Function3<IntrinsicMeasurable, Integer, Integer, Integer> getMinMainAxisIntrinsicItemSize() {
        return this.minMainAxisIntrinsicItemSize;
    }
}
