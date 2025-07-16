package androidx.compose.foundation.lazy;

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
@DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListState$scrollToItem$2", f = "LazyListState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LazyListState.kt */
final class LazyListState$scrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $scrollOffset;
    int label;
    final /* synthetic */ LazyListState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListState$scrollToItem$2(LazyListState lazyListState, int i, int i2, Continuation<? super LazyListState$scrollToItem$2> continuation) {
        super(2, continuation);
        this.this$0 = lazyListState;
        this.$index = i;
        this.$scrollOffset = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyListState$scrollToItem$2(this.this$0, this.$index, this.$scrollOffset, continuation);
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyListState$scrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.snapToItemIndexInternal$foundation_release(this.$index, this.$scrollOffset);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
