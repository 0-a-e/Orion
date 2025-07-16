package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListKeyRotationsRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer limit;
    private String marker;

    public String getKeyId() {
        return this.keyId;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public ListKeyRotationsRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public ListKeyRotationsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public ListKeyRotationsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getLimit() == null ? 0 : getLimit().hashCode())) * 31;
        if (getMarker() != null) {
            i = getMarker().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeyRotationsRequest)) {
            return false;
        }
        ListKeyRotationsRequest listKeyRotationsRequest = (ListKeyRotationsRequest) obj;
        if ((listKeyRotationsRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (listKeyRotationsRequest.getKeyId() != null && !listKeyRotationsRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((listKeyRotationsRequest.getLimit() == null) ^ (getLimit() == null)) {
            return false;
        }
        if (listKeyRotationsRequest.getLimit() != null && !listKeyRotationsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if ((listKeyRotationsRequest.getMarker() == null) ^ (getMarker() == null)) {
            return false;
        }
        return listKeyRotationsRequest.getMarker() == null || listKeyRotationsRequest.getMarker().equals(getMarker());
    }
}
