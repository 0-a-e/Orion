package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ClipScrollableContainerKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocalKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"LazyStaggeredGrid", "", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "slots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScope;", "Lkotlin/ExtensionFunctionType;", "LazyStaggeredGrid-LJWHXA8", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/lazy/staggeredgrid/LazyGridStaggeredGridSlotsProvider;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/FlingBehavior;ZFFLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyStaggeredGrid.kt */
public final class LazyStaggeredGridKt {
    /* renamed from: LazyStaggeredGrid-LJWHXA8  reason: not valid java name */
    public static final void m929LazyStaggeredGridLJWHXA8(LazyStaggeredGridState lazyStaggeredGridState, Orientation orientation, LazyGridStaggeredGridSlotsProvider lazyGridStaggeredGridSlotsProvider, Modifier modifier, PaddingValues paddingValues, boolean z, FlingBehavior flingBehavior, boolean z2, float f, float f2, Function1<? super LazyStaggeredGridScope, Unit> function1, Composer composer, int i, int i2, int i3) {
        Modifier modifier2;
        FlingBehavior flingBehavior2;
        int i4;
        float f3;
        LazyStaggeredGridState lazyStaggeredGridState2 = lazyStaggeredGridState;
        Orientation orientation2 = orientation;
        int i5 = i2;
        int i6 = i3;
        Composer startRestartGroup = composer.startRestartGroup(288295126);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyStaggeredGrid)P(9,6,8,5,1,7,3,10,4:c#ui.unit.Dp,2:c#ui.unit.Dp)52@2419L15,62@2835L18,64@2884L55,65@2965L24,66@3014L242,77@3281L60,83@3492L277,92@3889L57,95@4109L7,91@3833L385,103@4442L7,79@3347L1579:LazyStaggeredGrid.kt#fzvcnm");
        if ((i6 & 8) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        PaddingValues r16 = (i6 & 16) != 0 ? PaddingKt.m663PaddingValues0680j_4(Dp.m6614constructorimpl((float) 0)) : paddingValues;
        boolean z3 = (i6 & 32) != 0 ? false : z;
        if ((i6 & 64) != 0) {
            flingBehavior2 = ScrollableDefaults.INSTANCE.flingBehavior(startRestartGroup, 6);
            i4 = i & -3670017;
        } else {
            flingBehavior2 = flingBehavior;
            i4 = i;
        }
        boolean z4 = (i6 & 128) != 0 ? true : z2;
        float r19 = (i6 & 256) != 0 ? Dp.m6614constructorimpl((float) 0) : f;
        if ((i6 & 512) != 0) {
            f3 = Dp.m6614constructorimpl((float) 0);
        } else {
            f3 = f2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(288295126, i4, i5, "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGrid (LazyStaggeredGrid.kt:61)");
        }
        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(startRestartGroup, 6);
        Function0<LazyStaggeredGridItemProvider> rememberStaggeredGridItemProviderLambda = LazyStaggeredGridItemProviderKt.rememberStaggeredGridItemProviderLambda(lazyStaggeredGridState2, function1, startRestartGroup, ((i5 << 3) & 112) | 8);
        startRestartGroup.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        startRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
            startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        startRestartGroup.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        startRestartGroup.endReplaceableGroup();
        int i7 = i4 >> 6;
        int i8 = i7 & 7168;
        int i9 = i4 >> 9;
        int i10 = i8;
        int i11 = i4;
        Modifier modifier3 = modifier2;
        Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> r27 = LazyStaggeredGridMeasurePolicyKt.m939rememberStaggeredGridMeasurePolicy1tP8Re8(lazyStaggeredGridState, rememberStaggeredGridItemProviderLambda, r16, z3, orientation, r19, f3, coroutineScope, lazyGridStaggeredGridSlotsProvider, startRestartGroup, (i7 & 896) | 16777224 | i8 | ((i4 << 9) & 57344) | (i9 & 458752) | (i9 & 3670016) | ((i4 << 18) & 234881024));
        boolean z5 = z3;
        Modifier clipScrollableContainer = ClipScrollableContainerKt.clipScrollableContainer(LazyLayoutSemanticsKt.lazyLayoutSemantics(modifier3.then(lazyStaggeredGridState.getRemeasurementModifier$foundation_release()).then(lazyStaggeredGridState.getAwaitLayoutModifier$foundation_release()), rememberStaggeredGridItemProviderLambda, LazyStaggeredGridSemanticsKt.rememberLazyStaggeredGridSemanticState(lazyStaggeredGridState2, z5, startRestartGroup, ((i11 >> 12) & 112) | 8), orientation, z4, z5, startRestartGroup, ((i11 << 6) & 7168) | (i9 & 57344) | (i11 & 458752)), orientation2);
        LazyLayoutBeyondBoundsState rememberLazyStaggeredGridBeyondBoundsState = LazyStaggeredGridBeyondBoundsModifierKt.rememberLazyStaggeredGridBeyondBoundsState(lazyStaggeredGridState2, startRestartGroup, 8);
        LazyLayoutBeyondBoundsInfo beyondBoundsInfo$foundation_release = lazyStaggeredGridState.getBeyondBoundsInfo$foundation_release();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier lazyLayoutBeyondBoundsModifier = LazyLayoutBeyondBoundsModifierLocalKt.lazyLayoutBeyondBoundsModifier(clipScrollableContainer, rememberLazyStaggeredGridBeyondBoundsState, beyondBoundsInfo$foundation_release, z5, (LayoutDirection) consume, orientation, z4, startRestartGroup, (MutableVector.$stable << 6) | i10 | ((i11 << 12) & 458752) | ((i11 >> 3) & 3670016));
        OverscrollEffect overscrollEffect2 = overscrollEffect;
        Modifier overscroll = OverscrollKt.overscroll(lazyLayoutBeyondBoundsModifier, overscrollEffect2);
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2 = startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Modifier modifier4 = modifier3;
        boolean z6 = z5;
        LazyLayoutKt.LazyLayout((Function0<? extends LazyLayoutItemProvider>) rememberStaggeredGridItemProviderLambda, ScrollableKt.scrollable$default(overscroll, lazyStaggeredGridState2, orientation, overscrollEffect2, z4, scrollableDefaults.reverseDirection((LayoutDirection) consume2, orientation2, z5), flingBehavior2, lazyStaggeredGridState.getMutableInteractionSource$foundation_release(), (BringIntoViewSpec) null, 128, (Object) null), lazyStaggeredGridState.getPrefetchState$foundation_release(), (Function2<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult>) r27, startRestartGroup, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyStaggeredGridKt$LazyStaggeredGrid$1(lazyStaggeredGridState, orientation, lazyGridStaggeredGridSlotsProvider, modifier4, r16, z6, flingBehavior2, z4, r19, f3, function1, i, i2, i3));
        }
    }
}
