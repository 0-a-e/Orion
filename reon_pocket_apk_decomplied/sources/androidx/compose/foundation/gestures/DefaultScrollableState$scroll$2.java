package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2", f = "ScrollableState.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ScrollableState.kt */
final class DefaultScrollableState$scroll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ScrollScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ MutatePriority $scrollPriority;
    int label;
    final /* synthetic */ DefaultScrollableState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultScrollableState$scroll$2(DefaultScrollableState defaultScrollableState, MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super DefaultScrollableState$scroll$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultScrollableState;
        this.$scrollPriority = mutatePriority;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultScrollableState$scroll$2(this.this$0, this.$scrollPriority, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultScrollableState$scroll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2$1", f = "ScrollableState.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2$1  reason: invalid class name */
    /* compiled from: ScrollableState.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(defaultScrollableState, function2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ScrollScope scrollScope = (ScrollScope) this.L$0;
                defaultScrollableState.isScrollingState.setValue(Boxing.boxBoolean(true));
                Function2<ScrollScope, Continuation<? super Unit>, Object> function2 = function2;
                this.label = 1;
                if (function2.invoke(scrollScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    defaultScrollableState.isScrollingState.setValue(Boxing.boxBoolean(false));
                    throw th;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            defaultScrollableState.isScrollingState.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutatorMutex access$getScrollMutex$p = this.this$0.scrollMutex;
            ScrollScope access$getScrollScope$p = this.this$0.scrollScope;
            MutatePriority mutatePriority = this.$scrollPriority;
            final DefaultScrollableState defaultScrollableState = this.this$0;
            final Function2<ScrollScope, Continuation<? super Unit>, Object> function2 = this.$block;
            this.label = 1;
            if (access$getScrollMutex$p.mutateWith(access$getScrollScope$p, mutatePriority, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
