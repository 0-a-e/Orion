package com.amazonaws.services.dynamodbv2.model;

import java.io.Serializable;

public class SSESpecification implements Serializable {
    private Boolean enabled;
    private String kMSMasterKeyId;
    private String sSEType;

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public SSESpecification withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public String getSSEType() {
        return this.sSEType;
    }

    public void setSSEType(String str) {
        this.sSEType = str;
    }

    public SSESpecification withSSEType(String str) {
        this.sSEType = str;
        return this;
    }

    public void setSSEType(SSEType sSEType2) {
        this.sSEType = sSEType2.toString();
    }

    public SSESpecification withSSEType(SSEType sSEType2) {
        this.sSEType = sSEType2.toString();
        return this;
    }

    public String getKMSMasterKeyId() {
        return this.kMSMasterKeyId;
    }

    public void setKMSMasterKeyId(String str) {
        this.kMSMasterKeyId = str;
    }

    public SSESpecification withKMSMasterKeyId(String str) {
        this.kMSMasterKeyId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled() + ",");
        }
        if (getSSEType() != null) {
            sb.append("SSEType: " + getSSEType() + ",");
        }
        if (getKMSMasterKeyId() != null) {
            sb.append("KMSMasterKeyId: " + getKMSMasterKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getEnabled() == null ? 0 : getEnabled().hashCode()) + 31) * 31) + (getSSEType() == null ? 0 : getSSEType().hashCode())) * 31;
        if (getKMSMasterKeyId() != null) {
            i = getKMSMasterKeyId().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SSESpecification)) {
            return false;
        }
        SSESpecification sSESpecification = (SSESpecification) obj;
        if ((sSESpecification.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        if (sSESpecification.getEnabled() != null && !sSESpecification.getEnabled().equals(getEnabled())) {
            return false;
        }
        if ((sSESpecification.getSSEType() == null) ^ (getSSEType() == null)) {
            return false;
        }
        if (sSESpecification.getSSEType() != null && !sSESpecification.getSSEType().equals(getSSEType())) {
            return false;
        }
        if ((sSESpecification.getKMSMasterKeyId() == null) ^ (getKMSMasterKeyId() == null)) {
            return false;
        }
        return sSESpecification.getKMSMasterKeyId() == null || sSESpecification.getKMSMasterKeyId().equals(getKMSMasterKeyId());
    }
}
