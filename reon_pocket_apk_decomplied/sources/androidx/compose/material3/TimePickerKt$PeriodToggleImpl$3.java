package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$PeriodToggleImpl$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ Shape $endShape;
    final /* synthetic */ MeasurePolicy $measurePolicy;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $startShape;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$PeriodToggleImpl$3(Modifier modifier, TimePickerState timePickerState, TimePickerColors timePickerColors, MeasurePolicy measurePolicy, Shape shape, Shape shape2, int i) {
        super(2);
        this.$modifier = modifier;
        this.$state = timePickerState;
        this.$colors = timePickerColors;
        this.$measurePolicy = measurePolicy;
        this.$startShape = shape;
        this.$endShape = shape2;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TimePickerKt.PeriodToggleImpl(this.$modifier, this.$state, this.$colors, this.$measurePolicy, this.$startShape, this.$endShape, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
