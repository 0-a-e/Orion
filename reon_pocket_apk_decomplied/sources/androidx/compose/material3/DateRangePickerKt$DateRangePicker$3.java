package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$DateRangePicker$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ DateRangePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$DateRangePicker$3(DateRangePickerState dateRangePickerState, DatePickerFormatter datePickerFormatter) {
        super(2);
        this.$state = dateRangePickerState;
        this.$dateFormatter = datePickerFormatter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C95@4452L312:DateRangePicker.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-185279404, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:95)");
            }
            DateRangePickerDefaults.INSTANCE.m1784DateRangePickerHeadlinev84Udv0(this.$state.getSelectedStartDateMillis(), this.$state.getSelectedEndDateMillis(), this.$state.m1794getDisplayModejFl4v0(), this.$dateFormatter, PaddingKt.padding(Modifier.Companion, DateRangePickerKt.DateRangePickerHeadlinePadding), composer, 221184, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
