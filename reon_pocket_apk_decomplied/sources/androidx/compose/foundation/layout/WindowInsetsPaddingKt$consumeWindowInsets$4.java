package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.kt */
final class WindowInsetsPaddingKt$consumeWindowInsets$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ PaddingValues $paddingValues;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowInsetsPaddingKt$consumeWindowInsets$4(PaddingValues paddingValues) {
        super(3);
        this.$paddingValues = paddingValues;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceableGroup(114694318);
        ComposerKt.sourceInformation(composer, "C105@4277L85:WindowInsetsPadding.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(114694318, i, -1, "androidx.compose.foundation.layout.consumeWindowInsets.<anonymous> (WindowInsetsPadding.kt:105)");
        }
        PaddingValues paddingValues = this.$paddingValues;
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) paddingValues);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new PaddingValuesConsumingModifier(paddingValues);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        PaddingValuesConsumingModifier paddingValuesConsumingModifier = (PaddingValuesConsumingModifier) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return paddingValuesConsumingModifier;
    }
}
