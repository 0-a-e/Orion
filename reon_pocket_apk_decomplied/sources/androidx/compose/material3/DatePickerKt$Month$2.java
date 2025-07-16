package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$Month$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Long $endDateMillis;
    final /* synthetic */ CalendarMonth $month;
    final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
    final /* synthetic */ SelectedRangeInfo $rangeSelectionInfo;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ Long $startDateMillis;
    final /* synthetic */ long $todayMillis;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$Month$2(CalendarMonth calendarMonth, Function1<? super Long, Unit> function1, long j, Long l, Long l2, SelectedRangeInfo selectedRangeInfo, DatePickerFormatter datePickerFormatter, SelectableDates selectableDates, DatePickerColors datePickerColors, int i) {
        super(2);
        this.$month = calendarMonth;
        this.$onDateSelectionChange = function1;
        this.$todayMillis = j;
        this.$startDateMillis = l;
        this.$endDateMillis = l2;
        this.$rangeSelectionInfo = selectedRangeInfo;
        this.$dateFormatter = datePickerFormatter;
        this.$selectableDates = selectableDates;
        this.$colors = datePickerColors;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.Month(this.$month, this.$onDateSelectionChange, this.$todayMillis, this.$startDateMillis, this.$endDateMillis, this.$rangeSelectionInfo, this.$dateFormatter, this.$selectableDates, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
