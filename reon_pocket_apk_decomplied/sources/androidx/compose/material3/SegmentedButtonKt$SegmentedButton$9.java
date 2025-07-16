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
/* compiled from: SegmentedButton.kt */
final class SegmentedButtonKt$SegmentedButton$9 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ BorderStroke $border;
    final /* synthetic */ SegmentedButtonColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function2<Composer, Integer, Unit> $icon;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ boolean $selected;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ SingleChoiceSegmentedButtonRowScope $this_SegmentedButton;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SegmentedButtonKt$SegmentedButton$9(SingleChoiceSegmentedButtonRowScope singleChoiceSegmentedButtonRowScope, boolean z, Function0<Unit> function0, Shape shape, Modifier modifier, boolean z2, SegmentedButtonColors segmentedButtonColors, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, int i2, int i3) {
        super(2);
        this.$this_SegmentedButton = singleChoiceSegmentedButtonRowScope;
        this.$selected = z;
        this.$onClick = function0;
        this.$shape = shape;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$colors = segmentedButtonColors;
        this.$border = borderStroke;
        this.$interactionSource = mutableInteractionSource;
        this.$icon = function2;
        this.$label = function22;
        this.$$changed = i;
        this.$$changed1 = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SegmentedButtonKt.SegmentedButton(this.$this_SegmentedButton, this.$selected, this.$onClick, this.$shape, this.$modifier, this.$enabled, this.$colors, this.$border, this.$interactionSource, (Function2<? super Composer, ? super Integer, Unit>) this.$icon, (Function2<? super Composer, ? super Integer, Unit>) this.$label, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
