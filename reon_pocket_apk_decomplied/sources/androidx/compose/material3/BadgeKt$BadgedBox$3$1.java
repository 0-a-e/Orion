package androidx.compose.material3;

import androidx.compose.material3.tokens.BadgeTokens;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Badge.kt */
final class BadgeKt$BadgedBox$3$1 implements MeasurePolicy {
    final /* synthetic */ MutableFloatState $greatGrandParentAbsoluteRight$delegate;
    final /* synthetic */ MutableFloatState $greatGrandParentAbsoluteTop$delegate;
    final /* synthetic */ MutableFloatState $layoutAbsoluteLeft$delegate;
    final /* synthetic */ MutableFloatState $layoutAbsoluteTop$delegate;

    BadgeKt$BadgedBox$3$1(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, MutableFloatState mutableFloatState3, MutableFloatState mutableFloatState4) {
        this.$layoutAbsoluteTop$delegate = mutableFloatState;
        this.$layoutAbsoluteLeft$delegate = mutableFloatState2;
        this.$greatGrandParentAbsoluteRight$delegate = mutableFloatState3;
        this.$greatGrandParentAbsoluteTop$delegate = mutableFloatState4;
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
    public final MeasureResult m1530measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        List<? extends Measurable> list2 = list;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Measurable measurable = (Measurable) list2.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "badge")) {
                final Placeable r10 = measurable.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Measurable measurable2 = (Measurable) list2.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "anchor")) {
                        final Placeable r12 = measurable2.m5368measureBRTryo0(j);
                        int i3 = r12.get(AlignmentLineKt.getFirstBaseline());
                        int i4 = r12.get(AlignmentLineKt.getLastBaseline());
                        int width = r12.getWidth();
                        int height = r12.getHeight();
                        Map mapOf = MapsKt.mapOf(TuplesKt.to(AlignmentLineKt.getFirstBaseline(), Integer.valueOf(i3)), TuplesKt.to(AlignmentLineKt.getLastBaseline(), Integer.valueOf(i4)));
                        final MutableFloatState mutableFloatState = this.$layoutAbsoluteTop$delegate;
                        final MutableFloatState mutableFloatState2 = this.$layoutAbsoluteLeft$delegate;
                        final MutableFloatState mutableFloatState3 = this.$greatGrandParentAbsoluteRight$delegate;
                        final MeasureScope measureScope2 = measureScope;
                        final MutableFloatState mutableFloatState4 = this.$greatGrandParentAbsoluteTop$delegate;
                        return measureScope.layout(width, height, mapOf, new Function1<Placeable.PlacementScope, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                boolean z = r10.getWidth() > measureScope2.m6545roundToPx0680j_4(BadgeTokens.INSTANCE.m2657getSizeD9Ej5fM());
                                float badgeWithContentHorizontalOffset = z ? BadgeKt.getBadgeWithContentHorizontalOffset() : BadgeKt.getBadgeOffset();
                                float badgeWithContentVerticalOffset = z ? BadgeKt.getBadgeWithContentVerticalOffset() : BadgeKt.getBadgeOffset();
                                Placeable.PlacementScope.placeRelative$default(placementScope, r12, 0, 0, 0.0f, 4, (Object) null);
                                int width = r12.getWidth() + measureScope2.m6545roundToPx0680j_4(badgeWithContentHorizontalOffset);
                                int r1 = ((-r10.getHeight()) / 2) + measureScope2.m6545roundToPx0680j_4(badgeWithContentVerticalOffset);
                                float access$BadgedBox$lambda$4 = BadgeKt.BadgedBox$lambda$4(mutableFloatState) + ((float) r1);
                                float access$BadgedBox$lambda$7 = BadgeKt.BadgedBox$lambda$7(mutableFloatState3) - ((BadgeKt.BadgedBox$lambda$1(mutableFloatState2) + ((float) width)) + ((float) r10.getWidth()));
                                float access$BadgedBox$lambda$10 = access$BadgedBox$lambda$4 - BadgeKt.BadgedBox$lambda$10(mutableFloatState4);
                                if (access$BadgedBox$lambda$7 < 0.0f) {
                                    width += MathKt.roundToInt(access$BadgedBox$lambda$7);
                                }
                                int i = width;
                                if (access$BadgedBox$lambda$10 < 0.0f) {
                                    r1 -= MathKt.roundToInt(access$BadgedBox$lambda$10);
                                }
                                Placeable.PlacementScope.placeRelative$default(placementScope, r10, i, r1, 0.0f, 4, (Object) null);
                            }
                        });
                    }
                    MeasureScope measureScope3 = measureScope;
                    long j2 = j;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            MeasureScope measureScope4 = measureScope;
            long j3 = j;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
