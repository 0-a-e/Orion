package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a?\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"lazyLayoutSemantics", "Landroidx/compose/ui/Modifier;", "itemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "state", "Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "userScrollEnabled", "", "reverseScrolling", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/lazy/layout/LazyLayoutSemanticState;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutSemantics.kt */
public final class LazyLayoutSemanticsKt {
    public static final Modifier lazyLayoutSemantics(Modifier modifier, Function0<? extends LazyLayoutItemProvider> function0, LazyLayoutSemanticState lazyLayoutSemanticState, Orientation orientation, boolean z, boolean z2, Composer composer, int i) {
        Function0<? extends LazyLayoutItemProvider> function02 = function0;
        LazyLayoutSemanticState lazyLayoutSemanticState2 = lazyLayoutSemanticState;
        Orientation orientation2 = orientation;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(1070136913);
        ComposerKt.sourceInformation(composer2, "C(lazyLayoutSemantics)P(!1,3!1,4)47@1936L24,49@1991L2820:LazyLayoutSemantics.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1070136913, i, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:46)");
        }
        composer2.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Object[] objArr = {function02, lazyLayoutSemanticState2, orientation2, Boolean.valueOf(z)};
        composer2.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean z3 = false;
        for (int i2 = 0; i2 < 4; i2++) {
            z3 |= composer2.changed(objArr[i2]);
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z3 || rememberedValue2 == Composer.Companion.getEmpty()) {
            boolean z4 = orientation2 == Orientation.Vertical;
            rememberedValue2 = SemanticsModifierKt.semantics$default(Modifier.Companion, false, new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1(new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1(function02), z4, new ScrollAxisRange(new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$1(lazyLayoutSemanticState2), new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2(lazyLayoutSemanticState2), z2), z ? new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1(z4, coroutineScope, lazyLayoutSemanticState2) : null, z ? new LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1(function02, coroutineScope, lazyLayoutSemanticState2) : null, lazyLayoutSemanticState.collectionInfo()), 1, (Object) null);
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) rememberedValue2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }
}
