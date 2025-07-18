package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class UpdateKeyDescriptionRequest extends AmazonWebServiceRequest implements Serializable {
    private String description;
    private String keyId;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public UpdateKeyDescriptionRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public UpdateKeyDescriptionRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getDescription() != null) {
            sb.append("Description: " + getDescription());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31;
        if (getDescription() != null) {
            i = getDescription().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateKeyDescriptionRequest)) {
            return false;
        }
        UpdateKeyDescriptionRequest updateKeyDescriptionRequest = (UpdateKeyDescriptionRequest) obj;
        if ((updateKeyDescriptionRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (updateKeyDescriptionRequest.getKeyId() != null && !updateKeyDescriptionRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((updateKeyDescriptionRequest.getDescription() == null) ^ (getDescription() == null)) {
            return false;
        }
        return updateKeyDescriptionRequest.getDescription() == null || updateKeyDescriptionRequest.getDescription().equals(getDescription());
    }
}
