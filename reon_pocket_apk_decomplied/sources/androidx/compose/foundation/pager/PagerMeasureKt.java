package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a@\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001aH\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002\u001a@\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002\u001a\u0017\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\b\u001a\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f*\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0002\u001aj\u0010\u0015\u001a\u00020\u0006*\u00020 2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010)\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001aé\u0001\u0010?\u001a\u00020@*\u00020 2\u0006\u0010A\u001a\u00020\b2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u0002022\u0006\u0010)\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010+\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020G2/\u0010H\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0002\bK\u0012\u0004\u0012\u00020L0IH\u0000ø\u0001\u0000¢\u0006\u0004\bM\u0010N\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006O"}, d2 = {"DEBUG", "", "MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPositionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondBoundsPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", "index", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-_JDW0YA", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasure.kt */
public final class PagerMeasureKt {
    private static final boolean DEBUG = false;
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v7, resolved type: androidx.compose.foundation.pager.MeasuredPage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: measurePager-_JDW0YA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.pager.PagerMeasureResult m978measurePager_JDW0YA(androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope r36, int r37, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider r38, int r39, int r40, int r41, int r42, int r43, int r44, long r45, androidx.compose.foundation.gestures.Orientation r47, androidx.compose.ui.Alignment.Vertical r48, androidx.compose.ui.Alignment.Horizontal r49, boolean r50, long r51, int r53, int r54, java.util.List<java.lang.Integer> r55, androidx.compose.foundation.gestures.snapping.SnapPositionInLayout r56, androidx.compose.runtime.MutableState<kotlin.Unit> r57, kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.jvm.functions.Function1<? super androidx.compose.ui.layout.Placeable.PlacementScope, kotlin.Unit>, ? extends androidx.compose.ui.layout.MeasureResult> r58) {
        /*
            r0 = r37
            r15 = r39
            r14 = r40
            r1 = r45
            r13 = r47
            r12 = r54
            r3 = r55
            r11 = r58
            if (r14 < 0) goto L_0x03c5
            if (r41 < 0) goto L_0x03b9
            int r4 = r53 + r42
            r10 = 0
            int r9 = kotlin.ranges.RangesKt.coerceAtLeast((int) r4, (int) r10)
            if (r0 > 0) goto L_0x0060
            java.util.List r17 = kotlin.collections.CollectionsKt.emptyList()
            int r0 = -r14
            r22 = r0
            int r23 = r15 + r41
            int r0 = androidx.compose.ui.unit.Constraints.m6528getMinWidthimpl(r45)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            int r1 = androidx.compose.ui.unit.Constraints.m6527getMinHeightimpl(r45)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4 r2 = androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4.INSTANCE
            java.lang.Object r0 = r11.invoke(r0, r1, r2)
            r31 = r0
            androidx.compose.ui.layout.MeasureResult r31 = (androidx.compose.ui.layout.MeasureResult) r31
            androidx.compose.foundation.pager.PagerMeasureResult r0 = new androidx.compose.foundation.pager.PagerMeasureResult
            r16 = r0
            r30 = 0
            r32 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r18 = r53
            r19 = r42
            r20 = r41
            r21 = r47
            r25 = r54
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return r0
        L_0x0060:
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r13 != r4) goto L_0x006b
            int r4 = androidx.compose.ui.unit.Constraints.m6526getMaxWidthimpl(r45)
            r17 = r4
            goto L_0x006d
        L_0x006b:
            r17 = r53
        L_0x006d:
            androidx.compose.foundation.gestures.Orientation r4 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r13 == r4) goto L_0x0078
            int r4 = androidx.compose.ui.unit.Constraints.m6525getMaxHeightimpl(r45)
            r19 = r4
            goto L_0x007a
        L_0x0078:
            r19 = r53
        L_0x007a:
            r20 = 5
            r21 = 0
            r16 = 0
            r18 = 0
            long r4 = androidx.compose.ui.unit.ConstraintsKt.Constraints$default(r16, r17, r18, r19, r20, r21)
            r6 = r43
            r7 = r44
        L_0x008a:
            if (r6 <= 0) goto L_0x0092
            if (r7 <= 0) goto L_0x0092
            int r6 = r6 + -1
            int r7 = r7 - r9
            goto L_0x008a
        L_0x0092:
            int r7 = r7 * -1
            if (r6 < r0) goto L_0x0099
            int r6 = r0 + -1
            r7 = r10
        L_0x0099:
            kotlin.collections.ArrayDeque r8 = new kotlin.collections.ArrayDeque
            r8.<init>()
            int r10 = -r14
            if (r42 >= 0) goto L_0x00a6
            r16 = r42
            r43 = r6
            goto L_0x00aa
        L_0x00a6:
            r43 = r6
            r16 = 0
        L_0x00aa:
            int r6 = r10 + r16
            int r7 = r7 + r6
            r30 = r10
            r11 = 0
            r10 = r7
            r7 = r43
        L_0x00b3:
            if (r10 >= 0) goto L_0x00e9
            if (r7 <= 0) goto L_0x00e9
            int r7 = r7 + -1
            androidx.compose.ui.unit.LayoutDirection r26 = r36.getLayoutDirection()
            r16 = r36
            r17 = r7
            r18 = r4
            r20 = r38
            r21 = r51
            r23 = r47
            r24 = r49
            r25 = r48
            r27 = r50
            r28 = r53
            r43 = r7
            androidx.compose.foundation.pager.MeasuredPage r7 = m977getAndMeasureSGf7dI0(r16, r17, r18, r20, r21, r23, r24, r25, r26, r27, r28)
            r1 = 0
            r8.add(r1, r7)
            int r1 = r7.getCrossAxisSize()
            int r11 = java.lang.Math.max(r11, r1)
            int r10 = r10 + r9
            r7 = r43
            r1 = r45
            goto L_0x00b3
        L_0x00e9:
            if (r10 >= r6) goto L_0x00ec
            r10 = r6
        L_0x00ec:
            int r10 = r10 - r6
            int r2 = r15 + r41
            r43 = r7
            r1 = 0
            int r7 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r1)
            int r1 = -r10
            r17 = r43
            r44 = r2
            r18 = r10
            r16 = 0
            r2 = r1
            r1 = 0
        L_0x0101:
            int r10 = r8.size()
            r31 = 1
            if (r1 >= r10) goto L_0x0117
            if (r2 < r7) goto L_0x0111
            r8.remove(r1)
            r16 = r31
            goto L_0x0101
        L_0x0111:
            int r17 = r17 + 1
            int r2 = r2 + r9
            int r1 = r1 + 1
            goto L_0x0101
        L_0x0117:
            r32 = r16
            r10 = r17
            r1 = r18
        L_0x011d:
            if (r10 >= r0) goto L_0x0172
            if (r2 < r7) goto L_0x0129
            if (r2 <= 0) goto L_0x0129
            boolean r16 = r8.isEmpty()
            if (r16 == 0) goto L_0x0172
        L_0x0129:
            androidx.compose.ui.unit.LayoutDirection r26 = r36.getLayoutDirection()
            r16 = r36
            r17 = r10
            r18 = r4
            r20 = r38
            r21 = r51
            r23 = r47
            r24 = r49
            r25 = r48
            r27 = r50
            r28 = r53
            r33 = r7
            androidx.compose.foundation.pager.MeasuredPage r7 = m977getAndMeasureSGf7dI0(r16, r17, r18, r20, r21, r23, r24, r25, r26, r27, r28)
            int r13 = r0 + -1
            if (r10 != r13) goto L_0x014e
            r16 = r53
            goto L_0x0150
        L_0x014e:
            r16 = r9
        L_0x0150:
            int r2 = r2 + r16
            if (r2 > r6) goto L_0x015c
            if (r10 == r13) goto L_0x015c
            int r7 = r10 + 1
            int r1 = r1 - r9
            r32 = r31
            goto L_0x0169
        L_0x015c:
            int r13 = r7.getCrossAxisSize()
            int r11 = java.lang.Math.max(r11, r13)
            r8.add(r7)
            r7 = r43
        L_0x0169:
            int r10 = r10 + 1
            r13 = r47
            r43 = r7
            r7 = r33
            goto L_0x011d
        L_0x0172:
            if (r2 >= r15) goto L_0x01b0
            int r6 = r15 - r2
            int r1 = r1 - r6
            int r2 = r2 + r6
            r6 = r43
        L_0x017a:
            if (r1 >= r14) goto L_0x01aa
            if (r6 <= 0) goto L_0x01aa
            int r6 = r6 + -1
            androidx.compose.ui.unit.LayoutDirection r26 = r36.getLayoutDirection()
            r16 = r36
            r17 = r6
            r18 = r4
            r20 = r38
            r21 = r51
            r23 = r47
            r24 = r49
            r25 = r48
            r27 = r50
            r28 = r53
            androidx.compose.foundation.pager.MeasuredPage r7 = m977getAndMeasureSGf7dI0(r16, r17, r18, r20, r21, r23, r24, r25, r26, r27, r28)
            r13 = 0
            r8.add(r13, r7)
            int r7 = r7.getCrossAxisSize()
            int r11 = java.lang.Math.max(r11, r7)
            int r1 = r1 + r9
            goto L_0x017a
        L_0x01aa:
            r13 = 0
            if (r1 >= 0) goto L_0x01b3
            int r2 = r2 + r1
            r1 = r13
            goto L_0x01b3
        L_0x01b0:
            r13 = 0
            r6 = r43
        L_0x01b3:
            r35 = r11
            r11 = r2
            r2 = r35
            if (r1 < 0) goto L_0x03ad
            int r7 = -r1
            java.lang.Object r16 = r8.first()
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            if (r14 > 0) goto L_0x01cf
            if (r42 >= 0) goto L_0x01c6
            goto L_0x01cf
        L_0x01c6:
            r33 = r1
            r43 = r2
            r28 = r7
        L_0x01cc:
            r13 = r16
            goto L_0x01fc
        L_0x01cf:
            int r13 = r8.size()
            r43 = r2
            r2 = r1
            r1 = 0
        L_0x01d7:
            if (r1 >= r13) goto L_0x01f7
            if (r2 == 0) goto L_0x01f7
            if (r9 > r2) goto L_0x01f7
            r17 = r8
            java.util.List r17 = (java.util.List) r17
            r28 = r7
            int r7 = kotlin.collections.CollectionsKt.getLastIndex(r17)
            if (r1 == r7) goto L_0x01f9
            int r2 = r2 - r9
            int r1 = r1 + 1
            java.lang.Object r7 = r8.get(r1)
            r16 = r7
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            r7 = r28
            goto L_0x01d7
        L_0x01f7:
            r28 = r7
        L_0x01f9:
            r33 = r2
            goto L_0x01cc
        L_0x01fc:
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1 r1 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            r16 = r1
            r17 = r36
            r18 = r4
            r20 = r38
            r21 = r51
            r23 = r47
            r24 = r49
            r25 = r48
            r26 = r50
            r27 = r53
            r16.<init>(r17, r18, r20, r21, r23, r24, r25, r26, r27)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            java.util.List r6 = createPagesBeforeList(r6, r12, r3, r1)
            int r1 = r6.size()
            r7 = r43
            r2 = 0
        L_0x0222:
            if (r2 >= r1) goto L_0x0239
            java.lang.Object r16 = r6.get(r2)
            androidx.compose.foundation.pager.MeasuredPage r16 = (androidx.compose.foundation.pager.MeasuredPage) r16
            r43 = r1
            int r1 = r16.getCrossAxisSize()
            int r7 = java.lang.Math.max(r7, r1)
            int r2 = r2 + 1
            r1 = r43
            goto L_0x0222
        L_0x0239:
            java.lang.Object r1 = r8.last()
            androidx.compose.foundation.pager.MeasuredPage r1 = (androidx.compose.foundation.pager.MeasuredPage) r1
            int r1 = r1.getIndex()
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1 r2 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            r16 = r2
            r17 = r36
            r18 = r4
            r20 = r38
            r21 = r51
            r23 = r47
            r24 = r49
            r25 = r48
            r26 = r50
            r27 = r53
            r16.<init>(r17, r18, r20, r21, r23, r24, r25, r26, r27)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.util.List r4 = createPagesAfterList(r1, r0, r12, r3, r2)
            int r1 = r4.size()
            r2 = 0
        L_0x0267:
            if (r2 >= r1) goto L_0x027a
            java.lang.Object r3 = r4.get(r2)
            androidx.compose.foundation.pager.MeasuredPage r3 = (androidx.compose.foundation.pager.MeasuredPage) r3
            int r3 = r3.getCrossAxisSize()
            int r7 = java.lang.Math.max(r7, r3)
            int r2 = r2 + 1
            goto L_0x0267
        L_0x027a:
            java.lang.Object r1 = r8.first()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0293
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L_0x0293
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L_0x0293
            r16 = r31
            goto L_0x0295
        L_0x0293:
            r16 = 0
        L_0x0295:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            r5 = r47
            if (r5 != r1) goto L_0x029f
            r1 = r45
            r3 = r7
            goto L_0x02a2
        L_0x029f:
            r1 = r45
            r3 = r11
        L_0x02a2:
            int r17 = androidx.compose.ui.unit.ConstraintsKt.m6540constrainWidthK40F9xA(r1, r3)
            androidx.compose.foundation.gestures.Orientation r3 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r5 != r3) goto L_0x02ab
            r7 = r11
        L_0x02ab:
            int r18 = androidx.compose.ui.unit.ConstraintsKt.m6539constrainHeightK40F9xA(r1, r7)
            r2 = r8
            java.util.List r2 = (java.util.List) r2
            r19 = r36
            androidx.compose.ui.unit.Density r19 = (androidx.compose.ui.unit.Density) r19
            r1 = r36
            r20 = r44
            r3 = r6
            r5 = r17
            r6 = r18
            r21 = r28
            r7 = r11
            r22 = r8
            r8 = r39
            r36 = r9
            r9 = r21
            r15 = r10
            r23 = r30
            r21 = 0
            r10 = r47
            r0 = r58
            r34 = r11
            r11 = r50
            r12 = r19
            r24 = r13
            r19 = r15
            r15 = r47
            r13 = r42
            r14 = r53
            java.util.List r7 = calculatePagesOffsets(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            if (r16 == 0) goto L_0x02eb
            r8 = r7
            goto L_0x032f
        L_0x02eb:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r7.size()
            r1.<init>(r2)
            int r2 = r7.size()
            r10 = r21
        L_0x02fa:
            if (r10 >= r2) goto L_0x032c
            java.lang.Object r3 = r7.get(r10)
            r4 = r3
            androidx.compose.foundation.pager.MeasuredPage r4 = (androidx.compose.foundation.pager.MeasuredPage) r4
            int r5 = r4.getIndex()
            java.lang.Object r6 = r22.first()
            androidx.compose.foundation.pager.MeasuredPage r6 = (androidx.compose.foundation.pager.MeasuredPage) r6
            int r6 = r6.getIndex()
            if (r5 < r6) goto L_0x0329
            int r4 = r4.getIndex()
            java.lang.Object r5 = r22.last()
            androidx.compose.foundation.pager.MeasuredPage r5 = (androidx.compose.foundation.pager.MeasuredPage) r5
            int r5 = r5.getIndex()
            if (r4 > r5) goto L_0x0329
            r4 = r1
            java.util.Collection r4 = (java.util.Collection) r4
            r4.add(r3)
        L_0x0329:
            int r10 = r10 + 1
            goto L_0x02fa
        L_0x032c:
            java.util.List r1 = (java.util.List) r1
            r8 = r1
        L_0x032f:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r15 != r1) goto L_0x0336
            r1 = r18
            goto L_0x0338
        L_0x0336:
            r1 = r17
        L_0x0338:
            r2 = r8
            r3 = r40
            r4 = r41
            r5 = r36
            r6 = r56
            androidx.compose.foundation.pager.MeasuredPage r11 = calculateNewCurrentPage(r1, r2, r3, r4, r5, r6)
            if (r11 == 0) goto L_0x034e
            int r10 = r11.getOffset()
            r1 = r36
            goto L_0x0352
        L_0x034e:
            r1 = r36
            r10 = r21
        L_0x0352:
            if (r1 != 0) goto L_0x0356
            r1 = 0
            goto L_0x0362
        L_0x0356:
            float r2 = (float) r10
            float r2 = -r2
            float r1 = (float) r1
            float r2 = r2 / r1
            r1 = -1090519040(0xffffffffbf000000, float:-0.5)
            r3 = 1056964608(0x3f000000, float:0.5)
            float r1 = kotlin.ranges.RangesKt.coerceIn((float) r2, (float) r1, (float) r3)
        L_0x0362:
            r12 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r18)
            androidx.compose.foundation.pager.PagerMeasureKt$measurePager$9 r3 = new androidx.compose.foundation.pager.PagerMeasureKt$measurePager$9
            r4 = r57
            r3.<init>(r7, r4)
            java.lang.Object r0 = r0.invoke(r1, r2, r3)
            r16 = r0
            androidx.compose.ui.layout.MeasureResult r16 = (androidx.compose.ui.layout.MeasureResult) r16
            r0 = r37
            r10 = r19
            if (r10 < r0) goto L_0x038a
            r0 = r39
            r2 = r34
            if (r2 <= r0) goto L_0x0387
            goto L_0x038a
        L_0x0387:
            r14 = r21
            goto L_0x038c
        L_0x038a:
            r14 = r31
        L_0x038c:
            androidx.compose.foundation.pager.PagerMeasureResult r17 = new androidx.compose.foundation.pager.PagerMeasureResult
            r0 = r17
            r1 = r8
            r2 = r53
            r3 = r42
            r4 = r41
            r5 = r47
            r6 = r23
            r7 = r20
            r8 = r50
            r9 = r54
            r10 = r24
            r13 = r33
            r15 = r16
            r16 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r17
        L_0x03ad:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "invalid currentFirstPageScrollOffset"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03b9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative afterContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x03c5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "negative beforeContentPadding"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerMeasureKt.m978measurePager_JDW0YA(androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, int, androidx.compose.foundation.pager.PagerLazyLayoutItemProvider, int, int, int, int, int, int, long, androidx.compose.foundation.gestures.Orientation, androidx.compose.ui.Alignment$Vertical, androidx.compose.ui.Alignment$Horizontal, boolean, long, int, int, java.util.List, androidx.compose.foundation.gestures.snapping.SnapPositionInLayout, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function3):androidx.compose.foundation.pager.PagerMeasureResult");
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        List<MeasuredPage> list2 = null;
        if (i4 <= min) {
            while (true) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == min) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = list.get(i5).intValue();
            if (min + 1 <= intValue && intValue < i2) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        List<MeasuredPage> list2 = null;
        if (max <= i3) {
            while (true) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = list.get(i4).intValue();
            if (intValue < max) {
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                list2.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return list2 == null ? CollectionsKt.emptyList() : list2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0  reason: not valid java name */
    public static final MeasuredPage m977getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.m871measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, (DefaultConstructorMarker) null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        int i8;
        int i9;
        List<MeasuredPage> list4 = list;
        int i10 = i;
        int i11 = i2;
        int i12 = i5;
        Orientation orientation2 = orientation;
        boolean z2 = z;
        int i13 = i6;
        int i14 = i7 + i13;
        if (orientation2 == Orientation.Vertical) {
            i9 = i4;
            i8 = i11;
        } else {
            i9 = i4;
            i8 = i10;
        }
        boolean z3 = i3 < Math.min(i8, i9);
        if (!z3 || i12 == 0) {
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
            if (!z3) {
                int size = list2.size();
                int i15 = i12;
                for (int i16 = 0; i16 < size; i16++) {
                    MeasuredPage measuredPage = list2.get(i16);
                    i15 -= i14;
                    measuredPage.position(i15, i10, i11);
                    arrayList.add(measuredPage);
                }
                int size2 = list.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    MeasuredPage measuredPage2 = list4.get(i17);
                    measuredPage2.position(i12, i10, i11);
                    arrayList.add(measuredPage2);
                    i12 += i14;
                }
                int size3 = list3.size();
                for (int i18 = 0; i18 < size3; i18++) {
                    MeasuredPage measuredPage3 = list3.get(i18);
                    measuredPage3.position(i12, i10, i11);
                    arrayList.add(measuredPage3);
                    i12 += i14;
                }
            } else if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("No extra pages".toString());
            } else {
                int size4 = list.size();
                int[] iArr = new int[size4];
                for (int i19 = 0; i19 < size4; i19++) {
                    iArr[i19] = i7;
                }
                int[] iArr2 = new int[size4];
                for (int i20 = 0; i20 < size4; i20++) {
                    iArr2[i20] = 0;
                }
                Arrangement.HorizontalOrVertical r8 = Arrangement.Absolute.INSTANCE.m540spacedBy0680j_4(lazyLayoutMeasureScope.m874toDpu2uoSUM(i13));
                if (orientation2 == Orientation.Vertical) {
                    r8.arrange(density, i8, iArr, iArr2);
                } else {
                    Density density2 = density;
                    r8.arrange(density, i8, iArr, LayoutDirection.Ltr, iArr2);
                }
                IntProgression indices = ArraysKt.getIndices(iArr2);
                if (z2) {
                    indices = RangesKt.reversed(indices);
                }
                int first = indices.getFirst();
                int last = indices.getLast();
                int step = indices.getStep();
                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                    while (true) {
                        int i21 = iArr2[first];
                        MeasuredPage measuredPage4 = list4.get(calculatePagesOffsets$reverseAware(first, z2, size4));
                        if (z2) {
                            i21 = (i8 - i21) - measuredPage4.getSize();
                        }
                        measuredPage4.position(i21, i10, i11);
                        arrayList.add(measuredPage4);
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalStateException(("non-zero pagesScrollOffset=" + i12).toString());
    }

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i3, int i4, SnapPositionInLayout snapPositionInLayout) {
        MeasuredPage measuredPage;
        List<MeasuredPage> list2 = list;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPositionInLayout));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i5);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f2 = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPositionInLayout));
                    if (Float.compare(f, f2) < 0) {
                        measuredPage2 = measuredPage4;
                        f = f2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }
}
