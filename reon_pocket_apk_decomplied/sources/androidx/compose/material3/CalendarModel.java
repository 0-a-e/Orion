package androidx.compose.material3;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J$\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\f2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&J$\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\f2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004J$\u0010\u001e\u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\f2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001cH&J\u0016\u0010%\u001a\u00020&2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H&J\u0010\u0010(\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0012H&J\u0018\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H&J\u0010\u0010(\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001cH&J\u0018\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0006\u0010,\u001a\u00020\u0007H&J\u001a\u0010-\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fH&J\u0018\u0010.\u001a\u00020\"2\u0006\u0010+\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u0007H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00170\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/material3/CalendarModel;", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "(Ljava/util/Locale;)V", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "formatterCache", "", "", "getFormatterCache$material3_release", "()Ljava/util/Map;", "getLocale", "()Ljava/util/Locale;", "today", "Landroidx/compose/material3/CalendarDate;", "getToday", "()Landroidx/compose/material3/CalendarDate;", "weekdayNames", "", "Lkotlin/Pair;", "getWeekdayNames", "()Ljava/util/List;", "formatWithPattern", "utcTimeMillis", "", "pattern", "formatWithSkeleton", "date", "skeleton", "month", "Landroidx/compose/material3/CalendarMonth;", "getCanonicalDate", "timeInMillis", "getDateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "getDayOfWeek", "getMonth", "year", "minusMonths", "from", "subtractedMonthsCount", "parse", "plusMonths", "addedMonthsCount", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CalendarModel.kt */
public abstract class CalendarModel {
    public static final int $stable = 8;
    private final Map<String, Object> formatterCache = new LinkedHashMap();
    private final Locale locale;

    public abstract String formatWithPattern(long j, String str, Locale locale2);

    public abstract CalendarDate getCanonicalDate(long j);

    public abstract DateInputFormat getDateInputFormat(Locale locale2);

    public abstract int getDayOfWeek(CalendarDate calendarDate);

    public abstract int getFirstDayOfWeek();

    public abstract CalendarMonth getMonth(int i, int i2);

    public abstract CalendarMonth getMonth(long j);

    public abstract CalendarMonth getMonth(CalendarDate calendarDate);

    public abstract CalendarDate getToday();

    public abstract List<Pair<String, String>> getWeekdayNames();

    public abstract CalendarMonth minusMonths(CalendarMonth calendarMonth, int i);

    public abstract CalendarDate parse(String str, String str2);

    public abstract CalendarMonth plusMonths(CalendarMonth calendarMonth, int i);

    public CalendarModel(Locale locale2) {
        this.locale = locale2;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public final Map<String, Object> getFormatterCache$material3_release() {
        return this.formatterCache;
    }

    public static /* synthetic */ DateInputFormat getDateInputFormat$default(CalendarModel calendarModel, Locale locale2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                locale2 = calendarModel.locale;
            }
            return calendarModel.getDateInputFormat(locale2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDateInputFormat");
    }

    public static /* synthetic */ String formatWithSkeleton$default(CalendarModel calendarModel, CalendarMonth calendarMonth, String str, Locale locale2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                locale2 = calendarModel.locale;
            }
            return calendarModel.formatWithSkeleton(calendarMonth, str, locale2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
    }

    public final String formatWithSkeleton(CalendarMonth calendarMonth, String str, Locale locale2) {
        return CalendarModel_androidKt.formatWithSkeleton(calendarMonth.getStartUtcTimeMillis(), str, locale2, this.formatterCache);
    }

    public static /* synthetic */ String formatWithSkeleton$default(CalendarModel calendarModel, CalendarDate calendarDate, String str, Locale locale2, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                locale2 = calendarModel.locale;
            }
            return calendarModel.formatWithSkeleton(calendarDate, str, locale2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
    }

    public final String formatWithSkeleton(CalendarDate calendarDate, String str, Locale locale2) {
        return CalendarModel_androidKt.formatWithSkeleton(calendarDate.getUtcTimeMillis(), str, locale2, this.formatterCache);
    }
}
