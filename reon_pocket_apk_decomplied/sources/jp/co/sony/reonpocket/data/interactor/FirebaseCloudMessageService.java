package jp.co.sony.reonpocket.data.interactor;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.util.LocaleUtil$$ExternalSyntheticApiModelOutline0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/FirebaseCloudMessageService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "p0", "", "Companion", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FirebaseCloudMessageService.kt */
public final class FirebaseCloudMessageService extends FirebaseMessagingService {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NOTIFICATION_ID = 1;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Ljp/co/sony/reonpocket/data/interactor/FirebaseCloudMessageService$Companion;", "", "()V", "NOTIFICATION_ID", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: FirebaseCloudMessageService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Notification notification;
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        RemoteMessage.Notification notification2 = remoteMessage.getNotification();
        String title = notification2 != null ? notification2.getTitle() : null;
        RemoteMessage.Notification notification3 = remoteMessage.getNotification();
        String body = notification3 != null ? notification3.getBody() : null;
        Object systemService = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        Intent launchIntentForPackage = getApplicationContext().getPackageManager().getLaunchIntentForPackage(getApplicationContext().getPackageName());
        Intrinsics.checkNotNull(launchIntentForPackage);
        Intent flags = launchIntentForPackage.setPackage((String) null).setFlags(270532608);
        Intrinsics.checkNotNullExpressionValue(flags, "setFlags(...)");
        flags.setFlags(270532608);
        Context context = this;
        PendingIntent activity = PendingIntent.getActivity(context, 0, flags, 167772160);
        if (Build.VERSION.SDK_INT >= 26) {
            LocaleUtil$$ExternalSyntheticApiModelOutline0.m();
            CharSequence charSequence = title;
            NotificationChannel m = LocaleUtil$$ExternalSyntheticApiModelOutline0.m("jp.co.sony.reonpocket#FirebaseMessage", charSequence, 3);
            m.setDescription("Silent Notification");
            m.setImportance(3);
            m.setLockscreenVisibility(0);
            m.setLightColor(-16776961);
            notificationManager.createNotificationChannel(m);
            LocaleUtil$$ExternalSyntheticApiModelOutline0.m$1();
            notification = LocaleUtil$$ExternalSyntheticApiModelOutline0.m(context, "jp.co.sony.reonpocket#FirebaseMessage").setContentTitle(charSequence).setSmallIcon(R.mipmap.ic_notification).setContentText(body).setAutoCancel(true).setWhen(System.currentTimeMillis()).setCategory(NotificationCompat.CATEGORY_SERVICE).setContentIntent(activity).build();
        } else {
            notification = new NotificationCompat.Builder(context).setSmallIcon(R.mipmap.ic_notification).setContentTitle(title).setContentText(body).setContentIntent(activity).build();
        }
        Intrinsics.checkNotNull(notification);
        Object systemService2 = getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService2).notify(1, notification);
    }

    public void onNewToken(String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        super.onNewToken(str);
    }
}
