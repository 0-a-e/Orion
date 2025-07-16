package com.amazonaws.services.dynamodbv2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DescribeTableRequest extends AmazonWebServiceRequest implements Serializable {
    private String tableName;

    public DescribeTableRequest() {
    }

    public DescribeTableRequest(String str) {
        setTableName(str);
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String str) {
        this.tableName = str;
    }

    public DescribeTableRequest withTableName(String str) {
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
        if (obj == null || !(obj instanceof DescribeTableRequest)) {
            return false;
        }
        DescribeTableRequest describeTableRequest = (DescribeTableRequest) obj;
        if ((describeTableRequest.getTableName() == null) ^ (getTableName() == null)) {
            return false;
        }
        return describeTableRequest.getTableName() == null || describeTableRequest.getTableName().equals(getTableName());
    }
}
