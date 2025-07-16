package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
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
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Snackbar.kt */
final class SnackbarKt$OneRowSnackbar$2$1 implements MeasurePolicy {
    final /* synthetic */ String $actionTag;
    final /* synthetic */ String $dismissActionTag;
    final /* synthetic */ String $textTag;

    SnackbarKt$OneRowSnackbar$2$1(String str, String str2, String str3) {
        this.$actionTag = str;
        this.$dismissActionTag = str2;
        this.$textTag = str3;
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
    public final MeasureResult m2222measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Placeable placeable;
        Object obj;
        Object obj2;
        final int i;
        final int i2;
        Placeable placeable2;
        int i3;
        int i4;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        long j2 = j;
        int min = Math.min(Constraints.m6526getMaxWidthimpl(j), measureScope2.m6545roundToPx0680j_4(SnackbarKt.ContainerMaxWidth));
        String str = this.$actionTag;
        int size = list.size();
        int i5 = 0;
        while (true) {
            placeable = null;
            if (i5 >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj), (Object) str)) {
                break;
            }
            i5++;
        }
        Measurable measurable = (Measurable) obj;
        Placeable r15 = measurable != null ? measurable.m5368measureBRTryo0(j2) : null;
        String str2 = this.$dismissActionTag;
        int size2 = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i6);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId((Measurable) obj2), (Object) str2)) {
                break;
            }
            i6++;
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            placeable = measurable2.m5368measureBRTryo0(j2);
        }
        Placeable placeable3 = placeable;
        int width = r15 != null ? r15.getWidth() : 0;
        int height = r15 != null ? r15.getHeight() : 0;
        int width2 = placeable3 != null ? placeable3.getWidth() : 0;
        int height2 = placeable3 != null ? placeable3.getHeight() : 0;
        int coerceAtLeast = RangesKt.coerceAtLeast(((min - width) - width2) - (width2 == 0 ? measureScope2.m6545roundToPx0680j_4(SnackbarKt.TextEndExtraSpacing) : 0), Constraints.m6528getMinWidthimpl(j));
        String str3 = this.$textTag;
        int size3 = list.size();
        int i7 = 0;
        while (i7 < size3) {
            Measurable measurable3 = (Measurable) list2.get(i7);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), (Object) str3)) {
                Placeable placeable4 = r15;
                int i8 = height2;
                Placeable r0 = measurable3.m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, 0, coerceAtLeast, 0, 0, 9, (Object) null));
                int i9 = r0.get(AlignmentLineKt.getFirstBaseline());
                if (i9 != Integer.MIN_VALUE) {
                    int i10 = r0.get(AlignmentLineKt.getLastBaseline());
                    if (i10 != Integer.MIN_VALUE) {
                        boolean z = i9 == i10;
                        int i11 = min - width2;
                        final int i12 = i11 - width;
                        if (z) {
                            i3 = Math.max(measureScope2.m6545roundToPx0680j_4(SnackbarTokens.INSTANCE.m3144getSingleLineContainerHeightD9Ej5fM()), Math.max(height, i8));
                            int height3 = (i3 - r0.getHeight()) / 2;
                            if (placeable4 != null) {
                                placeable2 = placeable4;
                                int i13 = placeable2.get(AlignmentLineKt.getFirstBaseline());
                                if (i13 != Integer.MIN_VALUE) {
                                    i4 = (i9 + height3) - i13;
                                    i = i4;
                                    i2 = height3;
                                }
                            } else {
                                placeable2 = placeable4;
                            }
                            i4 = 0;
                            i = i4;
                            i2 = height3;
                        } else {
                            placeable2 = placeable4;
                            int r3 = measureScope2.m6545roundToPx0680j_4(SnackbarKt.HeightToFirstLine) - i9;
                            int max = Math.max(measureScope2.m6545roundToPx0680j_4(SnackbarTokens.INSTANCE.m3145getTwoLinesContainerHeightD9Ej5fM()), r0.getHeight() + r3);
                            i2 = r3;
                            i = placeable2 != null ? (max - placeable2.getHeight()) / 2 : 0;
                            i3 = max;
                        }
                        final int height4 = placeable3 != null ? (i3 - placeable3.getHeight()) / 2 : 0;
                        final Placeable placeable5 = r0;
                        final Placeable placeable6 = placeable3;
                        final int i14 = i11;
                        final Placeable placeable7 = placeable2;
                        return MeasureScope.CC.layout$default(measureScope, min, i3, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, 0, i2, 0.0f, 4, (Object) null);
                                Placeable placeable = placeable6;
                                if (placeable != null) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i14, height4, 0.0f, 4, (Object) null);
                                }
                                Placeable placeable2 = placeable7;
                                if (placeable2 != null) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i12, i, 0.0f, 4, (Object) null);
                                }
                            }
                        }, 4, (Object) null);
                    }
                    throw new IllegalArgumentException("No baselines for text".toString());
                }
                throw new IllegalArgumentException("No baselines for text".toString());
            }
            Placeable placeable8 = r15;
            int i15 = height2;
            i7++;
            r15 = placeable8;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
