package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$1$1$1$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ MutableState<TextFieldValue> $hourValue$delegate;
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$1$1$1$1(TimePickerState timePickerState, MutableState<TextFieldValue> mutableState) {
        super(1);
        this.$state = timePickerState;
        this.$hourValue$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m2494invokeZmokQxo(((KeyEvent) obj).m4946unboximpl());
    }

    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m2494invokeZmokQxo(android.view.KeyEvent keyEvent) {
        int r3 = KeyEvent_androidKt.m4959getUtf16CodePointZmokQxo(keyEvent);
        if (48 <= r3 && r3 < 58 && TextRange.m6042getStartimpl(TimePickerKt.TimeInputImpl$lambda$5(this.$hourValue$delegate).m6299getSelectiond9O1mEE()) == 2 && TimePickerKt.TimeInputImpl$lambda$5(this.$hourValue$delegate).getText().length() == 2) {
            this.$state.m2510setSelectioniHAOin8$material3_release(Selection.Companion.m2169getMinuteJiIwxys());
        }
        return false;
    }
}
