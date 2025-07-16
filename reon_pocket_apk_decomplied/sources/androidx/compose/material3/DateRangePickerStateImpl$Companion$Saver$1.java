package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/material3/DateRangePickerStateImpl;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerStateImpl$Companion$Saver$1 extends Lambda implements Function2<SaverScope, DateRangePickerStateImpl, List<? extends Object>> {
    public static final DateRangePickerStateImpl$Companion$Saver$1 INSTANCE = new DateRangePickerStateImpl$Companion$Saver$1();

    DateRangePickerStateImpl$Companion$Saver$1() {
        super(2);
    }

    public final List<Object> invoke(SaverScope saverScope, DateRangePickerStateImpl dateRangePickerStateImpl) {
        return CollectionsKt.listOf(dateRangePickerStateImpl.getSelectedStartDateMillis(), dateRangePickerStateImpl.getSelectedEndDateMillis(), Long.valueOf(dateRangePickerStateImpl.getDisplayedMonthMillis()), Integer.valueOf(dateRangePickerStateImpl.getYearRange().getFirst()), Integer.valueOf(dateRangePickerStateImpl.getYearRange().getLast()), Integer.valueOf(dateRangePickerStateImpl.m1796getDisplayModejFl4v0()));
    }
}
