package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scaffold.kt */
final class ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$topBar = function2;
        this.$snackbar = function22;
        this.$fab = function23;
        this.$fabPosition = i;
        this.$contentWindowInsets = windowInsets;
        this.$bottomBar = function24;
        this.$content = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m2105invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m2105invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        Object obj;
        Object obj2;
        Object obj3;
        FabPlacement fabPlacement;
        Object obj4;
        Integer num;
        int i;
        int i2;
        int i3;
        Object obj5;
        Object obj6;
        int i4;
        int r4;
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        int r16 = Constraints.m6526getMaxWidthimpl(j);
        int r17 = Constraints.m6525getMaxHeightimpl(j);
        long r11 = Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.TopBar, this.$topBar);
        ArrayList arrayList = new ArrayList(subcompose.size());
        int size = subcompose.size();
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(subcompose.get(i5).m5368measureBRTryo0(r11));
        }
        List list = arrayList;
        if (list.isEmpty()) {
            obj = null;
        } else {
            obj = list.get(0);
            int height = ((Placeable) obj).getHeight();
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i6 = 1;
                while (true) {
                    Object obj7 = list.get(i6);
                    int height2 = ((Placeable) obj7).getHeight();
                    if (height < height2) {
                        obj = obj7;
                        height = height2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        int height3 = placeable != null ? placeable.getHeight() : 0;
        List<Measurable> subcompose2 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Snackbar, this.$snackbar);
        WindowInsets windowInsets = this.$contentWindowInsets;
        ArrayList arrayList2 = new ArrayList(subcompose2.size());
        int size2 = subcompose2.size();
        int i7 = 0;
        while (i7 < size2) {
            Density density = subcomposeMeasureScope2;
            arrayList2.add(subcompose2.get(i7).m5368measureBRTryo0(ConstraintsKt.m6542offsetNN6EwU(r11, (-windowInsets.getLeft(density, subcomposeMeasureScope.getLayoutDirection())) - windowInsets.getRight(density, subcomposeMeasureScope.getLayoutDirection()), -windowInsets.getBottom(density))));
            i7++;
            subcompose2 = subcompose2;
        }
        List list2 = arrayList2;
        if (list2.isEmpty()) {
            obj2 = null;
        } else {
            obj2 = list2.get(0);
            int height4 = ((Placeable) obj2).getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                Object obj8 = obj2;
                int i8 = height4;
                int i9 = 1;
                while (true) {
                    Object obj9 = list2.get(i9);
                    int height5 = ((Placeable) obj9).getHeight();
                    if (i8 < height5) {
                        obj8 = obj9;
                        i8 = height5;
                    }
                    if (i9 == lastIndex2) {
                        break;
                    }
                    i9++;
                }
                obj2 = obj8;
            }
        }
        Placeable placeable2 = (Placeable) obj2;
        int height6 = placeable2 != null ? placeable2.getHeight() : 0;
        if (list2.isEmpty()) {
            obj3 = null;
        } else {
            obj3 = list2.get(0);
            int width = ((Placeable) obj3).getWidth();
            int lastIndex3 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex3) {
                Object obj10 = obj3;
                int i10 = width;
                int i11 = 1;
                while (true) {
                    Object obj11 = list2.get(i11);
                    int width2 = ((Placeable) obj11).getWidth();
                    if (i10 < width2) {
                        obj10 = obj11;
                        i10 = width2;
                    }
                    if (i11 == lastIndex3) {
                        break;
                    }
                    i11++;
                }
                obj3 = obj10;
            }
        }
        Placeable placeable3 = (Placeable) obj3;
        int width3 = placeable3 != null ? placeable3.getWidth() : 0;
        List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Fab, this.$fab);
        WindowInsets windowInsets2 = this.$contentWindowInsets;
        ArrayList arrayList3 = new ArrayList(subcompose3.size());
        int size3 = subcompose3.size();
        int i12 = 0;
        while (i12 < size3) {
            Density density2 = subcomposeMeasureScope2;
            List<Measurable> list3 = subcompose3;
            int i13 = size3;
            int right = (-windowInsets2.getLeft(density2, subcomposeMeasureScope.getLayoutDirection())) - windowInsets2.getRight(density2, subcomposeMeasureScope.getLayoutDirection());
            int i14 = -windowInsets2.getBottom(density2);
            WindowInsets windowInsets3 = windowInsets2;
            Placeable r2 = subcompose3.get(i12).m5368measureBRTryo0(ConstraintsKt.m6542offsetNN6EwU(r11, right, i14));
            if (r2.getHeight() == 0 || r2.getWidth() == 0) {
                r2 = null;
            }
            if (r2 != null) {
                arrayList3.add(r2);
            }
            i12++;
            windowInsets2 = windowInsets3;
            subcompose3 = list3;
            size3 = i13;
        }
        List list4 = arrayList3;
        if (!list4.isEmpty()) {
            if (list4.isEmpty()) {
                obj5 = null;
            } else {
                obj5 = list4.get(0);
                int width4 = ((Placeable) obj5).getWidth();
                int lastIndex4 = CollectionsKt.getLastIndex(list4);
                if (1 <= lastIndex4) {
                    int i15 = width4;
                    int i16 = 1;
                    while (true) {
                        Object obj12 = list4.get(i16);
                        int width5 = ((Placeable) obj12).getWidth();
                        if (i15 < width5) {
                            obj5 = obj12;
                            i15 = width5;
                        }
                        if (i16 == lastIndex4) {
                            break;
                        }
                        i16++;
                    }
                }
            }
            Intrinsics.checkNotNull(obj5);
            int width6 = ((Placeable) obj5).getWidth();
            if (list4.isEmpty()) {
                obj6 = null;
            } else {
                obj6 = list4.get(0);
                int height7 = ((Placeable) obj6).getHeight();
                int lastIndex5 = CollectionsKt.getLastIndex(list4);
                if (1 <= lastIndex5) {
                    Object obj13 = obj6;
                    int i17 = height7;
                    int i18 = 1;
                    while (true) {
                        Object obj14 = list4.get(i18);
                        Object obj15 = obj13;
                        int height8 = ((Placeable) obj14).getHeight();
                        if (i17 < height8) {
                            i17 = height8;
                            obj13 = obj14;
                        } else {
                            obj13 = obj15;
                        }
                        if (i18 == lastIndex5) {
                            break;
                        }
                        i18++;
                    }
                    obj6 = obj13;
                }
            }
            Intrinsics.checkNotNull(obj6);
            int height9 = ((Placeable) obj6).getHeight();
            int i19 = this.$fabPosition;
            if (!FabPosition.m1857equalsimpl0(i19, FabPosition.Companion.m1864getStartERTFSPs())) {
                if (!(FabPosition.m1857equalsimpl0(i19, FabPosition.Companion.m1862getEndERTFSPs()) ? true : FabPosition.m1857equalsimpl0(i19, FabPosition.Companion.m1863getEndOverlayERTFSPs()))) {
                    i4 = (r16 - width6) / 2;
                } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                    r4 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                } else {
                    i4 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                }
                fabPlacement = new FabPlacement(i4, width6, height9);
            } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                i4 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                fabPlacement = new FabPlacement(i4, width6, height9);
            } else {
                r4 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
            }
            i4 = (r16 - r4) - width6;
            fabPlacement = new FabPlacement(i4, width6, height9);
        } else {
            fabPlacement = null;
        }
        List<Measurable> subcompose4 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(1843374446, true, new ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bottomBarPlaceables$1(fabPlacement, this.$bottomBar)));
        ArrayList arrayList4 = new ArrayList(subcompose4.size());
        int size4 = subcompose4.size();
        int i20 = 0;
        while (i20 < size4) {
            arrayList4.add(subcompose4.get(i20).m5368measureBRTryo0(r11));
            i20++;
            subcompose4 = subcompose4;
        }
        List list5 = arrayList4;
        if (list5.isEmpty()) {
            obj4 = null;
        } else {
            obj4 = list5.get(0);
            int height10 = ((Placeable) obj4).getHeight();
            int lastIndex6 = CollectionsKt.getLastIndex(list5);
            if (1 <= lastIndex6) {
                int i21 = 1;
                while (true) {
                    Object obj16 = list5.get(i21);
                    Object obj17 = obj4;
                    int height11 = ((Placeable) obj16).getHeight();
                    if (height10 < height11) {
                        height10 = height11;
                        obj4 = obj16;
                    } else {
                        obj4 = obj17;
                    }
                    if (i21 == lastIndex6) {
                        break;
                    }
                    i21++;
                }
            }
        }
        Placeable placeable4 = (Placeable) obj4;
        Integer valueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
        if (fabPlacement != null) {
            int i22 = this.$fabPosition;
            WindowInsets windowInsets4 = this.$contentWindowInsets;
            if (valueOf == null || FabPosition.m1857equalsimpl0(i22, FabPosition.Companion.m1863getEndOverlayERTFSPs())) {
                i3 = fabPlacement.getHeight() + subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                i2 = windowInsets4.getBottom(subcomposeMeasureScope2);
            } else {
                i3 = valueOf.intValue() + fabPlacement.getHeight();
                i2 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
            }
            num = Integer.valueOf(i3 + i2);
        } else {
            num = null;
        }
        if (height6 != 0) {
            i = height6 + (num != null ? num.intValue() : valueOf != null ? valueOf.intValue() : this.$contentWindowInsets.getBottom(subcomposeMeasureScope2));
        } else {
            i = 0;
        }
        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.MainContent;
        List list6 = list4;
        ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1 scaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1 = r1;
        int i23 = width3;
        List list7 = list5;
        FabPlacement fabPlacement2 = fabPlacement;
        ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1 scaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$12 = new ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1(this.$contentWindowInsets, subcomposeMeasureScope, list, height3, list5, valueOf, this.$content);
        List<Measurable> subcompose5 = subcomposeMeasureScope2.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(1655277373, true, scaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1));
        ArrayList arrayList5 = new ArrayList(subcompose5.size());
        int size5 = subcompose5.size();
        for (int i24 = 0; i24 < size5; i24++) {
            arrayList5.add(subcompose5.get(i24).m5368measureBRTryo0(r11));
        }
        final List list8 = arrayList5;
        final List list9 = list;
        final List list10 = list2;
        final List list11 = list7;
        final FabPlacement fabPlacement3 = fabPlacement2;
        final int i25 = r16;
        final int i26 = i23;
        final WindowInsets windowInsets5 = this.$contentWindowInsets;
        final SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
        final int i27 = r17;
        final int i28 = i;
        final Integer num2 = valueOf;
        final List list12 = list6;
        final Integer num3 = num;
        return MeasureScope.CC.layout$default(subcomposeMeasureScope2, r16, r17, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                List<Placeable> list = list8;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    Placeable.PlacementScope.place$default(placementScope, list.get(i), 0, 0, 0.0f, 4, (Object) null);
                }
                List<Placeable> list2 = list9;
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    Placeable.PlacementScope.place$default(placementScope, list2.get(i2), 0, 0, 0.0f, 4, (Object) null);
                }
                List<Placeable> list3 = list10;
                int i3 = i25;
                int i4 = i26;
                WindowInsets windowInsets = windowInsets5;
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope3;
                int i5 = i27;
                int i6 = i28;
                int size3 = list3.size();
                for (int i7 = 0; i7 < size3; i7++) {
                    Placeable.PlacementScope.place$default(placementScope, list3.get(i7), ((i3 - i4) / 2) + windowInsets.getLeft(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), i5 - i6, 0.0f, 4, (Object) null);
                }
                List<Placeable> list4 = list11;
                int i8 = i27;
                Integer num = num2;
                int size4 = list4.size();
                for (int i9 = 0; i9 < size4; i9++) {
                    Placeable.PlacementScope.place$default(placementScope, list4.get(i9), 0, i8 - (num != null ? num.intValue() : 0), 0.0f, 4, (Object) null);
                }
                FabPlacement fabPlacement = fabPlacement3;
                if (fabPlacement != null) {
                    List<Placeable> list5 = list12;
                    int i10 = i27;
                    Integer num2 = num3;
                    int size5 = list5.size();
                    for (int i11 = 0; i11 < size5; i11++) {
                        int left = fabPlacement.getLeft();
                        Intrinsics.checkNotNull(num2);
                        Placeable.PlacementScope.place$default(placementScope, list5.get(i11), left, i10 - num2.intValue(), 0.0f, 4, (Object) null);
                    }
                }
            }
        }, 4, (Object) null);
    }
}
