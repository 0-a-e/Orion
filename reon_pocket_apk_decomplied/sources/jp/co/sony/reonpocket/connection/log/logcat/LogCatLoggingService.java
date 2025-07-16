package jp.co.sony.reonpocket.connection.log.logcat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.LocaleUtil$$ExternalSyntheticApiModelOutline0;
import jp.co.sony.reonpocket.util.PendingIntentExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLoggingService;", "Landroid/app/Service;", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogCatLoggingService.kt */
public final class LogCatLoggingService extends Service {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Ljp/co/sony/reonpocket/connection/log/logcat/LogCatLoggingService$Companion;", "", "()V", "startService", "", "aContext", "Landroid/content/Context;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LogCatLoggingService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startService(Context context) {
            Intrinsics.checkNotNullParameter(context, "aContext");
        }

        private Companion() {
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Notification notification;
        Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        Context context = this;
        PendingIntent activity = PendingIntent.getActivity(context, 1, new Intent(context, LogCatLogActivity.class), PendingIntentExtensionKt.asPendingIntentImmutableFlag(134217728));
        if (Build.VERSION.SDK_INT >= 26) {
            LocaleUtil$$ExternalSyntheticApiModelOutline0.m();
            NotificationChannel m = LocaleUtil$$ExternalSyntheticApiModelOutline0.m("LogCatLogging ChannelId", (CharSequence) "LogCatLogging", 4);
            m.setDescription("LogCatLogging Notify Description");
            m.setImportance(1);
            m.setLockscreenVisibility(0);
            m.setSound((Uri) null, (AudioAttributes) null);
            m.enableLights(false);
            notificationManager.createNotificationChannel(m);
            LocaleUtil$$ExternalSyntheticApiModelOutline0.m$1();
            notification = LocaleUtil$$ExternalSyntheticApiModelOutline0.m(context, "LogCatLogging ChannelId").setContentTitle("タップするとLogCatログファイル一覧画面が起動します").setSmallIcon(R.mipmap.ic_launcher).setContentText("").setAutoCancel(true).setContentIntent(activity).setWhen(System.currentTimeMillis()).setCategory(NotificationCompat.CATEGORY_SERVICE).build();
        } else {
            notification = new NotificationCompat.Builder(context).setSmallIcon(R.mipmap.ic_notification).setContentTitle("タップするとLogCatログファイル一覧画面が起動します").setContentText("").setContentIntent(activity).build();
        }
        Intrinsics.checkNotNull(notification);
        if (Build.VERSION.SDK_INT >= 34) {
            startForeground(2, notification, 16);
        } else {
            startForeground(2, notification);
        }
        return 2;
    }
}
