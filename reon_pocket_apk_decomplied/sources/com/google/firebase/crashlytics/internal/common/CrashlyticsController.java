package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsController {
    static final FilenameFilter APP_EXCEPTION_MARKER_FILTER = new CrashlyticsController$$ExternalSyntheticLambda2();
    static final String APP_EXCEPTION_MARKER_PREFIX = ".ae";
    static final String FIREBASE_APPLICATION_EXCEPTION = "_ae";
    static final String FIREBASE_CRASH_TYPE = "fatal";
    static final int FIREBASE_CRASH_TYPE_FATAL = 1;
    static final String FIREBASE_TIMESTAMP = "timestamp";
    private static final String GENERATOR_FORMAT = "Crashlytics Android SDK/%s";
    static final String NATIVE_SESSION_DIR = "native-sessions";
    /* access modifiers changed from: private */
    public final AnalyticsEventLogger analyticsEventLogger;
    private final AppData appData;
    /* access modifiers changed from: private */
    public final CrashlyticsBackgroundWorker backgroundWorker;
    final AtomicBoolean checkForUnsentReportsCalled = new AtomicBoolean(false);
    private final Context context;
    private CrashlyticsUncaughtExceptionHandler crashHandler;
    /* access modifiers changed from: private */
    public final CrashlyticsFileMarker crashMarker;
    /* access modifiers changed from: private */
    public final DataCollectionArbiter dataCollectionArbiter;
    private final FileStore fileStore;
    private final IdManager idManager;
    private final LogFileManager.DirectoryProvider logFileDirectoryProvider;
    /* access modifiers changed from: private */
    public final LogFileManager logFileManager;
    private final CrashlyticsNativeComponent nativeComponent;
    final TaskCompletionSource<Boolean> reportActionProvided = new TaskCompletionSource<>();
    /* access modifiers changed from: private */
    public final SessionReportingCoordinator reportingCoordinator;
    private final String unityVersion;
    final TaskCompletionSource<Boolean> unsentReportsAvailable = new TaskCompletionSource<>();
    final TaskCompletionSource<Void> unsentReportsHandled = new TaskCompletionSource<>();
    private final UserMetadata userMetadata;

    CrashlyticsController(Context context2, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, IdManager idManager2, DataCollectionArbiter dataCollectionArbiter2, FileStore fileStore2, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData2, UserMetadata userMetadata2, LogFileManager logFileManager2, LogFileManager.DirectoryProvider directoryProvider, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger2) {
        this.context = context2;
        this.backgroundWorker = crashlyticsBackgroundWorker;
        this.idManager = idManager2;
        this.dataCollectionArbiter = dataCollectionArbiter2;
        this.fileStore = fileStore2;
        this.crashMarker = crashlyticsFileMarker;
        this.appData = appData2;
        this.userMetadata = userMetadata2;
        this.logFileManager = logFileManager2;
        this.logFileDirectoryProvider = directoryProvider;
        this.nativeComponent = crashlyticsNativeComponent;
        this.unityVersion = appData2.unityVersionProvider.getUnityVersion();
        this.analyticsEventLogger = analyticsEventLogger2;
        this.reportingCoordinator = sessionReportingCoordinator;
    }

    private Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: package-private */
    public void enableExceptionHandling(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsDataProvider settingsDataProvider) {
        openSession();
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() {
            public void onUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th) {
                CrashlyticsController.this.handleUncaughtException(settingsDataProvider, thread, th);
            }
        }, settingsDataProvider, uncaughtExceptionHandler);
        this.crashHandler = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }

    /* access modifiers changed from: package-private */
    public synchronized void handleUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable th) {
        Logger logger = Logger.getLogger();
        logger.d("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        final long currentTimeMillis = System.currentTimeMillis();
        final Throwable th2 = th;
        final Thread thread2 = thread;
        final SettingsDataProvider settingsDataProvider2 = settingsDataProvider;
        try {
            Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submitTask(new Callable<Task<Void>>() {
                public Task<Void> call() throws Exception {
                    long access$000 = CrashlyticsController.getTimestampSeconds(currentTimeMillis);
                    String access$100 = CrashlyticsController.this.getCurrentSessionId();
                    if (access$100 == null) {
                        Logger.getLogger().e("Tried to write a fatal exception while no session was open.");
                        return Tasks.forResult(null);
                    }
                    CrashlyticsController.this.crashMarker.create();
                    CrashlyticsController.this.reportingCoordinator.persistFatalEvent(th2, thread2, access$100, access$000);
                    CrashlyticsController.this.doWriteAppExceptionMarker(currentTimeMillis);
                    CrashlyticsController.this.doCloseSessions(settingsDataProvider2);
                    CrashlyticsController.this.doOpenSession();
                    if (!CrashlyticsController.this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
                        return Tasks.forResult(null);
                    }
                    final Executor executor = CrashlyticsController.this.backgroundWorker.getExecutor();
                    return settingsDataProvider2.getAppSettings().onSuccessTask(executor, new SuccessContinuation<AppSettingsData, Void>() {
                        public Task<Void> then(AppSettingsData appSettingsData) throws Exception {
                            if (appSettingsData == null) {
                                Logger.getLogger().w("Received null app settings, cannot send reports at crash time.");
                                return Tasks.forResult(null);
                            }
                            return Tasks.whenAll((Task<?>[]) new Task[]{CrashlyticsController.this.logAnalyticsAppExceptionEvents(), CrashlyticsController.this.reportingCoordinator.sendReports(executor)});
                        }
                    });
                }
            }));
        } catch (Exception e) {
            Logger.getLogger().e("Error handling uncaught exception", e);
        }
    }

    private Task<Boolean> waitForReportAction() {
        if (this.dataCollectionArbiter.isAutomaticDataCollectionEnabled()) {
            Logger.getLogger().d("Automatic data collection is enabled. Allowing upload.");
            this.unsentReportsAvailable.trySetResult(false);
            return Tasks.forResult(true);
        }
        Logger.getLogger().d("Automatic data collection is disabled.");
        Logger.getLogger().v("Notifying that unsent reports are available.");
        this.unsentReportsAvailable.trySetResult(true);
        Task<TContinuationResult> onSuccessTask = this.dataCollectionArbiter.waitForAutomaticDataCollectionEnabled().onSuccessTask(new SuccessContinuation<Void, Boolean>() {
            public Task<Boolean> then(Void voidR) throws Exception {
                return Tasks.forResult(true);
            }
        });
        Logger.getLogger().d("Waiting for send/deleteUnsentReports to be called.");
        return Utils.race(onSuccessTask, this.reportActionProvided.getTask());
    }

    /* access modifiers changed from: package-private */
    public boolean didCrashOnPreviousExecution() {
        if (!this.crashMarker.isPresent()) {
            String currentSessionId = getCurrentSessionId();
            return currentSessionId != null && this.nativeComponent.hasCrashDataForSession(currentSessionId);
        }
        Logger.getLogger().v("Found previous crash marker.");
        this.crashMarker.remove();
        return Boolean.TRUE.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public Task<Boolean> checkForUnsentReports() {
        if (this.checkForUnsentReportsCalled.compareAndSet(false, true)) {
            return this.unsentReportsAvailable.getTask();
        }
        Logger.getLogger().w("checkForUnsentReports should only be called once per execution.");
        return Tasks.forResult(false);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> sendUnsentReports() {
        this.reportActionProvided.trySetResult(true);
        return this.unsentReportsHandled.getTask();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> deleteUnsentReports() {
        this.reportActionProvided.trySetResult(false);
        return this.unsentReportsHandled.getTask();
    }

    /* access modifiers changed from: package-private */
    public Task<Void> submitAllReports(final Task<AppSettingsData> task) {
        if (!this.reportingCoordinator.hasReportsToSend()) {
            Logger.getLogger().v("No crash reports are available to be sent.");
            this.unsentReportsAvailable.trySetResult(false);
            return Tasks.forResult(null);
        }
        Logger.getLogger().v("Crash reports are available to be sent.");
        return waitForReportAction().onSuccessTask(new SuccessContinuation<Boolean, Void>() {
            public Task<Void> then(final Boolean bool) throws Exception {
                return CrashlyticsController.this.backgroundWorker.submitTask(new Callable<Task<Void>>() {
                    public Task<Void> call() throws Exception {
                        if (!bool.booleanValue()) {
                            Logger.getLogger().v("Deleting cached crash reports...");
                            CrashlyticsController.deleteFiles(CrashlyticsController.this.listAppExceptionMarkerFiles());
                            CrashlyticsController.this.reportingCoordinator.removeAllReports();
                            CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
                            return Tasks.forResult(null);
                        }
                        Logger.getLogger().d("Sending cached crash reports...");
                        CrashlyticsController.this.dataCollectionArbiter.grantDataCollectionPermission(bool.booleanValue());
                        final Executor executor = CrashlyticsController.this.backgroundWorker.getExecutor();
                        return task.onSuccessTask(executor, new SuccessContinuation<AppSettingsData, Void>() {
                            public Task<Void> then(AppSettingsData appSettingsData) throws Exception {
                                if (appSettingsData == null) {
                                    Logger.getLogger().w("Received null app settings at app startup. Cannot send cached reports");
                                    return Tasks.forResult(null);
                                }
                                Task unused = CrashlyticsController.this.logAnalyticsAppExceptionEvents();
                                CrashlyticsController.this.reportingCoordinator.sendReports(executor);
                                CrashlyticsController.this.unsentReportsHandled.trySetResult(null);
                                return Tasks.forResult(null);
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void writeToLog(final long j, final String str) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                if (CrashlyticsController.this.isHandlingException()) {
                    return null;
                }
                CrashlyticsController.this.logFileManager.writeToLog(j, str);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void writeNonFatalException(Thread thread, Throwable th) {
        final long currentTimeMillis = System.currentTimeMillis();
        final Throwable th2 = th;
        final Thread thread2 = thread;
        this.backgroundWorker.submit((Runnable) new Runnable() {
            public void run() {
                if (!CrashlyticsController.this.isHandlingException()) {
                    long access$000 = CrashlyticsController.getTimestampSeconds(currentTimeMillis);
                    String access$100 = CrashlyticsController.this.getCurrentSessionId();
                    if (access$100 == null) {
                        Logger.getLogger().w("Tried to write a non-fatal exception while no session was open.");
                    } else {
                        CrashlyticsController.this.reportingCoordinator.persistNonFatalEvent(th2, thread2, access$100, access$000);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setUserId(String str) {
        this.userMetadata.setUserId(str);
        cacheUserData(this.userMetadata);
    }

    /* access modifiers changed from: package-private */
    public void setCustomKey(String str, String str2) {
        try {
            this.userMetadata.setCustomKey(str, str2);
            cacheKeyData(this.userMetadata.getCustomKeys(), false);
        } catch (IllegalArgumentException e) {
            Context context2 = this.context;
            if (context2 == null || !CommonUtils.isAppDebuggable(context2)) {
                Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public void setCustomKeys(Map<String, String> map) {
        this.userMetadata.setCustomKeys(map);
        cacheKeyData(this.userMetadata.getCustomKeys(), false);
    }

    /* access modifiers changed from: package-private */
    public void setInternalKey(String str, String str2) {
        try {
            this.userMetadata.setInternalKey(str, str2);
            cacheKeyData(this.userMetadata.getInternalKeys(), true);
        } catch (IllegalArgumentException e) {
            Context context2 = this.context;
            if (context2 == null || !CommonUtils.isAppDebuggable(context2)) {
                Logger.getLogger().e("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e;
        }
    }

    private void cacheUserData(final UserMetadata userMetadata2) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                String access$100 = CrashlyticsController.this.getCurrentSessionId();
                if (access$100 == null) {
                    Logger.getLogger().d("Tried to cache user data while no session was open.");
                    return null;
                }
                CrashlyticsController.this.reportingCoordinator.persistUserId(access$100);
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeUserData(access$100, userMetadata2);
                return null;
            }
        });
    }

    private void cacheKeyData(final Map<String, String> map, final boolean z) {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                new MetaDataStore(CrashlyticsController.this.getFilesDir()).writeKeyData(CrashlyticsController.this.getCurrentSessionId(), map, z);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void openSession() {
        this.backgroundWorker.submit(new Callable<Void>() {
            public Void call() throws Exception {
                CrashlyticsController.this.doOpenSession();
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public String getCurrentSessionId() {
        List<String> listSortedOpenSessionIds = this.reportingCoordinator.listSortedOpenSessionIds();
        if (!listSortedOpenSessionIds.isEmpty()) {
            return listSortedOpenSessionIds.get(0);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean finalizeSessions(SettingsDataProvider settingsDataProvider) {
        this.backgroundWorker.checkRunningOnThread();
        if (isHandlingException()) {
            Logger.getLogger().w("Skipping session finalization because a crash has already occurred.");
            return Boolean.FALSE.booleanValue();
        }
        Logger.getLogger().v("Finalizing previously open sessions.");
        try {
            doCloseSessions(true, settingsDataProvider);
            Logger.getLogger().v("Closed all previously open sessions.");
            return true;
        } catch (Exception e) {
            Logger.getLogger().e("Unable to finalize previously open sessions.", e);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void doOpenSession() {
        long currentTimestampSeconds = getCurrentTimestampSeconds();
        String clsuuid = new CLSUUID(this.idManager).toString();
        Logger logger = Logger.getLogger();
        logger.d("Opening a new session with ID " + clsuuid);
        this.nativeComponent.openSession(clsuuid);
        writeBeginSession(clsuuid, currentTimestampSeconds);
        writeSessionApp(clsuuid);
        writeSessionOS(clsuuid);
        writeSessionDevice(clsuuid);
        this.logFileManager.setCurrentSession(clsuuid);
        this.reportingCoordinator.onBeginSession(clsuuid, currentTimestampSeconds);
    }

    /* access modifiers changed from: package-private */
    public void doCloseSessions(SettingsDataProvider settingsDataProvider) {
        doCloseSessions(false, settingsDataProvider);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doCloseSessions(boolean r5, com.google.firebase.crashlytics.internal.settings.SettingsDataProvider r6) {
        /*
            r4 = this;
            com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator r0 = r4.reportingCoordinator
            java.util.List r0 = r0.listSortedOpenSessionIds()
            int r1 = r0.size()
            if (r1 > r5) goto L_0x0016
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.String r6 = "No open sessions to be closed."
            r5.v(r6)
            return
        L_0x0016:
            java.lang.Object r1 = r0.get(r5)
            java.lang.String r1 = (java.lang.String) r1
            com.google.firebase.crashlytics.internal.settings.model.Settings r6 = r6.getSettings()
            com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData r6 = r6.getFeaturesData()
            boolean r6 = r6.collectAnrs
            if (r6 == 0) goto L_0x002b
            r4.writeApplicationExitInfoEventIfRelevant(r1)
        L_0x002b:
            com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r6 = r4.nativeComponent
            boolean r6 = r6.hasCrashDataForSession(r1)
            if (r6 == 0) goto L_0x0053
            r4.finalizePreviousNativeSession(r1)
            com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r6 = r4.nativeComponent
            boolean r6 = r6.finalizeSession(r1)
            if (r6 != 0) goto L_0x0053
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Could not finalize native session: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r6.w(r1)
        L_0x0053:
            if (r5 == 0) goto L_0x005d
            r5 = 0
            java.lang.Object r5 = r0.get(r5)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x005e
        L_0x005d:
            r5 = 0
        L_0x005e:
            com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator r6 = r4.reportingCoordinator
            long r0 = getCurrentTimestampSeconds()
            r6.finalizeSessions(r0, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsController.doCloseSessions(boolean, com.google.firebase.crashlytics.internal.settings.SettingsDataProvider):void");
    }

    /* access modifiers changed from: package-private */
    public File[] listNativeSessionFileDirectories() {
        return ensureFileArrayNotNull(getNativeSessionFilesDir().listFiles());
    }

    /* access modifiers changed from: package-private */
    public File[] listAppExceptionMarkerFiles() {
        return listFilesMatching(APP_EXCEPTION_MARKER_FILTER);
    }

    private File[] listFilesMatching(FilenameFilter filenameFilter) {
        return listFilesMatching(getFilesDir(), filenameFilter);
    }

    private static File[] listFilesMatching(File file, FilenameFilter filenameFilter) {
        return ensureFileArrayNotNull(file.listFiles(filenameFilter));
    }

    private static File[] ensureFileArrayNotNull(File[] fileArr) {
        return fileArr == null ? new File[0] : fileArr;
    }

    private void finalizePreviousNativeSession(String str) {
        Logger logger = Logger.getLogger();
        logger.v("Finalizing native report for session " + str);
        NativeSessionFileProvider sessionFileProvider = this.nativeComponent.getSessionFileProvider(str);
        File minidumpFile = sessionFileProvider.getMinidumpFile();
        if (minidumpFile == null || !minidumpFile.exists()) {
            Logger logger2 = Logger.getLogger();
            logger2.w("No minidump data found for session " + str);
            return;
        }
        long lastModified = minidumpFile.lastModified();
        LogFileManager logFileManager2 = new LogFileManager(this.context, this.logFileDirectoryProvider, str);
        File file = new File(getNativeSessionFilesDir(), str);
        if (!file.mkdirs()) {
            Logger.getLogger().w("Couldn't create directory to store native session files, aborting.");
            return;
        }
        doWriteAppExceptionMarker(lastModified);
        List<NativeSessionFile> nativeSessionFiles = getNativeSessionFiles(sessionFileProvider, str, getFilesDir(), logFileManager2.getBytesForLog());
        NativeSessionFileGzipper.processNativeSessions(file, nativeSessionFiles);
        this.reportingCoordinator.finalizeSessionWithNativeEvent(str, nativeSessionFiles);
        logFileManager2.clearLog();
    }

    private static long getCurrentTimestampSeconds() {
        return getTimestampSeconds(System.currentTimeMillis());
    }

    /* access modifiers changed from: private */
    public static long getTimestampSeconds(long j) {
        return j / 1000;
    }

    /* access modifiers changed from: private */
    public void doWriteAppExceptionMarker(long j) {
        try {
            File filesDir = getFilesDir();
            new File(filesDir, APP_EXCEPTION_MARKER_PREFIX + j).createNewFile();
        } catch (IOException e) {
            Logger.getLogger().w("Could not create app exception marker file.", e);
        }
    }

    private void writeBeginSession(String str, long j) {
        this.nativeComponent.writeBeginSession(str, String.format(Locale.US, GENERATOR_FORMAT, new Object[]{CrashlyticsCore.getVersion()}), j);
    }

    private void writeSessionApp(String str) {
        String str2 = str;
        this.nativeComponent.writeSessionApp(str2, this.idManager.getAppIdentifier(), this.appData.versionCode, this.appData.versionName, this.idManager.getCrashlyticsInstallId(), DeliveryMechanism.determineFrom(this.appData.installerPackageName).getId(), this.unityVersion);
    }

    private void writeSessionOS(String str) {
        this.nativeComponent.writeSessionOs(str, Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.isRooted(getContext()));
    }

    private void writeSessionDevice(String str) {
        Context context2 = getContext();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int cpuArchitectureInt = CommonUtils.getCpuArchitectureInt();
        String str2 = Build.MODEL;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long totalRamInBytes = CommonUtils.getTotalRamInBytes();
        long blockSize = (long) statFs.getBlockSize();
        boolean isEmulator = CommonUtils.isEmulator(context2);
        int deviceState = CommonUtils.getDeviceState(context2);
        String str3 = Build.MANUFACTURER;
        String str4 = Build.PRODUCT;
        this.nativeComponent.writeSessionDevice(str, cpuArchitectureInt, str2, availableProcessors, totalRamInBytes, blockSize * ((long) statFs.getBlockCount()), isEmulator, deviceState, str3, str4);
    }

    /* access modifiers changed from: package-private */
    public UserMetadata getUserMetadata() {
        return this.userMetadata;
    }

    /* access modifiers changed from: package-private */
    public boolean isHandlingException() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.crashHandler;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.isHandlingException();
    }

    /* access modifiers changed from: package-private */
    public File getFilesDir() {
        return this.fileStore.getFilesDir();
    }

    /* access modifiers changed from: package-private */
    public File getNativeSessionFilesDir() {
        return new File(getFilesDir(), NATIVE_SESSION_DIR);
    }

    /* access modifiers changed from: private */
    public Task<Void> logAnalyticsAppExceptionEvents() {
        ArrayList arrayList = new ArrayList();
        for (File file : listAppExceptionMarkerFiles()) {
            try {
                arrayList.add(logAnalyticsAppExceptionEvent(Long.parseLong(file.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger.getLogger().w("Could not parse app exception timestamp from file " + file.getName());
            }
            file.delete();
        }
        return Tasks.whenAll((Collection<? extends Task<?>>) arrayList);
    }

    private Task<Void> logAnalyticsAppExceptionEvent(final long j) {
        if (firebaseCrashExists()) {
            Logger.getLogger().w("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.forResult(null);
        }
        Logger.getLogger().d("Logging app exception event to Firebase Analytics");
        return Tasks.call(new ScheduledThreadPoolExecutor(1), new Callable<Void>() {
            public Void call() throws Exception {
                Bundle bundle = new Bundle();
                bundle.putInt(CrashlyticsController.FIREBASE_CRASH_TYPE, 1);
                bundle.putLong(CrashlyticsController.FIREBASE_TIMESTAMP, j);
                CrashlyticsController.this.analyticsEventLogger.logEvent(CrashlyticsController.FIREBASE_APPLICATION_EXCEPTION, bundle);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public static void deleteFiles(File[] fileArr) {
        if (fileArr != null) {
            for (File delete : fileArr) {
                delete.delete();
            }
        }
    }

    private static boolean firebaseCrashExists() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    static List<NativeSessionFile> getNativeSessionFiles(NativeSessionFileProvider nativeSessionFileProvider, String str, File file, byte[] bArr) {
        MetaDataStore metaDataStore = new MetaDataStore(file);
        File userDataFileForSession = metaDataStore.getUserDataFileForSession(str);
        File keysFileForSession = metaDataStore.getKeysFileForSession(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", "metadata", nativeSessionFileProvider.getMetadataFile()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.getSessionFile()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.getAppFile()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProvider.getDeviceFile()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProvider.getOsFile()));
        arrayList.add(new FileBackedNativeSessionFile("minidump_file", "minidump", nativeSessionFileProvider.getMinidumpFile()));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", "user", userDataFileForSession));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", "keys", keysFileForSession));
        return arrayList;
    }

    private void writeApplicationExitInfoEventIfRelevant(String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            List m = ((ActivityManager) this.context.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 1);
            if (m.size() != 0) {
                LogFileManager logFileManager2 = new LogFileManager(this.context, this.logFileDirectoryProvider, str);
                UserMetadata userMetadata2 = new UserMetadata();
                userMetadata2.setCustomKeys(new MetaDataStore(getFilesDir()).readKeyData(str));
                this.reportingCoordinator.persistAppExitInfoEvent(str, Trace$$ExternalSyntheticApiModelOutline0.m(m.get(0)), logFileManager2, userMetadata2);
                return;
            }
            return;
        }
        Logger logger = Logger.getLogger();
        logger.v("ANR feature enabled, but device is API " + Build.VERSION.SDK_INT);
    }
}
