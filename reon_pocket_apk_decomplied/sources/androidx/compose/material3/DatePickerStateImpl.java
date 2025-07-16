package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0003\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB=\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\u0010\f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8V@VX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00048V@VX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/material3/DatePickerStateImpl;", "Landroidx/compose/material3/BaseDatePickerStateImpl;", "Landroidx/compose/material3/DatePickerState;", "initialSelectedDateMillis", "", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Ljava/util/Locale;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "_displayMode", "Landroidx/compose/runtime/MutableState;", "_selectedDate", "Landroidx/compose/material3/CalendarDate;", "displayMode", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "dateMillis", "selectedDateMillis", "getSelectedDateMillis", "()Ljava/lang/Long;", "setSelectedDateMillis", "(Ljava/lang/Long;)V", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerStateImpl extends BaseDatePickerStateImpl implements DatePickerState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private MutableState<DisplayMode> _displayMode;
    private MutableState<CalendarDate> _selectedDate;

    public /* synthetic */ DatePickerStateImpl(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, l2, intRange, i, selectableDates, locale);
    }

    private DatePickerStateImpl(Long l, Long l2, IntRange intRange, int i, SelectableDates selectableDates, Locale locale) {
        super(l2, intRange, selectableDates, locale);
        CalendarDate calendarDate;
        if (l != null) {
            calendarDate = getCalendarModel().getCanonicalDate(l.longValue());
            if (!intRange.contains(calendarDate.getYear())) {
                throw new IllegalArgumentException(("The provided initial date's year (" + calendarDate.getYear() + ") is out of the years range of " + intRange + '.').toString());
            }
        } else {
            calendarDate = null;
        }
        this._selectedDate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(calendarDate, (SnapshotMutationPolicy) null, 2, (Object) null);
        this._displayMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DisplayMode.m1806boximpl(i), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public Long getSelectedDateMillis() {
        CalendarDate value = this._selectedDate.getValue();
        if (value != null) {
            return Long.valueOf(value.getUtcTimeMillis());
        }
        return null;
    }

    public void setSelectedDateMillis(Long l) {
        if (l != null) {
            CalendarDate canonicalDate = getCalendarModel().getCanonicalDate(l.longValue());
            if (getYearRange().contains(canonicalDate.getYear())) {
                this._selectedDate.setValue(canonicalDate);
                return;
            }
            throw new IllegalArgumentException(("The provided date's year (" + canonicalDate.getYear() + ") is out of the years range of " + getYearRange() + '.').toString());
        }
        this._selectedDate.setValue(null);
    }

    /* renamed from: getDisplayMode-jFl-4v0  reason: not valid java name */
    public int m1780getDisplayModejFl4v0() {
        return this._displayMode.getValue().m1812unboximpl();
    }

    /* renamed from: setDisplayMode-vCnGnXg  reason: not valid java name */
    public void m1781setDisplayModevCnGnXg(int i) {
        Long selectedDateMillis = getSelectedDateMillis();
        if (selectedDateMillis != null) {
            setDisplayedMonthMillis(getCalendarModel().getMonth(selectedDateMillis.longValue()).getStartUtcTimeMillis());
        }
        this._displayMode.setValue(DisplayMode.m1806boximpl(i));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/material3/DatePickerStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/DatePickerStateImpl;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DatePicker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<DatePickerStateImpl, Object> Saver(SelectableDates selectableDates, Locale locale) {
            return ListSaverKt.listSaver(DatePickerStateImpl$Companion$Saver$1.INSTANCE, new DatePickerStateImpl$Companion$Saver$2(selectableDates, locale));
        }
    }
}
