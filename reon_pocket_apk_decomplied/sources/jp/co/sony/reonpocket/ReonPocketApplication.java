package jp.co.sony.reonpocket;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.io.File;
import jp.co.sony.reonpocket.connection.log.BGLogManager;
import jp.co.sony.reonpocket.connection.log.LogUpload;
import jp.co.sony.reonpocket.connection.log.logcat.LogCatLogger;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import jp.co.sony.reonpocket.util.CrashlyticsUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ljp/co/sony/reonpocket/ReonPocketApplication;", "Landroid/app/Application;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "aLogUpload", "Ljp/co/sony/reonpocket/connection/log/LogUpload;", "mBGLogManager", "Ljp/co/sony/reonpocket/connection/log/BGLogManager;", "mLogCatLogger", "Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLogger;", "getLogCatLogger", "onCreate", "", "onPause", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onResume", "uploadLog", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReonPocketApplication.kt */
public final class ReonPocketApplication extends Application implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static ReonPocketApplication instance;
    private final LogUpload aLogUpload = new LogUpload();
    private final BGLogManager mBGLogManager = new BGLogManager();
    private LogCatLogger mLogCatLogger;

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onCreate(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onDestroy(this, lifecycleOwner);
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStart(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        DefaultLifecycleObserver.CC.$default$onStop(this, lifecycleOwner);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\bR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/ReonPocketApplication$Companion;", "", "()V", "applicationContext", "Landroid/content/Context;", "getApplicationContext", "()Landroid/content/Context;", "instance", "Ljp/co/sony/reonpocket/ReonPocketApplication;", "getInstance", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReonPocketApplication.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReonPocketApplication getInstance() {
            ReonPocketApplication access$getInstance$cp = ReonPocketApplication.instance;
            if (access$getInstance$cp != null) {
                return access$getInstance$cp;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        public final Context getApplicationContext() {
            Context applicationContext = getInstance().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            return applicationContext;
        }
    }

    public void onCreate() {
        super.onCreate();
        AnalyticsUtil analyticsUtil = AnalyticsUtil.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        analyticsUtil.setFBAnalyticsCollectionSetting(applicationContext);
        CrashlyticsUtil.INSTANCE.setFBCrashlyticsCollectionSetting(this);
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(this);
        instance = this;
    }

    public void onResume(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        DefaultLifecycleObserver.CC.$default$onResume(this, lifecycleOwner);
        this.mBGLogManager.stopRequestLog();
        this.mBGLogManager.initContentList();
        this.mBGLogManager.createCallbackListener();
        uploadLog();
    }

    public void onPause(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        DefaultLifecycleObserver.CC.$default$onPause(this, lifecycleOwner);
        this.mBGLogManager.requestLog();
    }

    private final void uploadLog() {
        File filesDir = getApplicationContext().getFilesDir();
        String str = File.separator;
        File file = new File(filesDir + str + "log");
        LogUpload logUpload = this.aLogUpload;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        logUpload.uploadLog(applicationContext, file);
    }

    public final LogCatLogger getLogCatLogger() {
        LogCatLogger logCatLogger = this.mLogCatLogger;
        if (logCatLogger != null) {
            return logCatLogger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLogCatLogger");
        return null;
    }
}
