package androidx.compose.foundation;

import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect", f = "AndroidOverscroll.android.kt", i = {1, 1}, l = {223, 248}, m = "applyToFling-BMRW4eQ", n = {"this", "remainingVelocity"}, s = {"L$0", "J$0"})
/* compiled from: AndroidOverscroll.android.kt */
final class AndroidEdgeEffectOverscrollEffect$applyToFling$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidEdgeEffectOverscrollEffect$applyToFling$1(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super AndroidEdgeEffectOverscrollEffect$applyToFling$1> continuation) {
        super(continuation);
        this.this$0 = androidEdgeEffectOverscrollEffect;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.m194applyToFlingBMRW4eQ(0, (Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object>) null, this);
    }
}
