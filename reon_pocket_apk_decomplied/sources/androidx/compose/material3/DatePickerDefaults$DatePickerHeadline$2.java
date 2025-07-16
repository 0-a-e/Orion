package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerDefaults$DatePickerHeadline$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ DatePickerFormatter $dateFormatter;
    final /* synthetic */ int $displayMode;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Long $selectedDateMillis;
    final /* synthetic */ DatePickerDefaults $tmp9_rcvr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerDefaults$DatePickerHeadline$2(DatePickerDefaults datePickerDefaults, Long l, int i, DatePickerFormatter datePickerFormatter, Modifier modifier, int i2, int i3) {
        super(2);
        this.$tmp9_rcvr = datePickerDefaults;
        this.$selectedDateMillis = l;
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
        this.$tmp9_rcvr.m1762DatePickerHeadline3kbWawI(this.$selectedDateMillis, this.$displayMode, this.$dateFormatter, this.$modifier, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
