package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.PinnableContainer;
import androidx.compose.ui.layout.PinnableContainerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"LazyLayoutPinnableItem", "", "key", "", "index", "", "pinnedItemList", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;ILandroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyLayoutPinnableItem.kt */
public final class LazyLayoutPinnableItemKt {
    public static final void LazyLayoutPinnableItem(Object obj, int i, LazyLayoutPinnedItemList lazyLayoutPinnedItemList, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i2) {
        Composer startRestartGroup = composer.startRestartGroup(-2079116560);
        ComposerKt.sourceInformation(startRestartGroup, "C(LazyLayoutPinnableItem)P(2,1,3)53@2119L77,55@2294L7,56@2306L74,57@2385L103:LazyLayoutPinnableItem.kt#wow0x6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079116560, i2, -1, "androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:52)");
        }
        startRestartGroup.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean changed = startRestartGroup.changed(obj) | startRestartGroup.changed((Object) lazyLayoutPinnedItemList);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyLayoutPinnableItem(obj, lazyLayoutPinnedItemList);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) rememberedValue;
        lazyLayoutPinnableItem.setIndex(i);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = startRestartGroup.consume(PinnableContainerKt.getLocalPinnableContainer());
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        lazyLayoutPinnableItem.setParentPinnableContainer((PinnableContainer) consume);
        startRestartGroup.startReplaceableGroup(-913235405);
        boolean changed2 = startRestartGroup.changed((Object) lazyLayoutPinnableItem);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$1$1(lazyLayoutPinnableItem);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        EffectsKt.DisposableEffect((Object) lazyLayoutPinnableItem, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) (Function1) rememberedValue2, startRestartGroup, 0);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) PinnableContainerKt.getLocalPinnableContainer().provides(lazyLayoutPinnableItem), function2, startRestartGroup, ProvidedValue.$stable | ((i2 >> 6) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new LazyLayoutPinnableItemKt$LazyLayoutPinnableItem$2(obj, i, lazyLayoutPinnedItemList, function2, i2));
        }
    }
}
