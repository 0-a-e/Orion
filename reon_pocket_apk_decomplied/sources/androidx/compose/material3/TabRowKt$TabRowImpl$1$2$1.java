package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "<name for destructuring parameter 0>", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$TabRowImpl$1$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ TabRowKt$TabRowImpl$1$scope$1$1 $scope;

    TabRowKt$TabRowImpl$1$2$1(TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1) {
        this.$scope = tabRowKt$TabRowImpl$1$scope$1$1;
    }

    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MultiContentMeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MultiContentMeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
        return MultiContentMeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m2368measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        MeasureScope measureScope2 = measureScope;
        List<? extends List<? extends Measurable>> list2 = list;
        List list3 = (List) list2.get(0);
        List list4 = (List) list2.get(1);
        int i = 2;
        List list5 = (List) list2.get(2);
        int r6 = Constraints.m6526getMaxWidthimpl(j);
        int size = list3.size();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (size > 0) {
            intRef.element = r6 / size;
        }
        int i2 = 0;
        int size2 = list3.size();
        for (int i3 = 0; i3 < size2; i3++) {
            i2 = Integer.valueOf(Math.max(((Measurable) list3.get(i3)).maxIntrinsicHeight(intRef.element), i2.intValue()));
        }
        int intValue = i2.intValue();
        TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = this.$scope;
        ArrayList arrayList = new ArrayList(size);
        int i4 = 0;
        while (i4 < size) {
            arrayList.add(new TabPosition(Dp.m6614constructorimpl(measureScope2.m6547toDpu2uoSUM(intRef.element) * ((float) i4)), measureScope2.m6547toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m6612boximpl(Dp.m6614constructorimpl(measureScope2.m6547toDpu2uoSUM(Math.min(((Measurable) list3.get(i4)).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m6614constructorimpl(TabKt.getHorizontalTextPadding() * ((float) i)))), Dp.m6612boximpl(Dp.m6614constructorimpl((float) 24)))).m6628unboximpl(), (DefaultConstructorMarker) null));
            i4++;
            measureScope2 = measureScope;
            i = 2;
        }
        tabRowKt$TabRowImpl$1$scope$1$1.setTabPositions(arrayList);
        ArrayList arrayList2 = new ArrayList(list3.size());
        int size3 = list3.size();
        for (int i5 = 0; i5 < size3; i5++) {
            arrayList2.add(((Measurable) list3.get(i5)).m5368measureBRTryo0(Constraints.m6516copyZbe2FdA(j, intRef.element, intRef.element, intValue, intValue)));
        }
        final List list6 = arrayList2;
        ArrayList arrayList3 = new ArrayList(list4.size());
        int size4 = list4.size();
        for (int i6 = 0; i6 < size4; i6++) {
            arrayList3.add(((Measurable) list4.get(i6)).m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null)));
        }
        List list7 = arrayList3;
        ArrayList arrayList4 = new ArrayList(list5.size());
        int size5 = list5.size();
        for (int i7 = 0; i7 < size5; i7++) {
            arrayList4.add(((Measurable) list5.get(i7)).m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, intRef.element, intRef.element, 0, intValue, 4, (Object) null)));
        }
        final List list8 = list7;
        int i8 = intValue;
        final List list9 = arrayList4;
        final int i9 = i8;
        return MeasureScope.CC.layout$default(measureScope, r6, i8, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List<Placeable> list = list6;
                Ref.IntRef intRef = intRef;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i), i * intRef.element, 0, 0.0f, 4, (Object) null);
                }
                List<Placeable> list2 = list8;
                int i2 = i9;
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Placeable placeable = list2.get(i3);
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i2 - placeable.getHeight(), 0.0f, 4, (Object) null);
                }
                List<Placeable> list3 = list9;
                int i4 = i9;
                int size3 = list3.size();
                for (int i5 = 0; i5 < size3; i5++) {
                    Placeable placeable2 = list3.get(i5);
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, i4 - placeable2.getHeight(), 0.0f, 4, (Object) null);
                }
            }
        }, 4, (Object) null);
    }
}
