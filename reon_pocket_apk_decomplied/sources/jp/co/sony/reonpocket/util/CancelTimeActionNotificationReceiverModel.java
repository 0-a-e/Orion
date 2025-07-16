package jp.co.sony.reonpocket.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import java.text.SimpleDateFormat;
import jp.co.sony.reonpocket.util.service.TimeActionNotificationReceiver;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0003\f\r\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/util/CancelTimeActionNotificationReceiverModel;", "", "aContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getAContext", "()Landroid/content/Context;", "alarmManager", "Landroid/app/AlarmManager;", "cancelNotification", "", "newInstance", "Companion", "StopCause", "StopCauseMode", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CancelTimeActionNotificationReceiverModel.kt */
public final class CancelTimeActionNotificationReceiverModel {
    public static final int $stable = 8;
    public static final String CHANNEL_ID = "jp.co.sony.reonpocket";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOTIFICATION_ID = 1;
    public static final int REQUEST_CODE = 0;
    /* access modifiers changed from: private */
    public static CancelTimeActionNotificationReceiverModel sInstance;
    private final Context aContext;
    private final AlarmManager alarmManager;

    public CancelTimeActionNotificationReceiverModel(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        this.aContext = context;
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        this.alarmManager = (AlarmManager) systemService;
    }

    public final Context getAContext() {
        return this.aContext;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Ljp/co/sony/reonpocket/util/CancelTimeActionNotificationReceiverModel$Companion;", "", "()V", "CHANNEL_ID", "", "NOTIFICATION_ID", "", "REQUEST_CODE", "sInstance", "Ljp/co/sony/reonpocket/util/CancelTimeActionNotificationReceiverModel;", "getSInstance", "()Ljp/co/sony/reonpocket/util/CancelTimeActionNotificationReceiverModel;", "setSInstance", "(Ljp/co/sony/reonpocket/util/CancelTimeActionNotificationReceiverModel;)V", "getInstance", "aContext", "Landroid/content/Context;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CancelTimeActionNotificationReceiverModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CancelTimeActionNotificationReceiverModel getSInstance() {
            return CancelTimeActionNotificationReceiverModel.sInstance;
        }

        public final void setSInstance(CancelTimeActionNotificationReceiverModel cancelTimeActionNotificationReceiverModel) {
            CancelTimeActionNotificationReceiverModel.sInstance = cancelTimeActionNotificationReceiverModel;
        }

        public final CancelTimeActionNotificationReceiverModel getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "aContext");
            CancelTimeActionNotificationReceiverModel sInstance = getSInstance();
            return sInstance == null ? new CancelTimeActionNotificationReceiverModel(context) : sInstance;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/util/CancelTimeActionNotificationReceiverModel$StopCause;", "", "reason", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getReason", "()Ljava/lang/String;", "COMMON", "MY", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CancelTimeActionNotificationReceiverModel.kt */
    public enum StopCause {
        COMMON("common"),
        MY("my");
        
        private final String reason;

        public static EnumEntries<StopCause> getEntries() {
            return $ENTRIES;
        }

        private StopCause(String str) {
            this.reason = str;
        }

        public final String getReason() {
            return this.reason;
        }

        static {
            StopCause[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/util/CancelTimeActionNotificationReceiverModel$StopCauseMode;", "", "reason", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getReason", "()Ljava/lang/String;", "COMMON", "SMART", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CancelTimeActionNotificationReceiverModel.kt */
    public enum StopCauseMode {
        COMMON("common"),
        SMART("SMART");
        
        private final String reason;

        public static EnumEntries<StopCauseMode> getEntries() {
            return $ENTRIES;
        }

        private StopCauseMode(String str) {
            this.reason = str;
        }

        public final String getReason() {
            return this.reason;
        }

        static {
            StopCauseMode[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final CancelTimeActionNotificationReceiverModel newInstance(Context context) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        return new CancelTimeActionNotificationReceiverModel(context);
    }

    public final void cancelNotification() {
        Intent intent = new Intent(this.aContext, TimeActionNotificationReceiver.class);
        intent.setAction("TIMER_ACTION");
        this.alarmManager.cancel(PendingIntent.getBroadcast(this.aContext, 0, intent, 301989888));
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String format = new SimpleDateFormat("HH:mm:ss").format(Long.valueOf(System.currentTimeMillis()));
        debugLogUtil.d("alarm canceled in " + format);
    }
}
