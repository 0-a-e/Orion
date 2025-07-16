package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<ClosedFloatingPointRange<Float>, Unit> $onValueChange;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ int $steps;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$4(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, Function0<Unit> function0, SliderColors sliderColors, int i2, int i3) {
        super(2);
        this.$value = closedFloatingPointRange;
        this.$onValueChange = function1;
        this.$modifier = modifier;
        this.$enabled = z;
        this.$valueRange = closedFloatingPointRange2;
        this.$steps = i;
        this.$onValueChangeFinished = function0;
        this.$colors = sliderColors;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        SliderKt.RangeSlider(this.$value, this.$onValueChange, this.$modifier, this.$enabled, this.$valueRange, this.$steps, this.$onValueChangeFinished, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
