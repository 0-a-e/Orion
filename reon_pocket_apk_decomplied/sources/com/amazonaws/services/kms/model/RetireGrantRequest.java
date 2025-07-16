package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RetireGrantRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean dryRun;
    private String grantId;
    private String grantToken;
    private String keyId;

    public String getGrantToken() {
        return this.grantToken;
    }

    public void setGrantToken(String str) {
        this.grantToken = str;
    }

    public RetireGrantRequest withGrantToken(String str) {
        this.grantToken = str;
        return this;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public RetireGrantRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public RetireGrantRequest withGrantId(String str) {
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

    public RetireGrantRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGrantToken() != null) {
            sb.append("GrantToken: " + getGrantToken() + ",");
        }
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
        int hashCode = ((((((getGrantToken() == null ? 0 : getGrantToken().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getGrantId() == null ? 0 : getGrantId().hashCode())) * 31;
        if (getDryRun() != null) {
            i = getDryRun().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RetireGrantRequest)) {
            return false;
        }
        RetireGrantRequest retireGrantRequest = (RetireGrantRequest) obj;
        if ((retireGrantRequest.getGrantToken() == null) ^ (getGrantToken() == null)) {
            return false;
        }
        if (retireGrantRequest.getGrantToken() != null && !retireGrantRequest.getGrantToken().equals(getGrantToken())) {
            return false;
        }
        if ((retireGrantRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (retireGrantRequest.getKeyId() != null && !retireGrantRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((retireGrantRequest.getGrantId() == null) ^ (getGrantId() == null)) {
            return false;
        }
        if (retireGrantRequest.getGrantId() != null && !retireGrantRequest.getGrantId().equals(getGrantId())) {
            return false;
        }
        if ((retireGrantRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return retireGrantRequest.getDryRun() == null || retireGrantRequest.getDryRun().equals(getDryRun());
    }
}
