package jp.co.sony.reonpocket.connection.log.logcat;

import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger$outputLogFile$2", f = "LogCatLogger.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogCatLogger.kt */
final class LogCatLogger$outputLogFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ File $logFile;
    final /* synthetic */ Uri $outputFileUri;
    int label;
    final /* synthetic */ LogCatLogger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogCatLogger$outputLogFile$2(LogCatLogger logCatLogger, Uri uri, File file, Continuation<? super LogCatLogger$outputLogFile$2> continuation) {
        super(2, continuation);
        this.this$0 = logCatLogger;
        this.$outputFileUri = uri;
        this.$logFile = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogCatLogger$outputLogFile$2(this.this$0, this.$outputFileUri, this.$logFile, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((LogCatLogger$outputLogFile$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: android.os.ParcelFileDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v2 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r5v5, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c2 A[SYNTHETIC, Splitter:B:46:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ce A[SYNTHETIC, Splitter:B:51:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00da A[SYNTHETIC, Splitter:B:56:0x00da] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ed A[SYNTHETIC, Splitter:B:65:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00f9 A[SYNTHETIC, Splitter:B:70:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0105 A[SYNTHETIC, Splitter:B:75:0x0105] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.String r0 = "ParcelFileDescriptor close failed"
            java.lang.String r1 = "OutputStream close failed"
            java.lang.String r2 = "BufferedReader close failed"
            java.lang.String r3 = "CLOSE"
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r10.label
            if (r4 != 0) goto L_0x0110
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger r4 = r10.this$0     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            android.content.Context r4 = r4.context     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            android.net.Uri r5 = r10.$outputFileUri     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            java.lang.String r6 = "w"
            android.os.ParcelFileDescriptor r4 = r4.openFileDescriptor(r5, r6)     // Catch:{ Exception -> 0x00ba, all -> 0x00b6 }
            if (r4 == 0) goto L_0x008f
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.io.FileDescriptor r6 = r4.getFileDescriptor()     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x008c, all -> 0x0088 }
            java.io.File r6 = r10.$logFile     // Catch:{ Exception -> 0x0086 }
            java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0086 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0086 }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0086 }
            r9.<init>(r6)     // Catch:{ Exception -> 0x0086 }
            java.io.InputStream r9 = (java.io.InputStream) r9     // Catch:{ Exception -> 0x0086 }
            r8.<init>(r9, r7)     // Catch:{ Exception -> 0x0086 }
            java.io.Reader r8 = (java.io.Reader) r8     // Catch:{ Exception -> 0x0086 }
            boolean r6 = r8 instanceof java.io.BufferedReader     // Catch:{ Exception -> 0x0086 }
            if (r6 == 0) goto L_0x004a
            java.io.BufferedReader r8 = (java.io.BufferedReader) r8     // Catch:{ Exception -> 0x0086 }
            r11 = r8
            goto L_0x0052
        L_0x004a:
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0086 }
            r7 = 8192(0x2000, float:1.14794E-41)
            r6.<init>(r8, r7)     // Catch:{ Exception -> 0x0086 }
            r11 = r6
        L_0x0052:
            kotlin.sequences.Sequence r6 = kotlin.io.TextStreamsKt.lineSequence(r11)     // Catch:{ Exception -> 0x0086 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Exception -> 0x0086 }
        L_0x005a:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x0086 }
            if (r7 == 0) goto L_0x0090
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x0086 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0086 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0086 }
            r8.<init>()     // Catch:{ Exception -> 0x0086 }
            r8.append(r7)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r7 = "\n"
            r8.append(r7)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r7 = r8.toString()     // Catch:{ Exception -> 0x0086 }
            java.nio.charset.Charset r8 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0086 }
            byte[] r7 = r7.getBytes(r8)     // Catch:{ Exception -> 0x0086 }
            java.lang.String r8 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch:{ Exception -> 0x0086 }
            r5.write(r7)     // Catch:{ Exception -> 0x0086 }
            goto L_0x005a
        L_0x0086:
            r6 = move-exception
            goto L_0x00bd
        L_0x0088:
            r6 = move-exception
            r5 = r11
            goto L_0x00eb
        L_0x008c:
            r6 = move-exception
            r5 = r11
            goto L_0x00bd
        L_0x008f:
            r5 = r11
        L_0x0090:
            if (r11 == 0) goto L_0x009c
            r11.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x009c
        L_0x0096:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r2, r11)
        L_0x009c:
            if (r5 == 0) goto L_0x00a8
            r5.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00a8
        L_0x00a2:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r1, r11)
        L_0x00a8:
            if (r4 == 0) goto L_0x00b4
            r4.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00b4
        L_0x00ae:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r0, r11)
        L_0x00b4:
            r11 = 1
            goto L_0x00e5
        L_0x00b6:
            r6 = move-exception
            r4 = r11
            r5 = r4
            goto L_0x00eb
        L_0x00ba:
            r6 = move-exception
            r4 = r11
            r5 = r4
        L_0x00bd:
            r6.printStackTrace()     // Catch:{ all -> 0x00ea }
            if (r11 == 0) goto L_0x00cc
            r11.close()     // Catch:{ IOException -> 0x00c6 }
            goto L_0x00cc
        L_0x00c6:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r2, r11)
        L_0x00cc:
            if (r5 == 0) goto L_0x00d8
            r5.close()     // Catch:{ IOException -> 0x00d2 }
            goto L_0x00d8
        L_0x00d2:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r1, r11)
        L_0x00d8:
            if (r4 == 0) goto L_0x00e4
            r4.close()     // Catch:{ IOException -> 0x00de }
            goto L_0x00e4
        L_0x00de:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r0, r11)
        L_0x00e4:
            r11 = 0
        L_0x00e5:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            return r11
        L_0x00ea:
            r6 = move-exception
        L_0x00eb:
            if (r11 == 0) goto L_0x00f7
            r11.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f7
        L_0x00f1:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r2, r11)
        L_0x00f7:
            if (r5 == 0) goto L_0x0103
            r5.close()     // Catch:{ IOException -> 0x00fd }
            goto L_0x0103
        L_0x00fd:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r1, r11)
        L_0x0103:
            if (r4 == 0) goto L_0x010f
            r4.close()     // Catch:{ IOException -> 0x0109 }
            goto L_0x010f
        L_0x0109:
            r11 = move-exception
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            android.util.Log.w(r3, r0, r11)
        L_0x010f:
            throw r6
        L_0x0110:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger$outputLogFile$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
