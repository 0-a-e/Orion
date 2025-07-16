package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0002\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "placements", "Lkotlin/Function0;", "", "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BasicText.kt */
final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;

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

    public TextMeasurePolicy(Function0<? extends List<Rect>> function0) {
        this.placements = function0;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m1159measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Pair pair;
        List invoke = this.placements.invoke();
        List list2 = null;
        if (invoke != null) {
            ArrayList arrayList = new ArrayList(invoke.size());
            int size = invoke.size();
            for (int i = 0; i < size; i++) {
                Rect rect = (Rect) invoke.get(i);
                if (rect != null) {
                    pair = new Pair(((Measurable) list.get(i)).m5368measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) ((float) Math.floor((double) rect.getWidth())), 0, (int) ((float) Math.floor((double) rect.getHeight())), 5, (Object) null)), IntOffset.m6739boximpl(IntOffsetKt.IntOffset(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()))));
                } else {
                    List<? extends Measurable> list3 = list;
                    pair = null;
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            list2 = arrayList;
        }
        return MeasureScope.CC.layout$default(measureScope, Constraints.m6526getMaxWidthimpl(j), Constraints.m6525getMaxHeightimpl(j), (Map) null, new TextMeasurePolicy$measure$1(list2), 4, (Object) null);
    }
}
