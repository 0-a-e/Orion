package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerDefaults$DateRangePickerHeadline$6 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ Function2<Composer, Integer, Unit> $datesDelimiter;
    final /* synthetic */ int $displayMode;
    final /* synthetic */ Function2<Composer, Integer, Unit> $endDatePlaceholder;
    final /* synthetic */ String $endDateText;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Long $selectedEndDateMillis;
    final /* synthetic */ Long $selectedStartDateMillis;
    final /* synthetic */ Function2<Composer, Integer, Unit> $startDatePlaceholder;
    final /* synthetic */ String $startDateText;
    final /* synthetic */ DateRangePickerDefaults $tmp7_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerDefaults$DateRangePickerHeadline$6(DateRangePickerDefaults dateRangePickerDefaults, Long l, Long l2, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, int i2, int i3) {
        super(2);
        this.$tmp7_rcvr = dateRangePickerDefaults;
        this.$selectedStartDateMillis = l;
        this.$selectedEndDateMillis = l2;
        this.$displayMode = i;
        this.$dateFormatter = datePickerFormatter;
        this.$modifier = modifier;
        this.$startDateText = str;
        this.$endDateText = str2;
        this.$startDatePlaceholder = function2;
        this.$endDatePlaceholder = function22;
        this.$datesDelimiter = function23;
        this.$$changed = i2;
        this.$$changed1 = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp7_rcvr.m1782DateRangePickerHeadline0YIUgSQ(this.$selectedStartDateMillis, this.$selectedEndDateMillis, this.$displayMode, this.$dateFormatter, this.$modifier, this.$startDateText, this.$endDateText, this.$startDatePlaceholder, this.$endDatePlaceholder, this.$datesDelimiter, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1));
    }
}
