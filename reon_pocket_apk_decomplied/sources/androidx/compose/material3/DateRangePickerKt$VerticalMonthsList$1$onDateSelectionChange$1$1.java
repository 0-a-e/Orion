package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dateInMillis", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$VerticalMonthsList$1$onDateSelectionChange$1$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function2<Long, Long, Unit> $onDatesSelectionChange;
    final /* synthetic */ Long $selectedEndDateMillis;
    final /* synthetic */ Long $selectedStartDateMillis;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$VerticalMonthsList$1$onDateSelectionChange$1$1(Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2) {
        super(1);
        this.$selectedStartDateMillis = l;
        this.$selectedEndDateMillis = l2;
        this.$onDatesSelectionChange = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j) {
        DateRangePickerKt.updateDateSelection(j, this.$selectedStartDateMillis, this.$selectedEndDateMillis, this.$onDatesSelectionChange);
    }
}
