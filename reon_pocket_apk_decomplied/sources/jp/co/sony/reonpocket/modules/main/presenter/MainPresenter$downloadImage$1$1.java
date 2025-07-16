package jp.co.sony.reonpocket.modules.main.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import java.io.File;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import jp.co.sony.reonpocket.modules.main.view.MainViewInput;
import jp.co.sony.reonpocket.util.BitmapUtil;
import jp.co.sony.reonpocket.util.RemoteConfigUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"jp/co/sony/reonpocket/modules/main/presenter/MainPresenter$downloadImage$1$1", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainPresenter.kt */
public final class MainPresenter$downloadImage$1$1 implements TransferListener {
    final /* synthetic */ Context $aContext;
    final /* synthetic */ String $aCountry;
    final /* synthetic */ NotificationEntity $aNotificationEntity;
    final /* synthetic */ File $file;
    final /* synthetic */ MainPresenter this$0;

    public void onProgressChanged(int i, long j, long j2) {
    }

    MainPresenter$downloadImage$1$1(MainPresenter mainPresenter, NotificationEntity notificationEntity, File file, Context context, String str) {
        this.this$0 = mainPresenter;
        this.$aNotificationEntity = notificationEntity;
        this.$file = file;
        this.$aContext = context;
        this.$aCountry = str;
    }

    public void onStateChanged(int i, TransferState transferState) {
        if (transferState != null) {
            MainPresenter mainPresenter = this.this$0;
            NotificationEntity notificationEntity = this.$aNotificationEntity;
            File file = this.$file;
            Context context = this.$aContext;
            String str = this.$aCountry;
            if (transferState == TransferState.COMPLETED) {
                MainViewInput access$getAView$p = mainPresenter.aView;
                if (access$getAView$p != null) {
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
                RemoteConfigUtil.INSTANCE.saveNotificationVersion(context, str, notificationEntity.getVersion());
            }
        }
    }

    public void onError(int i, Exception exc) {
        MainViewInput access$getAView$p = this.this$0.aView;
        if (access$getAView$p != null) {
            access$getAView$p.showNotification(this.$aNotificationEntity.getButtonPreference(), this.$aNotificationEntity.getTitle(), this.$aNotificationEntity.getSubtitle(), this.$aNotificationEntity.getDescription(), this.$aNotificationEntity.getUrl(), (Bitmap) null);
        }
        RemoteConfigUtil.INSTANCE.saveNotificationVersion(this.$aContext, this.$aCountry, this.$aNotificationEntity.getVersion());
    }
}
