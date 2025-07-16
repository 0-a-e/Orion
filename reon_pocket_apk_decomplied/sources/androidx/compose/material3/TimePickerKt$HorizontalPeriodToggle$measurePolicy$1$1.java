package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
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
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 implements MeasurePolicy {
    public static final TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 INSTANCE = new TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1();

    TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1() {
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
    public final MeasureResult m2493measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List<? extends Measurable> list2 = list;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = (Measurable) list2.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "Spacer")) {
                final Placeable r1 = measurable.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, measureScope.m6545roundToPx0680j_4(TimePickerTokens.INSTANCE.m3186getPeriodSelectorOutlineWidthD9Ej5fM()), 0, 0, 12, (Object) null));
                ArrayList arrayList = new ArrayList(list.size());
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Object obj = list2.get(i2);
                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) "Spacer")) {
                        arrayList.add(obj);
                    }
                }
                List list3 = arrayList;
                ArrayList arrayList2 = new ArrayList(list3.size());
                int size3 = list3.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    arrayList2.add(((Measurable) list3.get(i3)).m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, Constraints.m6526getMaxWidthimpl(j) / 2, 0, 0, 12, (Object) null)));
                }
                final List list4 = arrayList2;
                return MeasureScope.CC.layout$default(measureScope, Constraints.m6526getMaxWidthimpl(j), Constraints.m6525getMaxHeightimpl(j), (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.place$default(placementScope, list4.get(0), 0, 0, 0.0f, 4, (Object) null);
                        Placeable.PlacementScope.place$default(placementScope, list4.get(1), list4.get(0).getWidth(), 0, 0.0f, 4, (Object) null);
                        Placeable.PlacementScope.place$default(placementScope, r1, list4.get(0).getWidth() - (r1.getWidth() / 2), 0, 0.0f, 4, (Object) null);
                    }
                }, 4, (Object) null);
            }
            MeasureScope measureScope2 = measureScope;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
