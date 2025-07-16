package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b\u001a\u0001\u0010\u0007\u001a\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\u0002\b\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0014\u0010%\u001a\u00020\u0017*\u00020\u00102\u0006\u0010&\u001a\u00020\u0017H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"DEBUG", "", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "rememberPagerMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "itemProviderLambda", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "beyondBoundsPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "snapPositionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "pageCount", "rememberPagerMeasurePolicy-121YqSk", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;IFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "calculateCurrentPageLayoutOffset", "pageSizeWithSpacing", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerMeasurePolicy.kt */
public final class PagerMeasurePolicyKt {
    private static final boolean DEBUG = false;

    private static final void debugLog(Function0<String> function0) {
    }

    /* renamed from: rememberPagerMeasurePolicy-121YqSk  reason: not valid java name */
    public static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> m979rememberPagerMeasurePolicy121YqSk(Function0<PagerLazyLayoutItemProvider> function0, PagerState pagerState, PaddingValues paddingValues, boolean z, Orientation orientation, int i, float f, PageSize pageSize, Alignment.Horizontal horizontal, Alignment.Vertical vertical, SnapPositionInLayout snapPositionInLayout, Function0<Integer> function02, Composer composer, int i2, int i3) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-1615726010);
        ComposerKt.sourceInformation(composer2, "C(rememberPagerMeasurePolicy)P(3,10,1,8,4!1,7:c#ui.unit.Dp,6!1,11,9)56@2324L5682:PagerMeasurePolicy.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1615726010, i2, i3, "androidx.compose.foundation.pager.rememberPagerMeasurePolicy (PagerMeasurePolicy.kt:56)");
        }
        Object[] objArr = {pagerState, paddingValues, Boolean.valueOf(z), orientation, horizontal, vertical, Dp.m6612boximpl(f), pageSize, snapPositionInLayout, function02};
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z2 = false;
        for (int i4 = 0; i4 < 10; i4++) {
            z2 |= composer2.changed(objArr[i4]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(orientation, paddingValues, z, pagerState, f, pageSize, function0, function02, vertical, horizontal, i, snapPositionInLayout);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return function2;
    }

    public static final int calculateCurrentPageLayoutOffset(PagerState pagerState, int i) {
        PageInfo pageInfo;
        List<PageInfo> visiblePagesInfo = pagerState.getLayoutInfo().getVisiblePagesInfo();
        int size = visiblePagesInfo.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                pageInfo = null;
                break;
            }
            pageInfo = visiblePagesInfo.get(i3);
            if (pageInfo.getIndex() == pagerState.getCurrentPage()) {
                break;
            }
            i3++;
        }
        PageInfo pageInfo2 = pageInfo;
        if (pageInfo2 != null) {
            i2 = pageInfo2.getOffset();
        }
        return -MathKt.roundToInt(((pagerState.getCurrentPageOffsetFraction() - (i == 0 ? pagerState.getCurrentPageOffsetFraction() : (-((float) i2)) / ((float) i))) * ((float) i)) - ((float) i2));
    }
}
