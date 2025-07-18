package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.ObjectRestoreResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.util.DateUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ObjectMetadata implements ServerSideEncryptionResult, S3RequesterChargedResult, ObjectExpirationResult, ObjectRestoreResult, Cloneable, Serializable {
    public static final String AES_256_SERVER_SIDE_ENCRYPTION = SSEAlgorithm.AES256.getAlgorithm();
    public static final String KMS_SERVER_SIDE_ENCRYPTION = SSEAlgorithm.KMS.getAlgorithm();
    private Date expirationTime;
    private String expirationTimeRuleId;
    private Date httpExpiresDate;
    private Map<String, Object> metadata = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private Boolean ongoingRestore;
    private Date restoreExpirationTime;
    private Map<String, String> userMetadata = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public ObjectMetadata() {
    }

    private ObjectMetadata(ObjectMetadata objectMetadata) {
        TreeMap treeMap = null;
        this.userMetadata = objectMetadata.userMetadata == null ? null : new TreeMap(objectMetadata.userMetadata);
        this.metadata = objectMetadata.metadata != null ? new TreeMap(objectMetadata.metadata) : treeMap;
        this.expirationTime = DateUtils.cloneDate(objectMetadata.expirationTime);
        this.expirationTimeRuleId = objectMetadata.expirationTimeRuleId;
        this.httpExpiresDate = DateUtils.cloneDate(objectMetadata.httpExpiresDate);
        this.ongoingRestore = objectMetadata.ongoingRestore;
        this.restoreExpirationTime = DateUtils.cloneDate(objectMetadata.restoreExpirationTime);
    }

    public Map<String, String> getUserMetadata() {
        return this.userMetadata;
    }

    public void setUserMetadata(Map<String, String> map) {
        this.userMetadata = map;
    }

    public void setHeader(String str, Object obj) {
        this.metadata.put(str, obj);
    }

    public void addUserMetadata(String str, String str2) {
        this.userMetadata.put(str, str2);
    }

    public Map<String, Object> getRawMetadata() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.putAll(this.metadata);
        return Collections.unmodifiableMap(treeMap);
    }

    public Object getRawMetadataValue(String str) {
        return this.metadata.get(str);
    }

    public Date getLastModified() {
        return DateUtils.cloneDate((Date) this.metadata.get(Headers.LAST_MODIFIED));
    }

    public void setLastModified(Date date) {
        this.metadata.put(Headers.LAST_MODIFIED, date);
    }

    public long getContentLength() {
        Long l = (Long) this.metadata.get("Content-Length");
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    public long getInstanceLength() {
        int lastIndexOf;
        String str = (String) this.metadata.get(Headers.CONTENT_RANGE);
        if (str == null || (lastIndexOf = str.lastIndexOf("/")) < 0) {
            return getContentLength();
        }
        return Long.parseLong(str.substring(lastIndexOf + 1));
    }

    public void setContentLength(long j) {
        this.metadata.put("Content-Length", Long.valueOf(j));
    }

    public String getContentType() {
        return (String) this.metadata.get("Content-Type");
    }

    public void setContentType(String str) {
        this.metadata.put("Content-Type", str);
    }

    public String getContentLanguage() {
        return (String) this.metadata.get(Headers.CONTENT_LANGUAGE);
    }

    public void setContentLanguage(String str) {
        this.metadata.put(Headers.CONTENT_LANGUAGE, str);
    }

    public String getContentEncoding() {
        return (String) this.metadata.get(Headers.CONTENT_ENCODING);
    }

    public void setContentEncoding(String str) {
        this.metadata.put(Headers.CONTENT_ENCODING, str);
    }

    public String getCacheControl() {
        return (String) this.metadata.get(Headers.CACHE_CONTROL);
    }

    public void setCacheControl(String str) {
        this.metadata.put(Headers.CACHE_CONTROL, str);
    }

    public void setContentMD5(String str) {
        if (str == null) {
            this.metadata.remove(Headers.CONTENT_MD5);
        } else {
            this.metadata.put(Headers.CONTENT_MD5, str);
        }
    }

    public String getContentMD5() {
        return (String) this.metadata.get(Headers.CONTENT_MD5);
    }

    public void setContentDisposition(String str) {
        this.metadata.put(Headers.CONTENT_DISPOSITION, str);
    }

    public String getContentDisposition() {
        return (String) this.metadata.get(Headers.CONTENT_DISPOSITION);
    }

    public String getETag() {
        return (String) this.metadata.get(Headers.ETAG);
    }

    public String getVersionId() {
        return (String) this.metadata.get(Headers.S3_VERSION_ID);
    }

    public String getSSEAlgorithm() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION);
    }

    @Deprecated
    public String getServerSideEncryption() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION);
    }

    public void setSSEAlgorithm(String str) {
        this.metadata.put(Headers.SERVER_SIDE_ENCRYPTION, str);
    }

    @Deprecated
    public void setServerSideEncryption(String str) {
        this.metadata.put(Headers.SERVER_SIDE_ENCRYPTION, str);
    }

    public String getSSECustomerAlgorithm() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM);
    }

    public void setSSECustomerAlgorithm(String str) {
        this.metadata.put(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM, str);
    }

    public String getSSECustomerKeyMd5() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5);
    }

    public void setSSECustomerKeyMd5(String str) {
        this.metadata.put(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5, str);
    }

    public Date getExpirationTime() {
        return DateUtils.cloneDate(this.expirationTime);
    }

    public void setExpirationTime(Date date) {
        this.expirationTime = date;
    }

    public String getExpirationTimeRuleId() {
        return this.expirationTimeRuleId;
    }

    public void setExpirationTimeRuleId(String str) {
        this.expirationTimeRuleId = str;
    }

    public Date getRestoreExpirationTime() {
        return DateUtils.cloneDate(this.restoreExpirationTime);
    }

    public void setRestoreExpirationTime(Date date) {
        this.restoreExpirationTime = date;
    }

    public void setOngoingRestore(boolean z) {
        this.ongoingRestore = Boolean.valueOf(z);
    }

    public Boolean getOngoingRestore() {
        return this.ongoingRestore;
    }

    public void setHttpExpiresDate(Date date) {
        this.httpExpiresDate = date;
    }

    public Date getHttpExpiresDate() {
        return DateUtils.cloneDate(this.httpExpiresDate);
    }

    public void setStorageClass(StorageClass storageClass) {
        this.metadata.put(Headers.STORAGE_CLASS, storageClass);
    }

    public String getStorageClass() {
        Object obj = this.metadata.get(Headers.STORAGE_CLASS);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getUserMetaDataOf(String str) {
        Map<String, String> map = this.userMetadata;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public ObjectMetadata clone() {
        return new ObjectMetadata(this);
    }

    public String getSSEAwsKmsKeyId() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION_KMS_KEY_ID);
    }

    public boolean isRequesterCharged() {
        return this.metadata.get(Headers.REQUESTER_CHARGED_HEADER) != null;
    }

    public void setRequesterCharged(boolean z) {
        if (z) {
            this.metadata.put(Headers.REQUESTER_CHARGED_HEADER, Constants.REQUESTER_PAYS);
        }
    }

    public Integer getPartCount() {
        return (Integer) this.metadata.get(Headers.S3_PARTS_COUNT);
    }

    public Long[] getContentRange() {
        String str = (String) this.metadata.get(Headers.CONTENT_RANGE);
        if (str == null) {
            return null;
        }
        String[] split = str.split("[ -/]+");
        try {
            return new Long[]{Long.valueOf(Long.parseLong(split[1])), Long.valueOf(Long.parseLong(split[2]))};
        } catch (NumberFormatException e) {
            throw new AmazonClientException("Unable to parse content range. Header 'Content-Range' has corrupted data" + e.getMessage(), e);
        }
    }

    public String getReplicationStatus() {
        return (String) this.metadata.get(Headers.OBJECT_REPLICATION_STATUS);
    }
}
