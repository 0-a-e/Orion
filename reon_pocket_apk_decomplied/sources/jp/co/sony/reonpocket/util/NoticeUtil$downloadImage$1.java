package jp.co.sony.reonpocket.util;

import android.graphics.Bitmap;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import java.io.File;
import jp.co.sony.reonpocket.data.entity.NotificationEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"jp/co/sony/reonpocket/util/NoticeUtil$downloadImage$1", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NoticeUtil.kt */
public final class NoticeUtil$downloadImage$1 implements TransferListener {
    final /* synthetic */ GetNoticeImageListener $aCallback;
    final /* synthetic */ NotificationEntity $aEntity;
    final /* synthetic */ File $file;

    public void onProgressChanged(int i, long j, long j2) {
    }

    NoticeUtil$downloadImage$1(GetNoticeImageListener getNoticeImageListener, NotificationEntity notificationEntity, File file) {
        this.$aCallback = getNoticeImageListener;
        this.$aEntity = notificationEntity;
        this.$file = file;
    }

    public void onStateChanged(int i, TransferState transferState) {
        if (transferState != null && transferState == TransferState.COMPLETED) {
            GetNoticeImageListener getNoticeImageListener = this.$aCallback;
            NotificationEntity notificationEntity = this.$aEntity;
            BitmapUtil bitmapUtil = BitmapUtil.INSTANCE;
            String absolutePath = this.$file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            getNoticeImageListener.successHandler(notificationEntity, bitmapUtil.getBitmap(absolutePath));
        }
    }

    public void onError(int i, Exception exc) {
        this.$aCallback.successHandler(this.$aEntity, (Bitmap) null);
    }
}
