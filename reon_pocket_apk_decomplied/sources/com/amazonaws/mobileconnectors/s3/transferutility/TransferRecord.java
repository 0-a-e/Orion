package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.util.json.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TransferRecord {
    /* access modifiers changed from: private */
    public static final Log LOGGER = LogFactory.getLog((Class<?>) TransferRecord.class);
    public String bucketName;
    public long bytesCurrent;
    public long bytesTotal;
    public String cannedAcl;
    public String eTag;
    public String expirationTimeRuleId;
    public String file;
    public long fileOffset;
    private Gson gson = new Gson();
    public String headerCacheControl;
    public String headerContentDisposition;
    public String headerContentEncoding;
    public String headerContentLanguage;
    public String headerContentType;
    public String headerExpire;
    public String headerStorageClass;
    public String httpExpires;
    public int id;
    public int isEncrypted;
    public int isLastPart;
    public int isMultipart;
    public int isRequesterPays;
    public String key;
    public int mainUploadId;
    public String md5;
    public String multipartId;
    public int partNumber;
    public long rangeLast;
    public long rangeStart;
    public long speed;
    public String sseAlgorithm;
    public String sseKMSKey;
    public TransferState state;
    private Future<?> submittedTask;
    public TransferUtilityOptions transferUtilityOptions;
    public TransferType type;
    public Map<String, String> userMetadata;
    public String versionId;

    public TransferRecord(int i) {
        this.id = i;
    }

    public void updateFromDB(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID));
        this.mainUploadId = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_MAIN_UPLOAD_ID));
        this.type = TransferType.getType(cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_TYPE)));
        this.state = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
        this.bucketName = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BUCKET_NAME));
        this.key = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_KEY));
        this.versionId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_VERSION_ID));
        this.bytesTotal = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_TOTAL));
        this.bytesCurrent = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_CURRENT));
        this.speed = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SPEED));
        this.isRequesterPays = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_REQUESTER_PAYS));
        this.isMultipart = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_MULTIPART));
        this.isLastPart = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_LAST_PART));
        this.isEncrypted = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_ENCRYPTED));
        this.partNumber = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM));
        this.eTag = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ETAG));
        this.file = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_FILE));
        this.multipartId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_MULTIPART_ID));
        this.rangeStart = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_DATA_RANGE_START));
        this.rangeLast = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_DATA_RANGE_LAST));
        this.fileOffset = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_FILE_OFFSET));
        this.headerContentType = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_TYPE));
        this.headerContentLanguage = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_LANGUAGE));
        this.headerContentDisposition = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_DISPOSITION));
        this.headerContentEncoding = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_ENCODING));
        this.headerCacheControl = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CACHE_CONTROL));
        this.headerExpire = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_EXPIRE));
        this.userMetadata = JsonUtils.jsonToMap(cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_USER_METADATA)));
        this.expirationTimeRuleId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_EXPIRATION_TIME_RULE_ID));
        this.httpExpires = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HTTP_EXPIRES_DATE));
        this.sseAlgorithm = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SSE_ALGORITHM));
        this.sseKMSKey = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SSE_KMS_KEY));
        this.md5 = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_CONTENT_MD5));
        this.cannedAcl = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_CANNED_ACL));
        this.headerStorageClass = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_STORAGE_CLASS));
        String string = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_TRANSFER_UTILITY_OPTIONS));
        try {
            this.transferUtilityOptions = (TransferUtilityOptions) this.gson.fromJson(string, TransferUtilityOptions.class);
        } catch (JsonSyntaxException e) {
            LOGGER.error(String.format("Failed to deserialize: %s, setting to default", new Object[]{string}), e);
            this.transferUtilityOptions = new TransferUtilityOptions();
        }
    }

    public boolean start(AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        if (isRunning() || !checkIsReadyToRun() || !checkPreferredNetworkAvailability(transferStatusUpdater, connectivityManager)) {
            return false;
        }
        if (this.type.equals(TransferType.DOWNLOAD)) {
            this.submittedTask = TransferThreadPool.submitTask(new DownloadTask(this, amazonS3, transferStatusUpdater));
            return true;
        }
        this.submittedTask = TransferThreadPool.submitTask(new UploadTask(this, amazonS3, transferDBUtil, transferStatusUpdater));
        return true;
    }

    public boolean pause(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (isFinalState(this.state) || TransferState.PAUSED.equals(this.state) || TransferState.PENDING_PAUSE.equals(this.state)) {
            return false;
        }
        transferStatusUpdater.updateState(this.id, TransferState.PENDING_PAUSE);
        if (isRunning()) {
            this.submittedTask.cancel(true);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pauseIfRequiredForNetworkInterruption(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        boolean checkPreferredNetworkAvailability = checkPreferredNetworkAvailability(transferStatusUpdater, connectivityManager);
        boolean z = false;
        if (!checkPreferredNetworkAvailability && !isFinalState(this.state)) {
            z = true;
            if (isRunning()) {
                this.submittedTask.cancel(true);
            }
        }
        return z;
    }

    public boolean cancel(final AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (isFinalState(this.state)) {
            return false;
        }
        transferStatusUpdater.updateState(this.id, TransferState.PENDING_CANCEL);
        if (isRunning()) {
            this.submittedTask.cancel(true);
        }
        if (TransferType.UPLOAD.equals(this.type) && this.isMultipart == 1) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        amazonS3.abortMultipartUpload(new AbortMultipartUploadRequest(TransferRecord.this.bucketName, TransferRecord.this.key, TransferRecord.this.multipartId));
                        Log access$000 = TransferRecord.LOGGER;
                        access$000.debug("Successfully clean up multipart upload: " + TransferRecord.this.id);
                    } catch (AmazonClientException e) {
                        Log access$0002 = TransferRecord.LOGGER;
                        access$0002.debug("Failed to abort multiplart upload: " + TransferRecord.this.id, e);
                    }
                }
            }).start();
        } else if (TransferType.DOWNLOAD.equals(this.type)) {
            new File(this.file).delete();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isRunning() {
        Future<?> future = this.submittedTask;
        return future != null && !future.isDone();
    }

    /* access modifiers changed from: package-private */
    public void waitTillFinish(long j) throws InterruptedException, ExecutionException, TimeoutException {
        if (isRunning()) {
            this.submittedTask.get(j, TimeUnit.MILLISECONDS);
        }
    }

    private boolean isFinalState(TransferState transferState) {
        return TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState);
    }

    private boolean checkIsReadyToRun() {
        return this.partNumber == 0 && !TransferState.COMPLETED.equals(this.state);
    }

    public String toString() {
        return "[id:" + this.id + ",bucketName:" + this.bucketName + ",key:" + this.key + ",file:" + this.file + ",type:" + this.type + ",bytesTotal:" + this.bytesTotal + ",bytesCurrent:" + this.bytesCurrent + ",fileOffset:" + this.fileOffset + ",state:" + this.state + ",cannedAcl:" + this.cannedAcl + ",mainUploadId:" + this.mainUploadId + ",isMultipart:" + this.isMultipart + ",isLastPart:" + this.isLastPart + ",partNumber:" + this.partNumber + ",multipartId:" + this.multipartId + ",eTag:" + this.eTag + ",storageClass:" + this.headerStorageClass + ",userMetadata:" + this.userMetadata.toString() + ",transferUtilityOptions:" + this.gson.toJson((Object) this.transferUtilityOptions) + "]";
    }

    /* access modifiers changed from: protected */
    public boolean checkPreferredNetworkAvailability(TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        TransferUtilityOptions transferUtilityOptions2;
        if (connectivityManager == null || (transferUtilityOptions2 = this.transferUtilityOptions) == null || transferUtilityOptions2.getTransferNetworkConnectionType() == null || this.transferUtilityOptions.getTransferNetworkConnectionType().isConnected(connectivityManager)) {
            return true;
        }
        Log log = LOGGER;
        log.info("Network Connection " + this.transferUtilityOptions.getTransferNetworkConnectionType() + " is not available.");
        transferStatusUpdater.updateState(this.id, TransferState.WAITING_FOR_NETWORK);
        return false;
    }
}
