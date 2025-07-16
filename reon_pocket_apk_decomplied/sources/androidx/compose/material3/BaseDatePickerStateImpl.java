package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b!\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n¢\u0006\u0002\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/BaseDatePickerStateImpl;", "", "initialDisplayedMonthMillis", "", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Lkotlin/ranges/IntRange;Landroidx/compose/material3/SelectableDates;Ljava/util/Locale;)V", "_displayedMonth", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/material3/CalendarMonth;", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "getCalendarModel", "()Landroidx/compose/material3/CalendarModel;", "monthMillis", "displayedMonthMillis", "getDisplayedMonthMillis", "()J", "setDisplayedMonthMillis", "(J)V", "getSelectableDates", "()Landroidx/compose/material3/SelectableDates;", "getYearRange", "()Lkotlin/ranges/IntRange;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public abstract class BaseDatePickerStateImpl {
    public static final int $stable = 0;
    private MutableState<CalendarMonth> _displayedMonth;
    private final CalendarModel calendarModel;
    private final SelectableDates selectableDates;
    private final IntRange yearRange;

    public BaseDatePickerStateImpl(Long l, IntRange intRange, SelectableDates selectableDates2, Locale locale) {
        CalendarMonth calendarMonth;
        this.yearRange = intRange;
        this.selectableDates = selectableDates2;
        CalendarModel createCalendarModel = CalendarModel_androidKt.createCalendarModel(locale);
        this.calendarModel = createCalendarModel;
        if (l != null) {
            calendarMonth = createCalendarModel.getMonth(l.longValue());
            if (!intRange.contains(calendarMonth.getYear())) {
                throw new IllegalArgumentException(("The initial display month's year (" + calendarMonth.getYear() + ") is out of the years range of " + intRange + '.').toString());
            }
        } else {
            calendarMonth = createCalendarModel.getMonth(createCalendarModel.getToday());
        }
        this._displayedMonth = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(calendarMonth, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final IntRange getYearRange() {
        return this.yearRange;
    }

    public final SelectableDates getSelectableDates() {
        return this.selectableDates;
    }

    public final CalendarModel getCalendarModel() {
        return this.calendarModel;
    }

    public final long getDisplayedMonthMillis() {
        return this._displayedMonth.getValue().getStartUtcTimeMillis();
    }

    public final void setDisplayedMonthMillis(long j) {
        CalendarMonth month = this.calendarModel.getMonth(j);
        if (this.yearRange.contains(month.getYear())) {
            this._displayedMonth.setValue(month);
            return;
        }
        throw new IllegalArgumentException(("The display month's year (" + month.getYear() + ") is out of the years range of " + this.yearRange + '.').toString());
    }
}
