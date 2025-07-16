package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u001e\u0010\u0002\u001a\u00020\u0003X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\t8fX¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aø\u0001\u0002\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/material3/DatePickerState;", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "getDisplayMode-jFl-4v0", "()I", "setDisplayMode-vCnGnXg", "(I)V", "displayedMonthMillis", "", "getDisplayedMonthMillis", "()J", "setDisplayedMonthMillis", "(J)V", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "getSelectableDates", "()Landroidx/compose/material3/SelectableDates;", "selectedDateMillis", "getSelectedDateMillis", "()Ljava/lang/Long;", "setSelectedDateMillis", "(Ljava/lang/Long;)V", "yearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
public interface DatePickerState {
    /* renamed from: getDisplayMode-jFl-4v0  reason: not valid java name */
    int m1778getDisplayModejFl4v0();

    long getDisplayedMonthMillis();

    SelectableDates getSelectableDates();

    Long getSelectedDateMillis();

    IntRange getYearRange();

    /* renamed from: setDisplayMode-vCnGnXg  reason: not valid java name */
    void m1779setDisplayModevCnGnXg(int i);

    void setDisplayedMonthMillis(long j);

    void setSelectedDateMillis(Long l);
}
