package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class CrashlyticsReportPersistence {
    private static final String APP_EXIT_INFO_FILE_NAME = "app-exit-info";
    private static final String EVENT_COUNTER_FORMAT = "%010d";
    private static final int EVENT_COUNTER_WIDTH = 10;
    private static final FilenameFilter EVENT_FILE_FILTER = new CrashlyticsReportPersistence$$ExternalSyntheticLambda1();
    private static final String EVENT_FILE_NAME_PREFIX = "event";
    private static final int EVENT_NAME_LENGTH = 15;
    private static final String EVENT_TYPE_ANR = "anr";
    private static final Comparator<? super File> LATEST_SESSION_ID_FIRST_COMPARATOR = new CrashlyticsReportPersistence$$ExternalSyntheticLambda0();
    private static final int MAX_OPEN_SESSIONS = 8;
    private static final String NATIVE_REPORTS_DIRECTORY = "native-reports";
    private static final String NORMAL_EVENT_SUFFIX = "";
    private static final String OPEN_SESSIONS_DIRECTORY_NAME = "sessions";
    private static final String PRIORITY_EVENT_SUFFIX = "_";
    private static final String PRIORITY_REPORTS_DIRECTORY = "priority-reports";
    private static final String REPORTS_DIRECTORY = "reports";
    private static final String REPORT_FILE_NAME = "report";
    private static final String SESSION_START_TIMESTAMP_FILE_NAME = "start-time";
    private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    private static final String USER_FILE_NAME = "user";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final String WORKING_DIRECTORY_NAME = "report-persistence";
    private final AtomicInteger eventCounter = new AtomicInteger(0);
    private final File nativeReportsDirectory;
    private final File openSessionsDirectory;
    private final File priorityReportsDirectory;
    private final File reportsDirectory;
    private final SettingsDataProvider settingsDataProvider;

    private static long convertTimestampFromSecondsToMs(long j) {
        return j * 1000;
    }

    public CrashlyticsReportPersistence(File file, SettingsDataProvider settingsDataProvider2) {
        File file2 = new File(file, WORKING_DIRECTORY_NAME);
        this.openSessionsDirectory = new File(file2, OPEN_SESSIONS_DIRECTORY_NAME);
        this.priorityReportsDirectory = new File(file2, PRIORITY_REPORTS_DIRECTORY);
        this.reportsDirectory = new File(file2, REPORTS_DIRECTORY);
        this.nativeReportsDirectory = new File(file2, NATIVE_REPORTS_DIRECTORY);
        this.settingsDataProvider = settingsDataProvider2;
    }

    public void persistReport(CrashlyticsReport crashlyticsReport) {
        CrashlyticsReport.Session session = crashlyticsReport.getSession();
        if (session == null) {
            Logger.getLogger().d("Could not get session for report");
            return;
        }
        String identifier = session.getIdentifier();
        try {
            File prepareDirectory = prepareDirectory(getSessionDirectoryById(identifier));
            writeTextFile(new File(prepareDirectory, REPORT_FILE_NAME), TRANSFORM.reportToJson(crashlyticsReport));
            writeTextFile(new File(prepareDirectory, SESSION_START_TIMESTAMP_FILE_NAME), "", session.getStartedAt());
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.d("Could not persist report for session " + identifier, e);
        }
    }

    public void persistEvent(CrashlyticsReport.Session.Event event, String str) {
        persistEvent(event, str, false);
    }

    public void persistEvent(CrashlyticsReport.Session.Event event, String str, boolean z) {
        int i = this.settingsDataProvider.getSettings().getSessionData().maxCustomExceptionEvents;
        File sessionDirectoryById = getSessionDirectoryById(str);
        try {
            writeTextFile(new File(sessionDirectoryById, generateEventFilename(this.eventCounter.getAndIncrement(), z)), TRANSFORM.eventToJson(event));
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.w("Could not persist event for session " + str, e);
        }
        trimEvents(sessionDirectoryById, i);
    }

    public void persistUserIdForSession(String str, String str2) {
        try {
            writeTextFile(new File(getSessionDirectoryById(str2), USER_FILE_NAME), str);
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.w("Could not persist user ID for session " + str2, e);
        }
    }

    public List<String> listSortedOpenSessionIds() {
        List<File> allFilesInDirectory = getAllFilesInDirectory(this.openSessionsDirectory);
        Collections.sort(allFilesInDirectory, LATEST_SESSION_ID_FIRST_COMPARATOR);
        ArrayList arrayList = new ArrayList();
        for (File name : allFilesInDirectory) {
            arrayList.add(name.getName());
        }
        return arrayList;
    }

    public long getStartTimestampMillis(String str) {
        return new File(getSessionDirectoryById(str), SESSION_START_TIMESTAMP_FILE_NAME).lastModified();
    }

    public boolean hasFinalizedReports() {
        return !getAllFinalizedReportFiles().isEmpty();
    }

    public void deleteAllReports() {
        for (File delete : getAllFinalizedReportFiles()) {
            delete.delete();
        }
    }

    public void deleteFinalizedReport(String str) {
        CrashlyticsReportPersistence$$ExternalSyntheticLambda4 crashlyticsReportPersistence$$ExternalSyntheticLambda4 = new CrashlyticsReportPersistence$$ExternalSyntheticLambda4(str);
        for (File delete : combineReportFiles(getFilesInDirectory(this.priorityReportsDirectory, (FilenameFilter) crashlyticsReportPersistence$$ExternalSyntheticLambda4), getFilesInDirectory(this.nativeReportsDirectory, (FilenameFilter) crashlyticsReportPersistence$$ExternalSyntheticLambda4), getFilesInDirectory(this.reportsDirectory, (FilenameFilter) crashlyticsReportPersistence$$ExternalSyntheticLambda4))) {
            delete.delete();
        }
    }

    public void finalizeReports(String str, long j) {
        for (File next : capAndGetOpenSessions(str)) {
            Logger logger = Logger.getLogger();
            logger.v("Finalizing report for session " + next.getName());
            synthesizeReport(next, j);
            recursiveDelete(next);
        }
        capFinalizedReports();
    }

    public void finalizeSessionWithNativeEvent(String str, CrashlyticsReport.FilesPayload filesPayload) {
        synthesizeNativeReportFile(new File(getSessionDirectoryById(str), REPORT_FILE_NAME), this.nativeReportsDirectory, filesPayload, str);
    }

    public List<CrashlyticsReportWithSessionId> loadFinalizedReports() {
        List<File> allFinalizedReportFiles = getAllFinalizedReportFiles();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(allFinalizedReportFiles.size());
        for (File next : getAllFinalizedReportFiles()) {
            try {
                arrayList.add(CrashlyticsReportWithSessionId.create(TRANSFORM.reportFromJson(readTextFile(next)), next.getName()));
            } catch (IOException e) {
                Logger logger = Logger.getLogger();
                logger.w("Could not load report file " + next + "; deleting", e);
                next.delete();
            }
        }
        return arrayList;
    }

    private List<File> capAndGetOpenSessions(String str) {
        List<File> filesInDirectory = getFilesInDirectory(this.openSessionsDirectory, (FileFilter) new CrashlyticsReportPersistence$$ExternalSyntheticLambda5(str));
        Collections.sort(filesInDirectory, LATEST_SESSION_ID_FIRST_COMPARATOR);
        if (filesInDirectory.size() <= 8) {
            return filesInDirectory;
        }
        for (File recursiveDelete : filesInDirectory.subList(8, filesInDirectory.size())) {
            recursiveDelete(recursiveDelete);
        }
        return filesInDirectory.subList(0, 8);
    }

    static /* synthetic */ boolean lambda$capAndGetOpenSessions$3(String str, File file) {
        return file.isDirectory() && !file.getName().equals(str);
    }

    private void capFinalizedReports() {
        int i = this.settingsDataProvider.getSettings().getSessionData().maxCompleteSessionsCount;
        List<File> allFinalizedReportFiles = getAllFinalizedReportFiles();
        int size = allFinalizedReportFiles.size();
        if (size > i) {
            for (File delete : allFinalizedReportFiles.subList(i, size)) {
                delete.delete();
            }
        }
    }

    private List<File> getAllFinalizedReportFiles() {
        return sortAndCombineReportFiles(combineReportFiles(getAllFilesInDirectory(this.priorityReportsDirectory), getAllFilesInDirectory(this.nativeReportsDirectory)), getAllFilesInDirectory(this.reportsDirectory));
    }

    private File getSessionDirectoryById(String str) {
        return new File(this.openSessionsDirectory, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void synthesizeReport(java.io.File r10, long r11) {
        /*
            r9 = this;
            java.io.FilenameFilter r0 = EVENT_FILE_FILTER
            java.util.List r0 = getFilesInDirectory((java.io.File) r10, (java.io.FilenameFilter) r0)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002b
            com.google.firebase.crashlytics.internal.Logger r11 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Session "
            r12.<init>(r0)
            java.lang.String r10 = r10.getName()
            r12.append(r10)
            java.lang.String r10 = " has no events."
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.v(r10)
            return
        L_0x002b:
            java.util.Collections.sort(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0038:
            r5 = r1
        L_0x0039:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0078
            java.lang.Object r3 = r0.next()
            java.io.File r3 = (java.io.File) r3
            com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform r4 = TRANSFORM     // Catch:{ IOException -> 0x0061 }
            java.lang.String r6 = readTextFile(r3)     // Catch:{ IOException -> 0x0061 }
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event r4 = r4.eventFromJson(r6)     // Catch:{ IOException -> 0x0061 }
            r2.add(r4)     // Catch:{ IOException -> 0x0061 }
            if (r5 != 0) goto L_0x005e
            java.lang.String r4 = r3.getName()     // Catch:{ IOException -> 0x0061 }
            boolean r3 = isHighPriorityEventFile(r4)     // Catch:{ IOException -> 0x0061 }
            if (r3 == 0) goto L_0x0038
        L_0x005e:
            r3 = 1
            r5 = r3
            goto L_0x0039
        L_0x0061:
            r4 = move-exception
            com.google.firebase.crashlytics.internal.Logger r6 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Could not add event to report for "
            r7.<init>(r8)
            r7.append(r3)
            java.lang.String r3 = r7.toString()
            r6.w(r3, r4)
            goto L_0x0039
        L_0x0078:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0098
            com.google.firebase.crashlytics.internal.Logger r11 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Could not parse event files for session "
            r12.<init>(r0)
            java.lang.String r10 = r10.getName()
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.w(r10)
            return
        L_0x0098:
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "user"
            r0.<init>(r10, r1)
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x00c4
            java.lang.String r0 = readTextFile(r0)     // Catch:{ IOException -> 0x00aa }
            goto L_0x00c5
        L_0x00aa:
            r0 = move-exception
            com.google.firebase.crashlytics.internal.Logger r1 = com.google.firebase.crashlytics.internal.Logger.getLogger()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Could not read user ID file in "
            r3.<init>(r4)
            java.lang.String r4 = r10.getName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r1.w(r3, r0)
        L_0x00c4:
            r0 = 0
        L_0x00c5:
            r6 = r0
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "report"
            r0.<init>(r10, r1)
            if (r5 == 0) goto L_0x00d2
            java.io.File r10 = r9.priorityReportsDirectory
            goto L_0x00d4
        L_0x00d2:
            java.io.File r10 = r9.reportsDirectory
        L_0x00d4:
            r1 = r10
            r3 = r11
            synthesizeReportFile(r0, r1, r2, r3, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence.synthesizeReport(java.io.File, long):void");
    }

    private static void synthesizeNativeReportFile(File file, File file2, CrashlyticsReport.FilesPayload filesPayload, String str) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = TRANSFORM;
            writeTextFile(new File(prepareDirectory(file2), str), crashlyticsReportJsonTransform.reportToJson(crashlyticsReportJsonTransform.reportFromJson(readTextFile(file)).withNdkPayload(filesPayload)));
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.w("Could not synthesize final native report file for " + file, e);
        }
    }

    private static void synthesizeReportFile(File file, File file2, List<CrashlyticsReport.Session.Event> list, long j, boolean z, String str) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = TRANSFORM;
            CrashlyticsReport withEvents = crashlyticsReportJsonTransform.reportFromJson(readTextFile(file)).withSessionEndFields(j, z, str).withEvents(ImmutableList.from(list));
            CrashlyticsReport.Session session = withEvents.getSession();
            if (session != null) {
                writeTextFile(new File(prepareDirectory(file2), session.getIdentifier()), crashlyticsReportJsonTransform.reportToJson(withEvents));
            }
        } catch (IOException e) {
            Logger logger = Logger.getLogger();
            logger.w("Could not synthesize final report file for " + file, e);
        }
    }

    private static List<File> sortAndCombineReportFiles(List<File>... listArr) {
        for (List<File> sort : listArr) {
            Collections.sort(sort, LATEST_SESSION_ID_FIRST_COMPARATOR);
        }
        return combineReportFiles(listArr);
    }

    private static List<File> combineReportFiles(List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (List<File> size : listArr) {
            i += size.size();
        }
        arrayList.ensureCapacity(i);
        for (List<File> addAll : listArr) {
            arrayList.addAll(addAll);
        }
        return arrayList;
    }

    private static boolean isHighPriorityEventFile(String str) {
        return str.startsWith("event") && str.endsWith(PRIORITY_EVENT_SUFFIX);
    }

    /* access modifiers changed from: private */
    public static boolean isNormalPriorityEventFile(File file, String str) {
        return str.startsWith("event") && !str.endsWith(PRIORITY_EVENT_SUFFIX);
    }

    private static String generateEventFilename(int i, boolean z) {
        String format = String.format(Locale.US, EVENT_COUNTER_FORMAT, new Object[]{Integer.valueOf(i)});
        String str = z ? PRIORITY_EVENT_SUFFIX : "";
        return "event" + format + str;
    }

    private static int trimEvents(File file, int i) {
        List<File> filesInDirectory = getFilesInDirectory(file, (FilenameFilter) new CrashlyticsReportPersistence$$ExternalSyntheticLambda2());
        Collections.sort(filesInDirectory, new CrashlyticsReportPersistence$$ExternalSyntheticLambda3());
        return capFilesCount(filesInDirectory, i);
    }

    private static String getEventNameWithoutPriority(String str) {
        return str.substring(0, EVENT_NAME_LENGTH);
    }

    /* access modifiers changed from: private */
    public static int oldestEventFileFirst(File file, File file2) {
        return getEventNameWithoutPriority(file.getName()).compareTo(getEventNameWithoutPriority(file2.getName()));
    }

    private static List<File> getAllFilesInDirectory(File file) {
        FileFilter fileFilter = null;
        return getFilesInDirectory(file, (FileFilter) null);
    }

    private static List<File> getFilesInDirectory(File file, FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    private static List<File> getFilesInDirectory(File file, FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    private static File prepareDirectory(File file) throws IOException {
        if (makeDirectory(file)) {
            return file;
        }
        throw new IOException("Could not create directory " + file);
    }

    private static boolean makeDirectory(File file) {
        return file.exists() || file.mkdirs();
    }

    private static void writeTextFile(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static void writeTextFile(File file, String str, long j) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), UTF_8);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(convertTimestampFromSecondsToMs(j));
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static String readTextFile(File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), UTF_8);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        throw th;
    }

    private static int capFilesCount(List<File> list, int i) {
        int size = list.size();
        for (File next : list) {
            if (size <= i) {
                return size;
            }
            recursiveDelete(next);
            size--;
        }
        return size;
    }

    private static void recursiveDelete(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                for (File recursiveDelete : file.listFiles()) {
                    recursiveDelete(recursiveDelete);
                }
            }
            file.delete();
        }
    }
}
