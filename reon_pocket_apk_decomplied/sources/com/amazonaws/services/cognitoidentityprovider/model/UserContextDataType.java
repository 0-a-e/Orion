package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

public class UserContextDataType implements Serializable {
    private String encodedData;
    private String ipAddress;

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public UserContextDataType withIpAddress(String str) {
        this.ipAddress = str;
        return this;
    }

    public String getEncodedData() {
        return this.encodedData;
    }

    public void setEncodedData(String str) {
        this.encodedData = str;
    }

    public UserContextDataType withEncodedData(String str) {
        this.encodedData = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getIpAddress() != null) {
            sb.append("IpAddress: " + getIpAddress() + ",");
        }
        if (getEncodedData() != null) {
            sb.append("EncodedData: " + getEncodedData());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getIpAddress() == null ? 0 : getIpAddress().hashCode()) + 31) * 31;
        if (getEncodedData() != null) {
            i = getEncodedData().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserContextDataType)) {
            return false;
        }
        UserContextDataType userContextDataType = (UserContextDataType) obj;
        if ((userContextDataType.getIpAddress() == null) ^ (getIpAddress() == null)) {
            return false;
        }
        if (userContextDataType.getIpAddress() != null && !userContextDataType.getIpAddress().equals(getIpAddress())) {
            return false;
        }
        if ((userContextDataType.getEncodedData() == null) ^ (getEncodedData() == null)) {
            return false;
        }
        return userContextDataType.getEncodedData() == null || userContextDataType.getEncodedData().equals(getEncodedData());
    }
}
