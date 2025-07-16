package jp.co.sony.reonpocket.connection.log;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.util.Iterator;
import java.util.List;
import jp.co.sony.reonpocket.connection.log.job.UploadLogJobTask;
import jp.co.sony.reonpocket.connection.log.service.OnClearFromRecentService;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/LogManager;", "", "()V", "KEY_CHARSET", "", "KEY_FAILED_RETRY_COUNT", "KEY_FW_VERSION", "KEY_GET_LOG_UNIX_TIME", "KEY_JOB_TIMEOUT", "KEY_LOG_DIR", "KEY_OWNER_ID", "KEY_VERSION_NAME", "LOG_FOLDER", "READ_LOG_JOB_ID", "", "TAG", "checkReadLogJobRunStatus", "", "aContext", "Landroid/content/Context;", "createUploadLogJob", "", "finishReadLogJob", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogManager.kt */
public final class LogManager {
    public static final int $stable = 0;
    public static final LogManager INSTANCE = new LogManager();
    public static final String KEY_CHARSET = "key_charset";
    public static final String KEY_FAILED_RETRY_COUNT = "key_failed_retry_count";
    public static final String KEY_FW_VERSION = "key_fw_version";
    public static final String KEY_GET_LOG_UNIX_TIME = "key_get_log_unix_time";
    public static final String KEY_JOB_TIMEOUT = "key_job_timeout";
    public static final String KEY_LOG_DIR = "key_log_dir";
    public static final String KEY_OWNER_ID = "key_owner_id";
    public static final String KEY_VERSION_NAME = "key_version_name";
    private static final String LOG_FOLDER = "log";
    private static final int READ_LOG_JOB_ID = 1;
    private static final String TAG = "AwsLog_LogManager";

    private LogManager() {
    }

    public final void createUploadLogJob(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        try {
            context.startService(new Intent(context, OnClearFromRecentService.class));
        } catch (Exception unused) {
            DebugLogUtil.INSTANCE.e(TAG, "OnClearFromRecentService start error");
        }
        finishReadLogJob(context);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        new UploadLogJobTask(applicationContext).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{LOG_FOLDER});
    }

    public final boolean checkReadLogJobRunStatus(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Object systemService = context.getSystemService("jobscheduler");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        List<JobInfo> allPendingJobs = ((JobScheduler) systemService).getAllPendingJobs();
        Intrinsics.checkNotNullExpressionValue(allPendingJobs, "getAllPendingJobs(...)");
        if (allPendingJobs.size() > 0) {
            Iterator it = allPendingJobs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((JobInfo) obj).getId() == 1) {
                    break;
                }
            }
            JobInfo jobInfo = (JobInfo) obj;
            if (jobInfo != null) {
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                int id = jobInfo.getId();
                debugLogUtil.w(TAG, "Job(ID:" + id + ") is running");
                return true;
            }
        }
        return false;
    }

    private final void finishReadLogJob(Context context) {
        Object obj;
        Object systemService = context.getApplicationContext().getSystemService("jobscheduler");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.job.JobScheduler");
        JobScheduler jobScheduler = (JobScheduler) systemService;
        List<JobInfo> allPendingJobs = jobScheduler.getAllPendingJobs();
        Intrinsics.checkNotNullExpressionValue(allPendingJobs, "getAllPendingJobs(...)");
        if (allPendingJobs.size() > 0) {
            Iterator it = allPendingJobs.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((JobInfo) obj).getId() == 1) {
                    break;
                }
            }
            JobInfo jobInfo = (JobInfo) obj;
            if (jobInfo != null) {
                jobScheduler.cancel(jobInfo.getId());
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                int id = jobInfo.getId();
                debugLogUtil.d(TAG, "Job(ID:" + id + ") has cancelled");
                return;
            }
            return;
        }
        DebugLogUtil.INSTANCE.d(TAG, "No job");
    }
}
