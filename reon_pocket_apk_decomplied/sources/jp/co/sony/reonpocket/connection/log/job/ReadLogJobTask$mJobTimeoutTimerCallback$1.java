package jp.co.sony.reonpocket.connection.log.job;

import java.util.TimerTask;
import jp.co.sony.reonpocket.connection.log.constant.LogJobResultCode;
import jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/util/TimerTask;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReadLogJobTask.kt */
final class ReadLogJobTask$mJobTimeoutTimerCallback$1 extends Lambda implements Function1<TimerTask, Unit> {
    final /* synthetic */ ReadLogJobTask this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReadLogJobTask$mJobTimeoutTimerCallback$1(ReadLogJobTask readLogJobTask) {
        super(1);
        this.this$0 = readLogJobTask;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TimerTask) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(TimerTask timerTask) {
        Intrinsics.checkNotNullParameter(timerTask, "$this$null");
        timerTask.cancel();
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        int jobId = this.this$0.aJobParameters.getJobId();
        long access$getMJobTimeout$p = (this.this$0.mJobTimeout / ((long) 1000)) / ((long) 60);
        debugLogUtil.w("AwsLog_ReadLogJobTask", "Job(ID:{" + jobId + "}) execute timeout(> " + access$getMJobTimeout$p + "min), try finish job");
        if (this.this$0.mRequestLogAction == ReadLogJobTask.RequestLogAction.START) {
            this.this$0.requestLog(ReadLogJobTask.RequestLogAction.STOP);
        } else {
            this.this$0.disconnect(LogJobResultCode.RESULT_FAIL_NORETRY.getCode());
        }
    }
}
