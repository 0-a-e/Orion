package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class RotateKeyOnDemandResult implements Serializable {
    private String keyId;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public RotateKeyOnDemandResult withKeyId(String str) {
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
        if (obj == null || !(obj instanceof RotateKeyOnDemandResult)) {
            return false;
        }
        RotateKeyOnDemandResult rotateKeyOnDemandResult = (RotateKeyOnDemandResult) obj;
        if ((rotateKeyOnDemandResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return rotateKeyOnDemandResult.getKeyId() == null || rotateKeyOnDemandResult.getKeyId().equals(getKeyId());
    }
}
