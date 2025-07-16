package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class GetKeyPolicyResult implements Serializable {
    private String policy;
    private String policyName;

    public String getPolicy() {
        return this.policy;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public GetKeyPolicyResult withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public GetKeyPolicyResult withPolicyName(String str) {
        this.policyName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getPolicyName() != null) {
            sb.append("PolicyName: " + getPolicyName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPolicy() == null ? 0 : getPolicy().hashCode()) + 31) * 31;
        if (getPolicyName() != null) {
            i = getPolicyName().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetKeyPolicyResult)) {
            return false;
        }
        GetKeyPolicyResult getKeyPolicyResult = (GetKeyPolicyResult) obj;
        if ((getKeyPolicyResult.getPolicy() == null) ^ (getPolicy() == null)) {
            return false;
        }
        if (getKeyPolicyResult.getPolicy() != null && !getKeyPolicyResult.getPolicy().equals(getPolicy())) {
            return false;
        }
        if ((getKeyPolicyResult.getPolicyName() == null) ^ (getPolicyName() == null)) {
            return false;
        }
        return getKeyPolicyResult.getPolicyName() == null || getKeyPolicyResult.getPolicyName().equals(getPolicyName());
    }
}
