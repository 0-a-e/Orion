package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GetCredentialsForIdentityRequest extends AmazonWebServiceRequest implements Serializable {
    private String customRoleArn;
    private String identityId;
    private Map<String, String> logins;

    public String getIdentityId() {
        return this.identityId;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public GetCredentialsForIdentityRequest withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public Map<String, String> getLogins() {
        return this.logins;
    }

    public void setLogins(Map<String, String> map) {
        this.logins = map;
    }

    public GetCredentialsForIdentityRequest withLogins(Map<String, String> map) {
        this.logins = map;
        return this;
    }

    public GetCredentialsForIdentityRequest addLoginsEntry(String str, String str2) {
        if (this.logins == null) {
            this.logins = new HashMap();
        }
        if (!this.logins.containsKey(str)) {
            this.logins.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetCredentialsForIdentityRequest clearLoginsEntries() {
        this.logins = null;
        return this;
    }

    public String getCustomRoleArn() {
        return this.customRoleArn;
    }

    public void setCustomRoleArn(String str) {
        this.customRoleArn = str;
    }

    public GetCredentialsForIdentityRequest withCustomRoleArn(String str) {
        this.customRoleArn = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getLogins() != null) {
            sb.append("Logins: " + getLogins() + ",");
        }
        if (getCustomRoleArn() != null) {
            sb.append("CustomRoleArn: " + getCustomRoleArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getIdentityId() == null ? 0 : getIdentityId().hashCode()) + 31) * 31) + (getLogins() == null ? 0 : getLogins().hashCode())) * 31;
        if (getCustomRoleArn() != null) {
            i = getCustomRoleArn().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetCredentialsForIdentityRequest)) {
            return false;
        }
        GetCredentialsForIdentityRequest getCredentialsForIdentityRequest = (GetCredentialsForIdentityRequest) obj;
        if ((getCredentialsForIdentityRequest.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        if (getCredentialsForIdentityRequest.getIdentityId() != null && !getCredentialsForIdentityRequest.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if ((getCredentialsForIdentityRequest.getLogins() == null) ^ (getLogins() == null)) {
            return false;
        }
        if (getCredentialsForIdentityRequest.getLogins() != null && !getCredentialsForIdentityRequest.getLogins().equals(getLogins())) {
            return false;
        }
        if ((getCredentialsForIdentityRequest.getCustomRoleArn() == null) ^ (getCustomRoleArn() == null)) {
            return false;
        }
        return getCredentialsForIdentityRequest.getCustomRoleArn() == null || getCredentialsForIdentityRequest.getCustomRoleArn().equals(getCustomRoleArn());
    }
}
