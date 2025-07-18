package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

public class GetCredentialsForIdentityResult implements Serializable {
    private Credentials credentials;
    private String identityId;

    public String getIdentityId() {
        return this.identityId;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public GetCredentialsForIdentityResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(Credentials credentials2) {
        this.credentials = credentials2;
    }

    public GetCredentialsForIdentityResult withCredentials(Credentials credentials2) {
        this.credentials = credentials2;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getCredentials() != null) {
            sb.append("Credentials: " + getCredentials());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIdentityId() == null ? 0 : getIdentityId().hashCode()) + 31) * 31;
        if (getCredentials() != null) {
            i = getCredentials().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetCredentialsForIdentityResult)) {
            return false;
        }
        GetCredentialsForIdentityResult getCredentialsForIdentityResult = (GetCredentialsForIdentityResult) obj;
        if ((getCredentialsForIdentityResult.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        if (getCredentialsForIdentityResult.getIdentityId() != null && !getCredentialsForIdentityResult.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if ((getCredentialsForIdentityResult.getCredentials() == null) ^ (getCredentials() == null)) {
            return false;
        }
        return getCredentialsForIdentityResult.getCredentials() == null || getCredentialsForIdentityResult.getCredentials().equals(getCredentials());
    }
}
