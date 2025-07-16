package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RevokeGrantRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private String grantId;
    private String keyId;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public RevokeGrantRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public RevokeGrantRequest withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public Boolean isDryRun() {
        return this.dryRun;
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public void setDryRun(Boolean bool) {
        this.dryRun = bool;
    }

    public RevokeGrantRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getGrantId() != null) {
            sb.append("GrantId: " + getGrantId() + ",");
        }
        if (getDryRun() != null) {
            sb.append("DryRun: " + getDryRun());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getGrantId() == null ? 0 : getGrantId().hashCode())) * 31;
        if (getDryRun() != null) {
            i = getDryRun().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RevokeGrantRequest)) {
            return false;
        }
        RevokeGrantRequest revokeGrantRequest = (RevokeGrantRequest) obj;
        if ((revokeGrantRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (revokeGrantRequest.getKeyId() != null && !revokeGrantRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((revokeGrantRequest.getGrantId() == null) ^ (getGrantId() == null)) {
            return false;
        }
        if (revokeGrantRequest.getGrantId() != null && !revokeGrantRequest.getGrantId().equals(getGrantId())) {
            return false;
        }
        if ((revokeGrantRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return revokeGrantRequest.getDryRun() == null || revokeGrantRequest.getDryRun().equals(getDryRun());
    }
}
