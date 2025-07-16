package androidx.compose.foundation.pager;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.reflect.KProperty0;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÖ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 21\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&H\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0001\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u0004\u001a\u00020\u000521\u0010!\u001a-\u0012\u0004\u0012\u00020#\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\"¢\u0006\u0002\b%¢\u0006\u0002\b&2#\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00182\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100*H\u0003¢\u0006\u0002\u0010-\u001a\u0014\u0010.\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006/"}, d2 = {"Pager", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/pager/PagerState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "beyondBoundsPageCount", "", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "Pager-fs30GE4", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZIFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "rememberPagerItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pageCount", "(Landroidx/compose/foundation/pager/PagerState;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "dragDirectionDetector", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPager.kt */
public final class LazyLayoutPagerKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: androidx.compose.foundation.pager.PagerWrapperFlingBehavior} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: androidx.compose.foundation.pager.PagerBringIntoViewSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: Pager-fs30GE4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m968Pagerfs30GE4(androidx.compose.ui.Modifier r33, androidx.compose.foundation.pager.PagerState r34, androidx.compose.foundation.layout.PaddingValues r35, boolean r36, androidx.compose.foundation.gestures.Orientation r37, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior r38, boolean r39, int r40, float r41, androidx.compose.foundation.pager.PageSize r42, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r43, kotlin.jvm.functions.Function1<? super java.lang.Integer, ? extends java.lang.Object> r44, androidx.compose.ui.Alignment.Horizontal r45, androidx.compose.ui.Alignment.Vertical r46, kotlin.jvm.functions.Function4<? super androidx.compose.foundation.pager.PagerScope, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, int r49, int r50, int r51) {
        /*
            r15 = r34
            r14 = r36
            r13 = r37
            r12 = r38
            r11 = r49
            r10 = r50
            r9 = r51
            r0 = -301644943(0xffffffffee054371, float:-1.031076E28)
            r1 = r48
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            java.lang.String r1 = "C(Pager)P(5,12,1,11,6,2,13!1,10:c#ui.unit.Dp,9,8,4!1,14)101@4846L18,103@4894L134,109@5054L534,124@5619L94,128@5739L115,134@5889L49,140@6089L276,149@6485L150,155@6798L7,148@6429L478,163@7131L7,136@5944L1832:LazyLayoutPager.kt#g6yjnt"
            androidx.compose.runtime.ComposerKt.sourceInformation(r8, r1)
            r1 = r9 & 128(0x80, float:1.794E-43)
            r7 = 0
            if (r1 == 0) goto L_0x0023
            r6 = r7
            goto L_0x0025
        L_0x0023:
            r6 = r40
        L_0x0025:
            r1 = r9 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0031
            float r1 = (float) r7
            float r1 = androidx.compose.ui.unit.Dp.m6614constructorimpl(r1)
            r16 = r1
            goto L_0x0033
        L_0x0031:
            r16 = r41
        L_0x0033:
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x003e
            java.lang.String r1 = "androidx.compose.foundation.pager.Pager (LazyLayoutPager.kt:95)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r11, r10, r1)
        L_0x003e:
            if (r6 < 0) goto L_0x0297
            androidx.compose.foundation.gestures.ScrollableDefaults r0 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            r5 = 6
            androidx.compose.foundation.OverscrollEffect r4 = r0.overscrollEffect(r8, r5)
            r0 = -735094232(0xffffffffd42f5a28, float:-3.01252739E12)
            r8.startReplaceableGroup(r0)
            boolean r0 = r8.changed((java.lang.Object) r15)
            java.lang.Object r1 = r8.rememberedValue()
            if (r0 != 0) goto L_0x005f
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x006a
        L_0x005f:
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$pagerItemProvider$1$1 r0 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$pagerItemProvider$1$1
            r0.<init>(r15)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r8.updateRememberedValue(r1)
        L_0x006a:
            r3 = r1
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r8.endReplaceableGroup()
            int r2 = r11 >> 3
            r17 = r2 & 14
            int r0 = r10 >> 9
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r17 | r0
            int r1 = r10 << 3
            r1 = r1 & 896(0x380, float:1.256E-42)
            r18 = r0 | r1
            r0 = r34
            r1 = r47
            r19 = r2
            r2 = r44
            r20 = r4
            r4 = r8
            r21 = r5
            r5 = r18
            kotlin.jvm.functions.Function0 r18 = rememberPagerItemProviderLambda(r0, r1, r2, r3, r4, r5)
            androidx.compose.foundation.gestures.snapping.SnapPositionInLayout r22 = androidx.compose.foundation.pager.PagerStateKt.getSnapAlignmentStartToStart()
            r0 = -735093678(0xffffffffd42f5c52, float:-3.01267262E12)
            r8.startReplaceableGroup(r0)
            boolean r0 = r8.changed((java.lang.Object) r15)
            java.lang.Object r1 = r8.rememberedValue()
            if (r0 != 0) goto L_0x00af
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x00ba
        L_0x00af:
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$measurePolicy$1$1 r0 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$measurePolicy$1$1
            r0.<init>(r15)
            r1 = r0
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            r8.updateRememberedValue(r1)
        L_0x00ba:
            r23 = r1
            kotlin.jvm.functions.Function0 r23 = (kotlin.jvm.functions.Function0) r23
            r8.endReplaceableGroup()
            r5 = r11 & 7168(0x1c00, float:1.0045E-41)
            r0 = 65520(0xfff0, float:9.1813E-41)
            r0 = r0 & r11
            int r24 = r11 >> 6
            r25 = 458752(0x70000, float:6.42848E-40)
            r1 = r24 & r25
            r0 = r0 | r1
            r26 = 3670016(0x380000, float:5.142788E-39)
            r1 = r24 & r26
            r0 = r0 | r1
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r24 & r1
            r0 = r0 | r1
            int r1 = r10 << 18
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r1
            r0 = r0 | r2
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r1 = r1 & r2
            r27 = r0 | r1
            r28 = 0
            r0 = r18
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r29 = r5
            r5 = r6
            r30 = r6
            r6 = r16
            r31 = r7
            r7 = r42
            r40 = r8
            r8 = r45
            r9 = r46
            r10 = r22
            r11 = r23
            r12 = r40
            r13 = r27
            r14 = r28
            kotlin.jvm.functions.Function2 r9 = androidx.compose.foundation.pager.PagerMeasurePolicyKt.m979rememberPagerMeasurePolicy121YqSk(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = 511388516(0x1e7b2b64, float:1.3296802E-20)
            r10 = r40
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1,2):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            r11 = r38
            boolean r0 = r10.changed((java.lang.Object) r11)
            boolean r1 = r10.changed((java.lang.Object) r15)
            r0 = r0 | r1
            java.lang.Object r1 = r10.rememberedValue()
            if (r0 != 0) goto L_0x0134
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x013c
        L_0x0134:
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r1 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior
            r1.<init>(r11, r15)
            r10.updateRememberedValue(r1)
        L_0x013c:
            r10.endReplaceableGroup()
            r12 = r1
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r12 = (androidx.compose.foundation.pager.PagerWrapperFlingBehavior) r12
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            r13 = r37
            if (r13 != r0) goto L_0x014a
            r7 = 1
            goto L_0x014c
        L_0x014a:
            r7 = r31
        L_0x014c:
            r0 = r24 & 112(0x70, float:1.57E-43)
            r0 = r17 | r0
            r14 = r36
            androidx.compose.foundation.lazy.layout.LazyLayoutSemanticState r2 = androidx.compose.foundation.pager.PagerSemanticsKt.rememberPagerSemanticState(r15, r14, r7, r10, r0)
            r0 = 1157296644(0x44faf204, float:2007.563)
            r10.startReplaceableGroup(r0)
            java.lang.String r0 = "CC(remember)P(1):Composables.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformation(r10, r0)
            boolean r0 = r10.changed((java.lang.Object) r15)
            java.lang.Object r1 = r10.rememberedValue()
            if (r0 != 0) goto L_0x0173
            androidx.compose.runtime.Composer$Companion r0 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r0.getEmpty()
            if (r1 != r0) goto L_0x017b
        L_0x0173:
            androidx.compose.foundation.pager.PagerBringIntoViewSpec r1 = new androidx.compose.foundation.pager.PagerBringIntoViewSpec
            r1.<init>(r15)
            r10.updateRememberedValue(r1)
        L_0x017b:
            r10.endReplaceableGroup()
            r22 = r1
            androidx.compose.foundation.pager.PagerBringIntoViewSpec r22 = (androidx.compose.foundation.pager.PagerBringIntoViewSpec) r22
            androidx.compose.ui.layout.RemeasurementModifier r0 = r34.getRemeasurementModifier$foundation_release()
            androidx.compose.ui.Modifier r0 = (androidx.compose.ui.Modifier) r0
            r8 = r33
            androidx.compose.ui.Modifier r0 = r8.then(r0)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r1 = r34.getAwaitLayoutModifier$foundation_release()
            androidx.compose.ui.Modifier r1 = (androidx.compose.ui.Modifier) r1
            androidx.compose.ui.Modifier r0 = r0.then(r1)
            r1 = r19
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r24 & r3
            r1 = r1 | r3
            int r3 = r49 << 6
            r3 = r3 & r25
            r7 = r1 | r3
            r1 = r18
            r3 = r37
            r4 = r39
            r5 = r36
            r6 = r10
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt.lazyLayoutSemantics(r0, r1, r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ClipScrollableContainerKt.clipScrollableContainer(r0, r13)
            int r1 = r49 >> 18
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r17 | r1
            r7 = r30
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r1 = androidx.compose.foundation.pager.PagerBeyondBoundsModifierKt.rememberPagerBeyondBoundsState(r15, r7, r10, r1)
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo r2 = r34.getBeyondBoundsInfo$foundation_release()
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r3 = (androidx.compose.runtime.CompositionLocal) r3
            r6 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r5 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r6, r5)
            java.lang.Object r3 = r10.consume(r3)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            r4 = r3
            androidx.compose.ui.unit.LayoutDirection r4 = (androidx.compose.ui.unit.LayoutDirection) r4
            int r3 = androidx.compose.runtime.collection.MutableVector.$stable
            int r3 = r3 << 6
            r3 = r3 | r29
            int r17 = r49 << 3
            r17 = r17 & r25
            r3 = r3 | r17
            r17 = r49 & r26
            r17 = r3 | r17
            r3 = r36
            r11 = r5
            r5 = r37
            r40 = r9
            r9 = r6
            r6 = r39
            r7 = r10
            r8 = r17
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            r3 = r20
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.OverscrollKt.overscroll(r0, r3)
            androidx.compose.foundation.gestures.ScrollableDefaults r1 = androidx.compose.foundation.gestures.ScrollableDefaults.INSTANCE
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.runtime.CompositionLocal r2 = (androidx.compose.runtime.CompositionLocal) r2
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r10, r9, r11)
            java.lang.Object r2 = r10.consume(r2)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r10)
            androidx.compose.ui.unit.LayoutDirection r2 = (androidx.compose.ui.unit.LayoutDirection) r2
            boolean r5 = r1.reverseDirection(r2, r13, r14)
            androidx.compose.foundation.interaction.MutableInteractionSource r7 = r34.getInternalInteractionSource$foundation_release()
            r1 = r15
            androidx.compose.foundation.gestures.ScrollableState r1 = (androidx.compose.foundation.gestures.ScrollableState) r1
            r6 = r12
            androidx.compose.foundation.gestures.FlingBehavior r6 = (androidx.compose.foundation.gestures.FlingBehavior) r6
            r8 = r22
            androidx.compose.foundation.gestures.BringIntoViewSpec r8 = (androidx.compose.foundation.gestures.BringIntoViewSpec) r8
            r2 = r37
            r4 = r39
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.gestures.ScrollableKt.scrollable(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.compose.ui.Modifier r0 = dragDirectionDetector(r0, r15)
            r1 = 2
            r2 = 0
            r11 = r43
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt.nestedScroll$default(r0, r11, r2, r1, r2)
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3 = r34.getPrefetchState$foundation_release()
            r6 = 0
            r7 = 0
            r1 = r18
            r4 = r40
            r5 = r10
            androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout((kotlin.jvm.functions.Function0<? extends androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider>) r1, (androidx.compose.ui.Modifier) r2, (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult>) r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0259
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x0259:
            androidx.compose.runtime.ScopeUpdateScope r12 = r10.endRestartGroup()
            if (r12 == 0) goto L_0x0296
            androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$2 r19 = new androidx.compose.foundation.pager.LazyLayoutPagerKt$Pager$2
            r0 = r19
            r1 = r33
            r2 = r34
            r3 = r35
            r4 = r36
            r5 = r37
            r6 = r38
            r7 = r39
            r8 = r30
            r9 = r16
            r10 = r42
            r11 = r43
            r15 = r12
            r12 = r44
            r13 = r45
            r14 = r46
            r32 = r15
            r15 = r47
            r16 = r49
            r17 = r50
            r18 = r51
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0 = r19
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            r1 = r32
            r1.updateScope(r0)
        L_0x0296:
            return
        L_0x0297:
            r30 = r6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "beyondBoundsPageCount should be greater than or equal to 0, you selected "
            r0.<init>(r1)
            r7 = r30
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.m968Pagerfs30GE4(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.gestures.snapping.SnapFlingBehavior, boolean, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, kotlin.jvm.functions.Function1, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Function0<PagerLazyLayoutItemProvider> rememberPagerItemProviderLambda(PagerState pagerState, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Function1<? super Integer, ? extends Object> function1, Function0<Integer> function0, Composer composer, int i) {
        composer.startReplaceableGroup(-1372505274);
        ComposerKt.sourceInformation(composer, "C(rememberPagerItemProviderLambda)P(3,1)248@10137L33,249@10191L25,250@10228L677:LazyLayoutPager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:247)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function4, composer, (i >> 3) & 14);
        State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 6) & 14);
        Object[] objArr = {pagerState, rememberUpdatedState, rememberUpdatedState2, function0};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            z |= composer.changed(objArr[i2]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1(rememberUpdatedState, rememberUpdatedState2, function0)), pagerState)));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        KProperty0 kProperty0 = (KProperty0) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return kProperty0;
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, PagerState pagerState) {
        return modifier.then(SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.Companion, (Object) pagerState, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new LazyLayoutPagerKt$dragDirectionDetector$1(pagerState, (Continuation<? super LazyLayoutPagerKt$dragDirectionDetector$1>) null)));
    }
}
