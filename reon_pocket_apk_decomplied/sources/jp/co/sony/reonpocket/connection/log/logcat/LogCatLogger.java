package jp.co.sony.reonpocket.connection.log.logcat;

import android.content.Context;
import android.net.Uri;
import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u000f2\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001cJ\u0006\u0010\u001d\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogger;", "", "context", "Landroid/content/Context;", "repository", "Ljp/co/sony/reonpocket/connection/log/logcat/LogCatFileRepository;", "(Landroid/content/Context;Ljp/co/sony/reonpocket/connection/log/logcat/LogCatFileRepository;)V", "escapeLogWord", "", "", "loggingJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "changeToNewLogFile", "", "enableLine", "", "line", "logging", "logFile", "Ljava/io/File;", "outputLogFile", "outputFileUri", "Landroid/net/Uri;", "(Ljava/io/File;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startLogging", "callback", "Lkotlin/Function0;", "stopLogging", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogger.kt */
public final class LogCatLogger {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final Context context;
    private final List<String> escapeLogWord = CollectionsKt.listOf("tag success", "onTagWriteSuccess", "toggleNotification", "request log", "notify log");
    private Job loggingJob;
    /* access modifiers changed from: private */
    public final LogCatFileRepository repository;
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));

    public LogCatLogger(Context context2, LogCatFileRepository logCatFileRepository) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(logCatFileRepository, "repository");
        this.context = context2;
        this.repository = logCatFileRepository;
    }

    public static /* synthetic */ void startLogging$default(LogCatLogger logCatLogger, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        logCatLogger.startLogging(function0);
    }

    public final void startLogging(Function0<Unit> function0) {
        Job job = this.loggingJob;
        if (job == null || !job.isActive()) {
            try {
                Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, Dispatchers.getDefault(), (CoroutineStart) null, new LogCatLogger$startLogging$1(this, function0, (Continuation<? super LogCatLogger$startLogging$1>) null), 2, (Object) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("loggingJob is active");
        }
    }

    /* access modifiers changed from: private */
    public final void logging(File file) {
        System.out.println("start logging");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ProcessBuilder(new String[]{"logcat", "-v", "time"}).start().getInputStream()));
            this.loggingJob = FlowKt.launchIn(FlowKt.flowOn(FlowKt.cancellable(FlowKt.onCompletion(FlowKt.onEach(FlowKt.asFlow(TextStreamsKt.lineSequence(bufferedReader)), new LogCatLogger$logging$1(this, file, (Continuation<? super LogCatLogger$logging$1>) null)), new LogCatLogger$logging$2(bufferedReader, (Continuation<? super LogCatLogger$logging$2>) null))), Dispatchers.getIO()), this.scope);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public final void changeToNewLogFile() {
        System.out.println("change to new log file");
        stopLogging();
        startLogging$default(this, (Function0) null, 1, (Object) null);
    }

    public final void stopLogging() {
        System.out.println("stop logging");
        Job job = this.loggingJob;
        if (job != null && job.isActive()) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.loggingJob = null;
    }

    public final Object outputLogFile(File file, Uri uri, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new LogCatLogger$outputLogFile$2(this, uri, file, (Continuation<? super LogCatLogger$outputLogFile$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final boolean enableLine(String str) {
        CharSequence charSequence = str;
        if (!StringsKt.contains$default(charSequence, (CharSequence) String.valueOf(Process.myPid()), false, 2, (Object) null)) {
            return false;
        }
        for (String contains$default : this.escapeLogWord) {
            if (StringsKt.contains$default(charSequence, (CharSequence) contains$default, false, 2, (Object) null)) {
                return false;
            }
        }
        return true;
    }
}
