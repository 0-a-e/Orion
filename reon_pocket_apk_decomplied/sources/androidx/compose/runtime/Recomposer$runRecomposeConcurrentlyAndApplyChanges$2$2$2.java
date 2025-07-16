package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2", f = "Recomposer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Recomposer.kt */
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ControlledComposition $composition;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(Recomposer recomposer, ControlledComposition controlledComposition, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$composition = controlledComposition;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(this.this$0, this.$composition, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        CancellableContinuation access$deriveStateLocked;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ControlledComposition access$performRecompose = this.this$0.performRecompose(this.$composition, (IdentityArraySet<Object>) null);
            Object access$getStateLock$p = this.this$0.stateLock;
            Recomposer recomposer = this.this$0;
            synchronized (access$getStateLock$p) {
                if (access$performRecompose != null) {
                    try {
                        recomposer.compositionsAwaitingApply.add(access$performRecompose);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                recomposer.concurrentCompositionsOutstanding = recomposer.concurrentCompositionsOutstanding - 1;
                access$deriveStateLocked = recomposer.deriveStateLocked();
            }
            if (access$deriveStateLocked != null) {
                Result.Companion companion = Result.Companion;
                access$deriveStateLocked.resumeWith(Result.m7042constructorimpl(Unit.INSTANCE));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
