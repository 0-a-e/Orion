package androidx.compose.ui.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: RootMeasurePolicy.kt */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final int $stable = 0;
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m5419measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        if (list.isEmpty()) {
            return MeasureScope.CC.layout$default(measureScope, Constraints.m6528getMinWidthimpl(j), Constraints.m6527getMinHeightimpl(j), (Map) null, RootMeasurePolicy$measure$1.INSTANCE, 4, (Object) null);
        }
        if (list.size() == 1) {
            Placeable r13 = ((Measurable) list.get(0)).m5368measureBRTryo0(j);
            return MeasureScope.CC.layout$default(measureScope, ConstraintsKt.m6540constrainWidthK40F9xA(j, r13.getWidth()), ConstraintsKt.m6539constrainHeightK40F9xA(j, r13.getHeight()), (Map) null, new RootMeasurePolicy$measure$2(r13), 4, (Object) null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Measurable) list.get(i)).m5368measureBRTryo0(j));
        }
        List list2 = arrayList;
        int size2 = list2.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size2; i4++) {
            Placeable placeable = (Placeable) list2.get(i4);
            i2 = Math.max(placeable.getWidth(), i2);
            i3 = Math.max(placeable.getHeight(), i3);
        }
        return MeasureScope.CC.layout$default(measureScope, ConstraintsKt.m6540constrainWidthK40F9xA(j, i2), ConstraintsKt.m6539constrainHeightK40F9xA(j, i3), (Map) null, new RootMeasurePolicy$measure$4(list2), 4, (Object) null);
    }
}
