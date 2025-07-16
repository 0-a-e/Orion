package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0002J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001aJ\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006 "}, d2 = {"Landroidx/compose/material3/CalendarDate;", "", "year", "", "month", "dayOfMonth", "utcTimeMillis", "", "(IIIJ)V", "getDayOfMonth", "()I", "getMonth", "getUtcTimeMillis", "()J", "getYear", "compareTo", "other", "component1", "component2", "component3", "component4", "copy", "equals", "", "", "format", "", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "skeleton", "hashCode", "toString", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CalendarModel.kt */
public final class CalendarDate implements Comparable<CalendarDate> {
    public static final int $stable = 0;
    private final int dayOfMonth;
    private final int month;
    private final long utcTimeMillis;
    private final int year;

    public static /* synthetic */ CalendarDate copy$default(CalendarDate calendarDate, int i, int i2, int i3, long j, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = calendarDate.year;
        }
        if ((i4 & 2) != 0) {
            i2 = calendarDate.month;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = calendarDate.dayOfMonth;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            j = calendarDate.utcTimeMillis;
        }
        return calendarDate.copy(i, i5, i6, j);
    }

    public final int component1() {
        return this.year;
    }

    public final int component2() {
        return this.month;
    }

    public final int component3() {
        return this.dayOfMonth;
    }

    public final long component4() {
        return this.utcTimeMillis;
    }

    public final CalendarDate copy(int i, int i2, int i3, long j) {
        return new CalendarDate(i, i2, i3, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarDate)) {
            return false;
        }
        CalendarDate calendarDate = (CalendarDate) obj;
        return this.year == calendarDate.year && this.month == calendarDate.month && this.dayOfMonth == calendarDate.dayOfMonth && this.utcTimeMillis == calendarDate.utcTimeMillis;
    }

    public int hashCode() {
        return (((((this.year * 31) + this.month) * 31) + this.dayOfMonth) * 31) + UByte$$ExternalSyntheticBackport0.m(this.utcTimeMillis);
    }

    public String toString() {
        return "CalendarDate(year=" + this.year + ", month=" + this.month + ", dayOfMonth=" + this.dayOfMonth + ", utcTimeMillis=" + this.utcTimeMillis + ')';
    }

    public CalendarDate(int i, int i2, int i3, long j) {
        this.year = i;
        this.month = i2;
        this.dayOfMonth = i3;
        this.utcTimeMillis = j;
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public final long getUtcTimeMillis() {
        return this.utcTimeMillis;
    }

    public int compareTo(CalendarDate calendarDate) {
        return Intrinsics.compare(this.utcTimeMillis, calendarDate.utcTimeMillis);
    }

    public final String format(CalendarModel calendarModel, String str) {
        return calendarModel.formatWithSkeleton(this, str, calendarModel.getLocale());
    }
}
