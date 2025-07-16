package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u0016\u0010\u0013\u001a\u00020\tHÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u000bHÂ\u0003J\t\u0010\u0017\u001a\u00020\rHÂ\u0003JS\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\"\u0010#\u001a\u00020 *\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020 H\u0016J\"\u0010)\u001a\u00020 *\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010*\u001a\u00020 H\u0016J,\u0010+\u001a\u00020,*\u00020-2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020.0&2\u0006\u0010/\u001a\u000200H\u0016ø\u0001\u0000¢\u0006\u0004\b1\u00102J\"\u00103\u001a\u00020 *\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010(\u001a\u00020 H\u0016J\"\u00104\u001a\u00020 *\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010*\u001a\u00020 H\u0016R\u0016\u0010\b\u001a\u00020\tX\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00065"}, d2 = {"Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSize", "Landroidx/compose/foundation/layout/SizeMode;", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "component1", "component2", "component3", "component4", "component4-D9Ej5fM", "()F", "component5", "component6", "copy", "copy-gwO9Abs", "(Landroidx/compose/foundation/layout/LayoutOrientation;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;)Landroidx/compose/foundation/layout/RowColumnMeasurePolicy;", "equals", "", "other", "", "hashCode", "", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class RowColumnMeasurePolicy implements MeasurePolicy {
    public static final int $stable = 0;
    private final float arrangementSpacing;
    private final CrossAxisAlignment crossAxisAlignment;
    private final SizeMode crossAxisSize;
    private final Arrangement.Horizontal horizontalArrangement;
    private final LayoutOrientation orientation;
    private final Arrangement.Vertical verticalArrangement;

    public /* synthetic */ RowColumnMeasurePolicy(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutOrientation, horizontal, vertical, f, sizeMode, crossAxisAlignment2);
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
    private final float m709component4D9Ej5fM() {
        return this.arrangementSpacing;
    }

    private final SizeMode component5() {
        return this.crossAxisSize;
    }

    private final CrossAxisAlignment component6() {
        return this.crossAxisAlignment;
    }

    /* renamed from: copy-gwO9Abs$default  reason: not valid java name */
    public static /* synthetic */ RowColumnMeasurePolicy m710copygwO9Abs$default(RowColumnMeasurePolicy rowColumnMeasurePolicy, LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2, int i, Object obj) {
        if ((i & 1) != 0) {
            layoutOrientation = rowColumnMeasurePolicy.orientation;
        }
        if ((i & 2) != 0) {
            horizontal = rowColumnMeasurePolicy.horizontalArrangement;
        }
        Arrangement.Horizontal horizontal2 = horizontal;
        if ((i & 4) != 0) {
            vertical = rowColumnMeasurePolicy.verticalArrangement;
        }
        Arrangement.Vertical vertical2 = vertical;
        if ((i & 8) != 0) {
            f = rowColumnMeasurePolicy.arrangementSpacing;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            sizeMode = rowColumnMeasurePolicy.crossAxisSize;
        }
        SizeMode sizeMode2 = sizeMode;
        if ((i & 32) != 0) {
            crossAxisAlignment2 = rowColumnMeasurePolicy.crossAxisAlignment;
        }
        return rowColumnMeasurePolicy.m711copygwO9Abs(layoutOrientation, horizontal2, vertical2, f2, sizeMode2, crossAxisAlignment2);
    }

    /* renamed from: copy-gwO9Abs  reason: not valid java name */
    public final RowColumnMeasurePolicy m711copygwO9Abs(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2) {
        return new RowColumnMeasurePolicy(layoutOrientation, horizontal, vertical, f, sizeMode, crossAxisAlignment2, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RowColumnMeasurePolicy)) {
            return false;
        }
        RowColumnMeasurePolicy rowColumnMeasurePolicy = (RowColumnMeasurePolicy) obj;
        return this.orientation == rowColumnMeasurePolicy.orientation && Intrinsics.areEqual((Object) this.horizontalArrangement, (Object) rowColumnMeasurePolicy.horizontalArrangement) && Intrinsics.areEqual((Object) this.verticalArrangement, (Object) rowColumnMeasurePolicy.verticalArrangement) && Dp.m6619equalsimpl0(this.arrangementSpacing, rowColumnMeasurePolicy.arrangementSpacing) && this.crossAxisSize == rowColumnMeasurePolicy.crossAxisSize && Intrinsics.areEqual((Object) this.crossAxisAlignment, (Object) rowColumnMeasurePolicy.crossAxisAlignment);
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
        return ((((((hashCode2 + i) * 31) + Dp.m6620hashCodeimpl(this.arrangementSpacing)) * 31) + this.crossAxisSize.hashCode()) * 31) + this.crossAxisAlignment.hashCode();
    }

    public String toString() {
        return "RowColumnMeasurePolicy(orientation=" + this.orientation + ", horizontalArrangement=" + this.horizontalArrangement + ", verticalArrangement=" + this.verticalArrangement + ", arrangementSpacing=" + Dp.m6625toStringimpl(this.arrangementSpacing) + ", crossAxisSize=" + this.crossAxisSize + ", crossAxisAlignment=" + this.crossAxisAlignment + ')';
    }

    private RowColumnMeasurePolicy(LayoutOrientation layoutOrientation, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f, SizeMode sizeMode, CrossAxisAlignment crossAxisAlignment2) {
        this.orientation = layoutOrientation;
        this.horizontalArrangement = horizontal;
        this.verticalArrangement = vertical;
        this.arrangementSpacing = f;
        this.crossAxisSize = sizeMode;
        this.crossAxisAlignment = crossAxisAlignment2;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m712measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int i2;
        RowColumnMeasurementHelper rowColumnMeasurementHelper = new RowColumnMeasurementHelper(this.orientation, this.horizontalArrangement, this.verticalArrangement, this.arrangementSpacing, this.crossAxisSize, this.crossAxisAlignment, list, new Placeable[list.size()], (DefaultConstructorMarker) null);
        RowColumnMeasureHelperResult r1 = rowColumnMeasurementHelper.m714measureWithoutPlacing_EkL_Y(measureScope, j, 0, list.size());
        if (this.orientation == LayoutOrientation.Horizontal) {
            i2 = r1.getMainAxisSize();
            i = r1.getCrossAxisSize();
        } else {
            i2 = r1.getCrossAxisSize();
            i = r1.getMainAxisSize();
        }
        int i3 = i;
        MeasureScope measureScope2 = measureScope;
        return MeasureScope.CC.layout$default(measureScope, i2, i3, (Map) null, new RowColumnMeasurePolicy$measure$1(rowColumnMeasurementHelper, r1, measureScope), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return ((Number) RowColumnImplKt.MinIntrinsicWidthMeasureBlock(this.orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m6545roundToPx0680j_4(this.arrangementSpacing)))).intValue();
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return ((Number) RowColumnImplKt.MinIntrinsicHeightMeasureBlock(this.orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m6545roundToPx0680j_4(this.arrangementSpacing)))).intValue();
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return ((Number) RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(this.orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m6545roundToPx0680j_4(this.arrangementSpacing)))).intValue();
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return ((Number) RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(this.orientation).invoke(list, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.m6545roundToPx0680j_4(this.arrangementSpacing)))).intValue();
    }
}
