package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000W\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007*\u0001\u0016\u001a\u0017\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\b\u001a/\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0007¢\u0006\u0002\u0010)\u001a\u0012\u0010*\u001a\u00020\u001f*\u00020$H@¢\u0006\u0002\u0010+\u001a\u0012\u0010,\u001a\u00020\u001f*\u00020$H@¢\u0006\u0002\u0010+\u001a\u0014\u0010-\u001a\u00020\u000e*\u00020\b2\u0006\u0010(\u001a\u00020\u000eH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001a\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000\"\u001a\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u0014\"\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017\"\u001e\u0010\u0018\u001a\u00020\u000e*\u00020\u00198BX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"DEBUG", "", "DefaultPositionThreshold", "Landroidx/compose/ui/unit/Dp;", "getDefaultPositionThreshold", "()F", "F", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo$annotations", "()V", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "MaxPagesForAnimateScroll", "", "PagesToPrefetch", "SnapAlignmentStartToStart", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "getSnapAlignmentStartToStart$annotations", "getSnapAlignmentStartToStart", "()Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "UnitDensity", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "singleAxisViewPort", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getSingleAxisViewPort$annotations", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)V", "getSingleAxisViewPort", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)I", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "rememberPagerState", "Landroidx/compose/foundation/pager/PagerState;", "initialPage", "initialPageOffsetFraction", "", "pageCount", "(IFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToPreviousPage", "calculateNewMaxScrollOffset", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerState.kt */
public final class PagerStateKt {
    private static final boolean DEBUG = false;
    private static final float DefaultPositionThreshold = Dp.m6614constructorimpl((float) 56);
    private static final PagerMeasureResult EmptyLayoutInfo = new PagerMeasureResult(CollectionsKt.emptyList(), 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, (MeasuredPage) null, (MeasuredPage) null, 0.0f, 0, false, new PagerStateKt$EmptyLayoutInfo$1(), false);
    private static final int MaxPagesForAnimateScroll = 3;
    public static final int PagesToPrefetch = 1;
    private static final SnapPositionInLayout SnapAlignmentStartToStart = new PagerStateKt$$ExternalSyntheticLambda0();
    /* access modifiers changed from: private */
    public static final PagerStateKt$UnitDensity$1 UnitDensity = new PagerStateKt$UnitDensity$1();

    /* access modifiers changed from: private */
    public static final int SnapAlignmentStartToStart$lambda$2(int i, int i2, int i3, int i4, int i5) {
        return 0;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    public static /* synthetic */ void getEmptyLayoutInfo$annotations() {
    }

    private static /* synthetic */ void getSingleAxisViewPort$annotations(PagerLayoutInfo pagerLayoutInfo) {
    }

    public static /* synthetic */ void getSnapAlignmentStartToStart$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.pager.PagerState rememberPagerState(int r10, float r11, kotlin.jvm.functions.Function0<java.lang.Integer> r12, androidx.compose.runtime.Composer r13, int r14, int r15) {
        /*
            r0 = -1210768637(0xffffffffb7d52303, float:-2.5407882E-5)
            r13.startReplaceableGroup(r0)
            java.lang.String r1 = "C(rememberPagerState)*80@3537L174:PagerState.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r13, r1)
            r1 = r15 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0011
            r10 = r2
        L_0x0011:
            r15 = r15 & 2
            if (r15 == 0) goto L_0x0016
            r11 = 0
        L_0x0016:
            boolean r15 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r15 == 0) goto L_0x0022
            r15 = -1
            java.lang.String r1 = "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:79)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r15, r1)
        L_0x0022:
            java.lang.Object[] r3 = new java.lang.Object[r2]
            androidx.compose.foundation.pager.PagerStateImpl$Companion r14 = androidx.compose.foundation.pager.PagerStateImpl.Companion
            androidx.compose.runtime.saveable.Saver r4 = r14.getSaver()
            r14 = -382513842(0xffffffffe9334d4e, float:-1.3547674E25)
            r13.startReplaceableGroup(r14)
            boolean r14 = r13.changed((int) r10)
            boolean r15 = r13.changed((float) r11)
            r14 = r14 | r15
            boolean r15 = r13.changedInstance(r12)
            r14 = r14 | r15
            java.lang.Object r15 = r13.rememberedValue()
            if (r14 != 0) goto L_0x004c
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r15 != r14) goto L_0x0057
        L_0x004c:
            androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1 r14 = new androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
            r14.<init>(r10, r11, r12)
            r15 = r14
            kotlin.jvm.functions.Function0 r15 = (kotlin.jvm.functions.Function0) r15
            r13.updateRememberedValue(r15)
        L_0x0057:
            r6 = r15
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            r13.endReplaceableGroup()
            r8 = 72
            r9 = 4
            r5 = 0
            r7 = r13
            java.lang.Object r10 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r3, r4, (java.lang.String) r5, r6, (androidx.compose.runtime.Composer) r7, (int) r8, (int) r9)
            androidx.compose.foundation.pager.PagerStateImpl r10 = (androidx.compose.foundation.pager.PagerStateImpl) r10
            androidx.compose.runtime.MutableState r11 = r10.getPageCountState()
            r11.setValue(r12)
            boolean r11 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r11 == 0) goto L_0x0078
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0078:
            r13.endReplaceableGroup()
            androidx.compose.foundation.pager.PagerState r10 = (androidx.compose.foundation.pager.PagerState) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerStateKt.rememberPagerState(int, float, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):androidx.compose.foundation.pager.PagerState");
    }

    public static final Object animateToNextPage(PagerState pagerState, Continuation<? super Unit> continuation) {
        if (pagerState.getCurrentPage() + 1 >= pagerState.getPageCount()) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, 0.0f, (AnimationSpec) null, continuation, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    public static final Object animateToPreviousPage(PagerState pagerState, Continuation<? super Unit> continuation) {
        if (pagerState.getCurrentPage() - 1 < 0) {
            return Unit.INSTANCE;
        }
        Object animateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() - 1, 0.0f, (AnimationSpec) null, continuation, 6, (Object) null);
        return animateScrollToPage$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToPage$default : Unit.INSTANCE;
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    public static final SnapPositionInLayout getSnapAlignmentStartToStart() {
        return SnapAlignmentStartToStart;
    }

    private static final int getSingleAxisViewPort(PagerLayoutInfo pagerLayoutInfo) {
        return pagerLayoutInfo.getOrientation() == Orientation.Vertical ? IntSize.m6789getHeightimpl(pagerLayoutInfo.m975getViewportSizeYbymL2g()) : IntSize.m6790getWidthimpl(pagerLayoutInfo.m975getViewportSizeYbymL2g());
    }

    /* access modifiers changed from: private */
    public static final int calculateNewMaxScrollOffset(PagerMeasureResult pagerMeasureResult, int i) {
        return RangesKt.coerceAtLeast((((pagerMeasureResult.getBeforeContentPadding() + (i * (pagerMeasureResult.getPageSpacing() + pagerMeasureResult.getPageSize()))) + pagerMeasureResult.getAfterContentPadding()) - pagerMeasureResult.getPageSpacing()) - getSingleAxisViewPort(pagerMeasureResult), 0);
    }
}
