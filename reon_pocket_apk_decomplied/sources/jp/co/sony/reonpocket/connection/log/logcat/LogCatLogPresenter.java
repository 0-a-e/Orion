package jp.co.sony.reonpocket.connection.log.logcat;

import android.net.Uri;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\u0018J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\fJ\u0006\u0010%\u001a\u00020\u0018R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\bX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006&"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogPresenter;", "", "logCatLogRepository", "Ljp/co/sony/reonpocket/connection/log/logcat/LogCatFileRepository;", "logCatLogger", "Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogger;", "(Ljp/co/sony/reonpocket/connection/log/logcat/LogCatFileRepository;Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogger;)V", "_confirmDeleteLogFile", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljp/co/sony/reonpocket/connection/log/logcat/ConfirmDeleteLogFileDialogInfo;", "_logFiles", "", "Ljava/io/File;", "_toastMessage", "", "confirmDeleteLogFile", "Lkotlinx/coroutines/flow/StateFlow;", "getConfirmDeleteLogFile", "()Lkotlinx/coroutines/flow/StateFlow;", "logFiles", "getLogFiles", "toastMessage", "getToastMessage", "loadLogFiles", "", "onClickDeleteAllFiles", "onClickLogFile", "logFile", "outputFileUri", "Landroid/net/Uri;", "onClickStartLogging", "onClickStopLogging", "onConfirmDeleteLogFile", "info", "onDismissDeleteLogFile", "onLongClickLogFile", "file", "onShownToast", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogPresenter.kt */
public final class LogCatLogPresenter {
    public static final int $stable = 8;
    private final MutableStateFlow<ConfirmDeleteLogFileDialogInfo> _confirmDeleteLogFile;
    /* access modifiers changed from: private */
    public final MutableStateFlow<List<File>> _logFiles;
    /* access modifiers changed from: private */
    public final MutableStateFlow<String> _toastMessage;
    private final StateFlow<ConfirmDeleteLogFileDialogInfo> confirmDeleteLogFile;
    /* access modifiers changed from: private */
    public final LogCatFileRepository logCatLogRepository;
    /* access modifiers changed from: private */
    public final LogCatLogger logCatLogger;
    private final StateFlow<List<File>> logFiles;
    private final StateFlow<String> toastMessage;

    public LogCatLogPresenter(LogCatFileRepository logCatFileRepository, LogCatLogger logCatLogger2) {
        Intrinsics.checkNotNullParameter(logCatFileRepository, "logCatLogRepository");
        Intrinsics.checkNotNullParameter(logCatLogger2, "logCatLogger");
        this.logCatLogRepository = logCatFileRepository;
        this.logCatLogger = logCatLogger2;
        MutableStateFlow<List<File>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._logFiles = MutableStateFlow;
        this.logFiles = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._toastMessage = MutableStateFlow2;
        this.toastMessage = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<ConfirmDeleteLogFileDialogInfo> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._confirmDeleteLogFile = MutableStateFlow3;
        this.confirmDeleteLogFile = FlowKt.asStateFlow(MutableStateFlow3);
    }

    public final StateFlow<List<File>> getLogFiles() {
        return this.logFiles;
    }

    public final StateFlow<String> getToastMessage() {
        return this.toastMessage;
    }

    public final StateFlow<ConfirmDeleteLogFileDialogInfo> getConfirmDeleteLogFile() {
        return this.confirmDeleteLogFile;
    }

    public final void onClickStartLogging() {
        this.logCatLogger.startLogging(new LogCatLogPresenter$onClickStartLogging$1(this));
    }

    public final void onClickStopLogging() {
        String value;
        this.logCatLogger.stopLogging();
        MutableStateFlow<String> mutableStateFlow = this._toastMessage;
        do {
            value = mutableStateFlow.getValue();
            String str = value;
        } while (!mutableStateFlow.compareAndSet(value, "LogCatのLoggingを止めました"));
    }

    public final void onClickDeleteAllFiles() {
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new LogCatLogPresenter$onClickDeleteAllFiles$1(this, (Continuation<? super LogCatLogPresenter$onClickDeleteAllFiles$1>) null), 1, (Object) null);
    }

    public final void onClickLogFile(File file, Uri uri) {
        Intrinsics.checkNotNullParameter(file, "logFile");
        Intrinsics.checkNotNullParameter(uri, "outputFileUri");
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new LogCatLogPresenter$onClickLogFile$1(this, file, uri, (Continuation<? super LogCatLogPresenter$onClickLogFile$1>) null), 1, (Object) null);
    }

    public final void onShownToast() {
        String value;
        MutableStateFlow<String> mutableStateFlow = this._toastMessage;
        do {
            value = mutableStateFlow.getValue();
            String str = value;
        } while (!mutableStateFlow.compareAndSet(value, null));
    }

    public final void onLongClickLogFile(File file) {
        ConfirmDeleteLogFileDialogInfo value;
        String name;
        Intrinsics.checkNotNullParameter(file, TransferTable.COLUMN_FILE);
        MutableStateFlow<ConfirmDeleteLogFileDialogInfo> mutableStateFlow = this._confirmDeleteLogFile;
        do {
            value = mutableStateFlow.getValue();
            ConfirmDeleteLogFileDialogInfo confirmDeleteLogFileDialogInfo = value;
            name = file.getName();
        } while (!mutableStateFlow.compareAndSet(value, new ConfirmDeleteLogFileDialogInfo(file, name + "\n\nを削除しますか？")));
    }

    public final void onConfirmDeleteLogFile(ConfirmDeleteLogFileDialogInfo confirmDeleteLogFileDialogInfo) {
        ConfirmDeleteLogFileDialogInfo value;
        String str;
        String value2;
        Intrinsics.checkNotNullParameter(confirmDeleteLogFileDialogInfo, "info");
        MutableStateFlow<ConfirmDeleteLogFileDialogInfo> mutableStateFlow = this._confirmDeleteLogFile;
        do {
            value = mutableStateFlow.getValue();
            ConfirmDeleteLogFileDialogInfo confirmDeleteLogFileDialogInfo2 = value;
        } while (!mutableStateFlow.compareAndSet(value, null));
        if (confirmDeleteLogFileDialogInfo.getFile().delete()) {
            str = "ログファイルを削除しました（" + confirmDeleteLogFileDialogInfo.getFile().getName() + "）";
        } else {
            str = "ログファイルの削除に失敗しました（" + confirmDeleteLogFileDialogInfo.getFile().getName() + "）";
        }
        String str2 = str;
        loadLogFiles();
        MutableStateFlow<String> mutableStateFlow2 = this._toastMessage;
        do {
            value2 = mutableStateFlow2.getValue();
            String str3 = value2;
        } while (!mutableStateFlow2.compareAndSet(value2, str2));
    }

    public final void onDismissDeleteLogFile() {
        ConfirmDeleteLogFileDialogInfo value;
        MutableStateFlow<ConfirmDeleteLogFileDialogInfo> mutableStateFlow = this._confirmDeleteLogFile;
        do {
            value = mutableStateFlow.getValue();
            ConfirmDeleteLogFileDialogInfo confirmDeleteLogFileDialogInfo = value;
        } while (!mutableStateFlow.compareAndSet(value, null));
    }

    public final void loadLogFiles() {
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new LogCatLogPresenter$loadLogFiles$1(this, (Continuation<? super LogCatLogPresenter$loadLogFiles$1>) null), 1, (Object) null);
    }
}
