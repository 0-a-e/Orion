package jp.co.sony.reonpocket.connection.log.logcat;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "line", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger$logging$1", f = "LogCatLogger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatLogger.kt */
final class LogCatLogger$logging$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $logFile;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LogCatLogger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogger$logging$1(LogCatLogger logCatLogger, File file, Continuation<? super LogCatLogger$logging$1> continuation) {
        super(2, continuation);
        this.this$0 = logCatLogger;
        this.$logFile = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LogCatLogger$logging$1 logCatLogger$logging$1 = new LogCatLogger$logging$1(this.this$0, this.$logFile, continuation);
        logCatLogger$logging$1.L$0 = obj;
        return logCatLogger$logging$1;
    }

    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((LogCatLogger$logging$1) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r4.label
            if (r0 != 0) goto L_0x005c
            kotlin.ResultKt.throwOnFailure(r5)
            java.lang.Object r5 = r4.L$0
            java.lang.String r5 = (java.lang.String) r5
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger r0 = r4.this$0
            boolean r0 = r0.enableLine(r5)
            if (r0 == 0) goto L_0x0059
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch:{ Exception -> 0x0059 }
            java.io.File r1 = r4.$logFile     // Catch:{ Exception -> 0x0059 }
            r2 = 1
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x0059 }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ Exception -> 0x0059 }
            r1 = r0
            java.io.FileWriter r1 = (java.io.FileWriter) r1     // Catch:{ all -> 0x0052 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r2.<init>()     // Catch:{ all -> 0x0052 }
            r2.append(r5)     // Catch:{ all -> 0x0052 }
            java.lang.String r5 = "\n"
            r2.append(r5)     // Catch:{ all -> 0x0052 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x0052 }
            r1.write(r5)     // Catch:{ all -> 0x0052 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0052 }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r5)     // Catch:{ Exception -> 0x0059 }
            java.io.File r5 = r4.$logFile     // Catch:{ Exception -> 0x0059 }
            long r0 = r5.length()     // Catch:{ Exception -> 0x0059 }
            r2 = 10000000(0x989680, double:4.9406565E-317)
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x0059
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger r5 = r4.this$0     // Catch:{ Exception -> 0x0059 }
            r5.changeToNewLogFile()     // Catch:{ Exception -> 0x0059 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x0059 }
            return r5
        L_0x0052:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r5)     // Catch:{ Exception -> 0x0059 }
            throw r1     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x005c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger$logging$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
