package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateInput.kt */
final class DateInputKt$DateInputTextField$4 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ DatePickerColors $colors;
    final /* synthetic */ DateInputFormat $dateInputFormat;
    final /* synthetic */ DateInputValidator $dateInputValidator;
    final /* synthetic */ Long $initialDateMillis;
    final /* synthetic */ int $inputIdentifier;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;
    final /* synthetic */ Locale $locale;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateInputKt$DateInputTextField$4(Modifier modifier, Long l, Function1<? super Long, Unit> function1, CalendarModel calendarModel, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, int i, DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, DatePickerColors datePickerColors, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$initialDateMillis = l;
        this.$onDateSelectionChange = function1;
        this.$calendarModel = calendarModel;
        this.$label = function2;
        this.$placeholder = function22;
        this.$inputIdentifier = i;
        this.$dateInputValidator = dateInputValidator;
        this.$dateInputFormat = dateInputFormat;
        this.$locale = locale;
        this.$colors = datePickerColors;
        this.$$changed = i2;
        this.$$changed1 = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        DateInputKt.m1734DateInputTextFieldtQNruF0(this.$modifier, this.$initialDateMillis, this.$onDateSelectionChange, this.$calendarModel, this.$label, this.$placeholder, this.$inputIdentifier, this.$dateInputValidator, this.$dateInputFormat, this.$locale, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), RecomposeScopeImplKt.updateChangedFlags(this.$$changed1));
    }
}
