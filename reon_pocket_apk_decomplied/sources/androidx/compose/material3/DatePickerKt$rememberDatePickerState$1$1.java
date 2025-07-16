package androidx.compose.material3;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material3/DatePickerStateImpl;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$rememberDatePickerState$1$1 extends Lambda implements Function0<DatePickerStateImpl> {
    final /* synthetic */ int $initialDisplayMode;
    final /* synthetic */ Long $initialDisplayedMonthMillis;
    final /* synthetic */ Long $initialSelectedDateMillis;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ SelectableDates $selectableDates;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$rememberDatePickerState$1$1(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Locale locale) {
        super(0);
        this.$initialSelectedDateMillis = l;
        this.$initialDisplayedMonthMillis = l2;
        this.$yearRange = intRange;
        this.$initialDisplayMode = i;
        this.$selectableDates = selectableDates;
        this.$locale = locale;
    }

    public final DatePickerStateImpl invoke() {
        return new DatePickerStateImpl(this.$initialSelectedDateMillis, this.$initialDisplayedMonthMillis, this.$yearRange, this.$initialDisplayMode, this.$selectableDates, this.$locale, (DefaultConstructorMarker) null);
    }
}
