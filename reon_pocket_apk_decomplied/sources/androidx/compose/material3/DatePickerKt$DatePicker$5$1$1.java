package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "dateInMillis", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePicker$5$1$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ DatePickerState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePicker$5$1$1(DatePickerState datePickerState) {
        super(1);
        this.$state = datePickerState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Long) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Long l) {
        this.$state.setSelectedDateMillis(l);
    }
}
