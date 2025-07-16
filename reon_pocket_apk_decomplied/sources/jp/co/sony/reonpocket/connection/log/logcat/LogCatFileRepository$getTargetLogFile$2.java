package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.File;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatFileRepository$getTargetLogFile$2", f = "LogCatFileRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatFileRepository.kt */
final class LogCatFileRepository$getTargetLogFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    int label;
    final /* synthetic */ LogCatFileRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatFileRepository$getTargetLogFile$2(LogCatFileRepository logCatFileRepository, Continuation<? super LogCatFileRepository$getTargetLogFile$2> continuation) {
        super(2, continuation);
        this.this$0 = logCatFileRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogCatFileRepository$getTargetLogFile$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return ((LogCatFileRepository$getTargetLogFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Date date = new Date();
            String format = this.this$0.dateFormatDate.format(date);
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            String format2 = this.this$0.dateFormatTime.format(date);
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            String str = "logcat_" + format;
            String str2 = str + "_" + format2 + ".txt";
            List access$getLogFilesNameStartWithMatch = this.this$0.getLogFilesNameStartWithMatch(str);
            if (access$getLogFilesNameStartWithMatch.isEmpty()) {
                return new File(this.this$0.externalStorageDownload, str2);
            }
            if (access$getLogFilesNameStartWithMatch.size() == 1) {
                File file = new File(this.this$0.externalStorageDownload, ((File) access$getLogFilesNameStartWithMatch.get(0)).getName());
                return LogCatFileRepository.isFileSizeOverLimitSize$default(this.this$0, file, 0, 2, (Object) null) ? new File(this.this$0.externalStorageDownload, str2) : file;
            }
            File access$getLatestHHmmssLogFile = this.this$0.getLatestHHmmssLogFile(access$getLogFilesNameStartWithMatch);
            if (access$getLatestHHmmssLogFile != null) {
                return LogCatFileRepository.isFileSizeOverLimitSize$default(this.this$0, access$getLatestHHmmssLogFile, 0, 2, (Object) null) ? new File(this.this$0.externalStorageDownload, str2) : access$getLatestHHmmssLogFile;
            }
            throw new Exception("not found latest HHmmss log file");
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
