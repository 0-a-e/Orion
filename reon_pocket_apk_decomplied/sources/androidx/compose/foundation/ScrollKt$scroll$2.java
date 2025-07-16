package androidx.compose.foundation;

import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollKt$scroll$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ FlingBehavior $flingBehavior;
    final /* synthetic */ boolean $isScrollable;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ boolean $reverseScrolling;
    final /* synthetic */ ScrollState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollKt$scroll$2(boolean z, boolean z2, ScrollState scrollState, boolean z3, FlingBehavior flingBehavior) {
        super(3);
        this.$isVertical = z;
        this.$reverseScrolling = z2;
        this.$state = scrollState;
        this.$isScrollable = z3;
        this.$flingBehavior = flingBehavior;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceableGroup(1478351300);
        ComposerKt.sourceInformation(composer, "C272@10178L18,273@10226L24,306@11719L7:Scroll.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1478351300, i, -1, "androidx.compose.foundation.scroll.<anonymous> (Scroll.kt:272)");
        }
        OverscrollEffect overscrollEffect = ScrollableDefaults.INSTANCE.overscrollEffect(composer, 6);
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new ScrollKt$scroll$2$semantics$1(this.$reverseScrolling, this.$isVertical, this.$isScrollable, this.$state, coroutineScope), 1, (Object) null);
        Orientation orientation = this.$isVertical ? Orientation.Vertical : Orientation.Horizontal;
        Modifier.Companion companion = Modifier.Companion;
        ScrollableDefaults scrollableDefaults = ScrollableDefaults.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier then = OverscrollKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(semantics$default, orientation), overscrollEffect).then(ScrollableKt.scrollable$default(companion, this.$state, orientation, overscrollEffect, this.$isScrollable, scrollableDefaults.reverseDirection((LayoutDirection) consume, orientation, this.$reverseScrolling), this.$flingBehavior, this.$state.getInternalInteractionSource$foundation_release(), (BringIntoViewSpec) null, 128, (Object) null)).then(new ScrollingLayoutElement(this.$state, this.$reverseScrolling, this.$isVertical));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
