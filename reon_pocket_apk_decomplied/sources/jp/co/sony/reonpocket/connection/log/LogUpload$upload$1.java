package jp.co.sony.reonpocket.connection.log;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import java.io.File;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"jp/co/sony/reonpocket/connection/log/LogUpload$upload$1", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "onError", "", "id", "", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onProgressChanged", "bytesCurrent", "", "bytesTotal", "onStateChanged", "state", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferState;", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogUpload.kt */
public final class LogUpload$upload$1 implements TransferListener {
    final /* synthetic */ File $aFile;
    final /* synthetic */ String $aFileName;

    public void onProgressChanged(int i, long j, long j2) {
    }

    LogUpload$upload$1(String str, File file) {
        this.$aFileName = str;
        this.$aFile = file;
    }

    public void onStateChanged(int i, TransferState transferState) {
        if (transferState == TransferState.COMPLETED) {
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            String str = this.$aFileName;
            debugLogUtil.d("AwsLog_UploadLogJobTask", str + " file uploaded successfully");
            try {
                this.$aFile.delete();
            } catch (Exception unused) {
                DebugLogUtil debugLogUtil2 = DebugLogUtil.INSTANCE;
                String str2 = this.$aFileName;
                debugLogUtil2.e("AwsLog_UploadLogJobTask", "Delete " + str2 + " file failed");
            }
        }
    }

    public void onError(int i, Exception exc) {
        DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
        String str = this.$aFileName;
        String message = exc != null ? exc.getMessage() : null;
        debugLogUtil.e("AwsLog_UploadLogJobTask", "Log file(" + str + ") upload failed. ID: " + i + ", EX: " + message);
    }
}
