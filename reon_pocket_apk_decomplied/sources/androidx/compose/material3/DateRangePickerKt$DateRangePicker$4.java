package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$DateRangePicker$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ DateRangePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$DateRangePicker$4(DateRangePickerState dateRangePickerState) {
        super(2);
        this.$state = dateRangePickerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C117@5380L50,114@5182L267:DateRangePicker.kt#uh7d8r");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1490010652, i, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:114)");
            }
            Modifier padding = PaddingKt.padding(Modifier.Companion, DatePickerKt.getDatePickerModeTogglePadding());
            int r0 = this.$state.m1794getDisplayModejFl4v0();
            composer.startReplaceableGroup(-1467496949);
            ComposerKt.sourceInformation(composer, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean changed = composer.changed((Object) this.$state);
            DateRangePickerState dateRangePickerState = this.$state;
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new DateRangePickerKt$DateRangePicker$4$1$1(dateRangePickerState);
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            DatePickerKt.m1771DisplayModeToggleButtontER2X8s(padding, r0, (Function1) rememberedValue, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
