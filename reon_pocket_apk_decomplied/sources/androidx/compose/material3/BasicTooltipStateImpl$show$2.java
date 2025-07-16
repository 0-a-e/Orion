package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.BasicTooltipStateImpl$show$2", f = "BasicTooltip.kt", i = {}, l = {159, 161}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BasicTooltip.kt */
final class BasicTooltipStateImpl$show$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $cancellableShow;
    int label;
    final /* synthetic */ BasicTooltipStateImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasicTooltipStateImpl$show$2(BasicTooltipStateImpl basicTooltipStateImpl, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super BasicTooltipStateImpl$show$2> continuation) {
        super(1, continuation);
        this.this$0 = basicTooltipStateImpl;
        this.$cancellableShow = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BasicTooltipStateImpl$show$2(this.this$0, this.$cancellableShow, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((BasicTooltipStateImpl$show$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.isPersistent()) {
                Function1<Continuation<? super Unit>, Object> function1 = this.$cancellableShow;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                final Function1<Continuation<? super Unit>, Object> function12 = this.$cancellableShow;
                this.label = 2;
                if (TimeoutKt.withTimeout(1500, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1 || i == 2) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                this.this$0.setVisible(false);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.setVisible(false);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.BasicTooltipStateImpl$show$2$1", f = "BasicTooltip.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.BasicTooltipStateImpl$show$2$1  reason: invalid class name */
    /* compiled from: BasicTooltip.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(function12, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super Unit>, Object> function1 = function12;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
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
}
