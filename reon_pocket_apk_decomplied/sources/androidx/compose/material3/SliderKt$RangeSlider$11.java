package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.ClosedFloatingPointRange;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Slider.kt */
final class SliderKt$RangeSlider$11 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ int $$default;
    final /* synthetic */ SliderColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $endInteractionSource;
    final /* synthetic */ Function3<RangeSliderState, Composer, Integer, Unit> $endThumb;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<ClosedFloatingPointRange<Float>, Unit> $onValueChange;
    final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    final /* synthetic */ MutableInteractionSource $startInteractionSource;
    final /* synthetic */ Function3<RangeSliderState, Composer, Integer, Unit> $startThumb;
    final /* synthetic */ int $steps;
    final /* synthetic */ Function3<RangeSliderState, Composer, Integer, Unit> $track;
    final /* synthetic */ ClosedFloatingPointRange<Float> $value;
    final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$RangeSlider$11(ClosedFloatingPointRange<Float> closedFloatingPointRange, Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, Function0<Unit> function0, SliderColors sliderColors, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function3, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function32, Function3<? super RangeSliderState, ? super Composer, ? super Integer, Unit> function33, int i, int i2, int i3, int i4) {
        super(2);
        this.$value = closedFloatingPointRange;
        this.$onValueChange = function1;
        this.$modifier = modifier;
        this.$enabled = z;
        this.$valueRange = closedFloatingPointRange2;
        this.$onValueChangeFinished = function0;
        this.$colors = sliderColors;
        this.$startInteractionSource = mutableInteractionSource;
        this.$endInteractionSource = mutableInteractionSource2;
        this.$startThumb = function3;
        this.$endThumb = function32;
        this.$track = function33;
        this.$steps = i;
        this.$$changed = i2;
        this.$$changed1 = i3;
        this.$$default = i4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ClosedFloatingPointRange<Float> closedFloatingPointRange = this.$value;
        Function1<ClosedFloatingPointRange<Float>, Unit> function1 = this.$onValueChange;
        Modifier modifier = this.$modifier;
        boolean z = this.$enabled;
        ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
        Function0<Unit> function0 = this.$onValueChangeFinished;
        SliderColors sliderColors = this.$colors;
        MutableInteractionSource mutableInteractionSource = this.$startInteractionSource;
        MutableInteractionSource mutableInteractionSource2 = this.$endInteractionSource;
        Function3<RangeSliderState, Composer, Integer, Unit> function3 = this.$startThumb;
        Function3<RangeSliderState, Composer, Integer, Unit> function32 = this.$endThumb;
        Function3<RangeSliderState, Composer, Integer, Unit> function33 = this.$track;
        int i2 = this.$steps;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3 = closedFloatingPointRange;
        SliderKt.RangeSlider(closedFloatingPointRange3, function1, modifier, z, closedFloatingPointRange2, function0, sliderColors, mutableInteractionSource, mutableInteractionSource2, function3, function32, function33, i2, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1), this.$$default);
    }
}
