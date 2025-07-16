package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "year", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$1$4$2$2$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ CalendarMonth $displayedMonth;
    final /* synthetic */ LazyListState $monthsListState;
    final /* synthetic */ MutableState<Boolean> $yearPickerVisible$delegate;
    final /* synthetic */ IntRange $yearRange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerContent$1$4$2$2$1$1(CoroutineScope coroutineScope, MutableState<Boolean> mutableState, LazyListState lazyListState, IntRange intRange, CalendarMonth calendarMonth) {
        super(1);
        this.$coroutineScope = coroutineScope;
        this.$yearPickerVisible$delegate = mutableState;
        this.$monthsListState = lazyListState;
        this.$yearRange = intRange;
        this.$displayedMonth = calendarMonth;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1$1", f = "DatePicker.kt", i = {}, l = {1568}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$4$2$2$1$1$1  reason: invalid class name */
    /* compiled from: DatePicker.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(lazyListState, i2, intRange, calendarMonth, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LazyListState lazyListState = lazyListState;
                this.label = 1;
                if (LazyListState.scrollToItem$default(lazyListState, (((i2 - intRange.getFirst()) * 12) + calendarMonth.getMonth()) - 1, 0, this, 2, (Object) null) == coroutine_suspended) {
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

    public final void invoke(int i) {
        MutableState<Boolean> mutableState = this.$yearPickerVisible$delegate;
        DatePickerKt.DatePickerContent$lambda$9(mutableState, !DatePickerKt.DatePickerContent$lambda$8(mutableState));
        CoroutineScope coroutineScope = this.$coroutineScope;
        final LazyListState lazyListState = this.$monthsListState;
        final IntRange intRange = this.$yearRange;
        final CalendarMonth calendarMonth = this.$displayedMonth;
        final int i2 = i;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
