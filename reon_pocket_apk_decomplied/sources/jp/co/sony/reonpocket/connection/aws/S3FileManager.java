package jp.co.sony.reonpocket.connection.aws;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import java.io.File;
import jp.co.sony.reonpocket.BuildConfig;
import jp.co.sony.reonpocket.util.DebugLogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J.\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J*\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ljp/co/sony/reonpocket/connection/aws/S3FileManager;", "", "()V", "BUCKET_NAME", "", "TAG", "mRegions", "Lcom/amazonaws/regions/Regions;", "mS3Client", "Lcom/amazonaws/services/s3/AmazonS3Client;", "mTransferUtility", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferUtility;", "createTransferUtility", "", "aContext", "Landroid/content/Context;", "download", "aKey", "aFile", "Ljava/io/File;", "aTransferListener", "Lcom/amazonaws/mobileconnectors/s3/transferutility/TransferListener;", "isNetworkAvailable", "", "upload", "app_prodRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: S3FileManager.kt */
public final class S3FileManager {
    public static final int $stable = 8;
    private static final String BUCKET_NAME = "rnp-prod-usagelog";
    public static final S3FileManager INSTANCE = new S3FileManager();
    private static final String TAG = "AwsManager_S3FileManager";
    private static final Regions mRegions = Regions.AP_NORTHEAST_1;
    private static AmazonS3Client mS3Client;
    private static TransferUtility mTransferUtility;

    private S3FileManager() {
    }

    public static /* synthetic */ void upload$default(S3FileManager s3FileManager, Context context, String str, File file, TransferListener transferListener, int i, Object obj) {
        if ((i & 8) != 0) {
            transferListener = null;
        }
        s3FileManager.upload(context, str, file, transferListener);
    }

    public final void upload(Context context, String str, File file, TransferListener transferListener) {
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        Intrinsics.checkNotNullParameter(file, "aFile");
        if (mTransferUtility == null) {
            INSTANCE.createTransferUtility(context);
            Unit unit = Unit.INSTANCE;
        }
        TransferUtility transferUtility = mTransferUtility;
        if (transferUtility != null) {
            TransferObserver upload = transferUtility.upload(str, file);
            if (transferListener != null) {
                upload.setTransferListener(transferListener);
                return;
            }
            upload.setTransferListener(new S3FileManager$upload$2$2$1());
            if (upload.getState() == TransferState.COMPLETED) {
                DebugLogUtil.INSTANCE.d(TAG, "complete");
            }
            long bytesTransferred = upload.getBytesTransferred();
            DebugLogUtil debugLogUtil = DebugLogUtil.INSTANCE;
            debugLogUtil.d(TAG, "Upload Bytes Transferrred: " + bytesTransferred);
        }
    }

    public static /* synthetic */ void download$default(S3FileManager s3FileManager, Context context, String str, File file, TransferListener transferListener, int i, Object obj) {
        if ((i & 4) != 0) {
            file = null;
        }
        if ((i & 8) != 0) {
            transferListener = null;
        }
        s3FileManager.download(context, str, file, transferListener);
    }

    public final void download(Context context, String str, File file, TransferListener transferListener) {
        TransferUtility transferUtility;
        Intrinsics.checkNotNullParameter(context, "aContext");
        Intrinsics.checkNotNullParameter(str, "aKey");
        if (CognitoManager.INSTANCE.getMCredentialsProvider() == null) {
            S3FileManager s3FileManager = this;
            CognitoManager.INSTANCE.createCredentialsProvider(context);
            Unit unit = Unit.INSTANCE;
        }
        CognitoCachingCredentialsProvider mCredentialsProvider = CognitoManager.INSTANCE.getMCredentialsProvider();
        Unit unit2 = null;
        if (mCredentialsProvider != null) {
            mS3Client = new AmazonS3Client((AWSCredentialsProvider) mCredentialsProvider, Region.getRegion(mRegions));
            transferUtility = TransferUtility.builder().s3Client(mS3Client).context(context.getApplicationContext()).defaultBucket(BuildConfig.NOTIFICATION_IMAGE_BUCKET_NAME).build();
        } else {
            transferUtility = null;
        }
        if (transferUtility != null) {
            if (file != null) {
                unit2 = Unit.INSTANCE;
            } else {
                file = null;
            }
            if (unit2 == null) {
                file = new File(context.getApplicationContext().getCacheDir(), str);
            }
            TransferObserver download = transferUtility.download(str, file);
            if (transferListener != null) {
                download.setTransferListener(transferListener);
                if (!INSTANCE.isNetworkAvailable(context)) {
                    transferListener.onError(0, new Exception("no available network"));
                    return;
                }
                return;
            }
            download.setTransferListener(new S3FileManager$download$3$4$1());
            if (download.getState() == TransferState.COMPLETED) {
                DebugLogUtil.INSTANCE.d(TAG, "complete");
            }
            long bytesTransferred = download.getBytesTransferred();
            DebugLogUtil.INSTANCE.d(TAG, "DOWNLOAD Bytes Transferrred: " + bytesTransferred);
        }
    }

    private final void createTransferUtility(Context context) {
        if (CognitoManager.INSTANCE.getMCredentialsProvider() == null) {
            S3FileManager s3FileManager = this;
            CognitoManager.INSTANCE.createCredentialsProvider(context);
            Unit unit = Unit.INSTANCE;
        }
        CognitoCachingCredentialsProvider mCredentialsProvider = CognitoManager.INSTANCE.getMCredentialsProvider();
        if (mCredentialsProvider != null) {
            mS3Client = new AmazonS3Client((AWSCredentialsProvider) mCredentialsProvider, Region.getRegion(mRegions));
            mTransferUtility = TransferUtility.builder().s3Client(mS3Client).context(context.getApplicationContext()).defaultBucket("rnp-prod-usagelog").build();
        }
    }

    private final boolean isNetworkAvailable(Context context) {
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
