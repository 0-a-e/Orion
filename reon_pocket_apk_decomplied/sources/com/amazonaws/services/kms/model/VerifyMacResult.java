package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class VerifyMacResult implements Serializable {
    private String keyId;
    private String macAlgorithm;
    private Boolean macValid;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public VerifyMacResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Boolean isMacValid() {
        return this.macValid;
    }

    public Boolean getMacValid() {
        return this.macValid;
    }

    public void setMacValid(Boolean bool) {
        this.macValid = bool;
    }

    public VerifyMacResult withMacValid(Boolean bool) {
        this.macValid = bool;
        return this;
    }

    public String getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public void setMacAlgorithm(String str) {
        this.macAlgorithm = str;
    }

    public VerifyMacResult withMacAlgorithm(String str) {
        this.macAlgorithm = str;
        return this;
    }

    public void setMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
    }

    public VerifyMacResult withMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getMacValid() != null) {
            sb.append("MacValid: " + getMacValid() + ",");
        }
        if (getMacAlgorithm() != null) {
            sb.append("MacAlgorithm: " + getMacAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getMacValid() == null ? 0 : getMacValid().hashCode())) * 31;
        if (getMacAlgorithm() != null) {
            i = getMacAlgorithm().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifyMacResult)) {
            return false;
        }
        VerifyMacResult verifyMacResult = (VerifyMacResult) obj;
        if ((verifyMacResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (verifyMacResult.getKeyId() != null && !verifyMacResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((verifyMacResult.getMacValid() == null) ^ (getMacValid() == null)) {
            return false;
        }
        if (verifyMacResult.getMacValid() != null && !verifyMacResult.getMacValid().equals(getMacValid())) {
            return false;
        }
        if ((verifyMacResult.getMacAlgorithm() == null) ^ (getMacAlgorithm() == null)) {
            return false;
        }
        return verifyMacResult.getMacAlgorithm() == null || verifyMacResult.getMacAlgorithm().equals(getMacAlgorithm());
    }
}
