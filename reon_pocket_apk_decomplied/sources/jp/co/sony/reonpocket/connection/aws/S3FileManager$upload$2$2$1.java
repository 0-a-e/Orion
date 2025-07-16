package jp.co.sony.reonpocket.connection.aws;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"jp/co/sony/reonpocket/connection/aws/S3FileManager$upload$2$2$1", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "current", "", "total", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: S3FileManager.kt */
public final class S3FileManager$upload$2$2$1 implements TransferListener {
    S3FileManager$upload$2$2$1() {
    }

    public void onStateChanged(int i, TransferState transferState) {
        Intrinsics.checkNotNullParameter(transferState, "state");
        if (transferState == TransferState.COMPLETED) {
            DebugLogUtil.INSTANCE.d("AwsManager_S3FileManager", "UPLOAD - - COMPLETED");
        }
    }

    public void onProgressChanged(int i, long j, long j2) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        debugLogUtil.d("AwsManager_S3FileManager", "UPLOAD - - ID: " + i + ", percent done = " + ((int) ((((double) j) / ((double) j2)) * 100.0d)));
    }

    public void onError(int i, Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "ex");
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String message = exc.getMessage();
        debugLogUtil.d("AwsManager_S3FileManager", "UPLOAD ERROR - - ID: " + i + " - - EX: " + message);
    }
}
