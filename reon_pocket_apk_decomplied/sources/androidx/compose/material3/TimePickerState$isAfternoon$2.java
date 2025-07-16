package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerState$isAfternoon$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ TimePickerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerState$isAfternoon$2(TimePickerState timePickerState) {
        super(0);
        this.this$0 = timePickerState;
    }

    public final Boolean invoke() {
        return Boolean.valueOf((this.this$0.is24hour() && this.this$0.isInnerCircle$material3_release()) || this.this$0.isAfternoonToggle$material3_release());
    }
}
