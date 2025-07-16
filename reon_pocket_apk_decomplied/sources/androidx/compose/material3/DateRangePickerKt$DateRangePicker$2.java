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
final class DateRangePickerKt$DateRangePicker$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DateRangePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$DateRangePicker$2(DateRangePickerState dateRangePickerState) {
        super(2);
        this.$state = dateRangePickerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C89@4223L145:DateRangePicker.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-162164694, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:89)");
            }
            DateRangePickerDefaults.INSTANCE.m1785DateRangePickerTitlehOD91z4(this.$state.m1794getDisplayModejFl4v0(), PaddingKt.padding(Modifier.Companion, DateRangePickerKt.DateRangePickerTitlePadding), composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
