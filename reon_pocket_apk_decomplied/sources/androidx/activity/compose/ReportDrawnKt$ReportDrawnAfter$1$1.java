package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.activity.compose.ReportDrawnKt$ReportDrawnAfter$1$1", f = "ReportDrawn.kt", i = {0}, l = {182}, m = "invokeSuspend", n = {"$this$reportWhenComplete$iv"}, s = {"L$0"})
/* compiled from: ReportDrawn.kt */
final class ReportDrawnKt$ReportDrawnAfter$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ FullyDrawnReporter $fullyDrawnReporter;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportDrawnKt$ReportDrawnAfter$1$1(FullyDrawnReporter fullyDrawnReporter, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super ReportDrawnKt$ReportDrawnAfter$1$1> continuation) {
        super(2, continuation);
        this.$fullyDrawnReporter = fullyDrawnReporter;
        this.$block = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReportDrawnKt$ReportDrawnAfter$1$1(this.$fullyDrawnReporter, this.$block, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReportDrawnKt$ReportDrawnAfter$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th;
        FullyDrawnReporter fullyDrawnReporter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FullyDrawnReporter fullyDrawnReporter2 = this.$fullyDrawnReporter;
            Function1<Continuation<? super Unit>, Object> function1 = this.$block;
            fullyDrawnReporter2.addReporter();
            if (!fullyDrawnReporter2.isFullyDrawnReported()) {
                try {
                    this.L$0 = fullyDrawnReporter2;
                    this.label = 1;
                    if (function1.invoke(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    fullyDrawnReporter = fullyDrawnReporter2;
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    fullyDrawnReporter = fullyDrawnReporter2;
                    th = th3;
                    fullyDrawnReporter.removeReporter();
                    throw th;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            fullyDrawnReporter = (FullyDrawnReporter) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        fullyDrawnReporter.removeReporter();
        return Unit.INSTANCE;
    }
}
