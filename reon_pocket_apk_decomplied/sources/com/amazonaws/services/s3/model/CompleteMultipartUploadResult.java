package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

public class CompleteMultipartUploadResult extends SSEResultBase implements ObjectExpirationResult, S3RequesterChargedResult, Serializable {
    private String bucketName;
    private String eTag;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private boolean isRequesterCharged;
    private String key;
    private String location;
    private String versionId;

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public Date getExpirationTime() {
        return this.expirationTime;
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

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }
}
