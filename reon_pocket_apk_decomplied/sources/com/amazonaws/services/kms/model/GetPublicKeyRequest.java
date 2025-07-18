package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetPublicKeyRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> grantTokens = new ArrayList();
    private String keyId;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public GetPublicKeyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public GetPublicKeyRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public GetPublicKeyRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31;
        if (getGrantTokens() != null) {
            i = getGrantTokens().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPublicKeyRequest)) {
            return false;
        }
        GetPublicKeyRequest getPublicKeyRequest = (GetPublicKeyRequest) obj;
        if ((getPublicKeyRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (getPublicKeyRequest.getKeyId() != null && !getPublicKeyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((getPublicKeyRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        return getPublicKeyRequest.getGrantTokens() == null || getPublicKeyRequest.getGrantTokens().equals(getGrantTokens());
    }
}
