package androidx.compose.material3;

import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/SelectedRangeInfo;", "", "gridStartCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "gridEndCoordinates", "firstIsSelectionStart", "", "lastIsSelectionEnd", "(JJZZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getFirstIsSelectionStart", "()Z", "getGridEndCoordinates-nOcc-ac", "()J", "J", "getGridStartCoordinates-nOcc-ac", "getLastIsSelectionEnd", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
public final class SelectedRangeInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean firstIsSelectionStart;
    private final long gridEndCoordinates;
    private final long gridStartCoordinates;
    private final boolean lastIsSelectionEnd;

    public /* synthetic */ SelectedRangeInfo(long j, long j2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, z, z2);
    }

    private SelectedRangeInfo(long j, long j2, boolean z, boolean z2) {
        this.gridStartCoordinates = j;
        this.gridEndCoordinates = j2;
        this.firstIsSelectionStart = z;
        this.lastIsSelectionEnd = z2;
    }

    /* renamed from: getGridStartCoordinates-nOcc-ac  reason: not valid java name */
    public final long m2160getGridStartCoordinatesnOccac() {
        return this.gridStartCoordinates;
    }

    /* renamed from: getGridEndCoordinates-nOcc-ac  reason: not valid java name */
    public final long m2159getGridEndCoordinatesnOccac() {
        return this.gridEndCoordinates;
    }

    public final boolean getFirstIsSelectionStart() {
        return this.firstIsSelectionStart;
    }

    public final boolean getLastIsSelectionEnd() {
        return this.lastIsSelectionEnd;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Landroidx/compose/material3/SelectedRangeInfo$Companion;", "", "()V", "calculateRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "month", "Landroidx/compose/material3/CalendarMonth;", "startDate", "Landroidx/compose/material3/CalendarDate;", "endDate", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DateRangePicker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SelectedRangeInfo calculateRangeInfo(CalendarMonth calendarMonth, CalendarDate calendarDate, CalendarDate calendarDate2) {
            int i;
            int i2;
            if (calendarDate.getUtcTimeMillis() > calendarMonth.getEndUtcTimeMillis() || calendarDate2.getUtcTimeMillis() < calendarMonth.getStartUtcTimeMillis()) {
                return null;
            }
            boolean z = calendarDate.getUtcTimeMillis() >= calendarMonth.getStartUtcTimeMillis();
            boolean z2 = calendarDate2.getUtcTimeMillis() <= calendarMonth.getEndUtcTimeMillis();
            if (z) {
                i = (calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarDate.getDayOfMonth()) - 1;
            } else {
                i = calendarMonth.getDaysFromStartOfWeekToFirstOfMonth();
            }
            if (z2) {
                i2 = (calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarDate2.getDayOfMonth()) - 1;
            } else {
                i2 = (calendarMonth.getDaysFromStartOfWeekToFirstOfMonth() + calendarMonth.getNumberOfDays()) - 1;
            }
            return new SelectedRangeInfo(IntOffsetKt.IntOffset(i % 7, i / 7), IntOffsetKt.IntOffset(i2 % 7, i2 / 7), z, z2, (DefaultConstructorMarker) null);
        }
    }
}
