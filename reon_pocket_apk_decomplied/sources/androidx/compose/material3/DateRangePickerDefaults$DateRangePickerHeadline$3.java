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
final class DateRangePickerDefaults$DateRangePickerHeadline$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ int $displayMode;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Long $selectedEndDateMillis;
    final /* synthetic */ Long $selectedStartDateMillis;
    final /* synthetic */ DateRangePickerDefaults $tmp0_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerDefaults$DateRangePickerHeadline$3(DateRangePickerDefaults dateRangePickerDefaults, Long l, Long l2, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, int i2, int i3) {
        super(2);
        this.$tmp0_rcvr = dateRangePickerDefaults;
        this.$selectedStartDateMillis = l;
        this.$selectedEndDateMillis = l2;
        this.$displayMode = i;
        this.$dateFormatter = datePickerFormatter;
        this.$modifier = modifier;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        this.$tmp0_rcvr.m1784DateRangePickerHeadlinev84Udv0(this.$selectedStartDateMillis, this.$selectedEndDateMillis, this.$displayMode, this.$dateFormatter, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
