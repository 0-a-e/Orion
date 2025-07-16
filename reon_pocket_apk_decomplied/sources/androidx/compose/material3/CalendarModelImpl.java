package androidx.compose.material3;

import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J$\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0014\u0010\u001a\u001a\u00020\u001b2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0007H\u0016J\u001a\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010(\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020\u0011H\u0016J\f\u0010+\u001a\u00020!*\u00020\u000bH\u0002J\f\u0010+\u001a\u00020!*\u00020\u001fH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Landroidx/compose/material3/CalendarModelImpl;", "Landroidx/compose/material3/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/util/Locale;)V", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "today", "Landroidx/compose/material3/CalendarDate;", "getToday", "()Landroidx/compose/material3/CalendarDate;", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "formatWithPattern", "utcTimeMillis", "", "pattern", "getCanonicalDate", "timeInMillis", "getDateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "getDayOfWeek", "date", "getMonth", "Landroidx/compose/material3/CalendarMonth;", "firstDayLocalDate", "Ljava/time/LocalDate;", "year", "month", "minusMonths", "from", "subtractedMonthsCount", "parse", "plusMonths", "addedMonthsCount", "toString", "toLocalDate", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CalendarModelImpl.android.kt */
public final class CalendarModelImpl extends CalendarModel {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ZoneId utcTimeZoneId = ComponentDialog$$ExternalSyntheticApiModelOutline0.m("UTC");
    private final int firstDayOfWeek;
    private final List<Pair<String, String>> weekdayNames;

    public CalendarModelImpl(Locale locale) {
        super(locale);
        this.firstDayOfWeek = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(locale).getFirstDayOfWeek().getValue();
        DayOfWeek[] m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m();
        Collection arrayList = new ArrayList(m.length);
        for (DayOfWeek dayOfWeek : m) {
            arrayList.add(TuplesKt.to(dayOfWeek.getDisplayName(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(), locale), dayOfWeek.getDisplayName(ComponentDialog$$ExternalSyntheticApiModelOutline0.m$1(), locale)));
        }
        this.weekdayNames = (List) arrayList;
    }

    public CalendarDate getToday() {
        LocalDate m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m();
        return new CalendarDate(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(m), m.getMonthValue(), m.getDayOfMonth(), m.atTime(ComponentDialog$$ExternalSyntheticApiModelOutline0.m()).atZone(utcTimeZoneId).toInstant().toEpochMilli());
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public List<Pair<String, String>> getWeekdayNames() {
        return this.weekdayNames;
    }

    public DateInputFormat getDateInputFormat(Locale locale) {
        return CalendarModelKt.datePatternAsInputFormat(DateTimeFormatterBuilder.getLocalizedDateTimePattern(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(), (FormatStyle) null, ComponentDialog$$ExternalSyntheticApiModelOutline0.m(locale), locale));
    }

    public CalendarDate getCanonicalDate(long j) {
        LocalDate m = Instant.ofEpochMilli(j).atZone(utcTimeZoneId).toLocalDate();
        return new CalendarDate(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(m), m.getMonthValue(), m.getDayOfMonth(), ComponentDialog$$ExternalSyntheticApiModelOutline0.m(m).toEpochSecond(ComponentDialog$$ExternalSyntheticApiModelOutline0.m()) * ((long) 1000));
    }

    public CalendarMonth getMonth(long j) {
        return getMonth(Instant.ofEpochMilli(j).atZone(utcTimeZoneId).withDayOfMonth(1).toLocalDate());
    }

    public CalendarMonth getMonth(CalendarDate calendarDate) {
        return getMonth(LocalDate.of(calendarDate.getYear(), calendarDate.getMonth(), 1));
    }

    public CalendarMonth getMonth(int i, int i2) {
        return getMonth(LocalDate.of(i, i2, 1));
    }

    public int getDayOfWeek(CalendarDate calendarDate) {
        return ComponentDialog$$ExternalSyntheticApiModelOutline0.m(toLocalDate(calendarDate)).getValue();
    }

    public CalendarMonth plusMonths(CalendarMonth calendarMonth, int i) {
        if (i <= 0) {
            return calendarMonth;
        }
        return getMonth(toLocalDate(calendarMonth).plusMonths((long) i));
    }

    public CalendarMonth minusMonths(CalendarMonth calendarMonth, int i) {
        if (i <= 0) {
            return calendarMonth;
        }
        return getMonth(toLocalDate(calendarMonth).minusMonths((long) i));
    }

    public String formatWithPattern(long j, String str, Locale locale) {
        return Companion.formatWithPattern(j, str, locale, getFormatterCache$material3_release());
    }

    public CalendarDate parse(String str, String str2) {
        try {
            LocalDate m = LocalDate.parse(str, ComponentDialog$$ExternalSyntheticApiModelOutline0.m(str2));
            return new CalendarDate(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(m), ComponentDialog$$ExternalSyntheticApiModelOutline0.m(m).getValue(), m.getDayOfMonth(), m.atTime(ComponentDialog$$ExternalSyntheticApiModelOutline0.m()).atZone(utcTimeZoneId).toInstant().toEpochMilli());
        } catch (DateTimeParseException unused) {
            return null;
        }
    }

    public String toString() {
        return "CalendarModel";
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0010J0\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\b2\n\u0010\f\u001a\u00060\rj\u0002`\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/CalendarModelImpl$Companion;", "", "()V", "utcTimeZoneId", "Ljava/time/ZoneId;", "getUtcTimeZoneId$material3_release", "()Ljava/time/ZoneId;", "formatWithPattern", "", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "cache", "", "getCachedDateTimeFormatter", "Ljava/time/format/DateTimeFormatter;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CalendarModelImpl.android.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String formatWithPattern(long j, String str, Locale locale, Map<String, Object> map) {
            return Instant.ofEpochMilli(j).atZone(getUtcTimeZoneId$material3_release()).toLocalDate().format(getCachedDateTimeFormatter(str, locale, map));
        }

        public final ZoneId getUtcTimeZoneId$material3_release() {
            return CalendarModelImpl.utcTimeZoneId;
        }

        private final DateTimeFormatter getCachedDateTimeFormatter(String str, Locale locale, Map<String, Object> map) {
            String str2 = "P:" + str + locale.toLanguageTag();
            Object obj = map.get(str2);
            if (obj == null) {
                obj = DateTimeFormatter.ofPattern(str, locale).withDecimalStyle(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(locale));
                map.put(str2, obj);
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.time.format.DateTimeFormatter");
            return ComponentDialog$$ExternalSyntheticApiModelOutline0.m(obj);
        }
    }

    private final CalendarMonth getMonth(LocalDate localDate) {
        int m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(localDate).getValue() - getFirstDayOfWeek();
        if (m < 0) {
            m += 7;
        }
        return new CalendarMonth(ComponentDialog$$ExternalSyntheticApiModelOutline0.m(localDate), localDate.getMonthValue(), localDate.lengthOfMonth(), m, localDate.atTime(ComponentDialog$$ExternalSyntheticApiModelOutline0.m()).atZone(utcTimeZoneId).toInstant().toEpochMilli());
    }

    private final LocalDate toLocalDate(CalendarMonth calendarMonth) {
        return Instant.ofEpochMilli(calendarMonth.getStartUtcTimeMillis()).atZone(utcTimeZoneId).toLocalDate();
    }

    private final LocalDate toLocalDate(CalendarDate calendarDate) {
        return LocalDate.of(calendarDate.getYear(), calendarDate.getMonth(), calendarDate.getDayOfMonth());
    }
}
