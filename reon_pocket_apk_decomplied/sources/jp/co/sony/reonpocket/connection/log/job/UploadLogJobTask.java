package jp.co.sony.reonpocket.connection.log.job;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import jp.co.sony.reonpocket.connection.aws.S3FileManager;
import jp.co.sony.reonpocket.connection.log.LogUpload;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\b\u0007\u0018\u0000 \u001c2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J%\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0012\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0014J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/job/UploadLogJobTask;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "", "aContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "aLogUpload", "Ljp/co/sony/reonpocket/connection/log/LogUpload;", "getALogUpload", "()Ljp/co/sony/reonpocket/connection/log/LogUpload;", "compressGZIP", "aInput", "Ljava/io/File;", "aOutput", "doInBackground", "params", "", "([Ljava/lang/String;)V", "onPostExecute", "result", "(Lkotlin/Unit;)V", "onPreExecute", "upload", "aDate", "aFileName", "aFile", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UploadLogJobTask.kt */
public final class UploadLogJobTask extends AsyncTask<String, Void, Unit> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AwsLog_UploadLogJobTask";
    private final Context aContext;
    private final LogUpload aLogUpload = new LogUpload();

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        doInBackground((String[]) objArr);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/job/UploadLogJobTask$Companion;", "", "()V", "TAG", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UploadLogJobTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public UploadLogJobTask(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
    }

    public final LogUpload getALogUpload() {
        return this.aLogUpload;
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() {
        super.onPreExecute();
        DebugLogUtil.INSTANCE.d(TAG, "Start upload log job");
    }

    /* access modifiers changed from: protected */
    public void doInBackground(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "params");
        this.aLogUpload.waitReadLog(this.aContext);
        if (MyContentUtil.isSupportLog$default(MyContentUtil.INSTANCE, this.aContext, (String) null, 2, (Object) null)) {
            File filesDir = this.aContext.getFilesDir();
            String str = File.separator;
            String str2 = strArr[0];
            this.aLogUpload.uploadLog(this.aContext, new File(filesDir + str + str2));
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Unit unit) {
        super.onPostExecute(unit);
        DebugLogUtil.INSTANCE.d(TAG, "End upload log job");
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
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.job.UploadLogJobTask.compressGZIP(java.io.File, java.io.File):void");
    }

    private final void upload(String str, String str2, File file) {
        String substring = StringsKt.substring(str, new IntRange(0, 3));
        String substring2 = StringsKt.substring(str, new IntRange(4, 5));
        String substring3 = StringsKt.substring(str, new IntRange(6, 7));
        S3FileManager.INSTANCE.upload(this.aContext, "year=" + substring + "/month=" + substring2 + "/day=" + substring3 + "/" + str2, file, new UploadLogJobTask$upload$1(str2, file));
    }
}
