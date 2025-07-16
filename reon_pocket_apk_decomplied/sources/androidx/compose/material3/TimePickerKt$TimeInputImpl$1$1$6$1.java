package androidx.compose.material3;

import androidx.compose.foundation.text.KeyboardActionScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/text/KeyboardActionScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$1$1$6$1 extends Lambda implements Function1<KeyboardActionScope, Unit> {
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1$6$1(TimePickerState timePickerState) {
        super(1);
        this.$state = timePickerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((KeyboardActionScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(KeyboardActionScope keyboardActionScope) {
        this.$state.m2510setSelectioniHAOin8$material3_release(Selection.Companion.m2169getMinuteJiIwxys());
    }
}
