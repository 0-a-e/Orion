package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RotateKeyOnDemandRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public RotateKeyOnDemandRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getKeyId() == null ? 0 : getKeyId().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RotateKeyOnDemandRequest)) {
            return false;
        }
        RotateKeyOnDemandRequest rotateKeyOnDemandRequest = (RotateKeyOnDemandRequest) obj;
        if ((rotateKeyOnDemandRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return rotateKeyOnDemandRequest.getKeyId() == null || rotateKeyOnDemandRequest.getKeyId().equals(getKeyId());
    }
}
