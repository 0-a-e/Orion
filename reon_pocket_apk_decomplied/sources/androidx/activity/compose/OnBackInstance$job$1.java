package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.activity.compose.OnBackInstance$job$1", f = "PredictiveBackHandler.kt", i = {0}, l = {156}, m = "invokeSuspend", n = {"completed"}, s = {"L$0"})
/* compiled from: PredictiveBackHandler.kt */
final class OnBackInstance$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> $onBack;
    Object L$0;
    int label;
    final /* synthetic */ OnBackInstance this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnBackInstance$job$1(Function2<? super Flow<BackEventCompat>, ? super Continuation<? super Unit>, ? extends Object> function2, OnBackInstance onBackInstance, Continuation<? super OnBackInstance$job$1> continuation) {
        super(2, continuation);
        this.$onBack = function2;
        this.this$0 = onBackInstance;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnBackInstance$job$1(this.$onBack, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OnBackInstance$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            Function2<Flow<BackEventCompat>, Continuation<? super Unit>, Object> function2 = this.$onBack;
            Flow onCompletion = FlowKt.onCompletion(FlowKt.consumeAsFlow(this.this$0.getChannel()), new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
            this.L$0 = booleanRef2;
            this.label = 1;
            if (function2.invoke(onCompletion, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef2;
        } else if (i == 1) {
            booleanRef = (Ref.BooleanRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (booleanRef.element) {
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("You must collect the progress flow".toString());
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/activity/BackEventCompat;", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.activity.compose.OnBackInstance$job$1$1", f = "PredictiveBackHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.activity.compose.OnBackInstance$job$1$1  reason: invalid class name */
    /* compiled from: PredictiveBackHandler.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super BackEventCompat>, Throwable, Continuation<? super Unit>, Object> {
        int label;

        public final Object invoke(FlowCollector<? super BackEventCompat> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            return new AnonymousClass1(booleanRef2, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                booleanRef2.element = true;
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
