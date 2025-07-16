package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Toggleable.kt */
final class ToggleableKt$toggleable$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function1<Boolean, Unit> $onValueChange;
    final /* synthetic */ Role $role;
    final /* synthetic */ boolean $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleable$2(boolean z, boolean z2, Role role, Function1<? super Boolean, Unit> function1) {
        super(3);
        this.$value = z;
        this.$enabled = z2;
        this.$role = role;
        this.$onValueChange = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    public final Modifier invoke(Modifier modifier, Composer composer, int i) {
        composer.startReplaceableGroup(290332169);
        ComposerKt.sourceInformation(composer, "C68@2718L39,69@2796L7:Toggleable.kt#gro6r2");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(290332169, i, -1, "androidx.compose.foundation.selection.toggleable.<anonymous> (Toggleable.kt:66)");
        }
        Modifier modifier2 = Modifier.Companion;
        boolean z = this.$value;
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(IndicationKt.getLocalIndication());
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifier3 = ToggleableKt.m1004toggleableO2vRcR0(modifier2, z, (MutableInteractionSource) rememberedValue, (Indication) consume, this.$enabled, this.$role, this.$onValueChange);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return modifier3;
    }
}
