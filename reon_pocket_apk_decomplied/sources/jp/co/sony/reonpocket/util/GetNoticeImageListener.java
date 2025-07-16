package jp.co.sony.reonpocket.util;

import android.graphics.Bitmap;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Ljp/co/sony/reonpocket/util/GetNoticeImageListener;", "", "failedHandler", "", "successHandler", "aEntity", "Ljp/co/sony/reonpocket/data/entity/NotificationEntity;", "bitmap", "Landroid/graphics/Bitmap;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NoticeUtil.kt */
public interface GetNoticeImageListener {
    void failedHandler();

    void successHandler(NotificationEntity notificationEntity, Bitmap bitmap);
}
