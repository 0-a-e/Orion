package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatFileRepository$getLogFiles$2", f = "LogCatFileRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatFileRepository.kt */
final class LogCatFileRepository$getLogFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends File>>, Object> {
    int label;
    final /* synthetic */ LogCatFileRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatFileRepository$getLogFiles$2(LogCatFileRepository logCatFileRepository, Continuation<? super LogCatFileRepository$getLogFiles$2> continuation) {
        super(2, continuation);
        this.this$0 = logCatFileRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogCatFileRepository$getLogFiles$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends File>> continuation) {
        return ((LogCatFileRepository$getLogFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getFilesInExternalStorageDownload();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
