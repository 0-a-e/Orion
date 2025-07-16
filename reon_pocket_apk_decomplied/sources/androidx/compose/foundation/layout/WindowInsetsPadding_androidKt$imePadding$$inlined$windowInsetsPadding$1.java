package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "androidx/compose/foundation/layout/WindowInsetsPadding_androidKt$windowInsetsPadding$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: WindowInsetsPadding.android.kt */
public final class WindowInsetsPadding_androidKt$imePadding$$inlined$windowInsetsPadding$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    public WindowInsetsPadding_androidKt$imePadding$$inlined$windowInsetsPadding$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceableGroup(359872873);
        ComposerKt.sourceInformation(composer, "C249@11341L9,250@11355L124:WindowInsetsPadding.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(359872873, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.android.kt:249)");
        }
        WindowInsetsHolder current = WindowInsetsHolder.Companion.current(composer, 8);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean changed = composer.changed((Object) current);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new InsetsPaddingModifier(current.getIme());
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return insetsPaddingModifier;
    }
}
