package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Checkbox.kt */
final class CheckboxKt$TriStateCheckbox$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ CheckboxColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ ToggleableState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckboxKt$TriStateCheckbox$2(ToggleableState toggleableState, Function0<Unit> function0, Modifier modifier, boolean z, CheckboxColors checkboxColors, MutableInteractionSource mutableInteractionSource, int i, int i2) {
        super(2);
        this.$state = toggleableState;
        this.$onClick = function0;
        this.$modifier = modifier;
        this.$enabled = z;
        this.$colors = checkboxColors;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        CheckboxKt.TriStateCheckbox(this.$state, this.$onClick, this.$modifier, this.$enabled, this.$colors, this.$interactionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
