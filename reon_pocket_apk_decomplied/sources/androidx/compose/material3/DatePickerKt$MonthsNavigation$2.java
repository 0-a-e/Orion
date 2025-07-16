package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$MonthsNavigation$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ boolean $nextAvailable;
    final /* synthetic */ Function0<Unit> $onNextClicked;
    final /* synthetic */ Function0<Unit> $onPreviousClicked;
    final /* synthetic */ Function0<Unit> $onYearPickerButtonClicked;
    final /* synthetic */ boolean $previousAvailable;
    final /* synthetic */ String $yearPickerText;
    final /* synthetic */ boolean $yearPickerVisible;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$MonthsNavigation$2(Modifier modifier, boolean z, boolean z2, boolean z3, String str, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, DatePickerColors datePickerColors, int i) {
        super(2);
        this.$modifier = modifier;
        this.$nextAvailable = z;
        this.$previousAvailable = z2;
        this.$yearPickerVisible = z3;
        this.$yearPickerText = str;
        this.$onNextClicked = function0;
        this.$onPreviousClicked = function02;
        this.$onYearPickerButtonClicked = function03;
        this.$colors = datePickerColors;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DatePickerKt.MonthsNavigation(this.$modifier, this.$nextAvailable, this.$previousAvailable, this.$yearPickerVisible, this.$yearPickerText, this.$onNextClicked, this.$onPreviousClicked, this.$onYearPickerButtonClicked, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1));
    }
}
