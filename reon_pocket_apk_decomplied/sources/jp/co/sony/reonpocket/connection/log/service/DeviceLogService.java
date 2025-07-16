package jp.co.sony.reonpocket.connection.log.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.collection.SimpleArrayMap;
import com.google.firebase.analytics.FirebaseAnalytics;
import jp.co.sony.reonpocket.connection.log.LogManager;
import jp.co.sony.reonpocket.connection.log.constant.LogJobResultCode;
import jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fH\u0016J\"\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ljp/co/sony/reonpocket/connection/log/service/DeviceLogService;", "Landroid/app/job/JobService;", "()V", "mRunningReadLogJobs", "Landroidx/collection/SimpleArrayMap;", "", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask;", "mSendMessenger", "Landroid/os/Messenger;", "convertResultStateToString", "", "aResultState", "onJobFinished", "", "aJobParameters", "Landroid/app/job/JobParameters;", "aJobResult", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "onStartJob", "", "params", "onStopJob", "sendMessageToClient", "aWhat", "aArg", "aBundle", "Landroid/os/Bundle;", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(message = "現在は使われていない。WorkManagerで置き換える必要があるが、まだ実装できていない。SCRUM-36を参照ください。")
/* compiled from: DeviceLogService.kt */
public final class DeviceLogService extends JobService {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MESSENGER_INTENT_KEY = "MESSENGER_INTENT_KEY";
    private static final String NOTIFICATION_CHANNEL_ID = "reon_pocket_channel_id";
    private static final String TAG = "AwsLog_DeviceLogService";
    private final SimpleArrayMap<Integer, ReadLogJobTask> mRunningReadLogJobs = new SimpleArrayMap<>(0, 1, (DefaultConstructorMarker) null);
    private Messenger mSendMessenger;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/service/DeviceLogService$Companion;", "", "()V", "MESSENGER_INTENT_KEY", "", "NOTIFICATION_CHANNEL_ID", "TAG", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceLogService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.mSendMessenger = (Messenger) intent.getParcelableExtra(MESSENGER_INTENT_KEY);
        return 2;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        Intrinsics.checkNotNullParameter(jobParameters, "params");
        ReadLogJobTask readLogJobTask = new ReadLogJobTask(this, jobParameters);
        synchronized (this.mRunningReadLogJobs) {
            ReadLogJobTask put = this.mRunningReadLogJobs.put(Integer.valueOf(jobParameters.getJobId()), readLogJobTask);
        }
        readLogJobTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JobParameters[]{jobParameters});
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        Intrinsics.checkNotNullParameter(jobParameters, "params");
        synchronized (this.mRunningReadLogJobs) {
            ReadLogJobTask remove = this.mRunningReadLogJobs.remove(Integer.valueOf(jobParameters.getJobId()));
            if (remove != null) {
                DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                int jobId = jobParameters.getJobId();
                debugLogUtil.w(TAG, "Job(ID:" + jobId + ") is cancelled, will retry");
                remove.cancel(true);
                return true;
            }
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            int jobId2 = jobParameters.getJobId();
            debugLogUtil2.d(TAG, "Job(ID:" + jobId2 + ") isn't exist");
            DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
            int jobId3 = jobParameters.getJobId();
            debugLogUtil3.d(TAG, "onStopJob(ID:" + jobId3 + "), wait next periodic\"");
            return false;
        }
    }

    public final void onJobFinished(JobParameters jobParameters, int i) {
        Intrinsics.checkNotNullParameter(jobParameters, "aJobParameters");
        synchronized (this.mRunningReadLogJobs) {
            ReadLogJobTask remove = this.mRunningReadLogJobs.remove(Integer.valueOf(jobParameters.getJobId()));
        }
        int i2 = 1;
        if (i == LogJobResultCode.RESULT_FAIL_RETRY.getCode()) {
            int i3 = jobParameters.getExtras().getInt(LogManager.KEY_FAILED_RETRY_COUNT);
            Context context = this;
            Integer intValue = SimpleStorageUtil.INSTANCE.getIntValue(context, SimpleStorageUtil.REON_READ_LOG_HAS_RETRY_COUNT);
            int intValue2 = intValue != null ? intValue.intValue() : 1;
            if (intValue2 == -1) {
                intValue2 = 1;
            }
            if (intValue2 < i3) {
                DebugLogUtil.INSTANCE.i(TAG, "Job(ID:" + jobParameters.getJobId() + ") is finished, result:failure(will retry, retry'count:" + intValue2 + ")");
                jobFinished(jobParameters, true);
                i2 = intValue2 + 1;
            } else {
                DebugLogUtil.INSTANCE.i(TAG, "Job(ID:" + jobParameters.getJobId() + ") is finished, result:failure(no retry), wait next periodic");
                jobFinished(jobParameters, false);
            }
            SimpleStorageUtil.INSTANCE.setIntValue(context, SimpleStorageUtil.REON_READ_LOG_HAS_RETRY_COUNT, i2);
            return;
        }
        DebugLogUtil.INSTANCE.i(TAG, "Job(ID:" + jobParameters.getJobId() + ") is finished, result:" + convertResultStateToString(i));
        SimpleStorageUtil.INSTANCE.setIntValue(this, SimpleStorageUtil.REON_READ_LOG_HAS_RETRY_COUNT, 1);
        jobFinished(jobParameters, false);
    }

    public static /* synthetic */ void sendMessageToClient$default(DeviceLogService deviceLogService, int i, int i2, Bundle bundle, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            bundle = null;
        }
        deviceLogService.sendMessageToClient(i, i2, bundle);
    }

    public final void sendMessageToClient(int i, int i2, Bundle bundle) {
        Messenger messenger = this.mSendMessenger;
        if (messenger != null) {
            Message obtain = Message.obtain((Handler) null, i, i2, 0);
            obtain.arg1 = i2;
            if (bundle != null) {
                obtain.setData(bundle);
            }
            try {
                messenger.send(obtain);
                Unit unit = Unit.INSTANCE;
            } catch (RemoteException e) {
                e.printStackTrace();
                Integer.valueOf(DebugLogUtil.INSTANCE.e(TAG, "Error passing service object back to activity."));
            }
        } else {
            DebugLogUtil.INSTANCE.d(TAG, "Service is bound, not started. There's no callback to send a message to.");
        }
    }

    private final String convertResultStateToString(int i) {
        if (i == LogJobResultCode.RESULT_SUCCESS.getCode()) {
            return FirebaseAnalytics.Param.SUCCESS;
        }
        if (i == LogJobResultCode.RESULT_FAIL_RETRY.getCode()) {
            return "failure(will retry)";
        }
        if (i == LogJobResultCode.RESULT_FAIL_NORETRY.getCode()) {
            return "failure(no retry)";
        }
        return String.valueOf(i);
    }
}
