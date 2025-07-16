package jp.co.sony.reonpocket.util.service;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.LocaleUtil$$ExternalSyntheticApiModelOutline0;
import jp.co.sony.reonpocket.util.PendingIntentExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0018\u00010\u0006R\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ljp/co/sony/reonpocket/util/service/TimeActionNotificationReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "keyguard", "Landroid/app/KeyguardManager;", "keylock", "Landroid/app/KeyguardManager$KeyguardLock;", "wakelock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeActionNotificationReceiver.kt */
public final class TimeActionNotificationReceiver extends BroadcastReceiver {
    public static final int $stable = 8;
    private KeyguardManager keyguard;
    private KeyguardManager.KeyguardLock keylock;
    private PowerManager.WakeLock wakelock;

    public void onReceive(Context context, Intent intent) {
        String string;
        Bundle extras;
        String string2;
        if (context != null && intent != null && Intrinsics.areEqual((Object) intent.getAction(), (Object) "TIMER_ACTION")) {
            Object systemService = context.getSystemService("power");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(805306394, "AppName:tag");
            this.wakelock = newWakeLock;
            if (newWakeLock != null) {
                newWakeLock.acquire(30);
            }
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            Intrinsics.checkNotNull(launchIntentForPackage);
            Intent flags = launchIntentForPackage.setPackage((String) null).setFlags(270532608);
            Intrinsics.checkNotNullExpressionValue(flags, "setFlags(...)");
            PendingIntent activity = PendingIntent.getActivity(context, intent.getIntExtra("RequestCode", 0), flags, PendingIntentExtensionKt.asPendingIntentMutableFlag(134217728));
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            Bundle extras2 = intent.getExtras();
            if (extras2 != null && (string = extras2.getString("title")) != null && (extras = intent.getExtras()) != null && (string2 = extras.getString("description")) != null) {
                Object systemService2 = context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
                Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
                NotificationManager notificationManager = (NotificationManager) systemService2;
                if (Build.VERSION.SDK_INT >= 26) {
                    LocaleUtil$$ExternalSyntheticApiModelOutline0.m();
                    CharSequence charSequence = string;
                    NotificationChannel m = LocaleUtil$$ExternalSyntheticApiModelOutline0.m("jp.co.sony.reonpocket", charSequence, 3);
                    m.setDescription(string2);
                    m.enableVibration(true);
                    boolean unused = m.canShowBadge();
                    m.enableLights(true);
                    m.setLightColor(context.getColor(R.color.NewBasicBackground));
                    m.setLockscreenVisibility(0);
                    m.setSound(defaultUri, (AudioAttributes) null);
                    m.setShowBadge(true);
                    notificationManager.createNotificationChannel(m);
                    Notification build = LocaleUtil$$ExternalSyntheticApiModelOutline0.m(context, "jp.co.sony.reonpocket").setContentTitle(charSequence).setSmallIcon(R.mipmap.ic_notification).setContentText(string2).setAutoCancel(true).setContentIntent(activity).setWhen(System.currentTimeMillis()).build();
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    notificationManager.cancel(R.string.app_name);
                    notificationManager.notify(R.string.app_name, build);
                } else {
                    NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(context).setSmallIcon(R.mipmap.ic_notification).setContentTitle(string).setContentText(string2).setContentIntent(activity);
                    Intrinsics.checkNotNullExpressionValue(contentIntent, "setContentIntent(...)");
                    notificationManager.cancel(R.string.app_name);
                    notificationManager.notify(R.string.app_name, contentIntent.build());
                }
                PowerManager.WakeLock wakeLock = this.wakelock;
                if (wakeLock != null) {
                    wakeLock.release();
                }
            }
        }
    }
}
