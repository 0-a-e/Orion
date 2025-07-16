package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "emit", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$updateDisplayedMonth$3<T> implements FlowCollector {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function1<Long, Unit> $onDisplayedMonthChange;
    final /* synthetic */ IntRange $yearRange;

    DatePickerKt$updateDisplayedMonth$3(LazyListState lazyListState, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange) {
        this.$lazyListState = lazyListState;
        this.$onDisplayedMonthChange = function1;
        this.$calendarModel = calendarModel;
        this.$yearRange = intRange;
    }

    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation);
    }

    public final Object emit(int i, Continuation<? super Unit> continuation) {
        this.$onDisplayedMonthChange.invoke(Boxing.boxLong(this.$calendarModel.getMonth(this.$yearRange.getFirst() + (this.$lazyListState.getFirstVisibleItemIndex() / 12), (this.$lazyListState.getFirstVisibleItemIndex() % 12) + 1).getStartUtcTimeMillis()));
        return Unit.INSTANCE;
    }
}
