package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Tooltip.kt */
final class TooltipKt$RichTooltip$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function2<Composer, Integer, Unit> $action;
    final /* synthetic */ RichTooltipColors $colors;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $shadowElevation;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ Function2<Composer, Integer, Unit> $text;
    final /* synthetic */ Function2<Composer, Integer, Unit> $title;
    final /* synthetic */ float $tonalElevation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TooltipKt$RichTooltip$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Shape shape, RichTooltipColors richTooltipColors, float f, float f2, Function2<? super Composer, ? super Integer, Unit> function23, int i, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$title = function2;
        this.$action = function22;
        this.$shape = shape;
        this.$colors = richTooltipColors;
        this.$tonalElevation = f;
        this.$shadowElevation = f2;
        this.$text = function23;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TooltipKt.m2604RichTooltip1tP8Re8(this.$modifier, this.$title, this.$action, this.$shape, this.$colors, this.$tonalElevation, this.$shadowElevation, this.$text, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
