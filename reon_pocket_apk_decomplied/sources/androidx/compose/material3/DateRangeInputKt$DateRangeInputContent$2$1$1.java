package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "startDateMillis", "", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DateRangeInput.kt */
final class DateRangeInputKt$DateRangeInputContent$2$1$1 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ Function2<Long, Long, Unit> $onDatesSelectionChange;
    final /* synthetic */ Long $selectedEndDateMillis;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangeInputKt$DateRangeInputContent$2$1$1(Function2<? super Long, ? super Long, Unit> function2, Long l) {
        super(1);
        this.$onDatesSelectionChange = function2;
        this.$selectedEndDateMillis = l;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Long) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Long l) {
        this.$onDatesSelectionChange.invoke(l, this.$selectedEndDateMillis);
    }
}
