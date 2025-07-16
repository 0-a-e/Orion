package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"rememberPagerBeyondBoundsState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "state", "Landroidx/compose/foundation/pager/PagerState;", "beyondBoundsPageCount", "", "(Landroidx/compose/foundation/pager/PagerState;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsState;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: PagerBeyondBoundsModifier.kt */
public final class PagerBeyondBoundsModifierKt {
    public static final LazyLayoutBeyondBoundsState rememberPagerBeyondBoundsState(PagerState pagerState, int i, Composer composer, int i2) {
        composer.startReplaceableGroup(373558254);
        ComposerKt.sourceInformation(composer, "C(rememberPagerBeyondBoundsState)P(1)28@1076L107:PagerBeyondBoundsModifier.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(373558254, i2, -1, "androidx.compose.foundation.pager.rememberPagerBeyondBoundsState (PagerBeyondBoundsModifier.kt:27)");
        }
        Integer valueOf = Integer.valueOf(i);
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) valueOf) | composer.changed((Object) pagerState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PagerBeyondBoundsState(pagerState, i);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PagerBeyondBoundsState pagerBeyondBoundsState = (PagerBeyondBoundsState) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pagerBeyondBoundsState;
    }
}
