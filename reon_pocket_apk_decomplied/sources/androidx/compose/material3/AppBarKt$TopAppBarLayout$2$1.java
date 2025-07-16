package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppBar.kt */
final class AppBarKt$TopAppBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ float $heightPx;
    final /* synthetic */ int $titleBottomPadding;
    final /* synthetic */ Arrangement.Horizontal $titleHorizontalArrangement;
    final /* synthetic */ Arrangement.Vertical $titleVerticalArrangement;

    AppBarKt$TopAppBarLayout$2$1(float f, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i) {
        this.$heightPx = f;
        this.$titleHorizontalArrangement = horizontal;
        this.$titleVerticalArrangement = vertical;
        this.$titleBottomPadding = i;
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
    public final MeasureResult m1520measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        List<? extends Measurable> list2 = list;
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Measurable measurable = (Measurable) list2.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "navigationIcon")) {
                final Placeable r10 = measurable.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 14, (Object) null));
                int size2 = list.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Measurable measurable2 = (Measurable) list2.get(i4);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) "actionIcons")) {
                        final Placeable r16 = measurable2.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 14, (Object) null));
                        if (Constraints.m6526getMaxWidthimpl(j) == Integer.MAX_VALUE) {
                            i = Constraints.m6526getMaxWidthimpl(j);
                        } else {
                            i = RangesKt.coerceAtLeast((Constraints.m6526getMaxWidthimpl(j) - r10.getWidth()) - r16.getWidth(), 0);
                        }
                        int i5 = i;
                        int size3 = list.size();
                        for (int i6 = 0; i6 < size3; i6++) {
                            Measurable measurable3 = (Measurable) list2.get(i6);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), (Object) "title")) {
                                final Placeable r12 = measurable3.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, i5, 0, 0, 12, (Object) null));
                                final int i7 = r12.get(AlignmentLineKt.getLastBaseline()) != Integer.MIN_VALUE ? r12.get(AlignmentLineKt.getLastBaseline()) : 0;
                                if (!Float.isNaN(this.$heightPx)) {
                                    i2 = MathKt.roundToInt(this.$heightPx);
                                }
                                int i8 = i2;
                                int r22 = Constraints.m6526getMaxWidthimpl(j);
                                final Arrangement.Horizontal horizontal = this.$titleHorizontalArrangement;
                                final int i9 = i8;
                                final long j2 = j;
                                final MeasureScope measureScope2 = measureScope;
                                final Arrangement.Vertical vertical = this.$titleVerticalArrangement;
                                final int i10 = this.$titleBottomPadding;
                                return MeasureScope.CC.layout$default(measureScope, r22, i8, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        int i;
                                        int i2;
                                        int i3;
                                        int i4;
                                        int i5;
                                        int r1;
                                        Placeable placeable = r10;
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i9 - placeable.getHeight()) / 2, 0.0f, 4, (Object) null);
                                        Placeable placeable2 = r12;
                                        Arrangement.Horizontal horizontal = horizontal;
                                        if (Intrinsics.areEqual((Object) horizontal, (Object) Arrangement.INSTANCE.getCenter())) {
                                            i = (Constraints.m6526getMaxWidthimpl(j2) - r12.getWidth()) / 2;
                                            if (i < r10.getWidth()) {
                                                r1 = r10.getWidth() - i;
                                            } else if (r12.getWidth() + i > Constraints.m6526getMaxWidthimpl(j2) - r16.getWidth()) {
                                                r1 = (Constraints.m6526getMaxWidthimpl(j2) - r16.getWidth()) - (r12.getWidth() + i);
                                            }
                                            i += r1;
                                        } else if (Intrinsics.areEqual((Object) horizontal, (Object) Arrangement.INSTANCE.getEnd())) {
                                            i = (Constraints.m6526getMaxWidthimpl(j2) - r12.getWidth()) - r16.getWidth();
                                        } else {
                                            i = Math.max(measureScope2.m6545roundToPx0680j_4(AppBarKt.TopAppBarTitleInset), r10.getWidth());
                                        }
                                        int i6 = i;
                                        Arrangement.Vertical vertical = vertical;
                                        if (Intrinsics.areEqual((Object) vertical, (Object) Arrangement.INSTANCE.getCenter())) {
                                            i5 = (i9 - r12.getHeight()) / 2;
                                        } else if (Intrinsics.areEqual((Object) vertical, (Object) Arrangement.INSTANCE.getBottom())) {
                                            if (i10 == 0) {
                                                i4 = i9;
                                                i3 = r12.getHeight();
                                            } else {
                                                i4 = i9 - r12.getHeight();
                                                i3 = Math.max(0, (i10 - r12.getHeight()) + i7);
                                            }
                                            i5 = i4 - i3;
                                        } else {
                                            i2 = 0;
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i6, i2, 0.0f, 4, (Object) null);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, r16, Constraints.m6526getMaxWidthimpl(j2) - r16.getWidth(), (i9 - r16.getHeight()) / 2, 0.0f, 4, (Object) null);
                                        }
                                        i2 = i5;
                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i6, i2, 0.0f, 4, (Object) null);
                                        Placeable.PlacementScope.placeRelative$default(placementScope, r16, Constraints.m6526getMaxWidthimpl(j2) - r16.getWidth(), (i9 - r16.getHeight()) / 2, 0.0f, 4, (Object) null);
                                    }
                                }, 4, (Object) null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
