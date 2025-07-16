package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1", f = "AppBar.kt", i = {0, 0}, l = {2203, 2204}, m = "onPostFling-RZ2iAVY", n = {"this", "available"}, s = {"L$0", "J$0"})
/* compiled from: AppBar.kt */
final class ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1(ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1 exitUntilCollapsedScrollBehavior$nestedScrollConnection$1, Continuation<? super ExitUntilCollapsedScrollBehavior$nestedScrollConnection$1$onPostFling$1> continuation) {
        super(continuation);
        this.this$0 = exitUntilCollapsedScrollBehavior$nestedScrollConnection$1;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m1843onPostFlingRZ2iAVY(0, 0, this);
    }
}
