package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J,\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "alignment", "Landroidx/compose/ui/Alignment;", "propagateMinConstraints", "", "(Landroidx/compose/ui/Alignment;Z)V", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Box.kt */
final class BoxMeasurePolicy implements MeasurePolicy {
    /* access modifiers changed from: private */
    public final Alignment alignment;
    private final boolean propagateMinConstraints;

    private final Alignment component1() {
        return this.alignment;
    }

    private final boolean component2() {
        return this.propagateMinConstraints;
    }

    public static /* synthetic */ BoxMeasurePolicy copy$default(BoxMeasurePolicy boxMeasurePolicy, Alignment alignment2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            alignment2 = boxMeasurePolicy.alignment;
        }
        if ((i & 2) != 0) {
            z = boxMeasurePolicy.propagateMinConstraints;
        }
        return boxMeasurePolicy.copy(alignment2, z);
    }

    public final BoxMeasurePolicy copy(Alignment alignment2, boolean z) {
        return new BoxMeasurePolicy(alignment2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) obj;
        return Intrinsics.areEqual((Object) this.alignment, (Object) boxMeasurePolicy.alignment) && this.propagateMinConstraints == boxMeasurePolicy.propagateMinConstraints;
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.propagateMinConstraints);
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.alignment + ", propagateMinConstraints=" + this.propagateMinConstraints + ')';
    }

    public BoxMeasurePolicy(Alignment alignment2, boolean z) {
        this.alignment = alignment2;
        this.propagateMinConstraints = z;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m585measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        long j2;
        int i;
        int i2;
        Placeable placeable;
        List<? extends Measurable> list2 = list;
        if (list.isEmpty()) {
            return MeasureScope.CC.layout$default(measureScope, Constraints.m6528getMinWidthimpl(j), Constraints.m6527getMinHeightimpl(j), (Map) null, BoxMeasurePolicy$measure$1.INSTANCE, 4, (Object) null);
        }
        if (this.propagateMinConstraints) {
            j2 = j;
        } else {
            j2 = Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        }
        if (list.size() == 1) {
            Measurable measurable = (Measurable) list2.get(0);
            if (!BoxKt.getMatchesParentSize(measurable)) {
                placeable = measurable.m5368measureBRTryo0(j2);
                i2 = Math.max(Constraints.m6528getMinWidthimpl(j), placeable.getWidth());
                i = Math.max(Constraints.m6527getMinHeightimpl(j), placeable.getHeight());
            } else {
                i2 = Constraints.m6528getMinWidthimpl(j);
                i = Constraints.m6527getMinHeightimpl(j);
                placeable = measurable.m5368measureBRTryo0(Constraints.Companion.m6534fixedJhjzzOo(Constraints.m6528getMinWidthimpl(j), Constraints.m6527getMinHeightimpl(j)));
            }
            int i3 = i2;
            int i4 = i;
            return MeasureScope.CC.layout$default(measureScope, i3, i4, (Map) null, new BoxMeasurePolicy$measure$2(placeable, measurable, measureScope, i3, i4, this), 4, (Object) null);
        }
        Placeable[] placeableArr = new Placeable[list.size()];
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Constraints.m6528getMinWidthimpl(j);
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = Constraints.m6527getMinHeightimpl(j);
        int size = list.size();
        boolean z = false;
        for (int i5 = 0; i5 < size; i5++) {
            Measurable measurable2 = (Measurable) list2.get(i5);
            if (!BoxKt.getMatchesParentSize(measurable2)) {
                Placeable r12 = measurable2.m5368measureBRTryo0(j2);
                placeableArr[i5] = r12;
                intRef.element = Math.max(intRef.element, r12.getWidth());
                intRef2.element = Math.max(intRef2.element, r12.getHeight());
            } else {
                z = true;
            }
        }
        if (z) {
            long Constraints = ConstraintsKt.Constraints(intRef.element != Integer.MAX_VALUE ? intRef.element : 0, intRef.element, intRef2.element != Integer.MAX_VALUE ? intRef2.element : 0, intRef2.element);
            int size2 = list.size();
            for (int i6 = 0; i6 < size2; i6++) {
                Measurable measurable3 = (Measurable) list2.get(i6);
                if (BoxKt.getMatchesParentSize(measurable3)) {
                    placeableArr[i6] = measurable3.m5368measureBRTryo0(Constraints);
                }
            }
        }
        return MeasureScope.CC.layout$default(measureScope, intRef.element, intRef2.element, (Map) null, new BoxMeasurePolicy$measure$5(placeableArr, list, measureScope, intRef, intRef2, this), 4, (Object) null);
    }
}
