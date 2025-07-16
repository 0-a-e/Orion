package jp.co.sony.reonpocket.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.text.SimpleDateFormat;
import jp.co.sony.reonpocket.connection.aws.S3FileManager;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.util.AnalyticsUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u000f"}, d2 = {"Ljp/co/sony/reonpocket/util/NoticeUtil;", "", "()V", "downloadImage", "", "aContext", "Landroid/content/Context;", "aEntity", "Ljp/co/sony/reonpocket/data/entity/NotificationEntity;", "aCallback", "Ljp/co/sony/reonpocket/util/GetNoticeImageListener;", "getNoticeImage", "sendLog", "version", "", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NoticeUtil.kt */
public final class NoticeUtil {
    public static final int $stable = 0;
    public static final NoticeUtil INSTANCE = new NoticeUtil();

    private NoticeUtil() {
    }

    public final void getNoticeImage(Context context, GetNoticeImageListener getNoticeImageListener) {
        SimpleDateFormat simpleDateFormat;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(getNoticeImageListener, "aCallback");
        NotificationEntity mNotificationEntity = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
        if (mNotificationEntity == null) {
            getNoticeImageListener.failedHandler();
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        } else {
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        }
        if (TextUtils.isEmpty(mNotificationEntity.getDate()) || simpleDateFormat.parse(mNotificationEntity.getDate()).getTime() > System.currentTimeMillis()) {
            NotificationEntity mNotificationEntity2 = RemoteConfigUtil.INSTANCE.getMNotificationEntity();
            sendLog(context, String.valueOf(mNotificationEntity2 != null ? Integer.valueOf(mNotificationEntity2.getVersion()) : null));
            downloadImage(context, mNotificationEntity, getNoticeImageListener);
            return;
        }
        getNoticeImageListener.failedHandler();
    }

    private final void sendLog(Context context, String str) {
        if (str == null) {
            str = AnalyticsUtil.ParameterConstants.NO_ID.getValue();
        }
        AnalyticsUtil analyticsUtil = AnalyticsUtil.INSTANCE;
        FirebaseAnalytics instance = FirebaseAnalytics.getInstance(context);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(...)");
        Context context2 = context;
        analyticsUtil.logEventWithString(context2, instance, AnalyticsUtil.EventName.SHOW_INFORMATION, AnalyticsUtil.EventParameter.NOTIFICATION_ID, str);
    }

    private final void downloadImage(Context context, NotificationEntity notificationEntity, GetNoticeImageListener getNoticeImageListener) {
        String path = notificationEntity.getPath();
        if (path == null) {
            getNoticeImageListener.successHandler(notificationEntity, (Bitmap) null);
            return;
        }
        File file = new File(context.getApplicationContext().getCacheDir(), path);
        S3FileManager.INSTANCE.download(context, path, file, new NoticeUtil$downloadImage$1(getNoticeImageListener, notificationEntity, file));
    }
}
