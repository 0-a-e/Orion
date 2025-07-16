package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class EnableKeyRotationRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer rotationPeriodInDays;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public EnableKeyRotationRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Integer getRotationPeriodInDays() {
        return this.rotationPeriodInDays;
    }

    public void setRotationPeriodInDays(Integer num) {
        this.rotationPeriodInDays = num;
    }

    public EnableKeyRotationRequest withRotationPeriodInDays(Integer num) {
        this.rotationPeriodInDays = num;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getRotationPeriodInDays() != null) {
            sb.append("RotationPeriodInDays: " + getRotationPeriodInDays());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31;
        if (getRotationPeriodInDays() != null) {
            i = getRotationPeriodInDays().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EnableKeyRotationRequest)) {
            return false;
        }
        EnableKeyRotationRequest enableKeyRotationRequest = (EnableKeyRotationRequest) obj;
        if ((enableKeyRotationRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (enableKeyRotationRequest.getKeyId() != null && !enableKeyRotationRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((enableKeyRotationRequest.getRotationPeriodInDays() == null) ^ (getRotationPeriodInDays() == null)) {
            return false;
        }
        return enableKeyRotationRequest.getRotationPeriodInDays() == null || enableKeyRotationRequest.getRotationPeriodInDays().equals(getRotationPeriodInDays());
    }
}
