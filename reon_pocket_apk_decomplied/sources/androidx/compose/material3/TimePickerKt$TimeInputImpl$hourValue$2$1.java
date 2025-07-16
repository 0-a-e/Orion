package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/text/input/TextFieldValue;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimePicker.kt */
final class TimePickerKt$TimeInputImpl$hourValue$2$1 extends Lambda implements Function0<MutableState<TextFieldValue>> {
    final /* synthetic */ TimePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimePickerKt$TimeInputImpl$hourValue$2$1(TimePickerState timePickerState) {
        super(0);
        this.$state = timePickerState;
    }

    public final MutableState<TextFieldValue> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(ActualJvm_jvmKt.toLocalString$default(this.$state.getHourForDisplay$material3_release(), 2, 0, false, 6, (Object) null), 0, (TextRange) null, 6, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
