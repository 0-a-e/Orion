package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: DatePicker.kt */
final class DatePickerKt$DatePickerContent$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ LazyListState $monthsListState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DatePickerKt$DatePickerContent$1$1$1(CoroutineScope coroutineScope, LazyListState lazyListState) {
        super(0);
        this.$coroutineScope = coroutineScope;
        this.$monthsListState = lazyListState;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1$1", f = "DatePicker.kt", i = {}, l = {1498}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.DatePickerKt$DatePickerContent$1$1$1$1  reason: invalid class name */
    /* compiled from: DatePicker.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(lazyListState, continuation);
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
                if (LazyListState.animateScrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() + 1, 0, this, 2, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (IllegalArgumentException unused) {
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void invoke() {
        CoroutineScope coroutineScope = this.$coroutineScope;
        final LazyListState lazyListState = this.$monthsListState;
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
