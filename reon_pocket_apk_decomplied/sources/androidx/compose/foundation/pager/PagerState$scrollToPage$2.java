package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$scrollToPage$2", f = "PagerState.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PagerState.kt */
final class PagerState$scrollToPage$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $page;
    final /* synthetic */ float $pageOffsetFraction;
    int label;
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PagerState$scrollToPage$2(PagerState pagerState, float f, int i, Continuation<? super PagerState$scrollToPage$2> continuation) {
        super(2, continuation);
        this.this$0 = pagerState;
        this.$pageOffsetFraction = f;
        this.$page = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PagerState$scrollToPage$2(this.this$0, this.$pageOffsetFraction, this.$page, continuation);
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((PagerState$scrollToPage$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.awaitScrollDependencies(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        float f = this.$pageOffsetFraction;
        double d = (double) f;
        if (-0.5d > d || d > 0.5d) {
            z = false;
        }
        if (z) {
            this.this$0.snapToItem$foundation_release(this.this$0.coerceInPageRange(this.$page), this.$pageOffsetFraction);
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException(("pageOffsetFraction " + f + " is not within the range -0.5 to 0.5").toString());
    }
}
