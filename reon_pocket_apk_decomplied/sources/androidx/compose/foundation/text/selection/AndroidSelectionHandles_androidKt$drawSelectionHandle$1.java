package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSelectionHandles.android.kt */
final class AndroidSelectionHandles_androidKt$drawSelectionHandle$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ Function0<Boolean> $iconVisible;
    final /* synthetic */ boolean $isLeft;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSelectionHandles_androidKt$drawSelectionHandle$1(Function0<Boolean> function0, boolean z) {
        super(3);
        this.$iconVisible = function0;
        this.$isLeft = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceableGroup(-196777734);
        ComposerKt.sourceInformation(composer, "C110@4533L7:AndroidSelectionHandles.android.kt#eksfi3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-196777734, i, -1, "androidx.compose.foundation.text.selection.drawSelectionHandle.<anonymous> (AndroidSelectionHandles.android.kt:110)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long r0 = ((TextSelectionColors) consume).m1324getHandleColor0d7_KjU();
        composer.startReplaceableGroup(442417347);
        boolean changed = composer.changed(r0) | composer.changedInstance(this.$iconVisible) | composer.changed(this.$isLeft);
        Function0<Boolean> function0 = this.$iconVisible;
        boolean z = this.$isLeft;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = new AndroidSelectionHandles_androidKt$drawSelectionHandle$1$1$1(r0, function0, z);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier drawWithCache = DrawModifierKt.drawWithCache(modifier, (Function1) rememberedValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawWithCache;
    }
}
