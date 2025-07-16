package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import androidx.tracing.Trace$$ExternalSyntheticApiModelOutline0;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.log.LogFileManager;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

public class SessionReportingCoordinator implements CrashlyticsLifecycleEvents {
    private static final int EVENT_THREAD_IMPORTANCE = 4;
    private static final String EVENT_TYPE_CRASH = "crash";
    private static final String EVENT_TYPE_LOGGED = "error";
    private static final int MAX_CHAINED_EXCEPTION_DEPTH = 8;
    private final CrashlyticsReportDataCapture dataCapture;
    private final LogFileManager logFileManager;
    private final UserMetadata reportMetadata;
    private final CrashlyticsReportPersistence reportPersistence;
    private final DataTransportCrashlyticsReportSender reportsSender;

    public static SessionReportingCoordinator create(Context context, IdManager idManager, FileStore fileStore, AppData appData, LogFileManager logFileManager2, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsDataProvider settingsDataProvider) {
        return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager, appData, stackTraceTrimmingStrategy), new CrashlyticsReportPersistence(new File(fileStore.getFilesDirPath()), settingsDataProvider), DataTransportCrashlyticsReportSender.create(context), logFileManager2, userMetadata);
    }

    SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager2, UserMetadata userMetadata) {
        this.dataCapture = crashlyticsReportDataCapture;
        this.reportPersistence = crashlyticsReportPersistence;
        this.reportsSender = dataTransportCrashlyticsReportSender;
        this.logFileManager = logFileManager2;
        this.reportMetadata = userMetadata;
    }

    public void onBeginSession(String str, long j) {
        this.reportPersistence.persistReport(this.dataCapture.captureReportData(str, j));
    }

    public void onLog(long j, String str) {
        this.logFileManager.writeToLog(j, str);
    }

    public void onCustomKey(String str, String str2) {
        this.reportMetadata.setCustomKey(str, str2);
    }

    public void onUserId(String str) {
        this.reportMetadata.setUserId(str);
    }

    public void persistFatalEvent(Throwable th, Thread thread, String str, long j) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting fatal event for session " + str);
        persistEvent(th, thread, str, "crash", j, true);
    }

    public void persistNonFatalEvent(Throwable th, Thread thread, String str, long j) {
        Logger logger = Logger.getLogger();
        logger.v("Persisting non-fatal event for session " + str);
        persistEvent(th, thread, str, "error", j, false);
    }

    public void persistAppExitInfoEvent(String str, ApplicationExitInfo applicationExitInfo, LogFileManager logFileManager2, UserMetadata userMetadata) {
        if (Trace$$ExternalSyntheticApiModelOutline0.m(applicationExitInfo) >= this.reportPersistence.getStartTimestampMillis(str) && Trace$$ExternalSyntheticApiModelOutline0.m(applicationExitInfo) == 6) {
            CrashlyticsReport.Session.Event captureAnrEventData = this.dataCapture.captureAnrEventData(convertApplicationExitInfo(applicationExitInfo));
            Logger logger = Logger.getLogger();
            logger.d("Persisting anr for session " + str);
            this.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(captureAnrEventData, logFileManager2, userMetadata), str, true);
        }
    }

    public void finalizeSessionWithNativeEvent(String str, List<NativeSessionFile> list) {
        ArrayList arrayList = new ArrayList();
        for (NativeSessionFile asFilePayload : list) {
            CrashlyticsReport.FilesPayload.File asFilePayload2 = asFilePayload.asFilePayload();
            if (asFilePayload2 != null) {
                arrayList.add(asFilePayload2);
            }
        }
        this.reportPersistence.finalizeSessionWithNativeEvent(str, CrashlyticsReport.FilesPayload.builder().setFiles(ImmutableList.from(arrayList)).build());
    }

    public void persistUserId(String str) {
        String userId = this.reportMetadata.getUserId();
        if (userId == null) {
            Logger.getLogger().v("Could not persist user ID; no user ID available");
        } else {
            this.reportPersistence.persistUserIdForSession(userId, str);
        }
    }

    public void finalizeSessions(long j, String str) {
        this.reportPersistence.finalizeReports(str, j);
    }

    public List<String> listSortedOpenSessionIds() {
        return this.reportPersistence.listSortedOpenSessionIds();
    }

    public boolean hasReportsToSend() {
        return this.reportPersistence.hasFinalizedReports();
    }

    public void removeAllReports() {
        this.reportPersistence.deleteAllReports();
    }

    public Task<Void> sendReports(Executor executor) {
        List<CrashlyticsReportWithSessionId> loadFinalizedReports = this.reportPersistence.loadFinalizedReports();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId sendReport : loadFinalizedReports) {
            arrayList.add(this.reportsSender.sendReport(sendReport).continueWith(executor, new SessionReportingCoordinator$$ExternalSyntheticLambda9(this)));
        }
        return Tasks.whenAll((Collection<? extends Task<?>>) arrayList);
    }

    private CrashlyticsReport.Session.Event addLogsAndCustomKeysToEvent(CrashlyticsReport.Session.Event event) {
        return addLogsAndCustomKeysToEvent(event, this.logFileManager, this.reportMetadata);
    }

    private CrashlyticsReport.Session.Event addLogsAndCustomKeysToEvent(CrashlyticsReport.Session.Event event, LogFileManager logFileManager2, UserMetadata userMetadata) {
        CrashlyticsReport.Session.Event.Builder builder = event.toBuilder();
        String logString = logFileManager2.getLogString();
        if (logString != null) {
            builder.setLog(CrashlyticsReport.Session.Event.Log.builder().setContent(logString).build());
        } else {
            Logger.getLogger().v("No log data to include with this event.");
        }
        List<CrashlyticsReport.CustomAttribute> sortedCustomAttributes = getSortedCustomAttributes(userMetadata.getCustomKeys());
        List<CrashlyticsReport.CustomAttribute> sortedCustomAttributes2 = getSortedCustomAttributes(userMetadata.getInternalKeys());
        if (!sortedCustomAttributes.isEmpty()) {
            builder.setApp(event.getApp().toBuilder().setCustomAttributes(ImmutableList.from(sortedCustomAttributes)).setInternalKeys(ImmutableList.from(sortedCustomAttributes2)).build());
        }
        return builder.build();
    }

    private void persistEvent(Throwable th, Thread thread, String str, String str2, long j, boolean z) {
        boolean equals = str2.equals("crash");
        CrashlyticsReport.Session.Event captureEventData = this.dataCapture.captureEventData(th, thread, str2, j, 4, 8, z);
        String str3 = str;
        this.reportPersistence.persistEvent(addLogsAndCustomKeysToEvent(captureEventData), str, equals);
    }

    /* access modifiers changed from: private */
    public boolean onReportSendComplete(Task<CrashlyticsReportWithSessionId> task) {
        if (task.isSuccessful()) {
            CrashlyticsReportWithSessionId result = task.getResult();
            Logger logger = Logger.getLogger();
            logger.d("Crashlytics report successfully enqueued to DataTransport: " + result.getSessionId());
            this.reportPersistence.deleteFinalizedReport(result.getSessionId());
            return true;
        }
        Logger.getLogger().w("Crashlytics report could not be enqueued to DataTransport", task.getException());
        return false;
    }

    private static List<CrashlyticsReport.CustomAttribute> getSortedCustomAttributes(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.builder().setKey((String) next.getKey()).setValue((String) next.getValue()).build());
        }
        Collections.sort(arrayList, new SessionReportingCoordinator$$ExternalSyntheticLambda10());
        return arrayList;
    }

    private static CrashlyticsReport.ApplicationExitInfo convertApplicationExitInfo(ApplicationExitInfo applicationExitInfo) {
        String str;
        try {
            str = convertInputStreamToString(Trace$$ExternalSyntheticApiModelOutline0.m(applicationExitInfo));
        } catch (IOException | NullPointerException e) {
            Logger logger = Logger.getLogger();
            logger.w("Could not get input trace in application exit info: " + Trace$$ExternalSyntheticApiModelOutline0.m(applicationExitInfo) + " Error: " + e);
            str = null;
        }
        return CrashlyticsReport.ApplicationExitInfo.builder().setImportance(Trace$$ExternalSyntheticApiModelOutline0.m$1(applicationExitInfo)).setProcessName(Trace$$ExternalSyntheticApiModelOutline0.m$1(applicationExitInfo)).setReasonCode(Trace$$ExternalSyntheticApiModelOutline0.m(applicationExitInfo)).setTimestamp(Trace$$ExternalSyntheticApiModelOutline0.m(applicationExitInfo)).setPid(Trace$$ExternalSyntheticApiModelOutline0.m$2(applicationExitInfo)).setPss(Trace$$ExternalSyntheticApiModelOutline0.m$1(applicationExitInfo)).setRss(Trace$$ExternalSyntheticApiModelOutline0.m$2(applicationExitInfo)).setTraceFile(str).build();
    }

    public static String convertInputStreamToString(InputStream inputStream) throws IOException, NullPointerException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(StandardCharsets.UTF_8.name())));
        while (true) {
            try {
                int read = bufferedReader.read();
                if (read != -1) {
                    sb.append((char) read);
                } else {
                    String sb2 = sb.toString();
                    bufferedReader.close();
                    return sb2;
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        throw th;
    }
}
