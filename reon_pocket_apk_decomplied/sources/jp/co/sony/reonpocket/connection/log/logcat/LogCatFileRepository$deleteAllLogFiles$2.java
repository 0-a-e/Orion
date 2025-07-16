package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatFileRepository$deleteAllLogFiles$2", f = "LogCatFileRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatFileRepository.kt */
final class LogCatFileRepository$deleteAllLogFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LogCatFileRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatFileRepository$deleteAllLogFiles$2(LogCatFileRepository logCatFileRepository, Continuation<? super LogCatFileRepository$deleteAllLogFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = logCatFileRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogCatFileRepository$deleteAllLogFiles$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogCatFileRepository$deleteAllLogFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            for (File file : this.this$0.getFilesInExternalStorageDownload()) {
                if (file.exists()) {
                    file.delete();
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
