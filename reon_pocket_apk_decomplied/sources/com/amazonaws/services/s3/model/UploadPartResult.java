package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.SSEResultBase;

public class UploadPartResult extends SSEResultBase implements S3RequesterChargedResult {
    private String eTag;
    private boolean isRequesterCharged;
    private int partNumber;

    public int getPartNumber() {
        return this.partNumber;
    }

    public void setPartNumber(int i) {
        this.partNumber = i;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public PartETag getPartETag() {
        return new PartETag(this.partNumber, this.eTag);
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setRequesterCharged(boolean z) {
        this.isRequesterCharged = z;
    }
}
