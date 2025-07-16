package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "startDateMillis", "", "endDateMillis", "invoke", "(Ljava/lang/Long;Ljava/lang/Long;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$DateRangePicker$5$1$1 extends Lambda implements Function2<Long, Long, Unit> {
    final /* synthetic */ DateRangePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$DateRangePicker$5$1$1(DateRangePickerState dateRangePickerState) {
        super(2);
        this.$state = dateRangePickerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Long) obj, (Long) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Long l, Long l2) {
        try {
            this.$state.setSelection(l, l2);
        } catch (IllegalArgumentException unused) {
        }
    }
}
