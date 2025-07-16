package jp.co.sony.reonpocket.modules.connect.presenter;

import android.graphics.Bitmap;
import jp.co.sony.reonpocket.R;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.modules.connect.view.ConnectionViewInput;
import jp.co.sony.reonpocket.util.GetNoticeImageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"jp/co/sony/reonpocket/modules/connect/presenter/ConnectionPresenter$showNotification$1", "Ljp/co/sony/reonpocket/util/GetNoticeImageListener;", "failedHandler", "", "successHandler", "aEntity", "Ljp/co/sony/reonpocket/data/entity/NotificationEntity;", "bitmap", "Landroid/graphics/Bitmap;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ConnectionPresenter.kt */
public final class ConnectionPresenter$showNotification$1 implements GetNoticeImageListener {
    final /* synthetic */ ConnectionPresenter this$0;

    ConnectionPresenter$showNotification$1(ConnectionPresenter connectionPresenter) {
        this.this$0 = connectionPresenter;
    }

    public void successHandler(NotificationEntity notificationEntity, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(notificationEntity, "aEntity");
        ConnectionViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.showNotification(notificationEntity.getButtonPreference(), notificationEntity.getTitle(), notificationEntity.getSubtitle(), notificationEntity.getDescription(), notificationEntity.getUrl(), bitmap);
        }
    }

    public void failedHandler() {
        ConnectionViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.showErrorMessage(R.string.setting_no_information_title);
        }
    }
}
