package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ListItemType;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$ListItemLayout$1$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ LayoutDirection $layoutDirection;

    ListItemKt$ListItemLayout$1$1(LayoutDirection layoutDirection) {
        this.$layoutDirection = layoutDirection;
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
    public final MeasureResult m1951measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        MeasureScope measureScope2 = measureScope;
        List<? extends List<? extends Measurable>> list2 = list;
        boolean z = false;
        List list3 = (List) list2.get(0);
        List list4 = (List) list2.get(1);
        List list5 = (List) list2.get(2);
        List list6 = (List) list2.get(4);
        long r9 = ConstraintsKt.m6542offsetNN6EwU(Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null), -measureScope2.m6545roundToPx0680j_4(Dp.m6614constructorimpl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())), -measureScope2.m6545roundToPx0680j_4(Dp.m6614constructorimpl(ListItemKt.getListItemVerticalPadding() * ((float) 2))));
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull((List) list2.get(3));
        Placeable r12 = measurable != null ? measurable.m5368measureBRTryo0(r9) : null;
        int widthOrZero = TextFieldImplKt.widthOrZero(r12);
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull(list6);
        Placeable r19 = measurable2 != null ? measurable2.m5368measureBRTryo0(ConstraintsKt.m6543offsetNN6EwU$default(r9, -widthOrZero, 0, 2, (Object) null)) : null;
        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(r19);
        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull(list3);
        Placeable r13 = measurable3 != null ? measurable3.m5368measureBRTryo0(ConstraintsKt.m6543offsetNN6EwU$default(r9, -widthOrZero2, 0, 2, (Object) null)) : null;
        int heightOrZero = TextFieldImplKt.heightOrZero(r13);
        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull(list5);
        Placeable r14 = measurable4 != null ? measurable4.m5368measureBRTryo0(ConstraintsKt.m6542offsetNN6EwU(r9, -widthOrZero2, -heightOrZero)) : null;
        int heightOrZero2 = heightOrZero + TextFieldImplKt.heightOrZero(r14);
        boolean z2 = (r14 == null || r14.get(AlignmentLineKt.getFirstBaseline()) == r14.get(AlignmentLineKt.getLastBaseline())) ? false : true;
        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull(list4);
        Placeable r15 = measurable5 != null ? measurable5.m5368measureBRTryo0(ConstraintsKt.m6542offsetNN6EwU(r9, -widthOrZero2, -heightOrZero2)) : null;
        ListItemType.Companion companion = ListItemType.Companion;
        boolean z3 = r15 != null;
        if (r14 != null) {
            z = true;
        }
        int r92 = companion.m1961getListItemTypeZLSjz4$material3_release(z3, z, z2);
        boolean r16 = ListItemType.m1956equalsimpl0(r92, ListItemType.Companion.m1963getThreeLineAlXitO8());
        PaddingValues r17 = PaddingKt.m666PaddingValuesa9UjIt4(ListItemKt.getListItemStartPadding(), r16 ? ListItemKt.getListItemThreeLineVerticalPadding() : ListItemKt.getListItemVerticalPadding(), ListItemKt.getListItemEndPadding(), r16 ? ListItemKt.getListItemThreeLineVerticalPadding() : ListItemKt.getListItemVerticalPadding());
        MeasureScope measureScope3 = measureScope;
        Placeable placeable = r12;
        Placeable placeable2 = r19;
        Placeable placeable3 = r13;
        Placeable placeable4 = r15;
        Placeable placeable5 = r14;
        PaddingValues paddingValues = r17;
        int i = r92;
        long j2 = j;
        return ListItemKt.place(measureScope3, ListItemKt.m1950calculateWidthxygx4p4(measureScope3, placeable, placeable2, placeable3, placeable4, placeable5, this.$layoutDirection, paddingValues, j2), ListItemKt.m1949calculateHeightN4Jib3Y(measureScope3, placeable, placeable2, placeable3, placeable4, placeable5, i, paddingValues, j2), r12, r19, r13, r15, r14, r16, this.$layoutDirection, r17);
    }
}
