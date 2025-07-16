package jp.co.sony.reonpocket.modules.settings.presenter;

import android.graphics.Bitmap;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import java.io.File;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.modules.settings.view.SettingViewInput;
import jp.co.sony.reonpocket.util.BitmapUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"jp/co/sony/reonpocket/modules/settings/presenter/SettingPresenter$downloadImage$1$1", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingPresenter.kt */
public final class SettingPresenter$downloadImage$1$1 implements TransferListener {
    final /* synthetic */ NotificationEntity $aEntity;
    final /* synthetic */ File $file;
    final /* synthetic */ SettingPresenter this$0;

    public void onProgressChanged(int i, long j, long j2) {
    }

    SettingPresenter$downloadImage$1$1(SettingPresenter settingPresenter, NotificationEntity notificationEntity, File file) {
        this.this$0 = settingPresenter;
        this.$aEntity = notificationEntity;
        this.$file = file;
    }

    public void onStateChanged(int i, TransferState transferState) {
        SettingViewInput access$getAView$p;
        if (transferState != null) {
            SettingPresenter settingPresenter = this.this$0;
            NotificationEntity notificationEntity = this.$aEntity;
            File file = this.$file;
            if (transferState == TransferState.COMPLETED && (access$getAView$p = settingPresenter.aView) != null) {
                String buttonPreference = notificationEntity.getButtonPreference();
                String title = notificationEntity.getTitle();
                String subtitle = notificationEntity.getSubtitle();
                String description = notificationEntity.getDescription();
                String url = notificationEntity.getUrl();
                BitmapUtil bitmapUtil = BitmapUtil.INSTANCE;
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                access$getAView$p.showNotification(buttonPreference, title, subtitle, description, url, bitmapUtil.getBitmap(absolutePath));
            }
        }
    }

    public void onError(int i, Exception exc) {
        SettingViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.showNotification(this.$aEntity.getButtonPreference(), this.$aEntity.getTitle(), this.$aEntity.getSubtitle(), this.$aEntity.getDescription(), this.$aEntity.getUrl(), (Bitmap) null);
        }
    }
}
