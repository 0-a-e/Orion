package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: RadioButton.kt */
final class RadioButtonKt$RadioButton$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ RadioButtonColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RadioButtonKt$RadioButton$3(boolean z, Function0<Unit> function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
        super(2);
        this.$selected = z;
        this.$onClick = function0;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$colors = radioButtonColors;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        RadioButtonKt.RadioButton(this.$selected, this.$onClick, this.$modifier, this.$enabled, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
