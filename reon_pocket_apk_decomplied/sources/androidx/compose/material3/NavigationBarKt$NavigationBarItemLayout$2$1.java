package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import com.google.firebase.messaging.Constants;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: NavigationBar.kt */
final class NavigationBarKt$NavigationBarItemLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ boolean $alwaysShowLabel;
    final /* synthetic */ Function0<Float> $animationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    NavigationBarKt$NavigationBarItemLayout$2$1(Function0<Float> function0, Function2<? super Composer, ? super Integer, Unit> function2, boolean z) {
        this.$animationProgress = function0;
        this.$label = function2;
        this.$alwaysShowLabel = z;
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
    public final MeasureResult m2007measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        Placeable placeable;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        float floatValue = this.$animationProgress.invoke().floatValue();
        long r3 = Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = (Measurable) list2.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "icon")) {
                Placeable r5 = measurable.m5368measureBRTryo0(r3);
                float f = (float) 2;
                int width = r5.getWidth() + measureScope2.m6545roundToPx0680j_4(Dp.m6614constructorimpl(NavigationBarKt.IndicatorHorizontalPadding * f));
                int roundToInt = MathKt.roundToInt(((float) width) * floatValue);
                int height = r5.getHeight() + measureScope2.m6545roundToPx0680j_4(Dp.m6614constructorimpl(NavigationBarKt.getIndicatorVerticalPadding() * f));
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Measurable measurable2 = (Measurable) list2.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "indicatorRipple")) {
                        Placeable r6 = measurable2.m5368measureBRTryo0(Constraints.Companion.m6534fixedJhjzzOo(width, height));
                        int size3 = list.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size3) {
                                obj = null;
                                break;
                            }
                            obj = list2.get(i3);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) "indicator")) {
                                break;
                            }
                            i3++;
                        }
                        Measurable measurable3 = (Measurable) obj;
                        Placeable r7 = measurable3 != null ? measurable3.m5368measureBRTryo0(Constraints.Companion.m6534fixedJhjzzOo(roundToInt, height)) : null;
                        if (this.$label != null) {
                            int size4 = list.size();
                            int i4 = 0;
                            while (i4 < size4) {
                                Measurable measurable4 = (Measurable) list2.get(i4);
                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), (Object) Constants.ScionAnalytics.PARAM_LABEL)) {
                                    placeable = measurable4.m5368measureBRTryo0(r3);
                                } else {
                                    i4++;
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                        placeable = null;
                        if (this.$label == null) {
                            return NavigationBarKt.m2004placeIconX9ElhV4(measureScope, r5, r6, r7, j);
                        }
                        Intrinsics.checkNotNull(placeable);
                        return NavigationBarKt.m2005placeLabelAndIconzUg2_y0(measureScope, placeable, r5, r6, r7, j, this.$alwaysShowLabel, floatValue);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
