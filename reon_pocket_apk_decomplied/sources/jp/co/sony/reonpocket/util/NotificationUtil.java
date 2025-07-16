package jp.co.sony.reonpocket.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.constant.MyNotificationChannel;
import jp.co.sony.reonpocket.constant.NotificationId;
import jp.co.sony.reonpocket.constant.NotifyAlertCode;
import jp.co.sony.reonpocket.modules.main.view.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Ljp/co/sony/reonpocket/util/NotificationUtil;", "", "()V", "convertAlertTypeCodeToNotification", "Ljp/co/sony/reonpocket/constant/MyNotificationChannel$NotificationGroup$Notification;", "aAlertType", "", "notifyNotifyAlert", "", "aContext", "Landroid/content/Context;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NotificationUtil.kt */
public final class NotificationUtil {
    public static final int $stable = 0;
    public static final NotificationUtil INSTANCE = new NotificationUtil();

    private NotificationUtil() {
    }

    @JvmStatic
    public static final void notifyNotifyAlert(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Object systemService = context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        String str = null;
        if (Build.VERSION.SDK_INT >= 26) {
            LocaleUtil$$ExternalSyntheticApiModelOutline0.m();
            NotificationChannel m = LocaleUtil$$ExternalSyntheticApiModelOutline0.m(MyNotificationChannel.NotifyAlert.INSTANCE.getId(), (CharSequence) context.getString(MyNotificationChannel.NotifyAlert.INSTANCE.getName()), 4);
            Integer description = MyNotificationChannel.NotifyAlert.INSTANCE.getDescription();
            m.setDescription(description != null ? context.getString(description.intValue()) : null);
            m.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(m);
        }
        MyNotificationChannel.NotificationGroup.Notification convertAlertTypeCodeToNotification = INSTANCE.convertAlertTypeCodeToNotification(i);
        if (convertAlertTypeCodeToNotification != null) {
            NotificationId from = NotificationId.Companion.from(convertAlertTypeCodeToNotification.getId());
            String string = context.getString(convertAlertTypeCodeToNotification.getTitle());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Integer description2 = convertAlertTypeCodeToNotification.getDescription();
            if (description2 != null) {
                str = context.getString(description2.intValue());
            }
            Intent putExtra = new Intent(context, MainActivity.class).putExtra(MainActivity.SHOW_ERROR_DIALOG_KEY_RELATED_NOTIFICATION_ID, from);
            Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
            Notification build = new NotificationCompat.Builder(context, MyNotificationChannel.NotifyAlert.INSTANCE.getId()).setSmallIcon(R.drawable.ic_notification).setContentTitle(string).setContentText(str).setPriority(1).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(context, i, putExtra, PendingIntentExtensionKt.asPendingIntentImmutableFlag(134217728))).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            notificationManager.cancel(MyNotificationChannel.NotifyAlert.NotificationGroup.INSTANCE.getId());
            notificationManager.notify(MyNotificationChannel.NotifyAlert.NotificationGroup.INSTANCE.getId(), build);
        }
    }

    private final MyNotificationChannel.NotificationGroup.Notification convertAlertTypeCodeToNotification(int i) {
        if (i == NotifyAlertCode.VBUS_VOLTAGE_ABNORMALITY_DETECTED.getCode()) {
            return MyNotificationChannel.NotifyAlert.NotificationGroup.VbusVoltage.INSTANCE;
        }
        if (i == NotifyAlertCode.USB_WATER_WET_DETECTION.getCode()) {
            return MyNotificationChannel.NotifyAlert.NotificationGroup.UsbWater.INSTANCE;
        }
        if (i == NotifyAlertCode.USB_AROUND_WATER_WET_DETECTION.getCode()) {
            return MyNotificationChannel.NotifyAlert.NotificationGroup.AroundUsbWater.INSTANCE;
        }
        if (i == NotifyAlertCode.USB_AROUND_OVER_HEAT.getCode()) {
            return MyNotificationChannel.NotifyAlert.NotificationGroup.AroundUsbHeat.INSTANCE;
        }
        return null;
    }
}
