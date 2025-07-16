package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior", f = "SnapFlingBehavior.kt", i = {0}, l = {165}, m = "fling", n = {"onRemainingScrollOffsetUpdate"}, s = {"L$0"})
/* compiled from: SnapFlingBehavior.kt */
final class SnapFlingBehavior$fling$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SnapFlingBehavior this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$fling$1(SnapFlingBehavior snapFlingBehavior, Continuation<? super SnapFlingBehavior$fling$1> continuation) {
        super(continuation);
        this.this$0 = snapFlingBehavior;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fling((ScrollScope) null, 0.0f, (Function1<? super Float, Unit>) null, this);
    }
}
