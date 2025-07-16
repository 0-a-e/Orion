package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimePicker$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ int $layoutType;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimePicker$1(TimePickerState timePickerState, Modifier modifier, TimePickerColors timePickerColors, int i, int i2, int i3) {
        super(2);
        this.$state = timePickerState;
        this.$modifier = modifier;
        this.$colors = timePickerColors;
        this.$layoutType = i;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TimePickerKt.m2483TimePickermT9BvqQ(this.$state, this.$modifier, this.$colors, this.$layoutType, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
