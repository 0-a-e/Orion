package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

public class AssumeRoleWithWebIdentityResult implements Serializable {
    private AssumedRoleUser assumedRoleUser;
    private String audience;
    private Credentials credentials;
    private Integer packedPolicySize;
    private String provider;
    private String sourceIdentity;
    private String subjectFromWebIdentityToken;

    public Credentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(Credentials credentials2) {
        this.credentials = credentials2;
    }

    public AssumeRoleWithWebIdentityResult withCredentials(Credentials credentials2) {
        this.credentials = credentials2;
        return this;
    }

    public String getSubjectFromWebIdentityToken() {
        return this.subjectFromWebIdentityToken;
    }

    public void setSubjectFromWebIdentityToken(String str) {
        this.subjectFromWebIdentityToken = str;
    }

    public AssumeRoleWithWebIdentityResult withSubjectFromWebIdentityToken(String str) {
        this.subjectFromWebIdentityToken = str;
        return this;
    }

    public AssumedRoleUser getAssumedRoleUser() {
        return this.assumedRoleUser;
    }

    public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser2) {
        this.assumedRoleUser = assumedRoleUser2;
    }

    public AssumeRoleWithWebIdentityResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser2) {
        this.assumedRoleUser = assumedRoleUser2;
        return this;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public AssumeRoleWithWebIdentityResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public AssumeRoleWithWebIdentityResult withProvider(String str) {
        this.provider = str;
        return this;
    }

    public String getAudience() {
        return this.audience;
    }

    public void setAudience(String str) {
        this.audience = str;
    }

    public AssumeRoleWithWebIdentityResult withAudience(String str) {
        this.audience = str;
        return this;
    }

    public String getSourceIdentity() {
        return this.sourceIdentity;
    }

    public void setSourceIdentity(String str) {
        this.sourceIdentity = str;
    }

    public AssumeRoleWithWebIdentityResult withSourceIdentity(String str) {
        this.sourceIdentity = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials() + ",");
        }
        if (getSubjectFromWebIdentityToken() != null) {
            sb.append("SubjectFromWebIdentityToken: " + getSubjectFromWebIdentityToken() + ",");
        }
        if (getAssumedRoleUser() != null) {
            sb.append("AssumedRoleUser: " + getAssumedRoleUser() + ",");
        }
        if (getPackedPolicySize() != null) {
            sb.append("PackedPolicySize: " + getPackedPolicySize() + ",");
        }
        if (getProvider() != null) {
            sb.append("Provider: " + getProvider() + ",");
        }
        if (getAudience() != null) {
            sb.append("Audience: " + getAudience() + ",");
        }
        if (getSourceIdentity() != null) {
            sb.append("SourceIdentity: " + getSourceIdentity());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        int hashCode = ((getCredentials() == null ? 0 : getCredentials().hashCode()) + 31) * 31;
        if (getSubjectFromWebIdentityToken() == null) {
            i = 0;
        } else {
            i = getSubjectFromWebIdentityToken().hashCode();
        }
        int hashCode2 = (((((((((hashCode + i) * 31) + (getAssumedRoleUser() == null ? 0 : getAssumedRoleUser().hashCode())) * 31) + (getPackedPolicySize() == null ? 0 : getPackedPolicySize().hashCode())) * 31) + (getProvider() == null ? 0 : getProvider().hashCode())) * 31) + (getAudience() == null ? 0 : getAudience().hashCode())) * 31;
        if (getSourceIdentity() != null) {
            i2 = getSourceIdentity().hashCode();
        }
        return hashCode2 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleWithWebIdentityResult)) {
            return false;
        }
        AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentityResult = (AssumeRoleWithWebIdentityResult) obj;
        if ((assumeRoleWithWebIdentityResult.getCredentials() == null) ^ (getCredentials() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getCredentials() != null && !assumeRoleWithWebIdentityResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getSubjectFromWebIdentityToken() == null) ^ (getSubjectFromWebIdentityToken() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getSubjectFromWebIdentityToken() != null && !assumeRoleWithWebIdentityResult.getSubjectFromWebIdentityToken().equals(getSubjectFromWebIdentityToken())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getAssumedRoleUser() == null) ^ (getAssumedRoleUser() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getAssumedRoleUser() != null && !assumeRoleWithWebIdentityResult.getAssumedRoleUser().equals(getAssumedRoleUser())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getPackedPolicySize() == null) ^ (getPackedPolicySize() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getPackedPolicySize() != null && !assumeRoleWithWebIdentityResult.getPackedPolicySize().equals(getPackedPolicySize())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getProvider() == null) ^ (getProvider() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getProvider() != null && !assumeRoleWithWebIdentityResult.getProvider().equals(getProvider())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getAudience() == null) ^ (getAudience() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getAudience() != null && !assumeRoleWithWebIdentityResult.getAudience().equals(getAudience())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getSourceIdentity() == null) ^ (getSourceIdentity() == null)) {
            return false;
        }
        return assumeRoleWithWebIdentityResult.getSourceIdentity() == null || assumeRoleWithWebIdentityResult.getSourceIdentity().equals(getSourceIdentity());
    }
}
