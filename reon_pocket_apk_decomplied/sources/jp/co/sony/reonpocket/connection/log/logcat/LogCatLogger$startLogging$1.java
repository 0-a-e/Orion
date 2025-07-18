package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger$startLogging$1", f = "LogCatLogger.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatLogger.kt */
final class LogCatLogger$startLogging$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    int label;
    final /* synthetic */ LogCatLogger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogger$startLogging$1(LogCatLogger logCatLogger, Function0<Unit> function0, Continuation<? super LogCatLogger$startLogging$1> continuation) {
        super(2, continuation);
        this.this$0 = logCatLogger;
        this.$callback = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogCatLogger$startLogging$1(this.this$0, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogCatLogger$startLogging$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.repository.getTargetLogFile(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.logging((File) obj);
        Function0<Unit> function0 = this.$callback;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
