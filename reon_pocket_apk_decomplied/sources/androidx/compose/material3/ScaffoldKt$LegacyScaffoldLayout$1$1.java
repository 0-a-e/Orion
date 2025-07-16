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
final class ScaffoldKt$LegacyScaffoldLayout$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $bottomBar;
    final /* synthetic */ Function3<PaddingValues, Composer, Integer, Unit> $content;
    final /* synthetic */ WindowInsets $contentWindowInsets;
    final /* synthetic */ Function2<Composer, Integer, Unit> $fab;
    final /* synthetic */ int $fabPosition;
    final /* synthetic */ Function2<Composer, Integer, Unit> $snackbar;
    final /* synthetic */ Function2<Composer, Integer, Unit> $topBar;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScaffoldKt$LegacyScaffoldLayout$1$1(Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i, WindowInsets windowInsets, Function2<? super Composer, ? super Integer, Unit> function24, Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3) {
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
        return m2104invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m2104invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        int r14 = Constraints.m6526getMaxWidthimpl(j);
        int r15 = Constraints.m6525getMaxHeightimpl(j);
        final long r9 = Constraints.m6517copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        final Function2<Composer, Integer, Unit> function2 = this.$topBar;
        final Function2<Composer, Integer, Unit> function22 = this.$snackbar;
        final Function2<Composer, Integer, Unit> function23 = this.$fab;
        final int i = this.$fabPosition;
        final WindowInsets windowInsets = this.$contentWindowInsets;
        final Function2<Composer, Integer, Unit> function24 = this.$bottomBar;
        final Function3<PaddingValues, Composer, Integer, Unit> function3 = this.$content;
        final SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        final int i2 = r14;
        final int i3 = r15;
        return MeasureScope.CC.layout$default(subcomposeMeasureScope, r14, r15, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Object obj;
                Object obj2;
                Object obj3;
                FabPlacement fabPlacement;
                int i;
                Object obj4;
                Integer num;
                int i2;
                int i3;
                Object obj5;
                Object obj6;
                int i4;
                int i5;
                int r9;
                List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.TopBar, function2);
                long j = r9;
                ArrayList arrayList = new ArrayList(subcompose.size());
                int size = subcompose.size();
                for (int i6 = 0; i6 < size; i6++) {
                    arrayList.add(subcompose.get(i6).m5368measureBRTryo0(j));
                }
                List list = arrayList;
                if (list.isEmpty()) {
                    obj = null;
                } else {
                    obj = list.get(0);
                    int height = ((Placeable) obj).getHeight();
                    int lastIndex = CollectionsKt.getLastIndex(list);
                    if (1 <= lastIndex) {
                        int i7 = 1;
                        while (true) {
                            Object obj7 = list.get(i7);
                            int height2 = ((Placeable) obj7).getHeight();
                            if (height < height2) {
                                obj = obj7;
                                height = height2;
                            }
                            if (i7 == lastIndex) {
                                break;
                            }
                            i7++;
                        }
                    }
                }
                Placeable placeable = (Placeable) obj;
                int height3 = placeable != null ? placeable.getHeight() : 0;
                List<Measurable> subcompose2 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                WindowInsets windowInsets = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope2;
                long j2 = r9;
                ArrayList arrayList2 = new ArrayList(subcompose2.size());
                int size2 = subcompose2.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    Density density = subcomposeMeasureScope;
                    arrayList2.add(subcompose2.get(i8).m5368measureBRTryo0(ConstraintsKt.m6542offsetNN6EwU(j2, (-windowInsets.getLeft(density, subcomposeMeasureScope.getLayoutDirection())) - windowInsets.getRight(density, subcomposeMeasureScope.getLayoutDirection()), -windowInsets.getBottom(density))));
                }
                List list2 = arrayList2;
                if (list2.isEmpty()) {
                    obj2 = null;
                } else {
                    obj2 = list2.get(0);
                    int height4 = ((Placeable) obj2).getHeight();
                    int lastIndex2 = CollectionsKt.getLastIndex(list2);
                    if (1 <= lastIndex2) {
                        int i9 = 1;
                        while (true) {
                            Object obj8 = list2.get(i9);
                            int height5 = ((Placeable) obj8).getHeight();
                            if (height4 < height5) {
                                obj2 = obj8;
                                height4 = height5;
                            }
                            if (i9 == lastIndex2) {
                                break;
                            }
                            i9++;
                        }
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
                        int i10 = 1;
                        while (true) {
                            Object obj9 = list2.get(i10);
                            int width2 = ((Placeable) obj9).getWidth();
                            if (width < width2) {
                                obj3 = obj9;
                                width = width2;
                            }
                            if (i10 == lastIndex3) {
                                break;
                            }
                            i10++;
                        }
                    }
                }
                Placeable placeable3 = (Placeable) obj3;
                int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.Fab, function23);
                WindowInsets windowInsets2 = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope2;
                long j3 = r9;
                ArrayList arrayList3 = new ArrayList(subcompose3.size());
                int size3 = subcompose3.size();
                int i11 = 0;
                while (i11 < size3) {
                    Density density2 = subcomposeMeasureScope2;
                    List<Measurable> list3 = subcompose3;
                    int i12 = size3;
                    int right = (-windowInsets2.getLeft(density2, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets2.getRight(density2, subcomposeMeasureScope2.getLayoutDirection());
                    int i13 = -windowInsets2.getBottom(density2);
                    WindowInsets windowInsets3 = windowInsets2;
                    Placeable r5 = subcompose3.get(i11).m5368measureBRTryo0(ConstraintsKt.m6542offsetNN6EwU(j3, right, i13));
                    if (r5.getHeight() == 0 || r5.getWidth() == 0) {
                        r5 = null;
                    }
                    if (r5 != null) {
                        arrayList3.add(r5);
                    }
                    i11++;
                    windowInsets2 = windowInsets3;
                    subcompose3 = list3;
                    size3 = i12;
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
                            int i14 = 1;
                            while (true) {
                                Object obj10 = list4.get(i14);
                                int width5 = ((Placeable) obj10).getWidth();
                                if (width4 < width5) {
                                    obj5 = obj10;
                                    width4 = width5;
                                }
                                if (i14 == lastIndex4) {
                                    break;
                                }
                                i14++;
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
                            int i15 = 1;
                            while (true) {
                                Object obj11 = list4.get(i15);
                                int height8 = ((Placeable) obj11).getHeight();
                                if (height7 < height8) {
                                    obj6 = obj11;
                                    height7 = height8;
                                }
                                if (i15 == lastIndex5) {
                                    break;
                                }
                                i15++;
                            }
                        }
                    }
                    Intrinsics.checkNotNull(obj6);
                    int height9 = ((Placeable) obj6).getHeight();
                    int i16 = i;
                    if (!FabPosition.m1857equalsimpl0(i16, FabPosition.Companion.m1864getStartERTFSPs())) {
                        if (!FabPosition.m1857equalsimpl0(i16, FabPosition.Companion.m1862getEndERTFSPs())) {
                            i4 = (i2 - width6) / 2;
                        } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                            i5 = i2;
                            r9 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                        } else {
                            i4 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                        }
                        fabPlacement = new FabPlacement(i4, width6, height9);
                    } else if (subcomposeMeasureScope2.getLayoutDirection() == LayoutDirection.Ltr) {
                        i4 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                        fabPlacement = new FabPlacement(i4, width6, height9);
                    } else {
                        i5 = i2;
                        r9 = subcomposeMeasureScope2.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    i4 = (i5 - r9) - width6;
                    fabPlacement = new FabPlacement(i4, width6, height9);
                } else {
                    fabPlacement = null;
                }
                List<Measurable> subcompose4 = subcomposeMeasureScope2.subcompose(ScaffoldLayoutContent.BottomBar, ComposableLambdaKt.composableLambdaInstance(-791102355, true, new ScaffoldKt$LegacyScaffoldLayout$1$1$1$bottomBarPlaceables$1(fabPlacement, function24)));
                long j4 = r9;
                ArrayList arrayList4 = new ArrayList(subcompose4.size());
                int size4 = subcompose4.size();
                for (int i17 = 0; i17 < size4; i17++) {
                    arrayList4.add(subcompose4.get(i17).m5368measureBRTryo0(j4));
                }
                List list5 = arrayList4;
                if (list5.isEmpty()) {
                    obj4 = null;
                    i = 0;
                } else {
                    i = 0;
                    obj4 = list5.get(0);
                    int height10 = ((Placeable) obj4).getHeight();
                    int lastIndex6 = CollectionsKt.getLastIndex(list5);
                    if (1 <= lastIndex6) {
                        int i18 = height10;
                        Object obj12 = obj4;
                        int i19 = 1;
                        while (true) {
                            Object obj13 = list5.get(i19);
                            int height11 = ((Placeable) obj13).getHeight();
                            if (i18 < height11) {
                                obj12 = obj13;
                                i18 = height11;
                            }
                            if (i19 == lastIndex6) {
                                break;
                            }
                            i19++;
                        }
                        obj4 = obj12;
                    }
                }
                Placeable placeable4 = (Placeable) obj4;
                Integer valueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                if (fabPlacement != null) {
                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope2;
                    WindowInsets windowInsets4 = windowInsets;
                    if (valueOf == null) {
                        i3 = fabPlacement.getHeight() + subcomposeMeasureScope3.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing) + windowInsets4.getBottom(subcomposeMeasureScope3);
                    } else {
                        i3 = valueOf.intValue() + fabPlacement.getHeight() + subcomposeMeasureScope3.m6545roundToPx0680j_4(ScaffoldKt.FabSpacing);
                    }
                    num = Integer.valueOf(i3);
                } else {
                    num = null;
                }
                if (height6 != 0) {
                    i2 = height6 + (num != null ? num.intValue() : valueOf != null ? valueOf.intValue() : windowInsets.getBottom(subcomposeMeasureScope2));
                } else {
                    i2 = i;
                }
                SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope2;
                List list6 = list4;
                ScaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1 scaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1 = r8;
                FabPlacement fabPlacement2 = fabPlacement;
                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.MainContent;
                List list7 = list5;
                int i20 = i;
                ScaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1 scaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$12 = new ScaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1(windowInsets, subcomposeMeasureScope2, list, height3, list5, valueOf, function3);
                List<Measurable> subcompose5 = subcomposeMeasureScope4.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(495329982, true, scaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1));
                long j5 = r9;
                ArrayList arrayList5 = new ArrayList(subcompose5.size());
                int size5 = subcompose5.size();
                for (int i21 = i20; i21 < size5; i21++) {
                    arrayList5.add(subcompose5.get(i21).m5368measureBRTryo0(j5));
                }
                List list8 = arrayList5;
                int size6 = list8.size();
                for (int i22 = i20; i22 < size6; i22++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) list8.get(i22), 0, 0, 0.0f, 4, (Object) null);
                }
                int size7 = list.size();
                for (int i23 = i20; i23 < size7; i23++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i23), 0, 0, 0.0f, 4, (Object) null);
                }
                int i24 = i2;
                WindowInsets windowInsets5 = windowInsets;
                SubcomposeMeasureScope subcomposeMeasureScope5 = subcomposeMeasureScope2;
                int i25 = i3;
                int size8 = list2.size();
                for (int i26 = i20; i26 < size8; i26++) {
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) list2.get(i26), ((i24 - width3) / 2) + windowInsets5.getLeft(subcomposeMeasureScope5, subcomposeMeasureScope5.getLayoutDirection()), i25 - i2, 0.0f, 4, (Object) null);
                }
                int i27 = i3;
                int size9 = list7.size();
                int i28 = i20;
                while (i28 < size9) {
                    List list9 = list7;
                    Placeable.PlacementScope.place$default(placementScope, (Placeable) list9.get(i28), 0, i27 - (valueOf != null ? valueOf.intValue() : i20), 0.0f, 4, (Object) null);
                    i28++;
                    list7 = list9;
                }
                if (fabPlacement2 != null) {
                    int i29 = i3;
                    int size10 = list6.size();
                    for (int i30 = i20; i30 < size10; i30++) {
                        int left = fabPlacement2.getLeft();
                        Intrinsics.checkNotNull(num);
                        Placeable.PlacementScope.place$default(placementScope, (Placeable) list6.get(i30), left, i29 - num.intValue(), 0.0f, 4, (Object) null);
                    }
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
            }
        }, 4, (Object) null);
    }
}
