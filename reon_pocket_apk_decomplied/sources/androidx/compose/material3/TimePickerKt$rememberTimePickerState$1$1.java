package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material3/TimePickerState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$rememberTimePickerState$1$1 extends Lambda implements Function0<TimePickerState> {
    final /* synthetic */ int $initialHour;
    final /* synthetic */ int $initialMinute;
    final /* synthetic */ boolean $is24Hour;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$rememberTimePickerState$1$1(int i, int i2, boolean z) {
        super(0);
        this.$initialHour = i;
        this.$initialMinute = i2;
        this.$is24Hour = z;
    }

    public final TimePickerState invoke() {
        return new TimePickerState(this.$initialHour, this.$initialMinute, this.$is24Hour);
    }
}
