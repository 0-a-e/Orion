package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001av\u0010\u0019\u001a\u0019\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001a¢\u0006\u0002\b\u00172\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010!\u001a\u00020\"H\u0003¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slots", "Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "rememberLazyGridMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/lazy/grid/LazyGridSlotsProvider;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
public final class LazyGridKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void LazyGrid(androidx.compose.ui.Modifier r34, androidx.compose.foundation.lazy.grid.LazyGridState r35, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider r36, androidx.compose.foundation.layout.PaddingValues r37, boolean r38, boolean r39, androidx.compose.foundation.gestures.FlingBehavior r40, boolean r41, androidx.compose.foundation.layout.Arrangement.Vertical r42, androidx.compose.foundation.layout.Arrangement.Horizontal r43, kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r44, androidx.compose.runtime.Composer r45, int r46, int r47, int r48) {
        /*
            r11 = r35
            r12 = r39
            r13 = r44
            r14 = r46
            r15 = r48
            r0 = -649686062(0xffffffffd94693d2, float:-3.49341097E15)
            r1 = r45
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(LazyGrid)P(5,8,7,1,6,4,2,9,10,3)68@3230L15,78@3671L18,80@3720L50,82@3796L51,84@3874L24,85@3923L244,104@4440L277,113@4837L48,116@5048L7,112@4781L376,124@5381L7,100@4295L1571:LazyGrid.kt#7791vq"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r1)
            r1 = r15 & 1
            if (r1 == 0) goto L_0x0022
            r4 = r14 | 6
            r5 = r4
            r4 = r34
            goto L_0x0036
        L_0x0022:
            r4 = r14 & 14
            if (r4 != 0) goto L_0x0033
            r4 = r34
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0030
            r5 = 4
            goto L_0x0031
        L_0x0030:
            r5 = 2
        L_0x0031:
            r5 = r5 | r14
            goto L_0x0036
        L_0x0033:
            r4 = r34
            r5 = r14
        L_0x0036:
            r6 = r15 & 2
            if (r6 == 0) goto L_0x003d
            r5 = r5 | 48
            goto L_0x004d
        L_0x003d:
            r6 = r14 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004d
            boolean r6 = r10.changed((java.lang.Object) r11)
            if (r6 == 0) goto L_0x004a
            r6 = 32
            goto L_0x004c
        L_0x004a:
            r6 = 16
        L_0x004c:
            r5 = r5 | r6
        L_0x004d:
            r6 = r15 & 4
            if (r6 == 0) goto L_0x0056
            r5 = r5 | 384(0x180, float:5.38E-43)
            r9 = r36
            goto L_0x0068
        L_0x0056:
            r6 = r14 & 896(0x380, float:1.256E-42)
            r9 = r36
            if (r6 != 0) goto L_0x0068
            boolean r6 = r10.changed((java.lang.Object) r9)
            if (r6 == 0) goto L_0x0065
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0067
        L_0x0065:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0067:
            r5 = r5 | r6
        L_0x0068:
            r6 = r15 & 8
            if (r6 == 0) goto L_0x006f
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0082
        L_0x006f:
            r7 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0082
            r7 = r37
            boolean r8 = r10.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x007e
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r5 = r5 | r8
            goto L_0x0084
        L_0x0082:
            r7 = r37
        L_0x0084:
            r8 = r15 & 16
            r16 = 57344(0xe000, float:8.0356E-41)
            if (r8 == 0) goto L_0x0090
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            r2 = r38
            goto L_0x00a3
        L_0x0090:
            r17 = r14 & r16
            r2 = r38
            if (r17 != 0) goto L_0x00a3
            boolean r17 = r10.changed((boolean) r2)
            if (r17 == 0) goto L_0x009f
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a1
        L_0x009f:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x00a1:
            r5 = r5 | r17
        L_0x00a3:
            r17 = r15 & 32
            r18 = 458752(0x70000, float:6.42848E-40)
            if (r17 == 0) goto L_0x00ae
            r17 = 196608(0x30000, float:2.75506E-40)
        L_0x00ab:
            r5 = r5 | r17
            goto L_0x00be
        L_0x00ae:
            r17 = r14 & r18
            if (r17 != 0) goto L_0x00be
            boolean r17 = r10.changed((boolean) r12)
            if (r17 == 0) goto L_0x00bb
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00ab
        L_0x00bb:
            r17 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00ab
        L_0x00be:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r19 = r14 & r17
            if (r19 != 0) goto L_0x00d8
            r19 = r15 & 64
            r0 = r40
            if (r19 != 0) goto L_0x00d3
            boolean r20 = r10.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x00d3
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r5 = r5 | r20
            goto L_0x00da
        L_0x00d8:
            r0 = r40
        L_0x00da:
            r3 = r15 & 128(0x80, float:1.794E-43)
            r21 = 29360128(0x1c00000, float:7.052966E-38)
            if (r3 == 0) goto L_0x00e4
            r3 = 12582912(0xc00000, float:1.7632415E-38)
            r5 = r5 | r3
            goto L_0x00f8
        L_0x00e4:
            r3 = r14 & r21
            if (r3 != 0) goto L_0x00f8
            r3 = r41
            boolean r22 = r10.changed((boolean) r3)
            if (r22 == 0) goto L_0x00f3
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f5
        L_0x00f3:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f5:
            r5 = r5 | r22
            goto L_0x00fa
        L_0x00f8:
            r3 = r41
        L_0x00fa:
            r0 = r15 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0102
            r0 = 100663296(0x6000000, float:2.4074124E-35)
            r5 = r5 | r0
            goto L_0x0117
        L_0x0102:
            r0 = 234881024(0xe000000, float:1.5777218E-30)
            r0 = r0 & r14
            if (r0 != 0) goto L_0x0117
            r0 = r42
            boolean r22 = r10.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x0112
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0114
        L_0x0112:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0114:
            r5 = r5 | r22
            goto L_0x0119
        L_0x0117:
            r0 = r42
        L_0x0119:
            r0 = r15 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0121
            r0 = 805306368(0x30000000, float:4.656613E-10)
            r5 = r5 | r0
            goto L_0x0136
        L_0x0121:
            r0 = 1879048192(0x70000000, float:1.58456325E29)
            r0 = r0 & r14
            if (r0 != 0) goto L_0x0136
            r0 = r43
            boolean r22 = r10.changed((java.lang.Object) r0)
            if (r22 == 0) goto L_0x0131
            r22 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0133
        L_0x0131:
            r22 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0133:
            r5 = r5 | r22
            goto L_0x0138
        L_0x0136:
            r0 = r43
        L_0x0138:
            r0 = r15 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x013f
            r0 = r47 | 6
            goto L_0x0151
        L_0x013f:
            r0 = r47 & 14
            if (r0 != 0) goto L_0x014f
            boolean r0 = r10.changedInstance(r13)
            if (r0 == 0) goto L_0x014b
            r0 = 4
            goto L_0x014c
        L_0x014b:
            r0 = 2
        L_0x014c:
            r0 = r47 | r0
            goto L_0x0151
        L_0x014f:
            r0 = r47
        L_0x0151:
            r22 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r5 & r22
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r3) goto L_0x0173
            r2 = r0 & 11
            r3 = 2
            if (r2 != r3) goto L_0x0173
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x0167
            goto L_0x0173
        L_0x0167:
            r10.skipToGroupEnd()
            r5 = r38
            r1 = r4
            r4 = r7
            r14 = r10
            r7 = r40
            goto L_0x0345
        L_0x0173:
            r10.startDefaults()
            r2 = r14 & 1
            r3 = 6
            if (r2 == 0) goto L_0x0196
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0182
            goto L_0x0196
        L_0x0182:
            r10.skipToGroupEnd()
            r1 = r15 & 64
            if (r1 == 0) goto L_0x018d
            r1 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r1
        L_0x018d:
            r33 = r40
            r8 = r4
            r6 = r5
            r20 = r7
            r7 = r38
            goto L_0x01cd
        L_0x0196:
            if (r1 == 0) goto L_0x019d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            goto L_0x019e
        L_0x019d:
            r1 = r4
        L_0x019e:
            r2 = 0
            if (r6 == 0) goto L_0x01ab
            float r4 = (float) r2
            float r4 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r4)
            androidx.compose.foundation.layout.PaddingValues r4 = androidx.compose.foundation.layout.PaddingKt.m663PaddingValues0680j_4(r4)
            goto L_0x01ac
        L_0x01ab:
            r4 = r7
        L_0x01ac:
            if (r8 == 0) goto L_0x01af
            goto L_0x01b1
        L_0x01af:
            r2 = r38
        L_0x01b1:
            r6 = r15 & 64
            if (r6 == 0) goto L_0x01c6
            androidx.compose.foundation.gestures.ScrollableDefaults r6 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.gestures.FlingBehavior r6 = r6.flingBehavior(r10, r3)
            r7 = -3670017(0xffffffffffc7ffff, float:NaN)
            r5 = r5 & r7
            r8 = r1
            r7 = r2
            r20 = r4
            r33 = r6
            goto L_0x01cc
        L_0x01c6:
            r33 = r40
            r8 = r1
            r7 = r2
            r20 = r4
        L_0x01cc:
            r6 = r5
        L_0x01cd:
            r10.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x01de
            java.lang.String r1 = "androidx.compose.foundation.lazy.grid.LazyGrid (LazyGrid.kt:77)"
            r2 = -649686062(0xffffffffd94693d2, float:-3.49341097E15)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r6, r0, r1)
        L_0x01de:
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.foundation.OverscrollEffect r5 = r1.overscrollEffect(r10, r3)
            int r4 = r6 >> 3
            r2 = r4 & 14
            int r0 = r0 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            kotlin.jvm.functions.Function0 r19 = androidx.compose.foundation.lazy.grid.LazyGridItemProviderKt.rememberLazyGridItemProviderLambda(r11, r13, r10, r0)
            int r22 = r6 >> 9
            r0 = r22 & 112(0x70, float:1.57E-43)
            r0 = r0 | r2
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r23 = androidx.compose.foundation.lazy.grid.LazySemanticsKt.rememberLazyGridSemanticState(r11, r7, r10, r0)
            r0 = 773894976(0x2e20b340, float:3.6538994E-11)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r0 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            java.lang.Object r0 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x022d
            kotlin.coroutines.EmptyCoroutineContext r0 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            kotlinx.coroutines.CoroutineScope r0 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r0, r10)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r1 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r1.<init>(r0)
            r10.updateRememberedValue(r1)
            r0 = r1
        L_0x022d:
            r10.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r0 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r0
            kotlinx.coroutines.CoroutineScope r24 = r0.getCoroutineScope()
            r10.endReplaceableGroup()
            r0 = r6 & 112(0x70, float:1.57E-43)
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 | r1
            r1 = r6 & 896(0x380, float:1.256E-42)
            r0 = r0 | r1
            r1 = r6 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r1
            r1 = r6 & r16
            r0 = r0 | r1
            r1 = r6 & r18
            r0 = r0 | r1
            r1 = r22 & r17
            r0 = r0 | r1
            r1 = r4 & r21
            r21 = r0 | r1
            r0 = r19
            r1 = r35
            r13 = r2
            r2 = r36
            r25 = r3
            r3 = r20
            r14 = r4
            r4 = r7
            r15 = r5
            r5 = r39
            r26 = r6
            r6 = r43
            r34 = r7
            r7 = r42
            r27 = r15
            r15 = r8
            r8 = r24
            r9 = r10
            r37 = r10
            r10 = r21
            kotlin.jvm.functions.Function2 r0 = rememberLazyGridMeasurePolicy(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.setVertical$foundation_release(r12)
            if (r12 == 0) goto L_0x027f
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Vertical
            goto L_0x0281
        L_0x027f:
            androidx.compose.foundation.gestures.Orientation r1 = androidx.compose.foundation.gestures.Orientation.Horizontal
        L_0x0281:
            r10 = r1
            androidx.compose.ui.layout.RemeasurementModifier r1 = r35.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r1 = r15.then(r1)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r2 = r35.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r2 = (androidx.compose.ui.Modifier) r2
            androidx.compose.ui.Modifier r1 = r1.then(r2)
            r2 = r22 & r16
            int r3 = r26 << 3
            r3 = r3 & r18
            r8 = r2 | r3
            r2 = r19
            r3 = r23
            r4 = r10
            r5 = r41
            r6 = r34
            r7 = r37
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r1, r10)
            r9 = r37
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r2 = androidx.compose.foundation.lazy.grid.LazyGridBeyondBoundsModifierKt.rememberLazyGridBeyondBoundsState(r11, r9, r13)
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r3 = r35.getBeyondBoundsInfo$foundation_release()
            androidx.compose.runtime.ProvidableCompositionLocal r4 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r4 = (androidx.compose.runtime.CompositionLocal) r4
            r5 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r6 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r9, r5, r6)
            java.lang.Object r4 = r9.consume(r4)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r9)
            r5 = r4
            androidx.compose.ui.unit.LayoutDirection r5 = (androidx.compose.ui.unit.LayoutDirection) r5
            int r4 = androidx.compose.runtime.collection.MutableVector.$stable
            int r4 = r4 << 6
            r6 = r14 & 7168(0x1c00, float:1.0045E-41)
            r4 = r4 | r6
            r6 = r14 & r17
            r13 = r4 | r6
            r4 = r34
            r6 = r10
            r7 = r41
            r8 = r9
            r14 = r9
            r9 = r13
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r2 = r27
            androidx.compose.ui.Modifier r22 = androidx.compose.foundation.OverscrollKt.overscroll(r1, r2)
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r4 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r4, r5)
            java.lang.Object r3 = r14.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.ui.unit.LayoutDirection r3 = (androidx.compose.ui.unit.LayoutDirection) r3
            r8 = r34
            boolean r27 = r1.reverseDirection(r3, r10, r8)
            androidx.compose.foundation.interaction.MutableInteractionSource r29 = r35.getInternalInteractionSource$foundation_release()
            r23 = r11
            androidx.compose.foundation.gestures.ScrollableState r23 = (androidx.compose.foundation.gestures.ScrollableState) r23
            r31 = 128(0x80, float:1.794E-43)
            r32 = 0
            r30 = 0
            r24 = r10
            r25 = r2
            r26 = r41
            r28 = r33
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.gestures.ScrollableKt.scrollable$default(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r35.getPrefetchState$foundation_release()
            r6 = 0
            r7 = 0
            r1 = r19
            r4 = r0
            r5 = r14
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x033f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x033f:
            r5 = r8
            r1 = r15
            r4 = r20
            r7 = r33
        L_0x0345:
            androidx.compose.runtime.ScopeUpdateScope r15 = r14.endRestartGroup()
            if (r15 == 0) goto L_0x036d
            androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1 r16 = new androidx.compose.foundation.lazy.grid.LazyGridKt$LazyGrid$1
            r0 = r16
            r2 = r35
            r3 = r36
            r6 = r39
            r8 = r41
            r9 = r42
            r10 = r43
            r11 = r44
            r12 = r46
            r13 = r47
            r14 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = r16
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r15.updateScope(r0)
        L_0x036d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(Function0<? extends LazyGridItemProvider> function0, LazyGridState lazyGridState, LazyGridSlotsProvider lazyGridSlotsProvider, PaddingValues paddingValues, boolean z, boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, CoroutineScope coroutineScope, Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-2068958445);
        ComposerKt.sourceInformation(composer2, "C(rememberLazyGridMeasurePolicy)P(4,7,6!1,5,3,2,8)167@6903L8834:LazyGrid.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2068958445, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridMeasurePolicy (LazyGrid.kt:167)");
        }
        Object[] objArr = {lazyGridState, lazyGridSlotsProvider, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal, vertical};
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i2 = 0; i2 < 7; i2++) {
            z3 |= composer2.changed(objArr[i2]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z3 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1(z2, paddingValues, z, function0, lazyGridSlotsProvider, lazyGridState, vertical, horizontal, coroutineScope);
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
}
