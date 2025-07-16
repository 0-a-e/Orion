package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$1$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerContent$1$3$1(MutableState<Boolean> mutableState) {
        super(0);
        this.$yearPickerVisible$delegate = mutableState;
    }

    public final void invoke() {
        MutableState<Boolean> mutableState = this.$yearPickerVisible$delegate;
        DatePickerKt.DatePickerContent$lambda$9(mutableState, !DatePickerKt.DatePickerContent$lambda$8(mutableState));
    }
}
