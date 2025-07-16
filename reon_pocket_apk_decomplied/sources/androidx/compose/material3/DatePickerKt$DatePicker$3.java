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
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePicker$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePicker$3(DatePickerState datePickerState, DatePickerFormatter datePickerFormatter) {
        super(2);
        this.$state = datePickerState;
        this.$dateFormatter = datePickerFormatter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C162@7771L243:DatePicker.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1780043561, i, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:162)");
            }
            DatePickerDefaults.INSTANCE.m1762DatePickerHeadline3kbWawI(this.$state.getSelectedDateMillis(), this.$state.m1778getDisplayModejFl4v0(), this.$dateFormatter, PaddingKt.padding(Modifier.Companion, DatePickerKt.DatePickerHeadlinePadding), composer, 27648, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
