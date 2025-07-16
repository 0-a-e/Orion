package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: IconButton.kt */
final class IconButtonKt$FilledIconToggleButton$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ boolean $checked;
    final /* synthetic */ IconToggleButtonColors $colors;
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Boolean, Unit> $onCheckedChange;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IconButtonKt$FilledIconToggleButton$4(boolean z, Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, IconToggleButtonColors iconToggleButtonColors, MutableInteractionSource mutableInteractionSource, Function2<? super Composer, ? super Integer, Unit> function2, int i, int i2) {
        super(2);
        this.$checked = z;
        this.$onCheckedChange = function1;
        this.$modifier = modifier;
        this.$enabled = z2;
        this.$shape = shape;
        this.$colors = iconToggleButtonColors;
        this.$interactionSource = mutableInteractionSource;
        this.$content = function2;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        IconButtonKt.FilledIconToggleButton(this.$checked, this.$onCheckedChange, this.$modifier, this.$enabled, this.$shape, this.$colors, this.$interactionSource, this.$content, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
