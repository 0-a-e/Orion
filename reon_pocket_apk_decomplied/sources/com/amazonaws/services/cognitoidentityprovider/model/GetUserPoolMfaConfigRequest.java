package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetUserPoolMfaConfigRequest extends AmazonWebServiceRequest implements Serializable {
    private String userPoolId;

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public GetUserPoolMfaConfigRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getUserPoolId() == null ? 0 : getUserPoolId().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetUserPoolMfaConfigRequest)) {
            return false;
        }
        GetUserPoolMfaConfigRequest getUserPoolMfaConfigRequest = (GetUserPoolMfaConfigRequest) obj;
        if ((getUserPoolMfaConfigRequest.getUserPoolId() == null) ^ (getUserPoolId() == null)) {
            return false;
        }
        return getUserPoolMfaConfigRequest.getUserPoolId() == null || getUserPoolMfaConfigRequest.getUserPoolId().equals(getUserPoolId());
    }
}
