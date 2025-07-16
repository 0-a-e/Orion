package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeTimeToLiveRequest extends AmazonWebServiceRequest implements Serializable {
    private String tableName;

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public DescribeTimeToLiveRequest withTableName(String str) {
        this.tableName = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (getTableName() != null) {
            sb.append("TableName: " + getTableName());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        return 31 + (getTableName() == null ? 0 : getTableName().hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTimeToLiveRequest)) {
            return false;
        }
        DescribeTimeToLiveRequest describeTimeToLiveRequest = (DescribeTimeToLiveRequest) obj;
        if ((describeTimeToLiveRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        return describeTimeToLiveRequest.getTableName() == null || describeTimeToLiveRequest.getTableName().equals(getTableName());
    }
}
