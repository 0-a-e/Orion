package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$CircularLayout$1$1 implements MeasurePolicy {
    final /* synthetic */ float $radius;

    TimePickerKt$CircularLayout$1$1(float f) {
        this.$radius = f;
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

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2492measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        Object obj2;
        List<? extends Measurable> list2 = list;
        final float r10 = measureScope.m6550toPx0680j_4(this.$radius);
        long r4 = Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj3 = list2.get(i2);
            Measurable measurable = (Measurable) obj3;
            if (!(LayoutIdKt.getLayoutId(measurable) == LayoutId.Selector || LayoutIdKt.getLayoutId(measurable) == LayoutId.InnerCircle)) {
                arrayList.add(obj3);
            }
        }
        List list3 = arrayList;
        ArrayList arrayList2 = new ArrayList(list3.size());
        int size2 = list3.size();
        for (int i3 = 0; i3 < size2; i3++) {
            arrayList2.add(((Measurable) list3.get(i3)).m5368measureBRTryo0(r4));
        }
        final List list4 = arrayList2;
        int size3 = list.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                obj = null;
                break;
            }
            obj = list2.get(i4);
            if (LayoutIdKt.getLayoutId((Measurable) obj) == LayoutId.Selector) {
                break;
            }
            i4++;
        }
        Measurable measurable2 = (Measurable) obj;
        int size4 = list.size();
        while (true) {
            if (i >= size4) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i);
            if (LayoutIdKt.getLayoutId((Measurable) obj2) == LayoutId.InnerCircle) {
                break;
            }
            i++;
        }
        Measurable measurable3 = (Measurable) obj2;
        float size5 = 6.2831855f / ((float) list4.size());
        Placeable r2 = measurable2 != null ? measurable2.m5368measureBRTryo0(r4) : null;
        final Placeable r7 = measurable3 != null ? measurable3.m5368measureBRTryo0(r4) : null;
        final Placeable placeable = r2;
        final long j2 = j;
        final float f = size5;
        return MeasureScope.CC.layout$default(measureScope, Constraints.m6528getMinWidthimpl(j), Constraints.m6527getMinHeightimpl(j), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable placeable = placeable;
                if (placeable != null) {
                    Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, (Object) null);
                }
                List<Placeable> list = list4;
                long j = j2;
                float f = r10;
                float f2 = f;
                int size = list.size();
                int i = 0;
                while (i < size) {
                    Placeable placeable2 = list.get(i);
                    int r8 = (Constraints.m6526getMaxWidthimpl(j) / 2) - (placeable2.getWidth() / 2);
                    int r9 = (Constraints.m6525getMaxHeightimpl(j) / 2) - (placeable2.getHeight() / 2);
                    double d = (double) f;
                    double d2 = ((double) (((float) i) * f2)) - 1.5707963267948966d;
                    List<Placeable> list2 = list;
                    double cos = (Math.cos(d2) * d) + ((double) r8);
                    double sin = (d * Math.sin(d2)) + ((double) r9);
                    Placeable.PlacementScope.place$default(placementScope, placeable2, MathKt.roundToInt(cos), MathKt.roundToInt(sin), 0.0f, 4, (Object) null);
                    i++;
                    list = list2;
                    j = j;
                }
                Placeable placeable3 = r7;
                if (placeable3 != null) {
                    Placeable.PlacementScope.place$default(placementScope, placeable3, (Constraints.m6528getMinWidthimpl(j2) - r7.getWidth()) / 2, (Constraints.m6527getMinHeightimpl(j2) - r7.getHeight()) / 2, 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
