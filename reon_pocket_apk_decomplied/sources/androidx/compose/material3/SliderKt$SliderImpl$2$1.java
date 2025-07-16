package androidx.compose.material3;

import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$SliderImpl$2$1 implements MeasurePolicy {
    final /* synthetic */ SliderState $state;

    SliderKt$SliderImpl$2$1(SliderState sliderState) {
        this.$state = sliderState;
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
    public final MeasureResult m2201measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List<? extends Measurable> list2 = list;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = (Measurable) list2.get(i);
            if (LayoutIdKt.getLayoutId(measurable) == SliderComponents.THUMB) {
                Placeable r2 = measurable.m5368measureBRTryo0(j);
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Measurable measurable2 = (Measurable) list2.get(i2);
                    if (LayoutIdKt.getLayoutId(measurable2) == SliderComponents.TRACK) {
                        final Placeable r8 = measurable2.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(ConstraintsKt.m6543offsetNN6EwU$default(j, -r2.getWidth(), 0, 2, (Object) null), 0, 0, 0, 0, 11, (Object) null));
                        int width = r2.getWidth() + r8.getWidth();
                        int max = Math.max(r8.getHeight(), r2.getHeight());
                        this.$state.updateDimensions$material3_release((float) r2.getWidth(), width);
                        final int width2 = r2.getWidth() / 2;
                        final int roundToInt = MathKt.roundToInt(((float) r8.getWidth()) * this.$state.getCoercedValueAsFraction$material3_release());
                        final int height = (max - r8.getHeight()) / 2;
                        final int height2 = (max - r2.getHeight()) / 2;
                        final Placeable placeable = r2;
                        return MeasureScope.CC.layout$default(measureScope, width, max, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.placeRelative$default(placementScope, r8, width2, height, 0.0f, 4, (Object) null);
                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, roundToInt, height2, 0.0f, 4, (Object) null);
                            }
                        }, 4, (Object) null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            long j2 = j;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
