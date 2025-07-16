package jp.co.sony.reonpocket.connection.log.logcat;

import android.app.Application;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import jp.co.sony.reonpocket.ReonPocketApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogActivity;", "Landroidx/activity/ComponentActivity;", "()V", "logger", "Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogger;", "presenter", "Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogPresenter;", "repository", "Ljp/co/sony/reonpocket/connection/log/logcat/LogCatFileRepository;", "isExternalStorageWritable", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLogActivity.kt */
public final class LogCatLogActivity extends ComponentActivity {
    public static final int $stable = 8;
    private LogCatLogger logger;
    /* access modifiers changed from: private */
    public LogCatLogPresenter presenter;
    private LogCatFileRepository repository;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isExternalStorageWritable()) {
            Toast.makeText(this, "外部ストレージが使えない状態です", 1).show();
            return;
        }
        Application application = getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type jp.co.sony.reonpocket.ReonPocketApplication");
        this.logger = ((ReonPocketApplication) application).getLogCatLogger();
        this.repository = new LogCatFileRepository(this, (CoroutineDispatcher) null, 2, (DefaultConstructorMarker) null);
        LogCatFileRepository logCatFileRepository = this.repository;
        if (logCatFileRepository == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repository");
            logCatFileRepository = null;
        }
        LogCatLogger logCatLogger = this.logger;
        if (logCatLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logger");
            logCatLogger = null;
        }
        this.presenter = new LogCatLogPresenter(logCatFileRepository, logCatLogger);
        ComponentActivityKt.setContent$default(this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(777571839, true, new LogCatLogActivity$onCreate$1(this)), 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        LogCatLogPresenter logCatLogPresenter = this.presenter;
        if (logCatLogPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("presenter");
            logCatLogPresenter = null;
        }
        logCatLogPresenter.loadLogFiles();
    }

    private final boolean isExternalStorageWritable() {
        return Intrinsics.areEqual((Object) Environment.getExternalStorageState(), (Object) "mounted");
    }
}
