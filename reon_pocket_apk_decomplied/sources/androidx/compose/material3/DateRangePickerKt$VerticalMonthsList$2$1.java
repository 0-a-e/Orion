package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$2$1", f = "DateRangePicker.kt", i = {}, l = {874}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DateRangePicker.kt */
final class DateRangePickerKt$VerticalMonthsList$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CalendarModel $calendarModel;
    final /* synthetic */ LazyListState $lazyListState;
    final /* synthetic */ Function1<Long, Unit> $onDisplayedMonthChange;
    final /* synthetic */ IntRange $yearRange;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$VerticalMonthsList$2$1(LazyListState lazyListState, Function1<? super Long, Unit> function1, CalendarModel calendarModel, IntRange intRange, Continuation<? super DateRangePickerKt$VerticalMonthsList$2$1> continuation) {
        super(2, continuation);
        this.$lazyListState = lazyListState;
        this.$onDisplayedMonthChange = function1;
        this.$calendarModel = calendarModel;
        this.$yearRange = intRange;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DateRangePickerKt$VerticalMonthsList$2$1(this.$lazyListState, this.$onDisplayedMonthChange, this.$calendarModel, this.$yearRange, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DateRangePickerKt$VerticalMonthsList$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DatePickerKt.updateDisplayedMonth(this.$lazyListState, this.$onDisplayedMonthChange, this.$calendarModel, this.$yearRange, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
