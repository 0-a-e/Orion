package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState", f = "LazyStaggeredGridState.kt", i = {0, 0, 0}, l = {227, 228}, m = "scroll", n = {"this", "scrollPriority", "block"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: LazyStaggeredGridState.kt */
final class LazyStaggeredGridState$scroll$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LazyStaggeredGridState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyStaggeredGridState$scroll$1(LazyStaggeredGridState lazyStaggeredGridState, Continuation<? super LazyStaggeredGridState$scroll$1> continuation) {
        super(continuation);
        this.this$0 = lazyStaggeredGridState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.scroll((MutatePriority) null, (Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
