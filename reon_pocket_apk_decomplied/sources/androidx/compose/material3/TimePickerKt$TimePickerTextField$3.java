package androidx.compose.material3;

import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimePickerTextField$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ TimePickerColors $colors;
    final /* synthetic */ KeyboardActions $keyboardActions;
    final /* synthetic */ KeyboardOptions $keyboardOptions;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Function1<TextFieldValue, Unit> $onValueChange;
    final /* synthetic */ int $selection;
    final /* synthetic */ TimePickerState $state;
    final /* synthetic */ TextFieldValue $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimePickerTextField$3(Modifier modifier, TextFieldValue textFieldValue, Function1<? super TextFieldValue, Unit> function1, TimePickerState timePickerState, int i, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, TimePickerColors timePickerColors, int i2, int i3) {
        super(2);
        this.$modifier = modifier;
        this.$value = textFieldValue;
        this.$onValueChange = function1;
        this.$state = timePickerState;
        this.$selection = i;
        this.$keyboardOptions = keyboardOptions;
        this.$keyboardActions = keyboardActions;
        this.$colors = timePickerColors;
        this.$$changed = i2;
        this.$$default = i3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        TimePickerKt.m2484TimePickerTextFieldlxUZ_iY(this.$modifier, this.$value, this.$onValueChange, this.$state, this.$selection, this.$keyboardOptions, this.$keyboardActions, this.$colors, composer, RecomposeScopeImplKt.updateChangedFlags(this.$$changed | 1), this.$$default);
    }
}
