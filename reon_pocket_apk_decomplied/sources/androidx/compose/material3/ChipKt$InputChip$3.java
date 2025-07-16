package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Chip.kt */
final class ChipKt$InputChip$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $avatar;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ SelectableChipColors $colors;
    final /* synthetic */ SelectableChipElevation $elevation;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipKt$InputChip$3(boolean z, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Shape shape, SelectableChipColors selectableChipColors, SelectableChipElevation selectableChipElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3) {
        super(2);
        this.$selected = z;
        this.$onClick = function0;
        this.$label = function2;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$leadingIcon = function22;
        this.$avatar = function23;
        this.$trailingIcon = function24;
        this.$shape = shape;
        this.$colors = selectableChipColors;
        this.$elevation = selectableChipElevation;
        this.$border = borderStroke;
        this.$interactionSource = mutableInteractionSource;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        boolean z = this.$selected;
        Function0<Unit> function0 = this.$onClick;
        Function2<Composer, Integer, Unit> function2 = this.$label;
        Modifier modifier = this.$modifier;
        boolean z2 = this.$enabled;
        Function2<Composer, Integer, Unit> function22 = this.$leadingIcon;
        Function2<Composer, Integer, Unit> function23 = this.$avatar;
        Function2<Composer, Integer, Unit> function24 = this.$trailingIcon;
        Shape shape = this.$shape;
        SelectableChipColors selectableChipColors = this.$colors;
        SelectableChipElevation selectableChipElevation = this.$elevation;
        BorderStroke borderStroke = this.$border;
        MutableInteractionSource mutableInteractionSource = this.$interactionSource;
        boolean z3 = z;
        ChipKt.InputChip(z3, function0, function2, modifier, z2, function22, function23, function24, shape, selectableChipColors, selectableChipElevation, borderStroke, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
