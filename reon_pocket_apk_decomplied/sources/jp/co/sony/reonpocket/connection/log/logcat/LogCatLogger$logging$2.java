package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.BufferedReader;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger$logging$2", f = "LogCatLogger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatLogger.kt */
final class LogCatLogger$logging$2 extends SuspendLambda implements Function3<FlowCollector<? super String>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ BufferedReader $bufferedReader;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogger$logging$2(BufferedReader bufferedReader, Continuation<? super LogCatLogger$logging$2> continuation) {
        super(3, continuation);
        this.$bufferedReader = bufferedReader;
    }

    public final Object invoke(FlowCollector<? super String> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return new LogCatLogger$logging$2(this.$bufferedReader, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                this.$bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
