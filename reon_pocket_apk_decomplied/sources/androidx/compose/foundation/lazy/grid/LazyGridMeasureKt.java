package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH\b\u001a\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001aõ\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042/\u00105\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080\b¢\u0006\u0002\b9\u0012\u0004\u0012\u00020:06H\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "itemConstraints", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Constraints;", "filter", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-W2FL7xs", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridMeasure.kt */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measureLazyGrid-W2FL7xs  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult m841measureLazyGridW2FL7xs(int r33, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider r34, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider r35, int r36, int r37, int r38, int r39, int r40, int r41, float r42, long r43, boolean r45, androidx.compose.foundation.layout.Arrangement.Vertical r46, androidx.compose.foundation.layout.Arrangement.Horizontal r47, boolean r48, androidx.compose.ui.unit.Density r49, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator r50, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider r51, java.util.List<java.lang.Integer> r52, kotlinx.coroutines.CoroutineScope r53, androidx.compose.runtime.MutableState<kotlin.Unit> r54, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r55) {
        /*
            r10 = r33
            r0 = r34
            r1 = r36
            r2 = r37
            r3 = r43
            r5 = r52
            r6 = r55
            if (r2 < 0) goto L_0x0367
            if (r38 < 0) goto L_0x035b
            if (r10 > 0) goto L_0x004f
            int r0 = androidx.compose.ui.unit.Constraints.m6528getMinWidthimpl(r43)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r3 = androidx.compose.ui.unit.Constraints.m6527getMinHeightimpl(r43)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3 r4 = androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3.INSTANCE
            java.lang.Object r0 = r6.invoke(r0, r3, r4)
            r5 = r0
            androidx.compose.ui.layout.MeasureResult r5 = (androidx.compose.ui.layout.MeasureResult) r5
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            int r8 = -r2
            int r9 = r1 + r38
            if (r45 == 0) goto L_0x0039
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x003b
        L_0x0039:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x003b:
            r12 = r0
            androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r15 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureResult
            r6 = 0
            r10 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r0 = r15
            r11 = r48
            r13 = r38
            r14 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r15
        L_0x004f:
            int r7 = kotlin.math.MathKt.roundToInt((float) r42)
            int r8 = r41 - r7
            r9 = 0
            if (r40 != 0) goto L_0x005c
            if (r8 >= 0) goto L_0x005c
            int r7 = r7 + r8
            r8 = r9
        L_0x005c:
            kotlin.collections.ArrayDeque r11 = new kotlin.collections.ArrayDeque
            r11.<init>()
            int r15 = -r2
            if (r39 >= 0) goto L_0x0067
            r12 = r39
            goto L_0x0068
        L_0x0067:
            r12 = r9
        L_0x0068:
            int r12 = r12 + r15
            int r8 = r8 + r12
            r13 = r8
            r8 = r40
        L_0x006d:
            if (r13 >= 0) goto L_0x0080
            if (r8 <= 0) goto L_0x0080
            int r8 = r8 + -1
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r14 = r0.getAndMeasure(r8)
            r11.add(r9, r14)
            int r14 = r14.getMainAxisSizeWithSpacings()
            int r13 = r13 + r14
            goto L_0x006d
        L_0x0080:
            if (r13 >= r12) goto L_0x0084
            int r7 = r7 + r13
            r13 = r12
        L_0x0084:
            int r13 = r13 - r12
            int r14 = r1 + r38
            r40 = r8
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast((int) r14, (int) r9)
            int r9 = -r13
            r17 = r40
            r16 = r13
            r19 = r14
            r13 = 0
            r18 = 0
        L_0x0097:
            int r14 = r11.size()
            r24 = 1
            if (r13 >= r14) goto L_0x00b7
            if (r9 < r8) goto L_0x00a7
            r11.remove(r13)
            r18 = r24
            goto L_0x0097
        L_0x00a7:
            int r17 = r17 + 1
            java.lang.Object r14 = r11.get(r13)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r14 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r14
            int r14 = r14.getMainAxisSizeWithSpacings()
            int r9 = r9 + r14
            int r13 = r13 + 1
            goto L_0x0097
        L_0x00b7:
            r14 = r9
            r13 = r17
            r9 = r18
        L_0x00bc:
            if (r13 >= r10) goto L_0x0114
            if (r14 < r8) goto L_0x00c8
            if (r14 <= 0) goto L_0x00c8
            boolean r17 = r11.isEmpty()
            if (r17 == 0) goto L_0x0114
        L_0x00c8:
            r17 = r8
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r8 = r0.getAndMeasure(r13)
            boolean r18 = r8.isEmpty()
            if (r18 == 0) goto L_0x00d5
            goto L_0x0114
        L_0x00d5:
            int r18 = r8.getMainAxisSizeWithSpacings()
            int r14 = r14 + r18
            if (r14 > r12) goto L_0x00fe
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r18 = r8.getItems()
            java.lang.Object r18 = kotlin.collections.ArraysKt.last((T[]) r18)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r18 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r18
            r20 = r12
            int r12 = r18.getIndex()
            r18 = r14
            int r14 = r10 + -1
            if (r12 == r14) goto L_0x0102
            int r9 = r13 + 1
            int r8 = r8.getMainAxisSizeWithSpacings()
            int r16 = r16 - r8
            r8 = r24
            goto L_0x0108
        L_0x00fe:
            r20 = r12
            r18 = r14
        L_0x0102:
            r11.add(r8)
            r8 = r9
            r9 = r40
        L_0x0108:
            int r13 = r13 + 1
            r40 = r9
            r14 = r18
            r12 = r20
            r9 = r8
            r8 = r17
            goto L_0x00bc
        L_0x0114:
            if (r14 >= r1) goto L_0x0148
            int r8 = r1 - r14
            int r16 = r16 - r8
            int r14 = r14 + r8
            r13 = r40
            r12 = r16
        L_0x011f:
            if (r12 >= r2) goto L_0x013b
            if (r13 <= 0) goto L_0x013b
            int r13 = r13 + -1
            r17 = r15
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r15 = r0.getAndMeasure(r13)
            r40 = r9
            r9 = 0
            r11.add(r9, r15)
            int r15 = r15.getMainAxisSizeWithSpacings()
            int r12 = r12 + r15
            r9 = r40
            r15 = r17
            goto L_0x011f
        L_0x013b:
            r40 = r9
            r17 = r15
            r9 = 0
            int r7 = r7 + r8
            if (r12 >= 0) goto L_0x0146
            int r7 = r7 + r12
            int r14 = r14 + r12
            r12 = r9
        L_0x0146:
            r8 = r14
            goto L_0x0150
        L_0x0148:
            r40 = r9
            r17 = r15
            r9 = 0
            r8 = r14
            r12 = r16
        L_0x0150:
            int r13 = kotlin.math.MathKt.roundToInt((float) r42)
            int r13 = kotlin.math.MathKt.getSign((int) r13)
            int r14 = kotlin.math.MathKt.getSign((int) r7)
            if (r13 != r14) goto L_0x016e
            int r13 = kotlin.math.MathKt.roundToInt((float) r42)
            int r13 = java.lang.Math.abs(r13)
            int r14 = java.lang.Math.abs(r7)
            if (r13 < r14) goto L_0x016e
            float r7 = (float) r7
            goto L_0x0170
        L_0x016e:
            r7 = r42
        L_0x0170:
            if (r12 < 0) goto L_0x034f
            int r15 = -r12
            java.lang.Object r13 = r11.first()
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r13 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r13
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r14 = r13.getItems()
            java.lang.Object r14 = kotlin.collections.ArraysKt.firstOrNull((T[]) r14)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r14 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r14
            if (r14 == 0) goto L_0x018a
            int r14 = r14.getIndex()
            goto L_0x018b
        L_0x018a:
            r14 = r9
        L_0x018b:
            java.lang.Object r16 = r11.lastOrNull()
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r16 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r16
            if (r16 == 0) goto L_0x01a7
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r16 = r16.getItems()
            if (r16 == 0) goto L_0x01a7
            java.lang.Object r16 = kotlin.collections.ArraysKt.lastOrNull((T[]) r16)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r16 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r16
            if (r16 == 0) goto L_0x01a7
            int r16 = r16.getIndex()
            r9 = r16
        L_0x01a7:
            r16 = r12
            int r12 = r52.size()
            r18 = 0
            r42 = r13
            r20 = r18
            r13 = 0
        L_0x01b4:
            if (r13 >= r12) goto L_0x01f4
            java.lang.Object r21 = r5.get(r13)
            java.lang.Number r21 = (java.lang.Number) r21
            r22 = r12
            int r12 = r21.intValue()
            if (r12 < 0) goto L_0x01eb
            if (r12 >= r14) goto L_0x01eb
            long r28 = r0.m850itemConstraintsOenEA2s(r12)
            r30 = 2
            r31 = 0
            r27 = 0
            r25 = r35
            r26 = r12
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r12 = androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.m847getAndMeasure3p2s80s$default(r25, r26, r27, r28, r30, r31)
            if (r20 != 0) goto L_0x01e1
            java.util.ArrayList r20 = new java.util.ArrayList
            r20.<init>()
            java.util.List r20 = (java.util.List) r20
        L_0x01e1:
            r21 = r14
            r14 = r20
            r14.add(r12)
            r20 = r14
            goto L_0x01ed
        L_0x01eb:
            r21 = r14
        L_0x01ed:
            int r13 = r13 + 1
            r14 = r21
            r12 = r22
            goto L_0x01b4
        L_0x01f4:
            r21 = r14
            if (r20 != 0) goto L_0x01fc
            java.util.List r20 = kotlin.collections.CollectionsKt.emptyList()
        L_0x01fc:
            r25 = r20
            int r12 = r52.size()
            r13 = 0
        L_0x0203:
            if (r13 >= r12) goto L_0x023e
            java.lang.Object r14 = r5.get(r13)
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            int r5 = r9 + 1
            if (r5 > r14) goto L_0x0239
            if (r14 >= r10) goto L_0x0239
            long r29 = r0.m850itemConstraintsOenEA2s(r14)
            r31 = 2
            r32 = 0
            r28 = 0
            r26 = r35
            r27 = r14
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r5 = androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.m847getAndMeasure3p2s80s$default(r26, r27, r28, r29, r31, r32)
            if (r18 != 0) goto L_0x0232
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            r18 = r14
            java.util.List r18 = (java.util.List) r18
        L_0x0232:
            r14 = r18
            r14.add(r5)
            r18 = r14
        L_0x0239:
            int r13 = r13 + 1
            r5 = r52
            goto L_0x0203
        L_0x023e:
            if (r18 != 0) goto L_0x0244
            java.util.List r18 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0244:
            r0 = r18
            if (r2 > 0) goto L_0x0250
            if (r39 >= 0) goto L_0x024b
            goto L_0x0250
        L_0x024b:
            r2 = r42
            r5 = r16
            goto L_0x0284
        L_0x0250:
            int r2 = r11.size()
            r13 = r42
            r12 = r16
            r5 = 0
        L_0x0259:
            if (r5 >= r2) goto L_0x0282
            java.lang.Object r14 = r11.get(r5)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r14 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r14
            int r14 = r14.getMainAxisSizeWithSpacings()
            if (r12 == 0) goto L_0x0282
            if (r14 > r12) goto L_0x0282
            r16 = r11
            java.util.List r16 = (java.util.List) r16
            r34 = r2
            int r2 = kotlin.collections.CollectionsKt.getLastIndex(r16)
            if (r5 == r2) goto L_0x0282
            int r12 = r12 - r14
            int r5 = r5 + 1
            java.lang.Object r2 = r11.get(r5)
            r13 = r2
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r13 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r13
            r2 = r34
            goto L_0x0259
        L_0x0282:
            r5 = r12
            r2 = r13
        L_0x0284:
            if (r45 == 0) goto L_0x028b
            int r12 = androidx.compose.ui.unit.Constraints.m6526getMaxWidthimpl(r43)
            goto L_0x028f
        L_0x028b:
            int r12 = androidx.compose.ui.unit.ConstraintsKt.m6540constrainWidthK40F9xA(r3, r8)
        L_0x028f:
            r26 = r12
            if (r45 == 0) goto L_0x0298
            int r3 = androidx.compose.ui.unit.ConstraintsKt.m6539constrainHeightK40F9xA(r3, r8)
            goto L_0x029c
        L_0x0298:
            int r3 = androidx.compose.ui.unit.Constraints.m6525getMaxHeightimpl(r43)
        L_0x029c:
            java.util.List r11 = (java.util.List) r11
            r12 = r25
            r13 = r0
            r27 = r19
            r4 = r21
            r14 = r26
            r18 = r15
            r28 = r17
            r15 = r3
            r16 = r8
            r17 = r36
            r19 = r45
            r20 = r46
            r21 = r47
            r22 = r48
            r23 = r49
            java.util.List r15 = calculateItemsOffsets(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            int r12 = (int) r7
            r11 = r50
            r13 = r26
            r14 = r3
            r34 = r15
            r16 = r35
            r17 = r51
            r18 = r45
            r19 = r53
            r11.onMeasured(r12, r13, r14, r15, r16, r17, r18, r19)
            int r11 = r10 + -1
            if (r9 != r11) goto L_0x02da
            if (r8 <= r1) goto L_0x02d8
            goto L_0x02da
        L_0x02d8:
            r24 = 0
        L_0x02da:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r26)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$5 r8 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$5
            r12 = r34
            r11 = r54
            r8.<init>(r12, r11)
            java.lang.Object r1 = r6.invoke(r1, r3, r8)
            r6 = r1
            androidx.compose.ui.layout.MeasureResult r6 = (androidx.compose.ui.layout.MeasureResult) r6
            boolean r1 = r25.isEmpty()
            if (r1 == 0) goto L_0x02ff
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x02ff
            goto L_0x032a
        L_0x02ff:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.size()
            r0.<init>(r1)
            int r1 = r12.size()
            r3 = 0
        L_0x030d:
            if (r3 >= r1) goto L_0x0327
            java.lang.Object r8 = r12.get(r3)
            r11 = r8
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem r11 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) r11
            int r11 = r11.getIndex()
            if (r4 > r11) goto L_0x0324
            if (r11 > r9) goto L_0x0324
            r11 = r0
            java.util.Collection r11 = (java.util.Collection) r11
            r11.add(r8)
        L_0x0324:
            int r3 = r3 + 1
            goto L_0x030d
        L_0x0327:
            java.util.List r0 = (java.util.List) r0
            r12 = r0
        L_0x032a:
            if (r45 == 0) goto L_0x032f
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0331
        L_0x032f:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0331:
            r13 = r0
            androidx.compose.foundation.lazy.grid.LazyGridMeasureResult r15 = new androidx.compose.foundation.lazy.grid.LazyGridMeasureResult
            r0 = r15
            r1 = r2
            r2 = r5
            r3 = r24
            r4 = r7
            r5 = r6
            r6 = r40
            r7 = r12
            r8 = r28
            r9 = r27
            r10 = r33
            r11 = r48
            r12 = r13
            r13 = r38
            r14 = r39
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r15
        L_0x034f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative initial offset"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x035b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative afterContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0367:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative beforeContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.m841measureLazyGridW2FL7xs(int, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator, androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider, java.util.List, kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.grid.LazyGridMeasureResult");
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        List<LazyGridMeasuredLine> list4 = list;
        int i6 = i;
        int i7 = i2;
        Arrangement.Vertical vertical2 = vertical;
        boolean z3 = z2;
        int i8 = i4;
        int i9 = z ? i7 : i6;
        boolean z4 = i3 < Math.min(i9, i8);
        if (!z4 || i5 == 0) {
            int size = list.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                i10 += list4.get(i11).getItems().length;
            }
            ArrayList arrayList = new ArrayList(i10);
            if (!z4) {
                int size2 = list2.size() - 1;
                if (size2 >= 0) {
                    int i12 = i5;
                    while (true) {
                        int i13 = size2 - 1;
                        LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size2);
                        int mainAxisSizeWithSpacings = i12 - lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                        LazyGridMeasuredItem.position$default(lazyGridMeasuredItem, mainAxisSizeWithSpacings, 0, i, i2, 0, 0, 48, (Object) null);
                        arrayList.add(lazyGridMeasuredItem);
                        if (i13 < 0) {
                            break;
                        }
                        size2 = i13;
                        i12 = mainAxisSizeWithSpacings;
                    }
                }
                int size3 = list.size();
                int i14 = i5;
                for (int i15 = 0; i15 < size3; i15++) {
                    LazyGridMeasuredLine lazyGridMeasuredLine = list4.get(i15);
                    CollectionsKt.addAll(arrayList, (T[]) lazyGridMeasuredLine.position(i14, i6, i7));
                    i14 += lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
                }
                int size4 = list3.size();
                int i16 = i14;
                int i17 = 0;
                while (i17 < size4) {
                    LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i17);
                    int i18 = size4;
                    LazyGridMeasuredItem lazyGridMeasuredItem3 = lazyGridMeasuredItem2;
                    LazyGridMeasuredItem.position$default(lazyGridMeasuredItem2, i16, 0, i, i2, 0, 0, 48, (Object) null);
                    arrayList.add(lazyGridMeasuredItem3);
                    i16 += lazyGridMeasuredItem3.getMainAxisSizeWithSpacings();
                    i17++;
                    size4 = i18;
                }
            } else if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no items".toString());
            } else {
                int size5 = list.size();
                int[] iArr = new int[size5];
                for (int i19 = 0; i19 < size5; i19++) {
                    iArr[i19] = list4.get(calculateItemsOffsets$reverseAware(i19, z3, size5)).getMainAxisSize();
                }
                int[] iArr2 = new int[size5];
                for (int i20 = 0; i20 < size5; i20++) {
                    iArr2[i20] = 0;
                }
                if (!z) {
                    Density density2 = density;
                    if (horizontal != null) {
                        horizontal.arrange(density, i9, iArr, LayoutDirection.Ltr, iArr2);
                    } else {
                        throw new IllegalArgumentException("null horizontalArrangement".toString());
                    }
                } else if (vertical2 != null) {
                    vertical2.arrange(density, i9, iArr, iArr2);
                } else {
                    throw new IllegalArgumentException("null verticalArrangement".toString());
                }
                IntProgression indices = ArraysKt.getIndices(iArr2);
                if (z3) {
                    indices = RangesKt.reversed(indices);
                }
                int first = indices.getFirst();
                int last = indices.getLast();
                int step = indices.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        int i21 = iArr2[first];
                        LazyGridMeasuredLine lazyGridMeasuredLine2 = list4.get(calculateItemsOffsets$reverseAware(first, z3, size5));
                        if (z3) {
                            i21 = (i9 - i21) - lazyGridMeasuredLine2.getMainAxisSize();
                        }
                        CollectionsKt.addAll(arrayList, (T[]) lazyGridMeasuredLine2.position(i21, i6, i7));
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("non-zero firstLineScrollOffset".toString());
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, Function1<? super Integer, Constraints> function1, Function1<? super Integer, Boolean> function12) {
        int size = list.size();
        List<LazyGridMeasuredItem> list2 = null;
        for (int i = 0; i < size; i++) {
            int intValue = list.get(i).intValue();
            if (function12.invoke(Integer.valueOf(intValue)).booleanValue()) {
                LazyGridMeasuredItem r3 = LazyGridMeasuredItemProvider.m847getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, intValue, 0, function1.invoke(Integer.valueOf(intValue)).m6532unboximpl(), 2, (Object) null);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(r3);
            }
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }
}
