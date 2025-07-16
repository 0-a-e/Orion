package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$updateScrollDeltaForPostLookahead$2$1", f = "LazyListState.kt", i = {}, l = {495}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LazyListState.kt */
final class LazyListState$updateScrollDeltaForPostLookahead$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LazyListState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListState$updateScrollDeltaForPostLookahead$2$1(LazyListState lazyListState, Continuation<? super LazyListState$updateScrollDeltaForPostLookahead$2$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyListState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyListState$updateScrollDeltaForPostLookahead$2$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyListState$updateScrollDeltaForPostLookahead$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(this.this$0._scrollDeltaBetweenPasses, Boxing.boxFloat(0.0f), AnimationSpecKt.spring$default(0.0f, 400.0f, Boxing.boxFloat(0.5f), 1, (Object) null), true, (Function1) null, this, 8, (Object) null) == coroutine_suspended) {
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
