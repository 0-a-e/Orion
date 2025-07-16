package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeGlobalTableSettingsRequest extends AmazonWebServiceRequest implements Serializable {
    private String globalTableName;

    public String getGlobalTableName() {
        return this.globalTableName;
    }

    public void setGlobalTableName(String str) {
        this.globalTableName = str;
    }

    public DescribeGlobalTableSettingsRequest withGlobalTableName(String str) {
        this.globalTableName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getGlobalTableName() != null) {
            sb.append("GlobalTableName: " + getGlobalTableName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getGlobalTableName() == null ? 0 : getGlobalTableName().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeGlobalTableSettingsRequest)) {
            return false;
        }
        DescribeGlobalTableSettingsRequest describeGlobalTableSettingsRequest = (DescribeGlobalTableSettingsRequest) obj;
        if ((describeGlobalTableSettingsRequest.getGlobalTableName() == null) ^ (getGlobalTableName() == null)) {
            return false;
        }
        return describeGlobalTableSettingsRequest.getGlobalTableName() == null || describeGlobalTableSettingsRequest.getGlobalTableName().equals(getGlobalTableName());
    }
}
