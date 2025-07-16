package jp.co.sony.reonpocket.connection.log;

import android.app.Application;
import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import jp.co.sony.reonpocket.connection.aws.S3FileManager;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u0015"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/LogUpload;", "Landroid/app/Application;", "()V", "compressGZIP", "", "aInput", "Ljava/io/File;", "aOutput", "upload", "aContext", "Landroid/content/Context;", "aDate", "", "aFileName", "aFile", "aLogType", "uploadLog", "logFileDir", "uploadLogFile", "waitReadLog", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogUpload.kt */
public final class LogUpload extends Application {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AwsLog_UploadLogJobTask";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/LogUpload$Companion;", "", "()V", "TAG", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LogUpload.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void waitReadLog(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        while (LogManager.INSTANCE.checkReadLogJobRunStatus(context)) {
            try {
                Thread.sleep(100);
            } catch (Exception unused) {
            }
        }
    }

    public final void uploadLog(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(file, "logFileDir");
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, context, (String) null, 2, (Object) null)) {
            DebugLogUtil.INSTANCE.d(TAG, "Read log's job has stoped, start upload log job");
            File[] listFiles = file.listFiles(new LogUpload$$ExternalSyntheticLambda1());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    DebugLogUtil.INSTANCE.e(TAG, "Upload unuploaded file:" + file2.getName());
                    String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
                    Intrinsics.checkNotNull(format);
                    String name = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    Intrinsics.checkNotNull(file2);
                    String name2 = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    upload(context, format, name, file2, name2);
                }
            }
            uploadLogFile(context, file);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean uploadLog$lambda$2(File file) {
        return file != null && file.isFile() && Intrinsics.areEqual((Object) FilesKt.getExtension(file), (Object) CompressorStreamFactory.GZIP);
    }

    private final void upload(Context context, String str, String str2, File file, String str3) {
        String substring = StringsKt.substring(str, new IntRange(0, 3));
        String substring2 = StringsKt.substring(str, new IntRange(4, 5));
        String substring3 = StringsKt.substring(str, new IntRange(6, 7));
        S3FileManager.INSTANCE.upload(context, "year=" + substring + "/month=" + substring2 + "/day=" + substring3 + "/" + str2, file, new LogUpload$upload$1(str2, file));
    }

    private final void uploadLogFile(Context context, File file) {
        Object obj;
        String name = file.getName();
        File[] listFiles = file.listFiles(new LogUpload$$ExternalSyntheticLambda0());
        if (listFiles != null) {
            for (File file2 : listFiles) {
                String format = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
                String str = file2.getName() + ".gz";
                File file3 = new File(file2.getParent() + File.separator + str);
                try {
                    Result.Companion companion = Result.Companion;
                    Intrinsics.checkNotNull(file2);
                    compressGZIP(file2, file3);
                    obj = Result.m7042constructorimpl(Boolean.valueOf(file2.delete()));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m7042constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m7045exceptionOrNullimpl(obj) == null) {
                    ((Boolean) obj).booleanValue();
                    if (file3.length() > 0) {
                        Intrinsics.checkNotNull(format);
                        Intrinsics.checkNotNull(name);
                        upload(context, format, str, file3, name);
                    } else {
                        file3.delete();
                        DebugLogUtil.INSTANCE.e(TAG, ".gz file empty, delete file");
                    }
                } else {
                    DebugLogUtil.INSTANCE.e(TAG, "CSV file compress to .gz or delete failed");
                }
            }
            return;
        }
        DebugLogUtil.INSTANCE.w(TAG, "CSV file isn't exist");
    }

    /* access modifiers changed from: private */
    public static final boolean uploadLogFile$lambda$6(File file) {
        return file != null && file.isFile() && Intrinsics.areEqual((Object) FilesKt.getExtension(file), (Object) "csv");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0038, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003f, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0042, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0043, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0046, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void compressGZIP(java.io.File r4, java.io.File r5) {
        /*
            r3 = this;
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r4)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r4 = r0
            java.io.FileInputStream r4 = (java.io.FileInputStream) r4     // Catch:{ all -> 0x0040 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0040 }
            r1.<init>(r5)     // Catch:{ all -> 0x0040 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x0040 }
            r5 = r1
            java.io.FileOutputStream r5 = (java.io.FileOutputStream) r5     // Catch:{ all -> 0x0039 }
            org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream r2 = new org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream     // Catch:{ all -> 0x0039 }
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ all -> 0x0039 }
            r2.<init>(r5)     // Catch:{ all -> 0x0039 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x0039 }
            r5 = r2
            org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream r5 = (org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream) r5     // Catch:{ all -> 0x0032 }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x0032 }
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ all -> 0x0032 }
            org.apache.commons.compress.utils.IOUtils.copy(r4, r5)     // Catch:{ all -> 0x0032 }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x0040 }
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            return
        L_0x0032:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x0039 }
            throw r5     // Catch:{ all -> 0x0039 }
        L_0x0039:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003b }
        L_0x003b:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x0040 }
            throw r5     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.LogUpload.compressGZIP(java.io.File, java.io.File):void");
    }
}
