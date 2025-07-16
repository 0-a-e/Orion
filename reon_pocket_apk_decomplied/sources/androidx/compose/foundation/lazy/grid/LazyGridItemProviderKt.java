package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty0;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"rememberLazyGridItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: LazyGridItemProvider.kt */
public final class LazyGridItemProviderKt {
    public static final Function0<LazyGridItemProvider> rememberLazyGridItemProviderLambda(LazyGridState lazyGridState, Function1<? super LazyGridScope, Unit> function1, Composer composer, int i) {
        composer.startReplaceableGroup(-1898306282);
        ComposerKt.sourceInformation(composer, "C(rememberLazyGridItemProviderLambda)P(1)41@1652L29,42@1693L604:LazyGridItemProvider.kt#7791vq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1898306282, i, -1, "androidx.compose.foundation.lazy.grid.rememberLazyGridItemProviderLambda (LazyGridItemProvider.kt:40)");
        }
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, (i >> 3) & 14);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) lazyGridState);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$itemProviderState$1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new LazyGridItemProviderKt$rememberLazyGridItemProviderLambda$1$intervalContentState$1(rememberUpdatedState)), lazyGridState)));
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
}
