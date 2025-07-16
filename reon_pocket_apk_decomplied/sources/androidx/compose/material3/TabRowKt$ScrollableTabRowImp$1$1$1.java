package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-0kLqBqw", "(Landroidx/compose/ui/layout/SubcomposeMeasureScope;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TabRow.kt */
final class TabRowKt$ScrollableTabRowImp$1$1$1 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $divider;
    final /* synthetic */ float $edgePadding;
    final /* synthetic */ Function3<List<TabPosition>, Composer, Integer, Unit> $indicator;
    final /* synthetic */ ScrollableTabData $scrollableTabData;
    final /* synthetic */ int $selectedTabIndex;
    final /* synthetic */ Function2<Composer, Integer, Unit> $tabs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TabRowKt$ScrollableTabRowImp$1$1$1(float f, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, ScrollableTabData scrollableTabData, int i, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3) {
        super(2);
        this.$edgePadding = f;
        this.$tabs = function2;
        this.$divider = function22;
        this.$scrollableTabData = scrollableTabData;
        this.$selectedTabIndex = i;
        this.$indicator = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m2367invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m6532unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m2367invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        int r7 = subcomposeMeasureScope2.m6545roundToPx0680j_4(TabRowKt.ScrollableTabRowMinimumTabWidth);
        final int r2 = subcomposeMeasureScope2.m6545roundToPx0680j_4(this.$edgePadding);
        List<Measurable> subcompose = subcomposeMeasureScope2.subcompose(TabSlots.Tabs, this.$tabs);
        int i = 0;
        int size = subcompose.size();
        for (int i2 = 0; i2 < size; i2++) {
            i = Integer.valueOf(Math.max(i.intValue(), subcompose.get(i2).maxIntrinsicHeight(Integer.MAX_VALUE)));
        }
        int intValue = i.intValue();
        long r5 = Constraints.m6517copyZbe2FdA$default(j, r7, 0, intValue, intValue, 2, (Object) null);
        List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        int size2 = subcompose.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Measurable measurable = subcompose.get(i3);
            Placeable r12 = measurable.m5368measureBRTryo0(r5);
            float r11 = Dp.m6614constructorimpl(subcomposeMeasureScope2.m6547toDpu2uoSUM(Math.min(measurable.maxIntrinsicWidth(r12.getHeight()), r12.getWidth())) - Dp.m6614constructorimpl(TabKt.getHorizontalTextPadding() * ((float) 2)));
            arrayList.add(r12);
            arrayList2.add(Dp.m6612boximpl(r11));
        }
        Integer valueOf = Integer.valueOf(r2 * 2);
        int size3 = arrayList.size();
        for (int i4 = 0; i4 < size3; i4++) {
            valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i4)).getWidth());
        }
        int intValue2 = valueOf.intValue();
        final Function2<Composer, Integer, Unit> function2 = this.$divider;
        final ScrollableTabData scrollableTabData = this.$scrollableTabData;
        int i5 = this.$selectedTabIndex;
        final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = this.$indicator;
        final List list = arrayList;
        final SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
        final int i6 = i5;
        final long j2 = j;
        final int i7 = intValue2;
        final int i8 = intValue;
        return MeasureScope.CC.layout$default(subcomposeMeasureScope2, intValue2, intValue, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                final List arrayList = new ArrayList();
                int i = r2;
                List<Placeable> list = list;
                SubcomposeMeasureScope subcomposeMeasureScope = subcomposeMeasureScope3;
                List<Dp> list2 = arrayList2;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Placeable placeable = list.get(i2);
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, 0, 0.0f, 4, (Object) null);
                    arrayList.add(new TabPosition(subcomposeMeasureScope.m6547toDpu2uoSUM(i), subcomposeMeasureScope.m6547toDpu2uoSUM(placeable.getWidth()), list2.get(i2).m6628unboximpl(), (DefaultConstructorMarker) null));
                    i += placeable.getWidth();
                }
                List<Measurable> subcompose = subcomposeMeasureScope3.subcompose(TabSlots.Divider, function2);
                long j = j2;
                int i3 = i7;
                int i4 = i8;
                int i5 = 0;
                for (int size2 = subcompose.size(); i5 < size2; size2 = size2) {
                    Placeable r20 = subcompose.get(i5).m5368measureBRTryo0(Constraints.m6517copyZbe2FdA$default(j, i3, i3, 0, 0, 8, (Object) null));
                    Placeable.PlacementScope.placeRelative$default(placementScope, r20, 0, i4 - r20.getHeight(), 0.0f, 4, (Object) null);
                    i5++;
                }
                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope3;
                TabSlots tabSlots = TabSlots.Indicator;
                final Function3<List<TabPosition>, Composer, Integer, Unit> function3 = function3;
                List<Measurable> subcompose2 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C942@41500L23:TabRow.kt#uh7d8r");
                        if ((i & 3) != 2 || !composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(358596038, i, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                            }
                            function3.invoke(arrayList, composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                }));
                int i6 = i7;
                int i7 = i8;
                int size3 = subcompose2.size();
                for (int i8 = 0; i8 < size3; i8++) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose2.get(i8).m5368measureBRTryo0(Constraints.Companion.m6534fixedJhjzzOo(i6, i7)), 0, 0, 0.0f, 4, (Object) null);
                }
                scrollableTabData.onLaidOut(subcomposeMeasureScope3, r2, arrayList, i6);
            }
        }, 4, (Object) null);
    }
}
