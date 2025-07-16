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
final class TimePickerKt$ClockText$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ boolean $autoSwitchToMinute;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ TimePickerState $state;
    final /* synthetic */ int $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$ClockText$4(Modifier modifier, TimePickerState timePickerState, int i, boolean z, int i2) {
        super(2);
        this.$modifier = modifier;
        this.$state = timePickerState;
        this.$value = i;
        this.$autoSwitchToMinute = z;
        this.$$changed = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TimePickerKt.ClockText(this.$modifier, this.$state, this.$value, this.$autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
