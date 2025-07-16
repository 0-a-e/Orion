package jp.co.sony.reonpocket.connection.log.job;

import android.app.job.JobParameters;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.PersistableBundle;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.File;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import jp.co.sony.reonpocket.connection.log.DeviceCommManager;
import jp.co.sony.reonpocket.connection.log.LogManager;
import jp.co.sony.reonpocket.connection.log.constant.LogContentTypeCode;
import jp.co.sony.reonpocket.connection.log.constant.LogJobResultCode;
import jp.co.sony.reonpocket.connection.log.constant.LogPartTagCode;
import jp.co.sony.reonpocket.connection.log.service.DeviceLogService;
import jp.co.sony.reonpocket.constant.GattProfileConstant;
import jp.co.sony.reonpocket.constant.ResponseCode;
import jp.co.sony.reonpocket.constant.SetOwnerIsLoginCode;
import jp.co.sony.reonpocket.data.entity.BleDataEntity;
import jp.co.sony.reonpocket.data.entity.Capability1$$ExternalSyntheticBackport0;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import jp.co.sony.reonpocket.util.MyContentUtil;
import jp.co.sony.reonpocket.util.SimpleStorageUtil;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000­\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\r\b\u0007\u0018\u0000 `2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0005`abcdB\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0002\u0010\bJ\u0014\u0010:\u001a\u00020;2\n\u0010<\u001a\u00020=\"\u00020\u0004H\u0002J\b\u0010>\u001a\u00020(H\u0002J\u0010\u0010?\u001a\u00020(2\u0006\u0010@\u001a\u00020\u0017H\u0002J\u0010\u0010A\u001a\u00020(2\u0006\u0010B\u001a\u00020\u0004H\u0002J!\u0010C\u001a\u00020\u00042\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020E\"\u00020\u0002H\u0014¢\u0006\u0002\u0010FJ\b\u0010G\u001a\u00020\nH\u0002J\u0010\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020\nH\u0002J\b\u0010J\u001a\u00020(H\u0002J\u0010\u0010K\u001a\u00020(2\u0006\u0010B\u001a\u00020\u0004H\u0002J\b\u0010L\u001a\u00020(H\u0002J\b\u0010M\u001a\u00020(H\u0002J\b\u0010N\u001a\u00020(H\u0014J\u0010\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010R\u001a\u00020(2\u0006\u0010B\u001a\u00020\u0004H\u0014J\b\u0010S\u001a\u00020(H\u0015J\u0018\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020\u00042\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010V\u001a\u00020(2\u0006\u0010P\u001a\u00020QH\u0003J\u0010\u0010W\u001a\u00020(2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010X\u001a\u00020(H\u0002J\u0010\u0010Y\u001a\u00020(2\u0006\u0010Z\u001a\u000205H\u0002J\u0010\u0010[\u001a\u00020(2\u0006\u0010\\\u001a\u00020\"H\u0002J\b\u0010]\u001a\u00020(H\u0002J\b\u0010^\u001a\u00020(H\u0003J\b\u0010_\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010%\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0&¢\u0006\u0002\b)X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u000607X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask;", "Landroid/os/AsyncTask;", "Landroid/app/job/JobParameters;", "Ljava/lang/Void;", "", "aService", "Ljp/co/sony/reonpocket/connection/log/service/DeviceLogService;", "aJobParameters", "(Ljp/co/sony/reonpocket/connection/log/service/DeviceLogService;Landroid/app/job/JobParameters;)V", "mAppVer", "", "mCharset", "mConnectCallbackListener", "jp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$mConnectCallbackListener$1", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$mConnectCallbackListener$1;", "mContext", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "mCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "mCurrentLogContentGroup", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogContentGroup;", "mCurrentLogInfo", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogInfo;", "mDateFormat", "Ljava/text/SimpleDateFormat;", "mDeviceManager", "Ljp/co/sony/reonpocket/connection/log/DeviceCommManager;", "mErrorCount", "mFWVer", "mGetLogWithTime", "", "Ljava/lang/Long;", "mJobInterrupt", "", "mJobResult", "mJobTimeout", "mJobTimeoutTimerCallback", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "mLastSequenceId", "Ljava/lang/Integer;", "mLogContentType", "Ljp/co/sony/reonpocket/connection/log/constant/LogContentTypeCode;", "mLogFilePath", "mLogNotifyEndTime", "mLogNotifyStartTime", "mLogTimeFormat", "mLostCount", "mOwnerId", "mRequestLogAction", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$RequestLogAction;", "mServiceReference", "Ljava/lang/ref/WeakReference;", "mTimeFormat", "mTimeoutTimerTask", "byteArrayOfInts", "", "ints", "", "connect", "createCSVFile", "aLogInfo", "disconnect", "aResult", "doInBackground", "params", "", "([Landroid/app/job/JobParameters;)Ljava/lang/Integer;", "getLogFilePath", "handleDataError", "aErrorMessage", "handleJobFailed", "handleJobFinish", "handleJobSuccess", "handleJobSuspended", "onCancelled", "onDataReceived", "aBleDataEntity", "Ljp/co/sony/reonpocket/data/entity/BleDataEntity;", "onPostExecute", "onPreExecute", "parseDataOfLogType", "aSequenceId", "parseFooter", "parseHeader", "registerDataCallbackListener", "requestLog", "aAction", "toggleLogNotify", "aIsEnable", "unregisterDataCallbackListener", "updateLogInfo", "writeOwner", "Companion", "LogContent", "LogContentGroup", "LogInfo", "RequestLogAction", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReadLogJobTask.kt */
public final class ReadLogJobTask extends AsyncTask<JobParameters, Void, Integer> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_CONTENTS_VERSION = "2.0";
    private static final String OS_IDENTIFIER = "android";
    private static final int SEQUENCE_ID_END = 254;
    private static final IntRange SEQUENCE_ID_RANGE = new IntRange(1, SEQUENCE_ID_END);
    private static final int SEQUENCE_ID_START = 1;
    private static final String TAG = "AwsLog_ReadLogJobTask";
    private static final IntRange UNKNOWN_ACTIVITY_RANGE = new IntRange(16, 28);
    /* access modifiers changed from: private */
    public final JobParameters aJobParameters;
    private final DeviceLogService aService;
    private String mAppVer;
    private String mCharset;
    private final ReadLogJobTask$mConnectCallbackListener$1 mConnectCallbackListener = new ReadLogJobTask$mConnectCallbackListener$1(this);
    private final Context mContext;
    private final CountDownLatch mCountDownLatch = new CountDownLatch(1);
    private LogContentGroup mCurrentLogContentGroup;
    private LogInfo mCurrentLogInfo;
    private final SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
    private final DeviceCommManager mDeviceManager = new DeviceCommManager();
    private int mErrorCount;
    private String mFWVer;
    private Long mGetLogWithTime;
    /* access modifiers changed from: private */
    public boolean mJobInterrupt;
    private int mJobResult = LogJobResultCode.RESULT_FAIL_RETRY.getCode();
    /* access modifiers changed from: private */
    public long mJobTimeout;
    private Function1<? super TimerTask, Unit> mJobTimeoutTimerCallback = new ReadLogJobTask$mJobTimeoutTimerCallback$1(this);
    private Integer mLastSequenceId;
    private LogContentTypeCode mLogContentType;
    private String mLogFilePath;
    private long mLogNotifyEndTime;
    private long mLogNotifyStartTime;
    private SimpleDateFormat mLogTimeFormat;
    private int mLostCount;
    private String mOwnerId;
    /* access modifiers changed from: private */
    public RequestLogAction mRequestLogAction = RequestLogAction.NONE;
    private final WeakReference<DeviceLogService> mServiceReference;
    private final SimpleDateFormat mTimeFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.getDefault());
    private TimerTask mTimeoutTimerTask;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReadLogJobTask.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        static {
            /*
                jp.co.sony.reonpocket.connection.log.constant.LogContentTypeCode[] r0 = jp.co.sony.reonpocket.connection.log.constant.LogContentTypeCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                jp.co.sony.reonpocket.connection.log.constant.LogContentTypeCode r2 = jp.co.sony.reonpocket.connection.log.constant.LogContentTypeCode.LOG     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                $EnumSwitchMapping$0 = r0
                jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask$RequestLogAction[] r0 = jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask.RequestLogAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask$RequestLogAction r2 = jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask.RequestLogAction.START     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask$RequestLogAction r1 = jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask.RequestLogAction.STOP     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask.WhenMappings.<clinit>():void");
        }
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute(((Number) obj).intValue());
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$Companion;", "", "()V", "LOG_CONTENTS_VERSION", "", "OS_IDENTIFIER", "SEQUENCE_ID_END", "", "SEQUENCE_ID_RANGE", "Lkotlin/ranges/IntRange;", "SEQUENCE_ID_START", "TAG", "UNKNOWN_ACTIVITY_RANGE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReadLogJobTask.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ReadLogJobTask(DeviceLogService deviceLogService, JobParameters jobParameters) {
        Intrinsics.checkNotNullParameter(deviceLogService, "aService");
        Intrinsics.checkNotNullParameter(jobParameters, "aJobParameters");
        this.aService = deviceLogService;
        this.aJobParameters = jobParameters;
        this.mServiceReference = new WeakReference<>(deviceLogService);
        this.mContext = deviceLogService.getApplicationContext();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$RequestLogAction;", "", "code", "", "(Ljava/lang/String;II)V", "getCode", "()I", "STOP", "START", "NONE", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReadLogJobTask.kt */
    private enum RequestLogAction {
        STOP(0),
        START(1),
        NONE(2);
        
        private final int code;

        public static EnumEntries<RequestLogAction> getEntries() {
            return $ENTRIES;
        }

        private RequestLogAction(int i) {
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }

        static {
            RequestLogAction[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated(message = "Deprecated in Java")
    public void onPreExecute() {
        super.onPreExecute();
        MyContentUtil myContentUtil = MyContentUtil.INSTANCE;
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        if (MyContentUtil.isSupportLog$default(myContentUtil, context, (String) null, 2, (Object) null)) {
            updateLogInfo();
        }
    }

    private final void updateLogInfo() {
        SimpleDateFormat simpleDateFormat;
        this.mJobInterrupt = false;
        if (Build.VERSION.SDK_INT >= 24) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ");
        }
        this.mLogTimeFormat = simpleDateFormat;
        Intrinsics.checkNotNull(simpleDateFormat);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        PersistableBundle extras = this.aJobParameters.getExtras();
        Intrinsics.checkNotNullExpressionValue(extras, "getExtras(...)");
        if (extras.containsKey(LogManager.KEY_JOB_TIMEOUT)) {
            this.mJobTimeout = extras.getLong(LogManager.KEY_JOB_TIMEOUT);
            Timer timer = new Timer();
            long j = this.mJobTimeout;
            TimerTask readLogJobTask$updateLogInfo$$inlined$schedule$1 = new ReadLogJobTask$updateLogInfo$$inlined$schedule$1(this.mJobTimeoutTimerCallback);
            timer.schedule(readLogJobTask$updateLogInfo$$inlined$schedule$1, j, j);
            this.mTimeoutTimerTask = readLogJobTask$updateLogInfo$$inlined$schedule$1;
        }
        this.mOwnerId = extras.getString(LogManager.KEY_OWNER_ID);
        this.mFWVer = extras.getString(LogManager.KEY_FW_VERSION);
        this.mAppVer = extras.getString(LogManager.KEY_VERSION_NAME);
        this.mCharset = extras.getString(LogManager.KEY_CHARSET);
        this.mGetLogWithTime = Long.valueOf(extras.getLong(LogManager.KEY_GET_LOG_UNIX_TIME));
        SimpleStorageUtil simpleStorageUtil = SimpleStorageUtil.INSTANCE;
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        String stringValue = simpleStorageUtil.getStringValue(context, SimpleStorageUtil.REON_LOG_UNIX_TIME);
        CharSequence charSequence = stringValue;
        if (!(charSequence == null || charSequence.length() == 0)) {
            this.mGetLogWithTime = Long.valueOf(Long.parseLong(stringValue) + 1);
        }
        this.mCurrentLogInfo = new LogInfo();
    }

    /* access modifiers changed from: protected */
    public Integer doInBackground(JobParameters... jobParametersArr) {
        Intrinsics.checkNotNullParameter(jobParametersArr, "params");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        int jobId = this.aJobParameters.getJobId();
        debugLogUtil.d(TAG, "Start job(ID:" + jobId + ")");
        try {
            connect();
            this.mCountDownLatch.await();
            DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
            int jobId2 = this.aJobParameters.getJobId();
            debugLogUtil2.d(TAG, "End job(ID:" + jobId2 + ")");
        } catch (InterruptedException unused) {
            DebugLogUtil debugLogUtil3 = DebugLogUtil.INSTANCE;
            int jobId3 = this.aJobParameters.getJobId();
            debugLogUtil3.w(TAG, "Job(ID:" + jobId3 + ") is interrupted");
            this.mJobInterrupt = true;
            if (this.mRequestLogAction == RequestLogAction.START) {
                requestLog(RequestLogAction.STOP);
            } else {
                disconnect(LogJobResultCode.RESULT_FAIL_NORETRY.getCode());
            }
        }
        return Integer.valueOf(this.mJobResult);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(int i) {
        DeviceLogService deviceLogService = (DeviceLogService) this.mServiceReference.get();
        if (deviceLogService != null) {
            deviceLogService.onJobFinished(this.aJobParameters, i);
        }
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        super.onCancelled();
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        int jobId = this.aJobParameters.getJobId();
        debugLogUtil.d(TAG, "Cancel job(ID:" + jobId + ")");
    }

    private final void connect() {
        DeviceCommManager deviceCommManager = this.mDeviceManager;
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        deviceCommManager.connect(context, this.mConnectCallbackListener);
    }

    /* access modifiers changed from: private */
    public final void disconnect(int i) {
        if (!this.mDeviceManager.disconnect()) {
            handleJobFinish(i);
        }
    }

    /* access modifiers changed from: private */
    public final void registerDataCallbackListener() {
        this.mDeviceManager.setMDataReceivedCallbackListener(new ReadLogJobTask$registerDataCallbackListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void unregisterDataCallbackListener() {
        this.mDeviceManager.setMDataReceivedCallbackListener((Function1<? super BleDataEntity, Unit>) null);
    }

    /* access modifiers changed from: private */
    public final void writeOwner() {
        List<String> list;
        SimpleStorageUtil simpleStorageUtil = SimpleStorageUtil.INSTANCE;
        Context context = this.mContext;
        Intrinsics.checkNotNullExpressionValue(context, "mContext");
        String stringValue = simpleStorageUtil.getStringValue(context, SimpleStorageUtil.REON_OWNER_ID);
        if (stringValue != null) {
            list = new Regex("\\s+").split(stringValue, 0);
        } else {
            list = null;
        }
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d(TAG, "ownerId: " + stringValue);
        List mutableListOf = CollectionsKt.mutableListOf(Byte.valueOf((byte) SetOwnerIsLoginCode.LOGIN_STATE_TRUE.getCode()));
        if (list != null) {
            for (String next : list) {
                if (next.length() > 0 && !Intrinsics.areEqual((Object) next, (Object) " ")) {
                    mutableListOf.add(Byte.valueOf((byte) Integer.parseInt(next)));
                }
            }
        }
        this.mDeviceManager.write(GattProfileConstant.SERVICE_DEVICE_CONTROL, GattProfileConstant.CHARACTERISTIC_OWNER, CollectionsKt.toByteArray(mutableListOf));
    }

    private final void toggleLogNotify(boolean z) {
        this.mDeviceManager.setNotification(GattProfileConstant.SERVICE_DEVICE_CONTROL, GattProfileConstant.CHARACTERISTIC_LOG_NOTIFY_DATA, z);
    }

    /* access modifiers changed from: private */
    public final void requestLog(RequestLogAction requestLogAction) {
        this.mLostCount = 0;
        this.mErrorCount = 0;
        if (requestLogAction == RequestLogAction.START) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            SimpleDateFormat simpleDateFormat = this.mLogTimeFormat;
            Intrinsics.checkNotNull(simpleDateFormat);
            Long l = this.mGetLogWithTime;
            Intrinsics.checkNotNull(l);
            String format = simpleDateFormat.format(new Date(l.longValue() * ((long) 1000)));
            debugLogUtil.i(TAG, "Request get log data with(time:" + format + ")");
        }
        this.mRequestLogAction = requestLogAction;
        byte[] createWriteBytes$default = BleDataEntity.Companion.createWriteBytes$default(BleDataEntity.Companion, requestLogAction.getCode(), 17, (ByteOrder) null, 4, (Object) null);
        BleDataEntity.Companion companion = BleDataEntity.Companion;
        Long l2 = this.mGetLogWithTime;
        Intrinsics.checkNotNull(l2);
        byte[] createWriteBytes$default2 = BleDataEntity.Companion.createWriteBytes$default(companion, (int) l2.longValue(), 20, (ByteOrder) null, 4, (Object) null);
        this.mDeviceManager.write(GattProfileConstant.SERVICE_DEVICE_CONTROL, GattProfileConstant.CHARACTERISTIC_REQUEST_LOG, ArraysKt.plus(ArraysKt.plus(createWriteBytes$default, createWriteBytes$default2), byteArrayOfInts(255, 255, 255, 255)));
    }

    private final byte[] byteArrayOfInts(int... iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    /* access modifiers changed from: private */
    public final void handleJobSuccess() {
        handleJobFinish(LogJobResultCode.RESULT_SUCCESS.getCode());
    }

    /* access modifiers changed from: private */
    public final void handleJobFailed() {
        handleJobFinish(LogJobResultCode.RESULT_FAIL_RETRY.getCode());
    }

    /* access modifiers changed from: private */
    public final void handleJobSuspended() {
        handleJobFinish(LogJobResultCode.RESULT_FAIL_NORETRY.getCode());
    }

    private final void handleJobFinish(int i) {
        LogInfo logInfo = this.mCurrentLogInfo;
        if (logInfo != null) {
            if (!logInfo.getMContentGroupList().isEmpty()) {
                createCSVFile(logInfo);
            } else {
                DebugLogUtil.INSTANCE.w(TAG, "Log data isn't exist");
            }
        }
        this.mJobResult = i;
        this.mCountDownLatch.countDown();
        TimerTask timerTask = this.mTimeoutTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:23|24|47) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE.e(TAG, "Write log to csv file, failed");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00cd */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void createCSVFile(jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask.LogInfo r25) {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "AwsLog_ReadLogJobTask"
            jp.co.sony.reonpocket.connection.log.BGLogManager r2 = new jp.co.sony.reonpocket.connection.log.BGLogManager
            r2.<init>()
            java.lang.String r3 = r24.getLogFilePath()
            r1.mLogFilePath = r3
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r1.mLogFilePath
            r3.<init>(r4)
            java.lang.String r4 = r1.mCharset
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)
            java.lang.String r5 = "forName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.io.OutputStreamWriter r5 = new java.io.OutputStreamWriter
            java.io.FileOutputStream r6 = new java.io.FileOutputStream
            r6.<init>(r3)
            java.io.OutputStream r6 = (java.io.OutputStream) r6
            r5.<init>(r6, r4)
            java.io.Writer r5 = (java.io.Writer) r5
            boolean r3 = r5 instanceof java.io.BufferedWriter
            if (r3 == 0) goto L_0x0036
            java.io.BufferedWriter r5 = (java.io.BufferedWriter) r5
            goto L_0x003e
        L_0x0036:
            java.io.BufferedWriter r3 = new java.io.BufferedWriter
            r4 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r5, r4)
            r5 = r3
        L_0x003e:
            java.io.Closeable r5 = (java.io.Closeable) r5
            r3 = r5
            java.io.BufferedWriter r3 = (java.io.BufferedWriter) r3     // Catch:{ all -> 0x0111 }
            jp.co.sony.reonpocket.util.DebugLogUtil r4 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE     // Catch:{ all -> 0x0111 }
            java.lang.String r6 = "Start create CSV file"
            r4.d((java.lang.String) r0, (java.lang.String) r6)     // Catch:{ all -> 0x0111 }
            jp.co.sony.reonpocket.connection.log.csv.LogWriter r4 = new jp.co.sony.reonpocket.connection.log.csv.LogWriter     // Catch:{ all -> 0x0111 }
            java.io.Writer r3 = (java.io.Writer) r3     // Catch:{ all -> 0x0111 }
            r4.<init>(r3)     // Catch:{ all -> 0x0111 }
            java.util.ArrayList r3 = r25.getMContentGroupList()     // Catch:{ all -> 0x0111 }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x0111 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0111 }
            r6 = 0
            r7 = 0
            r8 = r6
            r9 = r7
        L_0x005f:
            boolean r10 = r3.hasNext()     // Catch:{ all -> 0x0111 }
            if (r10 == 0) goto L_0x00d8
            java.lang.Object r10 = r3.next()     // Catch:{ all -> 0x0111 }
            int r11 = r8 + 1
            if (r8 >= 0) goto L_0x0070
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ all -> 0x0111 }
        L_0x0070:
            jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask$LogContentGroup r10 = (jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask.LogContentGroup) r10     // Catch:{ all -> 0x0111 }
            java.util.ArrayList r8 = r10.getMContentList()     // Catch:{ all -> 0x0111 }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ all -> 0x0111 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0111 }
            r10 = r6
        L_0x007d:
            boolean r12 = r8.hasNext()     // Catch:{ all -> 0x0111 }
            if (r12 == 0) goto L_0x00d6
            java.lang.Object r12 = r8.next()     // Catch:{ all -> 0x0111 }
            int r13 = r10 + 1
            if (r10 >= 0) goto L_0x008e
            kotlin.collections.CollectionsKt.throwIndexOverflow()     // Catch:{ all -> 0x0111 }
        L_0x008e:
            jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask$LogContent r12 = (jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask.LogContent) r12     // Catch:{ all -> 0x0111 }
            jp.co.sony.reonpocket.connection.log.entity.LogEntity r10 = r2.createLogEntity(r12)     // Catch:{ all -> 0x0111 }
            jp.co.sony.reonpocket.data.entity.BleDataEntity r23 = new jp.co.sony.reonpocket.data.entity.BleDataEntity     // Catch:{ all -> 0x0111 }
            jp.co.sony.reonpocket.constant.BleActionCode r15 = jp.co.sony.reonpocket.constant.BleActionCode.READ     // Catch:{ all -> 0x0111 }
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            byte[] r18 = r12.getMInfo()     // Catch:{ all -> 0x0111 }
            r21 = 48
            r22 = 0
            r19 = 0
            r20 = 0
            r14 = r23
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ all -> 0x0111 }
            java.nio.ByteOrder r12 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ all -> 0x0111 }
            java.lang.String r14 = "LITTLE_ENDIAN"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r14)     // Catch:{ all -> 0x0111 }
            r19 = 4
            r20 = 0
            r15 = 20
            r16 = 0
            r17 = 0
            r14 = r23
            r18 = r12
            java.lang.Long r12 = jp.co.sony.reonpocket.data.entity.BleDataEntity.getLongValue$default(r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0111 }
            if (r10 == 0) goto L_0x00d4
            r4.write(r10)     // Catch:{ Exception -> 0x00cd }
            r9 = r12
            goto L_0x00d4
        L_0x00cd:
            jp.co.sony.reonpocket.util.DebugLogUtil r10 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE     // Catch:{ all -> 0x0111 }
            java.lang.String r12 = "Write log to csv file, failed"
            r10.e(r0, r12)     // Catch:{ all -> 0x0111 }
        L_0x00d4:
            r10 = r13
            goto L_0x007d
        L_0x00d6:
            r8 = r11
            goto L_0x005f
        L_0x00d8:
            jp.co.sony.reonpocket.util.DebugLogUtil r2 = jp.co.sony.reonpocket.util.DebugLogUtil.INSTANCE     // Catch:{ all -> 0x0111 }
            java.lang.String r3 = "End create CSV file"
            r2.d((java.lang.String) r0, (java.lang.String) r3)     // Catch:{ all -> 0x0111 }
            java.lang.String r0 = "reon_log_unix_time"
            java.lang.String r2 = "mContext"
            if (r9 == 0) goto L_0x00fc
            java.lang.Number r9 = (java.lang.Number) r9     // Catch:{ all -> 0x0111 }
            long r3 = r9.longValue()     // Catch:{ all -> 0x0111 }
            jp.co.sony.reonpocket.util.SimpleStorageUtil r6 = jp.co.sony.reonpocket.util.SimpleStorageUtil.INSTANCE     // Catch:{ all -> 0x0111 }
            android.content.Context r8 = r1.mContext     // Catch:{ all -> 0x0111 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)     // Catch:{ all -> 0x0111 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0111 }
            r6.setStringValue(r8, r0, r3)     // Catch:{ all -> 0x0111 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0111 }
            goto L_0x00fd
        L_0x00fc:
            r3 = r7
        L_0x00fd:
            if (r3 != 0) goto L_0x010b
            jp.co.sony.reonpocket.util.SimpleStorageUtil r3 = jp.co.sony.reonpocket.util.SimpleStorageUtil.INSTANCE     // Catch:{ all -> 0x0111 }
            android.content.Context r4 = r1.mContext     // Catch:{ all -> 0x0111 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)     // Catch:{ all -> 0x0111 }
            java.lang.String r2 = ""
            r3.setStringValue(r4, r0, r2)     // Catch:{ all -> 0x0111 }
        L_0x010b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0111 }
            kotlin.io.CloseableKt.closeFinally(r5, r7)
            return
        L_0x0111:
            r0 = move-exception
            r2 = r0
            throw r2     // Catch:{ all -> 0x0114 }
        L_0x0114:
            r0 = move-exception
            r3 = r0
            kotlin.io.CloseableKt.closeFinally(r5, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask.createCSVFile(jp.co.sony.reonpocket.connection.log.job.ReadLogJobTask$LogInfo):void");
    }

    private final String getLogFilePath() {
        String str;
        String str2;
        String string = this.aJobParameters.getExtras().getString(LogManager.KEY_LOG_DIR);
        File file = string != null ? new File(string) : null;
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        String format = this.mDateFormat.format(new Date());
        String str3 = this.mOwnerId;
        Intrinsics.checkNotNull(str3);
        if (StringsKt.contains$default((CharSequence) str3, (CharSequence) ":", false, 2, (Object) null)) {
            String str4 = this.mOwnerId;
            Intrinsics.checkNotNull(str4);
            str = (String) StringsKt.split$default((CharSequence) str4, new String[]{":"}, false, 0, 6, (Object) null).get(1);
        } else {
            str = this.mOwnerId;
            Intrinsics.checkNotNull(str);
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bytes = String.valueOf(System.currentTimeMillis()).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] digest = instance.digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            str2 = String.format("%040x", new Object[]{new BigInteger(1, digest)});
        } catch (Exception unused) {
            DebugLogUtil.INSTANCE.e(TAG, "create hash value failed");
            str2 = String.format("%040x", new Object[]{Integer.valueOf(Capability1$$ExternalSyntheticBackport0.m(System.currentTimeMillis()))});
        }
        String str5 = format + "_" + str + "_" + str2 + "_android.csv";
        return string + File.separator + str5;
    }

    /* access modifiers changed from: private */
    public final void onDataReceived(BleDataEntity bleDataEntity) {
        LogPartTagCode logPartTagCode;
        if (bleDataEntity.getResult()) {
            String characteristicUuid = bleDataEntity.getCharacteristicUuid();
            switch (characteristicUuid.hashCode()) {
                case 1512277:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_OWNER)) {
                        toggleLogNotify(true);
                        return;
                    }
                    return;
                case 1513778:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_REQUEST_LOG)) {
                        int i = WhenMappings.$EnumSwitchMapping$1[this.mRequestLogAction.ordinal()];
                        if (i == 1) {
                            DebugLogUtil.INSTANCE.d(TAG, "request start send log success");
                            return;
                        } else if (i == 2) {
                            DebugLogUtil.INSTANCE.d(TAG, "request stop send log success");
                            disconnect(LogJobResultCode.RESULT_SUCCESS.getCode());
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 1513779:
                    if (characteristicUuid.equals(GattProfileConstant.CHARACTERISTIC_LOG_NOTIFY_DATA)) {
                        if (bleDataEntity.getData() == null) {
                            requestLog(RequestLogAction.START);
                            return;
                        }
                        Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 0, (ByteOrder) null, 4, (Object) null);
                        if (intValue$default != null) {
                            intValue$default.intValue();
                            LogPartTagCode[] values = LogPartTagCode.values();
                            int length = values.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 < length) {
                                    logPartTagCode = values[i2];
                                    int code = logPartTagCode.getCode();
                                    if (intValue$default == null || code != intValue$default.intValue()) {
                                        i2++;
                                    }
                                } else {
                                    logPartTagCode = null;
                                }
                            }
                            if (logPartTagCode != null) {
                                int intValue = intValue$default.intValue();
                                if (intValue == LogPartTagCode.HEADER.getCode()) {
                                    parseHeader(bleDataEntity);
                                    return;
                                } else if (intValue == LogPartTagCode.FOOTER.getCode()) {
                                    parseFooter(bleDataEntity);
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                LogContentTypeCode logContentTypeCode = this.mLogContentType;
                                if (logContentTypeCode == null) {
                                    DebugLogUtil.INSTANCE.e(TAG, "log's content type is null");
                                    return;
                                } else if (!SEQUENCE_ID_RANGE.contains(intValue$default.intValue())) {
                                    DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
                                    debugLogUtil.e(TAG, "sequenceId(" + intValue$default + ") is error");
                                    return;
                                } else if (WhenMappings.$EnumSwitchMapping$0[logContentTypeCode.ordinal()] == 1) {
                                    parseDataOfLogType(intValue$default.intValue(), bleDataEntity);
                                    return;
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            }
                        } else {
                            handleDataError("packet type is null");
                            return;
                        }
                    } else {
                        return;
                    }
                default:
                    return;
            }
        } else {
            String characteristicUuid2 = bleDataEntity.getCharacteristicUuid();
            switch (characteristicUuid2.hashCode()) {
                case 1512277:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_OWNER)) {
                        if (bleDataEntity.getResponseCode() == ResponseCode.INVALID_STATE) {
                            handleDataError("device already has another owner");
                            return;
                        } else {
                            handleDataError("set owner");
                            return;
                        }
                    }
                    break;
                case 1513778:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_REQUEST_LOG)) {
                        int i3 = WhenMappings.$EnumSwitchMapping$1[this.mRequestLogAction.ordinal()];
                        if (i3 == 1) {
                            handleDataError("request start send log failed");
                            return;
                        } else if (i3 == 2) {
                            DebugLogUtil.INSTANCE.d(TAG, "request stop send log failed");
                            disconnect(LogJobResultCode.RESULT_FAIL_NORETRY.getCode());
                            return;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1513779:
                    if (characteristicUuid2.equals(GattProfileConstant.CHARACTERISTIC_LOG_NOTIFY_DATA)) {
                        handleDataError("log notify");
                        return;
                    }
                    break;
            }
            handleDataError("other error");
        }
    }

    private final void handleDataError(String str) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.e(TAG, "data error:" + str);
        if (this.mRequestLogAction == RequestLogAction.START) {
            requestLog(RequestLogAction.STOP);
        } else {
            disconnect(LogJobResultCode.RESULT_FAIL_NORETRY.getCode());
        }
    }

    private final void parseHeader(BleDataEntity bleDataEntity) {
        Unit unit;
        LogContentTypeCode logContentTypeCode;
        Unit unit2;
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        byte[] data = bleDataEntity.getData();
        Intrinsics.checkNotNull(data);
        String arrays = Arrays.toString(data);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(...)");
        debugLogUtil.d(TAG, "header data: " + arrays);
        this.mLogNotifyStartTime = System.currentTimeMillis();
        LogContentTypeCode[] values = LogContentTypeCode.values();
        int length = values.length;
        int i = 0;
        while (true) {
            unit = null;
            if (i >= length) {
                logContentTypeCode = null;
                break;
            }
            logContentTypeCode = values[i];
            int code = logContentTypeCode.getCode();
            Integer intValue$default = BleDataEntity.getIntValue$default(bleDataEntity, 17, 1, (ByteOrder) null, 4, (Object) null);
            if (intValue$default != null && code == intValue$default.intValue()) {
                break;
            }
            i++;
        }
        if (logContentTypeCode != null) {
            this.mLogContentType = logContentTypeCode;
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            handleDataError("log content type error");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        Intrinsics.checkNotNullExpressionValue(byteOrder, "LITTLE_ENDIAN");
        Integer intValue = bleDataEntity.getIntValue(18, 2, byteOrder);
        if (intValue != null) {
            String binaryString = Integer.toBinaryString(intValue.intValue());
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(...)");
            String padStart = StringsKt.padStart(binaryString, 16, '0');
            try {
                int parseInt = Integer.parseInt(StringsKt.substring(padStart, new IntRange(8, 15)), CharsKt.checkRadix(2));
                int parseInt2 = Integer.parseInt(StringsKt.substring(padStart, new IntRange(0, 7)), CharsKt.checkRadix(2));
                DebugLogUtil.INSTANCE.d(TAG, "log content version: " + parseInt2 + InstructionFileId.DOT + parseInt);
                if (!Intrinsics.areEqual((Object) parseInt2 + InstructionFileId.DOT + parseInt, (Object) LOG_CONTENTS_VERSION)) {
                    requestLog(RequestLogAction.STOP);
                }
            } catch (NumberFormatException unused) {
                handleDataError("log content version error");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            handleDataError("log content version error");
        }
    }

    private final void parseDataOfLogType(int i, BleDataEntity bleDataEntity) {
        Unit unit;
        ArrayList<LogContent> mContentList;
        ArrayList<LogContentGroup> mContentGroupList;
        if (i == 1) {
            LogContentGroup logContentGroup = new LogContentGroup();
            this.mCurrentLogContentGroup = logContentGroup;
            logContentGroup.setMSequenceStartId(true);
        } else if (i == SEQUENCE_ID_END) {
            LogContentGroup logContentGroup2 = this.mCurrentLogContentGroup;
            if (logContentGroup2 != null) {
                logContentGroup2.setMSequenceEndId(true);
            }
            LogInfo logInfo = this.mCurrentLogInfo;
            if (!(logInfo == null || (mContentGroupList = logInfo.getMContentGroupList()) == null)) {
                LogContentGroup logContentGroup3 = this.mCurrentLogContentGroup;
                Intrinsics.checkNotNull(logContentGroup3);
                mContentGroupList.add(logContentGroup3);
            }
        }
        Integer num = this.mLastSequenceId;
        byte[] bArr = null;
        if (num != null) {
            int intValue = num.intValue();
            if (intValue != SEQUENCE_ID_END) {
                int abs = Math.abs(i - intValue);
                if (!(abs == 0 || abs == 1)) {
                    this.mLostCount += abs;
                }
            } else if (!(i == SEQUENCE_ID_END || i == 1)) {
                this.mLostCount += i - 1;
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null && i != 1) {
            this.mLostCount += i - 1;
        }
        this.mLastSequenceId = Integer.valueOf(i);
        LogContent logContent = new LogContent();
        logContent.setMSequenceId(Integer.valueOf(i));
        byte[] data = bleDataEntity.getData();
        if (data != null) {
            bArr = ArraysKt.copyOfRange(data, 1, bleDataEntity.getData().length);
        }
        logContent.setMInfo(bArr);
        LogContentGroup logContentGroup4 = this.mCurrentLogContentGroup;
        if (logContentGroup4 != null && (mContentList = logContentGroup4.getMContentList()) != null) {
            mContentList.add(logContent);
        }
    }

    private final void parseFooter(BleDataEntity bleDataEntity) {
        ArrayList<LogContentGroup> mContentGroupList;
        LogContentGroup logContentGroup;
        LogInfo logInfo = this.mCurrentLogInfo;
        if (!(logInfo == null || (mContentGroupList = logInfo.getMContentGroupList()) == null || (logContentGroup = this.mCurrentLogContentGroup) == null || logContentGroup.getMDataFull())) {
            mContentGroupList.add(logContentGroup);
        }
        ULong r1 = bleDataEntity.m6988getULongValuewoJcscw(21, 1);
        if (r1 != null) {
            long r12 = r1.m7268unboximpl();
            LogInfo logInfo2 = this.mCurrentLogInfo;
            if (logInfo2 != null) {
                logInfo2.m6982setMTotalADd3fzo(ULong.m7210boximpl(r12));
            }
        }
        this.mLogNotifyEndTime = System.currentTimeMillis();
        LogInfo logInfo3 = this.mCurrentLogInfo;
        if (logInfo3 != null) {
            ULong r2 = logInfo3.m6981getMTotal6VbMDqA();
            long j = 0;
            long r5 = r2 != null ? r2.m7268unboximpl() : 0;
            int i = 0;
            for (Object next : logInfo3.getMContentGroupList()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                j = ULong.m7216constructorimpl(j + ULong.m7216constructorimpl(((long) UInt.m7137constructorimpl(((LogContentGroup) next).getMContentList().size())) & 4294967295L));
                i = i2;
            }
            long j2 = j;
            long j3 = r5;
            String str = "\n送信したコンテンツパケットの総数:" + ULong.m7262toStringimpl(r5) + " \r\n受信したコンテンツパケットの総数:" + ULong.m7262toStringimpl(j) + " \r\nデータがなくなった:" + this.mLostCount + " \r\nフッターがない回数:" + this.mErrorCount + " \r\n開始時間:" + this.mLogNotifyStartTime + " \r\n終了時間:" + this.mLogNotifyEndTime + " \r\n開始時間:" + this.mTimeFormat.format(new Date(this.mLogNotifyStartTime)) + "\r\n終了時間:" + this.mTimeFormat.format(new Date(this.mLogNotifyEndTime));
            if (j3 == j2) {
                DebugLogUtil.INSTANCE.i(TAG, str);
            } else {
                DebugLogUtil.INSTANCE.e(TAG, str);
            }
        }
        requestLog(RequestLogAction.STOP);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR,\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogInfo;", "", "()V", "mContentGroupList", "Ljava/util/ArrayList;", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogContentGroup;", "Lkotlin/collections/ArrayList;", "getMContentGroupList", "()Ljava/util/ArrayList;", "setMContentGroupList", "(Ljava/util/ArrayList;)V", "mTotal", "Lkotlin/ULong;", "getMTotal-6VbMDqA$annotations", "getMTotal-6VbMDqA", "()Lkotlin/ULong;", "setMTotal-ADd3fzo", "(Lkotlin/ULong;)V", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReadLogJobTask.kt */
    private static final class LogInfo {
        private ArrayList<LogContentGroup> mContentGroupList = new ArrayList<>();
        private ULong mTotal;

        /* renamed from: getMTotal-6VbMDqA$annotations  reason: not valid java name */
        public static /* synthetic */ void m6980getMTotal6VbMDqA$annotations() {
        }

        public final ArrayList<LogContentGroup> getMContentGroupList() {
            return this.mContentGroupList;
        }

        public final void setMContentGroupList(ArrayList<LogContentGroup> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.mContentGroupList = arrayList;
        }

        /* renamed from: getMTotal-6VbMDqA  reason: not valid java name */
        public final ULong m6981getMTotal6VbMDqA() {
            return this.mTotal;
        }

        /* renamed from: setMTotal-ADd3fzo  reason: not valid java name */
        public final void m6982setMTotalADd3fzo(ULong uLong) {
            this.mTotal = uLong;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000e\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogContentGroup;", "", "()V", "mContentList", "Ljava/util/ArrayList;", "Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogContent;", "Lkotlin/collections/ArrayList;", "getMContentList", "()Ljava/util/ArrayList;", "setMContentList", "(Ljava/util/ArrayList;)V", "mDataFull", "", "getMDataFull", "()Z", "mSequenceEndId", "getMSequenceEndId", "setMSequenceEndId", "(Z)V", "mSequenceStartId", "getMSequenceStartId", "setMSequenceStartId", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReadLogJobTask.kt */
    private static final class LogContentGroup {
        private ArrayList<LogContent> mContentList = new ArrayList<>();
        private boolean mSequenceEndId;
        private boolean mSequenceStartId;

        public final boolean getMSequenceStartId() {
            return this.mSequenceStartId;
        }

        public final void setMSequenceStartId(boolean z) {
            this.mSequenceStartId = z;
        }

        public final boolean getMSequenceEndId() {
            return this.mSequenceEndId;
        }

        public final void setMSequenceEndId(boolean z) {
            this.mSequenceEndId = z;
        }

        public final boolean getMDataFull() {
            return this.mSequenceStartId && this.mSequenceEndId;
        }

        public final ArrayList<LogContent> getMContentList() {
            return this.mContentList;
        }

        public final void setMContentList(ArrayList<LogContent> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.mContentList = arrayList;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/job/ReadLogJobTask$LogContent;", "", "()V", "mInfo", "", "getMInfo", "()[B", "setMInfo", "([B)V", "mSequenceId", "", "getMSequenceId", "()Ljava/lang/Integer;", "setMSequenceId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReadLogJobTask.kt */
    public static final class LogContent {
        public static final int $stable = 8;
        private byte[] mInfo;
        private Integer mSequenceId;

        public final Integer getMSequenceId() {
            return this.mSequenceId;
        }

        public final void setMSequenceId(Integer num) {
            this.mSequenceId = num;
        }

        public final byte[] getMInfo() {
            return this.mInfo;
        }

        public final void setMInfo(byte[] bArr) {
            this.mInfo = bArr;
        }
    }
}
